package net.one97.paytm.nativesdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.DeferredCheckoutCallbackListener;
import net.one97.paytm.nativesdk.app.OnOrderCreatedListener;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantDetails;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.RiskConvFeeModel;
import net.one97.paytm.nativesdk.common.model.RiskConvenienceFeeItem;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.model.SimplifiedPaymentsOffer;
import net.one97.paytm.nativesdk.databinding.SaveCardLayoutBinding;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickTransactionInfo;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.wallet.view.WalletView;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;

public class DirectPaymentBL {
    private static DirectPaymentBL _instance;
    private BankMandatePTCModel bankMandatePTCModel;
    private CJPayMethodResponse cjPayMethodResponse;
    private String custSdkVersion = "1.0.6";
    private String customerId;
    private String defaultSelectedPayOption = "";
    private DeferredCheckoutCallbackListener deferredCheckoutCallbackListener;
    private double emiMax = 0.0d;
    private double emiMin = 0.0d;
    private EmiChannelInfo emiViewSelectedEmiChannelInfo;
    private HashMap<String, Object> extraParamsPTC;
    private HashMap<String, Object> gtmStringValues;
    private String headerLabelText;
    private boolean isAddMoney = false;
    private boolean isAndFlowEnabled;
    private boolean isBankOffersAvailable;
    private boolean isCustSdkUpiPush = false;
    private boolean isDefferedCheckoutEnabled;
    private boolean isFetchPayCallRequired = true;
    private boolean isMultiItemEmiFlow = false;
    private boolean isNativePlusEnable = false;
    private boolean isOpeningAuto = true;
    private boolean isPPBUpiFlag = false;
    private boolean isPaytmOptionExists;
    private boolean isPaytmWalletChecked;
    private boolean isPromoCodeExist = false;
    private boolean isSubsCriptionFlow = false;
    private boolean isSubscriptionFirstSelected = true;
    private boolean isToCreateOrderPaytmSdk;
    private boolean isTransactionProcessing = false;
    private boolean isUpiOnBoarded = false;
    private boolean isWalletChecked;
    public boolean isWalletDisbledDueToBalance;
    private boolean isWalletOtpValidated = false;
    public i<String> lastInsufficuentAmountError;
    private SaveCardLayoutBinding lastRadioChecked;
    private SavedCardView lastSelectedEmiSavedView;
    private String mPromoCodeBankOfferAI;
    private OneClickTransactionInfo oneClickTransactionInfo;
    private OrFlowCallbackListener orFlowCallbackListener;
    private OnOrderCreatedListener orderCreatedListener;
    private String paymentFlowBankOffer = SDKConstants.NATIVE_SDK_NONE;
    private PaytmBaseView paytmBaseView;
    private PaytmSDKRequestClient requestClient;
    private String requestId;
    private List<RiskConvFeeModel> riskConvFeeModel;
    private HashMap<String, RiskConvenienceFeeItem> riskConvenienceFeeItemHashMap = new HashMap<>();
    private SelectedInstrument selectedInstrument;
    private String selectedPaymentMode;
    private SimplifiedPaymentsOffer simplifiedPaymentsOffer;
    private ISubventionProvider subventionProvider;
    private String transcationStatusResponse;
    private UpiOptionsModel upiOptionsModel;
    private String verticalName;
    private boolean visaOneClickEnabledGTM;

    public boolean isUpiOnBoarded() {
        return this.isUpiOnBoarded;
    }

    public void setUpiOnBoarded(boolean z) {
        this.isUpiOnBoarded = z;
    }

    public boolean isWalletOtpValidated() {
        return this.isWalletOtpValidated;
    }

    public void setWalletOtpValidated(boolean z) {
        this.isWalletOtpValidated = z;
    }

    public boolean isSubscriptionFirstSelected() {
        return this.isSubscriptionFirstSelected;
    }

    public void setSubscriptionFirstSelected(boolean z) {
        this.isSubscriptionFirstSelected = z;
    }

    public boolean isSubsCriptionFlow() {
        return this.isSubsCriptionFlow;
    }

