package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public class PrPaymentsInActiveMerchantBindingImpl extends PrPaymentsInActiveMerchantBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final AppCompatImageView mboundView2;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(9);
        sIncludes = bVar;
        bVar.a(0, new String[]{"pr_past_payment"}, new int[]{7}, new int[]{R.layout.pr_past_payment});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.pr_barrier, 8);
    }

    public PrPaymentsInActiveMerchantBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrPaymentsInActiveMerchantBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 3, objArr[3], objArr[6], objArr[1], objArr[0], objArr[5], objArr[7], objArr[8], objArr[4]);
        this.mDirtyFlags = -1;
        this.animationView.setTag((Object) null);
        this.contactUsOn.setTag((Object) null);
        this.icon.setTag((Object) null);
        this.inActiveMerchant.setTag((Object) null);
        AppCompatImageView appCompatImageView = objArr[2];
        this.mboundView2 = appCompatImageView;
        appCompatImageView.setTag((Object) null);
        this.message.setTag((Object) null);
        this.title.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
        }
        this.pastPayment.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.pastPayment.hasPendingBindings() == false) goto L_0x0016;
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
            com.paytm.business.merchantprofile.databinding.PrPastPaymentBinding r0 = r6.pastPayment
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrPaymentsInActiveMerchantBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.listener == i2) {
            setListener((InactiveMerchantListener) obj);
        } else if (BR.data != i2) {
            return false;
        } else {
            setData((MerchantAccountState) obj);
        }
        return true;
    }

    public void setListener(InactiveMerchantListener inactiveMerchantListener) {
        this.mListener = inactiveMerchantListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    public void setData(MerchantAccountState merchantAccountState) {
        this.mData = merchantAccountState;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.pastPayment.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeDataUiState((y) obj, i3);
        }
        if (i2 == 1) {
            return onChangeDataAccountState((y) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return onChangePastPayment((PrPastPaymentBinding) obj, i3);
    }

    private boolean onChangeDataUiState(y<MerchantAccountActivationUIState> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDataAccountState(y<AccountActivationState> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangePastPayment(PrPastPaymentBinding prPastPaymentBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState] */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r9v1, types: [com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState] */
    /* JADX WARNING: type inference failed for: r8v7, types: [com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState] */
    /* JADX WARNING: type inference failed for: r8v14, types: [com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState] */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00f9 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00f9 }
            monitor-exit(r22)     // Catch:{ all -> 0x00f9 }
            com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener r0 = r1.mListener
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r12 = r1.mData
            r6 = 59
            long r8 = r2 & r6
            r10 = 49
            r13 = 51
            r15 = 64
            r17 = 0
            r6 = 1
            r7 = 0
            int r18 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0074
            if (r12 == 0) goto L_0x002b
            androidx.lifecycle.y r8 = r12.getUiState()
            androidx.lifecycle.y r9 = r12.getAccountState()
            goto L_0x002e
        L_0x002b:
            r8 = r17
            r9 = r8
        L_0x002e:
            r1.updateLiveDataRegistration(r7, r8)
            r1.updateLiveDataRegistration(r6, r9)
            if (r8 == 0) goto L_0x003d
            java.lang.Object r8 = r8.getValue()
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState r8 = (com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState) r8
            goto L_0x003f
        L_0x003d:
            r8 = r17
        L_0x003f:
            if (r9 == 0) goto L_0x0049
            java.lang.Object r9 = r9.getValue()
            r17 = r9
            com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState r17 = (com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState) r17
        L_0x0049:
            long r18 = r2 & r13
            int r9 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x006e
            boolean r6 = r8 instanceof com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress
            if (r9 == 0) goto L_0x005b
            if (r6 == 0) goto L_0x005a
            r19 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r19
            goto L_0x005b
        L_0x005a:
            long r2 = r2 | r15
        L_0x005b:
            long r19 = r2 & r10
            int r9 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            r9 = r6 ^ 1
            r21 = r17
            r17 = r8
            r8 = r9
            r9 = r21
            goto L_0x0078
        L_0x006b:
            r9 = r17
            goto L_0x0071
        L_0x006e:
            r9 = r17
            r6 = 0
        L_0x0071:
            r17 = r8
            goto L_0x0077
        L_0x0074:
            r9 = r17
            r6 = 0
        L_0x0077:
            r8 = 0
        L_0x0078:
            long r15 = r15 & r2
            int r19 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0080
            boolean r15 = r9 instanceof com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress
            goto L_0x0081
        L_0x0080:
            r15 = 0
        L_0x0081:
            long r13 = r13 & r2
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x008a
            if (r6 == 0) goto L_0x008b
            r15 = 1
            goto L_0x008b
        L_0x008a:
            r15 = 0
        L_0x008b:
            long r10 = r10 & r2
            int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a4
            com.airbnb.lottie.LottieAnimationView r10 = r1.animationView
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.dottetLoaderVisibility(r10, r6)
            android.widget.TextView r6 = r1.contactUsOn
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r6, r8)
            androidx.appcompat.widget.AppCompatImageView r6 = r1.icon
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r6, r8)
            androidx.appcompat.widget.AppCompatImageView r6 = r1.mboundView2
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r6, r8)
        L_0x00a4:
            r10 = 59
            long r10 = r10 & r2
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00c3
            android.widget.TextView r6 = r1.contactUsOn
            r8 = 1
            r11 = 0
            r13 = 1
            r14 = 0
            r7 = r8
            r8 = r9
            r10 = r9
            r9 = r17
            r4 = r10
            r10 = r0
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.deactivatedAccountCTA(r6, r7, r8, r9, r10, r11)
            androidx.constraintlayout.widget.ConstraintLayout r5 = r1.inActiveMerchant
            r8 = r17
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.inactivateMerchantState(r5, r4, r8, r0)
            goto L_0x00c8
        L_0x00c3:
            r4 = r9
            r8 = r17
            r13 = 1
            r14 = 0
        L_0x00c8:
            if (r16 == 0) goto L_0x00d9
            android.widget.TextView r5 = r1.message
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.deactivatedAccountMessage(r5, r4, r8, r13, r14)
            android.widget.TextView r5 = r1.title
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.textBold(r5, r15)
            android.widget.TextView r5 = r1.title
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.deactivatedAccountTitle(r5, r4, r8, r13)
        L_0x00d9:
            r4 = 40
            long r4 = r4 & r2
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00e7
            com.paytm.business.merchantprofile.databinding.PrPastPaymentBinding r4 = r1.pastPayment
            r4.setListener(r0)
        L_0x00e7:
            r4 = 48
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00f3
            com.paytm.business.merchantprofile.databinding.PrPastPaymentBinding r0 = r1.pastPayment
            r0.setData(r12)
        L_0x00f3:
            com.paytm.business.merchantprofile.databinding.PrPastPaymentBinding r0 = r1.pastPayment
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x00f9:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00f9 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrPaymentsInActiveMerchantBindingImpl.executeBindings():void");
    }
}
