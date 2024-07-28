package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.ConfigurationResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.BranchData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentAddDelete;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityPostCreateRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityTopPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CreateCommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.MemberListResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.RemoveMemberRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.MyCommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.PaytmLoginRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostResponse;
import io.reactivex.rxjava3.a.p;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface SheroesAppServiceApi {
    @POST("participation/reaction/add_comment")
    p<CommentAddDelete> addCommentFromApi(@Body CommentReactionRequestPojo commentReactionRequestPojo);

    @POST("participation/post/add")
    p<CreateCommunityResponse> createCommunityPost(@Body CommunityPostCreateRequest communityPostCreateRequest);

    @POST("participation/reaction/edit_comment")
    p<CommentAddDelete> editCommentFromApi(@Body CommentReactionRequestPojo commentReactionRequestPojo);

    @POST("participation/post/edit")
    p<CreateCommunityResponse> editCommunityPost(@Body CommunityPostCreateRequest communityPostCreateRequest);

    @GET("https://api.branch.io/v1/url")
    p<BranchData> fetchBranchData(@Query("url") String str, @Query("branch_key") String str2);

    @POST("participant/feed/all_communities")
    p<AllCommunitiesResponse> getAllCommunityFromApi(@Body MyCommunityRequest myCommunityRequest);

    @POST("participation/reaction/get_reactions")
    p<CommentReactionResponsePojo> getAllReactionFromApi(@Body CommentReactionRequestPojo commentReactionRequestPojo);

    @POST("participation/reaction/get_comments")
    p<CommentReactionResponsePojo> getCommentFromApi(@Body CommentReactionRequestPojo commentReactionRequestPojo);

    @POST
    p<FeedResponsePojo> getCommunityFeed(@Url String str, @Body CommunityFeedRequestPojo communityFeedRequestPojo);

    @POST("participant/community/join")
    p<CommunityResponse> getCommunityJoinResponse(@Body CommunityRequest communityRequest);

    @POST("participation/post/delete")
    p<DeleteCommunityPostResponse> getCommunityPostDeleteResponse(@Body DeleteCommunityPostRequest deleteCommunityPostRequest);

    @GET("participant/remote_config/?config_type=PaytmAppConfig")
    p<ConfigurationResponse> getConfig();

    @POST("participant/feed/")
    p<FeedResponsePojo> getFeedFromApi(@Body FeedRequestPojo feedRequestPojo);

    @POST("participation/reaction/like")
    p<LikeResponse> getLikesFromApi(@Body LikeRequestPojo likeRequestPojo);

    @POST("participant/user/paytmsignup")
    p<LoginResponse> getLoginAuthToken(@Body PaytmLoginRequest paytmLoginRequest);

    @POST("participation/reaction/unlike")
    p<LikeResponse> getUnLikesFromApi(@Body LikeRequestPojo likeRequestPojo);

    @POST("participation/link/render")
    p<LinkRenderResponse> linkRenderApi(@Body LinkRequest linkRequest);

    @POST("participant/community/unjoin")
    p<MemberListResponse> removeMember(@Body RemoveMemberRequest removeMemberRequest);

    @POST("participant/user/update_user_device")
    p<AppInstallation> saveInstallation(@Body AppInstallation appInstallation);

    @POST("participation/post/approve_or_delete")
    p<ApproveSpamPostResponse> spamPostApprove(@Body ApproveSpamPostRequest approveSpamPostRequest);

    @POST("participation/post/edit")
    p<CreateCommunityResponse> topPostCommunityPost(@Body CommunityTopPostRequest communityTopPostRequest);
}
