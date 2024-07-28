package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import java.util.List;

public interface IFeedView extends BaseMvpView {
    void addAllFeed(List<FeedDetail> list);

    void hideGifLoader();

    void invalidateCommunityJoin(CommunityFeedSolrObj communityFeedSolrObj);

    void invalidateCommunityLeft(CommunityFeedSolrObj communityFeedSolrObj);

    void invalidateItem(FeedDetail feedDetail);

    void notifyAllItemRemoved(FeedDetail feedDetail);

    void removeItem(FeedDetail feedDetail);

    void setData(int i2, FeedDetail feedDetail);

    void setFeedEnded(boolean z);

    void showFeedList(List<FeedDetail> list);

    void showGifLoader();

    void updateFeedConfigDataToMixpanel(FeedResponsePojo feedResponsePojo);
}
