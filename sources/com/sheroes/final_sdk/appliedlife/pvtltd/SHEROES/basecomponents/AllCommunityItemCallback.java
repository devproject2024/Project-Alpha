package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CarouselViewHolder;

public interface AllCommunityItemCallback extends BaseHolderInterface {
    void joinRequestForOpenCommunity(CommunityFeedSolrObj communityFeedSolrObj, CarouselViewHolder carouselViewHolder);

    void onSeeMoreClicked(CarouselDataObj carouselDataObj);

    void unJoinCommunity(CommunityFeedSolrObj communityFeedSolrObj, CarouselViewHolder carouselViewHolder);
}
