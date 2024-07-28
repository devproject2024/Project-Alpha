package com.alipay.mobile.nebula.resourcehandler;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.mobile.nebula.provider.H5APMTool;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.business.merchant_payments.common.utility.AppUtility;

public class H5ResourceHandlerUtil {
    public static final String AUDIO = "audio";
    public static final String IMAGE = "image";
    public static final String RESOURCE = "https://resource/";
    public static final String VIDEO = "video";

    public static String localIdToUrl(String str, String str2) {
        return RESOURCE + str + AppUtility.CENTER_DOT + str2;
    }

    public static String apUrlToFilePath(String str) {
        Uri parseUrl;
        String[] split;
        H5APMTool h5APMTool;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if ((str.endsWith(IMAGE) || str.endsWith(VIDEO) || str.endsWith(AUDIO)) && (parseUrl = H5UrlHelper.parseUrl(str)) != null && !TextUtils.isEmpty(parseUrl.getPath()) && (split = parseUrl.getPath().replace("/", "").split("\\.")) != null && split.length > 1) {
            String str2 = split[0];
            try {
                if (!TextUtils.isEmpty(str2) && (h5APMTool = (H5APMTool) H5Utils.getProvider(H5APMTool.class.getName())) != null) {
                    return h5APMTool.decodeToPath(str2);
                }
            } catch (Exception e2) {
                H5Log.e("", (Throwable) e2);
            }
        }
        return str;
    }
}
