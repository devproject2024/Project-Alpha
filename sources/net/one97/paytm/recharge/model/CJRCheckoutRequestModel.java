package net.one97.paytm.recharge.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class CJRCheckoutRequestModel {
    private final JSONObject metaData;
    private final String rechargeNumber;
    private final String rechargeUserName;

    public CJRCheckoutRequestModel() {
        this((JSONObject) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ CJRCheckoutRequestModel copy$default(CJRCheckoutRequestModel cJRCheckoutRequestModel, JSONObject jSONObject, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            jSONObject = cJRCheckoutRequestModel.metaData;
        }
        if ((i2 & 2) != 0) {
            str = cJRCheckoutRequestModel.rechargeNumber;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRCheckoutRequestModel.rechargeUserName;
        }
        return cJRCheckoutRequestModel.copy(jSONObject, str, str2);
    }

    public final JSONObject component1() {
        return this.metaData;
    }

    public final String component2() {
        return this.rechargeNumber;
    }

    public final String component3() {
        return this.rechargeUserName;
    }

    public final CJRCheckoutRequestModel copy(JSONObject jSONObject, String str, String str2) {
        return new CJRCheckoutRequestModel(jSONObject, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCheckoutRequestModel)) {
            return false;
        }
        CJRCheckoutRequestModel cJRCheckoutRequestModel = (CJRCheckoutRequestModel) obj;
        return k.a((Object) this.metaData, (Object) cJRCheckoutRequestModel.metaData) && k.a((Object) this.rechargeNumber, (Object) cJRCheckoutRequestModel.rechargeNumber) && k.a((Object) this.rechargeUserName, (Object) cJRCheckoutRequestModel.rechargeUserName);
    }

    public final int hashCode() {
        JSONObject jSONObject = this.metaData;
        int i2 = 0;
        int hashCode = (jSONObject != null ? jSONObject.hashCode() : 0) * 31;
        String str = this.rechargeNumber;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.rechargeUserName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRCheckoutRequestModel(metaData=" + this.metaData + ", rechargeNumber=" + this.rechargeNumber + ", rechargeUserName=" + this.rechargeUserName + ")";
    }

    public CJRCheckoutRequestModel(JSONObject jSONObject, String str, String str2) {
        this.metaData = jSONObject;
        this.rechargeNumber = str;
        this.rechargeUserName = str2;
    }

    public final JSONObject getMetaData() {
        return this.metaData;
    }

    public final String getRechargeNumber() {
        return this.rechargeNumber;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRCheckoutRequestModel(JSONObject jSONObject, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : jSONObject, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final String getRechargeUserName() {
        return this.rechargeUserName;
    }
}
