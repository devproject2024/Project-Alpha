package org.apache.xml.security.utils;

import java.io.OutputStream;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class UnsyncBufferedOutputStream extends OutputStream {

    /* renamed from: d  reason: collision with root package name */
    private static ThreadLocal f72786d = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public synchronized Object initialValue() {
            return new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final OutputStream f72787a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f72788b = ((byte[]) f72786d.get());

    /* renamed from: c  reason: collision with root package name */
    int f72789c = 0;

    public UnsyncBufferedOutputStream(OutputStream outputStream) {
        this.f72787a = outputStream;
    }

    private final void a() {
        int i2 = this.f72789c;
        if (i2 > 0) {
            this.f72787a.write(this.f72788b, 0, i2);
        }
        this.f72789c = 0;
    }

    public void close() {
        flush();
    }

    public void flush() {
        a();
        this.f72787a.flush();
    }

    public void write(int i2) {
        if (this.f72789c >= 8192) {
            a();
        }
        byte[] bArr = this.f72788b;
        int i3 = this.f72789c;
        this.f72789c = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) {
        int i4 = this.f72789c + i3;
        if (i4 > 8192) {
            a();
            if (i3 > 8192) {
                this.f72787a.write(bArr, i2, i3);
                return;
            }
            i4 = i3;
        }
        System.arraycopy(bArr, i2, this.f72788b, this.f72789c, i3);
        this.f72789c = i4;
    }
}
