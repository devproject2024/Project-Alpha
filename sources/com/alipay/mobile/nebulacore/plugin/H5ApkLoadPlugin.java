package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.util.H5DomainUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class H5ApkLoadPlugin extends H5SimplePlugin {
    public static final String TAG = "H5ApkLoadPlugin";
    private H5Page h5Page;

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.h5Page = (H5Page) h5CoreNode;
    }

    public void onRelease() {
        this.h5Page = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL.equals(h5Event.getAction())) {
            String string = H5Utils.getString(h5Event.getParam(), "url");
            String path = H5UrlHelper.getPath(string);
            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".apk")) {
                long currentTimeMillis = System.currentTimeMillis() - this.h5Page.getLastTouch();
                H5Log.d(TAG, "apk file url ".concat(String.valueOf(string)));
                int i2 = H5Utils.getInt(h5Event.getParam(), "historySize", 0);
                H5Log.d(TAG, "historySize " + i2 + " delta " + currentTimeMillis);
                if (currentTimeMillis < 400) {
                    H5Log.d(TAG, "user trigger apk download delta ".concat(String.valueOf(currentTimeMillis)));
                    return false;
                } else if (i2 <= 0) {
                    H5Log.d(TAG, "skip first apk download url");
                    return false;
                } else {
                    H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
                    if ((h5Service != null && h5Service.isAliDomain(string)) || H5DomainUtil.isSomeDomainInternal(H5DomainUtil.getNewDomainSuffix(string), H5Environment.getConfig("h5_302_download_apk_whiteList"))) {
                        return false;
                    }
                    loadSecLoadPage(string);
                    return true;
                }
            }
        }
        return false;
    }

    private void loadSecLoadPage(String str) {
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_loadSecPage");
        if (TextUtils.isEmpty(configWithProcessCache) || !"no".equalsIgnoreCase(configWithProcessCache)) {
            try {
                this.h5Page.loadUrl("https://ds.alipay.com/error/securityLink.htm?url=" + URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException unused) {
                H5Log.d(TAG, "Error: Unsupported encoding exception on ".concat(String.valueOf(str)));
            }
        }
    }
}
