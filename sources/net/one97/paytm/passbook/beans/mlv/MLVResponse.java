package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MLVResponse {
    @b(a = "paginator")
    private MLVPaginator paginator;
    @b(a = "result")
    private Result result;
    @b(a = "userCardDetails")
    private ArrayList<MLVUserCardDetail> userCardDetails;

    public static /* synthetic */ MLVResponse copy$default(MLVResponse mLVResponse, Result result2, ArrayList<MLVUserCardDetail> arrayList, MLVPaginator mLVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            result2 = mLVResponse.result;
        }
        if ((i2 & 2) != 0) {
            arrayList = mLVResponse.userCardDetails;
        }
        if ((i2 & 4) != 0) {
            mLVPaginator = mLVResponse.paginator;
        }
        return mLVResponse.copy(result2, arrayList, mLVPaginator);
    }

    public final Result component1() {
        return this.result;
    }

    public final ArrayList<MLVUserCardDetail> component2() {
        return this.userCardDetails;
    }

    public final MLVPaginator component3() {
        return this.paginator;
    }

    public final MLVResponse copy(Result result2, ArrayList<MLVUserCardDetail> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userCardDetails");
        return new MLVResponse(result2, arrayList, mLVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLVResponse)) {
            return false;
        }
        MLVResponse mLVResponse = (MLVResponse) obj;
        return k.a((Object) this.result, (Object) mLVResponse.result) && k.a((Object) this.userCardDetails, (Object) mLVResponse.userCardDetails) && k.a((Object) this.paginator, (Object) mLVResponse.paginator);
    }

    public final int hashCode() {
        Result result2 = this.result;
        int i2 = 0;
        int hashCode = (result2 != null ? result2.hashCode() : 0) * 31;
        ArrayList<MLVUserCardDetail> arrayList = this.userCardDetails;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        MLVPaginator mLVPaginator = this.paginator;
        if (mLVPaginator != null) {
            i2 = mLVPaginator.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MLVResponse(result=" + this.result + ", userCardDetails=" + this.userCardDetails + ", paginator=" + this.paginator + ")";
    }

    public MLVResponse(Result result2, ArrayList<MLVUserCardDetail> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userCardDetails");
        this.result = result2;
        this.userCardDetails = arrayList;
        this.paginator = mLVPaginator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLVResponse(Result result2, ArrayList arrayList, MLVPaginator mLVPaginator, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : result2, arrayList, mLVPaginator);
    }

    public final Result getResult() {
        return this.result;
    }

    public final void setResult(Result result2) {
        this.result = result2;
    }

    public final ArrayList<MLVUserCardDetail> getUserCardDetails() {
        return this.userCardDetails;
    }

    public final void setUserCardDetails(ArrayList<MLVUserCardDetail> arrayList) {
        k.c(arrayList, "<set-?>");
        this.userCardDetails = arrayList;
    }

    public final MLVPaginator getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(MLVPaginator mLVPaginator) {
        this.paginator = mLVPaginator;
    }
}
