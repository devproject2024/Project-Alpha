package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.view.fragment.WriteAReviewBottomSheet;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public class FragmentReviewBindingImpl extends FragmentReviewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback59;
    private final View.OnClickListener mCallback60;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 4);
        sViewsWithIds.put(R.id.comment, 5);
    }

    public FragmentReviewBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentReviewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[1], objArr[5], objArr[4], objArr[2]);
        this.mDirtyFlags = -1;
        this.closeButton.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView3 = objArr[3];
        this.mboundView3.setTag((Object) null);
        this.rating.setTag((Object) null);
        setRootTag(view);
        this.mCallback59 = new OnClickListener(this, 1);
        this.mCallback60 = new OnClickListener(this, 2);
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
        if (BR.fragment == i2) {
            setFragment((WriteAReviewBottomSheet) obj);
        } else if (BR.ratingModel == i2) {
            setRatingModel((CJRRatingReview) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((StoreRatingViewModel) obj);
        }
        return true;
    }

    public void setFragment(WriteAReviewBottomSheet writeAReviewBottomSheet) {
        this.mFragment = writeAReviewBottomSheet;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.fragment);
        super.requestRebind();
    }

    public void setRatingModel(CJRRatingReview cJRRatingReview) {
        this.mRatingModel = cJRRatingReview;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.ratingModel);
        super.requestRebind();
    }

    public void setViewModel(StoreRatingViewModel storeRatingViewModel) {
        this.mViewModel = storeRatingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeViewModelRatingValue((ObservableDouble) obj, i3);
    }

    private boolean onChangeViewModelRatingValue(ObservableDouble observableDouble, int i2) {
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
        ObservableDouble observableDouble = null;
        double d2 = 0.0d;
        StoreRatingViewModel storeRatingViewModel = this.mViewModel;
        int i2 = ((25 & j) > 0 ? 1 : ((25 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (storeRatingViewModel != null) {
                observableDouble = storeRatingViewModel.getRatingValue();
            }
            updateRegistration(0, (h) observableDouble);
            if (observableDouble != null) {
                d2 = observableDouble.get();
            }
        }
        if ((j & 16) != 0) {
            this.closeButton.setOnClickListener(this.mCallback59);
            this.mboundView3.setOnClickListener(this.mCallback60);
        }
        if (i2 != 0) {
            RatingVHViewModel.setRating(this.rating, Double.valueOf(d2));
        }
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            WriteAReviewBottomSheet writeAReviewBottomSheet = this.mFragment;
            if (writeAReviewBottomSheet != null) {
                z = true;
            }
            if (z) {
                writeAReviewBottomSheet.dismiss();
            }
        } else if (i2 == 2) {
            CJRRatingReview cJRRatingReview = this.mRatingModel;
            StoreRatingViewModel storeRatingViewModel = this.mViewModel;
            if (storeRatingViewModel != null) {
                z = true;
            }
            if (z && this.comment != null) {
                this.comment.getText();
                if (this.comment.getText() != null) {
                    this.comment.getText();
                    storeRatingViewModel.submitReview(this.rating, this.comment.getText().toString(), cJRRatingReview, this.closeButton);
                }
            }
        }
    }
}
