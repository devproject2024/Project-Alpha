package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MLVTransactionResponse extends IJRDataModel {
    @b(a = "response")
    private MLVTransactionListResponse response;

    public MLVTransactionResponse() {
        this((MLVTransactionListResponse) null, 1, (g) null);
    }

    public static /* synthetic */ MLVTransactionResponse copy$default(MLVTransactionResponse mLVTransactionResponse, MLVTransactionListResponse mLVTransactionListResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mLVTransactionListResponse = mLVTransactionResponse.response;
        }
        return mLVTransactionResponse.copy(mLVTransactionListResponse);
    }

    public final MLVTransactionListResponse component1() {
        return this.response;
    }

    public final MLVTransactionResponse copy(MLVTransactionListResponse mLVTransactionListResponse) {
        return new MLVTransactionResponse(mLVTransactionListResponse);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MLVTransactionResponse) && k.a((Object) this.response, (Object) ((MLVTransactionResponse) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        MLVTransactionListResponse mLVTransactionListResponse = this.response;
        if (mLVTransactionListResponse != null) {
            return mLVTransactionListResponse.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "MLVTransactionResponse(response=" + this.response + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLVTransactionResponse(MLVTransactionListResponse mLVTransactionListResponse, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : mLVTransactionListResponse);
    }

    public final MLVTransactionListResponse getResponse() {
        return this.response;
    }

    public final void setResponse(MLVTransactionListResponse mLVTransactionListResponse) {
        this.response = mLVTransactionListResponse;
    }

    public MLVTransactionResponse(MLVTransactionListResponse mLVTransactionListResponse) {
        this.response = mLVTransactionListResponse;
    }
}
