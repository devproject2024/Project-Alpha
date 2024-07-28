package org.apache.xml.security.utils;

import java.io.OutputStream;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class UnsyncByteArrayOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadLocal f72790a = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public synchronized Object initialValue() {
            return new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private byte[] f72791b = ((byte[]) f72790a.get());

    /* renamed from: c  reason: collision with root package name */
    private int f72792c = FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;

    /* renamed from: d  reason: collision with root package name */
    private int f72793d = 0;

    private void a(int i2) {
        int i3 = this.f72792c;
        while (i2 > i3) {
            i3 <<= 2;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f72791b, 0, bArr, 0, this.f72793d);
        this.f72791b = bArr;
        this.f72792c = i3;
    }

    public byte[] a() {
        int i2 = this.f72793d;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f72791b, 0, bArr, 0, i2);
        return bArr;
    }

    public void b() {
        this.f72793d = 0;
    }

    public void write(int i2) {
        int i3 = this.f72793d + 1;
        if (i3 > this.f72792c) {
            a(i3);
        }
        byte[] bArr = this.f72791b;
        int i4 = this.f72793d;
        this.f72793d = i4 + 1;
        bArr[i4] = (byte) i2;
    }

    public void write(byte[] bArr) {
        int length = this.f72793d + bArr.length;
        if (length > this.f72792c) {
            a(length);
        }
        System.arraycopy(bArr, 0, this.f72791b, this.f72793d, bArr.length);
        this.f72793d = length;
    }

    public void write(byte[] bArr, int i2, int i3) {
        int i4 = this.f72793d + i3;
        if (i4 > this.f72792c) {
            a(i4);
        }
        System.arraycopy(bArr, i2, this.f72791b, this.f72793d, i3);
        this.f72793d = i4;
    }
}
