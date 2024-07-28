package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a;

import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final Integer f17846a;

    /* renamed from: b  reason: collision with root package name */
    final String f17847b;

    /* renamed from: c  reason: collision with root package name */
    final String f17848c;

    /* renamed from: d  reason: collision with root package name */
    boolean f17849d = false;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (k.a((Object) this.f17846a, (Object) dVar.f17846a) && k.a((Object) this.f17847b, (Object) dVar.f17847b) && k.a((Object) this.f17848c, (Object) dVar.f17848c)) {
                    if (this.f17849d == dVar.f17849d) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Integer num = this.f17846a;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.f17847b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17848c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f17849d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "ItemSelectionModel(id=" + this.f17846a + ", type=" + this.f17847b + ", name=" + this.f17848c + ", selected=" + this.f17849d + ")";
    }

    public d(Integer num, String str, String str2) {
        this.f17846a = num;
        this.f17847b = str;
        this.f17848c = str2;
    }
}
