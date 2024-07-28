package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.AlbumPresenter;
import dagger.a;

public final class AlbumActivity_MembersInjector implements a<AlbumActivity> {
    private final javax.a.a<AlbumPresenter> mAlbumPresenterProvider;

    public AlbumActivity_MembersInjector(javax.a.a<AlbumPresenter> aVar) {
        this.mAlbumPresenterProvider = aVar;
    }

    public static a<AlbumActivity> create(javax.a.a<AlbumPresenter> aVar) {
        return new AlbumActivity_MembersInjector(aVar);
    }

    public final void injectMembers(AlbumActivity albumActivity) {
        injectMAlbumPresenter(albumActivity, this.mAlbumPresenterProvider.get());
    }

    public static void injectMAlbumPresenter(AlbumActivity albumActivity, AlbumPresenter albumPresenter) {
        albumActivity.mAlbumPresenter = albumPresenter;
    }
}
