package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import java.util.List;

public class ItemSealTrustBindingImpl extends ItemSealTrustBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback99;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.separator, 4);
    }

    public ItemSealTrustBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemSealTrustBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[4], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.trustSubtitle.setTag((Object) null);
        this.trustTitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback99 = new OnClickListener(this, 1);
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
        Context context;
        int i2;
        String str;
        int i3;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
        int i4 = 0;
        String str4 = null;
        if ((j & 23) != 0) {
            List<Item> items = view != null ? view.getItems() : null;
            Context context2 = cLPItemVHWithoutRV != null ? cLPItemVHWithoutRV.getContext() : null;
            Item item = items != null ? items.get(0) : null;
            updateRegistration(0, (h) item);
            String imageUrl = item != null ? item.getImageUrl() : null;
            int i5 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (item != null) {
                    str4 = item.getItemSubtitle();
                    str3 = item.getTitle();
                } else {
                    str3 = null;
                }
                boolean isEmpty = TextUtils.isEmpty(str4);
                boolean isEmpty2 = TextUtils.isEmpty(str3);
                if (i5 != 0) {
                    j |= isEmpty ? 256 : 128;
                }
                if ((j & 19) != 0) {
                    j |= isEmpty2 ? 64 : 32;
                }
                int i6 = isEmpty ? 8 : 0;
                if (isEmpty2) {
                    i4 = 8;
                }
                context = context2;
                i2 = i4;
                i3 = i6;
                String str5 = imageUrl;
                str = str3;
                str2 = str4;
                str4 = str5;
            } else {
                context = context2;
                str2 = null;
                i3 = 0;
                i2 = 0;
                str4 = imageUrl;
                str = null;
            }
        } else {
            str2 = null;
            str = null;
            context = null;
            i3 = 0;
            i2 = 0;
        }
        if ((16 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback99);
        }
        if ((23 & j) != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.mboundView3, str4, 0, false, false, 0, context);
        }
        if ((j & 19) != 0) {
            this.trustSubtitle.setText(str2);
            this.trustSubtitle.setVisibility(i3);
            d.a(this.trustTitle, (CharSequence) str);
            this.trustTitle.setVisibility(i2);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemVHWithoutRV cLPItemVHWithoutRV = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        boolean z = true;
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
    }
}
