package com.google.firebase.e;

import com.google.firebase.components.e;
import com.google.firebase.components.n;
import java.util.Iterator;
import java.util.Set;

public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final String f38729a;

    /* renamed from: b  reason: collision with root package name */
    private final d f38730b;

    private b(Set<f> set, d dVar) {
        this.f38729a = a(set);
        this.f38730b = dVar;
    }

    public final String a() {
        if (this.f38730b.a().isEmpty()) {
            return this.f38729a;
        }
        return this.f38729a + ' ' + a(this.f38730b.a());
    }

    private static String a(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it2 = set.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it2.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static com.google.firebase.components.b<h> b() {
        return com.google.firebase.components.b.a(h.class).a(n.c(f.class)).a(c.a()).a();
    }

    static /* synthetic */ h a(e eVar) {
        return new b(eVar.b(f.class), d.b());
    }
}
