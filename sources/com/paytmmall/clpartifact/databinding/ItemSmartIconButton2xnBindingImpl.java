package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconButton;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemSmartIconButton2xnBindingImpl extends ItemSmartIconButton2xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback5;
    private long mDirtyFlags;

    public ItemSmartIconButton2xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSmartIconButton2xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[2], objArr[0]);
        this.mDirtyFlags = -1;
        this.button2XNText.setTag((Object) null);
        this.buttonIcon.setTag((Object) null);
        this.cashbackView2XN.setTag((Object) null);
        setRootTag(view);
        this.mCallback5 = new OnClickListener(this, 1);
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
        String str3;
        Item.LayoutData layoutData;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Item item = this.mItem;
        CLPItemRVViewHolder cLPItemRVViewHolder = this.mHandler;
        String str6 = null;
        int i2 = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            String imageUrl = item != null ? item.getImageUrl() : null;
            Context context2 = cLPItemRVViewHolder != null ? cLPItemRVViewHolder.getContext() : null;
            if ((j & 9) != 0) {
                if (item != null) {
                    layoutData = item.getLayout();
                    str4 = item.getName();
                } else {
                    str4 = null;
                    layoutData = null;
                }
                if (layoutData != null) {
                    str5 = layoutData.getLabelColor();
                    str2 = layoutData.getLabelBgColor();
                } else {
                    str2 = null;
                    str5 = null;
                }
                if (str4 != null) {
                    str6 = str4.trim();
                }
                context = context2;
                str = imageUrl;
                str3 = str6;
                str6 = str5;
            } else {
                context = context2;
                str = imageUrl;
                str3 = null;
                str2 = null;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
            context = null;
        }
        if ((j & 9) != 0) {
            CLPSmartIconButton.setTextColor(this.button2XNText, str6);
            this.button2XNText.setText(str3);
            CLPSmartIconButton.setColorbg(this.cashbackView2XN, str2);
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.buttonIcon, str, 0, false, false, 0, context);
        }
        if ((j & 8) != 0) {
            this.cashbackView2XN.setOnClickListener(this.mCallback5);
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
