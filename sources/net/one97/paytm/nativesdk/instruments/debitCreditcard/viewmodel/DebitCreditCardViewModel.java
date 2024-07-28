package net.one97.paytm.nativesdk.instruments.debitCreditcard.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.c;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.ApiSession;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.CardUIValidator;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.UpiPushCallbackListener;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentData;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentListener;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.RiskConvenienceFeeItem;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard;
import net.one97.paytm.nativesdk.cvvHelp.view.CvvHelpBottomSheet;
import net.one97.paytm.nativesdk.databinding.SaveCardLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.DebitCreditCardListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.CardType;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.DebitCreditCreditCardsView;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class DebitCreditCardViewModel extends BaseViewModel implements Response.ErrorListener {
    public static final String DIRECT = "direct";
    public static final String REDIRECT = "redirect";
    private static final String otp = "otp";
    private final String AMEX = "AMEX";
    public ObservableBoolean addMoneySaveCardVisibility;
    private String aggregatePgConvenienceFee;
    public i<String> amount = new i<>("");
    public ObservableBoolean animateOneClick = new ObservableBoolean(false);
    public String bankCode = "";
    public String bankName = "";
    private c binDialog = null;
    private BinResponse binResponse;
    /* access modifiers changed from: private */
    public String cardHash;
    public ObservableInt cardImageVisibility;
    private boolean cardLayoutVisible;
    /* access modifiers changed from: private */
    public String cardNumber;
    private int cardSizeShouldBe = 0;
    private CardUIValidator cardUIValidator;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextGravity = new ObservableInt(1);
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    public ObservableInt crossVisibility;
    private String cvvNumber = "";
    private char dash = '-';
    public i<String> debitCardOrCreditCard;
    private EmiChannelInfo emiChannelInfo;
    private ArrayList<SavedCardView> emiSavedCardViews;
    private String emiType;
    public ObservableInt emiVisibility = new ObservableInt(8);
    private EnrollmentListener enrollmentListener;
    private String expiary;
    private String feePercent;
    private String fourDots = " •••• ";
    private VisaEnrollmentHelper helper;
    private double instrumentConvenienceFee;
    /* access modifiers changed from: private */
    public boolean isCreditCardLayout;
    private boolean isEmiView;
    public y<Boolean> isFetchBinCompleted;
    /* access modifiers changed from: private */
    public boolean isFetchBinProcessing;
    public ObservableBoolean isSingleVisaClickChecked = new ObservableBoolean(false);
    public ObservableBoolean isVisaCardEnrolled = new ObservableBoolean(false);
    private boolean isZestMoneyTransaction;
    private SaveCardLayoutBinding lastRadioChecked;
    /* access modifiers changed from: private */
    public DebitCreditCardListener listener;
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    public i<String> lowSuccessRateText;
    public ObservableInt lowSuccessRateVisibility;
    private String mode;
    public Double netPayableAmount;
    public ObservableInt newCardCVVVisibility;
    public ObservableInt newCardContainerVisibilty;
    public String newCardType;
    public String otpAtmTransaction;
    public ObservableBoolean otpRadioChecked;
    public i<String> paySecurelyText = new i<>();
    public i<String> payWithDebitOrCreditCard;
    public ObservableInt payWithNewDebitCardVisibility;
    private ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public PaymentModes paymentModes;
    private int prevEmiSelectedPosition = -1;
    private ObservableInt proceedButtonVisibility;
    public i<String> promoCodeText;
    public ObservableInt promoCodeVisibility;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    private ObservableInt saveCardVisibility;
    private boolean saveNewCard = true;
    public ObservableBoolean savedCardCheckValue = new ObservableBoolean(true);
    public ObservableInt selectEMIPlanVisibility = new ObservableInt(8);
    public ObservableInt showVisaOneClick = new ObservableInt(8);
    private char slash = '/';
    public ObservableInt upiCheckboxVisibility;
    public ObservableBoolean upiConsentChecked;
    public ObservableInt upiPayOptionVisibility;

    public interface SetOnFetchBinResult {
        void onComplete();

        void onError();
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void refreshSavedCards() {
    }

    public void setEmiChannelInfo(EmiChannelInfo emiChannelInfo2) {
        this.emiChannelInfo = emiChannelInfo2;
    }

    public void setEmiType(String str) {
        this.emiType = str;
    }

    public DebitCreditCardViewModel(Context context2, boolean z, boolean z2, DebitCreditCardListener debitCreditCardListener) {
        super(context2, debitCreditCardListener);
        this.context = context2;
        this.listener = debitCreditCardListener;
        this.isCreditCardLayout = z;
        this.isEmiView = z2;
        this.helper = new VisaEnrollmentHelper();
        this.otpRadioChecked = new ObservableBoolean(false);
        this.isFetchBinCompleted = new y<>();
        this.isFetchBinCompleted.setValue(Boolean.FALSE);
        this.listener.clearRadioGroup();
        this.newCardCVVVisibility = new ObservableInt(0);
        this.crossVisibility = new ObservableInt(8);
        this.promoCodeVisibility = new ObservableInt(8);
        this.newCardContainerVisibilty = new ObservableInt(8);
        this.payWithNewDebitCardVisibility = new ObservableInt(8);
        this.proceedButtonVisibility = new ObservableInt(8);
        this.lowSuccessRateVisibility = new ObservableInt(8);
        this.addMoneySaveCardVisibility = new ObservableBoolean(false);
        this.upiCheckboxVisibility = new ObservableInt(8);
        this.upiConsentChecked = new ObservableBoolean(true);
        this.upiPayOptionVisibility = new ObservableInt(8);
        if (DirectPaymentBL.getInstance().isAddMoney()) {
            this.addMoneySaveCardVisibility.set(true);
        }
        this.saveCardVisibility = new ObservableInt(8);
        this.cardImageVisibility = new ObservableInt(4);
        this.lowSuccessRateText = new i<>("");
        this.promoCodeText = new i<>("");
        if (this.isCreditCardLayout) {
            if (DirectPaymentBL.getInstance().getInstrument(PayMethodType.CREDIT_CARD) != null) {
                this.debitCardOrCreditCard = new i<>(DirectPaymentBL.getInstance().getInstrument(PayMethodType.CREDIT_CARD).getDisplayName());
            } else {
                this.debitCardOrCreditCard = new i<>("");
            }
            this.payWithDebitOrCreditCard = new i<>(this.context.getResources().getString(R.string.pay_with_a_new_credit_card));
            this.paymentModes = DirectPaymentBL.getInstance().getInstrument(PayMethodType.CREDIT_CARD);
        } else {
            if (DirectPaymentBL.getInstance().getInstrument(PayMethodType.DEBIT_CARD) != null) {
                this.debitCardOrCreditCard = new i<>(DirectPaymentBL.getInstance().getInstrument(PayMethodType.DEBIT_CARD).getDisplayName());
            } else {
                this.debitCardOrCreditCard = new i<>("");
            }
            this.payWithDebitOrCreditCard = new i<>(this.context.getResources().getString(R.string.pay_with_a_new_debit_card));
            this.paymentModes = DirectPaymentBL.getInstance().getInstrument(PayMethodType.DEBIT_CARD);
        }
        if (this.isEmiView) {
            this.debitCardOrCreditCard = new i<>(DirectPaymentBL.getInstance().getInstrument(PayMethodType.EMI).getDisplayName());
            this.paymentModes = DirectPaymentBL.getInstance().getInstrument(PayMethodType.EMI);
        }
        this.paySecurelyText.set(SDKUtility.getActualPaySecurelyText(this.context));
        this.netPayableAmount = Double.valueOf(SDKUtility.getDiffAmount());
        hideOffer();
        this.cardUIValidator = new CardUIValidator();
    }

    private void preSelectVisaSingleClick() {
        int consentFlagType = SDKUtils.getConsentFlagType();
        if (this.showVisaOneClick.get() != 0 && consentFlagType == SDKConstants.PRE_VISA_SELECTION.intValue()) {
            this.isSingleVisaClickChecked.set(true);
        }
    }

    public void showSavedCards(String str) {
        ArrayList<SavedInstruments> arrayList;
        if (SDKUtility.isSaveCardsAvailable() && !TextUtils.isEmpty(str)) {
            if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getSelectedPaymentMode())) {
                arrayList = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getSavedInstruments();
            } else {
                arrayList = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getSavedInstruments();
            }
            Instruments instruments = new Instruments();
            DirectPaymentBL.getInstance().setEmiViewSelectedEmiChannelInfo(this.emiChannelInfo);
            this.emiSavedCardViews = new ArrayList<>();
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (str.equalsIgnoreCase(arrayList.get(i3).getIssuingBank()) && arrayList.get(i3).isEmiAvailable()) {
                    SavedCardView savedCardView = (SavedCardView) instruments.getSavedCardView(this.context, arrayList.get(i3), true);
                    this.emiSavedCardViews.add(savedCardView);
                    this.listener.addSavedCard(savedCardView.getView());
                    i2++;
                }
            }
            if (i2 == 0) {
                this.newCardContainerVisibilty.set(0);
                paytWithNewDebitClicked((View) null);
                this.payWithNewDebitCardVisibility.set(8);
                return;
            }
            this.payWithNewDebitCardVisibility.set(0);
            this.newCardContainerVisibilty.set(8);
            this.selectEMIPlanVisibility.set(8);
        }
    }

    public void refreshLayout(String str, String str2, String str3) {
        setAmountIfNeeded();
        setEmiType(str3);
        this.bankOfferText.set(new SpannableString(""));
        this.bankOfferVisibility.set(8);
        this.bankOfferBottomText.set(new SpannableString(""));
        this.bankOfferBottomVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.cashBackText.set("");
        setPaySecurelyText();
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else {
            refreshConvenienceFee(str3);
        }
    }

    public void crossClicked(View view) {
        this.cardNumber = null;
        this.cvvNumber = null;
        this.expiary = null;
        this.cardHash = null;
        this.binResponse = null;
        this.binDialog = null;
        this.isVisaCardEnrolled.set(false);
        this.showVisaOneClick.set(8);
        if (SDKUtils.getConsentFlagType() != SDKConstants.PRE_VISA_SELECTION.intValue()) {
            this.isSingleVisaClickChecked.set(false);
        }
        this.upiPayOptionVisibility.set(8);
        this.upiCheckboxVisibility.set(8);
        this.listener.clearNewCardInfo();
        clearConvenienceFee();
        setAmountIfNeeded();
    }

    public void checkBoxChanged(CompoundButton compoundButton, boolean z) {
        this.saveNewCard = z;
        this.savedCardCheckValue.set(z);
    }

    public void oneClickChanged(CompoundButton compoundButton, boolean z) {
        CardDetails cardDetailObject;
        this.isSingleVisaClickChecked.set(z);
        if (z && (cardDetailObject = getCardDetailObject(this.cardNumber, "")) != null) {
            checkForEnrollment(Boolean.valueOf(SDKUtils.getVisaSDK(this.context).isEnrollmentSuccess(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId())));
        }
    }

    public void hideAllLayouts() {
        this.listener.clearSavedCard();
        this.newCardContainerVisibilty.set(8);
        this.emiVisibility.set(8);
        this.payWithNewDebitCardVisibility.set(8);
        this.proceedButtonVisibility.set(8);
        this.upiCheckboxVisibility.set(8);
        this.upiPayOptionVisibility.set(8);
        this.lowSuccessRateVisibility.set(8);
        this.cardImageVisibility.set(4);
        this.saveCardVisibility.set(8);
        this.cardLayoutVisible = false;
        this.bankCode = "";
        this.radioChecked.set(false);
        this.listener.clearNewCardInfo();
        this.cardHash = null;
        this.amount.set("");
        this.listener.clearEmiDetails();
        clearConvenienceFee();
        hideLoading();
    }

    public void refreshEmiInfo() {
        SaveCardLayoutBinding saveCardLayoutBinding = this.lastRadioChecked;
        if (saveCardLayoutBinding != null && this.emiChannelInfo != null) {
            saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{this.emiChannelInfo.getEmiPerMonth(), this.emiChannelInfo.getOfMonths(), MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.emiChannelInfo.getInterestRate()).doubleValue())}));
        }
    }

    public void debitCardViewClicked(View view) {
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        if (this.cardLayoutVisible) {
            hideAllLayouts();
            this.listener.changeArrowIcon(false);
            DirectPaymentBL.getInstance().setPaytmBaseView((PaytmBaseView) null);
            this.listener.closeKeyboard();
            return;
        }
        this.savedCardCheckValue.set(true);
        this.radioChecked.set(true);
        setAmountIfNeeded();
        this.listener.cardClicked();
        this.listener.changeArrowIcon(true);
        this.cardLayoutVisible = true;
        boolean z = this.isEmiView;
        String str = SDKConstants.CREDIT;
        if (z) {
            this.newCardContainerVisibilty.set(8);
            this.emiVisibility.set(0);
            this.listener.clearEmiDetails();
            if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
                if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, "EMI", SDKConstants.GA_KEY_HYBRID));
                } else {
                    str = "EMI";
                }
            }
            this.radioChecked.set(true);
            this.payWithNewDebitCardVisibility.set(8);
            this.listener.showNewCardAnimation();
            this.proceedButtonVisibility.set(0);
        }
        this.newCardContainerVisibilty.set(0);
        this.emiVisibility.set(8);
        if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
            if (SDKUtility.isHybridCase()) {
                if (!this.isCreditCardLayout) {
                    str = SDKConstants.DEBIT;
                }
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, str, SDKConstants.GA_KEY_HYBRID));
            } else if (!this.isCreditCardLayout) {
                str = SDKConstants.DEBIT;
            }
        }
        this.radioChecked.set(true);
        this.payWithNewDebitCardVisibility.set(8);
        this.listener.showNewCardAnimation();
        this.proceedButtonVisibility.set(0);
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, str, SDKConstants.GA_KEY_NEW));
        this.radioChecked.set(true);
        this.payWithNewDebitCardVisibility.set(8);
        this.listener.showNewCardAnimation();
        this.proceedButtonVisibility.set(0);
    }

    private void changeEMIUi(SaveCardLayoutBinding saveCardLayoutBinding, EmiChannelInfo emiChannelInfo2, int i2, String str) {
        this.prevEmiSelectedPosition = i2;
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        this.emiChannelInfo = emiChannelInfo2;
        if (!TextUtils.isEmpty(str)) {
            saveCardLayoutBinding.tvTotalAmount.setVisibility(0);
            RoboTextView roboTextView = saveCardLayoutBinding.tvTotalAmount;
            roboTextView.setText("Total " + this.context.getString(R.string.nativesdk_amount, new Object[]{str}));
        } else {
            saveCardLayoutBinding.tvTotalAmount.setVisibility(8);
        }
        saveCardLayoutBinding.tvChangePlan.setVisibility(0);
        saveCardLayoutBinding.emiDetailsLayout.setVisibility(0);
        saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{this.emiChannelInfo.getEmiPerMonth(), this.emiChannelInfo.getOfMonths(), decimalFormat.format(Double.valueOf(this.emiChannelInfo.getInterestRate()))}));
    }

    private void setLeftRightMargin(int i2, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(convertDpToPixel(i2), convertDpToPixel(10), convertDpToPixel(0), convertDpToPixel(0));
        linearLayout.setLayoutParams(layoutParams);
    }

    private int convertDpToPixel(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, this.context.getResources().getDisplayMetrics());
    }

    private void makeCvvErrorMessageNormal(SaveCardLayoutBinding saveCardLayoutBinding) {
        saveCardLayoutBinding.txtErrMsg.setVisibility(8);
        saveCardLayoutBinding.txtErrMsg.setText("");
        saveCardLayoutBinding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    private void changeCvvUi(SaveCardLayoutBinding saveCardLayoutBinding, boolean z) {
        if (z) {
            saveCardLayoutBinding.cvvLayout.setBackgroundResource(R.drawable.edit_text_error_bg);
            saveCardLayoutBinding.txtErrMsg.setVisibility(0);
            saveCardLayoutBinding.txtErrMsg.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
            if (saveCardLayoutBinding.twoModeAuthLayout.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) saveCardLayoutBinding.txtErrMsg.getLayoutParams();
                layoutParams.setMargins(convertDpToPixel(70), convertDpToPixel(10), convertDpToPixel(H5Param.WEBVIEW_FONT_SIZE_LARGER), convertDpToPixel(0));
                saveCardLayoutBinding.txtErrMsg.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) saveCardLayoutBinding.txtErrMsg.getLayoutParams();
            layoutParams2.setMargins(convertDpToPixel(30), convertDpToPixel(10), convertDpToPixel(H5Param.WEBVIEW_FONT_SIZE_LARGER), convertDpToPixel(0));
            saveCardLayoutBinding.txtErrMsg.setLayoutParams(layoutParams2);
            return;
        }
        saveCardLayoutBinding.txtErrMsg.setVisibility(8);
        saveCardLayoutBinding.txtErrMsg.setText("");
        saveCardLayoutBinding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    public void paytWithNewDebitClicked(View view) {
        uncheckLastCardSelected();
        this.payWithNewDebitCardVisibility.set(8);
        this.selectEMIPlanVisibility.set(0);
        this.newCardContainerVisibilty.set(0);
        this.radioChecked.set(true);
        this.listener.showNewCardAnimation();
        if (this.emiSavedCardViews != null) {
            for (int i2 = 0; i2 < this.emiSavedCardViews.size(); i2++) {
                this.emiSavedCardViews.get(i2).deselectView();
            }
        }
        DirectPaymentBL.getInstance().setLastSelectedEmiSavedView((SavedCardView) null);
    }

    public void uncheckLastCardSelected() {
        if (this.lastRadioChecked == null) {
            this.lastRadioChecked = DirectPaymentBL.getInstance().getLastRadioChecked();
        }
        SaveCardLayoutBinding saveCardLayoutBinding = this.lastRadioChecked;
        if (saveCardLayoutBinding != null) {
            saveCardLayoutBinding.rbCardNumber.setTypeface((Typeface) null, 0);
            this.lastRadioChecked.rbCardNumber.setChecked(false);
            this.lastRadioChecked.twoModeAuthLayout.clearCheck();
            this.lastRadioChecked.twoModeAuthLayout.setVisibility(8);
            this.lastRadioChecked.cvvLayout.setVisibility(8);
            this.lastRadioChecked.etCvv.setText("");
            this.lastRadioChecked.txtamount.setVisibility(8);
            this.lastRadioChecked.tvPromoMessage.setVisibility(8);
            this.lastRadioChecked.btnProceed.setVisibility(8);
            this.lastRadioChecked.textViewLowSuccess.setVisibility(8);
            this.emiChannelInfo = null;
            if (this.lastRadioChecked.emiDetailsLayout.getVisibility() == 0) {
                this.lastRadioChecked.emiDetailsLayout.setVisibility(8);
                this.lastRadioChecked.tvEmiAvailbale.setVisibility(0);
            }
            this.prevEmiSelectedPosition = -1;
            this.lastRadioChecked = null;
        }
        this.showVisaOneClick.set(8);
        this.isSingleVisaClickChecked.set(false);
    }

    public void hideNewCardInfo() {
        this.payWithNewDebitCardVisibility.set(0);
        this.selectEMIPlanVisibility.set(8);
        this.newCardContainerVisibilty.set(8);
        this.convFeeTextVisibility.set(8);
        this.convFeeText.set(new SpannableString(""));
        this.listener.hideNewCardAnimation();
        this.cardNumber = null;
        this.cvvNumber = null;
        this.expiary = null;
        this.cardHash = null;
        clearConvenienceFee();
        this.listener.clearNewCardInfo();
        if (!this.isEmiView) {
            hideAllLayouts();
        }
    }

    private boolean showRiskConvenienceFeeInfo() {
        RiskConvenienceFeeItem riskConvenienceFeeItem;
        if (!DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getBinPaymentMode()) || (riskConvenienceFeeItem = DirectPaymentBL.getInstance().getRiskConvenienceFeeItem(getBinPaymentMode())) == null) {
            return false;
        }
        this.listener.showRiskConvenienceFeeInfo(riskConvenienceFeeItem.getFeePercent(), riskConvenienceFeeItem.getReason(), getBinPaymentMode());
        return true;
    }

    public void proceedClicked(View view) {
        StringBuilder sb = new StringBuilder("new_dc_added|");
        sb.append(TextUtils.isEmpty(this.bankName) ? this.bankCode : this.bankName);
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_CONSENT_STATUS, String.valueOf(this.upiConsentChecked.get()), sb.toString(), MerchantBL.getMerchantInstance().getMid()));
        proceedClicked(view, true);
    }

    public void proceedClicked(View view, boolean z) {
        String str;
        Context context2;
        String str2;
        String str3;
        String str4 = "Credit Card";
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            if (!this.isCreditCardLayout) {
                str4 = "Debit Card";
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str4, "Internet not available"));
        } else if (SDKUtility.shouldShowValidatePromoError() && (this.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
            setValidatePromoText();
        } else if (this.isZestMoneyTransaction) {
            handleZestMoneyTransaction(view);
        } else if (newCardValidate(view)) {
            if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) || SDKConstants.BAJAJ.equalsIgnoreCase(this.newCardType)) {
                str = "";
            } else {
                String[] split = this.expiary.split("/");
                str = split[0] + "20" + split[1];
            }
            if (TextUtils.isEmpty(this.cvvNumber)) {
                this.cvvNumber = "111";
            }
            if (TextUtils.isEmpty(str)) {
                str = "20";
            }
            String str5 = "|" + this.cardNumber.replace("-", "") + "|" + this.cvvNumber + "|" + str;
            String str6 = null;
            if (this.otpRadioChecked.get()) {
                str6 = "otp";
            }
            if (SDKUtility.isHybridCase()) {
                if (this.isCreditCardLayout) {
                    str3 = str4;
                } else {
                    str3 = "Debit Card";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", str3, SDKConstants.GA_KEY_HYBRID, sb.toString(), ""));
            } else {
                if (this.isCreditCardLayout) {
                    str2 = str4;
                } else {
                    str2 = "Debit Card";
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", str2, SDKConstants.GA_KEY_NEW, sb2.toString(), ""));
            }
            if (!z || !showRiskConvenienceFeeInfo()) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, this.isCreditCardLayout ? SDKConstants.AI_KEY_NEW_CC : SDKConstants.AI_KEY_NEW_DC));
                }
                if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context2 = this.context) == null) {
                    goForTransaction(str6, str5, this.newCardType, view, false, getCardDetailObject(this.cardNumber, str));
                } else {
                    Toast.makeText(this.context, context2.getString(R.string.otp_not_validated), 0).show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public CardDetails getCardDetailObject(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            return null;
        }
        CardDetails cardDetails = new CardDetails();
        cardDetails.setExpiryDate(str2);
        String replace = str.replace("-", "");
        if (replace.length() < 6) {
            return null;
        }
        cardDetails.setFirstSixDigit(replace.substring(0, 6));
        cardDetails.setLastFourDigit(replace.substring(replace.length() - 4));
        return cardDetails;
    }

    public String getBinPaymentMode() {
        if (this.isEmiView) {
            return this.isCreditCardLayout ? PayMethodType.EMI.name() : SDKConstants.EMI_DC;
        }
        BinResponse binResponse2 = this.binResponse;
        if (!(binResponse2 == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null)) {
            String paymentMode = this.binResponse.getBody().getBinDetail().getPaymentMode();
            if (!TextUtils.isEmpty(paymentMode)) {
                return paymentMode;
            }
        }
        return this.isCreditCardLayout ? PayMethodType.CREDIT_CARD.name() : PayMethodType.DEBIT_CARD.name();
    }

    private boolean newCardValidate(final View view) {
        String str;
        if (isCardNumberInvalid() || isExiparyInvalid()) {
            return false;
        }
        if (this.isEmiView && this.emiChannelInfo == null) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getResources().getString(R.string.select_emi_plan), 0).show();
            return false;
        } else if (!TextUtils.isEmpty(this.newCardType) && SDKConstants.BAJAJ.equalsIgnoreCase(this.newCardType)) {
            return true;
        } else {
            if (SDKConstants.MAESTRO.equalsIgnoreCase(this.newCardType) || ((str = this.cvvNumber) != null && str.length() >= 3)) {
                String str2 = this.newCardType;
                if (str2 == null) {
                    fetchBinDetails(this.cardNumber.replace(String.valueOf(this.dash), ""), new SetOnFetchBinResult() {
                        public void onComplete() {
                            DebitCreditCardViewModel.this.listener.showHideProgressDialog(false);
                            DebitCreditCardViewModel.this.proceedClicked(view, true);
                        }

                        public void onError() {
                            DebitCreditCardViewModel.this.listener.showHideProgressDialog(false);
                        }
                    });
                    this.listener.showHideProgressDialog(true);
                    return false;
                } else if (str2.equalsIgnoreCase(SDKConstants.AMEX) && this.cvvNumber.trim().length() != 4) {
                    this.listener.changeCardUi(true, 3);
                    return false;
                } else if (this.newCardType.equalsIgnoreCase(SDKConstants.AMEX) || this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) || this.cvvNumber.trim().length() == 3) {
                    return this.otpRadioChecked.get();
                } else {
                    this.listener.changeCardUi(true, 3);
                    return false;
                }
            } else {
                this.listener.changeCardUi(true, 3);
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.isCreditCardLayout ? "Credit Card" : "Debit Card", "Invalid CVV (New Card)"));
                return false;
            }
        }
    }

    public boolean isExiparyInvalid() {
        if (SDKConstants.MAESTRO.equalsIgnoreCase(this.newCardType) || SDKConstants.BAJAJ.equalsIgnoreCase(this.newCardType)) {
            return false;
        }
        String str = this.expiary;
        if (str != null && str.length() >= 5 && SDKUtility.expiryValidate(this.expiary)) {
            return false;
        }
        this.listener.changeCardUi(true, 2);
        return true;
    }

    public boolean isCardNumberInvalid() {
        String str = this.cardNumber;
        if (str == null || str.length() <= 0) {
            this.listener.changeCardUi(true, 1);
            return true;
        } else if (CardType.detect(this.cardNumber.replace("-", "")) != CardType.UNKNOWN) {
            return false;
        } else {
            if (this.cardSizeShouldBe == 0 || this.cardNumber.replace("-", "").trim().length() == this.cardSizeShouldBe) {
                String replace = this.cardNumber.replace("-", "");
                if (replace.length() >= 14 && SDKUtility.applyLuhnCheck(replace)) {
                    return false;
                }
                this.listener.changeCardUi(true, 1);
                return true;
            }
            this.listener.changeCardUi(true, 1);
            return true;
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
        cvvHelpBottomSheet.show(((AppCompatActivity) this.context).getSupportFragmentManager(), "cvvsheet");
    }

    public void cardNumberBeforeTextChange(Editable editable) {
        ObservableInt observableInt = this.promoCodeVisibility;
        if (observableInt != null) {
            observableInt.set(8);
        }
        if (TextUtils.isEmpty(editable.toString())) {
            this.crossVisibility.set(8);
        } else {
            this.crossVisibility.set(0);
        }
        this.listener.changeCardUi(false, 1);
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
        this.cardNumber = editable.toString();
        String str = this.newCardType;
        if (str != null) {
            if (str.equalsIgnoreCase(SDKConstants.AMEX) && editable.length() == 18) {
                this.cardSizeShouldBe = 15;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                updateVisaSingleClickUI();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CARD_NUMBER);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                } else {
                    fetchCardDetails();
                }
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.DINERS) && editable.length() == 17) {
                this.cardSizeShouldBe = 14;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                updateVisaSingleClickUI();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CARD_NUMBER);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                } else {
                    fetchCardDetails();
                }
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) && editable.length() == 23) {
                this.cardSizeShouldBe = 19;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                updateVisaSingleClickUI();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CARD_NUMBER);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                } else {
                    fetchCardDetails();
                }
            } else if ((this.newCardType.equalsIgnoreCase(SDKConstants.MASTER) || this.newCardType.equalsIgnoreCase(SDKConstants.BAJAJ) || this.newCardType.equalsIgnoreCase(SDKConstants.VISA) || this.newCardType.equalsIgnoreCase(SDKConstants.RUPAY)) && editable.length() == 19) {
                this.cardSizeShouldBe = 16;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                updateVisaSingleClickUI();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CARD_NUMBER);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    getBankOffers();
                } else {
                    fetchCardDetails();
                }
            }
        }
        if (this.cardNumber.length() == 7 || (this.cardNumber.length() > 7 && TextUtils.isEmpty(this.newCardType))) {
            fetchBinDetails(this.cardNumber.replace(String.valueOf(this.dash), ""), (SetOnFetchBinResult) null);
        }
        if (this.cardNumber.length() < 7) {
            this.newCardType = null;
            this.cardImageVisibility.set(8);
            this.lowSuccessRateVisibility.set(8);
            this.upiPayOptionVisibility.set(8);
            this.upiCheckboxVisibility.set(8);
            this.newCardCVVVisibility.set(0);
            this.listener.enableDisableCvv(true);
            this.newCardCVVVisibility.set(0);
            this.cardSizeShouldBe = 0;
            this.listener.updateNewCardImage(-1);
            this.listener.clearRadioGroup();
            this.listener.enableDisableExipary(true);
            this.listener.changeCvvRequiredNotRequired(true);
            this.listener.changeExpiryRequiredNotRequired(true);
            clearConvenienceFee();
            setAmountIfNeeded();
            this.showVisaOneClick.set(8);
            this.isSingleVisaClickChecked.set(false);
            this.isFetchBinProcessing = false;
            this.binResponse = null;
            this.isVisaCardEnrolled.set(false);
        }
    }

    private void fetchBinDetails(final String str, final SetOnFetchBinResult setOnFetchBinResult) {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        final BinResponse binResposne = ApiSession.getInstance().getBinResposne(str);
        if (binResposne != null) {
            new Handler().post(new Runnable() {
                public void run() {
                    DebitCreditCardViewModel.this.onBinResponseApi(str, binResposne, setOnFetchBinResult);
                }
            });
        } else if (SDKUtility.isNetworkAvailable(this.context) && !this.isFetchBinProcessing) {
            this.isFetchBinProcessing = true;
            NativeSDKRepository.getInstance().fetchBinDetails(str, new PaymentMethodDataSource.Callback<BinResponse>() {
                public void onResponse(BinResponse binResponse) {
                    boolean unused = DebitCreditCardViewModel.this.isFetchBinProcessing = false;
                    DebitCreditCardViewModel.this.onBinResponseApi(str, binResponse, setOnFetchBinResult);
                }

                public void onErrorResponse(VolleyError volleyError, BinResponse binResponse) {
                    boolean unused = DebitCreditCardViewModel.this.isFetchBinProcessing = false;
                    setOnFetchBinResult.onError();
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
                            DebitCreditCardViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoErrorMsg());
                            DebitCreditCardViewModel.this.promoCodeVisibility.set(0);
                            DebitCreditCardViewModel.this.listener.changePromoCodeBg(true);
                            return;
                        }
                        DebitCreditCardViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg());
                        DebitCreditCardViewModel.this.promoCodeVisibility.set(0);
                        DebitCreditCardViewModel.this.listener.changePromoCodeBg(false);
                    }
                }

                public void onErrorResponse(VolleyError volleyError, PromoCodeResponse promoCodeResponse) {
                    DebitCreditCardViewModel.this.showServerFailureAlert(volleyError);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, DebitCreditCardViewModel.this.isCreditCardLayout ? "Credit Card" : "Debit Card", promoCodeApiUrl));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onBinResponseApi(String str, BinResponse binResponse2, SetOnFetchBinResult setOnFetchBinResult) {
        String str2;
        if (binResponse2 == null || binResponse2.getBody() == null) {
            this.lowSuccessRateVisibility.set(8);
        } else if (binResponse2.getBody() != null && binResponse2.getBody().getResultInfo() != null && binResponse2.getBody().getResultInfo().getResultStatus() != null && binResponse2.getBody().getResultInfo().getResultStatus().equalsIgnoreCase(AppConstants.FEED_SUB_TYPE)) {
            c cVar = this.binDialog;
            if (cVar == null) {
                this.binDialog = DialogUtility.showDialog(this.context, binResponse2.getBody().getResultInfo().getResultMsg(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        DebitCreditCardViewModel.this.crossClicked((View) null);
                    }
                });
                return;
            } else if (!cVar.isShowing()) {
                this.binDialog.show();
                return;
            } else {
                return;
            }
        } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || binResponse2 == null || binResponse2.getBody() == null || binResponse2.getBody() == null || binResponse2.getBody().getResultInfo() == null || binResponse2.getBody().getResultInfo().getResultStatus() == null || !binResponse2.getBody().getResultInfo().getResultStatus().equalsIgnoreCase("S") || binResponse2.getBody().getIsSubscriptionAvailable()) {
            if (!TextUtils.isEmpty(this.emiType) && !this.emiType.equalsIgnoreCase(binResponse2.getBody().getBinDetail().getPaymentMode())) {
                c cVar2 = this.binDialog;
                if (cVar2 == null) {
                    if (binResponse2.getBody().getBinDetail().getPaymentMode().equalsIgnoreCase(SDKConstants.DEBIT)) {
                        str2 = "Card number you have entered is of Debit Card";
                    } else {
                        str2 = binResponse2.getBody().getBinDetail().getPaymentMode().equalsIgnoreCase(SDKConstants.CREDIT) ? "Card number you have entered is of Credit Card" : "";
                    }
                    this.binDialog = DialogUtility.showDialog(this.context, str2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            DebitCreditCardViewModel.this.crossClicked((View) null);
                        }
                    });
                } else if (!cVar2.isShowing()) {
                    this.binDialog.show();
                }
            }
            ApiSession.getInstance().setBinResponse(str, binResponse2);
            this.binResponse = binResponse2;
            updateVisaSingleClickUI();
            if (binResponse2.getBody().getBinDetail() != null) {
                this.newCardType = binResponse2.getBody().getBinDetail().getChannelCode();
                this.isCreditCardLayout = SDKConstants.CREDIT.equalsIgnoreCase(binResponse2.getBody().getBinDetail().getPaymentMode());
                if (SDKConstants.AMEX.equalsIgnoreCase(this.newCardType)) {
                    this.listener.changeCvvFieldLength(4);
                } else {
                    this.listener.changeCvvFieldLength(3);
                }
            }
            if (binResponse2.getBody().getAuthModes() != null) {
                this.newCardCVVVisibility.set(0);
                this.listener.enableDisableCvv(true);
                this.otpAtmTransaction = binResponse2.getBody().getAuthModes()[0];
                if (binResponse2.getBody().getAuthModes()[0].equalsIgnoreCase("otp")) {
                    this.otpRadioChecked.set(true);
                    this.listener.atmRadioChecked(false);
                } else {
                    this.listener.atmRadioChecked(true);
                }
            }
            if (SDKConstants.MAESTRO.equalsIgnoreCase(this.newCardType)) {
                this.listener.changeCvvRequiredNotRequired(false);
                this.listener.changeExpiryRequiredNotRequired(false);
            } else {
                if (binResponse2.getBody().getAuthModes() != null) {
                    if (binResponse2.getBody().getAuthModes().length > 1) {
                        this.listener.enableDisableCvv(false);
                    } else {
                        this.listener.enableDisableCvv(true);
                    }
                }
                this.listener.enableDisableExipary(true);
            }
            if (binResponse2.getBody().getBinDetail() != null && SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(binResponse2.getBody().getBinDetail().getIssuingBankCode())) {
                this.listener.enableDisableCvv(Boolean.valueOf(binResponse2.getBody().getBinDetail().getCvvRequired()).booleanValue());
            }
            if (binResponse2.getBody().getHasLowSuccessRate() == null || !binResponse2.getBody().getHasLowSuccessRate().getStatus()) {
                this.lowSuccessRateVisibility.set(8);
            } else {
                this.lowSuccessRateVisibility.set(0);
                this.lowSuccessRateText.set(binResponse2.getBody().getHasLowSuccessRate().getMsg());
            }
            int cardImage = (binResponse2.getBody().getBinDetail().getChannelCode() == null || TextUtils.isEmpty(binResponse2.getBody().getBinDetail().getChannelCode())) ? -1 : SDKUtility.getCardImage(binResponse2.getBody().getBinDetail().getChannelCode());
            if (cardImage != -1) {
                this.listener.updateNewCardImage(cardImage);
            } else {
                this.listener.updateNewCardImage(binResponse2.getBody().getBinDetail().getIconUrl());
            }
            this.bankCode = binResponse2.getBody().getBinDetail().getIssuingBankCode();
            this.bankName = binResponse2.getBody().getBinDetail().getIssuingBank();
        } else {
            c cVar3 = this.binDialog;
            if (cVar3 == null) {
                this.binDialog = DialogUtility.showDialog(this.context, binResponse2.getBody().getErrorMessage(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        DebitCreditCardViewModel.this.crossClicked((View) null);
                    }
                });
                return;
            } else if (!cVar3.isShowing()) {
                this.binDialog.show();
                return;
            } else {
                return;
            }
        }
        this.isFetchBinCompleted.postValue(Boolean.TRUE);
        if (setOnFetchBinResult != null) {
            setOnFetchBinResult.onComplete();
        }
    }

    public void updateVisaSingleClickUI() {
        BinResponse binResponse2;
        if (TextUtils.isEmpty(this.cardNumber) || (binResponse2 = this.binResponse) == null || binResponse2.getBody() == null) {
            this.showVisaOneClick.set(8);
            this.isVisaCardEnrolled.set(false);
        } else if (!DirectPaymentBL.getInstance().isVisaOneClickEnabled() || !this.binResponse.getBody().isOneClickSupported() || TextUtils.isEmpty(this.cardNumber) || this.cardSizeShouldBe != this.cardNumber.replace("-", "").length()) {
            removeSingleClickView();
        } else {
            preSelectVisaSingleClick();
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, "");
            CardData cardData = new CardData(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate());
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_ENROLLMENT_OPTION_DISPLAYED, SDKConstants.GA_ENROLLMENT, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
            if (this.enrollmentListener == null) {
                this.enrollmentListener = new EnrollmentListener() {
                    public void isEnrolled(EnrollmentData enrollmentData) {
                        DebitCreditCardViewModel debitCreditCardViewModel = DebitCreditCardViewModel.this;
                        CardDetails access$600 = debitCreditCardViewModel.getCardDetailObject(debitCreditCardViewModel.cardNumber, "");
                        if (access$600 == null || !enrollmentData.isEligible() || !(DebitCreditCardViewModel.this.context instanceof ActivityInteractor) || !((ActivityInteractor) DebitCreditCardViewModel.this.context).isUIEnable() || !enrollmentData.getCardData().getFirstSixDigit().equals(access$600.getFirstSixDigit()) || !enrollmentData.getCardData().getLastFourDigit().equals(access$600.getLastFourDigit())) {
                            DebitCreditCardViewModel.this.removeSingleClickView();
                            return;
                        }
                        DebitCreditCardViewModel.this.checkForEnrollment(Boolean.valueOf(enrollmentData.isEnrolled()));
                        if (DebitCreditCardViewModel.this.showVisaOneClick.get() != 0 && !DebitCreditCardViewModel.this.isVisaCardEnrolled.get()) {
                            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_ENROLLMENT, DebitCreditCardViewModel.this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
                            DebitCreditCardViewModel.this.listener.animateOneClickContainer();
                        }
                        DebitCreditCardViewModel.this.showVisaOneClick.set(0);
                    }
                };
            }
            if (this.helper.isVisaCardEnrolled(this.context, cardData, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC, this.enrollmentListener, this.netPayableAmount.doubleValue(), getBinPaymentMode()) == null) {
                removeSingleClickView();
            }
        }
    }

    /* access modifiers changed from: private */
    public void removeSingleClickView() {
        this.isVisaCardEnrolled.set(false);
        this.showVisaOneClick.set(8);
        this.isSingleVisaClickChecked.set(false);
    }

    /* access modifiers changed from: private */
    public void checkForEnrollment(Boolean bool) {
        try {
            if (TextUtils.isEmpty(this.cardNumber) || this.cardSizeShouldBe != this.cardNumber.replace("-", "").length()) {
                this.isVisaCardEnrolled.set(false);
                this.isVisaCardEnrolled.set(false);
                return;
            }
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, "");
            CardData cardData = new CardData(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate());
            if (!bool.booleanValue() || !isVisaCardEnrolled()) {
                if (this.showVisaOneClick.get() == 0 && this.isSingleVisaClickChecked.get()) {
                    this.helper.createOnClickInfoObject(cardData);
                }
                this.isVisaCardEnrolled.set(false);
                return;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_REPEAT, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
            this.isVisaCardEnrolled.set(true);
            this.helper.createOnClickInfoObject(cardData);
        } catch (Exception unused) {
        }
    }

    public void expiryBeforeTextChange(Editable editable) {
        this.listener.changeCardUi(false, 2);
        if (editable.length() > 0 && editable.length() == 3 && this.slash == editable.charAt(editable.length() - 1)) {
            editable.delete(editable.length() - 1, editable.length());
        }
        if (editable.length() > 0 && editable.length() == 3 && Character.isDigit(editable.charAt(editable.length() - 1))) {
            editable.insert(editable.length() - 1, String.valueOf(this.slash));
        }
        if (editable.length() == 5) {
            if (this.newCardCVVVisibility.get() == 0) {
                this.listener.cvvEditTextFocus();
            } else {
                this.listener.hideCvvKeyBoard();
            }
            updateVisaSingleClickUI();
            sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_EXPIRY);
        }
        this.expiary = editable.toString();
    }

    public void cvvBeforeTextChange(Editable editable) {
        this.listener.changeCardUi(false, 3);
        String str = this.newCardType;
        if (str != null) {
            if (str.equalsIgnoreCase(SDKConstants.AMEX) && editable.toString().trim().length() == 4) {
                this.listener.hideCvvKeyBoard();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CVV);
            } else if (!this.newCardType.equalsIgnoreCase(SDKConstants.AMEX) && editable.toString().trim().length() == 3) {
                this.listener.hideCvvKeyBoard();
                sendNewCardNumberEventAppInvoke(SDKConstants.AI_KEY_CVV);
            }
        }
        this.cvvNumber = editable.toString();
    }

    public void onErrorResponse(VolleyError volleyError) {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, this.isCreditCardLayout ? "Credit Card" : "Debit Card", "url"));
        showServerFailureAlert(volleyError);
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
            if (Build.VERSION.SDK_INT >= 19) {
                str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, StandardCharsets.UTF_8), this.context);
            } else {
                str = this.context.getResources().getString(R.string.server_communication_failed);
            }
        } catch (Exception unused) {
            str = this.context.getResources().getString(R.string.server_communication_failed);
        }
        Context context2 = this.context;
        DialogUtility.showDialog(context2, context2.getResources().getString(R.string.unknown_error), str, (DialogInterface.OnClickListener) null);
    }

    private void goForTransaction(String str, String str2, String str3, View view, boolean z, CardDetails cardDetails) {
        String str4;
        BinResponse binResponse2;
        String str5 = str;
        String str6 = str3;
        this.cashBackTextVisibility.set(8);
        String binPaymentMode = getBinPaymentMode();
        EmiChannelInfo emiChannelInfo2 = this.emiChannelInfo;
        if (emiChannelInfo2 != null) {
            str4 = emiChannelInfo2.getPlanId();
            binPaymentMode = "EMI";
        } else {
            str4 = null;
        }
        String str7 = "1";
        if (!DirectPaymentBL.getInstance().isAddMoney() ? !this.saveNewCard : this.showVisaOneClick.get() != 0 || this.isVisaCardEnrolled.get() ? !this.saveNewCard : !this.isSingleVisaClickChecked.get()) {
            str7 = "0";
        }
        if (this.upiCheckboxVisibility.get() == 0) {
            makeUpiConsentApiRequest(this.bankCode, this.upiConsentChecked.get());
        }
        String str8 = str2;
        HashMap<String, String> cardsTranscationParam = PayUtility.getCardsTranscationParam(str, binPaymentMode, str2, str7, str4);
        if (!(!this.isEmiView || (binResponse2 = this.binResponse) == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null || TextUtils.isEmpty(this.binResponse.getBody().getBinDetail().getPaymentMode()))) {
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                cardsTranscationParam.put("emiType", this.binResponse.getBody().getBinDetail().getPaymentMode());
            } else {
                cardsTranscationParam.put(PayUtility.EMI_TYPE, this.binResponse.getBody().getBinDetail().getPaymentMode());
            }
            cardsTranscationParam.put("channelCode", this.binResponse.getBody().getBinDetail().getIssuingBankCode());
        }
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(this.bankCode)) {
            paytmAssistParams.setBankCode(this.bankCode);
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        String str9 = Constants.EASYPAY_PAYTYPE_CREDIT_CARD;
        if (!isEmpty && str.equalsIgnoreCase("otp")) {
            paytmAssistParams.setPayType(this.isCreditCardLayout ? str9 : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
        }
        if (!TextUtils.isEmpty(str3)) {
            paytmAssistParams.setCardType(str6);
        }
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), cardsTranscationParam);
        if (!TextUtils.isEmpty(this.bankCode)) {
            paymentInstrument.setBankCode(this.bankCode);
        }
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("otp")) {
            if (!this.isCreditCardLayout) {
                str9 = Constants.EASYPAY_PAYTYPE_DEBIT_CARD;
            }
            paymentInstrument.setPayType(str9);
        }
        if (!TextUtils.isEmpty(str3)) {
            paymentInstrument.setCardType(str6);
        }
        boolean z2 = this.isCreditCardLayout;
        String str10 = SDKConstants.GA_NEW_CC;
        paymentInstrument.setGaVisaPaymentMode(z2 ? str10 : SDKConstants.GA_NEW_DC);
        if (z) {
            paymentInstrument.setGaPaymentMethod(this.isCreditCardLayout ? "Credit Card" : "Debit Card");
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        } else {
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_COD);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        }
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getHybridPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
        } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null && SDKUtility.isOfferValid(this.paymentModes.getPaymentOffer())) {
            transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
        }
        if (DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getBinPaymentMode()) || (SDKUtility.parseDouble(this.aggregatePgConvenienceFee) > 0.0d && DirectPaymentBL.getInstance().isAddMoney())) {
            String riskConvenienceFeeAmount = DirectPaymentBL.getInstance().getRiskConvenienceFeeAmount(getBinPaymentMode());
            transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
            transactionProcessor.setRiskConvenienveFee(riskConvenienceFeeAmount);
        }
        transactionProcessor.setPaymentIntent(getPaymentIntent());
        transactionProcessor.setSavedCardTransaction(false);
        if ((!DirectPaymentBL.getInstance().isVisaOneClickEnabled() || this.showVisaOneClick.get() != 0 || !this.isSingleVisaClickChecked.get()) && !this.isVisaCardEnrolled.get()) {
            transactionProcessor.startTransaction(view);
            return;
        }
        transactionProcessor.setVisaSingleClickEnabled(true);
        transactionProcessor.setCardDetails(new CardData(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), cardDetails.getExpiryDate()));
        if (!this.isVisaCardEnrolled.get() || TextUtils.isEmpty(str3)) {
            if (!this.isCreditCardLayout) {
                str10 = SDKConstants.GA_NEW_DC;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_ENROLLMENT, str10));
            this.helper.proceedForTranscation(this.context, transactionProcessor, paymentInstrument, view, str3);
            return;
        }
        if (!this.isCreditCardLayout) {
            str10 = SDKConstants.GA_NEW_DC;
        }
        SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_REPEAT, str10));
        transactionProcessor.isEnrolled(true);
        this.helper.proceedForTranscation(this.context, transactionProcessor, paymentInstrument, (View) null, str3);
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

    private boolean isVisaCardEnrolled() {
        BinResponse binResponse2 = this.binResponse;
        return (binResponse2 == null || binResponse2.getBody() == null || !this.binResponse.getBody().isOneClickSupported()) ? false : true;
    }

    public void deselectView() {
        this.prevEmiSelectedPosition = -1;
    }

    public void fetchCardDetails() {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        } else if (!TextUtils.isEmpty(this.cardNumber) && ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            NativeSDKRepository.getInstance().fetchCardDetails(APIReqtGenerator.getFetchCardDetailsRequestObject(true, this.cardNumber), (PaymentMethodDataSource.Callback<FetchCardDetailsResponse>) new PaymentMethodDataSource.Callback<FetchCardDetailsResponse>() {
                public void onResponse(FetchCardDetailsResponse fetchCardDetailsResponse) {
                    List list;
                    if (fetchCardDetailsResponse == null || fetchCardDetailsResponse.getBody() == null) {
                        DebitCreditCardViewModel.this.showErrorDialog((String) null);
                        DebitCreditCardViewModel.this.listener.disableProceedButton();
                        return;
                    }
                    String unused = DebitCreditCardViewModel.this.cardHash = fetchCardDetailsResponse.getBody().getCardHash();
                    if (!(fetchCardDetailsResponse.getBody().getCardDetails() == null || fetchCardDetailsResponse.getBody().getCardDetails().getBinDetail() == null)) {
                        BinDetail binDetail = fetchCardDetailsResponse.getBody().getCardDetails().getBinDetail();
                        if (!TextUtils.isEmpty(binDetail.getChannelName()) && !PaytmSDK.getmEnabledPayModeMap().isEmpty() && (list = PaytmSDK.getmEnabledPayModeMap().get("CCDC")) != null && !list.isEmpty() && list.contains(binDetail.getChannelName())) {
                            DebitCreditCardViewModel debitCreditCardViewModel = DebitCreditCardViewModel.this;
                            debitCreditCardViewModel.showErrorDialog(debitCreditCardViewModel.context.getString(R.string.invalid_card));
                        }
                    }
                    if (!TextUtils.isEmpty(DebitCreditCardViewModel.this.cardHash)) {
                        DebitCreditCardViewModel.this.buildPaymentIntent();
                        DebitCreditCardViewModel.this.fetchConvenienceFee();
                        return;
                    }
                    DebitCreditCardViewModel debitCreditCardViewModel2 = DebitCreditCardViewModel.this;
                    debitCreditCardViewModel2.showErrorDialog(debitCreditCardViewModel2.context.getString(R.string.card_details_error));
                }

                public void onErrorResponse(VolleyError volleyError, FetchCardDetailsResponse fetchCardDetailsResponse) {
                    DebitCreditCardViewModel.this.showErrorDialog(volleyError != null ? volleyError.getMessage() : "");
                    DebitCreditCardViewModel.this.listener.disableProceedButton();
                }
            });
        }
    }

    /* access modifiers changed from: private */
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
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument);
        transactionProcessor.setPaymentIntent(getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }

    public boolean isZestMoneyTransaction() {
        return this.isZestMoneyTransaction;
    }

    public void setZestMoneyTransaction(boolean z) {
        this.isZestMoneyTransaction = z;
    }

    public void clearOffer() {
        PaymentModes paymentModes2 = this.paymentModes;
        if (paymentModes2 != null) {
            paymentModes2.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        }
    }

    private void getBankOffers() {
        String str;
        if (DirectPaymentBL.getInstance().isBankOffersAvailable() && !TextUtils.isEmpty(this.cardNumber) && !TextUtils.isEmpty(this.bankCode)) {
            PaymentModes paymentModes2 = this.paymentModes;
            if (paymentModes2 != null) {
                paymentModes2.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
                this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            }
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            if (this.isEmiView) {
                str = this.isCreditCardLayout ? "EMI" : SDKConstants.EMI_DC;
            } else {
                str = this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT;
            }
            paymentOption.setPayMethod(str);
            paymentOption.setBankCode(this.bankCode);
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
                    DebitCreditCardViewModel.this.listener.enableProceedButton();
                    DebitCreditCardViewModel.this.hideLoading();
                    if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof DebitCreditCreditCardsView) {
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                            DebitCreditCardViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        } else {
                            if (this.isHybridRequest) {
                                if (DebitCreditCardViewModel.this.paymentModes != null) {
                                    DebitCreditCardViewModel.this.paymentModes.setHybridPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                                }
                            } else if (DebitCreditCardViewModel.this.paymentModes != null) {
                                DebitCreditCardViewModel.this.paymentModes.setPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            }
                            DebitCreditCardViewModel.this.showBankOffers();
                            SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                        }
                        DebitCreditCardViewModel.this.fetchCardDetails();
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    DebitCreditCardViewModel.this.listener.enableProceedButton();
                    DebitCreditCardViewModel.this.bankOfferVisibility.set(8);
                    DebitCreditCardViewModel.this.bankOfferBottomVisibility.set(8);
                    DebitCreditCardViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                    DebitCreditCardViewModel.this.hideLoading();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showBankOffers() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (isOfferValid()) {
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
            if (paymentOffer.getTotalCashbackAmount() != null) {
                if (SDKUtility.isBankOfferBottom().booleanValue()) {
                    this.bankOfferVisibility.set(8);
                    this.bankOfferBottomVisibility.set(0);
                    i iVar = this.bankOfferBottomText;
                    Context context2 = this.context;
                    iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.cashback_applied_successfully, new Object[]{paymentOffer.getTotalCashbackAmount()}), paymentOffer));
                } else {
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar2 = this.bankOfferText;
                    Context context3 = this.context;
                    iVar2.set(SDKUtility.getBankOfferText(context3, context3.getString(R.string.cashback_applied_successfully, new Object[]{paymentOffer.getTotalCashbackAmount()}), paymentOffer));
                }
                this.cashBackTextVisibility.set(0);
                this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalCashbackAmount()))}));
                this.applyPromoFailed = false;
            } else if (paymentOffer.getTotalInstantDiscount() != null) {
                if (SDKUtility.isBankOfferBottom().booleanValue()) {
                    this.bankOfferVisibility.set(8);
                    this.bankOfferBottomVisibility.set(0);
                    i iVar3 = this.bankOfferBottomText;
                    Context context4 = this.context;
                    iVar3.set(SDKUtility.getBankOfferText(context4, context4.getString(R.string.instant_discount_applied_successfully, new Object[]{paymentOffer.getTotalInstantDiscount()}), paymentOffer));
                } else {
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar4 = this.bankOfferText;
                    Context context5 = this.context;
                    iVar4.set(SDKUtility.getBankOfferText(context5, context5.getString(R.string.instant_discount_applied_successfully, new Object[]{paymentOffer.getTotalInstantDiscount()}), paymentOffer));
                }
                this.cashBackTextVisibility.set(8);
                setPaySecurelyText();
                this.applyPromoFailed = false;
            } else {
                if (getPaymentIntent() != null && getPaymentIntent().size() > 0) {
                    showOffersTextFromCart(getPaymentIntent().get(0));
                }
                setValidatePromoText();
            }
        } else {
            if (SDKUtility.shouldShowValidatePromoError()) {
                setValidatePromoText();
            }
            if (getPaymentIntent() != null && getPaymentIntent().size() > 0) {
                showOffersTextFromCart(getPaymentIntent().get(0));
            }
            this.cashBackTextVisibility.set(8);
            setPaySecurelyText();
            this.cashBackText.set("");
        }
    }

    private void showOffersTextFromCart(PaymentIntent paymentIntent) {
        if (!TextUtils.isEmpty(paymentIntent.getOfferMsg()) && !isOfferValid()) {
            SDKUtility.setBankOfferTextFromVerify(this.bankOfferBottomVisibility, this.bankOfferVisibility, this.bankOfferBottomText, this.bankOfferText, paymentIntent.getOfferMsg());
        }
    }

    private boolean isOfferValid() {
        return getPaymentOffer() != null && SDKUtility.isOfferValid(getPaymentOffer()) && getPaymentOffer().getOfferBreakup() != null && getPaymentOffer().getOfferBreakup().size() > 0;
    }

    public void setPaymentIntents(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntents = new ArrayList<>();
        this.paymentIntents.addAll(arrayList);
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
                DebitCreditCardViewModel.this.hideLoading();
                if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    DebitCreditCardViewModel.this.listener.disableProceedButton();
                    DebitCreditCardViewModel.this.convFeeTextVisibility.set(8);
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, DebitCreditCardViewModel.this.context);
                    return;
                }
                DebitCreditCardViewModel.this.handleConvFeeResponse(verifyResponseData.getConvFeeResponse(), verifyResponseData.getVerifyModel());
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                DebitCreditCardViewModel.this.hideLoading();
                DebitCreditCardViewModel.this.convFeeTextVisibility.set(8);
                DebitCreditCardViewModel.this.listener.disableProceedButton();
                SDKUtility.handleVerticalError(apiResponseError, DebitCreditCardViewModel.this.context);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleConvFeeResponse(PaytmSDKRequestClient.ConvFeeResponse convFeeResponse, Object obj) {
        this.aggregatePgConvenienceFee = convFeeResponse.getAggregatePGConvFee();
        this.feePercent = convFeeResponse.getFeePercent();
        this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(convFeeResponse, getPaymentIntent(), obj);
        this.listener.enableProceedButton();
        configureConvFeeView();
    }

    public void configureConvFeeView() {
        Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            if (next.getMode().equalsIgnoreCase(getBinPaymentMode())) {
                next.setCardHash(this.cardHash);
                this.instrumentConvenienceFee = next.getConvFee();
                setPaySecurelyText();
                setAmountIfNeeded();
                if (SDKUtility.parseDouble(this.aggregatePgConvenienceFee) > 0.0d) {
                    this.convFeeTextVisibility.set(0);
                    SDKUtility.setConvenienceFeeText(this.convFeeText, this.aggregatePgConvenienceFee, next.getConvFeeText(), this.context, next.getSpannableConvFeeText());
                } else {
                    this.convFeeTextVisibility.set(8);
                }
                if (DirectPaymentBL.getInstance().isAddMoney() && this.instrumentConvenienceFee > 0.0d && this.isCreditCardLayout) {
                    this.cashBackTextVisibility.set(0);
                    i<String> iVar = this.cashBackText;
                    Context context2 = this.context;
                    int i2 = R.string.add_money_conv_fee_prceed;
                    iVar.set(context2.getString(i2, new Object[]{this.aggregatePgConvenienceFee}));
                    this.convFeeTextGravity.set(8388611);
                } else if (getPaymentOffer() != null && !DirectPaymentBL.getInstance().isAddMoney() && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
                    this.cashBackTextVisibility.set(0);
                    String doubleFormaAmount = SDKUtility.getDoubleFormaAmount((next.getTxnAmount() + next.getConvFee()) - SDKUtility.parseDouble(getPaymentOffer().getTotalCashbackAmount()));
                    this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{doubleFormaAmount}));
                }
                if (DirectPaymentBL.getInstance().isAddMoney() && !TextUtils.isEmpty(next.getOfferMsg())) {
                    SDKUtility.setBankOfferTextFromVerify(this.bankOfferBottomVisibility, this.bankOfferVisibility, this.bankOfferBottomText, this.bankOfferText, next.getOfferMsg());
                    return;
                }
                return;
            }
        }
    }

    private void hideOffer() {
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.bankOfferBottomVisibility.set(8);
        setPaySecurelyText();
    }

    public double getEmiConvenienceFee() {
        return this.instrumentConvenienceFee;
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setAggregatePgConvFee(String str) {
        this.aggregatePgConvenienceFee = str;
    }

    public void showPaymentProgressbar(View view) {
        super.showPaymentProgressbar(view);
        this.cashBackTextVisibility.set(0);
    }

    public String getCardNumber() {
        try {
            return this.cardNumber.replace("-", "");
        } catch (Exception unused) {
            return "";
        }
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

    private void fetchConvenienceFeeForEmi() {
        if (!TextUtils.isEmpty(this.emiType)) {
            CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
            cardPaymentIntentData.setCardHash(this.cardHash);
            this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), (ArrayList<String>) null, (ArrayList<String>) null, cardPaymentIntentData, this.emiType, Double.valueOf(getTotalInstantDiscount()));
            if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                getConvenienceFee();
            }
        }
    }

    /* access modifiers changed from: private */
    public void fetchConvenienceFee() {
        buildPaymentIntent();
        if (this.isEmiView) {
            fetchConvenienceFeeForEmi();
        } else if (this.cardHash != null && ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            getConvenienceFee();
        }
    }

    /* access modifiers changed from: private */
    public void buildPaymentIntent() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BinResponse binResponse2 = this.binResponse;
        if (!(binResponse2 == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null)) {
            arrayList.add(this.binResponse.getBody().getBinDetail().getIssuingBankCode());
            arrayList2.add(this.binResponse.getBody().getBinDetail().getChannelCode());
        }
        String binPaymentMode = getBinPaymentMode();
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.cardHash);
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(binPaymentMode, arrayList2, arrayList, cardPaymentIntentData, (String) null, Double.valueOf(getTotalInstantDiscount()));
    }

    private void setAmountIfNeeded() {
        this.amount.set("");
        setPaySecurelyText();
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
        this.netPayableAmount = Double.valueOf(SDKUtility.getNetPaySecurelyAmount(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
        updateVisaSingleClickUI();
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
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
        this.listener.startCheckingOfferAnimation();
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.listener.stopCheckingOfferAnimation();
    }

    public String getInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        return (paymentOffer == null || TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount())) ? "" : paymentOffer.getTotalInstantDiscount();
    }

    private void clearConvenienceFee() {
        if (!this.isEmiView) {
            this.paymentIntents = null;
            this.convFeeTextVisibility.set(8);
            this.convFeeText.set(new SpannableString(""));
            this.instrumentConvenienceFee = 0.0d;
            this.aggregatePgConvenienceFee = "";
            this.feePercent = "";
        }
    }

    private ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public void refreshConvenienceFee(String str) {
        setEmiType(str);
        if (this.isEmiView) {
            fetchConvenienceFeeForEmi();
        } else {
            fetchConvenienceFee();
        }
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }

    public boolean isCreditCardLayout() {
        return this.isCreditCardLayout;
    }

    private void sendNewCardNumberEventAppInvoke(String str) {
        if (!SDKUtility.isAppInvokeFlow()) {
            return;
        }
        if (this.isCreditCardLayout) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_CREDIT_CARD_NUMBER_ENTERED, str));
        } else {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_DEBIT_CARD_NUMBER_ENTERED, str));
        }
    }
}
