package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public class ParentStandardRvBindingImpl extends ParentStandardRvBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rvThinBanner, 1);
    }

    public ParentStandardRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private ParentStandardRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.clParent.setTag((Object) null);
        setRootTag(view);
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
        this.mView = view;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public void setHandler(CLPItemVHWithRV cLPItemVHWithRV) {
        this.mHandler = cLPItemVHWithRV;
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
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
