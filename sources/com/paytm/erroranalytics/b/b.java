package com.paytm.erroranalytics.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.erroranalytics.c.a.a.a;
import com.paytm.erroranalytics.e;
import net.one97.paytm.upi.util.UpiContract;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f42707a;

    /* renamed from: b  reason: collision with root package name */
    private static String f42708b;

    public static String a(Context context) {
        String str = f42708b;
        if (str != null) {
            return str;
        }
        if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)).getDeviceId();
            f42708b = deviceId;
            if (!TextUtils.isEmpty(deviceId)) {
                return f42708b;
            }
        } catch (Exception unused) {
            String str2 = e.f42808a;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            f42708b = string;
            if (!TextUtils.isEmpty(string)) {
                return f42708b;
            }
        } catch (Exception unused2) {
            String str3 = e.f42808a;
        }
        return null;
    }

    public static String b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return H5Utils.NETWORK_TYPE_WIFI;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return H5Utils.NETWORK_TYPE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return H5Utils.NETWORK_TYPE_3G;
                            case 13:
                                return H5Utils.NETWORK_TYPE_4G;
                            default:
                                return null;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
            return null;
        }
    }

    public static int c(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i2 = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(H5PermissionManager.level, -1) : -1;
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("scale", -1);
        }
        return Math.round((((float) intExtra) / ((float) i2)) * 100.0f);
    }

    public static int a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        return Math.round((((float) (statFs.getAvailableBlocksLong() * blockSizeLong)) / ((float) (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()))) * 100.0f);
    }
}
