package net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.OfflineDataEncryption;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.AccountBalance;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.IsDisabled;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.listeners.PaytmPaymentsBankListener;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.view.PaytmPaymentsBankView;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public class PaytmPaymentsBankViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    public boolean alreadyOpened;
    public i<String> amount = new i<>("");
    public ObservableInt amountVisibility = new ObservableInt(8);
    private boolean balanceApiHit;
    public ObservableInt balanceTxtVisiblity = new ObservableInt();
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    private boolean checkBalanceDone = false;
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    public i<String> disableMessage = new i<>();
    public ObservableInt disableMessageVisibility = new ObservableInt(8);
    public i<String> displayTextPostPaid = new i<>();
    public ObservableInt errorMsgVisibility = new ObservableInt(8);
    public i<String> errorPostPaid = new i<>();
    public ObservableInt fetchBalanceMsgVisiblity = new ObservableInt();
    private CJRFetchBalanceResponse fetchBalanceResponse;
    private double instrumentConvenienceFee;
    public i<String> insufficuentAmountError = new i<>();
    private Boolean isAmountSufficent;
    private IsDisabled isDisabled;
    private Boolean isPasscodeRequired;
    private boolean isPostpaid;
    private boolean isPostpaidInActive = false;
    /* access modifiers changed from: private */
    public boolean isSelected = false;
    private boolean isTermsChecked = true;
    private boolean isValid;
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context mContext;
    public i<String> mPrimaryInformation = new i<>();
    public i<String> mSecondaryInformation = new i<>();
    public ObservableInt mictLinesVisibility = new ObservableInt(8);
    public ObservableInt newVisibility = new ObservableInt(8);
    public boolean nextInstrumentOpenRequired = true;
    public i<String> paySecurelyText = new i<>();
    public ObservableInt paybackVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public PaymentModes paymentModes;
    /* access modifiers changed from: private */
    public PaytmPaymentsBankListener paymentsBankListener;
    private String pin = "";
    public i<String> pinError = new i<>();
    private String ppbBalance = "";
    private View proceedButton;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    private SelectedInstrument selectedInstrument;
    public ObservableInt termVisibility = new ObservableInt(8);
    public i<SpannableString> termsNConditionPostPaid = new i<>();
    public ObservableInt validatingOtpVisiblity = new ObservableInt(8);

    public PaytmPaymentsBankViewModel(Context context, PaymentModes paymentModes2, PaytmPaymentsBankListener paytmPaymentsBankListener, boolean z, boolean z2) {
        super(context, paytmPaymentsBankListener);
        this.isPostpaid = z2;
        this.mContext = context;
        this.paymentModes = paymentModes2;
        this.paymentsBankListener = paytmPaymentsBankListener;
        this.isValid = z;
        init();
    }

    public void refreshLayout() {
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.nextInstrumentOpenRequired = false;
        if (this.balanceApiHit) {
            try {
                setAmountIfNeeded();
                setPaySecurelyText();
                if (!DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    this.isAmountSufficent = Boolean.valueOf(checkIfAmountSufficient());
                    if (!this.isAmountSufficent.booleanValue()) {
                        this.paymentsBankListener.disableView(true);
                        this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
                        return;
                    }
                    this.paymentsBankListener.disableView(false);
                    fetchConvenienceFee();
                    return;
                }
                this.paymentsBankListener.disableView(false);
                if (getPaymentOffer() == null) {
                    getBankOffers();
                    return;
                }
                showBankOffers();
                fetchConvenienceFee();
            } catch (Exception unused) {
            }
        } else {
            payMethodSelected((View) null);
            setPaySecurelyText();
            setAmountIfNeeded();
        }
    }

    public void setProceedButtonView(View view) {
        this.proceedButton = view;
    }

    public void hideAmount() {
        this.amount.set("");
    }

    private void init() {
        this.fetchBalanceMsgVisiblity.set(8);
        this.mPrimaryInformation.set(this.paymentModes.getDisplayName());
        this.mSecondaryInformation.set(this.mContext.getString(R.string.check_balance));
        if (SDKUtility.isPayModeDisabled(this.paymentModes)) {
            setDisableText(this.paymentModes);
            return;
        }
        this.balanceTxtVisiblity.set(0);
        if (this.paymentModes.getOnboarding()) {
            this.newVisibility.set(0);
        } else {
            this.newVisibility.set(8);
        }
        if (this.isPostpaid) {
            this.balanceTxtVisiblity.set(0);
            if (this.paymentModes.getOnboarding()) {
                this.mSecondaryInformation.set(this.mContext.getString(R.string.native_use_now_next_month));
                this.newVisibility.set(0);
            }
        }
        setPaySecurelyText();
    }

    public void onPasscodeTextChanged(Editable editable) {
        this.pin = editable.toString();
        this.pinError.set("");
        if (this.pin.length() == 4) {
            this.paymentsBankListener.hideKeyboard();
        }
        this.paymentsBankListener.changePasscodeUi(false);
    }

    public void proceedClicked(View view) {
        Context context;
        if (!this.isPostpaid || this.isTermsChecked) {
            Boolean bool = this.isPasscodeRequired;
            if ((bool == null || bool.booleanValue()) && TextUtils.isEmpty(this.pin)) {
                this.pinError.set(this.mContext.getResources().getString(R.string.enter_passcode));
                this.paymentsBankListener.changePasscodeUi(true);
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.isPostpaid ? "Paytm Postpaid" : "Paytm Payment Bank", "Invalid Passcode"));
                return;
            }
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, this.isPostpaid ? SDKConstants.AI_KEY_POSTPAID : SDKConstants.AI_KEY_PPBL));
            }
            if (SDKUtility.shouldShowValidatePromoError() && (this.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
                setValidatePromoText();
            } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context = this.mContext) == null) {
                completeTransaction((AppCompatActivity) this.mContext);
            } else {
                Toast.makeText(this.mContext, context.getString(R.string.otp_not_validated), 0).show();
            }
        }
    }

    private boolean checkIfAmountSufficient() {
        boolean isPayableAmountGreaterThanOwnedMoney = SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), isHybridCase(), this.instrumentConvenienceFee);
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (!SDKUtility.isOfferValid(paymentOffer) || TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount())) {
            return isPayableAmountGreaterThanOwnedMoney;
        }
        try {
            double doubleValue = Double.valueOf(paymentOffer.getTotalInstantDiscount()).doubleValue();
            return doubleValue > 0.0d ? SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), doubleValue, isHybridCase(), this.instrumentConvenienceFee) : isPayableAmountGreaterThanOwnedMoney;
        } catch (NumberFormatException unused) {
            return isPayableAmountGreaterThanOwnedMoney;
        }
    }

    public void updateBalanceAndErrorView() {
        if (this.balanceApiHit) {
            this.isAmountSufficent = Boolean.valueOf(checkIfAmountSufficient());
        }
        Boolean bool = this.isAmountSufficent;
        if (bool == null || bool.booleanValue()) {
            this.insufficuentAmountError.set("");
            this.paymentsBankListener.disableView(false);
            if (!this.isValid) {
                Context context = this.mContext;
                Toast.makeText(context, this.mContext.getString(R.string.merchant_doesnt_accpet) + " " + this.mPrimaryInformation.get(), 1).show();
                return;
            }
            return;
        }
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
        this.paymentsBankListener.disableView(true);
        openNextInstrument();
    }

    public void onCheckChangedTerms(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.isTermsChecked = true;
            this.paymentsBankListener.toggleProceed(z);
            return;
        }
        this.isTermsChecked = false;
        this.paymentsBankListener.toggleProceed(z);
    }

    public boolean isCheckBalanceDone() {
        return this.checkBalanceDone;
    }

    public void payMethodSelected(View view) {
        Boolean bool;
        Boolean bool2;
        this.nextInstrumentOpenRequired = true;
        this.paymentsBankListener.setViewSelected();
        if (!this.isPostpaidInActive && !this.alreadyOpened) {
            this.alreadyOpened = true;
            if (this.checkBalanceDone && (bool2 = this.isAmountSufficent) != null && !bool2.booleanValue()) {
                return;
            }
            if (SDKUtility.isPayModeDisabled(this.paymentModes)) {
                setDisableText(this.paymentModes);
                return;
            }
            updateBalanceAndErrorView();
            DirectPaymentBL.getInstance().closeOpnedView();
            setAmountIfNeeded();
            setPaySecurelyText();
            this.paymentsBankListener.showAnimation(false);
            this.disableMessageVisibility.set(8);
            this.disableMessage.set("");
            if (this.mSecondaryInformation.get().equalsIgnoreCase(this.mContext.getString(R.string.check_balance))) {
                this.fetchBalanceMsgVisiblity.set(0);
                this.balanceTxtVisiblity.set(8);
                callBalanceAPI(this.paymentModes.getPaymentMode());
                this.paymentsBankListener.markViewSelected();
            } else if (this.isPostpaid && !this.checkBalanceDone) {
                this.fetchBalanceMsgVisiblity.set(0);
                this.balanceTxtVisiblity.set(8);
                callBalanceAPI(this.paymentModes.getPaymentMode());
                this.paymentsBankListener.markViewSelected();
            } else if (this.checkBalanceDone && (bool = this.isAmountSufficent) != null && bool.booleanValue()) {
                setSelectedInstrument(true);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                } else {
                    fetchConvenienceFee();
                }
            }
            if (!this.checkBalanceDone || !this.isPostpaid || !this.paymentModes.getOnboarding()) {
                this.mictLinesVisibility.set(8);
                this.paybackVisibility.set(8);
                this.termVisibility.set(8);
                return;
            }
            this.mictLinesVisibility.set(0);
            this.paybackVisibility.set(0);
            this.termVisibility.set(0);
        }
    }

    private void setDisableText(PaymentModes paymentModes2) {
        this.disableMessageVisibility.set(0);
        this.disableMessage.set(this.mContext.getString(R.string.disable_paymode_error_message));
        this.paymentsBankListener.disableView(true);
    }

    private void sendSelectGAEvent() {
        if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
            boolean z = this.isPostpaid;
            String str = SDKConstants.GA_KEY_NEW;
            if (z) {
                if (!this.paymentModes.getOnboarding()) {
                    str = "Returning";
                }
                String str2 = str;
                Boolean bool = this.isAmountSufficent;
                String str3 = (bool == null || !bool.booleanValue()) ? "Insuff_Bal" : "Sufficient_Bal";
                if (SDKConstants.GA_KEY_PPB.equalsIgnoreCase(DirectPaymentBL.getInstance().getDefaultSelectedPayOption())) {
                    if (SDKUtility.isHybridCase()) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_HYBRID, str2, str3));
                    } else {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_DEFAULT, str2, str3));
                    }
                } else if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_HYBRID, str2, str3));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_NEW, str2, str3));
                }
            } else if (SDKConstants.GA_KEY_PPB.equalsIgnoreCase(DirectPaymentBL.getInstance().getDefaultSelectedPayOption())) {
                if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_PPB, SDKConstants.GA_KEY_HYBRID));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_PPB, SDKConstants.GA_KEY_DEFAULT));
                }
            } else if (SDKUtility.isHybridCase()) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_PPB, SDKConstants.GA_KEY_HYBRID));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_PPB, str));
            }
        }
    }

    private void setAmountIfNeeded() {
        this.amountVisibility.set(8);
    }

    public void setSelectedInstrument(boolean z) {
        Boolean bool;
        this.selectedInstrument = new SelectedInstrument();
        this.selectedInstrument.setPrimaryName(this.mPrimaryInformation.get());
        this.selectedInstrument.setSecondaryName(this.mSecondaryInformation.get());
        this.selectedInstrument.setBaseViewModel(this);
        DirectPaymentBL.getInstance().setSelectedInstrument(this.selectedInstrument);
        if (z && (bool = this.isAmountSufficent) != null && bool.booleanValue()) {
            this.paymentsBankListener.onFetchBalance(this.isPasscodeRequired);
        }
    }

    private void goForTransaction(String str) {
        boolean isHybridCase = SDKUtility.isHybridCase();
        String str2 = SDKConstants.GA_KEY_POSTPAID;
        if (isHybridCase) {
            String str3 = this.isPostpaid ? str2 : SDKConstants.GA_KEY_PPB;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", str3, SDKConstants.GA_KEY_HYBRID, sb.toString(), "Accept_pay"));
        } else {
            String str4 = this.isPostpaid ? str2 : SDKConstants.GA_KEY_PPB;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", str4, SDKConstants.GA_KEY_NEW, sb2.toString(), "Accept_pay"));
        }
        this.cashBackTextVisibility.set(8);
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        HashMap<String, String> paymentsBankParam = PayUtility.getPaymentsBankParam(this.paymentModes.getPaymentMode(), str);
        String str5 = SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(this.paymentModes.getPaymentMode()) ? BaseViewModel.PaymentType.PPB : BaseViewModel.PaymentType.POSTPAID;
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, paymentsBankParam);
        if (!this.isPostpaid) {
            str2 = SDKConstants.GA_KEY_PPB;
        }
        paymentInstrument.setGaPaymentMethod(str2);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.mContext, str5, paymentInstrument);
        if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getHybridPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
        } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
        }
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            transactionProcessor.setPaymentIntent(this.paymentIntents);
        }
        transactionProcessor.startTransaction(this.proceedButton);
    }

    private void callBalanceAPI(String str) {
        if (!SDKUtility.isNetworkAvailable(this.mContext)) {
            DialogUtility.showNoInternetDialog(this.mContext, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            handleFetchBalanceError((VolleyError) null);
            return;
        }
        NativeSDKRepository.getInstance().fetchBalance(str, new PaymentMethodDataSource.Callback<CJRFetchBalanceResponse>() {
            public void onResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                PaytmPaymentsBankViewModel.this.handleFetchBalanceResponse(cJRFetchBalanceResponse);
            }

            public void onErrorResponse(VolleyError volleyError, CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                PaytmPaymentsBankViewModel.this.handleFetchBalanceError(volleyError);
            }
        });
    }

    private void executeRequest(Request request) {
        if (SDKUtility.isNetworkAvailable(this.mContext)) {
            VolleyRequestQueue.getInstance(this.mContext).addToRequestQueue(request);
        } else {
            DialogUtility.showNetworkDialog(request, this.mContext);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        String str;
        hidePaymentProgressbar(this.proceedButton);
        this.paymentsBankListener.enableProceedButton();
        this.fetchBalanceMsgVisiblity.set(8);
        if (volleyError instanceof CustomVolleyError) {
            CustomVolleyError customVolleyError = (CustomVolleyError) volleyError;
            if (customVolleyError.getUrl().contains("fetchBalanceInfo")) {
                this.insufficuentAmountError.set("Something went wrong.");
                this.balanceTxtVisiblity.set(0);
                this.nextInstrumentOpenRequired = true;
                openNextInstrument();
            } else if (customVolleyError.getUrl().contains(NativeSdkGtmLoader.getToken())) {
                if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(volleyError.getMessage()) || "410".equalsIgnoreCase(volleyError.getMessage()) || "403".equalsIgnoreCase(volleyError.getMessage())) {
                    if (PaytmSDK.getCallbackListener() != null) {
                        PaytmSDK.getCallbackListener().onSessionExpire(customVolleyError);
                    }
                    if (this.mContext != null) {
                        Intent intent = new Intent("kill");
                        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                        a.a(this.mContext.getApplicationContext()).a(intent);
                        return;
                    }
                    return;
                }
                try {
                    str = new JSONObject(customVolleyError.getErrorMsg()).getString("error_description");
                } catch (Exception unused) {
                    str = "";
                }
                this.pinError.set(str);
                this.paymentsBankListener.changePasscodeUi(true);
                this.validatingOtpVisiblity.set(8);
            }
            if (this.isPostpaid) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, SDKConstants.GA_KEY_POSTPAID, "Invalid Credentials"));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, SDKConstants.GA_KEY_PPB, "Invalid Credentials"));
            }
        }
    }

    public boolean isHybridCase() {
        return DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && !DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && DirectPaymentBL.getInstance().isPaytmWalletChecked();
    }

    /* access modifiers changed from: private */
    public void handleFetchBalanceError(VolleyError volleyError) {
        this.paymentsBankListener.enableProceedButton();
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        this.nextInstrumentOpenRequired = true;
        openNextInstrument();
    }

    /* access modifiers changed from: private */
    public void handleFetchBalanceResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        if (cJRFetchBalanceResponse == null || cJRFetchBalanceResponse.getBody() == null || cJRFetchBalanceResponse.getBody().getBalanceInfo() == null) {
            this.fetchBalanceMsgVisiblity.set(8);
            this.balanceTxtVisiblity.set(8);
            this.insufficuentAmountError.set("Error in fetching balance. Retry.");
            this.nextInstrumentOpenRequired = true;
            openNextInstrument();
            return;
        }
        this.paymentsBankListener.setTSecondaryTextColor();
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        this.ppbBalance = cJRFetchBalanceResponse.getBody().getBalanceInfo().getValue();
        String currency = cJRFetchBalanceResponse.getBody().getBalanceInfo().getCurrency();
        if (cJRFetchBalanceResponse.getBody().getPasscodeRequired() != null) {
            this.isPasscodeRequired = cJRFetchBalanceResponse.getBody().getPasscodeRequired();
        }
        BalanceInfo balanceInfo = new BalanceInfo();
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setValue(this.ppbBalance);
        accountBalance.setCurrency(currency);
        balanceInfo.setAccountBalance(accountBalance);
        this.fetchBalanceResponse = cJRFetchBalanceResponse;
        this.paymentModes.getPayChannelOptions().get(0).setBalanceInfo(balanceInfo);
        this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.ppbBalance).doubleValue())})).toString());
        if (!cJRFetchBalanceResponse.getBody().isEnable() && this.isPostpaid) {
            this.isAmountSufficent = Boolean.FALSE;
            disablePostpaidAndShowErrorMessage(cJRFetchBalanceResponse.getBody().getInfoButtonMessage());
        } else if (!TextUtils.isEmpty(cJRFetchBalanceResponse.getBody().getDisplayMessage()) && this.isPostpaid) {
            disablePostpaidAndShowErrorMessage(cJRFetchBalanceResponse.getBody().getDisplayMessage());
        } else if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else {
            updateBalance(0.0d);
            fetchConvenienceFee();
        }
    }

    private void disablePostpaidAndShowErrorMessage(String str) {
        this.errorPostPaid.set(str);
        this.errorMsgVisibility.set(0);
        this.paymentsBankListener.disablePostPaid();
        this.paymentsBankListener.setTSecondaryTextColor();
        this.isPostpaidInActive = true;
        this.nextInstrumentOpenRequired = true;
        openNextInstrument();
        this.balanceApiHit = true;
        setAmountIfNeeded();
        if (this.alreadyOpened) {
            setSelectedInstrument(true);
        }
        this.checkBalanceDone = true;
    }

    public void onResponse(Object obj) {
        if (obj instanceof CJRVerifyPasscodeResponse) {
            this.paymentsBankListener.enableProceedButton();
            this.validatingOtpVisiblity.set(8);
            CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) obj;
            if (!TextUtils.isEmpty(cJRVerifyPasscodeResponse.getErrorDescription())) {
                hidePaymentProgressbar(this.proceedButton);
                this.paymentsBankListener.changePasscodeUi(true);
                this.pinError.set(cJRVerifyPasscodeResponse.getErrorDescription());
                this.paymentsBankListener.changePasscodeUi(true);
                return;
            }
            goForTransaction(cJRVerifyPasscodeResponse.getAccessToken());
            return;
        }
        hidePaymentProgressbar(this.proceedButton);
    }

    /* access modifiers changed from: private */
    public void updateBalance(double d2) {
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        if (!TextUtils.isEmpty(this.ppbBalance)) {
            this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.ppbBalance).doubleValue())})).toString());
        }
        this.paymentsBankListener.setTSecondaryTextColor();
        this.isAmountSufficent = Boolean.valueOf(checkIfAmountSufficient());
        if (!this.isAmountSufficent.booleanValue()) {
            this.paymentsBankListener.disableView(true);
            this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
            hideOffer();
            this.nextInstrumentOpenRequired = true;
            openNextInstrument();
        } else {
            CJRFetchBalanceResponse cJRFetchBalanceResponse = this.fetchBalanceResponse;
            if (cJRFetchBalanceResponse != null) {
                this.paymentsBankListener.addOnBoardingData(cJRFetchBalanceResponse);
            }
            this.paymentsBankListener.disableView(false);
            sendSelectGAEvent();
            this.insufficuentAmountError.set("");
        }
        this.balanceApiHit = true;
        setAmountIfNeeded();
        if (this.alreadyOpened) {
            setSelectedInstrument(true);
        }
        this.checkBalanceDone = true;
    }

    private void openNextInstrument() {
        if (this.mContext != null && this.nextInstrumentOpenRequired) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID);
            intent.putExtra(SDKConstants.IS_POSTPAID, this.isPostpaid);
            if (this.isPostpaid) {
                intent.putExtra(SDKConstants.SELECTED_INSTRUMENT, SDKConstants.GA_KEY_POSTPAID);
            } else {
                intent.putExtra(SDKConstants.SELECTED_INSTRUMENT, SDKConstants.GA_KEY_PPB);
            }
            a.a(this.mContext.getApplicationContext()).a(intent);
        }
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
        if (TextUtils.isEmpty(this.pin)) {
            goForTransaction(this.pin);
        } else if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getClientId())) {
            try {
                if (SDKUtility.isNetworkAvailable(this.mContext)) {
                    this.paymentsBankListener.disableProceedButton();
                    this.validatingOtpVisiblity.set(0);
                    executeRequest(getVerifyPasscodeRequest(this.mContext, OfflineDataEncryption.encrypt(MerchantBL.getMerchantInstance().getRSAkey(), this.pin), this.isPostpaid ? "dc_txn" : BuildConfig.BANK_TXN_SCOPE));
                    if (isNativeJsonFlowEnabled()) {
                        showPaymentProgressbar(this.proceedButton);
                        return;
                    }
                    return;
                }
                DialogUtility.showNoInternetDialog(appCompatActivity, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (Exception e2) {
                hidePaymentProgressbar(this.proceedButton);
                LogUtility.e("PaytmPaymentsBankViewModel", e2.toString());
            }
        } else {
            goForTransaction(this.pin);
        }
    }

    private Request getVerifyPasscodeRequest(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", MerchantBL.getMerchantInstance().getAuthentication());
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("session_token", MerchantBL.getMerchantInstance().getSsoToken());
            hashMap.put(SDKConstants.X_DEVICE_IDENTIFIER, SDKUtility.getDeviceIdentifier(context, (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)));
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getToken());
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(MerchantBL.getMerchantInstance().getMobileNumber(), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(str2, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8), this, this, CJRVerifyPasscodeResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
            return volleyPostRequest;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    public void deselectView() {
        this.paymentsBankListener.deselectView();
        this.mictLinesVisibility.set(8);
        this.paybackVisibility.set(8);
        this.termVisibility.set(8);
        this.alreadyOpened = false;
    }

    private void hideOffer() {
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
    }

    /* access modifiers changed from: private */
    public void showBankOffers() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (paymentOffer == null || SDKUtility.isOfferValid(paymentOffer) || SDKUtility.shouldShowValidatePromoError() || paymentOffer.getOfferBreakup() == null || paymentOffer.getOfferBreakup().size() <= 0) {
            this.paymentsBankListener.changeOfferTextBgColor(b.c(this.mContext, R.color.color_e8f8f1), b.c(this.mContext, R.color.color_21c17a), false);
            if (paymentOffer == null) {
                return;
            }
            if (paymentOffer.getTotalCashbackAmount() != null) {
                this.bankOfferVisibility.set(0);
                i iVar = this.bankOfferText;
                Context context = this.mContext;
                iVar.set(SDKUtility.getBankOfferText(context, context.getString(R.string.cashback_applied_successfully, new Object[]{paymentOffer.getTotalCashbackAmount()}), paymentOffer));
                this.cashBackTextVisibility.set(0);
                this.cashBackText.set(this.mContext.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalCashbackAmount()))}));
                setPaySecurelyText();
                updateBalance(0.0d);
                this.applyPromoFailed = false;
            } else if (paymentOffer.getTotalInstantDiscount() != null) {
                this.bankOfferVisibility.set(0);
                i iVar2 = this.bankOfferText;
                Context context2 = this.mContext;
                iVar2.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.instant_discount_applied_successfully, new Object[]{paymentOffer.getTotalInstantDiscount()}), paymentOffer));
                this.cashBackTextVisibility.set(8);
                setPaySecurelyText();
                this.applyPromoFailed = false;
                try {
                    updateBalance(Double.valueOf(paymentOffer.getTotalInstantDiscount()).doubleValue());
                } catch (Exception unused) {
                    updateBalance(0.0d);
                }
            } else {
                setPaySecurelyText();
                this.bankOfferVisibility.set(8);
                this.cashBackTextVisibility.set(8);
                updateBalance(0.0d);
                setValidatePromoText();
            }
        } else {
            updateBalance(0.0d);
            setPaySecurelyText();
        }
    }

    private void getBankOffers() {
        if (!DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            updateBalance(0.0d);
            fetchConvenienceFee();
        } else if (getPaymentOffer() != null) {
            showBankOffers();
            fetchConvenienceFee();
        } else {
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            paymentOption.setTransactionAmount(new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US)).format(SDKUtility.getDiffAmount()));
            paymentOption.setPayMethod((this.isPostpaid ? PayMethodType.PAYTM_DIGITAL_CREDIT : PayMethodType.PPBL).name());
            this.paymentsBankListener.disableProceedButton();
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                showLoading(this.mContext.getString(R.string.conv_fee_fetching));
            } else {
                showLoading(this.mContext.getString(R.string.native_checking_offers));
            }
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, ""), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private boolean isHybrid = SDKUtility.isHybridCase();

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    PaytmPaymentsBankViewModel.this.paymentsBankListener.enableProceedButton();
                    PaytmPaymentsBankViewModel.this.hideLoading();
                    if ((DirectPaymentBL.getInstance().getPaytmBaseView() instanceof PaytmPaymentsBankView) || !PaytmPaymentsBankViewModel.this.isSelected) {
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                            PaytmPaymentsBankViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                            PaytmPaymentsBankViewModel.this.updateBalance(0.0d);
                        } else {
                            if (this.isHybrid) {
                                PaytmPaymentsBankViewModel.this.paymentModes.setHybridPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            } else {
                                PaytmPaymentsBankViewModel.this.paymentModes.setPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            }
                            SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                            PaytmPaymentsBankViewModel.this.showBankOffers();
                        }
                        PaytmPaymentsBankViewModel.this.fetchConvenienceFee();
                        return;
                    }
                    PaytmPaymentsBankViewModel.this.updateBalance(0.0d);
                    PaytmPaymentsBankViewModel.this.fetchConvenienceFee();
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    PaytmPaymentsBankViewModel.this.paymentsBankListener.disableProceedButton();
                    PaytmPaymentsBankViewModel.this.bankOfferVisibility.set(8);
                    PaytmPaymentsBankViewModel.this.hideLoading();
                    PaytmPaymentsBankViewModel.this.updateBalance(0.0d);
                    PaytmPaymentsBankViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                }
            });
        }
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* access modifiers changed from: private */
    public void fetchConvenienceFee() {
        Boolean bool;
        buildPaymentIntent();
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled() && (bool = this.isAmountSufficent) != null && bool.booleanValue()) {
            ArrayList<PaymentIntent> cachedConvenienceFeeIntent = ConvenienceFeeController.getInstance().getCachedConvenienceFeeIntent(this.paymentIntents);
            if (cachedConvenienceFeeIntent != null) {
                this.paymentIntents = cachedConvenienceFeeIntent;
                configureConvFeeView();
                return;
            }
            getConvenienceFee();
        }
    }

    private void buildPaymentIntent() {
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(getPaymentMode(), (ArrayList<String>) null, (ArrayList<String>) null, (CardPaymentIntentData) null, (String) null, Double.valueOf(getTotalInstantDiscount()));
    }

    private void getConvenienceFee() {
        if (!SDKUtility.isNetworkAvailable(this.mContext)) {
            DialogUtility.showNoInternetDialog(this.mContext, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        this.paymentsBankListener.disableProceedButton();
        showLoading(this.mContext.getString(R.string.conv_fee_fetching));
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                PaytmPaymentsBankViewModel.this.hideLoading();
                if (!PaytmPaymentsBankViewModel.this.isSelected) {
                    PaytmPaymentsBankViewModel.this.paymentsBankListener.enableProceedButton();
                } else if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, PaytmPaymentsBankViewModel.this.mContext);
                } else {
                    ArrayList unused = PaytmPaymentsBankViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) PaytmPaymentsBankViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                    BalanceInfo balanceInfo = PaytmPaymentsBankViewModel.this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo();
                    if (!(balanceInfo == null || balanceInfo.getAccountBalance() == null)) {
                        if (!ConvenienceFeeController.getInstance().checkConvenienceFeeOverFlow(PaytmPaymentsBankViewModel.this.getPaymentMode(), SDKUtility.parseDouble(balanceInfo.getAccountBalance().getValue()), PaytmPaymentsBankViewModel.this.paymentIntents)) {
                            PaytmPaymentsBankViewModel.this.configureConvFeeView();
                            PaytmPaymentsBankViewModel.this.paymentsBankListener.enableProceedButton();
                        }
                    }
                    PaytmPaymentsBankViewModel.this.handleConvFeeOverflowScenario();
                    PaytmPaymentsBankViewModel.this.paymentsBankListener.enableProceedButton();
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                PaytmPaymentsBankViewModel.this.hideLoading();
                PaytmPaymentsBankViewModel.this.convFeeTextVisibility.set(8);
                if (PaytmPaymentsBankViewModel.this.isSelected) {
                    PaytmPaymentsBankViewModel.this.paymentsBankListener.disableProceedButton();
                    SDKUtility.handleVerticalError(apiResponseError, PaytmPaymentsBankViewModel.this.mContext);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleConvFeeOverflowScenario() {
        this.paymentsBankListener.disableView(true);
        this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
        this.nextInstrumentOpenRequired = true;
        openNextInstrument();
    }

    /* access modifiers changed from: private */
    public void configureConvFeeView() {
        Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
        String str = null;
        double d2 = 0.0d;
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            d2 += next.getConvFee();
            String convFeeText2 = next.getConvFeeText();
            if (next.getMode().equalsIgnoreCase(getPaymentMode())) {
                this.instrumentConvenienceFee = next.getConvFee();
                setPaySecurelyText();
                setAmountIfNeeded();
                if (getPaymentOffer() != null && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
                    this.cashBackTextVisibility.set(0);
                    this.cashBackText.set(this.mContext.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.getDoubleFormaAmount((next.getTxnAmount() + next.getConvFee()) - SDKUtility.parseDouble(getPaymentOffer().getTotalCashbackAmount()))}));
                }
            }
            str = convFeeText2;
        }
        if (d2 > 0.0d) {
            this.convFeeTextVisibility.set(0);
            SDKUtility.setConvenienceFeeText(this.convFeeText, SDKUtility.priceWithoutDecimal(d2), str, this.mContext);
            return;
        }
        this.convFeeTextVisibility.set(8);
    }

    /* access modifiers changed from: private */
    public String getPaymentMode() {
        return (this.isPostpaid ? PayMethodType.PAYTM_DIGITAL_CREDIT : PayMethodType.PPBL).name();
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        if (SDKUtility.isHybridCase()) {
            return this.paymentModes.getHybridPaymentOffer();
        }
        return this.paymentModes.getPaymentOffer();
    }

    private double getTotalInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (paymentOffer == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    private void showLoading(String str) {
        this.loaderMsg.set(str);
        this.loaderVisibility.set(0);
        this.convFeeTextVisibility.set(8);
        this.paymentsBankListener.startCheckingOfferAnimation();
    }

    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.paymentsBankListener.stopCheckingOfferAnimation();
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.mContext, getTotalInstantDiscount(), this.instrumentConvenienceFee));
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }
}
