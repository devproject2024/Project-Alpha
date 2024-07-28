package com.alipay.mobile.nebula.util.tar;

import com.alipay.mobile.nebula.util.H5IOUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TarInputStream extends FilterInputStream {
    private static final int SKIP_BUFFER_SIZE = 2048;
    private long bytesRead = 0;
    private TarEntry currentEntry;
    private long currentFileSize = 0;
    private boolean defaultSkip = false;

    public boolean markSupported() {
        return false;
    }

    public TarInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized void mark(int i2) {
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read != -1 ? bArr[0] & 255 : read;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        TarEntry tarEntry = this.currentEntry;
        if (tarEntry != null) {
            if (this.currentFileSize == tarEntry.getSize()) {
                return -1;
            }
            if (this.currentEntry.getSize() - this.currentFileSize < ((long) i3)) {
                i3 = (int) (this.currentEntry.getSize() - this.currentFileSize);
            }
        }
        int read = super.read(bArr, i2, i3);
        if (read != -1) {
            if (this.currentEntry != null) {
                this.currentFileSize += (long) read;
            }
            this.bytesRead += (long) read;
        }
        return read;
    }

    public TarEntry getNextEntry() throws IOException {
        closeCurrentEntry();
        byte[] buf = H5IOUtils.getBuf(512);
        byte[] buf2 = H5IOUtils.getBuf(512);
        boolean z = false;
        int i2 = 0;
        while (i2 < 512) {
            int read = read(buf2, 0, 512 - i2);
            if (read < 0) {
                break;
            }
            System.arraycopy(buf2, 0, buf, i2, read);
            i2 += read;
        }
        int length = buf.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = true;
                break;
            } else if (buf[i3] != 0) {
                break;
            } else {
                i3++;
            }
        }
        if (!z) {
            this.currentEntry = new TarEntry(buf);
        }
        H5IOUtils.returnBuf(buf);
        H5IOUtils.returnBuf(buf2);
        return this.currentEntry;
    }

    public long getCurrentOffset() {
        return this.bytesRead;
    }

    /* access modifiers changed from: protected */
    public void closeCurrentEntry() throws IOException {
        TarEntry tarEntry = this.currentEntry;
        if (tarEntry != null) {
            if (tarEntry.getSize() > this.currentFileSize) {
                long j = 0;
                while (j < this.currentEntry.getSize() - this.currentFileSize) {
                    long skip = skip((this.currentEntry.getSize() - this.currentFileSize) - j);
                    if (skip != 0 || this.currentEntry.getSize() - this.currentFileSize <= 0) {
                        j += skip;
                    } else {
                        throw new IOException("Possible tar file corruption");
                    }
                }
            }
            this.currentEntry = null;
            this.currentFileSize = 0;
            skipPad();
        }
    }

    /* access modifiers changed from: protected */
    public void skipPad() throws IOException {
        int i2;
        long j = this.bytesRead;
        long j2 = 0;
        if (j > 0 && (i2 = (int) (j % 512)) > 0) {
            while (true) {
                long j3 = (long) (512 - i2);
                if (j2 < j3) {
                    j2 += skip(j3 - j2);
                } else {
                    return;
                }
            }
        }
    }

    public long skip(long j) throws IOException {
        if (this.defaultSkip) {
            long skip = super.skip(j);
            this.bytesRead += skip;
            return skip;
        } else if (j <= 0) {
            return 0;
        } else {
            byte[] buf = H5IOUtils.getBuf(2048);
            long j2 = j;
            while (j2 > 0) {
                long j3 = 2048;
                if (j2 < 2048) {
                    j3 = j2;
                }
                int read = read(buf, 0, (int) j3);
                if (read < 0) {
                    break;
                }
                j2 -= (long) read;
            }
            H5IOUtils.returnBuf(buf);
            return j - j2;
        }
    }

    public boolean isDefaultSkip() {
        return this.defaultSkip;
    }

    public void setDefaultSkip(boolean z) {
        this.defaultSkip = z;
    }
}
