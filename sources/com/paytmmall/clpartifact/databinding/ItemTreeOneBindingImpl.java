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
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPTreeViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemTreeOneBindingImpl extends ItemTreeOneBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback80;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ImageView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tree_expande, 7);
    }

    public ItemTreeOneBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemTreeOneBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[6], objArr[7]);
        this.mDirtyFlags = -1;
        this.imageViewArrow.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.mboundView4 = objArr[4];
        this.mboundView4.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        setRootTag(view);
        this.mCallback80 = new OnClickListener(this, 1);
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
            setHandler((CLPTreeViewHolder) obj);
        } else if (BR.label != i2) {
            return false;
        } else {
            setLabel((String) obj);
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

    public void setHandler(CLPTreeViewHolder cLPTreeViewHolder) {
        this.mHandler = cLPTreeViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setLabel(String str) {
        this.mLabel = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.label);
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
        CLPTreeViewHolder cLPTreeViewHolder = this.mHandler;
        String str3 = this.mLabel;
        String str4 = null;
        int i2 = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            Context context2 = cLPTreeViewHolder != null ? cLPTreeViewHolder.getContext() : null;
            if ((j & 9) == 0 || item == null) {
                context = context2;
                str = imageUrl;
                str2 = null;
            } else {
                context = context2;
                str = imageUrl;
                String itemSubtitle = item.getItemSubtitle();
                str4 = item.getName();
                str2 = itemSubtitle;
            }
        } else {
            str2 = null;
            str = null;
            context = null;
        }
        if ((8 & j) != 0) {
            this.imageViewArrow.setImageDrawable(getDrawableFromResource(this.imageViewArrow, R.drawable.clp_ic_down_arrow_24));
            this.mboundView1.setOnClickListener(this.mCallback80);
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.mboundView2, str, 0, false, false, 0, context);
        }
        if ((j & 9) != 0) {
            d.a(this.mboundView3, (CharSequence) str4);
            d.a(this.mboundView4, (CharSequence) str2);
        }
        if ((j & 12) != 0) {
            d.a(this.mboundView5, (CharSequence) str3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPTreeViewHolder cLPTreeViewHolder = this.mHandler;
        Item item = this.mItem;
        if (cLPTreeViewHolder != null) {
            cLPTreeViewHolder.ExpandTreeList(item);
        }
    }
}
