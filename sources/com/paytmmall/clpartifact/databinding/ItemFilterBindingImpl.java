package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortingViewHolder;

public class ItemFilterBindingImpl extends ItemFilterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback21;
    private long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.filterTxtValue2, 2);
    }

    public ItemFilterBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemFilterBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[0], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.filterTxt.setTag((Object) null);
        this.filterTxtValue1.setTag((Object) null);
        setRootTag(view);
        this.mCallback21 = new OnClickListener(this, 1);
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
            setItem((CJRFilterItem) obj);
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((CLPSortingViewHolder) obj);
        }
        return true;
    }

    public void setItem(CJRFilterItem cJRFilterItem) {
        this.mItem = cJRFilterItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(CLPSortingViewHolder cLPSortingViewHolder) {
        this.mHandler = cLPSortingViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CJRFilterItem cJRFilterItem = this.mItem;
        String str = null;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (!(i2 == 0 || cJRFilterItem == null)) {
            str = cJRFilterItem.getTitle();
        }
        if ((j & 4) != 0) {
            this.filterTxt.setOnClickListener(this.mCallback21);
        }
        if (i2 != 0) {
            d.a(this.filterTxtValue1, (CharSequence) str);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPSortingViewHolder cLPSortingViewHolder = this.mHandler;
        CJRFilterItem cJRFilterItem = this.mItem;
        if (cLPSortingViewHolder != null) {
            cLPSortingViewHolder.handleFilterClick(cJRFilterItem);
        }
    }
}
