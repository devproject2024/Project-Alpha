package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f32256a = {ae.h("isom"), ae.h("iso2"), ae.h("iso3"), ae.h("iso4"), ae.h("iso5"), ae.h("iso6"), ae.h("avc1"), ae.h("hvc1"), ae.h("hev1"), ae.h("av01"), ae.h("mp41"), ae.h("mp42"), ae.h("3g2a"), ae.h("3g2b"), ae.h("3gr6"), ae.h("3gs6"), ae.h("3ge6"), ae.h("3gg6"), ae.h("M4V "), ae.h("M4A "), ae.h("f4v "), ae.h("kddi"), ae.h("M4VP"), ae.h("qt  "), ae.h("MSNV"), ae.h("dby1")};

    public static boolean a(h hVar) throws IOException, InterruptedException {
        return a(hVar, true);
    }

    public static boolean b(h hVar) throws IOException, InterruptedException {
        return a(hVar, false);
    }

    private static boolean a(h hVar, boolean z) throws IOException, InterruptedException {
        boolean z2;
        h hVar2 = hVar;
        long d2 = hVar.d();
        long j = 4096;
        long j2 = -1;
        int i2 = (d2 > -1 ? 1 : (d2 == -1 ? 0 : -1));
        if (i2 != 0 && d2 <= 4096) {
            j = d2;
        }
        int i3 = (int) j;
        r rVar = new r(64);
        boolean z3 = false;
        int i4 = i3;
        int i5 = 0;
        boolean z4 = false;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            rVar.a(8);
            hVar2.c(rVar.f32566a, z3 ? 1 : 0, 8);
            long g2 = rVar.g();
            int i6 = rVar.i();
            int i7 = 16;
            if (g2 == 1) {
                hVar2.c(rVar.f32566a, 8, 8);
                rVar.b(16);
                g2 = rVar.k();
            } else {
                if (g2 == 0) {
                    long d3 = hVar.d();
                    if (d3 != j2) {
                        g2 = (d3 - hVar.b()) + 8;
                    }
                }
                i7 = 8;
            }
            if (i2 == 0 || ((long) i5) + g2 <= d2) {
                long j3 = (long) i7;
                if (g2 >= j3) {
                    i5 += i7;
                    if (i6 != a.Q) {
                        if (i6 != a.X && i6 != a.Z) {
                            long j4 = g2;
                            int i8 = i4;
                            if ((((long) i5) + g2) - j3 >= ((long) i8)) {
                                break;
                            }
                            int i9 = (int) (j4 - j3);
                            i5 += i9;
                            if (i6 == a.f32159a) {
                                if (i9 < 8) {
                                    return false;
                                }
                                rVar.a(i9);
                                hVar2.c(rVar.f32566a, 0, i9);
                                int i10 = i9 / 4;
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= i10) {
                                        break;
                                    }
                                    if (i11 == 1) {
                                        rVar.d(4);
                                    } else if (a(rVar.i())) {
                                        z4 = true;
                                        break;
                                    }
                                    i11++;
                                }
                                if (!z4) {
                                    return false;
                                }
                            } else if (i9 != 0) {
                                hVar2.c(i9);
                            }
                            i4 = i8;
                            j2 = -1;
                            z3 = false;
                        } else {
                            z2 = true;
                        }
                    } else {
                        i4 += (int) g2;
                        if (i2 != 0 && ((long) i4) > d2) {
                            i4 = (int) d2;
                        }
                        j2 = -1;
                    }
                } else {
                    return z3;
                }
            } else {
                return z3;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }

    private static boolean a(int i2) {
        if ((i2 >>> 8) == ae.h("3gp")) {
            return true;
        }
        for (int i3 : f32256a) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }
}
