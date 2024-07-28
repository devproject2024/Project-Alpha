package com.alipay.mobile.nebula.appcenter.apphandler;

import android.text.TextUtils;
import android.util.Pair;
import com.alipay.mobile.a.a;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Utils;

public abstract class H5StartAppBaseAdvice implements a {
    private static final String TAG = "H5StartAppAdvice";

    public abstract boolean canHandler(String str);

    public void onCallAfter(String str, Object obj, Object[] objArr) {
    }

    public Pair<Boolean, Object> onCallAround(String str, Object obj, Object[] objArr) {
        return null;
    }

    public void onCallBefore(String str, Object obj, Object[] objArr) {
    }

    public void onExecutionAfter(String str, Object obj, Object[] objArr) {
    }

    public void onExecutionBefore(String str, Object obj, Object[] objArr) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r5.startsWith("javascript:") == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r6.startsWith("javascript:") != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006e, code lost:
        r5 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) com.alipay.mobile.nebula.util.H5Utils.getProvider(com.alipay.mobile.nebula.provider.H5ConfigProvider.class.getName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007c, code lost:
        if (r5 == null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = r5.getConfigJSONArray("h5_enableInterceptJavascriptInScheme");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        if (r5 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008a, code lost:
        if (r5.contains(r2) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        com.alipay.mobile.nebula.util.H5Log.d(TAG, "H5StartAppBaseAdvice intercept javascript success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0096, code lost:
        return new android.util.Pair<>(java.lang.Boolean.TRUE, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        com.alipay.mobile.nebula.util.H5Log.d(TAG, "H5StartAppBaseAdvice intercept javascript success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        return new android.util.Pair<>(java.lang.Boolean.TRUE, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.Boolean, java.lang.Object> onExecutionAround(java.lang.String r12, java.lang.Object r13, java.lang.Object[] r14) {
        /*
            r11 = this;
            java.lang.String r13 = "H5StartAppAdvice"
            java.lang.String r0 = "void com.alipay.mobile.core.impl.MicroApplicationContextImpl.doStartApp(String, String, Bundle)"
            boolean r12 = android.text.TextUtils.equals(r12, r0)
            r0 = 0
            if (r12 != 0) goto L_0x000d
            return r0
        L_0x000d:
            if (r14 == 0) goto L_0x014d
            int r12 = r14.length     // Catch:{ Exception -> 0x0149 }
            r1 = 3
            if (r12 < r1) goto L_0x014d
            r12 = 0
            r1 = r14[r12]     // Catch:{ Exception -> 0x0149 }
            boolean r1 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0021
            r1 = r14[r12]     // Catch:{ Exception -> 0x0149 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0149 }
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            r3 = 1
            r4 = r14[r3]     // Catch:{ Exception -> 0x0149 }
            boolean r4 = r4 instanceof java.lang.String     // Catch:{ Exception -> 0x0149 }
            if (r4 == 0) goto L_0x002d
            r2 = r14[r3]     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0149 }
        L_0x002d:
            r4 = 2
            r5 = r14[r4]     // Catch:{ Exception -> 0x0149 }
            boolean r5 = r5 instanceof android.os.Bundle     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0039
            r14 = r14[r4]     // Catch:{ Exception -> 0x0149 }
            android.os.Bundle r14 = (android.os.Bundle) r14     // Catch:{ Exception -> 0x0149 }
            goto L_0x003a
        L_0x0039:
            r14 = r0
        L_0x003a:
            boolean r5 = com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler.hasCheckParam(r14)     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x014d
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x014d
            java.lang.String r5 = "url"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r14, (java.lang.String) r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "u"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r14, (java.lang.String) r6)     // Catch:{ Exception -> 0x0149 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r8 = "javascript:"
            if (r7 != 0) goto L_0x0062
            boolean r5 = r5.startsWith(r8)     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x006e
        L_0x0062:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x00a2
            boolean r5 = r6.startsWith(r8)     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x00a2
        L_0x006e:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r5 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0149 }
            java.lang.Object r5 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r5)     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r5 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r5     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "H5StartAppBaseAdvice intercept javascript success"
            if (r5 == 0) goto L_0x0097
            java.lang.String r7 = "h5_enableInterceptJavascriptInScheme"
            com.alibaba.a.b r5 = r5.getConfigJSONArray(r7)     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x008c
            boolean r5 = r5.contains(r2)     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x00a2
        L_0x008c:
            com.alipay.mobile.nebula.util.H5Log.d(r13, r6)     // Catch:{ Exception -> 0x0149 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0149 }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r14, r0)     // Catch:{ Exception -> 0x0149 }
            return r12
        L_0x0097:
            com.alipay.mobile.nebula.util.H5Log.d(r13, r6)     // Catch:{ Exception -> 0x0149 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0149 }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r14, r0)     // Catch:{ Exception -> 0x0149 }
            return r12
        L_0x00a2:
            boolean r5 = r11.canHandler(r2)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "URGENT_DISPLAY"
            java.lang.String r7 = " param:"
            java.lang.String r8 = " targetAppId:"
            java.lang.String r9 = "sourceAppId "
            if (r5 == 0) goto L_0x00fd
            java.lang.String r5 = "Advice.startApp"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0149 }
            java.lang.String r10 = "appId"
            r4[r12] = r10     // Catch:{ Exception -> 0x0149 }
            r4[r3] = r2     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.data.H5Trace.event(r5, r0, r4)     // Catch:{ Exception -> 0x0149 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r9)     // Catch:{ Exception -> 0x0149 }
            r12.append(r1)     // Catch:{ Exception -> 0x0149 }
            r12.append(r8)     // Catch:{ Exception -> 0x0149 }
            r12.append(r2)     // Catch:{ Exception -> 0x0149 }
            r12.append(r7)     // Catch:{ Exception -> 0x0149 }
            r12.append(r14)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.util.H5Log.d(r13, r12)     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo r12 = new com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo     // Catch:{ Exception -> 0x0149 }
            r12.<init>()     // Catch:{ Exception -> 0x0149 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x0149 }
            r3.<init>(r14)     // Catch:{ Exception -> 0x0149 }
            r12.params = r3     // Catch:{ Exception -> 0x0149 }
            r12.sourceAppId = r1     // Catch:{ Exception -> 0x0149 }
            r12.targetAppId = r2     // Catch:{ Exception -> 0x0149 }
            java.util.concurrent.ThreadPoolExecutor r14 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r6)     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppBaseAdvice$1 r1 = new com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppBaseAdvice$1     // Catch:{ Exception -> 0x0149 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0149 }
            r14.execute(r1)     // Catch:{ Exception -> 0x0149 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0149 }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r14, r0)     // Catch:{ Exception -> 0x0149 }
            return r12
        L_0x00fd:
            boolean r12 = com.alipay.mobile.nebula.appcenter.apphandler.H5InstallAppAdvice.enableUseDevMode(r14)     // Catch:{ Exception -> 0x0149 }
            if (r12 == 0) goto L_0x014d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r9)     // Catch:{ Exception -> 0x0149 }
            r12.append(r1)     // Catch:{ Exception -> 0x0149 }
            r12.append(r8)     // Catch:{ Exception -> 0x0149 }
            r12.append(r2)     // Catch:{ Exception -> 0x0149 }
            r12.append(r7)     // Catch:{ Exception -> 0x0149 }
            r12.append(r14)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.util.H5Log.d(r13, r12)     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo r12 = new com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo     // Catch:{ Exception -> 0x0149 }
            r12.<init>()     // Catch:{ Exception -> 0x0149 }
            if (r14 != 0) goto L_0x012a
            android.os.Bundle r14 = new android.os.Bundle     // Catch:{ Exception -> 0x0149 }
            r14.<init>()     // Catch:{ Exception -> 0x0149 }
        L_0x012a:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x0149 }
            r3.<init>(r14)     // Catch:{ Exception -> 0x0149 }
            r12.params = r3     // Catch:{ Exception -> 0x0149 }
            r12.sourceAppId = r1     // Catch:{ Exception -> 0x0149 }
            r12.targetAppId = r2     // Catch:{ Exception -> 0x0149 }
            java.util.concurrent.ThreadPoolExecutor r14 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r6)     // Catch:{ Exception -> 0x0149 }
            com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppBaseAdvice$2 r1 = new com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppBaseAdvice$2     // Catch:{ Exception -> 0x0149 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0149 }
            r14.execute(r1)     // Catch:{ Exception -> 0x0149 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0149 }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0149 }
            r12.<init>(r14, r0)     // Catch:{ Exception -> 0x0149 }
            return r12
        L_0x0149:
            r12 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r13, (java.lang.Throwable) r12)
        L_0x014d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppBaseAdvice.onExecutionAround(java.lang.String, java.lang.Object, java.lang.Object[]):android.util.Pair");
    }

    public static boolean enableHandleStartApp() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return true;
        }
        String config = h5ConfigProvider.getConfig(H5AppHandler.h5_enablenbhandler);
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    public boolean defaultHandler(String str) {
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider == null || h5AppProvider.getAppInfo(str, H5Utils.getVersion()) == null) {
            return false;
        }
        return true;
    }
}
