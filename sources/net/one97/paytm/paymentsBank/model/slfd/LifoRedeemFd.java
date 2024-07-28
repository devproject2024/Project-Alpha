package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class LifoRedeemFd extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_amount")
    private final String bookingAmount;
    @b(a = "booking_date")
    private final String bookingDate;
    @b(a = "fd_id")
    private final String fdId;
    @b(a = "interest_rate")
    private final Double interestRate;
    @b(a = "net_amount_payout")
    private final Double netAmountPayout;
    @b(a = "net_invested_amount")
    private final Double netInvestedAmount;
    @b(a = "redemption_amount")
    private final Double redemptionAmount;
    @b(a = "redemption_status")
    private final String redemptionStatus;

    public static /* synthetic */ LifoRedeemFd copy$default(LifoRedeemFd lifoRedeemFd, String str, String str2, String str3, Double d2, Double d3, Double d4, Double d5, String str4, int i2, Object obj) {
        LifoRedeemFd lifoRedeemFd2 = lifoRedeemFd;
        int i3 = i2;
        return lifoRedeemFd.copy((i3 & 1) != 0 ? lifoRedeemFd2.bookingAmount : str, (i3 & 2) != 0 ? lifoRedeemFd2.bookingDate : str2, (i3 & 4) != 0 ? lifoRedeemFd2.fdId : str3, (i3 & 8) != 0 ? lifoRedeemFd2.interestRate : d2, (i3 & 16) != 0 ? lifoRedeemFd2.netAmountPayout : d3, (i3 & 32) != 0 ? lifoRedeemFd2.netInvestedAmount : d4, (i3 & 64) != 0 ? lifoRedeemFd2.redemptionAmount : d5, (i3 & 128) != 0 ? lifoRedeemFd2.redemptionStatus : str4);
    }

    public final String component1() {
        return this.bookingAmount;
    }

    public final String component2() {
        return this.bookingDate;
    }

    public final String component3() {
        return this.fdId;
    }

    public final Double component4() {
        return this.interestRate;
    }

    public final Double component5() {
        return this.netAmountPayout;
    }

    public final Double component6() {
        return this.netInvestedAmount;
    }

    public final Double component7() {
        return this.redemptionAmount;
    }

    public final String component8() {
        return this.redemptionStatus;
    }

    public final LifoRedeemFd copy(String str, String str2, String str3, Double d2, Double d3, Double d4, Double d5, String str4) {
        return new LifoRedeemFd(str, str2, str3, d2, d3, d4, d5, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifoRedeemFd)) {
            return false;
        }
        LifoRedeemFd lifoRedeemFd = (LifoRedeemFd) obj;
        return k.a((Object) this.bookingAmount, (Object) lifoRedeemFd.bookingAmount) && k.a((Object) this.bookingDate, (Object) lifoRedeemFd.bookingDate) && k.a((Object) this.fdId, (Object) lifoRedeemFd.fdId) && k.a((Object) this.interestRate, (Object) lifoRedeemFd.interestRate) && k.a((Object) this.netAmountPayout, (Object) lifoRedeemFd.netAmountPayout) && k.a((Object) this.netInvestedAmount, (Object) lifoRedeemFd.netInvestedAmount) && k.a((Object) this.redemptionAmount, (Object) lifoRedeemFd.redemptionAmount) && k.a((Object) this.redemptionStatus, (Object) lifoRedeemFd.redemptionStatus);
    }

    public final int hashCode() {
        String str = this.bookingAmount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bookingDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fdId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d2 = this.interestRate;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.netAmountPayout;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.netInvestedAmount;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.redemptionAmount;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 31;
        String str4 = this.redemptionStatus;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "LifoRedeemFd(bookingAmount=" + this.bookingAmount + ", bookingDate=" + this.bookingDate + ", fdId=" + this.fdId + ", interestRate=" + this.interestRate + ", netAmountPayout=" + this.netAmountPayout + ", netInvestedAmount=" + this.netInvestedAmount + ", redemptionAmount=" + this.redemptionAmount + ", redemptionStatus=" + this.redemptionStatus + ")";
    }

    public final String getBookingAmount() {
        return this.bookingAmount;
    }

    public final String getBookingDate() {
        return this.bookingDate;
    }

    public final String getFdId() {
        return this.fdId;
    }

    public final Double getInterestRate() {
        return this.interestRate;
    }

    public final Double getNetAmountPayout() {
        return this.netAmountPayout;
    }

    public final Double getNetInvestedAmount() {
        return this.netInvestedAmount;
    }

    public final Double getRedemptionAmount() {
        return this.redemptionAmount;
    }

    public LifoRedeemFd(String str, String str2, String str3, Double d2, Double d3, Double d4, Double d5, String str4) {
        this.bookingAmount = str;
        this.bookingDate = str2;
        this.fdId = str3;
        this.interestRate = d2;
        this.netAmountPayout = d3;
        this.netInvestedAmount = d4;
        this.redemptionAmount = d5;
        this.redemptionStatus = str4;
    }

    public final String getRedemptionStatus() {
        return this.redemptionStatus;
    }
}
