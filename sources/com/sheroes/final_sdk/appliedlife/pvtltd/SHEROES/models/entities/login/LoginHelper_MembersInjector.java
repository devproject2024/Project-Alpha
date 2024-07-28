package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class LoginHelper_MembersInjector implements a<LoginHelper> {
    private final javax.a.a<Preference<AllCommunitiesResponse>> allCommunitiesResponsePreferenceProvider;
    private final javax.a.a<Preference<Configuration>> configurationPreferenceProvider;
    private final javax.a.a<Preference<AppInstallation>> mAppInstallationProvider;
    private final javax.a.a<LoginModel> mLoginModelProvider;
    private final javax.a.a<Preference<LoginResponse>> mLoginResponseProvider;

    public LoginHelper_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<LoginModel> aVar2, javax.a.a<Preference<AppInstallation>> aVar3, javax.a.a<Preference<AllCommunitiesResponse>> aVar4, javax.a.a<Preference<Configuration>> aVar5) {
        this.mLoginResponseProvider = aVar;
        this.mLoginModelProvider = aVar2;
        this.mAppInstallationProvider = aVar3;
        this.allCommunitiesResponsePreferenceProvider = aVar4;
        this.configurationPreferenceProvider = aVar5;
    }

    public static a<LoginHelper> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<LoginModel> aVar2, javax.a.a<Preference<AppInstallation>> aVar3, javax.a.a<Preference<AllCommunitiesResponse>> aVar4, javax.a.a<Preference<Configuration>> aVar5) {
        return new LoginHelper_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public final void injectMembers(LoginHelper loginHelper) {
        injectMLoginResponse(loginHelper, this.mLoginResponseProvider.get());
        injectMLoginModel(loginHelper, this.mLoginModelProvider.get());
        injectMAppInstallation(loginHelper, this.mAppInstallationProvider.get());
        injectAllCommunitiesResponsePreference(loginHelper, this.allCommunitiesResponsePreferenceProvider.get());
        injectConfigurationPreference(loginHelper, this.configurationPreferenceProvider.get());
    }

    public static void injectMLoginResponse(LoginHelper loginHelper, Preference<LoginResponse> preference) {
        loginHelper.mLoginResponse = preference;
    }

    public static void injectMLoginModel(LoginHelper loginHelper, LoginModel loginModel) {
        loginHelper.mLoginModel = loginModel;
    }

    public static void injectMAppInstallation(LoginHelper loginHelper, Preference<AppInstallation> preference) {
        loginHelper.mAppInstallation = preference;
    }

    public static void injectAllCommunitiesResponsePreference(LoginHelper loginHelper, Preference<AllCommunitiesResponse> preference) {
        loginHelper.allCommunitiesResponsePreference = preference;
    }

    public static void injectConfigurationPreference(LoginHelper loginHelper, Preference<Configuration> preference) {
        loginHelper.configurationPreference = preference;
    }
}
