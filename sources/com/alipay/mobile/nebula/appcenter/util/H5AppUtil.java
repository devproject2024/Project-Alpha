package com.alipay.mobile.nebula.appcenter.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobileappconfig.core.model.hybirdPB.PackInfoReq;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import easypay.manager.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5AppUtil {
    public static final int CERT_PATH_NOT_EXIST = 4;
    private static final int DEFAULT_MAX_PREPARE_WAIT_MS = 1000;
    public static final int EMPTY_RES = 8;
    public static final int INVALID_PARAM = 1;
    public static final int OFFLINE_PATH_NOT_EXIST = 2;
    public static final int OPEN_PLAT_REQ_MODE_All = 1;
    public static final int OPEN_PLAT_REQ_MODE_HPM = 3;
    public static final int OPEN_PLAT_REQ_MODE_ONE = 2;
    public static final int SUCCESS = 0;
    /* access modifiers changed from: private */
    public static String TAG = "H5AppUtil";
    public static final int TAR_PATH_NOT_EXIST = 3;
    public static final int TAR_SIGNATURE_IS_EMPTY = 5;
    public static final int UN_KNOW_EXCEPTION = 7;
    public static final int VERIFY_FAIL = 6;
    public static final String api_permission = "api_permission";
    private static final String[] appIds = {"20000067", "20000095", "20000096", "20000097", "20000098", "20000099"};
    private static Set<String> appSet = null;
    public static final String app_channel = "app_channel";
    public static final String app_type = "app_type";
    public static String currentPsd = "";
    public static final String down_type = "download_type";
    public static final String local_report = "local_report";
    public static final String package_nick = "package_nick";
    public static final String patchDict = "patchDict";
    public static final String preReqRate = "preReqRate";
    public static final String prepareTime = "expireTime";
    public static final String preset = "preset";
    private static final String[] publicAppIds = {"20000101", "20000042", "20000249"};
    private static Set<String> publicAppSet = null;
    public static final String release_type = "release_type";
    public static final String scene = "scene";
    public static String secAppId = "";
    public static final String short_preReqRate = "pr";
    public static final String short_prepareTime = "et";
    public static final String strictReqRate = "strictReqRate";
    public static final String third_platform = "third_platform";

    public static String matchAppId(String str) {
        String str2 = "";
        try {
            if (!str.contains("h5app")) {
                if (!str.contains("hybrid")) {
                    return null;
                }
            }
            if (str.contains("h5app")) {
                str2 = "\\d+\\.h5app\\.(alipay|m\\.taobao)\\.(net|com)";
            } else if (str.contains("hybrid")) {
                str2 = "^\\d+[.]hybrid[.]alipay-eco[.](com|net)$";
            }
            Pattern compile = H5PatternHelper.compile(str2);
            String host = H5UrlHelper.getHost(str);
            if (compile != null && !TextUtils.isEmpty(host)) {
                Matcher matcher = compile.matcher(host);
                if (matcher.find()) {
                    String str3 = TAG;
                    H5Log.d(str3, "group:" + matcher.group() + " url:" + str);
                    String group = matcher.group();
                    if (!TextUtils.isEmpty(group)) {
                        return group.substring(0, group.indexOf(AppUtility.CENTER_DOT));
                    }
                }
            }
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
        return null;
    }

    public static boolean isH5ContainerAppId(String str) {
        if (appSet == null) {
            HashSet hashSet = new HashSet();
            appSet = hashSet;
            hashSet.addAll(Arrays.asList(appIds));
        }
        return appSet.contains(str);
    }

    public static boolean isPublicAppId(String str) {
        if (publicAppSet == null) {
            HashSet hashSet = new HashSet();
            publicAppSet = hashSet;
            hashSet.addAll(Arrays.asList(publicAppIds));
        }
        return publicAppSet.contains(str);
    }

    public static List<String> getAppIds() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(Arrays.asList(appIds));
        return linkedList;
    }

    public static AppInfo toAppInfo(e eVar) {
        e jSONObject;
        H5AppCenterService h5AppCenterService;
        if (eVar == null || eVar.isEmpty()) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.app_id = H5Utils.getString(eVar, "app_id");
        if (!TextUtils.isEmpty(H5Utils.getString(eVar, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE))) {
            appInfo.size = Long.parseLong(H5Utils.getString(eVar, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE));
        }
        appInfo.patch = H5Utils.getString(eVar, "patch");
        appInfo.online = H5Utils.getInt(eVar, P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT);
        appInfo.fallback_base_url = H5Utils.getString(eVar, "fallback_base_url");
        appInfo.package_url = H5Utils.getString(eVar, "package_url");
        appInfo.version = H5Utils.getString(eVar, "version");
        appInfo.app_dsec = H5Utils.getString(eVar, "app_desc");
        appInfo.vhost = H5Utils.getString(eVar, "vhost");
        appInfo.nbl_id = H5Utils.getString(eVar, "nbl_id");
        appInfo.name = H5Utils.getString(eVar, "name");
        e jSONObject2 = H5Utils.getJSONObject(eVar, "extend_info", (e) null);
        String string = H5Utils.getString(eVar, "api_permission");
        if (!TextUtils.isEmpty(string)) {
            jSONObject2.put("api_permission", (Object) string);
        }
        String string2 = H5Utils.getString(eVar, package_nick);
        if (!TextUtils.isEmpty(string2)) {
            jSONObject2.put(package_nick, (Object) string2);
        }
        String string3 = H5Utils.getString(eVar, scene);
        if (!TextUtils.isEmpty(string3)) {
            jSONObject2.put(scene, (Object) string3);
        }
        appInfo.localReport = H5Utils.getInt(eVar, local_report);
        e jSONObject3 = H5Utils.getJSONObject(jSONObject2, H5Param.LAUNCHER_PARAM, (e) null);
        String string4 = H5Utils.getString(jSONObject3, H5Param.LONG_NB_APP_TYPE);
        if (!TextUtils.isEmpty(string4)) {
            appInfo.nbAppType = string4;
        } else {
            appInfo.nbAppType = H5Utils.getString(jSONObject3, H5Param.NB_APP_TYPE);
        }
        int i2 = H5Utils.getInt(eVar, preset);
        if (i2 != 0) {
            jSONObject2.put(preset, (Object) Integer.valueOf(i2));
        }
        appInfo.extend_info_jo = jSONObject2.toJSONString();
        appInfo.third_platform = eVar.getString(third_platform);
        appInfo.app_type = H5Utils.getInt(eVar, app_type);
        appInfo.app_channel = H5Utils.getInt(eVar, "app_channel");
        appInfo.main_url = H5Utils.getString(eVar, "main_url");
        appInfo.system_max = H5Utils.getString(eVar, "system_max");
        appInfo.system_min = H5Utils.getString(eVar, "system_min");
        appInfo.auto_install = H5Utils.getInt(eVar, down_type);
        appInfo.icon_url = H5Utils.getString(eVar, AppConstants.ICON_URL);
        appInfo.release_type = H5Utils.getString(eVar, "release_type");
        if (TextUtils.isEmpty(appInfo.release_type)) {
            appInfo.release_type = "ONLINE";
        }
        if (TextUtils.isEmpty(appInfo.patch) && (jSONObject = H5Utils.getJSONObject(eVar, patchDict, (e) null)) != null && !jSONObject.isEmpty() && (h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())) != null) {
            String findInstallAppVersion = h5AppCenterService.getAppDBService().findInstallAppVersion(appInfo.app_id);
            if (!TextUtils.isEmpty(findInstallAppVersion)) {
                Iterator<String> it2 = jSONObject.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    try {
                        String next = it2.next();
                        String obj = jSONObject.get(next).toString();
                        if (TextUtils.equals(next, findInstallAppVersion)) {
                            appInfo.patch = obj;
                            break;
                        }
                    } catch (Exception e2) {
                        H5Log.e(TAG, (Throwable) e2);
                    }
                }
            }
        }
        if ("66666672".equals(appInfo.app_id)) {
            String str = TAG;
            H5Log.d(str, "appInfo.app_id set app_channel 4 " + appInfo.app_id);
            appInfo.app_channel = 4;
        }
        if (h5AppChannel4(appInfo.app_id)) {
            appInfo.app_channel = 4;
        }
        return appInfo;
    }

    static boolean h5AppChannel4(String str) {
        b parseArray;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null || (parseArray = H5Utils.parseArray(h5ConfigProvider.getConfigWithProcessCache("h5_app_channel4"))) == null || parseArray.isEmpty()) {
            return false;
        }
        return parseArray.contains(str);
    }

    public static void setH5AppCenterProvider(String str, String str2) {
        try {
            H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
            if (h5Service != null) {
                h5Service.prepareApp(str, str2, new H5AppInstallProcess() {
                    ConditionVariable tagConditionVariable = new ConditionVariable();

                    public final void prepare(H5AppInstallStep h5AppInstallStep, String str) {
                        ConditionVariable conditionVariable;
                        String access$000 = H5AppUtil.TAG;
                        H5Log.d(access$000, "setH5AppCenterProvider--->prepare installStep " + h5AppInstallStep + ", appId " + str);
                        if (h5AppInstallStep == H5AppInstallStep.APP_INSTALL_STEP_ACQUIRE_INFO) {
                            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                            int i2 = 0;
                            if (h5ConfigProvider != null && !TextUtils.isEmpty(str)) {
                                String config = h5ConfigProvider.getConfig("h5_prepareWaitMS4Android");
                                if (!TextUtils.isEmpty(config)) {
                                    i2 = Integer.parseInt(config);
                                }
                                if (i2 > 1000) {
                                    i2 = 1000;
                                }
                                String access$0002 = H5AppUtil.TAG;
                                H5Log.d(access$0002, "setH5AppCenterProvider--->mainappid sleep " + i2 + " ms");
                            }
                            if (i2 > 0 && (conditionVariable = this.tagConditionVariable) != null) {
                                conditionVariable.close();
                                H5Log.d(H5AppUtil.TAG, "setH5AppCenterProvider--->sleep before");
                                this.tagConditionVariable.block((long) i2);
                                H5Log.d(H5AppUtil.TAG, "setH5AppCenterProvider--->sleep after");
                            }
                        }
                    }

                    public final void onResult(boolean z, boolean z2) {
                        if (this.tagConditionVariable != null) {
                            H5Log.d(H5AppUtil.TAG, "setH5AppCenterProvider--->sleep awake");
                            this.tagConditionVariable.open();
                        }
                    }
                });
            }
        } catch (Exception e2) {
            H5Log.e(TAG, "exception:", e2);
        }
    }

    public static String checkLogVersion(String str, String str2) {
        H5AppProvider h5AppProvider;
        if (!(str2 == null || !str2.contains("*") || (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) == null)) {
            String walletVersion = h5AppProvider.getWalletVersion(str);
            if (!TextUtils.isEmpty(walletVersion)) {
                return walletVersion;
            }
        }
        return str2;
    }

    public static boolean checkSubUrl(String str, String str2, String str3, String str4) {
        if (str.startsWith("/") || str.startsWith("file://") || !str.startsWith("http")) {
            return true;
        }
        Uri parseUrl = H5UrlHelper.parseUrl(str);
        Uri parseUrl2 = H5UrlHelper.parseUrl(str2);
        if (parseUrl == null || parseUrl2 == null) {
            return true;
        }
        if (TextUtils.equals(parseUrl.getScheme(), parseUrl2.getScheme()) && TextUtils.equals(parseUrl.getHost(), parseUrl2.getHost())) {
            return true;
        }
        String str5 = TAG;
        H5Log.e(str5, "uri:" + parseUrl + " launcherUrl:" + parseUrl2 + " match urlIsInvalid = false");
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider != null) {
            String subUrl = h5AppProvider.getSubUrl(str3, str4);
            if (!TextUtils.isEmpty(subUrl)) {
                H5Log.d(TAG, "subUrl:".concat(String.valueOf(subUrl)));
                b parseArray = H5Utils.parseArray(subUrl);
                if (parseArray != null && !parseArray.isEmpty()) {
                    int i2 = 0;
                    while (i2 < parseArray.size()) {
                        Uri parseUrl3 = H5UrlHelper.parseUrl(parseArray.get(i2).toString());
                        if (parseUrl3 == null || !TextUtils.equals(parseUrl.getScheme(), parseUrl3.getScheme()) || !TextUtils.equals(parseUrl.getHost(), parseUrl3.getHost())) {
                            i2++;
                        } else {
                            String str6 = TAG;
                            H5Log.e(str6, "uri:" + parseUrl + " subUri:" + parseUrl3 + " match urlIsInvalid = true");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int compareVersion(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.contains("*")) {
                if (!str2.contains("*")) {
                    String[] split = str.split("\\.");
                    String[] split2 = str2.split("\\.");
                    int length = split.length;
                    int length2 = split2.length;
                    int i2 = length <= length2 ? length : length2;
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = (Long.parseLong(split[i3]) > Long.parseLong(split2[i3]) ? 1 : (Long.parseLong(split[i3]) == Long.parseLong(split2[i3]) ? 0 : -1));
                        if (i4 > 0) {
                            return 1;
                        }
                        if (i4 < 0) {
                            return -1;
                        }
                    }
                    if (length > length2) {
                        while (i2 < length) {
                            if (Long.parseLong(split[i2]) > 0) {
                                return 1;
                            }
                            i2++;
                        }
                    } else if (length < length2) {
                        while (i2 < length2) {
                            if (Long.parseLong(split2[i2]) > 0) {
                                return -1;
                            }
                            i2++;
                        }
                    }
                }
            }
            return 0;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return 0;
        }
    }

    public static boolean downloadH5App(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        if (appInfo.auto_install == 2) {
            H5Log.d(TAG, "rn pkg auto_install == 2  not to downLoad");
            return false;
        } else if (H5Utils.isInWifi() || appInfo.auto_install == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String getPackageNick(String str) {
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider != null) {
            return h5AppProvider.getPackageNick(str);
        }
        return null;
    }

    private static boolean hasH5Open() {
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        return (h5Service != null ? h5Service.getTopH5Page() : null) != null;
    }

    public static void broadcastForH5Download(String str, String str2) {
        if (hasH5Open()) {
            String str3 = TAG;
            H5Log.d(str3, "broadcastForH5Download: appid " + str + " version:" + str2 + " download ok!");
            a a2 = a.a(H5Utils.getContext());
            Intent intent = new Intent("com.alipay.mobile.android.h5app.download");
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            bundle.putString("version", str2);
            intent.putExtras(bundle);
            a2.a(intent);
        }
    }

    public static void broadcastForH5Install(String str, String str2) {
        if (hasH5Open()) {
            String str3 = TAG;
            H5Log.d(str3, "broadcastForH5Install: appid " + str + " version:" + str2 + " install ok!");
            a a2 = a.a(H5Utils.getContext());
            Intent intent = new Intent("com.alipay.mobile.android.h5app.installstatus");
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            bundle.putString("version", str2);
            bundle.putString("source", "nebula");
            intent.putExtras(bundle);
            a2.a(intent);
        }
    }

    public static void appCenterLog(String str, AppInfo appInfo, String str2) {
        if (appInfo != null) {
            String str3 = ("appId=" + appInfo.app_id + "^version=" + appInfo.version) + str2;
            H5ProviderManager h5ProviderManager = H5Utils.getH5ProviderManager();
            H5LogProvider h5LogProvider = h5ProviderManager != null ? (H5LogProvider) h5ProviderManager.getProvider(H5LogProvider.class.getName()) : null;
            if (h5LogProvider != null) {
                h5LogProvider.log(str, "monitor", "", str2, str3);
            }
        }
    }

    public static H5LogProvider getH5LogProvider() {
        H5ProviderManager h5ProviderManager = H5Utils.getH5ProviderManager();
        if (h5ProviderManager != null) {
            return (H5LogProvider) h5ProviderManager.getProvider(H5LogProvider.class.getName());
        }
        return null;
    }

    public static void setConfig(e eVar, AppRes appRes) {
        if (eVar.containsKey(Constants.EASY_PAY_CONFIG_PREF_KEY)) {
            appRes.config = H5Utils.jsonToMap(H5Utils.toJSONString(H5Utils.getJSONObject(eVar, Constants.EASY_PAY_CONFIG_PREF_KEY, (e) null)));
            if (appRes.config == null) {
                appRes.config = new HashMap();
                return;
            }
            return;
        }
        appRes.config = null;
    }

    public static PackInfoReq getPkgReqFromAppReq(AppReq appReq) {
        PackInfoReq packInfoReq = new PackInfoReq();
        packInfoReq.platform = appReq.platform;
        packInfoReq.system = appReq.system;
        packInfoReq.client = appReq.client;
        packInfoReq.sdk = appReq.sdk;
        packInfoReq.env = appReq.env;
        packInfoReq.channel = appReq.channel;
        packInfoReq.bundleid = appReq.bundleid;
        packInfoReq.query = appReq.query;
        packInfoReq.existed = appReq.existed;
        packInfoReq.grayRules = appReq.grayRules;
        packInfoReq.localAppInfo = appReq.localAppInfo;
        packInfoReq.stableRpc = appReq.stableRpc;
        packInfoReq.scene = appReq.scene;
        packInfoReq.preferLocal = appReq.preferLocal;
        packInfoReq.reqmode = appReq.reqmode;
        return packInfoReq;
    }

    public static boolean isOffLine(String str) {
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider == null || !h5AppProvider.isOffline(str) || H5DevAppList.getInstance().contains(str)) {
            return false;
        }
        String str2 = TAG;
        H5Log.d(str2, "appId " + str + " isOffline not to start");
        return true;
    }

    public static boolean isRNApp(AppInfo appInfo) {
        return appInfo != null && appInfo.app_type == 5;
    }

    public static boolean isH5AppPkg(AppInfo appInfo) {
        return appInfo != null && appInfo.app_type == 1;
    }

    public static void deleteNebulaInstallFileAndDB(String str, String str2) {
        String str3 = TAG;
        H5Log.d(str3, "deleteNebulaInstallFileAndDB " + str2 + " " + str);
        H5FileUtil.delete(str);
        H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
        if (h5AppCenterService != null) {
            h5AppCenterService.getAppDBService().deleteAppInstall(str2);
        }
    }

    public static boolean isNativeApp(String str) {
        Set<String> commonResourceAppList;
        if (!H5Utils.isInWallet()) {
            return false;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null && "no".equals(h5ConfigProvider.getConfigWithProcessCache("h5_getFromIsNativeApp"))) {
            return false;
        }
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null && (commonResourceAppList = h5AppCenterPresetProvider.getCommonResourceAppList()) != null && !commonResourceAppList.isEmpty() && commonResourceAppList.contains(str)) {
            return false;
        }
        try {
            com.alipay.mobile.framework.b.a();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        return false;
    }

    public static boolean enableDSL(Bundle bundle) {
        return H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, H5Param.ENABLE_DSL));
    }

    public static boolean isAppChannel4(Bundle bundle) {
        return H5Utils.getInt(bundle, "app_channel") == 4;
    }

    public static Bundle mergeConmonStartParam(Bundle bundle, AppInfo appInfo) {
        getLauncherParamFromExtendInfo(bundle, appInfo);
        H5ParamParser.parseMagicOptions(bundle, TAG);
        return bundle;
    }

    public static void getLauncherParamFromExtendInfo(Bundle bundle, AppInfo appInfo) {
        if (appInfo != null && !TextUtils.isEmpty(appInfo.extend_info_jo)) {
            H5ParamParser.setLauncherParams(H5Utils.getJSONObject(H5Utils.parseObject(appInfo.extend_info_jo), H5Param.LAUNCHER_PARAM, (e) null), bundle);
        }
    }

    public static Bundle copyBundle(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle2 = (Bundle) bundle.clone();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            bundle2 = null;
        }
        H5Log.d(TAG, "copyBundle ".concat(String.valueOf(bundle2)));
        return bundle2;
    }
}
