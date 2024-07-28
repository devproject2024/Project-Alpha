package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;

public class ItemFullWidthRootRvBindingImpl extends ItemFullWidthRootRvBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback6;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.flash_sale_container, 5);
        sViewsWithIds.put(R.id.timer_view, 6);
        sViewsWithIds.put(R.id.color_background, 7);
        sViewsWithIds.put(R.id.rvThinBanner, 8);
    }

    public ItemFullWidthRootRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemFullWidthRootRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[7], objArr[5], objArr[1], objArr[8], objArr[6], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.backgroundImage.setTag((Object) null);
        this.lytTitle.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.viewAll.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
        this.mCallback6 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        } else if (BR.layoutManager == i2) {
            setLayoutManager((RecyclerView.LayoutManager) obj);
        } else if (BR.handler == i2) {
            setHandler((CLPItemVHWithRV) obj);
        } else if (BR.title == i2) {
            setTitle((Boolean) obj);
        } else if (BR.adapter != i2) {
            return false;
        } else {
            setAdapter((CLPItemRVAdapter) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(0, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public void setHandler(CLPItemVHWithRV cLPItemVHWithRV) {
        this.mHandler = cLPItemVHWithRV;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setTitle(Boolean bool) {
        this.mTitle = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 != BR.title) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
    }

    public void executeBindings() {
        long j;
        String str;
        String str2;
        Context context;
        int i2;
        int i3;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        Boolean bool = this.mTitle;
        Context context2 = null;
        if ((101 & j) != 0) {
            str2 = ((j & 97) == 0 || view == null) ? null : view.getTitle();
            str = ((j & 69) == 0 || view == null) ? null : view.getImageUrl();
        } else {
            str2 = null;
            str = null;
        }
        int i4 = 0;
        int i5 = ((j & 69) > 0 ? 1 : ((j & 69) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (cLPItemVHWithRV != null) {
                z = cLPItemVHWithRV.shouldShowBackgroundImage(view);
                context2 = cLPItemVHWithRV.getContext();
            } else {
                z = false;
            }
            if (i5 != 0) {
                j |= z ? 256 : 128;
            }
            i2 = z ? 0 : 8;
            context = context2;
        } else {
            context = null;
            i2 = 0;
        }
        int i6 = ((j & 72) > 0 ? 1 : ((j & 72) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i6 != 0) {
                j |= safeUnbox ? 1024 : 512;
            }
            if (!safeUnbox) {
                i4 = 8;
            }
            i3 = i4;
        } else {
            i3 = 0;
        }
        if ((69 & j) != 0) {
            this.backgroundImage.setVisibility(i2);
            ClickableRVChildViewHolder.setImageUrl(this.backgroundImage, str, 12, false, false, 0, context);
        }
        if ((j & 72) != 0) {
            this.lytTitle.setVisibility(i3);
            this.viewName.setVisibility(i3);
        }
        if ((64 & j) != 0) {
            this.viewAll.setOnClickListener(this.mCallback6);
        }
        if ((j & 97) != 0) {
            d.a((TextView) this.viewName, (CharSequence) str2);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        com.paytmmall.clpartifact.modal.clpCommon.View view2 = this.mView;
        if (cLPItemVHWithRV != null) {
            cLPItemVHWithRV.handleViewAllClick(view2);
        }
    }
}
