package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.UserPostCompactViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.AlbumActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CollectionActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.LikeListBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.PostBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.ShareBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CarouselViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommentNewViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedCommunityPostHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedProgressBarHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.HomeHeaderViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.ImageViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.UserPostHolder;

public interface SheroesAppComponent {
    void inject(AppInstallation appInstallation);

    void inject(AppInstallationHelper appInstallationHelper);

    void inject(LoginHelper loginHelper);

    void inject(CreatePostPresenter createPostPresenter);

    void inject(UserPostCompactViewHolder userPostCompactViewHolder);

    void inject(AlbumActivity albumActivity);

    void inject(BranchDeepLink branchDeepLink);

    void inject(CollectionActivity collectionActivity);

    void inject(CommunityPostActivity communityPostActivity);

    void inject(PostDetailActivity postDetailActivity);

    void inject(FeedFragment feedFragment);

    void inject(LikeListBottomSheetFragment likeListBottomSheetFragment);

    void inject(PostBottomSheetFragment postBottomSheetFragment);

    void inject(ShareBottomSheetFragment shareBottomSheetFragment);

    void inject(CarouselViewHolder carouselViewHolder);

    void inject(CommentNewViewHolder commentNewViewHolder);

    void inject(FeedCommunityPostHolder feedCommunityPostHolder);

    void inject(FeedProgressBarHolder feedProgressBarHolder);

    void inject(HomeHeaderViewHolder homeHeaderViewHolder);

    void inject(ImageViewHolder imageViewHolder);

    void inject(UserPostHolder userPostHolder);
}
