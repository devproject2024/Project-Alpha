package org.parceler;

import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35791a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f35792b = new ArrayList();

    public a() {
        a((Object) null);
    }

    public final boolean a(int i2) {
        return i2 < this.f35792b.size();
    }

    public final boolean b(int i2) {
        return this.f35792b.get(i2) == f35791a;
    }

    public final void a(int i2, Object obj) {
        if (this.f35792b.size() > i2) {
            this.f35792b.remove(i2);
        }
        this.f35792b.add(i2, obj);
    }

    public final int a(Object obj) {
        this.f35792b.add(obj);
        return this.f35792b.size() - 1;
    }

    public final <T> T c(int i2) {
        return this.f35792b.get(i2);
    }

    public final int b(Object obj) {
        for (int i2 = 0; i2 < this.f35792b.size(); i2++) {
            if (this.f35792b.get(i2) == obj) {
                return i2;
            }
        }
        return -1;
    }
}
