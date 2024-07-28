package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.MyCommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostResponse;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.i.a;

public class HomeModel {
    f gson;
    private final SheroesAppServiceApi sheroesAppServiceApi;

    public HomeModel(SheroesAppServiceApi sheroesAppServiceApi2, f fVar) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.gson = fVar;
    }

    public p<FeedResponsePojo> getCommunityFeedFromModel(CommunityFeedRequestPojo communityFeedRequestPojo, String str) {
        return this.sheroesAppServiceApi.getCommunityFeed(str, communityFeedRequestPojo).map(new h<FeedResponsePojo, FeedResponsePojo>() {
            public FeedResponsePojo apply(FeedResponsePojo feedResponsePojo) {
                return feedResponsePojo;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<AllCommunitiesResponse> getAllCommunityFromModel(MyCommunityRequest myCommunityRequest) {
        return this.sheroesAppServiceApi.getAllCommunityFromApi(myCommunityRequest).map(new h<AllCommunitiesResponse, AllCommunitiesResponse>() {
            public AllCommunitiesResponse apply(AllCommunitiesResponse allCommunitiesResponse) {
                return allCommunitiesResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<DeleteCommunityPostResponse> deleteCommunityPostFromModel(DeleteCommunityPostRequest deleteCommunityPostRequest) {
        return this.sheroesAppServiceApi.getCommunityPostDeleteResponse(deleteCommunityPostRequest).map(new h<DeleteCommunityPostResponse, DeleteCommunityPostResponse>() {
            public DeleteCommunityPostResponse apply(DeleteCommunityPostResponse deleteCommunityPostResponse) {
                return deleteCommunityPostResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<ApproveSpamPostResponse> getSpamPostApproveFromModel(ApproveSpamPostRequest approveSpamPostRequest) {
        return this.sheroesAppServiceApi.spamPostApprove(approveSpamPostRequest).map(new h<ApproveSpamPostResponse, ApproveSpamPostResponse>() {
            public ApproveSpamPostResponse apply(ApproveSpamPostResponse approveSpamPostResponse) {
                return approveSpamPostResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<ConfigurationResponse> getConfig() {
        return this.sheroesAppServiceApi.getConfig().map(new h<ConfigurationResponse, ConfigurationResponse>() {
            public ConfigurationResponse apply(ConfigurationResponse configurationResponse) {
                return configurationResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
