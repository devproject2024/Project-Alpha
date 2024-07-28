package com.alipay.mobile.nebula.appcenter.rpcblacklist;

import java.util.HashMap;
import java.util.Map;

public class H5RpcBlackList {
    private static H5RpcBlackList instance;
    private Map<String, H5RpcUpdateResponse> blackList = new HashMap();

    private H5RpcBlackList() {
    }

    public static synchronized H5RpcBlackList getInstance() {
        H5RpcBlackList h5RpcBlackList;
        synchronized (H5RpcBlackList.class) {
            if (instance == null) {
                instance = new H5RpcBlackList();
            }
            h5RpcBlackList = instance;
        }
        return h5RpcBlackList;
    }

    public synchronized void add(String str, H5RpcUpdateResponse h5RpcUpdateResponse) {
        if (str != null) {
            this.blackList.put(str, h5RpcUpdateResponse);
        }
    }

    public synchronized void remove(String str) {
        if (str != null) {
            this.blackList.remove(str);
        }
    }

    public synchronized boolean contains(String str) {
        if (str == null) {
            return false;
        }
        return this.blackList.containsKey(str);
    }
}
