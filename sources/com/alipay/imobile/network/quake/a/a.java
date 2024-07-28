package com.alipay.imobile.network.quake.a;

public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final String f14714a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14715b;

    public a(String str, String str2) {
        this.f14714a = str;
        this.f14715b = str2;
    }

    private static int a(int i2, Object obj) {
        return (i2 * 37) + (obj != null ? obj.hashCode() : 0);
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f14714a.equals(aVar.f14714a)) {
                String str = this.f14715b;
                String str2 = aVar.f14715b;
                return str != null ? str.equals(str2) : str2 == null;
            }
        }
    }

    public final int hashCode() {
        return a(a(17, this.f14714a), this.f14715b);
    }

    public final String toString() {
        int length = this.f14714a.length();
        String str = this.f14715b;
        if (str != null) {
            length += str.length() + 1;
        }
        b bVar = new b(length);
        bVar.a(this.f14714a);
        if (this.f14715b != null) {
            bVar.a("=");
            bVar.a(this.f14715b);
        }
        return bVar.toString();
    }
}
