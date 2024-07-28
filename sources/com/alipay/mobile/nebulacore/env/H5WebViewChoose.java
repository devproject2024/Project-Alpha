package com.alipay.mobile.nebulacore.env;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.HashMap;
import java.util.Map;

public class H5WebViewChoose {
    private static final String TAG = "H5WebViewChoose";

    public static boolean useSysWebWillCrash() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String str = Build.MANUFACTURER + "#" + Build.MODEL + "#" + Build.VERSION.SDK_INT;
            b parseArray = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_first_init_use_android_webView_phone"));
            if (parseArray != null && !parseArray.isEmpty()) {
                for (int i2 = 0; i2 < parseArray.size(); i2++) {
                    if (str.equalsIgnoreCase(parseArray.getString(i2))) {
                        H5Log.d(TAG, "h5_first_init_use_android_webView_phone contain use uc");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static WebViewType getWebViewType(String str, Context context, Bundle bundle) {
        H5Log.d(TAG, "getWebViewType bizType ".concat(String.valueOf(str)));
        if (RnService.isRnBiz(str)) {
            return WebViewType.RN_VIEW;
        }
        if (Nebula.DEBUG) {
            if (H5DevConfig.getBooleanConfig(H5DevConfig.H5_READ_USE_WEBVIEW_CONFIG, false)) {
                if (H5DevConfig.getBooleanConfig(H5DevConfig.H5_USE_UC_WEBVIEW, false)) {
                    H5Log.d(TAG, "read switch use uc webView");
                    return WebViewType.THIRD_PARTY;
                }
                H5Log.d(TAG, "read switch use android webView");
                return WebViewType.SYSTEM_BUILD_IN;
            } else if (Nebula.h5_dev_uc) {
                if (H5Utils.getConfigBoolean(context, "h5_uc_webview")) {
                    H5Log.d(TAG, "debug config to enable uc webview");
                    return WebViewType.THIRD_PARTY;
                }
                H5Log.d(TAG, "debug config to disable uc webview");
                return WebViewType.SYSTEM_BUILD_IN;
            }
        }
        String string = H5Utils.getString(bundle, H5Param.USE_SYS_WEBVIEW);
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string) && !useSysWebWillCrash()) {
            H5Log.d(TAG, "useSysWeb " + string + " use SysWebview");
            return WebViewType.SYSTEM_BUILD_IN;
        } else if (!enableExternalWebView(str, bundle) && !useSysWebWillCrash()) {
            return WebViewType.SYSTEM_BUILD_IN;
        } else {
            H5Log.d(TAG, "bizType match online config to use uc webview");
            return WebViewType.THIRD_PARTY;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.alibaba.a.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.alibaba.a.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.alibaba.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: com.alibaba.a.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0113 A[EDGE_INSN: B:79:0x0113->B:64:0x0113 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enableExternalWebView(java.lang.String r16, android.os.Bundle r17) {
        /*
            r1 = r17
            java.lang.String r0 = "h5_webViewConfig"
            java.lang.String r0 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "h5_webViewConfig "
            java.lang.String r2 = r3.concat(r2)
            java.lang.String r3 = "H5WebViewChoose"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r2)
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)
            java.lang.String r2 = "h5_enableExternalWebView"
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r2)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r4 != 0) goto L_0x002f
            java.lang.String r4 = "YES"
            boolean r2 = r4.equalsIgnoreCase(r2)
            goto L_0x0030
        L_0x002f:
            r2 = 1
        L_0x0030:
            r4 = 0
            if (r2 != 0) goto L_0x0034
            return r4
        L_0x0034:
            r2 = 2
            r6 = 0
            java.lang.String r7 = "h5_externalWebViewUsageRule"
            com.alibaba.a.e r7 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r7, r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String r8 = "h5_externalWebViewSdkVersion"
            com.alibaba.a.e r8 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r8, r6)     // Catch:{ Exception -> 0x005a }
            java.lang.String r9 = "h5_externalWebViewModel"
            com.alibaba.a.b r9 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r0, r9, r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r10 = "h5_externalWebView4UC"
            com.alibaba.a.b r6 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r0, r10, r6)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r10 = "h5_externalWebView4CPU"
            int r2 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r10, (int) r2)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0066
        L_0x0055:
            r0 = move-exception
            goto L_0x0061
        L_0x0057:
            r0 = move-exception
            r9 = r6
            goto L_0x0061
        L_0x005a:
            r0 = move-exception
            r8 = r6
            goto L_0x0060
        L_0x005d:
            r0 = move-exception
            r7 = r6
            r8 = r7
        L_0x0060:
            r9 = r8
        L_0x0061:
            java.lang.String r10 = "exception detail"
            com.alipay.mobile.nebula.util.H5Log.e(r3, r10, r0)
        L_0x0066:
            boolean r0 = com.alipay.mobile.nebula.util.H5DeviceHelper.x86(r2)
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = "x86 cpu use system webview."
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r0 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            r10 = r0
            com.alipay.mobile.nebula.provider.H5LogProvider r10 = (com.alipay.mobile.nebula.provider.H5LogProvider) r10
            if (r10 == 0) goto L_0x009a
            java.lang.String r0 = "appId"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            java.lang.String r0 = "isTinyApp"
            boolean r0 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r1, (java.lang.String) r0, (boolean) r4)
            java.lang.String r14 = java.lang.String.valueOf(r0)
            r15 = 0
            java.lang.String r11 = "H5_USE_AndroidWebview"
            java.lang.String r12 = "x86 core, degrade to system webview,"
            r10.log(r11, r12, r13, r14, r15)
        L_0x009a:
            r0 = 0
            goto L_0x009d
        L_0x009c:
            r0 = 1
        L_0x009d:
            if (r0 == 0) goto L_0x00ab
            boolean r1 = disableUcWebView(r6, r1)
            if (r1 == 0) goto L_0x00ab
            java.lang.String r0 = "disable ucwebview by h5_externalWebView4UC"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            r0 = 0
        L_0x00ab:
            if (r0 == 0) goto L_0x00ea
            java.util.HashMap r0 = buildWebViewSdkVersion(r8)
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "min"
            boolean r6 = r0.containsKey(r2)
            java.lang.String r8 = "disable ucwebview by h5_externalWebViewSdkVersion"
            if (r6 == 0) goto L_0x00e6
            java.lang.String r6 = "max"
            boolean r10 = r0.containsKey(r6)
            if (r10 == 0) goto L_0x00e6
            java.lang.Object r2 = r0.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 > r1) goto L_0x00df
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r1 > r0) goto L_0x00df
            r0 = 1
            goto L_0x00e0
        L_0x00df:
            r0 = 0
        L_0x00e0:
            if (r0 != 0) goto L_0x00ea
            com.alipay.mobile.nebula.util.H5Log.d(r3, r8)
            goto L_0x00ea
        L_0x00e6:
            com.alipay.mobile.nebula.util.H5Log.d(r3, r8)
            r0 = 0
        L_0x00ea:
            if (r0 == 0) goto L_0x0113
            if (r9 == 0) goto L_0x0113
            r1 = 0
        L_0x00ef:
            int r2 = r9.size()
            if (r1 >= r2) goto L_0x0113
            java.lang.String r2 = r9.getString(r1)
            java.lang.String r6 = android.os.Build.MODEL
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0110
            java.lang.String r6 = android.os.Build.MODEL
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0110
            java.lang.String r0 = "disable ucwebview by h5_externalWebViewModel"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            r0 = 0
            goto L_0x0113
        L_0x0110:
            int r1 = r1 + 1
            goto L_0x00ef
        L_0x0113:
            if (r0 == 0) goto L_0x0147
            boolean r0 = android.text.TextUtils.isEmpty(r16)
            if (r0 != 0) goto L_0x0146
            java.util.HashMap r0 = buildWebViewRules(r7)
            int r1 = r0.size()
            if (r1 == 0) goto L_0x0141
            r1 = r16
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "SYSTEM_BUILD_IN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x013b
            java.lang.String r0 = "disable ucwebview by h5_externalWebViewUsageRule"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            return r4
        L_0x013b:
            java.lang.String r0 = "THIRDPARTY"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            return r5
        L_0x0141:
            java.lang.String r0 = "rulesInMap is null, default"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
        L_0x0146:
            return r5
        L_0x0147:
            java.lang.String r0 = "disable ucwebview finally"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.env.H5WebViewChoose.enableExternalWebView(java.lang.String, android.os.Bundle):boolean");
    }

    private static HashMap<String, String> buildWebViewRules(e eVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (eVar != null) {
            try {
                for (Map.Entry next : eVar.entrySet()) {
                    try {
                        hashMap.put(next.getKey(), (String) next.getValue());
                    } catch (ClassCastException e2) {
                        H5Log.e(TAG, "exception detail", e2);
                    }
                }
            } catch (Exception e3) {
                H5Log.e(TAG, "exception detail.", e3);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Integer> buildWebViewSdkVersion(e eVar) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (eVar != null) {
            for (Map.Entry next : eVar.entrySet()) {
                hashMap.put(next.getKey(), (Integer) next.getValue());
            }
        }
        return hashMap;
    }

    public static void sendUcReceiver(boolean z) {
        a a2 = a.a(H5Environment.getContext());
        Intent intent = new Intent(H5Param.H5_ACTION_UC_INIT_FINISH);
        intent.putExtra("result", z);
        a2.a(intent);
    }

    public static boolean notNeedInitUc(Bundle bundle) {
        boolean z = getWebViewType(getBizType(bundle), H5Environment.getContext(), bundle) == WebViewType.THIRD_PARTY;
        H5Log.d(TAG, "ucReady " + H5Flag.ucReady + " useUc " + z + " needInitUc " + H5Flag.initUcNormal);
        return H5Flag.ucReady || !z || !H5Flag.initUcNormal;
    }

    public static String getBizType(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = H5Utils.getString(bundle, H5Param.LONG_BIZ_TYPE, "");
        if (TextUtils.isEmpty(string)) {
            string = H5Utils.getString(bundle, H5Param.PUBLIC_ID, "");
        }
        return TextUtils.isEmpty(string) ? H5Utils.getString(bundle, "appId") : string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00db, code lost:
        com.alipay.mobile.nebula.util.H5Log.d(TAG, "disableUcWebView loop object in round " + r8 + ", pi || ai || eu break");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean disableUcWebView(com.alibaba.a.b r16, android.os.Bundle r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r4 = "H5WebViewChoose"
            if (r0 == 0) goto L_0x0162
            boolean r5 = r16.isEmpty()
            if (r5 != 0) goto L_0x0162
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = android.os.Build.MANUFACTURER
            r5.append(r6)
            java.lang.String r6 = "#"
            r5.append(r6)
            java.lang.String r7 = android.os.Build.MODEL
            r5.append(r7)
            r5.append(r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "appId"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r6)
            java.lang.String r8 = "url"
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "disableUcWebView phoneInfo is "
            r8.<init>(r9)
            r8.append(r5)
            java.lang.String r9 = ", appId is "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = ", entryUrl is "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "disableUcWebView jsonArray is "
            r8.<init>(r9)
            java.lang.String r9 = r16.toJSONString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r8)
            r8 = 0
        L_0x0072:
            int r9 = r16.size()
            if (r8 >= r9) goto L_0x0162
            java.lang.String r9 = java.lang.String.valueOf(r8)
            java.lang.String r10 = "disableUcWebView loop jsonArray round "
            java.lang.String r9 = r10.concat(r9)
            com.alipay.mobile.nebula.util.H5Log.d(r4, r9)
            com.alibaba.a.e r9 = r0.getJSONObject(r8)
            int r10 = r9.size()
            if (r9 == 0) goto L_0x015d
            java.util.Set r11 = r9.keySet()
            java.util.Iterator r11 = r11.iterator()
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x009a:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L_0x00d0
            java.lang.Object r15 = r11.next()
            java.lang.String r15 = (java.lang.String) r15
            java.lang.String r2 = r9.getString(r15)
            java.lang.String r3 = "phoneInfo"
            boolean r3 = r3.equalsIgnoreCase(r15)
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r5.equalsIgnoreCase(r2)
            r12 = r3
        L_0x00b7:
            boolean r3 = r6.equalsIgnoreCase(r15)
            if (r3 == 0) goto L_0x00c2
            boolean r3 = android.text.TextUtils.equals(r7, r2)
            r13 = r3
        L_0x00c2:
            java.lang.String r3 = "entryUrl"
            boolean r3 = r3.equalsIgnoreCase(r15)
            if (r3 == 0) goto L_0x009a
            boolean r2 = android.text.TextUtils.equals(r1, r2)
            r14 = r2
            goto L_0x009a
        L_0x00d0:
            java.lang.String r2 = "disableUcWebView loop object in round "
            r3 = 1
            if (r10 != r3) goto L_0x00f1
            if (r12 != 0) goto L_0x00db
            if (r13 != 0) goto L_0x00db
            if (r14 == 0) goto L_0x00f1
        L_0x00db:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r1 = ", pi || ai || eu break"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            goto L_0x0163
        L_0x00f1:
            r9 = 2
            if (r10 != r9) goto L_0x013f
            if (r12 == 0) goto L_0x010d
            if (r13 == 0) goto L_0x010d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r1 = ", pi && ai break"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            goto L_0x0163
        L_0x010d:
            if (r12 == 0) goto L_0x0126
            if (r14 == 0) goto L_0x0126
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r1 = ", pi && eu break"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            goto L_0x0163
        L_0x0126:
            if (r13 == 0) goto L_0x013f
            if (r14 == 0) goto L_0x013f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r1 = ", ai && eu break"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            goto L_0x0163
        L_0x013f:
            r9 = 3
            if (r10 != r9) goto L_0x015e
            if (r12 == 0) goto L_0x015e
            if (r13 == 0) goto L_0x015e
            if (r14 == 0) goto L_0x015e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r1 = ", pi && ai && eu break"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            goto L_0x0163
        L_0x015d:
            r3 = 1
        L_0x015e:
            int r8 = r8 + 1
            goto L_0x0072
        L_0x0162:
            r3 = 0
        L_0x0163:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "disableUcWebView result "
            java.lang.String r0 = r1.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.env.H5WebViewChoose.disableUcWebView(com.alibaba.a.b, android.os.Bundle):boolean");
    }
}
