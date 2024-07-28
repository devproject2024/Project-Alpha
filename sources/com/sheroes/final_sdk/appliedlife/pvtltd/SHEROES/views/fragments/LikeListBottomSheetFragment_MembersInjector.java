package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.UserLikedListPresenterImpl;
import dagger.a;

public final class LikeListBottomSheetFragment_MembersInjector implements a<LikeListBottomSheetFragment> {
    private final javax.a.a<UserLikedListPresenterImpl> mUserLikedListPresenterProvider;

    public LikeListBottomSheetFragment_MembersInjector(javax.a.a<UserLikedListPresenterImpl> aVar) {
        this.mUserLikedListPresenterProvider = aVar;
    }

    public static a<LikeListBottomSheetFragment> create(javax.a.a<UserLikedListPresenterImpl> aVar) {
        return new LikeListBottomSheetFragment_MembersInjector(aVar);
    }

    public final void injectMembers(LikeListBottomSheetFragment likeListBottomSheetFragment) {
        injectMUserLikedListPresenter(likeListBottomSheetFragment, this.mUserLikedListPresenterProvider.get());
    }

    public static void injectMUserLikedListPresenter(LikeListBottomSheetFragment likeListBottomSheetFragment, UserLikedListPresenterImpl userLikedListPresenterImpl) {
        likeListBottomSheetFragment.mUserLikedListPresenter = userLikedListPresenterImpl;
    }
}
