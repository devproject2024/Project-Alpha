package net.one97.paytm.autoaddmoney.b;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final IJRDataModel f49156a;

    /* renamed from: b  reason: collision with root package name */
    private final String f49157b;

    /* renamed from: c  reason: collision with root package name */
    private final String f49158c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f49157b, (Object) cVar.f49157b) && k.a((Object) this.f49158c, (Object) cVar.f49158c) && k.a((Object) this.f49156a, (Object) cVar.f49156a);
    }

    public final int hashCode() {
        String str = this.f49157b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f49158c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        IJRDataModel iJRDataModel = this.f49156a;
        if (iJRDataModel != null) {
            i2 = iJRDataModel.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CardSucessChangedWrapper(minAmount=" + this.f49157b + ", autoAmount=" + this.f49158c + ", card=" + this.f49156a + ")";
    }

    public c(String str, String str2, IJRDataModel iJRDataModel) {
        this.f49157b = str;
        this.f49158c = str2;
        this.f49156a = iJRDataModel;
    }
}
