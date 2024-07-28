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
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem_1_3;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;

public class ItemCarousel13BindingImpl extends ItemCarousel13Binding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemCarousel13BindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemCarousel13BindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.carousel13Container.setTag((Object) null);
        this.carousel13Image.setTag((Object) null);
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
            setHandler((CLPCarouselItem_1_3) obj);
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

    public void setHandler(CLPCarouselItem_1_3 cLPCarouselItem_1_3) {
        this.mHandler = cLPCarouselItem_1_3;
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
        Context context;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPCarouselItem_1_3 cLPCarouselItem_1_3 = this.mHandler;
        Integer num = this.mPosition;
        PaytmAdView.a aVar = null;
        int i2 = ((15 & j) > 0 ? 1 : ((15 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if ((j & 11) == 0 || cLPCarouselItem_1_3 == null) {
                str = null;
                context = null;
            } else {
                str = cLPCarouselItem_1_3.getRequestId();
                context = cLPCarouselItem_1_3.getContext();
            }
            int safeUnbox = ViewDataBinding.safeUnbox(num);
            if (cLPCarouselItem_1_3 != null) {
                aVar = cLPCarouselItem_1_3.getAdClickListener(item, safeUnbox);
            }
        } else {
            str = null;
            context = null;
        }
        if (i2 != 0) {
            this.carousel13Image.setOnClickListener(aVar);
        }
        if ((j & 11) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.carousel13Image, item, 24, false, context);
            AddviewBindings.setAddView(this.carousel13Image, item, str);
        }
    }
}
