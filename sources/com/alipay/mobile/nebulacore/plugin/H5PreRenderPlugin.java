package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.prerender.H5PreRenderPool;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5FragmentManager;

public class H5PreRenderPlugin extends H5SimplePlugin {
    private static final int DEFAULT_PRE_RANDER_MAX = 3;
    public static final String KEY_PRE_RANDER_MAX = "H5_preRenderMax";
    private static final String PARAM = "param";
    private static final String TAG = "H5PreRenderPlugin";
    private static final String WINDOW_PARAMS = "windowParams";
    private H5SessionImpl h5Session;
    private Boolean showFavorites = Boolean.FALSE;

    public H5PreRenderPlugin(H5SessionImpl h5SessionImpl) {
        this.h5Session = h5SessionImpl;
    }

    public void onRelease() {
        this.h5Session = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.PRE_RENDER);
        h5EventFilter.addAction(H5Plugin.CommonEvents.CLEAR_RENDER);
        h5EventFilter.addAction(H5Plugin.CommonEvents.FINISH_RENDER);
        h5EventFilter.addAction("showFavorites");
        h5EventFilter.addAction(H5Plugin.InternalEvents.HIDE_FAVORITES);
    }

    public void onInitialize(H5CoreNode h5CoreNode) {
        super.onInitialize(h5CoreNode);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if ("showFavorites".equals(action)) {
            this.showFavorites = Boolean.TRUE;
            return false;
        } else if (!H5Plugin.InternalEvents.HIDE_FAVORITES.equals(action)) {
            return false;
        } else {
            this.showFavorites = Boolean.FALSE;
            return false;
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.PRE_RENDER.equals(action)) {
            openPreRenderByPlugin(h5Event, true);
            preRender(h5Event, h5BridgeContext);
            H5Log.d(TAG, "pre_render");
        } else if (H5Plugin.CommonEvents.CLEAR_RENDER.equals(action)) {
            openPreRenderByPlugin(h5Event, false);
            clearRender(h5Event, h5BridgeContext);
            H5Log.d(TAG, "clear_render");
            h5BridgeContext.sendSuccess();
        } else if (H5Plugin.CommonEvents.FINISH_RENDER.equals(action)) {
            h5BridgeContext.sendSuccess();
        }
        return true;
    }

    private void openPreRenderByPlugin(H5Event h5Event, boolean z) {
        if (h5Event.getActivity() instanceof H5Activity) {
            H5Log.d(TAG, "openPreRenderByPlugin:".concat(String.valueOf(z)));
            ((H5Activity) h5Event.getActivity()).openPreRenderByPlugin(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0217, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void preRender(com.alipay.mobile.h5container.api.H5Event r12, com.alipay.mobile.h5container.api.H5BridgeContext r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.alipay.mobile.h5container.api.H5CoreNode r0 = r12.getTarget()     // Catch:{ all -> 0x0262 }
            boolean r1 = r0 instanceof com.alipay.mobile.h5container.api.H5Page     // Catch:{ all -> 0x0262 }
            if (r1 != 0) goto L_0x0012
            java.lang.String r12 = "H5PreRenderPlugin"
            java.lang.String r13 = "invalid target!"
            com.alipay.mobile.nebula.util.H5Log.w(r12, r13)     // Catch:{ all -> 0x0262 }
            monitor-exit(r11)
            return
        L_0x0012:
            com.alipay.mobile.nebulacore.prerender.H5PreRenderPool r1 = com.alipay.mobile.nebulacore.prerender.H5PreRenderPool.getInstance()     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebulacore.core.H5PageImpl r0 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r0     // Catch:{ all -> 0x0262 }
            com.alibaba.a.e r2 = r12.getParam()     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = "windowParams"
            r4 = 0
            com.alibaba.a.e r3 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r2, r3, r4)     // Catch:{ all -> 0x0262 }
            java.lang.String r5 = r0.getUrl()     // Catch:{ all -> 0x0262 }
            java.lang.String r6 = "kickOut"
            java.lang.String r7 = "first"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r2, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0262 }
            if (r3 == 0) goto L_0x0218
            boolean r7 = r3.isEmpty()     // Catch:{ all -> 0x0262 }
            if (r7 == 0) goto L_0x003a
            goto L_0x0218
        L_0x003a:
            java.lang.String r7 = "url"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r3, (java.lang.String) r7)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "param"
            com.alibaba.a.e r3 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r3, r8, r4)     // Catch:{ all -> 0x0262 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x0262 }
            r4.<init>()     // Catch:{ all -> 0x0262 }
            android.os.Bundle r8 = r0.getParams()     // Catch:{ all -> 0x0262 }
            r4.putAll(r8)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "preRpc"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x0067
            java.lang.String r8 = "H5PreRenderPlugin"
            java.lang.String r9 = "in H5SessionPlugin delete preRpc startparam"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "preRpc"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x0067:
            java.lang.String r8 = "navSearchBar_type"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x0074
            java.lang.String r8 = "navSearchBar_type"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x0074:
            java.lang.String r8 = "backgroundColor"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x0081
            java.lang.String r8 = "backgroundColor"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x0081:
            java.lang.String r8 = "transparentTitle"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x0097
            java.lang.String r8 = "H5PreRenderPlugin"
            java.lang.String r9 = "in H5SessionPlugin delete transparentTitle startparam"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "transparentTitle"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x0097:
            java.lang.String r8 = "transparentTitleTextAuto"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x00ad
            java.lang.String r8 = "H5PreRenderPlugin"
            java.lang.String r9 = "in H5SessionPlugin delete transparentTitleTextAuto startparam"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "transparentTitleTextAuto"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x00ad:
            java.lang.String r8 = "titleImage"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x00c3
            java.lang.String r8 = "H5PreRenderPlugin"
            java.lang.String r9 = "in H5SessionPlugin delete titleImage startparam"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "titleImage"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x00c3:
            java.lang.String r8 = "bounceTopColor"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x00d0
            java.lang.String r8 = "bounceTopColor"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x00d0:
            java.lang.String r8 = "fragmentType"
            boolean r8 = r4.containsKey(r8)     // Catch:{ all -> 0x0262 }
            if (r8 == 0) goto L_0x00e4
            java.lang.String r8 = "H5PreRenderPlugin"
            java.lang.String r9 = "in H5SessionPlugin delete fragmentType startparam"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r8 = "fragmentType"
            r4.remove(r8)     // Catch:{ all -> 0x0262 }
        L_0x00e4:
            r8 = 0
            if (r3 == 0) goto L_0x0114
            boolean r9 = r3.isEmpty()     // Catch:{ all -> 0x0262 }
            if (r9 != 0) goto L_0x0114
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0262 }
            r9.<init>()     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.util.H5Utils.toBundle(r9, r3)     // Catch:{ all -> 0x0262 }
            android.os.Bundle r3 = com.alipay.mobile.nebula.util.H5ParamParser.parse(r9, r8)     // Catch:{ all -> 0x0262 }
            java.util.Set r9 = r3.keySet()     // Catch:{ all -> 0x0262 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0262 }
        L_0x0101:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0262 }
            if (r10 == 0) goto L_0x0111
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0262 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.util.H5ParamParser.remove(r4, r10)     // Catch:{ all -> 0x0262 }
            goto L_0x0101
        L_0x0111:
            r4.putAll(r3)     // Catch:{ all -> 0x0262 }
        L_0x0114:
            java.lang.String r3 = "showFavorites"
            java.lang.Boolean r9 = r11.showFavorites     // Catch:{ all -> 0x0262 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0262 }
            r4.putBoolean(r3, r9)     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebulacore.core.H5SessionImpl r3 = r11.h5Session     // Catch:{ all -> 0x0262 }
            android.os.Bundle r3 = r3.getParams()     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getAbsoluteUrl(r5, r7, r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r7 = "H5PreRenderPlugin"
            java.lang.String r9 = "pushWindow url "
            java.lang.String r10 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r9 = r9.concat(r10)     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r9)     // Catch:{ all -> 0x0262 }
            java.lang.String r7 = "url"
            r4.putString(r7, r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = "Referer"
            r4.putString(r3, r5)     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = "isPrerender"
            r5 = 1
            r4.putBoolean(r3, r5)     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = "launchParamsTag"
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0262 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0262 }
            if (r3 != 0) goto L_0x017e
            java.lang.String r3 = "appId"
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r4, (java.lang.String) r3)     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.startParam.H5StartParamManager r5 = com.alipay.mobile.nebula.startParam.H5StartParamManager.getInstance()     // Catch:{ all -> 0x0262 }
            android.os.Bundle r2 = r5.getH5StartParam(r3, r2)     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x017e
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0262 }
            if (r3 != 0) goto L_0x017e
            java.lang.String r3 = "H5PreRenderPlugin"
            java.lang.String r5 = "launcher "
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r5 = r5.concat(r7)     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.util.H5Log.d(r3, r5)     // Catch:{ all -> 0x0262 }
            r4.putAll(r2)     // Catch:{ all -> 0x0262 }
        L_0x017e:
            java.lang.String r2 = "H5PreRenderPlugin"
            com.alipay.mobile.nebula.util.H5ParamParser.parseMagicOptions(r4, r2)     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebula.util.H5ParamParser.parse(r4, r8)     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x0216
            com.alipay.mobile.h5container.api.H5Context r2 = r0.getContext()     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x0216
            com.alipay.mobile.h5container.api.H5Context r0 = r0.getContext()     // Catch:{ all -> 0x0262 }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x0262 }
            if (r0 != 0) goto L_0x019a
            goto L_0x0216
        L_0x019a:
            java.lang.String r0 = "fromType"
            java.lang.String r2 = "pushWindow"
            r4.putString(r0, r2)     // Catch:{ all -> 0x0262 }
            int r0 = r1.getPreFragmentCount()     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x01de
            boolean r0 = r1.containsPoolKey(r4, r8)     // Catch:{ all -> 0x0262 }
            if (r0 != 0) goto L_0x01de
            int r0 = r1.getPreFragmentCount()     // Catch:{ all -> 0x0262 }
            int r2 = r11.getH5PreRenderMax()     // Catch:{ all -> 0x0262 }
            if (r0 < r2) goto L_0x01de
            java.lang.String r0 = "none"
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x01db
            com.alibaba.a.e r12 = new com.alibaba.a.e     // Catch:{ all -> 0x0262 }
            r12.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "urls"
            com.alibaba.a.b r1 = r1.getUrls()     // Catch:{ all -> 0x0262 }
            r12.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "success"
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0262 }
            r12.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            r13.sendBridgeResult(r12)     // Catch:{ all -> 0x0262 }
            monitor-exit(r11)
            return
        L_0x01db:
            r11.kickOutPreRender(r12, r6)     // Catch:{ all -> 0x0262 }
        L_0x01de:
            android.app.Activity r0 = r12.getActivity()     // Catch:{ all -> 0x0262 }
            boolean r0 = r0 instanceof com.alipay.mobile.nebulacore.ui.H5Activity     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x01fa
            java.lang.String r0 = "H5PreRenderPlugin"
            java.lang.String r2 = "##h5prerender## add prerender by jsapi"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r2)     // Catch:{ all -> 0x0262 }
            android.app.Activity r12 = r12.getActivity()     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebulacore.ui.H5Activity r12 = (com.alipay.mobile.nebulacore.ui.H5Activity) r12     // Catch:{ all -> 0x0262 }
            com.alipay.mobile.nebulacore.ui.H5FragmentManager r12 = r12.getH5FragmentManager()     // Catch:{ all -> 0x0262 }
            r12.addPreFragment(r4, r8)     // Catch:{ all -> 0x0262 }
        L_0x01fa:
            com.alibaba.a.e r12 = new com.alibaba.a.e     // Catch:{ all -> 0x0262 }
            r12.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "urls"
            com.alibaba.a.b r1 = r1.getUrls()     // Catch:{ all -> 0x0262 }
            r12.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "success"
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0262 }
            r12.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            r13.sendBridgeResult(r12)     // Catch:{ all -> 0x0262 }
            monitor-exit(r11)
            return
        L_0x0216:
            monitor-exit(r11)
            return
        L_0x0218:
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            int r2 = r1.getPreFragmentCount()     // Catch:{ all -> 0x0262 }
            if (r2 != 0) goto L_0x023e
            java.lang.String r12 = "error"
            java.lang.String r1 = "2"
            r0.put((java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r12 = "message"
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()     // Catch:{ all -> 0x0262 }
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_wrongparam     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ all -> 0x0262 }
            r0.put((java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            r13.sendBridgeResult(r0)     // Catch:{ all -> 0x0262 }
            monitor-exit(r11)
            return
        L_0x023e:
            java.lang.String r2 = "none"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x0248
            monitor-exit(r11)
            return
        L_0x0248:
            r11.kickOutPreRender(r12, r6)     // Catch:{ all -> 0x0262 }
            java.lang.String r12 = "urls"
            com.alibaba.a.b r1 = r1.getUrls()     // Catch:{ all -> 0x0262 }
            r0.put((java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r12 = "success"
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0262 }
            r0.put((java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x0262 }
            r13.sendBridgeResult(r0)     // Catch:{ all -> 0x0262 }
            monitor-exit(r11)
            return
        L_0x0262:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5PreRenderPlugin.preRender(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }

    private int getH5PreRenderMax() {
        String config = H5Environment.getConfig(KEY_PRE_RANDER_MAX);
        try {
            if (TextUtils.isEmpty(config)) {
                return 3;
            }
            return Integer.parseInt(config);
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail.", e2);
            return 3;
        }
    }

    private void kickOutPreRender(H5Event h5Event, String str) {
        H5PreRenderPool instance = H5PreRenderPool.getInstance();
        if (instance.getPreFragmentCount() != 0 && (h5Event.getActivity() instanceof H5Activity)) {
            H5FragmentManager h5FragmentManager = ((H5Activity) h5Event.getActivity()).getH5FragmentManager();
            if ("last".equals(str)) {
                h5FragmentManager.clearPreFragment(instance.getPreFragmentCount() - 1, instance.getPreFragmentCount() - 1);
            } else {
                h5FragmentManager.clearPreFragment(0, 0);
            }
        }
    }

    private void clearRender(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e jSONObject = H5Utils.getJSONObject(h5Event.getParam(), "range", (e) null);
        int i2 = H5Utils.getInt(jSONObject, "location", 0);
        int i3 = H5Utils.getInt(jSONObject, "length", 1);
        H5PreRenderPool instance = H5PreRenderPool.getInstance();
        if (instance.getPreFragmentCount() == 0) {
            h5BridgeContext.sendBridgeResult("success", "false");
        } else if (i2 < 0 || i3 < 0) {
            e eVar = new e();
            eVar.put("error", (Object) "2");
            eVar.put("message", (Object) H5Environment.getResources().getString(R.string.h5_wrongparam));
            h5BridgeContext.sendBridgeResult(eVar);
        } else if (i2 > i3) {
            e eVar2 = new e();
            eVar2.put("error", (Object) "2");
            eVar2.put("message", (Object) H5Environment.getResources().getString(R.string.h5_wrongparam));
            h5BridgeContext.sendBridgeResult(eVar2);
        } else if (i2 > instance.getPreFragmentCount() - 1) {
            e eVar3 = new e();
            eVar3.put("error", (Object) "2");
            eVar3.put("message", (Object) H5Environment.getResources().getString(R.string.h5_wrongparam));
            h5BridgeContext.sendBridgeResult(eVar3);
        } else {
            if (i3 > instance.getPreFragmentCount() - 1) {
                i3 = instance.getPreFragmentCount() - 1;
            }
            if (h5Event.getActivity() instanceof H5Activity) {
                ((H5Activity) h5Event.getActivity()).getH5FragmentManager().clearPreFragment(i2, i3);
            }
            e eVar4 = new e();
            eVar4.put("urls", (Object) instance.getUrls());
            eVar4.put("success", (Object) Boolean.TRUE);
            h5BridgeContext.sendBridgeResult(eVar4);
        }
    }
}
