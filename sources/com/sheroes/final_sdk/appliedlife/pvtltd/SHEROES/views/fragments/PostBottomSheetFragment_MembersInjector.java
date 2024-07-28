package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostBottomSheetPresenter;
import dagger.a;

public final class PostBottomSheetFragment_MembersInjector implements a<PostBottomSheetFragment> {
    private final javax.a.a<Preference<AllCommunitiesResponse>> mAllCommunitiesProvider;
    private final javax.a.a<PostBottomSheetPresenter> mPostBottomSheetPresenterProvider;

    public PostBottomSheetFragment_MembersInjector(javax.a.a<PostBottomSheetPresenter> aVar, javax.a.a<Preference<AllCommunitiesResponse>> aVar2) {
        this.mPostBottomSheetPresenterProvider = aVar;
        this.mAllCommunitiesProvider = aVar2;
    }

    public static a<PostBottomSheetFragment> create(javax.a.a<PostBottomSheetPresenter> aVar, javax.a.a<Preference<AllCommunitiesResponse>> aVar2) {
        return new PostBottomSheetFragment_MembersInjector(aVar, aVar2);
    }

    public final void injectMembers(PostBottomSheetFragment postBottomSheetFragment) {
        injectMPostBottomSheetPresenter(postBottomSheetFragment, this.mPostBottomSheetPresenterProvider.get());
        injectMAllCommunities(postBottomSheetFragment, this.mAllCommunitiesProvider.get());
    }

    public static void injectMPostBottomSheetPresenter(PostBottomSheetFragment postBottomSheetFragment, PostBottomSheetPresenter postBottomSheetPresenter) {
        postBottomSheetFragment.mPostBottomSheetPresenter = postBottomSheetPresenter;
    }

    public static void injectMAllCommunities(PostBottomSheetFragment postBottomSheetFragment, Preference<AllCommunitiesResponse> preference) {
        postBottomSheetFragment.mAllCommunities = preference;
    }
}
