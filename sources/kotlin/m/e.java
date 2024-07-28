package kotlin.m;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.l.d;
import kotlin.o;

final class e implements d<kotlin.j.d> {

    /* renamed from: a  reason: collision with root package name */
    final CharSequence f47978a;

    /* renamed from: b  reason: collision with root package name */
    final int f47979b = 0;

    /* renamed from: c  reason: collision with root package name */
    final int f47980c = 0;

    /* renamed from: d  reason: collision with root package name */
    final m<CharSequence, Integer, o<Integer, Integer>> f47981d;

    public e(CharSequence charSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> mVar) {
        k.d(charSequence, "input");
        k.d(mVar, "getNextMatch");
        this.f47978a = charSequence;
        this.f47981d = mVar;
    }

    public static final class a implements Iterator<kotlin.j.d>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f47982a;

        /* renamed from: b  reason: collision with root package name */
        private int f47983b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f47984c;

        /* renamed from: d  reason: collision with root package name */
        private int f47985d;

        /* renamed from: e  reason: collision with root package name */
        private kotlin.j.d f47986e;

        /* renamed from: f  reason: collision with root package name */
        private int f47987f;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(e eVar) {
            this.f47982a = eVar;
            this.f47984c = kotlin.j.e.a(eVar.f47979b, 0, eVar.f47978a.length());
            this.f47985d = this.f47984c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (r6.f47987f < r6.f47982a.f47980c) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f47985d
                r1 = 0
                if (r0 >= 0) goto L_0x000b
                r6.f47983b = r1
                r0 = 0
                r6.f47986e = r0
                return
            L_0x000b:
                kotlin.m.e r0 = r6.f47982a
                int r0 = r0.f47980c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0020
                int r0 = r6.f47987f
                int r0 = r0 + r3
                r6.f47987f = r0
                int r0 = r6.f47987f
                kotlin.m.e r4 = r6.f47982a
                int r4 = r4.f47980c
                if (r0 >= r4) goto L_0x002c
            L_0x0020:
                int r0 = r6.f47985d
                kotlin.m.e r4 = r6.f47982a
                java.lang.CharSequence r4 = r4.f47978a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0040
            L_0x002c:
                int r0 = r6.f47984c
                kotlin.j.d r1 = new kotlin.j.d
                kotlin.m.e r4 = r6.f47982a
                java.lang.CharSequence r4 = r4.f47978a
                int r4 = kotlin.m.p.d(r4)
                r1.<init>(r0, r4)
                r6.f47986e = r1
                r6.f47985d = r2
                goto L_0x0091
            L_0x0040:
                kotlin.m.e r0 = r6.f47982a
                kotlin.g.a.m<java.lang.CharSequence, java.lang.Integer, kotlin.o<java.lang.Integer, java.lang.Integer>> r0 = r0.f47981d
                kotlin.m.e r4 = r6.f47982a
                java.lang.CharSequence r4 = r4.f47978a
                int r5 = r6.f47985d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.o r0 = (kotlin.o) r0
                if (r0 != 0) goto L_0x006a
                int r0 = r6.f47984c
                kotlin.j.d r1 = new kotlin.j.d
                kotlin.m.e r4 = r6.f47982a
                java.lang.CharSequence r4 = r4.f47978a
                int r4 = kotlin.m.p.d(r4)
                r1.<init>(r0, r4)
                r6.f47986e = r1
                r6.f47985d = r2
                goto L_0x0091
            L_0x006a:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f47984c
                kotlin.j.d r4 = kotlin.j.e.a((int) r4, (int) r2)
                r6.f47986e = r4
                int r2 = r2 + r0
                r6.f47984c = r2
                int r2 = r6.f47984c
                if (r0 != 0) goto L_0x008e
                r1 = 1
            L_0x008e:
                int r2 = r2 + r1
                r6.f47985d = r2
            L_0x0091:
                r6.f47983b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.m.e.a.a():void");
        }

        public final boolean hasNext() {
            if (this.f47983b == -1) {
                a();
            }
            return this.f47983b == 1;
        }

        public final /* synthetic */ Object next() {
            if (this.f47983b == -1) {
                a();
            }
            if (this.f47983b != 0) {
                kotlin.j.d dVar = this.f47986e;
                if (dVar != null) {
                    this.f47986e = null;
                    this.f47983b = -1;
                    return dVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }
    }

    public final Iterator<kotlin.j.d> a() {
        return new a(this);
    }
}
