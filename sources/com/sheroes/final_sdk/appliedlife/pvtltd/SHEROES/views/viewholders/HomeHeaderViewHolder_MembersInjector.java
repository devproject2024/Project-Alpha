package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class HomeHeaderViewHolder_MembersInjector implements a<HomeHeaderViewHolder> {
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public HomeHeaderViewHolder_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2) {
        this.userPreferenceProvider = aVar;
        this.mConfigurationProvider = aVar2;
    }

    public static a<HomeHeaderViewHolder> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2) {
        return new HomeHeaderViewHolder_MembersInjector(aVar, aVar2);
    }

    public final void injectMembers(HomeHeaderViewHolder homeHeaderViewHolder) {
        injectUserPreference(homeHeaderViewHolder, this.userPreferenceProvider.get());
        injectMConfiguration(homeHeaderViewHolder, this.mConfigurationProvider.get());
    }

    public static void injectUserPreference(HomeHeaderViewHolder homeHeaderViewHolder, Preference<LoginResponse> preference) {
        homeHeaderViewHolder.userPreference = preference;
    }

    public static void injectMConfiguration(HomeHeaderViewHolder homeHeaderViewHolder, Preference<Configuration> preference) {
        homeHeaderViewHolder.mConfiguration = preference;
    }
}
