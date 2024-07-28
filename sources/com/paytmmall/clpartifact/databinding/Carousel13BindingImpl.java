package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;

public class Carousel13BindingImpl extends Carousel13Binding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public Carousel13BindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, sIncludes, sViewsWithIds));
    }

    private Carousel13BindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0]);
        this.mDirtyFlags = -1;
        this.carousel13Rv.setTag((Object) null);
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
        if (BR.view != i2) {
            return false;
        }
        setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
