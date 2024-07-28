package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMyBillData extends IJRPaytmDataModel {
    @b(a = "billDetails")
    private final CJRMyBillDetails billDetails;
    @b(a = "error")
    private final CJRMyBillDataError error;
    @b(a = "statusCode")
    private final Integer statusCode;

    public CJRMyBillData() {
        this((Integer) null, (CJRMyBillDetails) null, (CJRMyBillDataError) null, 7, (g) null);
    }

    public static /* synthetic */ CJRMyBillData copy$default(CJRMyBillData cJRMyBillData, Integer num, CJRMyBillDetails cJRMyBillDetails, CJRMyBillDataError cJRMyBillDataError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRMyBillData.statusCode;
        }
        if ((i2 & 2) != 0) {
            cJRMyBillDetails = cJRMyBillData.billDetails;
        }
        if ((i2 & 4) != 0) {
            cJRMyBillDataError = cJRMyBillData.error;
        }
        return cJRMyBillData.copy(num, cJRMyBillDetails, cJRMyBillDataError);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final CJRMyBillDetails component2() {
        return this.billDetails;
    }

    public final CJRMyBillDataError component3() {
        return this.error;
    }

    public final CJRMyBillData copy(Integer num, CJRMyBillDetails cJRMyBillDetails, CJRMyBillDataError cJRMyBillDataError) {
        return new CJRMyBillData(num, cJRMyBillDetails, cJRMyBillDataError);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMyBillData)) {
            return false;
        }
        CJRMyBillData cJRMyBillData = (CJRMyBillData) obj;
        return k.a((Object) this.statusCode, (Object) cJRMyBillData.statusCode) && k.a((Object) this.billDetails, (Object) cJRMyBillData.billDetails) && k.a((Object) this.error, (Object) cJRMyBillData.error);
    }

    public final int hashCode() {
        Integer num = this.statusCode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        CJRMyBillDetails cJRMyBillDetails = this.billDetails;
        int hashCode2 = (hashCode + (cJRMyBillDetails != null ? cJRMyBillDetails.hashCode() : 0)) * 31;
        CJRMyBillDataError cJRMyBillDataError = this.error;
        if (cJRMyBillDataError != null) {
            i2 = cJRMyBillDataError.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRMyBillData(statusCode=" + this.statusCode + ", billDetails=" + this.billDetails + ", error=" + this.error + ")";
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final CJRMyBillDetails getBillDetails() {
        return this.billDetails;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMyBillData(Integer num, CJRMyBillDetails cJRMyBillDetails, CJRMyBillDataError cJRMyBillDataError, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : cJRMyBillDetails, (i2 & 4) != 0 ? null : cJRMyBillDataError);
    }

    public final CJRMyBillDataError getError() {
        return this.error;
    }

    public CJRMyBillData(Integer num, CJRMyBillDetails cJRMyBillDetails, CJRMyBillDataError cJRMyBillDataError) {
        this.statusCode = num;
        this.billDetails = cJRMyBillDetails;
        this.error = cJRMyBillDataError;
    }
}
