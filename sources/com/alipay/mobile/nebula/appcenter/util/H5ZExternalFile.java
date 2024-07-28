package com.alipay.mobile.nebula.appcenter.util;

import android.content.Context;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5BaseFile;
import com.alipay.mobile.nebula.util.H5Utils;
import java.io.File;

public class H5ZExternalFile extends H5BaseFile {
    private static final String CAN_USE_SYS_PATH = "yes";
    protected static final String ExtDataTunnel = "ExtDataTunnel";
    private static final String KEY_CAN_USE_SYS_PATH = "h5_download_can_use_sys_path";
    private static final String KEY_TRY_CREATE_ENABLE = "h5_try_create_file_enable";
    protected static final String SYS_DOWNLOAD_PATH = "/nebulaDownloads";
    private static final String TEST_APP_NAME = "try_create_test_app";
    private static final String TRY_CREATE_ENABLE = "yes";
    private static final String Tag = "H5ZExternalFile";
    private static final long serialVersionUID = -3489082633723468737L;
    private static volatile boolean tryCreateSucceeded = false;

    public H5ZExternalFile(Context context, String str, String str2, String str3) {
        super(buildPath(context, str, str2, str3));
    }

    public H5ZExternalFile(Context context, String str, String str2) {
        super(buildPath(context, str, str2, (String) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0124 A[SYNTHETIC, Splitter:B:49:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0187  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String buildPath(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            if (r8 == 0) goto L_0x01e9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x01e9
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x0010
            goto L_0x01e9
        L_0x0010:
            r0 = 0
            java.io.File r0 = r8.getExternalFilesDir(r9)     // Catch:{ Exception -> 0x0016 }
            goto L_0x004a
        L_0x0016:
            r1 = move-exception
            java.lang.String r2 = "H5ZExternalFile"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r2, (java.lang.Throwable) r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r2.<init>()
            java.lang.String r3 = "ContainerCreateFileFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.exceptionType(r3)
            java.lang.String r3 = "get external files dir exception"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendMessage(r3)
            java.lang.Class r3 = r1.getClass()
            java.lang.String r3 = r3.getName()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendExceptionName(r3)
            java.lang.String r1 = r1.getMessage()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r2.appendExceptionMessage(r1)
            java.lang.String r2 = "groupId"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendExtParams(r2, r9)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r1)
        L_0x004a:
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0102
            java.lang.String r3 = "h5_try_create_file_enable"
            java.lang.String r4 = "yes"
            boolean r3 = configEnabled(r3, r4)
            if (r3 == 0) goto L_0x0102
            java.lang.String r3 = "H5ZExternalFile"
            java.lang.String r4 = "try to create file is enabled"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r4)
            boolean r3 = tryCreateSucceeded
            if (r3 != 0) goto L_0x0102
            java.lang.Class<com.alipay.mobile.nebula.appcenter.util.H5ZExternalFile> r3 = com.alipay.mobile.nebula.appcenter.util.H5ZExternalFile.class
            monitor-enter(r3)
            boolean r4 = tryCreateSucceeded     // Catch:{ all -> 0x00ff }
            if (r4 != 0) goto L_0x00fc
            java.lang.String r4 = "H5ZExternalFile"
            java.lang.String r5 = "start to try to create file"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r5)     // Catch:{ all -> 0x00ff }
            java.lang.String r4 = concatPath(r0, r11, r10)     // Catch:{ Exception -> 0x00ef }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00ef }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00ef }
            r5.mkdirs()     // Catch:{ Exception -> 0x00ef }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ef }
            r5.<init>()     // Catch:{ Exception -> 0x00ef }
            r5.append(r4)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = "/try_create_test_app-"
            r5.append(r4)     // Catch:{ Exception -> 0x00ef }
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            java.lang.String r4 = r4.replace(r6, r7)     // Catch:{ Exception -> 0x00ef }
            r5.append(r4)     // Catch:{ Exception -> 0x00ef }
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            java.lang.String r4 = r4.replace(r6, r7)     // Catch:{ Exception -> 0x00ef }
            r5.append(r4)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00ef }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00ef }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r6 = "H5ZExternalFile"
            java.lang.String r7 = "try to create file path: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r7.concat(r4)     // Catch:{ Exception -> 0x00ef }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r4)     // Catch:{ Exception -> 0x00ef }
            boolean r4 = r5.createNewFile()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r6 = "H5ZExternalFile"
            java.lang.String r7 = "try to create file path result: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = r7.concat(r4)     // Catch:{ Exception -> 0x00ef }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r4)     // Catch:{ Exception -> 0x00ef }
            tryCreateSucceeded = r2     // Catch:{ Exception -> 0x00ef }
            r5.delete()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00fc
        L_0x00e6:
            r4 = move-exception
            java.lang.String r5 = "H5ZExternalFile"
            java.lang.String r6 = "delete file exception"
            com.alipay.mobile.nebula.util.H5Log.e(r5, r6, r4)     // Catch:{ Exception -> 0x00ef }
            goto L_0x00fc
        L_0x00ef:
            r4 = move-exception
            java.lang.String r5 = "H5ZExternalFile"
            java.lang.String r6 = "try to create file exception"
            com.alipay.mobile.nebula.util.H5Log.e(r5, r6, r4)     // Catch:{ all -> 0x00ff }
            tryCreateSucceeded = r1     // Catch:{ all -> 0x00ff }
            r4 = 0
            goto L_0x00fd
        L_0x00fc:
            r4 = 1
        L_0x00fd:
            monitor-exit(r3)     // Catch:{ all -> 0x00ff }
            goto L_0x0103
        L_0x00ff:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ff }
            throw r8
        L_0x0102:
            r4 = 1
        L_0x0103:
            if (r0 == 0) goto L_0x0107
            if (r4 != 0) goto L_0x01e4
        L_0x0107:
            java.lang.String r0 = "H5ZExternalFile"
            java.lang.String r3 = "externalFilesDir is null"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r3)
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r0 = r8.checkCallingOrSelfPermission(r0)
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = "h5_download_can_use_sys_path"
            java.lang.String r3 = "yes"
            boolean r0 = configEnabled(r0, r3)
            if (r0 == 0) goto L_0x0122
            r1 = 1
        L_0x0122:
            if (r1 == 0) goto L_0x0187
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r9.<init>()     // Catch:{ Exception -> 0x0154 }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x0154 }
            r9.append(r8)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = "/nebulaDownloads"
            r9.append(r8)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0154 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0154 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = "H5ZExternalFile"
            java.lang.String r1 = "use system storage: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r1.concat(r8)     // Catch:{ Exception -> 0x0154 }
            com.alipay.mobile.nebula.util.H5Log.d(r9, r8)     // Catch:{ Exception -> 0x0154 }
            goto L_0x01e4
        L_0x0154:
            r8 = move-exception
            java.lang.String r9 = "H5ZExternalFile"
            java.lang.String r10 = "create sys storage exception"
            com.alipay.mobile.nebula.util.H5Log.e(r9, r10, r8)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r9 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r9.<init>()
            java.lang.String r10 = "ContainerCreateFileFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r9 = r9.exceptionType(r10)
            java.lang.String r10 = "create sys storage exception"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r9 = r9.appendMessage(r10)
            java.lang.Class r10 = r8.getClass()
            java.lang.String r10 = r10.getName()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r9 = r9.appendExceptionName(r10)
            java.lang.String r8 = r8.getMessage()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r9.appendExceptionMessage(r8)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r8)
            java.lang.String r8 = ""
            return r8
        L_0x0187:
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5FileUtil.getSDPath()
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "sdcard path: "
            java.lang.String r0 = r1.concat(r0)
            java.lang.String r1 = "H5ZExternalFile"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x01b7
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r8.<init>()
            java.lang.String r9 = "ContainerCreateFileFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.exceptionType(r9)
            java.lang.String r9 = "get external files dir return null and sdcard is unmounted"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.appendMessage(r9)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r8)
            java.lang.String r8 = ""
            return r8
        L_0x01b7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = java.io.File.separator
            r0.append(r8)
            java.lang.String r8 = "ExtDataTunnel"
            r0.append(r8)
            java.lang.String r8 = java.io.File.separator
            r0.append(r8)
            java.lang.String r8 = "files"
            r0.append(r8)
            java.lang.String r8 = java.io.File.separator
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
        L_0x01e4:
            java.lang.String r8 = concatPath(r0, r11, r10)
            return r8
        L_0x01e9:
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r8.<init>()
            java.lang.String r11 = "ContainerCreateFileFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.exceptionType(r11)
            java.lang.String r11 = "context is null or groupId or name is empty"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.appendMessage(r11)
            java.lang.String r11 = "groupId"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.appendExtParams(r11, r9)
            java.lang.String r9 = "pathName"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r8 = r8.appendExtParams(r9, r10)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r8)
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.util.H5ZExternalFile.buildPath(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String concatPath(File file, String str, String str2) {
        if (file == null) {
            return "";
        }
        String str3 = file.getAbsolutePath() + formatPath(str);
        File file2 = new File(str3);
        if (!file2.isDirectory() || !file2.exists()) {
            file2.mkdirs();
        }
        return str3 + str2;
    }

    private static boolean configEnabled(String str, String str2) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return false;
        }
        return str2.equalsIgnoreCase(h5ConfigProvider.getConfig(str));
    }
}
