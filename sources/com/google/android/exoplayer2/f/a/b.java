package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a.a;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.v;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final a f32311a;

    /* renamed from: b  reason: collision with root package name */
    private final long f32312b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32313c;

    /* renamed from: d  reason: collision with root package name */
    private l f32314d;

    /* renamed from: e  reason: collision with root package name */
    private long f32315e;

    /* renamed from: f  reason: collision with root package name */
    private File f32316f;

    /* renamed from: g  reason: collision with root package name */
    private OutputStream f32317g;

    /* renamed from: h  reason: collision with root package name */
    private FileOutputStream f32318h;

    /* renamed from: i  reason: collision with root package name */
    private long f32319i;
    private long j;
    private v k;

    public static class a extends a.C0544a {
        public a(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public b(a aVar, long j2, int i2) {
        com.google.android.exoplayer2.g.a.b(j2 > 0 || j2 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i3 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if (i3 != 0 && j2 < 2097152) {
            com.google.android.exoplayer2.g.l.c();
        }
        this.f32311a = (a) com.google.android.exoplayer2.g.a.a(aVar);
        this.f32312b = i3 == 0 ? Long.MAX_VALUE : j2;
        this.f32313c = i2;
    }

    public final void a(l lVar) throws a {
        if (lVar.f32401g != -1 || !lVar.a(4)) {
            this.f32314d = lVar;
            this.f32315e = lVar.a(8) ? this.f32312b : Long.MAX_VALUE;
            this.j = 0;
            try {
                b();
            } catch (IOException e2) {
                throw new a(e2);
            }
        } else {
            this.f32314d = null;
        }
    }

    public final void a(byte[] bArr, int i2, int i3) throws a {
        if (this.f32314d != null) {
            int i4 = 0;
            while (i4 < i3) {
                try {
                    if (this.f32319i == this.f32315e) {
                        c();
                        b();
                    }
                    int min = (int) Math.min((long) (i3 - i4), this.f32315e - this.f32319i);
                    this.f32317g.write(bArr, i2 + i4, min);
                    i4 += min;
                    long j2 = (long) min;
                    this.f32319i += j2;
                    this.j += j2;
                } catch (IOException e2) {
                    throw new a(e2);
                }
            }
        }
    }

    public final void a() throws a {
        if (this.f32314d != null) {
            try {
                c();
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
    }

    private void b() throws IOException {
        if (this.f32314d.f32401g != -1) {
            Math.min(this.f32314d.f32401g - this.j, this.f32315e);
        }
        this.f32316f = this.f32311a.c();
        this.f32318h = new FileOutputStream(this.f32316f);
        int i2 = this.f32313c;
        if (i2 > 0) {
            v vVar = this.k;
            if (vVar == null) {
                this.k = new v(this.f32318h, i2);
            } else {
                vVar.a(this.f32318h);
            }
            this.f32317g = this.k;
        } else {
            this.f32317g = this.f32318h;
        }
        this.f32319i = 0;
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f32317g;
        if (outputStream != null) {
            try {
                outputStream.flush();
                ae.a((Closeable) this.f32317g);
                this.f32317g = null;
                this.f32316f = null;
            } catch (Throwable th) {
                ae.a((Closeable) this.f32317g);
                this.f32317g = null;
                File file = this.f32316f;
                this.f32316f = null;
                file.delete();
                throw th;
            }
        }
    }
}
