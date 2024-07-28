package net.one97.paytm.nativesdk.Utils;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.a;

public class PermissionUtil {
    public static final int REQUEST_PERMISSION_DO_NOT_SHOW_RATIONALE = 0;
    public static final int REQUEST_PERMISSION_SHOW_RATIONALE = 1;
    public static final int REQUEST_PHONE_STATE = 2;
    public static final int REQUEST_RECEIVE_SMS = 1;

    public static boolean checkReceiveSMSPermission(Context context) {
        return a.a(context, "android.permission.RECEIVE_SMS") == 0;
    }

    public static void requestReceiveSMSPermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.RECEIVE_SMS"}, 1);
    }

    public static boolean checkPhoneStatePermission(Context context) {
        return a.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static void requestPhoneStatePermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 2);
    }

    public static int shouldShowRequestPermissionRationaleState(String[] strArr, int[] iArr, String str, Activity activity) {
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            if (iArr[i2] != -1) {
                i2++;
            } else if (!a.a(activity, str2)) {
                return 0;
            } else {
                if (str.equals(str2)) {
                    return 1;
                }
                return -1;
            }
        }
        return -1;
    }

    public static boolean checkingPermissionIsEnabledOrNotForSmsPhoneState(Context context) {
        return a.a(context, "android.permission.READ_PHONE_STATE") == 0 && a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static void requestPermissionIsEnabledOrNotForSmsPhoneState(Activity activity) {
        a.a(activity, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1);
    }
}
