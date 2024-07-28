package com.alipay.iap.android.webapp.sdk.provider;

import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.kit.impl.AppContainerKitImpl;
import com.alipay.mobile.nebula.provider.H5UaProvider;

public class UaProvider implements H5UaProvider {
    public String getUa(String str) {
        String str2 = AppContainerKitImpl.getInstance().getKitConfig().appendedUserAgent;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + " " + str2;
    }
}
