package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import dagger.a.c;

public final class AlbumPresenter_Factory implements c<AlbumPresenter> {
    private static final AlbumPresenter_Factory INSTANCE = new AlbumPresenter_Factory();

    public final AlbumPresenter get() {
        return provideInstance();
    }

    public static AlbumPresenter provideInstance() {
        return new AlbumPresenter();
    }

    public static AlbumPresenter_Factory create() {
        return INSTANCE;
    }

    public static AlbumPresenter newAlbumPresenter() {
        return new AlbumPresenter();
    }
}
