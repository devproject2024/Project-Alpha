package com.alipay.iap.android.webapp.sdk.provider;

import android.text.TextUtils;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5AppUrlMapProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import java.io.File;

public class UrlMapProvider implements H5AppUrlMapProvider {
    private static final String TAG = "UrlMapProvider";

    public String mapUrl(String str, String str2, String str3) {
        AppInfo appInfo;
        "load response mapUrl url = ".concat(String.valueOf(str));
        c.e();
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String extension = H5FileUtil.getExtension(KitUtils.getFileName(str));
        if ((!TextUtils.isEmpty(extension) && !"html".equalsIgnoreCase(extension)) || (appInfo = ((H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName())).getAppInfo(str2, str3)) == null) {
            return str;
        }
        String extendRemoteURLPrefix = AppManagerUtil.getExtendRemoteURLPrefix(appInfo);
        "load response remoteURLPrefix = ".concat(String.valueOf(extendRemoteURLPrefix));
        c.e();
        if (TextUtils.isEmpty(extendRemoteURLPrefix) || !str.startsWith(extendRemoteURLPrefix)) {
            return str;
        }
        String type = AppManagerUtil.getType(appInfo);
        "load response type = ".concat(String.valueOf(type));
        c.e();
        if (!SubAppConfig.AppType.SPA.equalsIgnoreCase(type)) {
            return str;
        }
        String index = AppManagerUtil.getIndex(appInfo);
        "load response index = ".concat(String.valueOf(index));
        c.e();
        if (TextUtils.isEmpty(index)) {
            return str;
        }
        if (index.startsWith("/")) {
            return appInfo.vhost + index;
        } else if (index.startsWith("http")) {
            return index;
        } else {
            return appInfo.vhost + File.separator + index;
        }
    }
}
