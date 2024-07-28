package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;

public final class PaytmResultInfo {
    public final String messaage;
    public final String resultCode;
    public final String resultStatus;

    public static /* synthetic */ PaytmResultInfo copy$default(PaytmResultInfo paytmResultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paytmResultInfo.messaage;
        }
        if ((i2 & 2) != 0) {
            str2 = paytmResultInfo.resultCode;
        }
        if ((i2 & 4) != 0) {
            str3 = paytmResultInfo.resultStatus;
        }
        return paytmResultInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.messaage;
    }

    public final String component2() {
        return this.resultCode;
    }

    public final String component3() {
        return this.resultStatus;
    }

    public final PaytmResultInfo copy(String str, String str2, String str3) {
        k.d(str, "messaage");
        k.d(str2, "resultCode");
        k.d(str3, "resultStatus");
        return new PaytmResultInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaytmResultInfo)) {
            return false;
        }
        PaytmResultInfo paytmResultInfo = (PaytmResultInfo) obj;
        return k.a((Object) this.messaage, (Object) paytmResultInfo.messaage) && k.a((Object) this.resultCode, (Object) paytmResultInfo.resultCode) && k.a((Object) this.resultStatus, (Object) paytmResultInfo.resultStatus);
    }

    public final int hashCode() {
        String str = this.messaage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultStatus;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PaytmResultInfo(messaage=" + this.messaage + ", resultCode=" + this.resultCode + ", resultStatus=" + this.resultStatus + ")";
    }

    public PaytmResultInfo(String str, String str2, String str3) {
        k.d(str, "messaage");
        k.d(str2, "resultCode");
        k.d(str3, "resultStatus");
        this.messaage = str;
        this.resultCode = str2;
        this.resultStatus = str3;
    }

    public final String getMessaage() {
        return this.messaage;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }
}
