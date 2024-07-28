package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.InstallUpdateForMoEngage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import dagger.a;

public final class FeedCommunityPostHolder_MembersInjector implements a<FeedCommunityPostHolder> {
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<DateUtil> mDateUtilProvider;
    private final javax.a.a<Preference<InstallUpdateForMoEngage>> mInstallUpdatePreferenceProvider;
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public FeedCommunityPostHolder_MembersInjector(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3, javax.a.a<Preference<InstallUpdateForMoEngage>> aVar4) {
        this.mDateUtilProvider = aVar;
        this.userPreferenceProvider = aVar2;
        this.mConfigurationProvider = aVar3;
        this.mInstallUpdatePreferenceProvider = aVar4;
    }

    public static a<FeedCommunityPostHolder> create(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3, javax.a.a<Preference<InstallUpdateForMoEngage>> aVar4) {
        return new FeedCommunityPostHolder_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public final void injectMembers(FeedCommunityPostHolder feedCommunityPostHolder) {
        injectMDateUtil(feedCommunityPostHolder, this.mDateUtilProvider.get());
        injectUserPreference(feedCommunityPostHolder, this.userPreferenceProvider.get());
        injectMConfiguration(feedCommunityPostHolder, this.mConfigurationProvider.get());
        injectMInstallUpdatePreference(feedCommunityPostHolder, this.mInstallUpdatePreferenceProvider.get());
    }

    public static void injectMDateUtil(FeedCommunityPostHolder feedCommunityPostHolder, DateUtil dateUtil) {
        feedCommunityPostHolder.mDateUtil = dateUtil;
    }

    public static void injectUserPreference(FeedCommunityPostHolder feedCommunityPostHolder, Preference<LoginResponse> preference) {
        feedCommunityPostHolder.userPreference = preference;
    }

    public static void injectMConfiguration(FeedCommunityPostHolder feedCommunityPostHolder, Preference<Configuration> preference) {
        feedCommunityPostHolder.mConfiguration = preference;
    }

    public static void injectMInstallUpdatePreference(FeedCommunityPostHolder feedCommunityPostHolder, Preference<InstallUpdateForMoEngage> preference) {
        feedCommunityPostHolder.mInstallUpdatePreference = preference;
    }
}
