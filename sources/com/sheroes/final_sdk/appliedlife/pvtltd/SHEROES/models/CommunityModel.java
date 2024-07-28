package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityPostCreateRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CreateCommunityResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.i.a;

public class CommunityModel {
    f gson;
    private final SheroesAppServiceApi sheroesAppServiceApi;

    public CommunityModel(SheroesAppServiceApi sheroesAppServiceApi2, f fVar) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.gson = fVar;
    }

    public p<LinkRenderResponse> linkRenderFromModel(LinkRequest linkRequest) {
        return this.sheroesAppServiceApi.linkRenderApi(linkRequest).map(new h<LinkRenderResponse, LinkRenderResponse>() {
            public LinkRenderResponse apply(LinkRenderResponse linkRenderResponse) {
                return linkRenderResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<CreateCommunityResponse> addPostCommunity(CommunityPostCreateRequest communityPostCreateRequest) {
        return this.sheroesAppServiceApi.createCommunityPost(communityPostCreateRequest).map(new h<CreateCommunityResponse, CreateCommunityResponse>() {
            public CreateCommunityResponse apply(CreateCommunityResponse createCommunityResponse) {
                return createCommunityResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }

    public p<CreateCommunityResponse> editPostCommunity(CommunityPostCreateRequest communityPostCreateRequest) {
        return this.sheroesAppServiceApi.editCommunityPost(communityPostCreateRequest).map(new h<CreateCommunityResponse, CreateCommunityResponse>() {
            public CreateCommunityResponse apply(CreateCommunityResponse createCommunityResponse) {
                return createCommunityResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
