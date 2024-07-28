package com.business.merchant_payments.payment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;

public final class PaymentsSummaryModel {
    public boolean isNonMigrated;
    public String rewardPoints;
    public String totalAmount;
    public String totalPayments;

    public PaymentsSummaryModel() {
        this((String) null, (String) null, (String) null, false, 15, (g) null);
    }

    public static /* synthetic */ PaymentsSummaryModel copy$default(PaymentsSummaryModel paymentsSummaryModel, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentsSummaryModel.totalPayments;
        }
        if ((i2 & 2) != 0) {
            str2 = paymentsSummaryModel.rewardPoints;
        }
        if ((i2 & 4) != 0) {
            str3 = paymentsSummaryModel.totalAmount;
        }
        if ((i2 & 8) != 0) {
            z = paymentsSummaryModel.isNonMigrated;
        }
        return paymentsSummaryModel.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.totalPayments;
    }

    public final String component2() {
        return this.rewardPoints;
    }

    public final String component3() {
        return this.totalAmount;
    }

    public final boolean component4() {
        return this.isNonMigrated;
    }

    public final PaymentsSummaryModel copy(String str, String str2, String str3, boolean z) {
        k.d(str, "totalPayments");
        k.d(str2, "rewardPoints");
        k.d(str3, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        return new PaymentsSummaryModel(str, str2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsSummaryModel)) {
            return false;
        }
        PaymentsSummaryModel paymentsSummaryModel = (PaymentsSummaryModel) obj;
        return k.a((Object) this.totalPayments, (Object) paymentsSummaryModel.totalPayments) && k.a((Object) this.rewardPoints, (Object) paymentsSummaryModel.rewardPoints) && k.a((Object) this.totalAmount, (Object) paymentsSummaryModel.totalAmount) && this.isNonMigrated == paymentsSummaryModel.isNonMigrated;
    }

    public final int hashCode() {
        String str = this.totalPayments;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rewardPoints;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.totalAmount;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.isNonMigrated;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "PaymentsSummaryModel(totalPayments=" + this.totalPayments + ", rewardPoints=" + this.rewardPoints + ", totalAmount=" + this.totalAmount + ", isNonMigrated=" + this.isNonMigrated + ")";
    }

    public PaymentsSummaryModel(String str, String str2, String str3, boolean z) {
        k.d(str, "totalPayments");
        k.d(str2, "rewardPoints");
        k.d(str3, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        this.totalPayments = str;
        this.rewardPoints = str2;
        this.totalAmount = str3;
        this.isNonMigrated = z;
    }

    public final String getTotalPayments() {
        return this.totalPayments;
    }

    public final void setTotalPayments(String str) {
        k.d(str, "<set-?>");
        this.totalPayments = str;
    }

    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    public final void setRewardPoints(String str) {
        k.d(str, "<set-?>");
        this.rewardPoints = str;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(String str) {
        k.d(str, "<set-?>");
        this.totalAmount = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentsSummaryModel(String str, String str2, String str3, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isNonMigrated() {
        return this.isNonMigrated;
    }

    public final void setNonMigrated(boolean z) {
        this.isNonMigrated = z;
    }
}
