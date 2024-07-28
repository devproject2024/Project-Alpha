package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class Data extends IJRDataModel {
    @b(a = "paginator")
    private MGVPaginator paginator;
    @b(a = "userTemplateDetails")
    private ArrayList<UserTemplateDetail> userTemplateDetails;

    public static /* synthetic */ Data copy$default(Data data, ArrayList<UserTemplateDetail> arrayList, MGVPaginator mGVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = data.userTemplateDetails;
        }
        if ((i2 & 2) != 0) {
            mGVPaginator = data.paginator;
        }
        return data.copy(arrayList, mGVPaginator);
    }

    public final ArrayList<UserTemplateDetail> component1() {
        return this.userTemplateDetails;
    }

    public final MGVPaginator component2() {
        return this.paginator;
    }

    public final Data copy(ArrayList<UserTemplateDetail> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "userTemplateDetails");
        k.c(mGVPaginator, "paginator");
        return new Data(arrayList, mGVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return k.a((Object) this.userTemplateDetails, (Object) data.userTemplateDetails) && k.a((Object) this.paginator, (Object) data.paginator);
    }

    public final int hashCode() {
        ArrayList<UserTemplateDetail> arrayList = this.userTemplateDetails;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        MGVPaginator mGVPaginator = this.paginator;
        if (mGVPaginator != null) {
            i2 = mGVPaginator.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Data(userTemplateDetails=" + this.userTemplateDetails + ", paginator=" + this.paginator + ")";
    }

    public final ArrayList<UserTemplateDetail> getUserTemplateDetails() {
        return this.userTemplateDetails;
    }

    public final void setUserTemplateDetails(ArrayList<UserTemplateDetail> arrayList) {
        k.c(arrayList, "<set-?>");
        this.userTemplateDetails = arrayList;
    }

    public Data(ArrayList<UserTemplateDetail> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "userTemplateDetails");
        k.c(mGVPaginator, "paginator");
        this.userTemplateDetails = arrayList;
        this.paginator = mGVPaginator;
    }

    public final MGVPaginator getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(MGVPaginator mGVPaginator) {
        k.c(mGVPaginator, "<set-?>");
        this.paginator = mGVPaginator;
    }
}
