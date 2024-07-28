package com.alipay.mobile.nebulacore.appcenter.parse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5PublicRsaProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.api.H5ParseResult;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H5PackageParser {
    private static final String DEFAULT_TAR_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2y61svV7Q0gmvxprTt6YX76rps8R+q+C+Qtkkk2+njIABsf10sHnl/5aQBh2s+kdo6YGlJrnKdxVso2JRzy+QbRBUgTdJmKfm5uGPdcqYuO0ur4b/QCyHTMoKJjBT8iI3hYIGhn0hACDao4xIsgzJ39grRKUa6120WbInlOLWSQIDAQAB";
    private static final String NEW_H5APP_SIGN_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl96KRuzoQDgt3q3478MYKwTGDV0Fz5w+sKOfz+Ar+/XkwqLjVW7bAk+/nOD9Z4mnwM+BsgU/G5KGQ9WMjcXAow/eRBSf93iqcBX5+DdlkbneNyQP7Mvcy8EwOAa3y7AetEpTeYrv5cppFUjq4TVu9w+DwV1qegfvJEAA+6gFJEcJPxD9fxJggCF02tL3k9/WDnaNYVN3dCq8fN4jWZLr6KWlAX5UW5ZVtXP9IWObFnvRNjgXQhW/LzJLdbcDlQ5U6ImFyIFf//vn3vEhzlpU6EkxdGr+FWwsRiMTY9aZ1fJiFlgAZQpInV6cbDM8LgNGPtDsYUibIi3rVFtYtHAxQwIDAQAB";
    public static final String TAG = "H5PackageParser";
    public static final String TAR_PUBLIC_KEY = getRSA();
    public static final String TAR_VERIFY_FAIL = "tarVerifyFail";

    public static String getPublicKey(boolean z) {
        return z ? NEW_H5APP_SIGN_PUBLIC_KEY : DEFAULT_TAR_PUBLIC_KEY;
    }

    private static String getRSA() {
        H5PublicRsaProvider h5PublicRsaProvider = (H5PublicRsaProvider) Nebula.getProviderManager().getProvider(H5PublicRsaProvider.class.getName());
        if (h5PublicRsaProvider == null) {
            return "";
        }
        String publicRsa = h5PublicRsaProvider.getPublicRsa();
        return !TextUtils.isEmpty(publicRsa) ? publicRsa : "";
    }

    private static H5ParseResult getResult(int i2, String str) {
        H5ParseResult h5ParseResult = new H5ParseResult();
        h5ParseResult.code = i2;
        h5ParseResult.msg = str;
        return h5ParseResult;
    }

    private static H5ParseResult getResult(int i2, String str, long j, long j2, long j3) {
        H5ParseResult h5ParseResult = new H5ParseResult();
        h5ParseResult.code = i2;
        h5ParseResult.msg = str;
        h5ParseResult.verifyStart = j;
        h5ParseResult.loadStart = j2;
        h5ParseResult.loadEnd = j3;
        return h5ParseResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0789  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x07b5  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0839  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x026f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.mobile.nebulacore.api.H5ParseResult parsePackage(android.os.Bundle r37, java.util.Map<java.lang.String, byte[]> r38) {
        /*
            r1 = r37
            r2 = r38
            java.lang.String r3 = "package|"
            java.lang.String r4 = "mapDuration"
            java.lang.String r5 = "INVALID_PARAM"
            r6 = 1
            java.lang.String r7 = "H5PackageParser"
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "invalid params "
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.String) r0)
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r6, r5)
            return r0
        L_0x0019:
            long r8 = java.lang.System.currentTimeMillis()
            com.alibaba.a.e r10 = new com.alibaba.a.e
            r10.<init>()
            long r11 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = "appId"
            java.lang.String r15 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            java.lang.String r0 = "offlineHost"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            java.lang.String r13 = "onlineHost"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r13)
            java.lang.String r14 = "appType"
            int r14 = com.alipay.mobile.nebula.util.H5Utils.getInt((android.os.Bundle) r1, (java.lang.String) r14)
            r6 = 2
            r17 = r8
            r8 = 0
            if (r14 != r6) goto L_0x0046
            r9 = 1
            goto L_0x0047
        L_0x0046:
            r9 = 0
        L_0x0047:
            java.lang.String r14 = "mapHost"
            boolean r14 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r1, (java.lang.String) r14, (boolean) r8)
            java.lang.String r6 = "appVersion"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r6)
            r20 = r11
            java.lang.String r11 = "isNebulaApp"
            boolean r11 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r1, (java.lang.String) r11, (boolean) r8)
            java.lang.String r12 = "needForceVerify"
            boolean r12 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r1, (java.lang.String) r12, (boolean) r8)
            java.lang.String r8 = ""
            r22 = r3
            java.lang.String r3 = "customPublicKey"
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r3, (java.lang.String) r8)
            boolean r23 = android.text.TextUtils.isEmpty(r15)
            if (r23 == 0) goto L_0x0079
            java.lang.String r0 = "appIdIsEmpty"
            r1 = 1
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r1, r0)
            return r0
        L_0x0079:
            r23 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r24 = r4
            java.lang.String r4 = "parse package appId "
            r8.<init>(r4)
            r8.append(r15)
            java.lang.String r4 = " mapHost "
            r8.append(r4)
            r8.append(r14)
            java.lang.String r4 = " offlineHost:"
            r8.append(r4)
            r8.append(r0)
            java.lang.String r4 = " onlineHost:"
            r8.append(r4)
            r8.append(r13)
            java.lang.String r4 = " version:"
            r8.append(r4)
            r8.append(r6)
            java.lang.String r4 = " isNebula "
            r8.append(r4)
            r8.append(r11)
            java.lang.String r4 = r8.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r8 = "/"
            if (r4 == 0) goto L_0x011f
            com.alipay.mobile.nebula.provider.H5ProviderManager r4 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r25 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            r26 = r0
            java.lang.String r0 = r25.getName()
            java.lang.Object r0 = r4.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = (com.alipay.mobile.nebula.provider.H5AppProvider) r0
            if (r0 == 0) goto L_0x0121
            java.lang.String r0 = r0.getInstallPath(r15, r6)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x00fe
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r25 = r13
            java.lang.String r13 = "file://"
            java.lang.String r4 = r13.concat(r4)
            boolean r13 = r4.endsWith(r8)
            if (r13 != 0) goto L_0x0102
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            r13.append(r8)
            java.lang.String r4 = r13.toString()
            goto L_0x0102
        L_0x00fe:
            r25 = r13
            r4 = r26
        L_0x0102:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r27 = r9
            java.lang.String r9 = "installPath : "
            r13.<init>(r9)
            r13.append(r0)
            java.lang.String r0 = " offlineHost : "
            r13.append(r0)
            r13.append(r4)
            java.lang.String r0 = r13.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)
            r13 = r4
            goto L_0x0127
        L_0x011f:
            r26 = r0
        L_0x0121:
            r27 = r9
            r25 = r13
            r13 = r26
        L_0x0127:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r0 == 0) goto L_0x0174
            com.alipay.mobile.nebula.provider.H5ProviderManager r0 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r4 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r4 = r4.getName()
            java.lang.Object r0 = r0.getProvider(r4)
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = (com.alipay.mobile.nebula.provider.H5AppProvider) r0
            if (r0 == 0) goto L_0x0174
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto L_0x0174
            r9 = r5
            long r4 = r0.getPackageSize(r15, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r26 = r14
            java.lang.String r14 = "inject data size is "
            r0.<init>(r14)
            r0.append(r4)
            java.lang.String r14 = ", version is "
            r0.append(r14)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "size"
            r10.put((java.lang.String) r4, (java.lang.Object) r0)
            java.lang.String r0 = "version"
            r10.put((java.lang.String) r0, (java.lang.Object) r6)
            goto L_0x0177
        L_0x0174:
            r9 = r5
            r26 = r14
        L_0x0177:
            android.net.Uri r0 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r13)
            if (r0 == 0) goto L_0x0839
            java.lang.String r4 = r0.getPath()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0189
            goto L_0x0839
        L_0x0189:
            java.lang.String r4 = r0.getPath()
            boolean r0 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r4)
            java.lang.String r5 = "OFFLINE_PATH_NOT_EXIST"
            java.lang.String r14 = "offlinePath "
            if (r0 != 0) goto L_0x01b1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            r0.append(r4)
            java.lang.String r1 = " not exists!"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.String) r0)
            r1 = 2
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r1, r5)
            return r0
        L_0x01b1:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            java.lang.String r28 = "h5_setLastModified"
            r29 = r5
            java.lang.String r5 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r28)
            r28 = r11
            java.lang.String r11 = "no"
            boolean r5 = r11.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x020d
            r11 = r9
            r5 = r10
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0204 }
            r30 = r3
            long r2 = r0.lastModified()     // Catch:{ all -> 0x0202 }
            r0.setLastModified(r9)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            r31 = r11
            java.lang.String r11 = "lastModified "
            r0.<init>(r11)     // Catch:{ all -> 0x0200 }
            r0.append(r2)     // Catch:{ all -> 0x0200 }
            java.lang.String r2 = " newTime:"
            r0.append(r2)     // Catch:{ all -> 0x0200 }
            r0.append(r9)     // Catch:{ all -> 0x0200 }
            java.lang.String r2 = " cost:"
            r0.append(r2)     // Catch:{ all -> 0x0200 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0200 }
            long r2 = r2 - r9
            r0.append(r2)     // Catch:{ all -> 0x0200 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0200 }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)     // Catch:{ all -> 0x0200 }
            goto L_0x0212
        L_0x0200:
            r0 = move-exception
            goto L_0x0209
        L_0x0202:
            r0 = move-exception
            goto L_0x0207
        L_0x0204:
            r0 = move-exception
            r30 = r3
        L_0x0207:
            r31 = r11
        L_0x0209:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.Throwable) r0)
            goto L_0x0212
        L_0x020d:
            r30 = r3
            r31 = r9
            r5 = r10
        L_0x0212:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r8)
            r0.append(r15)
            java.lang.String r2 = ".tar"
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tarPath "
            java.lang.String r0 = r3.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)
            boolean r0 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r2)
            java.lang.String r3 = "ContainerOfflineVerifyFail"
            if (r0 != 0) goto L_0x026f
            java.lang.String r0 = "tar package not exists!"
            com.alipay.mobile.nebula.util.H5Log.w(r7, r0)
            notifyVerifyFailed(r15, r13, r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r3)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r6)
            java.lang.String r1 = "tar not exists"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)
            r0 = 3
            java.lang.String r1 = "TAR_PATH_NOT_EXIST"
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r0, r1)
            return r0
        L_0x026f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r9 = "/CERT.json"
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r10 = "/SIGN.json"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            boolean r10 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r0)
            if (r10 != 0) goto L_0x02cb
            boolean r10 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r9)
            if (r10 != 0) goto L_0x02cb
            java.lang.String r0 = "cert not exists!"
            com.alipay.mobile.nebula.util.H5Log.w(r7, r0)
            notifyVerifyFailed(r15, r13, r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r3)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r6)
            java.lang.String r1 = "cert not exists"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)
            r0 = 4
            java.lang.String r1 = "CERT_PATH_NOT_EXIST"
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r0, r1)
            return r0
        L_0x02cb:
            long r10 = java.lang.System.currentTimeMillis()
            boolean r32 = isNeedVerify()
            if (r32 != 0) goto L_0x02df
            if (r12 == 0) goto L_0x02d8
            goto L_0x02df
        L_0x02d8:
            r3 = r38
            r33 = r2
            r2 = r6
            goto L_0x0522
        L_0x02df:
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r12.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.start()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.appendPackageVersion(r6)
            r32 = r3
            java.lang.String r3 = "H5_CONTAINER_OFFLINE_VERIFY"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.seedId(r3)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r12)
            java.io.File r12 = new java.io.File
            r12.<init>(r4)
            java.io.File[] r12 = r12.listFiles()
            if (r12 == 0) goto L_0x080a
            r33 = r2
            int r2 = r12.length
            if (r2 != 0) goto L_0x030d
            goto L_0x080a
        L_0x030d:
            boolean r2 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r9)
            if (r2 == 0) goto L_0x032a
            boolean r19 = android.text.TextUtils.isEmpty(r30)
            if (r19 == 0) goto L_0x032a
            java.lang.String r19 = TAR_PUBLIC_KEY
            boolean r19 = android.text.TextUtils.isEmpty(r19)
            if (r19 != 0) goto L_0x0322
            goto L_0x032a
        L_0x0322:
            r34 = r3
            r35 = r6
            r3 = r2
            r2 = r30
            goto L_0x0355
        L_0x032a:
            r34 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r35 = r6
            java.lang.String r6 = "signPath is exist : "
            r3.<init>(r6)
            r3.append(r2)
            java.lang.String r2 = ", publicKey : "
            r3.append(r2)
            r2 = r30
            r3.append(r2)
            java.lang.String r6 = ", H5PackageParser.TAR_PUBLIC_KEY : "
            r3.append(r6)
            java.lang.String r6 = TAR_PUBLIC_KEY
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r3)
            r3 = 0
        L_0x0355:
            java.lang.String r6 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "useNewSignKey : "
            java.lang.String r1 = r1.concat(r6)
            com.alipay.mobile.nebula.util.H5Log.d(r7, r1)
            if (r3 == 0) goto L_0x036e
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.read(r9)
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)
            goto L_0x0376
        L_0x036e:
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.read(r0)
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)
        L_0x0376:
            if (r0 == 0) goto L_0x07d3
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0380
            goto L_0x07d3
        L_0x0380:
            int r1 = r12.length     // Catch:{ Exception -> 0x04c4 }
            r6 = 0
        L_0x0382:
            if (r6 >= r1) goto L_0x04bf
            r9 = r12[r6]     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r9 = r9.getName()     // Catch:{ Exception -> 0x04c4 }
            boolean r19 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x04c4 }
            if (r19 != 0) goto L_0x04a5
            r19 = r1
            java.lang.String r1 = "CERT.json"
            boolean r1 = android.text.TextUtils.equals(r9, r1)     // Catch:{ Exception -> 0x04c4 }
            if (r1 != 0) goto L_0x049a
            java.lang.String r1 = "SIGN.json"
            boolean r1 = android.text.TextUtils.equals(r9, r1)     // Catch:{ Exception -> 0x04c4 }
            if (r1 != 0) goto L_0x049a
            java.lang.String r1 = "ios"
            boolean r1 = r9.contains(r1)     // Catch:{ Exception -> 0x04c4 }
            if (r1 != 0) goto L_0x049a
            java.lang.String r1 = "tiny"
            boolean r1 = r9.contains(r1)     // Catch:{ Exception -> 0x04c4 }
            if (r1 != 0) goto L_0x049a
            boolean r1 = r0.containsKey(r9)     // Catch:{ Exception -> 0x04c4 }
            if (r1 == 0) goto L_0x049a
            java.lang.Object r1 = r0.get(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04c4 }
            if (r3 == 0) goto L_0x03e0
            r29 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4 }
            r0.<init>()     // Catch:{ Exception -> 0x04c4 }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r8)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04c4 }
            r30 = r3
            java.lang.String r3 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl96KRuzoQDgt3q3478MYKwTGDV0Fz5w+sKOfz+Ar+/XkwqLjVW7bAk+/nOD9Z4mnwM+BsgU/G5KGQ9WMjcXAow/eRBSf93iqcBX5+DdlkbneNyQP7Mvcy8EwOAa3y7AetEpTeYrv5cppFUjq4TVu9w+DwV1qegfvJEAA+6gFJEcJPxD9fxJggCF02tL3k9/WDnaNYVN3dCq8fN4jWZLr6KWlAX5UW5ZVtXP9IWObFnvRNjgXQhW/LzJLdbcDlQ5U6ImFyIFf//vn3vEhzlpU6EkxdGr+FWwsRiMTY9aZ1fJiFlgAZQpInV6cbDM8LgNGPtDsYUibIi3rVFtYtHAxQwIDAQAB"
            boolean r0 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r0, r3, r1)     // Catch:{ Exception -> 0x04c4 }
            goto L_0x043a
        L_0x03e0:
            r29 = r0
            r30 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x04c4 }
            if (r0 != 0) goto L_0x0401
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4 }
            r0.<init>()     // Catch:{ Exception -> 0x04c4 }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r8)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04c4 }
            boolean r0 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r0, r2, r1)     // Catch:{ Exception -> 0x04c4 }
            goto L_0x043a
        L_0x0401:
            java.lang.String r0 = TAR_PUBLIC_KEY     // Catch:{ Exception -> 0x04c4 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04c4 }
            if (r0 != 0) goto L_0x0422
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4 }
            r0.<init>()     // Catch:{ Exception -> 0x04c4 }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r8)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r3 = TAR_PUBLIC_KEY     // Catch:{ Exception -> 0x04c4 }
            boolean r0 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r0, r3, r1)     // Catch:{ Exception -> 0x04c4 }
            goto L_0x043a
        L_0x0422:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4 }
            r0.<init>()     // Catch:{ Exception -> 0x04c4 }
            r0.append(r4)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r8)     // Catch:{ Exception -> 0x04c4 }
            r0.append(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2y61svV7Q0gmvxprTt6YX76rps8R+q+C+Qtkkk2+njIABsf10sHnl/5aQBh2s+kdo6YGlJrnKdxVso2JRzy+QbRBUgTdJmKfm5uGPdcqYuO0ur4b/QCyHTMoKJjBT8iI3hYIGhn0hACDao4xIsgzJ39grRKUa6120WbInlOLWSQIDAQAB"
            boolean r0 = com.alipay.mobile.nebula.util.H5RsaUtil.verify(r0, r3, r1)     // Catch:{ Exception -> 0x04c4 }
        L_0x043a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04c4 }
            r3.<init>(r14)     // Catch:{ Exception -> 0x04c4 }
            r3.append(r4)     // Catch:{ Exception -> 0x04c4 }
            r36 = r2
            java.lang.String r2 = "signKey "
            r3.append(r2)     // Catch:{ Exception -> 0x04c4 }
            r3.append(r9)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r2 = " signValue "
            r3.append(r2)     // Catch:{ Exception -> 0x04c4 }
            r3.append(r1)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r1 = " verify result:"
            r3.append(r1)     // Catch:{ Exception -> 0x04c4 }
            r3.append(r0)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x04c4 }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r1)     // Catch:{ Exception -> 0x04c4 }
            if (r0 != 0) goto L_0x0497
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ Exception -> 0x04c4 }
            if (r0 == 0) goto L_0x0481
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x04c4 }
            long r0 = r0 - r10
            java.lang.String r2 = "verifyResult"
            java.lang.String r3 = "fail"
            r5.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x04c4 }
            java.lang.String r2 = "verifyDuration"
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x04c4 }
            r5.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x04c4 }
        L_0x0481:
            r1 = r37
            notifyVerifyFailed(r15, r13, r1)     // Catch:{ Exception -> 0x0495 }
            r2 = r35
            computeMd5AndMonitor(r4, r9, r15, r2)     // Catch:{ Exception -> 0x0493 }
            r0 = 6
            java.lang.String r3 = "VERIFY_FAIL"
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r0, r3)     // Catch:{ Exception -> 0x0493 }
            return r0
        L_0x0493:
            r0 = move-exception
            goto L_0x04c9
        L_0x0495:
            r0 = move-exception
            goto L_0x04c7
        L_0x0497:
            r1 = r37
            goto L_0x04a2
        L_0x049a:
            r1 = r37
            r29 = r0
            r36 = r2
            r30 = r3
        L_0x04a2:
            r2 = r35
            goto L_0x04b1
        L_0x04a5:
            r29 = r0
            r19 = r1
            r36 = r2
            r30 = r3
            r2 = r35
            r1 = r37
        L_0x04b1:
            int r6 = r6 + 1
            r35 = r2
            r1 = r19
            r0 = r29
            r3 = r30
            r2 = r36
            goto L_0x0382
        L_0x04bf:
            r1 = r37
            r2 = r35
            goto L_0x04cc
        L_0x04c4:
            r0 = move-exception
            r1 = r37
        L_0x04c7:
            r2 = r35
        L_0x04c9:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.Throwable) r0)
        L_0x04cc:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r10
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "verify tar signature succeed elapse:"
            r0.<init>(r6)
            r0.append(r3)
            java.lang.String r6 = " appId:"
            r0.append(r6)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r0 == 0) goto L_0x0502
            java.lang.String r0 = "verifyResult"
            java.lang.String r6 = "success"
            r5.put((java.lang.String) r0, (java.lang.Object) r6)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            java.lang.String r6 = "verifyDuration"
            r5.put((java.lang.String) r6, (java.lang.Object) r0)
        L_0x0502:
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.success()
            r6 = r34
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.seedId(r6)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendCostTime(r3)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r2)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r0)
            r3 = r38
        L_0x0522:
            if (r3 != 0) goto L_0x0532
            java.lang.String r0 = "invalid resPkg"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.String) r0)
            r0 = 8
            r1 = r31
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r0, r1)
            return r0
        L_0x0532:
            java.lang.String r0 = "api_permission"
            if (r28 == 0) goto L_0x0570
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r4 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r4 = r4.getName()
            java.lang.Object r4 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r4)
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = (com.alipay.mobile.nebula.provider.H5AppProvider) r4
            if (r4 == 0) goto L_0x0570
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r4.getAppInfo(r15, r2)
            if (r4 == 0) goto L_0x0570
            java.lang.String r4 = r4.extend_info_jo
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r0)
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)
            if (r4 == 0) goto L_0x0570
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L_0x0570
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r6 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()
            if (r6 == 0) goto L_0x056d
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r6 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()
            r6.putJson(r15, r4)
        L_0x056d:
            r4 = 1
            r6 = 1
            goto L_0x0572
        L_0x0570:
            r4 = 0
            r6 = 0
        L_0x0572:
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = java.lang.System.currentTimeMillis()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r12.<init>()
            java.lang.String r14 = "H5_CONTAINER_OFFLINE_LOAD"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.seedId(r14)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.appendPackageVersion(r2)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r12 = r12.start()
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r12)
            if (r26 == 0) goto L_0x0599
            r12 = r25
            goto L_0x059a
        L_0x0599:
            r12 = r13
        L_0x059a:
            r19 = 0
            r25 = 2048(0x800, float:2.87E-42)
            r26 = r6
            byte[] r6 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r25)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0748 }
            r25 = r13
            r13 = r33
            r1.<init>(r13)     // Catch:{ all -> 0x0744 }
            r33 = r13
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0742 }
            r13.<init>(r1)     // Catch:{ all -> 0x0742 }
            com.alipay.mobile.nebula.util.tar.TarInputStream r1 = new com.alipay.mobile.nebula.util.tar.TarInputStream     // Catch:{ all -> 0x0742 }
            r1.<init>(r13)     // Catch:{ all -> 0x0742 }
        L_0x05b9:
            com.alipay.mobile.nebula.util.tar.TarEntry r13 = r1.getNextEntry()     // Catch:{ all -> 0x073c }
            if (r13 == 0) goto L_0x06a3
            r28 = r8
            java.lang.String r8 = r13.getName()     // Catch:{ all -> 0x069a }
            boolean r9 = r13.isDirectory()     // Catch:{ all -> 0x0694 }
            if (r9 != 0) goto L_0x068a
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0694 }
            if (r9 != 0) goto L_0x068a
            java.lang.String r9 = "hpmfile.json"
            boolean r9 = android.text.TextUtils.equals(r8, r9)     // Catch:{ all -> 0x0694 }
            if (r9 != 0) goto L_0x068a
            com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream r9 = new com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream     // Catch:{ all -> 0x0694 }
            r9.<init>()     // Catch:{ all -> 0x0694 }
        L_0x05de:
            int r13 = r1.read(r6)     // Catch:{ all -> 0x0694 }
            r30 = r14
            r14 = -1
            if (r13 == r14) goto L_0x05ee
            r14 = 0
            r9.write(r6, r14, r13)     // Catch:{ all -> 0x0694 }
            r14 = r30
            goto L_0x05de
        L_0x05ee:
            r14 = 0
            byte[] r13 = r9.toByteArray()     // Catch:{ all -> 0x0694 }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r9)     // Catch:{ all -> 0x0694 }
            if (r13 == 0) goto L_0x068c
            java.lang.String r9 = "entryName "
            java.lang.String r14 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = r9.concat(r14)     // Catch:{ all -> 0x0694 }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r9)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = "_animation"
            boolean r9 = r8.startsWith(r9)     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x0611
            r3.put(r8, r13)     // Catch:{ all -> 0x0694 }
            goto L_0x0654
        L_0x0611:
            if (r27 == 0) goto L_0x0642
            boolean r9 = com.alipay.mobile.nebulacore.Nebula.isTinyResAppId(r15)     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x0627
            java.lang.String r9 = "https://"
            java.lang.String r14 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = r9.concat(r14)     // Catch:{ all -> 0x0694 }
            r3.put(r9, r13)     // Catch:{ all -> 0x0694 }
            goto L_0x0654
        L_0x0627:
            java.lang.String r9 = "http://"
            java.lang.String r14 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = r9.concat(r14)     // Catch:{ all -> 0x0694 }
            r3.put(r9, r13)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = "https://"
            java.lang.String r14 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = r9.concat(r14)     // Catch:{ all -> 0x0694 }
            r3.put(r9, r13)     // Catch:{ all -> 0x0694 }
            goto L_0x0654
        L_0x0642:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0694 }
            r9.<init>()     // Catch:{ all -> 0x0694 }
            r9.append(r12)     // Catch:{ all -> 0x0694 }
            r9.append(r8)     // Catch:{ all -> 0x0694 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0694 }
            r3.put(r9, r13)     // Catch:{ all -> 0x0694 }
        L_0x0654:
            boolean r9 = android.text.TextUtils.equals(r8, r0)     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x066b
            if (r4 != 0) goto L_0x066b
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r9 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x0669
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r9 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()     // Catch:{ all -> 0x0694 }
            r9.put(r15, r13)     // Catch:{ all -> 0x0694 }
        L_0x0669:
            r26 = 1
        L_0x066b:
            java.lang.String r9 = "appConfig.json"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x067d
            com.alipay.mobile.nebula.startParam.H5StartParamManager r9 = com.alipay.mobile.nebula.startParam.H5StartParamManager.getInstance()     // Catch:{ all -> 0x0694 }
            r9.put(r15, r13)     // Catch:{ all -> 0x0694 }
            r9 = 1
            com.alipay.mobile.nebulacore.Nebula.isDSL = r9     // Catch:{ all -> 0x0694 }
        L_0x067d:
            java.lang.String r9 = "tabBar.json"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ all -> 0x0694 }
            if (r9 == 0) goto L_0x068c
            com.alipay.mobile.nebula.util.H5TabbarUtils.setTabData(r15, r13)     // Catch:{ all -> 0x0694 }
            goto L_0x068c
        L_0x068a:
            r30 = r14
        L_0x068c:
            r23 = r8
            r8 = r28
            r14 = r30
            goto L_0x05b9
        L_0x0694:
            r0 = move-exception
            r17 = r8
            r4 = r22
            goto L_0x069f
        L_0x069a:
            r0 = move-exception
            r4 = r22
            r17 = r23
        L_0x069f:
            r3 = r24
            goto L_0x0753
        L_0x06a3:
            r28 = r8
            r30 = r14
            if (r26 != 0) goto L_0x06b6
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r0 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()     // Catch:{ all -> 0x069a }
            if (r0 == 0) goto L_0x06b6
            com.alipay.mobile.nebula.tinypermission.H5ApiManager r0 = com.alipay.mobile.nebulacore.Nebula.getH5TinyAppService()     // Catch:{ all -> 0x069a }
            r0.clear(r15)     // Catch:{ all -> 0x069a }
        L_0x06b6:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r6)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r1)
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r0 == 0) goto L_0x06e1
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r10
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x06e1
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3 = r24
            r5.put((java.lang.String) r3, (java.lang.Object) r0)
            java.lang.String r0 = java.lang.String.valueOf(r15)
            r4 = r22
            java.lang.String r0 = r4.concat(r0)
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r0, r5)
        L_0x06e1:
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r20
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "parse package elapse "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = " appId:"
            r3.append(r0)
            r3.append(r15)
            java.lang.String r0 = r3.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            r1 = r30
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.seedId(r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r15)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r2)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.success()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r10
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendCostTime(r1)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r0)
            java.lang.String r0 = "prepare_app"
            java.lang.String r1 = "parser_app"
            r2 = r20
            com.alipay.mobile.nebulacore.util.H5TimeUtil.timeLog(r0, r1, r2)
            long r7 = java.lang.System.currentTimeMillis()
            r1 = 0
            java.lang.String r2 = "SUCCESS"
            r3 = r17
            r5 = r28
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r1, r2, r3, r5, r7)
            return r0
        L_0x073c:
            r0 = move-exception
            r4 = r22
            r3 = r24
            goto L_0x0751
        L_0x0742:
            r0 = move-exception
            goto L_0x074b
        L_0x0744:
            r0 = move-exception
            r33 = r13
            goto L_0x074b
        L_0x0748:
            r0 = move-exception
            r25 = r13
        L_0x074b:
            r4 = r22
            r3 = r24
            r1 = r19
        L_0x0751:
            r17 = r23
        L_0x0753:
            java.lang.String r8 = "parse package exception"
            com.alipay.mobile.nebula.util.H5Log.e(r7, r8, r0)     // Catch:{ all -> 0x07a9 }
            r8 = r37
            r9 = r25
            notifyVerifyFailed(r15, r9, r8)     // Catch:{ all -> 0x07a9 }
            java.lang.String r7 = "IO"
            java.util.concurrent.ThreadPoolExecutor r7 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r7)     // Catch:{ all -> 0x07a9 }
            com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser$1 r8 = new com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser$1     // Catch:{ all -> 0x07a9 }
            r9 = r33
            r13 = r8
            r14 = r9
            r12 = r15
            r16 = r2
            r18 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x07a7 }
            r7.execute(r8)     // Catch:{ all -> 0x07a7 }
            r7 = 7
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x07a7 }
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r7, r0)     // Catch:{ all -> 0x07a7 }
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r6)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r1)
            boolean r1 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r1 == 0) goto L_0x07a6
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r10
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x07a6
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r5.put((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r1 = r4.concat(r1)
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r1, r5)
        L_0x07a6:
            return r0
        L_0x07a7:
            r0 = move-exception
            goto L_0x07ab
        L_0x07a9:
            r0 = move-exception
            r12 = r15
        L_0x07ab:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r6)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r1)
            boolean r1 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r1 == 0) goto L_0x07d2
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r10
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x07d2
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r5.put((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r1 = r4.concat(r1)
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r1, r5)
        L_0x07d2:
            throw r0
        L_0x07d3:
            r8 = r37
            r9 = r13
            r12 = r15
            r2 = r35
            java.lang.String r0 = "joCert is empty"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.String) r0)
            notifyVerifyFailed(r12, r9, r8)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()
            r1 = r32
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r12)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r2)
            java.lang.String r1 = "signature is empty"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)
            r0 = 5
            java.lang.String r1 = "TAR_SIGNATURE_IS_EMPTY"
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r0, r1)
            return r0
        L_0x080a:
            r2 = r6
            r12 = r15
            r1 = r32
            java.lang.String r0 = "childrenFiles length == 0"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.String) r0)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r0.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r12)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r2)
            java.lang.String r1 = "offline package files not exists"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)
            r1 = r29
            r2 = 2
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r2, r1)
            return r0
        L_0x0839:
            r1 = r9
            r2 = 1
            com.alipay.mobile.nebulacore.api.H5ParseResult r0 = getResult(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser.parsePackage(android.os.Bundle, java.util.Map):com.alipay.mobile.nebulacore.api.H5ParseResult");
    }

    private static void computeMd5AndMonitor(final String str, final String str2, final String str3, final String str4) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public final void run() {
                String fileMd5 = H5SecurityUtil.getFileMd5(str + "/" + str2);
                H5MonitorModel appendPackageVersion = new H5MonitorModel().fail().exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_VERIFY).appendSubappId(str3).appendPackageVersion(str4);
                StringBuilder sb = new StringBuilder("verify result is fail ");
                sb.append(str2);
                H5Monitor.exception(appendPackageVersion.appendMessage(sb.toString()).appendMd5(fileMd5));
            }
        });
    }

    private static void notifyVerifyFailed(final String str, final String str2, final Bundle bundle) {
        if ("no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_schedule_delete_fail_app"))) {
            notifyFail(str, str2, bundle);
            return;
        }
        H5Log.d(TAG, "notifyVerifyFailed appId ".concat(String.valueOf(str)));
        ScheduledThreadPoolExecutor scheduledExecutor = H5Utils.getScheduledExecutor();
        if (scheduledExecutor != null) {
            scheduledExecutor.schedule(new Runnable() {
                public final void run() {
                    H5ParseResult parsePackage = H5PackageParser.parsePackage(bundle, (Map<String, byte[]>) null);
                    if (parsePackage == null || parsePackage.code != 8) {
                        H5PackageParser.notifyFail(str, str2, bundle);
                    } else {
                        H5Log.d(H5PackageParser.TAG, "parsePackage again is ok not to delete");
                    }
                }
            }, 2, TimeUnit.SECONDS);
        }
    }

    public static void notifyFail(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
            if (h5AppProvider == null || !h5AppProvider.isNebulaApp(str)) {
                a a2 = a.a(H5Utils.getContext());
                Intent intent = new Intent();
                H5Log.d(TAG, str + " is not nebulaapp send verify failed broadcast to app center.");
                intent.setAction(TAR_VERIFY_FAIL);
                intent.putExtra("appId", str);
                intent.putExtra("localPath", str2);
                a2.a(intent);
            } else {
                H5Log.d(TAG, str + " is nebulaapp,verify failed ,delete localPath:" + str2);
                String path = Uri.parse(str2).getPath();
                H5Log.d(TAG, "deletePath:".concat(String.valueOf(path)));
                File file = new File(path);
                if (H5FileUtil.exists(file)) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            String str3 = "";
                            for (File file2 : listFiles) {
                                H5Log.d(TAG, "file  " + file2.getName());
                                str3 = str3 + "_" + file2.getName();
                            }
                        } else {
                            H5Log.d(TAG, "listFiles==null");
                        }
                    } catch (Exception e2) {
                        H5Log.e(TAG, (Throwable) e2);
                    }
                }
                H5AppUtil.deleteNebulaInstallFileAndDB(path, str);
            }
            if (H5Utils.isInWifi() && h5AppProvider != null) {
                h5AppProvider.downloadApp(str, H5Utils.getString(bundle, "appVersion"));
            }
        }
    }

    private static boolean isNeedVerify() {
        boolean isNeedVerifyFromConfig = isNeedVerifyFromConfig();
        H5Log.d(TAG, "parsePackage isNeedVerifyFromConfig ".concat(String.valueOf(isNeedVerifyFromConfig)));
        return isNeedVerifyFromConfig || Nebula.isRooted();
    }

    private static boolean isNeedVerifyFromConfig() {
        return !TextUtils.equals(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO, H5Environment.getConfigWithProcessCache("h5_shouldverifyapp"));
    }
}
