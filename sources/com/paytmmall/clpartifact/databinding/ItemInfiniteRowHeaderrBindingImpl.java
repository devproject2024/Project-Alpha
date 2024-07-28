package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.InfiniteGridRowViewHolder;

public class ItemInfiniteRowHeaderrBindingImpl extends ItemInfiniteRowHeaderrBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tab_container, 1);
        sViewsWithIds.put(R.id.tabs, 2);
        sViewsWithIds.put(R.id.single_tab, 3);
        sViewsWithIds.put(R.id.Divider, 4);
        sViewsWithIds.put(R.id.infinite_grid, 5);
    }

    public ItemInfiniteRowHeaderrBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemInfiniteRowHeaderrBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[5], objArr[0], objArr[3], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.relativeLayout.setTag((Object) null);
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
        if (BR.item == i2) {
            setItem((Item) obj);
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((InfiniteGridRowViewHolder) obj);
        }
        return true;
    }

    public void setItem(Item item) {
        this.mItem = item;
    }

    public void setHandler(InfiniteGridRowViewHolder infiniteGridRowViewHolder) {
        this.mHandler = infiniteGridRowViewHolder;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeItem((Item) obj, i3);
    }

    private boolean onChangeItem(Item item, int i2) {
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
