package com.paytmmall.clpartifact.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;

public class ClpItemChartBindingImpl extends ClpItemChartBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.star_icon, 4);
    }

    public ClpItemChartBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    private ClpItemChartBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[2], objArr[3], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.progressBar.setTag((Object) null);
        this.ratingTotal.setTag((Object) null);
        this.startNumber.setTag((Object) null);
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
        if (BR.ratingTotal == i2) {
            setRatingTotal((String) obj);
        } else if (BR.starNumber == i2) {
            setStarNumber((String) obj);
        } else if (BR.ratingData == i2) {
            setRatingData((Integer) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((RatingVHViewModel) obj);
        }
        return true;
    }

    public void setRatingTotal(String str) {
        this.mRatingTotal = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ratingTotal);
        super.requestRebind();
    }

    public void setStarNumber(String str) {
        this.mStarNumber = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.starNumber);
        super.requestRebind();
    }

    public void setRatingData(Integer num) {
        this.mRatingData = num;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.ratingData);
        super.requestRebind();
    }

    public void setViewModel(RatingVHViewModel ratingVHViewModel) {
        updateRegistration(0, (h) ratingVHViewModel);
        this.mViewModel = ratingVHViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeViewModel((RatingVHViewModel) obj, i3);
    }

    private boolean onChangeViewModel(RatingVHViewModel ratingVHViewModel, int i2) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mRatingTotal;
        String str2 = this.mStarNumber;
        Integer num = this.mRatingData;
        int i2 = 0;
        Drawable drawable = null;
        RatingVHViewModel ratingVHViewModel = this.mViewModel;
        int i3 = ((21 & j) > 0 ? 1 : ((21 & j) == 0 ? 0 : -1));
        if (!(i3 == 0 || ratingVHViewModel == null)) {
            drawable = ratingVHViewModel.getDrawable(this.progressBar, str2);
        }
        int i4 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            i2 = ViewDataBinding.safeUnbox(num);
        }
        if (i3 != 0) {
            this.progressBar.setProgressDrawable(drawable);
        }
        if (i4 != 0) {
            this.progressBar.setProgress(i2);
        }
        if ((18 & j) != 0) {
            d.a(this.ratingTotal, (CharSequence) str);
        }
        if ((j & 20) != 0) {
            d.a(this.startNumber, (CharSequence) str2);
        }
    }
}
