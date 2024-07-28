package com.alipay.iap.android.webapp.sdk.plugin;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.List;

public abstract class BaseUrlPlugin extends H5SimplePlugin {
    private static final String TAG = "BaseUrlPlugin";

    public abstract List<String> getBlackListConfig();

    public abstract List<String> getWhiteListConfig();

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String string = H5Utils.getString(h5Event.getParam(), "url");
        "interceptEvent url=".concat(String.valueOf(string));
        c.e();
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(Uri.parse(string).getScheme())) {
                return false;
            }
        } catch (Exception e2) {
            new StringBuilder("interceptEvent ").append(e2.getMessage());
            c.i();
        }
        if (isNotInWhiteList(string)) {
            c.e();
            return true;
        } else if (!isInBlackList(string)) {
            return false;
        } else {
            c.e();
            return true;
        }
    }

    private boolean isNotInWhiteList(String str) {
        List<String> whiteListConfig = getWhiteListConfig();
        if (whiteListConfig == null || whiteListConfig.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < whiteListConfig.size(); i2++) {
            if (KitUtils.isDomainMatch(whiteListConfig.get(i2), str)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInBlackList(String str) {
        List<String> blackListConfig = getBlackListConfig();
        if (!(blackListConfig == null || blackListConfig.size() == 0)) {
            for (int i2 = 0; i2 < blackListConfig.size(); i2++) {
                if (KitUtils.isDomainMatch(blackListConfig.get(i2), str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
