package com.alipay.mobile.nebula.tiny;

import android.text.TextUtils;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.process.H5IpcServer;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5TinyFallBackData {
    private static final String TAG = "H5TinyFallBackData";
    public static Map<String, Map<String, byte[]>> apiPermissionByte = new ConcurrentHashMap();
    public static Map<String, Map<String, byte[]>> appConfigByte = new ConcurrentHashMap();

    public static byte[] removeApiPermission(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (H5Utils.isInTinyProcess()) {
                H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
                if (h5EventHandlerService != null) {
                    try {
                        H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                        if (h5IpcServer != null) {
                            String removeApiPermission = h5IpcServer.removeApiPermission(str, str2);
                            if (!TextUtils.isEmpty(removeApiPermission)) {
                                return removeApiPermission.getBytes();
                            }
                        }
                    } catch (Throwable th) {
                        H5Log.e(TAG, th);
                    }
                }
            } else {
                Map remove = apiPermissionByte.remove(str);
                if (remove != null) {
                    return (byte[]) remove.get(str2);
                }
            }
        }
        return null;
    }

    public static byte[] removeAppConfigByte(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (H5Utils.isInTinyProcess()) {
                H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
                if (h5EventHandlerService != null) {
                    try {
                        H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                        if (h5IpcServer != null) {
                            String removeAppConfigByte = h5IpcServer.removeAppConfigByte(str, str2);
                            if (!TextUtils.isEmpty(removeAppConfigByte)) {
                                return removeAppConfigByte.getBytes();
                            }
                        }
                    } catch (Throwable th) {
                        H5Log.e(TAG, th);
                    }
                }
            } else {
                Map remove = appConfigByte.remove(str);
                if (remove != null) {
                    return (byte[]) remove.get(str2);
                }
            }
        }
        return null;
    }
}
