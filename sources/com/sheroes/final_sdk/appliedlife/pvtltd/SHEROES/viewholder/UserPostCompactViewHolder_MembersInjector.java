package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import dagger.a;

public final class UserPostCompactViewHolder_MembersInjector implements a<UserPostCompactViewHolder> {
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<DateUtil> mDateUtilProvider;
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public UserPostCompactViewHolder_MembersInjector(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        this.mDateUtilProvider = aVar;
        this.userPreferenceProvider = aVar2;
        this.mConfigurationProvider = aVar3;
    }

    public static a<UserPostCompactViewHolder> create(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<Preference<Configuration>> aVar3) {
        return new UserPostCompactViewHolder_MembersInjector(aVar, aVar2, aVar3);
    }

    public final void injectMembers(UserPostCompactViewHolder userPostCompactViewHolder) {
        injectMDateUtil(userPostCompactViewHolder, this.mDateUtilProvider.get());
        injectUserPreference(userPostCompactViewHolder, this.userPreferenceProvider.get());
        injectMConfiguration(userPostCompactViewHolder, this.mConfigurationProvider.get());
    }

    public static void injectMDateUtil(UserPostCompactViewHolder userPostCompactViewHolder, DateUtil dateUtil) {
        userPostCompactViewHolder.mDateUtil = dateUtil;
    }

    public static void injectUserPreference(UserPostCompactViewHolder userPostCompactViewHolder, Preference<LoginResponse> preference) {
        userPostCompactViewHolder.userPreference = preference;
    }

    public static void injectMConfiguration(UserPostCompactViewHolder userPostCompactViewHolder, Preference<Configuration> preference) {
        userPostCompactViewHolder.mConfiguration = preference;
    }
}
