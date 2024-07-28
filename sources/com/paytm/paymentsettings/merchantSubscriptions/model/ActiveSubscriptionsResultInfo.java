package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionsResultInfo extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private String status;

    public ActiveSubscriptionsResultInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsResultInfo copy$default(ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activeSubscriptionsResultInfo.code;
        }
        if ((i2 & 2) != 0) {
            str2 = activeSubscriptionsResultInfo.message;
        }
        if ((i2 & 4) != 0) {
            str3 = activeSubscriptionsResultInfo.status;
        }
        return activeSubscriptionsResultInfo.copy(str, str2, str3);
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

    public final ActiveSubscriptionsResultInfo copy(String str, String str2, String str3) {
        return new ActiveSubscriptionsResultInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsResultInfo)) {
            return false;
        }
        ActiveSubscriptionsResultInfo activeSubscriptionsResultInfo = (ActiveSubscriptionsResultInfo) obj;
        return k.a((Object) this.code, (Object) activeSubscriptionsResultInfo.code) && k.a((Object) this.message, (Object) activeSubscriptionsResultInfo.message) && k.a((Object) this.status, (Object) activeSubscriptionsResultInfo.status);
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
        return "ActiveSubscriptionsResultInfo(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionsResultInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public ActiveSubscriptionsResultInfo(String str, String str2, String str3) {
        this.code = str;
        this.message = str2;
        this.status = str3;
    }
}
