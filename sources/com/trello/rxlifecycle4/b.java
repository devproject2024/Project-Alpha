package com.trello.rxlifecycle4;

import com.trello.rxlifecycle4.a.a;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.v;

public final class b<T> implements v<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final p<?> f33769a;

    b(p<?> pVar) {
        a.a(pVar, "observable == null");
        this.f33769a = pVar;
    }

    public final u<T> a(p<T> pVar) {
        return pVar.takeUntil((u<U>) this.f33769a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f33769a.equals(((b) obj).f33769a);
    }

    public final int hashCode() {
        return this.f33769a.hashCode();
    }

    public final String toString() {
        return "LifecycleTransformer{observable=" + this.f33769a + '}';
    }
}
