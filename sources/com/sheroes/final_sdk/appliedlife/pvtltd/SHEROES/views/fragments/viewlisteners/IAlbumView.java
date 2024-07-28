package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Album;

public interface IAlbumView {
    void hideProgressBar();

    void showAlbum(Album album);

    void showProgressBar();

    void showSuccessMessage();

    void trackSaveImageEvent(String str);
}
