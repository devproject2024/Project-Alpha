package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DataBindingUtility;

public class MpLayoutVerifyQrPopupBindingImpl extends MpLayoutVerifyQrPopupBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mpVerifyText, 1);
        sViewsWithIds.put(R.id.verify_qr_yes, 2);
        sViewsWithIds.put(R.id.verify_qr_no, 3);
    }

    public MpLayoutVerifyQrPopupBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    public MpLayoutVerifyQrPopupBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1], objArr[0], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.parent.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (BR.showVerifyQrPopup != i2) {
            return false;
        }
        setShowVerifyQrPopup((Boolean) obj);
        return true;
    }

    public void setShowVerifyQrPopup(Boolean bool) {
        this.mShowVerifyQrPopup = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.showVerifyQrPopup);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = false;
        Boolean bool = this.mShowVerifyQrPopup;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = ViewDataBinding.safeUnbox(bool);
        }
        if (i2 != 0) {
            DataBindingUtility.bindVisibility(this.parent, z);
        }
    }
}
