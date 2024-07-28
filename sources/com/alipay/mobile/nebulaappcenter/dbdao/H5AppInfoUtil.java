package com.alipay.mobile.nebulaappcenter.dbdao;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import java.util.HashMap;

public class H5AppInfoUtil {
    private static final String TAG = "H5AppInfoUtil";

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean infoToBean(com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean r16, com.alipay.mobile.nebula.appcenter.model.AppInfo r17, boolean r18) {
        /*
            r1 = r17
            if (r16 != 0) goto L_0x000b
            com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean r0 = new com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean
            r0.<init>()
            r2 = r0
            goto L_0x000d
        L_0x000b:
            r2 = r16
        L_0x000d:
            java.lang.String r0 = r1.name
            r2.setName(r0)
            java.lang.String r0 = r1.patch
            r2.setPatch(r0)
            int r0 = r1.online
            r2.setOnline(r0)
            int r0 = r1.auto_install
            r2.setAuto_install(r0)
            java.lang.String r0 = r1.app_dsec
            r2.setApp_dsec(r0)
            java.lang.String r0 = r1.fallback_base_url
            r2.setFallback_base_url(r0)
            java.lang.String r0 = r1.icon_url
            r2.setIcon_url(r0)
            java.lang.String r0 = r1.sub_url
            r2.setSub_url(r0)
            java.lang.String r0 = r1.vhost
            r2.setVhost(r0)
            java.lang.String r0 = r1.extend_info_jo
            r2.setExtend_info(r0)
            java.lang.String r0 = r1.package_url
            r2.setPackage_url(r0)
            long r3 = r1.size
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r2.setSize(r0)
            java.lang.String r0 = r1.main_url
            r2.setMain_url(r0)
            java.lang.String r0 = r1.system_max
            r2.setSystem_max(r0)
            java.lang.String r0 = r1.system_min
            r2.setSystem_min(r0)
            java.lang.String r0 = r1.app_id
            r2.setApp_id(r0)
            java.lang.String r0 = r1.version
            r2.setVersion(r0)
            java.lang.String r0 = r1.third_platform
            r2.setThird_platform(r0)
            int r0 = r1.app_type
            r2.setApp_type(r0)
            int r0 = r1.app_channel
            r2.setApp_channel(r0)
            java.lang.String r0 = r1.release_type
            r2.setRelease_type(r0)
            java.lang.String r0 = r1.nbl_id
            r2.setNbl_id(r0)
            java.lang.String r0 = r1.nbAppType
            r2.setNbAppType(r0)
            int r0 = r1.is_mapping
            r2.setIs_mapping(r0)
            int r0 = r1.is_limit
            r2.setIs_limit(r0)
            java.lang.String r0 = r1.syncTime
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "H5AppInfoUtil"
            if (r0 != 0) goto L_0x00d3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "setUpdate_app_time for syncTime "
            r0.<init>(r4)
            java.lang.String r4 = r1.app_id
            r0.append(r4)
            java.lang.String r4 = " "
            r0.append(r4)
            java.lang.String r5 = r1.version
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r1.syncTime
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)
            java.lang.String r0 = r1.syncTime
            r1.update_app_time = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r1.syncTime
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r2.setUpdate_app_time(r0)
            goto L_0x00e6
        L_0x00d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r2.setUpdate_app_time(r0)
        L_0x00e6:
            int r0 = r1.localReport
            r2.setLocalReport(r0)
            java.lang.String r0 = r1.extend_info_jo     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = "online"
            java.lang.String r5 = "test"
            java.lang.String r6 = "dev"
            java.lang.String r7 = "enable"
            java.lang.String r8 = "url"
            java.lang.String r9 = "launchParams"
            r10 = 0
            java.lang.String r11 = "host"
            java.lang.String r12 = "launchMode"
            if (r0 == 0) goto L_0x017f
            boolean r13 = r0.isEmpty()     // Catch:{ Exception -> 0x01db }
            if (r13 != 0) goto L_0x017f
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x01db }
            r13.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.String r14 = r0.getString(r12)     // Catch:{ Exception -> 0x01db }
            r13.put(r12, r14)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r12 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r11, r10)     // Catch:{ Exception -> 0x01db }
            if (r12 == 0) goto L_0x0124
            boolean r14 = r12.isEmpty()     // Catch:{ Exception -> 0x01db }
            if (r14 == 0) goto L_0x013d
        L_0x0124:
            com.alibaba.a.e r12 = new com.alibaba.a.e     // Catch:{ Exception -> 0x01db }
            r12.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x01db }
            r12.put((java.lang.String) r7, (java.lang.Object) r14)     // Catch:{ Exception -> 0x01db }
            java.lang.String r7 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r12.put((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x01db }
            java.lang.String r6 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r12.put((java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x01db }
            java.lang.String r5 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r12.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ Exception -> 0x01db }
        L_0x013d:
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r12)     // Catch:{ Exception -> 0x01db }
            r13.put(r11, r4)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r9, r10)     // Catch:{ Exception -> 0x01db }
            if (r0 == 0) goto L_0x0163
            boolean r4 = r0.isEmpty()     // Catch:{ Exception -> 0x01db }
            if (r4 != 0) goto L_0x0163
            boolean r4 = r0.containsKey(r8)     // Catch:{ Exception -> 0x01db }
            if (r4 != 0) goto L_0x0163
            java.lang.String r4 = r1.main_url     // Catch:{ Exception -> 0x01db }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01db }
            if (r4 != 0) goto L_0x0163
            java.lang.String r4 = r1.main_url     // Catch:{ Exception -> 0x01db }
            r0.put((java.lang.String) r8, (java.lang.Object) r4)     // Catch:{ Exception -> 0x01db }
        L_0x0163:
            if (r0 == 0) goto L_0x016b
            boolean r4 = r0.isEmpty()     // Catch:{ Exception -> 0x01db }
            if (r4 == 0) goto L_0x0175
        L_0x016b:
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ Exception -> 0x01db }
            r0.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = r1.main_url     // Catch:{ Exception -> 0x01db }
            r0.put((java.lang.String) r8, (java.lang.Object) r4)     // Catch:{ Exception -> 0x01db }
        L_0x0175:
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r0)     // Catch:{ Exception -> 0x01db }
            r13.put(r9, r0)     // Catch:{ Exception -> 0x01db }
            r1.extend_info = r13     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x017f:
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ Exception -> 0x01db }
            r0.<init>()     // Catch:{ Exception -> 0x01db }
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x01db }
            r13.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.String r14 = "NebulaApp"
            r0.put((java.lang.String) r12, (java.lang.Object) r14)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r14 = new com.alibaba.a.e     // Catch:{ Exception -> 0x01db }
            r14.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.String r15 = r1.main_url     // Catch:{ Exception -> 0x01db }
            r14.put((java.lang.String) r8, (java.lang.Object) r15)     // Catch:{ Exception -> 0x01db }
            r0.put((java.lang.String) r9, (java.lang.Object) r14)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r8 = new com.alibaba.a.e     // Catch:{ Exception -> 0x01db }
            r8.<init>()     // Catch:{ Exception -> 0x01db }
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x01db }
            r8.put((java.lang.String) r7, (java.lang.Object) r14)     // Catch:{ Exception -> 0x01db }
            java.lang.String r7 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r8.put((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x01db }
            java.lang.String r6 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r8.put((java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x01db }
            java.lang.String r5 = r1.vhost     // Catch:{ Exception -> 0x01db }
            r8.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ Exception -> 0x01db }
            r0.put((java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r12, r10)     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r4)     // Catch:{ Exception -> 0x01db }
            r13.put(r12, r4)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r11, r10)     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r4)     // Catch:{ Exception -> 0x01db }
            r13.put(r11, r4)     // Catch:{ Exception -> 0x01db }
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r0, r9, r10)     // Catch:{ Exception -> 0x01db }
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r0)     // Catch:{ Exception -> 0x01db }
            r13.put(r9, r0)     // Catch:{ Exception -> 0x01db }
            r1.extend_info = r13     // Catch:{ Exception -> 0x01db }
            goto L_0x01df
        L_0x01db:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01df:
            if (r18 != 0) goto L_0x01e8
            com.alipay.mobile.nebulaappcenter.service.H5MemoryCache r0 = com.alipay.mobile.nebulaappcenter.service.H5MemoryCache.getInstance()
            r0.saveAppInfoToMemory(r1)
        L_0x01e8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.dbdao.H5AppInfoUtil.infoToBean(com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean, com.alipay.mobile.nebula.appcenter.model.AppInfo, boolean):com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean");
    }

    public static AppInfo beanToInfo(H5NebulaAppBean h5NebulaAppBean) {
        AppInfo appInfo = new AppInfo();
        appInfo.name = h5NebulaAppBean.getName();
        appInfo.patch = h5NebulaAppBean.getPatch();
        appInfo.online = h5NebulaAppBean.getOnline();
        appInfo.auto_install = h5NebulaAppBean.getAuto_install();
        appInfo.app_dsec = h5NebulaAppBean.getApp_dsec();
        appInfo.fallback_base_url = h5NebulaAppBean.getFallback_base_url();
        appInfo.icon_url = h5NebulaAppBean.getIcon_url();
        appInfo.sub_url = h5NebulaAppBean.getSub_url();
        appInfo.vhost = h5NebulaAppBean.getVhost();
        appInfo.extend_info_jo = h5NebulaAppBean.getExtend_info();
        appInfo.package_url = h5NebulaAppBean.getPackage_url();
        appInfo.size = h5NebulaAppBean.getSize().longValue();
        appInfo.main_url = h5NebulaAppBean.getMain_url();
        appInfo.system_max = h5NebulaAppBean.getSystem_max();
        appInfo.system_min = h5NebulaAppBean.getSystem_min();
        appInfo.app_id = h5NebulaAppBean.getApp_id();
        appInfo.version = h5NebulaAppBean.getVersion();
        appInfo.third_platform = h5NebulaAppBean.getThird_platform();
        appInfo.app_type = h5NebulaAppBean.app_type;
        appInfo.app_channel = h5NebulaAppBean.app_channel;
        appInfo.release_type = h5NebulaAppBean.getRelease_type();
        appInfo.is_mapping = h5NebulaAppBean.getIs_mapping();
        appInfo.is_mapping = h5NebulaAppBean.getIs_limit();
        appInfo.update_app_time = h5NebulaAppBean.getUpdate_app_time();
        appInfo.localReport = h5NebulaAppBean.getLocalReport();
        appInfo.nbAppType = h5NebulaAppBean.getNbAppType();
        appInfo.nbl_id = h5NebulaAppBean.getNbl_id();
        try {
            e parseObject = H5Utils.parseObject(appInfo.extend_info_jo);
            if (parseObject != null) {
                if (!parseObject.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(H5Param.LAUNCHER_MODE, parseObject.getString(H5Param.LAUNCHER_MODE));
                    e jSONObject = H5Utils.getJSONObject(parseObject, H5Param.HOST, (e) null);
                    if (jSONObject == null || jSONObject.isEmpty()) {
                        jSONObject = new e();
                        jSONObject.put("enable", (Object) Boolean.TRUE);
                        jSONObject.put("dev", (Object) appInfo.vhost);
                        jSONObject.put("test", (Object) appInfo.vhost);
                        jSONObject.put(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT, (Object) appInfo.vhost);
                    }
                    hashMap.put(H5Param.HOST, H5Utils.toJSONString(jSONObject));
                    e jSONObject2 = H5Utils.getJSONObject(parseObject, H5Param.LAUNCHER_PARAM, (e) null);
                    if (jSONObject2 != null && !jSONObject2.isEmpty() && !jSONObject2.containsKey("url") && !TextUtils.isEmpty(appInfo.main_url)) {
                        jSONObject2.put("url", (Object) appInfo.main_url);
                    }
                    if (jSONObject2 == null || jSONObject2.isEmpty()) {
                        jSONObject2 = new e();
                        jSONObject2.put("url", (Object) appInfo.main_url);
                    }
                    hashMap.put(H5Param.LAUNCHER_PARAM, H5Utils.toJSONString(jSONObject2));
                    appInfo.extend_info = hashMap;
                    return appInfo;
                }
            }
            e eVar = new e();
            HashMap hashMap2 = new HashMap();
            eVar.put(H5Param.LAUNCHER_MODE, (Object) H5Param.NEBULA_APP);
            e eVar2 = new e();
            eVar2.put("url", (Object) appInfo.main_url);
            eVar.put(H5Param.LAUNCHER_PARAM, (Object) eVar2);
            e eVar3 = new e();
            eVar3.put("enable", (Object) Boolean.TRUE);
            eVar3.put("dev", (Object) appInfo.vhost);
            eVar3.put("test", (Object) appInfo.vhost);
            eVar3.put(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT, (Object) appInfo.vhost);
            eVar.put(H5Param.HOST, (Object) eVar3);
            hashMap2.put(H5Param.LAUNCHER_MODE, H5Utils.toJSONString(H5Utils.getJSONObject(eVar, H5Param.LAUNCHER_MODE, (e) null)));
            hashMap2.put(H5Param.HOST, H5Utils.toJSONString(H5Utils.getJSONObject(eVar, H5Param.HOST, (e) null)));
            hashMap2.put(H5Param.LAUNCHER_PARAM, H5Utils.toJSONString(H5Utils.getJSONObject(eVar, H5Param.LAUNCHER_PARAM, (e) null)));
            appInfo.extend_info = hashMap2;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
        return appInfo;
    }
}
