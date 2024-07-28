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
import com.paytmmall.clpartifact.view.viewbindings.AddviewBindings;

public class ItemSmartIconButtonBindingImpl extends ItemSmartIconButtonBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback95;
    private long mDirtyFlags;

    public ItemSmartIconButtonBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSmartIconButtonBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[2], objArr[0]);
        this.mDirtyFlags = -1;
        this.buttonIcon.setTag((Object) null);
        this.buttonText.setTag((Object) null);
        this.cashbackView.setTag((Object) null);
        setRootTag(view);
        this.mCallback95 = new OnClickListener(this, 1);
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
        String str4;
        Context context2;
        String str5;
        Item.LayoutData layoutData;
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
            if (cLPItemRVViewHolder != null) {
                str3 = cLPItemRVViewHolder.getRequestId();
                context2 = cLPItemRVViewHolder.getContext();
            } else {
                context2 = null;
                str3 = null;
            }
            if ((j & 9) != 0) {
                if (item != null) {
                    layoutData = item.getLayout();
                    str5 = item.getName();
                } else {
                    layoutData = null;
                    str5 = null;
                }
                if (layoutData != null) {
                    String labelColor = layoutData.getLabelColor();
                    str2 = layoutData.getLabelBgColor();
                    context = context2;
                    str = imageUrl;
                    str4 = labelColor;
                } else {
                    context = context2;
                    str = imageUrl;
                    str4 = null;
                    str2 = null;
                }
                str6 = str5;
            } else {
                context = context2;
                str = imageUrl;
                str4 = null;
                str2 = null;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            context = null;
        }
        if (i2 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.buttonIcon, str, 0, false, false, 0, context);
            AddviewBindings.setAddView(this.buttonIcon, item, str3);
        }
        if ((j & 9) != 0) {
            this.buttonText.setText(str6);
            CLPSmartIconButton.setTextColor(this.buttonText, str4);
            CLPSmartIconButton.setColorbg(this.cashbackView, str2);
        }
        if ((j & 8) != 0) {
            this.cashbackView.setOnClickListener(this.mCallback95);
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
