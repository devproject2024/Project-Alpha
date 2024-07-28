package com.alipay.mobile.nebula.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;

public class H5StatusBarUtils {
    private static final String TSBS = "TSBS";
    private static final String TSBSOFF = "TSBSOFF";
    private static int statusBarHeight;

    public static boolean isSupport() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void setTransparentColor(Activity activity, int i2) {
        if (isSupport() && activity != null) {
            Window window = activity.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(i2);
        }
    }

    public static int getStatusBarHeight(Context context) {
        if (statusBarHeight == 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        }
        return statusBarHeight;
    }

    public static boolean isConfigSupport() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return true;
        }
        if (TextUtils.equals(h5ConfigProvider.getConfig(TSBS), "0")) {
            return false;
        }
        String config = h5ConfigProvider.getConfig(TSBSOFF);
        String str = Build.MODEL;
        if (TextUtils.isEmpty(config) || !config.contains(str)) {
            return true;
        }
        return false;
    }
}
