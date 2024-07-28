package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.o;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FileFragment;
import java.util.List;

public class AlbumGalleryAdapter extends o {
    public CommonUtil.Callback mCallBack;
    private final List<Photo> mPhoto;

    public AlbumGalleryAdapter(FragmentActivity fragmentActivity, List<Photo> list, CommonUtil.Callback callback) {
        super(fragmentActivity.getSupportFragmentManager());
        this.mPhoto = list;
        this.mCallBack = callback;
    }

    public int getCount() {
        return this.mPhoto.size();
    }

    public Fragment getItem(int i2) {
        FileFragment newInstance = FileFragment.newInstance(this.mPhoto.get(i2).url, (String) null);
        newInstance.mCallBack = this.mCallBack;
        return newInstance;
    }
}
