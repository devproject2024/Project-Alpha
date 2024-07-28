package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;

public final class KycBankInfoModel {
    public final Results results;
    public final String status;
    public final String statusCode;
    public final String statusMessage;

    public static /* synthetic */ KycBankInfoModel copy$default(KycBankInfoModel kycBankInfoModel, Results results2, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            results2 = kycBankInfoModel.results;
        }
        if ((i2 & 2) != 0) {
            str = kycBankInfoModel.status;
        }
        if ((i2 & 4) != 0) {
            str2 = kycBankInfoModel.statusCode;
        }
        if ((i2 & 8) != 0) {
            str3 = kycBankInfoModel.statusMessage;
        }
        return kycBankInfoModel.copy(results2, str, str2, str3);
    }

    public final Results component1() {
        return this.results;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.statusCode;
    }

    public final String component4() {
        return this.statusMessage;
    }

    public final KycBankInfoModel copy(Results results2, String str, String str2, String str3) {
        k.d(results2, "results");
        k.d(str, "status");
        k.d(str2, "statusCode");
        k.d(str3, "statusMessage");
        return new KycBankInfoModel(results2, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KycBankInfoModel)) {
            return false;
        }
        KycBankInfoModel kycBankInfoModel = (KycBankInfoModel) obj;
        return k.a((Object) this.results, (Object) kycBankInfoModel.results) && k.a((Object) this.status, (Object) kycBankInfoModel.status) && k.a((Object) this.statusCode, (Object) kycBankInfoModel.statusCode) && k.a((Object) this.statusMessage, (Object) kycBankInfoModel.statusMessage);
    }

    public final int hashCode() {
        Results results2 = this.results;
        int i2 = 0;
        int hashCode = (results2 != null ? results2.hashCode() : 0) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.statusCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "KycBankInfoModel(results=" + this.results + ", status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ")";
    }

    public KycBankInfoModel(Results results2, String str, String str2, String str3) {
        k.d(results2, "results");
        k.d(str, "status");
        k.d(str2, "statusCode");
        k.d(str3, "statusMessage");
        this.results = results2;
        this.status = str;
        this.statusCode = str2;
        this.statusMessage = str3;
    }

    public final Results getResults() {
        return this.results;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }
}
