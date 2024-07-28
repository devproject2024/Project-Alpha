package com.alipay.mobile.nebulacore.appcenter.center;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage;
import com.alipay.mobile.nebulacore.core.H5ContentProviderImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class H5GlobalPackage {
    public static final String TAG = "H5GlobalPackage";
    public static final String TINY_RES_KEY = "tinyRes";
    private static Map<String, Map<String, H5ContentPackage>> resourcePackageMap;
    private static List<H5ContentPackage> sPackageList;

    public static void prepare() {
        H5Log.d(TAG, "prepare global package");
        initPackageInfo();
        List<H5ContentPackage> list = sPackageList;
        if (list != null) {
            synchronized (list) {
                for (H5ContentPackage prepareContent : sPackageList) {
                    prepareContent.prepareContent((ConditionVariable) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addResourcePackage(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0086
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x000e
            goto L_0x0086
        L_0x000e:
            initPackageInfo()
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r0 = resourcePackageMap
            if (r0 != 0) goto L_0x001c
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            resourcePackageMap = r0
        L_0x001c:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r0 = resourcePackageMap
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r1 = resourcePackageMap     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0081
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r1 = resourcePackageMap     // Catch:{ all -> 0x0083 }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0083 }
            r2 = 0
            if (r1 == 0) goto L_0x006a
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r1 = resourcePackageMap     // Catch:{ all -> 0x0083 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0083 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "tinyRes"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x0057
            if (r1 == 0) goto L_0x0057
            java.lang.Object r4 = r1.get(r5)     // Catch:{ all -> 0x0083 }
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r4 = (com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage) r4     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x004e
            r4.setPreload(r7)     // Catch:{ all -> 0x0083 }
            r4.prepareContent(r2)     // Catch:{ all -> 0x0083 }
            goto L_0x0055
        L_0x004e:
            java.lang.String r4 = "H5GlobalPackage"
            java.lang.String r5 = "h5ContentPackage==null"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r5)     // Catch:{ all -> 0x0083 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            return
        L_0x0057:
            if (r1 == 0) goto L_0x0081
            boolean r4 = r1.containsKey(r5)     // Catch:{ all -> 0x0083 }
            if (r4 != 0) goto L_0x0081
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r4 = getContentPackage(r5, r6)     // Catch:{ all -> 0x0083 }
            r1.put(r5, r4)     // Catch:{ all -> 0x0083 }
            r4.prepareContent(r2)     // Catch:{ all -> 0x0083 }
            goto L_0x0081
        L_0x006a:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0083 }
            r1.<init>()     // Catch:{ all -> 0x0083 }
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r6 = getContentPackage(r5, r6)     // Catch:{ all -> 0x0083 }
            r6.setPreload(r7)     // Catch:{ all -> 0x0083 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0083 }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage>> r5 = resourcePackageMap     // Catch:{ all -> 0x0083 }
            r5.put(r4, r1)     // Catch:{ all -> 0x0083 }
            r6.prepareContent(r2)     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            return
        L_0x0083:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            throw r4
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.center.H5GlobalPackage.addResourcePackage(java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private static H5ContentPackage getContentPackage(String str, boolean z) {
        H5Log.d(TAG, "append resource package : ".concat(String.valueOf(str)));
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt(H5Param.APP_TYPE, 2);
        H5ContentPackage h5ContentPackage = new H5ContentPackage(bundle, true, false, true);
        h5ContentPackage.setCanDegrade(z);
        return h5ContentPackage;
    }

    public static void clearResourcePackages(String str) {
        Map<String, Map<String, H5ContentPackage>> map = resourcePackageMap;
        if (map != null && map.containsKey(str)) {
            resourcePackageMap.remove(str);
            H5Log.d(TAG, "resourcePackageMap remove : ".concat(String.valueOf(str)));
        }
    }

    public static byte[] getContent(String str) {
        List<H5ContentPackage> list = sPackageList;
        if (list == null) {
            return null;
        }
        for (H5ContentPackage next : list) {
            if (next.containsKey(str)) {
                H5Log.d(H5ContentProviderImpl.TAG, "load response from " + next.getAppId() + " version:" + next.currentUseVersion + " package " + str);
                return next.get(str);
            }
        }
        Map<String, Map<String, H5ContentPackage>> map = resourcePackageMap;
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry<String, Map<String, H5ContentPackage>> value : resourcePackageMap.entrySet()) {
                Map map2 = (Map) value.getValue();
                if (map2 != null && map2.size() > 0) {
                    for (Map.Entry value2 : map2.entrySet()) {
                        H5ContentPackage h5ContentPackage = (H5ContentPackage) value2.getValue();
                        if (h5ContentPackage.containsKey(str)) {
                            H5Log.d(H5ContentProviderImpl.TAG, "load response from resource package " + h5ContentPackage.getAppId() + " version:" + h5ContentPackage.currentUseVersion + " package " + str);
                            return h5ContentPackage.get(str);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    private static void initPackageInfo() {
        Set<String> commonResourceAppList;
        if (sPackageList == null) {
            sPackageList = Collections.synchronizedList(new ArrayList());
            H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
            if (h5AppCenterPresetProvider == null || (commonResourceAppList = h5AppCenterPresetProvider.getCommonResourceAppList()) == null || commonResourceAppList.isEmpty()) {
                H5Log.e(TAG, "init global app fail !! ");
                return;
            }
            for (String next : commonResourceAppList) {
                if (!TextUtils.isEmpty(next)) {
                    if (TextUtils.equals(next, h5AppCenterPresetProvider.getTinyCommonApp())) {
                        H5Log.d(TAG, next + " is tinyAppCommRes not add in PackageList");
                    } else {
                        Bundle bundle = new Bundle();
                        H5Log.d(TAG, "init global app ".concat(String.valueOf(next)));
                        bundle.putString("appId", next);
                        bundle.putInt(H5Param.APP_TYPE, 2);
                        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                        if (h5AppProvider != null) {
                            String version = h5AppProvider.getVersion(next);
                            if (!TextUtils.isEmpty(version)) {
                                bundle.putString("appVersion", version);
                            }
                        }
                        sPackageList.add(new H5ContentPackage(bundle, true, false, true));
                    }
                }
            }
        }
    }

    public static String getResPkgInfo(String str) {
        String str2;
        String str3;
        List<H5ContentPackage> list = sPackageList;
        String str4 = "";
        if (list != null && list.size() > 0) {
            for (H5ContentPackage next : sPackageList) {
                if (next.size() > 0) {
                    str4 = str4 + next.getAppId() + "_Y_" + next.getVersion() + "|";
                } else {
                    str4 = str4 + next.getAppId() + "_N_" + next.getVersion() + "|";
                }
            }
        }
        Map<String, Map<String, H5ContentPackage>> map = resourcePackageMap;
        if (map != null && map.size() > 0) {
            Map map2 = resourcePackageMap.get(str);
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry value : map2.entrySet()) {
                    H5ContentPackage h5ContentPackage = (H5ContentPackage) value.getValue();
                    if (h5ContentPackage.size() > 0) {
                        str3 = str4 + h5ContentPackage.getAppId() + "_Y_" + h5ContentPackage.getVersion() + "|";
                    } else {
                        str3 = str4 + h5ContentPackage.getAppId() + "_N_" + h5ContentPackage.getVersion() + "|";
                    }
                }
            }
            Map map3 = resourcePackageMap.get(TINY_RES_KEY);
            if (map3 != null && map3.size() > 0) {
                for (Map.Entry value2 : map3.entrySet()) {
                    H5ContentPackage h5ContentPackage2 = (H5ContentPackage) value2.getValue();
                    if (h5ContentPackage2.size() > 0) {
                        str2 = str4 + h5ContentPackage2.getAppId() + "_Y_" + h5ContentPackage2.getVersion() + "|";
                    } else {
                        str2 = str4 + h5ContentPackage2.getAppId() + "_N_" + h5ContentPackage2.getVersion() + "|";
                    }
                }
            }
        }
        if (str4.length() > 0 && str4.toString().endsWith("|")) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        return str4.toString();
    }
}
