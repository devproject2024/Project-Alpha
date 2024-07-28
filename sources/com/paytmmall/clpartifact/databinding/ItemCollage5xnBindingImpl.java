package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import java.util.List;

public class ItemCollage5xnBindingImpl extends ItemCollage5xnBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback82;
    private final View.OnClickListener mCallback83;
    private final View.OnClickListener mCallback84;
    private final View.OnClickListener mCallback85;
    private final View.OnClickListener mCallback86;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;

    public ItemCollage5xnBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemCollage5xnBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 11);
        this.mDirtyFlags = -1;
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
        this.mCallback82 = new OnClickListener(this, 1);
        this.mCallback83 = new OnClickListener(this, 2);
        this.mCallback86 = new OnClickListener(this, 5);
        this.mCallback84 = new OnClickListener(this, 3);
        this.mCallback85 = new OnClickListener(this, 4);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
        } else if (BR.handler != i2) {
            return false;
        } else {
            setHandler((CLPItemVHWithoutRV) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(3, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setHandler(CLPItemVHWithoutRV cLPItemVHWithoutRV) {
        this.mHandler = cLPItemVHWithoutRV;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewItemsGetInt4((Item) obj, i3);
            case 1:
                return onChangeItemViewItemsGetInt2((Item) obj, i3);
            case 2:
                return onChangeViewItemsGetInt0((Item) obj, i3);
            case 3:
                return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
            case 4:
                return onChangeItemViewItemsGetInt4((Item) obj, i3);
            case 5:
                return onChangeViewItemsGetInt2((Item) obj, i3);
            case 6:
                return onChangeItemViewItemsGetInt3((Item) obj, i3);
            case 7:
                return onChangeViewItemsGetInt1((Item) obj, i3);
            case 8:
                return onChangeItemViewItemsGetInt1((Item) obj, i3);
            case 9:
                return onChangeItemViewItemsGetInt0((Item) obj, i3);
            case 10:
                return onChangeViewItemsGetInt3((Item) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewItemsGetInt4(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt2(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt4(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt2(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt3(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt1(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt1(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeItemViewItemsGetInt0(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewItemsGetInt3(Item item, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    public void executeBindings() {
        long j;
        Item item;
        Item item2;
        Item item3;
        Item item4;
        Context context;
        Item item5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
        if ((8191 & j) != 0) {
            List<Item> items = view != null ? view.getItems() : null;
            context = cLPItemVHWithoutRV != null ? cLPItemVHWithoutRV.getContext() : null;
            if ((j & 6169) != 0) {
                item3 = items != null ? items.get(4) : null;
                updateRegistration(0, (h) item3);
                if (item3 == null) {
                    item3 = null;
                }
                updateRegistration(4, (h) item3);
            } else {
                item3 = null;
            }
            if ((j & 6668) != 0) {
                item2 = items != null ? items.get(0) : null;
                updateRegistration(2, (h) item2);
                if (item2 == null) {
                    item2 = null;
                }
                updateRegistration(9, (h) item2);
            } else {
                item2 = null;
            }
            if ((j & 6186) != 0) {
                item4 = items != null ? items.get(2) : null;
                updateRegistration(5, (h) item4);
                if (item4 == null) {
                    item4 = null;
                }
                updateRegistration(1, (h) item4);
            } else {
                item4 = null;
            }
            if ((j & 6536) != 0) {
                item = items != null ? items.get(1) : null;
                updateRegistration(7, (h) item);
                if (item == null) {
                    item = null;
                }
                updateRegistration(8, (h) item);
            } else {
                item = null;
            }
            if ((j & 7240) != 0) {
                item5 = items != null ? items.get(3) : null;
                updateRegistration(10, (h) item5);
                if (item5 == null) {
                    item5 = null;
                }
                updateRegistration(6, (h) item5);
            } else {
                item5 = null;
            }
        } else {
            item5 = null;
            context = null;
            item4 = null;
            item3 = null;
            item2 = null;
            item = null;
        }
        if ((4096 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback82);
            this.mboundView2.setOnClickListener(this.mCallback83);
            this.mboundView3.setOnClickListener(this.mCallback84);
            this.mboundView4.setOnClickListener(this.mCallback85);
            this.mboundView5.setOnClickListener(this.mCallback86);
        }
        if ((j & 6668) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.mboundView1, item2, 0, false, context);
        }
        if ((j & 6536) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.mboundView2, item, 0, false, context);
        }
        if ((6186 & j) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.mboundView3, item4, 0, false, context);
        }
        if ((7240 & j) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.mboundView4, item5, 0, false, context);
        }
        if ((j & 6169) != 0) {
            ClickableRVChildViewHolder.setImagePostMeasure(this.mboundView5, item3, 0, false, context);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
            if (cLPItemVHWithoutRV != null) {
                if (view2 != null) {
                    List<Item> items = view2.getItems();
                    if (items == null) {
                        z2 = false;
                    }
                    if (z2) {
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
                    if (items2 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV2.handleDeepLink(items2.get(1), 1);
                    }
                }
            }
        } else if (i2 == 3) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV3 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view4 = this.mView;
            if (cLPItemVHWithoutRV3 != null) {
                if (view4 != null) {
                    List<Item> items3 = view4.getItems();
                    if (items3 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV3.handleDeepLink(items3.get(2), 2);
                    }
                }
            }
        } else if (i2 == 4) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV4 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view5 = this.mView;
            if (cLPItemVHWithoutRV4 != null) {
                if (view5 != null) {
                    List<Item> items4 = view5.getItems();
                    if (items4 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV4.handleDeepLink(items4.get(3), 3);
                    }
                }
            }
        } else if (i2 == 5) {
            CLPItemVHWithoutRV cLPItemVHWithoutRV5 = this.mHandler;
            com.paytmmall.clpartifact.modal.clpCommon.View view6 = this.mView;
            if (cLPItemVHWithoutRV5 != null) {
                if (view6 != null) {
                    List<Item> items5 = view6.getItems();
                    if (items5 != null) {
                        z = true;
                    }
                    if (z) {
                        cLPItemVHWithoutRV5.handleDeepLink(items5.get(4), 4);
                    }
                }
            }
        }
    }
}
