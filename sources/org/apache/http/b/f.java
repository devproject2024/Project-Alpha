package org.apache.http.b;

import java.io.Serializable;
import org.apache.http.e.a;
import org.apache.http.e.b;
import org.apache.http.q;
import org.apache.http.t;

public final class f implements Serializable, Cloneable, t {

    /* renamed from: a  reason: collision with root package name */
    private final q f72505a;

    /* renamed from: b  reason: collision with root package name */
    private final int f72506b;

    /* renamed from: c  reason: collision with root package name */
    private final String f72507c;

    public f(q qVar, int i2, String str) {
        this.f72505a = (q) a.a(qVar, "Version");
        this.f72506b = a.a(i2, "Status code");
        this.f72507c = str;
    }

    public final int b() {
        return this.f72506b;
    }

    public final q a() {
        return this.f72505a;
    }

    public final String c() {
        return this.f72507c;
    }

    public final String toString() {
        d dVar = d.f72500b;
        a.a(this, "Status line");
        b a2 = d.a();
        int a3 = d.a(a()) + 1 + 3 + 1;
        String c2 = c();
        if (c2 != null) {
            a3 += c2.length();
        }
        a2.a(a3);
        q a4 = a();
        a.a(a4, "Protocol version");
        a2.a(d.a(a4));
        a2.a(a4.a());
        a2.a('/');
        a2.a(Integer.toString(a4.b()));
        a2.a('.');
        a2.a(Integer.toString(a4.c()));
        a2.a(' ');
        a2.a(Integer.toString(b()));
        a2.a(' ');
        if (c2 != null) {
            a2.a(c2);
        }
        return a2.toString();
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
