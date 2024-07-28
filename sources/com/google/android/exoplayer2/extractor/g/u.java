package com.google.android.exoplayer2.extractor.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.io.IOException;
import net.one97.paytm.upi.util.UpiConstants;

public final class u implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f32095a = $$Lambda$u$BtvAF6lhMLgSv9pGj3FKwChJkM.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final ab f32096b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f32097c;

    /* renamed from: d  reason: collision with root package name */
    private final r f32098d;

    /* renamed from: e  reason: collision with root package name */
    private final t f32099e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32100f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32101g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f32102h;

    /* renamed from: i  reason: collision with root package name */
    private long f32103i;
    private s j;
    private i k;
    private boolean l;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new u()};
    }

    public u() {
        this(new ab(0));
    }

    private u(ab abVar) {
        this.f32096b = abVar;
        this.f32098d = new r(4096);
        this.f32097c = new SparseArray<>();
        this.f32099e = new t();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        hVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        hVar.c(bArr[13] & 7);
        hVar.c(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public final void a(i iVar) {
        this.k = iVar;
    }

    public final void a(long j2, long j3) {
        if ((this.f32096b.a() == -9223372036854775807L) || !(this.f32096b.f32496a == 0 || this.f32096b.f32496a == j3)) {
            ab abVar = this.f32096b;
            abVar.f32498c = -9223372036854775807L;
            abVar.a(j3);
        }
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(j3);
        }
        for (int i2 = 0; i2 < this.f32097c.size(); i2++) {
            a valueAt = this.f32097c.valueAt(i2);
            valueAt.f32109f = false;
            valueAt.f32104a.a();
        }
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        int i2;
        long j2;
        long j3;
        h hVar2 = hVar;
        n nVar2 = nVar;
        long d2 = hVar.d();
        int i3 = (d2 > -1 ? 1 : (d2 == -1 ? 0 : -1));
        if (!(i3 != 0) || this.f32099e.f32089c) {
            if (!this.l) {
                this.l = true;
                if (this.f32099e.f32094h != -9223372036854775807L) {
                    s sVar = r3;
                    i2 = 4;
                    s sVar2 = new s(this.f32099e.f32087a, this.f32099e.f32094h, d2);
                    this.j = sVar;
                    this.k.a(this.j.a());
                } else {
                    i2 = 4;
                    this.k.a(new o.b(this.f32099e.f32094h));
                }
            } else {
                i2 = 4;
            }
            s sVar3 = this.j;
            if (sVar3 != null && sVar3.b()) {
                return this.j.a(hVar2, nVar2);
            }
            hVar.a();
            long b2 = i3 != 0 ? d2 - hVar.b() : -1;
            if ((b2 != -1 && b2 < 4) || !hVar2.b(this.f32098d.f32566a, 0, i2, true)) {
                return -1;
            }
            this.f32098d.c(0);
            int i4 = this.f32098d.i();
            if (i4 == 441) {
                return -1;
            }
            if (i4 == 442) {
                hVar2.c(this.f32098d.f32566a, 0, 10);
                this.f32098d.c(9);
                hVar2.b((this.f32098d.c() & 7) + 14);
                return 0;
            } else if (i4 == 443) {
                hVar2.c(this.f32098d.f32566a, 0, 2);
                this.f32098d.c(0);
                hVar2.b(this.f32098d.d() + 6);
                return 0;
            } else if (((i4 & -256) >> 8) != 1) {
                hVar2.b(1);
                return 0;
            } else {
                int i5 = i4 & PriceRangeSeekBar.INVALID_POINTER_ID;
                a aVar = this.f32097c.get(i5);
                if (!this.f32100f) {
                    if (aVar == null) {
                        j jVar = null;
                        if (i5 == 189) {
                            jVar = new b();
                            this.f32101g = true;
                            this.f32103i = hVar.c();
                        } else if ((i5 & Constants.EASY_PAY_INVISIBLE_ASSIST) == 192) {
                            jVar = new p();
                            this.f32101g = true;
                            this.f32103i = hVar.c();
                        } else if ((i5 & 240) == 224) {
                            jVar = new k();
                            this.f32102h = true;
                            this.f32103i = hVar.c();
                        }
                        if (jVar != null) {
                            jVar.a(this.k, new ac.d(i5, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS));
                            aVar = new a(jVar, this.f32096b);
                            this.f32097c.put(i5, aVar);
                        }
                    }
                    if (hVar.c() > ((!this.f32101g || !this.f32102h) ? 1048576 : this.f32103i + 8192)) {
                        this.f32100f = true;
                        this.k.a();
                    }
                }
                hVar2.c(this.f32098d.f32566a, 0, 2);
                this.f32098d.c(0);
                int d3 = this.f32098d.d() + 6;
                if (aVar == null) {
                    hVar2.b(d3);
                    return 0;
                }
                this.f32098d.a(d3);
                hVar2.b(this.f32098d.f32566a, 0, d3);
                this.f32098d.c(6);
                r rVar = this.f32098d;
                rVar.a(aVar.f32106c.f32562a, 0, 3);
                aVar.f32106c.a(0);
                aVar.f32106c.b(8);
                aVar.f32107d = aVar.f32106c.e();
                aVar.f32108e = aVar.f32106c.e();
                aVar.f32106c.b(6);
                aVar.f32110g = aVar.f32106c.c(8);
                rVar.a(aVar.f32106c.f32562a, 0, aVar.f32110g);
                aVar.f32106c.a(0);
                aVar.f32111h = 0;
                if (aVar.f32107d) {
                    aVar.f32106c.b(i2);
                    aVar.f32106c.b(1);
                    aVar.f32106c.b(1);
                    long c2 = (((long) aVar.f32106c.c(3)) << 30) | ((long) (aVar.f32106c.c(15) << 15)) | ((long) aVar.f32106c.c(15));
                    aVar.f32106c.b(1);
                    if (!aVar.f32109f && aVar.f32108e) {
                        aVar.f32106c.b(i2);
                        aVar.f32106c.b(1);
                        aVar.f32106c.b(1);
                        aVar.f32106c.b(1);
                        aVar.f32105b.b((((long) aVar.f32106c.c(3)) << 30) | ((long) (aVar.f32106c.c(15) << 15)) | ((long) aVar.f32106c.c(15)));
                        aVar.f32109f = true;
                    }
                    aVar.f32111h = aVar.f32105b.b(c2);
                }
                aVar.f32104a.a(aVar.f32111h, i2);
                aVar.f32104a.a(rVar);
                aVar.f32104a.b();
                r rVar2 = this.f32098d;
                rVar2.b(rVar2.f32566a.length);
                return 0;
            }
        } else {
            t tVar = this.f32099e;
            if (!tVar.f32091e) {
                long d4 = hVar.d();
                int min = (int) Math.min(20000, d4);
                long j4 = d4 - ((long) min);
                if (hVar.c() != j4) {
                    nVar2.f32288a = j4;
                    return 1;
                }
                tVar.f32088b.a(min);
                hVar.a();
                hVar2.c(tVar.f32088b.f32566a, 0, min);
                r rVar3 = tVar.f32088b;
                int i6 = rVar3.f32567b;
                int i7 = rVar3.f32568c - 4;
                while (true) {
                    if (i7 < i6) {
                        j3 = -9223372036854775807L;
                        break;
                    }
                    if (t.a(rVar3.f32566a, i7) == 442) {
                        rVar3.c(i7 + 4);
                        j3 = t.a(rVar3);
                        if (j3 != -9223372036854775807L) {
                            break;
                        }
                    }
                    i7--;
                }
                tVar.f32093g = j3;
                tVar.f32091e = true;
                return 0;
            } else if (tVar.f32093g == -9223372036854775807L) {
                return tVar.a(hVar2);
            } else {
                if (!tVar.f32090d) {
                    int min2 = (int) Math.min(20000, hVar.d());
                    if (hVar.c() != 0) {
                        nVar2.f32288a = 0;
                        return 1;
                    }
                    tVar.f32088b.a(min2);
                    hVar.a();
                    hVar2.c(tVar.f32088b.f32566a, 0, min2);
                    r rVar4 = tVar.f32088b;
                    int i8 = rVar4.f32567b;
                    int i9 = rVar4.f32568c;
                    while (true) {
                        if (i8 >= i9 - 3) {
                            j2 = -9223372036854775807L;
                            break;
                        }
                        if (t.a(rVar4.f32566a, i8) == 442) {
                            rVar4.c(i8 + 4);
                            j2 = t.a(rVar4);
                            if (j2 != -9223372036854775807L) {
                                break;
                            }
                        }
                        i8++;
                    }
                    tVar.f32092f = j2;
                    tVar.f32090d = true;
                    return 0;
                } else if (tVar.f32092f == -9223372036854775807L) {
                    return tVar.a(hVar2);
                } else {
                    tVar.f32094h = tVar.f32087a.b(tVar.f32093g) - tVar.f32087a.b(tVar.f32092f);
                    return tVar.a(hVar2);
                }
            }
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final j f32104a;

        /* renamed from: b  reason: collision with root package name */
        final ab f32105b;

        /* renamed from: c  reason: collision with root package name */
        final q f32106c = new q(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        boolean f32107d;

        /* renamed from: e  reason: collision with root package name */
        boolean f32108e;

        /* renamed from: f  reason: collision with root package name */
        boolean f32109f;

        /* renamed from: g  reason: collision with root package name */
        int f32110g;

        /* renamed from: h  reason: collision with root package name */
        long f32111h;

        public a(j jVar, ab abVar) {
            this.f32104a = jVar;
            this.f32105b = abVar;
        }
    }
}
