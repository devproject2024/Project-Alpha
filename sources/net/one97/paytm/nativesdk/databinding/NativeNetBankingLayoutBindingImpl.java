package net.one97.paytm.nativesdk.databinding;

import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NetBankingViewModel;

public class NativeNetBankingLayoutBindingImpl extends NativeNetBankingLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mNetBankingViewModelOnShowOtherBankClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mNetBankingViewModelProceedClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mNetBankingViewModelSetBankListVisiblityAndroidViewViewOnClickListener;
    private final LinearLayout mboundView0;
    private final RelativeLayout mboundView1;
    private final TextView mboundView18;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_promotion, 21);
        sViewsWithIds.put(R.id.txtamount, 22);
        sViewsWithIds.put(R.id.ivRightArrow, 23);
        sViewsWithIds.put(R.id.animationLayout, 24);
        sViewsWithIds.put(R.id.img_bank, 25);
        sViewsWithIds.put(R.id.imgCross, 26);
        sViewsWithIds.put(R.id.ltv_getOffers, 27);
        sViewsWithIds.put(R.id.ltv_loading, 28);
        sViewsWithIds.put(R.id.upiIcon, 29);
        sViewsWithIds.put(R.id.iv_proceed_upi_forward_nb, 30);
    }

    public NativeNetBankingLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 31, sIncludes, sViewsWithIds));
    }

    private NativeNetBankingLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 23, objArr[24], objArr[16], objArr[10], objArr[25], objArr[26], objArr[7], objArr[30], objArr[23], objArr[13], objArr[9], objArr[27], objArr[28], objArr[5], objArr[2], objArr[4], objArr[12], objArr[14], objArr[15], objArr[17], objArr[21], objArr[11], objArr[8], objArr[3], objArr[6], objArr[22], objArr[29], objArr[19], objArr[20]);
        this.mDirtyFlags = -1;
        this.btnProceed.setTag((Object) null);
        this.cbUpiCheckbox.setTag((Object) null);
        this.imgTick.setTag((Object) null);
        this.llCheckOffer.setTag((Object) null);
        this.llUpiCheckbox.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView18 = objArr[18];
        this.mboundView18.setTag((Object) null);
        this.otherBankLayout.setTag((Object) null);
        this.radioButton.setTag((Object) null);
        this.recyclerBankList.setTag((Object) null);
        this.tvBankOffer.setTag((Object) null);
        this.tvCheckingOffers.setTag((Object) null);
        this.tvOtherBankConvFee.setTag((Object) null);
        this.tvProceedSecurely.setTag((Object) null);
        this.tvUpiCheckbox.setTag((Object) null);
        this.txtAmount.setTag((Object) null);
        this.txtHeaderInstrunmentName.setTag((Object) null);
        this.txtSelectOtherBank.setTag((Object) null);
        this.upiPayOption.setTag((Object) null);
        this.upiPayText.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216;
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
        if (BR.netBankingViewModel == i2) {
            setNetBankingViewModel((NetBankingViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setNetBankingViewModel(NetBankingViewModel netBankingViewModel) {
        updateRegistration(2, (h) netBankingViewModel);
        this.mNetBankingViewModel = netBankingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.netBankingViewModel);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeNetBankingViewModelBankOfferText((i) obj, i3);
            case 1:
                return onChangeNetBankingViewModelRadioChecked((ObservableBoolean) obj, i3);
            case 2:
                return onChangeNetBankingViewModel((NetBankingViewModel) obj, i3);
            case 3:
                return onChangeNetBankingViewModelUpiPayOptionVisibility((ObservableInt) obj, i3);
            case 4:
                return onChangeNetBankingViewModelUpiConsentBoxText((i) obj, i3);
            case 5:
                return onChangeNetBankingViewModelAmount((i) obj, i3);
            case 6:
                return onChangeNetBankingViewModelOtherBankLoaderVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeNetBankingViewModelUpiCheckboxLayoutVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeNetBankingViewModelOtherBankLoaderMsg((i) obj, i3);
            case 9:
                return onChangeNetBankingViewModelBankOfferVisibility((ObservableInt) obj, i3);
            case 10:
                return onChangeNetBankingViewModelCashBackText((i) obj, i3);
            case 11:
                return onChangeNetBankingViewModelProceedButtonVisiblity((ObservableInt) obj, i3);
            case 12:
                return onChangeNetBankingViewModelConvFeeText((i) obj, i3);
            case 13:
                return onChangeNetBankingViewModelShowOtherBankVisiblity((ObservableInt) obj, i3);
            case 14:
                return onChangeNetBankingViewModelUpiCheckboxChecked((ObservableBoolean) obj, i3);
            case 15:
                return onChangeNetBankingViewModelNetBankingTitle((i) obj, i3);
            case 16:
                return onChangeNetBankingViewModelCashBackTextVisibility((ObservableInt) obj, i3);
            case 17:
                return onChangeNetBankingViewModelOtherBankText((i) obj, i3);
            case 18:
                return onChangeNetBankingViewModelTickImage((ObservableInt) obj, i3);
            case 19:
                return onChangeNetBankingViewModelConvFeeTextVisibility((ObservableInt) obj, i3);
            case 20:
                return onChangeNetBankingViewModelNetBankingBankListVisiblity((ObservableInt) obj, i3);
            case 21:
                return onChangeNetBankingViewModelPaySecurelyText((i) obj, i3);
            case 22:
                return onChangeNetBankingViewModelUpiPayOptionText((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeNetBankingViewModelBankOfferText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelRadioChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModel(NetBankingViewModel netBankingViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelUpiPayOptionVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelUpiConsentBoxText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelOtherBankLoaderVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelUpiCheckboxLayoutVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelOtherBankLoaderMsg(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelBankOfferVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelCashBackText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelProceedButtonVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelConvFeeText(i<SpannableString> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelShowOtherBankVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelUpiCheckboxChecked(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelNetBankingTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelCashBackTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelOtherBankText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelTickImage(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelConvFeeTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelNetBankingBankListVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelPaySecurelyText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeNetBankingViewModelUpiPayOptionText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r70 = this;
            r1 = r70
            monitor-enter(r70)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0520 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0520 }
            monitor-exit(r70)     // Catch:{ all -> 0x0520 }
            net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NetBankingViewModel r0 = r1.mNetBankingViewModel
            r6 = 25165823(0x17fffff, double:1.24335686E-316)
            long r6 = r6 & r2
            r8 = 16777252(0x1000024, double:8.289064E-317)
            r12 = 16777236(0x1000014, double:8.289056E-317)
            r16 = 17039364(0x1040004, double:8.4185644E-317)
            r18 = 16777228(0x100000c, double:8.289052E-317)
            r20 = 16793604(0x1004004, double:8.297143E-317)
            r22 = 16777222(0x1000006, double:8.289049E-317)
            r24 = 16779268(0x1000804, double:8.29006E-317)
            r26 = 16777221(0x1000005, double:8.2890485E-317)
            r28 = 16777220(0x1000004, double:8.289048E-317)
            r10 = 0
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x03ac
            long r6 = r2 & r26
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x003b
            androidx.databinding.i r6 = r0.bankOfferText
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0048
            java.lang.Object r6 = r6.get()
            android.text.SpannableString r6 = (android.text.SpannableString) r6
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            long r32 = r2 & r22
            r7 = 1
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x0060
            if (r0 == 0) goto L_0x0055
            androidx.databinding.ObservableBoolean r10 = r0.radioChecked
            goto L_0x0056
        L_0x0055:
            r10 = 0
        L_0x0056:
            r1.updateRegistration((int) r7, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0060
            boolean r10 = r10.get()
            goto L_0x0061
        L_0x0060:
            r10 = 0
        L_0x0061:
            long r33 = r2 & r18
            int r35 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x0078
            if (r0 == 0) goto L_0x006c
            androidx.databinding.ObservableInt r7 = r0.upiPayOptionVisibility
            goto L_0x006d
        L_0x006c:
            r7 = 0
        L_0x006d:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0078
            int r7 = r7.get()
            goto L_0x0079
        L_0x0078:
            r7 = 0
        L_0x0079:
            long r35 = r2 & r28
            int r11 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x00af
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl r11 = r1.mNetBankingViewModelOnShowOtherBankClickAndroidViewViewOnClickListener
            if (r11 != 0) goto L_0x008c
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl r11 = new net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl
            r11.<init>()
            r1.mNetBankingViewModelOnShowOtherBankClickAndroidViewViewOnClickListener = r11
        L_0x008c:
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl r11 = r11.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl1 r14 = r1.mNetBankingViewModelSetBankListVisiblityAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x009b
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl1 r14 = new net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl1
            r14.<init>()
            r1.mNetBankingViewModelSetBankListVisiblityAndroidViewViewOnClickListener = r14
        L_0x009b:
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl1 r14 = r14.setValue(r0)
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl2 r15 = r1.mNetBankingViewModelProceedClickedAndroidViewViewOnClickListener
            if (r15 != 0) goto L_0x00aa
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl2 r15 = new net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl2
            r15.<init>()
            r1.mNetBankingViewModelProceedClickedAndroidViewViewOnClickListener = r15
        L_0x00aa:
            net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl$OnClickListenerImpl2 r15 = r15.setValue(r0)
            goto L_0x00b2
        L_0x00af:
            r11 = 0
            r14 = 0
            r15 = 0
        L_0x00b2:
            long r37 = r2 & r12
            int r39 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r39 == 0) goto L_0x00cb
            if (r0 == 0) goto L_0x00bd
            androidx.databinding.i<java.lang.String> r12 = r0.upiConsentBoxText
            goto L_0x00be
        L_0x00bd:
            r12 = 0
        L_0x00be:
            r13 = 4
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00cb
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00cc
        L_0x00cb:
            r12 = 0
        L_0x00cc:
            long r39 = r2 & r8
            int r13 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0108
            if (r0 == 0) goto L_0x00d7
            androidx.databinding.i<java.lang.String> r8 = r0.amount
            goto L_0x00d8
        L_0x00d7:
            r8 = 0
        L_0x00d8:
            r9 = 5
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x00e5
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            if (r8 == 0) goto L_0x00ed
            int r9 = r8.length()
            goto L_0x00ee
        L_0x00ed:
            r9 = 0
        L_0x00ee:
            if (r9 <= 0) goto L_0x00f3
            r33 = 1
            goto L_0x00f5
        L_0x00f3:
            r33 = 0
        L_0x00f5:
            if (r13 == 0) goto L_0x0102
            if (r33 == 0) goto L_0x00fd
            r41 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x0100
        L_0x00fd:
            r41 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x0100:
            long r2 = r2 | r41
        L_0x0102:
            if (r33 == 0) goto L_0x0105
            goto L_0x0109
        L_0x0105:
            r9 = 8
            goto L_0x010a
        L_0x0108:
            r8 = 0
        L_0x0109:
            r9 = 0
        L_0x010a:
            r35 = 16777284(0x1000044, double:8.2890797E-317)
            long r41 = r2 & r35
            int r13 = (r41 > r4 ? 1 : (r41 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0124
            if (r0 == 0) goto L_0x0118
            androidx.databinding.ObservableInt r13 = r0.otherBankLoaderVisibility
            goto L_0x0119
        L_0x0118:
            r13 = 0
        L_0x0119:
            r4 = 6
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0124
            int r4 = r13.get()
            goto L_0x0125
        L_0x0124:
            r4 = 0
        L_0x0125:
            r30 = 16777348(0x1000084, double:8.2891113E-317)
            long r43 = r2 & r30
            r41 = 0
            int r5 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x0135
            androidx.databinding.ObservableInt r5 = r0.upiCheckboxLayoutVisibility
            goto L_0x0136
        L_0x0135:
            r5 = 0
        L_0x0136:
            r13 = 7
            r1.updateRegistration((int) r13, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0141
            int r5 = r5.get()
            goto L_0x0142
        L_0x0141:
            r5 = 0
        L_0x0142:
            r43 = 16777476(0x1000104, double:8.2891745E-317)
            long r43 = r2 & r43
            r41 = 0
            int r13 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0165
            if (r0 == 0) goto L_0x0154
            androidx.databinding.i<java.lang.String> r13 = r0.otherBankLoaderMsg
            r33 = r4
            goto L_0x0157
        L_0x0154:
            r33 = r4
            r13 = 0
        L_0x0157:
            r4 = 8
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0167
            java.lang.Object r4 = r13.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0168
        L_0x0165:
            r33 = r4
        L_0x0167:
            r4 = 0
        L_0x0168:
            r43 = 16777732(0x1000204, double:8.289301E-317)
            long r43 = r2 & r43
            r41 = 0
            int r13 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0189
            if (r0 == 0) goto L_0x017a
            androidx.databinding.ObservableInt r13 = r0.bankOfferVisibility
            r43 = r4
            goto L_0x017d
        L_0x017a:
            r43 = r4
            r13 = 0
        L_0x017d:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x018b
            int r4 = r13.get()
            goto L_0x018c
        L_0x0189:
            r43 = r4
        L_0x018b:
            r4 = 0
        L_0x018c:
            r44 = 16778244(0x1000404, double:8.289554E-317)
            long r44 = r2 & r44
            r41 = 0
            int r13 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x01af
            if (r0 == 0) goto L_0x019e
            androidx.databinding.i<java.lang.String> r13 = r0.cashBackText
            r44 = r4
            goto L_0x01a1
        L_0x019e:
            r44 = r4
            r13 = 0
        L_0x01a1:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x01b1
            java.lang.Object r4 = r13.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01b2
        L_0x01af:
            r44 = r4
        L_0x01b1:
            r4 = 0
        L_0x01b2:
            long r45 = r2 & r24
            r41 = 0
            int r13 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x01d0
            if (r0 == 0) goto L_0x01c1
            androidx.databinding.ObservableInt r13 = r0.proceedButtonVisiblity
            r45 = r4
            goto L_0x01c4
        L_0x01c1:
            r45 = r4
            r13 = 0
        L_0x01c4:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x01d2
            int r4 = r13.get()
            goto L_0x01d3
        L_0x01d0:
            r45 = r4
        L_0x01d2:
            r4 = 0
        L_0x01d3:
            r46 = 16781316(0x1001004, double:8.2910717E-317)
            long r46 = r2 & r46
            r41 = 0
            int r13 = (r46 > r41 ? 1 : (r46 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x01f6
            if (r0 == 0) goto L_0x01e5
            androidx.databinding.i<android.text.SpannableString> r13 = r0.convFeeText
            r46 = r4
            goto L_0x01e8
        L_0x01e5:
            r46 = r4
            r13 = 0
        L_0x01e8:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x01f8
            java.lang.Object r4 = r13.get()
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            goto L_0x01f9
        L_0x01f6:
            r46 = r4
        L_0x01f8:
            r4 = 0
        L_0x01f9:
            r47 = 16785412(0x1002004, double:8.2930954E-317)
            long r47 = r2 & r47
            r41 = 0
            int r13 = (r47 > r41 ? 1 : (r47 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x021a
            if (r0 == 0) goto L_0x020b
            androidx.databinding.ObservableInt r13 = r0.showOtherBankVisiblity
            r47 = r4
            goto L_0x020e
        L_0x020b:
            r47 = r4
            r13 = 0
        L_0x020e:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x021c
            int r4 = r13.get()
            goto L_0x021d
        L_0x021a:
            r47 = r4
        L_0x021c:
            r4 = 0
        L_0x021d:
            long r48 = r2 & r20
            r41 = 0
            int r13 = (r48 > r41 ? 1 : (r48 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x023b
            if (r0 == 0) goto L_0x022c
            androidx.databinding.ObservableBoolean r13 = r0.upiCheckboxChecked
            r48 = r4
            goto L_0x022f
        L_0x022c:
            r48 = r4
            r13 = 0
        L_0x022f:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x023d
            boolean r4 = r13.get()
            goto L_0x023e
        L_0x023b:
            r48 = r4
        L_0x023d:
            r4 = 0
        L_0x023e:
            r49 = 16809988(0x1008004, double:8.3052376E-317)
            long r49 = r2 & r49
            r41 = 0
            int r13 = (r49 > r41 ? 1 : (r49 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0261
            if (r0 == 0) goto L_0x0250
            androidx.databinding.i<java.lang.String> r13 = r0.netBankingTitle
            r49 = r4
            goto L_0x0253
        L_0x0250:
            r49 = r4
            r13 = 0
        L_0x0253:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0263
            java.lang.Object r4 = r13.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0264
        L_0x0261:
            r49 = r4
        L_0x0263:
            r4 = 0
        L_0x0264:
            r50 = 16842756(0x1010004, double:8.321427E-317)
            long r50 = r2 & r50
            r41 = 0
            int r13 = (r50 > r41 ? 1 : (r50 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0285
            if (r0 == 0) goto L_0x0276
            androidx.databinding.ObservableInt r13 = r0.cashBackTextVisibility
            r50 = r4
            goto L_0x0279
        L_0x0276:
            r50 = r4
            r13 = 0
        L_0x0279:
            r4 = 16
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0287
            int r4 = r13.get()
            goto L_0x0288
        L_0x0285:
            r50 = r4
        L_0x0287:
            r4 = 0
        L_0x0288:
            r51 = 16908292(0x1020004, double:8.353806E-317)
            long r51 = r2 & r51
            r41 = 0
            int r13 = (r51 > r41 ? 1 : (r51 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x02ab
            if (r0 == 0) goto L_0x029a
            androidx.databinding.i<java.lang.String> r13 = r0.otherBankText
            r51 = r4
            goto L_0x029d
        L_0x029a:
            r51 = r4
            r13 = 0
        L_0x029d:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x02ad
            java.lang.Object r4 = r13.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x02ae
        L_0x02ab:
            r51 = r4
        L_0x02ad:
            r4 = 0
        L_0x02ae:
            long r52 = r2 & r16
            r41 = 0
            int r13 = (r52 > r41 ? 1 : (r52 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x02cc
            if (r0 == 0) goto L_0x02bd
            androidx.databinding.ObservableInt r13 = r0.tickImage
            r52 = r4
            goto L_0x02c0
        L_0x02bd:
            r52 = r4
            r13 = 0
        L_0x02c0:
            r4 = 18
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x02ce
            int r4 = r13.get()
            goto L_0x02cf
        L_0x02cc:
            r52 = r4
        L_0x02ce:
            r4 = 0
        L_0x02cf:
            r53 = 17301508(0x1080004, double:8.5480807E-317)
            long r53 = r2 & r53
            r41 = 0
            int r13 = (r53 > r41 ? 1 : (r53 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x02f0
            if (r0 == 0) goto L_0x02e1
            androidx.databinding.ObservableInt r13 = r0.convFeeTextVisibility
            r53 = r4
            goto L_0x02e4
        L_0x02e1:
            r53 = r4
            r13 = 0
        L_0x02e4:
            r4 = 19
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x02f2
            int r4 = r13.get()
            goto L_0x02f3
        L_0x02f0:
            r53 = r4
        L_0x02f2:
            r4 = 0
        L_0x02f3:
            r54 = 17825796(0x1100004, double:8.8071134E-317)
            long r54 = r2 & r54
            r41 = 0
            int r13 = (r54 > r41 ? 1 : (r54 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0316
            if (r0 == 0) goto L_0x0305
            androidx.databinding.ObservableInt r13 = r0.netBankingBankListVisiblity
            r54 = r4
            goto L_0x0308
        L_0x0305:
            r54 = r4
            r13 = 0
        L_0x0308:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0318
            int r4 = r13.get()
            r32 = r4
            goto L_0x031a
        L_0x0316:
            r54 = r4
        L_0x0318:
            r32 = 0
        L_0x031a:
            r55 = 18874372(0x1200004, double:9.325179E-317)
            long r55 = r2 & r55
            r41 = 0
            int r4 = (r55 > r41 ? 1 : (r55 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x0339
            if (r0 == 0) goto L_0x032a
            androidx.databinding.i<java.lang.String> r4 = r0.paySecurelyText
            goto L_0x032b
        L_0x032a:
            r4 = 0
        L_0x032b:
            r13 = 21
            r1.updateRegistration((int) r13, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0339
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x033a
        L_0x0339:
            r4 = 0
        L_0x033a:
            r55 = 20971524(0x1400004, double:1.03613095E-316)
            long r55 = r2 & r55
            r41 = 0
            int r13 = (r55 > r41 ? 1 : (r55 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x037f
            if (r0 == 0) goto L_0x034a
            androidx.databinding.i<java.lang.String> r0 = r0.upiPayOptionText
            goto L_0x034b
        L_0x034a:
            r0 = 0
        L_0x034b:
            r13 = 22
            r1.updateRegistration((int) r13, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x037f
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r69 = r0
            r62 = r4
            r57 = r6
            r68 = r7
            r64 = r8
            r65 = r9
            r63 = r12
            r13 = r32
            r6 = r33
            r59 = r43
            r58 = r44
            r8 = r45
            r0 = r46
            r60 = r47
            r4 = r49
            r66 = r50
            r9 = r51
            r67 = r52
            r61 = r54
            goto L_0x03a5
        L_0x037f:
            r62 = r4
            r57 = r6
            r68 = r7
            r64 = r8
            r65 = r9
            r63 = r12
            r13 = r32
            r6 = r33
            r59 = r43
            r58 = r44
            r8 = r45
            r0 = r46
            r60 = r47
            r4 = r49
            r66 = r50
            r9 = r51
            r67 = r52
            r61 = r54
            r69 = 0
        L_0x03a5:
            r7 = r5
            r12 = r10
            r10 = r48
            r5 = r53
            goto L_0x03d3
        L_0x03ac:
            r0 = 0
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
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
        L_0x03d3:
            long r28 = r2 & r28
            r32 = 0
            int r34 = (r28 > r32 ? 1 : (r28 == r32 ? 0 : -1))
            r28 = r13
            if (r34 == 0) goto L_0x03ec
            android.widget.RelativeLayout r13 = r1.btnProceed
            r13.setOnClickListener(r15)
            android.widget.RelativeLayout r13 = r1.mboundView1
            r13.setOnClickListener(r14)
            android.widget.LinearLayout r13 = r1.otherBankLayout
            r13.setOnClickListener(r11)
        L_0x03ec:
            long r13 = r2 & r24
            int r11 = (r13 > r32 ? 1 : (r13 == r32 ? 0 : -1))
            if (r11 == 0) goto L_0x03f7
            android.widget.RelativeLayout r11 = r1.btnProceed
            r11.setVisibility(r0)
        L_0x03f7:
            long r13 = r2 & r20
            int r0 = (r13 > r32 ? 1 : (r13 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0402
            android.widget.CheckBox r0 = r1.cbUpiCheckbox
            androidx.databinding.a.a.a(r0, r4)
        L_0x0402:
            long r13 = r2 & r16
            int r0 = (r13 > r32 ? 1 : (r13 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x040d
            android.widget.ImageView r0 = r1.imgTick
            r0.setVisibility(r5)
        L_0x040d:
            r4 = 16777284(0x1000044, double:8.2890797E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x041a
            android.widget.LinearLayout r0 = r1.llCheckOffer
            r0.setVisibility(r6)
        L_0x041a:
            r4 = 16777348(0x1000084, double:8.2891113E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0427
            android.widget.LinearLayout r0 = r1.llUpiCheckbox
            r0.setVisibility(r7)
        L_0x0427:
            r4 = 16778244(0x1000404, double:8.289554E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0434
            android.widget.TextView r0 = r1.mboundView18
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0434:
            r4 = 16842756(0x1010004, double:8.321427E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0441
            android.widget.TextView r0 = r1.mboundView18
            r0.setVisibility(r9)
        L_0x0441:
            r4 = 16785412(0x1002004, double:8.2930954E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x044e
            android.widget.LinearLayout r0 = r1.otherBankLayout
            r0.setVisibility(r10)
        L_0x044e:
            long r4 = r2 & r22
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0459
            android.widget.RadioButton r0 = r1.radioButton
            androidx.databinding.a.a.a(r0, r12)
        L_0x0459:
            r4 = 17825796(0x1100004, double:8.8071134E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0468
            androidx.recyclerview.widget.RecyclerView r0 = r1.recyclerBankList
            r4 = r28
            r0.setVisibility(r4)
        L_0x0468:
            long r4 = r2 & r26
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0475
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r6 = r57
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0475:
            r4 = 16777732(0x1000204, double:8.289301E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0484
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankOffer
            r4 = r58
            r0.setVisibility(r4)
        L_0x0484:
            r4 = 16777476(0x1000104, double:8.2891745E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0493
            android.widget.TextView r0 = r1.tvCheckingOffers
            r4 = r59
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0493:
            r4 = 16781316(0x1001004, double:8.2910717E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04a2
            android.widget.TextView r0 = r1.tvOtherBankConvFee
            r4 = r60
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04a2:
            r4 = 17301508(0x1080004, double:8.5480807E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04b1
            android.widget.TextView r0 = r1.tvOtherBankConvFee
            r4 = r61
            r0.setVisibility(r4)
        L_0x04b1:
            r4 = 18874372(0x1200004, double:9.325179E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04c0
            android.widget.TextView r0 = r1.tvProceedSecurely
            r4 = r62
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04c0:
            r4 = 16777236(0x1000014, double:8.289056E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04cf
            android.widget.TextView r0 = r1.tvUpiCheckbox
            r12 = r63
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x04cf:
            r4 = 16777252(0x1000024, double:8.289064E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04e5
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtAmount
            r8 = r64
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtAmount
            r9 = r65
            r0.setVisibility(r9)
        L_0x04e5:
            r4 = 16809988(0x1008004, double:8.3052376E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x04f4
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtHeaderInstrunmentName
            r4 = r66
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x04f4:
            r4 = 16908292(0x1020004, double:8.353806E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0503
            android.widget.TextView r0 = r1.txtSelectOtherBank
            r4 = r67
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0503:
            long r4 = r2 & r18
            int r0 = (r4 > r32 ? 1 : (r4 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x0510
            android.widget.RelativeLayout r0 = r1.upiPayOption
            r7 = r68
            r0.setVisibility(r7)
        L_0x0510:
            r4 = 20971524(0x1400004, double:1.03613095E-316)
            long r2 = r2 & r4
            int r0 = (r2 > r32 ? 1 : (r2 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x051f
            android.widget.TextView r0 = r1.upiPayText
            r2 = r69
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x051f:
            return
        L_0x0520:
            r0 = move-exception
            monitor-exit(r70)     // Catch:{ all -> 0x0520 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private NetBankingViewModel value;

        public OnClickListenerImpl setValue(NetBankingViewModel netBankingViewModel) {
            this.value = netBankingViewModel;
            if (netBankingViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.onShowOtherBankClick(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private NetBankingViewModel value;

        public OnClickListenerImpl1 setValue(NetBankingViewModel netBankingViewModel) {
            this.value = netBankingViewModel;
            if (netBankingViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.setBankListVisiblity(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private NetBankingViewModel value;

        public OnClickListenerImpl2 setValue(NetBankingViewModel netBankingViewModel) {
            this.value = netBankingViewModel;
            if (netBankingViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.proceedClicked(view);
        }
    }
}
