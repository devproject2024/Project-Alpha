package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.CommunityModel;
import dagger.a;

public final class CreatePostPresenter_MembersInjector implements a<CreatePostPresenter> {
    private final javax.a.a<CommunityModel> communityModelProvider;

    public CreatePostPresenter_MembersInjector(javax.a.a<CommunityModel> aVar) {
        this.communityModelProvider = aVar;
    }

    public static a<CreatePostPresenter> create(javax.a.a<CommunityModel> aVar) {
        return new CreatePostPresenter_MembersInjector(aVar);
    }

    public final void injectMembers(CreatePostPresenter createPostPresenter) {
        injectCommunityModel(createPostPresenter, this.communityModelProvider.get());
    }

    public static void injectCommunityModel(CreatePostPresenter createPostPresenter, CommunityModel communityModel) {
        createPostPresenter.communityModel = communityModel;
    }
}
