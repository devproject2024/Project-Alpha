package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class GVListData extends IJRDataModel {
    @b(a = "paginator")
    private MGVPaginator paginator;
    @b(a = "userCardDetails")
    private ArrayList<UserCardDetail> userCardDetails;

    public static /* synthetic */ GVListData copy$default(GVListData gVListData, ArrayList<UserCardDetail> arrayList, MGVPaginator mGVPaginator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = gVListData.userCardDetails;
        }
        if ((i2 & 2) != 0) {
            mGVPaginator = gVListData.paginator;
        }
        return gVListData.copy(arrayList, mGVPaginator);
    }

    public final ArrayList<UserCardDetail> component1() {
        return this.userCardDetails;
    }

    public final MGVPaginator component2() {
        return this.paginator;
    }

    public final GVListData copy(ArrayList<UserCardDetail> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "userCardDetails");
        k.c(mGVPaginator, "paginator");
        return new GVListData(arrayList, mGVPaginator);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GVListData)) {
            return false;
        }
        GVListData gVListData = (GVListData) obj;
        return k.a((Object) this.userCardDetails, (Object) gVListData.userCardDetails) && k.a((Object) this.paginator, (Object) gVListData.paginator);
    }

    public final int hashCode() {
        ArrayList<UserCardDetail> arrayList = this.userCardDetails;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        MGVPaginator mGVPaginator = this.paginator;
        if (mGVPaginator != null) {
            i2 = mGVPaginator.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "GVListData(userCardDetails=" + this.userCardDetails + ", paginator=" + this.paginator + ")";
    }

    public final ArrayList<UserCardDetail> getUserCardDetails() {
        return this.userCardDetails;
    }

    public final void setUserCardDetails(ArrayList<UserCardDetail> arrayList) {
        k.c(arrayList, "<set-?>");
        this.userCardDetails = arrayList;
    }

    public GVListData(ArrayList<UserCardDetail> arrayList, MGVPaginator mGVPaginator) {
        k.c(arrayList, "userCardDetails");
        k.c(mGVPaginator, "paginator");
        this.userCardDetails = arrayList;
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
