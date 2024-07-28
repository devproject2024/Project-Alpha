package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionsPaymentDetails extends IJRPaytmDataModel {
    @b(a = "lastBilledAmount")
    private String lastBilledAmount;
    @b(a = "lastSuccessOrderId")
    private String lastSuccessOrderId;
    @b(a = "lastSuccessTxnDate")
    private String lastSuccessTxnDate;

    public ActiveSubscriptionsPaymentDetails() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsPaymentDetails copy$default(ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activeSubscriptionsPaymentDetails.lastSuccessOrderId;
        }
        if ((i2 & 2) != 0) {
            str2 = activeSubscriptionsPaymentDetails.lastBilledAmount;
        }
        if ((i2 & 4) != 0) {
            str3 = activeSubscriptionsPaymentDetails.lastSuccessTxnDate;
        }
        return activeSubscriptionsPaymentDetails.copy(str, str2, str3);
    }

    public final String component1() {
        return this.lastSuccessOrderId;
    }

    public final String component2() {
        return this.lastBilledAmount;
    }

    public final String component3() {
        return this.lastSuccessTxnDate;
    }

    public final ActiveSubscriptionsPaymentDetails copy(String str, String str2, String str3) {
        return new ActiveSubscriptionsPaymentDetails(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsPaymentDetails)) {
            return false;
        }
        ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails = (ActiveSubscriptionsPaymentDetails) obj;
        return k.a((Object) this.lastSuccessOrderId, (Object) activeSubscriptionsPaymentDetails.lastSuccessOrderId) && k.a((Object) this.lastBilledAmount, (Object) activeSubscriptionsPaymentDetails.lastBilledAmount) && k.a((Object) this.lastSuccessTxnDate, (Object) activeSubscriptionsPaymentDetails.lastSuccessTxnDate);
    }

    public final int hashCode() {
        String str = this.lastSuccessOrderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lastBilledAmount;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastSuccessTxnDate;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionsPaymentDetails(lastSuccessOrderId=" + this.lastSuccessOrderId + ", lastBilledAmount=" + this.lastBilledAmount + ", lastSuccessTxnDate=" + this.lastSuccessTxnDate + ")";
    }

    public final String getLastSuccessOrderId() {
        return this.lastSuccessOrderId;
    }

    public final void setLastSuccessOrderId(String str) {
        this.lastSuccessOrderId = str;
    }

    public final String getLastBilledAmount() {
        return this.lastBilledAmount;
    }

    public final void setLastBilledAmount(String str) {
        this.lastBilledAmount = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionsPaymentDetails(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getLastSuccessTxnDate() {
        return this.lastSuccessTxnDate;
    }

    public final void setLastSuccessTxnDate(String str) {
        this.lastSuccessTxnDate = str;
    }

    public ActiveSubscriptionsPaymentDetails(String str, String str2, String str3) {
        this.lastSuccessOrderId = str;
        this.lastBilledAmount = str2;
        this.lastSuccessTxnDate = str3;
    }
}
