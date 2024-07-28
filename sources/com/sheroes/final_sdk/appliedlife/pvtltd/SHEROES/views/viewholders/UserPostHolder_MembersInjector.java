package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import dagger.a;

public final class UserPostHolder_MembersInjector implements a<UserPostHolder> {
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<DateUtil> mDateUtilProvider;
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public UserPostHolder_MembersInjector(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        this.mDateUtilProvider = aVar;
        this.userPreferenceProvider = aVar2;
        this.mConfigurationProvider = aVar3;
    }

    public static a<UserPostHolder> create(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        return new UserPostHolder_MembersInjector(aVar, aVar2, aVar3);
    }

    public final void injectMembers(UserPostHolder userPostHolder) {
        injectMDateUtil(userPostHolder, this.mDateUtilProvider.get());
        injectUserPreference(userPostHolder, this.userPreferenceProvider.get());
        injectMConfiguration(userPostHolder, this.mConfigurationProvider.get());
    }

    public static void injectMDateUtil(UserPostHolder userPostHolder, DateUtil dateUtil) {
        userPostHolder.mDateUtil = dateUtil;
    }

    public static void injectUserPreference(UserPostHolder userPostHolder, Preference<LoginResponse> preference) {
        userPostHolder.userPreference = preference;
    }

    public static void injectMConfiguration(UserPostHolder userPostHolder, Preference<Configuration> preference) {
        userPostHolder.mConfiguration = preference;
    }
}
