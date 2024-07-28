package net.one97.paytm.h5paytmsdk.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public final class f {
    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = "";
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    str = next.processName;
                }
            }
        }
        return str;
    }

    public static boolean a(Context context) {
        return TextUtils.equals(context.getPackageName(), b(context));
    }
}
