package net.one97.paytm.nativesdk.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankViewModel;

public class PaytmBankInfoBankofferBindingImpl extends PaytmBankInfoBankofferBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private AfterTextChangedImpl mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_instrument_info, 10);
        sViewsWithIds.put(R.id.rb_cardNumber, 11);
        sViewsWithIds.put(R.id.bank_pin_layout, 12);
    }

    public PaytmBankInfoBankofferBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private PaytmBankInfoBankofferBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 10, objArr[12], objArr[8], objArr[10], objArr[7], objArr[5], objArr[11], objArr[2], objArr[6], objArr[9], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.etPaytmPasscode.setTag((Object) null);
        this.llMictLines.setTag((Object) null);
        this.lytValidatingOtp.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.tvNewTxt.setTag((Object) null);
        this.tvPayback.setTag((Object) null);
        this.txtErrorMsg.setTag((Object) null);
        this.txtPrimaryInfo.setTag((Object) null);
        this.txtamount.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
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
            setBankViewModel((BankOfferPaytmBankViewModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setBankViewModel(BankOfferPaytmBankViewModel bankOfferPaytmBankViewModel) {
        updateRegistration(5, (h) bankOfferPaytmBankViewModel);
        this.mBankViewModel = bankOfferPaytmBankViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
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
                return onChangeBankViewModelAmount((i) obj, i3);
            case 1:
                return onChangeBankViewModelPaybackVisibility((ObservableInt) obj, i3);
            case 2:
                return onChangeBankViewModelNewVisibility((ObservableInt) obj, i3);
            case 3:
                return onChangeBankViewModelInsufficuentAmountError((i) obj, i3);
            case 4:
                return onChangeBankViewModelDisplayTextPostPaid((i) obj, i3);
            case 5:
                return onChangeBankViewModel((BankOfferPaytmBankViewModel) obj, i3);
            case 6:
                return onChangeBankViewModelValidatingOtpVisiblity((ObservableInt) obj, i3);
            case 7:
                return onChangeBankViewModelMictLinesVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeBankViewModelPinError((i) obj, i3);
            case 9:
                return onChangeBankViewModelMPrimaryInformation((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeBankViewModelAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBankViewModelPaybackVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBankViewModelNewVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeBankViewModelInsufficuentAmountError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeBankViewModelDisplayTextPostPaid(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeBankViewModel(BankOfferPaytmBankViewModel bankOfferPaytmBankViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeBankViewModelValidatingOtpVisiblity(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeBankViewModelMictLinesVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeBankViewModelPinError(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBankViewModelMPrimaryInformation(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0100 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r42 = this;
            r1 = r42
            monitor-enter(r42)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0244 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0244 }
            monitor-exit(r42)     // Catch:{ all -> 0x0244 }
            net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankViewModel r0 = r1.mBankViewModel
            r6 = 3071(0xbff, double:1.5173E-320)
            long r6 = r6 & r2
            r12 = 2096(0x830, double:1.0356E-320)
            r14 = 2088(0x828, double:1.0316E-320)
            r16 = 2084(0x824, double:1.0296E-320)
            r18 = 2144(0x860, double:1.0593E-320)
            r20 = 2082(0x822, double:1.0286E-320)
            r22 = 2208(0x8a0, double:1.091E-320)
            r24 = 2081(0x821, double:1.028E-320)
            r26 = 2080(0x820, double:1.0277E-320)
            r9 = 0
            int r28 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x01a5
            long r6 = r2 & r24
            r8 = 1
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0030
            androidx.databinding.i<java.lang.String> r6 = r0.amount
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x003d
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            if (r6 == 0) goto L_0x0045
            int r7 = r6.length()
            goto L_0x0046
        L_0x0045:
            r7 = 0
        L_0x0046:
            if (r7 <= 0) goto L_0x004a
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            if (r30 == 0) goto L_0x0056
            if (r7 == 0) goto L_0x0052
            r30 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0054
        L_0x0052:
            r30 = 4096(0x1000, double:2.0237E-320)
        L_0x0054:
            long r2 = r2 | r30
        L_0x0056:
            if (r7 == 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            r7 = 8
            goto L_0x005e
        L_0x005c:
            r6 = 0
        L_0x005d:
            r7 = 0
        L_0x005e:
            long r30 = r2 & r20
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0069
            androidx.databinding.ObservableInt r9 = r0.paybackVisibility
            goto L_0x006a
        L_0x0069:
            r9 = 0
        L_0x006a:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0074
            int r9 = r9.get()
            goto L_0x0075
        L_0x0074:
            r9 = 0
        L_0x0075:
            long r31 = r2 & r16
            int r33 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x008c
            if (r0 == 0) goto L_0x0080
            androidx.databinding.ObservableInt r8 = r0.newVisibility
            goto L_0x0081
        L_0x0080:
            r8 = 0
        L_0x0081:
            r10 = 2
            r1.updateRegistration((int) r10, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x008c
            int r8 = r8.get()
            goto L_0x008d
        L_0x008c:
            r8 = 0
        L_0x008d:
            long r10 = r2 & r14
            int r34 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00c6
            if (r0 == 0) goto L_0x0098
            androidx.databinding.i<java.lang.String> r10 = r0.insufficuentAmountError
            goto L_0x0099
        L_0x0098:
            r10 = 0
        L_0x0099:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00a6
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x00a7
        L_0x00a6:
            r10 = 0
        L_0x00a7:
            if (r10 == 0) goto L_0x00ae
            int r11 = r10.length()
            goto L_0x00af
        L_0x00ae:
            r11 = 0
        L_0x00af:
            if (r11 <= 0) goto L_0x00b3
            r11 = 1
            goto L_0x00b4
        L_0x00b3:
            r11 = 0
        L_0x00b4:
            if (r34 == 0) goto L_0x00c0
            if (r11 == 0) goto L_0x00bc
            r34 = 32768(0x8000, double:1.61895E-319)
            goto L_0x00be
        L_0x00bc:
            r34 = 16384(0x4000, double:8.0948E-320)
        L_0x00be:
            long r2 = r2 | r34
        L_0x00c0:
            if (r11 == 0) goto L_0x00c3
            goto L_0x00c7
        L_0x00c3:
            r11 = 8
            goto L_0x00c8
        L_0x00c6:
            r10 = 0
        L_0x00c7:
            r11 = 0
        L_0x00c8:
            long r34 = r2 & r12
            int r36 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x00e1
            if (r0 == 0) goto L_0x00d3
            androidx.databinding.i<java.lang.String> r12 = r0.displayTextPostPaid
            goto L_0x00d4
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            r13 = 4
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00e1
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00e2
        L_0x00e1:
            r12 = 0
        L_0x00e2:
            long r36 = r2 & r18
            int r13 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f9
            if (r0 == 0) goto L_0x00ed
            androidx.databinding.ObservableInt r13 = r0.validatingOtpVisiblity
            goto L_0x00ee
        L_0x00ed:
            r13 = 0
        L_0x00ee:
            r14 = 6
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00f9
            int r13 = r13.get()
            goto L_0x00fa
        L_0x00f9:
            r13 = 0
        L_0x00fa:
            long r14 = r2 & r26
            int r38 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x0112
            if (r0 == 0) goto L_0x0112
            net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl$AfterTextChangedImpl r14 = r1.mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged
            if (r14 != 0) goto L_0x010d
            net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl$AfterTextChangedImpl r14 = new net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl$AfterTextChangedImpl
            r14.<init>()
            r1.mBankViewModelOnPasscodeTextChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = r14
        L_0x010d:
            net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl$AfterTextChangedImpl r14 = r14.setValue(r0)
            goto L_0x0113
        L_0x0112:
            r14 = 0
        L_0x0113:
            long r38 = r2 & r22
            int r15 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x012a
            if (r0 == 0) goto L_0x011e
            androidx.databinding.ObservableInt r15 = r0.mictLinesVisibility
            goto L_0x011f
        L_0x011e:
            r15 = 0
        L_0x011f:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x012a
            int r4 = r15.get()
            goto L_0x012b
        L_0x012a:
            r4 = 0
        L_0x012b:
            r32 = 2336(0x920, double:1.154E-320)
            long r40 = r2 & r32
            r38 = 0
            int r5 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0177
            if (r0 == 0) goto L_0x013e
            androidx.databinding.i<java.lang.String> r15 = r0.pinError
            r29 = r4
            r4 = 8
            goto L_0x0143
        L_0x013e:
            r29 = r4
            r4 = 8
            r15 = 0
        L_0x0143:
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x014f
            java.lang.Object r15 = r15.get()
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0150
        L_0x014f:
            r15 = 0
        L_0x0150:
            if (r15 == 0) goto L_0x0157
            int r40 = r15.length()
            goto L_0x0159
        L_0x0157:
            r40 = 0
        L_0x0159:
            if (r40 <= 0) goto L_0x015e
            r31 = 1
            goto L_0x0160
        L_0x015e:
            r31 = 0
        L_0x0160:
            if (r5 == 0) goto L_0x016d
            if (r31 == 0) goto L_0x0168
            r40 = 131072(0x20000, double:6.47582E-319)
            goto L_0x016b
        L_0x0168:
            r40 = 65536(0x10000, double:3.2379E-319)
        L_0x016b:
            long r2 = r2 | r40
        L_0x016d:
            if (r31 == 0) goto L_0x0172
            r30 = 0
            goto L_0x0174
        L_0x0172:
            r30 = 8
        L_0x0174:
            r4 = 2592(0xa20, double:1.2806E-320)
            goto L_0x017e
        L_0x0177:
            r29 = r4
            r4 = 2592(0xa20, double:1.2806E-320)
            r15 = 0
            r30 = 0
        L_0x017e:
            long r40 = r2 & r4
            r4 = 0
            int r31 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x019f
            if (r0 == 0) goto L_0x018b
            androidx.databinding.i<java.lang.String> r0 = r0.mPrimaryInformation
            goto L_0x018c
        L_0x018b:
            r0 = 0
        L_0x018c:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x019f
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r5 = r0
            r0 = r29
            r4 = r30
            goto L_0x01b2
        L_0x019f:
            r0 = r29
            r4 = r30
            r5 = 0
            goto L_0x01b2
        L_0x01a5:
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
        L_0x01b2:
            long r26 = r2 & r26
            r29 = 0
            int r31 = (r26 > r29 ? 1 : (r26 == r29 ? 0 : -1))
            if (r31 == 0) goto L_0x01c5
            r26 = r7
            android.widget.EditText r7 = r1.etPaytmPasscode
            r27 = r6
            r6 = 0
            androidx.databinding.a.d.a(r7, r6, r14, r6)
            goto L_0x01c9
        L_0x01c5:
            r27 = r6
            r26 = r7
        L_0x01c9:
            long r6 = r2 & r22
            int r14 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r14 == 0) goto L_0x01d4
            android.widget.LinearLayout r6 = r1.llMictLines
            r6.setVisibility(r0)
        L_0x01d4:
            long r6 = r2 & r18
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x01df
            android.widget.LinearLayout r0 = r1.lytValidatingOtp
            r0.setVisibility(r13)
        L_0x01df:
            r6 = 2088(0x828, double:1.0316E-320)
            long r6 = r6 & r2
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x01f0
            android.widget.TextView r0 = r1.mboundView4
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.TextView r0 = r1.mboundView4
            r0.setVisibility(r11)
        L_0x01f0:
            long r6 = r2 & r16
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x01fb
            android.widget.TextView r0 = r1.tvNewTxt
            r0.setVisibility(r8)
        L_0x01fb:
            r6 = 2096(0x830, double:1.0356E-320)
            long r6 = r6 & r2
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0207
            android.widget.TextView r0 = r1.tvPayback
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x0207:
            long r6 = r2 & r20
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0212
            android.widget.TextView r0 = r1.tvPayback
            r0.setVisibility(r9)
        L_0x0212:
            r6 = 2336(0x920, double:1.154E-320)
            long r6 = r6 & r2
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0223
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtErrorMsg
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.txtErrorMsg
            r0.setVisibility(r4)
        L_0x0223:
            r6 = 2592(0xa20, double:1.2806E-320)
            long r6 = r6 & r2
            int r0 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x022f
            android.widget.TextView r0 = r1.txtPrimaryInfo
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x022f:
            long r2 = r2 & r24
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0243
            android.widget.TextView r0 = r1.txtamount
            r6 = r27
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.txtamount
            r7 = r26
            r0.setVisibility(r7)
        L_0x0243:
            return
        L_0x0244:
            r0 = move-exception
            monitor-exit(r42)     // Catch:{ all -> 0x0244 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl.executeBindings():void");
    }

    public static class AfterTextChangedImpl implements d.a {
        private BankOfferPaytmBankViewModel value;

        public AfterTextChangedImpl setValue(BankOfferPaytmBankViewModel bankOfferPaytmBankViewModel) {
            this.value = bankOfferPaytmBankViewModel;
            if (bankOfferPaytmBankViewModel == null) {
                return null;
            }
            return this;
        }

        public void afterTextChanged(Editable editable) {
            this.value.onPasscodeTextChanged(editable);
        }
    }
}
