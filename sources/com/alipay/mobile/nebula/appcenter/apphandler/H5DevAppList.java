package com.alipay.mobile.nebula.appcenter.apphandler;

import android.text.TextUtils;
import com.alipay.mobile.a.a;
import com.alipay.mobile.a.b;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.process.H5IpcServer;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class H5DevAppList {
    private static final String TAG = "H5DevAppList";
    public static H5InstallAppAdvice h5InstallAppAdvice;
    private static H5DevAppList instance;
    private static Map<String, Boolean> tinyProcessMap = new ConcurrentHashMap();
    private Map<String, H5DevAppInfo> devlist = new ConcurrentHashMap();
    private boolean useDevRpc = false;

    private H5DevAppList() {
        Set<String> commonResourceAppList;
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null && (commonResourceAppList = h5AppCenterPresetProvider.getCommonResourceAppList()) != null && !commonResourceAppList.isEmpty()) {
            for (String put : commonResourceAppList) {
                tinyProcessMap.put(put, Boolean.FALSE);
            }
        }
    }

    public static synchronized H5DevAppList getInstance() {
        H5DevAppList h5DevAppList;
        synchronized (H5DevAppList.class) {
            if (instance == null) {
                instance = new H5DevAppList();
            }
            h5DevAppList = instance;
        }
        return h5DevAppList;
    }

    public synchronized void add(String str, H5DevAppInfo h5DevAppInfo) {
        if (str != null) {
            this.devlist.put(str, h5DevAppInfo);
        }
    }

    public synchronized void remove(String str) {
        if (str != null) {
            this.devlist.remove(str);
        }
    }

    public synchronized H5DevAppInfo getDevInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.devlist.get(str);
    }

    public synchronized String getDevInfoNbsv(String str) {
        if (H5Utils.isInTinyProcess()) {
            H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
            if (h5EventHandlerService != null) {
                try {
                    H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                    if (h5IpcServer != null) {
                        return h5IpcServer.getDevNbsv(str);
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            H5DevAppInfo h5DevAppInfo = this.devlist.get(str);
            if (h5DevAppInfo == null) {
                return null;
            }
            return h5DevAppInfo.nbsv;
        }
    }

    public synchronized boolean contains(String str) {
        if (H5Utils.isInTinyProcess()) {
            Boolean bool = tinyProcessMap.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
            if (h5EventHandlerService != null) {
                try {
                    H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                    if (h5IpcServer != null) {
                        boolean containDevAppId = h5IpcServer.containDevAppId(str);
                        tinyProcessMap.put(str, Boolean.valueOf(containDevAppId));
                        return containDevAppId;
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        } else if (H5Utils.isDebuggable(H5Utils.getContext()) && H5DevConfig.getBooleanConfig(H5DevConfig.h5_read_use_dev_db, false)) {
            return true;
        } else {
            if (str == null) {
                return false;
            }
            return this.devlist.containsKey(str);
        }
        return false;
    }

    public void setUseDevMode(String str, boolean z) {
        if (z) {
            this.useDevRpc = true;
            registerInstallAdvice();
        } else {
            remove(str);
            if (this.devlist.isEmpty()) {
                this.useDevRpc = false;
                unRegisterInstallAdvice();
            } else {
                String str2 = "";
                for (String str3 : this.devlist.keySet()) {
                    str2 = str2 + " " + str3;
                }
                H5Log.d(TAG, "dev list is not empty still exist ".concat(String.valueOf(str2)));
            }
        }
        if (H5Utils.isInTinyProcess() && !z) {
            tinyProcessMap.remove(str);
        }
    }

    public boolean getUseDevMode() {
        if (!H5Utils.isDebuggable(H5Utils.getContext()) || !H5DevConfig.getBooleanConfig(H5DevConfig.h5_read_use_dev_app_config, false)) {
            return this.useDevRpc && H5InstallAppAdvice.enableUseDevRPC();
        }
        return true;
    }

    public void registerInstallAdvice() {
        if (!H5InstallAppAdvice.enableHandleInstallApp()) {
            unRegisterInstallAdvice();
        } else if (h5InstallAppAdvice == null) {
            h5InstallAppAdvice = new H5InstallAppAdvice();
            b.a().a("void com.alipay.mobile.core.impl.MicroApplicationContextImpl.installApp(String, String, Bundle, FragmentActivity)", h5InstallAppAdvice, true);
        }
    }

    public void unRegisterInstallAdvice() {
        if (h5InstallAppAdvice != null) {
            b.a().a((a) h5InstallAppAdvice);
        }
        h5InstallAppAdvice = null;
    }
}
