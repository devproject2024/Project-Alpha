package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel;

public class MpActivityPaymentListBindingImpl extends MpActivityPaymentListBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(14);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_qr_payment_list_header"}, new int[]{6}, new int[]{R.layout.mp_qr_payment_list_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.back, 7);
        sViewsWithIds.put(R.id.download_statement_label, 8);
        sViewsWithIds.put(R.id.error_icon, 9);
        sViewsWithIds.put(R.id.error_header, 10);
        sViewsWithIds.put(R.id.error_summary, 11);
        sViewsWithIds.put(R.id.error_retry_btn, 12);
        sViewsWithIds.put(R.id.coordinatorLayout, 13);
    }

    public MpActivityPaymentListBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 14, sIncludes, sViewsWithIds));
    }

    public MpActivityPaymentListBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[4], objArr[7], objArr[13], objArr[8], objArr[10], objArr[9], objArr[5], objArr[12], objArr[11], objArr[1], objArr[6], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.animationView.setTag((Object) null);
        this.errorLayout.setTag((Object) null);
        this.header.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.paymentsRv.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.multipleqrHeaderLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.multipleqrHeaderLayout.hasPendingBindings() == false) goto L_0x0016;
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
            com.business.merchant_payments.databinding.MpQrPaymentListHeaderBinding r0 = r6.multipleqrHeaderLayout
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityPaymentListBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.model != i2) {
            return false;
        }
        setModel((PaymentsListViewModel) obj);
        return true;
    }

    public void setModel(PaymentsListViewModel paymentsListViewModel) {
        this.mModel = paymentsListViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.multipleqrHeaderLayout.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeModelMProgressState((ObservableBoolean) obj, i3);
        }
        if (i2 == 1) {
            return onChangeMultipleqrHeaderLayout((MpQrPaymentListHeaderBinding) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangeModelMErrorState((ObservableBoolean) obj, i3);
    }

    private boolean onChangeModelMProgressState(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMultipleqrHeaderLayout(MpQrPaymentListHeaderBinding mpQrPaymentListHeaderBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeModelMErrorState(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ec }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ec }
            monitor-exit(r20)     // Catch:{ all -> 0x00ec }
            com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel r0 = r1.mModel
            r6 = 29
            long r6 = r6 & r2
            r8 = 24
            r10 = 28
            r12 = 25
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00b4
            long r6 = r2 & r12
            r16 = 0
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0056
            if (r0 == 0) goto L_0x0029
            androidx.databinding.ObservableBoolean r6 = r0.getMProgressState()
            goto L_0x002b
        L_0x0029:
            r6 = r16
        L_0x002b:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0035
            boolean r6 = r6.get()
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            if (r17 == 0) goto L_0x0049
            if (r6 == 0) goto L_0x0041
            r17 = 64
            long r2 = r2 | r17
            r17 = 16384(0x4000, double:8.0948E-320)
            goto L_0x0047
        L_0x0041:
            r17 = 32
            long r2 = r2 | r17
            r17 = 8192(0x2000, double:4.0474E-320)
        L_0x0047:
            long r2 = r2 | r17
        L_0x0049:
            if (r6 == 0) goto L_0x004d
            r7 = 0
            goto L_0x004f
        L_0x004d:
            r7 = 8
        L_0x004f:
            if (r6 == 0) goto L_0x0054
            r6 = 8
            goto L_0x0058
        L_0x0054:
            r6 = 0
            goto L_0x0058
        L_0x0056:
            r6 = 0
            r7 = 0
        L_0x0058:
            long r17 = r2 & r10
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0082
            if (r0 == 0) goto L_0x0064
            androidx.databinding.ObservableBoolean r16 = r0.getMErrorState()
        L_0x0064:
            r14 = r16
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0071
            boolean r15 = r14.get()
            goto L_0x0072
        L_0x0071:
            r15 = 0
        L_0x0072:
            if (r19 == 0) goto L_0x007d
            if (r15 == 0) goto L_0x0079
            r18 = 1024(0x400, double:5.06E-321)
            goto L_0x007b
        L_0x0079:
            r18 = 512(0x200, double:2.53E-321)
        L_0x007b:
            long r2 = r2 | r18
        L_0x007d:
            if (r15 != 0) goto L_0x0082
            r15 = 8
            goto L_0x0083
        L_0x0082:
            r15 = 0
        L_0x0083:
            long r18 = r2 & r8
            int r14 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x0090
            boolean r0 = r0.isFromMultipleQR()
            goto L_0x0091
        L_0x0090:
            r0 = 0
        L_0x0091:
            if (r14 == 0) goto L_0x00a4
            if (r0 == 0) goto L_0x009c
            r18 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r18
            r18 = 4096(0x1000, double:2.0237E-320)
            goto L_0x00a2
        L_0x009c:
            r18 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r18
            r18 = 2048(0x800, double:1.0118E-320)
        L_0x00a2:
            long r2 = r2 | r18
        L_0x00a4:
            if (r0 == 0) goto L_0x00a8
            r14 = 0
            goto L_0x00aa
        L_0x00a8:
            r14 = 8
        L_0x00aa:
            if (r0 == 0) goto L_0x00af
            r0 = 8
            goto L_0x00b9
        L_0x00af:
            r0 = 0
            goto L_0x00b9
        L_0x00b1:
            r0 = 0
            r14 = 0
            goto L_0x00b9
        L_0x00b4:
            r0 = 0
            r6 = 0
            r7 = 0
            r14 = 0
            r15 = 0
        L_0x00b9:
            long r12 = r12 & r2
            int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00c8
            com.airbnb.lottie.LottieAnimationView r12 = r1.animationView
            r12.setVisibility(r7)
            androidx.recyclerview.widget.RecyclerView r7 = r1.paymentsRv
            r7.setVisibility(r6)
        L_0x00c8:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00d3
            androidx.constraintlayout.widget.ConstraintLayout r6 = r1.errorLayout
            r6.setVisibility(r15)
        L_0x00d3:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00e6
            com.business.merchant_payments.databinding.MpQrPaymentListHeaderBinding r2 = r1.multipleqrHeaderLayout
            android.view.View r2 = r2.getRoot()
            r2.setVisibility(r14)
            android.widget.TextView r2 = r1.title
            r2.setVisibility(r0)
        L_0x00e6:
            com.business.merchant_payments.databinding.MpQrPaymentListHeaderBinding r0 = r1.multipleqrHeaderLayout
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00ec }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpActivityPaymentListBindingImpl.executeBindings():void");
    }
}
