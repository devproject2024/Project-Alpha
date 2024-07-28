package org.apache.http.b;

import java.io.Serializable;
import org.apache.http.c;
import org.apache.http.e.a;

public final class b implements Serializable, Cloneable, org.apache.http.b {

    /* renamed from: a  reason: collision with root package name */
    private static final c[] f72489a = new c[0];

    /* renamed from: b  reason: collision with root package name */
    private final String f72490b;

    /* renamed from: c  reason: collision with root package name */
    private final String f72491c;

    public b(String str, String str2) {
        this.f72490b = (String) a.a(str, "Name");
        this.f72491c = str2;
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String a() {
        return this.f72490b;
    }

    public final String b() {
        return this.f72491c;
    }

    public final String toString() {
        d dVar = d.f72500b;
        return d.a((org.apache.http.b) this).toString();
    }
}
