package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.a;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class z extends com.google.android.exoplayer2.extractor.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(ab abVar, long j, long j2, int i2) {
        super(new a.b(), new a(i2, abVar), j, j + 1, j2, 940);
        ab abVar2 = abVar;
    }

    static final class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final ab f32123a;

        /* renamed from: b  reason: collision with root package name */
        private final r f32124b = new r();

        /* renamed from: c  reason: collision with root package name */
        private final int f32125c;

        public a(int i2, ab abVar) {
            this.f32125c = i2;
            this.f32123a = abVar;
        }

        public final a.e a(h hVar, long j) throws IOException, InterruptedException {
            int a2;
            int i2;
            long c2 = hVar.c();
            int min = (int) Math.min(112800, hVar.d() - c2);
            this.f32124b.a(min);
            hVar.c(this.f32124b.f32566a, 0, min);
            r rVar = this.f32124b;
            int i3 = rVar.f32568c;
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (rVar.b() >= 188 && (i2 = a2 + 188) <= i3) {
                long a3 = ad.a(rVar, (a2 = ad.a(rVar.f32566a, rVar.f32567b, i3)), this.f32125c);
                if (a3 != -9223372036854775807L) {
                    long b2 = this.f32123a.b(a3);
                    if (b2 > j) {
                        if (j4 == -9223372036854775807L) {
                            return a.e.a(b2, c2);
                        }
                        return a.e.a(c2 + j3);
                    } else if (100000 + b2 > j) {
                        return a.e.a(c2 + ((long) a2));
                    } else {
                        j3 = (long) a2;
                        j4 = b2;
                    }
                }
                rVar.c(i2);
                j2 = (long) i2;
            }
            if (j4 != -9223372036854775807L) {
                return a.e.b(j4, c2 + j2);
            }
            return a.e.f31677a;
        }

        public final void a() {
            r rVar = this.f32124b;
            byte[] bArr = ae.f32504f;
            rVar.a(bArr, bArr.length);
        }
    }
}
