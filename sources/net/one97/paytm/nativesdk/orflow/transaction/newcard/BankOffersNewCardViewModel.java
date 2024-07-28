package net.one97.paytm.nativesdk.orflow.transaction.newcard;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.ApiSession;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentData;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentListener;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard;
import net.one97.paytm.nativesdk.cvvHelp.view.CvvHelpBottomSheet;
import net.one97.paytm.nativesdk.databinding.SaveCardLayoutBinding;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.DebitCreditCardListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.CardType;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class BankOffersNewCardViewModel extends BaseViewModel implements Response.ErrorListener {
    public static final String DIRECT = "direct";
    public static final String REDIRECT = "redirect";
    private static final String otp = "otp";
    private final String AMEX = "AMEX";
    public ObservableBoolean addMoneySaveCardVisibility;
    public i<String> amount = new i<>("");
    private String bankCode = "";
    public i<SpannableString> bankOfferText = new i<>(new SpannableString(""));
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    private c binDialog = null;
    private BinResponse binResponse;
    public ObservableInt cardImageVisibility;
    private boolean cardLayoutVisible;
    /* access modifiers changed from: private */
    public String cardNumber;
    private int cardSizeShouldBe = 0;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public ObservableInt crossVisibility;
    private String cvvNumber = "";
    private char dash = '-';
    public i<String> debitCardOrCreditCard;
    private EmiChannelInfo emiChannelInfo;
    private ArrayList<PaymentIntent> emiPaymentIntent;
    private String emiPlanData;
    public ObservableInt emiVisibility = new ObservableInt(8);
    private EnrollmentListener enrollmentListener;
    private String expiary;
    private String fourDots = " •••• ";
    private VisaEnrollmentHelper helper;
    /* access modifiers changed from: private */
    public boolean isCreditCardLayout;
    private boolean isEmiEnabled = false;
    private boolean isEmiView;
    public ObservableBoolean isSingleVisaClickChecked = new ObservableBoolean(false);
    public ObservableBoolean isVisaCardEnrolled_ = new ObservableBoolean(false);
    private SaveCardLayoutBinding lastRadioChecked;
    /* access modifiers changed from: private */
    public DebitCreditCardListener listener;
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
    private ArrayList<PaymentIntent> paymentIntent;
    private PaymentModes paymentModes;
    private int prevEmiSelectedPosition = -1;
    private ObservableInt proceedButtonVisibility;
    public i<String> promoCodeText;
    public ObservableInt promoCodeVisibility;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    private ObservableInt saveCardVisibility;
    private boolean saveNewCard = true;
    public ObservableBoolean savedCardCheckValue = new ObservableBoolean(true);
    public ObservableInt showVisaOneClick = new ObservableInt(8);
    private char slash = '/';

    public interface SetOnFetchBinResult {
        void onComplete();

        void onError();
    }

    private void getBankOffers() {
    }

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void setEmiChannelInfo(EmiChannelInfo emiChannelInfo2) {
        this.emiChannelInfo = emiChannelInfo2;
    }

    public EmiChannelInfo getEmiChannelInfo() {
        return this.emiChannelInfo;
    }

    public BankOffersNewCardViewModel(Context context2, boolean z, boolean z2, DebitCreditCardListener debitCreditCardListener) {
        super(context2, debitCreditCardListener);
        this.context = context2;
        this.listener = debitCreditCardListener;
        this.isCreditCardLayout = z;
        this.isEmiView = z2;
        this.helper = new VisaEnrollmentHelper();
        this.otpRadioChecked = new ObservableBoolean(false);
        this.listener.clearRadioGroup();
        this.newCardCVVVisibility = new ObservableInt(0);
        this.crossVisibility = new ObservableInt(8);
        this.promoCodeVisibility = new ObservableInt(8);
        this.newCardContainerVisibilty = new ObservableInt(8);
        this.payWithNewDebitCardVisibility = new ObservableInt(8);
        this.proceedButtonVisibility = new ObservableInt(8);
        this.lowSuccessRateVisibility = new ObservableInt(8);
        this.addMoneySaveCardVisibility = new ObservableBoolean(false);
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
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.context));
        this.netPayableAmount = Double.valueOf(SDKUtility.getDiffAmount());
        hideOffer();
    }

    public void setPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntent = arrayList;
    }

    public void setEmiPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.emiPaymentIntent = arrayList;
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        return this.paymentIntent;
    }

    public ArrayList<PaymentIntent> getEmiPaymentIntent() {
        return this.emiPaymentIntent;
    }

    public void refreshLayout() {
        setAmountIfNeeded();
        this.bankOfferText.set(new SpannableString(""));
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.cashBackText.set("");
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.context));
        getBankOffers();
    }

    public void setEmiPlanData(String str) {
        this.emiPlanData = str;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void crossClicked(View view) {
        this.cardNumber = null;
        this.cvvNumber = null;
        this.expiary = null;
        this.listener.clearNewCardInfo();
        this.showVisaOneClick.set(8);
        this.isVisaCardEnrolled_.set(false);
        if (SDKUtils.getConsentFlagType() != SDKConstants.PRE_VISA_SELECTION.intValue()) {
            this.isSingleVisaClickChecked.set(false);
        }
    }

    public void checkBoxChanged(CompoundButton compoundButton, boolean z) {
        this.saveNewCard = z;
        this.savedCardCheckValue.set(z);
    }

    public void hideAllLayouts() {
        this.listener.clearSavedCard();
        this.newCardContainerVisibilty.set(8);
        this.emiVisibility.set(8);
        this.payWithNewDebitCardVisibility.set(8);
        this.proceedButtonVisibility.set(8);
        this.lowSuccessRateVisibility.set(8);
        this.cardImageVisibility.set(4);
        this.saveCardVisibility.set(8);
        this.cardLayoutVisible = false;
        this.bankCode = null;
        this.radioChecked.set(false);
        this.listener.clearNewCardInfo();
        this.amount.set("");
        this.listener.clearEmiDetails();
    }

    public void oneClickChanged(CompoundButton compoundButton, boolean z) {
        this.isSingleVisaClickChecked.set(z);
        if (z) {
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, "");
            checkForEnrollment(Boolean.valueOf(SDKUtils.getVisaSDK(this.context).isEnrollmentSuccess(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId())));
        }
    }

    public void refreshEmiInfo() {
        SaveCardLayoutBinding saveCardLayoutBinding = this.lastRadioChecked;
        if (saveCardLayoutBinding != null && this.emiChannelInfo != null) {
            saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.emiChannelInfo.getEmiPerMonth()).doubleValue()), this.emiChannelInfo.getOfMonths(), MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(this.emiChannelInfo.getInterestRate()).doubleValue())}));
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

    private void preSelectVisaSingleClick() {
        int consentFlagType = SDKUtils.getConsentFlagType();
        if (this.showVisaOneClick.get() != 0 && consentFlagType == SDKConstants.PRE_VISA_SELECTION.intValue()) {
            this.isSingleVisaClickChecked.set(true);
        }
    }

    private void setAmountIfNeeded() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.amount.set("");
        } else {
            this.amount.set(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{SDKUtility.priceWithoutDecimal(DirectPaymentBL.getInstance().getDifferentialAmount())}));
        }
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.context));
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
        saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{decimalFormat.format(Double.valueOf(this.emiChannelInfo.getEmiPerMonth())), this.emiChannelInfo.getOfMonths(), decimalFormat.format(Double.valueOf(this.emiChannelInfo.getInterestRate()))}));
    }

    private void setLeftRightMargin(int i2, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(convertDpToPixel(i2), convertDpToPixel(10), convertDpToPixel(0), convertDpToPixel(0));
        linearLayout.setLayoutParams(layoutParams);
    }

    private int convertDpToPixel(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, this.context.getResources().getDisplayMetrics());
    }

    public void refreshSavedCards() {
        if (this.lastRadioChecked == null) {
            return;
        }
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.lastRadioChecked.txtamount.setVisibility(8);
            return;
        }
        this.lastRadioChecked.txtamount.setVisibility(0);
        this.lastRadioChecked.txtamount.setText(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{SDKUtility.priceWithoutDecimal(MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(DirectPaymentBL.getInstance().getDifferentialAmount()).doubleValue()))}));
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
        if (this.newCardContainerVisibilty.get() != 0) {
            uncheckLastCardSelected();
            this.newCardContainerVisibilty.set(0);
            this.radioChecked.set(true);
            this.listener.showNewCardAnimation();
        }
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
            this.emiPlanData = null;
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

    private void hideNewCardInfo() {
        if (this.newCardContainerVisibilty.get() != 8) {
            this.newCardContainerVisibilty.set(8);
            this.listener.hideNewCardAnimation();
            this.cardNumber = null;
            this.cvvNumber = null;
            this.expiary = null;
            this.listener.clearNewCardInfo();
            if (!this.isEmiView) {
                hideAllLayouts();
            }
        }
    }

    public void proceedClicked(View view) {
        String str;
        String str2;
        String str3;
        String str4 = "Credit Card";
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getResources().getString(R.string.internet_not_available), 0).show();
            if (!this.isCreditCardLayout) {
                str4 = "Debit Card";
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str4, "Internet not available"));
        } else if (newCardValidate(view)) {
            if (!this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                String[] split = this.expiary.split("/");
                str = split[0] + "20" + split[1];
            } else {
                str = "";
            }
            String str5 = "|" + this.cardNumber.replace("-", "") + "|" + this.cvvNumber + "|" + str;
            String str6 = null;
            if (this.otpRadioChecked.get()) {
                str6 = "otp";
            }
            String str7 = str6;
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
            goForTransaction(str7, str5, this.newCardType, view, false);
        }
    }

    private boolean newCardValidate(final View view) {
        String str;
        if (TextUtils.isEmpty(this.cardNumber) || isExiparyInvalid()) {
            return false;
        }
        if (SDKConstants.MAESTRO.equalsIgnoreCase(this.newCardType) || ((str = this.cvvNumber) != null && str.length() >= 3)) {
            String str2 = this.newCardType;
            if (str2 == null) {
                fetchBinDetails(this.cardNumber.replace(String.valueOf(this.dash), ""), new SetOnFetchBinResult() {
                    public void onComplete() {
                        BankOffersNewCardViewModel.this.listener.showHideProgressDialog(false);
                        BankOffersNewCardViewModel.this.proceedClicked(view);
                    }

                    public void onError() {
                        BankOffersNewCardViewModel.this.listener.showHideProgressDialog(false);
                    }
                });
                this.listener.showHideProgressDialog(true);
                return false;
            } else if (str2.equalsIgnoreCase(SDKConstants.AMEX) && this.cvvNumber.trim().length() != 4) {
                this.listener.changeCardUi(true, 3);
                return false;
            } else if (!this.newCardType.equalsIgnoreCase(SDKConstants.AMEX) && !this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) && this.cvvNumber.trim().length() != 3) {
                this.listener.changeCardUi(true, 3);
                return false;
            } else if (!this.otpRadioChecked.get()) {
                return false;
            } else {
                if (!this.isEmiView || this.emiChannelInfo != null) {
                    return true;
                }
                Context context2 = this.context;
                Toast.makeText(context2, context2.getResources().getString(R.string.select_emi_plan), 0).show();
                return false;
            }
        } else {
            this.listener.changeCardUi(true, 3);
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.isCreditCardLayout ? "Credit Card" : "Debit Card", "Invalid CVV (New Card)"));
            return false;
        }
    }

    public boolean isExiparyInvalid() {
        if (SDKConstants.MAESTRO.equalsIgnoreCase(this.newCardType)) {
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
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("cvvsheet");
        cvvHelpBottomSheet.show(a2, (String) null);
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
        this.cardNumber = editable.toString();
        String str = this.newCardType;
        if (str != null) {
            if (str.equalsIgnoreCase(SDKConstants.AMEX) && editable.length() == 18) {
                this.cardSizeShouldBe = 15;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                getBankOffers();
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.DINERS) && editable.length() == 17) {
                this.cardSizeShouldBe = 14;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                getBankOffers();
            } else if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO) && editable.length() == 23) {
                this.cardSizeShouldBe = 19;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                getBankOffers();
            } else if ((this.newCardType.equalsIgnoreCase(SDKConstants.MASTER) || this.newCardType.equalsIgnoreCase(SDKConstants.VISA) || this.newCardType.equalsIgnoreCase(SDKConstants.RUPAY)) && editable.length() == 19) {
                this.cardSizeShouldBe = 16;
                this.listener.monthEditTextFocus();
                hitPromoCodeApi(this.cardNumber, this.isCreditCardLayout);
                getBankOffers();
            }
        }
        if (this.cardNumber.length() == 7 || (this.cardNumber.length() > 7 && TextUtils.isEmpty(this.newCardType))) {
            fetchBinDetails(this.cardNumber.replace(String.valueOf(this.dash), ""), (SetOnFetchBinResult) null);
        }
        if (this.cardNumber.length() < 7) {
            this.newCardType = null;
            this.cardImageVisibility.set(8);
            this.lowSuccessRateVisibility.set(8);
            this.newCardCVVVisibility.set(0);
            this.listener.enableDisableCvv(true);
            this.newCardCVVVisibility.set(0);
            this.cardSizeShouldBe = 0;
            this.listener.updateNewCardImage(-1);
            this.listener.clearRadioGroup();
            this.listener.enableDisableExipary(true);
            this.listener.changeCvvRequiredNotRequired(true);
            this.listener.changeExpiryRequiredNotRequired(true);
            this.showVisaOneClick.set(8);
            this.isVisaCardEnrolled_.set(false);
            this.isSingleVisaClickChecked.set(false);
        }
    }

    public void fetchBinDetails(final String str, final SetOnFetchBinResult setOnFetchBinResult) {
        final BinResponse binResposne = ApiSession.getInstance().getBinResposne(str);
        if (binResposne != null) {
            new Handler().post(new Runnable() {
                public void run() {
                    BankOffersNewCardViewModel.this.onBinResponseApi(str, binResposne, setOnFetchBinResult);
                }
            });
        } else if (SDKUtility.isNetworkAvailable(this.context)) {
            NativeSDKRepository.getInstance().fetchBinDetails(str, new PaymentMethodDataSource.Callback<BinResponse>() {
                public void onResponse(BinResponse binResponse) {
                    BankOffersNewCardViewModel.this.onBinResponseApi(str, binResponse, setOnFetchBinResult);
                }

                public void onErrorResponse(VolleyError volleyError, BinResponse binResponse) {
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
                            BankOffersNewCardViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoErrorMsg());
                            BankOffersNewCardViewModel.this.promoCodeVisibility.set(0);
                            BankOffersNewCardViewModel.this.listener.changePromoCodeBg(true);
                            return;
                        }
                        BankOffersNewCardViewModel.this.promoCodeText.set(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg());
                        BankOffersNewCardViewModel.this.promoCodeVisibility.set(0);
                        BankOffersNewCardViewModel.this.listener.changePromoCodeBg(false);
                    }
                }

                public void onErrorResponse(VolleyError volleyError, PromoCodeResponse promoCodeResponse) {
                    BankOffersNewCardViewModel.this.showServerFailureAlert(volleyError);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, BankOffersNewCardViewModel.this.isCreditCardLayout ? "Credit Card" : "Debit Card", promoCodeApiUrl));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onBinResponseApi(String str, BinResponse binResponse2, SetOnFetchBinResult setOnFetchBinResult) {
        if (binResponse2 == null || binResponse2.getBody() == null) {
            this.lowSuccessRateVisibility.set(8);
        } else if (binResponse2.getBody() == null || binResponse2.getBody().getResultInfo() == null || binResponse2.getBody().getResultInfo().getResultStatus() == null || !binResponse2.getBody().getResultInfo().getResultStatus().equalsIgnoreCase(AppConstants.FEED_SUB_TYPE)) {
            ApiSession.getInstance().setBinResponse(str, binResponse2);
            this.binResponse = binResponse2;
            this.newCardType = binResponse2.getBody().getBinDetail().getChannelCode();
            if (this.newCardType.equalsIgnoreCase(SDKConstants.AMEX)) {
                this.listener.changeCvvFieldLength(4);
            } else {
                this.listener.changeCvvFieldLength(3);
            }
            this.newCardCVVVisibility.set(0);
            this.listener.enableDisableCvv(true);
            this.otpAtmTransaction = binResponse2.getBody().getAuthModes()[0];
            if (binResponse2.getBody().getAuthModes()[0].equalsIgnoreCase("otp")) {
                this.otpRadioChecked.set(true);
                this.listener.atmRadioChecked(false);
            } else {
                this.listener.atmRadioChecked(true);
            }
            if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                this.listener.changeCvvRequiredNotRequired(false);
                this.listener.changeExpiryRequiredNotRequired(false);
            } else {
                if (binResponse2.getBody().getAuthModes().length > 1) {
                    this.listener.enableDisableCvv(false);
                } else {
                    this.listener.enableDisableCvv(true);
                }
                this.listener.enableDisableExipary(true);
            }
            if (binResponse2.getBody().getHasLowSuccessRate() == null || !binResponse2.getBody().getHasLowSuccessRate().getStatus()) {
                this.lowSuccessRateVisibility.set(8);
            } else {
                this.lowSuccessRateVisibility.set(0);
                this.lowSuccessRateText.set(binResponse2.getBody().getHasLowSuccessRate().getMsg());
            }
            this.listener.updateNewCardImage(SDKUtility.getCardImage(binResponse2.getBody().getBinDetail().getChannelCode()));
            this.bankCode = binResponse2.getBody().getBinDetail().getIssuingBankCode();
            String str2 = this.newCardType;
            if (str2 != null) {
                if (str2.equalsIgnoreCase(SDKConstants.AMEX)) {
                    this.cardSizeShouldBe = 15;
                } else if (this.newCardType.equalsIgnoreCase(SDKConstants.DINERS)) {
                    this.cardSizeShouldBe = 14;
                } else if (this.newCardType.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                    this.cardSizeShouldBe = 19;
                } else if (this.newCardType.equalsIgnoreCase(SDKConstants.MASTER) || this.newCardType.equalsIgnoreCase(SDKConstants.VISA) || this.newCardType.equalsIgnoreCase(SDKConstants.RUPAY)) {
                    this.cardSizeShouldBe = 16;
                }
            }
            updateVisaSingleClickUI();
        } else {
            c cVar = this.binDialog;
            if (cVar == null) {
                this.binDialog = DialogUtility.showDialog(this.context, binResponse2.getBody().getResultInfo().getResultMsg(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        BankOffersNewCardViewModel.this.crossClicked((View) null);
                    }
                });
                return;
            } else if (!cVar.isShowing()) {
                this.binDialog.show();
                return;
            } else {
                return;
            }
        }
        if (setOnFetchBinResult != null) {
            setOnFetchBinResult.onComplete();
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
        }
        this.expiary = editable.toString();
    }

    public void cvvBeforeTextChange(Editable editable) {
        this.listener.changeCardUi(false, 3);
        String str = this.newCardType;
        if (str != null) {
            if (str.equalsIgnoreCase(SDKConstants.AMEX) && editable.toString().trim().length() == 4) {
                this.listener.hideCvvKeyBoard();
            } else if (!this.newCardType.equalsIgnoreCase(SDKConstants.AMEX) && editable.toString().trim().length() == 3) {
                this.listener.hideCvvKeyBoard();
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
            str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, AppConstants.UTF_8), this.context);
        } catch (Exception unused) {
            str = this.context.getResources().getString(R.string.server_communication_failed);
        }
        Context context2 = this.context;
        DialogUtility.showDialog(context2, context2.getResources().getString(R.string.unknown_error), str, (DialogInterface.OnClickListener) null);
    }

    private void goForTransaction(String str, String str2, String str3, View view, boolean z) {
        String str4;
        BinResponse binResponse2;
        String str5 = str;
        String str6 = str3;
        View view2 = view;
        String str7 = this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT;
        if (this.emiChannelInfo == null || !isEmiEnabled()) {
            str4 = null;
        } else {
            str4 = this.emiChannelInfo.getPlanId();
            str7 = "EMI";
        }
        String str8 = "1";
        if (!DirectPaymentBL.getInstance().isAddMoney() ? !this.saveNewCard : this.showVisaOneClick.get() != 0 || this.isVisaCardEnrolled_.get() ? !this.saveNewCard : !this.isSingleVisaClickChecked.get()) {
            str8 = "0";
        }
        HashMap<String, String> cardsTranscationParam = PayUtility.getCardsTranscationParam(str5, str7, str2, str8, str4);
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(this.bankCode)) {
            paytmAssistParams.setBankCode(this.bankCode);
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        String str9 = Constants.EASYPAY_PAYTYPE_CREDIT_CARD;
        if (!isEmpty && str5.equalsIgnoreCase("otp")) {
            paytmAssistParams.setPayType(this.isCreditCardLayout ? str9 : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
        }
        if (!TextUtils.isEmpty(str3)) {
            paytmAssistParams.setCardType(str6);
        }
        if (!(this.emiChannelInfo == null || !isEmiEnabled() || (binResponse2 = this.binResponse) == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null || TextUtils.isEmpty(this.binResponse.getBody().getBinDetail().getPaymentMode()))) {
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                cardsTranscationParam.put("emiType", this.binResponse.getBody().getBinDetail().getPaymentMode());
            } else {
                cardsTranscationParam.put(PayUtility.EMI_TYPE, this.binResponse.getBody().getBinDetail().getPaymentMode());
            }
            cardsTranscationParam.put("channelCode", this.binResponse.getBody().getBinDetail().getIssuingBankCode());
        }
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), cardsTranscationParam);
        if (!TextUtils.isEmpty(this.bankCode)) {
            paymentInstrument.setBankCode(this.bankCode);
        }
        if (!TextUtils.isEmpty(str) && str5.equalsIgnoreCase("otp")) {
            if (!this.isCreditCardLayout) {
                str9 = Constants.EASYPAY_PAYTYPE_DEBIT_CARD;
            }
            paymentInstrument.setPayType(str9);
        }
        if (!TextUtils.isEmpty(str3)) {
            paymentInstrument.setCardType(str6);
        }
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
        transactionProcessor.setEmiPlanData(this.emiPlanData);
        if (this.emiChannelInfo == null || !isEmiEnabled()) {
            transactionProcessor.setPaymentIntent(this.paymentIntent);
        } else {
            transactionProcessor.setPaymentIntent(this.emiPaymentIntent);
        }
        if (DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getBinPaymentMode())) {
            String riskConvenienceFeeAmount = DirectPaymentBL.getInstance().getRiskConvenienceFeeAmount(getBinPaymentMode());
            transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
            transactionProcessor.setRiskConvenienveFee(riskConvenienceFeeAmount);
        }
        if ((!DirectPaymentBL.getInstance().isVisaOneClickEnabledForOffers() || this.showVisaOneClick.get() != 0 || !this.isSingleVisaClickChecked.get()) && !this.isVisaCardEnrolled_.get()) {
            transactionProcessor.startTransaction(view2);
        } else {
            transactionProcessor.setVisaSingleClickEnabled(true);
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, this.expiary);
            transactionProcessor.setCardDetails(new CardData(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate()));
            boolean z2 = this.isVisaCardEnrolled_.get();
            String str10 = SDKConstants.GA_NEW_CC;
            if (!z2 || TextUtils.isEmpty(str3)) {
                if (!this.isCreditCardLayout) {
                    str10 = SDKConstants.GA_NEW_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_ENROLLMENT, str10));
                this.helper.proceedForTranscation(this.context, transactionProcessor, paymentInstrument, view, str3);
            } else {
                if (!this.isCreditCardLayout) {
                    str10 = SDKConstants.GA_NEW_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_REPEAT, str10));
                transactionProcessor.isEnrolled(true);
                this.helper.proceedForTranscation(this.context, transactionProcessor, paymentInstrument, (View) null, str3);
            }
        }
        view2.setOnClickListener((View.OnClickListener) null);
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

    public void deselectView() {
        this.prevEmiSelectedPosition = -1;
    }

    private void showBankOffers(ApplyPromoResponse.PaymentOffer paymentOffer) {
        if (paymentOffer.getTotalCashbackAmount() != null) {
            this.bankOfferVisibility.set(0);
            i<SpannableString> iVar = this.bankOfferText;
            Context context2 = this.context;
            iVar.set(SDKUtility.getBankOfferText(context2, context2.getResources().getString(R.string.nativesdk_cashback_applied_successfully, new Object[]{paymentOffer.getTotalCashbackAmount()}), paymentOffer));
            this.cashBackTextVisibility.set(0);
            this.cashBackText.set(this.context.getResources().getString(R.string.nativesdk_effective_price, new Object[]{paymentOffer.getTotalCashbackAmount(), MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalCashbackAmount()))}));
        } else if (paymentOffer.getTotalInstantDiscount() != null) {
            this.bankOfferVisibility.set(0);
            i<SpannableString> iVar2 = this.bankOfferText;
            Context context3 = this.context;
            iVar2.set(SDKUtility.getBankOfferText(context3, context3.getResources().getString(R.string.nativesdk_instant_discount, new Object[]{paymentOffer.getTotalInstantDiscount()}), paymentOffer));
            this.paySecurelyText.set(this.context.getResources().getString(R.string.nativesdk_amount_pay, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(paymentOffer.getTotalInstantDiscount()))}));
        } else {
            this.bankOfferVisibility.set(8);
        }
    }

    private void hideOffer() {
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        i<String> iVar = this.paySecurelyText;
        iVar.set("Pay  ₹ " + SDKUtility.getDiffAmount());
    }

    public boolean isEmiEnabled() {
        return this.isEmiEnabled;
    }

    public void setEmiEnabled(boolean z) {
        this.isEmiEnabled = z;
    }

    public boolean isVisaCardEnrolled() {
        BinResponse binResponse2 = this.binResponse;
        return (binResponse2 == null || binResponse2.getBody() == null || !this.binResponse.getBody().isOneClickSupported()) ? false : true;
    }

    /* access modifiers changed from: private */
    public void removeSingleClickView() {
        this.isVisaCardEnrolled_.set(false);
        this.showVisaOneClick.set(8);
        this.isSingleVisaClickChecked.set(false);
    }

    /* access modifiers changed from: private */
    public void checkForEnrollment(Boolean bool) {
        try {
            if (TextUtils.isEmpty(this.cardNumber) || this.cardSizeShouldBe != this.cardNumber.replace("-", "").length()) {
                this.isVisaCardEnrolled_.set(false);
                this.isVisaCardEnrolled_.set(false);
                return;
            }
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, "");
            CardData cardData = new CardData(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate());
            if (!bool.booleanValue() || !isVisaCardEnrolled()) {
                if (this.showVisaOneClick.get() == 0 && this.isSingleVisaClickChecked.get()) {
                    this.helper.createOnClickInfoObject(cardData);
                }
                this.isVisaCardEnrolled_.set(false);
                return;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_REPEAT, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
            this.isVisaCardEnrolled_.set(true);
            this.helper.createOnClickInfoObject(cardData);
        } catch (Exception unused) {
        }
    }

    public void updateVisaSingleClickUI() {
        BinResponse binResponse2;
        if (TextUtils.isEmpty(this.cardNumber) || (binResponse2 = this.binResponse) == null || binResponse2.getBody() == null) {
            this.showVisaOneClick.set(8);
            this.isVisaCardEnrolled_.set(false);
        } else if (!DirectPaymentBL.getInstance().isVisaOneClickEnabledForOffers() || !this.binResponse.getBody().isOneClickSupported() || TextUtils.isEmpty(this.cardNumber)) {
            removeSingleClickView();
        } else {
            preSelectVisaSingleClick();
            CardDetails cardDetailObject = getCardDetailObject(this.cardNumber, "");
            CardData cardData = new CardData(cardDetailObject.getFirstSixDigit(), cardDetailObject.getLastFourDigit(), cardDetailObject.getExpiryDate());
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_ENROLLMENT_OPTION_DISPLAYED, SDKConstants.GA_ENROLLMENT, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
            if (this.enrollmentListener == null) {
                this.enrollmentListener = new EnrollmentListener() {
                    public void isEnrolled(EnrollmentData enrollmentData) {
                        BankOffersNewCardViewModel bankOffersNewCardViewModel = BankOffersNewCardViewModel.this;
                        CardDetails access$500 = bankOffersNewCardViewModel.getCardDetailObject(bankOffersNewCardViewModel.cardNumber, "");
                        if (!enrollmentData.isEligible() || !(BankOffersNewCardViewModel.this.context instanceof ActivityInteractor) || !((ActivityInteractor) BankOffersNewCardViewModel.this.context).isUIEnable() || !enrollmentData.getCardData().getFirstSixDigit().equals(access$500.getFirstSixDigit()) || !enrollmentData.getCardData().getLastFourDigit().equals(access$500.getLastFourDigit())) {
                            BankOffersNewCardViewModel.this.removeSingleClickView();
                            return;
                        }
                        BankOffersNewCardViewModel.this.checkForEnrollment(Boolean.valueOf(enrollmentData.isEnrolled()));
                        if (BankOffersNewCardViewModel.this.showVisaOneClick.get() != 0 && !BankOffersNewCardViewModel.this.isVisaCardEnrolled_.get()) {
                            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_ENROLLMENT, BankOffersNewCardViewModel.this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC));
                            BankOffersNewCardViewModel.this.listener.animateOneClickContainer();
                        }
                        BankOffersNewCardViewModel.this.showVisaOneClick.set(0);
                    }
                };
            }
            if (this.helper.isVisaCardEnrolled(this.context, cardData, this.isCreditCardLayout ? SDKConstants.GA_NEW_CC : SDKConstants.GA_NEW_DC, this.enrollmentListener, this.netPayableAmount.doubleValue(), getBinPaymentMode()) == null) {
                removeSingleClickView();
            }
        }
    }

    /* access modifiers changed from: private */
    public CardDetails getCardDetailObject(String str, String str2) {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setExpiryDate(str2);
        String replace = str.replace("-", "");
        cardDetails.setFirstSixDigit(replace.substring(0, 6));
        cardDetails.setLastFourDigit(replace.substring(replace.length() - 4));
        return cardDetails;
    }
}
