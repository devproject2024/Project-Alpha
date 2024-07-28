package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a.c;
import javax.a.a;

public final class PostBottomSheetPresenter_Factory implements c<PostBottomSheetPresenter> {
    private final a<HomeModel> homeModelProvider;
    private final a<Preference<AllCommunitiesResponse>> mAllCommunitiesProvider;
    private final a<Preference<Configuration>> mConfigurationProvider;
    private final a<Preference<LoginResponse>> mUserPreferenceAndUserPreferenceProvider;
    private final a<Context> sheroesApplicationProvider;

    public PostBottomSheetPresenter_Factory(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<Preference<Configuration>> aVar4, a<Preference<AllCommunitiesResponse>> aVar5) {
        this.homeModelProvider = aVar;
        this.sheroesApplicationProvider = aVar2;
        this.mUserPreferenceAndUserPreferenceProvider = aVar3;
        this.mConfigurationProvider = aVar4;
        this.mAllCommunitiesProvider = aVar5;
    }

    public final PostBottomSheetPresenter get() {
        return provideInstance(this.homeModelProvider, this.sheroesApplicationProvider, this.mUserPreferenceAndUserPreferenceProvider, this.mConfigurationProvider, this.mAllCommunitiesProvider);
    }

    public static PostBottomSheetPresenter provideInstance(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<Preference<Configuration>> aVar4, a<Preference<AllCommunitiesResponse>> aVar5) {
        PostBottomSheetPresenter postBottomSheetPresenter = new PostBottomSheetPresenter(aVar.get(), aVar2.get(), aVar3.get(), aVar4.get());
        PostBottomSheetPresenter_MembersInjector.injectMUserPreference(postBottomSheetPresenter, aVar3.get());
        PostBottomSheetPresenter_MembersInjector.injectMAllCommunities(postBottomSheetPresenter, aVar5.get());
        PostBottomSheetPresenter_MembersInjector.injectMConfiguration(postBottomSheetPresenter, aVar4.get());
        return postBottomSheetPresenter;
    }

    public static PostBottomSheetPresenter_Factory create(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<Preference<Configuration>> aVar4, a<Preference<AllCommunitiesResponse>> aVar5) {
        return new PostBottomSheetPresenter_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static PostBottomSheetPresenter newPostBottomSheetPresenter(HomeModel homeModel, Context context, Preference<LoginResponse> preference, Preference<Configuration> preference2) {
        return new PostBottomSheetPresenter(homeModel, context, preference, preference2);
    }
}
