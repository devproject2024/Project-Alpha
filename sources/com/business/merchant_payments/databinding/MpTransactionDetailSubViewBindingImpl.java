package com.business.merchant_payments.databinding;

import android.text.Spannable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;

public class MpTransactionDetailSubViewBindingImpl extends MpTransactionDetailSubViewBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.barrier, 29);
        sViewsWithIds.put(R.id.textView14, 30);
        sViewsWithIds.put(R.id.tv_order_id, 31);
        sViewsWithIds.put(R.id.textView17, 32);
        sViewsWithIds.put(R.id.profile_label_bank_name, 33);
        sViewsWithIds.put(R.id.data_profile_bank_name, 34);
    }

    public MpTransactionDetailSubViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 35, sIncludes, sViewsWithIds));
    }

    public MpTransactionDetailSubViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 22, objArr[29], objArr[34], objArr[21], objArr[7], objArr[33], objArr[2], objArr[3], objArr[4], objArr[5], objArr[30], objArr[32], objArr[8], objArr[9], objArr[10], objArr[11], objArr[12], objArr[13], objArr[14], objArr[18], objArr[27], objArr[22], objArr[28], objArr[16], objArr[17], objArr[1], objArr[20], objArr[26], objArr[25], objArr[24], objArr[23], objArr[31], objArr[6], objArr[19], objArr[15]);
        this.mDirtyFlags = -1;
        this.imageView3.setTag((Object) null);
        this.ivPaymode.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.textView10.setTag((Object) null);
        this.textView11.setTag((Object) null);
        this.textView12.setTag((Object) null);
        this.textView13.setTag((Object) null);
        this.textView18.setTag((Object) null);
        this.textView19.setTag((Object) null);
        this.textView20.setTag((Object) null);
        this.textView21.setTag((Object) null);
        this.textView22.setTag((Object) null);
        this.textView23.setTag((Object) null);
        this.textView24.setTag((Object) null);
        this.textView25.setTag((Object) null);
        this.textView28.setTag((Object) null);
        this.textView29.setTag((Object) null);
        this.textView31.setTag((Object) null);
        this.textView7.setTag((Object) null);
        this.textView8.setTag((Object) null);
        this.textView9.setTag((Object) null);
        this.tvAccountLbl.setTag((Object) null);
        this.tvDirectBank.setTag((Object) null);
        this.tvDirectSettle.setTag((Object) null);
        this.tvIfsc.setTag((Object) null);
        this.tvIfscLbl.setTag((Object) null);
        this.tvOrderIdText.setTag((Object) null);
        this.tvPaymentDescriptionText.setTag((Object) null);
        this.utrText.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8388608;
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((OnlineTxnDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(OnlineTxnDetailsViewModel onlineTxnDetailsViewModel) {
        this.mViewModel = onlineTxnDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelIsCardNoAvailable((ObservableBoolean) obj, i3);
            case 1:
                return onChangeViewModelSettlementVisibility((ObservableBoolean) obj, i3);
            case 2:
                return onChangeViewModelIsPCFTransaction((ObservableBoolean) obj, i3);
            case 3:
                return onChangeViewModelIsDirectSettlementVisible((ObservableBoolean) obj, i3);
            case 4:
                return onChangeViewModelUtrNo((i) obj, i3);
            case 5:
                return onChangeViewModelIsEmailAvailable((ObservableBoolean) obj, i3);
            case 6:
                return onChangeViewModelPayModeDetailText((i) obj, i3);
            case 7:
                return onChangeViewModelIsPayDescriptionVisible((ObservableBoolean) obj, i3);
            case 8:
                return onChangeViewModelBankIconUrl((i) obj, i3);
            case 9:
                return onChangeViewModelCustomerName((i) obj, i3);
            case 10:
                return onChangeViewModelPayMode((i) obj, i3);
            case 11:
                return onChangeViewModelReceivedFrom((i) obj, i3);
            case 12:
                return onChangeViewModelOrderId((i) obj, i3);
            case 13:
                return onChangeViewModelPayMethodIconUrl((i) obj, i3);
            case 14:
                return onChangeViewModelCustEmail((i) obj, i3);
            case 15:
                return onChangeViewModelIsPayDetailsVisible((ObservableBoolean) obj, i3);
            case 16:
                return onChangeViewModelDescription((i) obj, i3);
            case 17:
                return onChangeViewModelAccNo((i) obj, i3);
            case 18:
                return onChangeViewModelIfscCode((i) obj, i3);
            case 19:
                return onChangeViewModelTransactionType((i) obj, i3);
            case 20:
                return onChangeViewModelSettlementDate((i) obj, i3);
            case 21:
                return onChangeViewModelIsMobileAvailable((ObservableBoolean) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelIsCardNoAvailable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelSettlementVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsPCFTransaction(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelIsDirectSettlementVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelUtrNo(i<Spannable> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelIsEmailAvailable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelPayModeDetailText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelIsPayDescriptionVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelBankIconUrl(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelCustomerName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelPayMode(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelReceivedFrom(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelOrderId(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelPayMethodIconUrl(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelCustEmail(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelIsPayDetailsVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeViewModelDescription(i<Spannable> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeViewModelAccNo(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeViewModelIfscCode(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeViewModelTransactionType(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeViewModelSettlementDate(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeViewModelIsMobileAvailable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x061c  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0641  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x065f  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x066c  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0679  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x06a8  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x06b5  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x06c4  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x06d3  */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x06e7  */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x06f4  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x0701  */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x071f  */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x072e  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0740  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x075b  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0774  */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x077f  */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0791  */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x07ae  */
    /* JADX WARNING: Removed duplicated region for block: B:482:0x07bd  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x07cc  */
    /* JADX WARNING: Removed duplicated region for block: B:494:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r74 = this;
            r1 = r74
            monitor-enter(r74)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x07d4 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x07d4 }
            monitor-exit(r74)     // Catch:{ all -> 0x07d4 }
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r0 = r1.mViewModel
            r6 = 16777215(0xffffff, double:8.2890456E-317)
            long r6 = r6 & r2
            r10 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
            r12 = 12582913(0xc00001, double:6.216785E-317)
            r16 = 12583424(0xc00200, double:6.2170375E-317)
            r18 = 12582914(0xc00002, double:6.2167855E-317)
            r20 = 12582944(0xc00020, double:6.2168004E-317)
            r22 = 14680608(0xe00220, double:7.253184E-317)
            r24 = 12582926(0xc0000e, double:6.2167915E-317)
            r14 = 1
            r28 = 0
            r8 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0497
            long r6 = r2 & r12
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0069
            if (r0 == 0) goto L_0x0037
            androidx.databinding.ObservableBoolean r6 = r0.isCardNoAvailable
            goto L_0x0039
        L_0x0037:
            r6 = r28
        L_0x0039:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0043
            boolean r6 = r6.get()
            goto L_0x0044
        L_0x0043:
            r6 = 0
        L_0x0044:
            if (r9 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x004c
            r31 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x004f
        L_0x004c:
            r31 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x004f:
            long r2 = r2 | r31
        L_0x0051:
            if (r6 == 0) goto L_0x005c
            android.widget.TextView r6 = r1.textView19
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.business.merchant_payments.R.string.mp_card_number
            goto L_0x0064
        L_0x005c:
            android.widget.TextView r6 = r1.textView19
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.business.merchant_payments.R.string.mp_upi_id
        L_0x0064:
            java.lang.String r6 = r6.getString(r7)
            goto L_0x006b
        L_0x0069:
            r6 = r28
        L_0x006b:
            long r31 = r2 & r24
            int r7 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a7
            if (r0 == 0) goto L_0x0076
            androidx.databinding.ObservableBoolean r9 = r0.settlementVisibility
            goto L_0x0078
        L_0x0076:
            r9 = r28
        L_0x0078:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0082
            boolean r9 = r9.get()
            goto L_0x0083
        L_0x0082:
            r9 = 0
        L_0x0083:
            if (r7 == 0) goto L_0x008d
            if (r9 == 0) goto L_0x0089
            long r2 = r2 | r10
            goto L_0x008d
        L_0x0089:
            r31 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r2 = r2 | r31
        L_0x008d:
            long r31 = r2 & r18
            int r7 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009c
            if (r9 == 0) goto L_0x0098
            r31 = 36028797018963968(0x80000000000000, double:2.8480945388892178E-306)
            goto L_0x009a
        L_0x0098:
            r31 = 18014398509481984(0x40000000000000, double:1.7800590868057611E-307)
        L_0x009a:
            long r2 = r2 | r31
        L_0x009c:
            long r31 = r2 & r18
            int r7 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a8
            if (r9 != 0) goto L_0x00a8
            r7 = 8
            goto L_0x00a9
        L_0x00a7:
            r9 = 0
        L_0x00a8:
            r7 = 0
        L_0x00a9:
            r31 = 12582928(0xc00010, double:6.2167924E-317)
            long r31 = r2 & r31
            int r33 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r33 == 0) goto L_0x00c6
            if (r0 == 0) goto L_0x00b7
            androidx.databinding.i<android.text.Spannable> r8 = r0.utrNo
            goto L_0x00b9
        L_0x00b7:
            r8 = r28
        L_0x00b9:
            r12 = 4
            r1.updateRegistration((int) r12, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x00c6
            java.lang.Object r8 = r8.get()
            android.text.Spannable r8 = (android.text.Spannable) r8
            goto L_0x00c8
        L_0x00c6:
            r8 = r28
        L_0x00c8:
            long r12 = r2 & r20
            int r34 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00f4
            if (r0 == 0) goto L_0x00d3
            androidx.databinding.ObservableBoolean r12 = r0.isEmailAvailable
            goto L_0x00d5
        L_0x00d3:
            r12 = r28
        L_0x00d5:
            r13 = 5
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00e0
            boolean r13 = r12.get()
            goto L_0x00e1
        L_0x00e0:
            r13 = 0
        L_0x00e1:
            if (r34 == 0) goto L_0x00ec
            if (r13 == 0) goto L_0x00e8
            r34 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
            goto L_0x00ea
        L_0x00e8:
            r34 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
        L_0x00ea:
            long r2 = r2 | r34
        L_0x00ec:
            if (r13 != 0) goto L_0x00f7
            r34 = r13
            r13 = r12
            r12 = 8
            goto L_0x00fb
        L_0x00f4:
            r12 = r28
            r13 = 0
        L_0x00f7:
            r34 = r13
            r13 = r12
            r12 = 0
        L_0x00fb:
            r35 = 12582976(0xc00040, double:6.216816E-317)
            long r35 = r2 & r35
            int r37 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r37 == 0) goto L_0x0118
            if (r0 == 0) goto L_0x0109
            androidx.databinding.i<java.lang.String> r10 = r0.payModeDetailText
            goto L_0x010b
        L_0x0109:
            r10 = r28
        L_0x010b:
            r11 = 6
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0118
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x011a
        L_0x0118:
            r10 = r28
        L_0x011a:
            r37 = 12583040(0xc00080, double:6.216848E-317)
            long r37 = r2 & r37
            int r11 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x014c
            if (r0 == 0) goto L_0x0128
            androidx.databinding.ObservableBoolean r14 = r0.isPayDescriptionVisible
            goto L_0x012a
        L_0x0128:
            r14 = r28
        L_0x012a:
            r15 = 7
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0135
            boolean r14 = r14.get()
            goto L_0x0136
        L_0x0135:
            r14 = 0
        L_0x0136:
            if (r11 == 0) goto L_0x0147
            if (r14 == 0) goto L_0x0140
            r39 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x0145
        L_0x0140:
            r39 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x0145:
            long r2 = r2 | r39
        L_0x0147:
            if (r14 != 0) goto L_0x014c
            r11 = 8
            goto L_0x014d
        L_0x014c:
            r11 = 0
        L_0x014d:
            r14 = 12583168(0xc00100, double:6.216911E-317)
            long r14 = r14 & r2
            int r39 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r39 == 0) goto L_0x016a
            if (r0 == 0) goto L_0x015a
            androidx.databinding.i<java.lang.String> r14 = r0.bankIconUrl
            goto L_0x015c
        L_0x015a:
            r14 = r28
        L_0x015c:
            r15 = 8
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x016c
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x016e
        L_0x016a:
            r15 = 8
        L_0x016c:
            r14 = r28
        L_0x016e:
            long r38 = r2 & r16
            int r40 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x01a7
            if (r0 == 0) goto L_0x0179
            androidx.databinding.i<java.lang.String> r15 = r0.customerName
            goto L_0x017b
        L_0x0179:
            r15 = r28
        L_0x017b:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0189
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x018b
        L_0x0189:
            r4 = r28
        L_0x018b:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            r37 = 1
            r5 = r5 ^ 1
            if (r40 == 0) goto L_0x019e
            if (r5 == 0) goto L_0x019a
            r39 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            goto L_0x019c
        L_0x019a:
            r39 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
        L_0x019c:
            long r2 = r2 | r39
        L_0x019e:
            if (r5 != 0) goto L_0x01ab
            r39 = r15
            r15 = r5
            r5 = r4
            r4 = 8
            goto L_0x01b0
        L_0x01a7:
            r4 = r28
            r15 = r4
            r5 = 0
        L_0x01ab:
            r39 = r15
            r15 = r5
            r5 = r4
            r4 = 0
        L_0x01b0:
            r43 = 12583936(0xc00400, double:6.2172905E-317)
            long r43 = r2 & r43
            r40 = 0
            int r45 = (r43 > r40 ? 1 : (r43 == r40 ? 0 : -1))
            r40 = r4
            if (r45 == 0) goto L_0x01e5
            if (r0 == 0) goto L_0x01c4
            androidx.databinding.i<java.lang.String> r4 = r0.payMode
            r43 = r5
            goto L_0x01c8
        L_0x01c4:
            r43 = r5
            r4 = r28
        L_0x01c8:
            r5 = 10
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01d6
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01d8
        L_0x01d6:
            r4 = r28
        L_0x01d8:
            android.view.View r5 = r74.getRoot()
            android.content.Context r5 = r5.getContext()
            java.lang.String r4 = com.business.merchant_payments.common.utility.AppUtility.getPayModeLocalised(r5, r4)
            goto L_0x01e9
        L_0x01e5:
            r43 = r5
            r4 = r28
        L_0x01e9:
            r44 = 12584960(0xc00800, double:6.2177964E-317)
            long r44 = r2 & r44
            r41 = 0
            int r5 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x020d
            if (r0 == 0) goto L_0x01fb
            androidx.databinding.i<java.lang.String> r5 = r0.receivedFrom
            r44 = r4
            goto L_0x01ff
        L_0x01fb:
            r44 = r4
            r5 = r28
        L_0x01ff:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x020f
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0211
        L_0x020d:
            r44 = r4
        L_0x020f:
            r4 = r28
        L_0x0211:
            r45 = 12587008(0xc01000, double:6.218808E-317)
            long r45 = r2 & r45
            r41 = 0
            int r5 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0235
            if (r0 == 0) goto L_0x0223
            androidx.databinding.i<java.lang.String> r5 = r0.orderId
            r45 = r4
            goto L_0x0227
        L_0x0223:
            r45 = r4
            r5 = r28
        L_0x0227:
            r4 = 12
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0237
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0239
        L_0x0235:
            r45 = r4
        L_0x0237:
            r4 = r28
        L_0x0239:
            r46 = 12591104(0xc02000, double:6.220832E-317)
            long r46 = r2 & r46
            r41 = 0
            int r5 = (r46 > r41 ? 1 : (r46 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x025d
            if (r0 == 0) goto L_0x024b
            androidx.databinding.i<java.lang.String> r5 = r0.payMethodIconUrl
            r46 = r4
            goto L_0x024f
        L_0x024b:
            r46 = r4
            r5 = r28
        L_0x024f:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x025f
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0261
        L_0x025d:
            r46 = r4
        L_0x025f:
            r4 = r28
        L_0x0261:
            r47 = 12599296(0xc04000, double:6.2248793E-317)
            long r47 = r2 & r47
            r41 = 0
            int r5 = (r47 > r41 ? 1 : (r47 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0285
            if (r0 == 0) goto L_0x0273
            androidx.databinding.i<java.lang.String> r5 = r0.custEmail
            r47 = r4
            goto L_0x0277
        L_0x0273:
            r47 = r4
            r5 = r28
        L_0x0277:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0287
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0289
        L_0x0285:
            r47 = r4
        L_0x0287:
            r4 = r28
        L_0x0289:
            r48 = 12615680(0xc08000, double:6.232974E-317)
            long r48 = r2 & r48
            r41 = 0
            int r5 = (r48 > r41 ? 1 : (r48 == r41 ? 0 : -1))
            r48 = r4
            if (r5 == 0) goto L_0x02bf
            if (r0 == 0) goto L_0x029d
            androidx.databinding.ObservableBoolean r4 = r0.isPayDetailsVisible
            r49 = r6
            goto L_0x02a1
        L_0x029d:
            r49 = r6
            r4 = r28
        L_0x02a1:
            r6 = 15
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02ad
            boolean r4 = r4.get()
            goto L_0x02ae
        L_0x02ad:
            r4 = 0
        L_0x02ae:
            if (r5 == 0) goto L_0x02ba
            if (r4 == 0) goto L_0x02b6
            r5 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x02b9
        L_0x02b6:
            r5 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x02b9:
            long r2 = r2 | r5
        L_0x02ba:
            if (r4 != 0) goto L_0x02c1
            r4 = 8
            goto L_0x02c2
        L_0x02bf:
            r49 = r6
        L_0x02c1:
            r4 = 0
        L_0x02c2:
            r5 = 12648448(0xc10000, double:6.2491636E-317)
            long r5 = r5 & r2
            r41 = 0
            int r50 = (r5 > r41 ? 1 : (r5 == r41 ? 0 : -1))
            if (r50 == 0) goto L_0x02e1
            if (r0 == 0) goto L_0x02d1
            androidx.databinding.i<android.text.Spannable> r5 = r0.description
            goto L_0x02d3
        L_0x02d1:
            r5 = r28
        L_0x02d3:
            r6 = 16
            r1.updateRegistration((int) r6, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02e1
            java.lang.Object r5 = r5.get()
            android.text.Spannable r5 = (android.text.Spannable) r5
            goto L_0x02e3
        L_0x02e1:
            r5 = r28
        L_0x02e3:
            r50 = 12713984(0xc20000, double:6.2815427E-317)
            long r50 = r2 & r50
            r41 = 0
            int r6 = (r50 > r41 ? 1 : (r50 == r41 ? 0 : -1))
            if (r6 == 0) goto L_0x0322
            r50 = r4
            if (r0 == 0) goto L_0x02f7
            androidx.databinding.i<java.lang.String> r4 = r0.accNo
            r51 = r5
            goto L_0x02fb
        L_0x02f7:
            r51 = r5
            r4 = r28
        L_0x02fb:
            r5 = 17
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0309
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x030b
        L_0x0309:
            r4 = r28
        L_0x030b:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x031a
            if (r5 == 0) goto L_0x0316
            r52 = 144115188075855872(0x200000000000000, double:4.7783097267364807E-299)
            goto L_0x0318
        L_0x0316:
            r52 = 72057594037927936(0x100000000000000, double:7.2911220195563975E-304)
        L_0x0318:
            long r2 = r2 | r52
        L_0x031a:
            if (r5 == 0) goto L_0x0320
            r5 = r4
            r4 = 8
            goto L_0x0329
        L_0x0320:
            r5 = r4
            goto L_0x0328
        L_0x0322:
            r50 = r4
            r51 = r5
            r5 = r28
        L_0x0328:
            r4 = 0
        L_0x0329:
            r52 = 12845056(0xc40000, double:6.346301E-317)
            long r52 = r2 & r52
            r41 = 0
            int r6 = (r52 > r41 ? 1 : (r52 == r41 ? 0 : -1))
            if (r6 == 0) goto L_0x036e
            r52 = r4
            if (r0 == 0) goto L_0x033d
            androidx.databinding.i<java.lang.String> r4 = r0.ifscCode
            r53 = r5
            goto L_0x0341
        L_0x033d:
            r53 = r5
            r4 = r28
        L_0x0341:
            r5 = 18
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x034f
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0351
        L_0x034f:
            r4 = r28
        L_0x0351:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x0366
            if (r5 == 0) goto L_0x035f
            r54 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            goto L_0x0364
        L_0x035f:
            r54 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
        L_0x0364:
            long r2 = r2 | r54
        L_0x0366:
            if (r5 == 0) goto L_0x036c
            r5 = r4
            r4 = 8
            goto L_0x0375
        L_0x036c:
            r5 = r4
            goto L_0x0374
        L_0x036e:
            r52 = r4
            r53 = r5
            r5 = r28
        L_0x0374:
            r4 = 0
        L_0x0375:
            r54 = 13107200(0xc80000, double:6.475817E-317)
            long r54 = r2 & r54
            r41 = 0
            int r6 = (r54 > r41 ? 1 : (r54 == r41 ? 0 : -1))
            r54 = r4
            if (r6 == 0) goto L_0x03b3
            if (r0 == 0) goto L_0x0389
            androidx.databinding.i<java.lang.String> r4 = r0.transactionType
            r55 = r5
            goto L_0x038d
        L_0x0389:
            r55 = r5
            r4 = r28
        L_0x038d:
            r5 = 19
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x039b
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x039d
        L_0x039b:
            r4 = r28
        L_0x039d:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x03ae
            if (r5 == 0) goto L_0x03a9
            r56 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x03ac
        L_0x03a9:
            r56 = 16777216(0x1000000, double:8.289046E-317)
        L_0x03ac:
            long r2 = r2 | r56
        L_0x03ae:
            if (r5 == 0) goto L_0x03b7
            r5 = 8
            goto L_0x03b8
        L_0x03b3:
            r55 = r5
            r4 = r28
        L_0x03b7:
            r5 = 0
        L_0x03b8:
            r56 = 13631488(0xd00000, double:6.73485E-317)
            long r56 = r2 & r56
            r41 = 0
            int r6 = (r56 > r41 ? 1 : (r56 == r41 ? 0 : -1))
            if (r6 == 0) goto L_0x03dc
            if (r0 == 0) goto L_0x03ca
            androidx.databinding.i<java.lang.String> r6 = r0.settlementDate
            r56 = r4
            goto L_0x03ce
        L_0x03ca:
            r56 = r4
            r6 = r28
        L_0x03ce:
            r4 = 20
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x03de
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x03e0
        L_0x03dc:
            r56 = r4
        L_0x03de:
            r4 = r28
        L_0x03e0:
            long r57 = r2 & r22
            r41 = 0
            int r6 = (r57 > r41 ? 1 : (r57 == r41 ? 0 : -1))
            r57 = r4
            if (r6 == 0) goto L_0x0462
            if (r0 == 0) goto L_0x03f1
            androidx.databinding.ObservableBoolean r4 = r0.isMobileAvailable
            r58 = r5
            goto L_0x03f5
        L_0x03f1:
            r58 = r5
            r4 = r28
        L_0x03f5:
            r5 = 21
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0401
            boolean r4 = r4.get()
            goto L_0x0402
        L_0x0401:
            r4 = 0
        L_0x0402:
            if (r6 == 0) goto L_0x0410
            if (r4 == 0) goto L_0x040c
            r5 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x040f
        L_0x040c:
            r5 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x040f:
            long r2 = r2 | r5
        L_0x0410:
            r5 = 14680064(0xe00000, double:7.2529153E-317)
            long r26 = r2 & r5
            r41 = 0
            int r59 = (r26 > r41 ? 1 : (r26 == r41 ? 0 : -1))
            if (r59 == 0) goto L_0x042a
            if (r4 == 0) goto L_0x0423
            r26 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x0428
        L_0x0423:
            r26 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x0428:
            long r2 = r2 | r26
        L_0x042a:
            long r59 = r2 & r5
            int r5 = (r59 > r41 ? 1 : (r59 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0467
            if (r4 == 0) goto L_0x0433
            goto L_0x0467
        L_0x0433:
            r63 = r7
            r73 = r8
            r62 = r10
            r65 = r11
            r35 = r13
            r36 = r15
            r66 = r40
            r13 = r44
            r10 = r45
            r71 = r46
            r7 = r47
            r11 = r48
            r15 = r49
            r61 = r50
            r72 = r51
            r6 = r52
            r5 = r53
            r70 = r54
            r69 = r55
            r68 = r56
            r64 = r57
            r67 = r58
            r8 = 8
            goto L_0x0494
        L_0x0462:
            r58 = r5
            r41 = 0
            r4 = 0
        L_0x0467:
            r63 = r7
            r73 = r8
            r62 = r10
            r65 = r11
            r35 = r13
            r36 = r15
            r66 = r40
            r13 = r44
            r10 = r45
            r71 = r46
            r7 = r47
            r11 = r48
            r15 = r49
            r61 = r50
            r72 = r51
            r6 = r52
            r5 = r53
            r70 = r54
            r69 = r55
            r68 = r56
            r64 = r57
            r67 = r58
            r8 = 0
        L_0x0494:
            r44 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
            goto L_0x04cc
        L_0x0497:
            r41 = r4
            r44 = r10
            r5 = r28
            r7 = r5
            r10 = r7
            r11 = r10
            r13 = r11
            r14 = r13
            r15 = r14
            r35 = r15
            r39 = r35
            r43 = r39
            r62 = r43
            r64 = r62
            r68 = r64
            r69 = r68
            r71 = r69
            r72 = r71
            r73 = r72
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r12 = 0
            r34 = 0
            r36 = 0
            r61 = 0
            r63 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r70 = 0
        L_0x04cc:
            long r44 = r2 & r44
            int r40 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r40 == 0) goto L_0x04ee
            r40 = r15
            if (r0 == 0) goto L_0x04db
            androidx.databinding.ObservableBoolean r15 = r0.isPCFTransaction
            r44 = r13
            goto L_0x04df
        L_0x04db:
            r44 = r13
            r15 = r28
        L_0x04df:
            r13 = 2
            r1.updateRegistration((int) r13, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x04ea
            boolean r13 = r15.get()
            goto L_0x04eb
        L_0x04ea:
            r13 = 0
        L_0x04eb:
            r15 = 1
            r13 = r13 ^ r15
            goto L_0x04f3
        L_0x04ee:
            r44 = r13
            r40 = r15
            r13 = 0
        L_0x04f3:
            r29 = 1073741824(0x40000000, double:5.304989477E-315)
            long r29 = r2 & r29
            r41 = 0
            int r15 = (r29 > r41 ? 1 : (r29 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0525
            if (r0 == 0) goto L_0x0505
            androidx.databinding.ObservableBoolean r15 = r0.isEmailAvailable
            r29 = r13
            goto L_0x0509
        L_0x0505:
            r29 = r13
            r15 = r35
        L_0x0509:
            r13 = 5
            r1.updateRegistration((int) r13, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0513
            boolean r34 = r15.get()
        L_0x0513:
            long r45 = r2 & r20
            r41 = 0
            int r13 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0527
            if (r34 == 0) goto L_0x0520
            r45 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
            goto L_0x0522
        L_0x0520:
            r45 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
        L_0x0522:
            long r2 = r2 | r45
            goto L_0x0527
        L_0x0525:
            r29 = r13
        L_0x0527:
            long r45 = r2 & r22
            r41 = 0
            int r13 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x0545
            if (r4 == 0) goto L_0x0533
            r34 = 1
        L_0x0533:
            if (r13 == 0) goto L_0x0547
            if (r34 == 0) goto L_0x053d
            r45 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x0542
        L_0x053d:
            r45 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x0542:
            long r2 = r2 | r45
            goto L_0x0547
        L_0x0545:
            r34 = 0
        L_0x0547:
            long r45 = r2 & r24
            r47 = 12582918(0xc00006, double:6.2167875E-317)
            r41 = 0
            int r4 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x058e
            if (r9 != 0) goto L_0x0556
            r29 = 0
        L_0x0556:
            long r45 = r2 & r47
            int r4 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x056b
            if (r29 == 0) goto L_0x0564
            r45 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x0569
        L_0x0564:
            r45 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x0569:
            long r2 = r2 | r45
        L_0x056b:
            long r45 = r2 & r24
            int r4 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x0580
            if (r29 == 0) goto L_0x0579
            r45 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x057e
        L_0x0579:
            r45 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x057e:
            long r2 = r2 | r45
        L_0x0580:
            long r45 = r2 & r47
            int r4 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r4 == 0) goto L_0x058c
            if (r29 == 0) goto L_0x0589
            goto L_0x058c
        L_0x0589:
            r4 = 8
            goto L_0x0591
        L_0x058c:
            r4 = 0
            goto L_0x0591
        L_0x058e:
            r4 = 0
            r29 = 0
        L_0x0591:
            r45 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            long r45 = r2 & r45
            int r9 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r9 == 0) goto L_0x05ae
            if (r0 == 0) goto L_0x05a1
            androidx.databinding.ObservableBoolean r9 = r0.isDirectSettlementVisible
            goto L_0x05a3
        L_0x05a1:
            r9 = r28
        L_0x05a3:
            r13 = 3
            r1.updateRegistration((int) r13, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x05ae
            boolean r9 = r9.get()
            goto L_0x05af
        L_0x05ae:
            r9 = 0
        L_0x05af:
            r45 = 17179869184(0x400000000, double:8.4879831639E-314)
            long r45 = r2 & r45
            r41 = 0
            int r13 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x05ec
            if (r0 == 0) goto L_0x05c1
            androidx.databinding.i<java.lang.String> r0 = r0.customerName
            goto L_0x05c3
        L_0x05c1:
            r0 = r39
        L_0x05c3:
            r13 = 9
            r1.updateRegistration((int) r13, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x05d2
            java.lang.Object r0 = r0.get()
            r43 = r0
            java.lang.String r43 = (java.lang.String) r43
        L_0x05d2:
            boolean r0 = android.text.TextUtils.isEmpty(r43)
            r37 = 1
            r0 = r0 ^ 1
            long r35 = r2 & r16
            r41 = 0
            int r13 = (r35 > r41 ? 1 : (r35 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x05f0
            if (r0 == 0) goto L_0x05e7
            r35 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            goto L_0x05e9
        L_0x05e7:
            r35 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
        L_0x05e9:
            long r2 = r2 | r35
            goto L_0x05f0
        L_0x05ec:
            r37 = 1
            r0 = r36
        L_0x05f0:
            r13 = r43
            long r35 = r2 & r22
            r41 = 0
            int r15 = (r35 > r41 ? 1 : (r35 == r41 ? 0 : -1))
            if (r15 == 0) goto L_0x0613
            if (r34 == 0) goto L_0x05fd
            r0 = 1
        L_0x05fd:
            if (r15 == 0) goto L_0x060e
            if (r0 == 0) goto L_0x0607
            r34 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x060c
        L_0x0607:
            r34 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x060c:
            long r2 = r2 | r34
        L_0x060e:
            if (r0 != 0) goto L_0x0613
            r0 = 8
            goto L_0x0614
        L_0x0613:
            r0 = 0
        L_0x0614:
            long r34 = r2 & r24
            r36 = 0
            int r15 = (r34 > r36 ? 1 : (r34 == r36 ? 0 : -1))
            if (r15 == 0) goto L_0x0635
            if (r29 != 0) goto L_0x061f
            r9 = 0
        L_0x061f:
            if (r15 == 0) goto L_0x0630
            if (r9 == 0) goto L_0x0629
            r28 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x062e
        L_0x0629:
            r28 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x062e:
            long r2 = r2 | r28
        L_0x0630:
            if (r9 != 0) goto L_0x0635
            r9 = 8
            goto L_0x0636
        L_0x0635:
            r9 = 0
        L_0x0636:
            r28 = 12713984(0xc20000, double:6.2815427E-317)
            long r28 = r2 & r28
            r30 = 0
            int r15 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r15 == 0) goto L_0x0655
            android.widget.ImageView r15 = r1.imageView3
            r15.setVisibility(r6)
            android.widget.TextView r15 = r1.textView29
            androidx.databinding.a.d.a((android.widget.TextView) r15, (java.lang.CharSequence) r5)
            android.widget.TextView r5 = r1.textView29
            r5.setVisibility(r6)
            android.widget.TextView r5 = r1.tvAccountLbl
            r5.setVisibility(r6)
        L_0x0655:
            r5 = 12583168(0xc00100, double:6.216911E-317)
            long r5 = r5 & r2
            r28 = 0
            int r15 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r15 == 0) goto L_0x0664
            android.widget.ImageView r5 = r1.imageView3
            com.business.merchant_payments.common.utility.DataBindingUtility.loadPayMethodImage(r5, r14)
        L_0x0664:
            r5 = 12591104(0xc02000, double:6.220832E-317)
            long r5 = r5 & r2
            int r14 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r14 == 0) goto L_0x0671
            android.widget.ImageView r5 = r1.ivPaymode
            com.business.merchant_payments.common.utility.DataBindingUtility.loadPayMethodImage(r5, r7)
        L_0x0671:
            r5 = 14680064(0xe00000, double:7.2529153E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x0683
            android.widget.TextView r5 = r1.textView10
            r5.setVisibility(r8)
            android.widget.TextView r5 = r1.textView11
            r5.setVisibility(r8)
        L_0x0683:
            r5 = 12584960(0xc00800, double:6.2177964E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x0690
            android.widget.TextView r5 = r1.textView11
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r10)
        L_0x0690:
            long r5 = r2 & r20
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06a0
            android.widget.TextView r5 = r1.textView12
            r5.setVisibility(r12)
            android.widget.TextView r5 = r1.textView13
            r5.setVisibility(r12)
        L_0x06a0:
            r5 = 12599296(0xc04000, double:6.2248793E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06ad
            android.widget.TextView r5 = r1.textView13
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r11)
        L_0x06ad:
            r5 = 12583936(0xc00400, double:6.2172905E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06bc
            android.widget.TextView r5 = r1.textView18
            r6 = r44
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r6)
        L_0x06bc:
            r5 = 12582913(0xc00001, double:6.216785E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06cb
            android.widget.TextView r5 = r1.textView19
            r6 = r40
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r6)
        L_0x06cb:
            r5 = 12615680(0xc08000, double:6.232974E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06df
            android.widget.TextView r5 = r1.textView19
            r6 = r61
            r5.setVisibility(r6)
            android.widget.TextView r5 = r1.textView20
            r5.setVisibility(r6)
        L_0x06df:
            r5 = 12582976(0xc00040, double:6.216816E-317)
            long r5 = r5 & r2
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06ee
            android.widget.TextView r5 = r1.textView20
            r10 = r62
            androidx.databinding.a.d.a((android.widget.TextView) r5, (java.lang.CharSequence) r10)
        L_0x06ee:
            long r5 = r2 & r18
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x06fb
            android.widget.TextView r5 = r1.textView21
            r7 = r63
            r5.setVisibility(r7)
        L_0x06fb:
            long r5 = r2 & r47
            int r7 = (r5 > r28 ? 1 : (r5 == r28 ? 0 : -1))
            if (r7 == 0) goto L_0x0715
            android.widget.TextView r5 = r1.textView22
            r5.setVisibility(r4)
            android.widget.TextView r5 = r1.textView23
            r5.setVisibility(r4)
            android.widget.TextView r5 = r1.textView24
            r5.setVisibility(r4)
            android.widget.TextView r5 = r1.utrText
            r5.setVisibility(r4)
        L_0x0715:
            r4 = 13631488(0xd00000, double:6.73485E-317)
            long r4 = r4 & r2
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0726
            android.widget.TextView r4 = r1.textView23
            r5 = r64
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
        L_0x0726:
            r4 = 12583040(0xc00080, double:6.216848E-317)
            long r4 = r4 & r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x073a
            android.widget.TextView r4 = r1.textView25
            r11 = r65
            r4.setVisibility(r11)
            android.widget.TextView r4 = r1.tvPaymentDescriptionText
            r4.setVisibility(r11)
        L_0x073a:
            long r4 = r2 & r16
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0751
            android.widget.TextView r4 = r1.textView28
            r5 = r66
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.textView31
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r13)
            android.widget.TextView r4 = r1.textView31
            r4.setVisibility(r5)
        L_0x0751:
            r4 = 13107200(0xc80000, double:6.475817E-317)
            long r4 = r4 & r2
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x076e
            android.widget.TextView r4 = r1.textView7
            r5 = r67
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.textView8
            r8 = r68
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r8)
            android.widget.TextView r4 = r1.textView8
            r4.setVisibility(r5)
        L_0x076e:
            long r4 = r2 & r22
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0779
            android.widget.TextView r4 = r1.textView9
            r4.setVisibility(r0)
        L_0x0779:
            long r4 = r2 & r24
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0789
            android.widget.TextView r0 = r1.tvDirectBank
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.tvDirectSettle
            r0.setVisibility(r9)
        L_0x0789:
            r4 = 12845056(0xc40000, double:6.346301E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x07a4
            android.widget.TextView r0 = r1.tvIfsc
            r4 = r69
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.tvIfsc
            r4 = r70
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tvIfscLbl
            r0.setVisibility(r4)
        L_0x07a4:
            r4 = 12587008(0xc01000, double:6.218808E-317)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x07b5
            android.widget.TextView r0 = r1.tvOrderIdText
            r4 = r71
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x07b5:
            r4 = 12648448(0xc10000, double:6.2491636E-317)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x07c4
            android.widget.TextView r0 = r1.tvPaymentDescriptionText
            r4 = r72
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x07c4:
            r4 = 12582928(0xc00010, double:6.2167924E-317)
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x07d3
            android.widget.TextView r0 = r1.utrText
            r8 = r73
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x07d3:
            return
        L_0x07d4:
            r0 = move-exception
            monitor-exit(r74)     // Catch:{ all -> 0x07d4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpTransactionDetailSubViewBindingImpl.executeBindings():void");
    }
}
