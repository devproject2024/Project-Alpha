package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableInt;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.y;
import androidx.localbroadcastmanager.a.a;
import com.android.volley.VolleyError;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.WalletStateChangeListener;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.IsDisabled;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.InstrumentsSelectionManager;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.instruments.wallet.listeners.WalletListener;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;

public class WalletViewModel extends BaseViewModel {
    public i<String> addPayHybridAmountText = new i<>();
    public ObservableInt addPayHybridLayoutVisibility = new ObservableInt(8);
    public i<String> addPayHybridText = new i<>();
    /* access modifiers changed from: private */
    public String aggregatePgConvenienceFee;
    public i<String> amount = new i<>();
    public ObservableInt availableVisibilityBalance = new ObservableInt(8);
    public i<SpannableString> bankOfferText = new i<>(new SpannableString(""));
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    public i<String> giftCardBalance = new i<>();
    public ObservableInt giftCardBalanceVisibility = new ObservableInt(8);
    public boolean hasWalletOtpSent;
    private double instrumentConvenienceFee;
    private InstrumentsSelectionManager instrumentsSelectionManager;
    /* access modifiers changed from: private */
    public boolean isAlreadySelected;
    private IsDisabled isDisabled;
    public y<Boolean> isIncorrectText = new y<>();
    private boolean isValid;
    public y<Boolean> isWalletOtpTextVisible = new y<>();
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context mContext;
    public i<String> mPrimaryInformation = new i<>();
    public i<String> mSecondaryInformation = new i<>();
    public y<WalletOtpResponse> mWalletOtpResponse = new y<>();
    public y<WalletOtpResponse> mWalletValidateOtpResponse = new y<>();
    public ObservableInt otpViewVisibilty = new ObservableInt(8);
    public i<String> paySecurelyText = new i<>();
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents = null;
    private PaymentModes paymentModes;
    public ObservableInt proceedVisible = new ObservableInt(8);
    private SelectedInstrument selectedInstrument;
    public Toast toast;
    private double totalInstantDiscount = 0.0d;
    public i<String> walletBalance = new i<>();
    public ObservableInt walletBalanceVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public WalletListener walletListener;
    public ObservableInt walletOtpTxtVisibility = new ObservableInt(8);
    public ObservableInt walletSendOtpButtVisibility = new ObservableInt(8);

    public void deselectView() {
    }

    public void setAmount() {
    }

    public void setAlreadySelected(boolean z) {
        this.isAlreadySelected = z;
    }

    public boolean isWalletSelected() {
        return this.isAlreadySelected;
    }

