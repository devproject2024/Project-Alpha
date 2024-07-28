package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Response {
    @b(a = "paginator")
    private MLVPaginator paginator;
    @b(a = "result")
    private Result result;
    @b(a = "userTemplateDetails")
    private ArrayList<UserMLVTemplateDetail> userTemplateDetails;

    public static /* synthetic */ Response copy$default(Response response, Result result2, ArrayList<UserMLVTemplateDetail> arrayList, MLVPaginator mLVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            result2 = response.result;
        }
        if ((i2 & 2) != 0) {
            arrayList = response.userTemplateDetails;
        }
        if ((i2 & 4) != 0) {
            mLVPaginator = response.paginator;
        }
        return response.copy(result2, arrayList, mLVPaginator);
    }

    public final Result component1() {
        return this.result;
    }

    public final ArrayList<UserMLVTemplateDetail> component2() {
        return this.userTemplateDetails;
    }

    public final MLVPaginator component3() {
        return this.paginator;
    }

    public final Response copy(Result result2, ArrayList<UserMLVTemplateDetail> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userTemplateDetails");
        return new Response(result2, arrayList, mLVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return k.a((Object) this.result, (Object) response.result) && k.a((Object) this.userTemplateDetails, (Object) response.userTemplateDetails) && k.a((Object) this.paginator, (Object) response.paginator);
    }

    public final int hashCode() {
        Result result2 = this.result;
        int i2 = 0;
        int hashCode = (result2 != null ? result2.hashCode() : 0) * 31;
        ArrayList<UserMLVTemplateDetail> arrayList = this.userTemplateDetails;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        MLVPaginator mLVPaginator = this.paginator;
        if (mLVPaginator != null) {
            i2 = mLVPaginator.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Response(result=" + this.result + ", userTemplateDetails=" + this.userTemplateDetails + ", paginator=" + this.paginator + ")";
    }

    public Response(Result result2, ArrayList<UserMLVTemplateDetail> arrayList, MLVPaginator mLVPaginator) {
        k.c(arrayList, "userTemplateDetails");
        this.result = result2;
        this.userTemplateDetails = arrayList;
        this.paginator = mLVPaginator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Response(Result result2, ArrayList arrayList, MLVPaginator mLVPaginator, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : result2, arrayList, mLVPaginator);
    }

    public final Result getResult() {
        return this.result;
    }

    public final void setResult(Result result2) {
        this.result = result2;
    }

    public final ArrayList<UserMLVTemplateDetail> getUserTemplateDetails() {
        return this.userTemplateDetails;
    }

    public final void setUserTemplateDetails(ArrayList<UserMLVTemplateDetail> arrayList) {
        k.c(arrayList, "<set-?>");
        this.userTemplateDetails = arrayList;
    }

    public final MLVPaginator getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(MLVPaginator mLVPaginator) {
        this.paginator = mLVPaginator;
    }
}
