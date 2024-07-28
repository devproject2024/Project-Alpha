package org.apache.http.b;

import org.apache.http.e.a;
import org.apache.http.e.b;
import org.apache.http.q;

public final class d {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final d f72499a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final d f72500b = new d();

    static b a() {
        return new b();
    }

    static int a(q qVar) {
        return qVar.a().length() + 4;
    }

    public static b a(org.apache.http.b bVar) {
        a.a(bVar, "Header");
        b bVar2 = new b();
        String a2 = bVar.a();
        String b2 = bVar.b();
        int length = a2.length() + 2;
        if (b2 != null) {
            length += b2.length();
        }
        bVar2.a(length);
        bVar2.a(a2);
        bVar2.a(": ");
        if (b2 != null) {
            bVar2.a(bVar2.length() + b2.length());
            for (int i2 = 0; i2 < b2.length(); i2++) {
                char charAt = b2.charAt(i2);
                if (charAt == 13 || charAt == 10 || charAt == 12 || charAt == 11) {
                    charAt = ' ';
                }
                bVar2.a(charAt);
            }
        }
        return bVar2;
    }
}
