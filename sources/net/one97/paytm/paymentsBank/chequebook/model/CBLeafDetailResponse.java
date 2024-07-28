package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CBLeafDetailResponse extends IJRPaytmDataModel {
    @b(a = "response")
    private List<ChequeDetail> chqList;

    public CBLeafDetailResponse() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ CBLeafDetailResponse copy$default(CBLeafDetailResponse cBLeafDetailResponse, List<ChequeDetail> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = cBLeafDetailResponse.chqList;
        }
        return cBLeafDetailResponse.copy(list);
    }

    public final List<ChequeDetail> component1() {
        return this.chqList;
    }

    public final CBLeafDetailResponse copy(List<ChequeDetail> list) {
        return new CBLeafDetailResponse(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CBLeafDetailResponse) && k.a((Object) this.chqList, (Object) ((CBLeafDetailResponse) obj).chqList);
        }
        return true;
    }

    public final int hashCode() {
        List<ChequeDetail> list = this.chqList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CBLeafDetailResponse(chqList=" + this.chqList + ")";
    }

    public CBLeafDetailResponse(List<ChequeDetail> list) {
        this.chqList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CBLeafDetailResponse(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<ChequeDetail> getChqList() {
        return this.chqList;
    }

    public final void setChqList(List<ChequeDetail> list) {
        this.chqList = list;
    }
}
