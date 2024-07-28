package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.internel;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception.SheroesSdkNotInitializedException;

public class Validate {
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG = Validate.class.getName();

    public static void sdkInitialized() {
        if (!SheroesSdk.isInitialized()) {
            throw new SheroesSdkNotInitializedException("The SDK has not been initialized, make sure to call SheroesSdk.sdkInitialize() first.");
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    public static void hasInternetPermissions(Context context) {
        hasInternetPermissions(context, true);
    }

    public static void hasInternetPermissions(Context context, boolean z) {
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1 && z) {
            throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
        }
    }
}
