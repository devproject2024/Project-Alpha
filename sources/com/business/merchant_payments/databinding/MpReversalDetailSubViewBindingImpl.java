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
import com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel;

public class MpReversalDetailSubViewBindingImpl extends MpReversalDetailSubViewBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.barrier, 15);
        sViewsWithIds.put(R.id.textView14, 16);
        sViewsWithIds.put(R.id.textView7, 17);
        sViewsWithIds.put(R.id.tv_order_id, 18);
        sViewsWithIds.put(R.id.textView15, 19);
        sViewsWithIds.put(R.id.profile_label_bank_name, 20);
        sViewsWithIds.put(R.id.data_profile_bank_name, 21);
        sViewsWithIds.put(R.id.tv_settled_amnt, 22);
    }

    public MpReversalDetailSubViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 23, sIncludes, sViewsWithIds));
    }

    public MpReversalDetailSubViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 7, objArr[15], objArr[21], objArr[5], objArr[20], objArr[16], objArr[19], objArr[4], objArr[6], objArr[7], objArr[8], objArr[11], objArr[9], objArr[3], objArr[12], objArr[17], objArr[1], objArr[14], objArr[13], objArr[18], objArr[2], objArr[10], objArr[22]);
        this.mDirtyFlags = -1;
        this.ivPaymode.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.textView17.setTag((Object) null);
        this.textView18.setTag((Object) null);
        this.textView19.setTag((Object) null);
        this.textView20.setTag((Object) null);
        this.textView21.setTag((Object) null);
        this.textView25.setTag((Object) null);
        this.textView27.setTag((Object) null);
        this.textView30.setTag((Object) null);
        this.textView8.setTag((Object) null);
        this.tvBank.setTag((Object) null);
        this.tvDirectSettleVia.setTag((Object) null);
        this.tvOrderIdText.setTag((Object) null);
        this.tvPaymentDescriptionText.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        setViewModel((ReversalDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(ReversalDetailsViewModel reversalDetailsViewModel) {
        updateRegistration(6, (h) reversalDetailsViewModel);
        this.mViewModel = reversalDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelIsPayModeVisible((ObservableBoolean) obj, i3);
            case 1:
                return onChangeViewModelIsPayDetailsVisible((ObservableBoolean) obj, i3);
            case 2:
                return onChangeViewModelTxnDetailsString((i) obj, i3);
            case 3:
                return onChangeViewModelPayModeDetailText((i) obj, i3);
            case 4:
                return onChangeViewModelIsDirectSettleViaBankVisible((ObservableBoolean) obj, i3);
            case 5:
                return onChangeViewModelIsPaymentDescriptionVisible((ObservableBoolean) obj, i3);
            case 6:
                return onChangeViewModel((ReversalDetailsViewModel) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelIsPayModeVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsPayDetailsVisible(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelTxnDetailsString(i<String> iVar, int i2) {
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

    private boolean onChangeViewModel(ReversalDetailsViewModel reversalDetailsViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r42 = this;
            r1 = r42
            monitor-enter(r42)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x022e }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x022e }
            monitor-exit(r42)     // Catch:{ all -> 0x022e }
            com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel r0 = r1.mViewModel
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r12 = 196(0xc4, double:9.7E-322)
            r14 = 200(0xc8, double:9.9E-322)
            r16 = 194(0xc2, double:9.6E-322)
            r18 = 193(0xc1, double:9.54E-322)
            r20 = 192(0xc0, double:9.5E-322)
            r22 = 8
            r10 = 0
            int r23 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0187
            long r6 = r2 & r20
            int r23 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x0058
            java.lang.String r6 = r0.getOrderId()
            java.lang.String r7 = r0.getPayMethodIconUrl()
            java.lang.String r23 = r0.getTxnDate()
            android.text.Spannable r24 = r0.getPayModeDescription()
            java.lang.String r25 = r0.getPayModeDetailLabel()
            android.text.Spannable r26 = r0.getReceivedAmount()
            java.lang.String r27 = r0.getPayMode()
            android.text.Spannable r28 = r0.getTxnAmount()
            r41 = r7
            r7 = r6
            r6 = r27
            r27 = r26
            r26 = r25
            r25 = r24
            r24 = r23
            r23 = r41
            goto L_0x0066
        L_0x0058:
            r6 = 0
            r7 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x0066:
            android.view.View r29 = r42.getRoot()
            android.content.Context r11 = r29.getContext()
            java.lang.String r11 = com.business.merchant_payments.common.utility.AppUtility.getPayModeLocalised(r11, r6)
            r6 = r11
            r11 = r7
            goto L_0x0083
        L_0x0075:
            r6 = 0
            r11 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x0083:
            long r30 = r2 & r18
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00aa
            if (r0 == 0) goto L_0x008e
            androidx.databinding.ObservableBoolean r8 = r0.isPayModeVisible
            goto L_0x008f
        L_0x008e:
            r8 = 0
        L_0x008f:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0099
            boolean r8 = r8.get()
            goto L_0x009a
        L_0x0099:
            r8 = 0
        L_0x009a:
            if (r7 == 0) goto L_0x00a5
            if (r8 == 0) goto L_0x00a1
            r32 = 2048(0x800, double:1.0118E-320)
            goto L_0x00a3
        L_0x00a1:
            r32 = 1024(0x400, double:5.06E-321)
        L_0x00a3:
            long r2 = r2 | r32
        L_0x00a5:
            if (r8 != 0) goto L_0x00aa
            r7 = 8
            goto L_0x00ab
        L_0x00aa:
            r7 = 0
        L_0x00ab:
            long r8 = r2 & r16
            int r29 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r29 == 0) goto L_0x00d3
            if (r0 == 0) goto L_0x00b6
            androidx.databinding.ObservableBoolean r8 = r0.isPayDetailsVisible
            goto L_0x00b7
        L_0x00b6:
            r8 = 0
        L_0x00b7:
            r9 = 1
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x00c2
            boolean r8 = r8.get()
            goto L_0x00c3
        L_0x00c2:
            r8 = 0
        L_0x00c3:
            if (r29 == 0) goto L_0x00ce
            if (r8 == 0) goto L_0x00ca
            r32 = 8192(0x2000, double:4.0474E-320)
            goto L_0x00cc
        L_0x00ca:
            r32 = 4096(0x1000, double:2.0237E-320)
        L_0x00cc:
            long r2 = r2 | r32
        L_0x00ce:
            if (r8 != 0) goto L_0x00d3
            r8 = 8
            goto L_0x00d4
        L_0x00d3:
            r8 = 0
        L_0x00d4:
            long r32 = r2 & r12
            int r9 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00ed
            if (r0 == 0) goto L_0x00df
            androidx.databinding.i<java.lang.String> r9 = r0.txnDetailsString
            goto L_0x00e0
        L_0x00df:
            r9 = 0
        L_0x00e0:
            r10 = 2
            r1.updateRegistration((int) r10, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x00ed
            java.lang.Object r9 = r9.get()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00ee
        L_0x00ed:
            r9 = 0
        L_0x00ee:
            long r32 = r2 & r14
            int r10 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0107
            if (r0 == 0) goto L_0x00f9
            androidx.databinding.i<java.lang.String> r10 = r0.payModeDetailText
            goto L_0x00fa
        L_0x00f9:
            r10 = 0
        L_0x00fa:
            r12 = 3
            r1.updateRegistration((int) r12, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0107
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0108
        L_0x0107:
            r10 = 0
        L_0x0108:
            r12 = 208(0xd0, double:1.03E-321)
            long r34 = r2 & r12
            int r12 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0132
            if (r0 == 0) goto L_0x0115
            androidx.databinding.ObservableBoolean r13 = r0.isDirectSettleViaBankVisible
            goto L_0x0116
        L_0x0115:
            r13 = 0
        L_0x0116:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0121
            boolean r13 = r13.get()
            goto L_0x0122
        L_0x0121:
            r13 = 0
        L_0x0122:
            if (r12 == 0) goto L_0x012c
            if (r13 == 0) goto L_0x0129
            r14 = 512(0x200, double:2.53E-321)
            goto L_0x012b
        L_0x0129:
            r14 = 256(0x100, double:1.265E-321)
        L_0x012b:
            long r2 = r2 | r14
        L_0x012c:
            if (r13 == 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r12 = 8
            goto L_0x0133
        L_0x0132:
            r12 = 0
        L_0x0133:
            r13 = 224(0xe0, double:1.107E-321)
            long r36 = r2 & r13
            int r13 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0171
            if (r0 == 0) goto L_0x0140
            androidx.databinding.ObservableBoolean r0 = r0.isPaymentDescriptionVisible
            goto L_0x0141
        L_0x0140:
            r0 = 0
        L_0x0141:
            r14 = 5
            r1.updateRegistration((int) r14, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x014c
            boolean r0 = r0.get()
            goto L_0x014d
        L_0x014c:
            r0 = 0
        L_0x014d:
            if (r13 == 0) goto L_0x0158
            if (r0 == 0) goto L_0x0155
            r13 = 32768(0x8000, double:1.61895E-319)
            goto L_0x0157
        L_0x0155:
            r13 = 16384(0x4000, double:8.0948E-320)
        L_0x0157:
            long r2 = r2 | r13
        L_0x0158:
            if (r0 == 0) goto L_0x015b
            goto L_0x0171
        L_0x015b:
            r13 = r7
            r14 = r8
            r38 = r9
            r15 = r10
            r40 = r12
            r0 = r23
            r8 = r24
            r12 = r25
            r7 = r26
            r9 = r27
            r10 = r28
            r39 = 8
            goto L_0x0198
        L_0x0171:
            r13 = r7
            r14 = r8
            r38 = r9
            r15 = r10
            r40 = r12
            r0 = r23
            r8 = r24
            r12 = r25
            r7 = r26
            r9 = r27
            r10 = r28
            r39 = 0
            goto L_0x0198
        L_0x0187:
            r0 = 0
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
            r38 = 0
            r39 = 0
            r40 = 0
        L_0x0198:
            long r20 = r2 & r20
            int r22 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x01c6
            android.widget.ImageView r4 = r1.ivPaymode
            com.business.merchant_payments.common.utility.DataBindingUtility.loadPayMethodImage(r4, r0)
            android.widget.TextView r0 = r1.textView18
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.textView19
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.TextView r0 = r1.textView27
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.widget.TextView r0 = r1.textView30
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.textView8
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            android.widget.TextView r0 = r1.tvOrderIdText
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
            android.widget.TextView r0 = r1.tvPaymentDescriptionText
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x01c6:
            long r4 = r2 & r18
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01dd
            android.widget.ImageView r0 = r1.ivPaymode
            r0.setVisibility(r13)
            android.widget.TextView r0 = r1.textView17
            r0.setVisibility(r13)
            android.widget.TextView r0 = r1.textView18
            r0.setVisibility(r13)
        L_0x01dd:
            long r4 = r2 & r16
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01ed
            android.widget.TextView r0 = r1.textView19
            r0.setVisibility(r14)
            android.widget.TextView r0 = r1.textView20
            r0.setVisibility(r14)
        L_0x01ed:
            r4 = 200(0xc8, double:9.9E-322)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01f9
            android.widget.TextView r0 = r1.textView20
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x01f9:
            r4 = 196(0xc4, double:9.7E-322)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0207
            android.widget.TextView r0 = r1.textView21
            r9 = r38
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0207:
            r4 = 224(0xe0, double:1.107E-321)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x021a
            android.widget.TextView r0 = r1.textView25
            r4 = r39
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tvPaymentDescriptionText
            r0.setVisibility(r4)
        L_0x021a:
            r4 = 208(0xd0, double:1.03E-321)
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x022d
            android.widget.TextView r0 = r1.tvBank
            r12 = r40
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.tvDirectSettleVia
            r0.setVisibility(r12)
        L_0x022d:
            return
        L_0x022e:
            r0 = move-exception
            monitor-exit(r42)     // Catch:{ all -> 0x022e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpReversalDetailSubViewBindingImpl.executeBindings():void");
    }
}
