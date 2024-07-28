package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.emi.viewmodel.EmiViewModel;

public class EmiLayoutBindingImpl extends EmiLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private OnClickListenerImpl3 mEmiViewModelAnotherCardClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl1 mEmiViewModelCardNumberAfterTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl4 mEmiViewModelCrossClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl2 mEmiViewModelCvvAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl2 mEmiViewModelEmiClickedAndroidViewViewOnClickListener;
    private AfterTextChangedImpl mEmiViewModelExpiryAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl mEmiViewModelHelpClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mEmiViewModelOpenLinkAndroidViewViewOnClickListener;
    private OnClickListenerImpl6 mEmiViewModelProceedToPayAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mEmiViewModelSelectBankClickedAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final View mboundView29;
    private final LinearLayout mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_useAnother, 34);
        sViewsWithIds.put(R.id.iv_arrow, 35);
        sViewsWithIds.put(R.id.pb_selectBank, 36);
        sViewsWithIds.put(R.id.txtEmiSelectBank, 37);
        sViewsWithIds.put(R.id.iv_selectEmiArrow, 38);
        sViewsWithIds.put(R.id.pb_selectEmiPlan, 39);
        sViewsWithIds.put(R.id.txtSelectEmiPlan, 40);
        sViewsWithIds.put(R.id.rl_cardNumber, 41);
        sViewsWithIds.put(R.id.iv_saved_card, 42);
        sViewsWithIds.put(R.id.tv_addedBankName, 43);
        sViewsWithIds.put(R.id.imgEmiCross, 44);
        sViewsWithIds.put(R.id.tv_addedEmiInfo, 45);
        sViewsWithIds.put(R.id.tv_change_plan, 46);
        sViewsWithIds.put(R.id.fl_loader, 47);
        sViewsWithIds.put(R.id.ltv_getOffers, 48);
        sViewsWithIds.put(R.id.paysecurely, 49);
        sViewsWithIds.put(R.id.ltv_loading, 50);
    }

    public EmiLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 51, sIncludes, sViewsWithIds));
    }

    private EmiLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 30, objArr[33], objArr[15], objArr[7], objArr[5], objArr[47], objArr[44], objArr[35], objArr[16], objArr[17], objArr[42], objArr[38], objArr[30], objArr[4], objArr[1], objArr[2], objArr[48], objArr[50], objArr[49], objArr[36], objArr[39], objArr[10], objArr[3], objArr[25], objArr[41], objArr[20], objArr[14], objArr[9], objArr[13], objArr[18], objArr[19], objArr[43], objArr[23], objArr[45], objArr[24], objArr[26], objArr[21], objArr[27], objArr[22], objArr[46], objArr[31], objArr[32], objArr[8], objArr[28], objArr[34], objArr[12], objArr[37], objArr[40], objArr[11]);
        this.mDirtyFlags = -1;
        this.mDirtyFlags_1 = -1;
        this.btnProceed.setTag((Object) null);
        this.etCardNumber.setTag((Object) null);
        this.etCvv.setTag((Object) null);
        this.etExpiryValidity.setTag((Object) null);
        this.ivCardLogo.setTag((Object) null);
        this.ivCross.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llCvvLayout.setTag((Object) null);
        this.llSavedCardContainer.setTag((Object) null);
        this.llUseAnotherCard.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView29 = objArr[29];
        this.mboundView29.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.radioButton.setTag((Object) null);
        this.rbAnotherCard.setTag((Object) null);
        this.rlAllOffers.setTag((Object) null);
        this.rlCardView.setTag((Object) null);
        this.rlCreditCardNumber.setTag((Object) null);
        this.rlNameLayout.setTag((Object) null);
        this.rlSelectBank.setTag((Object) null);
        this.rlSelectEMIPlan.setTag((Object) null);
        this.tnc.setTag((Object) null);
        this.tvAddedEmiDetails.setTag((Object) null);
        this.tvAddedTotalAmount.setTag((Object) null);
        this.tvAppliedOffers.setTag((Object) null);
        this.tvBankName.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvChangeBankCard.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvCvvHelp.setTag((Object) null);
        this.tvSubventionOffer.setTag((Object) null);
        this.txtDebitCreditCard.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2147483648L;
            this.mDirtyFlags_1 = 0;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0) {
                if (this.mDirtyFlags_1 == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.view == i2) {
            setView((View) obj);
        } else if (BR.emiViewModel != i2) {
            return false;
        } else {
            setEmiViewModel((EmiViewModel) obj);
        }
        return true;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setEmiViewModel(EmiViewModel emiViewModel) {
        updateRegistration(10, (h) emiViewModel);
        this.mEmiViewModel = emiViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(BR.emiViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeEmiViewModelSubventionOfferText((i) obj, i3);
            case 1:
                return onChangeEmiViewModelRbChooseAnotherChecked((ObservableBoolean) obj, i3);
            case 2:
                return onChangeEmiViewModelVisibilityTotalAmount((ObservableBoolean) obj, i3);
            case 3:
                return onChangeEmiViewModelVisibilityCardNumber((ObservableBoolean) obj, i3);
            case 4:
                return onChangeEmiViewModelConvFeeText((i) obj, i3);
            case 5:
                return onChangeEmiViewModelVisibilityCvvLayout((ObservableBoolean) obj, i3);
            case 6:
                return onChangeEmiViewModelSubventionOfferVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeEmiViewModelVisibilityAnotherCard((ObservableBoolean) obj, i3);
            case 8:
                return onChangeEmiViewModelVisibilityProceedBtn((ObservableBoolean) obj, i3);
            case 9:
                return onChangeEmiViewModelAddedTotalAmountText((i) obj, i3);
            case 10:
                return onChangeEmiViewModel((EmiViewModel) obj, i3);
            case 11:
                return onChangeEmiViewModelVisibilityCross((ObservableBoolean) obj, i3);
            case 12:
                return onChangeEmiViewModelBankOfferVisibility((ObservableInt) obj, i3);
            case 13:
                return onChangeEmiViewModelLoaderVisibility((ObservableInt) obj, i3);
            case 14:
                return onChangeEmiViewModelVisibilityChangeBankCard((ObservableBoolean) obj, i3);
            case 15:
                return onChangeEmiViewModelVisibilityTnC((ObservableBoolean) obj, i3);
            case 16:
                return onChangeEmiViewModelLoaderMsg((i) obj, i3);
            case 17:
                return onChangeEmiViewModelVisibilitySelectedCardView((ObservableBoolean) obj, i3);
            case 18:
                return onChangeEmiViewModelBankOfferText((i) obj, i3);
            case 19:
                return onChangeEmiViewModelAppliedOffersVisibility((ObservableInt) obj, i3);
            case 20:
                return onChangeEmiViewModelVisibilitySavedCardContainer((ObservableBoolean) obj, i3);
            case 21:
                return onChangeEmiViewModelAmount((i) obj, i3);
            case 22:
                return onChangeEmiViewModelEmiDisplayName((i) obj, i3);
            case 23:
                return onChangeEmiViewModelAddedCardNumber((i) obj, i3);
            case 24:
                return onChangeEmiViewModelVisibilitySelectedPlan((ObservableBoolean) obj, i3);
            case 25:
                return onChangeEmiViewModelVisibilityCardImage((ObservableBoolean) obj, i3);
            case 26:
                return onChangeEmiViewModelVisibilitySelectBank((ObservableBoolean) obj, i3);
            case 27:
                return onChangeEmiViewModelRadioChecked((ObservableBoolean) obj, i3);
            case 28:
                return onChangeEmiViewModelVisibilitySelectPlan((ObservableBoolean) obj, i3);
            case 29:
                return onChangeEmiViewModelConvFeeTextVisibility((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeEmiViewModelSubventionOfferText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeEmiViewModelRbChooseAnotherChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityTotalAmount(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityCardNumber(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeEmiViewModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityCvvLayout(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeEmiViewModelSubventionOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityAnotherCard(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityProceedBtn(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeEmiViewModelAddedTotalAmountText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeEmiViewModel(EmiViewModel emiViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityCross(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeEmiViewModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeEmiViewModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityChangeBankCard(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityTnC(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeEmiViewModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilitySelectedCardView(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeEmiViewModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeEmiViewModelAppliedOffersVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilitySavedCardContainer(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeEmiViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeEmiViewModelEmiDisplayName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeEmiViewModelAddedCardNumber(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilitySelectedPlan(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilityCardImage(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 33554432;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilitySelectBank(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 67108864;
        }
        return true;
    }

    private boolean onChangeEmiViewModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 134217728;
        }
        return true;
    }

    private boolean onChangeEmiViewModelVisibilitySelectPlan(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 268435456;
        }
        return true;
    }

    private boolean onChangeEmiViewModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 536870912;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x04e5  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x054c  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x05c3  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x05f4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x061b  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x062a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r95 = this;
            r1 = r95
            monitor-enter(r95)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0994 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0994 }
            r1.mDirtyFlags_1 = r4     // Catch:{ all -> 0x0994 }
            monitor-exit(r95)     // Catch:{ all -> 0x0994 }
            net.one97.paytm.nativesdk.instruments.emi.viewmodel.EmiViewModel r0 = r1.mEmiViewModel
            r6 = 3221225471(0xbfffffff, double:1.5914968427E-314)
            long r6 = r6 & r2
            r14 = 2147484676(0x80000404, double:1.0609984034E-314)
            r16 = 2147484672(0x80000400, double:1.0609984014E-314)
            r18 = 2147484674(0x80000402, double:1.0609984024E-314)
            r20 = 2147484673(0x80000401, double:1.060998402E-314)
            r22 = 18014398509481984(0x40000000000000, double:1.7800590868057611E-307)
            r24 = 2147488832(0x80001440, double:1.0610004567E-314)
            r11 = 1
            r13 = 0
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x06be
            long r6 = r2 & r20
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x004d
            if (r0 == 0) goto L_0x0040
            androidx.databinding.i<java.lang.String> r6 = r0.subventionOfferText
            goto L_0x0041
        L_0x0040:
            r6 = 0
        L_0x0041:
            r1.updateRegistration((int) r13, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x004d
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x004e
        L_0x004d:
            r6 = 0
        L_0x004e:
            long r28 = r2 & r18
            int r7 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0064
            if (r0 == 0) goto L_0x0059
            androidx.databinding.ObservableBoolean r7 = r0.rbChooseAnotherChecked
            goto L_0x005a
        L_0x0059:
            r7 = 0
        L_0x005a:
            r1.updateRegistration((int) r11, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0064
            boolean r7 = r7.get()
            goto L_0x0065
        L_0x0064:
            r7 = 0
        L_0x0065:
            long r28 = r2 & r14
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0096
            if (r0 == 0) goto L_0x0070
            androidx.databinding.ObservableBoolean r11 = r0.visibilityTotalAmount
            goto L_0x0071
        L_0x0070:
            r11 = 0
        L_0x0071:
            r13 = 2
            r1.updateRegistration((int) r13, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x007c
            boolean r13 = r11.get()
            goto L_0x007d
        L_0x007c:
            r13 = 0
        L_0x007d:
            if (r30 == 0) goto L_0x008e
            if (r13 == 0) goto L_0x0087
            r30 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x008c
        L_0x0087:
            r30 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x008c:
            long r2 = r2 | r30
        L_0x008e:
            if (r13 == 0) goto L_0x0092
            r11 = 0
            goto L_0x0094
        L_0x0092:
            r11 = 8
        L_0x0094:
            r13 = r11
            goto L_0x0097
        L_0x0096:
            r13 = 0
        L_0x0097:
            long r30 = r2 & r16
            int r11 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x013d
            if (r0 == 0) goto L_0x013d
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl r11 = r1.mEmiViewModelExpiryAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r11 != 0) goto L_0x00aa
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl r11 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl
            r11.<init>()
            r1.mEmiViewModelExpiryAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r11
        L_0x00aa:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl r11 = r11.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl r14 = r1.mEmiViewModelHelpClickedAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x00b9
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl r14 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl
            r14.<init>()
            r1.mEmiViewModelHelpClickedAndroidViewViewOnClickListener = r14
        L_0x00b9:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl r14 = r14.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl1 r15 = r1.mEmiViewModelSelectBankClickedAndroidViewViewOnClickListener
            if (r15 != 0) goto L_0x00c8
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl1 r15 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl1
            r15.<init>()
            r1.mEmiViewModelSelectBankClickedAndroidViewViewOnClickListener = r15
        L_0x00c8:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl1 r15 = r15.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl2 r12 = r1.mEmiViewModelEmiClickedAndroidViewViewOnClickListener
            if (r12 != 0) goto L_0x00d7
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl2 r12 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl2
            r12.<init>()
            r1.mEmiViewModelEmiClickedAndroidViewViewOnClickListener = r12
        L_0x00d7:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl2 r12 = r12.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl1 r10 = r1.mEmiViewModelCardNumberAfterTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r10 != 0) goto L_0x00e6
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl1 r10 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl1
            r10.<init>()
            r1.mEmiViewModelCardNumberAfterTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r10
        L_0x00e6:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl1 r10 = r10.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl2 r4 = r1.mEmiViewModelCvvAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r4 != 0) goto L_0x00f5
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl2 r4 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl2
            r4.<init>()
            r1.mEmiViewModelCvvAfterTextChangeAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r4
        L_0x00f5:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$AfterTextChangedImpl2 r4 = r4.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl3 r5 = r1.mEmiViewModelAnotherCardClickedAndroidViewViewOnClickListener
            if (r5 != 0) goto L_0x0104
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl3 r5 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl3
            r5.<init>()
            r1.mEmiViewModelAnotherCardClickedAndroidViewViewOnClickListener = r5
        L_0x0104:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl3 r5 = r5.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl4 r8 = r1.mEmiViewModelCrossClickedAndroidViewViewOnClickListener
            if (r8 != 0) goto L_0x0113
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl4 r8 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl4
            r8.<init>()
            r1.mEmiViewModelCrossClickedAndroidViewViewOnClickListener = r8
        L_0x0113:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl4 r8 = r8.setValue(r0)
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl5 r9 = r1.mEmiViewModelOpenLinkAndroidViewViewOnClickListener
            if (r9 != 0) goto L_0x0122
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl5 r9 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl5
            r9.<init>()
            r1.mEmiViewModelOpenLinkAndroidViewViewOnClickListener = r9
        L_0x0122:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl5 r9 = r9.setValue(r0)
            r38 = r4
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl6 r4 = r1.mEmiViewModelProceedToPayAndroidViewViewOnClickListener
            if (r4 != 0) goto L_0x0133
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl6 r4 = new net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl6
            r4.<init>()
            r1.mEmiViewModelProceedToPayAndroidViewViewOnClickListener = r4
        L_0x0133:
            net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl$OnClickListenerImpl6 r4 = r4.setValue(r0)
            r36 = 2147484680(0x80000408, double:1.0609984054E-314)
            goto L_0x014d
        L_0x013d:
            r4 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r36 = 2147484680(0x80000408, double:1.0609984054E-314)
            r38 = 0
        L_0x014d:
            long r39 = r2 & r36
            r34 = 0
            int r41 = (r39 > r34 ? 1 : (r39 == r34 ? 0 : -1))
            r39 = r4
            if (r41 == 0) goto L_0x017e
            if (r0 == 0) goto L_0x015e
            androidx.databinding.ObservableBoolean r4 = r0.visibilityCardNumber
            r40 = r5
            goto L_0x0161
        L_0x015e:
            r40 = r5
            r4 = 0
        L_0x0161:
            r5 = 3
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x016c
            boolean r4 = r4.get()
            goto L_0x016d
        L_0x016c:
            r4 = 0
        L_0x016d:
            if (r41 == 0) goto L_0x0178
            if (r4 == 0) goto L_0x0174
            r41 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            goto L_0x0176
        L_0x0174:
            r41 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
        L_0x0176:
            long r2 = r2 | r41
        L_0x0178:
            if (r4 == 0) goto L_0x017b
            goto L_0x0180
        L_0x017b:
            r4 = 8
            goto L_0x0181
        L_0x017e:
            r40 = r5
        L_0x0180:
            r4 = 0
        L_0x0181:
            r41 = 2147484688(0x80000410, double:1.0609984093E-314)
            long r41 = r2 & r41
            r34 = 0
            int r5 = (r41 > r34 ? 1 : (r41 == r34 ? 0 : -1))
            if (r5 == 0) goto L_0x01a5
            if (r0 == 0) goto L_0x0195
            androidx.databinding.i<android.text.SpannableString> r5 = r0.convFeeText
            r41 = r4
            goto L_0x0198
        L_0x0195:
            r41 = r4
            r5 = 0
        L_0x0198:
            r4 = 4
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01a7
            java.lang.Object r4 = r5.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x01a8
        L_0x01a5:
            r41 = r4
        L_0x01a7:
            r4 = 0
        L_0x01a8:
            r42 = 2147484704(0x80000420, double:1.060998417E-314)
            long r42 = r2 & r42
            r34 = 0
            int r5 = (r42 > r34 ? 1 : (r42 == r34 ? 0 : -1))
            r42 = r4
            if (r5 == 0) goto L_0x01dd
            if (r0 == 0) goto L_0x01be
            androidx.databinding.ObservableBoolean r4 = r0.visibilityCvvLayout
            r43 = r6
            goto L_0x01c1
        L_0x01be:
            r43 = r6
            r4 = 0
        L_0x01c1:
            r6 = 5
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01cc
            boolean r4 = r4.get()
            goto L_0x01cd
        L_0x01cc:
            r4 = 0
        L_0x01cd:
            if (r5 == 0) goto L_0x01d7
            if (r4 == 0) goto L_0x01d4
            r5 = 576460752303423488(0x800000000000000, double:3.785766995733679E-270)
            goto L_0x01d6
        L_0x01d4:
            r5 = 288230376151711744(0x400000000000000, double:2.0522684006491881E-289)
        L_0x01d6:
            long r2 = r2 | r5
        L_0x01d7:
            if (r4 == 0) goto L_0x01da
            goto L_0x01df
        L_0x01da:
            r4 = 8
            goto L_0x01e0
        L_0x01dd:
            r43 = r6
        L_0x01df:
            r4 = 0
        L_0x01e0:
            r5 = 2147484736(0x80000440, double:1.060998433E-314)
            long r5 = r5 & r2
            r34 = 0
            int r44 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r44 == 0) goto L_0x01fd
            if (r0 == 0) goto L_0x01f1
            androidx.databinding.ObservableInt r5 = r0.subventionOfferVisibility
            goto L_0x01f2
        L_0x01f1:
            r5 = 0
        L_0x01f2:
            r6 = 6
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01fe
            int r6 = r5.get()
            goto L_0x01ff
        L_0x01fd:
            r5 = 0
        L_0x01fe:
            r6 = 0
        L_0x01ff:
            r44 = 2147484800(0x80000480, double:1.0609984646E-314)
            long r44 = r2 & r44
            r34 = 0
            int r46 = (r44 > r34 ? 1 : (r44 == r34 ? 0 : -1))
            r44 = r4
            if (r46 == 0) goto L_0x022a
            if (r0 == 0) goto L_0x0215
            androidx.databinding.ObservableBoolean r4 = r0.visibilityAnotherCard
            r45 = r5
            goto L_0x0218
        L_0x0215:
            r45 = r5
            r4 = 0
        L_0x0218:
            r5 = 7
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0223
            boolean r4 = r4.get()
            goto L_0x0224
        L_0x0223:
            r4 = 0
        L_0x0224:
            if (r4 == 0) goto L_0x0227
            goto L_0x022c
        L_0x0227:
            r4 = 8
            goto L_0x022d
        L_0x022a:
            r45 = r5
        L_0x022c:
            r4 = 0
        L_0x022d:
            r26 = 2147484928(0x80000500, double:1.060998528E-314)
            long r46 = r2 & r26
            r34 = 0
            int r5 = (r46 > r34 ? 1 : (r46 == r34 ? 0 : -1))
            r46 = r4
            if (r5 == 0) goto L_0x0264
            if (r0 == 0) goto L_0x0243
            androidx.databinding.ObservableBoolean r4 = r0.visibilityProceedBtn
            r32 = r6
            goto L_0x0246
        L_0x0243:
            r32 = r6
            r4 = 0
        L_0x0246:
            r6 = 8
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0252
            boolean r4 = r4.get()
            goto L_0x0253
        L_0x0252:
            r4 = 0
        L_0x0253:
            if (r5 == 0) goto L_0x025e
            if (r4 == 0) goto L_0x025a
            r47 = 144115188075855872(0x200000000000000, double:4.7783097267364807E-299)
            goto L_0x025c
        L_0x025a:
            r47 = 72057594037927936(0x100000000000000, double:7.2911220195563975E-304)
        L_0x025c:
            long r2 = r2 | r47
        L_0x025e:
            if (r4 == 0) goto L_0x0261
            goto L_0x0268
        L_0x0261:
            r4 = 8
            goto L_0x0269
        L_0x0264:
            r32 = r6
            r6 = 8
        L_0x0268:
            r4 = 0
        L_0x0269:
            r47 = 2147485184(0x80000600, double:1.0609986544E-314)
            long r47 = r2 & r47
            r34 = 0
            int r5 = (r47 > r34 ? 1 : (r47 == r34 ? 0 : -1))
            if (r5 == 0) goto L_0x028a
            if (r0 == 0) goto L_0x027b
            androidx.databinding.i<java.lang.String> r5 = r0.addedTotalAmountText
            goto L_0x027c
        L_0x027b:
            r5 = 0
        L_0x027c:
            r6 = 9
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x028a
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x028b
        L_0x028a:
            r5 = 0
        L_0x028b:
            r48 = 2147486720(0x80000c00, double:1.0609994133E-314)
            long r48 = r2 & r48
            r34 = 0
            int r6 = (r48 > r34 ? 1 : (r48 == r34 ? 0 : -1))
            r48 = r4
            if (r6 == 0) goto L_0x02c7
            if (r0 == 0) goto L_0x02a1
            androidx.databinding.ObservableBoolean r4 = r0.visibilityCross
            r49 = r5
            goto L_0x02a4
        L_0x02a1:
            r49 = r5
            r4 = 0
        L_0x02a4:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02b0
            boolean r4 = r4.get()
            goto L_0x02b1
        L_0x02b0:
            r4 = 0
        L_0x02b1:
            if (r6 == 0) goto L_0x02c1
            if (r4 == 0) goto L_0x02bb
            r5 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x02c0
        L_0x02bb:
            r5 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x02c0:
            long r2 = r2 | r5
        L_0x02c1:
            if (r4 == 0) goto L_0x02c4
            goto L_0x02c9
        L_0x02c4:
            r4 = 8
            goto L_0x02ca
        L_0x02c7:
            r49 = r5
        L_0x02c9:
            r4 = 0
        L_0x02ca:
            long r5 = r2 & r24
            r34 = 0
            int r50 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r50 == 0) goto L_0x02f6
            if (r0 == 0) goto L_0x02d7
            androidx.databinding.ObservableInt r5 = r0.bankOfferVisibility
            goto L_0x02d8
        L_0x02d7:
            r5 = 0
        L_0x02d8:
            r6 = 12
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02e4
            int r5 = r5.get()
            goto L_0x02e5
        L_0x02e4:
            r5 = 0
        L_0x02e5:
            if (r5 != 0) goto L_0x02e9
            r6 = 1
            goto L_0x02ea
        L_0x02e9:
            r6 = 0
        L_0x02ea:
            if (r50 == 0) goto L_0x02f8
            if (r6 == 0) goto L_0x02f3
            r50 = 36028797018963968(0x80000000000000, double:2.8480945388892178E-306)
            long r2 = r2 | r50
            goto L_0x02f8
        L_0x02f3:
            long r2 = r2 | r22
            goto L_0x02f8
        L_0x02f6:
            r5 = 0
            r6 = 0
        L_0x02f8:
            r50 = 2147492864(0x80002400, double:1.061002449E-314)
            long r50 = r2 & r50
            r34 = 0
            int r52 = (r50 > r34 ? 1 : (r50 == r34 ? 0 : -1))
            r50 = r4
            if (r52 == 0) goto L_0x031d
            if (r0 == 0) goto L_0x030e
            androidx.databinding.ObservableInt r4 = r0.loaderVisibility
            r51 = r5
            goto L_0x0311
        L_0x030e:
            r51 = r5
            r4 = 0
        L_0x0311:
            r5 = 13
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x031f
            int r4 = r4.get()
            goto L_0x0320
        L_0x031d:
            r51 = r5
        L_0x031f:
            r4 = 0
        L_0x0320:
            r52 = 2147501056(0x80004400, double:1.061006496E-314)
            long r52 = r2 & r52
            r34 = 0
            int r5 = (r52 > r34 ? 1 : (r52 == r34 ? 0 : -1))
            r52 = r4
            if (r5 == 0) goto L_0x035c
            if (r0 == 0) goto L_0x0336
            androidx.databinding.ObservableBoolean r4 = r0.visibilityChangeBankCard
            r53 = r6
            goto L_0x0339
        L_0x0336:
            r53 = r6
            r4 = 0
        L_0x0339:
            r6 = 14
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0345
            boolean r4 = r4.get()
            goto L_0x0346
        L_0x0345:
            r4 = 0
        L_0x0346:
            if (r5 == 0) goto L_0x0356
            if (r4 == 0) goto L_0x0350
            r5 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x0355
        L_0x0350:
            r5 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x0355:
            long r2 = r2 | r5
        L_0x0356:
            if (r4 == 0) goto L_0x0359
            goto L_0x035e
        L_0x0359:
            r4 = 8
            goto L_0x035f
        L_0x035c:
            r53 = r6
        L_0x035e:
            r4 = 0
        L_0x035f:
            r5 = 2147517440(0x80008400, double:1.061014591E-314)
            long r5 = r5 & r2
            r34 = 0
            int r54 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r54 == 0) goto L_0x0395
            if (r0 == 0) goto L_0x0370
            androidx.databinding.ObservableBoolean r5 = r0.visibilityTnC
            goto L_0x0371
        L_0x0370:
            r5 = 0
        L_0x0371:
            r6 = 15
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x037d
            boolean r5 = r5.get()
            goto L_0x037e
        L_0x037d:
            r5 = 0
        L_0x037e:
            if (r54 == 0) goto L_0x038f
            if (r5 == 0) goto L_0x0388
            r54 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x038d
        L_0x0388:
            r54 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x038d:
            long r2 = r2 | r54
        L_0x038f:
            if (r5 == 0) goto L_0x0392
            goto L_0x0395
        L_0x0392:
            r5 = 8
            goto L_0x0396
        L_0x0395:
            r5 = 0
        L_0x0396:
            r54 = 2147550208(0x80010400, double:1.0610307805E-314)
            long r54 = r2 & r54
            r34 = 0
            int r6 = (r54 > r34 ? 1 : (r54 == r34 ? 0 : -1))
            if (r6 == 0) goto L_0x03bb
            if (r0 == 0) goto L_0x03aa
            androidx.databinding.i<java.lang.String> r6 = r0.loaderMsg
            r54 = r4
            goto L_0x03ad
        L_0x03aa:
            r54 = r4
            r6 = 0
        L_0x03ad:
            r4 = 16
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x03bd
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x03be
        L_0x03bb:
            r54 = r4
        L_0x03bd:
            r4 = 0
        L_0x03be:
            r55 = 2147615744(0x80020400, double:1.0610631596E-314)
            long r55 = r2 & r55
            r34 = 0
            int r6 = (r55 > r34 ? 1 : (r55 == r34 ? 0 : -1))
            r55 = r4
            if (r6 == 0) goto L_0x03fa
            if (r0 == 0) goto L_0x03d4
            androidx.databinding.ObservableBoolean r4 = r0.visibilitySelectedCardView
            r56 = r5
            goto L_0x03d7
        L_0x03d4:
            r56 = r5
            r4 = 0
        L_0x03d7:
            r5 = 17
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x03e3
            boolean r4 = r4.get()
            goto L_0x03e4
        L_0x03e3:
            r4 = 0
        L_0x03e4:
            if (r6 == 0) goto L_0x03f4
            if (r4 == 0) goto L_0x03ee
            r5 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x03f3
        L_0x03ee:
            r5 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x03f3:
            long r2 = r2 | r5
        L_0x03f4:
            if (r4 == 0) goto L_0x03f7
            goto L_0x03fc
        L_0x03f7:
            r4 = 8
            goto L_0x03fd
        L_0x03fa:
            r56 = r5
        L_0x03fc:
            r4 = 0
        L_0x03fd:
            r5 = 2147746816(0x80040400, double:1.0611279178E-314)
            long r5 = r5 & r2
            r34 = 0
            int r57 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r57 == 0) goto L_0x041d
            if (r0 == 0) goto L_0x040e
            androidx.databinding.i r5 = r0.bankOfferText
            goto L_0x040f
        L_0x040e:
            r5 = 0
        L_0x040f:
            r6 = 18
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x041d
            java.lang.Object r5 = r5.get()
            android.text.SpannableString r5 = (android.text.SpannableString) r5
            goto L_0x041e
        L_0x041d:
            r5 = 0
        L_0x041e:
            r57 = 2148008960(0x80080400, double:1.061257434E-314)
            long r57 = r2 & r57
            r34 = 0
            int r6 = (r57 > r34 ? 1 : (r57 == r34 ? 0 : -1))
            if (r6 == 0) goto L_0x0441
            if (r0 == 0) goto L_0x0432
            androidx.databinding.ObservableInt r6 = r0.appliedOffersVisibility
            r57 = r4
            goto L_0x0435
        L_0x0432:
            r57 = r4
            r6 = 0
        L_0x0435:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0443
            int r4 = r6.get()
            goto L_0x0444
        L_0x0441:
            r57 = r4
        L_0x0443:
            r4 = 0
        L_0x0444:
            r58 = 2148533248(0x80100400, double:1.061516467E-314)
            long r58 = r2 & r58
            r34 = 0
            int r6 = (r58 > r34 ? 1 : (r58 == r34 ? 0 : -1))
            r58 = r4
            if (r6 == 0) goto L_0x047a
            if (r0 == 0) goto L_0x045a
            androidx.databinding.ObservableBoolean r4 = r0.visibilitySavedCardContainer
            r59 = r5
            goto L_0x045d
        L_0x045a:
            r59 = r5
            r4 = 0
        L_0x045d:
            r5 = 20
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0469
            boolean r4 = r4.get()
            goto L_0x046a
        L_0x0469:
            r4 = 0
        L_0x046a:
            if (r6 == 0) goto L_0x0474
            if (r4 == 0) goto L_0x0471
            r5 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
            goto L_0x0473
        L_0x0471:
            r5 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
        L_0x0473:
            long r2 = r2 | r5
        L_0x0474:
            if (r4 == 0) goto L_0x0477
            goto L_0x047c
        L_0x0477:
            r4 = 8
            goto L_0x047d
        L_0x047a:
            r59 = r5
        L_0x047c:
            r4 = 0
        L_0x047d:
            r5 = 2149581824(0x80200400, double:1.062034532E-314)
            long r5 = r5 & r2
            r34 = 0
            int r60 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r60 == 0) goto L_0x04bc
            if (r0 == 0) goto L_0x048e
            androidx.databinding.i<java.lang.String> r5 = r0.amount
            goto L_0x048f
        L_0x048e:
            r5 = 0
        L_0x048f:
            r6 = 21
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x049d
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x049e
        L_0x049d:
            r5 = 0
        L_0x049e:
            if (r5 == 0) goto L_0x04a5
            int r6 = r5.length()
            goto L_0x04a6
        L_0x04a5:
            r6 = 0
        L_0x04a6:
            if (r6 <= 0) goto L_0x04aa
            r6 = 1
            goto L_0x04ab
        L_0x04aa:
            r6 = 0
        L_0x04ab:
            if (r60 == 0) goto L_0x04b6
            if (r6 == 0) goto L_0x04b2
            r60 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            goto L_0x04b4
        L_0x04b2:
            r60 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
        L_0x04b4:
            long r2 = r2 | r60
        L_0x04b6:
            if (r6 == 0) goto L_0x04b9
            goto L_0x04bd
        L_0x04b9:
            r6 = 8
            goto L_0x04be
        L_0x04bc:
            r5 = 0
        L_0x04bd:
            r6 = 0
        L_0x04be:
            r60 = 2151678976(0x80400400, double:1.063070663E-314)
            long r60 = r2 & r60
            r34 = 0
            int r62 = (r60 > r34 ? 1 : (r60 == r34 ? 0 : -1))
            r60 = r4
            if (r62 == 0) goto L_0x04e5
            if (r0 == 0) goto L_0x04d4
            androidx.databinding.i<java.lang.String> r4 = r0.emiDisplayName
            r61 = r5
            goto L_0x04d7
        L_0x04d4:
            r61 = r5
            r4 = 0
        L_0x04d7:
            r5 = 22
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x04e7
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x04e8
        L_0x04e5:
            r61 = r5
        L_0x04e7:
            r4 = 0
        L_0x04e8:
            r62 = 2155873280(0x80800400, double:1.0651429244E-314)
            long r62 = r2 & r62
            r34 = 0
            int r5 = (r62 > r34 ? 1 : (r62 == r34 ? 0 : -1))
            if (r5 == 0) goto L_0x050d
            if (r0 == 0) goto L_0x04fc
            androidx.databinding.i<java.lang.String> r5 = r0.addedCardNumber
            r62 = r4
            goto L_0x04ff
        L_0x04fc:
            r62 = r4
            r5 = 0
        L_0x04ff:
            r4 = 23
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x050f
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0510
        L_0x050d:
            r62 = r4
        L_0x050f:
            r4 = 0
        L_0x0510:
            r63 = 2164261888(0x81000400, double:1.0692874475E-314)
            long r63 = r2 & r63
            r34 = 0
            int r5 = (r63 > r34 ? 1 : (r63 == r34 ? 0 : -1))
            r63 = r4
            if (r5 == 0) goto L_0x054c
            if (r0 == 0) goto L_0x0526
            androidx.databinding.ObservableBoolean r4 = r0.visibilitySelectedPlan
            r64 = r6
            goto L_0x0529
        L_0x0526:
            r64 = r6
            r4 = 0
        L_0x0529:
            r6 = 24
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0535
            boolean r4 = r4.get()
            goto L_0x0536
        L_0x0535:
            r4 = 0
        L_0x0536:
            if (r5 == 0) goto L_0x0546
            if (r4 == 0) goto L_0x0540
            r5 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x0545
        L_0x0540:
            r5 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x0545:
            long r2 = r2 | r5
        L_0x0546:
            if (r4 == 0) goto L_0x0549
            goto L_0x054e
        L_0x0549:
            r4 = 8
            goto L_0x054f
        L_0x054c:
            r64 = r6
        L_0x054e:
            r4 = 0
        L_0x054f:
            r5 = 2181039104(0x82000400, double:1.0775764935E-314)
            long r65 = r2 & r5
            r5 = 0
            int r67 = (r65 > r5 ? 1 : (r65 == r5 ? 0 : -1))
            if (r67 == 0) goto L_0x0586
            if (r0 == 0) goto L_0x0561
            androidx.databinding.ObservableBoolean r5 = r0.visibilityCardImage
            goto L_0x0562
        L_0x0561:
            r5 = 0
        L_0x0562:
            r6 = 25
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x056e
            boolean r5 = r5.get()
            goto L_0x056f
        L_0x056e:
            r5 = 0
        L_0x056f:
            if (r67 == 0) goto L_0x0580
            if (r5 == 0) goto L_0x0579
            r65 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            goto L_0x057e
        L_0x0579:
            r65 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
        L_0x057e:
            long r2 = r2 | r65
        L_0x0580:
            if (r5 == 0) goto L_0x0583
            goto L_0x0586
        L_0x0583:
            r5 = 8
            goto L_0x0587
        L_0x0586:
            r5 = 0
        L_0x0587:
            r65 = 2214593536(0x84000400, double:1.0941545856E-314)
            long r65 = r2 & r65
            r34 = 0
            int r6 = (r65 > r34 ? 1 : (r65 == r34 ? 0 : -1))
            r65 = r4
            if (r6 == 0) goto L_0x05c3
            if (r0 == 0) goto L_0x059d
            androidx.databinding.ObservableBoolean r4 = r0.visibilitySelectBank
            r66 = r5
            goto L_0x05a0
        L_0x059d:
            r66 = r5
            r4 = 0
        L_0x05a0:
            r5 = 26
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x05ac
            boolean r4 = r4.get()
            goto L_0x05ad
        L_0x05ac:
            r4 = 0
        L_0x05ad:
            if (r6 == 0) goto L_0x05bd
            if (r4 == 0) goto L_0x05b7
            r5 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x05bc
        L_0x05b7:
            r5 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x05bc:
            long r2 = r2 | r5
        L_0x05bd:
            if (r4 == 0) goto L_0x05c0
            goto L_0x05c5
        L_0x05c0:
            r4 = 8
            goto L_0x05c6
        L_0x05c3:
            r66 = r5
        L_0x05c5:
            r4 = 0
        L_0x05c6:
            r5 = 2281702400(0x88000400, double:1.12731077E-314)
            long r5 = r5 & r2
            r34 = 0
            int r67 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r67 == 0) goto L_0x05e4
            if (r0 == 0) goto L_0x05d7
            androidx.databinding.ObservableBoolean r5 = r0.radioChecked
            goto L_0x05d8
        L_0x05d7:
            r5 = 0
        L_0x05d8:
            r6 = 27
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x05e4
            boolean r5 = r5.get()
            goto L_0x05e5
        L_0x05e4:
            r5 = 0
        L_0x05e5:
            r67 = 2415920128(0x90000400, double:1.1936231383E-314)
            long r67 = r2 & r67
            r34 = 0
            int r6 = (r67 > r34 ? 1 : (r67 == r34 ? 0 : -1))
            r67 = r4
            if (r6 == 0) goto L_0x061b
            if (r0 == 0) goto L_0x05fb
            androidx.databinding.ObservableBoolean r4 = r0.visibilitySelectPlan
            r68 = r5
            goto L_0x05fe
        L_0x05fb:
            r68 = r5
            r4 = 0
        L_0x05fe:
            r5 = 28
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x060a
            boolean r4 = r4.get()
            goto L_0x060b
        L_0x060a:
            r4 = 0
        L_0x060b:
            if (r6 == 0) goto L_0x0615
            if (r4 == 0) goto L_0x0612
            r5 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
            goto L_0x0614
        L_0x0612:
            r5 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
        L_0x0614:
            long r2 = r2 | r5
        L_0x0615:
            if (r4 == 0) goto L_0x0618
            goto L_0x061d
        L_0x0618:
            r4 = 8
            goto L_0x061e
        L_0x061b:
            r68 = r5
        L_0x061d:
            r4 = 0
        L_0x061e:
            r5 = 2684355584(0xa0000400, double:1.3262478753E-314)
            long r5 = r5 & r2
            r34 = 0
            int r69 = (r5 > r34 ? 1 : (r5 == r34 ? 0 : -1))
            if (r69 == 0) goto L_0x067d
            if (r0 == 0) goto L_0x062f
            androidx.databinding.ObservableInt r5 = r0.convFeeTextVisibility
            goto L_0x0630
        L_0x062f:
            r5 = 0
        L_0x0630:
            r6 = 29
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x067d
            int r5 = r5.get()
            r79 = r4
            r90 = r5
            r75 = r7
            r83 = r13
            r13 = r38
            r7 = r39
            r4 = r40
            r77 = r41
            r89 = r42
            r91 = r43
            r70 = r44
            r72 = r46
            r6 = r48
            r82 = r49
            r39 = r50
            r86 = r51
            r38 = r52
            r87 = r54
            r88 = r55
            r80 = r56
            r76 = r57
            r73 = r58
            r85 = r59
            r71 = r60
            r93 = r61
            r92 = r62
            r84 = r63
            r94 = r64
            r81 = r65
            r5 = r66
            r78 = r67
            r74 = r68
            goto L_0x0706
        L_0x067d:
            r79 = r4
            r75 = r7
            r83 = r13
            r13 = r38
            r7 = r39
            r4 = r40
            r77 = r41
            r89 = r42
            r91 = r43
            r70 = r44
            r72 = r46
            r6 = r48
            r82 = r49
            r39 = r50
            r86 = r51
            r38 = r52
            r87 = r54
            r88 = r55
            r80 = r56
            r76 = r57
            r73 = r58
            r85 = r59
            r71 = r60
            r93 = r61
            r92 = r62
            r84 = r63
            r94 = r64
            r81 = r65
            r5 = r66
            r78 = r67
            r74 = r68
            r90 = 0
            goto L_0x0706
        L_0x06be:
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
            r32 = 0
            r38 = 0
            r39 = 0
            r45 = 0
            r53 = 0
            r70 = 0
            r71 = 0
            r72 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r77 = 0
            r78 = 0
            r79 = 0
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
        L_0x0706:
            long r22 = r2 & r22
            r34 = 0
            int r40 = (r22 > r34 ? 1 : (r22 == r34 ? 0 : -1))
            if (r40 == 0) goto L_0x072b
            if (r0 == 0) goto L_0x0715
            androidx.databinding.ObservableInt r0 = r0.subventionOfferVisibility
            r22 = r5
            goto L_0x0719
        L_0x0715:
            r22 = r5
            r0 = r45
        L_0x0719:
            r5 = 6
            r1.updateRegistration((int) r5, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0723
            int r32 = r0.get()
        L_0x0723:
            if (r32 != 0) goto L_0x0727
            r0 = 1
            goto L_0x0728
        L_0x0727:
            r0 = 0
        L_0x0728:
            r5 = r32
            goto L_0x0730
        L_0x072b:
            r22 = r5
            r5 = r32
            r0 = 0
        L_0x0730:
            long r32 = r2 & r24
            r34 = 0
            int r23 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
            if (r23 == 0) goto L_0x0754
            if (r53 == 0) goto L_0x073d
            r28 = 1
            goto L_0x073f
        L_0x073d:
            r28 = r0
        L_0x073f:
            if (r23 == 0) goto L_0x074a
            if (r28 == 0) goto L_0x0746
            r32 = -9223372036854775808
            goto L_0x0748
        L_0x0746:
            r32 = 4611686018427387904(0x4000000000000000, double:2.0)
        L_0x0748:
            long r2 = r2 | r32
        L_0x074a:
            if (r28 == 0) goto L_0x074f
            r29 = 0
            goto L_0x0751
        L_0x074f:
            r29 = 8
        L_0x0751:
            r0 = r29
            goto L_0x0755
        L_0x0754:
            r0 = 0
        L_0x0755:
            long r16 = r2 & r16
            r28 = 0
            int r23 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            r16 = r5
            if (r23 == 0) goto L_0x0792
            android.widget.RelativeLayout r5 = r1.btnProceed
            r5.setOnClickListener(r7)
            android.widget.EditText r5 = r1.etCardNumber
            r7 = 0
            androidx.databinding.a.d.a(r5, r7, r10, r7)
            android.widget.EditText r5 = r1.etCvv
            androidx.databinding.a.d.a(r5, r7, r13, r7)
            android.widget.EditText r5 = r1.etExpiryValidity
            androidx.databinding.a.d.a(r5, r7, r11, r7)
            android.widget.ImageView r5 = r1.ivCross
            r5.setOnClickListener(r8)
            android.widget.LinearLayout r5 = r1.llUseAnotherCard
            r5.setOnClickListener(r4)
            android.widget.RelativeLayout r4 = r1.rlNameLayout
            r4.setOnClickListener(r12)
            android.widget.RelativeLayout r4 = r1.rlSelectBank
            r4.setOnClickListener(r15)
            android.widget.TextView r4 = r1.tnc
            r4.setOnClickListener(r9)
            net.one97.paytm.nativesdk.widget.RoboTextView r4 = r1.tvCvvHelp
            r4.setOnClickListener(r14)
        L_0x0792:
            r4 = 2147484928(0x80000500, double:1.060998528E-314)
            long r4 = r4 & r2
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x07a3
            android.widget.RelativeLayout r4 = r1.btnProceed
            r4.setVisibility(r6)
        L_0x07a3:
            r4 = 2181039104(0x82000400, double:1.0775764935E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x07b4
            android.widget.ImageView r4 = r1.ivCardLogo
            r5 = r22
            r4.setVisibility(r5)
        L_0x07b4:
            r4 = 2147486720(0x80000c00, double:1.0609994133E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x07c5
            android.widget.ImageView r4 = r1.ivCross
            r5 = r39
            r4.setVisibility(r5)
        L_0x07c5:
            r4 = 2147492864(0x80002400, double:1.061002449E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x07d6
            android.widget.LinearLayout r4 = r1.llCheckOffer
            r5 = r38
            r4.setVisibility(r5)
        L_0x07d6:
            r4 = 2147484704(0x80000420, double:1.060998417E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x07ec
            android.widget.LinearLayout r4 = r1.llCvvLayout
            r5 = r70
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.mboundView6
            r4.setVisibility(r5)
        L_0x07ec:
            r4 = 2148533248(0x80100400, double:1.061516467E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x07fd
            android.widget.LinearLayout r4 = r1.llSavedCardContainer
            r5 = r71
            r4.setVisibility(r5)
        L_0x07fd:
            r4 = 2147484800(0x80000480, double:1.0609984646E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x080e
            android.widget.LinearLayout r4 = r1.llUseAnotherCard
            r5 = r72
            r4.setVisibility(r5)
        L_0x080e:
            r4 = 2148008960(0x80080400, double:1.061257434E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0824
            android.view.View r4 = r1.mboundView29
            r5 = r73
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.tvAppliedOffers
            r4.setVisibility(r5)
        L_0x0824:
            r4 = 2281702400(0x88000400, double:1.12731077E-314)
            long r4 = r4 & r2
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0835
            android.widget.RadioButton r4 = r1.radioButton
            r5 = r74
            androidx.databinding.a.a.a(r4, r5)
        L_0x0835:
            long r4 = r2 & r18
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0842
            android.widget.RadioButton r4 = r1.rbAnotherCard
            r5 = r75
            androidx.databinding.a.a.a(r4, r5)
        L_0x0842:
            long r4 = r2 & r24
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x084d
            android.widget.RelativeLayout r4 = r1.rlAllOffers
            r4.setVisibility(r0)
        L_0x084d:
            r4 = 2147615744(0x80020400, double:1.0610631596E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x085e
            android.widget.RelativeLayout r0 = r1.rlCardView
            r4 = r76
            r0.setVisibility(r4)
        L_0x085e:
            r4 = 2147484680(0x80000408, double:1.0609984054E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x086f
            android.widget.RelativeLayout r0 = r1.rlCreditCardNumber
            r4 = r77
            r0.setVisibility(r4)
        L_0x086f:
            r4 = 2214593536(0x84000400, double:1.0941545856E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0880
            android.widget.RelativeLayout r0 = r1.rlSelectBank
            r4 = r78
            r0.setVisibility(r4)
        L_0x0880:
            r4 = 2415920128(0x90000400, double:1.1936231383E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0891
            android.widget.RelativeLayout r0 = r1.rlSelectEMIPlan
            r4 = r79
            r0.setVisibility(r4)
        L_0x0891:
            r4 = 2147517440(0x80008400, double:1.061014591E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08a2
            android.widget.TextView r0 = r1.tnc
            r4 = r80
            r0.setVisibility(r4)
        L_0x08a2:
            r4 = 2164261888(0x81000400, double:1.0692874475E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08b3
            android.widget.RelativeLayout r0 = r1.tvAddedEmiDetails
            r4 = r81
            r0.setVisibility(r4)
        L_0x08b3:
            r4 = 2147485184(0x80000600, double:1.0609986544E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08c4
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvAddedTotalAmount
            r4 = r82
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x08c4:
            r4 = 2147484676(0x80000404, double:1.0609984034E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08d5
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvAddedTotalAmount
            r13 = r83
            r0.setVisibility(r13)
        L_0x08d5:
            r4 = 2155873280(0x80800400, double:1.0651429244E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08e6
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankName
            r4 = r84
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x08e6:
            r4 = 2147746816(0x80040400, double:1.0611279178E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x08f7
            android.widget.TextView r0 = r1.tvBankOffer
            r4 = r85
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x08f7:
            r4 = 2147488768(0x80001400, double:1.061000425E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0908
            android.widget.TextView r0 = r1.tvBankOffer
            r4 = r86
            r0.setVisibility(r4)
        L_0x0908:
            r4 = 2147501056(0x80004400, double:1.061006496E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0919
            android.widget.TextView r0 = r1.tvChangeBankCard
            r4 = r87
            r0.setVisibility(r4)
        L_0x0919:
            r4 = 2147550208(0x80010400, double:1.0610307805E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x092a
            android.widget.TextView r0 = r1.tvCheckingOffers
            r4 = r88
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x092a:
            r4 = 2147484688(0x80000410, double:1.0609984093E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x093b
            android.widget.TextView r0 = r1.tvConvFee
            r4 = r89
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x093b:
            r4 = 2684355584(0xa0000400, double:1.3262478753E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x094c
            android.widget.TextView r0 = r1.tvConvFee
            r5 = r90
            r0.setVisibility(r5)
        L_0x094c:
            r4 = 2147484736(0x80000440, double:1.060998433E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x095d
            android.widget.TextView r0 = r1.tvSubventionOffer
            r4 = r16
            r0.setVisibility(r4)
        L_0x095d:
            long r4 = r2 & r20
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x096a
            android.widget.TextView r0 = r1.tvSubventionOffer
            r4 = r91
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x096a:
            r4 = 2151678976(0x80400400, double:1.063070663E-314)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x097b
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtDebitCreditCard
            r4 = r92
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x097b:
            r4 = 2149581824(0x80200400, double:1.062034532E-314)
            long r2 = r2 & r4
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0993
            android.widget.TextView r0 = r1.txtamount
            r2 = r93
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.txtamount
            r2 = r94
            r0.setVisibility(r2)
        L_0x0993:
            return
        L_0x0994:
            r0 = move-exception
            monitor-exit(r95)     // Catch:{ all -> 0x0994 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        private EmiViewModel value;

        public AfterTextChangedImpl setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.expiryAfterTextChange(editable);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.helpClicked(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl1 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.selectBankClicked(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl2 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.emiClicked(view);
        }
    }

    public static class AfterTextChangedImpl1 implements d.a {
        private EmiViewModel value;

        public AfterTextChangedImpl1 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.cardNumberAfterTextChanged(editable);
        }
    }

    public static class AfterTextChangedImpl2 implements d.a {
        private EmiViewModel value;

        public AfterTextChangedImpl2 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.cvvAfterTextChange(editable);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl3 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.anotherCardClicked(view);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl4 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.crossClicked(view);
        }
    }

    public static class OnClickListenerImpl5 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl5 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.openLink(view);
        }
    }

    public static class OnClickListenerImpl6 implements View.OnClickListener {
        private EmiViewModel value;

        public OnClickListenerImpl6 setValue(EmiViewModel emiViewModel) {
            this.value = emiViewModel;
            if (emiViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedToPay(view);
        }
    }
}
