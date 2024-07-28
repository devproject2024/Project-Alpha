package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a;

public final class CommunityPostActivity_MembersInjector implements a<CommunityPostActivity> {
    private final javax.a.a<AppUtils> mAppUtilsProvider;
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<CreatePostPresenter> mCreatePostPresenterProvider;
    private final javax.a.a<Preference<LoginResponse>> mUserPreferenceProvider;

    public CommunityPostActivity_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<CreatePostPresenter> aVar2, javax.a.a<AppUtils> aVar3, javax.a.a<Preference<Configuration>> aVar4) {
        this.mUserPreferenceProvider = aVar;
        this.mCreatePostPresenterProvider = aVar2;
        this.mAppUtilsProvider = aVar3;
        this.mConfigurationProvider = aVar4;
    }

    public static a<CommunityPostActivity> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<CreatePostPresenter> aVar2, javax.a.a<AppUtils> aVar3, javax.a.a<Preference<Configuration>> aVar4) {
        return new CommunityPostActivity_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public final void injectMembers(CommunityPostActivity communityPostActivity) {
        injectMUserPreference(communityPostActivity, this.mUserPreferenceProvider.get());
        injectMCreatePostPresenter(communityPostActivity, this.mCreatePostPresenterProvider.get());
        injectMAppUtils(communityPostActivity, this.mAppUtilsProvider.get());
        injectMConfiguration(communityPostActivity, this.mConfigurationProvider.get());
    }

    public static void injectMUserPreference(CommunityPostActivity communityPostActivity, Preference<LoginResponse> preference) {
        communityPostActivity.mUserPreference = preference;
    }

    public static void injectMCreatePostPresenter(CommunityPostActivity communityPostActivity, CreatePostPresenter createPostPresenter) {
        communityPostActivity.mCreatePostPresenter = createPostPresenter;
    }

    public static void injectMAppUtils(CommunityPostActivity communityPostActivity, AppUtils appUtils) {
        communityPostActivity.mAppUtils = appUtils;
    }

    public static void injectMConfiguration(CommunityPostActivity communityPostActivity, Preference<Configuration> preference) {
        communityPostActivity.mConfiguration = preference;
    }
}
