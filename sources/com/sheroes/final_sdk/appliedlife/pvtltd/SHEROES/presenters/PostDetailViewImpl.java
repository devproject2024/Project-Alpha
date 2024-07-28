package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BasePresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentAddDelete;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityTopPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CreateCommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IPostDetailView;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.g.c;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDetailViewImpl extends BasePresenter<IPostDetailView> {
    /* access modifiers changed from: private */
    public int headerCount = 0;
    private Comment lastComment;
    AppUtils mAppUtils;
    /* access modifiers changed from: private */
    public List<BaseResponse> mBaseResponseList;
    private String mUserPostId;
    /* access modifiers changed from: private */
    public UserPostSolrObj mUserPostObj;
    /* access modifiers changed from: private */
    public int pageNumber = 1;
    SheroesAppServiceApi sheroesAppServiceApi;

    static /* synthetic */ int access$008(PostDetailViewImpl postDetailViewImpl) {
        int i2 = postDetailViewImpl.pageNumber;
        postDetailViewImpl.pageNumber = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$208(PostDetailViewImpl postDetailViewImpl) {
        int i2 = postDetailViewImpl.headerCount;
        postDetailViewImpl.headerCount = i2 + 1;
        return i2;
    }

    public PostDetailViewImpl(SheroesAppServiceApi sheroesAppServiceApi2, Context context) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.mBaseResponseList = new ArrayList();
    }

    public void setUserPost(UserPostSolrObj userPostSolrObj, String str) {
        this.mUserPostObj = userPostSolrObj;
        this.mUserPostId = str;
    }

    public void fetchUserPost() {
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        if (userPostSolrObj == null) {
            fetchUserPostFromServer();
            return;
        }
        this.mBaseResponseList.add(userPostSolrObj);
        ((IPostDetailView) getMvpView()).addData(0, this.mUserPostObj);
        this.headerCount++;
        ((IPostDetailView) getMvpView()).startProgressBar();
        getAllCommentFromPresenter(AppUtils.getCommentRequestBuilder(this.mUserPostObj.getEntityOrParticipantId(), this.pageNumber));
    }

    private void fetchUserPostFromServer() {
        FeedRequestPojo userCommunityDetailRequestBuilder = this.mAppUtils.userCommunityDetailRequestBuilder(AppConstants.FEED_COMMUNITY_POST, 1, Long.valueOf(this.mUserPostId).longValue());
        userCommunityDetailRequestBuilder.setPageSize(10);
        getFeedFromPresenter(userCommunityDetailRequestBuilder);
    }

    public void fetchMoreComments() {
        ((IPostDetailView) getMvpView()).commentStartedLoading();
        getAllCommentFromPresenter(AppUtils.getCommentRequestBuilder(this.mUserPostObj.getEntityOrParticipantId(), this.pageNumber));
    }

    public void getAllCommentFromPresenter(CommentReactionRequestPojo commentReactionRequestPojo) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMENT_REACTION);
            ((IPostDetailView) getMvpView()).hideProgressBar();
            return;
        }
        getAllCommentListFromModel(commentReactionRequestPojo).compose(bindToLifecycle()).subscribe(new c<CommentReactionResponsePojo>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_SERVER_PROBLEM), FeedParticipationEnum.ERROR_COMMENT_REACTION);
            }

            public void onNext(CommentReactionResponsePojo commentReactionResponsePojo) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).commentFinishedLoading();
                boolean z = true;
                if (PostDetailViewImpl.this.pageNumber == 1 && commentReactionResponsePojo.getNumFound() > 25) {
                    BaseResponse baseResponse = new BaseResponse();
                    PostDetailViewImpl.this.mBaseResponseList.add(baseResponse);
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).addData(baseResponse);
                    PostDetailViewImpl.access$208(PostDetailViewImpl.this);
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setHasMoreComments(true);
                }
                Collections.reverse(commentReactionResponsePojo.getCommentList());
                PostDetailViewImpl.this.mBaseResponseList.addAll(PostDetailViewImpl.this.headerCount, commentReactionResponsePojo.getCommentList());
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).addAllPost(PostDetailViewImpl.this.headerCount, commentReactionResponsePojo.getCommentList());
                if (PostDetailViewImpl.this.pageNumber != 1) {
                    if (commentReactionResponsePojo.getCommentList().size() < 25) {
                        PostDetailViewImpl.this.mBaseResponseList.remove(1);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setHasMoreComments(false);
                    }
                    z = false;
                } else {
                    if (PostDetailViewImpl.this.mUserPostObj.getIsEditOrDelete() == 1) {
                        PostDetailViewImpl.this.mUserPostObj.setIsEditOrDelete(0);
                        PostDetailViewImpl.this.mBaseResponseList.set(0, PostDetailViewImpl.this.mUserPostObj);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).editLastComment();
                    }
                    if (PostDetailViewImpl.this.mUserPostObj.getIsEditOrDelete() == 2) {
                        PostDetailViewImpl.this.mUserPostObj.setIsEditOrDelete(0);
                        PostDetailViewImpl.this.mBaseResponseList.set(0, PostDetailViewImpl.this.mUserPostObj);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).deleteLastComment();
                    }
                }
                if (z) {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).smoothScrollToBottom();
                }
                PostDetailViewImpl.access$008(PostDetailViewImpl.this);
            }
        });
    }

    public void editTopPost(CommunityTopPostRequest communityTopPostRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMUNITY_OWNER);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        editPostCommunity(communityTopPostRequest).compose(bindToLifecycle()).subscribe(new c<CreateCommunityResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_CREATE_COMMUNITY);
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onNext(CreateCommunityResponse createCommunityResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, createCommunityResponse.getFeedDetail());
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

    public void getFeedFromPresenter(FeedRequestPojo feedRequestPojo) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_FEED_RESPONSE);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        getFeedFromModel(feedRequestPojo).compose(bindToLifecycle()).subscribe(new c<FeedResponsePojo>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_FEED_RESPONSE);
            }

            public void onNext(FeedResponsePojo feedResponsePojo) {
                if (feedResponsePojo != null && !CommonUtil.isEmpty(feedResponsePojo.getFeedDetails())) {
                    UserPostSolrObj unused = PostDetailViewImpl.this.mUserPostObj = (UserPostSolrObj) feedResponsePojo.getFeedDetails().get(0);
                    if (CommonUtil.isNotEmpty(((IPostDetailView) PostDetailViewImpl.this.getMvpView()).getStreamType())) {
                        PostDetailViewImpl.this.mUserPostObj.setStreamType(((IPostDetailView) PostDetailViewImpl.this.getMvpView()).getStreamType());
                    }
                    PostDetailViewImpl.this.mBaseResponseList.add(PostDetailViewImpl.this.mUserPostObj);
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).addData(0, PostDetailViewImpl.this.mUserPostObj);
                    PostDetailViewImpl.access$208(PostDetailViewImpl.this);
                    PostDetailViewImpl postDetailViewImpl = PostDetailViewImpl.this;
                    postDetailViewImpl.getAllCommentFromPresenter(AppUtils.getCommentRequestBuilder(postDetailViewImpl.mUserPostObj.getEntityOrParticipantId(), PostDetailViewImpl.this.pageNumber));
                }
            }
        });
    }

    public p<FeedResponsePojo> getFeedFromModel(FeedRequestPojo feedRequestPojo) {
        return this.sheroesAppServiceApi.getFeedFromApi(feedRequestPojo).map(new h<FeedResponsePojo, FeedResponsePojo>() {
            public FeedResponsePojo apply(FeedResponsePojo feedResponsePojo) {
                return feedResponsePojo;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    private p<CommentReactionResponsePojo> getAllCommentListFromModel(CommentReactionRequestPojo commentReactionRequestPojo) {
        return this.sheroesAppServiceApi.getCommentFromApi(commentReactionRequestPojo).map(new h<CommentReactionResponsePojo, CommentReactionResponsePojo>() {
            public CommentReactionResponsePojo apply(CommentReactionResponsePojo commentReactionResponsePojo) {
                return commentReactionResponsePojo;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void addComment(String str, boolean z) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMENT_REACTION);
        } else {
            addCommentListFromModel(AppUtils.postCommentRequestBuilder(this.mUserPostObj.getEntityOrParticipantId(), str, z)).compose(bindToLifecycle()).subscribe(new c<CommentAddDelete>() {
                public void onComplete() {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                }

                public void onError(Throwable th) {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_UNABLE_TO_COMMENT), FeedParticipationEnum.ERROR_COMMENT_REACTION);
                }

                public void onNext(CommentAddDelete commentAddDelete) {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                    if (commentAddDelete != null) {
                        Comment commentReactionModel = commentAddDelete.getCommentReactionModel();
                        PostDetailViewImpl.this.mBaseResponseList.add(commentReactionModel);
                        PostDetailViewImpl.this.mUserPostObj.setNoOfComments(PostDetailViewImpl.this.mUserPostObj.getNoOfComments() + 1);
                        PostDetailViewImpl.this.mBaseResponseList.set(0, PostDetailViewImpl.this.mUserPostObj);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, PostDetailViewImpl.this.mUserPostObj);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).addData(commentReactionModel);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).smoothScrollToBottom();
                        HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) commentAddDelete.getCommentReactionModel().getId())).title(commentAddDelete.getCommentReactionModel().getComment()).positionInList(Integer.valueOf(PostDetailViewImpl.this.mUserPostObj != null ? PostDetailViewImpl.this.mUserPostObj.getNoOfComments() : -1)).build();
                        String str = "";
                        EventProperty.Builder communityName = new EventProperty.Builder().communityId(commentAddDelete.getCommentReactionModel().getCommunityId()).communityName(PostDetailViewImpl.this.mUserPostObj != null ? PostDetailViewImpl.this.mUserPostObj.getPostCommunityName() : str);
                        if (CommonUtil.isNotEmpty(PostDetailViewImpl.this.mUserPostObj.getStreamType())) {
                            str = PostDetailViewImpl.this.mUserPostObj.getStreamType();
                        }
                        AnalyticsManager.trackEvent(Event.REPLY_CREATED, PostDetailActivity.SCREEN_LABEL, (Map<String, Object>) new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str).build()).build());
                    }
                }
            });
        }
    }

    public p<CommentAddDelete> addCommentListFromModel(CommentReactionRequestPojo commentReactionRequestPojo) {
        return this.sheroesAppServiceApi.addCommentFromApi(commentReactionRequestPojo).map(new h<CommentAddDelete, CommentAddDelete>() {
            public CommentAddDelete apply(CommentAddDelete commentAddDelete) {
                return commentAddDelete;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void editCommentListFromPresenter(final CommentReactionRequestPojo commentReactionRequestPojo, int i2) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMENT_REACTION);
        } else {
            editCommentListFromModel(commentReactionRequestPojo).compose(bindToLifecycle()).subscribe(new c<CommentAddDelete>() {
                public void onComplete() {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                }

                public void onError(Throwable th) {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_UNABLE_TO_EDIT_DELETE), FeedParticipationEnum.ERROR_COMMENT_REACTION);
                }

                public void onNext(CommentAddDelete commentAddDelete) {
                    int findCommentPositionById;
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                    if (commentAddDelete.getStatus().equals("SUCCESS") && (findCommentPositionById = PostDetailViewImpl.findCommentPositionById(PostDetailViewImpl.this.mBaseResponseList, commentReactionRequestPojo.getParticipationId())) != -1) {
                        PostDetailViewImpl.this.mBaseResponseList.remove(findCommentPositionById);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).removeData(findCommentPositionById);
                        PostDetailViewImpl.this.mUserPostObj.setNoOfComments(PostDetailViewImpl.this.mUserPostObj.getNoOfComments() - 1);
                        PostDetailViewImpl.this.mBaseResponseList.set(0, PostDetailViewImpl.this.mUserPostObj);
                        ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, PostDetailViewImpl.this.mUserPostObj);
                    }
                }
            });
        }
    }

    public p<CommentAddDelete> editCommentListFromModel(CommentReactionRequestPojo commentReactionRequestPojo) {
        return this.sheroesAppServiceApi.editCommentFromApi(commentReactionRequestPojo).map(new h<CommentAddDelete, CommentAddDelete>() {
            public CommentAddDelete apply(CommentAddDelete commentAddDelete) {
                return commentAddDelete;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public static int findCommentPositionById(List<BaseResponse> list, long j) {
        Comment comment;
        if (CommonUtil.isEmpty(list)) {
            return -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseResponse baseResponse = list.get(i2);
            if ((baseResponse instanceof Comment) && (comment = (Comment) baseResponse) != null && ((long) comment.getId()) == j) {
                return i2;
            }
        }
        return -1;
    }

    public void getCommentUnLikesFromPresenter(LikeRequestPojo likeRequestPojo, final Comment comment) {
        final int findCommentPositionById = findCommentPositionById(this.mBaseResponseList, (long) comment.getId());
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            comment.isLiked = true;
            comment.likeCount++;
            ((IPostDetailView) getMvpView()).setData(findCommentPositionById, comment);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        getUnLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                Comment comment = comment;
                comment.isLiked = true;
                comment.likeCount++;
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(findCommentPositionById, comment);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    Comment comment = comment;
                    comment.isLiked = true;
                    comment.likeCount++;
                }
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(findCommentPositionById, comment);
                HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).positionInList(Integer.valueOf(comment.getItemPosition())).build();
                String str = "";
                EventProperty.Builder communityName = new EventProperty.Builder().communityId(comment.getCommunityId()).communityName(PostDetailViewImpl.this.mUserPostObj != null ? PostDetailViewImpl.this.mUserPostObj.getPostCommunityName() : str);
                if (PostDetailViewImpl.this.mUserPostObj != null && CommonUtil.isNotEmpty(PostDetailViewImpl.this.mUserPostObj.getStreamType())) {
                    str = PostDetailViewImpl.this.mUserPostObj.getStreamType();
                }
                AnalyticsManager.trackEvent(Event.REPLY_UNLIKED, PostDetailActivity.SCREEN_LABEL, (Map<String, Object>) new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str).build()).build());
            }
        });
    }

    public void getCommentLikesFromPresenter(LikeRequestPojo likeRequestPojo, final Comment comment) {
        final int findCommentPositionById = findCommentPositionById(this.mBaseResponseList, (long) comment.getId());
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            comment.isLiked = false;
            comment.likeCount--;
            ((IPostDetailView) getMvpView()).setData(findCommentPositionById, comment);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        getLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                Comment comment = comment;
                comment.isLiked = false;
                comment.likeCount--;
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(findCommentPositionById, comment);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    Comment comment = comment;
                    comment.isLiked = false;
                    comment.likeCount--;
                }
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(findCommentPositionById, comment);
                HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).positionInList(Integer.valueOf(comment.getItemPosition())).build();
                String str = "";
                EventProperty.Builder communityName = new EventProperty.Builder().communityId(comment.getCommunityId()).communityName(PostDetailViewImpl.this.mUserPostObj != null ? PostDetailViewImpl.this.mUserPostObj.getPostCommunityName() : str);
                if (PostDetailViewImpl.this.mUserPostObj != null && CommonUtil.isNotEmpty(PostDetailViewImpl.this.mUserPostObj.getStreamType())) {
                    str = PostDetailViewImpl.this.mUserPostObj.getStreamType();
                }
                AnalyticsManager.trackEvent(Event.REPLY_LIKED, PostDetailActivity.SCREEN_LABEL, (Map<String, Object>) new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str).build()).build());
            }
        });
    }

    public void deleteCommunityPostFromPresenter(DeleteCommunityPostRequest deleteCommunityPostRequest) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_FEED_RESPONSE);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        deleteCommunityPostFromModel(deleteCommunityPostRequest).compose(bindToLifecycle()).subscribe(new c<DeleteCommunityPostResponse>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_FEED_RESPONSE);
            }

            public void onNext(DeleteCommunityPostResponse deleteCommunityPostResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).onPostDeleted();
            }
        });
    }

    public p<DeleteCommunityPostResponse> deleteCommunityPostFromModel(DeleteCommunityPostRequest deleteCommunityPostRequest) {
        return this.sheroesAppServiceApi.getCommunityPostDeleteResponse(deleteCommunityPostRequest).map(new h<DeleteCommunityPostResponse, DeleteCommunityPostResponse>() {
            public DeleteCommunityPostResponse apply(DeleteCommunityPostResponse deleteCommunityPostResponse) {
                return deleteCommunityPostResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void getPostLikesFromPresenter(LikeRequestPojo likeRequestPojo, final UserPostSolrObj userPostSolrObj) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            userPostSolrObj.setReactionValue(0);
            userPostSolrObj.setNoOfLikes(this.mUserPostObj.getNoOfLikes() - 1);
            this.mBaseResponseList.set(0, userPostSolrObj);
            ((IPostDetailView) getMvpView()).setData(0, userPostSolrObj);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        getLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                userPostSolrObj.setReactionValue(0);
                userPostSolrObj.setNoOfLikes(PostDetailViewImpl.this.mUserPostObj.getNoOfLikes() - 1);
                PostDetailViewImpl.this.mBaseResponseList.set(0, userPostSolrObj);
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    userPostSolrObj.setReactionValue(0);
                    userPostSolrObj.setNoOfLikes(PostDetailViewImpl.this.mUserPostObj.getNoOfLikes() - 1);
                    PostDetailViewImpl.this.mBaseResponseList.set(0, userPostSolrObj);
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
                }
                AnalyticsManager.trackPostAction(Event.POST_LIKED, userPostSolrObj, PostDetailActivity.SCREEN_LABEL);
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
            }
        });
    }

    public void getPostUnLikesFromPresenter(LikeRequestPojo likeRequestPojo, final UserPostSolrObj userPostSolrObj) {
        if (!NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            ((IPostDetailView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            userPostSolrObj.setReactionValue(10);
            userPostSolrObj.setNoOfLikes(this.mUserPostObj.getNoOfLikes() + 1);
            this.mBaseResponseList.set(0, userPostSolrObj);
            ((IPostDetailView) getMvpView()).setData(0, userPostSolrObj);
            return;
        }
        ((IPostDetailView) getMvpView()).startProgressBar();
        getUnLikesFromModel(likeRequestPojo).compose(bindToLifecycle()).subscribe(new c<LikeResponse>() {
            public void onComplete() {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
                userPostSolrObj.setReactionValue(10);
                userPostSolrObj.setNoOfLikes(PostDetailViewImpl.this.mUserPostObj.getNoOfLikes() + 1);
                PostDetailViewImpl.this.mBaseResponseList.set(0, userPostSolrObj);
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
            }

            public void onNext(LikeResponse likeResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                if (likeResponse.getStatus() == "FAILED") {
                    userPostSolrObj.setReactionValue(10);
                    userPostSolrObj.setNoOfLikes(PostDetailViewImpl.this.mUserPostObj.getNoOfLikes() + 1);
                    PostDetailViewImpl.this.mBaseResponseList.set(0, userPostSolrObj);
                }
                AnalyticsManager.trackPostAction(Event.POST_UNLIKED, userPostSolrObj, PostDetailActivity.SCREEN_LABEL);
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
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

    public p<LikeResponse> getUnLikesFromModel(LikeRequestPojo likeRequestPojo) {
        return this.sheroesAppServiceApi.getUnLikesFromApi(likeRequestPojo).map(new h<LikeResponse, LikeResponse>() {
            public LikeResponse apply(LikeResponse likeResponse) {
                return likeResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public void getSpamPostApproveFromPresenter(final ApproveSpamPostRequest approveSpamPostRequest, final UserPostSolrObj userPostSolrObj) {
        ((IPostDetailView) getMvpView()).startProgressBar();
        getSpamPostApproveFromModel(approveSpamPostRequest).compose(bindToLifecycle()).subscribe(new c<ApproveSpamPostResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).showError(SheroesSdk.getApplicationContext().getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_LIKE_UNLIKE);
            }

            public void onNext(ApproveSpamPostResponse approveSpamPostResponse) {
                ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).stopProgressBar();
                if (approveSpamPostResponse == null) {
                    return;
                }
                if (!approveSpamPostRequest.isApproved() && approveSpamPostRequest.isSpam()) {
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).onPostDeleted();
                } else if (approveSpamPostRequest.isApproved() && !approveSpamPostRequest.isSpam()) {
                    userPostSolrObj.setSpamPost(false);
                    PostDetailViewImpl.this.mBaseResponseList.set(0, userPostSolrObj);
                    ((IPostDetailView) PostDetailViewImpl.this.getMvpView()).setData(0, userPostSolrObj);
                }
            }
        });
    }

    public p<ApproveSpamPostResponse> getSpamPostApproveFromModel(ApproveSpamPostRequest approveSpamPostRequest) {
        return this.sheroesAppServiceApi.spamPostApprove(approveSpamPostRequest).map(new h<ApproveSpamPostResponse, ApproveSpamPostResponse>() {
            public ApproveSpamPostResponse apply(ApproveSpamPostResponse approveSpamPostResponse) {
                return approveSpamPostResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public UserPostSolrObj getUserPostObj() {
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        if (userPostSolrObj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.mBaseResponseList.isEmpty()) {
            List<BaseResponse> list = this.mBaseResponseList;
            if (list.get(list.size() - 1) instanceof Comment) {
                List<BaseResponse> list2 = this.mBaseResponseList;
                arrayList.add((Comment) list2.get(list2.size() - 1));
            }
        }
        userPostSolrObj.setLastComments(arrayList);
        return userPostSolrObj;
    }

    public void updateUserPost(UserPostSolrObj userPostSolrObj) {
        this.mUserPostObj = userPostSolrObj;
        if (CommonUtil.isNotEmpty(((IPostDetailView) getMvpView()).getStreamType())) {
            this.mUserPostObj.setStreamType(((IPostDetailView) getMvpView()).getStreamType());
        }
        this.mBaseResponseList.set(0, userPostSolrObj);
        ((IPostDetailView) getMvpView()).setData(0, userPostSolrObj);
    }

    public Comment getLastComment() {
        if (!CommonUtil.isEmpty(this.mBaseResponseList)) {
            List<BaseResponse> list = this.mBaseResponseList;
            BaseResponse baseResponse = list.get(list.size() - 1);
            if (baseResponse instanceof Comment) {
                return (Comment) baseResponse;
            }
        }
        return null;
    }
}
