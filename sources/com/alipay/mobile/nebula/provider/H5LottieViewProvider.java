package com.alipay.mobile.nebula.provider;

import android.app.Activity;
import android.view.ViewGroup;
import java.util.Map;

public interface H5LottieViewProvider {
    ViewGroup createLoadingView(Activity activity);

    void playAnimation();

    void setImgs(Map<String, byte[]> map);

    void setLocationXY(int i2, int i3);

    void setMainJson(byte[] bArr);

    void setWidthAndHeight(int i2, int i3);

    void stopAnimation();
}
