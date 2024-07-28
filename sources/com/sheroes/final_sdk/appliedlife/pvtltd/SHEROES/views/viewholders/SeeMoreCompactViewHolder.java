package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.AllCommunityItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;

public class SeeMoreCompactViewHolder extends RecyclerView.v {
    private CarouselDataObj mCarouselDataObj;
    private final BaseHolderInterface viewInterface;

    public void bindData() {
    }

    public SeeMoreCompactViewHolder(View view, BaseHolderInterface baseHolderInterface, CarouselDataObj carouselDataObj) {
        super(view);
        ((FloatingActionButton) this.itemView.findViewById(R.id.sheroes_more_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SeeMoreCompactViewHolder.this.showMoreClicked();
            }
        });
        this.viewInterface = baseHolderInterface;
        this.mCarouselDataObj = carouselDataObj;
    }

    /* access modifiers changed from: private */
    public void showMoreClicked() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof AllCommunityItemCallback) {
            ((AllCommunityItemCallback) baseHolderInterface).onSeeMoreClicked(this.mCarouselDataObj);
        }
        BaseHolderInterface baseHolderInterface2 = this.viewInterface;
        if (baseHolderInterface2 instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface2).onSeeMoreClicked(this.mCarouselDataObj);
        }
    }
}
