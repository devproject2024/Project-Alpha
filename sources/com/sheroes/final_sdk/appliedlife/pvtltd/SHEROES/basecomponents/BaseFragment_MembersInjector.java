package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class BaseFragment_MembersInjector implements a<BaseFragment> {
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public BaseFragment_MembersInjector(javax.a.a<Preference<LoginResponse>> aVar) {
        this.userPreferenceProvider = aVar;
    }

    public static a<BaseFragment> create(javax.a.a<Preference<LoginResponse>> aVar) {
        return new BaseFragment_MembersInjector(aVar);
    }

    public final void injectMembers(BaseFragment baseFragment) {
        injectUserPreference(baseFragment, this.userPreferenceProvider.get());
    }

    public static void injectUserPreference(BaseFragment baseFragment, Preference<LoginResponse> preference) {
        baseFragment.userPreference = preference;
    }
}
