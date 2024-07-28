package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRGetUserConsentApiResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private final CJRGetBillData data;
    @b(a = "status")
    private final Integer status;

    public CJRGetUserConsentApiResponse() {
        this((Integer) null, (CJRGetBillData) null, 3, (g) null);
    }

    public static /* synthetic */ CJRGetUserConsentApiResponse copy$default(CJRGetUserConsentApiResponse cJRGetUserConsentApiResponse, Integer num, CJRGetBillData cJRGetBillData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRGetUserConsentApiResponse.status;
        }
        if ((i2 & 2) != 0) {
            cJRGetBillData = cJRGetUserConsentApiResponse.data;
        }
        return cJRGetUserConsentApiResponse.copy(num, cJRGetBillData);
    }

    public final Integer component1() {
        return this.status;
    }

    public final CJRGetBillData component2() {
        return this.data;
    }

    public final CJRGetUserConsentApiResponse copy(Integer num, CJRGetBillData cJRGetBillData) {
        return new CJRGetUserConsentApiResponse(num, cJRGetBillData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRGetUserConsentApiResponse)) {
            return false;
        }
        CJRGetUserConsentApiResponse cJRGetUserConsentApiResponse = (CJRGetUserConsentApiResponse) obj;
        return k.a((Object) this.status, (Object) cJRGetUserConsentApiResponse.status) && k.a((Object) this.data, (Object) cJRGetUserConsentApiResponse.data);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        CJRGetBillData cJRGetBillData = this.data;
        if (cJRGetBillData != null) {
            i2 = cJRGetBillData.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRGetUserConsentApiResponse(status=" + this.status + ", data=" + this.data + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRGetUserConsentApiResponse(Integer num, CJRGetBillData cJRGetBillData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : cJRGetBillData);
    }

    public final CJRGetBillData getData() {
        return this.data;
    }

    public CJRGetUserConsentApiResponse(Integer num, CJRGetBillData cJRGetBillData) {
        this.status = num;
        this.data = cJRGetBillData;
    }
}
