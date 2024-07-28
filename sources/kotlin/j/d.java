package kotlin.j;

public final class d extends b implements a<Integer> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f47946e = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final d f47947f = new d(1, 0);

    public d(int i2, int i3) {
        super(i2, i3, 1);
    }

    public final /* synthetic */ boolean a(Comparable comparable) {
        return a(((Number) comparable).intValue());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (a() && ((d) obj).a()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f47939a == dVar.f47939a && this.f47940b == dVar.f47940b;
    }

    public final int hashCode() {
        if (a()) {
            return -1;
        }
        return (this.f47939a * 31) + this.f47940b;
    }

    public final String toString() {
        return this.f47939a + ".." + this.f47940b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a(int i2) {
        return this.f47939a <= i2 && i2 <= this.f47940b;
    }

    public final boolean a() {
        return this.f47939a > this.f47940b;
    }
}
