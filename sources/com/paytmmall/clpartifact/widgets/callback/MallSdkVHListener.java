package com.paytmmall.clpartifact.widgets.callback;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.InfiniteGridViewPagerAdapter;
import java.util.HashMap;

public interface MallSdkVHListener {
    Fragment getCLPFragment(String str, int i2, Bundle bundle, InfiniteGridViewPagerAdapter.ITabVisibilityListener iTabVisibilityListener);

    HashMap<String, String> getContextParams();

    View getFlashView();

    String getGAKey();

    y<RedirectorModel> getReDirector();

    void openAllStoresTab();

    void openReviewsTab();

    void openSearch(FragmentActivity fragmentActivity, String str, int i2);

    void passAdapterPosFromVH(int i2);

    void setReDirectorValue(RedirectorModel redirectorModel);
}
