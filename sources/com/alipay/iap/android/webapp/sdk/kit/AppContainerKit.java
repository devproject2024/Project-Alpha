package com.alipay.iap.android.webapp.sdk.kit;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.app.WebAppListener;
import com.alipay.iap.android.webapp.sdk.kit.impl.AppContainerKitImpl;
import com.alipay.mobile.h5container.api.H5Plugin;
import java.util.List;
import java.util.Map;

public abstract class AppContainerKit {
    public abstract void configCommonResource(Map<String, SubAppConfig> map);

    public abstract void configSubapps(Map<String, SubAppConfig> map, List<String> list);

    public abstract void configSubappsOnly(Map<String, SubAppConfig> map);

    public abstract Application getApplication();

    public abstract String getOnlineAppId(String str);

    public abstract List<String> getResourceAppIds();

    public abstract void initialize(Application application, AppContainerKitConfig appContainerKitConfig);

    public abstract void openApp(Context context, String str);

    public abstract void openUrl(Context context, String str);

    public abstract void openUrl(Context context, String str, Bundle bundle, WebAppListener webAppListener);

    public abstract void registerPlugin(H5Plugin h5Plugin);

    public void release() {
    }

    public abstract void setProvider(String str, Object obj);

    public abstract void startContainerActivity(Context context, Bundle bundle, WebAppListener webAppListener);

    public abstract void unRegisterPlugin(H5Plugin h5Plugin);

    public static AppContainerKit getInstance() {
        return AppContainerKitImpl.getInstance();
    }

    public void startContainerActivity(Context context, Bundle bundle) {
        startContainerActivity(context, bundle, (WebAppListener) null);
    }

    public void openUrl(Context context, String str, Bundle bundle) {
        openUrl(context, str, bundle, (WebAppListener) null);
    }
}
