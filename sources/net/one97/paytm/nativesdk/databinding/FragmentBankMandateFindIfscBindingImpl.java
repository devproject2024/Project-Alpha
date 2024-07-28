package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateIfscCodeViewModel;

public class FragmentBankMandateFindIfscBindingImpl extends FragmentBankMandateFindIfscBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl1 mBankMandateIfscCodeViewModelCallBankListApiAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mBankMandateIfscCodeViewModelCallBranchListApiAndroidViewViewOnClickListener;
    private OnClickListenerImpl mBankMandateIfscCodeViewModelCallCityListApiAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mBankMandateIfscCodeViewModelCallStateListApiAndroidViewViewOnClickListener;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_back_ifsc, 8);
        sViewsWithIds.put(R.id.tv_toolbar_title, 9);
        sViewsWithIds.put(R.id.til_find_bank, 10);
        sViewsWithIds.put(R.id.til_find_state, 11);
        sViewsWithIds.put(R.id.til_find_city, 12);
        sViewsWithIds.put(R.id.til_find_branch, 13);
        sViewsWithIds.put(R.id.view_ifsc, 14);
        sViewsWithIds.put(R.id.tv_ifsc_text, 15);
        sViewsWithIds.put(R.id.container, 16);
    }

    public FragmentBankMandateFindIfscBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, sIncludes, sViewsWithIds));
    }

    private FragmentBankMandateFindIfscBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 12, objArr[7], objArr[5], objArr[16], objArr[8], objArr[1], objArr[4], objArr[3], objArr[2], objArr[10], objArr[13], objArr[12], objArr[11], objArr[6], objArr[15], objArr[9], objArr[14]);
        this.mDirtyFlags = -1;
        this.btnIfscContinue.setTag((Object) null);
        this.clIfscDetails.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tiEtBank.setTag((Object) null);
        this.tiEtBranch.setTag((Object) null);
        this.tiEtCity.setTag((Object) null);
        this.tiEtState.setTag((Object) null);
        this.tvIfscCode.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
        if (BR.bankMandateIfscCodeViewModel != i2) {
            return false;
        }
        setBankMandateIfscCodeViewModel((BankMandateIfscCodeViewModel) obj);
        return true;
    }

    public void setBankMandateIfscCodeViewModel(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel) {
        updateRegistration(11, (h) bankMandateIfscCodeViewModel);
        this.mBankMandateIfscCodeViewModel = bankMandateIfscCodeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        notifyPropertyChanged(BR.bankMandateIfscCodeViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeBankMandateIfscCodeViewModelBranchClickable((ObservableBoolean) obj, i3);
            case 1:
                return onChangeBankMandateIfscCodeViewModelBranchName((i) obj, i3);
            case 2:
                return onChangeBankMandateIfscCodeViewModelContinueVisibility((ObservableInt) obj, i3);
            case 3:
                return onChangeBankMandateIfscCodeViewModelCityName((i) obj, i3);
            case 4:
                return onChangeBankMandateIfscCodeViewModelStateName((i) obj, i3);
            case 5:
                return onChangeBankMandateIfscCodeViewModelBankName((i) obj, i3);
            case 6:
                return onChangeBankMandateIfscCodeViewModelCityClickable((ObservableBoolean) obj, i3);
            case 7:
                return onChangeBankMandateIfscCodeViewModelIfscVisibility((ObservableInt) obj, i3);
            case 8:
                return onChangeBankMandateIfscCodeViewModelStateClickable((ObservableBoolean) obj, i3);
            case 9:
                return onChangeBankMandateIfscCodeViewModelIfscCode((i) obj, i3);
            case 10:
                return onChangeBankMandateIfscCodeViewModelBankClickable((ObservableBoolean) obj, i3);
            case 11:
                return onChangeBankMandateIfscCodeViewModel((BankMandateIfscCodeViewModel) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeBankMandateIfscCodeViewModelBranchClickable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelBranchName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelContinueVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelCityName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelStateName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelBankName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelCityClickable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelIfscVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelStateClickable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelIfscCode(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModelBankClickable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeBankMandateIfscCodeViewModel(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r48 = this;
            r1 = r48
            monitor-enter(r48)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0256 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0256 }
            monitor-exit(r48)     // Catch:{ all -> 0x0256 }
            net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateIfscCodeViewModel r0 = r1.mBankMandateIfscCodeViewModel
            r6 = 8191(0x1fff, double:4.047E-320)
            long r6 = r6 & r2
            r14 = 6152(0x1808, double:3.0395E-320)
            r16 = 6146(0x1802, double:3.0365E-320)
            r18 = 6145(0x1801, double:3.036E-320)
            r20 = 6176(0x1820, double:3.0513E-320)
            r22 = 7168(0x1c00, double:3.5415E-320)
            r24 = 6272(0x1880, double:3.099E-320)
            r26 = 6208(0x1840, double:3.067E-320)
            r28 = 6148(0x1804, double:3.0375E-320)
            r8 = 0
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x01bd
            long r6 = r2 & r26
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x004f
            if (r0 == 0) goto L_0x003e
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl r6 = r1.mBankMandateIfscCodeViewModelCallCityListApiAndroidViewViewOnClickListener
            if (r6 != 0) goto L_0x0037
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl r6 = new net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl
            r6.<init>()
            r1.mBankMandateIfscCodeViewModelCallCityListApiAndroidViewViewOnClickListener = r6
        L_0x0037:
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl r6 = r6.setValue(r0)
            androidx.databinding.ObservableBoolean r7 = r0.cityClickable
            goto L_0x0040
        L_0x003e:
            r6 = 0
            r7 = 0
        L_0x0040:
            r9 = 6
            r1.updateRegistration((int) r9, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004c
            boolean r7 = r7.get()
            r9 = r6
            goto L_0x0051
        L_0x004c:
            r9 = r6
            r7 = 0
            goto L_0x0051
        L_0x004f:
            r7 = 0
            r9 = 0
        L_0x0051:
            long r33 = r2 & r22
            int r6 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x006b
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl1 r6 = r1.mBankMandateIfscCodeViewModelCallBankListApiAndroidViewViewOnClickListener
            if (r6 != 0) goto L_0x0064
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl1 r6 = new net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl1
            r6.<init>()
            r1.mBankMandateIfscCodeViewModelCallBankListApiAndroidViewViewOnClickListener = r6
        L_0x0064:
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl1 r6 = r6.setValue(r0)
            androidx.databinding.ObservableBoolean r10 = r0.bankClickable
            goto L_0x006d
        L_0x006b:
            r6 = 0
            r10 = 0
        L_0x006d:
            r11 = 10
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x007a
            boolean r10 = r10.get()
            goto L_0x007b
        L_0x0079:
            r6 = 0
        L_0x007a:
            r10 = 0
        L_0x007b:
            long r35 = r2 & r18
            int r11 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00a3
            if (r0 == 0) goto L_0x0095
            androidx.databinding.ObservableBoolean r11 = r0.branchClickable
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl2 r12 = r1.mBankMandateIfscCodeViewModelCallBranchListApiAndroidViewViewOnClickListener
            if (r12 != 0) goto L_0x0090
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl2 r12 = new net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl2
            r12.<init>()
            r1.mBankMandateIfscCodeViewModelCallBranchListApiAndroidViewViewOnClickListener = r12
        L_0x0090:
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl2 r12 = r12.setValue(r0)
            goto L_0x0097
        L_0x0095:
            r11 = 0
            r12 = 0
        L_0x0097:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x00a1
            boolean r11 = r11.get()
            goto L_0x00a5
        L_0x00a1:
            r11 = 0
            goto L_0x00a5
        L_0x00a3:
            r11 = 0
            r12 = 0
        L_0x00a5:
            long r37 = r2 & r16
            int r13 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x00b0
            androidx.databinding.i<java.lang.String> r13 = r0.branchName
            goto L_0x00b1
        L_0x00b0:
            r13 = 0
        L_0x00b1:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00be
            java.lang.Object r8 = r13.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00bf
        L_0x00be:
            r8 = 0
        L_0x00bf:
            long r38 = r2 & r28
            int r13 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00d6
            if (r0 == 0) goto L_0x00ca
            androidx.databinding.ObservableInt r13 = r0.continueVisibility
            goto L_0x00cb
        L_0x00ca:
            r13 = 0
        L_0x00cb:
            r4 = 2
            r1.updateRegistration((int) r4, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00d6
            int r4 = r13.get()
            goto L_0x00d7
        L_0x00d6:
            r4 = 0
        L_0x00d7:
            long r40 = r2 & r14
            r38 = 0
            int r5 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x00f2
            if (r0 == 0) goto L_0x00e4
            androidx.databinding.i<java.lang.String> r5 = r0.cityName
            goto L_0x00e5
        L_0x00e4:
            r5 = 0
        L_0x00e5:
            r13 = 3
            r1.updateRegistration((int) r13, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x00f2
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x00f3
        L_0x00f2:
            r5 = 0
        L_0x00f3:
            r35 = 6160(0x1810, double:3.0434E-320)
            long r40 = r2 & r35
            r38 = 0
            int r13 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r13 == 0) goto L_0x0110
            if (r0 == 0) goto L_0x0102
            androidx.databinding.i<java.lang.String> r13 = r0.stateName
            goto L_0x0103
        L_0x0102:
            r13 = 0
        L_0x0103:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0110
            java.lang.Object r13 = r13.get()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0111
        L_0x0110:
            r13 = 0
        L_0x0111:
            r14 = 6400(0x1900, double:3.162E-320)
            long r42 = r2 & r14
            r14 = 0
            int r44 = (r42 > r14 ? 1 : (r42 == r14 ? 0 : -1))
            if (r44 == 0) goto L_0x0143
            if (r0 == 0) goto L_0x0131
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl3 r14 = r1.mBankMandateIfscCodeViewModelCallStateListApiAndroidViewViewOnClickListener
            if (r14 != 0) goto L_0x0128
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl3 r14 = new net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl3
            r14.<init>()
            r1.mBankMandateIfscCodeViewModelCallStateListApiAndroidViewViewOnClickListener = r14
        L_0x0128:
            net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl$OnClickListenerImpl3 r14 = r14.setValue(r0)
            androidx.databinding.ObservableBoolean r15 = r0.stateClickable
            r42 = r4
            goto L_0x0135
        L_0x0131:
            r42 = r4
            r14 = 0
            r15 = 0
        L_0x0135:
            r4 = 8
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0141
            boolean r4 = r15.get()
            goto L_0x0147
        L_0x0141:
            r4 = 0
            goto L_0x0147
        L_0x0143:
            r42 = r4
            r4 = 0
            r14 = 0
        L_0x0147:
            long r43 = r2 & r20
            r38 = 0
            int r15 = (r43 > r38 ? 1 : (r43 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x0166
            if (r0 == 0) goto L_0x0156
            androidx.databinding.i<java.lang.String> r15 = r0.bankName
            r43 = r4
            goto L_0x0159
        L_0x0156:
            r43 = r4
            r15 = 0
        L_0x0159:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0168
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0169
        L_0x0166:
            r43 = r4
        L_0x0168:
            r4 = 0
        L_0x0169:
            long r44 = r2 & r24
            r38 = 0
            int r15 = (r44 > r38 ? 1 : (r44 == r38 ? 0 : -1))
            if (r15 == 0) goto L_0x0186
            if (r0 == 0) goto L_0x0178
            androidx.databinding.ObservableInt r15 = r0.ifscVisibility
            r44 = r4
            goto L_0x017b
        L_0x0178:
            r44 = r4
            r15 = 0
        L_0x017b:
            r4 = 7
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0188
            int r4 = r15.get()
            goto L_0x0189
        L_0x0186:
            r44 = r4
        L_0x0188:
            r4 = 0
        L_0x0189:
            r30 = 6656(0x1a00, double:3.2885E-320)
            long r45 = r2 & r30
            r37 = 0
            int r15 = (r45 > r37 ? 1 : (r45 == r37 ? 0 : -1))
            if (r15 == 0) goto L_0x01af
            if (r0 == 0) goto L_0x0198
            androidx.databinding.i<java.lang.String> r0 = r0.ifscCode
            goto L_0x0199
        L_0x0198:
            r0 = 0
        L_0x0199:
            r15 = 9
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x01af
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r47 = r0
            r32 = r14
            r0 = r42
            r15 = r43
            goto L_0x01b7
        L_0x01af:
            r32 = r14
            r0 = r42
            r15 = r43
            r47 = 0
        L_0x01b7:
            r14 = r13
            r13 = r7
            r7 = r5
            r5 = r44
            goto L_0x01ce
        L_0x01bd:
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
            r32 = 0
            r47 = 0
        L_0x01ce:
            long r28 = r2 & r28
            r37 = 0
            int r39 = (r28 > r37 ? 1 : (r28 == r37 ? 0 : -1))
            r28 = r15
            if (r39 == 0) goto L_0x01dd
            android.widget.Button r15 = r1.btnIfscContinue
            r15.setVisibility(r0)
        L_0x01dd:
            long r24 = r2 & r24
            int r0 = (r24 > r37 ? 1 : (r24 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x01e8
            androidx.constraintlayout.widget.Group r0 = r1.clIfscDetails
            r0.setVisibility(r4)
        L_0x01e8:
            long r20 = r2 & r20
            int r0 = (r20 > r37 ? 1 : (r20 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x01f3
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtBank
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x01f3:
            long r4 = r2 & r22
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x01fe
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtBank
            androidx.databinding.a.e.a(r0, r6, r10)
        L_0x01fe:
            long r4 = r2 & r16
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0209
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtBranch
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0209:
            long r4 = r2 & r18
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0214
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtBranch
            androidx.databinding.a.e.a(r0, r12, r11)
        L_0x0214:
            r4 = 6152(0x1808, double:3.0395E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0220
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtCity
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x0220:
            long r4 = r2 & r26
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x022b
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtCity
            androidx.databinding.a.e.a(r0, r9, r13)
        L_0x022b:
            r4 = 6160(0x1810, double:3.0434E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0237
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtState
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x0237:
            r4 = 6400(0x1900, double:3.162E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r37 ? 1 : (r4 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0247
            com.google.android.material.textfield.TextInputEditText r0 = r1.tiEtState
            r4 = r28
            r14 = r32
            androidx.databinding.a.e.a(r0, r14, r4)
        L_0x0247:
            r4 = 6656(0x1a00, double:3.2885E-320)
            long r2 = r2 & r4
            int r0 = (r2 > r37 ? 1 : (r2 == r37 ? 0 : -1))
            if (r0 == 0) goto L_0x0255
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvIfscCode
            r2 = r47
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0255:
            return
        L_0x0256:
            r0 = move-exception
            monitor-exit(r48)     // Catch:{ all -> 0x0256 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BankMandateIfscCodeViewModel value;

        public OnClickListenerImpl setValue(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel) {
            this.value = bankMandateIfscCodeViewModel;
            if (bankMandateIfscCodeViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.callCityListApi(view);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private BankMandateIfscCodeViewModel value;

        public OnClickListenerImpl1 setValue(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel) {
            this.value = bankMandateIfscCodeViewModel;
            if (bankMandateIfscCodeViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.callBankListApi(view);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private BankMandateIfscCodeViewModel value;

        public OnClickListenerImpl2 setValue(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel) {
            this.value = bankMandateIfscCodeViewModel;
            if (bankMandateIfscCodeViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.callBranchListApi(view);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private BankMandateIfscCodeViewModel value;

        public OnClickListenerImpl3 setValue(BankMandateIfscCodeViewModel bankMandateIfscCodeViewModel) {
            this.value = bankMandateIfscCodeViewModel;
            if (bankMandateIfscCodeViewModel == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.value.callStateListApi(view);
        }
    }
}
