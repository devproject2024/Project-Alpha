package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class FeedPresenter_MembersInjector implements a<FeedPresenter> {
    private final javax.a.a<Preference<AllCommunitiesResponse>> mAllCommunitiesProvider;
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;

    public FeedPresenter_MembersInjector(javax.a.a<Preference<AllCommunitiesResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2) {
        this.mAllCommunitiesProvider = aVar;
        this.mConfigurationProvider = aVar2;
    }

    public static a<FeedPresenter> create(javax.a.a<Preference<AllCommunitiesResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2) {
        return new FeedPresenter_MembersInjector(aVar, aVar2);
    }

    public final void injectMembers(FeedPresenter feedPresenter) {
        injectMAllCommunities(feedPresenter, this.mAllCommunitiesProvider.get());
        injectMConfiguration(feedPresenter, this.mConfigurationProvider.get());
    }

    public static void injectMAllCommunities(FeedPresenter feedPresenter, Preference<AllCommunitiesResponse> preference) {
        feedPresenter.mAllCommunities = preference;
    }

    public static void injectMConfiguration(FeedPresenter feedPresenter, Preference<Configuration> preference) {
        feedPresenter.mConfiguration = preference;
    }
}
