package com.alipay.mobile.nebulaappcenter.service;

import com.alipay.mobile.h5container.api.H5BaseService;
import com.alipay.mobile.h5container.api.H5PreSetPkgInfo;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import java.io.InputStream;
import java.util.List;

public abstract class NebulaAppCenterService extends H5BaseService {
    public abstract void clearAppAmrPackage();

    public abstract void clearAppUnzipPackage(long j);

    public abstract H5AppDBService getAppDBService();

    public abstract H5BaseApp getH5App();

    public abstract String getSDKVersion();

    public abstract void loadPresetApp(List<H5PreSetPkgInfo> list);

    public abstract void loadPresetAppList(InputStream inputStream);

    public abstract void loadPresetAppNow(List<H5PreSetPkgInfo> list, H5LoadPresetListen h5LoadPresetListen);

    public abstract void setUpInfo(AppInfo appInfo, boolean z);

    public abstract void setUpInfo(AppInfo appInfo, boolean z, boolean z2);

    public abstract void setUpInfo(AppInfo appInfo, boolean z, boolean z2, boolean z3);

    public abstract void setUpInfo(AppRes appRes, boolean z);

    public abstract void setUpInfo(AppRes appRes, boolean z, boolean z2);

    public abstract void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3);

    public abstract void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3, String str);
}
