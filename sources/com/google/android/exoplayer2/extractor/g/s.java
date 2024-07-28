package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.a;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class s extends com.google.android.exoplayer2.extractor.a {
    public s(ab abVar, long j, long j2) {
        super(new a.b(), new a(abVar, (byte) 0), j, j + 1, j2, 1000);
    }

    static final class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final ab f32085a;

        /* renamed from: b  reason: collision with root package name */
        private final r f32086b;

        /* synthetic */ a(ab abVar, byte b2) {
            this(abVar);
        }

        private a(ab abVar) {
            this.f32085a = abVar;
            this.f32086b = new r();
        }

        public final a.e a(h hVar, long j) throws IOException, InterruptedException {
            int a2;
            long c2 = hVar.c();
            int min = (int) Math.min(20000, hVar.d() - c2);
            this.f32086b.a(min);
            hVar.c(this.f32086b.f32566a, 0, min);
            r rVar = this.f32086b;
            int i2 = -1;
            long j2 = -9223372036854775807L;
            int i3 = -1;
            while (rVar.b() >= 4) {
                if (s.a(rVar.f32566a, rVar.f32567b) != 442) {
                    rVar.d(1);
                } else {
                    rVar.d(4);
                    long a3 = t.a(rVar);
                    if (a3 != -9223372036854775807L) {
                        long b2 = this.f32085a.b(a3);
                        if (b2 > j) {
                            if (j2 == -9223372036854775807L) {
                                return a.e.a(b2, c2);
                            }
                            return a.e.a(c2 + ((long) i3));
                        } else if (100000 + b2 > j) {
                            return a.e.a(c2 + ((long) rVar.f32567b));
                        } else {
                            i3 = rVar.f32567b;
                            j2 = b2;
                        }
                    }
                    int i4 = rVar.f32568c;
                    if (rVar.b() >= 10) {
                        rVar.d(9);
                        int c3 = rVar.c() & 7;
                        if (rVar.b() >= c3) {
                            rVar.d(c3);
                            if (rVar.b() >= 4) {
                                if (s.a(rVar.f32566a, rVar.f32567b) == 443) {
                                    rVar.d(4);
                                    int d2 = rVar.d();
                                    if (rVar.b() < d2) {
                                        rVar.c(i4);
                                    } else {
                                        rVar.d(d2);
                                    }
                                }
                                while (true) {
                                    if (rVar.b() < 4 || (a2 = s.a(rVar.f32566a, rVar.f32567b)) == 442 || a2 == 441 || (a2 >>> 8) != 1) {
                                        break;
                                    }
                                    rVar.d(4);
                                    if (rVar.b() < 2) {
                                        rVar.c(i4);
                                        break;
                                    }
                                    rVar.c(Math.min(rVar.f32568c, rVar.f32567b + rVar.d()));
                                }
                            } else {
                                rVar.c(i4);
                            }
                        } else {
                            rVar.c(i4);
                        }
                    } else {
                        rVar.c(i4);
                    }
                    i2 = rVar.f32567b;
                }
            }
            if (j2 != -9223372036854775807L) {
                return a.e.b(j2, c2 + ((long) i2));
            }
            return a.e.f31677a;
        }

        public final void a() {
            r rVar = this.f32086b;
            byte[] bArr = ae.f32504f;
            rVar.a(bArr, bArr.length);
        }
    }

    static /* synthetic */ int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
