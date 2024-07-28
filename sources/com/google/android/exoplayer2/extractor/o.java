package com.google.android.exoplayer2.extractor;

public interface o {
    a a(long j);

    long b();

    boolean h_();

    public static final class b implements o {

        /* renamed from: a  reason: collision with root package name */
        private final long f32291a;

        /* renamed from: b  reason: collision with root package name */
        private final a f32292b;

        public final boolean h_() {
            return false;
        }

        public b(long j) {
            this(j, 0);
        }

        public b(long j, long j2) {
            this.f32291a = j;
            this.f32292b = new a(j2 == 0 ? p.f32293a : new p(0, j2));
        }

        public final long b() {
            return this.f32291a;
        }

        public final a a(long j) {
            return this.f32292b;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final p f32289a;

        /* renamed from: b  reason: collision with root package name */
        public final p f32290b;

        public a(p pVar) {
            this(pVar, pVar);
        }

        public a(p pVar, p pVar2) {
            this.f32289a = (p) com.google.android.exoplayer2.g.a.a(pVar);
            this.f32290b = (p) com.google.android.exoplayer2.g.a.a(pVar2);
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.f32289a);
            if (this.f32289a.equals(this.f32290b)) {
                str = "";
            } else {
                str = ", " + this.f32290b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f32289a.equals(aVar.f32289a) && this.f32290b.equals(aVar.f32290b);
            }
        }

        public final int hashCode() {
            return (this.f32289a.hashCode() * 31) + this.f32290b.hashCode();
        }
    }
}
