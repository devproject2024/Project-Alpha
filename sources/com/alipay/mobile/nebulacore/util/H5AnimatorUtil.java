package com.alipay.mobile.nebulacore.util;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.nebula.provider.H5AnimatorResIdProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5AnimatorUtil {
    private static final String ANIM = "anim";
    private static boolean DEFAULT_NEED_ANIM = true;
    private static final String TAG = "H5AnimatorUtil";
    private static String pkgName;

    private static H5AnimatorResIdProvider getH5Animator() {
        return (H5AnimatorResIdProvider) H5Utils.getProvider(H5AnimatorResIdProvider.class.getName());
    }

    public static boolean isNeedAnimFromConfig() {
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_needAnim");
        if (TextUtils.isEmpty(configWithProcessCache) || !"no".equalsIgnoreCase(configWithProcessCache)) {
            return DEFAULT_NEED_ANIM;
        }
        return false;
    }

    public static void setActivityStart(H5Context h5Context) {
        if (isNeedAnimFromConfig()) {
            try {
                if (getH5Animator() != null) {
                    Activity activity = null;
                    Object context = (h5Context == null || h5Context.getContext() == null) ? null : h5Context.getContext();
                    H5Log.d(TAG, "context ".concat(String.valueOf(context)));
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                    if (activity != null) {
                        activity.overridePendingTransition(activity.getResources().getIdentifier(getH5Animator().startActivityEnterAnim(), ANIM, getPackageName()), activity.getResources().getIdentifier(getH5Animator().startActivityEnterExitAnim(), ANIM, getPackageName()));
                        return;
                    }
                    return;
                }
                b.a();
            } catch (Throwable th) {
                H5Log.d(TAG, "overridePendingTransitionFromXml exception : ".concat(String.valueOf(th)));
            }
        }
    }

    public static void setActivityNoAnimStart() {
        if (isNeedAnimFromConfig()) {
            try {
                b.a();
            } catch (Throwable th) {
                H5Log.d(TAG, "overridePendingTransitionFromXml exception : ".concat(String.valueOf(th)));
            }
        }
    }

    public static void setActivityFinish(Activity activity) {
        if (isNeedAnimFromConfig()) {
            try {
                if (getH5Animator() == null) {
                    b.a();
                } else if (activity != null) {
                    activity.overridePendingTransition(activity.getResources().getIdentifier(getH5Animator().finishActivityEnterAnim(), ANIM, getPackageName()), activity.getResources().getIdentifier(getH5Animator().finishActivityEnterExitAnim(), ANIM, getPackageName()));
                }
            } catch (Throwable th) {
                H5Log.d(TAG, " exception : ".concat(String.valueOf(th)));
            }
        }
    }

    public static void setActivityFadingStart() {
        if (isNeedTransAnim()) {
            try {
                b.a();
            } catch (Throwable th) {
                H5Log.d(TAG, "setActivityFadingStart exception : ".concat(String.valueOf(th)));
            }
        }
    }

    public static void setActivityFadingFinish() {
        if (isNeedTransAnim()) {
            try {
                b.a();
            } catch (Throwable th) {
                H5Log.d(TAG, "setActivityFadingFinish exception : ".concat(String.valueOf(th)));
            }
        }
    }

    public static boolean isNeedTransAnim() {
        String config = H5Environment.getConfig("h5_transAnim");
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    private static String getPackageName() {
        if (pkgName == null) {
            if (H5Utils.getContext() != null) {
                pkgName = H5Utils.getContext().getPackageName();
            } else {
                b.a();
            }
        }
        return pkgName;
    }
}
