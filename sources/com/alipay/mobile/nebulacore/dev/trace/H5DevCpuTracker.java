package com.alipay.mobile.nebulacore.dev.trace;

import android.os.Process;
import android.text.TextUtils;

public class H5DevCpuTracker {
    private static final String TAG = "H5DevCpuTracker";
    private static H5DevCpuTracker h5DevCpuTracker;
    private long mDeltaIdleTime;
    private long mDeltaProcTime;
    private long mDeltaTotalTime;
    private long mLastIdleTime;
    private long mLastProcTime;
    private long mLastTotalTime;
    private int mPid = Process.myPid();

    public static H5DevCpuTracker getInstance() {
        if (h5DevCpuTracker == null) {
            h5DevCpuTracker = new H5DevCpuTracker();
        }
        return h5DevCpuTracker;
    }

    private H5DevCpuTracker() {
        reset();
    }

    public void reset() {
        this.mLastIdleTime = 0;
        this.mLastTotalTime = 0;
        this.mLastProcTime = 0;
        this.mDeltaIdleTime = 0;
        this.mDeltaIdleTime = 0;
        this.mDeltaTotalTime = 0;
        this.mDeltaProcTime = 0;
    }

    public void updateSystem() {
        String statFileFirstLine = getStatFileFirstLine("/proc/stat");
        if (!TextUtils.isEmpty(statFileFirstLine)) {
            String[] split = statFileFirstLine.split(" ");
            if (split.length >= 9) {
                try {
                    long parseLong = Long.parseLong(split[2]);
                    long parseLong2 = Long.parseLong(split[3]);
                    long parseLong3 = Long.parseLong(split[4]);
                    long parseLong4 = Long.parseLong(split[5]);
                    long parseLong5 = Long.parseLong(split[6]);
                    long parseLong6 = parseLong + parseLong2 + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                    this.mDeltaIdleTime = parseLong4 - this.mLastIdleTime;
                    this.mDeltaTotalTime = parseLong6 - this.mLastTotalTime;
                    this.mLastIdleTime = parseLong4;
                    this.mLastTotalTime = parseLong6;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void updateProcess() {
        String statFileFirstLine = getStatFileFirstLine("/proc/" + this.mPid + "/stat");
        if (!TextUtils.isEmpty(statFileFirstLine)) {
            String[] split = statFileFirstLine.split(" ");
            if (split.length >= 17) {
                try {
                    long parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                    this.mDeltaProcTime = parseLong - this.mLastProcTime;
                    this.mLastProcTime = parseLong;
                } catch (Throwable unused) {
                }
                updateSystem();
            }
        }
    }

    public float getSystemCpuUsagePercent() {
        long j = this.mDeltaTotalTime;
        if (j > 0) {
            return (((float) (j - this.mDeltaIdleTime)) * 100.0f) / ((float) j);
        }
        return -1.0f;
    }

    public float getProcessCpuUsagePercent() {
        long j = this.mDeltaTotalTime;
        if (j > 0) {
            return (((float) this.mDeltaProcTime) * 100.0f) / ((float) j);
        }
        return -1.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r3 != null) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getStatFileFirstLine(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0015 }
            r1.<init>(r3)     // Catch:{ all -> 0x0015 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0015 }
            r3.<init>(r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x0013 }
        L_0x000f:
            r3.close()     // Catch:{ all -> 0x0019 }
            goto L_0x0019
        L_0x0013:
            goto L_0x0016
        L_0x0015:
            r3 = r0
        L_0x0016:
            if (r3 == 0) goto L_0x0019
            goto L_0x000f
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.trace.H5DevCpuTracker.getStatFileFirstLine(java.lang.String):java.lang.String");
    }
}
