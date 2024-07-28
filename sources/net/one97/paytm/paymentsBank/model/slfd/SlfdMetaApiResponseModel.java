package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdMetaApiResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "exit_load_rate")
    private Integer exitLoadRate = 0;
    @b(a = "exit_load_text")
    private String exitLoadText;
    @b(a = "fd_calculator_fun")
    private String fdCalculatorFunc;
    @b(a = "fd_cap_amount")
    private Double fdCapAmount;
    @b(a = "fd_floor_amount")
    private Double fdFloorAmount;
    @b(a = "interest_rate_text")
    private String interestRateText;
    @b(a = "message")
    private String message;
    @b(a = "peak_interest_rate_annualized")
    private Double peakInterestRateAnnualized;
    @b(a = "peak_interest_rate_per_annum")
    private Double peakInterestRatePerAnnum;
    @b(a = "peak_tenure_days")
    private Integer peakTenureDays = 0;
    @b(a = "peak_tenure_months")
    private Integer peakTenureMonths = 0;
    @b(a = "redemption_banner_url")
    private String redemptionBannerUrl;
    @b(a = "response_code")
    private int responseCode;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txnId;

    public SlfdMetaApiResponseModel() {
        Double valueOf = Double.valueOf(0.0d);
        this.peakInterestRateAnnualized = valueOf;
        this.peakInterestRatePerAnnum = valueOf;
        this.fdCapAmount = valueOf;
        this.fdFloorAmount = valueOf;
    }

    public final Double getPeakInterestRateAnnualized() {
        return this.peakInterestRateAnnualized;
    }

    public final void setPeakInterestRateAnnualized(Double d2) {
        this.peakInterestRateAnnualized = d2;
    }

    public final Double getPeakInterestRatePerAnnum() {
        return this.peakInterestRatePerAnnum;
    }

    public final void setPeakInterestRatePerAnnum(Double d2) {
        this.peakInterestRatePerAnnum = d2;
    }

    public final Integer getPeakTenureDays() {
        return this.peakTenureDays;
    }

    public final void setPeakTenureDays(Integer num) {
        this.peakTenureDays = num;
    }

    public final Integer getPeakTenureMonths() {
        return this.peakTenureMonths;
    }

    public final void setPeakTenureMonths(Integer num) {
        this.peakTenureMonths = num;
    }

    public final String getInterestRateText() {
        return this.interestRateText;
    }

    public final void setInterestRateText(String str) {
        this.interestRateText = str;
    }

    public final Integer getExitLoadRate() {
        return this.exitLoadRate;
    }

    public final void setExitLoadRate(Integer num) {
        this.exitLoadRate = num;
    }

    public final String getExitLoadText() {
        return this.exitLoadText;
    }

    public final void setExitLoadText(String str) {
        this.exitLoadText = str;
    }

    public final Double getFdCapAmount() {
        return this.fdCapAmount;
    }

    public final void setFdCapAmount(Double d2) {
        this.fdCapAmount = d2;
    }

    public final Double getFdFloorAmount() {
        return this.fdFloorAmount;
    }

    public final void setFdFloorAmount(Double d2) {
        this.fdFloorAmount = d2;
    }

    public final String getRedemptionBannerUrl() {
        return this.redemptionBannerUrl;
    }

    public final void setRedemptionBannerUrl(String str) {
        this.redemptionBannerUrl = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final String getFdCalculatorFunc() {
        return this.fdCalculatorFunc;
    }

    public final void setFdCalculatorFunc(String str) {
        this.fdCalculatorFunc = str;
    }
}
