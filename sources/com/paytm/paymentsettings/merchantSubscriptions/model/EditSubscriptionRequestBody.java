package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionRequestBody extends IJRPaytmDataModel {
    @b(a = "actionType")
    private final String actionType;
    @b(a = "expiryDate")
    private final String expiryDate;
    @b(a = "mid")
    private final String mid;
    @b(a = "subsId")
    private final String subsId;

    public EditSubscriptionRequestBody() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ EditSubscriptionRequestBody copy$default(EditSubscriptionRequestBody editSubscriptionRequestBody, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editSubscriptionRequestBody.expiryDate;
        }
        if ((i2 & 2) != 0) {
            str2 = editSubscriptionRequestBody.actionType;
        }
        if ((i2 & 4) != 0) {
            str3 = editSubscriptionRequestBody.subsId;
        }
        if ((i2 & 8) != 0) {
            str4 = editSubscriptionRequestBody.mid;
        }
        return editSubscriptionRequestBody.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.expiryDate;
    }

    public final String component2() {
        return this.actionType;
    }

    public final String component3() {
        return this.subsId;
    }

    public final String component4() {
        return this.mid;
    }

    public final EditSubscriptionRequestBody copy(String str, String str2, String str3, String str4) {
        return new EditSubscriptionRequestBody(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionRequestBody)) {
            return false;
        }
        EditSubscriptionRequestBody editSubscriptionRequestBody = (EditSubscriptionRequestBody) obj;
        return k.a((Object) this.expiryDate, (Object) editSubscriptionRequestBody.expiryDate) && k.a((Object) this.actionType, (Object) editSubscriptionRequestBody.actionType) && k.a((Object) this.subsId, (Object) editSubscriptionRequestBody.subsId) && k.a((Object) this.mid, (Object) editSubscriptionRequestBody.mid);
    }

    public final int hashCode() {
        String str = this.expiryDate;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.actionType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subsId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mid;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "EditSubscriptionRequestBody(expiryDate=" + this.expiryDate + ", actionType=" + this.actionType + ", subsId=" + this.subsId + ", mid=" + this.mid + ")";
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getSubsId() {
        return this.subsId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditSubscriptionRequestBody(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getMid() {
        return this.mid;
    }

    public EditSubscriptionRequestBody(String str, String str2, String str3, String str4) {
        this.expiryDate = str;
        this.actionType = str2;
        this.subsId = str3;
        this.mid = str4;
    }
}
