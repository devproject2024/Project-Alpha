package com.paytmmall.clpartifact.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;

public class OptimizeLytRootRvBindingImpl extends OptimizeLytRootRvBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public OptimizeLytRootRvBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    private OptimizeLytRootRvBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[0], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.clParent.setTag((Object) null);
        this.rvThinBanner.setTag((Object) null);
        this.viewName.setTag((Object) null);
        setRootTag(view);
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
        } else if (BR.layoutManager == i2) {
            setLayoutManager((RecyclerView.LayoutManager) obj);
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
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.layoutManager);
        super.requestRebind();
    }

    public void setAdapter(CLPItemRVAdapter cLPItemRVAdapter) {
        this.mAdapter = cLPItemRVAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
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
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        com.paytmmall.clpartifact.modal.clpCommon.View view = this.mView;
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        String str = null;
        CLPItemRVAdapter cLPItemRVAdapter = this.mAdapter;
        int i2 = 0;
        int i3 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (view != null) {
                str = view.getTitle();
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i3 != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if (isEmpty) {
                i2 = 8;
            }
        }
        if ((20 & j) != 0) {
            this.rvThinBanner.setAdapter(cLPItemRVAdapter);
        }
        if ((18 & j) != 0) {
            this.rvThinBanner.setLayoutManager(layoutManager);
        }
        if ((j & 25) != 0) {
            d.a((TextView) this.viewName, (CharSequence) str);
            this.viewName.setVisibility(i2);
        }
    }
}
