package net.one97.paytm.nativesdk.common.model;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;

public class PayChannelOptions implements BaseDataModel {
    public i<String> amount = new i<>("");
    private BalanceInfo balanceInfo;
    public ObservableBoolean bankSelectionProceedVisible = new ObservableBoolean(false);
    private String cachedPaymentIntent;
    private String channelCode;
    private String channelName;
    private String convFeeText;
    private double convenienceFee;
    private String emiType;
    private HasLowSuccess hasLowSuccess;
    private ApplyPromoResponse.PaymentOffer hybridPaymentOffer;
    private String iconUrl;
    private boolean isConvFeeLoading;
    private IsDisabled isDisabled;
    public ObservableBoolean isGreenTickVisible = new ObservableBoolean(false);
    @c(a = "isHybridDisabled")
    private Boolean isHybridDisabled;
    private boolean isProceedVisible;
    public ObservableInt lowSuccessVisibility = new ObservableInt(8);
    @c(a = "mandateAuthMode")
    private List<String> mandateAuthMode = null;
    @c(a = "mandateBankCode")
    private String mandateBankCode;
    @c(a = "mandateMode")
    private String mandateMode;
    @c(a = "maxAmount")
    @a
    private MinAmount maxAmount;
    @c(a = "minAmount")
    @a
    private MinAmount minAmount;
    private String mode;
    private ApplyPromoResponse.PaymentOffer paymentOffer;
    public boolean showCheckingOffer = false;
    @c(a = "templateId")
    @a
    private String templateId;

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public String getEmiType() {
        return this.emiType;
    }

    public void setEmiType(String str) {
        this.emiType = str;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public boolean isConvFeeLoading() {
        return this.isConvFeeLoading;
    }

    public void setConvFeeLoading(boolean z) {
        this.isConvFeeLoading = z;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public String getConvFeeText() {
        return this.convFeeText;
    }

    public void setConvFeeText(String str) {
        this.convFeeText = str;
    }

    public BalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public void setBalanceInfo(BalanceInfo balanceInfo2) {
        this.balanceInfo = balanceInfo2;
    }

    public boolean isProceedVisible() {
        return this.isProceedVisible;
    }

    public void setProceedVisible(boolean z) {
        this.isProceedVisible = z;
    }

    public MinAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(MinAmount minAmount2) {
        this.minAmount = minAmount2;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", channelName = " + this.channelName + ", channelCode = " + this.channelCode + ", iconUrl = " + this.iconUrl + ", hasLowSuccess = " + this.hasLowSuccess + "]";
    }

    public MinAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(MinAmount minAmount2) {
        this.maxAmount = minAmount2;
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        return this.paymentOffer;
    }

    public void setPaymentOffer(ApplyPromoResponse.PaymentOffer paymentOffer2) {
        this.paymentOffer = paymentOffer2;
    }

    public void setHybridPaymentOffer(ApplyPromoResponse.PaymentOffer paymentOffer2) {
        this.hybridPaymentOffer = paymentOffer2;
    }

    public ApplyPromoResponse.PaymentOffer getHybridPaymentOffer() {
        return this.hybridPaymentOffer;
    }

    public double getConvenienceFee() {
        return this.convenienceFee;
    }

    public void setConvenienceFee(double d2) {
        this.convenienceFee = d2;
    }

    public String getCachedPaymentIntent() {
        return this.cachedPaymentIntent;
    }

    public void setCachedPaymentIntent(String str) {
        this.cachedPaymentIntent = str;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getMandateMode() {
        return this.mandateMode;
    }

    public void setMandateMode(String str) {
        this.mandateMode = str;
    }

    public List<String> getMandateAuthMode() {
        return this.mandateAuthMode;
    }

    public void setMandateAuthMode(List<String> list) {
        this.mandateAuthMode = list;
    }

    public String getMandateBankCode() {
        return this.mandateBankCode;
    }

    public void setMandateBankCode(String str) {
        this.mandateBankCode = str;
    }

    public Boolean getIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public void setIsHybridDisabled(Boolean bool) {
        this.isHybridDisabled = bool;
    }
}
