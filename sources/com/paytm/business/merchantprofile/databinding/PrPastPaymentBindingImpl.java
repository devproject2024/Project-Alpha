package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.generated.callback.OnClickListener;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public class PrPastPaymentBindingImpl extends PrPastPaymentBinding implements OnClickListener.Listener {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public final View.OnClickListener mCallback6;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public PrPastPaymentBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    public PrPastPaymentBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.parent.setTag((Object) null);
        this.viewPastPayments.setTag((Object) null);
        setRootTag(view);
        this.mCallback6 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    public void setData(MerchantAccountState merchantAccountState) {
        this.mData = merchantAccountState;
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 4) != 0) {
            this.viewPastPayments.setOnClickListener(this.mCallback6);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        InactiveMerchantListener inactiveMerchantListener = this.mListener;
        if (inactiveMerchantListener != null) {
            inactiveMerchantListener.onViewPastPaymentsClick();
        }
    }
}
