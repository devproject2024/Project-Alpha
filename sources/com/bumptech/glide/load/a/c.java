package com.bumptech.glide.load.a;

import com.bumptech.glide.load.b.a.b;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f6691a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f6692b;

    /* renamed from: c  reason: collision with root package name */
    private b f6693c;

    /* renamed from: d  reason: collision with root package name */
    private int f6694d;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, (byte) 0);
    }

    private c(OutputStream outputStream, b bVar, byte b2) {
        this.f6691a = outputStream;
        this.f6693c = bVar;
        this.f6692b = (byte[]) bVar.a(65536, byte[].class);
    }

    public final void write(int i2) throws IOException {
        byte[] bArr = this.f6692b;
        int i3 = this.f6694d;
        this.f6694d = i3 + 1;
        bArr[i3] = (byte) i2;
        b();
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f6694d != 0 || i5 < this.f6692b.length) {
                int min = Math.min(i5, this.f6692b.length - this.f6694d);
                System.arraycopy(bArr, i6, this.f6692b, this.f6694d, min);
                this.f6694d += min;
                i4 += min;
                b();
            } else {
                this.f6691a.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }

    public final void flush() throws IOException {
        a();
        this.f6691a.flush();
    }

    private void a() throws IOException {
        int i2 = this.f6694d;
        if (i2 > 0) {
            this.f6691a.write(this.f6692b, 0, i2);
            this.f6694d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f6694d == this.f6692b.length) {
            a();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void close() throws IOException {
        try {
            flush();
            this.f6691a.close();
            byte[] bArr = this.f6692b;
            if (bArr != null) {
                this.f6693c.a(bArr);
                this.f6692b = null;
            }
        } catch (Throwable th) {
            this.f6691a.close();
            throw th;
        }
    }
}
