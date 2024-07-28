package com.alipay.mobile.nebulacore.tabbar;

public class H5SessionTabObserver {
    public static final String ENTRY_NAME = "tabBar.json";
    private volatile String data;
    private volatile H5SessionTabListener listener;

    public interface H5SessionTabListener {
        void onDataParsed(String str);
    }

    public synchronized H5SessionTabListener setData(String str) {
        this.data = str;
        return this.listener;
    }

    public synchronized String getData(H5SessionTabListener h5SessionTabListener) {
        this.listener = h5SessionTabListener;
        return this.data;
    }

    public void clear() {
        this.listener = null;
        this.data = null;
    }
}
