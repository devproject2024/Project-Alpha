package com.alipay.mobile.nebulacore.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5FragmentRootView extends RelativeLayout {
    private static final String TAG = "H5FragmentRootView";
    private boolean enableNewAdjustInput = false;
    private int statusBarHeight = 0;

    public H5FragmentRootView(Context context) {
        super(context);
    }

    public H5FragmentRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public H5FragmentRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void init(Context context, Bundle bundle) {
        if (H5Utils.getBoolean(bundle, H5Param.LONG_FULLSCREEN, false)) {
            H5Log.d(TAG, "disable enableNewAdjustInput by fullScreen.");
            this.enableNewAdjustInput = false;
        } else {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            if (h5ConfigProvider != null) {
                this.enableNewAdjustInput = H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_enableNewAdjustInput"));
            }
        }
        H5Log.d(TAG, "enableNewAdjustInput: " + this.enableNewAdjustInput);
        if (this.enableNewAdjustInput) {
            this.statusBarHeight = H5StatusBarUtils.getStatusBarHeight(context);
            setFitsSystemWindows(true);
            if (context instanceof Activity) {
                ((Activity) context).getWindow().setSoftInputMode(16);
            }
        }
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsets2;
        if (!this.enableNewAdjustInput) {
            return super.onApplyWindowInsets(windowInsets);
        }
        if (Build.VERSION.SDK_INT > 19) {
            int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop() - this.statusBarHeight;
            if (systemWindowInsetTop < 0) {
                systemWindowInsetTop = 0;
            }
            windowInsets2 = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), systemWindowInsetTop, windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        } else {
            windowInsets2 = windowInsets;
        }
        H5Log.d(TAG, "onApplyWindowInsets, before: " + windowInsets + ", after: " + windowInsets2);
        return super.onApplyWindowInsets(windowInsets2);
    }
}
