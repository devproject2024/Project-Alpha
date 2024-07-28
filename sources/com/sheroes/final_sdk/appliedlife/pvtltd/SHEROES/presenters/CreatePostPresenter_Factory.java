package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.CommunityModel;
import dagger.a.c;
import javax.a.a;

public final class CreatePostPresenter_Factory implements c<CreatePostPresenter> {
    private final a<CommunityModel> communityModelProvider;

    public CreatePostPresenter_Factory(a<CommunityModel> aVar) {
        this.communityModelProvider = aVar;
    }

    public final CreatePostPresenter get() {
        return provideInstance(this.communityModelProvider);
    }

    public static CreatePostPresenter provideInstance(a<CommunityModel> aVar) {
        CreatePostPresenter createPostPresenter = new CreatePostPresenter();
        CreatePostPresenter_MembersInjector.injectCommunityModel(createPostPresenter, aVar.get());
        return createPostPresenter;
    }

    public static CreatePostPresenter_Factory create(a<CommunityModel> aVar) {
        return new CreatePostPresenter_Factory(aVar);
    }

    public static CreatePostPresenter newCreatePostPresenter() {
        return new CreatePostPresenter();
    }
}
