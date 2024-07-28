package net.one97.paytm.acceptPayment.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ForceUpdateResponseModel extends IJRPaytmDataModel {
    private Result results;
    private String status;
    private String statusCode;

    public ForceUpdateResponseModel() {
        this((String) null, (String) null, (Result) null, 7, (g) null);
    }

    public static /* synthetic */ ForceUpdateResponseModel copy$default(ForceUpdateResponseModel forceUpdateResponseModel, String str, String str2, Result result, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = forceUpdateResponseModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = forceUpdateResponseModel.statusCode;
        }
        if ((i2 & 4) != 0) {
            result = forceUpdateResponseModel.results;
        }
        return forceUpdateResponseModel.copy(str, str2, result);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final Result component3() {
        return this.results;
    }

    public final ForceUpdateResponseModel copy(String str, String str2, Result result) {
        return new ForceUpdateResponseModel(str, str2, result);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForceUpdateResponseModel)) {
            return false;
        }
        ForceUpdateResponseModel forceUpdateResponseModel = (ForceUpdateResponseModel) obj;
        return k.a((Object) this.status, (Object) forceUpdateResponseModel.status) && k.a((Object) this.statusCode, (Object) forceUpdateResponseModel.statusCode) && k.a((Object) this.results, (Object) forceUpdateResponseModel.results);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Result result = this.results;
        if (result != null) {
            i2 = result.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ForceUpdateResponseModel(status=" + this.status + ", statusCode=" + this.statusCode + ", results=" + this.results + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public ForceUpdateResponseModel(String str, String str2, Result result) {
        this.status = str;
        this.statusCode = str2;
        this.results = result;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ForceUpdateResponseModel(String str, String str2, Result result, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : result);
    }

    public final Result getResults() {
        return this.results;
    }

    public final void setResults(Result result) {
        this.results = result;
    }
}
