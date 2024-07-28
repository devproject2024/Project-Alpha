package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.viewmodel.DebitCreditCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class DebitCreditCardLayoutBindingImpl extends DebitCreditCardLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private AfterTextChangedImpl1 mDebitCardModelCardNumberBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnCheckedChangeListenerImpl mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private OnClickListenerImpl4 mDebitCardModelCrossClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl2 mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl2 mDebitCardModelDebitCardViewClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl3 mDebitCardModelHelpClickedAndroidViewViewOnClickListener;
    private OnCheckedChangeListenerImpl1 mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private OnClickListenerImpl mDebitCardModelPaytWithNewDebitClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mDebitCardModelProceedClickedAndroidViewViewOnClickListener;
    private long mDirtyFlags;
    private final LinearLayout mboundView12;
    private final RoboTextView mboundView18;
    private final CheckBox mboundView25;
    private final FrameLayout mboundView31;
    private final TextView mboundView37;
    private final LinearLayout mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_promotion, 40);
        sViewsWithIds.put(R.id.ivRightArrow, 41);
        sViewsWithIds.put(R.id.card_container, 42);
        sViewsWithIds.put(R.id.selectBankLayout, 43);
        sViewsWithIds.put(R.id.txtEmiSelectBank, 44);
        sViewsWithIds.put(R.id.emi_saved_Cards_top_layout, 45);
        sViewsWithIds.put(R.id.emi_saved_Cards_container, 46);
        sViewsWithIds.put(R.id.ll_newCardLayout, 47);
        sViewsWithIds.put(R.id.tv_enter_card_number, 48);
        sViewsWithIds.put(R.id.tvExipary, 49);
        sViewsWithIds.put(R.id.tvCvv, 50);
        sViewsWithIds.put(R.id.txtSelectEmiPlan, 51);
        sViewsWithIds.put(R.id.tvUpiCheckbox, 52);
        sViewsWithIds.put(R.id.otpTopLayout, 53);
        sViewsWithIds.put(R.id.otp_cvv_layout, 54);
        sViewsWithIds.put(R.id.txtErrMsg, 55);
        sViewsWithIds.put(R.id.ltv_getOffers, 56);
        sViewsWithIds.put(R.id.ltv_loading, 57);
        sViewsWithIds.put(R.id.upiIcon, 58);
        sViewsWithIds.put(R.id.upiPayText, 59);
    }

    public DebitCreditCardLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 60, sIncludes, sViewsWithIds));
    }

    private DebitCreditCardLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 36, objArr[35], objArr[42], objArr[1], objArr[22], objArr[27], objArr[46], objArr[45], objArr[8], objArr[14], objArr[11], objArr[28], objArr[20], objArr[9], objArr[10], objArr[41], objArr[32], objArr[47], objArr[16], objArr[26], objArr[56], objArr[57], objArr[7], objArr[19], objArr[54], objArr[53], objArr[36], objArr[2], objArr[43], objArr[15], objArr[0], objArr[30], objArr[38], objArr[33], objArr[34], objArr[50], objArr[13], objArr[48], objArr[49], objArr[21], objArr[23], objArr[24], objArr[29], objArr[6], objArr[17], objArr[40], objArr[52], objArr[3], objArr[44], objArr[55], objArr[51], objArr[4], objArr[58], objArr[39], objArr[59]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.cardTextLayout.setTag((Object) null);
        this.cbOneClick.setTag((Object) null);
        this.cbUpiCheckbox.setTag((Object) null);
        this.etCardNumber.setTag((Object) null);
        this.etCvv.setTag((Object) null);
        this.etExpiryValidity.setTag((Object) null);
        this.etOtpCVV.setTag((Object) null);
        this.iconVscpInfo.setTag((Object) null);
        this.ivCardLogo.setTag((Object) null);
        this.ivCross.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llSaveCard.setTag((Object) null);
        this.llUpiCheckbox.setTag((Object) null);
        this.mboundView12 = objArr[12];
        this.mboundView12.setTag((Object) null);
        this.mboundView18 = objArr[18];
        this.mboundView18.setTag((Object) null);
        this.mboundView25 = objArr[25];
        this.mboundView25.setTag((Object) null);
        this.mboundView31 = objArr[31];
        this.mboundView31.setTag((Object) null);
        this.mboundView37 = objArr[37];
        this.mboundView37.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.newCardContainer.setTag((Object) null);
        this.oneClickContainer.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.radioButton.setTag((Object) null);
        this.selectEmiPlanLayout.setTag((Object) null);
        this.toplayout.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvBankOfferBottom.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvCvvHelp.setTag((Object) null);
        this.tvOneClickEnabled.setTag((Object) null);
        this.tvOneClickMsg.setTag((Object) null);
        this.tvOneClickViewDetails.setTag((Object) null);
        this.tvOtpCvvHelp.setTag((Object) null);
        this.tvPayWithNewDebitCard.setTag((Object) null);
        this.tvPromoMessage.setTag((Object) null);
        this.txtDebitCreditCard.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        this.upiPayOption.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 137438953472L;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.debitCardModel != i2) {
            return false;
        } else {
            setDebitCardModel((DebitCreditCardViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setDebitCardModel(DebitCreditCardViewModel debitCreditCardViewModel) {
        updateRegistration(12, (h) debitCreditCardViewModel);
        this.mDebitCardModel = debitCreditCardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.debitCardModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeDebitCardModelConvFeeTextGravity((ObservableInt) obj, i3);
            case 1:
                return onChangeDebitCardModelBankOfferVisibility((ObservableInt) obj, i3);
            case 2:
                return onChangeDebitCardModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 3:
                return onChangeDebitCardModelSelectEMIPlanVisibility((ObservableInt) obj, i3);
            case 4:
                return onChangeDebitCardModelCashBackText((i) obj, i3);
            case 5:
                return onChangeDebitCardModelCardImageVisibility((ObservableInt) obj, i3);
            case 6:
                return onChangeDebitCardModelEmiVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeDebitCardModelCrossVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeDebitCardModelUpiCheckboxVisibility((ObservableInt) obj, i3);
            case 9:
                return onChangeDebitCardModelUpiPayOptionVisibility((ObservableInt) obj, i3);
            case 10:
                return onChangeDebitCardModelPayWithDebitOrCreditCard((i) obj, i3);
            case 11:
                return onChangeDebitCardModelNewCardContainerVisibilty((ObservableInt) obj, i3);
            case 12:
                return onChangeDebitCardModel((DebitCreditCardViewModel) obj, i3);
            case 13:
                return onChangeDebitCardModelAmount((i) obj, i3);
            case 14:
                return onChangeDebitCardModelRadioChecked((ObservableBoolean) obj, i3);
            case 15:
                return onChangeDebitCardModelBankOfferBottomVisibility((ObservableInt) obj, i3);
            case 16:
                return onChangeDebitCardModelLowSuccessRateVisibility((ObservableInt) obj, i3);
            case 17:
                return onChangeDebitCardModelPaySecurelyText((i) obj, i3);
            case 18:
                return onChangeDebitCardModelPromoCodeVisibility((ObservableInt) obj, i3);
            case 19:
                return onChangeDebitCardModelIsSingleVisaClickChecked((ObservableBoolean) obj, i3);
            case 20:
                return onChangeDebitCardModelUpiConsentChecked((ObservableBoolean) obj, i3);
            case 21:
                return onChangeDebitCardModelConvFeeText((i) obj, i3);
            case 22:
                return onChangeDebitCardModelConvFeeTextVisibility((ObservableInt) obj, i3);
            case 23:
                return onChangeDebitCardModelLoaderMsg((i) obj, i3);
            case 24:
                return onChangeDebitCardModelPayWithNewDebitCardVisibility((ObservableInt) obj, i3);
            case 25:
                return onChangeDebitCardModelDebitCardOrCreditCard((i) obj, i3);
            case 26:
                return onChangeDebitCardModelLoaderVisibility((ObservableInt) obj, i3);
            case 27:
                return onChangeDebitCardModelIsVisaCardEnrolled((ObservableBoolean) obj, i3);
            case 28:
                return onChangeDebitCardModelAddMoneySaveCardVisibility((ObservableBoolean) obj, i3);
            case 29:
                return onChangeDebitCardModelBankOfferText((i) obj, i3);
            case 30:
                return onChangeDebitCardModelLowSuccessRateText((i) obj, i3);
            case 31:
                return onChangeDebitCardModelBankOfferBottomText((i) obj, i3);
            case 32:
                return onChangeDebitCardModelSavedCardCheckValue((ObservableBoolean) obj, i3);
            case 33:
                return onChangeDebitCardModelNewCardCVVVisibility((ObservableInt) obj, i3);
            case 34:
                return onChangeDebitCardModelShowVisaOneClick((ObservableInt) obj, i3);
            case 35:
                return onChangeDebitCardModelPromoCodeText((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeDebitCardModelConvFeeTextGravity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDebitCardModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDebitCardModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeDebitCardModelSelectEMIPlanVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeDebitCardModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeDebitCardModelCardImageVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeDebitCardModelEmiVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeDebitCardModelCrossVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeDebitCardModelUpiCheckboxVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeDebitCardModelUpiPayOptionVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPayWithDebitOrCreditCard(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeDebitCardModelNewCardContainerVisibilty(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeDebitCardModel(DebitCreditCardViewModel debitCreditCardViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeDebitCardModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeDebitCardModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeDebitCardModelBankOfferBottomVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLowSuccessRateVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPromoCodeVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeDebitCardModelIsSingleVisaClickChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeDebitCardModelUpiConsentChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeDebitCardModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeDebitCardModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPayWithNewDebitCardVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        return true;
    }

    private boolean onChangeDebitCardModelDebitCardOrCreditCard(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 33554432;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 67108864;
        }
        return true;
    }

    private boolean onChangeDebitCardModelIsVisaCardEnrolled(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 134217728;
        }
        return true;
    }

    private boolean onChangeDebitCardModelAddMoneySaveCardVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 268435456;
        }
        return true;
    }

    private boolean onChangeDebitCardModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 536870912;
        }
        return true;
    }

    private boolean onChangeDebitCardModelLowSuccessRateText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1073741824;
        }
        return true;
    }

    private boolean onChangeDebitCardModelBankOfferBottomText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2147483648L;
        }
        return true;
    }

    private boolean onChangeDebitCardModelSavedCardCheckValue(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4294967296L;
        }
        return true;
    }

    private boolean onChangeDebitCardModelNewCardCVVVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8589934592L;
        }
        return true;
    }

    private boolean onChangeDebitCardModelShowVisaOneClick(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 17179869184L;
        }
        return true;
    }

    private boolean onChangeDebitCardModelPromoCodeText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 34359738368L;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x023a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0490  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x05be  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x05ce  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x05e6  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x05f6  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x060c  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x061c  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x0642  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x065a  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x07f0  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0819  */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x083d  */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x084f  */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0894  */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x08ba  */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x08cc  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x08de  */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x08f0  */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0902  */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x090f  */
    /* JADX WARNING: Removed duplicated region for block: B:522:0x0921  */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x0933  */
    /* JADX WARNING: Removed duplicated region for block: B:528:0x0945  */
    /* JADX WARNING: Removed duplicated region for block: B:531:0x0957  */
    /* JADX WARNING: Removed duplicated region for block: B:534:0x0969  */
    /* JADX WARNING: Removed duplicated region for block: B:537:0x0976  */
    /* JADX WARNING: Removed duplicated region for block: B:540:0x0981  */
    /* JADX WARNING: Removed duplicated region for block: B:543:0x0991  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x09a3  */
    /* JADX WARNING: Removed duplicated region for block: B:549:0x09b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:552:0x09c7  */
    /* JADX WARNING: Removed duplicated region for block: B:555:0x09d9  */
    /* JADX WARNING: Removed duplicated region for block: B:558:0x09eb  */
    /* JADX WARNING: Removed duplicated region for block: B:561:0x09fd  */
    /* JADX WARNING: Removed duplicated region for block: B:564:0x0a0f  */
    /* JADX WARNING: Removed duplicated region for block: B:567:0x0a21  */
    /* JADX WARNING: Removed duplicated region for block: B:570:0x0a33  */
    /* JADX WARNING: Removed duplicated region for block: B:573:0x0a45  */
    /* JADX WARNING: Removed duplicated region for block: B:576:0x0a57  */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x0a69  */
    /* JADX WARNING: Removed duplicated region for block: B:582:0x0a7b  */
    /* JADX WARNING: Removed duplicated region for block: B:585:0x0a8d  */
    /* JADX WARNING: Removed duplicated region for block: B:588:0x0a9f  */
    /* JADX WARNING: Removed duplicated region for block: B:591:0x0ab1  */
    /* JADX WARNING: Removed duplicated region for block: B:594:0x0ac3  */
    /* JADX WARNING: Removed duplicated region for block: B:597:0x0ad5  */
    /* JADX WARNING: Removed duplicated region for block: B:600:0x0ae7  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0af9  */
    /* JADX WARNING: Removed duplicated region for block: B:606:0x0b0b  */
    /* JADX WARNING: Removed duplicated region for block: B:609:0x0b24  */
    /* JADX WARNING: Removed duplicated region for block: B:618:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r110 = this;
            r1 = r110
            monitor-enter(r110)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0b2c }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0b2c }
            monitor-exit(r110)     // Catch:{ all -> 0x0b2c }
            net.one97.paytm.nativesdk.instruments.debitCreditcard.viewmodel.DebitCreditCardViewModel r0 = r1.mDebitCardModel
            r6 = 206158430207(0x2fffffffff, double:1.01855797966E-312)
            long r6 = r6 & r2
            r8 = 137438957572(0x2000001004, double:6.79038673366E-313)
            r11 = 137438957570(0x2000001002, double:6.79038673356E-313)
            r15 = 137438957569(0x2000001001, double:6.7903867335E-313)
            r17 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
            r19 = 137707393024(0x2010001000, double:6.80364920715E-313)
            r21 = 137573175296(0x2008001000, double:6.7970179703E-313)
            r23 = 137510260736(0x2004401000, double:6.79390957803E-313)
            r25 = 154887262208(0x2410001000, double:7.65244752354E-313)
            r14 = 1
            r10 = 0
            int r31 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x072b
            long r6 = r2 & r15
            int r31 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x0048
            androidx.databinding.ObservableInt r6 = r0.convFeeTextGravity
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0053
            int r6 = r6.get()
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            long r31 = r2 & r11
            int r7 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x006a
            if (r0 == 0) goto L_0x005f
            androidx.databinding.ObservableInt r7 = r0.bankOfferVisibility
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x006a
            int r7 = r7.get()
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            long r31 = r2 & r8
            int r33 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x0082
            if (r0 == 0) goto L_0x0076
            androidx.databinding.ObservableInt r10 = r0.cashBackTextVisibility
            goto L_0x0077
        L_0x0076:
            r10 = 0
        L_0x0077:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0082
            int r10 = r10.get()
            goto L_0x0083
        L_0x0082:
            r10 = 0
        L_0x0083:
            r15 = 137438957576(0x2000001008, double:6.79038673385E-313)
            long r15 = r15 & r2
            int r34 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x009e
            if (r0 == 0) goto L_0x0092
            androidx.databinding.ObservableInt r15 = r0.selectEMIPlanVisibility
            goto L_0x0093
        L_0x0092:
            r15 = 0
        L_0x0093:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x009e
            int r11 = r15.get()
            goto L_0x009f
        L_0x009e:
            r11 = 0
        L_0x009f:
            r15 = 137438957584(0x2000001010, double:6.79038673425E-313)
            long r15 = r15 & r2
            int r12 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00bc
            if (r0 == 0) goto L_0x00ae
            androidx.databinding.i<java.lang.String> r12 = r0.cashBackText
            goto L_0x00af
        L_0x00ae:
            r12 = 0
        L_0x00af:
            r15 = 4
            r1.updateRegistration((int) r15, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00bc
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00bd
        L_0x00bc:
            r12 = 0
        L_0x00bd:
            r15 = 137438957600(0x2000001020, double:6.79038673504E-313)
            long r15 = r15 & r2
            int r35 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00d8
            if (r0 == 0) goto L_0x00cc
            androidx.databinding.ObservableInt r15 = r0.cardImageVisibility
            goto L_0x00cd
        L_0x00cc:
            r15 = 0
        L_0x00cd:
            r8 = 5
            r1.updateRegistration((int) r8, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00d8
            int r8 = r15.get()
            goto L_0x00d9
        L_0x00d8:
            r8 = 0
        L_0x00d9:
            r15 = 137438957632(0x2000001040, double:6.7903867366E-313)
            long r15 = r15 & r2
            int r9 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00f4
            if (r0 == 0) goto L_0x00e8
            androidx.databinding.ObservableInt r9 = r0.emiVisibility
            goto L_0x00e9
        L_0x00e8:
            r9 = 0
        L_0x00e9:
            r15 = 6
            r1.updateRegistration((int) r15, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x00f4
            int r9 = r9.get()
            goto L_0x00f5
        L_0x00f4:
            r9 = 0
        L_0x00f5:
            r15 = 137438957696(0x2000001080, double:6.7903867398E-313)
            long r15 = r15 & r2
            int r36 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x0110
            if (r0 == 0) goto L_0x0104
            androidx.databinding.ObservableInt r15 = r0.crossVisibility
            goto L_0x0105
        L_0x0104:
            r15 = 0
        L_0x0105:
            r13 = 7
            r1.updateRegistration((int) r13, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0110
            int r13 = r15.get()
            goto L_0x0111
        L_0x0110:
            r13 = 0
        L_0x0111:
            r36 = 137438957824(0x2000001100, double:6.7903867461E-313)
            long r36 = r2 & r36
            int r15 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0130
            if (r0 == 0) goto L_0x0123
            androidx.databinding.ObservableInt r15 = r0.upiCheckboxVisibility
            r14 = 8
            goto L_0x0126
        L_0x0123:
            r14 = 8
            r15 = 0
        L_0x0126:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0130
            int r14 = r15.get()
            goto L_0x0131
        L_0x0130:
            r14 = 0
        L_0x0131:
            r37 = 137438958080(0x2000001200, double:6.79038675875E-313)
            long r37 = r2 & r37
            int r15 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x014e
            if (r0 == 0) goto L_0x0141
            androidx.databinding.ObservableInt r15 = r0.upiPayOptionVisibility
            goto L_0x0142
        L_0x0141:
            r15 = 0
        L_0x0142:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x014e
            int r4 = r15.get()
            goto L_0x014f
        L_0x014e:
            r4 = 0
        L_0x014f:
            r39 = 137438958592(0x2000001400, double:6.79038678405E-313)
            long r39 = r2 & r39
            r37 = 0
            int r5 = (r39 > r37 ? 1 : (r39 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x0170
            if (r0 == 0) goto L_0x0161
            androidx.databinding.i<java.lang.String> r5 = r0.payWithDebitOrCreditCard
            goto L_0x0162
        L_0x0161:
            r5 = 0
        L_0x0162:
            r15 = 10
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0170
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0171
        L_0x0170:
            r5 = 0
        L_0x0171:
            r39 = 137438959616(0x2000001800, double:6.79038683464E-313)
            long r39 = r2 & r39
            r37 = 0
            int r15 = (r39 > r37 ? 1 : (r39 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x0194
            if (r0 == 0) goto L_0x0185
            androidx.databinding.ObservableInt r15 = r0.newCardContainerVisibilty
            r39 = r4
            goto L_0x0188
        L_0x0185:
            r39 = r4
            r15 = 0
        L_0x0188:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0196
            int r4 = r15.get()
            goto L_0x0197
        L_0x0194:
            r39 = r4
        L_0x0196:
            r4 = 0
        L_0x0197:
            r40 = 137438965760(0x2000003000, double:6.7903871382E-313)
            long r40 = r2 & r40
            r37 = 0
            int r15 = (r40 > r37 ? 1 : (r40 == r37 ? 0 : -1))
            r40 = r4
            if (r15 == 0) goto L_0x01dd
            if (r0 == 0) goto L_0x01ad
            androidx.databinding.i<java.lang.String> r4 = r0.amount
            r41 = r5
            goto L_0x01b0
        L_0x01ad:
            r41 = r5
            r4 = 0
        L_0x01b0:
            r5 = 13
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01be
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01bf
        L_0x01be:
            r4 = 0
        L_0x01bf:
            if (r4 == 0) goto L_0x01c6
            int r5 = r4.length()
            goto L_0x01c7
        L_0x01c6:
            r5 = 0
        L_0x01c7:
            if (r5 <= 0) goto L_0x01cb
            r5 = 1
            goto L_0x01cc
        L_0x01cb:
            r5 = 0
        L_0x01cc:
            if (r15 == 0) goto L_0x01d7
            if (r5 == 0) goto L_0x01d3
            r42 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            goto L_0x01d5
        L_0x01d3:
            r42 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
        L_0x01d5:
            long r2 = r2 | r42
        L_0x01d7:
            if (r5 == 0) goto L_0x01da
            goto L_0x01e0
        L_0x01da:
            r5 = 8
            goto L_0x01e1
        L_0x01dd:
            r41 = r5
            r4 = 0
        L_0x01e0:
            r5 = 0
        L_0x01e1:
            r42 = 137438973952(0x2000005000, double:6.79038754294E-313)
            long r42 = r2 & r42
            r37 = 0
            int r15 = (r42 > r37 ? 1 : (r42 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x0204
            if (r0 == 0) goto L_0x01f5
            androidx.databinding.ObservableBoolean r15 = r0.radioChecked
            r42 = r4
            goto L_0x01f8
        L_0x01f5:
            r42 = r4
            r15 = 0
        L_0x01f8:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0206
            boolean r4 = r15.get()
            goto L_0x0207
        L_0x0204:
            r42 = r4
        L_0x0206:
            r4 = 0
        L_0x0207:
            r43 = 137438990336(0x2000009000, double:6.7903883524E-313)
            long r43 = r2 & r43
            r37 = 0
            int r15 = (r43 > r37 ? 1 : (r43 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x022a
            if (r0 == 0) goto L_0x021b
            androidx.databinding.ObservableInt r15 = r0.bankOfferBottomVisibility
            r43 = r4
            goto L_0x021e
        L_0x021b:
            r43 = r4
            r15 = 0
        L_0x021e:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x022c
            int r4 = r15.get()
            goto L_0x022d
        L_0x022a:
            r43 = r4
        L_0x022c:
            r4 = 0
        L_0x022d:
            r44 = 137438957568(0x2000001000, double:6.79038673346E-313)
            long r44 = r2 & r44
            r37 = 0
            int r15 = (r44 > r37 ? 1 : (r44 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x02e5
            if (r0 == 0) goto L_0x02e5
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl r15 = r1.mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r15 != 0) goto L_0x0247
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl r15 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl
            r15.<init>()
            r1.mDebitCardModelCheckBoxChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r15
        L_0x0247:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl r15 = r15.setValue(r0)
            r44 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl r4 = r1.mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r4 != 0) goto L_0x0258
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl
            r4.<init>()
            r1.mDebitCardModelExpiryBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r4
        L_0x0258:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl r4 = r4.setValue(r0)
            r45 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl1 r4 = r1.mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r4 != 0) goto L_0x0269
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl1 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl1
            r4.<init>()
            r1.mDebitCardModelOneClickChangedAndroidWidgetCompoundButtonOnCheckedChangeListener = r4
        L_0x0269:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnCheckedChangeListenerImpl1 r4 = r4.setValue(r0)
            r46 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl r4 = r1.mDebitCardModelPaytWithNewDebitClickedAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x027a
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl
            r4.<init>()
            r1.mDebitCardModelPaytWithNewDebitClickedAndroidViewViewOnClickListener = r4
        L_0x027a:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl r4 = r4.setValue(r0)
            r47 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl1 r4 = r1.mDebitCardModelProceedClickedAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x028b
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl1 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl1
            r4.<init>()
            r1.mDebitCardModelProceedClickedAndroidViewViewOnClickListener = r4
        L_0x028b:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl1 r4 = r4.setValue(r0)
            r48 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl1 r4 = r1.mDebitCardModelCardNumberBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r4 != 0) goto L_0x029c
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl1 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl1
            r4.<init>()
            r1.mDebitCardModelCardNumberBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r4
        L_0x029c:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl1 r4 = r4.setValue(r0)
            r49 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl2 r4 = r1.mDebitCardModelDebitCardViewClickedAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x02ad
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl2 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl2
            r4.<init>()
            r1.mDebitCardModelDebitCardViewClickedAndroidViewViewOnClickListener = r4
        L_0x02ad:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl2 r4 = r4.setValue(r0)
            r50 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl3 r4 = r1.mDebitCardModelHelpClickedAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x02be
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl3 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl3
            r4.<init>()
            r1.mDebitCardModelHelpClickedAndroidViewViewOnClickListener = r4
        L_0x02be:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl3 r4 = r4.setValue(r0)
            r51 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl2 r4 = r1.mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r4 != 0) goto L_0x02cf
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl2 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl2
            r4.<init>()
            r1.mDebitCardModelCvvBeforeTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r4
        L_0x02cf:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$AfterTextChangedImpl2 r4 = r4.setValue(r0)
            r52 = r4
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl4 r4 = r1.mDebitCardModelCrossClickedAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x02e0
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl4 r4 = new net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl4
            r4.<init>()
            r1.mDebitCardModelCrossClickedAndroidViewViewOnClickListener = r4
        L_0x02e0:
            net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl$OnClickListenerImpl4 r4 = r4.setValue(r0)
            goto L_0x02f9
        L_0x02e5:
            r44 = r4
            r4 = 0
            r15 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
        L_0x02f9:
            r53 = 137439023104(0x2000011000, double:6.79038997137E-313)
            long r53 = r2 & r53
            r37 = 0
            int r55 = (r53 > r37 ? 1 : (r53 == r37 ? 0 : -1))
            r53 = r4
            if (r55 == 0) goto L_0x031e
            if (r0 == 0) goto L_0x030f
            androidx.databinding.ObservableInt r4 = r0.lowSuccessRateVisibility
            r54 = r5
            goto L_0x0312
        L_0x030f:
            r54 = r5
            r4 = 0
        L_0x0312:
            r5 = 16
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0320
            int r4 = r4.get()
            goto L_0x0321
        L_0x031e:
            r54 = r5
        L_0x0320:
            r4 = 0
        L_0x0321:
            r55 = 137439088640(0x2000021000, double:6.7903932093E-313)
            long r55 = r2 & r55
            r37 = 0
            int r5 = (r55 > r37 ? 1 : (r55 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x0346
            if (r0 == 0) goto L_0x0335
            androidx.databinding.i<java.lang.String> r5 = r0.paySecurelyText
            r55 = r4
            goto L_0x0338
        L_0x0335:
            r55 = r4
            r5 = 0
        L_0x0338:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0348
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0349
        L_0x0346:
            r55 = r4
        L_0x0348:
            r4 = 0
        L_0x0349:
            r56 = 137439219712(0x2000041000, double:6.7903996851E-313)
            long r56 = r2 & r56
            r37 = 0
            int r5 = (r56 > r37 ? 1 : (r56 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x036c
            if (r0 == 0) goto L_0x035d
            androidx.databinding.ObservableInt r5 = r0.promoCodeVisibility
            r56 = r4
            goto L_0x0360
        L_0x035d:
            r56 = r4
            r5 = 0
        L_0x0360:
            r4 = 18
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x036e
            int r4 = r5.get()
            goto L_0x036f
        L_0x036c:
            r56 = r4
        L_0x036e:
            r4 = 0
        L_0x036f:
            r57 = 137439481856(0x2000081000, double:6.79041263673E-313)
            long r57 = r2 & r57
            r37 = 0
            int r5 = (r57 > r37 ? 1 : (r57 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x0392
            if (r0 == 0) goto L_0x0383
            androidx.databinding.ObservableBoolean r5 = r0.isSingleVisaClickChecked
            r57 = r4
            goto L_0x0386
        L_0x0383:
            r57 = r4
            r5 = 0
        L_0x0386:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0394
            boolean r4 = r5.get()
            goto L_0x0395
        L_0x0392:
            r57 = r4
        L_0x0394:
            r4 = 0
        L_0x0395:
            r58 = 137440006144(0x2000101000, double:6.79043854E-313)
            long r58 = r2 & r58
            r37 = 0
            int r5 = (r58 > r37 ? 1 : (r58 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x03b8
            if (r0 == 0) goto L_0x03a9
            androidx.databinding.ObservableBoolean r5 = r0.upiConsentChecked
            r58 = r4
            goto L_0x03ac
        L_0x03a9:
            r58 = r4
            r5 = 0
        L_0x03ac:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x03ba
            boolean r4 = r5.get()
            goto L_0x03bb
        L_0x03b8:
            r58 = r4
        L_0x03ba:
            r4 = 0
        L_0x03bb:
            r59 = 137441054720(0x2000201000, double:6.79049034653E-313)
            long r59 = r2 & r59
            r37 = 0
            int r5 = (r59 > r37 ? 1 : (r59 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x03e0
            if (r0 == 0) goto L_0x03cf
            androidx.databinding.i<android.text.SpannableString> r5 = r0.convFeeText
            r59 = r4
            goto L_0x03d2
        L_0x03cf:
            r59 = r4
            r5 = 0
        L_0x03d2:
            r4 = 21
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x03e2
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x03e3
        L_0x03e0:
            r59 = r4
        L_0x03e2:
            r4 = 0
        L_0x03e3:
            r60 = 137443151872(0x2000401000, double:6.7905939596E-313)
            long r60 = r2 & r60
            r37 = 0
            int r5 = (r60 > r37 ? 1 : (r60 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x040a
            if (r0 == 0) goto L_0x03f9
            androidx.databinding.ObservableInt r5 = r0.convFeeTextVisibility
            r60 = r4
            r4 = 22
            goto L_0x03fe
        L_0x03f9:
            r60 = r4
            r4 = 22
            r5 = 0
        L_0x03fe:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0408
            int r4 = r5.get()
            goto L_0x040e
        L_0x0408:
            r4 = 0
            goto L_0x040e
        L_0x040a:
            r60 = r4
            r4 = 0
            r5 = 0
        L_0x040e:
            r61 = 137447346176(0x2000801000, double:6.79080118576E-313)
            long r61 = r2 & r61
            r37 = 0
            int r63 = (r61 > r37 ? 1 : (r61 == r37 ? 0 : -1))
            r61 = r4
            if (r63 == 0) goto L_0x0435
            if (r0 == 0) goto L_0x0424
            androidx.databinding.i<java.lang.String> r4 = r0.loaderMsg
            r62 = r5
            goto L_0x0427
        L_0x0424:
            r62 = r5
            r4 = 0
        L_0x0427:
            r5 = 23
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0437
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0438
        L_0x0435:
            r62 = r5
        L_0x0437:
            r4 = 0
        L_0x0438:
            r63 = 137455734784(0x2001001000, double:6.79121563806E-313)
            long r63 = r2 & r63
            r37 = 0
            int r5 = (r63 > r37 ? 1 : (r63 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x045b
            if (r0 == 0) goto L_0x044c
            androidx.databinding.ObservableInt r5 = r0.payWithNewDebitCardVisibility
            r63 = r4
            goto L_0x044f
        L_0x044c:
            r63 = r4
            r5 = 0
        L_0x044f:
            r4 = 24
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x045d
            int r4 = r5.get()
            goto L_0x045e
        L_0x045b:
            r63 = r4
        L_0x045d:
            r4 = 0
        L_0x045e:
            r64 = 137472512000(0x2002001000, double:6.79204454267E-313)
            long r64 = r2 & r64
            r37 = 0
            int r5 = (r64 > r37 ? 1 : (r64 == r37 ? 0 : -1))
            if (r5 == 0) goto L_0x0483
            if (r0 == 0) goto L_0x0472
            androidx.databinding.i<java.lang.String> r5 = r0.debitCardOrCreditCard
            r64 = r4
            goto L_0x0475
        L_0x0472:
            r64 = r4
            r5 = 0
        L_0x0475:
            r4 = 25
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0485
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0486
        L_0x0483:
            r64 = r4
        L_0x0485:
            r4 = 0
        L_0x0486:
            long r65 = r2 & r23
            r37 = 0
            int r5 = (r65 > r37 ? 1 : (r65 == r37 ? 0 : -1))
            r65 = r4
            if (r5 == 0) goto L_0x04b8
            if (r0 == 0) goto L_0x0497
            androidx.databinding.ObservableInt r4 = r0.loaderVisibility
            r66 = r6
            goto L_0x049a
        L_0x0497:
            r66 = r6
            r4 = 0
        L_0x049a:
            r6 = 26
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x04a6
            int r4 = r4.get()
            goto L_0x04a7
        L_0x04a6:
            r4 = 0
        L_0x04a7:
            if (r4 != 0) goto L_0x04ab
            r6 = 1
            goto L_0x04ac
        L_0x04ab:
            r6 = 0
        L_0x04ac:
            if (r5 == 0) goto L_0x04bc
            if (r6 == 0) goto L_0x04b5
            r67 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
            long r2 = r2 | r67
            goto L_0x04bc
        L_0x04b5:
            long r2 = r2 | r17
            goto L_0x04bc
        L_0x04b8:
            r66 = r6
            r4 = 0
            r6 = 0
        L_0x04bc:
            long r67 = r2 & r21
            r37 = 0
            int r5 = (r67 > r37 ? 1 : (r67 == r37 ? 0 : -1))
            r67 = r4
            if (r5 == 0) goto L_0x0516
            if (r0 == 0) goto L_0x04cd
            androidx.databinding.ObservableBoolean r4 = r0.isVisaCardEnrolled
            r68 = r6
            goto L_0x04d0
        L_0x04cd:
            r68 = r6
            r4 = 0
        L_0x04d0:
            r6 = 27
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x04dc
            boolean r4 = r4.get()
            goto L_0x04dd
        L_0x04dc:
            r4 = 0
        L_0x04dd:
            r6 = r4 ^ 1
            r69 = r7
            r7 = 1
            if (r4 != r7) goto L_0x04e6
            r4 = 1
            goto L_0x04e7
        L_0x04e6:
            r4 = 0
        L_0x04e7:
            if (r5 == 0) goto L_0x04f8
            if (r6 == 0) goto L_0x04f1
            r70 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x04f6
        L_0x04f1:
            r70 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x04f6:
            long r2 = r2 | r70
        L_0x04f8:
            long r70 = r2 & r21
            r36 = 0
            int r5 = (r70 > r36 ? 1 : (r70 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x0509
            if (r4 == 0) goto L_0x0505
            r70 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
            goto L_0x0507
        L_0x0505:
            r70 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
        L_0x0507:
            long r2 = r2 | r70
        L_0x0509:
            if (r6 == 0) goto L_0x050e
            r5 = 8
            goto L_0x050f
        L_0x050e:
            r5 = 0
        L_0x050f:
            if (r4 == 0) goto L_0x0514
            r4 = 8
            goto L_0x051d
        L_0x0514:
            r4 = 0
            goto L_0x051d
        L_0x0516:
            r68 = r6
            r69 = r7
            r7 = 1
            r4 = 0
            r5 = 0
        L_0x051d:
            long r70 = r2 & r25
            r36 = 0
            int r6 = (r70 > r36 ? 1 : (r70 == r36 ? 0 : -1))
            if (r6 == 0) goto L_0x056d
            if (r0 == 0) goto L_0x052c
            androidx.databinding.ObservableBoolean r7 = r0.addMoneySaveCardVisibility
            r70 = r4
            goto L_0x052f
        L_0x052c:
            r70 = r4
            r7 = 0
        L_0x052f:
            r4 = 28
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x053b
            boolean r4 = r7.get()
            goto L_0x053c
        L_0x053b:
            r4 = 0
        L_0x053c:
            if (r6 == 0) goto L_0x054c
            if (r4 == 0) goto L_0x0546
            r6 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            goto L_0x054b
        L_0x0546:
            r6 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
        L_0x054b:
            long r2 = r2 | r6
        L_0x054c:
            long r6 = r2 & r19
            r37 = 0
            int r71 = (r6 > r37 ? 1 : (r6 == r37 ? 0 : -1))
            if (r71 == 0) goto L_0x0562
            if (r4 == 0) goto L_0x055c
            r6 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x0561
        L_0x055c:
            r6 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x0561:
            long r2 = r2 | r6
        L_0x0562:
            long r6 = r2 & r19
            int r71 = (r6 > r37 ? 1 : (r6 == r37 ? 0 : -1))
            if (r71 == 0) goto L_0x0572
            if (r4 == 0) goto L_0x0572
            r6 = 8
            goto L_0x0573
        L_0x056d:
            r70 = r4
            r37 = 0
            r4 = 0
        L_0x0572:
            r6 = 0
        L_0x0573:
            r71 = 137975828480(0x2020001000, double:6.81691168085E-313)
            long r71 = r2 & r71
            int r7 = (r71 > r37 ? 1 : (r71 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x0596
            if (r0 == 0) goto L_0x0585
            androidx.databinding.i r7 = r0.bankOfferText
            r71 = r4
            goto L_0x0588
        L_0x0585:
            r71 = r4
            r7 = 0
        L_0x0588:
            r4 = 29
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0598
            java.lang.Object r4 = r7.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x0599
        L_0x0596:
            r71 = r4
        L_0x0598:
            r4 = 0
        L_0x0599:
            r72 = 138512699392(0x2040001000, double:6.84343662823E-313)
            long r72 = r2 & r72
            r37 = 0
            int r7 = (r72 > r37 ? 1 : (r72 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x05be
            if (r0 == 0) goto L_0x05ad
            androidx.databinding.i<java.lang.String> r7 = r0.lowSuccessRateText
            r72 = r4
            goto L_0x05b0
        L_0x05ad:
            r72 = r4
            r7 = 0
        L_0x05b0:
            r4 = 30
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x05c0
            java.lang.Object r4 = r7.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x05c1
        L_0x05be:
            r72 = r4
        L_0x05c0:
            r4 = 0
        L_0x05c1:
            r73 = 139586441216(0x2080001000, double:6.896486523E-313)
            long r73 = r2 & r73
            r37 = 0
            int r7 = (r73 > r37 ? 1 : (r73 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x05e6
            if (r0 == 0) goto L_0x05d5
            androidx.databinding.i r7 = r0.bankOfferBottomText
            r73 = r4
            goto L_0x05d8
        L_0x05d5:
            r73 = r4
            r7 = 0
        L_0x05d8:
            r4 = 31
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x05e8
            java.lang.Object r4 = r7.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x05e9
        L_0x05e6:
            r73 = r4
        L_0x05e8:
            r4 = 0
        L_0x05e9:
            r74 = 141733924864(0x2100001000, double:7.00258631255E-313)
            long r74 = r2 & r74
            r37 = 0
            int r7 = (r74 > r37 ? 1 : (r74 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x060c
            if (r0 == 0) goto L_0x05fd
            androidx.databinding.ObservableBoolean r7 = r0.savedCardCheckValue
            r74 = r4
            goto L_0x0600
        L_0x05fd:
            r74 = r4
            r7 = 0
        L_0x0600:
            r4 = 32
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x060e
            boolean r4 = r7.get()
            goto L_0x060f
        L_0x060c:
            r74 = r4
        L_0x060e:
            r4 = 0
        L_0x060f:
            r75 = 146028892160(0x2200001000, double:7.21478589165E-313)
            long r75 = r2 & r75
            r37 = 0
            int r7 = (r75 > r37 ? 1 : (r75 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x0632
            if (r0 == 0) goto L_0x0623
            androidx.databinding.ObservableInt r7 = r0.newCardCVVVisibility
            r75 = r4
            goto L_0x0626
        L_0x0623:
            r75 = r4
            r7 = 0
        L_0x0626:
            r4 = 33
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0634
            int r4 = r7.get()
            goto L_0x0635
        L_0x0632:
            r75 = r4
        L_0x0634:
            r4 = 0
        L_0x0635:
            r76 = 154618826752(0x2400001000, double:7.63918504984E-313)
            long r76 = r2 & r76
            r37 = 0
            int r7 = (r76 > r37 ? 1 : (r76 == r37 ? 0 : -1))
            if (r7 == 0) goto L_0x065a
            if (r0 == 0) goto L_0x0649
            androidx.databinding.ObservableInt r7 = r0.showVisaOneClick
            r76 = r4
            goto L_0x064c
        L_0x0649:
            r76 = r4
            r7 = 0
        L_0x064c:
            r4 = 34
            r1.updateRegistration((int) r4, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0658
            int r4 = r7.get()
            goto L_0x065e
        L_0x0658:
            r4 = 0
            goto L_0x065e
        L_0x065a:
            r76 = r4
            r4 = 0
            r7 = 0
        L_0x065e:
            r77 = 171798695936(0x2800001000, double:8.48798336623E-313)
            long r77 = r2 & r77
            r37 = 0
            int r79 = (r77 > r37 ? 1 : (r77 == r37 ? 0 : -1))
            r77 = r2
            if (r79 == 0) goto L_0x06cf
            if (r0 == 0) goto L_0x0672
            androidx.databinding.i<java.lang.String> r2 = r0.promoCodeText
            goto L_0x0673
        L_0x0672:
            r2 = 0
        L_0x0673:
            r3 = 35
            r1.updateRegistration((int) r3, (androidx.databinding.h) r2)
            if (r2 == 0) goto L_0x06cf
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            r104 = r2
            r82 = r6
            r90 = r9
            r88 = r10
            r94 = r11
            r89 = r12
            r80 = r13
            r83 = r14
            r109 = r39
            r91 = r40
            r102 = r41
            r107 = r42
            r93 = r43
            r98 = r44
            r3 = r45
            r6 = r47
            r9 = r48
            r2 = r50
            r10 = r51
            r12 = r52
            r14 = r53
            r108 = r54
            r86 = r55
            r92 = r56
            r105 = r57
            r13 = r59
            r100 = r60
            r99 = r63
            r103 = r64
            r106 = r65
            r101 = r66
            r81 = r67
            r96 = r69
            r11 = r70
            r95 = r72
            r85 = r73
            r97 = r74
            r87 = r75
            r84 = r76
            goto L_0x071d
        L_0x06cf:
            r82 = r6
            r90 = r9
            r88 = r10
            r94 = r11
            r89 = r12
            r80 = r13
            r83 = r14
            r109 = r39
            r91 = r40
            r102 = r41
            r107 = r42
            r93 = r43
            r98 = r44
            r3 = r45
            r6 = r47
            r9 = r48
            r2 = r50
            r10 = r51
            r12 = r52
            r14 = r53
            r108 = r54
            r86 = r55
            r92 = r56
            r105 = r57
            r13 = r59
            r100 = r60
            r99 = r63
            r103 = r64
            r106 = r65
            r101 = r66
            r81 = r67
            r96 = r69
            r11 = r70
            r95 = r72
            r85 = r73
            r97 = r74
            r87 = r75
            r84 = r76
            r104 = 0
        L_0x071d:
            r39 = r4
            r40 = r7
            r41 = r8
            r7 = r49
            r4 = r58
            r8 = r5
            r5 = r46
            goto L_0x0785
        L_0x072b:
            r77 = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r61 = 0
            r62 = 0
            r68 = 0
            r71 = 0
            r80 = 0
            r81 = 0
            r82 = 0
            r83 = 0
            r84 = 0
            r85 = 0
            r86 = 0
            r87 = 0
            r88 = 0
            r89 = 0
            r90 = 0
            r91 = 0
            r92 = 0
            r93 = 0
            r94 = 0
            r95 = 0
            r96 = 0
            r97 = 0
            r98 = 0
            r99 = 0
            r100 = 0
            r101 = 0
            r102 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r107 = 0
            r108 = 0
            r109 = 0
        L_0x0785:
            long r17 = r77 & r17
            r37 = 0
            int r42 = (r17 > r37 ? 1 : (r17 == r37 ? 0 : -1))
            if (r42 == 0) goto L_0x07ad
            r17 = r13
            if (r0 == 0) goto L_0x0796
            androidx.databinding.ObservableInt r13 = r0.convFeeTextVisibility
            r18 = r4
            goto L_0x079a
        L_0x0796:
            r18 = r4
            r13 = r62
        L_0x079a:
            r4 = 22
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x07a5
            int r61 = r13.get()
        L_0x07a5:
            if (r61 != 0) goto L_0x07a9
            r4 = 1
            goto L_0x07aa
        L_0x07a9:
            r4 = 0
        L_0x07aa:
            r13 = r61
            goto L_0x07b4
        L_0x07ad:
            r18 = r4
            r17 = r13
            r13 = r61
            r4 = 0
        L_0x07b4:
            r27 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            long r27 = r77 & r27
            r37 = 0
            int r29 = (r27 > r37 ? 1 : (r27 == r37 ? 0 : -1))
            if (r29 == 0) goto L_0x07e0
            if (r0 == 0) goto L_0x07c8
            androidx.databinding.ObservableInt r0 = r0.showVisaOneClick
            r27 = r4
            goto L_0x07cc
        L_0x07c8:
            r27 = r4
            r0 = r40
        L_0x07cc:
            r4 = 34
            r1.updateRegistration((int) r4, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x07d7
            int r39 = r0.get()
        L_0x07d7:
            r0 = r39
            r4 = 8
            if (r0 != r4) goto L_0x07e6
            r28 = 1
            goto L_0x07e8
        L_0x07e0:
            r27 = r4
            r4 = 8
            r0 = r39
        L_0x07e6:
            r28 = 0
        L_0x07e8:
            long r29 = r77 & r25
            r37 = 0
            int r39 = (r29 > r37 ? 1 : (r29 == r37 ? 0 : -1))
            if (r39 == 0) goto L_0x0810
            if (r71 == 0) goto L_0x07f3
            goto L_0x07f5
        L_0x07f3:
            r28 = 0
        L_0x07f5:
            if (r39 == 0) goto L_0x0806
            if (r28 == 0) goto L_0x07ff
            r29 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x0804
        L_0x07ff:
            r29 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x0804:
            long r77 = r77 | r29
        L_0x0806:
            if (r28 == 0) goto L_0x080b
            r28 = 0
            goto L_0x080d
        L_0x080b:
            r28 = 8
        L_0x080d:
            r4 = r28
            goto L_0x0811
        L_0x0810:
            r4 = 0
        L_0x0811:
            long r28 = r77 & r23
            r37 = 0
            int r39 = (r28 > r37 ? 1 : (r28 == r37 ? 0 : -1))
            if (r39 == 0) goto L_0x083d
            if (r68 == 0) goto L_0x081e
            r36 = 1
            goto L_0x0820
        L_0x081e:
            r36 = r27
        L_0x0820:
            if (r39 == 0) goto L_0x0831
            if (r36 == 0) goto L_0x082a
            r27 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x082f
        L_0x082a:
            r27 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x082f:
            long r77 = r77 | r27
        L_0x0831:
            if (r36 == 0) goto L_0x0836
            r31 = 0
            goto L_0x0838
        L_0x0836:
            r31 = 8
        L_0x0838:
            r27 = r13
            r13 = r31
            goto L_0x0840
        L_0x083d:
            r27 = r13
            r13 = 0
        L_0x0840:
            r28 = 137438957568(0x2000001000, double:6.79038673346E-313)
            long r28 = r77 & r28
            r30 = 0
            int r36 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            r28 = r0
            if (r36 == 0) goto L_0x088c
            android.widget.RelativeLayout r0 = r1.btnProceed
            r0.setOnClickListener(r9)
            android.widget.RelativeLayout r0 = r1.cardTextLayout
            r0.setOnClickListener(r2)
            android.widget.CheckBox r0 = r1.cbOneClick
            r0.setOnCheckedChangeListener(r5)
            android.widget.EditText r0 = r1.etCardNumber
            r2 = 0
            androidx.databinding.a.d.a(r0, r2, r7, r2)
            android.widget.EditText r0 = r1.etCvv
            androidx.databinding.a.d.a(r0, r2, r12, r2)
            android.widget.EditText r0 = r1.etExpiryValidity
            androidx.databinding.a.d.a(r0, r2, r3, r2)
            android.widget.EditText r0 = r1.etOtpCVV
            androidx.databinding.a.d.a(r0, r2, r12, r2)
            android.widget.ImageView r0 = r1.ivCross
            r0.setOnClickListener(r14)
            android.widget.CheckBox r0 = r1.mboundView25
            r0.setOnCheckedChangeListener(r15)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvCvvHelp
            r0.setOnClickListener(r10)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvOtpCvvHelp
            r0.setOnClickListener(r10)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPayWithNewDebitCard
            r0.setOnClickListener(r6)
        L_0x088c:
            long r2 = r77 & r21
            r5 = 0
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x08ad
            android.widget.CheckBox r0 = r1.cbOneClick
            r0.setVisibility(r11)
            android.widget.ImageView r0 = r1.iconVscpInfo
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.tvOneClickEnabled
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.tvOneClickMsg
            r0.setVisibility(r11)
            android.widget.TextView r0 = r1.tvOneClickViewDetails
            r0.setVisibility(r11)
        L_0x08ad:
            r2 = 137439481856(0x2000081000, double:6.79041263673E-313)
            long r2 = r77 & r2
            r5 = 0
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x08c1
            android.widget.CheckBox r0 = r1.cbOneClick
            r2 = r18
            androidx.databinding.a.a.a(r0, r2)
        L_0x08c1:
            r2 = 137440006144(0x2000101000, double:6.79043854E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x08d3
            android.widget.CheckBox r0 = r1.cbUpiCheckbox
            r2 = r17
            androidx.databinding.a.a.a(r0, r2)
        L_0x08d3:
            r2 = 137438957600(0x2000001020, double:6.79038673504E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x08e5
            android.widget.ImageView r0 = r1.ivCardLogo
            r8 = r41
            r0.setVisibility(r8)
        L_0x08e5:
            r2 = 137438957696(0x2000001080, double:6.7903867398E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x08f7
            android.widget.ImageView r0 = r1.ivCross
            r2 = r80
            r0.setVisibility(r2)
        L_0x08f7:
            r2 = 137506066432(0x2004001000, double:6.7937023519E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0909
            android.widget.LinearLayout r0 = r1.llCheckOffer
            r2 = r81
            r0.setVisibility(r2)
        L_0x0909:
            long r2 = r77 & r19
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0916
            android.widget.LinearLayout r0 = r1.llSaveCard
            r2 = r82
            r0.setVisibility(r2)
        L_0x0916:
            r2 = 137438957824(0x2000001100, double:6.7903867461E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0928
            android.widget.LinearLayout r0 = r1.llUpiCheckbox
            r14 = r83
            r0.setVisibility(r14)
        L_0x0928:
            r2 = 146028892160(0x2200001000, double:7.21478589165E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x093a
            android.widget.LinearLayout r0 = r1.mboundView12
            r2 = r84
            r0.setVisibility(r2)
        L_0x093a:
            r2 = 138512699392(0x2040001000, double:6.84343662823E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x094c
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.mboundView18
            r2 = r85
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x094c:
            r2 = 137439023104(0x2000011000, double:6.79038997137E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x095e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.mboundView18
            r2 = r86
            r0.setVisibility(r2)
        L_0x095e:
            r2 = 141733924864(0x2100001000, double:7.00258631255E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0970
            android.widget.CheckBox r0 = r1.mboundView25
            r2 = r87
            androidx.databinding.a.a.a(r0, r2)
        L_0x0970:
            long r2 = r77 & r25
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x097b
            android.widget.CheckBox r0 = r1.mboundView25
            r0.setVisibility(r4)
        L_0x097b:
            long r2 = r77 & r23
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0986
            android.widget.FrameLayout r0 = r1.mboundView31
            r0.setVisibility(r13)
        L_0x0986:
            r2 = 137438957572(0x2000001004, double:6.79038673366E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0998
            android.widget.TextView r0 = r1.mboundView37
            r10 = r88
            r0.setVisibility(r10)
        L_0x0998:
            r2 = 137438957584(0x2000001010, double:6.79038673425E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x09aa
            android.widget.TextView r0 = r1.mboundView37
            r12 = r89
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x09aa:
            r2 = 137438957632(0x2000001040, double:6.7903867366E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x09bc
            android.widget.LinearLayout r0 = r1.mboundView5
            r9 = r90
            r0.setVisibility(r9)
        L_0x09bc:
            r2 = 137438959616(0x2000001800, double:6.79038683464E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x09ce
            android.widget.LinearLayout r0 = r1.newCardContainer
            r2 = r91
            r0.setVisibility(r2)
        L_0x09ce:
            r2 = 154618826752(0x2400001000, double:7.63918504984E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x09e0
            android.widget.RelativeLayout r0 = r1.oneClickContainer
            r2 = r28
            r0.setVisibility(r2)
        L_0x09e0:
            r2 = 137439088640(0x2000021000, double:6.7903932093E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x09f2
            android.widget.TextView r0 = r1.paysecurely
            r2 = r92
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x09f2:
            r2 = 137438973952(0x2000005000, double:6.79038754294E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a04
            android.widget.RadioButton r0 = r1.radioButton
            r2 = r93
            androidx.databinding.a.a.a(r0, r2)
        L_0x0a04:
            r2 = 137438957576(0x2000001008, double:6.79038673385E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a16
            android.widget.RelativeLayout r0 = r1.selectEmiPlanLayout
            r11 = r94
            r0.setVisibility(r11)
        L_0x0a16:
            r2 = 137975828480(0x2020001000, double:6.81691168085E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a28
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r2 = r95
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0a28:
            r2 = 137438957570(0x2000001002, double:6.79038673356E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a3a
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r2 = r96
            r0.setVisibility(r2)
        L_0x0a3a:
            r2 = 139586441216(0x2080001000, double:6.896486523E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a4c
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOfferBottom
            r2 = r97
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0a4c:
            r2 = 137438990336(0x2000009000, double:6.7903883524E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a5e
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOfferBottom
            r2 = r98
            r0.setVisibility(r2)
        L_0x0a5e:
            r2 = 137447346176(0x2000801000, double:6.79080118576E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a70
            android.widget.TextView r0 = r1.tvCheckingOffers
            r2 = r99
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0a70:
            r2 = 137441054720(0x2000201000, double:6.79049034653E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a82
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r100
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0a82:
            r2 = 137438957569(0x2000001001, double:6.7903867335E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0a94
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r101
            r0.setGravity(r2)
        L_0x0a94:
            r2 = 137443151872(0x2000401000, double:6.7905939596E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0aa6
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r27
            r0.setVisibility(r2)
        L_0x0aa6:
            r2 = 137438958592(0x2000001400, double:6.79038678405E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0ab8
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPayWithNewDebitCard
            r2 = r102
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0ab8:
            r2 = 137455734784(0x2001001000, double:6.79121563806E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0aca
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPayWithNewDebitCard
            r2 = r103
            r0.setVisibility(r2)
        L_0x0aca:
            r2 = 171798695936(0x2800001000, double:8.48798336623E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0adc
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPromoMessage
            r2 = r104
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0adc:
            r2 = 137439219712(0x2000041000, double:6.7903996851E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0aee
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPromoMessage
            r2 = r105
            r0.setVisibility(r2)
        L_0x0aee:
            r2 = 137472512000(0x2002001000, double:6.79204454267E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0b00
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtDebitCreditCard
            r2 = r106
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0b00:
            r2 = 137438965760(0x2000003000, double:6.7903871382E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0b19
            android.widget.TextView r0 = r1.txtamount
            r2 = r107
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.txtamount
            r2 = r108
            r0.setVisibility(r2)
        L_0x0b19:
            r2 = 137438958080(0x2000001200, double:6.79038675875E-313)
            long r2 = r77 & r2
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0b2b
            android.widget.RelativeLayout r0 = r1.upiPayOption
            r2 = r109
            r0.setVisibility(r2)
        L_0x0b2b:
            return
        L_0x0b2c:
            r0 = move-exception
            monitor-exit(r110)     // Catch:{ all -> 0x0b2c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl.executeBindings():void");
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private DebitCreditCardViewModel value;

        public OnCheckedChangeListenerImpl setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.checkBoxChanged(compoundButton, z);
        }
    }

    public static class AfterTextChangedImpl implements d.a {
        private DebitCreditCardViewModel value;

        public AfterTextChangedImpl setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.expiryBeforeTextChange(editable);
        }
    }

    public static class OnCheckedChangeListenerImpl1 implements CompoundButton.OnCheckedChangeListener {
        private DebitCreditCardViewModel value;

        public OnCheckedChangeListenerImpl1 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.oneClickChanged(compoundButton, z);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private DebitCreditCardViewModel value;

        public OnClickListenerImpl setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.paytWithNewDebitClicked(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private DebitCreditCardViewModel value;

        public OnClickListenerImpl1 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedClicked(view);
        }
    }

    public static class AfterTextChangedImpl1 implements d.a {
        private DebitCreditCardViewModel value;

        public AfterTextChangedImpl1 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.cardNumberBeforeTextChange(editable);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private DebitCreditCardViewModel value;

        public OnClickListenerImpl2 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.debitCardViewClicked(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private DebitCreditCardViewModel value;

        public OnClickListenerImpl3 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.helpClicked(view);
        }
    }

    public static class AfterTextChangedImpl2 implements d.a {
        private DebitCreditCardViewModel value;

        public AfterTextChangedImpl2 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.cvvBeforeTextChange(editable);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private DebitCreditCardViewModel value;

        public OnClickListenerImpl4 setValue(DebitCreditCardViewModel debitCreditCardViewModel) {
            this.value = debitCreditCardViewModel;
            if (debitCreditCardViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.crossClicked(view);
        }
    }
}
