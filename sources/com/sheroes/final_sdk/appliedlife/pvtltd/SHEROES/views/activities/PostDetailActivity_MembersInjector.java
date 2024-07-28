package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostDetailViewImpl;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a;

public final class PostDetailActivity_MembersInjector implements a<PostDetailActivity> {
    private final javax.a.a<AppUtils> mAppUtilsProvider;
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<PostDetailViewImpl> mPostDetailPresenterProvider;
    private final javax.a.a<Preference<LoginResponse>> mUserPreferenceProvider;

    public PostDetailActivity_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2, javax.a.a<AppUtils> aVar3, javax.a.a<PostDetailViewImpl> aVar4) {
        this.mUserPreferenceProvider = aVar;
        this.mConfigurationProvider = aVar2;
        this.mAppUtilsProvider = aVar3;
        this.mPostDetailPresenterProvider = aVar4;
    }

    public static a<PostDetailActivity> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<Preference<Configuration>> aVar2, javax.a.a<AppUtils> aVar3, javax.a.a<PostDetailViewImpl> aVar4) {
        return new PostDetailActivity_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public final void injectMembers(PostDetailActivity postDetailActivity) {
        injectMUserPreference(postDetailActivity, this.mUserPreferenceProvider.get());
        injectMConfiguration(postDetailActivity, this.mConfigurationProvider.get());
        injectMAppUtils(postDetailActivity, this.mAppUtilsProvider.get());
        injectMPostDetailPresenter(postDetailActivity, this.mPostDetailPresenterProvider.get());
    }

    public static void injectMUserPreference(PostDetailActivity postDetailActivity, Preference<LoginResponse> preference) {
        postDetailActivity.mUserPreference = preference;
    }

    public static void injectMConfiguration(PostDetailActivity postDetailActivity, Preference<Configuration> preference) {
        postDetailActivity.mConfiguration = preference;
    }

    public static void injectMAppUtils(PostDetailActivity postDetailActivity, AppUtils appUtils) {
        postDetailActivity.mAppUtils = appUtils;
    }

    public static void injectMPostDetailPresenter(PostDetailActivity postDetailActivity, PostDetailViewImpl postDetailViewImpl) {
        postDetailActivity.mPostDetailPresenter = postDetailViewImpl;
    }
}
