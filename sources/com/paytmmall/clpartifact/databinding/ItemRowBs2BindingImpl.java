package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemRowBs2BindingImpl extends ItemRowBs2Binding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback94;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView3;

    public ItemRowBs2BindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemRowBs2BindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[2]);
        this.mDirtyFlags = -1;
        this.itemAddTag.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        setRootTag(view);
        this.mCallback94 = new OnClickListener(this, 1);
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
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        int i2 = 0;
        String str2 = null;
        if ((j & 11) != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            Context context2 = cLPItemRVViewHolder != null ? cLPItemRVViewHolder.getContext() : null;
            int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (item != null) {
                    str2 = item.getName();
                    z = item.getSponsored();
                } else {
                    z = false;
                }
                if (i3 != 0) {
                    j |= z ? 32 : 16;
                }
                if (!z) {
                    i2 = 8;
                }
            }
            context = context2;
            str = imageUrl;
        } else {
            str = null;
            context = null;
        }
        if ((j & 9) != 0) {
            this.itemAddTag.setVisibility(i2);
            d.a(this.mboundView3, (CharSequence) str2);
        }
        if ((8 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback94);
        }
        if ((j & 11) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.mboundView1, str, 0, false, false, 0, context);
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
