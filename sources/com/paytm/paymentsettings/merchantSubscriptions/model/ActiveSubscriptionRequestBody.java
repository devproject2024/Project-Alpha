package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionRequestBody extends IJRPaytmDataModel {
    @b(a = "custId")
    private final String custId;
    @b(a = "detailRequired")
    private final boolean detailRequired;
    @b(a = "mid")
    private final String mid;

    public ActiveSubscriptionRequestBody() {
        this((String) null, (String) null, false, 7, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionRequestBody copy$default(ActiveSubscriptionRequestBody activeSubscriptionRequestBody, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activeSubscriptionRequestBody.custId;
        }
        if ((i2 & 2) != 0) {
            str2 = activeSubscriptionRequestBody.mid;
        }
        if ((i2 & 4) != 0) {
            z = activeSubscriptionRequestBody.detailRequired;
        }
        return activeSubscriptionRequestBody.copy(str, str2, z);
    }

    public final String component1() {
        return this.custId;
    }

    public final String component2() {
        return this.mid;
    }

    public final boolean component3() {
        return this.detailRequired;
    }

    public final ActiveSubscriptionRequestBody copy(String str, String str2, boolean z) {
        return new ActiveSubscriptionRequestBody(str, str2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionRequestBody)) {
            return false;
        }
        ActiveSubscriptionRequestBody activeSubscriptionRequestBody = (ActiveSubscriptionRequestBody) obj;
        return k.a((Object) this.custId, (Object) activeSubscriptionRequestBody.custId) && k.a((Object) this.mid, (Object) activeSubscriptionRequestBody.mid) && this.detailRequired == activeSubscriptionRequestBody.detailRequired;
    }

    public final int hashCode() {
        String str = this.custId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mid;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.detailRequired;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "ActiveSubscriptionRequestBody(custId=" + this.custId + ", mid=" + this.mid + ", detailRequired=" + this.detailRequired + ")";
    }

    public final String getCustId() {
        return this.custId;
    }

    public final String getMid() {
        return this.mid;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionRequestBody(String str, String str2, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? true : z);
    }

    public final boolean getDetailRequired() {
        return this.detailRequired;
    }

    public ActiveSubscriptionRequestBody(String str, String str2, boolean z) {
        this.custId = str;
        this.mid = str2;
        this.detailRequired = z;
    }
}