    public boolean isWalletDisbledDueToBalance() {
        return this.isWalletDisbledDueToBalance;
    }

    public void setWalletDisbledDueToBalance(boolean z) {
        this.isWalletDisbledDueToBalance = z;
    }

    public void setSubsCriptionFlow(boolean z) {
        this.isSubsCriptionFlow = z;
    }

    public boolean isWalletChecked() {
        return this.isWalletChecked;
    }

    public void setWalletChecked(boolean z) {
        this.isWalletChecked = z;
    }

    public boolean isPaytmOptionExists() {
        return this.isPaytmOptionExists;
    }

    public void setPaytmOptionExists(boolean z) {
        this.isPaytmOptionExists = z;
    }

    public void setAddMoney(boolean z) {
        this.isAddMoney = z;
    }

    public boolean isAddMoney() {
        return this.isAddMoney;
    }

    public boolean isCreditDebitCardsAvailable() {
        try {
            if (this.cjPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments() == null || this.cjPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments().size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setEmiMax(double d2) {
        this.emiMax = d2;
    }

    public void setEmiMin(double d2) {
        this.emiMin = d2;
    }

    public double getEmiMin() {
        return this.emiMin;
    }

    public double getEmiMax() {
        return this.emiMax;
    }

    public static synchronized DirectPaymentBL getInstance() {
        DirectPaymentBL directPaymentBL;
        synchronized (DirectPaymentBL.class) {
            if (_instance == null) {
                _instance = new DirectPaymentBL();
            }
            directPaymentBL = _instance;
        }
        return directPaymentBL;
    }

    public MerchantDetails getMerchantDetails() {
        try {
            return this.cjPayMethodResponse.getBody().getMerchantDetails();
        } catch (Exception unused) {
            return null;
        }
    }

    public MerchantDetails getAddNPayMerchantDetails() {
        try {
            return this.cjPayMethodResponse.getBody().getAddMoneyMerchantDetails();
        } catch (Exception unused) {
            return null;
        }
    }

    public MandateAccountDetails getMerchantAccountDetails() {
        try {
            return this.cjPayMethodResponse.getBody().getMandateAccountDetails();
        } catch (Exception unused) {
            return null;
        }
    }

    public List<SavedMandateBanksItem> getSavedMandateBanksItemList() {
        try {
            return this.cjPayMethodResponse.getBody().getMerchantPayOption().getSavedMandateBanks();
        } catch (Exception unused) {
            return null;
        }
    }

    public void setResponse(CJPayMethodResponse cJPayMethodResponse) {
        if (cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null) {
            SDKUtility.dropBreadCrumbs("DirectPaymentBL", "cjrPayMethodResponse null is " + Log.getStackTraceString(new Throwable()));
        }
        this.cjPayMethodResponse = cJPayMethodResponse;
        if (!(cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getSubscriptionDetailsInfo() == null)) {
            if (cJPayMethodResponse.getBody().getSubscriptionDetailsInfo().isIsEnabled()) {
                getInstance().setSubsCriptionFlow(true);
            } else {
                getInstance().setSubsCriptionFlow(false);
            }
        }
        if (SDKConstants.ADDANDPAY.equalsIgnoreCase(getInstance().getPaymentFlowAvailable())) {
            SDKUtils.INSTANCE.addWalletToAddMoneyOptions(cJPayMethodResponse);
            SDKUtils.INSTANCE.addGiftVoucher(cJPayMethodResponse);
        }
        buildRiskConvenienceFeeMap();
        if (MerchantBL.getMerchantInstance().isAppInvoke() || getInstance().isSubsCriptionFlow() || MerchantBL.getMerchantInstance().isTransparentAppInvoke()) {
            SDKUtils.setMerchantDetails(cJPayMethodResponse);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMandateAccountType(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = -1953474717(0xffffffff8b905763, float:-5.559827E-32)
            java.lang.String r2 = "OTHERS"
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = "ISA"
            if (r0 == r1) goto L_0x003b
            r1 = -1704036199(0xffffffff9a6e7899, float:-4.9314664E-23)
            if (r0 == r1) goto L_0x0031
            r1 = 2142(0x85e, float:3.002E-42)
            if (r0 == r1) goto L_0x0027
            r1 = 72791(0x11c57, float:1.02002E-40)
            if (r0 == r1) goto L_0x001f
            goto L_0x0043
        L_0x001f:
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L_0x0043
            r8 = 0
            goto L_0x0044
        L_0x0027:
            java.lang.String r0 = "CA"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0043
            r8 = 2
            goto L_0x0044
        L_0x0031:
            java.lang.String r0 = "SAVINGS"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x003b:
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0043
            r8 = 3
            goto L_0x0044
        L_0x0043:
            r8 = -1
        L_0x0044:
            if (r8 == 0) goto L_0x004e
            if (r8 == r5) goto L_0x004e
            if (r8 == r4) goto L_0x004d
            if (r8 == r3) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r6 = r2
        L_0x004e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.DirectPaymentBL.getMandateAccountType(java.lang.String):java.lang.String");
    }

    public CJPayMethodResponse getCjPayMethodResponse() {
        return this.cjPayMethodResponse;
    }

    private void buildRiskConvenienceFeeMap() {
        CJPayMethodResponse cJPayMethodResponse = this.cjPayMethodResponse;
        if (cJPayMethodResponse != null && cJPayMethodResponse.getBody() != null && this.cjPayMethodResponse.getBody().getRiskConvenienceFee() != null) {
            Iterator<RiskConvenienceFeeItem> it2 = this.cjPayMethodResponse.getBody().getRiskConvenienceFee().iterator();
            while (it2.hasNext()) {
                RiskConvenienceFeeItem next = it2.next();
                this.riskConvenienceFeeItemHashMap.put(next.getPayMethod(), next);
            }
        }
    }

    public boolean isRiskConvenienceFeeMode() {
        return this.riskConvenienceFeeItemHashMap.size() > 0;
    }

    public RiskConvenienceFeeItem getRiskConvenienceFeeItem(String str) {
        return this.riskConvenienceFeeItemHashMap.get(str);
    }

    public String getRiskConvenienceFeeAmount(String str) {
        RiskConvenienceFeeItem riskConvenienceFeeItem = getRiskConvenienceFeeItem(str);
        if (riskConvenienceFeeItem == null) {
            return "";
        }
        double parseDouble = SDKUtility.parseDouble(riskConvenienceFeeItem.getFeePercent());
        return MerchantBL.getMerchantInstance().getWithoutDoubleAmount((SDKUtility.parseDouble(MerchantBL.getMerchantInstance().getAmount()) * parseDouble) / 100.0d);
    }

    public double getAmountWithRiskFee(String str, double d2) {
        RiskConvenienceFeeItem riskConvenienceFeeItem;
        if (getInstance().isRiskConvenienceFeeApplied(str) && (riskConvenienceFeeItem = getRiskConvenienceFeeItem(str)) != null) {
            return d2 + ((SDKUtility.parseDouble(riskConvenienceFeeItem.getFeePercent()) * d2) / 100.0d);
        }
        return d2;
    }

    public boolean isRiskConvenienceFeeApplied(String str) {
        RiskConvenienceFeeItem riskConvenienceFeeItem;
        if (getInstance().isDefferedCheckoutEnabled && (riskConvenienceFeeItem = this.riskConvenienceFeeItemHashMap.get(str)) != null && SDKUtility.parseDouble(riskConvenienceFeeItem.getFeePercent()) > 0.0d) {
            return true;
        }
        return false;
    }

    public MerchantPayOption getMerchantPayMethod() {
        Body body;
        if (SDKConstants.ADDANDPAY.equalsIgnoreCase(getSelectedPaymentMode())) {
            return getAddMoneyPayMethod();
        }
        CJPayMethodResponse cJPayMethodResponse = this.cjPayMethodResponse;
        if (cJPayMethodResponse == null || (body = cJPayMethodResponse.getBody()) == null) {
            return null;
        }
        return body.getMerchantPayOption();
    }

    public MerchantPayOption getAddMoneyPayMethod() {
        Body body;
        CJPayMethodResponse cJPayMethodResponse = this.cjPayMethodResponse;
        if (cJPayMethodResponse == null || (body = cJPayMethodResponse.getBody()) == null) {
            return null;
        }
        return body.getAddMoneyPayOption();
    }

    public String getPaymentFlowAvailable() {
        Body body;
        CJPayMethodResponse cJPayMethodResponse = this.cjPayMethodResponse;
        if (cJPayMethodResponse == null || (body = cJPayMethodResponse.getBody()) == null || body.getPaymentFlow() == null) {
            return SDKConstants.NATIVE_SDK_NONE;
        }
        return body.getPaymentFlow();
    }

    public String getSelectedPaymentMode() {
        return this.selectedPaymentMode;
    }

    public void setSelectedPaymentMode(String str) {
        this.selectedPaymentMode = str;
    }

    public boolean isWalletEnabledOnMerchant() {
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod == null || (paymentModes = merchantPayMethod.getPaymentModes()) == null) {
            return false;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equalsIgnoreCase(PayMethodType.BALANCE.name()) && (next.getIsDisabled() == null || !next.getIsDisabled().getStatus())) {
                return true;
            }
        }
        return false;
    }

    public String getInstrumentName(String str) {
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod == null || (paymentModes = merchantPayMethod.getPaymentModes()) == null) {
            return null;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equals(str) && !arePayChannelOptionsEmpty(next)) {
                return next.getDisplayName();
            }
        }
        return null;
    }

    public String getInstrumentBalance(PayMethodType payMethodType) {
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod == null) {
            return null;
        }
        ArrayList<PaymentModes> paymentModes = merchantPayMethod.getPaymentModes();
        if (!(merchantPayMethod == null || paymentModes == null)) {
            for (PaymentModes next : paymentModes) {
                if (next.getPaymentMode().equals(payMethodType.name()) && !arePayChannelOptionsEmpty(next)) {
                    PayChannelOptions payChannelOptions = next.getPayChannelOptions().get(0);
                    if (!isBalanceInfoEmpty(payChannelOptions)) {
                        return payChannelOptions.getBalanceInfo().getAccountBalance().getValue();
                    }
                }
            }
        }
        return null;
    }

