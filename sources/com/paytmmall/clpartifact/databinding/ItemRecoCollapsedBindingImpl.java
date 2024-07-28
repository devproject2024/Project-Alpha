package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoItemVH;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemRecoCollapsedBindingImpl extends ItemRecoCollapsedBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    public ItemRecoCollapsedBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemRecoCollapsedBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1]);
        this.mDirtyFlags = -1;
        this.imageLL.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
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
            setHandler((CLPRecoItemVH) obj);
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

    public void setHandler(CLPRecoItemVH cLPRecoItemVH) {
        this.mHandler = cLPRecoItemVH;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
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
        Context context;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPRecoItemVH cLPRecoItemVH = this.mHandler;
        Context context2 = null;
        int i2 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
        if (i2 != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            if (cLPRecoItemVH != null) {
                context2 = cLPRecoItemVH.getContext();
            }
            str = imageUrl;
            context = context2;
        } else {
            str = null;
            context = null;
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.imageLL, str, 0, false, false, 0, context);
        }
    }
}
