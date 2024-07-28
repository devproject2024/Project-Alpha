package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionsCustomerDetails extends IJRPaytmDataModel {
    @b(a = "customerEmail")
    private String customerEmail;
    @b(a = "customerId")
    private String customerId;
    @b(a = "customerMobile")
    private String customerMobile;
    @b(a = "customerName")
    private String customerName;

    public ActiveSubscriptionsCustomerDetails() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsCustomerDetails copy$default(ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activeSubscriptionsCustomerDetails.customerEmail;
        }
        if ((i2 & 2) != 0) {
            str2 = activeSubscriptionsCustomerDetails.customerMobile;
        }
        if ((i2 & 4) != 0) {
            str3 = activeSubscriptionsCustomerDetails.customerName;
        }
        if ((i2 & 8) != 0) {
            str4 = activeSubscriptionsCustomerDetails.customerId;
        }
        return activeSubscriptionsCustomerDetails.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.customerEmail;
    }

    public final String component2() {
        return this.customerMobile;
    }

    public final String component3() {
        return this.customerName;
    }

    public final String component4() {
        return this.customerId;
    }

    public final ActiveSubscriptionsCustomerDetails copy(String str, String str2, String str3, String str4) {
        return new ActiveSubscriptionsCustomerDetails(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsCustomerDetails)) {
            return false;
        }
        ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails = (ActiveSubscriptionsCustomerDetails) obj;
        return k.a((Object) this.customerEmail, (Object) activeSubscriptionsCustomerDetails.customerEmail) && k.a((Object) this.customerMobile, (Object) activeSubscriptionsCustomerDetails.customerMobile) && k.a((Object) this.customerName, (Object) activeSubscriptionsCustomerDetails.customerName) && k.a((Object) this.customerId, (Object) activeSubscriptionsCustomerDetails.customerId);
    }

    public final int hashCode() {
        String str = this.customerEmail;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customerMobile;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.customerName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.customerId;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionsCustomerDetails(customerEmail=" + this.customerEmail + ", customerMobile=" + this.customerMobile + ", customerName=" + this.customerName + ", customerId=" + this.customerId + ")";
    }

    public final String getCustomerEmail() {
        return this.customerEmail;
    }

    public final void setCustomerEmail(String str) {
        this.customerEmail = str;
    }

    public final String getCustomerMobile() {
        return this.customerMobile;
    }

    public final void setCustomerMobile(String str) {
        this.customerMobile = str;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final void setCustomerName(String str) {
        this.customerName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionsCustomerDetails(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public ActiveSubscriptionsCustomerDetails(String str, String str2, String str3, String str4) {
        this.customerEmail = str;
        this.customerMobile = str2;
        this.customerName = str3;
        this.customerId = str4;
    }
}
