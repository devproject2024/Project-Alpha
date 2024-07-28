package com.business.merchant_payments.notificationsettings.model;

import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class InboxDataModel {
    public final AdditionalInfo additionalInfo;
    public final String body;
    public final String deeplink;
    public final String mPayMode;
    public final SettlementAmount netAmount;
    public final String orderCreatedTime;
    public final PayMoneyAmount payMoneyAmount;
    public final String settleMode;
    public final String settledTime;

    public static /* synthetic */ InboxDataModel copy$default(InboxDataModel inboxDataModel, String str, String str2, String str3, AdditionalInfo additionalInfo2, PayMoneyAmount payMoneyAmount2, String str4, String str5, String str6, SettlementAmount settlementAmount, int i2, Object obj) {
        InboxDataModel inboxDataModel2 = inboxDataModel;
        int i3 = i2;
        return inboxDataModel.copy((i3 & 1) != 0 ? inboxDataModel2.body : str, (i3 & 2) != 0 ? inboxDataModel2.deeplink : str2, (i3 & 4) != 0 ? inboxDataModel2.mPayMode : str3, (i3 & 8) != 0 ? inboxDataModel2.additionalInfo : additionalInfo2, (i3 & 16) != 0 ? inboxDataModel2.payMoneyAmount : payMoneyAmount2, (i3 & 32) != 0 ? inboxDataModel2.orderCreatedTime : str4, (i3 & 64) != 0 ? inboxDataModel2.settledTime : str5, (i3 & 128) != 0 ? inboxDataModel2.settleMode : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? inboxDataModel2.netAmount : settlementAmount);
    }

    public final String component1() {
        return this.body;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final String component3() {
        return this.mPayMode;
    }

    public final AdditionalInfo component4() {
        return this.additionalInfo;
    }

    public final PayMoneyAmount component5() {
        return this.payMoneyAmount;
    }

    public final String component6() {
        return this.orderCreatedTime;
    }

    public final String component7() {
        return this.settledTime;
    }

    public final String component8() {
        return this.settleMode;
    }

    public final SettlementAmount component9() {
        return this.netAmount;
    }

    public final InboxDataModel copy(String str, String str2, String str3, AdditionalInfo additionalInfo2, PayMoneyAmount payMoneyAmount2, String str4, String str5, String str6, SettlementAmount settlementAmount) {
        k.d(str, "body");
        k.d(str2, "deeplink");
        k.d(str3, "mPayMode");
        k.d(additionalInfo2, "additionalInfo");
        PayMoneyAmount payMoneyAmount3 = payMoneyAmount2;
        k.d(payMoneyAmount3, "payMoneyAmount");
        String str7 = str4;
        k.d(str7, "orderCreatedTime");
        String str8 = str5;
        k.d(str8, "settledTime");
        String str9 = str6;
        k.d(str9, "settleMode");
        SettlementAmount settlementAmount2 = settlementAmount;
        k.d(settlementAmount2, "netAmount");
        return new InboxDataModel(str, str2, str3, additionalInfo2, payMoneyAmount3, str7, str8, str9, settlementAmount2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InboxDataModel)) {
            return false;
        }
        InboxDataModel inboxDataModel = (InboxDataModel) obj;
        return k.a((Object) this.body, (Object) inboxDataModel.body) && k.a((Object) this.deeplink, (Object) inboxDataModel.deeplink) && k.a((Object) this.mPayMode, (Object) inboxDataModel.mPayMode) && k.a((Object) this.additionalInfo, (Object) inboxDataModel.additionalInfo) && k.a((Object) this.payMoneyAmount, (Object) inboxDataModel.payMoneyAmount) && k.a((Object) this.orderCreatedTime, (Object) inboxDataModel.orderCreatedTime) && k.a((Object) this.settledTime, (Object) inboxDataModel.settledTime) && k.a((Object) this.settleMode, (Object) inboxDataModel.settleMode) && k.a((Object) this.netAmount, (Object) inboxDataModel.netAmount);
    }

    public final int hashCode() {
        String str = this.body;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deeplink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mPayMode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        AdditionalInfo additionalInfo2 = this.additionalInfo;
        int hashCode4 = (hashCode3 + (additionalInfo2 != null ? additionalInfo2.hashCode() : 0)) * 31;
        PayMoneyAmount payMoneyAmount2 = this.payMoneyAmount;
        int hashCode5 = (hashCode4 + (payMoneyAmount2 != null ? payMoneyAmount2.hashCode() : 0)) * 31;
        String str4 = this.orderCreatedTime;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.settledTime;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.settleMode;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        SettlementAmount settlementAmount = this.netAmount;
        if (settlementAmount != null) {
            i2 = settlementAmount.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "InboxDataModel(body=" + this.body + ", deeplink=" + this.deeplink + ", mPayMode=" + this.mPayMode + ", additionalInfo=" + this.additionalInfo + ", payMoneyAmount=" + this.payMoneyAmount + ", orderCreatedTime=" + this.orderCreatedTime + ", settledTime=" + this.settledTime + ", settleMode=" + this.settleMode + ", netAmount=" + this.netAmount + ")";
    }

    public InboxDataModel(String str, String str2, String str3, AdditionalInfo additionalInfo2, PayMoneyAmount payMoneyAmount2, String str4, String str5, String str6, SettlementAmount settlementAmount) {
        k.d(str, "body");
        k.d(str2, "deeplink");
        k.d(str3, "mPayMode");
        k.d(additionalInfo2, "additionalInfo");
        k.d(payMoneyAmount2, "payMoneyAmount");
        k.d(str4, "orderCreatedTime");
        k.d(str5, "settledTime");
        k.d(str6, "settleMode");
        k.d(settlementAmount, "netAmount");
        this.body = str;
        this.deeplink = str2;
        this.mPayMode = str3;
        this.additionalInfo = additionalInfo2;
        this.payMoneyAmount = payMoneyAmount2;
        this.orderCreatedTime = str4;
        this.settledTime = str5;
        this.settleMode = str6;
        this.netAmount = settlementAmount;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getMPayMode() {
        return this.mPayMode;
    }

    public final AdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final PayMoneyAmount getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public final String getSettledTime() {
        return this.settledTime;
    }

    public final String getSettleMode() {
        return this.settleMode;
    }

    public final SettlementAmount getNetAmount() {
        return this.netAmount;
    }
}
