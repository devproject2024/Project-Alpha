package com.alipay.mobile.nebulacore.config;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.config.H5PluginConfig;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5PluginProxy extends H5SimplePlugin {
    public static final String TAG = "H5PluginProxy";
    private H5PluginManager pluginManager;
    private Map<String, List<ProxyInfo>> pluginMap = new ConcurrentHashMap();

    public H5PluginProxy(List<H5PluginConfig> list, H5PluginManager h5PluginManager) {
        List list2;
        this.pluginManager = h5PluginManager;
        if (list != null && !list.isEmpty()) {
            for (H5PluginConfig next : list) {
                if (next.lazyInit) {
                    ProxyInfo proxyInfo = new ProxyInfo();
                    proxyInfo.registered = false;
                    proxyInfo.plugin = null;
                    proxyInfo.pluginInfo = next;
                    for (String next2 : next.eventList) {
                        if (!this.pluginMap.containsKey(next2)) {
                            list2 = new ArrayList();
                            this.pluginMap.put(next2, list2);
                        } else {
                            list2 = this.pluginMap.get(next2);
                        }
                        list2.add(proxyInfo);
                    }
                } else {
                    initPlugin(next, (H5Event) null);
                }
            }
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        for (String addAction : this.pluginMap.keySet()) {
            h5EventFilter.addAction(addAction);
        }
    }

    public void onRelease() {
        this.pluginMap.clear();
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        boolean z;
        if (h5Event == null) {
            H5Log.e(TAG, "invalid event!");
            return false;
        }
        String action = h5Event.getAction();
        if (TextUtils.isEmpty(action)) {
            H5Log.w(TAG, "invalid event name");
            return false;
        }
        List list = this.pluginMap.get(action);
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ProxyInfo proxyInfo = (ProxyInfo) list.get(size);
                if (proxyInfo.plugin == null || !proxyInfo.registered) {
                    if (proxyInfo.plugin == null) {
                        proxyInfo.plugin = initPlugin(proxyInfo.pluginInfo, h5Event);
                    }
                    if (proxyInfo.plugin != null) {
                        H5Log.d(TAG, "[" + action + "] intercept pass " + proxyInfo.pluginInfo.className);
                        z = proxyInfo.plugin.interceptEvent(h5Event, h5BridgeContext);
                        proxyInfo.registered = z;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return z;
                    }
                }
            }
        }
        return false;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        boolean z;
        if (h5Event == null) {
            H5Log.e(TAG, "invalid event!");
            return false;
        }
        String action = h5Event.getAction();
        if (TextUtils.isEmpty(action)) {
            H5Log.w(TAG, "invalid event name");
            return false;
        }
        List list = this.pluginMap.get(action);
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ProxyInfo proxyInfo = (ProxyInfo) list.get(size);
                if (proxyInfo.plugin == null || !proxyInfo.registered) {
                    if (proxyInfo.plugin == null) {
                        proxyInfo.plugin = initPlugin(proxyInfo.pluginInfo, h5Event);
                    }
                    if (proxyInfo.plugin != null) {
                        H5Log.d(TAG, "[" + action + "] handle pass " + proxyInfo.pluginInfo.className);
                        z = proxyInfo.plugin.handleEvent(h5Event, h5BridgeContext);
                        proxyInfo.registered = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private H5Plugin initPlugin(H5PluginConfig h5PluginConfig, H5Event h5Event) {
        H5Plugin h5Plugin;
        long currentTimeMillis = System.currentTimeMillis();
        String str = h5PluginConfig.bundleName;
        String str2 = h5PluginConfig.className;
        if (h5Event != null && !TextUtils.isEmpty(h5Event.getId()) && h5Event.getId().startsWith("native_") && H5Utils.isInTinyProcess() && !TextUtils.isEmpty(str)) {
            if (str.contains("nebula") || str.contains("liteprocess") || str.contains("tinyappservice")) {
                H5Log.d(TAG, "in tinyProcess event " + h5Event.getAction() + " " + str + "  can to load class ");
            } else {
                H5Log.d(TAG, "in tinyProcess event " + h5Event.getAction() + " " + str + " is not to load class ");
                return null;
            }
        }
        Class<?> cls = H5Environment.getClass(str, str2);
        if (cls == null) {
            return null;
        }
        try {
            if (!H5Plugin.class.isAssignableFrom(cls) || (h5Plugin = (H5Plugin) cls.newInstance()) == null) {
                return null;
            }
            try {
                H5Log.d(TAG, "register ext plugin " + str2 + " elapse " + (System.currentTimeMillis() - currentTimeMillis));
                this.pluginManager.register(h5Plugin);
            } catch (Throwable th) {
                th = th;
            }
            return h5Plugin;
        } catch (Throwable th2) {
            th = th2;
            h5Plugin = null;
            H5Log.e(TAG, "failed to initialize plugin ".concat(String.valueOf(str2)), th);
            H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log(TAG, (String) null, (String) null, (String) null, (String) null, "load plugin fail ^className=" + str2 + "^exception=" + th);
            }
            return h5Plugin;
        }
    }

    class ProxyInfo {
        public H5Plugin plugin;
        public H5PluginConfig pluginInfo;
        public boolean registered;

        ProxyInfo() {
        }
    }
}
