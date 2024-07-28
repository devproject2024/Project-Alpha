package com.alipay.mobile.nebulacore.bridge;

import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventDispatchHandler;
import com.alipay.mobile.h5container.api.H5JsCallData;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5JSApiMonitorFilter;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.core.H5BridgeContextImpl;
import com.alipay.mobile.nebulacore.core.H5BridgeRunnable;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.plugin.H5AlertPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SessionPlugin;
import com.alipay.mobile.nebulacore.web.H5WebView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class H5BridgeImpl implements H5Bridge {
    private static final double JSAPI_MONITOR_SAMPLE_RATE = 0.1d;
    private static final String KEY_JSAPI_SAMPLE_RATE = "h5_jsapi_sample_rate";
    public static final String TAG = "H5BridgeImpl";
    private static List<String> WHITE_EVENT_LIST = new ArrayList();
    private static List<String> WHITE_JSAPI_LIST = new ArrayList();
    private List<String> apiWhiteParseList = new ArrayList();
    private String appId;
    private b asyncJsapiPostWeb;
    private Map<String, Long> callLog;
    private Map<String, H5CallBack> callPool;
    private H5Page h5Page;
    private Random random = new Random(System.currentTimeMillis());
    private boolean released;
    private int size = AppConstants.START_OTP_FLOW;
    private boolean tinyApp;
    /* access modifiers changed from: private */
    public H5WebView webView;
    /* access modifiers changed from: private */
    public List<Integer> whiteCode = new ArrayList();
    private b whiteJsApiJsonArray;

    static {
        WHITE_EVENT_LIST.add("JSPlugin_AlipayH5Share");
        WHITE_EVENT_LIST.add("beforeunload");
        WHITE_EVENT_LIST.add("message");
        WHITE_EVENT_LIST.add("nbcomponent.canrender");
        WHITE_JSAPI_LIST.add(H5SessionPlugin.SHOW_NETWORK_CHECK_ACTIVITY);
        WHITE_JSAPI_LIST.add(H5AlertPlugin.SHOW_UC_FAIL_DIALOG);
        WHITE_JSAPI_LIST.add("setKeyboardType");
        WHITE_JSAPI_LIST.add(H5Param.MONITOR_PERFORMANCE);
        WHITE_JSAPI_LIST.add("getStartupParams");
    }

    public H5BridgeImpl(H5WebView h5WebView, H5Page h5Page2) {
        this.webView = h5WebView;
        this.released = false;
        this.callPool = new ConcurrentHashMap();
        this.callLog = new ConcurrentHashMap();
        this.h5Page = h5Page2;
        this.tinyApp = H5Utils.getBoolean(h5Page2.getParams(), H5Param.isTinyApp, false);
        this.appId = H5Utils.getString(h5Page2.getParams(), "appId");
        try {
            initChart();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_white_jsapiList");
        if (!TextUtils.isEmpty(configWithProcessCache)) {
            this.whiteJsApiJsonArray = H5Utils.parseArray(configWithProcessCache);
        }
        String configWithProcessCache2 = H5Environment.getConfigWithProcessCache("h5_async_jsapi_postWeb");
        if (!TextUtils.isEmpty(configWithProcessCache2)) {
            this.asyncJsapiPostWeb = H5Utils.parseArray(configWithProcessCache2);
        }
    }

    public void onRelease() {
        this.released = true;
        this.webView = null;
        this.callPool.clear();
        this.callLog.clear();
        this.callLog = null;
        this.callPool = null;
        this.h5Page = null;
    }

    public void sendToNative(H5Event h5Event) {
        if (h5Event != null && !this.released) {
            postNative(h5Event, (H5BridgeContext) null);
        }
    }

    public void sendToNative(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event != null && !this.released) {
            postNative(h5Event, h5BridgeContext);
        }
    }

    private void postNative(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        if (!h5Event.isDispatcherOnWorkThread()) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5BridgeImpl.this.executeNative(h5Event, h5BridgeContext);
                }
            });
        } else if (H5Utils.isMain()) {
            H5EventDispatchHandler.getAsyncHandler().post(new Runnable() {
                public void run() {
                    H5BridgeImpl.this.executeNative(h5Event, h5BridgeContext);
                }
            });
        } else {
            executeNative(h5Event, h5BridgeContext);
        }
    }

    /* access modifiers changed from: private */
    public void executeNative(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String str;
        String str2;
        String str3;
        H5BridgeContext h5BridgeContext2;
        boolean z;
        H5AppProvider h5AppProvider;
        H5Event h5Event2 = h5Event;
        if (h5Event2 != null && !this.released) {
            String id = h5Event.getId();
            boolean containsKey = this.callPool.containsKey(id);
            e param = h5Event.getParam();
            if (containsKey) {
                H5CallBack remove = this.callPool.remove(id);
                if (remove != null) {
                    remove.onCallBack(param);
                }
                H5Log.d(TAG, "H5 callback for ".concat(String.valueOf(id)));
                return;
            }
            boolean z2 = h5Event.getTarget() instanceof H5Page;
            String str4 = "";
            if (z2) {
                str2 = H5Utils.getString(((H5Page) h5Event.getTarget()).getParams(), "appId");
                if (!TextUtils.isEmpty(str2) && (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) != null) {
                    str4 = h5AppProvider.getVersion(str2);
                }
                str = str4;
            } else {
                str2 = str4;
                str = str2;
            }
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            double d2 = JSAPI_MONITOR_SAMPLE_RATE;
            if (h5ConfigProvider != null) {
                String config = h5ConfigProvider.getConfig(KEY_JSAPI_SAMPLE_RATE);
                if (!TextUtils.isEmpty(config)) {
                    try {
                        d2 = Double.parseDouble(config);
                    } catch (Exception e2) {
                        H5Log.e(TAG, "parse double failed", e2);
                    }
                }
            }
            Random random2 = this.random;
            boolean z3 = random2 != null && random2.nextDouble() <= d2;
            long currentTimeMillis = System.currentTimeMillis();
            if (!H5JSApiMonitorFilter.shouldFilter(h5Event.getAction()) && H5Monitor.isJSApiMonitorEnabled() && z3) {
                H5Monitor.behavior(new H5MonitorModel().start().seedId(H5MonitorModel.SEED_ID_JSAPI_CALL).appendSubappId(str2).appendPackageVersion(str).appendJSApi(h5Event.getAction()));
            }
            String action = h5Event.getAction();
            Map<String, Long> map = this.callLog;
            String id2 = h5Event.getId();
            long currentTimeMillis2 = System.currentTimeMillis();
            String str5 = H5MonitorModel.SEED_ID_JSAPI_CALL;
            map.put(id2, Long.valueOf(currentTimeMillis2));
            String str6 = null;
            if (param != null) {
                str3 = param.toJSONString();
                param.put("funcName", (Object) action);
            } else {
                str3 = null;
            }
            H5Log.d(TAG, "jsapi req name={" + action + "} eventId " + id + " " + str3);
            if (str3 != null && str3.length() > this.size && !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_notLogForMaxReq"))) {
                H5Log.d(TAG, "match size substring " + str3.length());
                str3 = str3.substring(0, this.size);
            }
            long j = currentTimeMillis;
            H5JsCallData build = new H5JsCallData.Builder().setAction(action).setElapse(0).setJoMsg(str3).build();
            if (this.h5Page.getPageData() != null) {
                this.h5Page.getPageData().addJsapiInfo(h5Event.getId(), build);
            }
            if (z2 && H5ProviderManagerImpl.getInstance().getProvider(H5DevDebugProvider.class.getName()) != null) {
                e eVar = new e();
                eVar.put("subType", (Object) action);
                eVar.put("request", (Object) str3);
                eVar.put("eventId", (Object) id);
                ((H5Page) h5Event.getTarget()).sendEvent(H5Plugin.CommonEvents.H5_DEV_JS_API_TO_NATIVE, eVar);
            }
            if (h5BridgeContext != null) {
                h5BridgeContext2 = h5BridgeContext;
            } else {
                h5BridgeContext2 = new H5BridgeContextImpl(this, id, action);
            }
            if (z2) {
                H5Page h5Page2 = (H5Page) h5Event.getTarget();
                String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_getRealUrlFromWebViewEnable");
                if (!H5Utils.isMain() || H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(configWithProcessCache)) {
                    str6 = h5Page2.getUrl();
                } else {
                    H5WebView h5WebView = this.webView;
                    if (h5WebView != null) {
                        str6 = h5WebView.getUrl();
                    }
                    if (TextUtils.isEmpty(str6)) {
                        str6 = h5Page2.getUrl();
                    }
                }
                H5Log.d(TAG, "check jsapi [" + action + "] permission for: " + str6);
                String string = H5Utils.getString(h5Page2.getParams(), "appId");
                if (Nebula.getH5TinyAppService() != null ? Nebula.getH5TinyAppService().hasPermissionFile(string) : false) {
                    b bVar = this.whiteJsApiJsonArray;
                    if (bVar != null && bVar.contains(action)) {
                        H5Log.d(TAG, "whiteJsApiJsonArray contain this ".concat(String.valueOf(action)));
                    } else if (!WHITE_JSAPI_LIST.contains(action) && !setPermission(h5Event2, string, h5BridgeContext2, false)) {
                        if (!H5JSApiMonitorFilter.shouldFilter(h5Event.getAction()) && H5Monitor.isJSApiMonitorEnabled()) {
                            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_JSAPI_CALL).appendJSApi(action).appendSubappId(str2).appendPackageVersion(str).appendJSApi(h5Event.getAction()).appendMessage("call " + action + " failed because no permission").appendUrl(str6));
                            return;
                        }
                        return;
                    }
                } else if (!this.tinyApp || !H5Utils.isInTinyProcess() || !enableTinyIgnorePermission()) {
                    H5JSApiPermissionProvider h5JSApiPermissionProvider = (H5JSApiPermissionProvider) H5ProviderManagerImpl.getInstance().getProvider(H5JSApiPermissionProvider.class.getName());
                    if (h5JSApiPermissionProvider != null) {
                        boolean hasDomainPermission = h5JSApiPermissionProvider.hasDomainPermission(action, str6);
                        H5Log.d("H5JSApiPermission|H5Bridge", "has oldPermisson = ".concat(String.valueOf(hasDomainPermission)));
                        z = hasDomainPermission;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        h5BridgeContext2.sendNoRightToInvoke();
                        H5Log.e("H5JSApiPermission|H5Bridge", " API: " + action + " has no permission on page:>>" + str6);
                        if (!H5JSApiMonitorFilter.shouldFilter(h5Event.getAction()) && H5Monitor.isJSApiMonitorEnabled()) {
                            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_JSAPI_CALL).appendSubappId(str2).appendPackageVersion(str).appendJSApi(h5Event.getAction()).appendMessage("call " + action + " failed because no permission").appendUrl(str6));
                            return;
                        }
                        return;
                    }
                } else {
                    H5Log.d(TAG, " is TinyApp  but not has permissionFile most because of installApp fail");
                    H5LogProvider h5LogProvider = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
                    if (h5LogProvider != null) {
                        h5LogProvider.log("h5enableTinyIgnorePermission", (String) null, (String) null, string, action);
                    }
                }
            }
            Nebula.getDispatcher().dispatch(h5Event2, h5BridgeContext2);
            if (!H5JSApiMonitorFilter.shouldFilter(h5Event.getAction()) && H5Monitor.isJSApiMonitorEnabled() && z3) {
                H5Monitor.behavior(new H5MonitorModel().success().appendCostTime(System.currentTimeMillis() - j).appendSubappId(str2).appendPackageVersion(str).appendJSApi(h5Event.getAction()).seedId(str5));
            }
        }
    }

    private boolean enableTinyIgnorePermission() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableTinyIgnorePermission"));
    }

    public void sendToWeb(H5Event h5Event) {
        if (h5Event != null && !this.released) {
            postWeb(h5Event);
        }
    }

    private void postWeb(final H5Event h5Event) {
        b bVar;
        if (h5Event == null || (bVar = this.asyncJsapiPostWeb) == null || !bVar.contains(h5Event.getAction())) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    try {
                        H5BridgeImpl.this.executeWeb(h5Event);
                    } catch (OutOfMemoryError e2) {
                        H5Log.e(H5BridgeImpl.TAG, (Throwable) e2);
                    }
                }
            });
        } else {
            H5EventDispatchHandler.getAsyncHandler().post(new Runnable() {
                public void run() {
                    try {
                        H5BridgeImpl.this.executeWeb(h5Event);
                    } catch (OutOfMemoryError e2) {
                        H5Log.e(H5BridgeImpl.TAG, (Throwable) e2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void executeWeb(H5Event h5Event) {
        H5Page h5Page2;
        H5CallBack remove;
        if (h5Event != null && this.webView != null) {
            String id = h5Event.getId();
            String action = h5Event.getAction();
            e param = h5Event.getParam();
            String type = h5Event.getType();
            boolean isKeepCallback = h5Event.isKeepCallback();
            e eVar = new e();
            eVar.put("clientId", (Object) id);
            eVar.put(H5Param.FUNC, (Object) action);
            eVar.put(H5Param.PARAM, (Object) param);
            eVar.put(H5Param.MSG_TYPE, (Object) type);
            eVar.put(H5Param.KEEP_CALLBACK, (Object) Boolean.valueOf(isKeepCallback));
            String str = "AlipayJSBridge._invokeJS(" + a.toJSONString(eVar.toJSONString()) + ")";
            new H5BridgeRunnable(this.h5Page, param, this.callLog, action, id).run();
            Map<String, Long> map = this.callLog;
            if ((map == null || !map.containsKey(id)) && (h5Page2 = this.h5Page) != null) {
                String string = H5Utils.getString(h5Page2.getParams(), "appId");
                boolean z = false;
                if (Nebula.getH5TinyAppService() != null) {
                    z = Nebula.getH5TinyAppService().hasPermissionFile(string);
                }
                if (z && !setPermission(h5Event, string, (H5BridgeContext) null, true) && !WHITE_EVENT_LIST.contains(action)) {
                    if (this.callPool.containsKey(id) && (remove = this.callPool.remove(id)) != null) {
                        e eVar2 = new e();
                        eVar2.put("prevent", (Object) Boolean.FALSE);
                        remove.onCallBack(eVar2);
                        H5Log.d(TAG, action + " H5 callback for " + id);
                        return;
                    }
                    return;
                }
            }
            try {
                if (Nebula.DEBUG && !id.startsWith("native_") && this.callLog != null && this.callLog.containsKey(id) && !isKeepCallback) {
                    H5Log.d(TAG, action + " js_native_is cost time " + (System.currentTimeMillis() - this.callLog.get(id).longValue()));
                }
                if (!fixJson(action, str)) {
                    this.webView.loadUrl("javascript:(function(){if(typeof AlipayJSBridge === 'object'){" + str + "}})();");
                    H5Log.d(TAG, "jsapi rep:".concat(String.valueOf(str)));
                }
            } catch (Exception e2) {
                H5Log.e(TAG, "loadUrl exception", e2);
            }
        }
    }

    private boolean fixJson(String str, final String str2) {
        if (!this.apiWhiteParseList.contains(str)) {
            return false;
        }
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                String str = "";
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    if (H5BridgeImpl.this.whiteCode == null || !H5BridgeImpl.this.whiteCode.contains(Integer.valueOf(str2.charAt(i2)))) {
                        str = str + str2.charAt(i2);
                    } else {
                        H5Log.d(H5BridgeImpl.TAG, "contain white" + str2.charAt(i2) + " not add");
                    }
                }
                H5Log.d(H5BridgeImpl.TAG, "coast " + (System.currentTimeMillis() - currentTimeMillis) + " for action fixJson");
                if (H5BridgeImpl.this.webView != null) {
                    H5BridgeImpl.this.webView.loadUrl("javascript:(function(){if(typeof AlipayJSBridge === 'object'){" + str + "}})();");
                    H5Log.d(H5BridgeImpl.TAG, "fixJson jsapi rep:".concat(String.valueOf(str)));
                }
            }
        });
        return true;
    }

    private void initChart() {
        e parseObject;
        String config = H5Environment.getConfig("h5_Whitespace");
        if (!TextUtils.isEmpty(config) && (parseObject = H5Utils.parseObject(config)) != null && parseObject.containsKey(this.appId)) {
            String string = H5Utils.getString(parseObject, this.appId);
            if (!TextUtils.isEmpty(string)) {
                this.apiWhiteParseList = Arrays.asList(string.split("\\|"));
                String string2 = H5Utils.getString(parseObject, "whitespace_code");
                if (!TextUtils.isEmpty(string2)) {
                    for (String parseInt : Arrays.asList(string2.split("\\|"))) {
                        this.whiteCode.add(Integer.valueOf(Integer.parseInt(parseInt)));
                    }
                }
            }
        }
    }

    private boolean setPermission(H5Event h5Event, String str, H5BridgeContext h5BridgeContext, boolean z) {
        if (Nebula.getH5TinyAppService() != null) {
            return Nebula.getH5TinyAppService().setPermission(h5Event, str, h5BridgeContext, z);
        }
        return true;
    }

    public void sendToWeb(String str, e eVar, H5CallBack h5CallBack) {
        H5Session session;
        HashMap hashMap;
        e eVar2;
        e eVar3;
        if (!this.released) {
            H5Event build = new H5Event.Builder().action(str).param(eVar).type(H5Event.TYPE_CALL).build();
            if (h5CallBack != null) {
                this.callPool.put(build.getId(), h5CallBack);
            }
            H5Page h5Page2 = this.h5Page;
            if (!(h5Page2 == null || (session = h5Page2.getSession()) == null)) {
                String serviceWorkerID = session.getServiceWorkerID();
                if (!TextUtils.isEmpty(serviceWorkerID)) {
                    H5Log.d(TAG, "sendToWeb workId ".concat(String.valueOf(serviceWorkerID)));
                    H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
                    if (h5Service != null) {
                        try {
                            hashMap = new HashMap();
                            hashMap.put("appId", serviceWorkerID);
                            eVar2 = new e();
                            eVar2.put(H5Param.FUNC, (Object) str);
                            if (eVar != null) {
                                eVar3 = eVar.getJSONObject("data");
                                if (eVar3 == null) {
                                    eVar3 = new e();
                                    eVar.put("data", (Object) eVar3);
                                }
                                eVar3.put(Constants.EVENTS_NB_PAGE_URL, (Object) this.h5Page.getUrl());
                                eVar2.put(H5Param.PARAM, (Object) eVar);
                            } else {
                                e eVar4 = new e();
                                e eVar5 = new e();
                                eVar5.put(Constants.EVENTS_NB_PAGE_URL, (Object) this.h5Page.getUrl());
                                eVar4.put("data", (Object) eVar5);
                                eVar2.put(H5Param.PARAM, (Object) eVar4);
                            }
                        } catch (Throwable th) {
                            H5Log.e(TAG, "catch exception ", th);
                        }
                        hashMap.put("message", eVar2.toJSONString());
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        hashMap.put("messageId", sb.toString());
                        h5Service.sendServiceWorkerPushMessage(hashMap);
                    }
                }
            }
            sendToWeb(build);
        }
    }

    public void sendDataWarpToWeb(String str, e eVar, H5CallBack h5CallBack) {
        if (eVar == null || eVar.isEmpty()) {
            sendToWeb(str, eVar, h5CallBack);
            return;
        }
        e eVar2 = new e();
        eVar2.put("data", (Object) eVar);
        sendToWeb(str, eVar2, h5CallBack);
    }
}
