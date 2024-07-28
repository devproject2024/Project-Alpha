package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a.c;
import javax.a.a;

public final class FeedPresenter_Factory implements c<FeedPresenter> {
    private final a<Context> contextProvider;
    private final a<HomeModel> homeModelProvider;
    private final a<Preference<AllCommunitiesResponse>> mAllCommunitiesProvider;
    private final a<Preference<Configuration>> mConfigurationAndConfigurationProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;
    private final a<Preference<LoginResponse>> userPreferenceProvider;

    public FeedPresenter_Factory(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<SheroesAppServiceApi> aVar4, a<Preference<Configuration>> aVar5, a<Preference<AllCommunitiesResponse>> aVar6) {
        this.homeModelProvider = aVar;
        this.contextProvider = aVar2;
        this.userPreferenceProvider = aVar3;
        this.sheroesAppServiceApiProvider = aVar4;
        this.mConfigurationAndConfigurationProvider = aVar5;
        this.mAllCommunitiesProvider = aVar6;
    }

    public final FeedPresenter get() {
        return provideInstance(this.homeModelProvider, this.contextProvider, this.userPreferenceProvider, this.sheroesAppServiceApiProvider, this.mConfigurationAndConfigurationProvider, this.mAllCommunitiesProvider);
    }

    public static FeedPresenter provideInstance(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<SheroesAppServiceApi> aVar4, a<Preference<Configuration>> aVar5, a<Preference<AllCommunitiesResponse>> aVar6) {
        FeedPresenter feedPresenter = new FeedPresenter(aVar.get(), aVar2.get(), aVar3.get(), aVar4.get(), aVar5.get());
        FeedPresenter_MembersInjector.injectMAllCommunities(feedPresenter, aVar6.get());
        FeedPresenter_MembersInjector.injectMConfiguration(feedPresenter, aVar5.get());
        return feedPresenter;
    }

    public static FeedPresenter_Factory create(a<HomeModel> aVar, a<Context> aVar2, a<Preference<LoginResponse>> aVar3, a<SheroesAppServiceApi> aVar4, a<Preference<Configuration>> aVar5, a<Preference<AllCommunitiesResponse>> aVar6) {
        return new FeedPresenter_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static FeedPresenter newFeedPresenter(HomeModel homeModel, Context context, Preference<LoginResponse> preference, SheroesAppServiceApi sheroesAppServiceApi, Preference<Configuration> preference2) {
        return new FeedPresenter(homeModel, context, preference, sheroesAppServiceApi, preference2);
    }
}
