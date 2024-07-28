package com.alipay.mobile.nebulacore.wallet;

import android.text.TextUtils;
import com.alibaba.a.a;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.alipay.iap.android.webapp.sdk.provider.IAPLogProvider;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.wallet.H5LoggerSwitchModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class H5LoggerSwitch {
    private static final String APLOG_TYPE = "aplog";
    private static final String DEFAULT_OUTPUT = "mdap|aplog";
    private static final String MAAP_TYPE = "mdap";
    public static final String TAG = "H5LoggerSwitch";
    public static H5LoggerSwitchModel loggerSwitchModel;
    public static Map<String, LoggerPresetModel> presetSwitchMap;

    static {
        HashMap hashMap = new HashMap();
        presetSwitchMap = hashMap;
        hashMap.put("H5_AL_FLOW", new LoggerPresetModel(Constants.RESULT_STATUS_SUCCESS, DEFAULT_OUTPUT));
        presetSwitchMap.put(H5Plugin.CommonEvents.H5_AL_PAY_START, new LoggerPresetModel("1070", DEFAULT_OUTPUT));
        presetSwitchMap.put(H5Plugin.CommonEvents.H5_AL_PAY_RESULT, new LoggerPresetModel("1080", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_LOAD_FAIL", new LoggerPresetModel("1110", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_RESUME", new LoggerPresetModel("1120", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_SYNCAJAX", new LoggerPresetModel("2030", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_NETWORK_PERFORMANCE_WARN", new LoggerPresetModel("2041", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_NETWORK_PERFORMANCE_ERROR", new LoggerPresetModel("2042", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_NETWORK_PERFORMANCE_INVALIDSESSION", new LoggerPresetModel("2043", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_NETWORK_START", new LoggerPresetModel("2044", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_JSERROR", new LoggerPresetModel("2050", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_INTERCEPT_SCHEME", new LoggerPresetModel("2100", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_LAUNCH_PARAM_WARN", new LoggerPresetModel("2200", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_NETWORK_PERMISSON_ERROR", new LoggerPresetModel("2088", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ENTRY_ERROR", new LoggerPresetModel("4001", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_FROM_NATIVE", new LoggerPresetModel("4008", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_TO_NATIVE", new LoggerPresetModel("4009", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_START", new LoggerPresetModel("4010", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_CONFIG", new LoggerPresetModel("4020", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_VERIFYTAR_SUCCESS", new LoggerPresetModel("4030", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_VERIFYTAR_FAIL", new LoggerPresetModel("4031", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_VERIFYTAR_NONEXISTENT", new LoggerPresetModel("4032", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_LAUNCH", new LoggerPresetModel("4040", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_RESUME", new LoggerPresetModel("4050", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_END", new LoggerPresetModel("4060", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ENTRYRPC", new LoggerPresetModel("4070", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ENTRYRPC_SKIP", new LoggerPresetModel("4071", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ENTRYRPC_SUCCESS", new LoggerPresetModel("4072", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ENTRYRPC_ERROR", new LoggerPresetModel("4073", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_JSAPI_CALL", new LoggerPresetModel("4080", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_JSAPI_RESULT", new LoggerPresetModel("4100", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_JSAPI_RESULT_ERROR", new LoggerPresetModel("4101", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_GLOBALLIST_ERROR", new LoggerPresetModel("4121", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_GLOBALLIST_SUCCESS", new LoggerPresetModel("4122", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_HTTPPROXY", new LoggerPresetModel("4130", DEFAULT_OUTPUT));
        presetSwitchMap.put(H5Logger.H5_AL_SESSION_HTTPPROXY_FAIL, new LoggerPresetModel("4131", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_AUTOLOGIN", new LoggerPresetModel("4140", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_INJECT_JS", new LoggerPresetModel("4150", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_INJECT_JSCODE", new LoggerPresetModel("4151", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_MAP_SUCCESS", new LoggerPresetModel("4160", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_FALLBACK", new LoggerPresetModel("4161", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_UPDATEPACKAGE_SUCCESS", new LoggerPresetModel("4162", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_PAGE_UNAVAILABEL", new LoggerPresetModel("4181", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_ILLEGAL_URL", new LoggerPresetModel("4190", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_JSAPI_SENDEVENT", new LoggerPresetModel("4200", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_AUTOLOGIN_START", new LoggerPresetModel("4300", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_AUTOLOGIN_RESULT", new LoggerPresetModel("4301", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_AUTOLOGIN_END", new LoggerPresetModel("4302", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ALIAUTOLOGIN", new LoggerPresetModel("4400", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_SESSION_ZHIMALOGIN", new LoggerPresetModel("4401", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_GETSHARECONTENT_RESULT", new LoggerPresetModel("4500", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_ALMODE_ENABLE", new LoggerPresetModel("4600", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_PREPARE", new LoggerPresetModel("5000", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_DOWNLOAD", new LoggerPresetModel("5001", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_UNZIP", new LoggerPresetModel("5002", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_REQUEST", new LoggerPresetModel("5003", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_POOL", new LoggerPresetModel("5004", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_VERIFY", new LoggerPresetModel("5005", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_EXCEP", new LoggerPresetModel("5006", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_BIZ_SYNC", new LoggerPresetModel("5007", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_BIZ_APPCENTER", new LoggerPresetModel("5008", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_BIZ_EXCP", new LoggerPresetModel("5009", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_RPC_EXCEPTION", new LoggerPresetModel("5010", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_APP_LOAD_DATASOURCE", new LoggerPresetModel("5011", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_PAGE_RES_REDIRECT", new LoggerPresetModel("5012", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_RESOURCE_FIRST_OFFLINE", new LoggerPresetModel("7000", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_TABBAR_WARN", new LoggerPresetModel("99000", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_AL_TABBAR_ERROR", new LoggerPresetModel("99001", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_PAGE_ABNORMAL", new LoggerPresetModel("2021", DEFAULT_OUTPUT));
        presetSwitchMap.put("H5_PAGE_REPAIR", new LoggerPresetModel("5020", DEFAULT_OUTPUT));
    }

    private static void setLoggerSwitchModel(String str) {
        try {
            loggerSwitchModel = (H5LoggerSwitchModel) a.parseObject(str, H5LoggerSwitchModel.class);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static boolean isUploadMdap(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if (!enableLoggerSwitch()) {
            printApLog(str, str2, str3, str4, str5);
            return true;
        }
        if (loggerSwitchModel == null) {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
            if (h5ConfigProvider != null) {
                str14 = h5ConfigProvider.getConfigWithProcessCache("h5_autoLoggerSwitch");
            } else {
                str14 = "";
            }
            if (!TextUtils.isEmpty(str14)) {
                setLoggerSwitchModel(str14);
            } else {
                printApLog(str, str2, str3, str4, str5);
                return true;
            }
        }
        Map<String, LoggerPresetModel> map = presetSwitchMap;
        if (map != null) {
            LoggerPresetModel loggerPresetModel = map.get(str);
            if (loggerPresetModel != null) {
                str7 = loggerPresetModel.logId;
                str6 = loggerPresetModel.output;
            } else {
                str7 = "";
                str6 = str7;
            }
            if (loggerPresetModel == null || TextUtils.isEmpty(str7)) {
                String str15 = str2;
                String str16 = str3;
                String str17 = str4;
                String str18 = str5;
                printApLog(str, str2, str3, str4, str5);
                return true;
            }
            String[] split = (str2 + "^" + str3 + "^" + str4 + "^" + str5).split(IAPLogProvider.EXT_PARAM_DIVIDER);
            if (split == null || split.length <= 0) {
                str11 = "";
                str10 = str11;
                str9 = str10;
                str8 = str9;
            } else {
                int length = split.length;
                str11 = "";
                str10 = str11;
                str9 = str10;
                str8 = str9;
                int i2 = 0;
                while (i2 < length) {
                    String str19 = split[i2];
                    String[] strArr = split;
                    if (str19.contains("targetUrl=")) {
                        str11 = str19.substring(str19.indexOf("=") + 1);
                    }
                    if (str19.contains("appId=")) {
                        str10 = str19.substring(str19.indexOf("=") + 1);
                    }
                    if (str19.contains("publicId=")) {
                        str9 = str19.substring(str19.indexOf("=") + 1);
                    }
                    if (str19.contains("url=")) {
                        str8 = str19.substring(str19.indexOf("=") + 1);
                    }
                    i2++;
                    split = strArr;
                }
            }
            H5LoggerSwitchModel h5LoggerSwitchModel = loggerSwitchModel;
            if (h5LoggerSwitchModel == null || h5LoggerSwitchModel.getRules().size() <= 0) {
                printApLog(str, str2, str3, str4, str5);
                return true;
            }
            String output = loggerSwitchModel.getOutput();
            Iterator<H5LoggerSwitchModel.RulesBean> it2 = loggerSwitchModel.getRules().iterator();
            boolean z = true;
            while (it2.hasNext()) {
                H5LoggerSwitchModel.RulesBean next = it2.next();
                Iterator<H5LoggerSwitchModel.RulesBean> it3 = it2;
                if (TextUtils.equals(next.getLid(), str7)) {
                    String publicId = next.getRange().getPublicId();
                    String appId = next.getRange().getAppId();
                    str12 = str7;
                    String url = next.getRange().getUrl();
                    boolean z2 = !TextUtils.isEmpty(publicId) && match(str9, publicId);
                    if (!TextUtils.isEmpty(appId) && match(str10, appId)) {
                        z2 = true;
                    }
                    boolean z3 = !TextUtils.isEmpty(url) && (match(str11, url) || match(str8, url));
                    if (TextUtils.isEmpty(publicId) && TextUtils.isEmpty(appId)) {
                        z2 = true;
                    }
                    if (TextUtils.isEmpty(url)) {
                        z3 = true;
                    }
                    if (!z3 || !z2) {
                        z = false;
                    } else {
                        String output2 = next.getOutput();
                        if (!TextUtils.isEmpty(output2)) {
                            if (match(APLOG_TYPE, output2)) {
                                printApLog(str, str2, str3, str4, str5);
                            }
                            if (match(MAAP_TYPE, output2)) {
                                return true;
                            }
                            String str20 = str;
                            it2 = it3;
                            str13 = str12;
                            z = false;
                        } else {
                            printApLog(str, str2, str3, str4, str5);
                            return true;
                        }
                    }
                } else {
                    str12 = str7;
                }
                String str21 = str;
                it2 = it3;
                str13 = str12;
            }
            if (!z) {
                return false;
            }
            if (!TextUtils.isEmpty(output)) {
                if (match(APLOG_TYPE, output) && match(APLOG_TYPE, str6)) {
                    printApLog(str, str2, str3, str4, str5);
                }
                return match(MAAP_TYPE, output) && match(MAAP_TYPE, str6);
            }
            printApLog(str, str2, str3, str4, str5);
            return true;
        }
        String str22 = str2;
        String str23 = str3;
        String str24 = str4;
        String str25 = str5;
        printApLog(str, str2, str3, str4, str5);
        return true;
    }

    private static void printApLog(String str, String str2, String str3, String str4, String str5) {
        H5Log.d(TAG, "seedId: " + str + " ,param1: " + str2 + " ,param2: " + str3 + " ,param3: " + str4 + " ,param4: " + str5);
    }

    public static class LoggerPresetModel {
        public String logId;
        public String output;

        public LoggerPresetModel(String str, String str2) {
            this.logId = str;
            this.output = str2;
        }
    }

    private static boolean match(String str, String str2) {
        Pattern compile = H5PatternHelper.compile(str2);
        if (compile == null) {
            return false;
        }
        return compile.matcher(str).find();
    }

    private static boolean enableLoggerSwitch() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableLoggerSwitch"));
    }
}
