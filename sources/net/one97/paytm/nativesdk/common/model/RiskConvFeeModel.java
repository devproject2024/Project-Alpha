package net.one97.paytm.nativesdk.common.model;

import kotlin.g.b.k;

public final class RiskConvFeeModel {
    private String cardHash;
    private String cardType;
    private String convFee;

    public static /* synthetic */ RiskConvFeeModel copy$default(RiskConvFeeModel riskConvFeeModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = riskConvFeeModel.cardHash;
        }
        if ((i2 & 2) != 0) {
            str2 = riskConvFeeModel.convFee;
        }
        if ((i2 & 4) != 0) {
            str3 = riskConvFeeModel.cardType;
        }
        return riskConvFeeModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.cardHash;
    }

    public final String component2() {
        return this.convFee;
    }

    public final String component3() {
        return this.cardType;
    }

    public final RiskConvFeeModel copy(String str, String str2, String str3) {
        return new RiskConvFeeModel(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiskConvFeeModel)) {
            return false;
        }
        RiskConvFeeModel riskConvFeeModel = (RiskConvFeeModel) obj;
        return k.a((Object) this.cardHash, (Object) riskConvFeeModel.cardHash) && k.a((Object) this.convFee, (Object) riskConvFeeModel.convFee) && k.a((Object) this.cardType, (Object) riskConvFeeModel.cardType);
    }

    public final int hashCode() {
        String str = this.cardHash;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.convFee;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cardType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "RiskConvFeeModel(cardHash=" + this.cardHash + ", convFee=" + this.convFee + ", cardType=" + this.cardType + ")";
    }

    public RiskConvFeeModel(String str, String str2, String str3) {
        this.cardHash = str;
        this.convFee = str2;
        this.cardType = str3;
    }

    public final String getCardHash() {
        return this.cardHash;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getConvFee() {
        return this.convFee;
    }

    public final void setCardHash(String str) {
        this.cardHash = str;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final void setConvFee(String str) {
        this.convFee = str;
    }
}
