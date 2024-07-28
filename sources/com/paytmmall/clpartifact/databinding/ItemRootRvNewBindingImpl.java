package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
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
import com.paytmmall.clpartifact.view.viewbindings.CommonViewBindings;
import com.paytmmall.clpartifact.view.viewbindings.RecoWidgetViewBindings;

public class ItemRootRvNewBindingImpl extends ItemRootRvNewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback17;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_background, 5);
        sViewsWithIds.put(R.id.view_top_layout, 6);
        sViewsWithIds.put(R.id.barrier1, 7);
        sViewsWithIds.put(R.id.marginView1, 8);
        sViewsWithIds.put(R.id.background, 9);
        sViewsWithIds.put(R.id.iv_flash_image, 10);
        sViewsWithIds.put(R.id.tv_ends_in, 11);
        sViewsWithIds.put(R.id.timer_view, 12);
        sViewsWithIds.put(R.id.super_layout, 13);
        sViewsWithIds.put(R.id.color_background, 14);
        sViewsWithIds.put(R.id.rvThinBanner, 15);
        sViewsWithIds.put(R.id.img_bg, 16);
    }

    public ItemRootRvNewBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, sIncludes, sViewsWithIds));
    }

    private ItemRootRvNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[9], objArr[4], objArr[7], objArr[0], objArr[14], objArr[16], objArr[10], objArr[5], objArr[8], objArr[3], objArr[15], objArr[13], objArr[12], objArr[11], objArr[2], objArr[1], objArr[6]);
        this.mDirtyFlags = -1;
        this.backgroundImage.setTag((Object) null);
        this.clParent.setTag((Object) null);
        this.marginView2.setTag((Object) null);
        this.viewAll.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
        this.mCallback17 = new OnClickListener(this, 1);
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
        Context context2;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        CLPItemVHWithRV cLPItemVHWithRV = this.mHandler;
        Boolean bool = this.mTitle;
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
                context2 = null;
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
            CommonViewBindings.setTitleItemMargin(this.marginView2, view, cLPItemVHWithRV);
        }
        if ((64 & j) != 0) {
            this.viewAll.setOnClickListener(this.mCallback17);
        }
        if ((j & 97) != 0) {
            d.a((TextView) this.viewName, (CharSequence) str2);
        }
        if ((65 & j) != 0) {
            RecoWidgetViewBindings.setTitleColor(this.viewName, view);
            RecoWidgetViewBindings.setTitleSize(this.viewName, view);
        }
        if ((j & 72) != 0) {
            this.viewName.setVisibility(i3);
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
