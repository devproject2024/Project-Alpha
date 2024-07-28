package net.one97.paytm.nativesdk.instruments.upipush.viewmodel;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
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
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.callbacks.SetOnUpiPushListener;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class UpiPushViewModel extends BaseViewModel {
    private static final String DEVICE_BINDING_ACTION_FILTER = "DEVICE_BINDING_ACTION_FILTER";
    private static final String UNREGISTER_DEVICE_BINDING_FILTER = "UNREGISTER_DEVICE_BINDING_FILTER";
    public i<String> amount = new i<>();
    public ObservableInt amountVisibility = new ObservableInt(8);
    private BankOfferUpdateListener bankOfferUpdateListener;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    private ProgressDialog dialog;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer hybridPaymentOffer;
    private double instrumentConvenienceFee;
    public boolean isBalanceFetchHit = false;
    public boolean isSelected = false;
    /* access modifiers changed from: private */
    public SetOnUpiPushListener listener;
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    public i<String> paySecurelyText = new i<>();
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    private PaymentModes paymentModes;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer paymentOffer;
    /* access modifiers changed from: private */
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (UpiPushViewModel.DEVICE_BINDING_ACTION_FILTER.equalsIgnoreCase(intent.getAction())) {
                a.a(context).a(UpiPushViewModel.this.receiver);
            } else if (UpiPushViewModel.UNREGISTER_DEVICE_BINDING_FILTER.equalsIgnoreCase(intent.getAction())) {
                a.a(context).a(UpiPushViewModel.this.receiver);
            }
        }
    };
    private VpaBankAccountDetail vpaDetail;

    public interface BankOfferUpdateListener {
        void onBankOfferFetched();
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public UpiPushViewModel(Context context2, VpaBankAccountDetail vpaBankAccountDetail, PaymentModes paymentModes2, SetOnUpiPushListener setOnUpiPushListener) {
        super(context2, setOnUpiPushListener);
        this.listener = setOnUpiPushListener;
        this.dialog = new ProgressDialog(context2);
        this.dialog.setCancelable(false);
        this.dialog.setMessage(context2.getResources().getString(R.string.please_wait));
        this.context = context2;
        this.paymentModes = paymentModes2;
        this.vpaDetail = vpaBankAccountDetail;
        setPaySecurelyText();
    }

    public void setBankOfferUpdateListener(BankOfferUpdateListener bankOfferUpdateListener2) {
        this.bankOfferUpdateListener = bankOfferUpdateListener2;
    }

    public void proceedClicked(VpaBankAccountDetail vpaBankAccountDetail, View view) {
        if (SDKUtility.isUpiCollectEnabled()) {
            this.cashBackTextVisibility.set(8);
            HashMap<String, String> upiCollectParam = PayUtility.getUpiCollectParam(vpaBankAccountDetail.getName());
            PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), upiCollectParam);
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_COllECT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.UPI_COLLECT, paymentInstrument);
            if (SDKUtility.isHybridCase() && SDKUtility.isOfferValid(this.hybridPaymentOffer)) {
                transactionProcessor.setOfferBody(new f().b(this.hybridPaymentOffer));
            } else if (!SDKUtility.isHybridCase() && SDKUtility.isOfferValid(this.paymentOffer)) {
                transactionProcessor.setOfferBody(new f().b(this.paymentOffer));
            }
            transactionProcessor.setPaymentIntent(getPaymentIntent());
            transactionProcessor.startTransaction(view);
        }
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        ApplyPromoResponse.PaymentOffer paymentOffer2;
        ApplyPromoResponse.PaymentOffer paymentOffer3;
        if (SDKUtility.isHybridCase() && (paymentOffer3 = this.hybridPaymentOffer) != null) {
            return paymentOffer3;
        }
        if (SDKUtility.isHybridCase() || (paymentOffer2 = this.paymentOffer) == null) {
            return null;
        }
        return paymentOffer2;
    }

    public boolean isHybridCase() {
        return DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && !DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && DirectPaymentBL.getInstance().isPaytmWalletChecked();
    }

    public boolean checkIfAmountSufficient(String str) {
        boolean isPayableAmountGreaterThanOwnedMoney = SDKUtility.isPayableAmountGreaterThanOwnedMoney(str, isHybridCase(), this.instrumentConvenienceFee);
        ApplyPromoResponse.PaymentOffer paymentOffer2 = getPaymentOffer();
        if (!SDKUtility.isOfferValid(paymentOffer2) || TextUtils.isEmpty(paymentOffer2.getTotalInstantDiscount())) {
            return isPayableAmountGreaterThanOwnedMoney;
        }
        try {
            return Double.valueOf(paymentOffer2.getTotalInstantDiscount()).doubleValue() > 0.0d ? SDKUtility.isPayableAmountGreaterThanOwnedMoney(str, isHybridCase(), this.instrumentConvenienceFee) : isPayableAmountGreaterThanOwnedMoney;
        } catch (NumberFormatException unused) {
            return isPayableAmountGreaterThanOwnedMoney;
        }
    }

    public void deselectView() {
        this.listener.clearAllSelection();
    }

    public void setSelected() {
        this.isSelected = true;
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else {
            fetchConvenienceFee();
        }
    }

    /* access modifiers changed from: private */
    public void showOffers() {
        ApplyPromoResponse.PaymentOffer paymentOffer2 = SDKUtility.isHybridCase() ? this.hybridPaymentOffer : this.paymentOffer;
        ApplyPromoResponse.PaymentOffer paymentOffer3 = this.paymentOffer;
        if (paymentOffer3 == null || SDKUtility.isOfferValid(paymentOffer3) || SDKUtility.shouldShowValidatePromoError() || this.paymentOffer.getOfferBreakup() == null || this.paymentOffer.getOfferBreakup().size() <= 0) {
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
            if (paymentOffer2 != null) {
                if (paymentOffer2.getTotalCashbackAmount() != null) {
                    this.bankOfferVisibility.set(0);
                    i iVar = this.bankOfferText;
                    Context context2 = this.context;
                    iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.cashback_applied_successfully, new Object[]{paymentOffer2.getTotalCashbackAmount()}), this.paymentOffer));
                    this.cashBackTextVisibility.set(0);
                    this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer2.getTotalCashbackAmount()))}));
                } else if (paymentOffer2.getTotalInstantDiscount() != null) {
                    this.bankOfferVisibility.set(0);
                    i iVar2 = this.bankOfferText;
                    Context context3 = this.context;
                    iVar2.set(SDKUtility.getBankOfferText(context3, context3.getString(R.string.instant_discount_applied_successfully, new Object[]{paymentOffer2.getTotalInstantDiscount()}), this.paymentOffer));
                    this.cashBackTextVisibility.set(8);
                    setPaySecurelyText();
                } else {
                    this.bankOfferVisibility.set(8);
                    this.cashBackTextVisibility.set(8);
                    setValidatePromoText();
                }
            }
            this.bankOfferUpdateListener.onBankOfferFetched();
        }
    }

    public void getBankOffers() {
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            if ((SDKUtility.isHybridCase() ? this.hybridPaymentOffer : this.paymentOffer) != null) {
                showOffers();
                fetchConvenienceFee();
                return;
            }
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            paymentOption.setPayMethod("UPI");
            paymentOption.setVpa(this.vpaDetail.getName());
            this.listener.disableProceedButton();
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                showLoading(this.context.getString(R.string.conv_fee_fetching));
            } else {
                showLoading(this.context.getString(R.string.native_checking_offers));
            }
            this.bankOfferVisibility.set(8);
            this.cashBackTextVisibility.set(8);
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private boolean isHybrid = SDKUtility.isHybridCase();

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    UpiPushViewModel.this.listener.enableProceedButton();
                    UpiPushViewModel.this.hideLoading();
                    if ((DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiPushView) && UpiPushViewModel.this.isSelected) {
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null) {
                            UpiPushViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        } else if (applyPromoResponse.getBody().getPaymentOffer() != null) {
                            if (this.isHybrid) {
                                ApplyPromoResponse.PaymentOffer unused = UpiPushViewModel.this.hybridPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                            } else {
                                ApplyPromoResponse.PaymentOffer unused2 = UpiPushViewModel.this.paymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                            }
                            SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                            UpiPushViewModel upiPushViewModel = UpiPushViewModel.this;
                            upiPushViewModel.applyPromoFailed = false;
                            upiPushViewModel.showOffers();
                        } else {
                            UpiPushViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        }
                        UpiPushViewModel.this.fetchConvenienceFee();
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    UpiPushViewModel.this.listener.enableProceedButton();
                    UpiPushViewModel.this.bankOfferVisibility.set(8);
                    UpiPushViewModel.this.hideLoading();
                    UpiPushViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                }
            });
        }
    }

    public void fetchConvenienceFee() {
        buildPaymentIntent();
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            ArrayList<PaymentIntent> cachedConvenienceFeeIntent = ConvenienceFeeController.getInstance().getCachedConvenienceFeeIntent(this.paymentIntents);
            if (cachedConvenienceFeeIntent != null) {
                this.paymentIntents = cachedConvenienceFeeIntent;
                configureConvFeeView();
                return;
            }
            getConvenienceFee();
        }
    }

    public void buildPaymentIntent() {
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.UPI.name(), (ArrayList<String>) null, (ArrayList<String>) null, (CardPaymentIntentData) null, (String) null, Double.valueOf(getTotalInstantDiscount()));
    }

    private void getConvenienceFee() {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        this.listener.disableProceedButton();
        showLoading(this.context.getString(R.string.conv_fee_fetching));
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                UpiPushViewModel.this.hideLoading();
                if (!UpiPushViewModel.this.isSelected) {
                    UpiPushViewModel.this.listener.enableProceedButton();
                } else if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    UpiPushViewModel.this.convFeeTextVisibility.set(8);
                    UpiPushViewModel.this.listener.disableProceedButton();
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, UpiPushViewModel.this.context);
                } else {
                    ArrayList unused = UpiPushViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) UpiPushViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                    UpiPushViewModel.this.configureConvFeeView();
                    UpiPushViewModel.this.listener.enableProceedButton();
                    UpiPushViewModel.this.listener.updateCheckBalanceLayout();
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                UpiPushViewModel.this.hideLoading();
                UpiPushViewModel.this.convFeeTextVisibility.set(8);
                if (UpiPushViewModel.this.isSelected) {
                    SDKUtility.handleVerticalError(apiResponseError, UpiPushViewModel.this.context);
                    UpiPushViewModel.this.listener.disableProceedButton();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void configureConvFeeView() {
        if (this.isSelected) {
            String str = null;
            Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
            double d2 = 0.0d;
            while (it2.hasNext()) {
                PaymentIntent next = it2.next();
                d2 += next.getConvFee();
                String convFeeText2 = next.getConvFeeText();
                if (next.getMode().equalsIgnoreCase(PayMethodType.UPI.name())) {
                    this.instrumentConvenienceFee = next.getConvFee();
                    setPaySecurelyText();
                    setAmountIfNeeded();
                    if (getPaymentOffer() != null && !DirectPaymentBL.getInstance().isAddMoney() && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
                        this.cashBackTextVisibility.set(0);
                        this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.getDoubleFormaAmount((next.getTxnAmount() + next.getConvFee()) - SDKUtility.parseDouble(getPaymentOffer().getTotalCashbackAmount()))}));
                    }
                }
                str = convFeeText2;
            }
            if (d2 > 0.0d) {
                this.convFeeTextVisibility.set(0);
                SDKUtility.setConvenienceFeeText(this.convFeeText, SDKUtility.priceWithoutDecimal(d2), str, this.context);
                return;
            }
            this.convFeeTextVisibility.set(8);
        }
    }

    public void invalidatePaymentIntent() {
        this.paymentIntents = null;
        this.instrumentConvenienceFee = 0.0d;
    }

    private void showLoading(String str) {
        this.loaderMsg.set(str);
        this.loaderVisibility.set(0);
        this.convFeeTextVisibility.set(8);
        this.listener.startCheckingOfferAnimation();
    }

    private double getTotalInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer2 = getPaymentOffer();
        if (paymentOffer2 == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer2.getTotalInstantDiscount());
    }

    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.listener.stopCheckingOfferAnimation();
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
    }

    public String getNetPayableAmount() {
        return SDKUtility.getNetPayableAmount(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee);
    }

    public Double getNetPayableAmountInDouble() {
        return Double.valueOf(SDKUtility.getNetPayableAmountInDouble(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
    }

    public void setAmountIfNeeded() {
        this.amount.set("");
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

    public void setValidatePromoText() {
        if (SDKUtility.shouldShowValidatePromoError()) {
            this.bankOfferVisibility.set(0);
            this.applyPromoFailed = true;
            i iVar = this.bankOfferText;
            Context context2 = this.context;
            iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.applied_promocode_not_valid), (ApplyPromoResponse.PaymentOffer) null));
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.white), b.c(this.context, R.color.color_fd5c5c), true);
        }
    }
}
