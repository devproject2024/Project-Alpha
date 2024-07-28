package com.google.android.exoplayer2.extractor.g;

import android.util.Pair;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public final class f implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f31962c = {73, 68, TarHeader.LF_CHR};

    /* renamed from: a  reason: collision with root package name */
    long f31963a;

    /* renamed from: b  reason: collision with root package name */
    long f31964b;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f31965d;

    /* renamed from: e  reason: collision with root package name */
    private final q f31966e;

    /* renamed from: f  reason: collision with root package name */
    private final r f31967f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31968g;

    /* renamed from: h  reason: collision with root package name */
    private String f31969h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.exoplayer2.extractor.q f31970i;
    private com.google.android.exoplayer2.extractor.q j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private int t;
    private com.google.android.exoplayer2.extractor.q u;
    private long v;

    public static boolean a(int i2) {
        return (i2 & 65526) == 65520;
    }

    public final void b() {
    }

    public f() {
        this(true, (String) null);
    }

    public f(boolean z, String str) {
        this.f31966e = new q(new byte[7]);
        this.f31967f = new r(Arrays.copyOf(f31962c, 10));
        d();
        this.p = -1;
        this.q = -1;
        this.f31963a = -9223372036854775807L;
        this.f31965d = z;
        this.f31968g = str;
    }

    public final void a() {
        c();
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f31969h = dVar.c();
        this.f31970i = iVar.a(dVar.b(), 1);
        if (this.f31965d) {
            dVar.a();
            this.j = iVar.a(dVar.b(), 4);
            this.j.a(Format.a(dVar.c(), "application/id3"));
            return;
        }
        this.j = new com.google.android.exoplayer2.extractor.f();
    }

    public final void a(long j2, int i2) {
        this.f31964b = j2;
    }

    public final void a(r rVar) throws v {
        while (rVar.b() > 0) {
            int i2 = this.k;
            if (i2 == 0) {
                b(rVar);
            } else if (i2 == 1) {
                c(rVar);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (a(rVar, this.f31966e.f32562a, this.n ? 7 : 5)) {
                        i();
                    }
                } else if (i2 == 4) {
                    d(rVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (a(rVar, this.f31967f.f32566a, 10)) {
                h();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.o = false;
        d();
    }

    private boolean a(r rVar, byte[] bArr, int i2) {
        int min = Math.min(rVar.b(), i2 - this.l);
        rVar.a(bArr, this.l, min);
        this.l += min;
        return this.l == i2;
    }

    private void d() {
        this.k = 0;
        this.l = 0;
        this.m = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
    }

    private void e() {
        this.k = 2;
        this.l = f31962c.length;
        this.t = 0;
        this.f31967f.c(0);
    }

    private void a(com.google.android.exoplayer2.extractor.q qVar, long j2, int i2, int i3) {
        this.k = 4;
        this.l = i2;
        this.u = qVar;
        this.v = j2;
        this.t = i3;
    }

    private void f() {
        this.k = 3;
        this.l = 0;
    }

    private void g() {
        this.k = 1;
        this.l = 0;
    }

    private void b(r rVar) {
        byte[] bArr = rVar.f32566a;
        int i2 = rVar.f32567b;
        int i3 = rVar.f32568c;
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (this.m != 512 || !a((byte) -1, (byte) b2) || (!this.o && !a(rVar, i4 - 2))) {
                int i5 = this.m;
                byte b3 = b2 | i5;
                if (b3 == 329) {
                    this.m = 768;
                } else if (b3 == 511) {
                    this.m = 512;
                } else if (b3 == 836) {
                    this.m = TarConstants.EOF_BLOCK;
                } else if (b3 == 1075) {
                    e();
                    rVar.c(i4);
                    return;
                } else if (i5 != 256) {
                    this.m = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
                    i4--;
                }
                i2 = i4;
            } else {
                this.r = (b2 & 8) >> 3;
                boolean z = true;
                if ((b2 & 1) != 0) {
                    z = false;
                }
                this.n = z;
                if (!this.o) {
                    g();
                } else {
                    f();
                }
                rVar.c(i4);
                return;
            }
        }
        rVar.c(i2);
    }

    private void c(r rVar) {
        if (rVar.b() != 0) {
            this.f31966e.f32562a[0] = rVar.f32566a[rVar.f32567b];
            this.f31966e.a(2);
            int c2 = this.f31966e.c(4);
            int i2 = this.q;
            if (i2 == -1 || c2 == i2) {
                if (!this.o) {
                    this.o = true;
                    this.p = this.r;
                    this.q = c2;
                }
                f();
                return;
            }
            c();
        }
    }

    private boolean a(r rVar, int i2) {
        rVar.c(i2 + 1);
        if (!b(rVar, this.f31966e.f32562a, 1)) {
            return false;
        }
        this.f31966e.a(4);
        int c2 = this.f31966e.c(1);
        int i3 = this.p;
        if (i3 != -1 && c2 != i3) {
            return false;
        }
        if (this.q != -1) {
            if (!b(rVar, this.f31966e.f32562a, 1)) {
                return true;
            }
            this.f31966e.a(2);
            if (this.f31966e.c(4) != this.q) {
                return false;
            }
            rVar.c(i2 + 2);
        }
        if (!b(rVar, this.f31966e.f32562a, 4)) {
            return true;
        }
        this.f31966e.a(14);
        int c3 = this.f31966e.c(13);
        if (c3 <= 6) {
            return false;
        }
        int i4 = i2 + c3;
        int i5 = i4 + 1;
        if (i5 >= rVar.f32568c) {
            return true;
        }
        return a(rVar.f32566a[i4], rVar.f32566a[i5]) && (this.p == -1 || ((rVar.f32566a[i5] & 8) >> 3) == c2);
    }

    private static boolean a(byte b2, byte b3) {
        return a((int) ((b2 & 255) << 8) | (b3 & 255));
    }

    private static boolean b(r rVar, byte[] bArr, int i2) {
        if (rVar.b() < i2) {
            return false;
        }
        rVar.a(bArr, 0, i2);
        return true;
    }

    private void h() {
        this.j.a(this.f31967f, 10);
        this.f31967f.c(6);
        a(this.j, 0, 10, this.f31967f.m() + 10);
    }

    private void i() throws v {
        this.f31966e.a(0);
        if (!this.s) {
            int c2 = this.f31966e.c(2) + 1;
            if (c2 != 2) {
                StringBuilder sb = new StringBuilder("Detected audio object type: ");
                sb.append(c2);
                sb.append(", but assuming AAC LC.");
                l.c();
                c2 = 2;
            }
            this.f31966e.b(5);
            byte[] a2 = c.a(c2, this.q, this.f31966e.c(3));
            Pair<Integer, Integer> a3 = c.a(a2);
            Format a4 = Format.a(this.f31969h, "audio/mp4a-latm", -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), (List<byte[]>) Collections.singletonList(a2), (DrmInitData) null, this.f31968g);
            this.f31963a = 1024000000 / ((long) a4.w);
            this.f31970i.a(a4);
            this.s = true;
        } else {
            this.f31966e.b(10);
        }
        this.f31966e.b(4);
        int c3 = (this.f31966e.c(13) - 2) - 5;
        if (this.n) {
            c3 -= 2;
        }
        a(this.f31970i, this.f31963a, 0, c3);
    }

    private void d(r rVar) {
        int min = Math.min(rVar.b(), this.t - this.l);
        this.u.a(rVar, min);
        this.l += min;
        int i2 = this.l;
        int i3 = this.t;
        if (i2 == i3) {
            this.u.a(this.f31964b, 1, i3, 0, (q.a) null);
            this.f31964b += this.v;
            d();
        }
    }
}
