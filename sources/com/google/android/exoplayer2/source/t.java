package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.s;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class t implements q {

    /* renamed from: a  reason: collision with root package name */
    public final s f33388a = new s();

    /* renamed from: b  reason: collision with root package name */
    public boolean f33389b;

    /* renamed from: c  reason: collision with root package name */
    public b f33390c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.f.b f33391d;

    /* renamed from: e  reason: collision with root package name */
    private final int f33392e;

    /* renamed from: f  reason: collision with root package name */
    private final s.a f33393f = new s.a();

    /* renamed from: g  reason: collision with root package name */
    private final r f33394g = new r(32);

    /* renamed from: h  reason: collision with root package name */
    private a f33395h = new a(0, this.f33392e);

    /* renamed from: i  reason: collision with root package name */
    private a f33396i;
    private a j;
    private Format k;
    private boolean l;
    private Format m;
    private long n;
    private long o;

    public interface b {
        void i();
    }

    public t(com.google.android.exoplayer2.f.b bVar) {
        this.f33391d = bVar;
        this.f33392e = bVar.c();
        a aVar = this.f33395h;
        this.f33396i = aVar;
        this.j = aVar;
    }

    public final void a(boolean z) {
        this.f33388a.a(z);
        a(this.f33395h);
        this.f33395h = new a(0, this.f33392e);
        a aVar = this.f33395h;
        this.f33396i = aVar;
        this.j = aVar;
        this.o = 0;
        this.f33391d.b();
    }

    public final void a(int i2) {
        this.f33388a.f33295d = i2;
    }

    public final void b(int i2) {
        this.o = this.f33388a.a(i2);
        long j2 = this.o;
        if (j2 == 0 || j2 == this.f33395h.f33397a) {
            a(this.f33395h);
            this.f33395h = new a(this.o, this.f33392e);
            a aVar = this.f33395h;
            this.f33396i = aVar;
            this.j = aVar;
            return;
        }
        a aVar2 = this.f33395h;
        while (this.o > aVar2.f33398b) {
            aVar2 = aVar2.f33401e;
        }
        a aVar3 = aVar2.f33401e;
        a(aVar3);
        aVar2.f33401e = new a(aVar2.f33398b, this.f33392e);
        this.j = this.o == aVar2.f33398b ? aVar2.f33401e : aVar2;
        if (this.f33396i == aVar3) {
            this.f33396i = aVar2.f33401e;
        }
    }

    public final int a() {
        s sVar = this.f33388a;
        return sVar.c() ? sVar.f33292a[sVar.c(sVar.f33294c)] : sVar.f33295d;
    }

    public final void b() {
        this.f33388a.h();
        this.f33396i = this.f33395h;
    }

    public final void a(long j2, boolean z, boolean z2) {
        a(this.f33388a.a(j2, z, z2));
    }

    public final void c() {
        a(this.f33388a.k());
    }

    public final int a(long j2, boolean z) {
        return this.f33388a.a(j2, z);
    }

    public final int a(o oVar, e eVar, boolean z, boolean z2, long j2) {
        int a2 = this.f33388a.a(oVar, eVar, z, z2, this.k, this.f33393f);
        if (a2 == -5) {
            this.k = oVar.f32757a;
            return -5;
        } else if (a2 == -4) {
            if (!eVar.c()) {
                if (eVar.f31312d < j2) {
                    eVar.a(Integer.MIN_VALUE);
                }
                if (!eVar.e()) {
                    if (eVar.f()) {
                        a(eVar, this.f33393f);
                    }
                    eVar.c(this.f33393f.f33301a);
                    a(this.f33393f.f33302b, eVar.f31311c, this.f33393f.f33301a);
                }
            }
            return -4;
        } else if (a2 == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private void a(e eVar, s.a aVar) {
        int i2;
        e eVar2 = eVar;
        s.a aVar2 = aVar;
        long j2 = aVar2.f33302b;
        this.f33394g.a(1);
        a(j2, this.f33394g.f32566a, 1);
        long j3 = j2 + 1;
        byte b2 = this.f33394g.f32566a[0];
        boolean z = (b2 & 128) != 0;
        byte b3 = b2 & Byte.MAX_VALUE;
        if (eVar2.f31310b.f31290a == null) {
            eVar2.f31310b.f31290a = new byte[16];
        }
        a(j3, eVar2.f31310b.f31290a, (int) b3);
        long j4 = j3 + ((long) b3);
        if (z) {
            this.f33394g.a(2);
            a(j4, this.f33394g.f32566a, 2);
            j4 += 2;
            i2 = this.f33394g.d();
        } else {
            i2 = 1;
        }
        int[] iArr = eVar2.f31310b.f31293d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar2.f31310b.f31294e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.f33394g.a(i3);
            a(j4, this.f33394g.f32566a, i3);
            j4 += (long) i3;
            this.f33394g.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.f33394g.d();
                iArr4[i4] = this.f33394g.n();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar2.f33301a - ((int) (j4 - aVar2.f33302b));
        }
        q.a aVar3 = aVar2.f33303c;
        eVar2.f31310b.a(i2, iArr2, iArr4, aVar3.f32297b, eVar2.f31310b.f31290a, aVar3.f32296a, aVar3.f32298c, aVar3.f32299d);
        int i5 = (int) (j4 - aVar2.f33302b);
        aVar2.f33302b += (long) i5;
        aVar2.f33301a -= i5;
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        c(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.f33396i.f33398b - j2));
            byteBuffer.put(this.f33396i.f33400d.f32309a, this.f33396i.a(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.f33396i.f33398b) {
                this.f33396i = this.f33396i.f33401e;
            }
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        c(j2);
        long j3 = j2;
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f33396i.f33398b - j3));
            System.arraycopy(this.f33396i.f33400d.f32309a, this.f33396i.a(j3), bArr, i2 - i3, min);
            i3 -= min;
            j3 += (long) min;
            if (j3 == this.f33396i.f33398b) {
                this.f33396i = this.f33396i.f33401e;
            }
        }
    }

    private void c(long j2) {
        while (j2 >= this.f33396i.f33398b) {
            this.f33396i = this.f33396i.f33401e;
        }
    }

    public final void a(long j2) {
        if (j2 != -1) {
            while (j2 >= this.f33395h.f33398b) {
                this.f33391d.a(this.f33395h.f33400d);
                this.f33395h = this.f33395h.a();
            }
            if (this.f33396i.f33397a < this.f33395h.f33397a) {
                this.f33396i = this.f33395h;
            }
        }
    }

    public final void b(long j2) {
        if (this.n != j2) {
            this.n = j2;
            this.l = true;
        }
    }

    public void a(Format format) {
        Format format2;
        long j2 = this.n;
        if (format == null) {
            format2 = null;
        } else {
            format2 = (j2 == 0 || format.m == Long.MAX_VALUE) ? format : format.a(format.m + j2);
        }
        boolean a2 = this.f33388a.a(format2);
        this.m = format;
        this.l = false;
        b bVar = this.f33390c;
        if (bVar != null && a2) {
            bVar.i();
        }
    }

    public final int a(h hVar, int i2, boolean z) throws IOException, InterruptedException {
        int a2 = hVar.a(this.j.f33400d.f32309a, this.j.a(this.o), c(i2));
        if (a2 != -1) {
            d(a2);
            return a2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void a(r rVar, int i2) {
        while (i2 > 0) {
            int c2 = c(i2);
            rVar.a(this.j.f33400d.f32309a, this.j.a(this.o), c2);
            i2 -= c2;
            d(c2);
        }
    }

    public final void a(long j2, int i2, int i3, int i4, q.a aVar) {
        if (this.l) {
            a(this.m);
        }
        long j3 = j2 + this.n;
        if (this.f33389b) {
            if ((i2 & 1) != 0 && this.f33388a.a(j3)) {
                this.f33389b = false;
            } else {
                return;
            }
        }
        int i5 = i3;
        this.f33388a.a(j3, i2, (this.o - ((long) i5)) - ((long) i4), i5, aVar);
    }

    private void a(a aVar) {
        if (aVar.f33399c) {
            com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[((this.j.f33399c ? 1 : 0) + (((int) (this.j.f33397a - aVar.f33397a)) / this.f33392e))];
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                aVarArr[i2] = aVar.f33400d;
                aVar = aVar.a();
            }
            this.f33391d.a(aVarArr);
        }
    }

    private int c(int i2) {
        if (!this.j.f33399c) {
            this.j.a(this.f33391d.a(), new a(this.j.f33398b, this.f33392e));
        }
        return Math.min(i2, (int) (this.j.f33398b - this.o));
    }

    private void d(int i2) {
        this.o += (long) i2;
        if (this.o == this.j.f33398b) {
            this.j = this.j.f33401e;
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f33397a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33398b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33399c;

        /* renamed from: d  reason: collision with root package name */
        public com.google.android.exoplayer2.f.a f33400d;

        /* renamed from: e  reason: collision with root package name */
        public a f33401e;

        public a(long j, int i2) {
            this.f33397a = j;
            this.f33398b = j + ((long) i2);
        }

        public final void a(com.google.android.exoplayer2.f.a aVar, a aVar2) {
            this.f33400d = aVar;
            this.f33401e = aVar2;
            this.f33399c = true;
        }

        public final int a(long j) {
            return ((int) (j - this.f33397a)) + this.f33400d.f32310b;
        }

        public final a a() {
            this.f33400d = null;
            a aVar = this.f33401e;
            this.f33401e = null;
            return aVar;
        }
    }
}
