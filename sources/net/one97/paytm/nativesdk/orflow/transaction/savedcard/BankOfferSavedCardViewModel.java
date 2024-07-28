package net.one97.paytm.nativesdk.orflow.transaction.savedcard;

import android.content.Context;
import android.text.SpannableString;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.savedCard.listeners.SavedCardClickListener;

public class BankOfferSavedCardViewModel extends BaseViewModel {
    public i<String> bankName;
    public i<SpannableString> bankOfferText = new i<>(new SpannableString(""));
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    public i<String> cardNumber;
    public ObservableBoolean cardSelected;
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    private ApplyPromoResponse.PaymentOffer hybridEmiPaymentOffer;
    private ApplyPromoResponse.PaymentOffer hybridPaymentOffer;
    public i<String> imageUrl;
    private boolean isCreditCardLayout;
    private boolean isEmiEnabled = false;
    private boolean isSelected = false;
    public ObservableBoolean isSingleVisaClickChecked = new ObservableBoolean(false);
    public ObservableInt lowSuccess;
    private Context mContext;
    private Double multiEmiNetAmount;
    public Double netPayableAmount = Double.valueOf(1.0d);
    private ApplyPromoResponse.PaymentOffer nonHybridEmiPaymentOffer;
    private ApplyPromoResponse.PaymentOffer nonHybridPaymentOffer;
    public i<String> offerApplicableText = new i<>("");
    public ObservableInt offerApplicationVisibility = new ObservableInt(8);
    public i<String> paySecurelyText = new i<>();
    private SavedCardClickListener savedCardClickListener;
    private SavedInstruments savedInstruments;
    public ObservableInt showVisaOneClick = new ObservableInt(8);

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public void getBankOffers() {
    }

    public BankOfferSavedCardViewModel(Context context, String str, String str2, String str3, SavedInstruments savedInstruments2, SavedCardClickListener savedCardClickListener2) {
        super(context, (BaseViewActions) null);
        this.savedInstruments = savedInstruments2;
        this.mContext = context;
        this.savedCardClickListener = savedCardClickListener2;
        this.cardNumber = new i<>(str);
        this.bankName = new i<>(str2);
        this.imageUrl = new i<>(str3);
        this.lowSuccess = new ObservableInt(8);
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.mContext));
        savedCardClickListener2.updateVisaSingleClickUI();
        showOfferAvailabilityInfo();
        this.isCreditCardLayout = savedInstruments2.getCardDetails().getCardType().contains(SDKConstants.CREDIT);
    }

    private void showOfferAvailabilityInfo() {
        if (getPaymentOffer() == null) {
            return;
        }
        if (getPaymentOffer().getTotalCashbackAmount() != null) {
            this.offerApplicationVisibility.set(0);
            i<String> iVar = this.offerApplicableText;
            iVar.set("Cashback offer applicable worth ₹ " + getPaymentOffer().getTotalCashbackAmount());
        } else if (getPaymentOffer().getTotalInstantDiscount() != null) {
            this.offerApplicationVisibility.set(0);
            i<String> iVar2 = this.offerApplicableText;
            iVar2.set("Instant offer applicable worth ₹ " + getPaymentOffer().getTotalInstantDiscount());
        } else {
            this.offerApplicationVisibility.set(8);
        }
    }

    private void hideOfferAvailabilityInfo() {
        this.offerApplicableText.set("");
        this.offerApplicationVisibility.set(8);
    }

    public void showBankOffers() {
        hideOfferAvailabilityInfo();
        if (getPaymentOffer() == null) {
            return;
        }
        if (getPaymentOffer().getTotalCashbackAmount() != null) {
            this.bankOfferVisibility.set(0);
            i<SpannableString> iVar = this.bankOfferText;
            Context context = this.mContext;
            iVar.set(SDKUtility.getBankOfferText(context, context.getResources().getString(R.string.nativesdk_cashback_applied_successfully, new Object[]{getPaymentOffer().getTotalCashbackAmount()}), getPaymentOffer()));
            this.cashBackTextVisibility.set(0);
            this.cashBackText.set(this.mContext.getResources().getString(R.string.nativesdk_effective_price, new Object[]{getPaymentOffer().getTotalCashbackAmount(), MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(getPaymentOffer().getTotalCashbackAmount()))}));
            this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.mContext));
            this.savedCardClickListener.updateVisaSingleClickUI();
        } else if (getPaymentOffer().getTotalInstantDiscount() != null) {
            this.bankOfferVisibility.set(0);
            i<SpannableString> iVar2 = this.bankOfferText;
            Context context2 = this.mContext;
            iVar2.set(SDKUtility.getBankOfferText(context2, context2.getResources().getString(R.string.nativesdk_instant_discount, new Object[]{getPaymentOffer().getTotalInstantDiscount()}), getPaymentOffer()));
            this.paySecurelyText.set(this.mContext.getResources().getString(R.string.nativesdk_amount_pay, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(getPaymentOffer().getTotalInstantDiscount()))}));
            this.savedCardClickListener.updateVisaSingleClickUI();
        } else {
            this.bankOfferVisibility.set(8);
        }
    }

    public void hideOffer() {
        showOfferAvailabilityInfo();
        this.bankOfferText.set(new SpannableString(""));
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.mContext));
        this.savedCardClickListener.updateVisaSingleClickUI();
        this.cashBackText.set("");
    }

    public void hybridCheckChanged() {
        if (this.isEmiEnabled) {
            if (!SDKUtility.isHybridCase()) {
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
            } else if (this.nonHybridEmiPaymentOffer == null) {
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
        } else if (!SDKUtility.isHybridCase()) {
            if (this.nonHybridPaymentOffer == null) {
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
        arrayList.add(offerBreakup);
        paymentOffer.setOfferBreakup(arrayList);
        return paymentOffer;
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        return this.isEmiEnabled ? SDKUtility.isHybridCase() ? this.hybridEmiPaymentOffer : this.nonHybridEmiPaymentOffer : SDKUtility.isHybridCase() ? this.hybridPaymentOffer : this.nonHybridPaymentOffer;
    }

    public void setEmiEnabled(boolean z) {
        this.isEmiEnabled = z;
        hideOfferAvailabilityInfo();
        hideOffer();
        getBankOffers();
    }

    public boolean isEmiEnabled() {
        return this.isEmiEnabled;
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

    public String getAmount() {
        if (getPaymentOffer() == null) {
            return MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getDiffAmount());
        }
        if (getPaymentOffer().getTotalCashbackAmount() != null) {
            return MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getDiffAmount());
        }
        if (getPaymentOffer().getTotalInstantDiscount() != null) {
            return MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(getPaymentOffer().getTotalInstantDiscount()));
        }
        return MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getDiffAmount());
    }
}
