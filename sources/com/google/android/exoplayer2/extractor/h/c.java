package com.google.android.exoplayer2.extractor.h;

import com.google.android.exoplayer2.b.x;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;

final class c {
    public static b a(h hVar) throws IOException, InterruptedException {
        a a2;
        com.google.android.exoplayer2.g.a.a(hVar);
        r rVar = new r(16);
        if (a.a(hVar, rVar).f32140a != x.f31280a) {
            return null;
        }
        hVar.c(rVar.f32566a, 0, 4);
        rVar.c(0);
        int i2 = rVar.i();
        if (i2 != x.f31281b) {
            "Unsupported RIFF format: ".concat(String.valueOf(i2));
            l.d();
            return null;
        }
        while (true) {
            a2 = a.a(hVar, rVar);
            if (a2.f32140a == x.f31282c) {
                break;
            }
            hVar.c((int) a2.f32141b);
        }
        com.google.android.exoplayer2.g.a.b(a2.f32141b >= 16);
        hVar.c(rVar.f32566a, 0, 16);
        rVar.c(0);
        int e2 = rVar.e();
        int e3 = rVar.e();
        int o = rVar.o();
        int o2 = rVar.o();
        int e4 = rVar.e();
        int e5 = rVar.e();
        int i3 = (e3 * e5) / 8;
        if (e4 == i3) {
            int a3 = x.a(e2, e5);
            if (a3 == 0) {
                StringBuilder sb = new StringBuilder("Unsupported WAV format: ");
                sb.append(e5);
                sb.append(" bit/sample, type ");
                sb.append(e2);
                l.d();
                return null;
            }
            hVar.c(((int) a2.f32141b) - 16);
            return new b(e3, o, o2, e4, e5, a3);
        }
        throw new v("Expected block alignment: " + i3 + "; got: " + e4);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32140a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32141b;

        private a(int i2, long j) {
            this.f32140a = i2;
            this.f32141b = j;
        }

        public static a a(h hVar, r rVar) throws IOException, InterruptedException {
            hVar.c(rVar.f32566a, 0, 8);
            rVar.c(0);
            return new a(rVar.i(), rVar.h());
        }
    }
}
