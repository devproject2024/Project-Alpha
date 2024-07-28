package org.apache.http;

import java.io.Serializable;
import org.apache.http.e.a;

public class q implements Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    protected final String f72521d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f72522e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f72523f;

    public q(String str, int i2, int i3) {
        this.f72521d = (String) a.a(str, "Protocol name");
        this.f72522e = a.a(i2, "Protocol minor version");
        this.f72523f = a.a(i3, "Protocol minor version");
    }

    public final String a() {
        return this.f72521d;
    }

    public final int b() {
        return this.f72522e;
    }

    public final int c() {
        return this.f72523f;
    }

    public final int hashCode() {
        return (this.f72521d.hashCode() ^ (this.f72522e * 100000)) ^ this.f72523f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f72521d.equals(qVar.f72521d) && this.f72522e == qVar.f72522e && this.f72523f == qVar.f72523f;
    }

    public String toString() {
        return this.f72521d + '/' + Integer.toString(this.f72522e) + '.' + Integer.toString(this.f72523f);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
