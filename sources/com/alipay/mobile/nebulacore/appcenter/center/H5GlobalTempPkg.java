package com.alipay.mobile.nebulacore.appcenter.center;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5PreSetPkgInfo;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5PresetInfo;
import com.alipay.mobile.nebula.appcenter.H5PresetPkg;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage;
import com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParser;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5GlobalTempPkg {
    private static final String TAG = "H5GlobalTempPkg";
    private static H5GlobalTempPkg instance;
    private Map<String, H5ContentPackage> h5ContentPackageList = new ConcurrentHashMap();

    private H5GlobalTempPkg() {
    }

    public byte[] getContent(String str) {
        Map<String, H5ContentPackage> map = this.h5ContentPackageList;
        if (map != null && !map.isEmpty()) {
            for (String str2 : this.h5ContentPackageList.keySet()) {
                H5ContentPackage h5ContentPackage = this.h5ContentPackageList.get(str2);
                if (h5ContentPackage.containsKey(str)) {
                    H5Log.d(TAG, "load response from  appId:" + h5ContentPackage.getAppId() + " version:" + h5ContentPackage.currentUseVersion + " package " + str);
                    return h5ContentPackage.get(str);
                }
            }
        }
        return null;
    }

    public static synchronized H5GlobalTempPkg getInstance() {
        H5GlobalTempPkg h5GlobalTempPkg;
        synchronized (H5GlobalTempPkg.class) {
            if (instance == null) {
                instance = new H5GlobalTempPkg();
            }
            h5GlobalTempPkg = instance;
        }
        return h5GlobalTempPkg;
    }

    public void put(String str, ConcurrentHashMap<String, byte[]> concurrentHashMap, String str2) {
        H5ContentPackage h5ContentPackage;
        Map<String, H5ContentPackage> map = this.h5ContentPackageList;
        if (map != null && (h5ContentPackage = map.get(str)) != null) {
            h5ContentPackage.clear();
            h5ContentPackage.putAll(concurrentHashMap);
            h5ContentPackage.currentUseVersion = str2;
        }
    }

    public H5ContentPackage getH5ContentPackage(String str) {
        Map<String, H5ContentPackage> map = this.h5ContentPackageList;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.h5ContentPackageList.get(str);
    }

    public void clear(String str) {
        Map<String, H5ContentPackage> map = this.h5ContentPackageList;
        if (map != null && map.get(str) != null) {
            this.h5ContentPackageList.get(str).clear();
        }
    }

    public void prepareContent(String str) {
        prepareContentWithVersion(str, (String) null);
    }

    public void prepareContentWithVersion(String str, String str2) {
        H5AppDBService appDBService;
        String str3;
        String str4 = str;
        long currentTimeMillis = System.currentTimeMillis();
        H5ContentPackage h5ContentPackage = this.h5ContentPackageList.get(str4);
        if (h5ContentPackage == null) {
            Bundle bundle = new Bundle();
            H5Log.d(TAG, "init h5TempPkg app ".concat(String.valueOf(str)));
            bundle.putString("appId", str4);
            bundle.putInt(H5Param.APP_TYPE, 2);
            this.h5ContentPackageList.put(str4, new H5ContentPackage(bundle, true, false, true));
        }
        H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
        if (!(h5AppCenterService == null || (appDBService = h5AppCenterService.getAppDBService()) == null)) {
            if (!TextUtils.isEmpty(str2)) {
                H5Log.d(TAG, "prepareContent useVersion:".concat(String.valueOf(str2)));
                str3 = str2;
            } else {
                str3 = appDBService.findInstallAppVersion(str4);
                H5Log.d(TAG, "prepareContent installVersion:".concat(String.valueOf(str3)));
            }
            if (!TextUtils.isEmpty(str3)) {
                if (h5ContentPackage == null || h5ContentPackage.isEmpty() || !TextUtils.equals(str3, h5ContentPackage.currentUseVersion)) {
                    H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                    if (h5AppProvider != null) {
                        String installPath = h5AppProvider.getInstallPath(str4, str3);
                        if (!TextUtils.isEmpty(installPath)) {
                            boolean install = install(str4, installPath, str3);
                            H5Log.d(TAG, "prepareContent from " + installPath + " result:" + install + " speed:" + (System.currentTimeMillis() - currentTimeMillis));
                            if (install) {
                                return;
                            }
                        }
                    }
                } else {
                    H5Log.d(TAG, "prepareContent h5ContentPackage is not Empty not parse");
                    return;
                }
            }
        }
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null && h5AppCenterPresetProvider.getH5PresetPkg() != null) {
            try {
                H5PresetPkg h5PresetPkg = h5AppCenterPresetProvider.getH5PresetPkg();
                if (h5PresetPkg.getPreSetInfo() != null && h5PresetPkg.getPreSetInfo().containsKey(str4)) {
                    H5PresetInfo h5PresetInfo = h5PresetPkg.getPreSetInfo().get(str4);
                    String str5 = h5PresetInfo.appId;
                    String str6 = h5PresetInfo.version;
                    String str7 = h5PresetInfo.downloadUrl;
                    H5Log.d(TAG, "setWalletPreset getPreSetInfo  " + str5 + " " + str6);
                    AssetManager assets = H5Environment.getContext().getAssets();
                    InputStream open = assets.open(h5PresetPkg.getPresetPath() + str5);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new H5PreSetPkgInfo(str, str6, open, true, str7));
                    if (h5AppCenterService != null) {
                        final String str8 = str;
                        final String str9 = str6;
                        final long j = currentTimeMillis;
                        h5AppCenterService.loadPresetAppNow(arrayList, new H5LoadPresetListen() {
                            public void getPresetPath(String str) {
                                if (!TextUtils.isEmpty(str)) {
                                    boolean access$000 = H5GlobalTempPkg.this.install(str8, str, str9);
                                    H5Log.d(H5GlobalTempPkg.TAG, "prepareContent from apk  result:" + access$000 + " speed:" + (System.currentTimeMillis() - j));
                                }
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                H5Log.e(TAG, "setWalletPreset not exist", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean install(String str, String str2, String str3) {
        H5ContentPackage h5ContentPackage = getInstance().getH5ContentPackage(str);
        if (h5ContentPackage == null) {
            return false;
        }
        Bundle params = h5ContentPackage.getParams();
        String concat = "file://".concat(String.valueOf(str2));
        if (!concat.endsWith("/")) {
            concat = concat + "/";
        }
        params.putString(H5Param.OFFLINE_HOST, concat);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (H5PackageParser.parsePackage(params, concurrentHashMap).code != 0) {
            return false;
        }
        H5Log.d(TAG, "appId parsePackage success");
        clear(str);
        put(str, concurrentHashMap, str3);
        return true;
    }
}
