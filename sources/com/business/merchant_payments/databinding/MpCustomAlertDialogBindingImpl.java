package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.common.utility.DataBindingUtility;
import com.paytm.utility.RoboTextView;

public class MpCustomAlertDialogBindingImpl extends MpCustomAlertDialogBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final RoboTextView mboundView4;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public MpCustomAlertDialogBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public MpCustomAlertDialogBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        RoboTextView roboTextView = objArr[4];
        this.mboundView4 = roboTextView;
        roboTextView.setTag((Object) null);
        this.msg.setTag((Object) null);
        this.positiveActionBtn.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
        if (BR.isTitleVisible == i2) {
            setIsTitleVisible((Boolean) obj);
        } else if (BR.message == i2) {
            setMessage((String) obj);
        } else if (BR.positiveText == i2) {
            setPositiveText((String) obj);
        } else if (BR.isNegativeBtnVisible == i2) {
            setIsNegativeBtnVisible((Boolean) obj);
        } else if (BR.negativeText == i2) {
            setNegativeText((String) obj);
        } else if (BR.onNegativeClick == i2) {
            setOnNegativeClick((View.OnClickListener) obj);
        } else if (BR.onPositiveClick == i2) {
            setOnPositiveClick((View.OnClickListener) obj);
        } else if (BR.mTitle != i2) {
            return false;
        } else {
            setMTitle((String) obj);
        }
        return true;
    }

    public void setIsTitleVisible(Boolean bool) {
        this.mIsTitleVisible = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.isTitleVisible);
        super.requestRebind();
    }

    public void setMessage(String str) {
        this.mMessage = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.message);
        super.requestRebind();
    }

    public void setPositiveText(String str) {
        this.mPositiveText = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.positiveText);
        super.requestRebind();
    }

    public void setIsNegativeBtnVisible(Boolean bool) {
        this.mIsNegativeBtnVisible = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.isNegativeBtnVisible);
        super.requestRebind();
    }

    public void setNegativeText(String str) {
        this.mNegativeText = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.negativeText);
        super.requestRebind();
    }

    public void setOnNegativeClick(View.OnClickListener onClickListener) {
        this.mOnNegativeClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.onNegativeClick);
        super.requestRebind();
    }

    public void setOnPositiveClick(View.OnClickListener onClickListener) {
        this.mOnPositiveClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.onPositiveClick);
        super.requestRebind();
    }

    public void setMTitle(String str) {
        this.mMTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.mTitle);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean bool = this.mIsTitleVisible;
        String str = this.mMessage;
        String str2 = this.mPositiveText;
        Boolean bool2 = this.mIsNegativeBtnVisible;
        String str3 = this.mNegativeText;
        View.OnClickListener onClickListener = this.mOnNegativeClick;
        View.OnClickListener onClickListener2 = this.mOnPositiveClick;
        String str4 = this.mMTitle;
        boolean z2 = false;
        int i2 = ((257 & j) > 0 ? 1 : ((257 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = ViewDataBinding.safeUnbox(bool);
        } else {
            z = false;
        }
        int i3 = ((258 & j) > 0 ? 1 : ((258 & j) == 0 ? 0 : -1));
        int i4 = ((260 & j) > 0 ? 1 : ((260 & j) == 0 ? 0 : -1));
        int i5 = ((264 & j) > 0 ? 1 : ((264 & j) == 0 ? 0 : -1));
        if (i5 != 0) {
            z2 = ViewDataBinding.safeUnbox(bool2);
        }
        int i6 = ((272 & j) > 0 ? 1 : ((272 & j) == 0 ? 0 : -1));
        int i7 = ((288 & j) > 0 ? 1 : ((288 & j) == 0 ? 0 : -1));
        int i8 = ((320 & j) > 0 ? 1 : ((320 & j) == 0 ? 0 : -1));
        int i9 = ((j & 384) > 0 ? 1 : ((j & 384) == 0 ? 0 : -1));
        if (i5 != 0) {
            DataBindingUtility.bindVisibility(this.mboundView4, z2);
        }
        if (i7 != 0) {
            this.mboundView4.setOnClickListener(onClickListener);
        }
        if (i6 != 0) {
            d.a((TextView) this.mboundView4, (CharSequence) str3);
        }
        if (i3 != 0) {
            d.a((TextView) this.msg, (CharSequence) str);
        }
        if (i8 != 0) {
            this.positiveActionBtn.setOnClickListener(onClickListener2);
        }
        if (i4 != 0) {
            d.a((TextView) this.positiveActionBtn, (CharSequence) str2);
        }
        if (i2 != 0) {
            DataBindingUtility.bindVisibility(this.title, z);
        }
        if (i9 != 0) {
            d.a((TextView) this.title, (CharSequence) str4);
        }
    }
}
