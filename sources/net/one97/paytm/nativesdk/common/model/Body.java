package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail;

public class Body implements BaseDataModel {
    private MerchantDetails addMoneyMerchantDetails;
    private MerchantPayOption addMoneyPayOption;
    private String appInvokeDevice;
    private String[] authModes;
    private BinDetail binDetail;
    private String errorMessage;
    private HasLowSuccess hasLowSuccessRate;
    private String iconBaseUrl;
    private String iconUrl;
    private Boolean isEmiAvailable;
    private boolean isHybridDisabled;
    private boolean isSubscriptionAvailable;
    @c(a = "mandateAccountDetails")
    private MandateAccountDetails mandateAccountDetails;
    @c(a = "mandateSupportedApps")
    private List<MandateSupportedApp> mandateSupportedApps = null;
    private MerchantDetails merchantDetails;
    private MerchantPayOption merchantPayOption;
    private boolean nativeJsonRequestSupported;
    private String oneClickMaxAmount;
    private boolean oneClickSupported;
    private String paymentFlow;
    private ArrayList<PaymentOffer> paymentOffers;
    private boolean pcfEnabled;
    private PromoCodeData promoCodeData;
    private ResultInfo resultInfo;
    private ArrayList<RiskConvenienceFeeItem> riskConvenienceFee;
    @c(a = "simplifiedPaymentOffers")
    private SimplifiedPaymentsOffer simplifiedPaymentsOffer;
    @c(a = "subscriptionDetail")
    private SubscriptionDetailsInfo subscriptionDetailsInfo;
    private Boolean walletOnly;

    public boolean getIsSubscriptionAvailable() {
        return this.isSubscriptionAvailable;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getAppInvokeDevice() {
        return this.appInvokeDevice;
    }

    public void setAppInvokeDevice(String str) {
        this.appInvokeDevice = str;
    }

    public SubscriptionDetailsInfo getSubscriptionDetailsInfo() {
        return this.subscriptionDetailsInfo;
    }

    public void setSubscriptionDetailsInfo(SubscriptionDetailsInfo subscriptionDetailsInfo2) {
        this.subscriptionDetailsInfo = subscriptionDetailsInfo2;
    }

    public List<MandateSupportedApp> getMandateSupportedApps() {
        return this.mandateSupportedApps;
    }

    public boolean isNativeJsonRequestSupported() {
        return this.nativeJsonRequestSupported;
    }

    public void setNativeJsonRequestSupported(boolean z) {
        this.nativeJsonRequestSupported = z;
    }

    public MerchantPayOption getAddMoneyPayOption() {
        return this.addMoneyPayOption;
    }

    public void setAddMoneyPayOption(MerchantPayOption merchantPayOption2) {
        this.addMoneyPayOption = merchantPayOption2;
    }

    public MerchantPayOption getMerchantPayOption() {
        return this.merchantPayOption;
    }

    public void setMerchantPayOption(MerchantPayOption merchantPayOption2) {
        this.merchantPayOption = merchantPayOption2;
    }

    public String getPaymentFlow() {
        return this.paymentFlow;
    }

    public void setPaymentFlow(String str) {
        this.paymentFlow = str;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public ArrayList<RiskConvenienceFeeItem> getRiskConvenienceFee() {
        return this.riskConvenienceFee;
    }

    public void setRiskConvenienceFee(ArrayList<RiskConvenienceFeeItem> arrayList) {
        this.riskConvenienceFee = arrayList;
    }

    public String toString() {
        return "ClassPojo [addMoneyPayOption = " + this.addMoneyPayOption + ", merchantPayOption = " + this.merchantPayOption + ", paymentFlow = " + this.paymentFlow + ", resultInfo = " + this.resultInfo + "]";
    }

    public BinDetail getBinDetail() {
        return this.binDetail;
    }

    public void setBinDetail(BinDetail binDetail2) {
        this.binDetail = binDetail2;
    }

    public HasLowSuccess getHasLowSuccessRate() {
        return this.hasLowSuccessRate;
    }

    public void setHasLowSuccessRate(HasLowSuccess hasLowSuccess) {
        this.hasLowSuccessRate = hasLowSuccess;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String[] getAuthModes() {
        return this.authModes;
    }

    public void setAuthModes(String[] strArr) {
        this.authModes = strArr;
    }

    public MerchantDetails getMerchantDetails() {
        return this.merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails2) {
        this.merchantDetails = merchantDetails2;
    }

    public PromoCodeData getPromoCodeData() {
        return this.promoCodeData;
    }

    public void setPromoCodeData(PromoCodeData promoCodeData2) {
        this.promoCodeData = promoCodeData2;
    }

    public ArrayList<PaymentOffer> getPaymentOffers() {
        return this.paymentOffers;
    }

    public void setPaymentOffers(ArrayList<PaymentOffer> arrayList) {
        this.paymentOffers = arrayList;
    }

    public Boolean getEmiAvailable() {
        return this.isEmiAvailable;
    }

    public void setEmiAvailable(Boolean bool) {
        this.isEmiAvailable = bool;
    }

    public String getOneClickMaxAmount() {
        return this.oneClickMaxAmount;
    }

    public void setOneClickMaxAmount(String str) {
        this.oneClickMaxAmount = str;
    }

    public boolean isOneClickSupported() {
        return this.oneClickSupported;
    }

    public void setOneClickSupported(boolean z) {
        this.oneClickSupported = z;
    }

    public boolean isHybridDisabled() {
        return this.isHybridDisabled;
    }

    public boolean isWalletOnly() {
        Boolean bool = this.walletOnly;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public String getIconBaseUrl() {
        return this.iconBaseUrl;
    }

    public void setIconBaseUrl(String str) {
        this.iconBaseUrl = str;
    }

    public MandateAccountDetails getMandateAccountDetails() {
        return this.mandateAccountDetails;
    }

    public void setMandateAccountDetails(MandateAccountDetails mandateAccountDetails2) {
        this.mandateAccountDetails = mandateAccountDetails2;
    }

    public SimplifiedPaymentsOffer getSimplifiedPaymentsOffer() {
        return this.simplifiedPaymentsOffer;
    }

    public void setSimplifiedPaymentsOffer(SimplifiedPaymentsOffer simplifiedPaymentsOffer2) {
        this.simplifiedPaymentsOffer = simplifiedPaymentsOffer2;
    }

    public MerchantDetails getAddMoneyMerchantDetails() {
        return this.addMoneyMerchantDetails;
    }

    public boolean isPcfEnabled() {
        return this.pcfEnabled;
    }

    public void setPcfEnabled(boolean z) {
        this.pcfEnabled = z;
    }
}
