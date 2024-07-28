package net.one97.paytm.o2o.movies.common;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class f extends Throwable {
    private final IJRPaytmDataModel dataModel;
    private final NetworkCustomError error;
    private final int errorCode;

    public f() {
        this(0, (IJRPaytmDataModel) null, (NetworkCustomError) null, 7, (g) null);
    }

    public static /* synthetic */ f copy$default(f fVar, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = fVar.errorCode;
        }
        if ((i3 & 2) != 0) {
            iJRPaytmDataModel = fVar.dataModel;
        }
        if ((i3 & 4) != 0) {
            networkCustomError = fVar.error;
        }
        return fVar.copy(i2, iJRPaytmDataModel, networkCustomError);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final IJRPaytmDataModel component2() {
        return this.dataModel;
    }

    public final NetworkCustomError component3() {
        return this.error;
    }

    public final f copy(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        return new f(i2, iJRPaytmDataModel, networkCustomError);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.errorCode == fVar.errorCode && k.a((Object) this.dataModel, (Object) fVar.dataModel) && k.a((Object) this.error, (Object) fVar.error);
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.errorCode).hashCode() * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.dataModel;
        int i2 = 0;
        int hashCode2 = (hashCode + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.error;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PaytmNetworkError(errorCode=" + this.errorCode + ", dataModel=" + this.dataModel + ", error=" + this.error + ")";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final IJRPaytmDataModel getDataModel() {
        return this.dataModel;
    }

    public f(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.errorCode = i2;
        this.dataModel = iJRPaytmDataModel;
        this.error = networkCustomError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, int i3, g gVar) {
        this((i3 & 1) != 0 ? -1 : i2, (i3 & 2) != 0 ? null : iJRPaytmDataModel, (i3 & 4) != 0 ? null : networkCustomError);
    }

    public final NetworkCustomError getError() {
        return this.error;
    }
}
