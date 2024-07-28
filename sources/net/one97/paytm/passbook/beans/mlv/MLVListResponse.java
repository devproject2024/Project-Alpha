package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MLVListResponse extends IJRDataModel {
    @b(a = "response")
    private MLVResponse response;

    public MLVListResponse() {
        this((MLVResponse) null, 1, (g) null);
    }

    public static /* synthetic */ MLVListResponse copy$default(MLVListResponse mLVListResponse, MLVResponse mLVResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mLVResponse = mLVListResponse.response;
        }
        return mLVListResponse.copy(mLVResponse);
    }

    public final MLVResponse component1() {
        return this.response;
    }

    public final MLVListResponse copy(MLVResponse mLVResponse) {
        return new MLVListResponse(mLVResponse);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MLVListResponse) && k.a((Object) this.response, (Object) ((MLVListResponse) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        MLVResponse mLVResponse = this.response;
        if (mLVResponse != null) {
            return mLVResponse.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "MLVListResponse(response=" + this.response + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLVListResponse(MLVResponse mLVResponse, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : mLVResponse);
    }

    public final MLVResponse getResponse() {
        return this.response;
    }

    public final void setResponse(MLVResponse mLVResponse) {
        this.response = mLVResponse;
    }

    public MLVListResponse(MLVResponse mLVResponse) {
        this.response = mLVResponse;
    }
}
