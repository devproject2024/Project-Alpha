package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BasePresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.CommunityModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityPostCreateRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CreateCommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.ICommunityPostView;
import io.reactivex.rxjava3.g.c;

public class CreatePostPresenter extends BasePresenter<ICommunityPostView> {
    CommunityModel communityModel;

    public void sendPost(CommunityPostCreateRequest communityPostCreateRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((ICommunityPostView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMUNITY_OWNER);
            return;
        }
        ((ICommunityPostView) getMvpView()).startProgressBar();
        this.communityModel.addPostCommunity(communityPostCreateRequest).compose(bindToLifecycle()).subscribe(new c<CreateCommunityResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onNext(CreateCommunityResponse createCommunityResponse) {
                if (createCommunityResponse.getStatus().equalsIgnoreCase("SUCCESS")) {
                    ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).onPostSend(createCommunityResponse.getFeedDetail());
                    AnalyticsManager.trackPostAction(Event.POST_CREATED, createCommunityResponse.getFeedDetail(), CommunityPostActivity.SCREEN_LABEL);
                    return;
                }
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
            }
        });
    }

    public void fetchLinkDetails(LinkRequest linkRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((ICommunityPostView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMUNITY_OWNER);
            return;
        }
        ((ICommunityPostView) getMvpView()).startProgressBar();
        this.communityModel.linkRenderFromModel(linkRequest).compose(bindToLifecycle()).subscribe(new c<LinkRenderResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onNext(LinkRenderResponse linkRenderResponse) {
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).linkRenderResponse(linkRenderResponse);
            }
        });
    }

    public void editPost(CommunityPostCreateRequest communityPostCreateRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((ICommunityPostView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMUNITY_OWNER);
            return;
        }
        ((ICommunityPostView) getMvpView()).startProgressBar();
        this.communityModel.editPostCommunity(communityPostCreateRequest).compose(bindToLifecycle()).subscribe(new c<CreateCommunityResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onNext(CreateCommunityResponse createCommunityResponse) {
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).stopProgressBar();
                ((ICommunityPostView) CreatePostPresenter.this.getMvpView()).onPostSend(createCommunityResponse.getFeedDetail());
                AnalyticsManager.trackPostAction(Event.POST_EDITED, createCommunityResponse.getFeedDetail(), CommunityPostActivity.SCREEN_LABEL);
            }
        });
    }
}
