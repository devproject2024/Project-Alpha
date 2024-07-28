package com.alipay.mobile.nebulacore.appcenter.parse;

import android.os.Bundle;
import android.os.ConditionVariable;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5ContentPackagePool {
    public static final String TAG = "H5ContentPackagePool";
    private static Map<String, H5ContentPackage> packagePool = new ConcurrentHashMap();

    public static void preparePackage(Bundle bundle, boolean z, ConditionVariable conditionVariable) {
        String string = H5Utils.getString(bundle, H5Param.SESSION_ID);
        H5Log.d(TAG, "prepare package ".concat(String.valueOf(string)));
        if (packagePool.containsKey(string)) {
            H5Log.w(TAG, "package " + string + " already exists.");
            return;
        }
        H5ContentPackage h5ContentPackage = new H5ContentPackage(bundle, true, z, false);
        packagePool.put(string, h5ContentPackage);
        h5ContentPackage.prepareContent(conditionVariable);
    }

    public static void clearPackage(String str) {
        if (!packagePool.containsKey(str)) {
            H5Log.d(TAG, "clearPackage packagePool not contain ".concat(String.valueOf(str)));
            return;
        }
        H5Log.d(TAG, "consumePackage ".concat(String.valueOf(str)));
        packagePool.remove(str);
    }

    public static H5ContentPackage getPackage(String str) {
        if (!packagePool.containsKey(str)) {
            H5Log.d(TAG, "getPackage packagePool not contain ".concat(String.valueOf(str)));
            return null;
        }
        H5Log.d(TAG, "getPackage ".concat(String.valueOf(str)));
        return packagePool.get(str);
    }
}