    public WalletViewModel(Context context, PaymentModes paymentModes2, WalletListener walletListener2, boolean z, InstrumentsSelectionManager instrumentsSelectionManager2) {
        super(context, walletListener2);
        this.mContext = context;
        this.paymentModes = paymentModes2;
        this.walletListener = walletListener2;
        this.isValid = z;
        this.instrumentsSelectionManager = instrumentsSelectionManager2;
        init();
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    private void init() {
        this.mPrimaryInformation.set(this.paymentModes.getDisplayName());
        PaymentModes paymentModes2 = this.paymentModes;
        if (paymentModes2 != null && paymentModes2.getPayChannelOptions() != null && this.paymentModes.getPayChannelOptions().size() > 0) {
            this.isDisabled = this.paymentModes.getIsDisabled();
            if (!(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo() == null || this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() == null)) {
                this.mSecondaryInformation.set(this.mContext.getString(R.string.nativesdk_balance, new Object[]{SDKUtility.priceWithoutDecimal(Double.valueOf(this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue()).doubleValue())}));
            }
            BalanceInfo balanceInfo = this.paymentModes.getPayChannelOptions().get(0).getBalanceInfo();
            if (balanceInfo == null || balanceInfo.getSubWalletDetails() == null || balanceInfo.getSubWalletDetails().size() <= 0) {
                this.availableVisibilityBalance.set(0);
            } else {
                this.walletListener.inflateBalanceViews(balanceInfo.getSubWalletDetails());
                this.availableVisibilityBalance.set(8);
            }
            this.proceedVisible.addOnPropertyChangedCallback(new h.a() {
                public void onPropertyChanged(h hVar, int i2) {
                    if (DirectPaymentBL.getInstance().isSubsCriptionFlow() && WalletViewModel.this.isWalletSelected() && i2 == 0) {
                        WalletViewModel.this.proceedVisible.set(8);
                    }
                }
            });
            setPaySecurelyText();
            if (disabledDueToBalance()) {
                this.walletListener.disableView(true);
            }
        }
    }

    public void selectPayMethod() {
        payMethodSelected((View) null);
    }

    public void selectNextInstrument() {
        int totalInstrumentsSelected;
        if ((DirectPaymentBL.getInstance().isSubsCriptionFlow() && SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && !DirectPaymentBL.getInstance().isWalletOtpValidated()) || (totalInstrumentsSelected = this.instrumentsSelectionManager.getTotalInstrumentsSelected()) > 1) {
            return;
        }
        if (totalInstrumentsSelected == 1 && !isWalletSelected()) {
            return;
        }
        if ((DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && this.isValid && !DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && (DirectPaymentBL.getInstance().isPaytmWalletChecked() || Double.parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE)) < 1.0d)) || !this.isValid) {
            sendEventForNextInstrumentSelection();
        }
    }

    private void sendEventForNextInstrumentSelection() {
        Intent intent = new Intent();
        intent.setAction(SDKConstants.SELECT_NEXT_INSTRUMENT);
        intent.putExtra(SDKConstants.SELECTED_INSTRUMENT, SDKConstants.GA_KEY_BALANCE);
        a.a(this.mContext.getApplicationContext()).a(intent);
    }

    public void payMethodSelected(View view) {
        Context context;
        if (disabledDueToBalance()) {
            this.walletListener.disableView(true);
            DirectPaymentBL.getInstance().setWalletDisbledDueToBalance(true);
            Context context2 = this.mContext;
            if (context2 != null) {
                context2.getApplicationContext();
            }
            if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
                hideOtpView();
                this.walletOtpTxtVisibility.set(8);
                this.walletSendOtpButtVisibility.set(8);
                return;
            }
            selectNextInstrument();
        } else if (!this.isValid) {
            this.walletListener.deselectView();
            this.isAlreadySelected = false;
            this.addPayHybridLayoutVisibility.set(8);
            this.amount.set("");
            ((WalletStateChangeListener) this.mContext).onWalletStateChange();
            DirectPaymentBL.getInstance().setPaytmWalletChecked(false, this.mContext);
            if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
                hideOtpView();
                this.walletOtpTxtVisibility.set(8);
                this.walletSendOtpButtVisibility.set(8);
            }
            if (DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
                DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
                if (!(DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiPushView)) {
                    Intent intent = new Intent();
                    intent.setAction(SDKConstants.REFRESH_UPI);
                    a.a(this.mContext.getApplicationContext()).a(intent);
                }
            } else {
                Intent intent2 = new Intent();
                intent2.setAction(SDKConstants.REFRESH_LAYOUT_FILTER);
                a.a(this.mContext.getApplicationContext()).a(intent2);
            }
            selectNextInstrument();
        } else {
            if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_BALANCE, SDKConstants.GA_KEY_NEW));
            }
            Intent intent3 = new Intent();
            intent3.setAction(SDKConstants.EMI_REFRESH_FILTER);
            a.a(this.mContext.getApplicationContext()).a(intent3);
            if (SDKUtility.isHybridSupported()) {
                Intent intent4 = new Intent();
                intent4.setAction(SDKConstants.HYBRID_WALLET_CHECKED_UNCHECKED);
                a.a(this.mContext.getApplicationContext()).a(intent4);
            }
            if (!this.isAlreadySelected) {
                IsDisabled isDisabled2 = this.isDisabled;
                if (isDisabled2 == null || !isDisabled2.getStatus()) {
                    this.isAlreadySelected = true;
                    DirectPaymentBL.getInstance().setPaytmWalletChecked(true, this.mContext);
                    invalidatePaymentIntent();
                    ConvenienceFeeController.getInstance().resetConvenienceFee();
                    if (!SDKUtility.isHybridSupported()) {
                        setSelectedInstrument();
                    }
                    if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
                        this.proceedVisible.set(0);
                    } else {
                        if (!SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) || (DirectPaymentBL.getInstance().isSubsCriptionFlow() && !DirectPaymentBL.getInstance().isWalletOtpValidated())) {
                            this.addPayHybridText.set(this.mContext.getString(R.string.choose_other_option_to_pay_balance));
                            if (!SDKUtility.isHybridSupported() && (context = this.mContext) != null) {
                                this.addPayHybridText.set(context.getString(R.string.choose_other_option_to_pay_balance));
                            }
                            this.addPayHybridLayoutVisibility.set(0);
                            Context context3 = this.mContext;
                            if (context3 != null) {
                                this.addPayHybridAmountText.set(Html.fromHtml(context3.getString(R.string.nativesdk_amount, new Object[]{DirectPaymentBL.getInstance().getDifferentialAmount()})).toString());
                            }
                            this.walletListener.setSelectedView();
                        } else {
                            Context context4 = this.mContext;
                            if (context4 != null) {
                                this.addPayHybridText.set(context4.getString(R.string.choose_other_option_to_add_balance));
                            }
                            this.walletListener.loadInstruments(true);
                        }
                        setAmount();
                    }
                    ((WalletStateChangeListener) this.mContext).onWalletStateChange();
                    if (DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
                        DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
                        if (!(DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiPushView)) {
                            Intent intent5 = new Intent();
                            intent5.setAction(SDKConstants.REFRESH_UPI);
                            a.a(this.mContext.getApplicationContext()).a(intent5);
                        }
                    } else {
                        Intent intent6 = new Intent();
                        intent6.setAction(SDKConstants.REFRESH_LAYOUT_FILTER);
                        a.a(this.mContext.getApplicationContext()).a(intent6);
                    }
                    setAmount();
                    setPaySecurelyText();
                    fetchConvenienceFee();
                }
                if (SDKUtility.isHybridSupported()) {
                    this.paymentModes.getPaymentMode();
                    Intent intent7 = new Intent();
                    intent7.setAction(SDKConstants.REFRESH_PPB_POSTPAID_FILTER);
                    a.a(this.mContext.getApplicationContext()).a(intent7);
                }
                selectNextInstrument();
            } else if (DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null) {
                if (DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().isWalletOnly() && SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getPaymentFlowAvailable())) {
                    return;
                }
                if (SDKUtils.isOnlyWalletPresent()) {
                    Toast toast2 = this.toast;
                    if (toast2 != null) {
                        toast2.cancel();
                    }
                    Context context5 = this.mContext;
                    this.toast = Toast.makeText(context5, context5.getString(R.string.wallet_unselect_restrict), 1);
                    this.toast.show();
                    return;
                }
                this.walletListener.deselectView();
                this.isAlreadySelected = false;
                this.addPayHybridLayoutVisibility.set(8);
                this.amount.set("");
                hideConvenienceFee();
                DirectPaymentBL.getInstance().setPaytmWalletChecked(false, this.mContext);
                invalidatePaymentIntent();
                ConvenienceFeeController.getInstance().resetConvenienceFee();
                if (!DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && !SDKConstants.HYBRID.equals(DirectPaymentBL.getInstance().getSelectedPaymentMode()) && !SDKUtility.isHybridSupported()) {
                    this.walletListener.loadInstruments(false);
                }
                ((WalletStateChangeListener) this.mContext).onWalletStateChange();
                if (DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
                    DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
                    if (!(DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiPushView)) {
                        Intent intent8 = new Intent();
                        intent8.setAction(SDKConstants.REFRESH_UPI);
                        a.a(this.mContext.getApplicationContext()).a(intent8);
                        return;
                    }
                    return;
                }
                Intent intent9 = new Intent();
                intent9.setAction(SDKConstants.REFRESH_LAYOUT_FILTER);
                a.a(this.mContext.getApplicationContext()).a(intent9);
            }
        }
    }

    private boolean disabledDueToBalance() {
        return SDKUtility.disabledDueToBalance(this.paymentModes);
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
        goForTransaction((View) null);
    }

    public boolean canEnableWallet() {
        return DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && !disabledDueToBalance();
    }

    public void setSelectedInstrument() {
        DirectPaymentBL.getInstance().closeOpnedView();
        this.selectedInstrument = new SelectedInstrument();
        this.selectedInstrument.setPrimaryName(this.mPrimaryInformation.get());
        this.selectedInstrument.setSecondaryName(this.mSecondaryInformation.get());
        this.selectedInstrument.setBaseViewModel(this);
        DirectPaymentBL.getInstance().setSelectedInstrument(this.selectedInstrument);
        this.walletListener.setSelectedView();
        this.isAlreadySelected = true;
    }

    public void proceedClicked(View view) {
        Context context;
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("pay_clicked", SDKConstants.AI_KEY_WALLET, SDKConstants.GA_KEY_DEFAULT));
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_WALLET));
        }
        if (SDKUtility.shouldShowValidatePromoError()) {
            i<SpannableString> iVar = this.bankOfferText;
            Context context2 = this.mContext;
            iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.applied_promocode_not_valid), (ApplyPromoResponse.PaymentOffer) null));
            this.bankOfferVisibility.set(0);
        } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context = this.mContext) == null) {
            goForTransaction(view);
        } else {
            Toast.makeText(this.mContext, context.getString(R.string.otp_not_validated), 0).show();
        }
    }

    private void goForTransaction(View view) {
        HashMap<String, String> balanceParam = PayUtility.getBalanceParam(this.paymentModes.getPaymentMode());
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), balanceParam);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_BALANCE);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.mContext, "wallet", paymentInstrument);
        if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
        } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
        }
        if (!SDKUtility.isHybridCase()) {
            transactionProcessor.setPaymentIntent(getPaymentIntent());
        }
        transactionProcessor.startTransaction(view);
    }

    public void fetchConvenienceFee() {
        if (!SDKUtility.isHybridCase()) {
            buildPaymentIntent();
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                getConvenienceFee();
            }
        }
    }

    private void buildPaymentIntent() {
        if (!SDKUtility.isHybridCase()) {
            this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.BALANCE.name(), (ArrayList<String>) null, (ArrayList<String>) null, (CardPaymentIntentData) null, (String) null, Double.valueOf(this.totalInstantDiscount));
        }
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
        this.walletListener.shouldEnableProceed(false);
        showLoading(this.mContext.getString(R.string.conv_fee_fetching));
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                WalletViewModel.this.hideLoading();
                if (!WalletViewModel.this.isAlreadySelected) {
                    WalletViewModel.this.walletListener.shouldEnableProceed(true);
                    WalletViewModel.this.convFeeTextVisibility.set(8);
                } else if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    WalletViewModel.this.convFeeTextVisibility.set(8);
                    WalletViewModel.this.walletListener.shouldEnableProceed(false);
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, WalletViewModel.this.mContext);
                } else {
                    PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = verifyResponseData.getConvFeeResponse();
                    String unused = WalletViewModel.this.aggregatePgConvenienceFee = convFeeResponse.getAggregatePGConvFee();
                    ArrayList unused2 = WalletViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(convFeeResponse, (ArrayList<PaymentIntent>) WalletViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                    if (ConvenienceFeeController.getInstance().checkConvenienceFeeOverFlow(PayMethodType.BALANCE.name(), SDKUtility.parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE)), WalletViewModel.this.paymentIntents)) {
                        WalletViewModel.this.handleConvFeeOverflowScenario();
                        WalletViewModel.this.convFeeTextVisibility.set(8);
                    } else {
                        WalletViewModel.this.configureConvFeeView();
                    }
                    WalletViewModel.this.walletListener.shouldEnableProceed(true);
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                WalletViewModel.this.hideLoading();
                if (!WalletViewModel.this.isAlreadySelected) {
                    WalletViewModel.this.walletListener.shouldEnableProceed(true);
                    WalletViewModel.this.convFeeTextVisibility.set(8);
                    return;
                }
                WalletViewModel.this.convFeeTextVisibility.set(8);
                WalletViewModel.this.walletListener.shouldEnableProceed(false);
                SDKUtility.handleVerticalError(apiResponseError, WalletViewModel.this.mContext);
            }
        });
    }

    private ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        if (this.paymentModes == null) {
            return null;
        }
        if (SDKUtility.isHybridCase()) {
            return this.paymentModes.getHybridPaymentOffer();
        }
        return this.paymentModes.getPaymentOffer();
    }

    /* access modifiers changed from: private */
    public void configureConvFeeView() {
        Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            if (next.getMode().equalsIgnoreCase(PayMethodType.BALANCE.name())) {
                this.instrumentConvenienceFee = next.getConvFee();
                setPaySecurelyText();
                if (SDKUtility.parseDouble(this.aggregatePgConvenienceFee) > 0.0d) {
                    this.convFeeTextVisibility.set(0);
                    SDKUtility.setConvenienceFeeText(this.convFeeText, SDKUtility.priceWithoutDecimal(this.aggregatePgConvenienceFee), next.getConvFeeText(), this.mContext);
                    return;
                }
                this.convFeeTextVisibility.set(8);
                return;
            }
        }
    }

    private void hideConvenienceFee() {
        this.convFeeTextVisibility.set(8);
        hideLoading();
    }

    /* access modifiers changed from: private */
    public void handleConvFeeOverflowScenario() {
        if (ConvenienceFeeController.getInstance().isConvenienceFeeHybridCase()) {
            this.proceedVisible.set(8);
        } else {
            setValid(false);
            this.walletListener.disableView(true);
            payMethodSelected((View) null);
        }
        Intent intent = new Intent();
        intent.setAction(SDKConstants.SELECT_NEXT_INSTRUMENT);
        intent.putExtra(SDKConstants.SELECTED_INSTRUMENT, SDKConstants.GA_KEY_BALANCE);
        a.a(this.mContext.getApplicationContext()).a(intent);
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.mContext, this.totalInstantDiscount, this.instrumentConvenienceFee));
    }

    private void invalidatePaymentIntent() {
        this.paymentIntents = null;
        this.instrumentConvenienceFee = 0.0d;
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    private void showLoading(String str) {
        this.loaderMsg.set(str);
        this.loaderVisibility.set(0);
        this.convFeeTextVisibility.set(8);
        this.walletListener.startCheckingOfferAnimation();
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.walletListener.stopCheckingOfferAnimation();
    }

    private ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public void showOtpView() {
        this.otpViewVisibilty.set(0);
    }

    public void validateWalletOtp(String str) {
        PaymentRepository.Companion.getInstance(this.mContext).validateWalletOtpRequest(str, new PaymentMethodDataSource.Callback<WalletOtpResponse>() {
            public void onErrorResponse(VolleyError volleyError, WalletOtpResponse walletOtpResponse) {
            }

            public void onResponse(WalletOtpResponse walletOtpResponse) {
                if (walletOtpResponse != null) {
                    if (!(walletOtpResponse.getBody() == null || walletOtpResponse.getBody().getResultInfo() == null || walletOtpResponse.getBody().getResultInfo().getResultCode() == null)) {
                        walletOtpResponse.getBody().getResultInfo().getResultCode();
                        WalletViewModel.this.mWalletValidateOtpResponse.postValue(walletOtpResponse);
                    }
                    WalletViewModel.this.hideOtpView();
                }
            }
        });
    }

    public void sendWalletOtp() {
        PaymentRepository.Companion.getInstance(this.mContext).sendWalletOtpRequest(MerchantBL.getMerchantInstance().getMobileNumber(), new PaymentMethodDataSource.Callback<WalletOtpResponse>() {
            public void onErrorResponse(VolleyError volleyError, WalletOtpResponse walletOtpResponse) {
            }

            public void onResponse(WalletOtpResponse walletOtpResponse) {
                if (walletOtpResponse != null && walletOtpResponse.getBody() != null && walletOtpResponse.getBody().getResultInfo() != null && !TextUtils.isEmpty(walletOtpResponse.getBody().getResultInfo().getResultCode())) {
                    WalletViewModel.this.mWalletOtpResponse.postValue(walletOtpResponse);
                }
            }
        });
    }

    public void onWalletCheckChanged(View view, boolean z) {
        DirectPaymentBL.getInstance().setWalletChecked(z);
        if (!DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
            return;
        }
        if (!z) {
            this.walletSendOtpButtVisibility.set(8);
            this.walletOtpTxtVisibility.set(8);
            this.otpViewVisibilty.set(8);
        } else if (DirectPaymentBL.getInstance().isWalletOtpValidated()) {
            this.walletSendOtpButtVisibility.set(8);
            this.walletOtpTxtVisibility.set(8);
        } else {
            this.walletOtpTxtVisibility.set(0);
            this.walletSendOtpButtVisibility.set(0);
        }
    }

    public void hideOtpView() {
        this.otpViewVisibilty.set(8);
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }

    public void showHideBankOfferError(boolean z) {
        if (!z) {
            this.bankOfferText.set(new SpannableString(""));
            this.bankOfferVisibility.set(8);
        } else if (SDKUtility.shouldShowValidatePromoError()) {
            i<SpannableString> iVar = this.bankOfferText;
            Context context = this.mContext;
            iVar.set(SDKUtility.getBankOfferText(context, context.getString(R.string.applied_promocode_not_valid), (ApplyPromoResponse.PaymentOffer) null));
            this.bankOfferVisibility.set(0);
        }
    }
}
