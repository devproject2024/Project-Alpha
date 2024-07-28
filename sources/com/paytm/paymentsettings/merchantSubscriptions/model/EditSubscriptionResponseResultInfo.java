package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionResponseResultInfo extends IJRPaytmDataModel {
    @b(a = "code")
    private final String code;
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final String status;

    public EditSubscriptionResponseResultInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ EditSubscriptionResponseResultInfo copy$default(EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editSubscriptionResponseResultInfo.code;
        }
        if ((i2 & 2) != 0) {
            str2 = editSubscriptionResponseResultInfo.message;
        }
        if ((i2 & 4) != 0) {
            str3 = editSubscriptionResponseResultInfo.status;
        }
        return editSubscriptionResponseResultInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final EditSubscriptionResponseResultInfo copy(String str, String str2, String str3) {
        return new EditSubscriptionResponseResultInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionResponseResultInfo)) {
            return false;
        }
        EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo = (EditSubscriptionResponseResultInfo) obj;
        return k.a((Object) this.code, (Object) editSubscriptionResponseResultInfo.code) && k.a((Object) this.message, (Object) editSubscriptionResponseResultInfo.message) && k.a((Object) this.status, (Object) editSubscriptionResponseResultInfo.status);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "EditSubscriptionResponseResultInfo(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditSubscriptionResponseResultInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public EditSubscriptionResponseResultInfo(String str, String str2, String str3) {
        this.code = str;
        this.message = str2;
        this.status = str3;
    }
}
