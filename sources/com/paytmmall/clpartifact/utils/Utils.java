package com.paytmmall.clpartifact.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class Utils {
    public static final String KEY_KYC_NAME = "bank_kyc_name";
    public static final String TAG = Utils.class.getSimpleName();

    public static float dp2px(float f2) {
        int i2;
        try {
            i2 = (int) (f2 * Resources.getSystem().getDisplayMetrics().density);
        } catch (Exception unused) {
            i2 = 0;
        }
        return (float) i2;
    }

    public static String getImageUrlWithScalingParameter(String str, int i2) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("imwidth", String.valueOf(Math.abs(i2))).build().toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage(), e2);
            return str;
        }
    }

    public static void setStatusBarColor(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && activity.getWindow() != null) {
            activity.getWindow().setStatusBarColor(i2);
        }
    }

    public static String getCSVValue(Iterable<String> iterable) {
        StringBuilder sb = new StringBuilder();
        for (String str : iterable) {
            sb.append(str + AppConstants.COMMA);
        }
        return sb.toString().substring(0, sb.length() > 0 ? sb.length() - 1 : 0);
    }

    public static String getKYCName(Context context) {
        return a.a(CLPArtifact.getInstance().getContext().getApplicationContext(), a.c.HOME).b(KEY_KYC_NAME, "", true);
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void assertBackgroundThread() {
        if (isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }
}
