package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.k;

class ReflectiveGenericLifecycleObserver implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3595a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f3596b = b.f3648a.b(this.f3595a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3595a = obj;
    }

    public final void a(q qVar, k.a aVar) {
        b.a aVar2 = this.f3596b;
        Object obj = this.f3595a;
        b.a.a(aVar2.f3651a.get(aVar), qVar, aVar, obj);
        b.a.a(aVar2.f3651a.get(k.a.ON_ANY), qVar, aVar, obj);
    }
}
