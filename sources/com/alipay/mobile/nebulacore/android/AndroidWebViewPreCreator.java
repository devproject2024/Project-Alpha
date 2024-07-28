package com.alipay.mobile.nebulacore.android;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class AndroidWebViewPreCreator {
    public static final String CONFIG_KEY_H5_ENABLE_WEB_VIEW_POOL = "h5_enableWebViewPool";
    public static final int DEFAULT_POOL_CAPACITY = 2;
    public static final int MAX_POOL_CAPACITY = 4;
    public static final String TAG = "AndroidWebViewPreCreator";
    private static boolean sInitiated = false;
    private static H5ConfigProvider.OnConfigChangeListener sOnWebViewPoolChange = new H5ConfigProvider.OnConfigChangeListener() {
        public final void onChange(String str) {
            AndroidWebViewPreCreator.configureWebViewPool(str);
        }
    };
    static boolean sUseWebViewFromPool = false;
    static int sWebViewCreateDelay = 3000;
    static int sWebViewPoolCapacity = 0;
    private static boolean sWebViewPoolKeep = false;

    public static AndroidWebView getInstance(Context context) {
        AndroidWebView androidWebView = null;
        if (sWebViewPoolCapacity <= 0 || AndroidWebView.getWebViewPoolSize() <= 0 || !isH5Activity(context) || !sUseWebViewFromPool) {
            return null;
        }
        try {
            AndroidWebView pollOnce = AndroidWebView.pollOnce();
            if (pollOnce == null || pollOnce.getWebViewEx() == null) {
                return null;
            }
            ((MutableContextWrapper) pollOnce.getWebViewEx().getContext()).setBaseContext(context);
            H5Log.d(TAG, "WebView get from pool");
            H5PageData.sUseWebViewPool = true;
            try {
                if (sWebViewPoolKeep) {
                    AndroidWebView.preCreateOnMainWithDelay(sWebViewCreateDelay);
                }
                return pollOnce;
            } catch (Throwable th) {
                th = th;
                androidWebView = pollOnce;
                H5Log.e(TAG, "WebView get from pool", th);
                return androidWebView;
            }
        } catch (Throwable th2) {
            th = th2;
            H5Log.e(TAG, "WebView get from pool", th);
            return androidWebView;
        }
    }

    private static boolean isH5Activity(Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        try {
            Class<?> cls = Class.forName("com.alipay.mobile.nebulacore.ui.H5Activity");
            H5Log.d(TAG, "isH5Activity: " + context.getClass() + " isAssignableFrom " + cls);
            if (cls != null) {
                return cls.isAssignableFrom(context.getClass());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void init() {
        String str;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            if (sInitiated) {
                str = h5ConfigProvider.getConfig(CONFIG_KEY_H5_ENABLE_WEB_VIEW_POOL);
            } else {
                str = h5ConfigProvider.getConfigWithNotifyChange(CONFIG_KEY_H5_ENABLE_WEB_VIEW_POOL, sOnWebViewPoolChange);
            }
            configureWebViewPool(str);
        }
        if (!sInitiated) {
            sInitiated = true;
            AndroidWebView.preCreateOnMainWithDelay(0);
        }
    }

    /* access modifiers changed from: private */
    public static void configureWebViewPool(String str) {
        e parseObject = H5Utils.parseObject(str);
        if (parseObject == null) {
            H5Log.d(TAG, "WebView pool config is empty");
            return;
        }
        Boolean bool = parseObject.getBoolean("enable");
        if (bool == null || !bool.booleanValue()) {
            H5Log.d(TAG, "pre-create WebView is disabled");
            sWebViewPoolCapacity = 0;
            return;
        }
        int i2 = H5Utils.getInt(parseObject, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, sWebViewPoolCapacity);
        if (i2 > 4 || i2 <= 0) {
            sWebViewPoolCapacity = 2;
        } else {
            sWebViewPoolCapacity = i2;
        }
        int i3 = H5Utils.getInt(parseObject, "delay", sWebViewCreateDelay);
        if (i3 > 0) {
            sWebViewCreateDelay = i3;
        }
        sUseWebViewFromPool = H5Utils.getBoolean(parseObject, "use", sUseWebViewFromPool);
        sWebViewPoolKeep = H5Utils.getBoolean(parseObject, "keep", sWebViewPoolKeep);
    }
}
