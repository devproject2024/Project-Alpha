package net.one97.paytm.appManager.storage.db;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    Integer f49067a;
    @b(a = "key")

    /* renamed from: b  reason: collision with root package name */
    public String f49068b;
    @b(a = "value")

    /* renamed from: c  reason: collision with root package name */
    public String f49069c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f49067a, (Object) cVar.f49067a) && k.a((Object) this.f49068b, (Object) cVar.f49068b) && k.a((Object) this.f49069c, (Object) cVar.f49069c);
    }

    public final int hashCode() {
        Integer num = this.f49067a;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.f49068b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f49069c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ItemTable(id=" + this.f49067a + ", keyValue=" + this.f49068b + ", value=" + this.f49069c + ")";
    }

    public c(Integer num, String str, String str2) {
        k.c(str, "keyValue");
        k.c(str2, "value");
        this.f49067a = num;
        this.f49068b = str;
        this.f49069c = str2;
    }
}
