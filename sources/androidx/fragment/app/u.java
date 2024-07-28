package androidx.fragment.app;

import androidx.lifecycle.k;
import androidx.lifecycle.q;
import androidx.lifecycle.t;

final class u implements q {

    /* renamed from: a  reason: collision with root package name */
    t f3545a = null;

    u() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f3545a == null) {
            this.f3545a = new t(this);
        }
    }

    public final k getLifecycle() {
        a();
        return this.f3545a;
    }

    /* access modifiers changed from: package-private */
    public final void a(k.a aVar) {
        this.f3545a.a(aVar);
    }
}
