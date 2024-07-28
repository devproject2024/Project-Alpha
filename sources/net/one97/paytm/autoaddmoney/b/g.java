package net.one97.paytm.autoaddmoney.b;

import kotlin.g.b.k;
import net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd;
import net.one97.paytm.common.entity.IJRDataModel;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final CJRSubscribeAutoAdd f49166a;

    /* renamed from: b  reason: collision with root package name */
    public final IJRDataModel f49167b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.a((Object) this.f49166a, (Object) gVar.f49166a) && k.a((Object) this.f49167b, (Object) gVar.f49167b);
    }

    public final int hashCode() {
        CJRSubscribeAutoAdd cJRSubscribeAutoAdd = this.f49166a;
        int i2 = 0;
        int hashCode = (cJRSubscribeAutoAdd != null ? cJRSubscribeAutoAdd.hashCode() : 0) * 31;
        IJRDataModel iJRDataModel = this.f49167b;
        if (iJRDataModel != null) {
            i2 = iJRDataModel.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SubscriptionWrapper(cjrSubscribeAutoAdd=" + this.f49166a + ", subscribeCard=" + this.f49167b + ")";
    }

    public g(CJRSubscribeAutoAdd cJRSubscribeAutoAdd, IJRDataModel iJRDataModel) {
        this.f49166a = cJRSubscribeAutoAdd;
        this.f49167b = iJRDataModel;
    }
}
