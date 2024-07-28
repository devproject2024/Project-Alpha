package net.one97.paytm.upi.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.a;
import androidx.fragment.app.Fragment;

public abstract class PermissionUtil {
    public static final int REQUEST_CODE_ACCESS_LOCATION = 57;
    public static final int REQUEST_CODE_CAMERA = 51;
    public static final int REQUEST_CODE_GET_ACCOUNTS = 54;
    public static final int REQUEST_CODE_PHONE_STATE = 52;
    public static final int REQUEST_CODE_READ_CONTACTS = 53;
    public static final int REQUEST_CODE_READ_SMS = 55;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 56;
    public static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_SAVE_QR = 58;
    public static final int REQUEST_PERMISSION_DO_NOT_SHOW_RATIONALE = 0;
    public static final int REQUEST_PERMISSION_SHOW_RATIONALE = 1;

    public void showDialogForPermissionSettings(String str) {
    }

    public static boolean verifyPermissions(int[] iArr) {
        if (iArr.length <= 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
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

    public static boolean isVersionMarshmallowAndAbove() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isVersionOreoAndAbove() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isVersionNougatAndAbove() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean checkReadPhoneStatePermission(Context context) {
        return a.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static void requestReadPhoneStatePermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 52);
    }

    public static boolean checkCameraPermission(Activity activity) {
        return a.a((Context) activity, "android.permission.CAMERA") == 0;
    }

    public static void requestCameraPermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.CAMERA"}, 51);
    }

    public static void openAppSettingPage(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        context.startActivity(intent);
    }

    public static void openAppSettingPage(Activity activity, int i2) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivityForResult(intent, i2);
    }

    public static void openAppSettingPage(Fragment fragment, int i2) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.getActivity().getPackageName(), (String) null));
        fragment.startActivityForResult(intent, i2);
    }

    public static boolean checkReadContactsPermission(Context context) {
        return a.a(context, "android.permission.READ_CONTACTS") == 0;
    }

    public static void requestReadContactsPermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.READ_CONTACTS"}, 53);
    }

    public static boolean checkPhoneStatePermission(Activity activity) {
        return a.a((Context) activity, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static void requestWriteExternalPermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 56);
    }

    public static void requestWriteExternalPermissionSaveQr(Activity activity) {
        a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 58);
    }

    public static boolean checkWriteExternalStoragePermission(Activity activity) {
        return a.a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean checkGetAccountsPermission(Activity activity) {
        return a.a((Context) activity, "android.permission.GET_ACCOUNTS") == 0;
    }

    public static boolean checkReadSmsPermission(Context context) {
        return a.a(context, "android.permission.READ_SMS") == 0;
    }

    public static void requestAccessLocationPermission(Activity activity) {
        a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 57);
    }

    public static boolean checkAccessLocationPermission(Context context) {
        return a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean checkWriteContactPermission(Activity activity) {
        return a.a((Context) activity, "android.permission.WRITE_CONTACTS") == 0;
    }

    public static boolean checkTelephonyPermission(Context context) {
        return a.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean checkOreoPermission(Context context) {
        return !isVersionOreoAndAbove() || checkReadContactsPermission(context);
    }

    public static boolean areAllPermissionsGranted(int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasSelectedNeverShowThisAgain(Activity activity, String str) {
        if (activity == null || activity.isFinishing() || a.a(activity, str) || a.a((Context) activity, str) != -1) {
            return false;
        }
        return true;
    }
}
