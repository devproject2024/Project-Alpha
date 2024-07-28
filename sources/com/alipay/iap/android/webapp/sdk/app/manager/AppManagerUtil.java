package com.alipay.iap.android.webapp.sdk.app.manager;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;

public class AppManagerUtil {
    public static final String EXTEND_INDEX = "Index";
    public static final String EXTEND_ONLINE_APPID = "_online";
    public static final String EXTEND_PREFIX_DEFAULT = "app";
    public static final String EXTEND_REMOTE_URL_PREFIX = "RemoteURLPrefix";
    public static final String EXTEND_SHOULD_LOAD_REMOTE = "ShouldLoadRemote";
    public static final String EXTEND_TYPE = "Type";
    public static final String EXTEND_UPDATE_POLICY = "UpdatePolicy";
    private static final String TAG = "AppManagerUtil";
    private static String mAppPrefix;

    private static String getPrefix() {
        String str = mAppPrefix;
        if (str != null) {
            return str;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            mAppPrefix = h5ConfigProvider.getConfig(Constants.APP_EXTEND_PREFIX);
        }
        if (TextUtils.isEmpty(mAppPrefix)) {
            mAppPrefix = EXTEND_PREFIX_DEFAULT;
        }
        return mAppPrefix;
    }

    public static H5AppDBService getH5AppDBService() {
        return ((H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())).getAppDBService();
    }

    public static AppInfo getLastInstalledAppInfo(String str) {
        H5AppDBService h5AppDBService = getH5AppDBService();
        if (h5AppDBService == null) {
            return null;
        }
        String findInstallAppVersion = h5AppDBService.findInstallAppVersion(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" installAppVersion ");
        sb.append(findInstallAppVersion);
        c.e();
        if (TextUtils.isEmpty(findInstallAppVersion)) {
            return null;
        }
        return h5AppDBService.getAppInfo(str, findInstallAppVersion);
    }

    public static AppInfo getAppInfo(String str) {
        H5AppDBService h5AppDBService = getH5AppDBService();
        if (h5AppDBService != null) {
            return h5AppDBService.getAppInfo(str, (String) null);
        }
        return null;
    }

    public static AppInfo buildAppInfo(String str, SubAppConfig subAppConfig) {
        if (TextUtils.isEmpty(str) || subAppConfig == null || TextUtils.isEmpty(subAppConfig.version)) {
            return null;
        }
        "config = ".concat(String.valueOf(subAppConfig));
        c.e();
        AppInfo appInfo = new AppInfo();
        appInfo.app_id = str;
        appInfo.version = subAppConfig.version;
        appInfo.package_url = subAppConfig.downloadURL;
        appInfo.vhost = getVhost(subAppConfig.remoteURLPrefix);
        appInfo.main_url = subAppConfig.index;
        String prefix = getPrefix();
        e eVar = new e();
        eVar.put(prefix + EXTEND_TYPE, (Object) subAppConfig.type);
        eVar.put(prefix + EXTEND_INDEX, (Object) subAppConfig.index);
        eVar.put(prefix + EXTEND_UPDATE_POLICY, (Object) subAppConfig.updatePolicy);
        eVar.put(prefix + EXTEND_REMOTE_URL_PREFIX, (Object) subAppConfig.remoteURLPrefix);
        eVar.put(prefix + EXTEND_SHOULD_LOAD_REMOTE, (Object) String.valueOf(subAppConfig.shouldLoadRemote));
        e eVar2 = new e();
        eVar2.put(H5Param.LAUNCHER_PARAM, (Object) eVar);
        appInfo.extend_info_jo = eVar2.toJSONString();
        return appInfo;
    }

    private static String getVhost(String str) {
        try {
            Uri parse = Uri.parse(str);
            String str2 = parse.getScheme() + "://" + parse.getHost();
            "vhost = ".concat(String.valueOf(str2));
            c.e();
            return str2;
        } catch (Exception e2) {
            new StringBuilder("getVhost").append(e2.getMessage());
            c.g();
            return null;
        }
    }

    public static String getPresetFileName(AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        return appInfo.app_id + "_" + appInfo.version + ".amr";
    }

    public static String getExtendParam(AppInfo appInfo, String str) {
        if (appInfo != null && !TextUtils.isEmpty(appInfo.extend_info_jo)) {
            try {
                e parseObject = H5Utils.parseObject(appInfo.extend_info_jo);
                if (parseObject != null) {
                    if (parseObject.containsKey(H5Param.LAUNCHER_PARAM)) {
                        e jSONObject = parseObject.getJSONObject(H5Param.LAUNCHER_PARAM);
                        return jSONObject.getString(getPrefix() + str);
                    }
                }
                return null;
            } catch (Exception e2) {
                new StringBuilder("getExtendParam: ").append(e2.getMessage());
                c.i();
            }
        }
        return null;
    }

    public static String getUpdatePolicy(AppInfo appInfo) {
        return getExtendParam(appInfo, EXTEND_UPDATE_POLICY);
    }

    public static String getShouldLoadRemote(AppInfo appInfo) {
        return getExtendParam(appInfo, EXTEND_SHOULD_LOAD_REMOTE);
    }

    public static String getType(AppInfo appInfo) {
        return getExtendParam(appInfo, EXTEND_TYPE);
    }

    public static String getIndex(AppInfo appInfo) {
        return getExtendParam(appInfo, EXTEND_INDEX);
    }

    public static String getExtendRemoteURLPrefix(AppInfo appInfo) {
        return getExtendParam(appInfo, EXTEND_REMOTE_URL_PREFIX);
    }

    public static String getOnlineAppId(String str) {
        return str + EXTEND_ONLINE_APPID;
    }
}
