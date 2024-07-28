package com.arthurivanets.arvi;

import com.arthurivanets.arvi.a.b;
import com.arthurivanets.arvi.b.b.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final int f30961a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<g> f30962b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, g> f30963c;

    a(int i2) {
        boolean z = i2 >= 0;
        c.a((Object) "You must specify a valid Pool Max Size.");
        if (z) {
            this.f30961a = i2;
            this.f30962b = new HashSet();
            this.f30963c = new HashMap();
            return;
        }
        throw new IllegalStateException(String.format(Locale.US, "%s - the condition is not met. The Condition must be positive.", new Object[]{"You must specify a valid Pool Max Size."}));
    }

    public final void a(g gVar) {
        c.a((Object) gVar);
        this.f30962b.add(gVar);
        this.f30963c.put(gVar.f31015b, gVar);
    }

    public final void a(String str) {
        c.a(str);
        g d2 = d(str);
        if (d2 != null) {
            b(d2);
        }
        this.f30963c.remove(str);
    }

    public final g b(String str) {
        g gVar;
        c.a(str);
        Iterator<g> it2 = this.f30962b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                gVar = null;
                break;
            }
            gVar = it2.next();
            if ((gVar.f31016c != null) && !gVar.f31016c.k() && !gVar.a() && !this.f30963c.containsKey(gVar.f31015b)) {
                gVar.f31014a = System.currentTimeMillis();
                break;
            }
        }
        if (gVar != null) {
            gVar.a(str);
            this.f30963c.put(str, gVar);
        }
        return gVar;
    }

    public final g c(String str) {
        c.a(str);
        g gVar = (g) Collections.min(this.f30962b);
        if (gVar != null) {
            gVar.f31014a = System.currentTimeMillis();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            b(gVar);
            gVar.a(str);
            this.f30963c.put(str, gVar);
        }
        return gVar;
    }

    public final g d(String str) {
        c.a(str);
        g gVar = this.f30963c.get(str);
        if (gVar != null) {
            a(gVar, str);
        }
        return gVar;
    }

    public final boolean e(String str) {
        return this.f30963c.get(str) != null;
    }

    private static g a(g gVar, String str) {
        gVar.f31014a = System.currentTimeMillis();
        gVar.a(str);
        return gVar;
    }

    public final boolean a() {
        return this.f30962b.size() == this.f30961a;
    }

    private static void b(g gVar) {
        b bVar = gVar.f31016c;
        if (bVar != null) {
            bVar.a(false);
            bVar.e();
            bVar.a((b.a) null);
            bVar.f();
        }
        gVar.a();
        gVar.f31015b = "";
    }
}
