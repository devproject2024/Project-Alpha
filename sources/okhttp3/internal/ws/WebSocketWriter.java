package okhttp3.internal.ws;

import i.c;
import i.d;
import i.f;
import i.u;
import i.w;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter {
    boolean activeWriter;
    final c buffer = new c();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final c.a maskCursor;
    private final byte[] maskKey;
    final Random random;
    final d sink;
    final c sinkBuffer;
    boolean writerClosed;

    WebSocketWriter(boolean z, d dVar, Random random2) {
        if (dVar == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z;
            this.sink = dVar;
            this.sinkBuffer = dVar.a();
            this.random = random2;
            c.a aVar = null;
            this.maskKey = z ? new byte[4] : null;
            this.maskCursor = z ? new c.a() : aVar;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void writePing(f fVar) throws IOException {
        writeControlFrame(9, fVar);
    }

    /* access modifiers changed from: package-private */
    public final void writePong(f fVar) throws IOException {
        writeControlFrame(10, fVar);
    }

    /* access modifiers changed from: package-private */
    public final void writeClose(int i2, f fVar) throws IOException {
        f fVar2 = f.EMPTY;
        if (!(i2 == 0 && fVar == null)) {
            if (i2 != 0) {
                WebSocketProtocol.validateCloseCode(i2);
            }
            c cVar = new c();
            cVar.i(i2);
            if (fVar != null) {
                cVar.d(fVar);
            }
            fVar2 = cVar.p();
        }
        try {
            writeControlFrame(8, fVar2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i2, f fVar) throws IOException {
        if (!this.writerClosed) {
            int size = fVar.size();
            if (((long) size) <= 125) {
                this.sinkBuffer.j(i2 | 128);
                if (this.isClient) {
                    this.sinkBuffer.j(size | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.c(this.maskKey);
                    if (size > 0) {
                        long j = this.sinkBuffer.f46277b;
                        this.sinkBuffer.d(fVar);
                        this.sinkBuffer.a(this.maskCursor);
                        this.maskCursor.a(j);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.j(size);
                    this.sinkBuffer.d(fVar);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public final u newMessageSink(int i2, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i2;
            frameSink2.contentLength = j;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public final void writeMessageFrame(int i2, long j, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.sinkBuffer.j(i2);
            if (this.isClient) {
                i3 = 128;
            }
            if (j <= 125) {
                this.sinkBuffer.j(((int) j) | i3);
            } else if (j <= 65535) {
                this.sinkBuffer.j(i3 | 126);
                this.sinkBuffer.i((int) j);
            } else {
                this.sinkBuffer.j(i3 | 127);
                this.sinkBuffer.j(j);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.c(this.maskKey);
                if (j > 0) {
                    long j2 = this.sinkBuffer.f46277b;
                    this.sinkBuffer.write(this.buffer, j);
                    this.sinkBuffer.a(this.maskCursor);
                    this.maskCursor.a(j2);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.c();
            return;
        }
        throw new IOException("closed");
    }

    final class FrameSink implements u {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public final void write(c cVar, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(cVar, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.f46277b > this.contentLength - 8192;
                long f2 = WebSocketWriter.this.buffer.f();
                if (f2 > 0 && !z) {
                    WebSocketWriter.this.writeMessageFrame(this.formatOpcode, f2, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f46277b, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public final w timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public final void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f46277b, this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
