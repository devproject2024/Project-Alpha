package net.one97.paytm.nativesdk.instruments.savedCard.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.UpiPushCallbackListener;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.savedCard.listeners.SavedCardClickListener;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public class SavedCardViewModel extends BaseViewModel {
    public i<String> amount = new i<>("");
    public ObservableInt appliedOffersVisibility = new ObservableInt(8);
    public i<String> bankName;
    private double cardConvenienceFee;
    public i<String> cardNumber;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public i<SpannableString> convFeeText = new i<>(new SpannableString(""));
    public ObservableInt convFeeTextGravity = new ObservableInt(1);
    public ObservableInt convFeeTextVisibility = new ObservableInt(8);
    private double emiConvenienceFee;
    private ArrayList<PaymentIntent> emiPaymentIntent;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer hybridEmiPaymentOffer;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer hybridPaymentOffer;
    public i<String> imageUrl;
    /* access modifiers changed from: private */
    public boolean isApiCallRunning = false;
    /* access modifiers changed from: private */
    public boolean isConvFeeRequestInProgress;
    private boolean isCreditCardLayout;
    public boolean isEmiEnabled = false;
    /* access modifiers changed from: private */
    public boolean isEmiView;
    /* access modifiers changed from: private */
    public boolean isSelected = false;
    public ObservableBoolean isSingleVisaClickChecked = new ObservableBoolean(false);
    private boolean isSubventedEmi;
    public i<String> loaderMsg = new i<>("");
    public ObservableInt loaderVisibility = new ObservableInt(8);
    public ObservableInt lowSuccess;
    private Double multiEmiNetAmount;
    public Double netPayableAmount;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer nonHybridEmiPaymentOffer;
    /* access modifiers changed from: private */
    public ApplyPromoResponse.PaymentOffer nonHybridPaymentOffer;
    public i<String> offerApplicableText = new i<>("");
    public ObservableInt offerApplicationVisibility = new ObservableInt(8);
    public i<String> paySecurelyText = new i<>();
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public SavedCardClickListener savedCardClickListener;
    private SavedInstruments savedInstruments;
    public ObservableInt showVisaOneClick = new ObservableInt(8);
    private String subventedOfferText;
    public i<String> subventionOfferText = new i<>("");
    public ObservableInt subventionOfferVisibility = new ObservableInt(8);

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public SavedCardViewModel(Context context2, String str, String str2, String str3, SavedInstruments savedInstruments2, boolean z, SavedCardClickListener savedCardClickListener2) {
        super(context2, savedCardClickListener2);
        this.savedInstruments = savedInstruments2;
        this.context = context2;
        this.cardNumber = new i<>(str);
        this.bankName = new i<>(str2);
        this.imageUrl = new i<>(str3);
        this.lowSuccess = new ObservableInt(8);
        this.savedCardClickListener = savedCardClickListener2;
        setPaySecurelyText();
        this.isCreditCardLayout = savedInstruments2.getCardDetails().getCardType().contains(SDKConstants.CREDIT);
        this.isEmiView = z;
        this.savedCardClickListener = savedCardClickListener2;
        if (!z) {
            if (!SDKUtility.isHybridSupported()) {
                this.nonHybridPaymentOffer = convertObjectToAppliedOffer();
            } else {
                this.hybridPaymentOffer = convertObjectToAppliedOffer();
            }
        }
        showOfferAvailabilityInfo();
    }

    /* access modifiers changed from: private */
    public void showOfferAvailabilityInfo() {
        String str;
        if (SDKUtility.isAppInvokeFlow() && SDKConstants.ADDANDPAY.equals(DirectPaymentBL.getInstance().getPaymentFlowBankOffer()) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            return;
        }
        if (getPaymentOffer() != null) {
            if (SDKUtility.isAppInvokeFlow()) {
                String str2 = this.savedInstruments.getIssuingBank() + "-" + this.savedInstruments.getChannelCode();
                if (this.isCreditCardLayout) {
                    str = "Credit Card-".concat(String.valueOf(str2));
                } else {
                    str = "Debit Card-".concat(String.valueOf(str2));
                }
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_BULK_OFFERS, str));
            }
            if (getPaymentOffer().getOfferBreakup() == null || getPaymentOffer().getOfferBreakup().size() <= 0) {
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            } else if (!TextUtils.isEmpty(getPaymentOffer().getOfferBreakup().get(0).getPromocodeApplied())) {
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI(getPaymentOffer().getOfferBreakup().get(0).getPromocodeApplied());
            } else {
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            }
            if (getPaymentOffer().getTotalCashbackAmount() != null) {
                this.offerApplicationVisibility.set(0);
                this.offerApplicableText.set(this.context.getString(R.string.cashback_applicable, new Object[]{getPaymentOffer().getTotalCashbackAmount()}));
            } else if (getPaymentOffer().getTotalInstantDiscount() != null) {
                this.offerApplicationVisibility.set(0);
                this.offerApplicableText.set(this.context.getString(R.string.instant_discount_applicable, new Object[]{getPaymentOffer().getTotalInstantDiscount()}));
            } else {
                ApplyPromoResponse.PaymentOffer paymentOffer = this.hybridPaymentOffer;
                if (paymentOffer == null) {
                    hideOfferAvailabilityInfo();
                } else if (!TextUtils.isEmpty(paymentOffer.getTotalCashbackAmount())) {
                    this.offerApplicationVisibility.set(0);
                    this.offerApplicableText.set(this.context.getString(R.string.cashback_applicable_tap_to_view));
                } else if (!TextUtils.isEmpty(this.hybridPaymentOffer.getTotalInstantDiscount())) {
                    this.offerApplicationVisibility.set(0);
                    this.offerApplicableText.set(this.context.getString(R.string.instant_discount_applicable_tap_to_view));
                } else {
                    hideOfferAvailabilityInfo();
                }
            }
        } else if (SDKUtility.shouldShowValidatePromoError()) {
            setValidatePromoText();
        } else {
            ApplyPromoResponse.PaymentOffer paymentOffer2 = this.hybridPaymentOffer;
            if (paymentOffer2 == null) {
                hideOfferAvailabilityInfo();
            } else if (!TextUtils.isEmpty(paymentOffer2.getTotalCashbackAmount())) {
                this.offerApplicableText.set(this.context.getString(R.string.cashback_applicable_tap_to_view));
            } else if (!TextUtils.isEmpty(this.hybridPaymentOffer.getTotalInstantDiscount())) {
                this.offerApplicableText.set(this.context.getString(R.string.instant_discount_applicable_tap_to_view));
            } else {
                hideOfferAvailabilityInfo();
            }
            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
        }
    }

    public void hideOfferAvailabilityInfo() {
        this.offerApplicableText.set("");
        this.offerApplicationVisibility.set(8);
    }

    public void showBankOffers() {
        hideOfferAvailabilityInfo();
        if (isOfferValid()) {
            this.savedCardClickListener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
            if (getPaymentOffer().getTotalCashbackAmount() != null) {
                if (SDKUtility.isBankOfferBottom().booleanValue()) {
                    this.bankOfferVisibility.set(8);
                    this.bankOfferBottomVisibility.set(0);
                    i iVar = this.bankOfferBottomText;
                    Context context2 = this.context;
                    iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.cashback_applied_successfully, new Object[]{getPaymentOffer().getTotalCashbackAmount()}), getPaymentOffer()));
                } else {
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar2 = this.bankOfferText;
                    Context context3 = this.context;
                    iVar2.set(SDKUtility.getBankOfferText(context3, context3.getString(R.string.cashback_applied_successfully, new Object[]{getPaymentOffer().getTotalCashbackAmount()}), getPaymentOffer()));
                }
                if (!SDKUtils.isRiskConvFeeApplicable(getCardHash())) {
                    this.cashBackTextVisibility.set(0);
                    this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(getPaymentOffer().getTotalCashbackAmount()))}));
                }
                setPaySecurelyText();
            } else if (getPaymentOffer().getTotalInstantDiscount() != null) {
                if (SDKUtility.isBankOfferBottom().booleanValue()) {
                    this.bankOfferVisibility.set(8);
                    this.bankOfferBottomVisibility.set(0);
                    i iVar3 = this.bankOfferBottomText;
                    Context context4 = this.context;
                    iVar3.set(SDKUtility.getBankOfferText(context4, context4.getString(R.string.instant_discount_applied_successfully, new Object[]{getPaymentOffer().getTotalInstantDiscount()}), getPaymentOffer()));
                } else {
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar4 = this.bankOfferText;
                    Context context5 = this.context;
                    iVar4.set(SDKUtility.getBankOfferText(context5, context5.getString(R.string.instant_discount_applied_successfully, new Object[]{getPaymentOffer().getTotalInstantDiscount()}), getPaymentOffer()));
                }
                this.cashBackTextVisibility.set(8);
                setPaySecurelyText();
            } else {
                this.bankOfferText.set(new SpannableString(""));
                this.bankOfferVisibility.set(8);
                this.bankOfferBottomVisibility.set(8);
                this.cashBackTextVisibility.set(8);
                setPaySecurelyText();
                this.cashBackText.set("");
                setValidatePromoText();
                if (getPaymentIntent() != null && getPaymentIntent().size() > 0) {
                    showOffersTextFromCart(getPaymentIntent().get(0));
                }
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
        updateSubventedOfferView();
    }

    public void hideOffer() {
        showOfferAvailabilityInfo();
        this.bankOfferText.set(new SpannableString(""));
        this.bankOfferVisibility.set(8);
        this.bankOfferBottomText.set(new SpannableString(""));
        this.bankOfferBottomVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        setPaySecurelyText();
        this.cashBackText.set("");
        hideSubventedOffer();
    }

    public void fetchConvenienceFee() {
        buildPaymentIntent();
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled() && this.isSelected && !this.isEmiEnabled && !this.isEmiView) {
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.savedInstruments.getChannelCode());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.savedInstruments.getIssuingBank());
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.savedInstruments.getCardDetails().getCardHash());
        cardPaymentIntentData.setBin6(this.savedInstruments.getCardDetails().getFirstSixDigit());
        cardPaymentIntentData.setBin8(this.savedInstruments.getCardDetails().getFirstEightDigit());
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT, arrayList, arrayList2, cardPaymentIntentData, (String) null, Double.valueOf(getTotalInstantDiscount()));
    }

    public void buildEmiPaymentIntent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.savedInstruments.getChannelCode());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.savedInstruments.getIssuingBank());
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.savedInstruments.getCardDetails().getCardHash());
        cardPaymentIntentData.setBin6(this.savedInstruments.getCardDetails().getFirstSixDigit());
        cardPaymentIntentData.setBin8(this.savedInstruments.getCardDetails().getFirstEightDigit());
        this.emiPaymentIntent = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), arrayList, arrayList2, cardPaymentIntentData, this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT, Double.valueOf(getTotalInstantDiscount()));
    }

    public void getBankOffers() {
        String str;
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            if (this.isEmiEnabled || this.isEmiView) {
                if (!SDKUtility.isHybridCase() || this.hybridEmiPaymentOffer == null) {
                    if (!SDKUtility.isHybridCase() && this.nonHybridEmiPaymentOffer != null) {
                        if (this.isSelected) {
                            showBankOffers();
                            fetchConvenienceFee();
                            updateSubventedOfferView();
                            return;
                        }
                        showOfferAvailabilityInfo();
                        return;
                    }
                } else if (this.isSelected) {
                    showBankOffers();
                    fetchConvenienceFee();
                    updateSubventedOfferView();
                    return;
                } else {
                    showOfferAvailabilityInfo();
                    return;
                }
            } else if (!SDKUtility.isHybridCase() || this.hybridPaymentOffer == null) {
                if (!SDKUtility.isHybridCase() && this.nonHybridPaymentOffer != null) {
                    if (this.isSelected) {
                        showBankOffers();
                        fetchConvenienceFee();
                        return;
                    }
                    showOfferAvailabilityInfo();
                    updateSubventedOfferView();
                    return;
                }
            } else if (this.isSelected) {
                showBankOffers();
                fetchConvenienceFee();
                return;
            } else {
                showOfferAvailabilityInfo();
                updateSubventedOfferView();
                return;
            }
            if (!SDKUtility.isHybridCase()) {
                showLoading(this.context.getString(R.string.native_checking_offers));
            }
            if (!this.isApiCallRunning) {
                this.isApiCallRunning = true;
                ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
                StringBuilder sb = new StringBuilder();
                sb.append(SDKUtility.getDiffAmount());
                paymentOption.setTransactionAmount(sb.toString());
                if (this.isEmiEnabled || this.isEmiView) {
                    str = PayMethodType.EMI.name();
                } else {
                    str = this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT;
                }
                paymentOption.setPayMethod(str);
                paymentOption.setBankCode(this.savedInstruments.getIssuingBank());
                paymentOption.setSavedCardId(this.savedInstruments.getCardDetails().getCardId());
                this.savedCardClickListener.disableProceedButton();
                if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                    showLoading(this.context.getString(R.string.conv_fee_fetching));
                } else {
                    showLoading(this.context.getString(R.string.native_checking_offers));
                }
                this.offerApplicableText.set("");
                this.offerApplicationVisibility.set(8);
                NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                    private boolean isEMi;
                    private boolean isHybrid = SDKUtility.isHybridCase();

                    {
                        this.isEMi = SavedCardViewModel.this.isEmiEnabled || SavedCardViewModel.this.isEmiView;
                    }

                    public void onResponse(ApplyPromoResponse applyPromoResponse) {
                        boolean unused = SavedCardViewModel.this.isApiCallRunning = false;
                        SavedCardViewModel.this.hideLoading();
                        SavedCardViewModel.this.savedCardClickListener.enableProceedButton();
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null || applyPromoResponse.getBody().getPaymentOffer() == null) {
                            SavedCardViewModel.this.fetchConvenienceFee();
                            SavedCardViewModel.this.setValidatePromoText();
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                            return;
                        }
                        if (this.isEMi) {
                            if (this.isHybrid) {
                                ApplyPromoResponse.PaymentOffer unused2 = SavedCardViewModel.this.hybridEmiPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                            } else {
                                ApplyPromoResponse.PaymentOffer unused3 = SavedCardViewModel.this.nonHybridEmiPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                            }
                        } else if (this.isHybrid) {
                            ApplyPromoResponse.PaymentOffer unused4 = SavedCardViewModel.this.hybridPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                        } else {
                            ApplyPromoResponse.PaymentOffer unused5 = SavedCardViewModel.this.nonHybridPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                        }
                        SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                        if (SavedCardViewModel.this.isSelected) {
                            SavedCardViewModel.this.showBankOffers();
                            SavedCardViewModel.this.fetchConvenienceFee();
                            return;
                        }
                        SavedCardViewModel.this.showOfferAvailabilityInfo();
                    }

                    public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                        boolean unused = SavedCardViewModel.this.isApiCallRunning = false;
                        SavedCardViewModel.this.savedCardClickListener.enableProceedButton();
                        SavedCardViewModel.this.hideLoading();
                        SavedCardViewModel.this.hideOffer();
                        SavedCardViewModel.this.hideOfferAvailabilityInfo();
                        SavedCardViewModel.this.setValidatePromoText();
                    }
                });
            }
        }
    }

    public void hybridCheckChanged() {
        if (!this.isEmiEnabled) {
            if (!SDKUtility.isHybridCase()) {
                if (this.nonHybridPaymentOffer == null) {
                    if (this.isSelected) {
                        getBankOffers();
                    }
                    hideOffer();
                } else if (this.isSelected) {
                    showBankOffers();
                    return;
                } else {
                    showOfferAvailabilityInfo();
                    return;
                }
            } else if (this.hybridPaymentOffer == null) {
                if (this.isSelected) {
                    getBankOffers();
                }
                hideOffer();
            } else if (this.isSelected) {
                showBankOffers();
                return;
            }
            showOfferAvailabilityInfo();
        } else if (!SDKUtility.isHybridCase()) {
            if (this.nonHybridEmiPaymentOffer == null) {
                if (this.isSelected) {
                    getBankOffers();
                }
                hideOffer();
                hideOfferAvailabilityInfo();
            } else if (this.isSelected) {
                showBankOffers();
            } else {
                showOfferAvailabilityInfo();
            }
        } else if (this.hybridEmiPaymentOffer == null) {
            if (this.isSelected) {
                getBankOffers();
            }
            hideOffer();
            hideOfferAvailabilityInfo();
        } else if (this.isSelected) {
            showBankOffers();
        } else {
            showOfferAvailabilityInfo();
        }
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    private ApplyPromoResponse.PaymentOffer convertObjectToAppliedOffer() {
        if (this.savedInstruments.getPaymentOfferDetails() == null) {
            return null;
        }
        ApplyPromoResponse.PaymentOffer paymentOffer = new ApplyPromoResponse.PaymentOffer();
        paymentOffer.setTotalInstantDiscount(this.savedInstruments.getPaymentOfferDetails().getInstantDiscount());
        paymentOffer.setTotalCashbackAmount(this.savedInstruments.getPaymentOfferDetails().getCashbackAmount());
        ArrayList arrayList = new ArrayList();
        ApplyPromoResponse.OfferBreakup offerBreakup = new ApplyPromoResponse.OfferBreakup();
        offerBreakup.setCashbackAmount(this.savedInstruments.getPaymentOfferDetails().getCashbackAmount());
        offerBreakup.setInstantDiscount(this.savedInstruments.getPaymentOfferDetails().getInstantDiscount());
        offerBreakup.setPayMethod(this.savedInstruments.getPaymentOfferDetails().getPayMethod());
        offerBreakup.setPromocodeApplied(this.savedInstruments.getPaymentOfferDetails().getPromocodeApplied());
        offerBreakup.setPromotext(this.savedInstruments.getPaymentOfferDetails().getPromoText());
        offerBreakup.setPromoVisibility(this.savedInstruments.getPaymentOfferDetails().getPromoVisibility());
        arrayList.add(offerBreakup);
        paymentOffer.setOfferBreakup(arrayList);
        return paymentOffer;
    }

    public void oneClickChanged(CompoundButton compoundButton, boolean z) {
        this.isSingleVisaClickChecked.set(z);
        updateVisaPreference(z);
    }

    private void updateVisaPreference(boolean z) {
        CardDetails cardDetails;
        SavedInstruments savedInstruments2 = this.savedInstruments;
        if (savedInstruments2 != null && !z && (cardDetails = savedInstruments2.getCardDetails()) != null && DirectPaymentBL.getInstance().getCustomerId() != null) {
            SharedPreferenceUtil.getInstance().setBoolean(SDKUtils.getVisaAlias(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), DirectPaymentBL.getInstance().getCustomerId()), false);
        }
    }

    public String getInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        return (paymentOffer == null || TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount())) ? "" : paymentOffer.getTotalInstantDiscount();
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        return (this.isEmiEnabled || this.isEmiView) ? SDKUtility.isHybridCase() ? this.hybridEmiPaymentOffer : this.nonHybridEmiPaymentOffer : SDKUtility.isHybridCase() ? this.hybridPaymentOffer : this.nonHybridPaymentOffer;
    }

    public void setEmiEnabled(boolean z) {
        this.isEmiEnabled = z;
        hideOfferAvailabilityInfo();
        hideOffer();
        if (!this.isEmiEnabled) {
            clearEmiConvenienceFee();
        }
        getBankOffers();
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
        this.savedCardClickListener.disableProceedButton();
        this.isConvFeeRequestInProgress = true;
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                SavedCardViewModel.this.hideLoading();
                boolean unused = SavedCardViewModel.this.isConvFeeRequestInProgress = false;
                if (!SavedCardViewModel.this.isSelected) {
                    SavedCardViewModel.this.savedCardClickListener.enableProceedButton();
                } else if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    SavedCardViewModel.this.convFeeTextVisibility.set(8);
                    SavedCardViewModel.this.savedCardClickListener.disableProceedButton();
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, SavedCardViewModel.this.context);
                } else {
                    ArrayList unused2 = SavedCardViewModel.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) SavedCardViewModel.this.paymentIntents, verifyResponseData.getVerifyModel());
                    SavedCardViewModel.this.configureConvFeeView();
                    SavedCardViewModel.this.savedCardClickListener.enableProceedButton();
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                SavedCardViewModel.this.hideLoading();
                SavedCardViewModel.this.convFeeTextVisibility.set(8);
                boolean unused = SavedCardViewModel.this.isConvFeeRequestInProgress = false;
                if (SavedCardViewModel.this.isSelected) {
                    SavedCardViewModel.this.savedCardClickListener.disableProceedButton();
                    SDKUtility.handleVerticalError(apiResponseError, SavedCardViewModel.this.context);
                }
            }
        });
    }

    public void configureConvFeeView() {
        if (this.isSelected) {
            Iterator<PaymentIntent> it2 = getCurrentPaymentIntent().iterator();
            String str = null;
            double d2 = 0.0d;
            SpannableString spannableString = null;
            double d3 = 0.0d;
            while (it2.hasNext()) {
                PaymentIntent next = it2.next();
                d3 += next.getConvFee();
                next.getFeePercent();
                String convFeeText2 = next.getConvFeeText();
                SpannableString spannableConvFeeText = next.getSpannableConvFeeText();
                if (next.getMode().equalsIgnoreCase(getPaymentMode())) {
                    if (this.isEmiEnabled) {
                        this.emiConvenienceFee = next.getConvFee();
                    } else {
                        this.cardConvenienceFee = next.getConvFee();
                    }
                    setPaySecurelyText();
                    setAmountIfNeeded();
                    if (DirectPaymentBL.getInstance().isAddMoney() && next.getConvFee() > d2 && this.isCreditCardLayout) {
                        this.cashBackTextVisibility.set(0);
                        i<String> iVar = this.cashBackText;
                        Context context2 = this.context;
                        int i2 = R.string.add_money_conv_fee_prceed;
                        StringBuilder sb = new StringBuilder();
                        sb.append(next.getConvFee());
                        iVar.set(context2.getString(i2, new Object[]{sb.toString()}));
                        this.convFeeTextGravity.set(8388611);
                    } else if (getPaymentOffer() != null && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
                        this.cashBackTextVisibility.set(0);
                        this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.getDoubleFormaAmount((next.getTxnAmount() + next.getConvFee()) - SDKUtility.parseDouble(getPaymentOffer().getTotalCashbackAmount()))}));
                    }
                    showOffersTextFromCart(next);
                }
                str = convFeeText2;
                spannableString = spannableConvFeeText;
                d2 = 0.0d;
            }
            if (d3 > d2) {
                this.convFeeTextVisibility.set(0);
                SDKUtility.setConvenienceFeeText(this.convFeeText, SDKUtility.priceWithoutDecimal(d3), str, this.context, spannableString);
                return;
            }
            this.convFeeTextVisibility.set(8);
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

    public String getPaymentMode() {
        if (this.isEmiEnabled) {
            return PayMethodType.EMI.name();
        }
        return getCardType();
    }

    public String getCardType() {
        return (this.isCreditCardLayout ? PayMethodType.CREDIT_CARD : PayMethodType.DEBIT_CARD).name();
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public ArrayList<PaymentIntent> getEmiPaymentIntent() {
        if (this.emiPaymentIntent == null) {
            buildEmiPaymentIntent();
        }
        return this.emiPaymentIntent;
    }

    private ArrayList<PaymentIntent> getCurrentPaymentIntent() {
        if (this.isEmiEnabled) {
            return getEmiPaymentIntent();
        }
        return getPaymentIntent();
    }

    public void invalidatePaymentIntent() {
        this.paymentIntents = null;
        clearEmiConvenienceFee();
    }

    private void clearEmiConvenienceFee() {
        this.emiPaymentIntent = null;
        this.emiConvenienceFee = 0.0d;
    }

    private double getTotalInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (paymentOffer == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    private void showLoading(String str) {
        this.convFeeTextVisibility.set(8);
        this.loaderMsg.set(str);
        this.loaderVisibility.set(0);
        this.savedCardClickListener.startCheckingOfferAnimation();
    }

    public void hideLoading() {
        this.loaderVisibility.set(8);
        this.savedCardClickListener.stopCheckingOfferAnimation();
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    public void setPaySecurelyText() {
        Double d2;
        if (!this.isEmiEnabled || (d2 = this.multiEmiNetAmount) == null) {
            this.netPayableAmount = Double.valueOf(SDKUtility.getNetPaySecurelyAmount(this.context, getTotalInstantDiscount(), getPayableConvenienceFee()));
            this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.context, getTotalInstantDiscount(), getPayableConvenienceFee()));
        } else {
            this.netPayableAmount = SDKUtility.getNetEmiPaySecurelyAmount(this.context, d2.doubleValue());
            this.paySecurelyText.set(SDKUtility.getNetEmiPaySecurelyText(this.context, this.multiEmiNetAmount.doubleValue()));
        }
        this.savedCardClickListener.updateVisaSingleClickUI();
    }

    public void setPaySecurelyText(String str) {
        this.multiEmiNetAmount = Double.valueOf(SDKUtility.parseDouble(str));
        setPaySecurelyText();
    }

    public void setAmountIfNeeded() {
        this.amount.set("");
    }

    public double getEmiConvenienceFee() {
        return this.emiConvenienceFee;
    }

    public String getCardHash() {
        return this.savedInstruments.getCardDetails().getCardHash();
    }

    public void setPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntents = new ArrayList<>();
        this.paymentIntents.addAll(arrayList);
    }

    public void setEmiPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.emiPaymentIntent = new ArrayList<>();
        this.emiPaymentIntent.addAll(arrayList);
    }

    public double getPayableConvenienceFee() {
        if (this.isEmiEnabled) {
            return this.emiConvenienceFee;
        }
        return this.cardConvenienceFee;
    }

    public void fetchEmiBankOffer() {
        ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
        StringBuilder sb = new StringBuilder();
        sb.append(SDKUtility.getDiffAmount());
        paymentOption.setTransactionAmount(sb.toString());
        paymentOption.setPayMethod(this.isCreditCardLayout ? PayMethodType.EMI.name() : SDKConstants.EMI_DC);
        paymentOption.setBankCode(this.savedInstruments.getIssuingBankCode());
        if (!TextUtils.isEmpty(this.savedInstruments.getCardDetails().getCardId())) {
            paymentOption.setSavedCardId(this.savedInstruments.getCardDetails().getCardId());
        }
        NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
            private boolean isHybrid = SDKUtility.isHybridCase();

            public void onResponse(ApplyPromoResponse applyPromoResponse) {
                if (applyPromoResponse == null || applyPromoResponse.getBody() == null) {
                    SavedCardViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                } else if (applyPromoResponse.getBody().getPaymentOffer() != null) {
                    if (this.isHybrid) {
                        ApplyPromoResponse.PaymentOffer unused = SavedCardViewModel.this.hybridEmiPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                    } else {
                        ApplyPromoResponse.PaymentOffer unused2 = SavedCardViewModel.this.nonHybridEmiPaymentOffer = applyPromoResponse.getBody().getPaymentOffer();
                    }
                    SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                    SavedCardViewModel.this.applyPromoFailed = false;
                } else {
                    SavedCardViewModel.this.setValidatePromoText();
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                }
                SavedCardViewModel.this.savedCardClickListener.bankEmiOfferReceived();
            }

            public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                SavedCardViewModel.this.savedCardClickListener.bankEmiOfferError();
                SavedCardViewModel.this.setValidatePromoText();
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            }
        });
    }

    public ApplyPromoResponse.PaymentOffer getEmiBankOffer() {
        return SDKUtility.isHybridCase() ? this.hybridEmiPaymentOffer : this.nonHybridEmiPaymentOffer;
    }

    public ApplyPromoResponse.PaymentOffer getSavedCardBankOffer() {
        return SDKUtility.isHybridCase() ? this.hybridPaymentOffer : this.nonHybridPaymentOffer;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void handleEmiOfferText() {
        if (this.isEmiEnabled) {
            boolean isOfferValid = SDKUtility.isOfferValid(getSavedCardBankOffer());
            boolean isOfferValid2 = SDKUtility.isOfferValid(getEmiBankOffer());
            if (isOfferValid && !isOfferValid2) {
                String totalCashbackAmount = getSavedCardBankOffer().getTotalCashbackAmount();
                if (TextUtils.isEmpty(totalCashbackAmount)) {
                    String totalInstantDiscount = getSavedCardBankOffer().getTotalInstantDiscount();
                    if (TextUtils.isEmpty(totalInstantDiscount)) {
                        return;
                    }
                    if (SDKUtility.isBankOfferBottom().booleanValue()) {
                        this.bankOfferVisibility.set(8);
                        this.bankOfferBottomVisibility.set(0);
                        i iVar = this.bankOfferBottomText;
                        Context context2 = this.context;
                        iVar.set(SDKUtility.getBankOfferText(context2, "₹ " + totalInstantDiscount + " instant discount offer cannot be applied as EMI pay mode is selected", (ApplyPromoResponse.PaymentOffer) null));
                        return;
                    }
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar2 = this.bankOfferText;
                    Context context3 = this.context;
                    iVar2.set(SDKUtility.getBankOfferText(context3, "₹ " + totalInstantDiscount + " instant discount offer cannot be applied as EMI pay mode is selected", (ApplyPromoResponse.PaymentOffer) null));
                } else if (SDKUtility.isBankOfferBottom().booleanValue()) {
                    this.bankOfferVisibility.set(8);
                    this.bankOfferBottomVisibility.set(0);
                    i iVar3 = this.bankOfferBottomText;
                    Context context4 = this.context;
                    iVar3.set(SDKUtility.getBankOfferText(context4, "₹ " + totalCashbackAmount + " cashback offer cannot be applied as EMI pay mode is selected", (ApplyPromoResponse.PaymentOffer) null));
                } else {
                    this.bankOfferBottomVisibility.set(8);
                    this.bankOfferVisibility.set(0);
                    i iVar4 = this.bankOfferText;
                    Context context5 = this.context;
                    iVar4.set(SDKUtility.getBankOfferText(context5, "₹ " + totalCashbackAmount + " cashback offer cannot be applied as EMI pay mode is selected", (ApplyPromoResponse.PaymentOffer) null));
                }
            }
        }
    }

    public void setSubventedEmi(boolean z) {
        this.isSubventedEmi = z;
    }

    public void setSubventedOfferText(String str) {
        this.isSubventedEmi = true;
        this.subventedOfferText = str;
    }

    private void showSubventedOffer() {
        this.subventionOfferText.set(this.subventedOfferText);
        this.subventionOfferVisibility.set(0);
    }

    private void hideSubventedOffer() {
        this.subventionOfferText.set(this.subventedOfferText);
        this.subventionOfferVisibility.set(8);
        this.appliedOffersVisibility.set(8);
    }

    public void updateSubventedOfferView() {
        if (TextUtils.isEmpty(this.subventedOfferText) || (!this.isEmiView && !this.isEmiEnabled)) {
            hideSubventedOffer();
        } else {
            showSubventedOffer();
        }
        if ((this.bankOfferVisibility.get() == 0 || this.bankOfferBottomVisibility.get() == 0) && !TextUtils.isEmpty(this.subventedOfferText)) {
            this.appliedOffersVisibility.set(0);
        } else {
            this.appliedOffersVisibility.set(8);
        }
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

    public boolean isToShowUpiConsent(String str) {
        return SDKUtils.isToShowUpiConsent(str);
    }

    public boolean isHybridDisabled() {
        return this.savedInstruments.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.savedInstruments.isEmiHybridDisabled();
    }
}
