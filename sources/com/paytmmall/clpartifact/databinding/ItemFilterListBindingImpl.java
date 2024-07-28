package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.view.adapter.FilterRecyclerViewAdapter;

public class ItemFilterListBindingImpl extends ItemFilterListBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.selectedView, 3);
        sViewsWithIds.put(R.id.image_selected_filter, 4);
    }

    public ItemFilterListBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemFilterListBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[4], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.filterTextView.setTag((Object) null);
        this.linearRectItem.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
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
        if (BR.item == i2) {
            setItem((CJRFilterItem) obj);
        } else if (BR.handler == i2) {
            setHandler((FilterRecyclerViewAdapter.FilterListViewHolder) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
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

    public void setHandler(FilterRecyclerViewAdapter.FilterListViewHolder filterListViewHolder) {
        this.mHandler = filterListViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.position);
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
        int i2 = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (!(i2 == 0 || cJRFilterItem == null)) {
            str = cJRFilterItem.getTitle();
        }
        if (i2 != 0) {
            d.a((TextView) this.filterTextView, (CharSequence) str);
        }
        if ((j & 8) != 0) {
            this.linearRectItem.setOnClickListener(this.mCallback1);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        FilterRecyclerViewAdapter.FilterListViewHolder filterListViewHolder = this.mHandler;
        Integer num = this.mPosition;
        if (filterListViewHolder != null) {
            filterListViewHolder.onCLick(num.intValue());
        }
    }
}
