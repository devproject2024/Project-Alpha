package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31953a = $$Lambda$e$2DXTg3ASqir33FR1jdLnB50dxvs.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31954b = ae.h("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final int f31955c;

    /* renamed from: d  reason: collision with root package name */
    private final f f31956d;

    /* renamed from: e  reason: collision with root package name */
    private final r f31957e;

    /* renamed from: f  reason: collision with root package name */
    private final r f31958f;

    /* renamed from: g  reason: collision with root package name */
    private final q f31959g;

    /* renamed from: h  reason: collision with root package name */
    private final long f31960h;

    /* renamed from: i  reason: collision with root package name */
    private i f31961i;
    private long j;
    private long k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new e()};
    }

    public e() {
        this((byte) 0);
    }

    private e(byte b2) {
        this(0);
    }

    public e(int i2) {
        this.f31960h = 0;
        this.j = 0;
        this.f31955c = i2;
        this.f31956d = new f();
        this.f31957e = new r((int) EmiUtil.EMI_PLAN_REQUEST_CODE);
        this.l = -1;
        this.k = -1;
        this.f31958f = new r(10);
        this.f31959g = new q(this.f31958f.f32566a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r9.a();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if ((r3 - r0) < 8192) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.exoplayer2.extractor.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            int r0 = r8.b(r9)
            r1 = 0
            r3 = r0
        L_0x0006:
            r2 = 0
            r4 = 0
        L_0x0008:
            com.google.android.exoplayer2.g.r r5 = r8.f31958f
            byte[] r5 = r5.f32566a
            r6 = 2
            r9.c(r5, r1, r6)
            com.google.android.exoplayer2.g.r r5 = r8.f31958f
            r5.c(r1)
            com.google.android.exoplayer2.g.r r5 = r8.f31958f
            int r5 = r5.d()
            boolean r5 = com.google.android.exoplayer2.extractor.g.f.a((int) r5)
            if (r5 != 0) goto L_0x0031
            r9.a()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L_0x002d
            return r1
        L_0x002d:
            r9.c(r3)
            goto L_0x0006
        L_0x0031:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L_0x003b
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L_0x003b
            return r5
        L_0x003b:
            com.google.android.exoplayer2.g.r r5 = r8.f31958f
            byte[] r5 = r5.f32566a
            r9.c(r5, r1, r6)
            com.google.android.exoplayer2.g.q r5 = r8.f31959g
            r6 = 14
            r5.a(r6)
            com.google.android.exoplayer2.g.q r5 = r8.f31959g
            r6 = 13
            int r5 = r5.c(r6)
            r6 = 6
            if (r5 > r6) goto L_0x0055
            return r1
        L_0x0055:
            int r6 = r5 + -6
            r9.c(r6)
            int r4 = r4 + r5
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.e.a(com.google.android.exoplayer2.extractor.h):boolean");
    }

    public final void a(i iVar) {
        this.f31961i = iVar;
        this.f31956d.a(iVar, new ac.d(0, 1));
        iVar.a();
    }

    public final void a(long j2, long j3) {
        this.n = false;
        this.f31956d.c();
        this.j = this.f31960h + j3;
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        h hVar2 = hVar;
        long d2 = hVar.d();
        boolean z = ((this.f31955c & 1) == 0 || d2 == -1) ? false : true;
        if (z && !this.m) {
            this.l = -1;
            hVar.a();
            long j2 = 0;
            if (hVar.c() == 0) {
                b(hVar);
            }
            int i2 = 0;
            while (true) {
                if (!hVar2.b(this.f31958f.f32566a, 0, 2, true)) {
                    break;
                }
                this.f31958f.c(0);
                if (f.a(this.f31958f.d())) {
                    if (!hVar2.b(this.f31958f.f32566a, 0, 4, true)) {
                        break;
                    }
                    this.f31959g.a(14);
                    int c2 = this.f31959g.c(13);
                    if (c2 > 6) {
                        j2 += (long) c2;
                        i2++;
                        if (i2 != 1000) {
                            if (!hVar2.a(c2 - 6, true)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        this.m = true;
                        throw new v("Malformed ADTS stream");
                    }
                } else {
                    i2 = 0;
                    break;
                }
            }
            hVar.a();
            if (i2 > 0) {
                this.l = (int) (j2 / ((long) i2));
            } else {
                this.l = -1;
            }
            this.m = true;
        }
        int a2 = hVar2.a(this.f31957e.f32566a, 0, EmiUtil.EMI_PLAN_REQUEST_CODE);
        boolean z2 = a2 == -1;
        if (!this.o) {
            boolean z3 = z && this.l > 0;
            if (!z3 || this.f31956d.f31963a != -9223372036854775807L || z2) {
                i iVar = (i) a.a(this.f31961i);
                if (!z3 || this.f31956d.f31963a == -9223372036854775807L) {
                    iVar.a(new o.b(-9223372036854775807L));
                } else {
                    iVar.a(new c(d2, this.k, (int) ((((long) (this.l * 8)) * 1000000) / this.f31956d.f31963a), this.l));
                }
                this.o = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.f31957e.c(0);
        this.f31957e.b(a2);
        if (!this.n) {
            this.f31956d.f31964b = this.j;
            this.n = true;
        }
        this.f31956d.a(this.f31957e);
        return 0;
    }

    private int b(h hVar) throws IOException, InterruptedException {
        int i2 = 0;
        while (true) {
            hVar.c(this.f31958f.f32566a, 0, 10);
            this.f31958f.c(0);
            if (this.f31958f.f() != f31954b) {
                break;
            }
            this.f31958f.d(3);
            int m2 = this.f31958f.m();
            i2 += m2 + 10;
            hVar.c(m2);
        }
        hVar.a();
        hVar.c(i2);
        if (this.k == -1) {
            this.k = (long) i2;
        }
        return i2;
    }
}
