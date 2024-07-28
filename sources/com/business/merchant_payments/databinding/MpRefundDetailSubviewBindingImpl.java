package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;

public class MpRefundDetailSubviewBindingImpl extends MpRefundDetailSubviewBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.barrier, 21);
        sViewsWithIds.put(R.id.textView14, 22);
        sViewsWithIds.put(R.id.textView7, 23);
        sViewsWithIds.put(R.id.tv_order_id, 24);
        sViewsWithIds.put(R.id.textView15, 25);
        sViewsWithIds.put(R.id.profile_label_bank_name, 26);
        sViewsWithIds.put(R.id.data_profile_bank_name, 27);
    }

    public MpRefundDetailSubviewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 28, sIncludes, sViewsWithIds));
    }

    public MpRefundDetailSubviewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 8, objArr[21], objArr[27], objArr[10], objArr[26], objArr[2], objArr[3], objArr[4], objArr[5], objArr[22], objArr[25], objArr[9], objArr[11], objArr[12], objArr[13], objArr[16], objArr[14], objArr[8], objArr[19], objArr[20], objArr[23], objArr[6], objArr[1], objArr[18], objArr[17], objArr[24], objArr[7], objArr[15]);
        this.mDirtyFlags = -1;
        this.ivPaymode.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.textView10.setTag((Object) null);
        this.textView11.setTag((Object) null);
        this.textView12.setTag((Object) null);
        this.textView13.setTag((Object) null);
        this.textView17.setTag((Object) null);
        this.textView18.setTag((Object) null);
        this.textView19.setTag((Object) null);
        this.textView20.setTag((Object) null);
        this.textView21.setTag((Object) null);
        this.textView25.setTag((Object) null);
        this.textView27.setTag((Object) null);
        this.textView28.setTag((Object) null);
        this.textView31.setTag((Object) null);
        this.textView8.setTag((Object) null);
        this.textView9.setTag((Object) null);
        this.tvBank.setTag((Object) null);
        this.tvDirectSettleVia.setTag((Object) null);
        this.tvOrderIdText.setTag((Object) null);
        this.tvPaymentDescriptionText.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        setViewModel((RefundDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(RefundDetailsViewModel refundDetailsViewModel) {
        updateRegistration(7, (h) refundDetailsViewModel);
        this.mViewModel = refundDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelEmailVisibility((ObservableBoolean) obj, i3);
            case 1:
                return onChangeViewModelIsPayModeVisible((ObservableBoolean) obj, i3);
            case 2:
                return onChangeViewModelIsPayDetailsVisible((ObservableBoolean) obj, i3);
            case 3:
                return onChangeViewModelPayModeDetailText((i) obj, i3);
            case 4:
                return onChangeViewModelIsDirectSettleViaBankVisible((ObservableBoolean) obj, i3);
            case 5:
                return onChangeViewModelIsPaymentDescriptionVisible((ObservableBoolean) obj, i3);
            case 6:
                return onChangeViewModelIsMobileAvailable((ObservableBoolean) obj, i3);
            case 7:
                return onChangeViewModel((RefundDetailsViewModel) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelEmailVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsPayModeVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsPayDetailsVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelPayModeDetailText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelIsDirectSettleViaBankVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelIsPaymentDescriptionVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelIsMobileAvailable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModel(RefundDetailsViewModel refundDetailsViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r59 = this;
            r1 = r59
            monitor-enter(r59)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x040a }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x040a }
            monitor-exit(r59)     // Catch:{ all -> 0x040a }
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r0 = r1.mViewModel
            r6 = 511(0x1ff, double:2.525E-321)
            long r6 = r6 & r2
            r10 = 67108864(0x4000000, double:3.31561842E-316)
            r12 = 33554432(0x2000000, double:1.6578092E-316)
            r16 = 8388608(0x800000, double:4.144523E-317)
            r18 = 448(0x1c0, double:2.213E-321)
            r20 = 385(0x181, double:1.9E-321)
            r22 = 384(0x180, double:1.897E-321)
            r14 = 1
            r26 = 449(0x1c1, double:2.22E-321)
            r28 = 0
            r15 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x026f
            long r6 = r2 & r22
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00a2
            if (r0 == 0) goto L_0x006e
            java.lang.String r6 = r0.getOrderId()
            java.lang.String r7 = r0.getPayMethodIconUrl()
            java.lang.String r31 = r0.getTxnDate()
            android.text.Spannable r32 = r0.payModeDescription()
            java.lang.String r33 = r0.getPayModeDetailLabel()
            java.lang.String r34 = r0.getEmail()
            java.lang.String r35 = r0.getCustomerName()
            java.lang.String r36 = r0.getPaymentMode()
            java.lang.String r37 = r0.getPayMode()
            android.text.Spannable r38 = r0.getTxnAmount()
            int r39 = r0.isUnlimitedMerchant()
            r58 = r7
            r7 = r6
            r6 = r37
            r37 = r36
            r36 = r34
            r34 = r33
            r33 = r32
            r32 = r31
            r31 = r58
            goto L_0x0083
        L_0x006e:
            r6 = r28
            r7 = r6
            r31 = r7
            r32 = r31
            r33 = r32
            r34 = r33
            r35 = r34
            r36 = r35
            r37 = r36
            r38 = r37
            r39 = 0
        L_0x0083:
            boolean r40 = android.text.TextUtils.isEmpty(r35)
            android.view.View r41 = r59.getRoot()
            android.content.Context r8 = r41.getContext()
            java.lang.String r6 = com.business.merchant_payments.common.utility.AppUtility.getPayModeLocalised(r8, r6)
            r8 = r40 ^ 1
            if (r30 == 0) goto L_0x009c
            if (r8 == 0) goto L_0x009b
            long r2 = r2 | r10
            goto L_0x009c
        L_0x009b:
            long r2 = r2 | r12
        L_0x009c:
            if (r8 != 0) goto L_0x00b8
            r9 = r8
            r8 = 8
            goto L_0x00ba
        L_0x00a2:
            r6 = r28
            r7 = r6
            r31 = r7
            r32 = r31
            r33 = r32
            r34 = r33
            r35 = r34
            r36 = r35
            r37 = r36
            r38 = r37
            r8 = 0
            r39 = 0
        L_0x00b8:
            r9 = r8
            r8 = 0
        L_0x00ba:
            long r40 = r2 & r20
            int r30 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00eb
            if (r0 == 0) goto L_0x00c5
            androidx.databinding.ObservableBoolean r12 = r0.emailVisibility
            goto L_0x00c7
        L_0x00c5:
            r12 = r28
        L_0x00c7:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00d1
            boolean r13 = r12.get()
            goto L_0x00d2
        L_0x00d1:
            r13 = 0
        L_0x00d2:
            if (r30 == 0) goto L_0x00e1
            if (r13 == 0) goto L_0x00dc
            r44 = 268435456(0x10000000, double:1.32624737E-315)
            long r2 = r2 | r44
            goto L_0x00e1
        L_0x00dc:
            r42 = 134217728(0x8000000, double:6.63123685E-316)
            long r2 = r2 | r42
        L_0x00e1:
            if (r13 != 0) goto L_0x00ee
            r30 = r13
            r24 = 386(0x182, double:1.907E-321)
            r13 = r12
            r12 = 8
            goto L_0x00f4
        L_0x00eb:
            r12 = r28
            r13 = 0
        L_0x00ee:
            r30 = r13
            r24 = 386(0x182, double:1.907E-321)
            r13 = r12
            r12 = 0
        L_0x00f4:
            long r44 = r2 & r24
            int r46 = (r44 > r4 ? 1 : (r44 == r4 ? 0 : -1))
            if (r46 == 0) goto L_0x011e
            if (r0 == 0) goto L_0x00ff
            androidx.databinding.ObservableBoolean r10 = r0.isPayModeVisible
            goto L_0x0101
        L_0x00ff:
            r10 = r28
        L_0x0101:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x010b
            boolean r10 = r10.get()
            goto L_0x010c
        L_0x010b:
            r10 = 0
        L_0x010c:
            if (r46 == 0) goto L_0x0119
            if (r10 == 0) goto L_0x0114
            r46 = 262144(0x40000, double:1.295163E-318)
            goto L_0x0117
        L_0x0114:
            r46 = 131072(0x20000, double:6.47582E-319)
        L_0x0117:
            long r2 = r2 | r46
        L_0x0119:
            if (r10 != 0) goto L_0x011e
            r10 = 8
            goto L_0x011f
        L_0x011e:
            r10 = 0
        L_0x011f:
            r46 = 388(0x184, double:1.917E-321)
            long r46 = r2 & r46
            int r11 = (r46 > r4 ? 1 : (r46 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x014c
            if (r0 == 0) goto L_0x012c
            androidx.databinding.ObservableBoolean r14 = r0.isPayDetailsVisible
            goto L_0x012e
        L_0x012c:
            r14 = r28
        L_0x012e:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0139
            boolean r15 = r14.get()
            goto L_0x013a
        L_0x0139:
            r15 = 0
        L_0x013a:
            if (r11 == 0) goto L_0x0147
            if (r15 == 0) goto L_0x0142
            r48 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x0145
        L_0x0142:
            r48 = 524288(0x80000, double:2.590327E-318)
        L_0x0145:
            long r2 = r2 | r48
        L_0x0147:
            if (r15 != 0) goto L_0x014c
            r15 = 8
            goto L_0x014d
        L_0x014c:
            r15 = 0
        L_0x014d:
            r48 = 392(0x188, double:1.937E-321)
            long r48 = r2 & r48
            int r11 = (r48 > r4 ? 1 : (r48 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0169
            if (r0 == 0) goto L_0x015a
            androidx.databinding.i<java.lang.String> r11 = r0.payModeDetailText
            goto L_0x015c
        L_0x015a:
            r11 = r28
        L_0x015c:
            r14 = 3
            r1.updateRegistration((int) r14, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x0169
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x016b
        L_0x0169:
            r11 = r28
        L_0x016b:
            r48 = 400(0x190, double:1.976E-321)
            long r48 = r2 & r48
            int r14 = (r48 > r4 ? 1 : (r48 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0197
            if (r0 == 0) goto L_0x0178
            androidx.databinding.ObservableBoolean r4 = r0.isDirectSettleViaBankVisible
            goto L_0x017a
        L_0x0178:
            r4 = r28
        L_0x017a:
            r5 = 4
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0185
            boolean r4 = r4.get()
            goto L_0x0186
        L_0x0185:
            r4 = 0
        L_0x0186:
            if (r14 == 0) goto L_0x0191
            if (r4 == 0) goto L_0x018d
            r50 = 16384(0x4000, double:8.0948E-320)
            goto L_0x018f
        L_0x018d:
            r50 = 8192(0x2000, double:4.0474E-320)
        L_0x018f:
            long r2 = r2 | r50
        L_0x0191:
            if (r4 == 0) goto L_0x0194
            goto L_0x0197
        L_0x0194:
            r4 = 8
            goto L_0x0198
        L_0x0197:
            r4 = 0
        L_0x0198:
            r50 = 416(0x1a0, double:2.055E-321)
            long r50 = r2 & r50
            r48 = 0
            int r5 = (r50 > r48 ? 1 : (r50 == r48 ? 0 : -1))
            if (r5 == 0) goto L_0x01cb
            if (r0 == 0) goto L_0x01a9
            androidx.databinding.ObservableBoolean r14 = r0.isPaymentDescriptionVisible
            r50 = r4
            goto L_0x01ad
        L_0x01a9:
            r50 = r4
            r14 = r28
        L_0x01ad:
            r4 = 5
            r1.updateRegistration((int) r4, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x01b8
            boolean r4 = r14.get()
            goto L_0x01b9
        L_0x01b8:
            r4 = 0
        L_0x01b9:
            if (r5 == 0) goto L_0x01c6
            if (r4 == 0) goto L_0x01c1
            r51 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x01c4
        L_0x01c1:
            r51 = 2097152(0x200000, double:1.0361308E-317)
        L_0x01c4:
            long r2 = r2 | r51
        L_0x01c6:
            if (r4 != 0) goto L_0x01cd
            r4 = 8
            goto L_0x01ce
        L_0x01cb:
            r50 = r4
        L_0x01cd:
            r4 = 0
        L_0x01ce:
            long r51 = r2 & r26
            r48 = 0
            int r5 = (r51 > r48 ? 1 : (r51 == r48 ? 0 : -1))
            if (r5 == 0) goto L_0x0245
            if (r0 == 0) goto L_0x01db
            androidx.databinding.ObservableBoolean r5 = r0.isMobileAvailable
            goto L_0x01dd
        L_0x01db:
            r5 = r28
        L_0x01dd:
            r14 = 6
            r1.updateRegistration((int) r14, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x01e8
            boolean r5 = r5.get()
            goto L_0x01e9
        L_0x01e8:
            r5 = 0
        L_0x01e9:
            long r51 = r2 & r18
            r48 = 0
            int r14 = (r51 > r48 ? 1 : (r51 == r48 ? 0 : -1))
            if (r14 == 0) goto L_0x01fa
            if (r5 == 0) goto L_0x01f6
            r51 = 4096(0x1000, double:2.0237E-320)
            goto L_0x01f8
        L_0x01f6:
            r51 = 2048(0x800, double:1.0118E-320)
        L_0x01f8:
            long r2 = r2 | r51
        L_0x01fa:
            long r51 = r2 & r26
            int r14 = (r51 > r48 ? 1 : (r51 == r48 ? 0 : -1))
            if (r14 == 0) goto L_0x020a
            if (r5 == 0) goto L_0x0208
            r51 = 16777216(0x1000000, double:8.289046E-317)
            long r2 = r2 | r51
            goto L_0x020a
        L_0x0208:
            long r2 = r2 | r16
        L_0x020a:
            long r51 = r2 & r18
            int r14 = (r51 > r48 ? 1 : (r51 == r48 ? 0 : -1))
            if (r14 == 0) goto L_0x0230
            if (r5 == 0) goto L_0x0213
            goto L_0x0230
        L_0x0213:
            r56 = r4
            r28 = r9
            r55 = r11
            r53 = r12
            r54 = r15
            r11 = r34
            r14 = r36
            r9 = r37
            r4 = r39
            r57 = r50
            r12 = r6
            r15 = r8
            r6 = r31
            r8 = r32
            r32 = 8
            goto L_0x0264
        L_0x0230:
            r56 = r4
            r28 = r9
            r55 = r11
            r53 = r12
            r54 = r15
            r11 = r34
            r14 = r36
            r9 = r37
            r4 = r39
            r57 = r50
            goto L_0x025c
        L_0x0245:
            r48 = 0
            r56 = r4
            r28 = r9
            r55 = r11
            r53 = r12
            r54 = r15
            r11 = r34
            r14 = r36
            r9 = r37
            r4 = r39
            r57 = r50
            r5 = 0
        L_0x025c:
            r12 = r6
            r15 = r8
            r6 = r31
            r8 = r32
            r32 = 0
        L_0x0264:
            r31 = r13
            r13 = r38
            r58 = r33
            r33 = r10
            r10 = r58
            goto L_0x0294
        L_0x026f:
            r48 = r4
            r6 = r28
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r31 = r14
            r35 = r31
            r55 = r35
            r4 = 0
            r5 = 0
            r15 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r53 = 0
            r54 = 0
            r56 = 0
            r57 = 0
        L_0x0294:
            long r16 = r2 & r16
            int r34 = (r16 > r48 ? 1 : (r16 == r48 ? 0 : -1))
            if (r34 == 0) goto L_0x02c5
            r16 = r10
            if (r0 == 0) goto L_0x02a3
            androidx.databinding.ObservableBoolean r10 = r0.emailVisibility
            r17 = r7
            goto L_0x02a7
        L_0x02a3:
            r17 = r7
            r10 = r31
        L_0x02a7:
            r7 = 0
            r1.updateRegistration((int) r7, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x02b1
            boolean r30 = r10.get()
        L_0x02b1:
            long r36 = r2 & r20
            r38 = 0
            int r10 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r10 == 0) goto L_0x02ca
            if (r30 == 0) goto L_0x02bf
            r36 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x02c2
        L_0x02bf:
            r36 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x02c2:
            long r2 = r2 | r36
            goto L_0x02ca
        L_0x02c5:
            r17 = r7
            r16 = r10
            r7 = 0
        L_0x02ca:
            long r36 = r2 & r26
            r38 = 32768(0x8000, double:1.61895E-319)
            r42 = 0
            int r10 = (r36 > r42 ? 1 : (r36 == r42 ? 0 : -1))
            if (r10 == 0) goto L_0x02e6
            if (r5 == 0) goto L_0x02d9
            r30 = 1
        L_0x02d9:
            if (r10 == 0) goto L_0x02e8
            if (r30 == 0) goto L_0x02e3
            r36 = 65536(0x10000, double:3.2379E-319)
            long r2 = r2 | r36
            goto L_0x02e8
        L_0x02e3:
            long r2 = r2 | r38
            goto L_0x02e8
        L_0x02e6:
            r30 = 0
        L_0x02e8:
            long r36 = r2 & r38
            r38 = 0
            int r5 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x030e
            if (r0 == 0) goto L_0x02f6
            java.lang.String r35 = r0.getCustomerName()
        L_0x02f6:
            boolean r0 = android.text.TextUtils.isEmpty(r35)
            r5 = 1
            r0 = r0 ^ r5
            long r36 = r2 & r22
            int r10 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r10 == 0) goto L_0x0311
            if (r0 == 0) goto L_0x0308
            r36 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x030b
        L_0x0308:
            r36 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x030b:
            long r2 = r2 | r36
            goto L_0x0311
        L_0x030e:
            r5 = 1
            r0 = r28
        L_0x0311:
            r10 = r35
            long r34 = r2 & r26
            int r28 = (r34 > r38 ? 1 : (r34 == r38 ? 0 : -1))
            if (r28 == 0) goto L_0x032c
            if (r30 == 0) goto L_0x031c
            r0 = 1
        L_0x031c:
            if (r28 == 0) goto L_0x0327
            if (r0 == 0) goto L_0x0323
            r30 = 1024(0x400, double:5.06E-321)
            goto L_0x0325
        L_0x0323:
            r30 = 512(0x200, double:2.53E-321)
        L_0x0325:
            long r2 = r2 | r30
        L_0x0327:
            if (r0 == 0) goto L_0x032a
            goto L_0x032c
        L_0x032a:
            r7 = 8
        L_0x032c:
            long r22 = r2 & r22
            r28 = 0
            int r0 = (r22 > r28 ? 1 : (r22 == r28 ? 0 : -1))
            if (r0 == 0) goto L_0x0379
            android.widget.ImageView r0 = r1.ivPaymode
            com.business.merchant_payments.common.utility.DataBindingUtility.loadPayMethodImage(r0, r6)
            android.widget.TextView r0 = r1.textView11
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.textView13
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
            android.widget.TextView r0 = r1.textView18
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
            android.widget.TextView r0 = r1.textView19
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
            android.widget.TextView r0 = r1.textView21
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.textView27
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.widget.TextView r0 = r1.textView28
            r0.setVisibility(r15)
            android.widget.TextView r0 = r1.textView31
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.TextView r0 = r1.textView31
            r0.setVisibility(r15)
            android.widget.TextView r0 = r1.textView8
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.tvOrderIdText
            r4 = r17
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.tvPaymentDescriptionText
            r4 = r16
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
        L_0x0379:
            r4 = 386(0x182, double:1.907E-321)
            long r4 = r4 & r2
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0393
            android.widget.ImageView r0 = r1.ivPaymode
            r10 = r33
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.textView17
            r0.setVisibility(r10)
            android.widget.TextView r0 = r1.textView18
            r0.setVisibility(r10)
        L_0x0393:
            long r4 = r2 & r18
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03a5
            android.widget.TextView r0 = r1.textView10
            r4 = r32
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.textView11
            r0.setVisibility(r4)
        L_0x03a5:
            long r4 = r2 & r20
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03b7
            android.widget.TextView r0 = r1.textView12
            r12 = r53
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.textView13
            r0.setVisibility(r12)
        L_0x03b7:
            r4 = 388(0x184, double:1.917E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03ca
            android.widget.TextView r0 = r1.textView19
            r15 = r54
            r0.setVisibility(r15)
            android.widget.TextView r0 = r1.textView20
            r0.setVisibility(r15)
        L_0x03ca:
            r4 = 392(0x188, double:1.937E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03d8
            android.widget.TextView r0 = r1.textView20
            r11 = r55
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x03d8:
            r4 = 416(0x1a0, double:2.055E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03eb
            android.widget.TextView r0 = r1.textView25
            r4 = r56
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tvPaymentDescriptionText
            r0.setVisibility(r4)
        L_0x03eb:
            long r4 = r2 & r26
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x03f6
            android.widget.TextView r0 = r1.textView9
            r0.setVisibility(r7)
        L_0x03f6:
            r4 = 400(0x190, double:1.976E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0409
            android.widget.TextView r0 = r1.tvBank
            r2 = r57
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.tvDirectSettleVia
            r0.setVisibility(r2)
        L_0x0409:
            return
        L_0x040a:
            r0 = move-exception
            monitor-exit(r59)     // Catch:{ all -> 0x040a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpRefundDetailSubviewBindingImpl.executeBindings():void");
    }
}
