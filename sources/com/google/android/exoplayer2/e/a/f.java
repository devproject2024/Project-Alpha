package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f31444a = ae.h("GA94");

    public static void a(long j, r rVar, q[] qVarArr) {
        while (true) {
            boolean z = true;
            if (rVar.b() > 1) {
                int a2 = a(rVar);
                int a3 = a(rVar);
                int i2 = rVar.f32567b + a3;
                if (a3 == -1 || a3 > rVar.b()) {
                    l.c();
                    i2 = rVar.f32568c;
                } else if (a2 == 4 && a3 >= 8) {
                    int c2 = rVar.c();
                    int d2 = rVar.d();
                    int i3 = d2 == 49 ? rVar.i() : 0;
                    int c3 = rVar.c();
                    if (d2 == 47) {
                        rVar.d(1);
                    }
                    boolean z2 = c2 == 181 && (d2 == 49 || d2 == 47) && c3 == 3;
                    if (d2 == 49) {
                        if (i3 != f31444a) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        b(j, rVar, qVarArr);
                    }
                }
                rVar.c(i2);
            } else {
                return;
            }
        }
    }

    public static void b(long j, r rVar, q[] qVarArr) {
        int c2 = rVar.c();
        if ((c2 & 64) != 0) {
            rVar.d(1);
            int i2 = (c2 & 31) * 3;
            int i3 = rVar.f32567b;
            for (q qVar : qVarArr) {
                rVar.c(i3);
                qVar.a(rVar, i2);
                qVar.a(j, 1, i2, 0, (q.a) null);
            }
        }
    }

    private static int a(r rVar) {
        int i2 = 0;
        while (rVar.b() != 0) {
            int c2 = rVar.c();
            i2 += c2;
            if (c2 != 255) {
                return i2;
            }
        }
        return -1;
    }
}
