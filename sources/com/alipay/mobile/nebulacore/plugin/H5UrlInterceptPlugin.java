package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.tinypermission.H5ApiManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class H5UrlInterceptPlugin extends H5SimplePlugin {
    public static final String BROADCAST_TITLE_URL = "com.alipay.mobile.h5container.pageFinished";
    public static final String TAG = "H5UrlInterceptPlugin";
    private static final List<String> WHITE_LIST;
    private static final String xiaochengxuUrlHeader = "https://render.alipay.com/p/s/h5misc/resource_error?url=";
    private String appId;
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private boolean isBackKeyPressed = false;
    private String offlineHost;
    private Set<String> tmpSchemeWhiteSet = new HashSet();

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.h5Page = (H5Page) h5CoreNode;
        Bundle params = this.h5Page.getParams();
        this.appId = H5Utils.getString(params, "appId");
        this.offlineHost = H5Utils.getString(params, H5Param.OFFLINE_HOST);
        H5Log.d(TAG, "url interception.");
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL.equals(action)) {
            H5Log.d(TAG, "H5_PAGE_SHOULD_LOAD_URL");
            return shouldInterceptUrl(h5Event);
        }
        if (H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE.equals(action)) {
            Activity activity = h5Event.getActivity();
            String string = H5Utils.getString(h5Event.getParam(), "title");
            if (activity != null) {
                activity.setTitle(string);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE.equals(action)) {
            TextUtils.isEmpty(H5Utils.getString(this.h5Page.getParams(), H5Param.PUBLIC_ID, ""));
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_BACK.equals(action)) {
            H5Log.d(TAG, "H5_TOOLBAR_BACK");
            this.isBackKeyPressed = true;
        } else if (H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK.equals(action)) {
            H5Log.d(TAG, "H5_PAGE_PHYSICAL_BACK");
            this.isBackKeyPressed = true;
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action)) {
            e param = h5Event.getParam();
            String string2 = H5Utils.getString(param, "url");
            String string3 = H5Utils.getString(param, "title");
            Intent intent = new Intent();
            intent.setAction(BROADCAST_TITLE_URL);
            intent.putExtra("title", string3);
            intent.putExtra("url", string2);
            H5Log.d(TAG, "send page finished broadcast.");
            a.a((Context) h5Event.getActivity()).a(intent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0274 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0281 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02a1 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02c7 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02e2 A[SYNTHETIC, Splitter:B:128:0x02e2] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0155 A[Catch:{ Exception -> 0x0472 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean shouldInterceptUrl(com.alipay.mobile.h5container.api.H5Event r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r0 = "pp"
            java.lang.String r2 = "h5_competitiveList"
            java.lang.String r3 = "url"
            java.lang.String r4 = "H5UrlInterceptPlugin"
            r5 = 1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            java.lang.String r7 = "isBackKeyPressed is "
            r6.<init>(r7)     // Catch:{ Exception -> 0x0472 }
            boolean r7 = r1.isBackKeyPressed     // Catch:{ Exception -> 0x0472 }
            r6.append(r7)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r6)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.e r6 = r22.getParam()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x0472 }
            android.net.Uri r7 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r6)     // Catch:{ Exception -> 0x0472 }
            if (r7 != 0) goto L_0x0033
            java.lang.String r0 = "load url intercepted for failed to parse url."
            com.alipay.mobile.nebula.util.H5Log.w(r4, r0)     // Catch:{ Exception -> 0x0472 }
            return r5
        L_0x0033:
            java.lang.String r8 = r7.getScheme()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r9 = r7.getHost()     // Catch:{ Exception -> 0x0472 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            java.lang.String r11 = "url "
            r10.<init>(r11)     // Catch:{ Exception -> 0x0472 }
            r10.append(r6)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r11 = " scheme "
            r10.append(r11)     // Catch:{ Exception -> 0x0472 }
            r10.append(r8)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r11 = " host "
            r10.append(r11)     // Catch:{ Exception -> 0x0472 }
            r10.append(r9)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = r1.appId     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r11 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            boolean r10 = interceptXiaoChengXu(r6, r10, r11)     // Catch:{ Exception -> 0x0472 }
            if (r10 == 0) goto L_0x0068
            return r5
        L_0x0068:
            boolean r10 = r1.interceptHttpPage(r8, r9)     // Catch:{ Exception -> 0x0472 }
            if (r10 == 0) goto L_0x006f
            return r5
        L_0x006f:
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0472 }
            r11 = 0
            if (r10 != 0) goto L_0x009a
            java.lang.String r10 = ".docx"
            boolean r10 = r6.endsWith(r10)     // Catch:{ Exception -> 0x0472 }
            if (r10 != 0) goto L_0x0086
            java.lang.String r10 = ".doc"
            boolean r10 = r6.endsWith(r10)     // Catch:{ Exception -> 0x0472 }
            if (r10 == 0) goto L_0x009a
        L_0x0086:
            java.lang.String r10 = "h5_open_doc"
            java.lang.String r10 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r12 = "no"
            boolean r10 = r12.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0472 }
            if (r10 != 0) goto L_0x009a
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebulacore.Nebula.openInBrowser(r0, r6, r11)     // Catch:{ Exception -> 0x0472 }
            return r5
        L_0x009a:
            com.alipay.mobile.h5container.api.H5Page r10 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ Exception -> 0x0472 }
            android.net.Uri r10 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r10)     // Catch:{ Exception -> 0x0472 }
            if (r10 == 0) goto L_0x00ab
            java.lang.String r10 = r10.getHost()     // Catch:{ Exception -> 0x0472 }
            goto L_0x00ac
        L_0x00ab:
            r10 = r11
        L_0x00ac:
            java.lang.String r12 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r2)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.e r12 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r12)     // Catch:{ Exception -> 0x0472 }
            if (r12 == 0) goto L_0x00da
            if (r10 == 0) goto L_0x00da
            java.lang.String r14 = "aliWhiteList"
            java.lang.String r12 = r12.getString(r14)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.b r12 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r12)     // Catch:{ Exception -> 0x0472 }
            if (r12 == 0) goto L_0x00da
            r14 = 0
        L_0x00c5:
            int r15 = r12.size()     // Catch:{ Exception -> 0x0472 }
            if (r14 >= r15) goto L_0x00da
            java.lang.String r15 = r12.getString(r14)     // Catch:{ Exception -> 0x0472 }
            boolean r15 = com.alipay.mobile.nebula.util.H5PatternHelper.matchRegex(r15, r10)     // Catch:{ Exception -> 0x0472 }
            if (r15 == 0) goto L_0x00d7
            r10 = 1
            goto L_0x00db
        L_0x00d7:
            int r14 = r14 + 1
            goto L_0x00c5
        L_0x00da:
            r10 = 0
        L_0x00db:
            java.lang.String r12 = "isInCompetitiveAliWhiteList "
            java.lang.String r14 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r12 = r12.concat(r14)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r12)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r12 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            android.os.Bundle r12 = r12.getParams()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r14 = "interceptJump"
            boolean r12 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r12, (java.lang.String) r14, (boolean) r5)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r14 = "interceptJump "
            java.lang.String r15 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r14 = r14.concat(r15)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r14)     // Catch:{ Exception -> 0x0472 }
            if (r12 == 0) goto L_0x0118
            java.lang.String r2 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r2)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.e r11 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = "comListData "
            java.lang.String r12 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = r2.concat(r12)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r2)     // Catch:{ Exception -> 0x0472 }
        L_0x0118:
            java.lang.String r2 = "https://ds.alipay.com/error/securityLink.htm?url="
            java.lang.String r12 = "utf-8"
            if (r10 != 0) goto L_0x0170
            if (r11 == 0) goto L_0x0170
            if (r9 == 0) goto L_0x0170
            java.lang.String r14 = "competitiveLinkList"
            java.lang.String r14 = r11.getString(r14)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.b r14 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r14)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r15 = "competitiveLinkja:"
            java.lang.String r13 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r13 = r15.concat(r13)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r13)     // Catch:{ Exception -> 0x0472 }
            if (r14 == 0) goto L_0x0152
            r13 = 0
        L_0x013d:
            int r15 = r14.size()     // Catch:{ Exception -> 0x0472 }
            if (r13 >= r15) goto L_0x0152
            java.lang.String r15 = r14.getString(r13)     // Catch:{ Exception -> 0x0472 }
            boolean r15 = com.alipay.mobile.nebula.util.H5PatternHelper.matchRegex(r15, r9)     // Catch:{ Exception -> 0x0472 }
            if (r15 == 0) goto L_0x014f
            r9 = 1
            goto L_0x0153
        L_0x014f:
            int r13 = r13 + 1
            goto L_0x013d
        L_0x0152:
            r9 = 0
        L_0x0153:
            if (r9 == 0) goto L_0x0170
            java.lang.String r0 = "DEFAULT_COMPETITIVE_LINK_LIST"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = java.net.URLEncoder.encode(r6, r12)     // Catch:{ Exception -> 0x0472 }
            r0.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r2.loadUrl(r0)     // Catch:{ Exception -> 0x0472 }
            return r5
        L_0x0170:
            java.lang.String r9 = "file://"
            boolean r9 = r6.startsWith(r9)     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x01b3
            java.lang.String r9 = r1.offlineHost     // Catch:{ Exception -> 0x0472 }
            boolean r9 = r6.startsWith(r9)     // Catch:{ Exception -> 0x0472 }
            if (r9 != 0) goto L_0x01b3
            java.lang.String r0 = "file url intercepted for safe strategy"
            com.alipay.mobile.nebula.util.H5Log.w(r4, r0)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0472 }
            r0.<init>()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = "https://alipay.com/h5container/un_safe.html"
            boolean r7 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ Exception -> 0x0472 }
            if (r7 == 0) goto L_0x01a8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            r7.<init>()     // Catch:{ Exception -> 0x0472 }
            r7.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = "?url="
            r7.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5UrlHelper.encode(r6)     // Catch:{ Exception -> 0x0472 }
            r7.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0472 }
        L_0x01a8:
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            java.lang.String r3 = "h5PageLoadUrl"
            r2.sendEvent(r3, r0)     // Catch:{ Exception -> 0x0472 }
            return r5
        L_0x01b3:
            java.lang.String r9 = "about:blank"
            boolean r9 = r9.equals(r6)     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x01bd
            r9 = 0
            return r9
        L_0x01bd:
            java.lang.String r9 = "about"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 != 0) goto L_0x0470
            java.lang.String r9 = "data"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 != 0) goto L_0x0470
            java.lang.String r9 = "http"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 != 0) goto L_0x0470
            java.lang.String r9 = "https"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 != 0) goto L_0x0470
            java.lang.String r9 = "ftp"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x01e7
            goto L_0x0470
        L_0x01e7:
            java.lang.String r9 = "file"
            boolean r9 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x020c
            java.lang.String r0 = r7.getPath()     // Catch:{ Exception -> 0x0472 }
            if (r0 == 0) goto L_0x020a
            java.lang.String r2 = "/android_asset/"
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0472 }
            if (r2 == 0) goto L_0x020a
            java.lang.String r2 = "load asset "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
        L_0x020a:
            r0 = 0
            return r0
        L_0x020c:
            if (r11 == 0) goto L_0x046b
            if (r8 == 0) goto L_0x046b
            if (r10 != 0) goto L_0x0459
            java.util.Set<java.lang.String> r7 = com.alipay.mobile.nebulacore.util.H5SchemeWhiteList.sSchemeMap     // Catch:{ Exception -> 0x0472 }
            boolean r7 = r7.contains(r8)     // Catch:{ Exception -> 0x0472 }
            if (r7 == 0) goto L_0x021c
            goto L_0x0459
        L_0x021c:
            java.lang.String r7 = "schemeBlacklist"
            java.lang.String r7 = r11.getString(r7)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.b r7 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r7)     // Catch:{ Exception -> 0x0472 }
            if (r7 == 0) goto L_0x023e
            r9 = 0
        L_0x0229:
            int r10 = r7.size()     // Catch:{ Exception -> 0x0472 }
            if (r9 >= r10) goto L_0x023e
            java.lang.String r10 = r7.getString(r9)     // Catch:{ Exception -> 0x0472 }
            boolean r10 = com.alipay.mobile.nebula.util.H5PatternHelper.matchRegex(r10, r8)     // Catch:{ Exception -> 0x0472 }
            if (r10 == 0) goto L_0x023b
            r7 = 1
            goto L_0x023f
        L_0x023b:
            int r9 = r9 + 1
            goto L_0x0229
        L_0x023e:
            r7 = 0
        L_0x023f:
            java.lang.String r9 = "schemeWhiteList"
            java.lang.String r9 = r11.getString(r9)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.b r9 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r9)     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x0261
            r10 = 0
        L_0x024c:
            int r11 = r9.size()     // Catch:{ Exception -> 0x0472 }
            if (r10 >= r11) goto L_0x0261
            java.lang.String r11 = r9.getString(r10)     // Catch:{ Exception -> 0x0472 }
            boolean r11 = com.alipay.mobile.nebula.util.H5PatternHelper.matchRegex(r11, r8)     // Catch:{ Exception -> 0x0472 }
            if (r11 == 0) goto L_0x025e
            r9 = 1
            goto L_0x0262
        L_0x025e:
            int r10 = r10 + 1
            goto L_0x024c
        L_0x0261:
            r9 = 0
        L_0x0262:
            com.alipay.mobile.h5container.api.H5Page r10 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            long r10 = r10.getLastTouch()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r13 = "h5_ppConfig"
            java.lang.String r13 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r13)     // Catch:{ Exception -> 0x0472 }
            com.alibaba.a.e r13 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r13)     // Catch:{ Exception -> 0x0472 }
            if (r13 == 0) goto L_0x0281
            java.lang.String r14 = "YES"
            java.lang.String r15 = "jumpToPP"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r13, (java.lang.String) r15)     // Catch:{ Exception -> 0x0472 }
            boolean r13 = r14.equals(r13)     // Catch:{ Exception -> 0x0472 }
            goto L_0x0282
        L_0x0281:
            r13 = 1
        L_0x0282:
            java.lang.String r14 = "jumpToPP "
            java.lang.String r15 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r14 = r14.concat(r15)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r14)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.provider.H5ProviderManager r14 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()     // Catch:{ Exception -> 0x0472 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ChannelProvider> r15 = com.alipay.mobile.nebula.provider.H5ChannelProvider.class
            java.lang.String r15 = r15.getName()     // Catch:{ Exception -> 0x0472 }
            java.lang.Object r14 = r14.getProvider(r15)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.provider.H5ChannelProvider r14 = (com.alipay.mobile.nebula.provider.H5ChannelProvider) r14     // Catch:{ Exception -> 0x0472 }
            if (r14 == 0) goto L_0x02c7
            java.lang.String r14 = r14.getChannelId()     // Catch:{ Exception -> 0x0472 }
            java.lang.String r15 = "5136"
            boolean r15 = r15.equals(r14)     // Catch:{ Exception -> 0x0472 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            r16 = r0
            java.lang.String r0 = "WalletChannelId is "
            r5.<init>(r0)     // Catch:{ Exception -> 0x0472 }
            r5.append(r14)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = ", isGooglePlayChannel "
            r5.append(r0)     // Catch:{ Exception -> 0x0472 }
            r5.append(r15)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            goto L_0x02ca
        L_0x02c7:
            r16 = r0
            r15 = 0
        L_0x02ca:
            java.lang.String r0 = "isGooglePlayChannel:"
            java.lang.String r5 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = r0.concat(r5)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = "h5PageInterceptScheme"
            java.lang.String r5 = "scheme"
            r17 = 400(0x190, double:1.976E-321)
            java.lang.String r14 = "type"
            if (r7 == 0) goto L_0x0328
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0472 }
            long r19 = r19 - r10
            long r9 = java.lang.Math.abs(r19)     // Catch:{ Exception -> 0x0472 }
            int r7 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r7 >= 0) goto L_0x0321
            com.alibaba.a.e r7 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0472 }
            r7.<init>()     // Catch:{ Exception -> 0x0472 }
            r7.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0472 }
            r7.put((java.lang.String) r5, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r3 = "blacklist"
            r7.put((java.lang.String) r14, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r3 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r3.sendEvent(r0, r7)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = "DEFAULT_SCHEME_BLACK_LIST_MANUAL"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r2 = java.net.URLEncoder.encode(r6, r12)     // Catch:{ Exception -> 0x0472 }
            r0.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r2.loadUrl(r0)     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0321:
            java.lang.String r0 = "DEFAULT_SCHEME_BLACK_LIST_AUTO"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0328:
            r2 = 2
            java.lang.String r7 = "URGENT"
            if (r9 == 0) goto L_0x0378
            java.lang.String r0 = "DEFAULT_SCHEME_WHITE_LIST"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            if (r13 == 0) goto L_0x0351
            boolean r0 = r1.resolveExtApp(r6)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x0351
            com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin$1 r0 = new com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin$1     // Catch:{ Exception -> 0x0472 }
            r0.<init>(r15, r8)     // Catch:{ Exception -> 0x0472 }
            java.util.concurrent.ThreadPoolExecutor r3 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r7)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebulacore.util.H5PPQueryThread r5 = com.alipay.mobile.nebulacore.util.H5PPQueryThread.getInstance()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r7 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r5.setParams(r6, r2, r0, r7)     // Catch:{ Exception -> 0x0472 }
            r3.execute(r5)     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0351:
            r0 = r16
            boolean r2 = r0.equals(r8)     // Catch:{ Exception -> 0x0472 }
            if (r2 == 0) goto L_0x0447
            java.lang.String r2 = "www.25pp.com/down"
            boolean r2 = r6.contains(r2)     // Catch:{ Exception -> 0x0472 }
            if (r2 == 0) goto L_0x0447
            com.alibaba.a.e r2 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0472 }
            r2.<init>()     // Catch:{ Exception -> 0x0472 }
            r2.put((java.lang.String) r14, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r0 = "downloadUrl"
            r2.put((java.lang.String) r0, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            java.lang.String r3 = "h5PageJumpPPDownload"
            r0.sendEvent(r3, r2)     // Catch:{ Exception -> 0x0472 }
            goto L_0x0447
        L_0x0378:
            boolean r9 = r1.isBackKeyPressed     // Catch:{ Exception -> 0x0472 }
            if (r9 == 0) goto L_0x0381
            java.util.Set<java.lang.String> r9 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            r9.clear()     // Catch:{ Exception -> 0x0472 }
        L_0x0381:
            r9 = r3
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0472 }
            r19 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            r20 = r15
            java.lang.String r15 = "lastTouchTime is "
            r7.<init>(r15)     // Catch:{ Exception -> 0x0472 }
            r7.append(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r15 = " ,interceptTime is "
            r7.append(r15)     // Catch:{ Exception -> 0x0472 }
            r7.append(r2)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r15 = " ,delta is "
            r7.append(r15)     // Catch:{ Exception -> 0x0472 }
            long r2 = r2 - r10
            long r10 = java.lang.Math.abs(r2)     // Catch:{ Exception -> 0x0472 }
            r7.append(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = "tmpSchemeWhiteSet contains "
            r7.append(r10)     // Catch:{ Exception -> 0x0472 }
            java.util.Set<java.lang.String> r10 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            boolean r10 = r10.contains(r8)     // Catch:{ Exception -> 0x0472 }
            r7.append(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r7)     // Catch:{ Exception -> 0x0472 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = "https://ds.alipay.com/error/redirectLink.htm?url="
            r7.<init>(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r10 = java.net.URLEncoder.encode(r6, r12)     // Catch:{ Exception -> 0x0472 }
            r7.append(r10)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0472 }
            long r2 = java.lang.Math.abs(r2)     // Catch:{ Exception -> 0x0472 }
            int r10 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r10 >= 0) goto L_0x044f
            com.alibaba.a.e r2 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0472 }
            r2.<init>()     // Catch:{ Exception -> 0x0472 }
            r2.put((java.lang.String) r9, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0472 }
            r2.put((java.lang.String) r5, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0472 }
            java.lang.String r3 = "greylist"
            r2.put((java.lang.String) r14, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r3 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r3.sendEvent(r0, r2)     // Catch:{ Exception -> 0x0472 }
            if (r13 == 0) goto L_0x0425
            boolean r0 = r1.resolveExtApp(r6)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x0425
            java.util.Set<java.lang.String> r0 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            boolean r0 = r0.contains(r8)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x0425
            java.lang.String r0 = "DEFAULT_SCHEME_ELSE_MANUAL_PP"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            java.util.Set<java.lang.String> r0 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            r0.add(r8)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin$2 r0 = new com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin$2     // Catch:{ Exception -> 0x0472 }
            r15 = r20
            r0.<init>(r15, r8, r7)     // Catch:{ Exception -> 0x0472 }
            java.util.concurrent.ThreadPoolExecutor r2 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r19)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.nebulacore.util.H5PPQueryThread r3 = com.alipay.mobile.nebulacore.util.H5PPQueryThread.getInstance()     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r5 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r7 = 2
            r3.setParams(r6, r7, r0, r5)     // Catch:{ Exception -> 0x0472 }
            r2.execute(r3)     // Catch:{ Exception -> 0x0472 }
            r0 = 0
            r1.isBackKeyPressed = r0     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0425:
            java.util.Set<java.lang.String> r0 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            boolean r0 = r0.contains(r8)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x0447
            boolean r0 = r1.resolveExtApp(r6)     // Catch:{ Exception -> 0x0472 }
            if (r0 == 0) goto L_0x0447
            java.lang.String r0 = "DEFAULT_SCHEME_ELSE_MANUAL_NORMAL"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            java.util.Set<java.lang.String> r0 = r1.tmpSchemeWhiteSet     // Catch:{ Exception -> 0x0472 }
            r0.add(r8)     // Catch:{ Exception -> 0x0472 }
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page     // Catch:{ Exception -> 0x0472 }
            r0.loadUrl(r7)     // Catch:{ Exception -> 0x0472 }
            r0 = 0
            r1.isBackKeyPressed = r0     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0447:
            boolean r0 = r1.resolveExtApp(r6)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x046b
            r2 = 1
            return r2
        L_0x044f:
            java.lang.String r0 = "DEFAULT_SCHEME_ELSE_AUTO"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            r0 = 0
            r1.isBackKeyPressed = r0     // Catch:{ Exception -> 0x0472 }
            r2 = 1
            return r2
        L_0x0459:
            java.lang.String r0 = "hardcode scheme whitelist"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0472 }
            boolean r0 = r1.resolveExtApp(r6)     // Catch:{ Exception -> 0x0472 }
            if (r0 != 0) goto L_0x0466
            r2 = 1
            return r2
        L_0x0466:
            boolean r0 = r1.startExtApp(r6, r8)     // Catch:{ Exception -> 0x0472 }
            return r0
        L_0x046b:
            boolean r0 = r1.startExtApp(r6, r8)     // Catch:{ Exception -> 0x0472 }
            return r0
        L_0x0470:
            r0 = 0
            return r0
        L_0x0472:
            r0 = move-exception
            java.lang.String r2 = "check url exception."
            com.alipay.mobile.nebula.util.H5Log.e(r4, r2, r0)
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin.shouldInterceptUrl(com.alipay.mobile.h5container.api.H5Event):boolean");
    }

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("tel");
        WHITE_LIST.add("mailto");
        WHITE_LIST.add("sms");
        WHITE_LIST.add("geo");
    }

    public static boolean interceptXiaoChengXu(String str, String str2, H5Page h5Page2) {
        String str3;
        boolean z = false;
        if (str.startsWith(xiaochengxuUrlHeader)) {
            return false;
        }
        Uri parseUrl = H5UrlHelper.parseUrl(str);
        if (parseUrl != null) {
            String scheme = parseUrl.getScheme();
            if (scheme != null && WHITE_LIST.contains(scheme.toLowerCase())) {
                return false;
            }
            str3 = parseUrl.getHost();
        } else {
            str3 = "";
        }
        if ((Nebula.getH5TinyAppService() != null ? Nebula.getH5TinyAppService().hasPermissionFile(str2) : false) && (!Nebula.getH5TinyAppService().hasPermission(str2, str3, H5ApiManager.validDomain))) {
            H5Logger.performanceLoggerV2("H5_AL_NETWORK_PERMISSON_ERROR", (String) null, (String) null, (String) null, "BanMainURL=".concat(String.valueOf(str)), (String) null, "H-EM");
            h5Page2.loadUrl(xiaochengxuUrlHeader + H5UrlHelper.encode(str));
        }
        return z;
    }

    private boolean interceptHttpPage(String str, String str2) {
        b parseArray;
        if (this.h5Page != null && "http".equals(str) && !TextUtils.isEmpty(str2)) {
            String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_SSLVerifyDomain");
            if (!(TextUtils.isEmpty(configWithProcessCache) || (parseArray = H5Utils.parseArray(configWithProcessCache)) == null || parseArray.size() == 0)) {
                int i2 = 0;
                while (i2 < parseArray.size()) {
                    try {
                        String string = parseArray.getString(i2);
                        if (H5PatternHelper.matchRegex(string, str2)) {
                            this.h5Page.getWebView().loadUrl("javascript:location.replace('" + "https://ds.alipay.com/fd-in15xm06/index.html" + "');");
                            H5Log.w(TAG, "url intercepted by pattern ".concat(String.valueOf(string)));
                            return true;
                        }
                        i2++;
                    } catch (Throwable th) {
                        H5Log.e(TAG, "match http host exception.", th);
                    }
                }
            }
        }
        return false;
    }

    private boolean startExtApp(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !"javascript".equals(str2)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent((ComponentName) null);
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector((Intent) null);
                }
                try {
                    Nebula.startExtActivity(parseUri);
                    if (this.tmpSchemeWhiteSet.contains(str2)) {
                        this.h5Page.exitPage();
                    }
                    H5Log.d(TAG, "start ext app: ".concat(String.valueOf(str2)));
                    return true;
                } catch (Exception e2) {
                    H5Log.e(TAG, "exception detail", e2);
                    return false;
                }
            } catch (URISyntaxException e3) {
                H5Log.w(TAG, "bad uri " + str + ": " + e3.getMessage());
            }
        }
        return false;
    }

    private boolean resolveExtApp(String str) {
        Intent intent;
        if (!TextUtils.isEmpty(str)) {
            PackageManager packageManager = H5Environment.getContext().getPackageManager();
            try {
                intent = Intent.parseUri(str, 1);
            } catch (URISyntaxException e2) {
                H5Log.e(TAG, "parse event exception.", e2);
                intent = null;
            }
            if (intent != null) {
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent((ComponentName) null);
            }
            if (packageManager.resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    public void onRelease() {
        H5Log.d(TAG, "onRelease");
        this.h5Page = null;
        this.tmpSchemeWhiteSet.clear();
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
    }
}
