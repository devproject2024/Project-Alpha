package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.BranchModel;
import dagger.a;

public final class BranchDeepLink_MembersInjector implements a<BranchDeepLink> {
    private final javax.a.a<BranchModel> mBranchModelProvider;

    public BranchDeepLink_MembersInjector(javax.a.a<BranchModel> aVar) {
        this.mBranchModelProvider = aVar;
    }

    public static a<BranchDeepLink> create(javax.a.a<BranchModel> aVar) {
        return new BranchDeepLink_MembersInjector(aVar);
    }

    public final void injectMembers(BranchDeepLink branchDeepLink) {
        injectMBranchModel(branchDeepLink, this.mBranchModelProvider.get());
    }

    public static void injectMBranchModel(BranchDeepLink branchDeepLink, BranchModel branchModel) {
        branchDeepLink.mBranchModel = branchModel;
    }
}
