package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ActiveSubscriptionsHistoryDetails extends IJRPaytmDataModel {
    @b(a = "lastRenewalStatus")
    private String lastRenewalStatus;
    @b(a = "lastRenewaldate")
    private String lastRenewaldate;
    @b(a = "totalRenewalOrders")
    private String totalRenewalOrders;
    @b(a = "totalSuccessfulRenewalAmount")
    private String totalSuccessfulRenewalAmount;
    @b(a = "totalSuccessfulRenewalOrders")
    private String totalSuccessfulRenewalOrders;

    public ActiveSubscriptionsHistoryDetails() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsHistoryDetails copy$default(ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activeSubscriptionsHistoryDetails.totalSuccessfulRenewalAmount;
        }
        if ((i2 & 2) != 0) {
            str2 = activeSubscriptionsHistoryDetails.lastRenewalStatus;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = activeSubscriptionsHistoryDetails.totalSuccessfulRenewalOrders;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = activeSubscriptionsHistoryDetails.lastRenewaldate;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = activeSubscriptionsHistoryDetails.totalRenewalOrders;
        }
        return activeSubscriptionsHistoryDetails.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.totalSuccessfulRenewalAmount;
    }

    public final String component2() {
        return this.lastRenewalStatus;
    }

    public final String component3() {
        return this.totalSuccessfulRenewalOrders;
    }

    public final String component4() {
        return this.lastRenewaldate;
    }

    public final String component5() {
        return this.totalRenewalOrders;
    }

    public final ActiveSubscriptionsHistoryDetails copy(String str, String str2, String str3, String str4, String str5) {
        return new ActiveSubscriptionsHistoryDetails(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsHistoryDetails)) {
            return false;
        }
        ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails = (ActiveSubscriptionsHistoryDetails) obj;
        return k.a((Object) this.totalSuccessfulRenewalAmount, (Object) activeSubscriptionsHistoryDetails.totalSuccessfulRenewalAmount) && k.a((Object) this.lastRenewalStatus, (Object) activeSubscriptionsHistoryDetails.lastRenewalStatus) && k.a((Object) this.totalSuccessfulRenewalOrders, (Object) activeSubscriptionsHistoryDetails.totalSuccessfulRenewalOrders) && k.a((Object) this.lastRenewaldate, (Object) activeSubscriptionsHistoryDetails.lastRenewaldate) && k.a((Object) this.totalRenewalOrders, (Object) activeSubscriptionsHistoryDetails.totalRenewalOrders);
    }

    public final int hashCode() {
        String str = this.totalSuccessfulRenewalAmount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lastRenewalStatus;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.totalSuccessfulRenewalOrders;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastRenewaldate;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.totalRenewalOrders;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionsHistoryDetails(totalSuccessfulRenewalAmount=" + this.totalSuccessfulRenewalAmount + ", lastRenewalStatus=" + this.lastRenewalStatus + ", totalSuccessfulRenewalOrders=" + this.totalSuccessfulRenewalOrders + ", lastRenewaldate=" + this.lastRenewaldate + ", totalRenewalOrders=" + this.totalRenewalOrders + ")";
    }

    public final String getTotalSuccessfulRenewalAmount() {
        return this.totalSuccessfulRenewalAmount;
    }

    public final void setTotalSuccessfulRenewalAmount(String str) {
        this.totalSuccessfulRenewalAmount = str;
    }

    public final String getLastRenewalStatus() {
        return this.lastRenewalStatus;
    }

    public final void setLastRenewalStatus(String str) {
        this.lastRenewalStatus = str;
    }

    public final String getTotalSuccessfulRenewalOrders() {
        return this.totalSuccessfulRenewalOrders;
    }

    public final void setTotalSuccessfulRenewalOrders(String str) {
        this.totalSuccessfulRenewalOrders = str;
    }

    public final String getLastRenewaldate() {
        return this.lastRenewaldate;
    }

    public final void setLastRenewaldate(String str) {
        this.lastRenewaldate = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActiveSubscriptionsHistoryDetails(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsHistoryDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTotalRenewalOrders() {
        return this.totalRenewalOrders;
    }

    public final void setTotalRenewalOrders(String str) {
        this.totalRenewalOrders = str;
    }

    public ActiveSubscriptionsHistoryDetails(String str, String str2, String str3, String str4, String str5) {
        this.totalSuccessfulRenewalAmount = str;
        this.lastRenewalStatus = str2;
        this.totalSuccessfulRenewalOrders = str3;
        this.lastRenewaldate = str4;
        this.totalRenewalOrders = str5;
    }
}
