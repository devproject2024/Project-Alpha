package com.alipay.mobile.nebulacore.dev.trace;

import com.alipay.mobile.nebula.util.H5Log;
import com.business.merchant_payments.utility.StringUtility;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class H5PerformanceUtils {
    private static final String TAG = "H5PerformanceUtils";
    private static int sCoreNum;

    private H5PerformanceUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = r5.getRootView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap takeScreenShot(com.alipay.mobile.h5container.api.H5Page r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.view.View r1 = r5.getRootView()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            int r2 = r1.getWidth()
            int r2 = r2 / 2
            int r3 = r1.getHeight()
            int r3 = r3 / 2
            if (r2 <= 0) goto L_0x003f
            if (r3 > 0) goto L_0x001c
            goto L_0x003f
        L_0x001c:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r2, r3, r5)
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r5)
            android.os.ConditionVariable r2 = new android.os.ConditionVariable
            r2.<init>()
            r3 = 1056964608(0x3f000000, float:0.5)
            r0.scale(r3, r3)
            com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils$1 r3 = new com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils$1
            r3.<init>(r1, r0, r2)
            com.alipay.mobile.nebula.util.H5Utils.runOnMain(r3)
            r0 = 5000(0x1388, double:2.4703E-320)
            r2.block(r0)
            return r5
        L_0x003f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "cannot takeScreenShot for url "
            r1.<init>(r4)
            java.lang.String r5 = r5.getUrl()
            r1.append(r5)
            java.lang.String r5 = " width: "
            r1.append(r5)
            r1.append(r2)
            java.lang.String r5 = ", height: "
            r1.append(r5)
            r1.append(r3)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "H5PerformanceUtils"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils.takeScreenShot(com.alipay.mobile.h5container.api.H5Page):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a A[SYNTHETIC, Splitter:B:27:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0056 A[SYNTHETIC, Splitter:B:34:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getRamSize() {
        /*
            java.lang.String r0 = "H5PerformanceUtils"
            r1 = 0
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.lang.String r6 = "/proc/meminfo"
            r5.<init>(r6)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r6 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.lang.String r3 = r4.readLine()     // Catch:{ Exception -> 0x003c }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x003c }
            if (r5 == 0) goto L_0x0026
            r4.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r3 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r3)
        L_0x0025:
            return r1
        L_0x0026:
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x003c }
            r5 = 1
            r3 = r3[r5]     // Catch:{ Exception -> 0x003c }
            long r1 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r3)
        L_0x003b:
            return r1
        L_0x003c:
            r3 = move-exception
            goto L_0x0045
        L_0x003e:
            r1 = move-exception
            r4 = r3
            goto L_0x0054
        L_0x0041:
            r4 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
        L_0x0045:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0052
            r4.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r3)
        L_0x0052:
            return r1
        L_0x0053:
            r1 = move-exception
        L_0x0054:
            if (r4 == 0) goto L_0x005e
            r4.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r2 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x005e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils.getRamSize():long");
    }

    public static int getNumCores() {
        if (sCoreNum == 0) {
            try {
                sCoreNum = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return Pattern.matches("cpu[0-9]", file.getName());
                    }
                }).length;
            } catch (Exception e2) {
                H5Log.e(TAG, "getNumCores exception", e2);
                sCoreNum = 1;
            }
        }
        return sCoreNum;
    }

    public static List<String> getAllThreadsTraces() {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                StringBuilder sb = new StringBuilder();
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                String name = ((Thread) next.getKey()).getName();
                sb.append("ThreadName=");
                sb.append(name);
                sb.append(StringUtility.NEW_LINE);
                for (StackTraceElement valueOf : stackTraceElementArr) {
                    sb.append(String.valueOf(valueOf));
                    sb.append(StringUtility.NEW_LINE);
                }
                sb.append(StringUtility.NEW_LINE);
                arrayList.add(sb.toString());
            }
            return arrayList;
        } catch (Throwable th) {
            H5Log.e(TAG, "getAllStackTraces", th);
            return null;
        }
    }
}
