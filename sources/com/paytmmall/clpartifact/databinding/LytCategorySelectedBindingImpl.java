package com.paytmmall.clpartifact.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.b;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.actions.ICategoryClickListener;

public class LytCategorySelectedBindingImpl extends LytCategorySelectedBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback87;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final View mboundView2;
    private final View mboundView3;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public LytCategorySelectedBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private LytCategorySelectedBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.txvCategory.setTag((Object) null);
        setRootTag(view);
        this.mCallback87 = new OnClickListener(this, 1);
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
        if (BR.category == i2) {
            setCategory((String) obj);
        } else if (BR.handler == i2) {
            setHandler((ICategoryClickListener) obj);
        } else if (BR.isSelected == i2) {
            setIsSelected((Boolean) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
        }
        return true;
    }

    public void setCategory(String str) {
        this.mCategory = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.category);
        super.requestRebind();
    }

    public void setHandler(ICategoryClickListener iCategoryClickListener) {
        this.mHandler = iCategoryClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setIsSelected(Boolean bool) {
        this.mIsSelected = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.isSelected);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        int i2;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mCategory;
        Boolean bool = this.mIsSelected;
        int i4 = 0;
        int i5 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i5 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i5 != 0) {
                if (safeUnbox) {
                    j3 = j | 64 | 256;
                    j2 = 1024;
                } else {
                    j3 = j | 32 | 128;
                    j2 = 512;
                }
                j = j3 | j2;
            }
            i2 = safeUnbox ? 0 : 8;
            int colorFromResource = getColorFromResource(this.mboundView0, safeUnbox ? R.color.white : R.color.gray_background_color);
            if (safeUnbox) {
                i4 = 8;
            }
            i3 = i4;
            i4 = colorFromResource;
        } else {
            i3 = 0;
            i2 = 0;
        }
        if ((16 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback87);
        }
        if ((20 & j) != 0) {
            androidx.databinding.a.e.a((View) this.mboundView0, (Drawable) b.a(i4));
            this.mboundView2.setVisibility(i3);
            this.mboundView3.setVisibility(i2);
        }
        if ((j & 17) != 0) {
            d.a(this.txvCategory, (CharSequence) str);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        ICategoryClickListener iCategoryClickListener = this.mHandler;
        String str = this.mCategory;
        Integer num = this.mPosition;
        if (iCategoryClickListener != null) {
            iCategoryClickListener.onCategoryClick(str, num.intValue());
        }
    }
}
