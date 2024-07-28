package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink sink2) {
        if (sink2 != null) {
            this.deflater = new Deflater(-1, true);
            this.sink = Okio.buffer(sink2);
            this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
            writeHeader();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final void write(Buffer buffer, long j) throws IOException {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (i2 != 0) {
            updateCrc(buffer, j);
            this.deflaterSink.write(buffer, j);
        }
    }

    public final void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final void close() throws IOException {
        if (!this.closed) {
            Throwable th = null;
            try {
                this.deflaterSink.finishDeflate();
                writeFooter();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.deflater.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.closed = true;
            if (th != null) {
                g.a(th);
            }
        }
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private void writeFooter() throws IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void updateCrc(Buffer buffer, long j) {
        d dVar = buffer.head;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (dVar.f45275c - dVar.f45274b));
            this.crc.update(dVar.f45273a, dVar.f45274b, min);
            j -= (long) min;
            dVar = dVar.f45278f;
        }
    }
}
