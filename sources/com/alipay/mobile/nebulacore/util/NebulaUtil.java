package com.alipay.mobile.nebulacore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.alibaba.a.e;
import com.alipay.mobile.c.a;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5ImageUploadListener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5ImageUploadProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.Random;

public class NebulaUtil {
    public static final String TAG = "H5NebulaUtil";
    public static String dslJs = "";

    public static String getApplicationDir() {
        Context context = H5Environment.getContext();
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir;
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail", th);
            return null;
        }
    }

    public static void parseNoAlphaColor(Bundle bundle) {
        if (!H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false)) {
            setNoAlpha(bundle);
        }
    }

    private static void setNoAlpha(Bundle bundle) {
        int i2 = H5Utils.getInt(bundle, "backgroundColor", -16777216);
        if (i2 != -16777216) {
            bundle.putInt("backgroundColor", -16777216 | i2);
        }
    }

    public static boolean isShowTransAnimate(Bundle bundle) {
        if (!H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false) || !H5Utils.getBoolean(bundle, H5Param.LONG_TRANS_ANIMATE, false)) {
            return false;
        }
        return true;
    }

    public static boolean isLogBlankScreen(String str) {
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_logNewBlankScreenConfig"));
        if (parseObject == null || parseObject.isEmpty()) {
            return false;
        }
        String string = H5Utils.getString(parseObject, "enable");
        String string2 = H5Utils.getString(parseObject, "appId");
        if (TextUtils.isEmpty(dslJs)) {
            dslJs = H5Utils.getString(parseObject, "script");
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(str) || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string) || !isAppIdMatch(string2, str)) {
            return false;
        }
        H5Log.e(TAG, "isLogBlankScreen true");
        return true;
    }

    public static boolean isAppIdMatch(String str, String str2) {
        return H5PatternHelper.matchRegex(str, str2);
    }

    public static boolean isUcCheckDsl() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_dslCheckConfig"));
        if (parseObject == null || parseObject.isEmpty()) {
            return false;
        }
        String string = H5Utils.getString(parseObject, "ucCheck");
        if (TextUtils.isEmpty(string) || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string)) {
            return false;
        }
        H5Log.d(TAG, "isUcCheckDsl true");
        return true;
    }

    public static boolean isCloseCheckDsl() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_dslCheckConfig"));
        if (parseObject == null || parseObject.isEmpty()) {
            return true;
        }
        String string = H5Utils.getString(parseObject, "closeCheck");
        if (TextUtils.isEmpty(string) || !"no".equalsIgnoreCase(string)) {
            return true;
        }
        H5Log.d(TAG, "isCloseCheckDsl false");
        return false;
    }

    public static boolean isScreenOn() {
        b.a();
        PowerManager powerManager = (PowerManager) a.f14950c.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isScreenOn();
        }
        H5Log.d(TAG, "powerManager == null");
        return true;
    }

    public static void whiteScreenSnapshotUpload(final H5Page h5Page) {
        if (h5Page != null) {
            try {
                e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_whiteScreenImageUpload"));
                if (parseObject == null) {
                    return;
                }
                if (!parseObject.isEmpty()) {
                    String string = H5Utils.getString(parseObject, "enable");
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    if (!"no".equalsIgnoreCase(string)) {
                        final int parseInt = Integer.parseInt(H5Utils.getString(parseObject, "pixelNum"));
                        final float parseFloat = Float.parseFloat(H5Utils.getString(parseObject, "matchRatio"));
                        H5Log.d(TAG, "pixelNum : " + parseInt + " matchRatio : " + parseFloat);
                        if (parseInt == 0) {
                            return;
                        }
                        if (parseFloat != 0.0f) {
                            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                                public final void run() {
                                    Bitmap takeScreenShot = H5PerformanceUtils.takeScreenShot(h5Page);
                                    if (takeScreenShot != null && takeScreenShot.getWidth() > 0 && takeScreenShot.getHeight() > 0) {
                                        int width = takeScreenShot.getWidth();
                                        int height = takeScreenShot.getHeight();
                                        SparseIntArray sparseIntArray = new SparseIntArray();
                                        Random random = new Random();
                                        boolean z = false;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= parseInt) {
                                                break;
                                            }
                                            int pixel = takeScreenShot.getPixel(random.nextInt(width - 1), random.nextInt(height - 1));
                                            if (sparseIntArray.indexOfKey(pixel) >= 0) {
                                                int i3 = sparseIntArray.get(pixel) + 1;
                                                sparseIntArray.put(pixel, i3);
                                                if (((float) i3) >= ((float) parseInt) * parseFloat) {
                                                    H5Log.d(NebulaUtil.TAG, "isWhiteScreen = true, number : " + i3 + " pixelNum * matchRatio : " + (((float) parseInt) * parseFloat));
                                                    z = true;
                                                    break;
                                                }
                                            } else {
                                                sparseIntArray.put(pixel, 1);
                                            }
                                            i2++;
                                        }
                                        H5ImageUploadProvider h5ImageUploadProvider = (H5ImageUploadProvider) Nebula.getProviderManager().getProvider(H5ImageUploadProvider.class.getName());
                                        if (z && h5ImageUploadProvider != null) {
                                            h5ImageUploadProvider.uploadImage(takeScreenShot, new H5ImageUploadListener() {
                                                public void onSuccess(String str) {
                                                    H5PageData pageData;
                                                    H5Log.d(NebulaUtil.TAG, "multimediaID : ".concat(String.valueOf(str)));
                                                    if (h5Page != null && (pageData = h5Page.getPageData()) != null) {
                                                        pageData.setMultimediaID(str);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public static boolean enableResDegrade() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_nbresmode"));
    }

    public static boolean enableShowLoadingViewConfig() {
        String config = H5Environment.getConfig("h5_enableShowLoadingView");
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    public static boolean enableAllowFileAccess(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.alibaba.a.b parseArray = H5Utils.parseArray(H5Environment.getConfigWithProcessCache("h5_enableAllowFileAccessList"));
        if (parseArray == null || parseArray.isEmpty()) {
            parseArray = new com.alibaba.a.b();
            parseArray.add("\\/apps\\/.*");
        }
        if (parseArray.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < parseArray.size(); i2++) {
            String string = parseArray.getString(i2);
            if (H5PatternHelper.matchRegex(string, str)) {
                H5Log.d(TAG, "matchRegex regex : " + string + " path : " + str);
                z = true;
            }
        }
        return z;
    }
}
