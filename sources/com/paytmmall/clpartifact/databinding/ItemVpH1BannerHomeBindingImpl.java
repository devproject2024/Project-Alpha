package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.SliderViewPagerAdapter;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;

public class ItemVpH1BannerHomeBindingImpl extends ItemVpH1BannerHomeBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemVpH1BannerHomeBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemVpH1BannerHomeBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.viewpagerImage.setTag((Object) null);
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
        Context context;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        SliderViewPagerAdapter sliderViewPagerAdapter = this.mHandler;
        PaytmAdView.a aVar = null;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            if (sliderViewPagerAdapter != null) {
                aVar = sliderViewPagerAdapter.getAdClickListener(item);
                str2 = sliderViewPagerAdapter.getRequestId();
                str = imageUrl;
                context = sliderViewPagerAdapter.getContext();
            } else {
                str = imageUrl;
                str2 = null;
                context = null;
            }
        } else {
            str2 = null;
            str = null;
            context = null;
        }
        if (i2 != 0) {
            this.viewpagerImage.setOnClickListener(aVar);
            ClickableRVChildViewHolder.setImageUrl(this.viewpagerImage, str, 5, false, false, 0, context);
            AddviewBindings.setAddView(this.viewpagerImage, item, str2);
        }
    }
}
