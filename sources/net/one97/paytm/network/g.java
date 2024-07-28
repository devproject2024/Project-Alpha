package net.one97.paytm.network;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f55799a;

    /* renamed from: b  reason: collision with root package name */
    public IJRPaytmDataModel f55800b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f55801c;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!(this.f55799a == gVar.f55799a) || !k.a((Object) this.f55800b, (Object) gVar.f55800b) || !k.a((Object) this.f55801c, (Object) gVar.f55801c)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f55799a * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.f55800b;
        int i3 = 0;
        int hashCode = (i2 + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f55801c;
        if (networkCustomError != null) {
            i3 = networkCustomError.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "PaytmCommonError(statusCode=" + this.f55799a + ", ijrPaytmDataModel=" + this.f55800b + ", networkCustomError=" + this.f55801c + ")";
    }

    public g(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f55799a = i2;
        this.f55800b = iJRPaytmDataModel;
        this.f55801c = networkCustomError;
    }
}
