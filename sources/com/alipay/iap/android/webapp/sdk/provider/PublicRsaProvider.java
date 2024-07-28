package com.alipay.iap.android.webapp.sdk.provider;

import com.alipay.iap.android.webapp.sdk.kit.impl.AppContainerKitImpl;
import com.alipay.mobile.nebula.provider.H5PublicRsaProvider;

public class PublicRsaProvider implements H5PublicRsaProvider {
    public String getPublicRsa() {
        return AppContainerKitImpl.getInstance().getKitConfig().appPublicKey;
    }
}
