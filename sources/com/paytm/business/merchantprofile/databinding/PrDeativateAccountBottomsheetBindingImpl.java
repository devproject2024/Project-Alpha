package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public class PrDeativateAccountBottomsheetBindingImpl extends PrDeativateAccountBottomsheetBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final AppCompatImageView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.pr_barrier, 6);
        sViewsWithIds.put(R.id.close_icon, 7);
    }

    public PrDeativateAccountBottomsheetBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    public PrDeativateAccountBottomsheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[7], objArr[1], objArr[3], objArr[5], objArr[0], objArr[6], objArr[4]);
        this.mDirtyFlags = -1;
        this.icon.setTag((Object) null);
        this.iconFailed.setTag((Object) null);
        AppCompatImageView appCompatImageView = objArr[2];
        this.mboundView2 = appCompatImageView;
        appCompatImageView.setTag((Object) null);
        this.message.setTag((Object) null);
        this.oarent.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
    }

    public void setData(MerchantAccountState merchantAccountState) {
        this.mData = merchantAccountState;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeDataUiState((y) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeDataAccountState((y) obj, i3);
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

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x009d }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x009d }
            monitor-exit(r17)     // Catch:{ all -> 0x009d }
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r0 = r1.mData
            r6 = 27
            long r8 = r2 & r6
            r10 = 26
            r12 = 0
            r13 = 1
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x006f
            if (r0 == 0) goto L_0x0024
            androidx.lifecycle.y r8 = r0.getUiState()
            androidx.lifecycle.y r0 = r0.getAccountState()
            goto L_0x0026
        L_0x0024:
            r0 = r14
            r8 = r0
        L_0x0026:
            r1.updateLiveDataRegistration(r12, r8)
            r1.updateLiveDataRegistration(r13, r0)
            if (r8 == 0) goto L_0x0035
            java.lang.Object r8 = r8.getValue()
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState r8 = (com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState) r8
            goto L_0x0036
        L_0x0035:
            r8 = r14
        L_0x0036:
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r0.getValue()
            com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState r0 = (com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState) r0
            goto L_0x0040
        L_0x003f:
            r0 = r14
        L_0x0040:
            long r15 = r2 & r10
            int r9 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0071
            boolean r12 = r0 instanceof com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress
            boolean r14 = r0 instanceof com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed
            if (r9 == 0) goto L_0x0054
            if (r12 == 0) goto L_0x0051
            r15 = 64
            goto L_0x0053
        L_0x0051:
            r15 = 32
        L_0x0053:
            long r2 = r2 | r15
        L_0x0054:
            if (r12 == 0) goto L_0x005f
            android.widget.TextView r9 = r1.title
            android.content.res.Resources r9 = r9.getResources()
            int r15 = com.paytm.business.merchantprofile.R.string.pr_application_status
            goto L_0x0067
        L_0x005f:
            android.widget.TextView r9 = r1.title
            android.content.res.Resources r9 = r9.getResources()
            int r15 = com.paytm.business.merchantprofile.R.string.pr_account_deactivated_ap
        L_0x0067:
            java.lang.String r9 = r9.getString(r15)
            r15 = r12 ^ 1
            r14 = r14 ^ r13
            goto L_0x0074
        L_0x006f:
            r0 = r14
            r8 = r0
        L_0x0071:
            r9 = r14
            r14 = 0
            r15 = 0
        L_0x0074:
            long r10 = r10 & r2
            int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0092
            androidx.appcompat.widget.AppCompatImageView r10 = r1.icon
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r10, r15)
            androidx.appcompat.widget.AppCompatImageView r10 = r1.iconFailed
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r10, r12)
            androidx.appcompat.widget.AppCompatImageView r10 = r1.mboundView2
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r10, r15)
            androidx.constraintlayout.widget.ConstraintLayout r10 = r1.oarent
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.bindVisibility(r10, r14)
            android.widget.TextView r10 = r1.title
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r9)
        L_0x0092:
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x009c
            android.widget.TextView r2 = r1.message
            com.paytm.business.merchantprofile.common.utility.DataBindingUtility.deactivatedAccountMessage(r2, r0, r8, r13, r13)
        L_0x009c:
            return
        L_0x009d:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x009d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrDeativateAccountBottomsheetBindingImpl.executeBindings():void");
    }
}
