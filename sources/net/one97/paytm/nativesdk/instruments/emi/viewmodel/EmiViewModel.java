package net.one97.paytm.nativesdk.instruments.emi.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.c;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardUIValidator;
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
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard;
import net.one97.paytm.nativesdk.cvvHelp.view.CvvHelpBottomSheet;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.instruments.emi.listeners.EmiClickListener;
import net.one97.paytm.nativesdk.instruments.emi.view.EmiView;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class EmiViewModel extends BaseViewModel {
    public i<String> addedCardNumber = new i<>("");
    public i<String> addedTotalAmountText = new i<>("");
    public i<String> amount = new i<>("");
    public ObservableInt appliedOffersVisibility = new ObservableInt(8);
    private String bankCode = "";
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public boolean binBinCallInProgress = false;
    private c binDialog = null;
    /* access modifiers changed from: private */
    public String cardHash;
    private String cardNumber;
    private CardUIValidator cardUIValidator;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    private String currentEmiPlanId;
    private String cvvNumber;
    private char dash = '-';
    private BankData emiBankData;
    /* access modifiers changed from: private */
    public EmiChannelInfo emiChannelInfo;
    public i<String> emiDisplayName;
    private String emiPlanBody;
    private String expiryDate;
    /* access modifiers changed from: private */
    public String fetchPlanString;
    private double instrumentConvenienceFee;
    private boolean isBinResponseReceived = false;
    private boolean isToSaveCard = false;
    private boolean isViewUpdatedToNew = false;
    private boolean isZestMoneyTransaction = false;
    /* access modifiers changed from: private */
    public EmiClickListener listener;
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    private Double multiEmiNetAmount;
    private String newCardType;
    public i<String> paySecurelyText = new i<>();
    private ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public PaymentModes paymentModes;
    public i<String> promoCodeText;
    public ObservableInt promoCodeVisibility = new ObservableInt(8);
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    public ObservableBoolean rbChooseAnotherChecked = new ObservableBoolean(false);
    /* access modifiers changed from: private */
    public boolean requestTenure = false;
    private String subventedOfferText;
    public i<String> subventionOfferText = new i<>("");
    public ObservableInt subventionOfferVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Object verifyResponseModel;
    public ObservableBoolean visibilityAnotherCard = new ObservableBoolean(false);
    public ObservableBoolean visibilityCardImage = new ObservableBoolean(false);
    public ObservableBoolean visibilityCardNumber = new ObservableBoolean(false);
    public ObservableBoolean visibilityChangeBankCard = new ObservableBoolean(true);
    public ObservableBoolean visibilityCross = new ObservableBoolean(false);
    public ObservableBoolean visibilityCvvLayout = new ObservableBoolean(false);
    public ObservableBoolean visibilityProceedBtn = new ObservableBoolean(false);
    public ObservableBoolean visibilitySavedCardContainer = new ObservableBoolean(false);
    public ObservableBoolean visibilitySelectBank = new ObservableBoolean(false);
    public ObservableBoolean visibilitySelectPlan = new ObservableBoolean(false);
    public ObservableBoolean visibilitySelectedCardView = new ObservableBoolean(false);
    public ObservableBoolean visibilitySelectedPlan = new ObservableBoolean(false);
    public ObservableBoolean visibilityTnC = new ObservableBoolean(false);
    public ObservableBoolean visibilityTotalAmount = new ObservableBoolean(false);
    public ObservableInt vpaInputLayoutVisiblity;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public EmiViewModel(Context context2, PaymentModes paymentModes2, EmiClickListener emiClickListener) {
        super(context2, emiClickListener);
        this.listener = emiClickListener;
        this.context = context2;
        this.vpaInputLayoutVisiblity = new ObservableInt(8);
        PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.EMI);
        if (instrument != null) {
            this.emiDisplayName = new i<>(instrument.getDisplayName());
        }
        this.cardUIValidator = new CardUIValidator();
        this.paymentModes = paymentModes2;
    }

    public String getEmiType() {
        BankData bankData = this.emiBankData;
        if (bankData == null) {
            return "";
        }
        return bankData.getCardType();
    }

    public String getEmiChannelCode() {
        BankData bankData = this.emiBankData;
        if (bankData == null) {
            return "";
        }
        return bankData.getBankCode();
    }

    public String getEmiChannelName() {
        BankData bankData = this.emiBankData;
        if (bankData == null) {
            return "";
        }
        return bankData.getBankName();
    }

    public EmiChannelInfo getEmiChannelInfo() {
        return this.emiChannelInfo;
    }

    public void setEmiChannelInfo(EmiChannelInfo emiChannelInfo2) {
        this.emiChannelInfo = emiChannelInfo2;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void setZestMoneyTransaction(boolean z) {
        this.isZestMoneyTransaction = z;
    }

    public void setViewUpdatedToNew(boolean z) {
        this.isViewUpdatedToNew = z;
    }

    public boolean isViewUpdatedToNew() {
        return this.isViewUpdatedToNew;
    }

    public void refreshLayout() {
        setAmountIfNeeded();
        clearOffer();
        if (getPaymentOffer() == null) {
            hideOffer();
        }
        this.paymentIntents = null;
        this.fetchPlanString = null;
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else {
            fetchConvenienceFeeForEmi();
        }
        if (this.emiChannelInfo != null) {
            changeBankCardClicked();
        }
    }

    public void proceedToPay(View view) {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getResources().getString(R.string.internet_not_available), 0).show();
        } else if (this.isZestMoneyTransaction) {
            handleZestMoneyTransaction(view);
        } else if (!this.cardUIValidator.isCardValid(this.cardNumber)) {
            this.listener.changeCardView(true);
        } else if (!this.cardUIValidator.isExpiryValid(this.expiryDate)) {
            this.listener.changeExpiryView(true);
        } else if (!this.cardUIValidator.isCvvValid(this.cvvNumber)) {
            this.listener.changeCvvView(true);
        } else if (this.emiChannelInfo == null) {
            Context context3 = this.context;
            Toast.makeText(context3, context3.getResources().getString(R.string.select_emi_plan), 0).show();
        } else {
            String cardInfo = getCardInfo();
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, "EMI"));
            }
            if (SDKUtility.shouldShowValidatePromoError() && (this.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
                setValidatePromoText();
            } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated()) {
                goForTransaction((String) null, cardInfo, this.cardUIValidator.getCardType(), this.emiChannelInfo.getPlanId(), view);
            } else {
                Context context4 = this.context;
                if (context4 != null) {
                    Toast.makeText(this.context, context4.getString(R.string.otp_not_validated), 0).show();
                }
            }
        }
    }

    private String getCardInfo() {
        if (TextUtils.isEmpty(this.cvvNumber)) {
            this.cvvNumber = "111";
        }
        String str = "20";
        if (this.cardUIValidator.isExpiryRequired()) {
            String[] split = this.expiryDate.split("/");
            str = split[0] + str + split[1];
        }
        return "|" + this.cardNumber.replace("-", "") + "|" + this.cvvNumber + "|" + str;
    }

    private void goForTransaction(String str, String str2, String str3, String str4, View view) {
        HashMap<String, String> cardsTranscationParam = PayUtility.getCardsTranscationParam(str, PayMethodType.EMI.name(), str2, this.isToSaveCard ? "1" : "0", str4);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            cardsTranscationParam.put("emiType", this.cardUIValidator.getBinResponse().getBody().getBinDetail().getPaymentMode());
        } else {
            cardsTranscationParam.put(PayUtility.EMI_TYPE, this.cardUIValidator.getBinResponse().getBody().getBinDetail().getPaymentMode());
        }
        cardsTranscationParam.put("channelCode", this.cardUIValidator.getBinResponse().getBody().getBinDetail().getIssuingBankCode());
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), cardsTranscationParam);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument);
        if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getHybridPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
        } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
        }
        transactionProcessor.setPaymentIntent(getPaymentIntent());
        transactionProcessor.setEmiPlanData(this.emiPlanBody);
        transactionProcessor.startTransaction(view);
    }

    public void emiClicked(View view) {
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        this.listener.onViewSelected();
        setAmountIfNeeded();
        this.visibilitySelectBank.set(true);
        this.radioChecked.set(true);
        this.visibilityTnC.set(true);
        if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_COD, SDKConstants.GA_KEY_NEW));
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, "EMI", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            if (DirectPaymentBL.getInstance().getPaymentFlowAvailable().equals(SDKConstants.ADDANDPAY) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, "EMI"));
            }
        }
        this.listener.changeArrowIcon(true);
        setPaySecurelyText();
    }

    public void setAmountIfNeeded() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.amount.set("");
            this.listener.changeRemainingAmt(MerchantBL.getMerchantInstance().getAmount());
            return;
        }
        Double d2 = this.multiEmiNetAmount;
        if (d2 != null) {
            this.amount.set(SDKUtility.getNetEmiAmountText(this.context, d2.doubleValue()));
            return;
        }
        this.amount.set(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{SDKUtility.priceWithoutDecimal(DirectPaymentBL.getInstance().getDifferentialAmount())}));
        this.listener.changeRemainingAmt(DirectPaymentBL.getInstance().getDifferentialAmount());
    }

    private void hideEmiView() {
        this.amount.set("");
        this.radioChecked.set(false);
        this.vpaInputLayoutVisiblity.set(8);
        this.listener.changeArrowIcon(false);
        clearState();
        this.visibilitySelectBank.set(false);
        this.visibilityTnC.set(false);
    }

    public void deselectView() {
        clearState();
        hideEmiView();
        hideOffer();
    }

    public void selectBankClicked(View view) {
        this.listener.openSelectBankActivity();
    }

    public void cardNumberAfterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString())) {
            this.visibilityCross.set(false);
        } else {
            this.visibilityCross.set(true);
        }
        if (editable.length() > 0 && editable.length() % 5 == 0 && this.dash == editable.charAt(editable.length() - 1)) {
            editable.delete(editable.length() - 1, editable.length());
        }
        if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(this.dash)).length <= 4) {
            editable.insert(editable.length() - 1, String.valueOf(this.dash));
        }
        hideOffer();
        PaymentModes paymentModes2 = this.paymentModes;
        if (paymentModes2 != null) {
            paymentModes2.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        }
        this.subventedOfferText = null;
        this.cardNumber = editable.toString();
        String str = this.newCardType;
        if (str != null) {
            if (str.equalsIgnoreCase(SDKConstants.AMEX) && editable.length() == 18) {
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, isCreditCardLayout());
                fetchCardDetails();
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                }
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.DINERS) && editable.length() == 17) {
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, isCreditCardLayout());
                fetchCardDetails();
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                }
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) && editable.length() == 23) {
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, isCreditCardLayout());
                fetchCardDetails();
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                }
            } else if ((this.newCardType.equalsIgnoreCase(SDKConstants.MASTER) || this.newCardType.equalsIgnoreCase(SDKConstants.BAJAJ) || this.newCardType.equalsIgnoreCase(SDKConstants.VISA) || this.newCardType.equalsIgnoreCase(SDKConstants.RUPAY)) && editable.length() == 19) {
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, isCreditCardLayout());
                fetchCardDetails();
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                }
            }
        }
        if (this.cardNumber.length() == 7 || (this.cardNumber.length() > 7 && !this.isBinResponseReceived)) {
            fetchBinDetails(this.cardNumber.replace(String.valueOf(this.dash), ""));
        }
        if (this.cardNumber.length() < 7) {
            this.newCardType = null;
            clearConvenienceFee();
            setAmountIfNeeded();
            this.visibilityCardImage.set(false);
        }
    }

    public void hideOffer() {
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        setPaySecurelyText();
        hideSubventedOffer();
    }

    /* access modifiers changed from: private */
    public void showServerFailureAlert(VolleyError volleyError) {
        String str;
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        try {
            str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, AppConstants.UTF_8), this.context);
        } catch (Exception unused) {
            str = this.context.getResources().getString(R.string.server_communication_failed);
        }
        Context context2 = this.context;
        DialogUtility.showDialog(context2, context2.getResources().getString(R.string.unknown_error), str, (DialogInterface.OnClickListener) null);
    }

    public void crossClicked(View view) {
        this.listener.clearCardInfo();
        this.visibilityCardImage.set(false);
        clearConvenienceFee();
    }

    private void clearConvenienceFee() {
        this.paymentIntents = null;
        this.convFeeTextVisibility.set(8);
        this.convFeeText.set(new SpannableString(""));
        this.instrumentConvenienceFee = 0.0d;
    }

    public void expiryAfterTextChange(Editable editable) {
        if (editable.length() > 0 && editable.length() == 3 && '/' == editable.charAt(editable.length() - 1)) {
            editable.delete(editable.length() - 1, editable.length());
        }
        if (editable.length() > 0 && editable.length() == 3 && Character.isDigit(editable.charAt(editable.length() - 1))) {
            editable.insert(editable.length() - 1, "/");
        }
        this.listener.changeExpiryView(false);
        this.expiryDate = editable.toString();
        if (editable.length() != 5) {
            return;
        }
        if (this.visibilityCvvLayout.get()) {
            this.listener.cvvEditTextFocus();
        } else {
            this.listener.closeKeyboard();
        }
    }

    public void cvvAfterTextChange(Editable editable) {
        this.cvvNumber = editable.toString();
        this.listener.changeCvvView(false);
        if (this.cardUIValidator.isCvvValid(editable.toString())) {
            this.listener.closeKeyboard();
        }
    }

    public void helpClicked(View view) {
        CvvHelpBottomSheet cvvHelpBottomSheet;
        if (this.newCardType == null || TextUtils.isEmpty(this.cardNumber)) {
            cvvHelpBottomSheet = CvvHelpBottomSheet.getInstance(CvvHelpCard.ALL);
        } else if (this.newCardType.equalsIgnoreCase(SDKConstants.AMEX)) {
            cvvHelpBottomSheet = CvvHelpBottomSheet.getInstance(CvvHelpCard.AMEX);
        } else {
            cvvHelpBottomSheet = CvvHelpBottomSheet.getInstance(CvvHelpCard.NON_AMEX);
        }
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("cvvsheet");
        cvvHelpBottomSheet.show(a2, (String) null);
    }

    public void anotherCardClicked(View view) {
        if (!this.isViewUpdatedToNew || this.emiChannelInfo == null) {
            this.visibilityCardNumber.set(true);
            this.visibilitySelectPlan.set(true);
            this.visibilitySelectedCardView.set(false);
            this.visibilitySelectedPlan.set(false);
            this.visibilityCvvLayout.set(false);
            this.visibilityProceedBtn.set(false);
        } else {
            this.visibilitySelectPlan.set(false);
            this.visibilityCardNumber.set(false);
            this.visibilitySelectedCardView.set(true);
            this.visibilitySelectedPlan.set(true);
            if (!TextUtils.isEmpty(this.addedTotalAmountText.get())) {
                this.visibilityTotalAmount.set(true);
            } else {
                this.visibilityTotalAmount.set(false);
            }
            this.visibilityCvvLayout.set(true);
            this.visibilityChangeBankCard.set(true);
            this.visibilityProceedBtn.set(true);
        }
        getBankOffers();
        configureConvFeeView();
        this.rbChooseAnotherChecked.set(true);
        this.listener.deSelectSavedCard();
    }

    public void changeBankCardClicked() {
        this.visibilityCardNumber.set(true);
        this.visibilitySelectPlan.set(true);
        this.visibilitySelectedCardView.set(false);
        this.visibilitySelectedPlan.set(false);
        this.visibilityCvvLayout.set(false);
        this.visibilityProceedBtn.set(false);
        this.emiChannelInfo = null;
        this.emiPlanBody = null;
        this.isViewUpdatedToNew = false;
        this.subventedOfferText = "";
        this.fetchPlanString = null;
        this.listener.enableDisableCVV(true);
        this.listener.enableDisableExpiry(true);
        updateSubventedOfferView();
    }

    /* access modifiers changed from: private */
    public void handleBinResponse(String str, BinResponse binResponse) {
        String str2;
        if (binResponse != null && binResponse.getBody() != null) {
            this.cardUIValidator.setBinResponse(binResponse);
            if (!(binResponse.getBody() == null || binResponse.getBody().getResultInfo() == null || binResponse.getBody().getResultInfo().getResultStatus() == null || !binResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase(AppConstants.FEED_SUB_TYPE))) {
                c cVar = this.binDialog;
                if (cVar == null) {
                    this.binDialog = DialogUtility.showDialog(this.context, binResponse.getBody().getResultInfo().getResultMsg(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            EmiViewModel.this.crossClicked((View) null);
                        }
                    });
                } else if (!cVar.isShowing()) {
                    this.binDialog.show();
                }
            }
            String emiType = getEmiType();
            if (!TextUtils.isEmpty(emiType) && !emiType.equalsIgnoreCase(binResponse.getBody().getBinDetail().getPaymentMode())) {
                c cVar2 = this.binDialog;
                if (cVar2 == null) {
                    if (binResponse.getBody().getBinDetail().getPaymentMode().equalsIgnoreCase(SDKConstants.DEBIT)) {
                        str2 = "Card number you have entered is of Debit Card";
                    } else {
                        str2 = binResponse.getBody().getBinDetail().getPaymentMode().equalsIgnoreCase(SDKConstants.CREDIT) ? "Card number you have entered is of Credit Card" : "";
                    }
                    this.binDialog = DialogUtility.showDialog(this.context, str2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            EmiViewModel.this.crossClicked((View) null);
                        }
                    });
                } else if (!cVar2.isShowing()) {
                    this.binDialog.show();
                }
            }
            if (binResponse.getBody().getBinDetail() != null) {
                this.newCardType = binResponse.getBody().getBinDetail().getChannelCode();
            }
            this.listener.binResponseReceived(binResponse);
            if (this.cardUIValidator.isCVVRequired()) {
                this.listener.enableDisableCVV(true);
            } else {
                this.listener.enableDisableCVV(false);
            }
            if (this.cardUIValidator.isExpiryRequired()) {
                this.listener.enableDisableExpiry(true);
            } else {
                this.listener.enableDisableExpiry(false);
            }
            this.isBinResponseReceived = true;
        }
    }

    /* access modifiers changed from: private */
    public void handleBinError() {
        this.listener.enableDisableCVV(true);
        this.listener.enableDisableExpiry(true);
    }

    public void deSelectAddedCard() {
        if (!this.isViewUpdatedToNew || this.emiChannelInfo == null) {
            this.visibilitySelectedCardView.set(false);
            this.visibilityCardNumber.set(false);
            this.visibilityCardImage.set(false);
        } else {
            this.visibilitySelectedCardView.set(true);
            this.visibilityCardNumber.set(false);
            this.visibilityCardImage.set(false);
        }
        this.visibilityProceedBtn.set(false);
        this.visibilityCross.set(false);
        this.visibilitySelectPlan.set(false);
        this.rbChooseAnotherChecked.set(false);
        this.visibilityCvvLayout.set(false);
        this.visibilitySelectedPlan.set(false);
        this.visibilityCvvLayout.set(false);
        this.visibilityChangeBankCard.set(false);
        this.convFeeTextVisibility.set(8);
        this.visibilityTotalAmount.set(false);
        setSubventedOfferText((String) null);
        hideOffer();
    }

    public void clearState() {
        this.visibilityProceedBtn.set(false);
        this.visibilitySavedCardContainer.set(false);
        this.visibilityAnotherCard.set(false);
        this.visibilityCardNumber.set(false);
        this.visibilityCardImage.set(false);
        this.visibilityCross.set(false);
        this.visibilitySelectPlan.set(false);
        this.visibilitySelectedCardView.set(false);
        this.visibilityCvvLayout.set(false);
        this.visibilitySelectedPlan.set(false);
        this.visibilityChangeBankCard.set(false);
        this.visibilityCardNumber.set(false);
        this.visibilityCardImage.set(false);
        this.emiBankData = null;
        this.emiChannelInfo = null;
        this.emiPlanBody = null;
        this.isViewUpdatedToNew = false;
        this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.rbChooseAnotherChecked.set(false);
        this.convFeeTextVisibility.set(8);
        this.fetchPlanString = null;
        this.listener.enableDisableCVV(true);
        this.listener.enableDisableExpiry(true);
        setPaySecurelyText();
        setSubventedOfferText((String) null);
        setAddedTotalAmountText((String) null);
    }

    private void handleZestMoneyTransaction(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put(PayUtility.AUTH_MODE, "3D");
        hashMap.put("paymentMode", "EMI");
        hashMap.put("channelCode", SDKConstants.ZEST_MONEY_CHANNEL_CODE);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            hashMap.put("emiType", "NBFC");
        } else {
            hashMap.put(PayUtility.EMI_TYPE, "NBFC");
        }
        hashMap.put("isEmi", "true");
        if (!DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            hashMap.put(PayUtility.PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            hashMap.put(PayUtility.PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else {
            hashMap.put(PayUtility.PAYMENT_FLOW, DirectPaymentBL.getInstance().getPaymentFlowAvailable());
        }
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), hashMap);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_COD);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument).startTransaction(view);
    }

    public CardUIValidator getCardUIValidator() {
        return this.cardUIValidator;
    }

    public void setEmiDetails(BankData bankData) {
        this.emiBankData = bankData;
    }

    public BankData getSelectedBankData() {
        return this.emiBankData;
    }

    public void clearOffer() {
        this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
    }

    /* access modifiers changed from: private */
    public boolean isCreditCardLayout() {
        return PayMethodType.CREDIT_CARD.name().equalsIgnoreCase(this.cardUIValidator.getBinPayMode(SDKConstants.CREDIT));
    }

    /* access modifiers changed from: private */
    public void showBankOffers() {
        ApplyPromoResponse.PaymentOffer hybridPaymentOffer = SDKUtility.isHybridCase() ? this.paymentModes.getHybridPaymentOffer() : this.paymentModes.getPaymentOffer();
        if (SDKUtility.isOfferValid(hybridPaymentOffer) || SDKUtility.shouldShowValidatePromoError() || hybridPaymentOffer.getOfferBreakup() == null || hybridPaymentOffer.getOfferBreakup().size() <= 0) {
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
            if (hybridPaymentOffer.getTotalCashbackAmount() != null) {
                this.bankOfferVisibility.set(0);
                i iVar = this.bankOfferText;
                Context context2 = this.context;
                iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.cashback_applied_successfully, new Object[]{hybridPaymentOffer.getTotalCashbackAmount()}), hybridPaymentOffer));
                this.cashBackTextVisibility.set(0);
                this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(hybridPaymentOffer.getTotalCashbackAmount()))}));
                this.applyPromoFailed = false;
            } else if (hybridPaymentOffer.getTotalInstantDiscount() != null) {
                this.bankOfferVisibility.set(0);
                i iVar2 = this.bankOfferText;
                Context context3 = this.context;
                iVar2.set(SDKUtility.getBankOfferText(context3, context3.getString(R.string.instant_discount_applied_successfully, new Object[]{hybridPaymentOffer.getTotalInstantDiscount()}), hybridPaymentOffer));
                this.cashBackTextVisibility.set(8);
                this.applyPromoFailed = false;
                setPaySecurelyText();
            } else {
                this.bankOfferVisibility.set(8);
                setValidatePromoText();
            }
            updateSubventedOfferView();
        }
    }

    public void showErrorDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.context.getString(R.string.something_went_wrong);
        }
        DialogUtility.showDialog(this.context, str, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void fetchConvenienceFeeForEmi() {
        if (!TextUtils.isEmpty(getEmiType()) && !TextUtils.isEmpty(this.cardNumber)) {
            buildPaymentIntent();
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                getConvenienceFee();
            }
        }
    }

    public void buildPaymentIntent() {
        ArrayList arrayList;
        ArrayList arrayList2;
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.cardHash);
        CardUIValidator cardUIValidator2 = getCardUIValidator();
        if (cardUIValidator2 == null || cardUIValidator2.getBinResponse() == null || cardUIValidator2.getBinResponse().getBody() == null) {
            arrayList2 = null;
            arrayList = null;
        } else {
            BinDetail binDetail = cardUIValidator2.getBinResponse().getBody().getBinDetail();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(binDetail.getChannelCode());
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(binDetail.getIssuingBankCode());
            arrayList = arrayList4;
            arrayList2 = arrayList3;
        }
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), arrayList2, arrayList, cardPaymentIntentData, getEmiType(), Double.valueOf(getTotalInstantDiscount()));
    }

    /* access modifiers changed from: private */
    public void handleConvFeeResponse(PaytmSDKRequestClient.ConvFeeResponse convFeeResponse, Object obj) {
        this.paymentIntents = ConvenienceFeeController.getInstance().setConvFeeResponse(convFeeResponse, this.paymentIntents, obj);
        this.listener.enableProceedButton();
        configureConvFeeView();
    }

    public void setPaySecurelyText() {
        Double d2 = this.multiEmiNetAmount;
        if (d2 != null) {
            this.paySecurelyText.set(SDKUtility.getNetEmiPaySecurelyText(this.context, d2.doubleValue()));
        } else {
            this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
        }
    }

    public void setPaySecurelyText(String str) {
        this.multiEmiNetAmount = Double.valueOf(SDKUtility.parseDouble(str));
        setPaySecurelyText();
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        if (this.paymentModes == null) {
            return null;
        }
        if (SDKUtility.isHybridCase()) {
            return this.paymentModes.getHybridPaymentOffer();
        }
        return this.paymentModes.getPaymentOffer();
    }

    public Object getVerifyResponseModel() {
        return this.verifyResponseModel;
    }

    public void setVerifyResponseModel(Object obj) {
        this.verifyResponseModel = obj;
    }

    private double getTotalInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (paymentOffer == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    public void setPaymentIntents(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntents = new ArrayList<>();
        this.paymentIntents.addAll(arrayList);
    }

    public void configureConvFeeView() {
        ArrayList<PaymentIntent> arrayList = this.paymentIntents;
        if (arrayList == null) {
            this.convFeeTextVisibility.set(8);
            return;
        }
        Iterator<PaymentIntent> it2 = arrayList.iterator();
        String str = null;
        double d2 = 0.0d;
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            d2 += next.getConvFee();
            String convFeeText2 = next.getConvFeeText();
            if (next.getMode().equalsIgnoreCase(PayMethodType.EMI.name())) {
                next.setCardHash(this.cardHash);
                this.instrumentConvenienceFee = next.getConvFee();
                setPaySecurelyText();
                setAmountIfNeeded();
                if (getPaymentOffer() != null && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
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

    private void showLoading(String str) {
        this.loaderMsg.set(str);
        this.loaderVisibility.set(0);
        this.convFeeTextVisibility.set(8);
        this.listener.startCheckingOfferAnimation();
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.listener.stopCheckingOfferAnimation();
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String str) {
        this.cardHash = str;
    }

    public double getEmiConvenienceFee() {
        return this.instrumentConvenienceFee;
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public void setFetchPlanString(String str) {
        this.fetchPlanString = str;
    }

    public void setEmiResponseData(String str) {
        this.emiPlanBody = str;
    }

    public void setCurrentEmiPlanId(String str) {
        this.currentEmiPlanId = str;
    }

    public void fetchTenures() {
        if (TextUtils.isEmpty(this.cardHash) && ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            this.requestTenure = true;
        } else if (!DirectPaymentBL.getInstance().isBankOffersAvailable() || getPaymentOffer() != null) {
            this.requestTenure = false;
            if (!SDKUtility.isNetworkAvailable(this.context)) {
                Context context2 = this.context;
                SDKUtility.showErrorInSnackBar(context2, context2.getResources().getString(R.string.no_connection), this.context.getResources().getString(R.string.no_internet));
                return;
            }
            String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(SDKUtility.getDiffAmount());
            ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
            String str = null;
            if (SDKUtility.isOfferValid(getPaymentOffer())) {
                str = new f().b(paymentOffer);
                priceWithoutDecimal = MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalInstantDiscount()));
            }
            final String str2 = priceWithoutDecimal;
            final String str3 = str;
            String str4 = this.fetchPlanString;
            if (str4 != null) {
                this.listener.onTenureSuccess(str4);
                if (isSelected()) {
                    EmiUtil.startEmiPlanActivity(this.context, this.fetchPlanString, str2, "EMI_VIEW", EmiUtil.EMI_PLAN_REQUEST_CODE, getPaymentIntent(), str3, this.currentEmiPlanId);
                    return;
                }
                return;
            }
            EmiUtil.fetchTenuresWithOffers(getSelectedBankData(), new ISubventionProvider.IBankTenureListener() {
                public void onBankSuccessResponse(String str) {
                    String unused = EmiViewModel.this.fetchPlanString = str;
                    String planId = EmiViewModel.this.emiChannelInfo != null ? EmiViewModel.this.emiChannelInfo.getPlanId() : "";
                    if (EmiViewModel.this.isSelected()) {
                        EmiUtil.startEmiPlanActivity(EmiViewModel.this.context, str, str2, "EMI_VIEW", EmiUtil.EMI_PLAN_REQUEST_CODE, EmiViewModel.this.getPaymentIntent(), str3, planId);
                    }
                    EmiViewModel.this.listener.onTenureSuccess(str);
                }

                public void onBankError(String str, String str2) {
                    EmiViewModel.this.listener.onTenureFailure(str, str2);
                }

                public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                    if (EmiUtil.isAuthError(apiResponseError)) {
                        SDKUtility.handleVerticalError(apiResponseError, EmiViewModel.this.context);
                    } else {
                        EmiViewModel.this.listener.onTenureFailure(apiResponseError.getErrorTitle(), apiResponseError.getErrorMsg());
                    }
                }
            }, getPaymentIntent(), str3);
        } else {
            this.requestTenure = true;
        }
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
        showLoading(this.context.getString(R.string.conv_fee_fetching));
        this.listener.disableProceedButton();
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                EmiViewModel.this.hideLoading();
                if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    EmiViewModel.this.listener.disableProceedButton();
                    EmiViewModel.this.convFeeTextVisibility.set(8);
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, EmiViewModel.this.context);
                    return;
                }
                Object unused = EmiViewModel.this.verifyResponseModel = verifyResponseData.getVerifyModel();
                EmiViewModel.this.handleConvFeeResponse(verifyResponseData.getConvFeeResponse(), EmiViewModel.this.verifyResponseModel);
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                EmiViewModel.this.hideLoading();
                EmiViewModel.this.convFeeTextVisibility.set(8);
                EmiViewModel.this.listener.disableProceedButton();
                SDKUtility.handleVerticalError(apiResponseError, EmiViewModel.this.context);
            }
        });
    }

    private void fetchCardDetails() {
        if (!TextUtils.isEmpty(this.cardNumber) && ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            NativeSDKRepository.getInstance().fetchCardDetails(APIReqtGenerator.getFetchCardDetailsRequestObject(true, this.cardNumber), (PaymentMethodDataSource.Callback<FetchCardDetailsResponse>) new PaymentMethodDataSource.Callback<FetchCardDetailsResponse>() {
                public void onResponse(FetchCardDetailsResponse fetchCardDetailsResponse) {
                    if (fetchCardDetailsResponse == null || fetchCardDetailsResponse.getBody() == null) {
                        EmiViewModel.this.showErrorDialog((String) null);
                        EmiViewModel.this.listener.disableProceedButton();
                        return;
                    }
                    String unused = EmiViewModel.this.cardHash = fetchCardDetailsResponse.getBody().getCardHash();
                    if (TextUtils.isEmpty(EmiViewModel.this.cardHash)) {
                        EmiViewModel emiViewModel = EmiViewModel.this;
                        emiViewModel.showErrorDialog(emiViewModel.context.getString(R.string.card_details_error));
                        return;
                    }
                    EmiViewModel.this.buildPaymentIntent();
                    EmiViewModel.this.fetchConvenienceFeeForEmi();
                    if (EmiViewModel.this.requestTenure) {
                        EmiViewModel.this.fetchTenures();
                    }
                }

                public void onErrorResponse(VolleyError volleyError, FetchCardDetailsResponse fetchCardDetailsResponse) {
                    EmiViewModel.this.showErrorDialog(volleyError != null ? volleyError.getMessage() : "");
                    EmiViewModel.this.listener.disableProceedButton();
                }
            });
        }
    }

    private void getBankOffers() {
        BankData bankData;
        if (!DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            fetchConvenienceFeeForEmi();
        } else if (TextUtils.isEmpty(this.cardNumber) || (bankData = this.emiBankData) == null || TextUtils.isEmpty(bankData.getBankCode())) {
            fetchConvenienceFeeForEmi();
        } else {
            this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            if (isCreditCardLayout()) {
                paymentOption.setPayMethod("EMI");
            } else {
                paymentOption.setPayMethod(SDKConstants.EMI_DC);
            }
            paymentOption.setBankCode(this.emiBankData.getBankCode());
            paymentOption.setCardNo(this.cardNumber.replace("-", ""));
            this.listener.disableProceedButton();
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                showLoading(this.context.getString(R.string.conv_fee_fetching));
            } else {
                showLoading(this.context.getString(R.string.native_checking_offers));
            }
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private boolean isHybridRequest = SDKUtility.isHybridCase();

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    EmiViewModel.this.listener.enableProceedButton();
                    EmiViewModel.this.hideLoading();
                    if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                        EmiViewModel.this.setValidatePromoText();
                        DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                    } else {
                        if (this.isHybridRequest) {
                            EmiViewModel.this.paymentModes.setHybridPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                        } else {
                            EmiViewModel.this.paymentModes.setPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                        }
                        EmiViewModel.this.showBankOffers();
                        SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                    }
                    if (EmiViewModel.this.requestTenure) {
                        EmiViewModel.this.fetchTenures();
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    EmiViewModel.this.listener.enableProceedButton();
                    EmiViewModel.this.bankOfferVisibility.set(8);
                    EmiViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                    EmiViewModel.this.hideLoading();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean isSelected() {
        return DirectPaymentBL.getInstance().getPaytmBaseView() instanceof EmiView;
    }

    private void fetchBinDetails(final String str) {
        if (!this.binBinCallInProgress) {
            this.binBinCallInProgress = true;
            this.cardUIValidator.setBinResponse((BinResponse) null);
            NativeSDKRepository.getInstance().fetchBinDetails(str, new PaymentMethodDataSource.Callback<BinResponse>() {
                public void onResponse(BinResponse binResponse) {
                    boolean unused = EmiViewModel.this.binBinCallInProgress = false;
                    EmiViewModel.this.handleBinResponse(str, binResponse);
                }

                public void onErrorResponse(VolleyError volleyError, BinResponse binResponse) {
                    boolean unused = EmiViewModel.this.binBinCallInProgress = false;
                    EmiViewModel.this.handleBinError();
                }
            });
        }
    }

    private void hitPromoCodeApi(String str, boolean z) {
        if (DirectPaymentBL.getInstance().isPromoCodeExist()) {
            final String promoCodeApiUrl = NativeSdkGtmLoader.getPromoCodeApiUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
            NativeSDKRepository.getInstance().fetchPromoCodeDetail(str.replace(String.valueOf(this.dash), ""), z ? SDKConstants.CREDIT : SDKConstants.DEBIT, new PaymentMethodDataSource.Callback<PromoCodeResponse>() {
                public void onResponse(PromoCodeResponse promoCodeResponse) {
                    if (promoCodeResponse != null && promoCodeResponse.getBody() != null && promoCodeResponse.getBody().getPromoCodeDetail() != null && !TextUtils.isEmpty(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg())) {
                        if (promoCodeResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase("FAILURE")) {
                            EmiViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoErrorMsg());
                            EmiViewModel.this.promoCodeVisibility.set(0);
                            EmiViewModel.this.listener.changePromoCodeBg(true);
                            return;
                        }
                        EmiViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg());
                        EmiViewModel.this.promoCodeVisibility.set(0);
                        EmiViewModel.this.listener.changePromoCodeBg(false);
                    }
                }

                public void onErrorResponse(VolleyError volleyError, PromoCodeResponse promoCodeResponse) {
                    EmiViewModel.this.showServerFailureAlert(volleyError);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, EmiViewModel.this.isCreditCardLayout() ? "Credit Card" : "Debit Card", promoCodeApiUrl));
                }
            });
        }
    }

    public void setSubventedOfferText(String str) {
        this.subventedOfferText = str;
    }

    private void showSubventedOffer() {
        this.subventionOfferText.set(this.subventedOfferText);
        this.subventionOfferVisibility.set(0);
    }

    private void hideSubventedOffer() {
        this.subventionOfferText.set(this.subventedOfferText);
        this.subventionOfferVisibility.set(8);
    }

    public void updateSubventedOfferView() {
        if (!TextUtils.isEmpty(this.subventedOfferText)) {
            showSubventedOffer();
        } else {
            hideSubventedOffer();
        }
        if (!SDKUtility.isOfferValid(getPaymentOffer()) || TextUtils.isEmpty(this.subventedOfferText)) {
            this.appliedOffersVisibility.set(8);
        } else {
            this.appliedOffersVisibility.set(0);
        }
    }

    public void setAddedTotalAmountText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.addedTotalAmountText.set("");
            this.visibilityTotalAmount.set(false);
            return;
        }
        this.addedTotalAmountText.set(str);
        this.visibilityTotalAmount.set(true);
    }

    public void openLink(View view) {
        this.listener.tncClickListener();
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }
}
