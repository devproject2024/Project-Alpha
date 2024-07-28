package com.alipay.mobile.nebulaappcenter;

import android.os.Bundle;
import com.alipay.mobile.h5container.api.H5PreSetPkgInfo;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebulaappcenter.service.NebulaAppCenter;
import java.io.InputStream;
import java.util.List;

public class H5AppCenterServiceImpl extends H5AppCenterService {
    public void onCreate(Bundle bundle) {
        NebulaAppCenter.getService().onCreate(bundle);
    }

    public void loadPresetAppList(InputStream inputStream) {
        NebulaAppCenter.getService().loadPresetAppList(inputStream);
    }

    public void onDestroy(Bundle bundle) {
        NebulaAppCenter.getService().onDestroy(bundle);
    }

    public H5AppDBService getAppDBService() {
        return NebulaAppCenter.getService().getAppDBService();
    }

    public H5BaseApp getH5App() {
        return NebulaAppCenter.getService().getH5App();
    }

    public String getSDKVersion() {
        return NebulaAppCenter.getService().getSDKVersion();
    }

    public void loadPresetApp(List<H5PreSetPkgInfo> list) {
        NebulaAppCenter.getService().loadPresetApp(list);
    }

    public void loadPresetAppNow(List<H5PreSetPkgInfo> list, H5LoadPresetListen h5LoadPresetListen) {
        NebulaAppCenter.getService().loadPresetAppNow(list, h5LoadPresetListen);
    }

    public void clearAppAmrPackage() {
        NebulaAppCenter.getService().clearAppAmrPackage();
    }

    public void clearAppUnzipPackage(long j) {
        NebulaAppCenter.getService().clearAppUnzipPackage(j);
    }

    public void setUpInfo(AppRes appRes, boolean z) {
        NebulaAppCenter.getService().setUpInfo(appRes, z);
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2) {
        NebulaAppCenter.getService().setUpInfo(appRes, z, z2);
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3) {
        NebulaAppCenter.getService().setUpInfo(appRes, z, z2, z3);
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3, String str) {
        NebulaAppCenter.getService().setUpInfo(appRes, z, z2, z3, str);
    }

    public synchronized void setUpInfo(AppInfo appInfo, boolean z) {
        NebulaAppCenter.getService().setUpInfo(appInfo, z);
    }

    public void setUpInfo(AppInfo appInfo, boolean z, boolean z2) {
        NebulaAppCenter.getService().setUpInfo(appInfo, z, z2);
    }

    public void setUpInfo(AppInfo appInfo, boolean z, boolean z2, boolean z3) {
        NebulaAppCenter.getService().setUpInfo(appInfo, z, z2, z3);
    }
}
