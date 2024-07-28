package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a;

public final class ShareBottomSheetFragment_MembersInjector implements a<ShareBottomSheetFragment> {
    private final javax.a.a<Preference<Configuration>> mConfigurationProvider;

    public ShareBottomSheetFragment_MembersInjector(javax.a.a<Preference<Configuration>> aVar) {
        this.mConfigurationProvider = aVar;
    }

    public static a<ShareBottomSheetFragment> create(javax.a.a<Preference<Configuration>> aVar) {
        return new ShareBottomSheetFragment_MembersInjector(aVar);
    }

    public final void injectMembers(ShareBottomSheetFragment shareBottomSheetFragment) {
        injectMConfiguration(shareBottomSheetFragment, this.mConfigurationProvider.get());
    }

    public static void injectMConfiguration(ShareBottomSheetFragment shareBottomSheetFragment, Preference<Configuration> preference) {
        shareBottomSheetFragment.mConfiguration = preference;
    }
}
