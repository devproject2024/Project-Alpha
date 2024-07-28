package com.alipay.mobile.nebulacore.dev.provider;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.a.e;
import com.alibaba.a.a;
import com.alibaba.a.b;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.dev.H5BugmeLogCollector;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.batched.BatchedScheduler;
import com.alipay.mobile.nebulacore.dev.bugme.H5BugmeBatchedScheduler;
import com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class H5WalletDevDebugProvider implements H5DevDebugProvider {
    private static final String SCOPE_MODEL = "deviceModel";
    private static final String SCOPE_PKG_INFO = "pkgInfo";
    private static final String SCOPE_SESSION = "session";
    private static final String SCOPE_TITLE = "title";
    private static final String SCOPE_UA = "ua";
    private static final String SCOPE_URL = "url";
    public static final String TAG = "H5WalletDevDebugProvider";
    private Set<String> ignoreConsoleFuncs = null;
    private Map<String, e<String, OneShotValue>> mDataMap = new HashMap();
    private H5BugMeManager mH5BugMeManager = null;
    private H5BugmeBatchedScheduler mScheduler = new H5BugmeBatchedScheduler();

    public H5WalletDevDebugProvider(H5BugMeManager h5BugMeManager) {
        this.mH5BugMeManager = h5BugMeManager;
        this.mDataMap.put("url", new e(20));
        this.mDataMap.put(SCOPE_UA, new e(20));
        this.mDataMap.put("title", new e(20));
        this.mDataMap.put(SCOPE_MODEL, new e(20));
        this.mDataMap.put(SCOPE_SESSION, new e(20));
        this.mDataMap.put(SCOPE_PKG_INFO, new e(20));
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            try {
                b parseArray = a.parseArray(h5ConfigProvider.getConfig("h5_bugmeIgnoreConsole"));
                int size = parseArray.size();
                this.ignoreConsoleFuncs = new HashSet();
                for (int i2 = 0; i2 < size; i2++) {
                    this.ignoreConsoleFuncs.add(parseArray.getString(i2));
                }
            } catch (Throwable th) {
                H5Log.e(TAG, "parse config error", th);
            }
        }
    }

    private void putOneShotValue(String str, String str2, Object obj) {
        e eVar;
        if (obj != null && str2 != null) {
            if ((str.equals(SCOPE_PKG_INFO) || !TextUtils.isEmpty((String) obj)) && (eVar = this.mDataMap.get(str)) != null) {
                OneShotValue oneShotValue = (OneShotValue) eVar.get(str2);
                if (oneShotValue == null) {
                    eVar.put(str2, new OneShotValue(obj, false));
                    H5Log.d(TAG, "put OneShotValue[" + str + "] " + obj);
                } else if (!obj.equals(oneShotValue.value)) {
                    oneShotValue.value = obj;
                    oneShotValue.used = false;
                    eVar.put(str2, oneShotValue);
                    H5Log.d(TAG, "put OneShotValue[" + str + "] " + obj);
                }
            }
        }
    }

    private Object getOneShotValue(String str, String str2, boolean z) {
        OneShotValue oneShotValue;
        e eVar = this.mDataMap.get(str);
        if (eVar == null || str2 == null || (oneShotValue = (OneShotValue) eVar.get(str2)) == null) {
            return null;
        }
        if (z) {
            return oneShotValue.value;
        }
        if (oneShotValue.used) {
            return null;
        }
        oneShotValue.used = true;
        return oneShotValue.value;
    }

    public BatchedScheduler<com.alibaba.a.e> getScheduler() {
        return this.mScheduler;
    }

    public void pageLog(String str, String str2, String str3, String str4, String str5, com.alibaba.a.e eVar) {
        com.alibaba.a.e eVar2 = new com.alibaba.a.e();
        eVar2.put("type", (Object) H5Param.PAGE);
        eVar2.put("subType", (Object) str);
        eVar2.put("viewId", (Object) str2);
        if (!TextUtils.isEmpty(str4)) {
            eVar2.put("url", (Object) str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            eVar2.put("title", (Object) str5);
        }
        if (eVar != null) {
            eVar2.put("extra", (Object) eVar);
        }
        if (!TextUtils.isEmpty(str3)) {
            putOneShotValue(SCOPE_UA, str2, str3);
        }
        putOneShotValue(SCOPE_MODEL, str2, Build.MODEL);
        sendLog(str2, eVar2);
    }

    public void jsApiLog(String str, String str2, String str3, String str4, String str5) {
        Set<String> set;
        if (TextUtils.isEmpty(str) || (set = this.ignoreConsoleFuncs) == null || !set.contains(str)) {
            com.alibaba.a.e eVar = new com.alibaba.a.e();
            eVar.put("type", (Object) "jsapi");
            eVar.put("subType", (Object) str);
            eVar.put("viewId", (Object) str2);
            eVar.put("eventId", (Object) str3);
            eVar.put("request", (Object) str4);
            eVar.put(Payload.RESPONSE, (Object) str5);
            sendLog(str2, eVar);
        }
    }

    public void eventLog(String str, String str2, String str3) {
        com.alibaba.a.e eVar = new com.alibaba.a.e();
        eVar.put("type", (Object) AppConstants.NOTIFICATION_DETAILS.EVENT);
        eVar.put("subType", (Object) str);
        eVar.put("viewId", (Object) str2);
        eVar.put("data", (Object) str3);
        sendLog(str2, eVar);
    }

    public void consoleLog(String str, String str2, String str3, String str4) {
        Set<String> set;
        if (TextUtils.isEmpty(str4) || (set = this.ignoreConsoleFuncs) == null || !set.contains(str4)) {
            com.alibaba.a.e eVar = new com.alibaba.a.e();
            eVar.put("type", (Object) "console");
            eVar.put("subType", (Object) str);
            eVar.put("viewId", (Object) str2);
            eVar.put("content", (Object) str3);
            sendLog(str2, eVar);
        }
    }

    public void netWorkLog(String str, String str2, com.alibaba.a.e eVar) {
        String str3 = str2;
        com.alibaba.a.e eVar2 = eVar;
        String string = H5Utils.getString(eVar2, "reqUrl");
        String string2 = H5Utils.getString(eVar2, "method");
        String string3 = H5Utils.getString(eVar2, "protocol");
        int i2 = H5Utils.getInt(eVar2, "reqId");
        String valueOf = String.valueOf(H5Utils.getInt(eVar2, "statusCode"));
        boolean z = H5Utils.getBoolean(eVar2, "fromLocalPkg", false);
        String string4 = H5Utils.getString(eVar2, "trimmedResponse");
        com.alibaba.a.e eVar3 = new com.alibaba.a.e();
        String str4 = "fromLocalPkg";
        boolean z2 = z;
        eVar3.put("type", (Object) ContactsConstant.NETWORK);
        eVar3.put("subType", (Object) str);
        eVar3.put("viewId", (Object) str3);
        eVar3.put("reqId", (Object) Integer.valueOf(i2));
        eVar3.put("reqUrl", (Object) string);
        eVar3.put("method", (Object) string2);
        if (!TextUtils.isEmpty(valueOf) && !"0".equals(valueOf)) {
            eVar3.put("statusCode", (Object) valueOf);
        }
        if (!TextUtils.isEmpty(string4)) {
            eVar3.put("trimmedResponse", (Object) string4);
        }
        if (!TextUtils.isEmpty(string3)) {
            eVar3.put("protocol", (Object) string3);
        }
        eVar3.put(str4, (Object) Boolean.valueOf(z2));
        sendLog(str3, eVar3);
    }

    public void screenshot(String str, final String str2) {
        final com.alibaba.a.e eVar = new com.alibaba.a.e();
        eVar.put("type", (Object) "screenshot");
        eVar.put("subType", (Object) str);
        eVar.put("viewId", (Object) str2);
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                Bitmap takeScreenShot;
                H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
                if (!(h5Service == null || h5Service.getTopH5Page() == null || (takeScreenShot = H5PerformanceUtils.takeScreenShot(h5Service.getTopH5Page())) == null)) {
                    PoolingByteArrayOutputStream poolingByteArrayOutputStream = null;
                    try {
                        PoolingByteArrayOutputStream poolingByteArrayOutputStream2 = new PoolingByteArrayOutputStream();
                        try {
                            takeScreenShot.compress(Bitmap.CompressFormat.JPEG, 100, poolingByteArrayOutputStream2);
                            eVar.put("img", (Object) Base64.encodeToString(poolingByteArrayOutputStream2.toByteArray(), 0));
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            poolingByteArrayOutputStream = poolingByteArrayOutputStream2;
                            try {
                                H5Log.e(H5WalletDevDebugProvider.TAG, (Throwable) e);
                                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                H5WalletDevDebugProvider.this.sendLog(str2, eVar);
                            } catch (Throwable th) {
                                th = th;
                                poolingByteArrayOutputStream2 = poolingByteArrayOutputStream;
                                H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        H5Log.e(H5WalletDevDebugProvider.TAG, (Throwable) e);
                        H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                        H5WalletDevDebugProvider.this.sendLog(str2, eVar);
                    }
                }
                H5WalletDevDebugProvider.this.sendLog(str2, eVar);
            }
        });
    }

    public void welcome(String str, String str2, String str3, String str4) {
        com.alibaba.a.e eVar = new com.alibaba.a.e();
        eVar.put("type", (Object) str);
        eVar.put("subType", (Object) str2);
        eVar.put("viewId", (Object) str3);
        eVar.put("hello", (Object) str4);
        sendLog(str3, eVar);
    }

    public void setUserAgent(String str, String str2) {
        putOneShotValue(SCOPE_UA, str, str2);
    }

    public void setTitle(String str, String str2) {
        putOneShotValue("title", str, str2);
    }

    public void setPageUrl(String str, String str2) {
        putOneShotValue("url", str, str2);
    }

    public void setSessionId(String str, String str2) {
        putOneShotValue(SCOPE_SESSION, str, str2);
    }

    public void setPkgInfo(String str, com.alibaba.a.e eVar) {
        putOneShotValue(SCOPE_PKG_INFO, str, eVar);
    }

    public void onRelease() {
        H5BugmeBatchedScheduler h5BugmeBatchedScheduler = this.mScheduler;
        if (h5BugmeBatchedScheduler != null) {
            h5BugmeBatchedScheduler.shutdown();
            this.mScheduler = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkSwitch(java.lang.String r5, com.alibaba.a.e r6) {
        /*
            r4 = this;
            r0 = 1
            if (r5 == 0) goto L_0x0015
            java.lang.String r1 = "url"
            java.lang.Object r5 = r4.getOneShotValue(r1, r5, r0)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0016
            com.alipay.mobile.nebula.dev.H5BugMeManager r1 = r4.mH5BugMeManager
            boolean r1 = r1.hasAccessToDebug(r5)
            goto L_0x0017
        L_0x0015:
            r5 = 0
        L_0x0016:
            r1 = 1
        L_0x0017:
            java.lang.String r2 = "H5WalletDevDebugProvider"
            r3 = 0
            if (r1 != 0) goto L_0x002a
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "do not have access for url: "
            java.lang.String r5 = r6.concat(r5)
            com.alipay.mobile.nebula.util.H5Log.d(r2, r5)
            return r3
        L_0x002a:
            java.lang.String r5 = "h5_bug_me_debug_switch"
            boolean r5 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r5, r3)
            if (r5 == 0) goto L_0x0033
            return r0
        L_0x0033:
            java.lang.String r5 = "h5_trace_debug_switch"
            boolean r5 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r5, r3)
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = "type"
            java.lang.String r5 = r6.getString(r5)
            java.lang.String r6 = "page"
            boolean r5 = r6.equals(r5)
            return r5
        L_0x0049:
            java.lang.String r5 = "H5 switch can't send bumge log"
            com.alipay.mobile.nebula.util.H5Log.d(r2, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.provider.H5WalletDevDebugProvider.checkSwitch(java.lang.String, com.alibaba.a.e):boolean");
    }

    /* access modifiers changed from: private */
    public void sendLog(String str, com.alibaba.a.e eVar) {
        if (this.mScheduler != null) {
            boolean checkSwitch = checkSwitch(str, eVar);
            if (checkSwitch || H5BugmeLogCollector.enabled()) {
                eVar.put("id", (Object) Integer.valueOf(H5BugmeIdGenerator.nextId()));
                eVar.put(StringSet.ts, (Object) Long.valueOf(System.currentTimeMillis()));
                eVar.put("bugmeSwitchOpen", (Object) Boolean.valueOf(checkSwitch));
                Object oneShotValue = getOneShotValue("url", str, false);
                if (oneShotValue != null) {
                    eVar.put("url", (Object) oneShotValue.toString());
                }
                Object oneShotValue2 = getOneShotValue("title", str, false);
                if (oneShotValue2 != null) {
                    eVar.put("title", (Object) oneShotValue2.toString());
                }
                Object oneShotValue3 = getOneShotValue(SCOPE_UA, str, false);
                if (oneShotValue3 != null) {
                    eVar.put("userAgent", (Object) oneShotValue3.toString());
                }
                Object oneShotValue4 = getOneShotValue(SCOPE_MODEL, str, false);
                if (oneShotValue4 != null) {
                    eVar.put(SCOPE_MODEL, (Object) oneShotValue4.toString());
                }
                Object oneShotValue5 = getOneShotValue(SCOPE_SESSION, str, false);
                if (oneShotValue5 != null) {
                    eVar.put(H5Param.SESSION_ID, (Object) oneShotValue5.toString());
                }
                Object oneShotValue6 = getOneShotValue(SCOPE_PKG_INFO, str, false);
                if (oneShotValue6 != null) {
                    eVar.put(AppManagerUtil.EXTEND_PREFIX_DEFAULT, (Object) oneShotValue6.toString());
                }
                this.mScheduler.post(eVar);
            }
        }
    }

    class OneShotValue {
        boolean used;
        Object value;

        public OneShotValue(Object obj, boolean z) {
            this.value = obj;
            this.used = z;
        }
    }
}
