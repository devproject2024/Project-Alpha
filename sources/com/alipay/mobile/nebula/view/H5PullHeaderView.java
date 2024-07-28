package com.alipay.mobile.nebula.view;

import android.view.View;

public interface H5PullHeaderView {
    View getContentView();

    void onProgressUpdate(int i2);

    void setLastRefresh();

    void showFinish();

    void showLoading();

    void showOpen();

    void showOver();
}
