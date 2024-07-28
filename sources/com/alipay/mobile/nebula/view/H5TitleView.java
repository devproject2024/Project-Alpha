package com.alipay.mobile.nebula.view;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;

public interface H5TitleView {
    ColorDrawable getContentBgView();

    View getContentView();

    View getDivider();

    View getHdividerInTitle();

    TextView getMainTitleView();

    View getOptionMenuContainer();

    View getPopAnchor();

    TextView getSubTitleView();

    String getTitle();

    void openTranslucentStatusBarSupport(int i2);

    void releaseViewList();

    void resetTitleColor(int i2);

    void setBackCloseBtnImage(String str);

    void setBtIcon(Bitmap bitmap, int i2);

    void setH5Page(H5Page h5Page);

    void setImgTitle(Bitmap bitmap);

    void setImgTitle(Bitmap bitmap, String str);

    void setOptionMenu(e eVar);

    void setOptionType(H5Param.OptionType optionType);

    void setOptionType(H5Param.OptionType optionType, int i2, boolean z);

    void setSubTitle(String str);

    void setTitle(String str);

    View setTitleBarSearch(Bundle bundle);

    void setTitleTxtColor(int i2);

    void showBackButton(boolean z);

    void showCloseButton(boolean z);

    void showOptionMenu(boolean z);

    void showTitleLoading(boolean z);

    void switchToBlueTheme();

    void switchToTitleBar();

    void switchToWhiteTheme();
}
