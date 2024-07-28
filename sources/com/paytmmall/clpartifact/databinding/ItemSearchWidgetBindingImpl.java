package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import java.util.List;

public class ItemSearchWidgetBindingImpl extends ItemSearchWidgetBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback48;
    private final View.OnClickListener mCallback49;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ItemSearchWidgetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemSearchWidgetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[2], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        this.image.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.subtitle.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        this.mCallback49 = new OnClickListener(this, 2);
        this.mCallback48 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPItemVHWithoutRV) obj);
        } else if (BR.position != i2) {
            return false;
        } else {
            setPosition((Integer) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(1, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV) {
        this.mHandler = cLPItemVHWithoutRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setPosition(Integer num) {
        this.mPosition = num;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewItemsGetInt0((Item) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeViewItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        int i2;
        int i3;
        String str;
        String str2;
        Item item;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        int i4 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
        if (i4 != 0) {
            List<Item> items = view != null ? view.getItems() : null;
            item = items != null ? items.get(0) : null;
            updateRegistration(0, (h) item);
            if (item != null) {
                str2 = item.getItemSubtitle();
                str = item.getTitle();
            } else {
                str2 = null;
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
            if (i4 != 0) {
                j |= isEmpty ? 256 : 128;
            }
            if ((j & 19) != 0) {
                j |= isEmpty2 ? 64 : 32;
            }
            i3 = 8;
            i2 = isEmpty ? 8 : 0;
            if (!isEmpty2) {
                i3 = 0;
            }
        } else {
            item = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
        }
        if ((16 & j) != 0) {
            this.image.setOnClickListener(this.mCallback48);
            this.subtitle.setOnClickListener(this.mCallback49);
        }
        if ((j & 19) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.image, item, 0, false, (Context) null);
            this.subtitle.setVisibility(i2);
            this.subtitle.setText(str2);
            d.a(this.title, (CharSequence) str);
            this.title.setVisibility(i3);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = true;
        if (i2 == 1) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
            if (cLPItemVHWithoutRV != null) {
                if (view2 != null) {
                    List<Item> items = view2.getItems();
                    if (items == null) {
                        z = false;
                    }
                    if (z) {
                        cLPItemVHWithoutRV.handleDeepLink(items.get(0), 0);
                    }
                }
            }
        } else if (i2 == 2) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV2 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view3 = this.mView;
            if (cLPItemVHWithoutRV2 != null) {
                if (view3 != null) {
                    List<Item> items2 = view3.getItems();
                    if (items2 == null) {
                        z = false;
                    }
                    if (z) {
                        cLPItemVHWithoutRV2.handleDeepLink(items2.get(0), 0);
                    }
                }
            }
        }
    }
}
