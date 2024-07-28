package com.alipay.mobile.nebulacore.log;

import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H5PerformanceScheduler {
    private static final String TAG = "H5PerformanceScheduler";
    /* access modifiers changed from: private */
    public static H5PerformanceLog pendingH5Log;

    public static void appendHeadScreen(Object obj) {
        H5Log.d(TAG, "Got headScreen, update archive!");
        H5PerformanceLog h5PerformanceLog = pendingH5Log;
        if (h5PerformanceLog != null) {
            h5PerformanceLog.setPerformanceData("headScreen", obj);
        }
    }

    public static void scheduleH5PerfLog(final H5PerformanceLog h5PerformanceLog) {
        if (h5PerformanceLog != null) {
            pendingH5Log = null;
            if (h5PerformanceLog.getPerformanceData("headScreen") != null) {
                H5Log.d(TAG, "Already has headScreen, direct sent!");
                H5Utils.getExecutor(H5ThreadType.IO).execute(h5PerformanceLog);
                return;
            }
            H5Log.d(TAG, "Do not has headScreen, put into archive!");
            ScheduledThreadPoolExecutor scheduledExecutor = H5Utils.getScheduledExecutor();
            if (scheduledExecutor != null) {
                pendingH5Log = h5PerformanceLog;
                scheduledExecutor.schedule(new Runnable() {
                    public final void run() {
                        h5PerformanceLog.run();
                        H5PerformanceLog unused = H5PerformanceScheduler.pendingH5Log = null;
                    }
                }, 3, TimeUnit.SECONDS);
            }
        }
    }
}
