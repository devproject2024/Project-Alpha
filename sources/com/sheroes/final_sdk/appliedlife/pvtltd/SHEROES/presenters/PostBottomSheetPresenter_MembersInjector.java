package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class PostBottomSheetPresenter_MembersInjector implements a<PostBottomSheetPresenter> {
    private final javax.a.a<Preference<AllCommunitiesResponse>> mAllCommunitiesProvider;
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<Preference<LoginResponse>> mUserPreferenceProvider;

    public PostBottomSheetPresenter_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<AllCommunitiesResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        this.mUserPreferenceProvider = aVar;
        this.mAllCommunitiesProvider = aVar2;
        this.mConfigurationProvider = aVar3;
    }

    public static a<PostBottomSheetPresenter> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<AllCommunitiesResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        return new PostBottomSheetPresenter_MembersInjector(aVar, aVar2, aVar3);
    }

    public final void injectMembers(PostBottomSheetPresenter postBottomSheetPresenter) {
        injectMUserPreference(postBottomSheetPresenter, this.mUserPreferenceProvider.get());
        injectMAllCommunities(postBottomSheetPresenter, this.mAllCommunitiesProvider.get());
        injectMConfiguration(postBottomSheetPresenter, this.mConfigurationProvider.get());
    }

    public static void injectMUserPreference(PostBottomSheetPresenter postBottomSheetPresenter, Preference<LoginResponse> preference) {
        postBottomSheetPresenter.mUserPreference = preference;
    }

    public static void injectMAllCommunities(PostBottomSheetPresenter postBottomSheetPresenter, Preference<AllCommunitiesResponse> preference) {
        postBottomSheetPresenter.mAllCommunities = preference;
    }

    public static void injectMConfiguration(PostBottomSheetPresenter postBottomSheetPresenter, Preference<Configuration> preference) {
        postBottomSheetPresenter.mConfiguration = preference;
    }
}
