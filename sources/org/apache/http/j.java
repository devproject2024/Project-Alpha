package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import org.apache.http.e.c;

public final class j implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected final String f72513a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f72514b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f72515c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f72516d;

    /* renamed from: e  reason: collision with root package name */
    protected final InetAddress f72517e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f72514b.equals(jVar.f72514b) && this.f72515c == jVar.f72515c && this.f72516d.equals(jVar.f72516d)) {
                InetAddress inetAddress = this.f72517e;
                InetAddress inetAddress2 = jVar.f72517e;
                return inetAddress != null ? inetAddress.equals(inetAddress2) : inetAddress2 == null;
            }
        }
    }

    public final int hashCode() {
        int a2 = c.a((c.a(17, this.f72514b) * 37) + this.f72515c, this.f72516d);
        InetAddress inetAddress = this.f72517e;
        return inetAddress != null ? c.a(a2, inetAddress) : a2;
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f72516d);
        sb.append("://");
        sb.append(this.f72513a);
        if (this.f72515c != -1) {
            sb.append(':');
            sb.append(Integer.toString(this.f72515c));
        }
        return sb.toString();
    }
}
