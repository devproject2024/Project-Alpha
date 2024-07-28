package net.one97.paytm.nativesdk.orflow.transaction.ppb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
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
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.AccountBalance;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.IsDisabled;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.listeners.PaytmPaymentsBankListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public class BankOfferPaytmBankViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    public boolean alreadyOpened;
    public i<String> amount = new i<>("");
    private boolean balanceApiHit;
    public ObservableInt balanceTxtVisiblity = new ObservableInt();
    public i<String> bankOfferText = new i<>("");
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    private boolean checkBalanceDone = false;
    public i<String> displayTextPostPaid = new i<>();
    public ObservableInt fetchBalanceMsgVisiblity = new ObservableInt();
    public i<String> insufficuentAmountError = new i<>();
    private Boolean isAmountSufficent;
    private IsDisabled isDisabled;
    private Boolean isPasscodeRequired;
    private boolean isPostpaid;
    private boolean isSelected = false;
    private boolean isTermsChecked = true;
    private boolean isValid;
    private Context mContext;
    public i<String> mPrimaryInformation = new i<>();
    public i<String> mSecondaryInformation = new i<>();
    public ObservableInt mictLinesVisibility = new ObservableInt(8);
    public ObservableInt newVisibility = new ObservableInt(8);
    public i<String> paySecurelyText = new i<>();
    public ObservableInt paybackVisibility = new ObservableInt(8);
    private PaymentModes paymentModes;
    private PaytmPaymentsBankListener paymentsBankListener;
    private String pin = "";
    public i<String> pinError = new i<>();
    private View proceedButton;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    private SelectedInstrument selectedInstrument;
    public ObservableInt termVisibility = new ObservableInt(8);
    public i<SpannableString> termsNConditionPostPaid = new i<>();
    public ObservableInt validatingOtpVisiblity = new ObservableInt(8);

    private void getBankOffers() {
    }

    public BankOfferPaytmBankViewModel(Context context, PaymentModes paymentModes2, PaytmPaymentsBankListener paytmPaymentsBankListener, boolean z, boolean z2) {
        super(context, paytmPaymentsBankListener);
        this.isPostpaid = z2;
        this.mContext = context;
        this.paymentModes = paymentModes2;
        this.paymentsBankListener = paytmPaymentsBankListener;
        this.isValid = z;
        init();
    }

    public void refreshLayout() {
        if (this.balanceApiHit) {
            try {
                this.isAmountSufficent = Boolean.valueOf(SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), isHybridCase(), 0.0d));
                if (!this.isAmountSufficent.booleanValue()) {
                    this.paymentsBankListener.disableView(true);
                    this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
                    openNextInstrument();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        payMethodSelected((View) null);
        this.bankOfferText.set("");
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.cashBackText.set("");
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.mContext));
        getBankOffers();
        setAmountIfNeeded();
    }

    public void setProceedButtonView(View view) {
        this.proceedButton = view;
    }

    public void hideAmount() {
        this.amount.set("");
    }

    private void init() {
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        this.mPrimaryInformation.set(this.paymentModes.getDisplayName());
        PaymentModes paymentModes2 = this.paymentModes;
        if (!(paymentModes2 == null || paymentModes2.getPayChannelOptions() == null || this.paymentModes.getPayChannelOptions().size() <= 0)) {
            this.isDisabled = this.paymentModes.getIsDisabled();
            this.mSecondaryInformation.set(this.mContext.getString(R.string.check_balance));
            if (this.paymentModes.getOnboarding()) {
                this.newVisibility.set(0);
            } else {
                this.newVisibility.set(8);
            }
        }
        if (this.isPostpaid) {
            this.balanceTxtVisiblity.set(0);
            if (this.paymentModes.getOnboarding()) {
                this.mSecondaryInformation.set(this.mContext.getString(R.string.native_use_now_next_month));
                this.newVisibility.set(0);
            }
        }
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.mContext));
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
        if (!this.isPostpaid || this.isTermsChecked) {
            Boolean bool = this.isPasscodeRequired;
            if ((bool == null || bool.booleanValue()) && TextUtils.isEmpty(this.pin)) {
                this.pinError.set(this.mContext.getResources().getString(R.string.enter_passcode));
                this.paymentsBankListener.changePasscodeUi(true);
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.isPostpaid ? "Paytm Postpaid" : "Paytm Payment Bank", "Invalid Passcode"));
                return;
            }
            completeTransaction((AppCompatActivity) this.mContext);
        }
    }

    public void updateBalanceAndErrorView() {
        if (this.balanceApiHit) {
            this.isAmountSufficent = Boolean.valueOf(SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), isHybridCase(), 0.0d));
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
        if (!this.alreadyOpened) {
            this.alreadyOpened = true;
            updateBalanceAndErrorView();
            DirectPaymentBL.getInstance().closeOpnedView();
            setAmountIfNeeded();
            this.paymentsBankListener.showAnimation(false);
            IsDisabled isDisabled2 = this.isDisabled;
            if (isDisabled2 == null || !isDisabled2.getStatus()) {
                if (this.mSecondaryInformation.get().equalsIgnoreCase(this.mContext.getString(R.string.check_balance))) {
                    this.fetchBalanceMsgVisiblity.set(0);
                    this.balanceTxtVisiblity.set(8);
                    callBalanceAPI(this.paymentModes.getPaymentMode());
                    this.paymentsBankListener.markViewSelected();
                } else if (!this.isPostpaid || this.checkBalanceDone) {
                    setSelectedInstrument(true);
                    getBankOffers();
                } else {
                    this.fetchBalanceMsgVisiblity.set(0);
                    this.balanceTxtVisiblity.set(8);
                    callBalanceAPI(this.paymentModes.getPaymentMode());
                    this.paymentsBankListener.markViewSelected();
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
        Boolean bool;
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked() || (bool = this.isAmountSufficent) == null || !bool.booleanValue()) {
            this.amount.set("");
            return;
        }
        this.amount.set(this.mContext.getResources().getString(R.string.nativesdk_amount, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(DirectPaymentBL.getInstance().getDifferentialAmount()).doubleValue())}));
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
        transactionProcessor.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        transactionProcessor.startTransaction(this.proceedButton);
        this.proceedButton.setOnClickListener((View.OnClickListener) null);
    }

    private void callBalanceAPI(String str) {
        NativeSDKRepository.getInstance().fetchBalance(str, new PaymentMethodDataSource.Callback<CJRFetchBalanceResponse>() {
            public void onResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                BankOfferPaytmBankViewModel.this.handleFetchBalanceResponse(cJRFetchBalanceResponse);
            }

            public void onErrorResponse(VolleyError volleyError, CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                BankOfferPaytmBankViewModel.this.handleFetchBalanceError(volleyError);
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
        openNextInstrument();
    }

    /* access modifiers changed from: private */
    public void handleFetchBalanceResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        if (cJRFetchBalanceResponse == null || cJRFetchBalanceResponse.getBody() == null || cJRFetchBalanceResponse.getBody().getBalanceInfo() == null) {
            this.fetchBalanceMsgVisiblity.set(8);
            this.balanceTxtVisiblity.set(8);
            this.insufficuentAmountError.set("Error in fetching balance. Retry.");
            openNextInstrument();
            return;
        }
        this.fetchBalanceMsgVisiblity.set(8);
        this.balanceTxtVisiblity.set(0);
        String value = cJRFetchBalanceResponse.getBody().getBalanceInfo().getValue();
        String currency = cJRFetchBalanceResponse.getBody().getBalanceInfo().getCurrency();
        if (cJRFetchBalanceResponse.getBody().getPasscodeRequired() != null) {
            this.isPasscodeRequired = cJRFetchBalanceResponse.getBody().getPasscodeRequired();
        }
        this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(value).doubleValue())})).toString());
        BalanceInfo balanceInfo = new BalanceInfo();
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setValue(value);
        accountBalance.setCurrency(currency);
        balanceInfo.setAccountBalance(accountBalance);
        this.paymentModes.getPayChannelOptions().get(0).setBalanceInfo(balanceInfo);
        this.isAmountSufficent = Boolean.valueOf(SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), isHybridCase(), 0.0d));
        if (!this.isAmountSufficent.booleanValue()) {
            this.paymentsBankListener.disableView(true);
            this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
            openNextInstrument();
        } else {
            this.paymentsBankListener.addOnBoardingData(cJRFetchBalanceResponse);
            getBankOffers();
            sendSelectGAEvent();
        }
        this.balanceApiHit = true;
        setAmountIfNeeded();
        if (this.alreadyOpened) {
            setSelectedInstrument(true);
        }
        this.checkBalanceDone = true;
    }

    public void onResponse(Object obj) {
        if (obj instanceof CJRFetchBalanceResponse) {
            hidePaymentProgressbar(this.proceedButton);
            CJRFetchBalanceResponse cJRFetchBalanceResponse = (CJRFetchBalanceResponse) obj;
            if (cJRFetchBalanceResponse.getBody() == null || cJRFetchBalanceResponse.getBody().getBalanceInfo() == null) {
                this.fetchBalanceMsgVisiblity.set(8);
                this.balanceTxtVisiblity.set(8);
                this.insufficuentAmountError.set("Error in fetching balance. Retry.");
                openNextInstrument();
                return;
            }
            this.balanceTxtVisiblity.set(0);
            this.fetchBalanceMsgVisiblity.set(8);
            String value = cJRFetchBalanceResponse.getBody().getBalanceInfo().getValue();
            String currency = cJRFetchBalanceResponse.getBody().getBalanceInfo().getCurrency();
            if (cJRFetchBalanceResponse.getBody().getPasscodeRequired() != null) {
                this.isPasscodeRequired = cJRFetchBalanceResponse.getBody().getPasscodeRequired();
            }
            this.mSecondaryInformation.set(Html.fromHtml(this.mContext.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(value).doubleValue())})).toString());
            BalanceInfo balanceInfo = new BalanceInfo();
            AccountBalance accountBalance = new AccountBalance();
            accountBalance.setValue(value);
            accountBalance.setCurrency(currency);
            balanceInfo.setAccountBalance(accountBalance);
            this.paymentModes.getPayChannelOptions().get(0).setBalanceInfo(balanceInfo);
            this.isAmountSufficent = Boolean.valueOf(SDKUtility.isPayableAmountGreaterThanOwnedMoney(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue(), isHybridCase(), 0.0d));
            if (!this.isAmountSufficent.booleanValue()) {
                this.paymentsBankListener.disableView(true);
                this.insufficuentAmountError.set(this.mContext.getString(R.string.native_insufficent_balance));
                openNextInstrument();
            } else {
                this.paymentsBankListener.addOnBoardingData(cJRFetchBalanceResponse);
                sendSelectGAEvent();
            }
            this.balanceApiHit = true;
            setAmountIfNeeded();
            if (this.alreadyOpened) {
                setSelectedInstrument(true);
            }
            this.checkBalanceDone = true;
        } else if (obj instanceof CJRVerifyPasscodeResponse) {
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
        } else {
            hidePaymentProgressbar(this.proceedButton);
        }
    }

    private void openNextInstrument() {
        if (this.mContext != null) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID);
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
    }
}
