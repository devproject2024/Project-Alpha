package net.one97.paytm.nativesdk.instruments.netbanking.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.VolleyError;
import com.bumptech.glide.b;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.UpiPushCallbackListener;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.HasLowSuccess;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingListener;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingProvidersActivity;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingView;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class NetBankingViewModel extends BaseViewModel {
    private static final String TAG = NetBankingViewModel.class.getCanonicalName();
    public i<String> amount = new i<>("");
    /* access modifiers changed from: private */
    public List<PayChannelOptions> bankList = new ArrayList();
    /* access modifiers changed from: private */
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BankData bankData = (BankData) intent.getParcelableExtra(EMIConstants.SELECTED_BANK);
            if (bankData != null) {
                String bankName = bankData.getBankName();
                String unused = NetBankingViewModel.this.selectedChannelCode = bankData.getBankCode();
                String unused2 = NetBankingViewModel.this.selectedChannelName = bankData.getBankName();
                String bankLogoUrl = bankData.getBankLogoUrl();
                DirectPaymentBL.getInstance().setSelectedInstrument(NetBankingViewModel.this.selectedInstrument);
                NetBankingViewModel.this.listener.closeCachierSheet();
                try {
                    if (NetBankingViewModel.this.isBroadcastRegistered) {
                        a.a(NetBankingViewModel.this.mContext.getApplicationContext()).a(NetBankingViewModel.this.broadcastReceiver);
                    }
                } catch (Exception unused3) {
                    LogUtility.e("NetBankingViewModel", "unregistering failed.");
                }
                if (NetBankingViewModel.this.bankList != null && NetBankingViewModel.this.bankList.size() > 0) {
                    int i2 = 0;
                    while (i2 < NetBankingViewModel.this.bankList.size()) {
                        if (TextUtils.isEmpty(((PayChannelOptions) NetBankingViewModel.this.bankList.get(i2)).getChannelName()) || !((PayChannelOptions) NetBankingViewModel.this.bankList.get(i2)).getChannelName().equalsIgnoreCase(bankName)) {
                            i2++;
                        } else {
                            NetBankingViewModel netBankingViewModel = NetBankingViewModel.this;
                            netBankingViewModel.bankSelected((PayChannelOptions) netBankingViewModel.bankList.get(i2));
                            NetBankingViewModel netBankingViewModel2 = NetBankingViewModel.this;
                            netBankingViewModel2.fetchConvenienceFee((PayChannelOptions) netBankingViewModel2.bankList.get(i2), "");
                            NetBankingViewModel.this.listener.selectItemOnAdapter(i2);
                            NetBankingViewModel.this.listener.getBankOffer((PayChannelOptions) NetBankingViewModel.this.bankList.get(i2));
                            NetBankingViewModel.this.hideUpiConsentCheckbox();
                            NetBankingViewModel.this.hideUpiPayOption();
                            return;
                        }
                    }
                }
                NetBankingViewModel.this.setLastChannelSelected((PayChannelOptions) null);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    NetBankingViewModel netBankingViewModel3 = NetBankingViewModel.this;
                    netBankingViewModel3.getBankOffersForSelectedChannel(netBankingViewModel3.selectedChannelCode);
                } else {
                    NetBankingViewModel netBankingViewModel4 = NetBankingViewModel.this;
                    netBankingViewModel4.fetchConvenienceFee((PayChannelOptions) null, netBankingViewModel4.selectedChannelCode);
                }
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_NB_BANK_SELECTED, bankName));
                }
                NetBankingViewModel.this.listener.selectItemOnAdapter(-1);
                NetBankingViewModel.this.listener.updateBankIcon(bankLogoUrl);
                NetBankingViewModel.this.otherBankText.set(bankName);
                NetBankingViewModel.this.tickImage.set(0);
                NetBankingViewModel.this.proceedButtonVisiblity.set(0);
                NetBankingViewModel.this.setPaySecurelyText();
                NetBankingViewModel netBankingViewModel5 = NetBankingViewModel.this;
                netBankingViewModel5.isOtherBankSelected = true;
                netBankingViewModel5.getBankOffersForSelectedChannel(netBankingViewModel5.selectedChannelCode);
                NetBankingViewModel netBankingViewModel6 = NetBankingViewModel.this;
                netBankingViewModel6.showUpiConsentCheckbox(netBankingViewModel6.selectedChannelCode);
            }
        }
    };
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public boolean isBroadcastRegistered = false;
    private boolean isCalledFromCashierSheet;
    public boolean isOtherBankSelected = false;
    private PayChannelOptions lastChannelSelected;
    /* access modifiers changed from: private */
    public NetBankingListener listener;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mIsLoggedIn;
    private PaymentModes netBanking;
    public ObservableInt netBankingBankListVisiblity = new ObservableInt();
    public i<String> netBankingTitle = new i<>();
    private double otherBankConvFee;
    public i<String> otherBankLoaderMsg = new i<>("");
    public ObservableInt otherBankLoaderVisibility = new ObservableInt(8);
    public i<String> otherBankText;
    public VpaBankAccountDetail otherSelectedVpa;
    public i<String> paySecurelyText = new i<>();
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    public ObservableInt proceedButtonVisiblity = new ObservableInt(8);
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    /* access modifiers changed from: private */
    public String selectedChannelCode;
    /* access modifiers changed from: private */
    public String selectedChannelName;
    /* access modifiers changed from: private */
    public SelectedInstrument selectedInstrument;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer selectedPaymentOffer;
    public ObservableInt showOtherBankVisiblity = new ObservableInt();
    public ObservableInt tickImage = new ObservableInt(8);
    public ObservableBoolean upiCheckboxChecked = new ObservableBoolean(true);
    public ObservableInt upiCheckboxLayoutVisibility = new ObservableInt(8);
    public i<String> upiConsentBoxText = new i<>();
    public i<String> upiPayOptionText = new i<>();
    public ObservableInt upiPayOptionVisibility = new ObservableInt(8);

    public PayChannelOptions getLastChannelSelected() {
        return this.lastChannelSelected;
    }

    public void setLastChannelSelected(PayChannelOptions payChannelOptions) {
        this.lastChannelSelected = payChannelOptions;
    }

    public NetBankingViewModel(Context context, PaymentModes paymentModes, NetBankingListener netBankingListener, boolean z, boolean z2) {
        super(context, netBankingListener);
        this.netBanking = paymentModes;
        this.otherBankText = new i<>(context.getResources().getString(R.string.select_from_all_other_banks));
        setBankList();
        this.netBankingBankListVisiblity.set(8);
        this.showOtherBankVisiblity.set(8);
        this.netBankingTitle.set(paymentModes.getDisplayName());
        this.listener = netBankingListener;
        netBankingListener.updateBankIcon((String) null);
        this.mContext = context;
        this.mIsLoggedIn = z;
        this.isCalledFromCashierSheet = z2;
    }

    public void proceedClicked(View view) {
        Context context;
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_CONSENT_STATUS, String.valueOf(this.upiCheckboxChecked.get()), "net_banking|" + getSelectedChannelName(), MerchantBL.getMerchantInstance().getMid()));
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_PAYMENT_CONFIRMATION, SDKConstants.GA_NB_BANK_SELECTION_PAYMENT_CONFIRMED, getSelectedChannelName()));
        if (SDKUtility.isHybridCase()) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_NETBANKING, SDKConstants.GA_KEY_HYBRID, sb.toString(), ""));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_NETBANKING, SDKConstants.GA_KEY_NEW, sb2.toString(), ""));
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_NB));
        }
        if (SDKUtility.shouldShowValidatePromoError() && (this.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
            setValidatePromoText();
        } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context = this.mContext) == null) {
            goForTransaction(view);
            if (this.upiCheckboxLayoutVisibility.get() == 0) {
                makeUpiConsentApiRequest(getSelectedChannelCode(), this.upiCheckboxChecked.get());
            }
        } else {
            Toast.makeText(this.mContext, context.getString(R.string.otp_not_validated), 0).show();
        }
    }

    public void refreshLayout() {
        setPaySecurelyText();
        if (getLastChannelSelected() != null) {
            getBankOffers(getLastChannelSelected());
        }
        if (!TextUtils.isEmpty(this.selectedChannelCode) && this.isOtherBankSelected) {
            showUpiConsentCheckbox(this.selectedChannelCode);
            getBankOffersForSelectedChannel(this.selectedChannelCode);
        }
    }

    public void setBankListVisiblity(View view) {
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        showHideBankList();
        if (SDKUtility.isHybridCase()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_NETBANKING, SDKConstants.GA_KEY_HYBRID));
        } else {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_NETBANKING, SDKConstants.GA_KEY_NEW));
        }
    }

    public void showHideBankList() {
        if (this.netBankingBankListVisiblity.get() != 0) {
            this.netBankingBankListVisiblity.set(0);
            this.showOtherBankVisiblity.set(0);
            this.listener.onBankListVisible();
            this.listener.changeArrowIcon(true);
            this.radioChecked.set(true);
            if (this.isOtherBankSelected) {
                showUpiConsentCheckbox(this.selectedChannelCode);
                setAmountIfNeeded();
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffersForSelectedChannel(this.selectedChannelCode);
                } else {
                    fetchConvenienceFee((PayChannelOptions) null, this.selectedChannelCode);
                }
                this.proceedButtonVisiblity.set(0);
            } else {
                hideUpiConsentCheckbox();
                this.amount.set("");
                this.proceedButtonVisiblity.set(8);
            }
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_NB, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                if (SDKConstants.ADDANDPAY.equals(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, SDKConstants.AI_KEY_NB));
                    return;
                }
                return;
            }
            return;
        }
        hideUpiConsentCheckbox();
        this.amount.set("");
        this.convFeeTextVisibility.set(8);
        this.convFeeText.set(new SpannableString(""));
        this.proceedButtonVisiblity.set(8);
        this.netBankingBankListVisiblity.set(8);
        this.showOtherBankVisiblity.set(8);
        this.listener.changeArrowIcon(false);
        DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
        this.radioChecked.set(false);
    }

    private void setBankList() {
        this.bankList = this.netBanking.getPayChannelOptions();
    }

    public List<PayChannelOptions> getBankList() {
        return this.bankList;
    }

    public static void loadImage(ImageView imageView, String str) {
        LogUtility.d(TAG, "Image - ".concat(String.valueOf(str)));
        try {
            Context context = imageView.getContext();
            if ((context instanceof AppCompatActivity) && !((AppCompatActivity) context).isFinishing()) {
                b.b(context.getApplicationContext()).a(str).a(imageView);
            }
        } catch (IllegalArgumentException e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void setLowSuccessVisiblity(View view, HasLowSuccess hasLowSuccess) {
        if (hasLowSuccess != null) {
            view.setVisibility(hasLowSuccess.getStatus() ? 0 : 4);
        }
    }

    public void onShowOtherBankClick(View view) {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.OTHER_OPTION_NB, "Net Banking", ""));
        a.a(this.mContext.getApplicationContext()).a(this.broadcastReceiver, new IntentFilter(SDKConstants.NET_BANKING_ACTION_FILTER));
        this.isBroadcastRegistered = true;
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mContext;
        Intent intent = new Intent(appCompatActivity, NetBankingProvidersActivity.class);
        intent.putExtra("a", this.mIsLoggedIn);
        intent.putExtra(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.otherBankText.get());
        intent.putExtra(SDKConstants.IS_CASHIER_SHEET, this.isCalledFromCashierSheet);
        hideUpiConsentCheckbox();
        hideUpiPayOption();
        appCompatActivity.startActivity(intent);
    }

    private void goForTransaction(View view) {
        HashMap<String, String> nBTranscationParam = PayUtility.getNBTranscationParam(this.netBanking.getPaymentMode(), this.selectedChannelCode);
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(this.selectedChannelCode)) {
            paytmAssistParams.setBankCode(this.selectedChannelCode);
        }
        paytmAssistParams.setPayType("NB");
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), nBTranscationParam);
        if (!TextUtils.isEmpty(this.selectedChannelCode)) {
            paymentInstrument.setBankCode(this.selectedChannelCode);
        }
        paymentInstrument.setPayType("NB");
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_NETBANKING);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.mContext, "Net banking", paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        if (SDKUtility.isOfferValid(this.selectedPaymentOffer)) {
            transactionProcessor.setOfferBody(new f().b(this.selectedPaymentOffer));
        }
        transactionProcessor.setPaymentIntent(getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
        goForTransaction((View) null);
    }

    public void bankSelectedProceedClicked(View view) {
        goForTransaction(view);
    }

    public void setSelectedInstrument(PayChannelOptions payChannelOptions) {
        this.cashBackTextVisibility.set(8);
        this.bankOfferVisibility.set(8);
        this.selectedInstrument = new SelectedInstrument();
        this.selectedInstrument.setPrimaryName(this.netBanking.getDisplayName());
        this.selectedInstrument.setSecondaryName(payChannelOptions.getChannelName());
        this.selectedInstrument.setBaseViewModel(this);
        this.selectedChannelCode = payChannelOptions.getChannelCode();
        this.selectedChannelName = payChannelOptions.getChannelName();
        if (SDKUtility.isHybridCase() && payChannelOptions.getHybridPaymentOffer() != null) {
            this.selectedPaymentOffer = payChannelOptions.getHybridPaymentOffer();
        } else if (!SDKUtility.isHybridCase() && payChannelOptions.getPaymentOffer() != null) {
            this.selectedPaymentOffer = payChannelOptions.getPaymentOffer();
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_NB_BANK_SELECTED, this.selectedChannelCode));
        }
        this.isOtherBankSelected = false;
        DirectPaymentBL.getInstance().setSelectedInstrument(this.selectedInstrument);
        this.listener.closeCachierSheet();
    }

    public void bankSelected(PayChannelOptions payChannelOptions) {
        this.proceedButtonVisiblity.set(8);
        this.otherBankText.set(this.mContext.getResources().getString(R.string.select_from_all_other_banks));
        this.convFeeText.set(new SpannableString(""));
        this.convFeeTextVisibility.set(8);
        hideUpiConsentCheckbox();
        hideUpiPayOption();
        this.amount.set("");
        this.tickImage.set(8);
        this.listener.updateBankIcon((String) null);
        PayChannelOptions payChannelOptions2 = this.lastChannelSelected;
        if (payChannelOptions2 != null) {
            payChannelOptions2.isGreenTickVisible.set(false);
            this.lastChannelSelected.bankSelectionProceedVisible.set(false);
            this.lastChannelSelected.lowSuccessVisibility.set(8);
        }
        payChannelOptions.isGreenTickVisible.set(true);
        payChannelOptions.bankSelectionProceedVisible.set(true);
        if (payChannelOptions.getHasLowSuccess() == null || !payChannelOptions.getHasLowSuccess().getStatus()) {
            payChannelOptions.lowSuccessVisibility.set(8);
        } else {
            payChannelOptions.lowSuccessVisibility.set(0);
        }
        this.lastChannelSelected = payChannelOptions;
    }

    private void setAmountIfNeeded(PayChannelOptions payChannelOptions) {
        if (payChannelOptions != null) {
            payChannelOptions.amount.set("");
        }
    }

    public void deselectView() {
        this.selectedPaymentOffer = null;
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        setPaySecurelyText();
    }

    /* access modifiers changed from: private */
    public void getBankOffersForSelectedChannel(final String str) {
        this.selectedPaymentOffer = null;
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            paymentOption.setPayMethod(PayMethodType.NET_BANKING.name());
            paymentOption.setBankCode(this.selectedChannelCode);
            this.listener.disableProceedButton();
            showLoading(this.mContext.getString(R.string.native_checking_offers));
            this.bankOfferVisibility.set(8);
            this.bankOfferText.set(new SpannableString(""));
            this.cashBackTextVisibility.set(8);
            this.listener.startCheckingOfferAnimation();
            setPaySecurelyText();
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private String localSelectedChannelCode = str;

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    NetBankingViewModel.this.listener.enableProceedButton();
                    NetBankingViewModel.this.hideLoading();
                    if (!(DirectPaymentBL.getInstance().getPaytmBaseView() instanceof NetBankingView) || !this.localSelectedChannelCode.equalsIgnoreCase(NetBankingViewModel.this.selectedChannelCode)) {
                        return;
                    }
                    if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                        NetBankingViewModel.this.fetchConvenienceFee((PayChannelOptions) null, str);
                        NetBankingViewModel.this.setValidatePromoText();
                        DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        return;
                    }
                    ApplyPromoResponse.PaymentOffer unused = NetBankingViewModel.this.selectedPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                    NetBankingViewModel.this.fetchConvenienceFee((PayChannelOptions) null, str);
                    if (SDKUtility.isOfferValid(NetBankingViewModel.this.selectedPaymentOffer) || SDKUtility.shouldShowValidatePromoError() || NetBankingViewModel.this.selectedPaymentOffer == null || NetBankingViewModel.this.selectedPaymentOffer.getOfferBreakup() == null || NetBankingViewModel.this.selectedPaymentOffer.getOfferBreakup().size() <= 0) {
                        SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                        NetBankingViewModel.this.listener.changeOfferTextBgColor(androidx.core.content.b.c(NetBankingViewModel.this.mContext, R.color.color_e8f8f1), androidx.core.content.b.c(NetBankingViewModel.this.mContext, R.color.color_21c17a), false);
                        if (applyPromoResponse.getBody().getPaymentOffer().getTotalCashbackAmount() != null) {
                            NetBankingViewModel.this.bankOfferVisibility.set(0);
                            NetBankingViewModel.this.bankOfferText.set(SDKUtility.getBankOfferText(NetBankingViewModel.this.mContext, NetBankingViewModel.this.mContext.getString(R.string.cashback_applied_successfully, new Object[]{applyPromoResponse.getBody().getPaymentOffer().getTotalCashbackAmount()}), applyPromoResponse.getBody().getPaymentOffer()));
                            NetBankingViewModel.this.cashBackTextVisibility.set(0);
                            NetBankingViewModel.this.cashBackText.set(NetBankingViewModel.this.mContext.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.priceWithoutDecimal(SDKUtility.getEffectAfterOfferAmount(applyPromoResponse.getBody().getPaymentOffer().getTotalCashbackAmount()))}));
                            NetBankingViewModel.this.setPaySecurelyText();
                            NetBankingViewModel.this.applyPromoFailed = false;
                        } else if (applyPromoResponse.getBody().getPaymentOffer().getTotalInstantDiscount() != null) {
                            NetBankingViewModel.this.bankOfferVisibility.set(0);
                            NetBankingViewModel.this.bankOfferText.set(SDKUtility.getBankOfferText(NetBankingViewModel.this.mContext, NetBankingViewModel.this.mContext.getString(R.string.instant_discount_applied_successfully, new Object[]{applyPromoResponse.getBody().getPaymentOffer().getTotalInstantDiscount()}), applyPromoResponse.getBody().getPaymentOffer()));
                            NetBankingViewModel.this.cashBackTextVisibility.set(8);
                            NetBankingViewModel.this.setPaySecurelyText();
                            NetBankingViewModel.this.applyPromoFailed = false;
                        } else {
                            NetBankingViewModel.this.cashBackTextVisibility.set(8);
                            NetBankingViewModel.this.bankOfferVisibility.set(8);
                            NetBankingViewModel.this.setValidatePromoText();
                        }
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    NetBankingViewModel.this.listener.enableProceedButton();
                    NetBankingViewModel.this.hideLoading();
                    NetBankingViewModel.this.cashBackTextVisibility.set(8);
                    NetBankingViewModel.this.bankOfferVisibility.set(8);
                    NetBankingViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                }
            });
        }
    }

    public void getBankOffers(final PayChannelOptions payChannelOptions) {
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            if ((SDKUtility.isHybridCase() ? payChannelOptions.getHybridPaymentOffer() : payChannelOptions.getPaymentOffer()) != null) {
                fetchConvenienceFee(payChannelOptions, "");
                return;
            }
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            paymentOption.setPayMethod(PayMethodType.NET_BANKING.name());
            paymentOption.setBankCode(payChannelOptions.getChannelCode());
            this.listener.disableProceedButton();
            payChannelOptions.showCheckingOffer = true;
            this.bankOfferText.set(new SpannableString(""));
            this.bankOfferVisibility.set(8);
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private boolean isHybrid = SDKUtility.isHybridCase();

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    payChannelOptions.showCheckingOffer = false;
                    NetBankingViewModel.this.listener.updateAdapter();
                    NetBankingViewModel.this.listener.enableProceedButton();
                    if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof NetBankingView) {
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null) {
                            NetBankingViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        } else if (applyPromoResponse.getBody().getPaymentOffer() != null) {
                            if (this.isHybrid) {
                                payChannelOptions.setHybridPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            } else {
                                payChannelOptions.setPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            }
                            SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                            NetBankingViewModel.this.listener.updateAdapter();
                        } else {
                            NetBankingViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        }
                        NetBankingViewModel.this.fetchConvenienceFee(payChannelOptions, "");
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    NetBankingViewModel.this.listener.enableProceedButton();
                    payChannelOptions.showCheckingOffer = false;
                    NetBankingViewModel.this.listener.updateAdapter();
                    NetBankingViewModel.this.setValidatePromoText();
                }
            });
        }
    }

    private void buildPaymentIntent(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.NET_BANKING.name(), (ArrayList<String>) null, arrayList, (CardPaymentIntentData) null, (String) null, Double.valueOf(SDKUtility.parseDouble(str2)));
    }

    public void fetchConvenienceFee(PayChannelOptions payChannelOptions, String str) {
        String str2;
        if (payChannelOptions != null) {
            if (!SDKUtility.isHybridCase() || payChannelOptions.getHybridPaymentOffer() == null) {
                str2 = (SDKUtility.isHybridCase() || payChannelOptions.getPaymentOffer() == null) ? "" : payChannelOptions.getPaymentOffer().getTotalInstantDiscount();
            } else {
                str2 = payChannelOptions.getHybridPaymentOffer().getTotalInstantDiscount();
            }
            buildPaymentIntent(payChannelOptions.getChannelCode(), str2);
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                ArrayList<PaymentIntent> cachedConvenienceFeeIntent = ConvenienceFeeController.getInstance().getCachedConvenienceFeeIntent(this.paymentIntents);
                if (cachedConvenienceFeeIntent != null) {
                    this.paymentIntents = cachedConvenienceFeeIntent;
                    configureConvFeeView(payChannelOptions);
                    return;
                }
                getConvenienceFee(payChannelOptions);
            }
        } else if (!TextUtils.isEmpty(str)) {
            buildPaymentIntent(str, "0.0");
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                ArrayList<PaymentIntent> cachedConvenienceFeeIntent2 = ConvenienceFeeController.getInstance().getCachedConvenienceFeeIntent(this.paymentIntents);
                if (cachedConvenienceFeeIntent2 != null) {
                    this.paymentIntents = cachedConvenienceFeeIntent2;
                    configureConvFeeForOtherBank();
                    return;
                }
                getConvenienceFeeForOtherBank();
            }
        }
    }

    private void getConvenienceFee(final PayChannelOptions payChannelOptions) {
        if (!SDKUtility.isNetworkAvailable(this.mContext)) {
            DialogUtility.showNoInternetDialog(this.mContext, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        payChannelOptions.setConvFeeText(this.mContext.getString(R.string.conv_fee_fetching));
        payChannelOptions.setConvFeeLoading(true);
        this.listener.disableProceedButton();
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, SDKUtility.isHybridCase() ? payChannelOptions.getHybridPaymentOffer() : payChannelOptions.getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                payChannelOptions.setConvFeeLoading(false);
                if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, NetBankingViewModel.this.mContext);
                    return;
                }
                ArrayList unused = NetBankingViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) NetBankingViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                NetBankingViewModel.this.configureConvFeeView(payChannelOptions);
                NetBankingViewModel.this.listener.enableProceedButton();
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                payChannelOptions.setConvFeeText("");
                payChannelOptions.setConvFeeLoading(false);
                NetBankingViewModel.this.listener.disableProceedButton();
                SDKUtility.handleVerticalError(apiResponseError, NetBankingViewModel.this.mContext);
            }
        });
    }

    private void getConvenienceFeeForOtherBank() {
        if (!SDKUtility.isNetworkAvailable(this.mContext)) {
            DialogUtility.showNoInternetDialog(this.mContext, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        showLoading(this.mContext.getString(R.string.conv_fee_fetching));
        this.listener.disableProceedButton();
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, this.selectedPaymentOffer);
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                NetBankingViewModel.this.hideLoading();
                if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof NetBankingView) {
                    if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                        SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, NetBankingViewModel.this.mContext);
                    } else {
                        ArrayList unused = NetBankingViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) NetBankingViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                        NetBankingViewModel.this.configureConvFeeForOtherBank();
                        NetBankingViewModel.this.listener.enableProceedButton();
                    }
                    NetBankingViewModel.this.listener.updateAdapter();
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                NetBankingViewModel.this.listener.disableProceedButton();
                NetBankingViewModel.this.hideLoading();
                SDKUtility.handleVerticalError(apiResponseError, NetBankingViewModel.this.mContext);
            }
        });
    }

    /* access modifiers changed from: private */
    public void configureConvFeeView(PayChannelOptions payChannelOptions) {
        Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
        String str = null;
        double d2 = 0.0d;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            PaymentIntent next = it2.next();
            d2 += next.getConvFee();
            String convFeeText2 = next.getConvFeeText();
            if (PayMethodType.NET_BANKING.name().equalsIgnoreCase(next.getMode())) {
                payChannelOptions.setConvenienceFee(next.getConvFee());
                str = convFeeText2;
                break;
            }
            str = convFeeText2;
        }
        if (d2 <= 0.0d) {
            payChannelOptions.setConvFeeText("");
        } else if (TextUtils.isEmpty(str)) {
            payChannelOptions.setConvFeeText(this.mContext.getString(R.string.conv_fee_default_msg, new Object[]{SDKUtility.priceWithoutDecimal(d2)}));
        } else if (SDKUtility.isAppInvokeFlow()) {
            payChannelOptions.setConvFeeText(str);
        } else {
            payChannelOptions.setConvFeeText(this.mContext.getString(R.string.nativesdk_conv_amount_holder, new Object[]{str, SDKUtility.priceWithoutDecimal(d2)}));
        }
    }

    /* access modifiers changed from: private */
    public void configureConvFeeForOtherBank() {
        Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
        String str = null;
        double d2 = 0.0d;
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            d2 += next.getConvFee();
            String convFeeText2 = next.getConvFeeText();
            if (PayMethodType.NET_BANKING.name().equalsIgnoreCase(next.getMode())) {
                this.otherBankConvFee = next.getConvFee();
                ApplyPromoResponse.PaymentOffer paymentOffer = this.selectedPaymentOffer;
                if (paymentOffer != null && !TextUtils.isEmpty(paymentOffer.getTotalCashbackAmount())) {
                    this.cashBackTextVisibility.set(0);
                    this.cashBackText.set(this.mContext.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.getNetPayableAmount(this.mContext, SDKUtility.parseDouble(this.selectedPaymentOffer.getTotalCashbackAmount()), d2)}));
                }
                setPaySecurelyText();
                setAmountIfNeeded();
            }
            str = convFeeText2;
        }
        if (d2 > 0.0d) {
            SDKUtility.setConvenienceFeeText(this.convFeeText, SDKUtility.priceWithoutDecimal(d2), str, this.mContext);
            this.convFeeTextVisibility.set(0);
            return;
        }
        this.convFeeTextVisibility.set(8);
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.mContext, getTotalInstantDiscountForOtherBanks(), this.otherBankConvFee));
    }

    public void setAmountIfNeeded() {
        this.amount.set("");
    }

    private double getTotalInstantDiscountForOtherBanks() {
        ApplyPromoResponse.PaymentOffer paymentOffer = this.selectedPaymentOffer;
        if (paymentOffer == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    private void showLoading(String str) {
        this.otherBankLoaderMsg.set(str);
        this.otherBankLoaderVisibility.set(0);
        this.convFeeTextVisibility.set(8);
        this.listener.startCheckingOfferAnimation();
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        this.otherBankLoaderVisibility.set(8);
        this.listener.stopCheckingOfferAnimation();
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    private ArrayList<PaymentIntent> getPaymentIntent() {
        PayChannelOptions payChannelOptions;
        if (this.paymentIntents == null && (payChannelOptions = this.lastChannelSelected) != null) {
            buildPaymentIntent(payChannelOptions.getChannelCode(), "0.0");
        }
        return this.paymentIntents;
    }

    /* access modifiers changed from: private */
    public void showUpiConsentCheckbox(String str) {
        if (SDKUtils.isToShowUpiConsent(str)) {
            this.upiCheckboxLayoutVisibility.set(0);
            this.upiCheckboxChecked.set(true);
            this.upiConsentBoxText.set(this.mContext.getString(R.string.native_upi_consent_text, new Object[]{this.otherBankText.get()}));
            return;
        }
        hideUpiConsentCheckbox();
        showUpiPayOption();
    }

    /* access modifiers changed from: private */
    public void hideUpiConsentCheckbox() {
        this.upiCheckboxLayoutVisibility.set(8);
        this.upiCheckboxChecked.set(false);
    }

    private void showUpiPayOption() {
        this.otherSelectedVpa = SDKUtils.isToShowUpiPayOption(this.selectedChannelCode, this.mContext);
        VpaBankAccountDetail vpaBankAccountDetail = this.otherSelectedVpa;
        if ((vpaBankAccountDetail == null || vpaBankAccountDetail.getBankMetaData() == null || TextUtils.isEmpty(this.otherSelectedVpa.getBankMetaData().getPerTxnLimit()) || Double.parseDouble(this.otherSelectedVpa.getBankMetaData().getPerTxnLimit()) >= SDKUtility.getDiffAmount()) && SDKUtility.isPaytmApp(this.mContext) && SDKUtility.isUpiPushEnabled() && this.otherSelectedVpa != null) {
            this.upiPayOptionVisibility.set(0);
            this.upiPayOptionText.set(this.mContext.getString(R.string.native_upi_option_text, new Object[]{this.otherBankText.get()}));
            return;
        }
        hideUpiPayOption();
    }

    /* access modifiers changed from: private */
    public void hideUpiPayOption() {
        this.upiPayOptionVisibility.set(8);
    }

    public void makeUpiConsentApiRequest(final String str, final boolean z) {
        if (PaytmSDK.getUpiCallBackListener() != null) {
            PaytmSDK.getUpiCallBackListener().fetchUpiSeqNo(new UpiPushCallbackListener.FetchUpiSeqNoListener() {
                public void setUpiMetaData(HashMap<String, String> hashMap) {
                    NativeSDKRepository.getInstance().makeUpiConsentApiCall(str, z, hashMap);
                }
            });
        }
    }

    public String getSelectedChannelCode() {
        return this.selectedChannelCode;
    }

    public String getSelectedChannelName() {
        return this.selectedChannelName;
    }
}
