package com.paytmmall.clpartifact.databinding;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconHeaderV2RootVH;

public class ItemSmartIconHeaderV2RootBindingImpl extends ItemSmartIconHeaderV2RootBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback79;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLayoutGroup, 5);
        sViewsWithIds.put(R.id.reco_rv, 6);
        sViewsWithIds.put(R.id.smartIconsV2Rv, 7);
        sViewsWithIds.put(R.id.footerView, 8);
    }

    public ItemSmartIconHeaderV2RootBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemSmartIconHeaderV2RootBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[8], objArr[1], objArr[0], objArr[6], objArr[7], objArr[3], objArr[2], objArr[5]);
        this.mDirtyFlags = -1;
        this.bannerImage.setTag((Object) null);
        this.imageLogo.setTag((Object) null);
        this.mainLayout.setTag((Object) null);
        this.subtitle.setTag((Object) null);
        this.title.setTag((Object) null);
        setRootTag(view);
        this.mCallback79 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
            setHandler((SmartIconHeaderV2RootVH) obj);
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

    public void setHandler(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH) {
        this.mHandler = smartIconHeaderV2RootVH;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setTitle(Boolean bool) {
        this.mTitle = bool;
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
        int i2;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        SmartIconHeaderV2RootVH smartIconHeaderV2RootVH = this.mHandler;
        Context context2 = null;
        int i3 = ((37 & j) > 0 ? 1 : ((37 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            int i4 = R.drawable.ic_paytm_logo;
            updateRegistration(0, (h) view);
            str2 = ((j & 33) == 0 || view == null) ? null : view.getSubtitle();
            String imageUrl = view != null ? view.getImageUrl() : null;
            if (smartIconHeaderV2RootVH != null) {
                context2 = smartIconHeaderV2RootVH.getContext();
            }
            str = imageUrl;
            i2 = i4;
            context = context2;
        } else {
            str2 = null;
            str = null;
            context = null;
            i2 = 0;
        }
        if ((32 & j) != 0) {
            this.bannerImage.setOnClickListener(this.mCallback79);
        }
        if (i3 != 0) {
            ClickableRVChildViewHolder.setImageUrl(this.imageLogo, str, 0, false, false, i2, context);
        }
        if ((j & 33) != 0) {
            d.a(this.subtitle, (CharSequence) str2);
            d.a(this.title, (CharSequence) str2);
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        SmartIconHeaderV2RootVH smartIconHeaderV2RootVH = this.mHandler;
        if (smartIconHeaderV2RootVH != null) {
            smartIconHeaderV2RootVH.handleBannerClick();
        }
    }
}
