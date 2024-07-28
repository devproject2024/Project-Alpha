package com.alipay.iap.android.webapp.sdk.provider;

import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.mobile.nebula.appcenter.H5PresetPkg;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PresetProvider implements H5AppCenterPresetProvider {
    public Set<String> getEnableDegradeApp() {
        return null;
    }

    public H5PresetPkg getH5PresetPkg() {
        return null;
    }

    public InputStream getPresetAppInfo() {
        return null;
    }

    public InputStream getPresetAppInfoObject() {
        return null;
    }

    public String getTinyCommonApp() {
        return null;
    }

    public Set<String> getCommonResourceAppList() {
        HashSet hashSet = new HashSet();
        List<String> resourceAppIds = AppContainerKit.getInstance().getResourceAppIds();
        if (resourceAppIds != null) {
            hashSet.addAll(resourceAppIds);
        }
        return hashSet;
    }
}
