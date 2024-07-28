package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RedemptionResponseListItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fdNumber")
    private final String fdNumber;
    @b(a = "interestRate")
    private final Double interestRate;
    @b(a = "netAmountPayout")
    private final Double netAmountPayout;
    @b(a = "redemptionAmount")
    private final Double redemptionAmount;
    @b(a = "redemptionStatus")
    private final String redemptionStatus;
    @b(a = "status")
    private final String status;
    @b(a = "transactionSubType")
    private final String transactionSubType;
    @b(a = "transactionType")
    private final String transactionType;

    public static /* synthetic */ RedemptionResponseListItem copy$default(RedemptionResponseListItem redemptionResponseListItem, String str, String str2, String str3, String str4, Double d2, Double d3, String str5, Double d4, int i2, Object obj) {
        RedemptionResponseListItem redemptionResponseListItem2 = redemptionResponseListItem;
        int i3 = i2;
        return redemptionResponseListItem.copy((i3 & 1) != 0 ? redemptionResponseListItem2.fdNumber : str, (i3 & 2) != 0 ? redemptionResponseListItem2.status : str2, (i3 & 4) != 0 ? redemptionResponseListItem2.transactionSubType : str3, (i3 & 8) != 0 ? redemptionResponseListItem2.transactionType : str4, (i3 & 16) != 0 ? redemptionResponseListItem2.interestRate : d2, (i3 & 32) != 0 ? redemptionResponseListItem2.netAmountPayout : d3, (i3 & 64) != 0 ? redemptionResponseListItem2.redemptionStatus : str5, (i3 & 128) != 0 ? redemptionResponseListItem2.redemptionAmount : d4);
    }

    public final String component1() {
        return this.fdNumber;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.transactionSubType;
    }

    public final String component4() {
        return this.transactionType;
    }

    public final Double component5() {
        return this.interestRate;
    }

    public final Double component6() {
        return this.netAmountPayout;
    }

    public final String component7() {
        return this.redemptionStatus;
    }

    public final Double component8() {
        return this.redemptionAmount;
    }

    public final RedemptionResponseListItem copy(String str, String str2, String str3, String str4, Double d2, Double d3, String str5, Double d4) {
        return new RedemptionResponseListItem(str, str2, str3, str4, d2, d3, str5, d4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedemptionResponseListItem)) {
            return false;
        }
        RedemptionResponseListItem redemptionResponseListItem = (RedemptionResponseListItem) obj;
        return k.a((Object) this.fdNumber, (Object) redemptionResponseListItem.fdNumber) && k.a((Object) this.status, (Object) redemptionResponseListItem.status) && k.a((Object) this.transactionSubType, (Object) redemptionResponseListItem.transactionSubType) && k.a((Object) this.transactionType, (Object) redemptionResponseListItem.transactionType) && k.a((Object) this.interestRate, (Object) redemptionResponseListItem.interestRate) && k.a((Object) this.netAmountPayout, (Object) redemptionResponseListItem.netAmountPayout) && k.a((Object) this.redemptionStatus, (Object) redemptionResponseListItem.redemptionStatus) && k.a((Object) this.redemptionAmount, (Object) redemptionResponseListItem.redemptionAmount);
    }

    public final int hashCode() {
        String str = this.fdNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.transactionSubType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.transactionType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Double d2 = this.interestRate;
        int hashCode5 = (hashCode4 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.netAmountPayout;
        int hashCode6 = (hashCode5 + (d3 != null ? d3.hashCode() : 0)) * 31;
        String str5 = this.redemptionStatus;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Double d4 = this.redemptionAmount;
        if (d4 != null) {
            i2 = d4.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "RedemptionResponseListItem(fdNumber=" + this.fdNumber + ", status=" + this.status + ", transactionSubType=" + this.transactionSubType + ", transactionType=" + this.transactionType + ", interestRate=" + this.interestRate + ", netAmountPayout=" + this.netAmountPayout + ", redemptionStatus=" + this.redemptionStatus + ", redemptionAmount=" + this.redemptionAmount + ")";
    }

    public final String getFdNumber() {
        return this.fdNumber;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTransactionSubType() {
        return this.transactionSubType;
    }

    public final String getTransactionType() {
        return this.transactionType;
    }

    public final Double getInterestRate() {
        return this.interestRate;
    }

    public final Double getNetAmountPayout() {
        return this.netAmountPayout;
    }

    public final String getRedemptionStatus() {
        return this.redemptionStatus;
    }

    public RedemptionResponseListItem(String str, String str2, String str3, String str4, Double d2, Double d3, String str5, Double d4) {
        this.fdNumber = str;
        this.status = str2;
        this.transactionSubType = str3;
        this.transactionType = str4;
        this.interestRate = d2;
        this.netAmountPayout = d3;
        this.redemptionStatus = str5;
        this.redemptionAmount = d4;
    }

    public final Double getRedemptionAmount() {
        return this.redemptionAmount;
    }
}
