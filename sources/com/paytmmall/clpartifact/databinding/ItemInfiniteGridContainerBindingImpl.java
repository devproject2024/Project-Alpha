package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.R;

public class ItemInfiniteGridContainerBindingImpl extends ItemInfiniteGridContainerBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.viewName, 1);
        sViewsWithIds.put(R.id.filter_container, 2);
        sViewsWithIds.put(R.id.grid_tabs_container, 3);
        sViewsWithIds.put(R.id.mainProgressBar, 4);
        sViewsWithIds.put(R.id.progressBar, 5);
        sViewsWithIds.put(R.id.noNetworkLL, 6);
        sViewsWithIds.put(R.id.retryButton, 7);
    }

    public ItemInfiniteGridContainerBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemInfiniteGridContainerBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[3], objArr[4], objArr[6], objArr[5], objArr[7], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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