    private boolean arePayChannelOptionsEmpty(PaymentModes paymentModes) {
        return paymentModes.getPayChannelOptions() == null || paymentModes.getPayChannelOptions().size() == 0;
    }

    private boolean isBalanceInfoEmpty(PayChannelOptions payChannelOptions) {
        return payChannelOptions.getBalanceInfo() == null || payChannelOptions.getBalanceInfo().getAccountBalance() == null;
    }

    public ArrayList<SavedInstruments> getMerchantSavedInstruments() {
        MerchantPayOption merchantPayOption;
        CJPayMethodResponse cJPayMethodResponse = this.cjPayMethodResponse;
        if (cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || (merchantPayOption = this.cjPayMethodResponse.getBody().getMerchantPayOption()) == null) {
            return null;
        }
        return merchantPayOption.getSavedInstruments();
    }

    public boolean isPaytmInstrumentAvailable(String str) {
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        ArrayList<PaymentModes> paymentModes = merchantPayMethod.getPaymentModes();
        if (!(merchantPayMethod == null || paymentModes == null)) {
            for (int i2 = 0; i2 < paymentModes.size(); i2++) {
                if (paymentModes.get(i2).getPaymentMode().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setPaytmBaseView(PaytmBaseView paytmBaseView2) {
        this.paytmBaseView = paytmBaseView2;
        PaytmBaseView paytmBaseView3 = this.paytmBaseView;
        if (paytmBaseView3 != null) {
            paytmBaseView3.setSelected(true);
        }
        if (PaytmSDK.getAppContext() != null) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.UNCHECK_VIEWS_ACTION_FILTER);
            a.a(PaytmSDK.getAppContext()).a(intent);
        }
    }

    public void closeOpnedView() {
        PaytmBaseView paytmBaseView2 = this.paytmBaseView;
        if (paytmBaseView2 != null) {
            if (!(paytmBaseView2 instanceof WalletView) || (getInstance().isSubsCriptionFlow && !getInstance().isWalletOtpValidated)) {
                this.paytmBaseView.setSelected(false);
            }
            this.paytmBaseView.closeView();
        }
    }

    public PaymentModes getInstrument(PayMethodType payMethodType) {
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod == null || (paymentModes = merchantPayMethod.getPaymentModes()) == null) {
            return null;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equals(payMethodType.name())) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<PaymentModes> getMerchantModes() {
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod != null) {
            return merchantPayMethod.getPaymentModes();
        }
        return null;
    }

    public ArrayList<PaymentModes> getAddMoneyModes() {
        MerchantPayOption addMoneyPayMethod = getAddMoneyPayMethod();
        if (addMoneyPayMethod != null) {
            return addMoneyPayMethod.getPaymentModes();
        }
        return null;
    }

    public PaymentModes getInstrument(String str) {
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayMethod = getMerchantPayMethod();
        if (merchantPayMethod == null || (paymentModes = merchantPayMethod.getPaymentModes()) == null) {
            return null;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equalsIgnoreCase(str) && !arePayChannelOptionsEmpty(next)) {
                return next;
            }
        }
        return null;
    }

