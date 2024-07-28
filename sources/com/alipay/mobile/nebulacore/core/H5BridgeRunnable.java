package com.alipay.mobile.nebulacore.core;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class H5BridgeRunnable {
    private static final String LOG_GAP_TAG = "`_`";
    private static final String TAG = "H5BridgeRunnable";
    private static List<String> blackActionList = Collections.synchronizedList(new ArrayList());
    private static List<String> blackMsgList = Collections.synchronizedList(new ArrayList());
    private static H5JsApiConfigModel jsApiConfigModel;
    private String action;
    private Map<String, Long> callLog;
    private String eventId;
    private H5Page h5Page;
    private e param;

    static {
        blackActionList.add(H5Plugin.CommonEvents.GET_AP_DATA_STORAGE);
        blackActionList.add("contact");
        blackActionList.add("getAllContacts");
        blackActionList.add(H5Plugin.CommonEvents.SET_TITLE_COLOR);
        blackActionList.add("chooseContact");
        blackActionList.add("getDTSchemeValue");
        blackActionList.add("setGestureBack");
        blackMsgList.add("forbidden!");
        blackMsgList.add("invalid parameter!");
        blackMsgList.add("none error!");
        blackMsgList.add("not implemented!");
        blackMsgList.add("unknown error!");
    }

    public H5BridgeRunnable(H5Page h5Page2, e eVar, Map<String, Long> map, String str, String str2) {
        this.param = eVar;
        this.eventId = str2;
        this.action = str;
        this.callLog = map;
        this.h5Page = h5Page2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0369  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.alibaba.a.e r0 = r1.param
            java.lang.String r2 = "error"
            r3 = 0
            java.lang.String r4 = ""
            r5 = 0
            if (r0 == 0) goto L_0x0137
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0137
            java.lang.String r0 = r1.action
            if (r0 == 0) goto L_0x0137
            java.util.List<java.lang.String> r6 = blackActionList
            if (r6 == 0) goto L_0x0137
            boolean r0 = r6.contains(r0)
            if (r0 != 0) goto L_0x0137
            com.alibaba.a.e r0 = r1.param
            int r0 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r2)
            com.alibaba.a.e r6 = r1.param
            java.lang.String r7 = "message"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r7)
            java.lang.String r7 = "not implemented!"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0067
            java.lang.String r7 = "h5_upload_not_found_err"
            java.lang.String r7 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r7)
            java.lang.String r8 = "yes"
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0067
            com.alipay.mobile.nebula.provider.H5ProviderManager r7 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r8 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r8 = r8.getName()
            java.lang.Object r7 = r7.getProvider(r8)
            r8 = r7
            com.alipay.mobile.nebula.provider.H5LogProvider r8 = (com.alipay.mobile.nebula.provider.H5LogProvider) r8
            if (r8 == 0) goto L_0x0067
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r13 = r1.action
            java.lang.String r9 = "h5_not_implemented_api"
            r8.log(r9, r10, r11, r12, r13)
        L_0x0067:
            if (r0 == 0) goto L_0x0137
            java.util.List<java.lang.String> r7 = blackMsgList
            boolean r6 = r7.contains(r6)
            if (r6 != 0) goto L_0x0137
            com.alipay.mobile.h5container.api.H5Page r6 = r1.h5Page
            if (r6 == 0) goto L_0x0137
            com.alibaba.a.e r6 = r1.param
            if (r6 == 0) goto L_0x0080
            java.lang.String r7 = "errorMessage"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r7)
            goto L_0x0081
        L_0x0080:
            r6 = r3
        L_0x0081:
            java.lang.String r7 = r1.action
            if (r7 == 0) goto L_0x00a0
            com.alipay.mobile.h5container.api.H5Page r7 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r7 = r7.getPageData()
            if (r7 == 0) goto L_0x00a0
            com.alipay.mobile.h5container.api.H5Page r7 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r7 = r7.getPageData()
            java.lang.String r8 = r1.eventId
            com.alipay.mobile.h5container.api.H5JsCallData r7 = r7.getJsapiInfo(r8)
            if (r7 == 0) goto L_0x00a0
            java.lang.String r7 = r7.getJoMsg()
            goto L_0x00a1
        L_0x00a0:
            r7 = r3
        L_0x00a1:
            r8 = 500(0x1f4, float:7.0E-43)
            if (r7 == 0) goto L_0x00af
            int r9 = r7.length()
            if (r9 <= r8) goto L_0x00af
            java.lang.String r7 = r7.substring(r5, r8)
        L_0x00af:
            if (r6 == 0) goto L_0x00bb
            int r9 = r6.length()
            if (r9 <= r8) goto L_0x00bb
            java.lang.String r6 = r6.substring(r5, r8)
        L_0x00bb:
            java.lang.String r8 = "h5_jsapiResultErrorLogBlackList"
            java.lang.String r8 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r8)
            com.alibaba.a.b r8 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r8)
            if (r8 == 0) goto L_0x00ea
            r9 = 0
        L_0x00c8:
            int r10 = r8.size()
            if (r9 >= r10) goto L_0x00ea
            java.lang.String r10 = r8.getString(r9)
            java.util.regex.Pattern r10 = java.util.regex.Pattern.compile(r10)
            java.lang.String r11 = r1.action
            java.util.regex.Matcher r10 = r10.matcher(r11)
            if (r10 == 0) goto L_0x00e7
            boolean r10 = r10.matches()
            if (r10 == 0) goto L_0x00e7
            r6 = r4
            r7 = r6
            goto L_0x00ea
        L_0x00e7:
            int r9 = r9 + 1
            goto L_0x00c8
        L_0x00ea:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "jsapiName="
            r8.<init>(r9)
            java.lang.String r9 = r1.action
            r8.append(r9)
            java.lang.String r9 = "^params="
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = "^code="
            r8.append(r7)
            r8.append(r0)
            java.lang.String r0 = "^msg="
            r8.append(r0)
            r8.append(r6)
            java.lang.String r13 = r8.toString()
            java.lang.String r9 = com.alipay.mobile.h5container.api.H5Plugin.CommonEvents.H5_AL_JSAPI_RESULT_ERROR
            r10 = 0
            java.lang.String r11 = com.alipay.mobile.nebulacore.wallet.H5Logger.DIAGNOSE
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            java.lang.String r12 = r0.getPageInfo()
            r14 = 0
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            com.alipay.mobile.h5container.api.H5Page r6 = r1.h5Page
            android.os.Bundle r6 = r6.getParams()
            java.lang.String r15 = com.alipay.mobile.nebulacore.wallet.H5Logger.getUniteParam4(r0, r6)
            java.lang.String r16 = "H-MM"
            com.alipay.mobile.nebulacore.wallet.H5Logger.performanceLoggerV2(r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x0137:
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r0 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5DevDebugProvider> r6 = com.alipay.mobile.nebula.provider.H5DevDebugProvider.class
            java.lang.String r6 = r6.getName()
            java.lang.Object r0 = r0.getProvider(r6)
            r6 = r0
            com.alipay.mobile.nebula.provider.H5DevDebugProvider r6 = (com.alipay.mobile.nebula.provider.H5DevDebugProvider) r6
            if (r6 == 0) goto L_0x01b3
            java.util.Map<java.lang.String, java.lang.Long> r0 = r1.callLog
            if (r0 == 0) goto L_0x0196
            java.lang.String r7 = r1.eventId
            boolean r0 = r0.containsKey(r7)
            if (r0 == 0) goto L_0x0196
            com.alibaba.a.e r0 = r1.param
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = r0.toJSONString()
            r11 = r0
            goto L_0x0161
        L_0x0160:
            r11 = r3
        L_0x0161:
            java.lang.String r0 = r1.action
            if (r0 == 0) goto L_0x017f
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            if (r0 == 0) goto L_0x017f
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            java.lang.String r7 = r1.eventId
            com.alipay.mobile.h5container.api.H5JsCallData r0 = r0.getJsapiInfo(r7)
            if (r0 == 0) goto L_0x017f
            java.lang.String r3 = r0.getJoMsg()
        L_0x017f:
            r10 = r3
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
            if (r0 == 0) goto L_0x01b3
            java.lang.String r7 = r1.action
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            java.lang.String r8 = com.alipay.mobile.nebula.dev.H5BugmeIdGenerator.getBugmeViewId(r0)
            java.lang.String r9 = r1.eventId
            r6.jsApiLog(r7, r8, r9, r10, r11)
            goto L_0x01b3
        L_0x0196:
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
            if (r0 == 0) goto L_0x01b3
            com.alibaba.a.e r0 = r1.param
            if (r0 != 0) goto L_0x01a4
            r0 = r4
            goto L_0x01a8
        L_0x01a4:
            java.lang.String r0 = r0.toJSONString()
        L_0x01a8:
            java.lang.String r3 = r1.action
            com.alipay.mobile.h5container.api.H5Page r7 = r1.h5Page
            java.lang.String r7 = com.alipay.mobile.nebula.dev.H5BugmeIdGenerator.getBugmeViewId(r7)
            r6.eventLog(r3, r7, r0)
        L_0x01b3:
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = jsApiConfigModel
            java.lang.String r3 = "H5BridgeRunnable"
            if (r0 != 0) goto L_0x01d5
            java.lang.String r0 = "h5_secJsApiCallConfig"
            java.lang.String r0 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r0)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L_0x01c6
            return
        L_0x01c6:
            java.lang.Class<com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel> r6 = com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel.class
            java.lang.Object r0 = com.alibaba.a.a.parseObject((java.lang.String) r0, r6)     // Catch:{ Exception -> 0x01d1 }
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = (com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel) r0     // Catch:{ Exception -> 0x01d1 }
            jsApiConfigModel = r0     // Catch:{ Exception -> 0x01d1 }
            goto L_0x01d5
        L_0x01d1:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01d5:
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = jsApiConfigModel
            if (r0 == 0) goto L_0x039a
            boolean r0 = r0.isEnable()
            if (r0 != 0) goto L_0x01e1
            goto L_0x039a
        L_0x01e1:
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            if (r0 == 0) goto L_0x0399
            java.util.Map<java.lang.String, java.lang.Long> r0 = r1.callLog
            if (r0 == 0) goto L_0x0399
            java.lang.String r3 = r1.eventId
            boolean r0 = r0.containsKey(r3)
            if (r0 != 0) goto L_0x01f7
            goto L_0x0399
        L_0x01f7:
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = jsApiConfigModel
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel$AllBean r0 = r0.getAll()
            if (r0 != 0) goto L_0x0208
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = jsApiConfigModel
            com.alibaba.a.e r0 = r0.getEvery()
            if (r0 != 0) goto L_0x0208
            return
        L_0x0208:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0
            com.alipay.mobile.h5container.api.H5Page r3 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r3 = r3.getPageData()
            java.lang.String r3 = r3.getPageUrl()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r1.action
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "`_`"
            if (r7 == 0) goto L_0x022f
            r7 = r8
            goto L_0x0240
        L_0x022f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r1.action
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
        L_0x0240:
            r6.append(r7)
            java.lang.String r7 = r1.action
            java.lang.String r9 = "rpc"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x0254
            if (r0 == 0) goto L_0x0271
            boolean r0 = r0.isRpcDomains(r3)
            goto L_0x0272
        L_0x0254:
            java.lang.Class<com.alipay.mobile.nebula.permission.H5PermissionManager> r0 = com.alipay.mobile.nebula.permission.H5PermissionManager.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.permission.H5PermissionManager r0 = (com.alipay.mobile.nebula.permission.H5PermissionManager) r0
            if (r0 == 0) goto L_0x0270
            java.lang.String r7 = r1.action
            java.lang.String r7 = r0.getAliLevel(r7)
            java.lang.String r9 = r1.action
            boolean r0 = r0.urlInWhiteList(r9, r3)
            r9 = r7
            goto L_0x0272
        L_0x0270:
            r9 = r4
        L_0x0271:
            r0 = 0
        L_0x0272:
            r6.append(r9)
            r6.append(r8)
            java.lang.String r3 = "Y"
            java.lang.String r7 = "N"
            if (r0 == 0) goto L_0x0280
            r0 = r3
            goto L_0x0281
        L_0x0280:
            r0 = r7
        L_0x0281:
            r6.append(r0)
            r6.append(r8)
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            java.lang.String r11 = r1.eventId
            com.alipay.mobile.h5container.api.H5JsCallData r0 = r0.getJsapiInfo(r11)
            if (r0 == 0) goto L_0x029a
            java.lang.String r0 = r0.getJoMsg()
            goto L_0x029b
        L_0x029a:
            r0 = r4
        L_0x029b:
            com.alibaba.a.e r11 = r1.param
            if (r11 == 0) goto L_0x02a4
            java.lang.String r11 = r11.toJSONString()
            goto L_0x02a5
        L_0x02a4:
            r11 = r4
        L_0x02a5:
            int r12 = r0.length()
            int r13 = r11.length()
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r14 = jsApiConfigModel
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel$AllBean r14 = r14.getAll()
            if (r14 == 0) goto L_0x02e8
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r14 = jsApiConfigModel
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel$AllBean r14 = r14.getAll()
            boolean r15 = r14.isIn()
            boolean r16 = r14.isOut()
            int r14 = r14.getMaxLength()
            if (r15 == 0) goto L_0x02d6
            int r15 = r0.length()
            if (r15 <= r14) goto L_0x02d7
            int r15 = r14 + -1
            java.lang.String r0 = r0.substring(r5, r15)
            goto L_0x02d7
        L_0x02d6:
            r0 = r4
        L_0x02d7:
            if (r16 == 0) goto L_0x0342
            int r4 = r11.length()
            if (r4 <= r14) goto L_0x02e6
            int r14 = r14 + -1
            java.lang.String r4 = r11.substring(r5, r14)
            goto L_0x0342
        L_0x02e6:
            r4 = r11
            goto L_0x0342
        L_0x02e8:
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r14 = jsApiConfigModel
            com.alibaba.a.e r14 = r14.getEvery()
            if (r14 == 0) goto L_0x0341
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r14 = jsApiConfigModel
            com.alibaba.a.e r14 = r14.getEvery()
            java.lang.String r15 = r1.action
            boolean r14 = r14.containsKey(r15)
            if (r14 == 0) goto L_0x0341
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r14 = jsApiConfigModel
            com.alibaba.a.e r14 = r14.getEvery()
            java.lang.String r15 = r1.action
            com.alibaba.a.e r14 = r14.getJSONObject(r15)
            java.lang.String r15 = "in"
            boolean r15 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((com.alibaba.a.e) r14, (java.lang.String) r15, (boolean) r5)
            java.lang.String r9 = "out"
            boolean r9 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((com.alibaba.a.e) r14, (java.lang.String) r9, (boolean) r5)
            r10 = 50
            java.lang.String r5 = "maxLength"
            int r5 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r14, (java.lang.String) r5, (int) r10)
            if (r15 == 0) goto L_0x0330
            int r10 = r0.length()
            if (r10 <= r5) goto L_0x032e
            int r10 = r5 + -1
            r14 = 0
            java.lang.String r0 = r0.substring(r14, r10)
            goto L_0x0332
        L_0x032e:
            r14 = 0
            goto L_0x0332
        L_0x0330:
            r14 = 0
            r0 = r4
        L_0x0332:
            if (r9 == 0) goto L_0x0342
            int r4 = r11.length()
            if (r4 <= r5) goto L_0x02e6
            int r5 = r5 + -1
            java.lang.String r4 = r11.substring(r14, r5)
            goto L_0x0342
        L_0x0341:
            r0 = r4
        L_0x0342:
            com.alibaba.a.e r5 = r1.param
            if (r5 == 0) goto L_0x034e
            boolean r2 = r5.containsKey(r2)
            if (r2 == 0) goto L_0x034e
            r3 = r7
            r4 = r11
        L_0x034e:
            java.util.Map<java.lang.String, java.lang.Long> r2 = r1.callLog
            if (r2 == 0) goto L_0x0369
            java.lang.String r5 = r1.eventId
            boolean r2 = r2.containsKey(r5)
            if (r2 == 0) goto L_0x0369
            java.util.Map<java.lang.String, java.lang.Long> r2 = r1.callLog
            java.lang.String r5 = r1.eventId
            java.lang.Object r2 = r2.get(r5)
            java.lang.Long r2 = (java.lang.Long) r2
            long r9 = r2.longValue()
            goto L_0x036b
        L_0x0369:
            r9 = 0
        L_0x036b:
            r6.append(r0)
            r6.append(r8)
            r6.append(r12)
            r6.append(r8)
            r6.append(r4)
            r6.append(r8)
            r6.append(r13)
            r6.append(r8)
            r6.append(r3)
            r6.append(r8)
            r6.append(r9)
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.h5container.api.H5PageData r0 = r0.getPageData()
            java.lang.String r2 = r6.toString()
            r0.appendJsApiDetail(r2)
        L_0x0399:
            return
        L_0x039a:
            java.lang.String r0 = "jsApiConfigModel == null or not enable!"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5BridgeRunnable.run():void");
    }
}
