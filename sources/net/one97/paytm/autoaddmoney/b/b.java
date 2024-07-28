package net.one97.paytm.autoaddmoney.b;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f49151a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49152b;

    /* renamed from: c  reason: collision with root package name */
    public final IJRDataModel f49153c;

    /* renamed from: d  reason: collision with root package name */
    private final String f49154d;

    /* renamed from: e  reason: collision with root package name */
    private final String f49155e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f49151a, (Object) bVar.f49151a) && k.a((Object) this.f49152b, (Object) bVar.f49152b) && k.a((Object) this.f49154d, (Object) bVar.f49154d) && k.a((Object) this.f49155e, (Object) bVar.f49155e) && k.a((Object) this.f49153c, (Object) bVar.f49153c);
    }

    public final int hashCode() {
        String str = this.f49151a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f49152b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f49154d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f49155e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        IJRDataModel iJRDataModel = this.f49153c;
        if (iJRDataModel != null) {
            i2 = iJRDataModel.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CardLinkedErrorWrapper(status=" + this.f49151a + ", message=" + this.f49152b + ", minAmount=" + this.f49154d + ", AutoAmaunt=" + this.f49155e + ", cardModel=" + this.f49153c + ")";
    }

    public b(String str, String str2, String str3, String str4, IJRDataModel iJRDataModel) {
        this.f49151a = str;
        this.f49152b = str2;
        this.f49154d = str3;
        this.f49155e = str4;
        this.f49153c = iJRDataModel;
    }
}
