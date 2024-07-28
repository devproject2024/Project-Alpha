package net.one97.paytm.recharge.model.v4;

import kotlin.g.b.k;

public final class CJRDthRechargeHeaderModel {
    private final String operator;
    private final String operatorId;
    private final String operatorImageUrl;

    public static /* synthetic */ CJRDthRechargeHeaderModel copy$default(CJRDthRechargeHeaderModel cJRDthRechargeHeaderModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRDthRechargeHeaderModel.operatorId;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRDthRechargeHeaderModel.operator;
        }
        if ((i2 & 4) != 0) {
            str3 = cJRDthRechargeHeaderModel.operatorImageUrl;
        }
        return cJRDthRechargeHeaderModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.operatorId;
    }

    public final String component2() {
        return this.operator;
    }

    public final String component3() {
        return this.operatorImageUrl;
    }

    public final CJRDthRechargeHeaderModel copy(String str, String str2, String str3) {
        return new CJRDthRechargeHeaderModel(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRDthRechargeHeaderModel)) {
            return false;
        }
        CJRDthRechargeHeaderModel cJRDthRechargeHeaderModel = (CJRDthRechargeHeaderModel) obj;
        return k.a((Object) this.operatorId, (Object) cJRDthRechargeHeaderModel.operatorId) && k.a((Object) this.operator, (Object) cJRDthRechargeHeaderModel.operator) && k.a((Object) this.operatorImageUrl, (Object) cJRDthRechargeHeaderModel.operatorImageUrl);
    }

    public final int hashCode() {
        String str = this.operatorId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.operator;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.operatorImageUrl;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRDthRechargeHeaderModel(operatorId=" + this.operatorId + ", operator=" + this.operator + ", operatorImageUrl=" + this.operatorImageUrl + ")";
    }

    public CJRDthRechargeHeaderModel(String str, String str2, String str3) {
        this.operatorId = str;
        this.operator = str2;
        this.operatorImageUrl = str3;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getOperatorId() {
        return this.operatorId;
    }

    public final String getOperatorImageUrl() {
        return this.operatorImageUrl;
    }
}
