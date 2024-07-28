package okhttp3.internal.ws;

import i.c;
import i.e;
import i.f;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class WebSocketReader {
    boolean closed;
    private final c controlFrameBuffer = new c();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final c.a maskCursor;
    private final byte[] maskKey;
    private final c messageFrameBuffer = new c();
    int opcode;
    final e source;

    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(f fVar) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(f fVar);

        void onReadPong(f fVar);
    }

    WebSocketReader(boolean z, e eVar, FrameCallback frameCallback2) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = z;
            this.source = eVar;
            this.frameCallback = frameCallback2;
            c.a aVar = null;
            this.maskKey = z ? null : new byte[4];
            this.maskCursor = !z ? new c.a() : aVar;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() throws IOException {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                byte g2 = this.source.g() & 255;
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = g2 & 15;
                boolean z = true;
                this.isFinalFrame = (g2 & 128) != 0;
                this.isControlFrame = (g2 & 8) != 0;
                if (!this.isControlFrame || this.isFinalFrame) {
                    boolean z2 = (g2 & 64) != 0;
                    boolean z3 = (g2 & 32) != 0;
                    boolean z4 = (g2 & 16) != 0;
                    if (z2 || z3 || z4) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte g3 = this.source.g() & 255;
                    if ((g3 & 128) == 0) {
                        z = false;
                    }
                    boolean z5 = this.isClient;
                    if (z == z5) {
                        throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    this.frameLength = (long) (g3 & Byte.MAX_VALUE);
                    long j = this.frameLength;
                    if (j == 126) {
                        this.frameLength = ((long) this.source.h()) & 65535;
                    } else if (j == 127) {
                        this.frameLength = this.source.j();
                        if (this.frameLength < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.source.a(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void readControlFrame() throws IOException {
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.a(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.a(this.maskCursor);
                this.maskCursor.a(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long j2 = this.controlFrameBuffer.f46277b;
                if (j2 != 1) {
                    if (j2 != 0) {
                        s = this.controlFrameBuffer.h();
                        str = this.controlFrameBuffer.q();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.p());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.p());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readMessageFrame() throws IOException {
        int i2 = this.opcode;
        if (i2 == 1 || i2 == 2) {
            readMessage();
            if (i2 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.q());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.p());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.a(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.a(this.maskCursor);
                    this.maskCursor.a(this.messageFrameBuffer.f46277b - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
