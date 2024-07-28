package com.alipay.mobile.nebulacore.manager;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class H5PluginManagerImpl implements H5PluginManager {
    public static final String TAG = "H5PluginManager";
    private final int TIME = 0;
    private Map<String, List<H5Plugin>> actionMap = new ConcurrentHashMap();
    private String clazzName;
    private H5CoreNode coreNode;
    private Set<H5Plugin> pluginSet = new HashSet();

    public void onInitialize(H5CoreNode h5CoreNode) {
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
    }

    public H5PluginManagerImpl(H5CoreNode h5CoreNode) {
        this.coreNode = h5CoreNode;
    }

    public synchronized boolean register(H5Plugin h5Plugin) {
        List list;
        if (h5Plugin == null) {
            H5Log.w(TAG, "invalid plugin parameter!");
            return false;
        } else if (this.pluginSet.contains(h5Plugin)) {
            H5Log.w(TAG, "plugin already registered!");
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            H5EventFilter h5EventFilter = new H5EventFilter();
            try {
                h5Plugin.onPrepare(h5EventFilter);
                Iterator<String> actionIterator = h5EventFilter.actionIterator();
                if (!actionIterator.hasNext()) {
                    H5Log.w(TAG, "empty filter");
                    return false;
                }
                try {
                    h5Plugin.onInitialize(this.coreNode);
                    this.pluginSet.add(h5Plugin);
                    while (actionIterator.hasNext()) {
                        String next = actionIterator.next();
                        if (TextUtils.isEmpty(next)) {
                            H5Log.w(TAG, "event can't be empty!");
                        } else {
                            if (!this.actionMap.containsKey(next)) {
                                list = new ArrayList();
                                this.actionMap.put(next, list);
                            } else {
                                list = this.actionMap.get(next);
                            }
                            list.add(h5Plugin);
                        }
                    }
                    if (Nebula.DEBUG) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0) {
                            H5Log.d(TAG, "Nebula cost time register plugin " + H5Utils.getClassName(h5Plugin) + " elapse " + currentTimeMillis2);
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    this.clazzName = H5Utils.getClassName(h5Plugin);
                    H5Log.e(TAG, this.clazzName + "  onInitialize exception.", th);
                    H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
                    if (h5LogProvider != null) {
                        String str = "";
                        if (this.coreNode instanceof H5Page) {
                            H5Page h5Page = (H5Page) this.coreNode;
                            str = "^appId=" + H5Utils.getString(h5Page.getParams(), "appId") + "^tinyApp=" + H5Utils.getBoolean(h5Page.getParams(), H5Param.isTinyApp, false);
                        }
                        h5LogProvider.log("H5_PLUGIN_EXCEPTION", (String) null, str, this.clazzName, Log.getStackTraceString(th), (String) null);
                    }
                    if (!Nebula.enableThrow()) {
                        return false;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                this.clazzName = H5Utils.getClassName(h5Plugin);
                H5Log.e(TAG, this.clazzName + "  onPrepare exception.", th2);
                return false;
            }
        }
    }

    public synchronized boolean unregister(H5Plugin h5Plugin) {
        if (h5Plugin == null) {
            H5Log.w(TAG, "invalid plugin parameter!");
            return false;
        } else if (!this.pluginSet.contains(h5Plugin)) {
            H5Log.w(TAG, "plugin not registered!");
            return false;
        } else {
            this.pluginSet.remove(h5Plugin);
            for (String next : this.actionMap.keySet()) {
                List list = this.actionMap.get(next);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (h5Plugin.equals((H5Plugin) it2.next())) {
                        it2.remove();
                    }
                }
                if (list.isEmpty()) {
                    this.actionMap.remove(next);
                }
            }
            if (Nebula.DEBUG) {
                this.clazzName = H5Utils.getClassName(h5Plugin);
                H5Log.d(TAG, "Nebula cost time unregister plugin " + this.clazzName);
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0115, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean interceptEvent(com.alipay.mobile.h5container.api.H5Event r19, com.alipay.mobile.h5container.api.H5BridgeContext r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            monitor-enter(r18)
            r3 = 0
            if (r2 != 0) goto L_0x0011
            java.lang.String r0 = "H5PluginManager"
            java.lang.String r2 = "invalid event!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0159 }
            monitor-exit(r18)
            return r3
        L_0x0011:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            java.lang.String r13 = r19.getAction()     // Catch:{ all -> 0x0159 }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "H5PluginManager"
            java.lang.String r2 = "invalid event name"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r2)     // Catch:{ all -> 0x0159 }
            monitor-exit(r18)
            return r3
        L_0x0028:
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5Plugin>> r0 = r1.actionMap     // Catch:{ all -> 0x0159 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x0159 }
            r14 = r0
            java.util.List r14 = (java.util.List) r14     // Catch:{ all -> 0x0159 }
            if (r14 == 0) goto L_0x0156
            boolean r0 = r14.isEmpty()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x003b
            goto L_0x0156
        L_0x003b:
            int r0 = r14.size()     // Catch:{ all -> 0x0159 }
            r15 = 1
            int r0 = r0 - r15
            r12 = r0
        L_0x0042:
            if (r12 < 0) goto L_0x0153
            java.lang.Object r0 = r14.get(r12)     // Catch:{ all -> 0x0159 }
            r11 = r0
            com.alipay.mobile.h5container.api.H5Plugin r11 = (com.alipay.mobile.h5container.api.H5Plugin) r11     // Catch:{ all -> 0x0159 }
            r10 = r20
            boolean r0 = r11.interceptEvent(r2, r10)     // Catch:{ all -> 0x0055 }
            r3 = r11
            r15 = r12
            goto L_0x00dc
        L_0x0055:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r11)     // Catch:{ all -> 0x0159 }
            java.lang.String r6 = "H5PluginManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r7.<init>()     // Catch:{ all -> 0x0159 }
            r7.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r8 = " interceptEvent exception."
            r7.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.e(r6, r7, r9)     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r6 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()     // Catch:{ all -> 0x0159 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r7 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0159 }
            java.lang.Object r6 = r6.getProvider(r7)     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.provider.H5LogProvider r6 = (com.alipay.mobile.nebula.provider.H5LogProvider) r6     // Catch:{ all -> 0x0159 }
            if (r6 == 0) goto L_0x00d1
            java.lang.String r7 = ""
            com.alipay.mobile.h5container.api.H5CoreNode r8 = r1.coreNode     // Catch:{ all -> 0x0159 }
            boolean r8 = r8 instanceof com.alipay.mobile.h5container.api.H5Page     // Catch:{ all -> 0x0159 }
            if (r8 == 0) goto L_0x00ba
            com.alipay.mobile.h5container.api.H5CoreNode r7 = r1.coreNode     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.h5container.api.H5Page r7 = (com.alipay.mobile.h5container.api.H5Page) r7     // Catch:{ all -> 0x0159 }
            android.os.Bundle r8 = r7.getParams()     // Catch:{ all -> 0x0159 }
            java.lang.String r15 = "appId"
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r8, (java.lang.String) r15)     // Catch:{ all -> 0x0159 }
            android.os.Bundle r7 = r7.getParams()     // Catch:{ all -> 0x0159 }
            java.lang.String r15 = "isTinyApp"
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r7, (java.lang.String) r15, (boolean) r3)     // Catch:{ all -> 0x0159 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "^appId="
            r15.<init>(r3)     // Catch:{ all -> 0x0159 }
            r15.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "^tinyApp="
            r15.append(r3)     // Catch:{ all -> 0x0159 }
            r15.append(r7)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r15.toString()     // Catch:{ all -> 0x0159 }
            goto L_0x00bb
        L_0x00ba:
            r3 = r7
        L_0x00bb:
            java.lang.String r7 = "H5_PLUGIN_EXCEPTION"
            java.lang.String r15 = android.util.Log.getStackTraceString(r9)     // Catch:{ all -> 0x0159 }
            r16 = 0
            r8 = r13
            r17 = r9
            r9 = r3
            r10 = r0
            r3 = r11
            r11 = r15
            r15 = r12
            r12 = r16
            r6.log(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0159 }
            goto L_0x00d5
        L_0x00d1:
            r17 = r9
            r3 = r11
            r15 = r12
        L_0x00d5:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.enableThrow()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0152
            r0 = 0
        L_0x00dc:
            r6 = 0
            if (r0 == 0) goto L_0x0117
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0114
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            long r8 = r8 - r4
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0114
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r2 = "H5PluginManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r4 = "Nebula cost time ["
            r3.<init>(r4)     // Catch:{ all -> 0x0159 }
            r3.append(r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r4 = "] intercepted by "
            r3.append(r4)     // Catch:{ all -> 0x0159 }
            r3.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = " elapse:"
            r3.append(r0)     // Catch:{ all -> 0x0159 }
            r3.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)     // Catch:{ all -> 0x0159 }
        L_0x0114:
            monitor-exit(r18)
            r8 = 1
            return r8
        L_0x0117:
            r8 = 1
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x014c
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            long r9 = r9 - r4
            int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x014c
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "H5PluginManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = "Nebula cost time ["
            r6.<init>(r7)     // Catch:{ all -> 0x0159 }
            r6.append(r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = "] intercept pass "
            r6.append(r7)     // Catch:{ all -> 0x0159 }
            r6.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = " elapse:"
            r6.append(r0)     // Catch:{ all -> 0x0159 }
            r6.append(r9)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)     // Catch:{ all -> 0x0159 }
        L_0x014c:
            int r12 = r15 + -1
            r3 = 0
            r15 = 1
            goto L_0x0042
        L_0x0152:
            throw r17     // Catch:{ all -> 0x0159 }
        L_0x0153:
            monitor-exit(r18)
            r2 = 0
            return r2
        L_0x0156:
            r2 = 0
            monitor-exit(r18)
            return r2
        L_0x0159:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.manager.H5PluginManagerImpl.interceptEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0115, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r19, com.alipay.mobile.h5container.api.H5BridgeContext r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            monitor-enter(r18)
            r3 = 0
            if (r2 != 0) goto L_0x0011
            java.lang.String r0 = "H5PluginManager"
            java.lang.String r2 = "invalid event!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0159 }
            monitor-exit(r18)
            return r3
        L_0x0011:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            java.lang.String r13 = r19.getAction()     // Catch:{ all -> 0x0159 }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "H5PluginManager"
            java.lang.String r2 = "invalid event name"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r2)     // Catch:{ all -> 0x0159 }
            monitor-exit(r18)
            return r3
        L_0x0028:
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5Plugin>> r0 = r1.actionMap     // Catch:{ all -> 0x0159 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x0159 }
            r14 = r0
            java.util.List r14 = (java.util.List) r14     // Catch:{ all -> 0x0159 }
            if (r14 == 0) goto L_0x0156
            boolean r0 = r14.isEmpty()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x003b
            goto L_0x0156
        L_0x003b:
            int r0 = r14.size()     // Catch:{ all -> 0x0159 }
            r15 = 1
            int r0 = r0 - r15
            r12 = r0
        L_0x0042:
            if (r12 < 0) goto L_0x0153
            java.lang.Object r0 = r14.get(r12)     // Catch:{ all -> 0x0159 }
            r11 = r0
            com.alipay.mobile.h5container.api.H5Plugin r11 = (com.alipay.mobile.h5container.api.H5Plugin) r11     // Catch:{ all -> 0x0159 }
            r10 = r20
            boolean r0 = r11.handleEvent(r2, r10)     // Catch:{ all -> 0x0055 }
            r3 = r11
            r15 = r12
            goto L_0x00dc
        L_0x0055:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r11)     // Catch:{ all -> 0x0159 }
            java.lang.String r6 = "H5PluginManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r7.<init>()     // Catch:{ all -> 0x0159 }
            r7.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r8 = " handleEvent exception."
            r7.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.e(r6, r7, r9)     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r6 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()     // Catch:{ all -> 0x0159 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r7 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0159 }
            java.lang.Object r6 = r6.getProvider(r7)     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.provider.H5LogProvider r6 = (com.alipay.mobile.nebula.provider.H5LogProvider) r6     // Catch:{ all -> 0x0159 }
            if (r6 == 0) goto L_0x00d1
            java.lang.String r7 = ""
            com.alipay.mobile.h5container.api.H5CoreNode r8 = r1.coreNode     // Catch:{ all -> 0x0159 }
            boolean r8 = r8 instanceof com.alipay.mobile.h5container.api.H5Page     // Catch:{ all -> 0x0159 }
            if (r8 == 0) goto L_0x00ba
            com.alipay.mobile.h5container.api.H5CoreNode r7 = r1.coreNode     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.h5container.api.H5Page r7 = (com.alipay.mobile.h5container.api.H5Page) r7     // Catch:{ all -> 0x0159 }
            android.os.Bundle r8 = r7.getParams()     // Catch:{ all -> 0x0159 }
            java.lang.String r15 = "appId"
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r8, (java.lang.String) r15)     // Catch:{ all -> 0x0159 }
            android.os.Bundle r7 = r7.getParams()     // Catch:{ all -> 0x0159 }
            java.lang.String r15 = "isTinyApp"
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r7, (java.lang.String) r15, (boolean) r3)     // Catch:{ all -> 0x0159 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "^appId="
            r15.<init>(r3)     // Catch:{ all -> 0x0159 }
            r15.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "^tinyApp="
            r15.append(r3)     // Catch:{ all -> 0x0159 }
            r15.append(r7)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r15.toString()     // Catch:{ all -> 0x0159 }
            goto L_0x00bb
        L_0x00ba:
            r3 = r7
        L_0x00bb:
            java.lang.String r7 = "H5_PLUGIN_EXCEPTION"
            java.lang.String r15 = android.util.Log.getStackTraceString(r9)     // Catch:{ all -> 0x0159 }
            r16 = 0
            r8 = r13
            r17 = r9
            r9 = r3
            r10 = r0
            r3 = r11
            r11 = r15
            r15 = r12
            r12 = r16
            r6.log(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0159 }
            goto L_0x00d5
        L_0x00d1:
            r17 = r9
            r3 = r11
            r15 = r12
        L_0x00d5:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.enableThrow()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0152
            r0 = 0
        L_0x00dc:
            r6 = 0
            if (r0 == 0) goto L_0x0117
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0114
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            long r8 = r8 - r4
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0114
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r2 = "H5PluginManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r4 = "Nebula cost time ["
            r3.<init>(r4)     // Catch:{ all -> 0x0159 }
            r3.append(r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r4 = "] handled by "
            r3.append(r4)     // Catch:{ all -> 0x0159 }
            r3.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = " elapse:"
            r3.append(r0)     // Catch:{ all -> 0x0159 }
            r3.append(r8)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)     // Catch:{ all -> 0x0159 }
        L_0x0114:
            monitor-exit(r18)
            r8 = 1
            return r8
        L_0x0117:
            r8 = 1
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x014c
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            long r9 = r9 - r4
            int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x014c
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getClassName(r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "H5PluginManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = "Nebula cost time ["
            r6.<init>(r7)     // Catch:{ all -> 0x0159 }
            r6.append(r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r7 = "] handle pass "
            r6.append(r7)     // Catch:{ all -> 0x0159 }
            r6.append(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = " elapse:"
            r6.append(r0)     // Catch:{ all -> 0x0159 }
            r6.append(r9)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0159 }
            com.alipay.mobile.nebula.util.H5Log.d(r3, r0)     // Catch:{ all -> 0x0159 }
        L_0x014c:
            int r12 = r15 + -1
            r3 = 0
            r15 = 1
            goto L_0x0042
        L_0x0152:
            throw r17     // Catch:{ all -> 0x0159 }
        L_0x0153:
            monitor-exit(r18)
            r2 = 0
            return r2
        L_0x0156:
            r2 = 0
            monitor-exit(r18)
            return r2
        L_0x0159:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.manager.H5PluginManagerImpl.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    public synchronized void onRelease() {
        for (H5Plugin next : this.pluginSet) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                next.onRelease();
                if (Nebula.DEBUG) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 0) {
                        H5Log.d(TAG, "Nebula cost time release plugin " + H5Utils.getClassName(next) + " elapse:" + currentTimeMillis2);
                    }
                }
            } catch (Throwable th) {
                String className = H5Utils.getClassName(next);
                H5Log.e(TAG, className + " onRelease exception.", th);
                H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
                if (h5LogProvider != null) {
                    String str = "";
                    if (this.coreNode instanceof H5Page) {
                        H5Page h5Page = (H5Page) this.coreNode;
                        str = "^appId=" + H5Utils.getString(h5Page.getParams(), "appId") + "^tinyApp=" + H5Utils.getBoolean(h5Page.getParams(), H5Param.isTinyApp, false);
                    }
                    h5LogProvider.log("H5_PLUGIN_EXCEPTION", (String) null, str, className, Log.getStackTraceString(th), (String) null);
                }
                if (Nebula.enableThrow()) {
                    throw th;
                }
            }
        }
        this.pluginSet.clear();
        this.actionMap.clear();
    }

    public boolean register(List<H5Plugin> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean z = true;
        for (H5Plugin register : list) {
            z |= register(register);
        }
        return z;
    }

    public boolean unregister(List<H5Plugin> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean z = true;
        for (H5Plugin unregister : list) {
            z |= unregister(unregister);
        }
        return z;
    }

    public synchronized boolean canHandle(String str) {
        return !TextUtils.isEmpty(str) && this.actionMap.containsKey(str);
    }
}
