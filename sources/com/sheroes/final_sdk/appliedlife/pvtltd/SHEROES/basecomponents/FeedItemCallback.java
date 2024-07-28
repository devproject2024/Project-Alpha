package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.view.View;
import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.ImageSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;

public interface FeedItemCallback extends BaseHolderInterface {
    void onAskQuestionClicked();

    void onCommentMenuClicked(UserPostSolrObj userPostSolrObj, TextView textView);

    void onCommunityJoinOrLeave(CommunityFeedSolrObj communityFeedSolrObj);

    void onImagePostClicked(ImageSolrObj imageSolrObj);

    void onLikesCountClicked(UserPostSolrObj userPostSolrObj);

    void onPostMenuClicked(UserPostSolrObj userPostSolrObj, View view);

    void onPostShared(FeedDetail feedDetail);

    void onSeeMoreClicked(CarouselDataObj carouselDataObj);

    void onSpamPostApprove(UserPostSolrObj userPostSolrObj);

    void onSpamPostDelete(UserPostSolrObj userPostSolrObj);

    void onUserPostClicked(UserPostSolrObj userPostSolrObj);

    void onUserPostCommentClicked(UserPostSolrObj userPostSolrObj);

    void onUserPostImageClicked(UserPostSolrObj userPostSolrObj);

    void onUserPostLiked(UserPostSolrObj userPostSolrObj);

    void onUserPostUnLiked(UserPostSolrObj userPostSolrObj);

    void userCommentLikeRequest(UserPostSolrObj userPostSolrObj, boolean z, int i2);
}
