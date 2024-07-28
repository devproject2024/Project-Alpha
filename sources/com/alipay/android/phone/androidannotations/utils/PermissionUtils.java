package com.alipay.android.phone.androidannotations.utils;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;

public class PermissionUtils {
    public static boolean hasSelfPermissions(Context context, String... strArr) {
        return true;
    }

    private PermissionUtils() {
    }

    public static boolean verifyPermissions(int... iArr) {
        for (int i2 : iArr) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i2) {
        getNeedCheckPermissions(activity, strArr);
    }

    public static String[] getNeedCheckPermissions(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!hasSelfPermissions(context, str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
