package com.alipay.mobile.nebulacore.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Listener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5Scenario;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.appcenter.model.H5Refer;
import com.alipay.mobile.nebula.provider.H5PreRpcProvider;
import com.alipay.mobile.nebula.startParam.H5AppStartParam;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.config.H5PluginConfigManager;
import com.alipay.mobile.nebulacore.data.H5MemData;
import com.alipay.mobile.nebulacore.plugin.H5ScreenPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SessionPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SnapshotPlugin;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabBar;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class H5SessionImpl extends H5CoreTarget implements H5Session {
    private static final String BROADCAST_HIDE_PAGE = "com.alipay.mobile.h5container.hidePage";
    private static final String BROADCAST_PAGE_CLOSE = "com.alipay.mobile.h5container.pageClose";
    private static final String BROADCAST_SHOW_PAGE = "com.alipay.mobile.h5container.showPage";
    public static final String TAG = "H5Session";
    private boolean exited = false;
    private H5Scenario h5Scenario;
    private H5SessionTabBar h5SessionTabBar;
    private H5SessionTabManager h5SessionTabManager;
    private H5SessionTabObserver h5SessionTabObserver;
    private List<H5Listener> listener = new LinkedList();
    private Stack<H5Page> pages = new Stack<>();
    private Bundle params;
    private H5ContentProvider provider;
    private String serviceWorkerId;
    private String sessionId;
    private final long sessionTag;

    public H5SessionImpl() {
        H5Log.d(TAG, "nebulasessiontracker newSession @" + hashCode());
        this.h5Data = new H5MemData();
        initPlugins();
        if (Nebula.getH5LogHandler() != null) {
            H5Refer.referUrl = Nebula.getH5LogHandler().getContextParam("refViewID");
        }
        this.h5SessionTabManager = new H5SessionTabManager();
        this.h5SessionTabObserver = new H5SessionTabObserver();
        this.sessionTag = new Random(System.currentTimeMillis()).nextLong();
    }

    public long getSessionTag() {
        return this.sessionTag;
    }

    private void initPlugins() {
        H5PluginManager pluginManager = getPluginManager();
        pluginManager.register((H5Plugin) new H5SessionPlugin(this));
        pluginManager.register((H5Plugin) new H5ScreenPlugin());
        pluginManager.register((H5Plugin) new H5SnapshotPlugin(this));
        this.h5SessionTabBar = new H5SessionTabBar(this);
        pluginManager.register((H5Plugin) this.h5SessionTabBar);
        H5Plugin createPlugin = H5PluginConfigManager.getInstance().createPlugin("session", pluginManager);
        if (createPlugin != null) {
            pluginManager.register(createPlugin);
        }
    }

    public String getId() {
        return this.sessionId;
    }

    public void setId(String str) {
        this.sessionId = str;
        H5Log.d(TAG, "nebulasessiontracker newSession setId " + str + " @" + hashCode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010e, code lost:
        if (r6.pages.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0110, code lost:
        setPageEnableFallbackUrl(r6.pages.peek());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean addPage(final com.alipay.mobile.h5container.api.H5Page r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r1 = r6.pages
            monitor-enter(r1)
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r2 = r6.pages     // Catch:{ all -> 0x011d }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x002c
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl r3 = new com.alipay.mobile.nebulacore.core.H5ContentProviderImpl     // Catch:{ all -> 0x011d }
            r3.<init>(r7)     // Catch:{ all -> 0x011d }
            r6.provider = r3     // Catch:{ all -> 0x011d }
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r3 = r6.listener     // Catch:{ all -> 0x011d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x011d }
        L_0x001c:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x002c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.h5container.api.H5Listener r4 = (com.alipay.mobile.h5container.api.H5Listener) r4     // Catch:{ all -> 0x011d }
            r4.onSessionCreated(r6)     // Catch:{ all -> 0x011d }
            goto L_0x001c
        L_0x002c:
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r3 = r6.pages     // Catch:{ all -> 0x011d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x011d }
        L_0x0032:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x0046
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.h5container.api.H5Page r4 = (com.alipay.mobile.h5container.api.H5Page) r4     // Catch:{ all -> 0x011d }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x011d }
            if (r4 == 0) goto L_0x0032
            monitor-exit(r1)     // Catch:{ all -> 0x011d }
            return r0
        L_0x0046:
            r7.setParent(r6)     // Catch:{ all -> 0x011d }
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r0 = r6.pages     // Catch:{ all -> 0x011d }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x011d }
            if (r0 != 0) goto L_0x006e
            java.lang.String r0 = "com.alipay.mobile.h5container.hidePage"
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r3 = r6.pages     // Catch:{ all -> 0x011d }
            java.lang.Object r3 = r3.peek()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.h5container.api.H5Page r3 = (com.alipay.mobile.h5container.api.H5Page) r3     // Catch:{ all -> 0x011d }
            java.lang.String r3 = r3.getTitle()     // Catch:{ all -> 0x011d }
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r4 = r6.pages     // Catch:{ all -> 0x011d }
            java.lang.Object r4 = r4.peek()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.h5container.api.H5Page r4 = (com.alipay.mobile.h5container.api.H5Page) r4     // Catch:{ all -> 0x011d }
            java.lang.String r4 = r4.getUrl()     // Catch:{ all -> 0x011d }
            r6.sendBroadCast(r7, r0, r3, r4)     // Catch:{ all -> 0x011d }
        L_0x006e:
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r0 = r6.pages     // Catch:{ all -> 0x011d }
            r0.add(r7)     // Catch:{ all -> 0x011d }
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r6.listener     // Catch:{ all -> 0x011d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x011d }
        L_0x0079:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x011d }
            if (r3 == 0) goto L_0x0089
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.h5container.api.H5Listener r3 = (com.alipay.mobile.h5container.api.H5Listener) r3     // Catch:{ all -> 0x011d }
            r3.onPageCreated(r7)     // Catch:{ all -> 0x011d }
            goto L_0x0079
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            java.util.concurrent.Executor r0 = com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory.getSingleThreadExecutor()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.nebulacore.core.H5SessionImpl$1 r2 = new com.alipay.mobile.nebulacore.core.H5SessionImpl$1     // Catch:{ all -> 0x011d }
            r2.<init>(r7)     // Catch:{ all -> 0x011d }
            r0.execute(r2)     // Catch:{ all -> 0x011d }
        L_0x0097:
            com.alipay.mobile.h5container.api.H5PageData r0 = r7.getPageData()     // Catch:{ all -> 0x011d }
            com.alipay.mobile.nebula.provider.H5LogProvider r2 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x0107
            com.alipay.mobile.nebula.provider.H5LogProvider r2 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()     // Catch:{ all -> 0x011d }
            java.lang.String r3 = "refViewID"
            java.lang.String r2 = r2.getContextParam(r3)     // Catch:{ all -> 0x011d }
            com.alipay.mobile.nebula.provider.H5LogProvider r3 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()     // Catch:{ all -> 0x011d }
            java.lang.String r4 = "viewID"
            java.lang.String r3 = r3.getContextParam(r4)     // Catch:{ all -> 0x011d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            java.lang.String r5 = "appId="
            r4.<init>(r5)     // Catch:{ all -> 0x011d }
            java.lang.String r5 = r0.getAppId()     // Catch:{ all -> 0x011d }
            r4.append(r5)     // Catch:{ all -> 0x011d }
            java.lang.String r5 = "^publicId="
            r4.append(r5)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = r0.getPublicId()     // Catch:{ all -> 0x011d }
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "^sourceId="
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.secAppId     // Catch:{ all -> 0x011d }
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "^viewId="
            r4.append(r0)     // Catch:{ all -> 0x011d }
            r4.append(r3)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "^refviewId="
            r4.append(r0)     // Catch:{ all -> 0x011d }
            r4.append(r2)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "^token="
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = com.alipay.mobile.nebulacore.wallet.H5Logger.getToken()     // Catch:{ all -> 0x011d }
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = "^h5Token="
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = com.alipay.mobile.h5container.api.H5PageLoader.h5Token     // Catch:{ all -> 0x011d }
            r4.append(r0)     // Catch:{ all -> 0x011d }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x011d }
            r7.setPerformance(r0)     // Catch:{ all -> 0x011d }
        L_0x0107:
            monitor-exit(r1)     // Catch:{ all -> 0x011d }
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r7 = r6.pages
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x011b
            java.util.Stack<com.alipay.mobile.h5container.api.H5Page> r7 = r6.pages
            java.lang.Object r7 = r7.peek()
            com.alipay.mobile.h5container.api.H5Page r7 = (com.alipay.mobile.h5container.api.H5Page) r7
            r6.setPageEnableFallbackUrl(r7)
        L_0x011b:
            r7 = 1
            return r7
        L_0x011d:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5SessionImpl.addPage(com.alipay.mobile.h5container.api.H5Page):boolean");
    }

    private void sendBroadCast(H5Page h5Page, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = h5Page.getTitle();
        }
        H5Log.d(TAG, "send Title:".concat(String.valueOf(str2)));
        intent.putExtra("title", str2);
        intent.putExtra("utl", str3);
        a.a(h5Page.getContext().getContext()).a(intent);
    }

    public boolean removePage(H5Page h5Page) {
        H5Page h5Page2;
        if (h5Page == null) {
            return false;
        }
        synchronized (this.pages) {
            Iterator it2 = this.pages.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    h5Page2 = null;
                    break;
                }
                h5Page2 = (H5Page) it2.next();
                if (h5Page2.equals(h5Page)) {
                    if (this.pages.size() > 1) {
                        sendBroadCast(h5Page, BROADCAST_HIDE_PAGE, h5Page.getTitle(), h5Page.getUrl());
                    }
                    it2.remove();
                    if (!this.pages.isEmpty()) {
                        sendBroadCast(this.pages.peek(), BROADCAST_SHOW_PAGE, this.pages.peek().getTitle(), this.pages.peek().getUrl());
                    }
                }
            }
            if (h5Page2 != null) {
                for (int size = (this.listener == null ? 0 : this.listener.size()) - 1; size >= 0; size--) {
                    this.listener.get(size).onPageDestroyed(h5Page2);
                }
                if (this.pages.isEmpty()) {
                    sendBroadCast(h5Page2, BROADCAST_PAGE_CLOSE, h5Page2.getTitle(), h5Page2.getUrl());
                    Nebula.getService().removeSession(getId());
                    exitSession();
                    for (int size2 = (this.listener == null ? 0 : this.listener.size()) - 1; size2 >= 0; size2--) {
                        this.listener.get(size2).onSessionDestroyed(this);
                    }
                }
                if (this.pages.isEmpty()) {
                    h5Page2.sendEvent(H5Plugin.CommonEvents.H5_AL_SESSION_TO_NATIVE, (e) null);
                }
                h5Page2.onRelease();
                h5Page2.setParent((H5CoreNode) null);
            }
        }
        if (h5Page2 != null) {
            return true;
        }
        return false;
    }

    public H5Page getTopPage() {
        synchronized (this.pages) {
            if (this.pages.isEmpty()) {
                H5Log.d(TAG, "getTopPage pages.isEmpty()");
                return null;
            }
            H5Page peek = this.pages.peek();
            if (!H5Utils.getBoolean(peek.getParams(), H5Param.LONG_ISPRERENDER, false)) {
                H5Log.d(TAG, "getTopPage top");
                return peek;
            }
            int size = this.pages.size();
            for (int i2 = size - 2; i2 >= 0; i2--) {
                H5Page h5Page = (H5Page) this.pages.elementAt(i2);
                if (!H5Utils.getBoolean(h5Page.getParams(), H5Param.LONG_ISPRERENDER, false)) {
                    H5Log.d(TAG, "getTopPage in index " + i2 + ", size " + size);
                    return h5Page;
                }
            }
            H5Log.d(TAG, "getTopPage no normal page exists");
            return null;
        }
    }

    public Stack<H5Page> getPages() {
        return this.pages;
    }

    public H5Scenario getScenario() {
        return this.h5Scenario;
    }

    public void setScenario(H5Scenario h5Scenario2) {
        this.h5Scenario = h5Scenario2;
    }

    public Bundle getParams() {
        return this.params;
    }

    public void setParams(Bundle bundle) {
        this.params = bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addListener(com.alipay.mobile.h5container.api.H5Listener r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002c
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r2.listener     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0008
            goto L_0x002c
        L_0x0008:
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r2.listener     // Catch:{ all -> 0x0029 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0029 }
        L_0x000e:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0029 }
            com.alipay.mobile.h5container.api.H5Listener r1 = (com.alipay.mobile.h5container.api.H5Listener) r1     // Catch:{ all -> 0x0029 }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r2)
            return
        L_0x0022:
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r2.listener     // Catch:{ all -> 0x0029 }
            r0.add(r3)     // Catch:{ all -> 0x0029 }
            monitor-exit(r2)
            return
        L_0x0029:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002c:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5SessionImpl.addListener(com.alipay.mobile.h5container.api.H5Listener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeListener(com.alipay.mobile.h5container.api.H5Listener r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0012
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r1.listener     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0008
            goto L_0x0012
        L_0x0008:
            java.util.List<com.alipay.mobile.h5container.api.H5Listener> r0 = r1.listener     // Catch:{ all -> 0x000f }
            r0.remove(r2)     // Catch:{ all -> 0x000f }
            monitor-exit(r1)
            return
        L_0x000f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0012:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5SessionImpl.removeListener(com.alipay.mobile.h5container.api.H5Listener):void");
    }

    public synchronized void removeAllListener() {
        if (this.listener != null && !this.listener.isEmpty()) {
            this.listener.clear();
        }
    }

    private void exitPage() {
        Stack stack = new Stack();
        Iterator it2 = this.pages.iterator();
        while (it2.hasNext()) {
            stack.add((H5Page) it2.next());
        }
        for (int size = stack.size() - 1; size >= 0; size--) {
            ((H5Page) stack.get(size)).sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
        }
    }

    public boolean exitSession() {
        H5AppDBService appDBService;
        H5Log.d(TAG, "nebulasessiontracker exitSession @" + hashCode());
        if (H5Utils.isInTinyProcess()) {
            H5Page topPage = getTopPage();
            if (topPage != null && (topPage.getContext().getContext() instanceof Activity)) {
                Nebula.doKeepAlive((Activity) topPage.getContext().getContext(), topPage.getParams());
            }
        } else if (this.exited) {
            H5Log.e(TAG, "session already exited!");
            return false;
        } else {
            this.exited = true;
            H5Refer.referUrl = "";
            exitPage();
            H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
            if (!(h5AppCenterService == null || (appDBService = h5AppCenterService.getAppDBService()) == null)) {
                appDBService.clearPresetMemory();
            }
            H5ContentProvider h5ContentProvider = this.provider;
            if (h5ContentProvider != null) {
                h5ContentProvider.releaseContent();
                this.provider = null;
            }
            H5Flag.setOpenAuthGrantFlag(this.sessionId, false);
            H5AppStartParam.getInstance().remove(this.sessionId);
            H5PreRpcProvider h5PreRpcProvider = (H5PreRpcProvider) Nebula.getProviderManager().getProvider(H5PreRpcProvider.class.getName());
            if (h5PreRpcProvider != null) {
                h5PreRpcProvider.clearPreAll();
            }
            H5PageLoader.release();
            this.h5SessionTabBar = null;
            H5SessionTabManager h5SessionTabManager2 = this.h5SessionTabManager;
            if (h5SessionTabManager2 != null) {
                h5SessionTabManager2.clearTabFragments();
                this.h5SessionTabManager = null;
            }
            H5SessionTabObserver h5SessionTabObserver2 = this.h5SessionTabObserver;
            if (h5SessionTabObserver2 != null) {
                h5SessionTabObserver2.clear();
                this.h5SessionTabObserver = null;
            }
        }
        return true;
    }

    public H5ContentProvider getWebProvider() {
        return this.provider;
    }

    public void setServiceWorkerID(String str) {
        this.serviceWorkerId = str;
    }

    public String getServiceWorkerID() {
        return this.serviceWorkerId;
    }

    private void setPageEnableFallbackUrl(H5Page h5Page) {
        if (h5Page != null) {
            boolean isRnBiz = RnService.isRnBiz(H5Utils.getString(h5Page.getParams(), H5Param.LONG_BIZ_TYPE, ""));
            H5ContentProvider h5ContentProvider = this.provider;
            if (h5ContentProvider != null) {
                h5ContentProvider.setEnableFallbackUrl(isRnBiz);
            }
        }
    }

    public H5SessionTabBar getH5SessionTabBar() {
        return this.h5SessionTabBar;
    }

    public H5SessionTabManager getH5SessionTabManager() {
        return this.h5SessionTabManager;
    }

    public H5SessionTabObserver getH5SessionTabObserver() {
        return this.h5SessionTabObserver;
    }
}
