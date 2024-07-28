package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;

public class MpRefundDetailsViewNewBindingImpl extends MpRefundDetailsViewNewBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView1;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(28);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_refund_detail_subview"}, new int[]{13}, new int[]{R.layout.mp_refund_detail_subview});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_header, 14);
        sViewsWithIds.put(R.id.rl_amnt_status, 15);
        sViewsWithIds.put(R.id.iv_close, 16);
        sViewsWithIds.put(R.id.tv_header_lbl, 17);
        sViewsWithIds.put(R.id.rl_print_reciept, 18);
        sViewsWithIds.put(R.id.iv_print_reciept, 19);
        sViewsWithIds.put(R.id.tv_print_reciept, 20);
        sViewsWithIds.put(R.id.rl_need_help, 21);
        sViewsWithIds.put(R.id.iv_need_help, 22);
        sViewsWithIds.put(R.id.tv_need_help, 23);
        sViewsWithIds.put(R.id.refund_tv_transfered_to_bnk_txt, 24);
        sViewsWithIds.put(R.id.refund_tv_transfered_on_date, 25);
        sViewsWithIds.put(R.id.net_top_sep, 26);
        sViewsWithIds.put(R.id.net_total_txt, 27);
    }

    public MpRefundDetailsViewNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 28, sIncludes, sViewsWithIds));
    }

    public MpRefundDetailsViewNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[0], objArr[12], objArr[16], objArr[22], objArr[19], objArr[26], objArr[11], objArr[27], objArr[13], objArr[7], objArr[8], objArr[10], objArr[9], objArr[25], objArr[6], objArr[24], objArr[15], objArr[14], objArr[21], objArr[18], objArr[5], objArr[2], objArr[3], objArr[17], objArr[23], objArr[20], objArr[4]);
        this.mDirtyFlags = -1;
        this.coordinatorLayout.setTag((Object) null);
        this.dotProgressBar.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[1];
        this.mboundView1 = relativeLayout;
        relativeLayout.setTag((Object) null);
        this.netTotalAmnt.setTag((Object) null);
        this.refundTvCommission.setTag((Object) null);
        this.refundTvCommissionAmnt.setTag((Object) null);
        this.refundTvGstAmntTxt.setTag((Object) null);
        this.refundTvGstTxt.setTag((Object) null);
        this.refundTvTransferedToBnkAmnt.setTag((Object) null);
        this.totalPaymentCollectedContainer.setTag((Object) null);
        this.tvAmnt.setTag((Object) null);
        this.tvDateTime.setTag((Object) null);
        this.tvTxnId.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.refundDetailSubview.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.refundDetailSubview.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r6.refundDetailSubview
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpRefundDetailsViewNewBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.refundDetailsViewModel != i2) {
            return false;
        }
        setRefundDetailsViewModel((RefundDetailsViewModel) obj);
        return true;
    }

    public void setRefundDetailsViewModel(RefundDetailsViewModel refundDetailsViewModel) {
        updateRegistration(0, (h) refundDetailsViewModel);
        this.mRefundDetailsViewModel = refundDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.refundDetailsViewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.refundDetailSubview.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeRefundDetailsViewModel((RefundDetailsViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeRefundDetailsViewModelDottedProgressBarVisibility((ObservableBoolean) obj, i3);
        }
        if (i2 == 2) {
            return onChangeRefundDetailSubview((MpRefundDetailSubviewBinding) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeRefundDetailsViewModelPaymentDetailLoading((ObservableBoolean) obj, i3);
    }

    private boolean onChangeRefundDetailsViewModel(RefundDetailsViewModel refundDetailsViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeRefundDetailsViewModelDottedProgressBarVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeRefundDetailSubview(MpRefundDetailSubviewBinding mpRefundDetailSubviewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeRefundDetailsViewModelPaymentDetailLoading(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r32 = this;
            r1 = r32
            monitor-enter(r32)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0122 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0122 }
            monitor-exit(r32)     // Catch:{ all -> 0x0122 }
            com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel r0 = r1.mRefundDetailsViewModel
            r6 = 27
            long r8 = r2 & r6
            r10 = 17
            r12 = 128(0x80, double:6.32E-322)
            int r16 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0089
            long r8 = r2 & r10
            int r17 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0049
            if (r0 == 0) goto L_0x0049
            android.text.Spannable r8 = r0.getGstAmount()
            java.lang.String r9 = r0.getRefundAmount()
            java.lang.String r17 = r0.getCommissionText()
            android.text.Spannable r18 = r0.getCommissionAmount()
            java.lang.String r19 = r0.getGstText()
            android.text.Spannable r20 = r0.getSettledAmount()
            int r21 = r0.isUnlimitedMerchant()
            java.lang.String r22 = r0.getRefundDate()
            java.lang.String r23 = r0.getTxnId()
            android.text.Spannable r24 = r0.getReceivedAmount()
            goto L_0x005b
        L_0x0049:
            r8 = 0
            r9 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
        L_0x005b:
            if (r0 == 0) goto L_0x0060
            androidx.databinding.ObservableBoolean r14 = r0.paymentDetailLoading
            goto L_0x0061
        L_0x0060:
            r14 = 0
        L_0x0061:
            r15 = 3
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x006c
            boolean r14 = r14.get()
            goto L_0x006d
        L_0x006c:
            r14 = 0
        L_0x006d:
            if (r16 == 0) goto L_0x0076
            if (r14 == 0) goto L_0x0075
            r15 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r15
            goto L_0x0076
        L_0x0075:
            long r2 = r2 | r12
        L_0x0076:
            r15 = r9
            r25 = r17
            r26 = r18
            r27 = r19
            r28 = r20
            r29 = r22
            r30 = r23
            r31 = r24
            r9 = r8
            r8 = r21
            goto L_0x009b
        L_0x0089:
            r8 = 0
            r9 = 0
            r14 = 0
            r15 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
        L_0x009b:
            long r12 = r12 & r2
            r10 = 1
            int r11 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00a6
            androidx.databinding.ObservableBoolean r0 = r0.dottedProgressBarVisibility
            goto L_0x00a7
        L_0x00a6:
            r0 = 0
        L_0x00a7:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x00b1
            boolean r0 = r0.get()
            goto L_0x00b2
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            long r11 = r2 & r6
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00ca
            if (r14 == 0) goto L_0x00bb
            r0 = 1
        L_0x00bb:
            if (r13 == 0) goto L_0x00c5
            if (r0 == 0) goto L_0x00c2
            r10 = 64
            goto L_0x00c4
        L_0x00c2:
            r10 = 32
        L_0x00c4:
            long r2 = r2 | r10
        L_0x00c5:
            if (r0 != 0) goto L_0x00ca
            r14 = 8
            goto L_0x00cb
        L_0x00ca:
            r14 = 0
        L_0x00cb:
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d5
            com.business.merchant_payments.widget.DotProgressBar r0 = r1.dotProgressBar
            r0.setVisibility(r14)
        L_0x00d5:
            r6 = 17
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011c
            android.widget.TextView r0 = r1.netTotalAmnt
            r2 = r28
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.refundTvCommission
            r2 = r25
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.refundTvCommissionAmnt
            r2 = r26
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.refundTvGstAmntTxt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.refundTvGstTxt
            r2 = r27
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.refundTvTransferedToBnkAmnt
            r2 = r31
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.LinearLayout r0 = r1.totalPaymentCollectedContainer
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.tvAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.tvDateTime
            r2 = r29
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
            android.widget.TextView r0 = r1.tvTxnId
            r2 = r30
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x011c:
            com.business.merchant_payments.databinding.MpRefundDetailSubviewBinding r0 = r1.refundDetailSubview
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x0122:
            r0 = move-exception
            monitor-exit(r32)     // Catch:{ all -> 0x0122 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpRefundDetailsViewNewBindingImpl.executeBindings():void");
    }
}
