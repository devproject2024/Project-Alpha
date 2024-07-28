package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BasePresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.ConfigurationResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityTopPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CreateCommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.MemberListResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.RemoveMemberRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.MyCommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IFeedView;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.g.c;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedPresenter extends BasePresenter<IFeedView> {
    private static final int END_REQUEST = 2;
    public static final int LOAD_MORE_REQUEST = 1;
    public static final int NORMAL_REQUEST = 0;
    Preference<AllCommunitiesResponse> mAllCommunities;
    Preference<Configuration> mConfiguration;
    private String mEndpointUrl;
    /* access modifiers changed from: private */
    public List<FeedDetail> mFeedDetailList = new ArrayList();
    /* access modifiers changed from: private */
    public int mFeedState;
    HomeModel mHomeModel;
    /* access modifiers changed from: private */
    public boolean mIsFeedLoading;
    /* access modifiers changed from: private */
    public boolean mIsHomeFeed;
    /* access modifiers changed from: private */
    public String mNextToken = "";
    Context mSheroesApplication;
    SheroesAppServiceApi sheroesAppServiceApi;

    public FeedPresenter(HomeModel homeModel, Context context, Preference<LoginResponse> preference, SheroesAppServiceApi sheroesAppServiceApi2, Preference<Configuration> preference2) {
        this.mHomeModel = homeModel;
        this.mSheroesApplication = context;
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.mConfiguration = preference2;
    }

    public void detachView() {
        super.detachView();
    }

    public boolean isViewAttached() {
        return super.isViewAttached();
    }

    public void fetchFeed(int i2) {
        if (!this.mIsFeedLoading) {
            if (!(i2 == 1 && this.mFeedState == 2)) {
                this.mFeedState = i2;
            }
            int i3 = this.mFeedState;
            if (i3 == 0) {
                this.mNextToken = null;
                if (this.mIsHomeFeed && CommonUtil.isEmpty(this.mFeedDetailList)) {
                    ArrayList arrayList = new ArrayList();
                    FeedDetail feedDetail = new FeedDetail();
                    feedDetail.setSubType("HEADER");
                    arrayList.add(0, feedDetail);
                    ((IFeedView) getMvpView()).showFeedList(arrayList);
                }
            } else if (i3 != 1 && i3 == 2) {
                ((IFeedView) getMvpView()).startProgressBar();
                return;
            }
            this.mIsFeedLoading = true;
            CommunityFeedRequestPojo communityFeedRequestPojo = new CommunityFeedRequestPojo();
            communityFeedRequestPojo.setNextToken(this.mNextToken);
            if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
                ((IFeedView) getMvpView()).stopProgressBar();
                ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_FEED_RESPONSE);
                this.mIsFeedLoading = false;
                return;
            }
            this.mHomeModel.getCommunityFeedFromModel(communityFeedRequestPojo, this.mEndpointUrl).compose(bindToLifecycle()).subscribe(new c<FeedResponsePojo>() {
                public void onComplete() {
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                }

                public void onError(Throwable th) {
                    boolean unused = FeedPresenter.this.mIsFeedLoading = false;
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                    ((IFeedView) FeedPresenter.this.getMvpView()).showFeedList(FeedPresenter.this.mFeedDetailList);
                }

                public void onNext(FeedResponsePojo feedResponsePojo) {
                    boolean unused = FeedPresenter.this.mIsFeedLoading = false;
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                    ((IFeedView) FeedPresenter.this.getMvpView()).hideGifLoader();
                    if (feedResponsePojo.getStatus().equalsIgnoreCase("SUCCESS")) {
                        List<FeedDetail> feedDetails = feedResponsePojo.getFeedDetails();
                        String unused2 = FeedPresenter.this.mNextToken = feedResponsePojo.getNextToken();
                        int access$300 = FeedPresenter.this.mFeedState;
                        if (access$300 == 0) {
                            ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                            if (FeedPresenter.this.mIsHomeFeed) {
                                FeedDetail feedDetail = new FeedDetail();
                                feedDetail.setSubType("HEADER");
                                feedDetails.add(0, feedDetail);
                            }
                            List unused3 = FeedPresenter.this.mFeedDetailList = feedDetails;
                            ((IFeedView) FeedPresenter.this.getMvpView()).setFeedEnded(false);
                            ((IFeedView) FeedPresenter.this.getMvpView()).showFeedList(new ArrayList(FeedPresenter.this.mFeedDetailList));
                            ((IFeedView) FeedPresenter.this.getMvpView()).updateFeedConfigDataToMixpanel(feedResponsePojo);
                        } else if (access$300 == 1) {
                            if (!CommonUtil.isEmpty(feedDetails)) {
                                FeedPresenter.this.mFeedDetailList.addAll(feedDetails);
                                ((IFeedView) FeedPresenter.this.getMvpView()).addAllFeed(feedDetails);
                                return;
                            }
                            ((IFeedView) FeedPresenter.this.getMvpView()).setFeedEnded(true);
                        }
                    } else {
                        if (feedResponsePojo.getStatus().equals("FAILED")) {
                            ((IFeedView) FeedPresenter.this.getMvpView()).setFeedEnded(true);
                        } else if (!CommonUtil.isEmpty(FeedPresenter.this.mFeedDetailList) && FeedPresenter.this.mFeedDetailList.size() < 5) {
                            ((IFeedView) FeedPresenter.this.getMvpView()).setFeedEnded(true);
                        }
                        ((IFeedView) FeedPresenter.this.getMvpView()).showFeedList(FeedPresenter.this.mFeedDetailList);
                    }
                }
            });
        }
    }

    public boolean isFeedLoading() {
        return this.mIsFeedLoading;
    }

    public void getAllCommunities(MyCommunityRequest myCommunityRequest) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_MY_COMMUNITIES);
        } else {
            this.mHomeModel.getAllCommunityFromModel(myCommunityRequest).compose(bindToLifecycle()).subscribe(new c<AllCommunitiesResponse>() {
                public void onComplete() {
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                }

                public void onError(Throwable th) {
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                    ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_MY_COMMUNITIES);
                }

                public void onNext(AllCommunitiesResponse allCommunitiesResponse) {
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                    if (allCommunitiesResponse != null) {
                        FeedPresenter.this.mAllCommunities.set(allCommunitiesResponse);
                    }
                }
            });
        }
    }

    public void deleteCommunityPostFromPresenter(DeleteCommunityPostRequest deleteCommunityPostRequest, final UserPostSolrObj userPostSolrObj) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_FEED_RESPONSE);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        this.mHomeModel.deleteCommunityPostFromModel(deleteCommunityPostRequest).compose(bindToLifecycle()).subscribe(new c<DeleteCommunityPostResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_FEED_RESPONSE);
            }

            public void onNext(DeleteCommunityPostResponse deleteCommunityPostResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).notifyAllItemRemoved(userPostSolrObj);
            }
        });
    }

    public void getSpamPostApproveFromPresenter(final ApproveSpamPostRequest approveSpamPostRequest, final UserPostSolrObj userPostSolrObj) {
        ((IFeedView) getMvpView()).startProgressBar();
        this.mHomeModel.getSpamPostApproveFromModel(approveSpamPostRequest).compose(bindToLifecycle()).subscribe(new c<ApproveSpamPostResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            }

            public void onNext(ApproveSpamPostResponse approveSpamPostResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                if (approveSpamPostResponse == null) {
                    return;
                }
                if (!approveSpamPostRequest.isApproved() && approveSpamPostRequest.isSpam()) {
                    ((IFeedView) FeedPresenter.this.getMvpView()).removeItem(userPostSolrObj);
                } else if (approveSpamPostRequest.isApproved() && !approveSpamPostRequest.isSpam()) {
                    userPostSolrObj.setSpamPost(false);
                    ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(userPostSolrObj);
                }
            }
        });
    }

    public void getPostLikesFromPresenter(LikeRequestPojo likeRequestPojo, final FeedDetail feedDetail) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            feedDetail.setReactionValue(0);
            feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() - 1);
            ((IFeedView) getMvpView()).invalidateItem(feedDetail);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        getLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                feedDetail.setReactionValue(0);
                FeedDetail feedDetail = feedDetail;
                feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() - 1);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(feedDetail);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus().equals("FAILED")) {
                    feedDetail.setReactionValue(0);
                    FeedDetail feedDetail = feedDetail;
                    feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() - 1);
                    ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(feedDetail);
                }
                AnalyticsManager.trackPostAction(Event.POST_LIKED, feedDetail, FeedFragment.SCREEN_LABEL);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(feedDetail);
            }
        });
    }

    public p<LikeResponse> getLikesFromModel(LikeRequestPojo likeRequestPojo) {
        return this.sheroesAppServiceApi.getLikesFromApi(likeRequestPojo).map(new h<LikeResponse, LikeResponse>() {
            public LikeResponse apply(LikeResponse likeResponse) {
                return likeResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void getPostUnLikesFromPresenter(LikeRequestPojo likeRequestPojo, final FeedDetail feedDetail) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            feedDetail.setReactionValue(10);
            feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() + 1);
            ((IFeedView) getMvpView()).invalidateItem(feedDetail);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        getUnLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                feedDetail.setReactionValue(10);
                FeedDetail feedDetail = feedDetail;
                feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() + 1);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(feedDetail);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    feedDetail.setReactionValue(10);
                    FeedDetail feedDetail = feedDetail;
                    feedDetail.setNoOfLikes(feedDetail.getNoOfLikes() + 1);
                }
                AnalyticsManager.trackPostAction(Event.POST_UNLIKED, feedDetail, FeedFragment.SCREEN_LABEL);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(feedDetail);
            }
        });
    }

    public p<LikeResponse> getUnLikesFromModel(LikeRequestPojo likeRequestPojo) {
        return this.sheroesAppServiceApi.getUnLikesFromApi(likeRequestPojo).map(new h<LikeResponse, LikeResponse>() {
            public LikeResponse apply(LikeResponse likeResponse) {
                return likeResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void getCommentUnLikesFromPresenter(LikeRequestPojo likeRequestPojo, final Comment comment, final UserPostSolrObj userPostSolrObj) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            comment.isLiked = true;
            comment.likeCount++;
            userPostSolrObj.getLastComments().set(0, comment);
            ((IFeedView) getMvpView()).invalidateItem(userPostSolrObj);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        getUnLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                Comment comment = comment;
                comment.isLiked = true;
                comment.likeCount++;
                userPostSolrObj.getLastComments().set(0, comment);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(userPostSolrObj);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    Comment comment = comment;
                    comment.isLiked = true;
                    comment.likeCount++;
                }
                userPostSolrObj.getLastComments().set(0, comment);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(userPostSolrObj);
                HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).positionInList(Integer.valueOf(comment.getItemPosition())).build();
                EventProperty.Builder communityId = new EventProperty.Builder().communityId(comment.getCommunityId());
                UserPostSolrObj userPostSolrObj = userPostSolrObj;
                String str = "";
                EventProperty.Builder communityName = communityId.communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : str);
                UserPostSolrObj userPostSolrObj2 = userPostSolrObj;
                if (userPostSolrObj2 != null && CommonUtil.isNotEmpty(userPostSolrObj2.getStreamType())) {
                    str = userPostSolrObj.getStreamType();
                }
                AnalyticsManager.trackEvent(Event.REPLY_UNLIKED, PostDetailActivity.SCREEN_LABEL, (Map<String, Object>) new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str).build()).build());
            }
        });
    }

    public void getCommentLikesFromPresenter(LikeRequestPojo likeRequestPojo, final Comment comment, final UserPostSolrObj userPostSolrObj) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            comment.isLiked = false;
            comment.likeCount--;
            userPostSolrObj.getLastComments().set(0, comment);
            ((IFeedView) getMvpView()).invalidateItem(userPostSolrObj);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        getLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                Comment comment = comment;
                comment.isLiked = false;
                comment.likeCount--;
                userPostSolrObj.getLastComments().set(0, comment);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(userPostSolrObj);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    Comment comment = comment;
                    comment.isLiked = false;
                    comment.likeCount--;
                    userPostSolrObj.getLastComments().set(0, comment);
                }
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(userPostSolrObj);
                HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).positionInList(Integer.valueOf(comment.getItemPosition())).build();
                EventProperty.Builder communityId = new EventProperty.Builder().communityId(comment.getCommunityId());
                UserPostSolrObj userPostSolrObj = userPostSolrObj;
                String str = "";
                EventProperty.Builder communityName = communityId.communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : str);
                UserPostSolrObj userPostSolrObj2 = userPostSolrObj;
                if (userPostSolrObj2 != null && CommonUtil.isNotEmpty(userPostSolrObj2.getStreamType())) {
                    str = userPostSolrObj.getStreamType();
                }
                AnalyticsManager.trackEvent(Event.REPLY_LIKED, PostDetailActivity.SCREEN_LABEL, (Map<String, Object>) new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str).build()).build());
            }
        });
    }

    public void editTopPost(CommunityTopPostRequest communityTopPostRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMUNITY_OWNER);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        editPostCommunity(communityTopPostRequest).compose(bindToLifecycle()).subscribe(new c<CreateCommunityResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onNext(CreateCommunityResponse createCommunityResponse) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateItem(createCommunityResponse.getFeedDetail());
            }
        });
    }

    public p<CreateCommunityResponse> editPostCommunity(CommunityTopPostRequest communityTopPostRequest) {
        return this.sheroesAppServiceApi.topPostCommunityPost(communityTopPostRequest).map(new h<CreateCommunityResponse, CreateCommunityResponse>() {
            public CreateCommunityResponse apply(CreateCommunityResponse createCommunityResponse) {
                return createCommunityResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void onStop() {
        detachView();
    }

    public void setEndpointUrl(String str) {
        this.mEndpointUrl = str;
    }

    public void setIsHomeFeed(boolean z) {
        this.mIsHomeFeed = z;
    }

    public void joinCommunity(CommunityRequest communityRequest, final CommunityFeedSolrObj communityFeedSolrObj) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_JOIN_INVITE);
            communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() - 1);
            communityFeedSolrObj.setMember(false);
            ((IFeedView) getMvpView()).invalidateCommunityJoin(communityFeedSolrObj);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        this.sheroesAppServiceApi.getCommunityJoinResponse(communityRequest).map(new h<CommunityResponse, CommunityResponse>() {
            public CommunityResponse apply(CommunityResponse communityResponse) {
                return communityResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).compose(bindToLifecycle()).subscribe(new c<CommunityResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_JOIN_INVITE);
                CommunityFeedSolrObj communityFeedSolrObj = communityFeedSolrObj;
                communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() - 1);
                communityFeedSolrObj.setMember(false);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateCommunityJoin(communityFeedSolrObj);
            }

            public void onNext(CommunityResponse communityResponse) {
                if (communityResponse.getStatus().equalsIgnoreCase("FAILED")) {
                    CommunityFeedSolrObj communityFeedSolrObj = communityFeedSolrObj;
                    communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() - 1);
                    communityFeedSolrObj.setMember(false);
                }
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateCommunityJoin(communityFeedSolrObj);
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }
        });
    }

    public void leaveCommunity(RemoveMemberRequest removeMemberRequest, final CommunityFeedSolrObj communityFeedSolrObj) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_JOIN_INVITE);
            communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() + 1);
            communityFeedSolrObj.setMember(true);
            ((IFeedView) getMvpView()).invalidateCommunityJoin(communityFeedSolrObj);
            return;
        }
        ((IFeedView) getMvpView()).startProgressBar();
        this.sheroesAppServiceApi.removeMember(removeMemberRequest).map(new h<MemberListResponse, MemberListResponse>() {
            public MemberListResponse apply(MemberListResponse memberListResponse) {
                return memberListResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).compose(bindToLifecycle()).subscribe(new c<MemberListResponse>() {
            public void onComplete() {
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IFeedView) FeedPresenter.this.getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_JOIN_INVITE);
                CommunityFeedSolrObj communityFeedSolrObj = communityFeedSolrObj;
                communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() + 1);
                communityFeedSolrObj.setMember(true);
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateCommunityJoin(communityFeedSolrObj);
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onNext(MemberListResponse memberListResponse) {
                if (memberListResponse.getStatus().equalsIgnoreCase("FAILED")) {
                    ((IFeedView) FeedPresenter.this.getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_JOIN_INVITE);
                    CommunityFeedSolrObj communityFeedSolrObj = communityFeedSolrObj;
                    communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() + 1);
                    communityFeedSolrObj.setMember(true);
                }
                ((IFeedView) FeedPresenter.this.getMvpView()).invalidateCommunityLeft(communityFeedSolrObj);
                ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
            }
        });
    }

    public void queryConfig() {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IFeedView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_MEMBER);
        } else {
            this.mHomeModel.getConfig().compose(bindToLifecycle()).subscribe(new c<ConfigurationResponse>() {
                public void onComplete() {
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                }

                public void onError(Throwable th) {
                    ((IFeedView) FeedPresenter.this.getMvpView()).showError(FeedPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_MEMBER);
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                }

                public void onNext(ConfigurationResponse configurationResponse) {
                    if (!(configurationResponse == null || !configurationResponse.status.equalsIgnoreCase("SUCCESS") || configurationResponse.configuration == null)) {
                        FeedPresenter.this.mConfiguration.set(configurationResponse.configuration);
                        if (configurationResponse.configuration.configData != null && CommonUtil.isNotEmpty(configurationResponse.configuration.configData.thumborKey)) {
                            SharedPreferences.Editor edit = SheroesSdk.getAppSharedPrefs().edit();
                            edit.putString(AppConstants.THUMBOR_KEY, configurationResponse.configuration.configData.thumborKey);
                            edit.apply();
                        }
                    }
                    ((IFeedView) FeedPresenter.this.getMvpView()).stopProgressBar();
                }
            });
        }
    }
}
