package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviews;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.view.viewHolder.BaseRatingViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.DummyViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.NoRatingVH;
import com.paytmmall.clpartifact.view.viewHolder.RatingVH;
import com.paytmmall.clpartifact.view.viewHolder.ReviewVH;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;
import java.util.List;

public class StoreRatingAdapter extends RecyclerView.a<BaseRatingViewHolder> {
    private List<IRatingReviewModel> reviews;
    private StoreRatingViewModel storeRatingViewModel;

    public StoreRatingAdapter(StoreRatingViewModel storeRatingViewModel2) {
        this.storeRatingViewModel = storeRatingViewModel2;
    }

    public BaseRatingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return getViewHolder(i2, f.a(LayoutInflater.from(viewGroup.getContext()), getLayout(i2), viewGroup, false));
    }

    private int getLayout(int i2) {
        if (i2 == 100) {
            return RatingVH.getLayout();
        }
        if (i2 == 101) {
            return ReviewVH.getLayout();
        }
        if (i2 != 105) {
            return NoRatingVH.getLayout();
        }
        return DummyViewHolder.getLayout();
    }

    private BaseRatingViewHolder getViewHolder(int i2, ViewDataBinding viewDataBinding) {
        if (i2 == 100) {
            return new RatingVH(viewDataBinding, this);
        }
        if (i2 == 101) {
            return new ReviewVH(viewDataBinding, this);
        }
        if (i2 != 105) {
            return new NoRatingVH(viewDataBinding, this);
        }
        return new DummyViewHolder(viewDataBinding);
    }

    public void onBindViewHolder(BaseRatingViewHolder baseRatingViewHolder, int i2) {
        IRatingReviewModel iRatingReviewModel = this.reviews.get(i2);
        if (iRatingReviewModel instanceof CJRReviews) {
            iRatingReviewModel.setLastItem(i2 == getItemCount() + -2);
        }
        baseRatingViewHolder.bind(iRatingReviewModel);
    }

    public int getItemViewType(int i2) {
        return this.reviews.get(i2).getViewType();
    }

    public int getItemCount() {
        List<IRatingReviewModel> list = this.reviews;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void updateList(List<IRatingReviewModel> list) {
        this.reviews = list;
        notifyDataSetChanged();
    }

    public void redirect(RedirectorModel redirectorModel, IRatingReviewModel iRatingReviewModel) {
        if (redirectorModel != null) {
            if (redirectorModel.getRequest() == 1001) {
                this.storeRatingViewModel.openReviewScreen((CJRRatingReview) iRatingReviewModel);
            } else if (redirectorModel.getRequest() == 1002) {
                this.storeRatingViewModel.hitAPIForRatingReview((CJRRatingReview) iRatingReviewModel, redirectorModel);
            } else if (redirectorModel.getRequest() == 1003) {
                this.storeRatingViewModel.reportReview(redirectorModel);
            }
        }
    }

    public ObservableDouble getStoreRating() {
        return this.storeRatingViewModel.getRatingValue();
    }
}
