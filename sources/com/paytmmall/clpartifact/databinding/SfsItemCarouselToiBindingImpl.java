package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings;

public class SfsItemCarouselToiBindingImpl extends SfsItemCarouselToiBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback72;
    private long mDirtyFlags;
    private final CLPRobotoTextView mboundView4;

    public SfsItemCarouselToiBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private SfsItemCarouselToiBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[2], objArr[0], objArr[3]);
        this.mDirtyFlags = -1;
        this.bgImage.setTag((Object) null);
        this.iconImage.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.one.setTag((Object) null);
        this.titletxt.setTag((Object) null);
        setRootTag(view);
        this.mCallback72 = new OnClickListener(this, 1);
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
        String str4;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        int i2 = 0;
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (item != null) {
                str6 = item.getImageUrl();
                str2 = item.getItemSubtitle();
                str5 = item.getTitle();
                str4 = item.getIcon_url();
            } else {
                str4 = null;
                str6 = null;
                str2 = null;
                str5 = null;
            }
            boolean z = str4 != null;
            if (i3 != 0) {
                j |= z ? 32 : 16;
            }
            if (!z) {
                i2 = 8;
            }
            String str7 = str5;
            str = str6;
            str3 = str7;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((9 & j) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.bgImage, str, 22, false, false, 0, (Context) null);
            this.iconImage.setVisibility(i2);
            RecoWidgetViewBindings.setCircularImage(this.iconImage, str4, (Context) null);
            d.a((TextView) this.mboundView4, (CharSequence) str3);
            d.a((TextView) this.titletxt, (CharSequence) str2);
        }
        if ((j & 8) != 0) {
            this.one.setOnClickListener(this.mCallback72);
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
