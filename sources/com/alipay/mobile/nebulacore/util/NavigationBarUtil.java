package com.alipay.mobile.nebulacore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public class NavigationBarUtil {
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    private static String sNavBarOverride;
    private final boolean mHasNavigationBar;
    private final boolean mInPortrait;
    private final int mNavigationBarHeight;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable unused) {
                sNavBarOverride = null;
            }
        }
    }

    public NavigationBarUtil(Activity activity) {
        boolean z = false;
        this.mInPortrait = activity.getResources().getConfiguration().orientation == 1;
        this.mNavigationBarHeight = getNavigationBarHeight(activity);
        this.mHasNavigationBar = this.mNavigationBarHeight > 0 ? true : z;
    }

    private int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
            return 0;
        }
        return getInternalDimensionSize(resources, this.mInPortrait ? NAV_BAR_HEIGHT_RES_NAME : NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME);
    }

    private boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        if ("1".equals(sNavBarOverride)) {
            return false;
        }
        if ("0".equals(sNavBarOverride)) {
            return true;
        }
        return z;
    }

    private int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    public int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }
}
