package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;
import java.io.IOException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final C0538a f31649a;

    /* renamed from: b  reason: collision with root package name */
    protected final f f31650b;

    /* renamed from: c  reason: collision with root package name */
    protected c f31651c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31652d;

    public static final class b implements d {
        public final long a(long j) {
            return j;
        }
    }

    public interface d {
        long a(long j);
    }

    public interface f {

        /* renamed from: com.google.android.exoplayer2.extractor.a$f$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$a(f fVar) {
            }
        }

        e a(h hVar, long j) throws IOException, InterruptedException;

        void a();
    }

    protected a(d dVar, f fVar, long j, long j2, long j3, int i2) {
        this.f31650b = fVar;
        this.f31652d = i2;
        this.f31649a = new C0538a(dVar, j, j2, j3);
    }

    public final o a() {
        return this.f31649a;
    }

    public final void a(long j) {
        long j2 = j;
        c cVar = this.f31651c;
        if (cVar == null || cVar.f31669a != j2) {
            long j3 = this.f31649a.f31658f;
            c cVar2 = r1;
            c cVar3 = new c(j, this.f31649a.f31653a.a(j2), this.f31649a.f31654b, this.f31649a.f31655c, this.f31649a.f31656d, this.f31649a.f31657e, j3);
            this.f31651c = cVar2;
        }
    }

    public final boolean b() {
        return this.f31651c != null;
    }

    public final int a(h hVar, n nVar) throws InterruptedException, IOException {
        f fVar = (f) com.google.android.exoplayer2.g.a.a(this.f31650b);
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.g.a.a(this.f31651c);
            long j = cVar.f31673e;
            long j2 = cVar.f31674f;
            long j3 = cVar.f31675g;
            if (j2 - j <= ((long) this.f31652d)) {
                c();
                return a(hVar, j, nVar);
            } else if (!a(hVar, j3)) {
                return a(hVar, j3, nVar);
            } else {
                hVar.a();
                e a2 = fVar.a(hVar, cVar.f31670b);
                int a3 = a2.f31678b;
                if (a3 == -3) {
                    c();
                    return a(hVar, j3, nVar);
                } else if (a3 == -2) {
                    long b2 = a2.f31679c;
                    long c2 = a2.f31680d;
                    cVar.f31671c = b2;
                    cVar.f31673e = c2;
                    cVar.a();
                } else if (a3 == -1) {
                    long b3 = a2.f31679c;
                    long c3 = a2.f31680d;
                    cVar.f31672d = b3;
                    cVar.f31674f = c3;
                    cVar.a();
                } else if (a3 == 0) {
                    long unused = a2.f31680d;
                    c();
                    a(hVar, a2.f31680d);
                    return a(hVar, a2.f31680d, nVar);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    private void c() {
        this.f31651c = null;
        this.f31650b.a();
    }

    private static boolean a(h hVar, long j) throws IOException, InterruptedException {
        long c2 = j - hVar.c();
        if (c2 < 0 || c2 > 262144) {
            return false;
        }
        hVar.b((int) c2);
        return true;
    }

    private static int a(h hVar, long j, n nVar) {
        if (j == hVar.c()) {
            return 0;
        }
        nVar.f32288a = j;
        return 1;
    }

    protected static class c {

        /* renamed from: a  reason: collision with root package name */
        final long f31669a;

        /* renamed from: b  reason: collision with root package name */
        final long f31670b;

        /* renamed from: c  reason: collision with root package name */
        long f31671c;

        /* renamed from: d  reason: collision with root package name */
        long f31672d;

        /* renamed from: e  reason: collision with root package name */
        long f31673e;

        /* renamed from: f  reason: collision with root package name */
        long f31674f;

        /* renamed from: g  reason: collision with root package name */
        long f31675g;

        /* renamed from: h  reason: collision with root package name */
        private final long f31676h;

        protected static long a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) (((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2))));
            return ae.a(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        protected c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f31669a = j;
            this.f31670b = j2;
            this.f31671c = j3;
            this.f31672d = j4;
            this.f31673e = j5;
            this.f31674f = j6;
            this.f31676h = j7;
            this.f31675g = a(j2, j3, j4, j5, j6, j7);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f31675g = a(this.f31670b, this.f31671c, this.f31672d, this.f31673e, this.f31674f, this.f31676h);
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f31677a = new e(-3, -9223372036854775807L, -1);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f31678b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f31679c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f31680d;

        private e(int i2, long j, long j2) {
            this.f31678b = i2;
            this.f31679c = j;
            this.f31680d = j2;
        }

        public static e a(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e b(long j, long j2) {
            return new e(-2, j, j2);
        }

        public static e a(long j) {
            return new e(0, -9223372036854775807L, j);
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.a$a  reason: collision with other inner class name */
    public static class C0538a implements o {

        /* renamed from: a  reason: collision with root package name */
        final d f31653a;

        /* renamed from: b  reason: collision with root package name */
        final long f31654b = 0;

        /* renamed from: c  reason: collision with root package name */
        final long f31655c;

        /* renamed from: d  reason: collision with root package name */
        final long f31656d;

        /* renamed from: e  reason: collision with root package name */
        final long f31657e;

        /* renamed from: f  reason: collision with root package name */
        final long f31658f;

        /* renamed from: g  reason: collision with root package name */
        private final long f31659g;

        public final boolean h_() {
            return true;
        }

        public C0538a(d dVar, long j, long j2, long j3) {
            this.f31653a = dVar;
            this.f31659g = j;
            this.f31655c = j2;
            this.f31656d = 0;
            this.f31657e = j3;
            this.f31658f = 188;
        }

        public final o.a a(long j) {
            return new o.a(new p(j, c.a(this.f31653a.a(j), this.f31654b, this.f31655c, this.f31656d, this.f31657e, this.f31658f)));
        }

        public final long b() {
            return this.f31659g;
        }
    }
}
