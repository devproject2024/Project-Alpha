package com.alipay.mobile.nebula.provider;

import android.app.Activity;
import android.view.View;

public interface H5LoadingViewProvider {
    View getContentView(Activity activity);

    void setIcon(String str);

    void setTitle(String str);

    void stopLoading(Activity activity);
}
