package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortBottomSheetVH;

public class ItemSortfilterDetailBindingImpl extends ItemSortfilterDetailBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback73;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ItemSortfilterDetailBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemSortfilterDetailBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.sortFilterName.setTag((Object) null);
        setRootTag(view);
        this.mCallback73 = new OnClickListener(this, 1);
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
            setItem((CJRSortingKeys) obj);
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((CLPSortBottomSheetVH) obj);
        }
        return true;
    }

    public void setItem(CJRSortingKeys cJRSortingKeys) {
        this.mItem = cJRSortingKeys;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(CLPSortBottomSheetVH cLPSortBottomSheetVH) {
        this.mHandler = cLPSortBottomSheetVH;
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
        CJRSortingKeys cJRSortingKeys = this.mItem;
        String str = null;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (!(i2 == 0 || cJRSortingKeys == null)) {
            str = cJRSortingKeys.getName();
        }
        if ((j & 4) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback73);
        }
        if (i2 != 0) {
            d.a(this.sortFilterName, (CharSequence) str);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPSortBottomSheetVH cLPSortBottomSheetVH = this.mHandler;
        CJRSortingKeys cJRSortingKeys = this.mItem;
        if (cLPSortBottomSheetVH != null) {
            cLPSortBottomSheetVH.handleSortItemClick(cJRSortingKeys);
        }
    }
}
