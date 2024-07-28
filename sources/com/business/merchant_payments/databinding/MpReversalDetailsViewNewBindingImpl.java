package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel;

public class MpReversalDetailsViewNewBindingImpl extends MpReversalDetailsViewNewBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView1;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(24);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_reversal_detail_sub_view"}, new int[]{12}, new int[]{R.layout.mp_reversal_detail_sub_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_header, 13);
        sViewsWithIds.put(R.id.rl_amnt_status, 14);
        sViewsWithIds.put(R.id.iv_close, 15);
        sViewsWithIds.put(R.id.rl_need_help, 16);
        sViewsWithIds.put(R.id.iv_need_help, 17);
        sViewsWithIds.put(R.id.tv_need_help, 18);
        sViewsWithIds.put(R.id.total_payment_collected_container, 19);
        sViewsWithIds.put(R.id.refund_tv_commission, 20);
        sViewsWithIds.put(R.id.refund_tv_gst_txt, 21);
        sViewsWithIds.put(R.id.net_top_sep, 22);
        sViewsWithIds.put(R.id.net_total_txt, 23);
    }

    public MpReversalDetailsViewNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 24, sIncludes, sViewsWithIds));
    }

    public MpReversalDetailsViewNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[0], objArr[12], objArr[11], objArr[15], objArr[17], objArr[22], objArr[10], objArr[23], objArr[20], objArr[8], objArr[9], objArr[21], objArr[7], objArr[6], objArr[14], objArr[13], objArr[16], objArr[19], objArr[3], objArr[4], objArr[2], objArr[18], objArr[5]);
        this.mDirtyFlags = -1;
        this.coordinatorLayout.setTag((Object) null);
        this.dotProgressBar.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[1];
        this.mboundView1 = relativeLayout;
        relativeLayout.setTag((Object) null);
        this.netTotalAmnt.setTag((Object) null);
        this.refundTvCommissionAmnt.setTag((Object) null);
        this.refundTvGstAmntTxt.setTag((Object) null);
        this.refundTvTransferedToBnkAmnt.setTag((Object) null);
        this.refundTvTransferedToBnkTxt.setTag((Object) null);
        this.tvAmnt.setTag((Object) null);
        this.tvDateTime.setTag((Object) null);
        this.tvHeaderLbl.setTag((Object) null);
        this.tvTxnId.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.detailsContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.detailsContainer.hasPendingBindings() == false) goto L_0x0016;
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
            com.business.merchant_payments.databinding.MpReversalDetailSubViewBinding r0 = r6.detailsContainer
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpReversalDetailsViewNewBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.refundDetailsViewModel != i2) {
            return false;
        }
        setRefundDetailsViewModel((ReversalDetailsViewModel) obj);
        return true;
    }

    public void setRefundDetailsViewModel(ReversalDetailsViewModel reversalDetailsViewModel) {
        updateRegistration(1, (h) reversalDetailsViewModel);
        this.mRefundDetailsViewModel = reversalDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.refundDetailsViewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.detailsContainer.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeRefundDetailsViewModelPaymentDetailLoading((ObservableBoolean) obj, i3);
        }
        if (i2 == 1) {
            return onChangeRefundDetailsViewModel((ReversalDetailsViewModel) obj, i3);
        }
        if (i2 == 2) {
            return onChangeDetailsContainer((MpReversalDetailSubViewBinding) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeRefundDetailsViewModelTxnType((i) obj, i3);
    }

    private boolean onChangeRefundDetailsViewModelPaymentDetailLoading(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeRefundDetailsViewModel(ReversalDetailsViewModel reversalDetailsViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDetailsContainer(MpReversalDetailSubViewBinding mpReversalDetailSubViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeRefundDetailsViewModelTxnType(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00fb }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00fb }
            monitor-exit(r26)     // Catch:{ all -> 0x00fb }
            com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel r0 = r1.mRefundDetailsViewModel
            r6 = 27
            long r6 = r6 & r2
            r8 = 26
            r10 = 18
            r12 = 19
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a4
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x0025
            androidx.databinding.ObservableBoolean r6 = r0.paymentDetailLoading
            goto L_0x0026
        L_0x0025:
            r6 = 0
        L_0x0026:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0030
            boolean r6 = r6.get()
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r16 == 0) goto L_0x003c
            if (r6 == 0) goto L_0x0038
            r16 = 64
            goto L_0x003a
        L_0x0038:
            r16 = 32
        L_0x003a:
            long r2 = r2 | r16
        L_0x003c:
            if (r6 != 0) goto L_0x0042
            r6 = 8
            r14 = 8
        L_0x0042:
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0067
            if (r0 == 0) goto L_0x0067
            android.text.Spannable r6 = r0.getGstAmount()
            android.text.Spannable r7 = r0.getSettledAmount()
            java.lang.String r16 = r0.getRefundAmount()
            java.lang.String r17 = r0.getRefundDate()
            android.text.Spannable r18 = r0.getCommissionAmount()
            java.lang.String r19 = r0.getTxnId()
            android.text.Spannable r20 = r0.getReceivedAmount()
            goto L_0x0073
        L_0x0067:
            r6 = 0
            r7 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x0073:
            long r21 = r2 & r8
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0099
            if (r0 == 0) goto L_0x007e
            androidx.databinding.i<java.lang.String> r0 = r0.txnType
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            r15 = 3
            r1.updateRegistration((int) r15, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r0.get()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            r25 = r15
            r8 = r16
            r9 = r17
            r0 = r18
            r24 = r19
            r15 = r20
            goto L_0x00ae
        L_0x0099:
            r8 = r16
            r9 = r17
            r0 = r18
            r24 = r19
            r15 = r20
            goto L_0x00ac
        L_0x00a4:
            r0 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r15 = 0
            r24 = 0
        L_0x00ac:
            r25 = 0
        L_0x00ae:
            long r12 = r12 & r2
            int r18 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x00b8
            com.business.merchant_payments.widget.DotProgressBar r12 = r1.dotProgressBar
            r12.setVisibility(r14)
        L_0x00b8:
            long r10 = r10 & r2
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00e2
            android.widget.TextView r10 = r1.netTotalAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r7)
            android.widget.TextView r7 = r1.refundTvCommissionAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.refundTvGstAmntTxt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.TextView r0 = r1.refundTvTransferedToBnkAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.tvAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            android.widget.TextView r0 = r1.tvDateTime
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.tvTxnId
            r6 = r24
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00e2:
            r6 = 26
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f5
            android.widget.TextView r0 = r1.refundTvTransferedToBnkTxt
            r15 = r25
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.tvHeaderLbl
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x00f5:
            com.business.merchant_payments.databinding.MpReversalDetailSubViewBinding r0 = r1.detailsContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x00fb:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x00fb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpReversalDetailsViewNewBindingImpl.executeBindings():void");
    }
}
