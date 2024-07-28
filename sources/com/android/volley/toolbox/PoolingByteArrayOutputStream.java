package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 256);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i2) {
        this.mPool = byteArrayPool;
        this.buf = this.mPool.getBuf(Math.max(i2, 256));
    }

    public void close() throws IOException {
        this.mPool.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.mPool.returnBuf(this.buf);
    }

    private void expand(int i2) {
        if (this.count + i2 > this.buf.length) {
            byte[] buf = this.mPool.getBuf((this.count + i2) * 2);
            System.arraycopy(this.buf, 0, buf, 0, this.count);
            this.mPool.returnBuf(this.buf);
            this.buf = buf;
        }
    }

    public synchronized void write(byte[] bArr, int i2, int i3) {
        expand(i3);
        super.write(bArr, i2, i3);
    }

    public synchronized void write(int i2) {
        expand(1);
        super.write(i2);
    }
}
