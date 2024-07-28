package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_amount")
    private double bookingAmount;
    @b(a = "booking_date")
    private long bookingDate;
    @b(a = "fd_category")
    private List<String> fdCategory = w.INSTANCE;
    @b(a = "fd_id")
    private String fdId;
    @b(a = "fd_status")
    private String fdStatus;
    @b(a = "interest_earned")
    private double interestEarned;
    @b(a = "interest_rate_annualized")
    private double interestRateAnnualized;
    @b(a = "interest_rate_per_annum")
    private double interestRatePerAnnum;
    @b(a = "lien_amount")
    private double lienAmount;
    @b(a = "locked_amount")
    private double lockedAmount;
    @b(a = "maturity_amount")
    private double maturityAmount;
    @b(a = "net_invested_amount")
    private double netInvestedAmount;

    public final double getBookingAmount() {
        return this.bookingAmount;
    }

    public final void setBookingAmount(double d2) {
        this.bookingAmount = d2;
    }

    public final String getFdId() {
        return this.fdId;
    }

    public final void setFdId(String str) {
        this.fdId = str;
    }

    public final String getFdStatus() {
        return this.fdStatus;
    }

    public final void setFdStatus(String str) {
        this.fdStatus = str;
    }

    public final double getInterestRateAnnualized() {
        return this.interestRateAnnualized;
    }

    public final void setInterestRateAnnualized(double d2) {
        this.interestRateAnnualized = d2;
    }

    public final double getInterestRatePerAnnum() {
        return this.interestRatePerAnnum;
    }

    public final void setInterestRatePerAnnum(double d2) {
        this.interestRatePerAnnum = d2;
    }

    public final double getLienAmount() {
        return this.lienAmount;
    }

    public final void setLienAmount(double d2) {
        this.lienAmount = d2;
    }

    public final double getLockedAmount() {
        return this.lockedAmount;
    }

    public final void setLockedAmount(double d2) {
        this.lockedAmount = d2;
    }

    public final double getMaturityAmount() {
        return this.maturityAmount;
    }

    public final void setMaturityAmount(double d2) {
        this.maturityAmount = d2;
    }

    public final double getNetInvestedAmount() {
        return this.netInvestedAmount;
    }

    public final void setNetInvestedAmount(double d2) {
        this.netInvestedAmount = d2;
    }

    public final long getBookingDate() {
        return this.bookingDate;
    }

    public final void setBookingDate(long j) {
        this.bookingDate = j;
    }

    public final double getInterestEarned() {
        return this.interestEarned;
    }

    public final void setInterestEarned(double d2) {
        this.interestEarned = d2;
    }

    public final List<String> getFdCategory() {
        return this.fdCategory;
    }

    public final void setFdCategory(List<String> list) {
        k.c(list, "<set-?>");
        this.fdCategory = list;
    }
}
