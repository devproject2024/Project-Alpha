package com.alipay.mobile.nebula.util;

import android.os.Build;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class H5DeviceHelper {
    public static final String TAG = "H5DeviceHelper";
    private static String sAbi;
    private static String[] sAbiList;
    private static String sArch;
    private static String sCpuAbi;
    private static String sCpuHardware;
    private static Boolean sIsX86;
    private static String[] sSupportedABIs;

    public static synchronized boolean x86(int i2) {
        synchronized (H5DeviceHelper.class) {
            try {
                if (sIsX86 != null) {
                    boolean booleanValue = sIsX86.booleanValue();
                    return booleanValue;
                } else if (i2 == 1) {
                    boolean isX86Device = isX86Device();
                    return isX86Device;
                } else {
                    boolean isX86DeviceV2 = isX86DeviceV2();
                    return isX86DeviceV2;
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r3 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        r2 = r3;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2 = java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abilist");
        r6 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r4 = new java.io.BufferedReader(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r5 = r4.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0085, code lost:
        if (r5 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (r5.isEmpty() != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008d, code lost:
        r5 = r5.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r5[0].contains("x86") == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009b, code lost:
        sIsX86 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a6, code lost:
        if (r5[0].contains("arm") == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a8, code lost:
        sIsX86 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ac, code lost:
        com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4);
        com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b2, code lost:
        if (r2 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b5, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b6, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5);
        com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00bf, code lost:
        if (r2 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c1, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c4, code lost:
        r0 = java.lang.System.getProperty("os.arch");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ca, code lost:
        if (r0 == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d0, code lost:
        if (r0.contains("x86") == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d2, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d3, code lost:
        r0 = java.lang.Boolean.valueOf(r3);
        sIsX86 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00dd, code lost:
        return r0.booleanValue();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isX86Device() {
        /*
            java.lang.String r0 = "arm"
            java.lang.String r1 = "x86"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "getprop ro.product.cpu.abi"
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ all -> 0x0050 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x004d }
            java.io.InputStream r5 = r3.getInputStream()     // Catch:{ all -> 0x004d }
            r4.<init>(r5)     // Catch:{ all -> 0x004d }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x004a }
            r5.<init>(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = r5.readLine()     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x003f
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0048 }
            if (r7 != 0) goto L_0x003f
            boolean r7 = r6.contains(r1)     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x0035
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0048 }
            sIsX86 = r6     // Catch:{ all -> 0x0048 }
            goto L_0x003f
        L_0x0035:
            boolean r6 = r6.contains(r0)     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x003f
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0048 }
            sIsX86 = r6     // Catch:{ all -> 0x0048 }
        L_0x003f:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
            if (r3 == 0) goto L_0x0067
            goto L_0x0063
        L_0x0048:
            r6 = move-exception
            goto L_0x0054
        L_0x004a:
            r6 = move-exception
            r5 = r2
            goto L_0x0054
        L_0x004d:
            r6 = move-exception
            r4 = r2
            goto L_0x0053
        L_0x0050:
            r6 = move-exception
            r3 = r2
            r4 = r3
        L_0x0053:
            r5 = r4
        L_0x0054:
            java.lang.String r7 = "H5DeviceHelper"
            java.lang.String r8 = "exception detail"
            com.alipay.mobile.nebula.util.H5Log.e(r7, r8, r6)     // Catch:{ all -> 0x00de }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
            if (r3 == 0) goto L_0x0067
        L_0x0063:
            r3.destroy()
            goto L_0x0068
        L_0x0067:
            r2 = r3
        L_0x0068:
            r3 = 0
            java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = "getprop ro.product.cpu.abilist"
            java.lang.Process r2 = r6.exec(r7)     // Catch:{ all -> 0x00b8 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x00b8 }
            java.io.InputStream r7 = r2.getInputStream()     // Catch:{ all -> 0x00b8 }
            r6.<init>(r7)     // Catch:{ all -> 0x00b8 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00b6 }
            r4.<init>(r6)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x00b5 }
            if (r5 == 0) goto L_0x00ac
            boolean r7 = r5.isEmpty()     // Catch:{ all -> 0x00b5 }
            if (r7 != 0) goto L_0x00ac
            java.lang.String r7 = ","
            java.lang.String[] r5 = r5.split(r7)     // Catch:{ all -> 0x00b5 }
            r7 = r5[r3]     // Catch:{ all -> 0x00b5 }
            boolean r7 = r7.contains(r1)     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x00a0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b5 }
            sIsX86 = r0     // Catch:{ all -> 0x00b5 }
            goto L_0x00ac
        L_0x00a0:
            r5 = r5[r3]     // Catch:{ all -> 0x00b5 }
            boolean r0 = r5.contains(r0)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00ac
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b5 }
            sIsX86 = r0     // Catch:{ all -> 0x00b5 }
        L_0x00ac:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r6)
            if (r2 == 0) goto L_0x00c4
            goto L_0x00c1
        L_0x00b5:
            r5 = r4
        L_0x00b6:
            r4 = r6
            goto L_0x00b9
        L_0x00b8:
        L_0x00b9:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
            if (r2 == 0) goto L_0x00c4
        L_0x00c1:
            r2.destroy()
        L_0x00c4:
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x00d3
            r3 = 1
        L_0x00d3:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            sIsX86 = r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x00de:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
            if (r3 == 0) goto L_0x00ea
            r3.destroy()
        L_0x00ea:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5DeviceHelper.isX86Device():boolean");
    }

    private static boolean isX86DeviceV2() {
        sIsX86 = Boolean.valueOf(isArchContains("x86"));
        H5Log.d(TAG, "isX86DeviceV2 " + sIsX86);
        return sIsX86.booleanValue();
    }

    private static boolean isArchContains(String str) {
        String fromSystemProp;
        if (sArch == null) {
            sArch = System.getProperty("os.arch");
        }
        String str2 = sArch;
        if (str2 != null && str2.toLowerCase().contains(str)) {
            return true;
        }
        if (sAbi == null) {
            try {
                sAbi = Build.CPU_ABI;
            } catch (Exception e2) {
                H5Log.e(TAG, "exception ", e2);
            }
        }
        String str3 = sAbi;
        if (str3 != null && str3.toLowerCase().contains(str)) {
            return true;
        }
        if (sSupportedABIs == null && Build.VERSION.SDK_INT >= 21) {
            try {
                sSupportedABIs = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            } catch (Exception e3) {
                H5Log.e(TAG, "exception ", e3);
            }
        }
        String[] strArr = sSupportedABIs;
        if (strArr != null && strArr.length > 0 && strArr[0] != null && strArr[0].toLowerCase().contains(str)) {
            return true;
        }
        if (sCpuAbi == null) {
            sCpuAbi = getFromSystemProp("ro.product.cpu.abi");
        }
        String str4 = sCpuAbi;
        if (str4 != null && str4.toLowerCase().contains(str)) {
            return true;
        }
        if (!(sAbiList != null || (fromSystemProp = getFromSystemProp("ro.product.cpu.abilist")) == null || fromSystemProp.length() == 0)) {
            sAbiList = fromSystemProp.split(AppConstants.COMMA);
        }
        String[] strArr2 = sAbiList;
        if (strArr2 == null || strArr2.length <= 0 || strArr2[0] == null || !strArr2[0].toLowerCase().contains(str)) {
            return false;
        }
        return true;
    }

    private static String getFromSystemProp(String str) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        try {
            fileInputStream = new FileInputStream(new File("/system/build.prop"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                bufferedReader = null;
                try {
                    H5Log.e(TAG, "exception ", th);
                    H5IOUtils.closeQuietly(bufferedReader);
                    H5IOUtils.closeQuietly(inputStreamReader);
                    H5IOUtils.closeQuietly(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    H5IOUtils.closeQuietly(bufferedReader);
                    H5IOUtils.closeQuietly(inputStreamReader);
                    H5IOUtils.closeQuietly(fileInputStream);
                    throw th2;
                }
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains(str)) {
                            String[] split = readLine.split("=");
                            if (split.length == 2 && split[0].trim().equals(str)) {
                                String trim = split[1].trim();
                                H5IOUtils.closeQuietly(bufferedReader);
                                H5IOUtils.closeQuietly(inputStreamReader);
                                H5IOUtils.closeQuietly(fileInputStream);
                                return trim;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        H5Log.e(TAG, "exception ", th);
                        H5IOUtils.closeQuietly(bufferedReader);
                        H5IOUtils.closeQuietly(inputStreamReader);
                        H5IOUtils.closeQuietly(fileInputStream);
                        return null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                H5Log.e(TAG, "exception ", th);
                H5IOUtils.closeQuietly(bufferedReader);
                H5IOUtils.closeQuietly(inputStreamReader);
                H5IOUtils.closeQuietly(fileInputStream);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
            H5Log.e(TAG, "exception ", th);
            H5IOUtils.closeQuietly(bufferedReader);
            H5IOUtils.closeQuietly(inputStreamReader);
            H5IOUtils.closeQuietly(fileInputStream);
            return null;
        }
        H5IOUtils.closeQuietly(bufferedReader);
        H5IOUtils.closeQuietly(inputStreamReader);
        H5IOUtils.closeQuietly(fileInputStream);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuHardware() {
        /*
            java.lang.String r0 = "H5DeviceHelper"
            java.lang.String r1 = sCpuHardware
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.lang.String r5 = "/proc/cpuinfo"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
        L_0x0018:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x0033 }
            if (r4 != 0) goto L_0x0024
            java.lang.String r4 = "/proc/cpuinfo lacks a Hardware entry, use Build.BOARD"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r4)     // Catch:{ Exception -> 0x0033 }
            goto L_0x003f
        L_0x0024:
            java.lang.String r5 = "Hardware\t: "
            boolean r5 = r4.startsWith(r5)     // Catch:{ Exception -> 0x0033 }
            if (r5 == 0) goto L_0x0018
            r5 = 11
            java.lang.String r2 = r4.substring(r5)     // Catch:{ Exception -> 0x0033 }
            goto L_0x003f
        L_0x0033:
            r4 = move-exception
            goto L_0x003a
        L_0x0035:
            r0 = move-exception
            r3 = r2
            goto L_0x0055
        L_0x0038:
            r4 = move-exception
            r3 = r2
        L_0x003a:
            java.lang.String r5 = "Cannot get Hardware from /proc/cpuinfo"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r5, r4)     // Catch:{ all -> 0x0054 }
        L_0x003f:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
            android.os.StrictMode.setThreadPolicy(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x004d
            java.lang.String r2 = android.os.Build.BOARD
        L_0x004d:
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = ""
        L_0x0051:
            sCpuHardware = r2
            return r2
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
            android.os.StrictMode.setThreadPolicy(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5DeviceHelper.getCpuHardware():java.lang.String");
    }
}
