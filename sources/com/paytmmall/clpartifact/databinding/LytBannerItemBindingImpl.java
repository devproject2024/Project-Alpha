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
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;
import com.paytmmall.clpartifact.view.viewbindings.CommonViewBindings;

public class LytBannerItemBindingImpl extends LytBannerItemBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public LytBannerItemBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private LytBannerItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[0]);
        this.mDirtyFlags = -1;
        this.avatar.setTag((Object) null);
        this.viewPagerLayout.setTag((Object) null);
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
            setHandler((CLPItemRVViewHolder) obj);
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

    public void setHandler(CLPItemRVViewHolder cLPItemRVViewHolder) {
        this.mHandler = cLPItemRVViewHolder;
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
        String str3;
        int i2;
        String str4;
        PaytmAdView.a aVar;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        Integer num = this.mPosition;
        int i3 = ((15 & j) > 0 ? 1 : ((15 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if ((j & 9) == 0 || item == null) {
                str3 = null;
                str5 = null;
                i2 = 0;
            } else {
                i2 = item.getBannerCornerRadius();
                str3 = item.getParentType();
                str5 = item.getmClassName();
            }
            String requestId = ((j & 11) == 0 || cLPItemRVViewHolder == null) ? null : cLPItemRVViewHolder.getRequestId();
            aVar = cLPItemRVViewHolder != null ? cLPItemRVViewHolder.getAdClickListener(item, ViewDataBinding.safeUnbox(num)) : null;
            str4 = (j & 12) != 0 ? String.valueOf(num) : null;
            str2 = str5;
            str = requestId;
        } else {
            aVar = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
        }
        if (i3 != 0) {
            this.avatar.setOnClickListener(aVar);
        }
        if ((j & 12) != 0 && getBuildSdkInt() >= 4) {
            this.avatar.setContentDescription(str4);
        }
        if ((j & 9) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.avatar, item, i2, false, (Context) null);
            CommonViewBindings.setBannerMargins(this.viewPagerLayout, str2);
            CommonViewBindings.setBannerDimensionRatio(this.viewPagerLayout, str3);
        }
        if ((j & 11) != 0) {
            AddviewBindings.setAddView(this.avatar, item, str);
        }
    }
}
