package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.a;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;

public class MpReceiveForItemViewBindingImpl extends MpReceiveForItemViewBinding {
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
        sparseIntArray.put(R.id.divider_1, 3);
    }

    public MpReceiveForItemViewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    public MpReceiveForItemViewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.switchTransactionNotification.setTag((Object) null);
        this.tvTransactionNotification.setTag((Object) null);
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
        if (BR.isChecked == i2) {
            setIsChecked((Boolean) obj);
        } else if (BR.checkChangeListener == i2) {
            setCheckChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        } else if (BR.msg != i2) {
            return false;
        } else {
            setMsg((String) obj);
        }
        return true;
    }

    public void setIsChecked(Boolean bool) {
        this.mIsChecked = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.isChecked);
        super.requestRebind();
    }

    public void setCheckChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.checkChangeListener);
        super.requestRebind();
    }

    public void setMsg(String str) {
        this.mMsg = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.msg);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = false;
        Boolean bool = this.mIsChecked;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mCheckChangeListener;
        String str = this.mMsg;
        int i2 = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = ViewDataBinding.safeUnbox(bool);
        }
        int i3 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        int i4 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i2 != 0) {
            a.a(this.switchTransactionNotification, z);
        }
        if (i3 != 0) {
            this.switchTransactionNotification.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if (i4 != 0) {
            d.a((TextView) this.tvTransactionNotification, (CharSequence) str);
        }
    }
}
