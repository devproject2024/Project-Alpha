package com.alipay.mobile.nebula.appcenter.apphandler;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.process.H5IpcServer;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class H5PreferAppList {
    private static final String TAG = "H5PreferAppList";
    public static final long defaultTime = 10800000;
    private static H5PreferAppList instance = null;
    public static final String nbprefer = "nbprefer";
    public static final String nbsn = "nbsn";
    public static final String nbsv = "nbsv";
    private static Map<String, Boolean> tinyProcessMap = new ConcurrentHashMap();
    private Map<String, H5PreferAppInfo> preferList = new ConcurrentHashMap();

    private H5PreferAppList() {
        Set<String> commonResourceAppList;
        Map<String, H5PreferAppInfo> jsonToMap = jsonToMap(getPreferAppListStr());
        if (jsonToMap != null && jsonToMap.size() > 0) {
            this.preferList.putAll(jsonToMap);
        }
        checkExpired();
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null && (commonResourceAppList = h5AppCenterPresetProvider.getCommonResourceAppList()) != null && !commonResourceAppList.isEmpty()) {
            for (String put : commonResourceAppList) {
                tinyProcessMap.put(put, Boolean.FALSE);
            }
        }
    }

    private void checkExpired() {
        Map<String, H5PreferAppInfo> map = this.preferList;
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, H5PreferAppInfo>> it2 = this.preferList.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                H5PreferAppInfo h5PreferAppInfo = (H5PreferAppInfo) next.getValue();
                if (h5PreferAppInfo != null && isExpired(h5PreferAppInfo.getSaveTime())) {
                    deleteAllAppInfo((String) next.getKey(), h5PreferAppInfo.getNbsv());
                    it2.remove();
                }
            }
            savePreferAppList();
        }
    }

    public static synchronized H5PreferAppList getInstance() {
        H5PreferAppList h5PreferAppList;
        synchronized (H5PreferAppList.class) {
            if (instance == null) {
                instance = new H5PreferAppList();
            }
            h5PreferAppList = instance;
        }
        return h5PreferAppList;
    }

    public synchronized void add(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.preferList.put(str, new H5PreferAppInfo(str2, System.currentTimeMillis(), str3));
            savePreferAppList();
        }
    }

    public synchronized void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.preferList.get(str) != null) {
                this.preferList.remove(str);
                savePreferAppList();
                H5Log.d(TAG, "also remove from H5DevAppList");
                H5DevAppList.getInstance().remove(str);
            }
        }
    }

    public synchronized String getPreferVersion(String str) {
        if (H5Utils.isInTinyProcess()) {
            H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
            if (h5EventHandlerService != null) {
                try {
                    H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                    if (h5IpcServer != null) {
                        return h5IpcServer.getPreferVersion(str);
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            H5PreferAppInfo h5PreferAppInfo = this.preferList.get(str);
            if (h5PreferAppInfo == null) {
                return "";
            }
            return h5PreferAppInfo.getNbsv();
        }
    }

    public synchronized boolean contains(String str) {
        if (H5Utils.isInTinyProcess()) {
            Boolean bool = tinyProcessMap.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
            if (h5EventHandlerService != null) {
                try {
                    H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                    if (h5IpcServer != null) {
                        boolean containPreferAppId = h5IpcServer.containPreferAppId(str);
                        tinyProcessMap.put(str, Boolean.valueOf(containPreferAppId));
                        return containPreferAppId;
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            boolean containsKey = this.preferList.containsKey(str);
            if (!containsKey) {
                return containsKey;
            }
            H5PreferAppInfo h5PreferAppInfo = this.preferList.get(str);
            if (h5PreferAppInfo == null) {
                return false;
            }
            if (!isExpired(h5PreferAppInfo.getSaveTime())) {
                return containsKey;
            }
            remove(str);
            deleteAllAppInfo(str, h5PreferAppInfo.getNbsv());
            return false;
        }
        return false;
    }

    public void clearProcessCache(String str) {
        if (H5Utils.isInTinyProcess()) {
            tinyProcessMap.remove(str);
        }
    }

    private void deleteAllAppInfo(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    H5PreferAppList.this.deleteAppInfoAndInstallPath(str, str2);
                }
            });
        }
    }

    public void deleteAppInfoWithAppId(String str) {
        H5PreferAppInfo h5PreferAppInfo;
        if (!TextUtils.isEmpty(str) && (h5PreferAppInfo = this.preferList.get(str)) != null) {
            deleteAppInfoAndInstallPath(str, h5PreferAppInfo.getNbsv());
            remove(str);
        }
    }

    /* access modifiers changed from: private */
    public void deleteAppInfoAndInstallPath(String str, String str2) {
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider != null) {
            String installPath = h5AppProvider.getInstallPath(str, str2);
            String downloadLocalPath = h5AppProvider.getDownloadLocalPath(str, str2);
            H5Log.d(TAG, "deleteAllAppInfo, appId: " + str + " version: " + str2 + " installPath : " + installPath + " downloadPath :" + downloadLocalPath);
            H5FileUtil.delete(installPath);
            H5FileUtil.delete(downloadLocalPath);
        }
        H5AppDBService appDBService = ((H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())).getAppDBService();
        if (appDBService != null) {
            H5Log.d(TAG, "deleteDBAppInfo, appId: " + str + " version: " + str2);
            appDBService.deleteAppInfo(str, str2);
        }
    }

    public static boolean enableUsePrefer(Bundle bundle) {
        return bundle != null && bundle.containsKey(nbprefer) && H5AppHandler.CHECK_VALUE.equalsIgnoreCase(bundle.getString(nbprefer));
    }

    private void savePreferAppList() {
        String jSONString = H5Utils.toJSONString(this.preferList);
        H5Log.d(TAG, "set preferList: ".concat(String.valueOf(jSONString)));
        H5DevConfig.setStringConfig(H5DevConfig.H5_PREFER_APP_LIST, jSONString);
    }

    private String getPreferAppListStr() {
        String stringConfig = H5DevConfig.getStringConfig(H5DevConfig.H5_PREFER_APP_LIST, (String) null);
        H5Log.d(TAG, "get preferList: ".concat(String.valueOf(stringConfig)));
        return stringConfig;
    }

    public void clearPreferAppList() {
        this.preferList.clear();
        H5DevConfig.setStringConfig(H5DevConfig.H5_PREFER_APP_LIST, "");
    }

    public boolean isExpired(long j) {
        e parseObject;
        int i2;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        boolean z = false;
        long j2 = defaultTime;
        if (!(h5ConfigProvider == null || (parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5_preferExpired"))) == null || parseObject.isEmpty())) {
            try {
                i2 = Integer.parseInt(H5Utils.getString(parseObject, "time"));
            } catch (Throwable th) {
                H5Log.e(TAG, th);
                i2 = 0;
            }
            if (i2 > 0) {
                j2 = (long) (i2 * 1000);
            }
        }
        if (System.currentTimeMillis() > j + j2) {
            z = true;
        }
        H5Log.d(TAG, "result : " + z + " currentTime " + System.currentTimeMillis() + " saveTime : " + j + " expiredTime : " + j2);
        return z;
    }

    public static boolean enablePreferList() {
        e parseObject;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null || (parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5_preferExpired"))) == null || parseObject.isEmpty() || !StringSet.off.equalsIgnoreCase(H5Utils.getString(parseObject, "switch"))) {
            return true;
        }
        return false;
    }

    private Map<String, H5PreferAppInfo> jsonToMap(String str) {
        e parseObject = H5Utils.parseObject(str);
        if (parseObject == null || parseObject.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : parseObject.keySet()) {
            try {
                hashMap.put(next, (H5PreferAppInfo) a.parseObject(parseObject.get(next).toString(), H5PreferAppInfo.class));
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        H5Log.d(TAG, "parse map : " + hashMap.toString());
        return hashMap;
    }

    public static void startCheckPermissionScheme(H5StartAppInfo h5StartAppInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("alipays://platformapi/startapp?appId=" + h5StartAppInfo.targetAppId);
        Bundle bundle = new Bundle();
        if (h5StartAppInfo.params != null) {
            bundle = (Bundle) h5StartAppInfo.params.clone();
        }
        bundle.putString(H5InstallAppAdvice.nbsource, "debug");
        bundle.putString(nbsn, getNbsn(h5StartAppInfo.targetAppId));
        bundle.putString(nbsv, getInstance().getPreferVersion(h5StartAppInfo.targetAppId));
        for (String str : bundle.keySet()) {
            try {
                String obj = bundle.get(str).toString();
                sb.append(AppConstants.AND_SIGN + str + "=" + H5UrlHelper.encode(obj));
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        H5Log.d(TAG, "encodeSchemeBuilder : " + sb.toString());
        String encode = H5UrlHelper.encode(sb.toString());
        H5EnvProvider h5EnvProvider = (H5EnvProvider) H5Utils.getProvider(H5EnvProvider.class.getName());
        if (h5EnvProvider != null) {
            H5Log.d(TAG, "scheme : " + "alipays://platformapi/startapp?appId=20001101&token=preferconvert&scheme=" + encode);
            h5EnvProvider.goToSchemeService("alipays://platformapi/startapp?appId=20001101&token=preferconvert&scheme=" + encode);
        }
    }

    private static String getNbsn(String str) {
        H5PreferAppInfo h5PreferAppInfo = getInstance().preferList.get(str);
        if (h5PreferAppInfo == null) {
            return "";
        }
        String nbsn2 = h5PreferAppInfo.getNbsn();
        H5Log.d(TAG, " preferNbsn : ".concat(String.valueOf(nbsn2)));
        return nbsn2;
    }
}
