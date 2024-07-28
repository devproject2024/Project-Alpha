package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemRow2xnBindingImpl extends ItemRow2xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback105;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public ItemRow2xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemRow2xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[3], objArr[1], objArr[5], objArr[2], objArr[6], objArr[7], objArr[4]);
        this.mDirtyFlags = -1;
        this.itemAddTag.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.parentLayout.setTag((Object) null);
        this.row1xnCost.setTag((Object) null);
        this.row1xnImage.setTag((Object) null);
        this.row1xnOfferPrice.setTag((Object) null);
        this.row1xnTags.setTag((Object) null);
        this.row1xnText.setTag((Object) null);
        setRootTag(view);
        this.mCallback105 = new OnClickListener(this, 1);
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
        Context context;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        Drawable drawable;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        Integer num = this.mPosition;
        if ((j & 11) != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            Context context2 = cLPItemRVViewHolder != null ? cLPItemRVViewHolder.getContext() : null;
            int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (item != null) {
                    str8 = item.getOfferPrice();
                    str7 = item.getMactualPrice();
                    String discount = item.getDiscount();
                    str6 = item.getName();
                    z = item.getSponsored();
                    str9 = discount;
                } else {
                    z = false;
                    str9 = null;
                    str8 = null;
                    str7 = null;
                    str6 = null;
                }
                if (i3 != 0) {
                    j |= z ? 128 : 64;
                }
                str3 = StringUtils.getRupeesFormat(str8);
                String rupeesFormat = StringUtils.getRupeesFormat(str7);
                str2 = str9 + "%";
                i2 = z ? 0 : 8;
                context = context2;
                str = imageUrl;
                str4 = rupeesFormat;
                str5 = str6;
            } else {
                context = context2;
                str = imageUrl;
                str5 = null;
                str4 = null;
                str3 = null;
                i2 = 0;
                str2 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            i2 = 0;
            str2 = null;
            str = null;
            context = null;
        }
        int i4 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i4 != 0) {
            boolean z2 = ViewDataBinding.safeUnbox(num) % 2 == 0;
            if (i4 != 0) {
                j |= z2 ? 32 : 16;
            }
            drawable = getDrawableFromResource(this.parentLayout, z2 ? R.drawable.custom2xnborder : R.drawable.custom2xnborderbottom);
        } else {
            drawable = null;
        }
        if ((9 & j) != 0) {
            this.itemAddTag.setVisibility(i2);
            d.a((TextView) this.row1xnCost, (CharSequence) str3);
            d.a((TextView) this.row1xnOfferPrice, (CharSequence) str4);
            d.a((TextView) this.row1xnTags, (CharSequence) str2);
            d.a(this.row1xnText, (CharSequence) str5);
        }
        if ((j & 12) != 0) {
            androidx.databinding.a.e.a((View) this.parentLayout, drawable);
        }
        if ((8 & j) != 0) {
            this.parentLayout.setOnClickListener(this.mCallback105);
        }
        if ((j & 11) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.row1xnImage, str, 0, false, false, 0, context);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        Item item = this.mItem;
        Integer num = this.mPosition;
        if (cLPItemRVViewHolder != null) {
            cLPItemRVViewHolder.handleDeepLink(item, num.intValue());
        }
    }
}
