package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public class FragmentSmartIconListBindingImpl extends FragmentSmartIconListBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    public FragmentSmartIconListBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, sIncludes, sViewsWithIds));
    }

    private FragmentSmartIconListBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[0]);
        this.mDirtyFlags = -1;
        this.recyclerViewItem.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
