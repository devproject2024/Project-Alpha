package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.SmartGroupItemVH;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;

public class ItemSmartGrpGridBindingImpl extends ItemSmartGrpGridBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback27;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ic_raises, 4);
        sViewsWithIds.put(R.id.grp_item, 5);
        sViewsWithIds.put(R.id.textView, 6);
    }

    public ItemSmartGrpGridBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemSmartGrpGridBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[2], objArr[5], objArr[4], objArr[6], objArr[1]);
        this.mDirtyFlags = -1;
        this.categoryTitle.setTag((Object) null);
        this.groupImageView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvLabel.setTag((Object) null);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 1);
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
            setItem((Item) obj);
        } else if (BR.handler == i2) {
            setHandler((SmartGroupItemVH) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
        }
        return true;
    }

    public void setItem(Item item) {
        updateRegistration(0, (h) item);
        this.mItem = item;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    public void setHandler(SmartGroupItemVH smartGroupItemVH) {
        this.mHandler = smartGroupItemVH;
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
        long j;
        String str;
        String str2;
        Item.LayoutData layoutData;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        SmartGroupItemVH smartGroupItemVH = this.mHandler;
        String str3 = null;
        int i2 = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if ((j & 9) != 0) {
                if (item != null) {
                    str2 = item.getName();
                    layoutData = item.mLayout;
                } else {
                    str2 = null;
                    layoutData = null;
                }
                str = layoutData != null ? layoutData.mLabel : null;
            } else {
                str2 = null;
                str = null;
            }
            if (smartGroupItemVH != null) {
                str3 = smartGroupItemVH.getRequestId();
            }
        } else {
            str2 = null;
            str = null;
        }
        int i3 = ((8 & j) > 0 ? 1 : ((8 & j) == 0 ? 0 : -1));
        int i4 = i3 != 0 ? R.drawable.sfs_grid_default_placeholder : 0;
        if ((j & 9) != 0) {
            this.categoryTitle.setText(str2);
            d.a(this.tvLabel, (CharSequence) str);
        }
        if (i2 != 0) {
            AddviewBindings.setAddView(this.groupImageView, item, str3);
        }
        if (i3 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.groupImageView, (String) null, 0, false, false, i4, (Context) null);
            this.mboundView0.setOnClickListener(this.mCallback27);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        SmartGroupItemVH smartGroupItemVH = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (smartGroupItemVH != null) {
            smartGroupItemVH.handleClick(item, num);
        }
    }
}
