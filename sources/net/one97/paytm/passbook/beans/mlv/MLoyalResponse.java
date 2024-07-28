package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MLoyalResponse extends IJRDataModel {
    @b(a = "merchantList")
    private ArrayList<MerchantItem> merchantList;
    @b(a = "status")
    private MLoyalResponseStatus status;

    public MLoyalResponse() {
        this((ArrayList) null, (MLoyalResponseStatus) null, 3, (g) null);
    }

    public static /* synthetic */ MLoyalResponse copy$default(MLoyalResponse mLoyalResponse, ArrayList<MerchantItem> arrayList, MLoyalResponseStatus mLoyalResponseStatus, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = mLoyalResponse.merchantList;
        }
        if ((i2 & 2) != 0) {
            mLoyalResponseStatus = mLoyalResponse.status;
        }
        return mLoyalResponse.copy(arrayList, mLoyalResponseStatus);
    }

    public final ArrayList<MerchantItem> component1() {
        return this.merchantList;
    }

    public final MLoyalResponseStatus component2() {
        return this.status;
    }

    public final MLoyalResponse copy(ArrayList<MerchantItem> arrayList, MLoyalResponseStatus mLoyalResponseStatus) {
        return new MLoyalResponse(arrayList, mLoyalResponseStatus);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLoyalResponse)) {
            return false;
        }
        MLoyalResponse mLoyalResponse = (MLoyalResponse) obj;
        return k.a((Object) this.merchantList, (Object) mLoyalResponse.merchantList) && k.a((Object) this.status, (Object) mLoyalResponse.status);
    }

    public final int hashCode() {
        ArrayList<MerchantItem> arrayList = this.merchantList;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        MLoyalResponseStatus mLoyalResponseStatus = this.status;
        if (mLoyalResponseStatus != null) {
            i2 = mLoyalResponseStatus.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MLoyalResponse(merchantList=" + this.merchantList + ", status=" + this.status + ")";
    }

    public final ArrayList<MerchantItem> getMerchantList() {
        return this.merchantList;
    }

    public final void setMerchantList(ArrayList<MerchantItem> arrayList) {
        this.merchantList = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLoyalResponse(ArrayList arrayList, MLoyalResponseStatus mLoyalResponseStatus, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : mLoyalResponseStatus);
    }

    public final MLoyalResponseStatus getStatus() {
        return this.status;
    }

    public final void setStatus(MLoyalResponseStatus mLoyalResponseStatus) {
        this.status = mLoyalResponseStatus;
    }

    public MLoyalResponse(ArrayList<MerchantItem> arrayList, MLoyalResponseStatus mLoyalResponseStatus) {
        this.merchantList = arrayList;
        this.status = mLoyalResponseStatus;
    }
}
