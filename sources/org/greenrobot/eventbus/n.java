package org.greenrobot.eventbus;

final class n {

    /* renamed from: a  reason: collision with root package name */
    final Object f72909a;

    /* renamed from: b  reason: collision with root package name */
    final l f72910b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f72911c = true;

    n(Object obj, l lVar) {
        this.f72909a = obj;
        this.f72910b = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f72909a != nVar.f72909a || !this.f72910b.equals(nVar.f72910b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f72909a.hashCode() + this.f72910b.f72895f.hashCode();
    }
}
