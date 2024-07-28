package com.paytm.android.chat.view;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.k;

public final class d {
    @b(a = "title")

    /* renamed from: a  reason: collision with root package name */
    public final String f42567a;
    @b(a = "icon")

    /* renamed from: b  reason: collision with root package name */
    public final String f42568b;
    @b(a = "deeplink")

    /* renamed from: c  reason: collision with root package name */
    public final String f42569c;
    @b(a = "items")

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f42570d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a((Object) this.f42567a, (Object) dVar.f42567a) && k.a((Object) this.f42568b, (Object) dVar.f42568b) && k.a((Object) this.f42569c, (Object) dVar.f42569c) && k.a((Object) this.f42570d, (Object) dVar.f42570d);
    }

    public final int hashCode() {
        String str = this.f42567a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f42568b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f42569c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<d> list = this.f42570d;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MenuItem(title=" + this.f42567a + ", icon=" + this.f42568b + ", deeplink=" + this.f42569c + ", items=" + this.f42570d + ")";
    }
}
