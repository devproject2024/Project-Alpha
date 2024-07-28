package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
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
import net.one97.paytm.nativesdk.generated.callback.OnClickListener;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.viewmodel.PaytmPaymentsBankViewModel;

public class NativesdkPaymentsBankInfoBindingImpl extends NativesdkPaymentsBankInfoBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnCheckedChangeListenerImpl mBankViewModelOnCheckChangedTermsAndroidWidgetCompoundButtonOnCheckedChangeListener;
    private AfterTextChangedImpl mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl mBankViewModelProceedClickedAndroidViewViewOnClickListener;
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final FrameLayout mboundView19;
    private final TextView mboundView25;
    private final TextView mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_instrument_info, 26);
        sViewsWithIds.put(R.id.tv_promotion, 27);
        sViewsWithIds.put(R.id.bank_pin_layout, 28);
        sViewsWithIds.put(R.id.ltv_getOffers, 29);
        sViewsWithIds.put(R.id.ltv_loading, 30);
    }

    public NativesdkPaymentsBankInfoBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 31, sIncludes, sViewsWithIds));
    }

    private NativesdkPaymentsBankInfoBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 29, objArr[28], objArr[23], objArr[14], objArr[16], objArr[20], objArr[26], objArr[12], objArr[13], objArr[29], objArr[30], objArr[7], objArr[8], objArr[24], objArr[1], objArr[18], objArr[21], objArr[22], objArr[11], objArr[3], objArr[9], objArr[27], objArr[15], objArr[17], objArr[2], objArr[5], objArr[4]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.cbTermsAndCondition.setTag((Object) null);
        this.etPaytmPasscode.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llMictLines.setTag((Object) null);
        this.llTermConditions.setTag((Object) null);
        this.lytFetchPaymentBankBalance.setTag((Object) null);
        this.lytValidatingOtp.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView10 = objArr[10];
        this.mboundView10.setTag((Object) null);
        this.mboundView19 = objArr[19];
        this.mboundView19.setTag((Object) null);
        this.mboundView25 = objArr[25];
        this.mboundView25.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.paysecurely.setTag((Object) null);
        this.rbCardNumber.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvConvFee.setTag((Object) null);
        this.tvDisableErrorMessage.setTag((Object) null);
        this.tvNewTxt.setTag((Object) null);
        this.tvPayback.setTag((Object) null);
        this.tvTerms.setTag((Object) null);
        this.txtErrorMsg.setTag((Object) null);
        this.txtPrimaryInfo.setTag((Object) null);
        this.txtSecondaryInfo.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        this.mCallback4 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1073741824;
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
        if (BR.bankViewModel == i2) {
            setBankViewModel((PaytmPaymentsBankViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setBankViewModel(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel) {
        updateRegistration(3, (h) paytmPaymentsBankViewModel);
        this.mBankViewModel = paytmPaymentsBankViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.bankViewModel);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeBankViewModelPaybackVisibility((ObservableInt) obj, i3);
            case 1:
                return onChangeBankViewModelConvFeeTextVisibility((ObservableInt) obj, i3);
            case 2:
                return onChangeBankViewModelTermVisibility((ObservableInt) obj, i3);
            case 3:
                return onChangeBankViewModel((PaytmPaymentsBankViewModel) obj, i3);
            case 4:
                return onChangeBankViewModelErrorMsgVisibility((ObservableInt) obj, i3);
            case 5:
                return onChangeBankViewModelMSecondaryInformation((i) obj, i3);
            case 6:
                return onChangeBankViewModelFetchBalanceMsgVisiblity((ObservableInt) obj, i3);
            case 7:
                return onChangeBankViewModelInsufficuentAmountError((i) obj, i3);
            case 8:
                return onChangeBankViewModelDisplayTextPostPaid((i) obj, i3);
            case 9:
                return onChangeBankViewModelConvFeeText((i) obj, i3);
            case 10:
                return onChangeBankViewModelMictLinesVisibility((ObservableInt) obj, i3);
            case 11:
                return onChangeBankViewModelPinError((i) obj, i3);
            case 12:
                return onChangeBankViewModelBankOfferVisibility((ObservableInt) obj, i3);
            case 13:
                return onChangeBankViewModelBankOfferText((i) obj, i3);
            case 14:
                return onChangeBankViewModelAmount((i) obj, i3);
            case 15:
                return onChangeBankViewModelTermsNConditionPostPaid((i) obj, i3);
            case 16:
                return onChangeBankViewModelRadioChecked((ObservableBoolean) obj, i3);
            case 17:
                return onChangeBankViewModelDisableMessageVisibility((ObservableInt) obj, i3);
            case 18:
                return onChangeBankViewModelAmountVisibility((ObservableInt) obj, i3);
            case 19:
                return onChangeBankViewModelBalanceTxtVisiblity((ObservableInt) obj, i3);
            case 20:
                return onChangeBankViewModelLoaderVisibility((ObservableInt) obj, i3);
            case 21:
                return onChangeBankViewModelPaySecurelyText((i) obj, i3);
            case 22:
                return onChangeBankViewModelLoaderMsg((i) obj, i3);
            case 23:
                return onChangeBankViewModelNewVisibility((ObservableInt) obj, i3);
            case 24:
                return onChangeBankViewModelCashBackText((i) obj, i3);
            case 25:
                return onChangeBankViewModelErrorPostPaid((i) obj, i3);
            case 26:
                return onChangeBankViewModelValidatingOtpVisiblity((ObservableInt) obj, i3);
            case 27:
                return onChangeBankViewModelDisableMessage((i) obj, i3);
            case 28:
                return onChangeBankViewModelMPrimaryInformation((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeBankViewModelPaybackVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBankViewModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBankViewModelTermVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeBankViewModel(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeBankViewModelErrorMsgVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeBankViewModelMSecondaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeBankViewModelFetchBalanceMsgVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeBankViewModelInsufficuentAmountError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeBankViewModelDisplayTextPostPaid(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBankViewModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeBankViewModelMictLinesVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeBankViewModelPinError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeBankViewModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeBankViewModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeBankViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeBankViewModelTermsNConditionPostPaid(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeBankViewModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeBankViewModelDisableMessageVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeBankViewModelAmountVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeBankViewModelBalanceTxtVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeBankViewModelLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeBankViewModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeBankViewModelLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeBankViewModelNewVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    private boolean onChangeBankViewModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        return true;
    }

    private boolean onChangeBankViewModelErrorPostPaid(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 33554432;
        }
        return true;
    }

    private boolean onChangeBankViewModelValidatingOtpVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 67108864;
        }
        return true;
    }

    private boolean onChangeBankViewModelDisableMessage(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 134217728;
        }
        return true;
    }

    private boolean onChangeBankViewModelMPrimaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 268435456;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r86 = this;
            r1 = r86
            monitor-enter(r86)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0775 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0775 }
            monitor-exit(r86)     // Catch:{ all -> 0x0775 }
            net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.viewmodel.PaytmPaymentsBankViewModel r0 = r1.mBankViewModel
            r6 = 1610612735(0x5fffffff, double:7.95748421E-315)
            long r6 = r6 & r2
            r12 = 1073741848(0x40000018, double:5.304989596E-315)
            r16 = 1073741836(0x4000000c, double:5.304989537E-315)
            r18 = 1073741832(0x40000008, double:5.304989517E-315)
            r20 = 1073741834(0x4000000a, double:5.304989527E-315)
            r22 = 1073741833(0x40000009, double:5.30498952E-315)
            r24 = 137438953472(0x2000000000, double:6.7903865311E-313)
            r26 = 1074790410(0x4010000a, double:5.31017018E-315)
            r15 = 1
            r14 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0503
            long r6 = r2 & r22
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0043
            if (r0 == 0) goto L_0x0038
            androidx.databinding.ObservableInt r6 = r0.paybackVisibility
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0043
            int r6 = r6.get()
            goto L_0x0044
        L_0x0043:
            r6 = 0
        L_0x0044:
            long r33 = r2 & r20
            int r7 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x004f
            androidx.databinding.ObservableInt r7 = r0.convFeeTextVisibility
            goto L_0x0050
        L_0x004f:
            r7 = 0
        L_0x0050:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x005b
            int r9 = r7.get()
            goto L_0x005c
        L_0x005a:
            r7 = 0
        L_0x005b:
            r9 = 0
        L_0x005c:
            long r33 = r2 & r16
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0067
            androidx.databinding.ObservableInt r14 = r0.termVisibility
            goto L_0x0068
        L_0x0067:
            r14 = 0
        L_0x0068:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0073
            int r14 = r14.get()
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            long r35 = r2 & r18
            int r8 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00aa
            if (r0 == 0) goto L_0x00aa
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnClickListenerImpl r8 = r1.mBankViewModelProceedClickedAndroidViewViewOnClickListener
            if (r8 != 0) goto L_0x0087
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnClickListenerImpl r8 = new net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnClickListenerImpl
            r8.<init>()
            r1.mBankViewModelProceedClickedAndroidViewViewOnClickListener = r8
        L_0x0087:
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnClickListenerImpl r8 = r8.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$AfterTextChangedImpl r15 = r1.mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r15 != 0) goto L_0x0096
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$AfterTextChangedImpl r15 = new net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$AfterTextChangedImpl
            r15.<init>()
            r1.mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r15
        L_0x0096:
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$AfterTextChangedImpl r15 = r15.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnCheckedChangeListenerImpl r10 = r1.mBankViewModelOnCheckChangedTermsAndroidWidgetCompoundButtonOnCheckedChangeListener
            if (r10 != 0) goto L_0x00a5
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnCheckedChangeListenerImpl r10 = new net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnCheckedChangeListenerImpl
            r10.<init>()
            r1.mBankViewModelOnCheckChangedTermsAndroidWidgetCompoundButtonOnCheckedChangeListener = r10
        L_0x00a5:
            net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl$OnCheckedChangeListenerImpl r10 = r10.setValue(r0)
            goto L_0x00ad
        L_0x00aa:
            r8 = 0
            r10 = 0
            r15 = 0
        L_0x00ad:
            long r37 = r2 & r12
            int r11 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00c4
            if (r0 == 0) goto L_0x00b8
            androidx.databinding.ObservableInt r11 = r0.errorMsgVisibility
            goto L_0x00b9
        L_0x00b8:
            r11 = 0
        L_0x00b9:
            r12 = 4
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00c4
            int r11 = r11.get()
            goto L_0x00c5
        L_0x00c4:
            r11 = 0
        L_0x00c5:
            r12 = 1073741864(0x40000028, double:5.304989675E-315)
            long r39 = r2 & r12
            int r12 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00e1
            if (r0 == 0) goto L_0x00d3
            androidx.databinding.i<java.lang.String> r12 = r0.mSecondaryInformation
            goto L_0x00d4
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            r13 = 5
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00e1
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00e2
        L_0x00e1:
            r12 = 0
        L_0x00e2:
            r31 = 1073741896(0x40000048, double:5.304989833E-315)
            long r39 = r2 & r31
            int r13 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00fc
            if (r0 == 0) goto L_0x00f0
            androidx.databinding.ObservableInt r13 = r0.fetchBalanceMsgVisiblity
            goto L_0x00f1
        L_0x00f0:
            r13 = 0
        L_0x00f1:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00fc
            int r4 = r13.get()
            goto L_0x00fd
        L_0x00fc:
            r4 = 0
        L_0x00fd:
            r41 = 1073741960(0x40000088, double:5.30499015E-315)
            long r41 = r2 & r41
            r39 = 0
            int r5 = (r41 > r39 ? 1 : (r41 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0144
            if (r0 == 0) goto L_0x010f
            androidx.databinding.i<java.lang.String> r13 = r0.insufficuentAmountError
            r41 = r4
            goto L_0x0112
        L_0x010f:
            r41 = r4
            r13 = 0
        L_0x0112:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x011f
            java.lang.Object r4 = r13.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0120
        L_0x011f:
            r4 = 0
        L_0x0120:
            if (r4 == 0) goto L_0x0127
            int r13 = r4.length()
            goto L_0x0128
        L_0x0127:
            r13 = 0
        L_0x0128:
            if (r13 <= 0) goto L_0x012c
            r13 = 1
            goto L_0x012d
        L_0x012c:
            r13 = 0
        L_0x012d:
            if (r5 == 0) goto L_0x013e
            if (r13 == 0) goto L_0x0137
            r42 = 17179869184(0x400000000, double:8.4879831639E-314)
            goto L_0x013c
        L_0x0137:
            r42 = 8589934592(0x200000000, double:4.243991582E-314)
        L_0x013c:
            long r2 = r2 | r42
        L_0x013e:
            if (r13 == 0) goto L_0x0141
            goto L_0x0147
        L_0x0141:
            r5 = 8
            goto L_0x0148
        L_0x0144:
            r41 = r4
            r4 = 0
        L_0x0147:
            r5 = 0
        L_0x0148:
            r42 = 1073742088(0x40000108, double:5.30499078E-315)
            long r42 = r2 & r42
            r39 = 0
            int r13 = (r42 > r39 ? 1 : (r42 == r39 ? 0 : -1))
            if (r13 == 0) goto L_0x016d
            if (r0 == 0) goto L_0x015c
            androidx.databinding.i<java.lang.String> r13 = r0.displayTextPostPaid
            r30 = r4
            r4 = 8
            goto L_0x0161
        L_0x015c:
            r30 = r4
            r4 = 8
            r13 = 0
        L_0x0161:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0171
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0172
        L_0x016d:
            r30 = r4
            r4 = 8
        L_0x0171:
            r13 = 0
        L_0x0172:
            r42 = 1073742344(0x40000208, double:5.304992047E-315)
            long r42 = r2 & r42
            r39 = 0
            int r44 = (r42 > r39 ? 1 : (r42 == r39 ? 0 : -1))
            if (r44 == 0) goto L_0x0195
            if (r0 == 0) goto L_0x0184
            androidx.databinding.i<android.text.SpannableString> r4 = r0.convFeeText
            r43 = r5
            goto L_0x0187
        L_0x0184:
            r43 = r5
            r4 = 0
        L_0x0187:
            r5 = 9
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0197
            java.lang.Object r4 = r4.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x0198
        L_0x0195:
            r43 = r5
        L_0x0197:
            r4 = 0
        L_0x0198:
            r28 = 1073742856(0x40000408, double:5.304994576E-315)
            long r44 = r2 & r28
            r39 = 0
            int r5 = (r44 > r39 ? 1 : (r44 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x01b9
            if (r0 == 0) goto L_0x01aa
            androidx.databinding.ObservableInt r5 = r0.mictLinesVisibility
            r44 = r4
            goto L_0x01ad
        L_0x01aa:
            r44 = r4
            r5 = 0
        L_0x01ad:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01bb
            int r4 = r5.get()
            goto L_0x01bc
        L_0x01b9:
            r44 = r4
        L_0x01bb:
            r4 = 0
        L_0x01bc:
            r45 = 1073743880(0x40000808, double:5.304999635E-315)
            long r45 = r2 & r45
            r39 = 0
            int r5 = (r45 > r39 ? 1 : (r45 == r39 ? 0 : -1))
            r45 = r4
            if (r5 == 0) goto L_0x0206
            if (r0 == 0) goto L_0x01d0
            androidx.databinding.i<java.lang.String> r4 = r0.pinError
            r46 = r6
            goto L_0x01d3
        L_0x01d0:
            r46 = r6
            r4 = 0
        L_0x01d3:
            r6 = 11
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01e1
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01e2
        L_0x01e1:
            r4 = 0
        L_0x01e2:
            if (r4 == 0) goto L_0x01e9
            int r6 = r4.length()
            goto L_0x01ea
        L_0x01e9:
            r6 = 0
        L_0x01ea:
            if (r6 <= 0) goto L_0x01ee
            r6 = 1
            goto L_0x01ef
        L_0x01ee:
            r6 = 0
        L_0x01ef:
            if (r5 == 0) goto L_0x0200
            if (r6 == 0) goto L_0x01f9
            r47 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x01fe
        L_0x01f9:
            r47 = 2147483648(0x80000000, double:1.0609978955E-314)
        L_0x01fe:
            long r2 = r2 | r47
        L_0x0200:
            if (r6 == 0) goto L_0x0203
            goto L_0x0209
        L_0x0203:
            r5 = 8
            goto L_0x020a
        L_0x0206:
            r46 = r6
            r4 = 0
        L_0x0209:
            r5 = 0
        L_0x020a:
            r47 = 1073745928(0x40001008, double:5.305009754E-315)
            long r47 = r2 & r47
            r39 = 0
            int r6 = (r47 > r39 ? 1 : (r47 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x022b
            if (r0 == 0) goto L_0x021c
            androidx.databinding.ObservableInt r6 = r0.bankOfferVisibility
            r47 = r4
            goto L_0x021f
        L_0x021c:
            r47 = r4
            r6 = 0
        L_0x021f:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x022d
            int r4 = r6.get()
            goto L_0x022e
        L_0x022b:
            r47 = r4
        L_0x022d:
            r4 = 0
        L_0x022e:
            r48 = 1073750024(0x40002008, double:5.30502999E-315)
            long r48 = r2 & r48
            r39 = 0
            int r6 = (r48 > r39 ? 1 : (r48 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0251
            if (r0 == 0) goto L_0x0240
            androidx.databinding.i r6 = r0.bankOfferText
            r48 = r4
            goto L_0x0243
        L_0x0240:
            r48 = r4
            r6 = 0
        L_0x0243:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0253
            java.lang.Object r4 = r6.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x0254
        L_0x0251:
            r48 = r4
        L_0x0253:
            r4 = 0
        L_0x0254:
            r49 = 1073758216(0x40004008, double:5.305070465E-315)
            long r49 = r2 & r49
            r39 = 0
            int r6 = (r49 > r39 ? 1 : (r49 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0277
            if (r0 == 0) goto L_0x0266
            androidx.databinding.i<java.lang.String> r6 = r0.amount
            r49 = r4
            goto L_0x0269
        L_0x0266:
            r49 = r4
            r6 = 0
        L_0x0269:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0279
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x027a
        L_0x0277:
            r49 = r4
        L_0x0279:
            r4 = 0
        L_0x027a:
            r50 = 1073774600(0x40008008, double:5.30515141E-315)
            long r50 = r2 & r50
            r39 = 0
            int r6 = (r50 > r39 ? 1 : (r50 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x029d
            if (r0 == 0) goto L_0x028c
            androidx.databinding.i<android.text.SpannableString> r6 = r0.termsNConditionPostPaid
            r50 = r4
            goto L_0x028f
        L_0x028c:
            r50 = r4
            r6 = 0
        L_0x028f:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x029f
            java.lang.Object r4 = r6.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x02a0
        L_0x029d:
            r50 = r4
        L_0x029f:
            r4 = 0
        L_0x02a0:
            r51 = 1073807368(0x40010008, double:5.30531331E-315)
            long r51 = r2 & r51
            r39 = 0
            int r6 = (r51 > r39 ? 1 : (r51 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x02c1
            if (r0 == 0) goto L_0x02b2
            androidx.databinding.ObservableBoolean r6 = r0.radioChecked
            r51 = r4
            goto L_0x02b5
        L_0x02b2:
            r51 = r4
            r6 = 0
        L_0x02b5:
            r4 = 16
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x02c3
            boolean r4 = r6.get()
            goto L_0x02c4
        L_0x02c1:
            r51 = r4
        L_0x02c3:
            r4 = 0
        L_0x02c4:
            r52 = 1073872904(0x40020008, double:5.3056371E-315)
            long r52 = r2 & r52
            r39 = 0
            int r6 = (r52 > r39 ? 1 : (r52 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x02e5
            if (r0 == 0) goto L_0x02d6
            androidx.databinding.ObservableInt r6 = r0.disableMessageVisibility
            r52 = r4
            goto L_0x02d9
        L_0x02d6:
            r52 = r4
            r6 = 0
        L_0x02d9:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x02e7
            int r4 = r6.get()
            goto L_0x02e8
        L_0x02e5:
            r52 = r4
        L_0x02e7:
            r4 = 0
        L_0x02e8:
            r53 = 1074003976(0x40040008, double:5.30628468E-315)
            long r53 = r2 & r53
            r39 = 0
            int r6 = (r53 > r39 ? 1 : (r53 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0309
            if (r0 == 0) goto L_0x02fa
            androidx.databinding.ObservableInt r6 = r0.amountVisibility
            r53 = r4
            goto L_0x02fd
        L_0x02fa:
            r53 = r4
            r6 = 0
        L_0x02fd:
            r4 = 18
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x030b
            int r4 = r6.get()
            goto L_0x030c
        L_0x0309:
            r53 = r4
        L_0x030b:
            r4 = 0
        L_0x030c:
            r54 = 1074266120(0x40080008, double:5.307579844E-315)
            long r54 = r2 & r54
            r39 = 0
            int r6 = (r54 > r39 ? 1 : (r54 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x032d
            if (r0 == 0) goto L_0x031e
            androidx.databinding.ObservableInt r6 = r0.balanceTxtVisiblity
            r54 = r4
            goto L_0x0321
        L_0x031e:
            r54 = r4
            r6 = 0
        L_0x0321:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x032f
            int r4 = r6.get()
            goto L_0x0330
        L_0x032d:
            r54 = r4
        L_0x032f:
            r4 = 0
        L_0x0330:
            long r55 = r2 & r26
            r39 = 0
            int r6 = (r55 > r39 ? 1 : (r55 == r39 ? 0 : -1))
            r55 = r4
            if (r6 == 0) goto L_0x0365
            if (r0 == 0) goto L_0x0341
            androidx.databinding.ObservableInt r4 = r0.loaderVisibility
            r56 = r5
            goto L_0x0344
        L_0x0341:
            r56 = r5
            r4 = 0
        L_0x0344:
            r5 = 20
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0350
            int r4 = r4.get()
            goto L_0x0351
        L_0x0350:
            r4 = 0
        L_0x0351:
            if (r4 != 0) goto L_0x0355
            r5 = 1
            goto L_0x0356
        L_0x0355:
            r5 = 0
        L_0x0356:
            if (r6 == 0) goto L_0x0369
            if (r5 == 0) goto L_0x0362
            r57 = 274877906944(0x4000000000, double:1.358077306218E-312)
            long r2 = r2 | r57
            goto L_0x0369
        L_0x0362:
            long r2 = r2 | r24
            goto L_0x0369
        L_0x0365:
            r56 = r5
            r4 = 0
            r5 = 0
        L_0x0369:
            r57 = 1075838984(0x40200008, double:5.315350825E-315)
            long r57 = r2 & r57
            r39 = 0
            int r6 = (r57 > r39 ? 1 : (r57 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x038c
            if (r0 == 0) goto L_0x037b
            androidx.databinding.i<java.lang.String> r6 = r0.paySecurelyText
            r57 = r4
            goto L_0x037e
        L_0x037b:
            r57 = r4
            r6 = 0
        L_0x037e:
            r4 = 21
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x038e
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x038f
        L_0x038c:
            r57 = r4
        L_0x038e:
            r4 = 0
        L_0x038f:
            r58 = 1077936136(0x40400008, double:5.32571213E-315)
            long r58 = r2 & r58
            r39 = 0
            int r6 = (r58 > r39 ? 1 : (r58 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x03b2
            if (r0 == 0) goto L_0x03a1
            androidx.databinding.i<java.lang.String> r6 = r0.loaderMsg
            r58 = r4
            goto L_0x03a4
        L_0x03a1:
            r58 = r4
            r6 = 0
        L_0x03a4:
            r4 = 22
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x03b4
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x03b5
        L_0x03b2:
            r58 = r4
        L_0x03b4:
            r4 = 0
        L_0x03b5:
            r59 = 1082130440(0x40800008, double:5.346434747E-315)
            long r59 = r2 & r59
            r39 = 0
            int r6 = (r59 > r39 ? 1 : (r59 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x03d6
            if (r0 == 0) goto L_0x03c7
            androidx.databinding.ObservableInt r6 = r0.newVisibility
            r59 = r4
            goto L_0x03ca
        L_0x03c7:
            r59 = r4
            r6 = 0
        L_0x03ca:
            r4 = 23
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x03d8
            int r4 = r6.get()
            goto L_0x03d9
        L_0x03d6:
            r59 = r4
        L_0x03d8:
            r4 = 0
        L_0x03d9:
            r60 = 1090519048(0x41000008, double:5.387879978E-315)
            long r60 = r2 & r60
            r39 = 0
            int r6 = (r60 > r39 ? 1 : (r60 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x03fc
            if (r0 == 0) goto L_0x03eb
            androidx.databinding.i<java.lang.String> r6 = r0.cashBackText
            r60 = r4
            goto L_0x03ee
        L_0x03eb:
            r60 = r4
            r6 = 0
        L_0x03ee:
            r4 = 24
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x03fe
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x03ff
        L_0x03fc:
            r60 = r4
        L_0x03fe:
            r4 = 0
        L_0x03ff:
            r61 = 1107296264(0x42000008, double:5.47077044E-315)
            long r61 = r2 & r61
            r39 = 0
            int r6 = (r61 > r39 ? 1 : (r61 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0422
            if (r0 == 0) goto L_0x0411
            androidx.databinding.i<java.lang.String> r6 = r0.errorPostPaid
            r61 = r4
            goto L_0x0414
        L_0x0411:
            r61 = r4
            r6 = 0
        L_0x0414:
            r4 = 25
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0424
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0425
        L_0x0422:
            r61 = r4
        L_0x0424:
            r4 = 0
        L_0x0425:
            r62 = 1140850696(0x44000008, double:5.63655136E-315)
            long r62 = r2 & r62
            r39 = 0
            int r6 = (r62 > r39 ? 1 : (r62 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0446
            if (r0 == 0) goto L_0x0437
            androidx.databinding.ObservableInt r6 = r0.validatingOtpVisiblity
            r62 = r4
            goto L_0x043a
        L_0x0437:
            r62 = r4
            r6 = 0
        L_0x043a:
            r4 = 26
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0448
            int r4 = r6.get()
            goto L_0x0449
        L_0x0446:
            r62 = r4
        L_0x0448:
            r4 = 0
        L_0x0449:
            r63 = 1207959560(0x48000008, double:5.9681132E-315)
            long r63 = r2 & r63
            r39 = 0
            int r6 = (r63 > r39 ? 1 : (r63 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x046c
            if (r0 == 0) goto L_0x045b
            androidx.databinding.i<java.lang.String> r6 = r0.disableMessage
            r63 = r4
            goto L_0x045e
        L_0x045b:
            r63 = r4
            r6 = 0
        L_0x045e:
            r4 = 27
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x046e
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x046f
        L_0x046c:
            r63 = r4
        L_0x046e:
            r4 = 0
        L_0x046f:
            r64 = 1342177288(0x50000008, double:6.631236886E-315)
            long r64 = r2 & r64
            r39 = 0
            int r6 = (r64 > r39 ? 1 : (r64 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x04c4
            if (r0 == 0) goto L_0x0481
            androidx.databinding.i<java.lang.String> r6 = r0.mPrimaryInformation
            r64 = r2
            goto L_0x0484
        L_0x0481:
            r64 = r2
            r6 = 0
        L_0x0484:
            r2 = 28
            r1.updateRegistration((int) r2, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x04c6
            java.lang.Object r2 = r6.get()
            java.lang.String r2 = (java.lang.String) r2
            r80 = r2
            r73 = r4
            r81 = r12
            r75 = r13
            r4 = r41
            r71 = r44
            r3 = r45
            r76 = r46
            r78 = r47
            r69 = r48
            r68 = r49
            r83 = r50
            r77 = r51
            r67 = r52
            r72 = r53
            r84 = r54
            r82 = r55
            r79 = r56
            r2 = r57
            r66 = r58
            r70 = r59
            r74 = r60
            r13 = r61
            r12 = r62
            r6 = r63
            goto L_0x04f8
        L_0x04c4:
            r64 = r2
        L_0x04c6:
            r73 = r4
            r81 = r12
            r75 = r13
            r4 = r41
            r71 = r44
            r3 = r45
            r76 = r46
            r78 = r47
            r69 = r48
            r68 = r49
            r83 = r50
            r77 = r51
            r67 = r52
            r72 = r53
            r84 = r54
            r82 = r55
            r79 = r56
            r2 = r57
            r66 = r58
            r70 = r59
            r74 = r60
            r13 = r61
            r12 = r62
            r6 = r63
            r80 = 0
        L_0x04f8:
            r41 = r9
            r9 = r43
            r85 = r30
            r30 = r7
            r7 = r85
            goto L_0x053d
        L_0x0503:
            r64 = r2
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
            r30 = 0
            r41 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
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
        L_0x053d:
            long r24 = r64 & r24
            r39 = 0
            int r43 = (r24 > r39 ? 1 : (r24 == r39 ? 0 : -1))
            if (r43 == 0) goto L_0x0562
            if (r0 == 0) goto L_0x054c
            androidx.databinding.ObservableInt r0 = r0.convFeeTextVisibility
            r24 = r9
            goto L_0x0550
        L_0x054c:
            r24 = r9
            r0 = r30
        L_0x0550:
            r9 = 1
            r1.updateRegistration((int) r9, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x055a
            int r41 = r0.get()
        L_0x055a:
            if (r41 != 0) goto L_0x055e
            r0 = 1
            goto L_0x055f
        L_0x055e:
            r0 = 0
        L_0x055f:
            r9 = r41
            goto L_0x0567
        L_0x0562:
            r24 = r9
            r9 = r41
            r0 = 0
        L_0x0567:
            long r43 = r64 & r26
            r39 = 0
            int r25 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r25 == 0) goto L_0x058d
            if (r5 == 0) goto L_0x0572
            r0 = 1
        L_0x0572:
            if (r25 == 0) goto L_0x0583
            if (r0 == 0) goto L_0x057c
            r43 = 68719476736(0x1000000000, double:3.39519326554E-313)
            goto L_0x0581
        L_0x057c:
            r43 = 34359738368(0x800000000, double:1.69759663277E-313)
        L_0x0581:
            long r64 = r64 | r43
        L_0x0583:
            if (r0 == 0) goto L_0x0588
            r33 = 0
            goto L_0x058a
        L_0x0588:
            r33 = 8
        L_0x058a:
            r0 = r33
            goto L_0x058e
        L_0x058d:
            r0 = 0
        L_0x058e:
            long r18 = r64 & r18
            r39 = 0
            int r5 = (r18 > r39 ? 1 : (r18 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x05a6
            android.widget.RelativeLayout r5 = r1.btnProceed
            r5.setOnClickListener(r8)
            android.widget.CheckBox r5 = r1.cbTermsAndCondition
            r5.setOnCheckedChangeListener(r10)
            android.widget.EditText r5 = r1.etPaytmPasscode
            r8 = 0
            androidx.databinding.a.d.a(r5, r8, r15, r8)
        L_0x05a6:
            r18 = 1074790408(0x40100008, double:5.31017017E-315)
            long r18 = r64 & r18
            r33 = 0
            int r5 = (r18 > r33 ? 1 : (r18 == r33 ? 0 : -1))
            if (r5 == 0) goto L_0x05b6
            android.widget.LinearLayout r5 = r1.llCheckOffer
            r5.setVisibility(r2)
        L_0x05b6:
            r18 = 1073742856(0x40000408, double:5.304994576E-315)
            long r18 = r64 & r18
            int r2 = (r18 > r33 ? 1 : (r18 == r33 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            android.widget.LinearLayout r2 = r1.llMictLines
            r2.setVisibility(r3)
        L_0x05c4:
            long r2 = r64 & r16
            int r5 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r5 == 0) goto L_0x05cf
            android.widget.LinearLayout r2 = r1.llTermConditions
            r2.setVisibility(r14)
        L_0x05cf:
            r2 = 1073741896(0x40000048, double:5.304989833E-315)
            long r2 = r64 & r2
            int r5 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r5 == 0) goto L_0x05dd
            android.widget.LinearLayout r2 = r1.lytFetchPaymentBankBalance
            r2.setVisibility(r4)
        L_0x05dd:
            r2 = 1140850696(0x44000008, double:5.63655136E-315)
            long r2 = r64 & r2
            int r4 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r4 == 0) goto L_0x05eb
            android.widget.LinearLayout r2 = r1.lytValidatingOtp
            r2.setVisibility(r6)
        L_0x05eb:
            r2 = 1073741824(0x40000000, double:5.304989477E-315)
            long r2 = r64 & r2
            int r4 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r4 == 0) goto L_0x05fb
            android.widget.LinearLayout r2 = r1.mboundView0
            android.view.View$OnClickListener r3 = r1.mCallback4
            r2.setOnClickListener(r3)
        L_0x05fb:
            r2 = 1073741848(0x40000018, double:5.304989596E-315)
            long r2 = r64 & r2
            int r4 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r4 == 0) goto L_0x0609
            android.widget.TextView r2 = r1.mboundView10
            r2.setVisibility(r11)
        L_0x0609:
            r2 = 1107296264(0x42000008, double:5.47077044E-315)
            long r2 = r64 & r2
            int r4 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r4 == 0) goto L_0x0617
            android.widget.TextView r2 = r1.mboundView10
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r12)
        L_0x0617:
            long r2 = r64 & r26
            int r4 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r4 == 0) goto L_0x0622
            android.widget.FrameLayout r2 = r1.mboundView19
            r2.setVisibility(r0)
        L_0x0622:
            r2 = 1090519048(0x41000008, double:5.387879978E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0630
            android.widget.TextView r0 = r1.mboundView25
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x0630:
            r2 = 1073741960(0x40000088, double:5.30499015E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0645
            android.widget.TextView r0 = r1.mboundView6
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.mboundView6
            r2 = r24
            r0.setVisibility(r2)
        L_0x0645:
            r2 = 1075838984(0x40200008, double:5.315350825E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0655
            android.widget.TextView r0 = r1.paysecurely
            r2 = r66
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0655:
            r2 = 1073807368(0x40010008, double:5.30531331E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0665
            android.widget.RadioButton r0 = r1.rbCardNumber
            r2 = r67
            androidx.databinding.a.a.a(r0, r2)
        L_0x0665:
            r2 = 1073750024(0x40002008, double:5.30502999E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0675
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r2 = r68
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0675:
            r2 = 1073745928(0x40001008, double:5.305009754E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0685
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r2 = r69
            r0.setVisibility(r2)
        L_0x0685:
            r2 = 1077936136(0x40400008, double:5.32571213E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0695
            android.widget.TextView r0 = r1.tvCheckingOffers
            r2 = r70
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0695:
            r2 = 1073742344(0x40000208, double:5.304992047E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06a5
            android.widget.TextView r0 = r1.tvConvFee
            r2 = r71
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x06a5:
            long r2 = r64 & r20
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06b0
            android.widget.TextView r0 = r1.tvConvFee
            r0.setVisibility(r9)
        L_0x06b0:
            r2 = 1073872904(0x40020008, double:5.3056371E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06c0
            android.widget.TextView r0 = r1.tvDisableErrorMessage
            r2 = r72
            r0.setVisibility(r2)
        L_0x06c0:
            r2 = 1207959560(0x48000008, double:5.9681132E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06d0
            android.widget.TextView r0 = r1.tvDisableErrorMessage
            r4 = r73
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x06d0:
            r2 = 1082130440(0x40800008, double:5.346434747E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06e0
            android.widget.TextView r0 = r1.tvNewTxt
            r2 = r74
            r0.setVisibility(r2)
        L_0x06e0:
            r2 = 1073742088(0x40000108, double:5.30499078E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06f0
            android.widget.TextView r0 = r1.tvPayback
            r13 = r75
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x06f0:
            long r2 = r64 & r22
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x06fd
            android.widget.TextView r0 = r1.tvPayback
            r2 = r76
            r0.setVisibility(r2)
        L_0x06fd:
            r2 = 1073774600(0x40008008, double:5.30515141E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x070d
            android.widget.TextView r0 = r1.tvTerms
            r2 = r77
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x070d:
            r2 = 1073743880(0x40000808, double:5.304999635E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0724
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtErrorMsg
            r2 = r78
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtErrorMsg
            r2 = r79
            r0.setVisibility(r2)
        L_0x0724:
            r2 = 1342177288(0x50000008, double:6.631236886E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0734
            android.widget.TextView r0 = r1.txtPrimaryInfo
            r2 = r80
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0734:
            r2 = 1073741864(0x40000028, double:5.304989675E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0744
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtSecondaryInfo
            r12 = r81
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x0744:
            r2 = 1074266120(0x40080008, double:5.307579844E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0754
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtSecondaryInfo
            r2 = r82
            r0.setVisibility(r2)
        L_0x0754:
            r2 = 1073758216(0x40004008, double:5.305070465E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0764
            android.widget.TextView r0 = r1.txtamount
            r2 = r83
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0764:
            r2 = 1074003976(0x40040008, double:5.30628468E-315)
            long r2 = r64 & r2
            int r0 = (r2 > r33 ? 1 : (r2 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0774
            android.widget.TextView r0 = r1.txtamount
            r2 = r84
            r0.setVisibility(r2)
        L_0x0774:
            return
        L_0x0775:
            r0 = move-exception
            monitor-exit(r86)     // Catch:{ all -> 0x0775 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private PaytmPaymentsBankViewModel value;

        public OnClickListenerImpl setValue(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel) {
            this.value = paytmPaymentsBankViewModel;
            if (paytmPaymentsBankViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedClicked(view);
        }
    }

    public static class AfterTextChangedImpl implements d.a {
        private PaytmPaymentsBankViewModel value;

        public AfterTextChangedImpl setValue(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel) {
            this.value = paytmPaymentsBankViewModel;
            if (paytmPaymentsBankViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.onPasscodeTextChanged(editable);
        }
    }

    public static class OnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
        private PaytmPaymentsBankViewModel value;

        public OnCheckedChangeListenerImpl setValue(PaytmPaymentsBankViewModel paytmPaymentsBankViewModel) {
            this.value = paytmPaymentsBankViewModel;
            if (paytmPaymentsBankViewModel == null) {
                return null;
            }
            return this;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.value.onCheckChangedTerms(compoundButton, z);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        PaytmPaymentsBankViewModel paytmPaymentsBankViewModel = this.mBankViewModel;
        if (paytmPaymentsBankViewModel != null) {
            paytmPaymentsBankViewModel.payMethodSelected(view);
        }
    }
}
