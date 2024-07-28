package net.one97.paytm.landingpage.leftNavigation.model;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public NetworkCustomError f52877a;

    /* renamed from: b  reason: collision with root package name */
    public IJRPaytmDataModel f52878b;

    /* renamed from: c  reason: collision with root package name */
    private int f52879c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f52879c == aVar.f52879c && k.a((Object) this.f52877a, (Object) aVar.f52877a) && k.a((Object) this.f52878b, (Object) aVar.f52878b);
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.f52879c).hashCode() * 31;
        NetworkCustomError networkCustomError = this.f52877a;
        int i2 = 0;
        int hashCode2 = (hashCode + (networkCustomError != null ? networkCustomError.hashCode() : 0)) * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.f52878b;
        if (iJRPaytmDataModel != null) {
            i2 = iJRPaytmDataModel.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "NetworkErrorLiveDataModel(errorCode=" + this.f52879c + ", error=" + this.f52877a + ", model=" + this.f52878b + ")";
    }

    public a(int i2, NetworkCustomError networkCustomError, IJRPaytmDataModel iJRPaytmDataModel) {
        this.f52879c = i2;
        this.f52877a = networkCustomError;
        this.f52878b = iJRPaytmDataModel;
    }
}
