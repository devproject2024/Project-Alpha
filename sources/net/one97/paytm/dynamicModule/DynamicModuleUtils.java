package net.one97.paytm.dynamicModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleUtils {
    private static final String TAG = "PlayCore-DFMUtils";

    public static long getAvailableInternalMemorySizeInMB() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576;
    }

    public static int getBatteryPercentage(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i2 = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(H5PermissionManager.level, -1) : -1;
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("scale", -1);
        }
        return (int) ((((double) intExtra) / ((double) i2)) * 100.0d);
    }

    public static boolean isBatteryCharging(Context context) {
        int intExtra = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean isFastInternetConnection(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        if (activeNetworkInfo.getType() != 1) {
            if (activeNetworkInfo.getType() != 0) {
                return false;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 8:
                case 9:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean isEligibleForInitialBackgroundInstall() {
        Context appContext = CJRJarvisApplication.getAppContext();
        long availableInternalMemorySizeInMB = getAvailableInternalMemorySizeInMB();
        int batteryPercentage = getBatteryPercentage(appContext);
        boolean isBatteryCharging = isBatteryCharging(appContext);
        boolean isFastInternetConnection = isFastInternetConnection(appContext);
        if (availableInternalMemorySizeInMB >= 200) {
            return (batteryPercentage >= 20 || isBatteryCharging) && isFastInternetConnection;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC, Splitter:B:20:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0040=Splitter:B:24:0x0040, B:17:0x0031=Splitter:B:17:0x0031} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String loadJSONFromAsset(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x003e, Exception -> 0x002f, all -> 0x002c }
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x003e, Exception -> 0x002f, all -> 0x002c }
            int r4 = r3.available()     // Catch:{ IOException -> 0x002a, Exception -> 0x0028 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x002a, Exception -> 0x0028 }
            r3.read(r4)     // Catch:{ IOException -> 0x002a, Exception -> 0x0028 }
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x002a, Exception -> 0x0028 }
            java.lang.String r2 = "UTF-8"
            r1.<init>(r4, r2)     // Catch:{ IOException -> 0x002a, Exception -> 0x0028 }
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x0027:
            return r1
        L_0x0028:
            r4 = move-exception
            goto L_0x0031
        L_0x002a:
            r4 = move-exception
            goto L_0x0040
        L_0x002c:
            r4 = move-exception
            r3 = r0
            goto L_0x0057
        L_0x002f:
            r4 = move-exception
            r3 = r0
        L_0x0031:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0056 }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x0055
            r3.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0055
        L_0x003e:
            r4 = move-exception
            r3 = r0
        L_0x0040:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0056 }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x0055
            r3.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x0055:
            return r0
        L_0x0056:
            r4 = move-exception
        L_0x0057:
            if (r3 == 0) goto L_0x0065
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0065
        L_0x005d:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x0065:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.DynamicModuleUtils.loadJSONFromAsset(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String getRequestFailedErrorMsg(Context context, DynamicModuleManager.REQUEST_FAILED request_failed) {
        switch (request_failed) {
            case NETWORK_ERROR:
                return context.getString(R.string.err_enable_network_heading);
            case INSUFFICIENT_STORAGE:
                return context.getString(R.string.lbl_Insufficient_storage);
            case SERVICE_DIED:
                return context.getString(R.string.error_something_went_wrong);
            case ACCESS_DENIED:
                return context.getString(R.string.error_dd_access_denied);
            case MODULE_UNAVAILABLE:
                return context.getString(R.string.dd_beta_error_message);
            case API_NOT_AVAILABLE:
                return context.getString(R.string.dd_beta_error_message);
            default:
                return context.getString(R.string.error_something_went_wrong);
        }
    }
}
