package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateSubDetailsViewModel;

public class FragmentBankMandateSubDetailsBindingImpl extends FragmentBankMandateSubDetailsBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_header, 15);
        sViewsWithIds.put(R.id.iv_back_arrow, 16);
        sViewsWithIds.put(R.id.tv_sub_details, 17);
        sViewsWithIds.put(R.id.tv_cust_name, 18);
        sViewsWithIds.put(R.id.tv_frequency, 19);
        sViewsWithIds.put(R.id.tv_max_amt, 20);
        sViewsWithIds.put(R.id.tv_start_date, 21);
        sViewsWithIds.put(R.id.tv_expiry_date, 22);
        sViewsWithIds.put(R.id.tv_purpose, 23);
        sViewsWithIds.put(R.id.view_divider_ac_details, 24);
        sViewsWithIds.put(R.id.tv_bank_ac_details, 25);
        sViewsWithIds.put(R.id.view_iv_bank_sub_logo, 26);
        sViewsWithIds.put(R.id.iv_bank_sub_logo, 27);
        sViewsWithIds.put(R.id.btn_confirm, 28);
        sViewsWithIds.put(R.id.tv_mandate_powered_by, 29);
        sViewsWithIds.put(R.id.iv_e_mandate_nach, 30);
        sViewsWithIds.put(R.id.iv_e_mandate_npci, 31);
    }

    public FragmentBankMandateSubDetailsBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 32, sIncludes, sViewsWithIds));
    }

    private FragmentBankMandateSubDetailsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 16, objArr[28], objArr[16], objArr[27], objArr[30], objArr[31], objArr[2], objArr[14], objArr[25], objArr[13], objArr[12], objArr[3], objArr[11], objArr[18], objArr[5], objArr[22], objArr[9], objArr[19], objArr[6], objArr[29], objArr[20], objArr[7], objArr[1], objArr[23], objArr[10], objArr[21], objArr[8], objArr[17], objArr[4], objArr[24], objArr[15], objArr[26]);
        this.mDirtyFlags = -1;
        this.ivMerchantLogo.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvAuthTypeDesc.setTag((Object) null);
        this.tvBankAcType.setTag((Object) null);
        this.tvBankIfscCode.setTag((Object) null);
        this.tvBankMandatePay.setTag((Object) null);
        this.tvBankNameAcNum.setTag((Object) null);
        this.tvCustNameDetails.setTag((Object) null);
        this.tvExpiryDateDetails.setTag((Object) null);
        this.tvFrequencyDetails.setTag((Object) null);
        this.tvMaxAmtDetails.setTag((Object) null);
        this.tvMerchantName.setTag((Object) null);
        this.tvPurposeDetails.setTag((Object) null);
        this.tvStartDateDetails.setTag((Object) null);
        this.tvWillBeDeducted.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 65536;
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
        if (BR.bankMandateSubDetailsViewModel != i2) {
            return false;
        }
        setBankMandateSubDetailsViewModel((BankMandateSubDetailsViewModel) obj);
        return true;
    }

    public void setBankMandateSubDetailsViewModel(BankMandateSubDetailsViewModel bankMandateSubDetailsViewModel) {
        updateRegistration(2, (h) bankMandateSubDetailsViewModel);
        this.mBankMandateSubDetailsViewModel = bankMandateSubDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.bankMandateSubDetailsViewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeBankMandateSubDetailsViewModelMaxAmount((i) obj, i3);
            case 1:
                return onChangeBankMandateSubDetailsViewModelFrequency((i) obj, i3);
            case 2:
                return onChangeBankMandateSubDetailsViewModel((BankMandateSubDetailsViewModel) obj, i3);
            case 3:
                return onChangeBankMandateSubDetailsViewModelIfscCode((i) obj, i3);
            case 4:
                return onChangeBankMandateSubDetailsViewModelBankAcNo((i) obj, i3);
            case 5:
                return onChangeBankMandateSubDetailsViewModelMLogoVisibility((ObservableInt) obj, i3);
            case 6:
                return onChangeBankMandateSubDetailsViewModelMNameVisibility((ObservableInt) obj, i3);
            case 7:
                return onChangeBankMandateSubDetailsViewModelPurpose((i) obj, i3);
            case 8:
                return onChangeBankMandateSubDetailsViewModelPayText((i) obj, i3);
            case 9:
                return onChangeBankMandateSubDetailsViewModelCustName((i) obj, i3);
            case 10:
                return onChangeBankMandateSubDetailsViewModelDeductedTextVisibility((ObservableInt) obj, i3);
            case 11:
                return onChangeBankMandateSubDetailsViewModelStartDate((i) obj, i3);
            case 12:
                return onChangeBankMandateSubDetailsViewModelExpiryDate((i) obj, i3);
            case 13:
                return onChangeBankMandateSubDetailsViewModelMerchantName((i) obj, i3);
            case 14:
                return onChangeBankMandateSubDetailsViewModelAuthText((i) obj, i3);
            case 15:
                return onChangeBankMandateSubDetailsViewModelAcType((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeBankMandateSubDetailsViewModelMaxAmount(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelFrequency(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModel(BankMandateSubDetailsViewModel bankMandateSubDetailsViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelIfscCode(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelBankAcNo(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelMLogoVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelMNameVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelPurpose(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelPayText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelCustName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelDeductedTextVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelStartDate(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelExpiryDate(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelMerchantName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelAuthText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeBankMandateSubDetailsViewModelAcType(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r50 = this;
            r1 = r50
            monitor-enter(r50)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x02bf }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x02bf }
            monitor-exit(r50)     // Catch:{ all -> 0x02bf }
            net.one97.paytm.nativesdk.bank_mandate.viewModel.BankMandateSubDetailsViewModel r0 = r1.mBankMandateSubDetailsViewModel
            r6 = 131071(0x1ffff, double:6.47577E-319)
            long r6 = r6 & r2
            r10 = 65668(0x10084, double:3.24443E-319)
            r14 = 65604(0x10044, double:3.24127E-319)
            r16 = 65796(0x10104, double:3.25075E-319)
            r18 = 65556(0x10014, double:3.2389E-319)
            r20 = 65548(0x1000c, double:3.2385E-319)
            r22 = 98308(0x18004, double:4.85706E-319)
            r24 = 65542(0x10006, double:3.2382E-319)
            r26 = 81924(0x14004, double:4.0476E-319)
            r28 = 65541(0x10005, double:3.23816E-319)
            r30 = 65572(0x10024, double:3.2397E-319)
            r8 = 0
            int r34 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x01f0
            long r6 = r2 & r28
            int r34 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x004b
            if (r0 == 0) goto L_0x003e
            androidx.databinding.i<java.lang.String> r6 = r0.maxAmount
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x004b
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            long r34 = r2 & r24
            int r7 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0065
            if (r0 == 0) goto L_0x0057
            androidx.databinding.i<java.lang.String> r7 = r0.frequency
            goto L_0x0058
        L_0x0057:
            r7 = 0
        L_0x0058:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0065
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0066
        L_0x0065:
            r7 = 0
        L_0x0066:
            long r35 = r2 & r20
            int r8 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0080
            if (r0 == 0) goto L_0x0071
            androidx.databinding.i<java.lang.String> r8 = r0.ifscCode
            goto L_0x0072
        L_0x0071:
            r8 = 0
        L_0x0072:
            r9 = 3
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0080
            java.lang.Object r8 = r8.get()
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0081
        L_0x0080:
            r9 = 0
        L_0x0081:
            long r36 = r2 & r18
            int r8 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x009a
            if (r0 == 0) goto L_0x008c
            androidx.databinding.i<java.lang.String> r8 = r0.bankAcNo
            goto L_0x008d
        L_0x008c:
            r8 = 0
        L_0x008d:
            r12 = 4
            r1.updateRegistration((int) r12, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x009a
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x009b
        L_0x009a:
            r8 = 0
        L_0x009b:
            long r12 = r2 & r30
            int r38 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00a6
            androidx.databinding.ObservableInt r12 = r0.mLogoVisibility
            goto L_0x00a7
        L_0x00a6:
            r12 = 0
        L_0x00a7:
            r13 = 5
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00b2
            int r12 = r12.get()
            goto L_0x00b3
        L_0x00b2:
            r12 = 0
        L_0x00b3:
            long r38 = r2 & r14
            int r13 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00ca
            if (r0 == 0) goto L_0x00be
            androidx.databinding.ObservableInt r13 = r0.mNameVisibility
            goto L_0x00bf
        L_0x00be:
            r13 = 0
        L_0x00bf:
            r14 = 6
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x00ca
            int r13 = r13.get()
            goto L_0x00cb
        L_0x00ca:
            r13 = 0
        L_0x00cb:
            long r14 = r2 & r10
            int r40 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x00e4
            if (r0 == 0) goto L_0x00d6
            androidx.databinding.i<java.lang.String> r14 = r0.purpose
            goto L_0x00d7
        L_0x00d6:
            r14 = 0
        L_0x00d7:
            r15 = 7
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00e4
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00e5
        L_0x00e4:
            r14 = 0
        L_0x00e5:
            long r40 = r2 & r16
            int r15 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00ff
            if (r0 == 0) goto L_0x00f0
            androidx.databinding.i<java.lang.String> r15 = r0.payText
            goto L_0x00f1
        L_0x00f0:
            r15 = 0
        L_0x00f1:
            r10 = 8
            r1.updateRegistration((int) r10, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00ff
            java.lang.Object r10 = r15.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0100
        L_0x00ff:
            r10 = 0
        L_0x0100:
            r36 = 66052(0x10204, double:3.2634E-319)
            long r42 = r2 & r36
            int r11 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x011d
            if (r0 == 0) goto L_0x010e
            androidx.databinding.i<java.lang.String> r11 = r0.custName
            goto L_0x010f
        L_0x010e:
            r11 = 0
        L_0x010f:
            r15 = 9
            r1.updateRegistration((int) r15, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x011d
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x011e
        L_0x011d:
            r11 = 0
        L_0x011e:
            r42 = 66564(0x10404, double:3.2887E-319)
            long r42 = r2 & r42
            int r15 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x013b
            if (r0 == 0) goto L_0x012c
            androidx.databinding.ObservableInt r15 = r0.deductedTextVisibility
            goto L_0x012d
        L_0x012c:
            r15 = 0
        L_0x012d:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x013b
            int r4 = r15.get()
            r34 = r4
            goto L_0x013d
        L_0x013b:
            r34 = 0
        L_0x013d:
            r4 = 67588(0x10804, double:3.3393E-319)
            long r4 = r4 & r2
            r42 = 0
            int r15 = (r4 > r42 ? 1 : (r4 == r42 ? 0 : -1))
            if (r15 == 0) goto L_0x015b
            if (r0 == 0) goto L_0x014c
            androidx.databinding.i<java.lang.String> r4 = r0.startDate
            goto L_0x014d
        L_0x014c:
            r4 = 0
        L_0x014d:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x015b
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x015c
        L_0x015b:
            r4 = 0
        L_0x015c:
            r32 = 69636(0x11004, double:3.4405E-319)
            long r44 = r2 & r32
            r42 = 0
            int r5 = (r44 > r42 ? 1 : (r44 == r42 ? 0 : -1))
            if (r5 == 0) goto L_0x017b
            if (r0 == 0) goto L_0x016c
            androidx.databinding.i<java.lang.String> r5 = r0.expiryDate
            goto L_0x016d
        L_0x016c:
            r5 = 0
        L_0x016d:
            r15 = 12
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x017b
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x017c
        L_0x017b:
            r5 = 0
        L_0x017c:
            r44 = 73732(0x12004, double:3.64284E-319)
            long r44 = r2 & r44
            r42 = 0
            int r15 = (r44 > r42 ? 1 : (r44 == r42 ? 0 : -1))
            if (r15 == 0) goto L_0x019f
            if (r0 == 0) goto L_0x018e
            androidx.databinding.i<java.lang.String> r15 = r0.merchantName
            r44 = r4
            goto L_0x0191
        L_0x018e:
            r44 = r4
            r15 = 0
        L_0x0191:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01a1
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01a2
        L_0x019f:
            r44 = r4
        L_0x01a1:
            r4 = 0
        L_0x01a2:
            long r45 = r2 & r26
            r42 = 0
            int r15 = (r45 > r42 ? 1 : (r45 == r42 ? 0 : -1))
            if (r15 == 0) goto L_0x01c2
            if (r0 == 0) goto L_0x01b1
            androidx.databinding.i<java.lang.String> r15 = r0.authText
            r45 = r4
            goto L_0x01b4
        L_0x01b1:
            r45 = r4
            r15 = 0
        L_0x01b4:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x01c4
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01c5
        L_0x01c2:
            r45 = r4
        L_0x01c4:
            r4 = 0
        L_0x01c5:
            long r46 = r2 & r22
            r42 = 0
            int r15 = (r46 > r42 ? 1 : (r46 == r42 ? 0 : -1))
            if (r15 == 0) goto L_0x01e6
            if (r0 == 0) goto L_0x01d2
            androidx.databinding.i<java.lang.String> r0 = r0.acType
            goto L_0x01d3
        L_0x01d2:
            r0 = 0
        L_0x01d3:
            r15 = 15
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x01e6
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            r15 = r14
            r49 = r34
            r48 = r44
            goto L_0x01ec
        L_0x01e6:
            r15 = r14
            r49 = r34
            r48 = r44
            r0 = 0
        L_0x01ec:
            r14 = r13
            r13 = r45
            goto L_0x0201
        L_0x01f0:
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
            r48 = 0
            r49 = 0
        L_0x0201:
            long r30 = r2 & r30
            r34 = 0
            int r42 = (r30 > r34 ? 1 : (r30 == r34 ? 0 : -1))
            r30 = r15
            if (r42 == 0) goto L_0x0210
            android.widget.ImageView r15 = r1.ivMerchantLogo
            r15.setVisibility(r12)
        L_0x0210:
            long r26 = r2 & r26
            int r12 = (r26 > r34 ? 1 : (r26 == r34 ? 0 : -1))
            if (r12 == 0) goto L_0x021b
            net.one97.paytm.nativesdk.widget.RoboTextView r12 = r1.tvAuthTypeDesc
            androidx.databinding.a.d.a((android.widget.TextView) r12, (java.lang.CharSequence) r4)
        L_0x021b:
            long r22 = r2 & r22
            int r4 = (r22 > r34 ? 1 : (r22 == r34 ? 0 : -1))
            if (r4 == 0) goto L_0x0226
            net.one97.paytm.nativesdk.widget.RoboTextView r4 = r1.tvBankAcType
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r0)
        L_0x0226:
            long r20 = r2 & r20
            int r0 = (r20 > r34 ? 1 : (r20 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0231
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankIfscCode
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0231:
            long r15 = r2 & r16
            int r0 = (r15 > r34 ? 1 : (r15 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x023c
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankMandatePay
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x023c:
            long r9 = r2 & r18
            int r0 = (r9 > r34 ? 1 : (r9 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0247
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankNameAcNum
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0247:
            r8 = 66052(0x10204, double:3.2634E-319)
            long r8 = r8 & r2
            int r0 = (r8 > r34 ? 1 : (r8 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0254
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvCustNameDetails
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0254:
            r8 = 69636(0x11004, double:3.4405E-319)
            long r8 = r8 & r2
            int r0 = (r8 > r34 ? 1 : (r8 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0261
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvExpiryDateDetails
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x0261:
            long r4 = r2 & r24
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x026c
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvFrequencyDetails
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x026c:
            long r4 = r2 & r28
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0277
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvMaxAmtDetails
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0277:
            r4 = 73732(0x12004, double:3.64284E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0284
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvMerchantName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x0284:
            r4 = 65604(0x10044, double:3.24127E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x0291
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvMerchantName
            r0.setVisibility(r14)
        L_0x0291:
            r4 = 65668(0x10084, double:3.24443E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x02a0
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvPurposeDetails
            r14 = r30
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x02a0:
            r4 = 67588(0x10804, double:3.3393E-319)
            long r4 = r4 & r2
            int r0 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x02af
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvStartDateDetails
            r4 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x02af:
            r4 = 66564(0x10404, double:3.2887E-319)
            long r2 = r2 & r4
            int r0 = (r2 > r34 ? 1 : (r2 == r34 ? 0 : -1))
            if (r0 == 0) goto L_0x02be
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvWillBeDeducted
            r2 = r49
            r0.setVisibility(r2)
        L_0x02be:
            return
        L_0x02bf:
            r0 = move-exception
            monitor-exit(r50)     // Catch:{ all -> 0x02bf }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.FragmentBankMandateSubDetailsBindingImpl.executeBindings():void");
    }
}