    public PaymentModes getAddMoneyInstrument(PayMethodType payMethodType) {
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption addMoneyPayMethod = getAddMoneyPayMethod();
        if (addMoneyPayMethod == null || (paymentModes = addMoneyPayMethod.getPaymentModes()) == null) {
            return null;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equals(payMethodType.name()) && !arePayChannelOptionsEmpty(next)) {
                return next;
            }
        }
        return null;
    }

    public double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public boolean isWalletAmountSufficientToPay() {
        String instrumentBalance = getInstrumentBalance(PayMethodType.BALANCE);
        if (TextUtils.isEmpty(instrumentBalance)) {
            return false;
        }
        int compare = Double.compare(parseDouble(instrumentBalance), parseDouble(MerchantBL.getMerchantInstance().getAmount().replace(AppConstants.COMMA, "")) + ConvenienceFeeController.getInstance().getTotalConvenienceFeePayable());
        if (compare > 0) {
            System.out.println("d1 is greater than d2");
            return true;
        } else if (compare < 0) {
            System.out.println("d1 is less than d2");
            return false;
        } else {
            System.out.println("d1 is equal to d2");
            return true;
        }
    }

    public boolean isRemainingAmountInDecimals() {
        String instrumentBalance = getInstrumentBalance(PayMethodType.BALANCE);
        if (TextUtils.isEmpty(instrumentBalance)) {
            return false;
        }
        try {
            Double valueOf = Double.valueOf(Double.parseDouble(instrumentBalance));
            Double valueOf2 = Double.valueOf(Double.parseDouble(MerchantBL.getMerchantInstance().getAmount().replace(AppConstants.COMMA, "")));
            if (valueOf.doubleValue() >= valueOf2.doubleValue() || valueOf2.doubleValue() - valueOf.doubleValue() >= 1.0d) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public String getDifferentialAmount() {
        double parseDouble = parseDouble(getInstrumentBalance(PayMethodType.BALANCE));
        return MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(Double.toString(parseDouble(MerchantBL.getMerchantInstance().getAmount().replace(AppConstants.COMMA, "")) - parseDouble)).doubleValue());
    }

    public SelectedInstrument getSelectedInstrument() {
        return this.selectedInstrument;
    }

    public void setSelectedInstrument(SelectedInstrument selectedInstrument2) {
        this.selectedInstrument = selectedInstrument2;
    }

    public PaytmBaseView getPaytmBaseView() {
        return this.paytmBaseView;
    }

    public boolean isNativeJsonRequestSupported() {
        if (isNativePlusEnable()) {
            return true;
        }
        if (getInstance() == null || getInstance().getCjPayMethodResponse() == null || getInstance().getCjPayMethodResponse().getBody() == null) {
            return false;
        }
        return getInstance().getCjPayMethodResponse().getBody().isNativeJsonRequestSupported();
    }

    public boolean isVisaOneClickEnabledForOffers() {
        return isVisaOneClickEnabled() && isVSCPOffersEnableGTM();
    }

    private boolean isVSCPOffersEnableGTM() {
        return GTMLoader.getBoolean(SDKConstants.VISA_GTM_BANK_OFFER, false);
    }

    public boolean isTransparentWebviewEnabled() {
        return GTMLoader.getBoolean(SDKConstants.TRANSPARENT_WEBVIEW_FLOW, true);
    }

    public boolean isAddMoneyPromotionTagEnable() {
        return GTMLoader.getBoolean(SDKConstants.ADDMONEY_FEE_PROMOTION_TAG, true);
    }

    public boolean isVisaOneClickEnabled() {
        if (isNativeJsonRequestSupported() && isVisaOneClickEnabledGTM() && Build.VERSION.SDK_INT >= 19 && getInstance() != null && getInstance().getCjPayMethodResponse() != null && getInstance().getCjPayMethodResponse().getBody() != null) {
            return true;
        }
        return false;
    }

    public boolean isBankMandateEnabled() {
        return GTMLoader.getBoolean(SDKConstants.NATIVE_PG_ENABLED_BANK_MANDATE, true);
    }

    public boolean isInstrumentEnabledOnAddMoney() {
        return getInstance() == null || getInstance().getCjPayMethodResponse() == null || getInstance().getCjPayMethodResponse().getBody() == null || getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption() == null || getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getPaymentModes() == null || getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getPaymentModes().size() <= 0;
    }

    public boolean isInstrumentEnabledOnMerchant() {
        return getInstance() == null || getInstance().getCjPayMethodResponse() == null || getInstance().getCjPayMethodResponse().getBody() == null || getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption() == null || getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getPaymentModes() == null || getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getPaymentModes().size() <= 0;
    }

    public String getTranscationStatusResponse() {
        return this.transcationStatusResponse;
    }

    public void setTranscationStatusResponse(String str) {
        this.transcationStatusResponse = str;
    }

    public boolean isPaytmWalletChecked() {
        return this.isPaytmWalletChecked;
    }

    public void setPaytmWalletChecked(boolean z, Context context) {
        this.isPaytmWalletChecked = z;
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.EMI_REFRESH_FILTER);
            intent.putExtra("data", this.isPaytmWalletChecked);
            a.a(context.getApplicationContext()).a(intent);
        }
    }

    public void clearInstance() {
        this.cjPayMethodResponse = null;
        this.paytmBaseView = null;
        this.selectedInstrument = null;
        this.transcationStatusResponse = null;
        this.lastInsufficuentAmountError = null;
        this.subventionProvider = null;
        this.requestClient = null;
        _instance = null;
    }

    public boolean isFetchPayCallRequired() {
        if (getInstance().getCjPayMethodResponse() == null || MerchantBL.getMerchantInstance().getVpaFetch() == null) {
            return this.isFetchPayCallRequired;
        }
        return false;
    }

    public void setFetchPayCallRequired(boolean z) {
        this.isFetchPayCallRequired = z;
    }

    public void setPromoCodeExist(boolean z) {
        this.isPromoCodeExist = z;
    }

    public boolean isPromoCodeExist() {
        return this.isPromoCodeExist;
    }

    public void setUpiOptionsModel(UpiOptionsModel upiOptionsModel2) {
        this.upiOptionsModel = upiOptionsModel2;
    }

    public UpiOptionsModel getUpiOptionsModel() {
        return this.upiOptionsModel;
    }

    public void setLastRadioChecked(SaveCardLayoutBinding saveCardLayoutBinding) {
        this.lastRadioChecked = saveCardLayoutBinding;
    }

    public SaveCardLayoutBinding getLastRadioChecked() {
        return this.lastRadioChecked;
    }

    public void setDefaultSelectedPayOption(String str) {
        this.defaultSelectedPayOption = str;
    }

    public String getDefaultSelectedPayOption() {
        return this.defaultSelectedPayOption;
    }

    public void setOpeningAuto(boolean z) {
        this.isOpeningAuto = z;
    }

    public boolean isOpeningAuto() {
        return this.isOpeningAuto;
    }

    public void setToCreateOrderPaytmSdk(boolean z) {
        this.isToCreateOrderPaytmSdk = z;
    }

    public boolean isToCreateOrderPaytmSdk() {
        return this.isToCreateOrderPaytmSdk;
    }

    public void setOrderCreatedListener(OnOrderCreatedListener onOrderCreatedListener) {
        this.orderCreatedListener = onOrderCreatedListener;
    }

    public OnOrderCreatedListener getOrderCreatedListener() {
        return this.orderCreatedListener;
    }

    public void generateRequestId() {
        this.requestId = SDKUtility.generateRequestId();
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setBankOffersAvailable(boolean z) {
        this.isBankOffersAvailable = z;
    }

    public boolean isBankOffersAvailable() {
        return this.isBankOffersAvailable;
    }

    public void setRequestClient(PaytmSDKRequestClient paytmSDKRequestClient) {
        this.requestClient = paytmSDKRequestClient;
        setDefferedCheckoutEnabled(true);
    }

    public PaytmSDKRequestClient getRequestClient() {
        return this.requestClient;
    }

    public boolean isDefferedCheckoutEnabled() {
        return this.isDefferedCheckoutEnabled;
    }

    public void setDefferedCheckoutEnabled(boolean z) {
        this.isDefferedCheckoutEnabled = z;
    }

    public boolean isAndFlowEnabled() {
        return this.isAndFlowEnabled;
    }

    public void setAndFlowEnabled(boolean z) {
        this.isAndFlowEnabled = z;
    }

    public void setEmiViewSelectedEmiChannelInfo(EmiChannelInfo emiChannelInfo) {
        this.emiViewSelectedEmiChannelInfo = emiChannelInfo;
    }

    public EmiChannelInfo getEmiViewSelectedEmiChannelInfo() {
        return this.emiViewSelectedEmiChannelInfo;
    }

    public void setLastSelectedEmiSavedView(SavedCardView savedCardView) {
        this.lastSelectedEmiSavedView = savedCardView;
    }

    public SavedCardView getLastSelectedEmiSavedView() {
        return this.lastSelectedEmiSavedView;
    }

    public boolean isPPBUpiFlag() {
        return this.isPPBUpiFlag;
    }

    /* access modifiers changed from: package-private */
    public void setPPBUpiFlag(boolean z) {
        this.isPPBUpiFlag = z;
    }

    public OrFlowCallbackListener getOrFlowCallbackListener() {
        return this.orFlowCallbackListener;
    }

    /* access modifiers changed from: package-private */
    public void setOrFlowCallbackListener(OrFlowCallbackListener orFlowCallbackListener2) {
        this.orFlowCallbackListener = orFlowCallbackListener2;
    }

    public DeferredCheckoutCallbackListener getDeferredCheckoutCallbackListener() {
        return this.deferredCheckoutCallbackListener;
    }

    /* access modifiers changed from: package-private */
    public void setDeferredCheckoutCallbackListener(DeferredCheckoutCallbackListener deferredCheckoutCallbackListener2) {
        this.deferredCheckoutCallbackListener = deferredCheckoutCallbackListener2;
    }

    /* access modifiers changed from: package-private */
    public void setHeaderLabelText(String str) {
        this.headerLabelText = str;
    }

    public String getHeaderLabelText() {
        return this.headerLabelText;
    }

    public boolean isMultiItemEmiFlow() {
        return this.isMultiItemEmiFlow;
    }

    public void setMultiItemEmiFlow(boolean z) {
        this.isMultiItemEmiFlow = z;
    }

    /* access modifiers changed from: package-private */
    public void setSubventionProvider(ISubventionProvider iSubventionProvider) {
        this.subventionProvider = iSubventionProvider;
        this.isMultiItemEmiFlow = true;
    }

    public ISubventionProvider getSubventionProvider() {
        return this.subventionProvider;
    }

    public void setGTMStringValues(HashMap<String, Object> hashMap) {
        this.gtmStringValues = hashMap;
    }

    public HashMap<String, Object> getGtmStringValues() {
        return this.gtmStringValues;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getVerticalName() {
        if (TextUtils.isEmpty(this.verticalName)) {
            return SDKConstants.GA_PAYMENT_GATEWAY;
        }
        return this.verticalName;
    }

    public void setVerticalName(String str) {
        this.verticalName = str;
    }

    public boolean isVisaOneClickEnabledGTM() {
        return this.visaOneClickEnabledGTM;
    }

    public void setVisaOneClickEnabledGTM(boolean z) {
        this.visaOneClickEnabledGTM = z;
    }

    public void setExtraParamsPTC(HashMap<String, Object> hashMap) {
        this.extraParamsPTC = hashMap;
    }

    public HashMap<String, Object> getExtraParamsPTC() {
        return this.extraParamsPTC;
    }

    public void setOneClickTranscationListener(OneClickTransactionInfo oneClickTransactionInfo2) {
        this.oneClickTransactionInfo = oneClickTransactionInfo2;
    }

    public OneClickTransactionInfo getOneClickTranscationListener() {
        return this.oneClickTransactionInfo;
    }

    public void setNativePlusEnabled(boolean z) {
        this.isNativePlusEnable = z;
    }

    public boolean isNativePlusEnable() {
        return this.isNativePlusEnable;
    }

    public void setTransactionProcessing(boolean z) {
        this.isTransactionProcessing = z;
    }

    public boolean isTransactionProcessing() {
        return this.isTransactionProcessing;
    }

    public BankMandatePTCModel getBankMandatePTCModel() {
        return this.bankMandatePTCModel;
    }

    public void setBankMandatePTCModel(BankMandatePTCModel bankMandatePTCModel2) {
        this.bankMandatePTCModel = bankMandatePTCModel2;
    }

    public SimplifiedPaymentsOffer getSimplifiedPaymentsOffer() {
        return this.simplifiedPaymentsOffer;
    }

    public void setSimplifiedPaymentsOffer(SimplifiedPaymentsOffer simplifiedPaymentsOffer2) {
        this.simplifiedPaymentsOffer = simplifiedPaymentsOffer2;
    }

    public String getPromoCodeBankOfferAI() {
        return this.mPromoCodeBankOfferAI;
    }

    public void setPromoCodeBankOfferAI(String str) {
        this.mPromoCodeBankOfferAI = str;
    }

    public String getPaymentFlowBankOffer() {
        return this.paymentFlowBankOffer;
    }

    public void setPaymentFlowBankOffer(String str) {
        this.paymentFlowBankOffer = str;
    }

    /* access modifiers changed from: package-private */
    public void setUpiPushCustomSDKFlow(boolean z) {
        this.isCustSdkUpiPush = z;
    }

    public boolean isCustSdkUpiPush() {
        return this.isCustSdkUpiPush;
    }

    public void setCustSdKVersion(String str) {
        this.custSdkVersion = str;
    }

    public String getCustSdkVersion() {
        return this.custSdkVersion;
    }

    public void setRiskConvFeeData(List<RiskConvFeeModel> list) {
        this.riskConvFeeModel = list;
    }

    public List<RiskConvFeeModel> getRiskConvFeeModel() {
        return this.riskConvFeeModel;
    }

    public String getBankName() {
        SelectedInstrument selectedInstrument2 = this.selectedInstrument;
        return (selectedInstrument2 == null || selectedInstrument2.getSecondaryName() == null) ? "" : this.selectedInstrument.getSecondaryName();
    }
}
