package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.customViews.InfiniteGridCustomRecyclerview;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public class RatingReviewFragmentBindingImpl extends RatingReviewFragmentBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final InfiniteGridCustomRecyclerview mboundView1;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public RatingReviewFragmentBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, sIncludes, sViewsWithIds));
    }

    private RatingReviewFragmentBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (BR.model == i2) {
            setModel((StoreRatingViewModel) obj);
        } else if (BR.adapter != i2) {
            return false;
        } else {
            setAdapter((StoreRatingAdapter) obj);
        }
        return true;
    }

    public void setModel(StoreRatingViewModel storeRatingViewModel) {
        this.mModel = storeRatingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void setAdapter(StoreRatingAdapter storeRatingAdapter) {
        this.mAdapter = storeRatingAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        StoreRatingViewModel storeRatingViewModel = this.mModel;
        StoreRatingAdapter storeRatingAdapter = this.mAdapter;
        if ((6 & j) != 0) {
            StoreRatingViewModel.bindRecyclerViewAdapter((RecyclerView) this.mboundView1, (RecyclerView.a<?>) storeRatingAdapter);
        }
        if ((j & 5) != 0) {
            StoreRatingViewModel.bindRecyclerViewAdapter((RecyclerView) this.mboundView1, storeRatingViewModel);
        }
    }
}
