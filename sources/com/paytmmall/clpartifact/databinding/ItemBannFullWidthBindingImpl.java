package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.SliderViewPagerAdapter;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;

public class ItemBannFullWidthBindingImpl extends ItemBannFullWidthBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemBannFullWidthBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, sIncludes, sViewsWithIds));
    }

    private ItemBannFullWidthBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0]);
        this.mDirtyFlags = -1;
        this.avatar.setTag((Object) null);
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
            setHandler((SliderViewPagerAdapter) obj);
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

    public void setHandler(SliderViewPagerAdapter sliderViewPagerAdapter) {
        this.mHandler = sliderViewPagerAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
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
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        SliderViewPagerAdapter sliderViewPagerAdapter = this.mHandler;
        PaytmAdView.a aVar = null;
        int i2 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if ((j & 5) != 0) {
                str2 = String.valueOf(item != null ? item.getPosition() : 0);
            } else {
                str2 = null;
            }
            if (sliderViewPagerAdapter != null) {
                aVar = sliderViewPagerAdapter.getAdClickListener(item);
                str = sliderViewPagerAdapter.getRequestId();
                context = sliderViewPagerAdapter.getContext();
            } else {
                context = null;
                str = null;
            }
        } else {
            context = null;
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            this.avatar.setOnClickListener(aVar);
            ClickableRVChildViewHolder.setImagePostMeasure(this.avatar, item, 0, false, context);
            AddviewBindings.setAddView(this.avatar, item, str);
        }
        if ((j & 5) != 0 && getBuildSdkInt() >= 4) {
            this.avatar.setContentDescription(str2);
        }
    }
}
