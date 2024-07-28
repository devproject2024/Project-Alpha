package com.google.android.gms.b;

import com.google.android.gms.b.a;
import java.util.Iterator;

final class g implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a f8281a;

    g(a aVar) {
        this.f8281a = aVar;
    }

    public final void a(T t) {
        a aVar = this.f8281a;
        aVar.f8274a = t;
        Iterator it2 = aVar.f8276c.iterator();
        while (it2.hasNext()) {
            ((a.C0120a) it2.next()).b();
        }
        this.f8281a.f8276c.clear();
        this.f8281a.f8275b = null;
    }
}
