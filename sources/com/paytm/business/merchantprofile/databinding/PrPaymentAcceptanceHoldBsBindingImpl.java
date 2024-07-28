package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.utility.DataBindingUtility;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public class PrPaymentAcceptanceHoldBsBindingImpl extends PrPaymentAcceptanceHoldBsBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(5);
        sIncludes = bVar;
        bVar.a(0, new String[]{"pr_deativate_account_bottomsheet", "pr_reactivation_failed"}, new int[]{2, 3}, new int[]{R.layout.pr_deativate_account_bottomsheet, R.layout.pr_reactivation_failed});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mp_layout_barrier, 4);
    }

    public PrPaymentAcceptanceHoldBsBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public PrPaymentAcceptanceHoldBsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[2], objArr[1], objArr[0], objArr[4], objArr[3]);
        this.mDirtyFlags = -1;
        this.contactUsOn.setTag((Object) null);
        this.inActiveMerchant.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
        }
        this.apUi.invalidateAll();
        this.reactivationFailed.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.reactivationFailed.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.apUi.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            com.paytm.business.merchantprofile.databinding.PrDeativateAccountBottomsheetBinding r0 = r6.apUi
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.paytm.business.merchantprofile.databinding.PrReactivationFailedBinding r0 = r6.reactivationFailed
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrPaymentAcceptanceHoldBsBindingImpl.hasPendingBindings():boolean");
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
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    public void setData(MerchantAccountState merchantAccountState) {
        this.mData = merchantAccountState;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.apUi.setLifecycleOwner(qVar);
        this.reactivationFailed.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeApUi((PrDeativateAccountBottomsheetBinding) obj, i3);
        }
        if (i2 == 1) {
            return onChangeDataUiState((y) obj, i3);
        }
        if (i2 == 2) {
            return onChangeDataAccountState((y) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeReactivationFailed((PrReactivationFailedBinding) obj, i3);
    }

    private boolean onChangeApUi(PrDeativateAccountBottomsheetBinding prDeativateAccountBottomsheetBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDataUiState(y<MerchantAccountActivationUIState> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDataAccountState(y<AccountActivationState> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeReactivationFailed(PrReactivationFailedBinding prReactivationFailedBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        MerchantAccountActivationUIState merchantAccountActivationUIState;
        AccountActivationState accountActivationState;
        y<AccountActivationState> yVar;
        y<MerchantAccountActivationUIState> yVar2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = false;
        InactiveMerchantListener inactiveMerchantListener = this.mListener;
        MerchantAccountState merchantAccountState = this.mData;
        AccountActivationState accountActivationState2 = null;
        int i2 = ((118 & j) > 0 ? 1 : ((118 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (merchantAccountState != null) {
                yVar2 = merchantAccountState.getUiState();
                yVar = merchantAccountState.getAccountState();
            } else {
                yVar2 = null;
                yVar = null;
            }
            updateLiveDataRegistration(1, yVar2);
            updateLiveDataRegistration(2, yVar);
            MerchantAccountActivationUIState value = yVar2 != null ? yVar2.getValue() : null;
            if (yVar != null) {
                accountActivationState2 = yVar.getValue();
            }
            if ((j & 98) != 0) {
                z = !(value instanceof ActivationStatusCheckInProgress);
            }
            merchantAccountActivationUIState = value;
            accountActivationState = accountActivationState2;
        } else {
            accountActivationState = null;
            merchantAccountActivationUIState = null;
        }
        if ((80 & j) != 0) {
            this.apUi.setListener(inactiveMerchantListener);
            this.reactivationFailed.setListener(inactiveMerchantListener);
        }
        if ((96 & j) != 0) {
            this.apUi.setData(merchantAccountState);
            this.reactivationFailed.setData(merchantAccountState);
        }
        if ((j & 98) != 0) {
            DataBindingUtility.bindVisibility(this.contactUsOn, z);
        }
        if (i2 != 0) {
            DataBindingUtility.deactivatedAccountCTA(this.contactUsOn, true, accountActivationState, merchantAccountActivationUIState, inactiveMerchantListener, true);
            DataBindingUtility.inactivateMerchantState(this.inActiveMerchant, accountActivationState, merchantAccountActivationUIState, inactiveMerchantListener);
        }
        ViewDataBinding.executeBindingsOn(this.apUi);
        ViewDataBinding.executeBindingsOn(this.reactivationFailed);
    }
}
