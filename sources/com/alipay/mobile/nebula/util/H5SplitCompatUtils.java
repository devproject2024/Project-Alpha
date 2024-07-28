package com.alipay.mobile.nebula.util;

import android.content.Context;
import com.alipay.mobile.nebula.R;
import java.lang.reflect.InvocationTargetException;

public class H5SplitCompatUtils {
    private static final String DYNAMIC_DELIVERY_DISABLE = "NO";
    private static final String KEY_DYNAMIC_DELIVERY_FIX = "h5_dynamic_delivery_fix";
    private static final String TAG = "H5SplitCompatUtils";

    public static void doInstall(Context context) {
        H5Log.d(TAG, "do split install for context: ".concat(String.valueOf(context)));
        String stringConfig = H5Utils.getStringConfig(KEY_DYNAMIC_DELIVERY_FIX);
        H5Log.d(TAG, "h5_dynamic_delivery_fix value: ".concat(String.valueOf(stringConfig)));
        if (!"NO".equalsIgnoreCase(stringConfig)) {
            H5Log.d(TAG, "start to do SplitCompat.install");
            if (splitCompatExisted() && isResourceInaccessible(context)) {
                install(context);
            }
        }
    }

    private static boolean isResourceInaccessible(Context context) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            context.getResources().getLayout(R.layout.h5_web_content);
            z = false;
        } catch (Exception e2) {
            H5Log.e(TAG, "check resource failed", e2);
            z = true;
        }
        H5Log.d(TAG, "check resource inaccessible: ".concat(String.valueOf(z)));
        H5Log.d(TAG, "check resource cost: " + (System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    private static boolean splitCompatExisted() {
        try {
            Class.forName("com.google.android.play.core.splitcompat.a");
            return true;
        } catch (Exception unused) {
            H5Log.e(TAG, "SplitCompat class not found, just check, take it easy");
            return false;
        }
    }

    private static void install(Context context) {
        try {
            Class<?> cls = Class.forName("com.google.android.play.core.splitcompat.a");
            cls.getDeclaredMethod("install", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            H5Log.d(TAG, "SplitCompat install complete");
        } catch (ClassNotFoundException unused) {
            H5Log.e(TAG, "SplitCompat class not found, install failed");
        } catch (NoSuchMethodException unused2) {
            H5Log.e(TAG, "SplitCompat install method not found, install failed");
        } catch (IllegalAccessException unused3) {
            H5Log.e(TAG, "Invoke splitCompat install method exception, install failed");
        } catch (InvocationTargetException unused4) {
            H5Log.e(TAG, "Invoke splitCompat install method exception, install failed");
        } catch (Exception unused5) {
            H5Log.e(TAG, "SplitCompat install failed");
        }
    }
}
