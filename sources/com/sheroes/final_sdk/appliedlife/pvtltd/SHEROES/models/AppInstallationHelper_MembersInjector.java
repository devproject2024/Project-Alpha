package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class AppInstallationHelper_MembersInjector implements a<AppInstallationHelper> {
    private final javax.a.a<AppInstallationModel> appInstallationModelProvider;
    private final javax.a.a<Preference<AppInstallation>> mAppInstallationPrefProvider;
    private final javax.a.a<Preference<LoginResponse>> mLoginResponseProvider;

    public AppInstallationHelper_MembersInjector(javax.a.a<Preference<AppInstallation>> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<AppInstallationModel> aVar3) {
        this.mAppInstallationPrefProvider = aVar;
        this.mLoginResponseProvider = aVar2;
        this.appInstallationModelProvider = aVar3;
    }

    public static a<AppInstallationHelper> create(javax.a.a<Preference<AppInstallation>> aVar, javax.a.a<Preference<LoginResponse>> aVar2, javax.a.a<AppInstallationModel> aVar3) {
        return new AppInstallationHelper_MembersInjector(aVar, aVar2, aVar3);
    }

    public final void injectMembers(AppInstallationHelper appInstallationHelper) {
        injectMAppInstallationPref(appInstallationHelper, this.mAppInstallationPrefProvider.get());
        injectMLoginResponse(appInstallationHelper, this.mLoginResponseProvider.get());
        injectAppInstallationModel(appInstallationHelper, this.appInstallationModelProvider.get());
    }

    public static void injectMAppInstallationPref(AppInstallationHelper appInstallationHelper, Preference<AppInstallation> preference) {
        appInstallationHelper.mAppInstallationPref = preference;
    }

    public static void injectMLoginResponse(AppInstallationHelper appInstallationHelper, Preference<LoginResponse> preference) {
        appInstallationHelper.mLoginResponse = preference;
    }

    public static void injectAppInstallationModel(AppInstallationHelper appInstallationHelper, AppInstallationModel appInstallationModel) {
        appInstallationHelper.appInstallationModel = appInstallationModel;
    }
}
