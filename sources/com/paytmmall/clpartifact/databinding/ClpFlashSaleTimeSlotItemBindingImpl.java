package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.FlashSaleTimeSlotViewHolder;

public class ClpFlashSaleTimeSlotItemBindingImpl extends ClpFlashSaleTimeSlotItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback55;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.fragmentContainer, 1);
        sViewsWithIds.put(R.id.time_slot_container, 2);
        sViewsWithIds.put(R.id.title, 3);
        sViewsWithIds.put(R.id.time, 4);
        sViewsWithIds.put(R.id.flash_sale_circle, 5);
    }

    public ClpFlashSaleTimeSlotItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private ClpFlashSaleTimeSlotItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[5], objArr[1], objArr[4], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        this.mCallback55 = new OnClickListener(this, 1);
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
        } else if (BR.holder != i2) {
            return false;
        } else {
            setHolder((FlashSaleTimeSlotViewHolder) obj);
        }
        return true;
    }

    public void setItem(Item item) {
        this.mItem = item;
    }

    public void setHolder(FlashSaleTimeSlotViewHolder flashSaleTimeSlotViewHolder) {
        this.mHolder = flashSaleTimeSlotViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.holder);
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 4) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback55);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        FlashSaleTimeSlotViewHolder flashSaleTimeSlotViewHolder = this.mHolder;
        if (flashSaleTimeSlotViewHolder != null) {
            flashSaleTimeSlotViewHolder.lambda$bind$0$FlashSaleTimeSlotViewHolder(view);
        }
    }
}
