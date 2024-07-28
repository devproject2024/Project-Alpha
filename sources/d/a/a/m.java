package d.a.a;

final class m {

    /* renamed from: a  reason: collision with root package name */
    final Object f45990a;

    /* renamed from: b  reason: collision with root package name */
    final k f45991b;

    /* renamed from: c  reason: collision with root package name */
    final int f45992c = 0;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f45993d = true;

    m(Object obj, k kVar) {
        this.f45990a = obj;
        this.f45991b = kVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f45990a != mVar.f45990a || !this.f45991b.equals(mVar.f45991b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f45990a.hashCode() + this.f45991b.f45987d.hashCode();
    }
}
