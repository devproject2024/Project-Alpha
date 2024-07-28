package com.alipay.mobile.nebula.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.nebula.refresh.H5PullContainer;

public interface H5WebContentView {
    View getContentView();

    H5LoadingView getH5LoadingView();

    TextView getH5ProviderDomain();

    View getHdivider();

    H5Progress getProgress();

    LinearLayout getProviderLayout();

    H5PullContainer getPullContainer();

    boolean isCustomBackground();

    void setProviderLogo(Drawable drawable);

    void setProviderText(String str);

    void setProviderUc(String str);

    void showProviderVisibility(boolean z);

    void swicthDefaultContentBg(Drawable drawable, boolean z);

    void switchCustomContentBg(int i2, Drawable drawable, boolean z);
}
