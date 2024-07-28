package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseFragment_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.FeedPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a;

public final class FeedFragment_MembersInjector implements a<FeedFragment> {
    private final javax.a.a<AppUtils> mAppUtilsProvider;
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;
    private final javax.a.a<FeedPresenter> mFeedPresenterProvider;
    private final javax.a.a<Preference<LoginResponse>> mUserPreferenceAndUserPreferenceProvider;

    public FeedFragment_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<AppUtils> aVar2, javax.a.a<FeedPresenter> aVar3, javax.a.a<Preference<Configuration>> aVar4) {
        this.mUserPreferenceAndUserPreferenceProvider = aVar;
        this.mAppUtilsProvider = aVar2;
        this.mFeedPresenterProvider = aVar3;
        this.mConfigurationProvider = aVar4;
    }

    public static a<FeedFragment> create(javax.a.a<Preference<LoginResponse>> aVar, javax.a.a<AppUtils> aVar2, javax.a.a<FeedPresenter> aVar3, javax.a.a<Preference<Configuration>> aVar4) {
        return new FeedFragment_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public final void injectMembers(FeedFragment feedFragment) {
        BaseFragment_MembersInjector.injectUserPreference(feedFragment, this.mUserPreferenceAndUserPreferenceProvider.get());
        injectMAppUtils(feedFragment, this.mAppUtilsProvider.get());
        injectMFeedPresenter(feedFragment, this.mFeedPresenterProvider.get());
        injectMUserPreference(feedFragment, this.mUserPreferenceAndUserPreferenceProvider.get());
        injectMConfiguration(feedFragment, this.mConfigurationProvider.get());
    }

    public static void injectMAppUtils(FeedFragment feedFragment, AppUtils appUtils) {
        feedFragment.mAppUtils = appUtils;
    }

    public static void injectMFeedPresenter(FeedFragment feedFragment, FeedPresenter feedPresenter) {
        feedFragment.mFeedPresenter = feedPresenter;
    }

    public static void injectMUserPreference(FeedFragment feedFragment, Preference<LoginResponse> preference) {
        feedFragment.mUserPreference = preference;
    }

    public static void injectMConfiguration(FeedFragment feedFragment, Preference<Configuration> preference) {
        feedFragment.mConfiguration = preference;
    }
}
