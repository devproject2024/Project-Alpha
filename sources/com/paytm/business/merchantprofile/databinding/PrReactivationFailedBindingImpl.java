package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.utility.DataBindingUtility;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;
import com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed;

public class PrReactivationFailedBindingImpl extends PrReactivationFailedBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.icon_warning, 1);
        sViewsWithIds.put(R.id.title, 2);
        sViewsWithIds.put(R.id.message, 3);
    }

    public PrReactivationFailedBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    public PrReactivationFailedBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[3], objArr[0], objArr[2]);
        this.mDirtyFlags = -1;
        this.oarent.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeDataAccountState((y) obj, i3);
    }

    private boolean onChangeDataAccountState(y<AccountActivationState> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MerchantAccountState merchantAccountState = this.mData;
        boolean z = false;
        int i2 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
        if (i2 != 0) {
            AccountActivationState accountActivationState = null;
            y<AccountActivationState> accountState = merchantAccountState != null ? merchantAccountState.getAccountState() : null;
            updateLiveDataRegistration(0, accountState);
            if (accountState != null) {
                accountActivationState = accountState.getValue();
            }
            z = accountActivationState instanceof ReActivationFailed;
        }
        if (i2 != 0) {
            DataBindingUtility.bindVisibility(this.oarent, z);
        }
    }
}
