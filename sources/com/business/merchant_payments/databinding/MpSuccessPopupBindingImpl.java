package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DataBindingUtility;
import com.business.merchant_payments.homepagedialogs.HomePageSuccessPopup;

public class MpSuccessPopupBindingImpl extends MpSuccessPopupBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.success_icon, 2);
    }

    public MpSuccessPopupBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    public MpSuccessPopupBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.txtCongratsStatic.setTag((Object) null);
        setRootTag(view);
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
            setListener((HomePageSuccessPopup.HomePageNotificationPopupListener) obj);
        } else if (BR.message != i2) {
            return false;
        } else {
            setMessage((String) obj);
        }
        return true;
    }

    public void setListener(HomePageSuccessPopup.HomePageNotificationPopupListener homePageNotificationPopupListener) {
        this.mListener = homePageNotificationPopupListener;
    }

    public void setMessage(String str) {
        this.mMessage = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.message);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mMessage;
        if ((j & 6) != 0) {
            DataBindingUtility.htmlText(this.txtCongratsStatic, str);
        }
    }
}
