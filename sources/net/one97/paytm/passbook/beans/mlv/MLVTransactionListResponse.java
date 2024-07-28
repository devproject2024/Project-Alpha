package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MLVTransactionListResponse {
    @b(a = "paginator")
    private MLVPaginator paginator;
    @b(a = "result")
    private Result result;
    @b(a = "accountTransactionInfos")
    private ArrayList<MLVAccountTransactionInfo> userTransactionList;

    public static /* synthetic */ MLVTransactionListResponse copy$default(MLVTransactionListResponse mLVTransactionListResponse, Result result2, ArrayList<MLVAccountTransactionInfo> arrayList, MLVPaginator mLVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            result2 = mLVTransactionListResponse.result;
        }
        if ((i2 & 2) != 0) {
            arrayList = mLVTransactionListResponse.userTransactionList;
        }
        if ((i2 & 4) != 0) {
            mLVPaginator = mLVTransactionListResponse.paginator;
        }
        return mLVTransactionListResponse.copy(result2, arrayList, mLVPaginator);
    }

    public final Result component1() {
        return this.result;
    }

    public final ArrayList<MLVAccountTransactionInfo> component2() {
        return this.userTransactionList;
    }

    public final MLVPaginator component3() {
        return this.paginator;
    }

    public final MLVTransactionListResponse copy(Result result2, ArrayList<MLVAccountTransactionInfo> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userTransactionList");
        return new MLVTransactionListResponse(result2, arrayList, mLVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLVTransactionListResponse)) {
            return false;
        }
        MLVTransactionListResponse mLVTransactionListResponse = (MLVTransactionListResponse) obj;
        return k.a((Object) this.result, (Object) mLVTransactionListResponse.result) && k.a((Object) this.userTransactionList, (Object) mLVTransactionListResponse.userTransactionList) && k.a((Object) this.paginator, (Object) mLVTransactionListResponse.paginator);
    }

    public final int hashCode() {
        Result result2 = this.result;
        int i2 = 0;
        int hashCode = (result2 != null ? result2.hashCode() : 0) * 31;
        ArrayList<MLVAccountTransactionInfo> arrayList = this.userTransactionList;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        MLVPaginator mLVPaginator = this.paginator;
        if (mLVPaginator != null) {
            i2 = mLVPaginator.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MLVTransactionListResponse(result=" + this.result + ", userTransactionList=" + this.userTransactionList + ", paginator=" + this.paginator + ")";
    }

    public MLVTransactionListResponse(Result result2, ArrayList<MLVAccountTransactionInfo> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userTransactionList");
        this.result = result2;
        this.userTransactionList = arrayList;
        this.paginator = mLVPaginator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLVTransactionListResponse(Result result2, ArrayList arrayList, MLVPaginator mLVPaginator, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : result2, arrayList, mLVPaginator);
    }

    public final Result getResult() {
        return this.result;
    }

    public final void setResult(Result result2) {
        this.result = result2;
    }

    public final ArrayList<MLVAccountTransactionInfo> getUserTransactionList() {
        return this.userTransactionList;
    }

    public final void setUserTransactionList(ArrayList<MLVAccountTransactionInfo> arrayList) {
        k.c(arrayList, "<set-?>");
        this.userTransactionList = arrayList;
    }

    public final MLVPaginator getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(MLVPaginator mLVPaginator) {
        this.paginator = mLVPaginator;
    }
}
