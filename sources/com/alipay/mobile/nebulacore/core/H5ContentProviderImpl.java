package com.alipay.mobile.nebulacore.core;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5ResProvider;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandler;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.TestDataUtils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackagePool;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.alipay.mobile.nebulacore.web.H5InputStream;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class H5ContentProviderImpl implements H5ContentProvider, H5InputStream.H5InputListener {
    private static final String CHECK_MIME_TYPE_OFF = "NO";
    private static final String KEY_CHECK_MIME_TYPE = "h5_check_mime_type";
    private static final String KEY_MATCH_RES_SAMPLE_RATE = "h5_match_res_sample_rate";
    private static final String KEY_MIME_TYPE_MAP = "h5_mime_type_url_map";
    private static final double MATCH_RES_SAMPLE_RATE_DEFAULT = 0.1d;
    public static final String TAG = "H5ContentProviderImpl";
    private static final String TINY_RES_HOST = "https://appx";
    private String cdnHost;
    /* access modifiers changed from: private */
    public H5ContentPackage contentPackage;
    private boolean enableFallback;
    private boolean enableFallbackUrl;
    private H5ResourceHandler h5ResourceHandler;
    private boolean hasInputException = false;
    private boolean hasTinyGoOnline = false;
    private boolean isNebulaApp = false;
    /* access modifiers changed from: private */
    public String mAppId;
    /* access modifiers changed from: private */
    public Bundle mBundle;
    private List<H5InputStream> mConnList;
    private HashMap<String, String> mContentMap;
    private ExecutorService mFallbackExecutor = null;
    private boolean mFirstReq = true;
    /* access modifiers changed from: private */
    public H5Page mH5Page;
    private boolean mHasResourceOffline = false;
    private List<InputStream> mInputStreamList;
    private String mIsLocal = H5Param.DEFAULT_LONG_PRESSO_LOGIN;
    private boolean mTryConcatOnlineHost = false;
    private boolean mapHost;
    private String offlineHost;
    private String onlineHost;
    private Random random;
    private H5ResProvider resProvider;
    private String sessionId;
    private e tinyConfig;
    private String tinyResFallbackUrl;
    private String unsafeUrl = "https://render.alipay.com/p/s/h5container/index";
    private Boolean useGetContentOnUi = null;
    /* access modifiers changed from: private */
    public String version;

    H5ContentProviderImpl(H5Page h5Page) {
        this.mBundle = h5Page.getParams();
        this.mH5Page = h5Page;
        this.mContentMap = new HashMap<>();
        this.mAppId = H5Utils.getString(this.mBundle, "appId");
        this.sessionId = H5Utils.getString(this.mBundle, H5Param.SESSION_ID);
        this.mConnList = Collections.synchronizedList(new ArrayList());
        this.mInputStreamList = Collections.synchronizedList(new ArrayList());
        this.contentPackage = H5ContentPackagePool.getPackage(this.sessionId);
        this.offlineHost = H5Utils.getString(this.mBundle, H5Param.OFFLINE_HOST);
        this.onlineHost = H5Utils.getString(this.mBundle, H5Param.ONLINE_HOST);
        this.mapHost = H5Utils.getBoolean(this.mBundle, H5Param.MAP_HOST, false);
        this.enableFallback = H5Utils.getBoolean(this.mBundle, H5Param.ENABLE_FALLBACK, true);
        this.enableFallbackUrl = false;
        H5Log.d(TAG, "mapHost " + this.mapHost + " enableFallback " + this.enableFallback);
        H5Log.d(TAG, "appId " + this.mAppId + " offlineHost " + this.offlineHost + " sessionId:" + this.sessionId);
        StringBuilder sb = new StringBuilder("onlineHost ");
        sb.append(this.onlineHost);
        H5Log.d(TAG, sb.toString());
        this.cdnHost = H5Utils.getString(this.mBundle, H5Param.CDN_HOST);
        this.version = H5Utils.getString(this.mBundle, "appVersion");
        this.resProvider = (H5ResProvider) Nebula.getProviderManager().getProvider(H5ResProvider.class.getName());
        this.h5ResourceHandler = (H5ResourceHandler) Nebula.getProviderManager().getProvider(H5ResourceHandler.class.getName());
        H5Log.d(TAG, " cdnHost " + this.cdnHost + " version:" + this.version);
        this.tinyConfig = H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_resRedirect"));
        if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(H5Environment.getConfigWithProcessCache("h5_tryConcatOnlineHost"))) {
            this.mTryConcatOnlineHost = true;
        }
        this.isNebulaApp = H5Utils.getBoolean(this.mBundle, H5Param.IS_NEBULA_APP, false);
        this.random = new Random(System.currentTimeMillis());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v102, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c6 A[Catch:{ all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e4 A[Catch:{ all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01eb A[Catch:{ all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f5 A[Catch:{ all -> 0x0503 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.webkit.WebResourceResponse getContent(android.net.Uri r17, java.lang.String r18, com.alipay.mobile.h5container.api.H5Page r19, boolean r20, boolean r21) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r5 = r18
            java.lang.String r1 = "file://"
            java.lang.String r8 = "H5ContentProviderImpl"
            long r2 = java.lang.System.currentTimeMillis()
            r9 = 0
            boolean r4 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0503 }
            if (r4 == 0) goto L_0x0022
            boolean r4 = com.alipay.mobile.nebula.util.H5Utils.isMain()     // Catch:{ all -> 0x0503 }
            if (r4 != 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = "not invoke on ui thread!!!"
            r0.<init>(r1)     // Catch:{ all -> 0x0503 }
            throw r0     // Catch:{ all -> 0x0503 }
        L_0x0022:
            boolean r4 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x0503 }
            if (r4 == 0) goto L_0x0032
            java.lang.String r0 = "invalid url parameter"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r8, (java.lang.String) r0)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r9, (java.io.InputStream) r9)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0032:
            boolean r4 = r5.startsWith(r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = "https://"
            if (r4 != 0) goto L_0x0056
            java.lang.String r4 = "http://"
            boolean r4 = r5.startsWith(r4)     // Catch:{ all -> 0x0503 }
            if (r4 != 0) goto L_0x0056
            boolean r4 = r5.startsWith(r6)     // Catch:{ all -> 0x0503 }
            if (r4 != 0) goto L_0x0056
            java.lang.String r0 = "skip load resource for "
            java.lang.String r1 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)     // Catch:{ all -> 0x0503 }
            return r9
        L_0x0056:
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5UrlHelper.purifyUrl(r18)     // Catch:{ all -> 0x0503 }
            boolean r10 = r7.hasTinyGoOnline     // Catch:{ all -> 0x0503 }
            java.lang.String r11 = "https://appx"
            if (r10 == 0) goto L_0x008a
            boolean r10 = r4.startsWith(r11)     // Catch:{ all -> 0x0503 }
            if (r10 == 0) goto L_0x008a
            java.lang.String r10 = "hasTinyGoOnline true use tinyRes again "
            java.lang.String r12 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r10 = r10.concat(r12)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r10)     // Catch:{ all -> 0x0503 }
            java.lang.String r10 = r16.getTinyResFallbackUrl()     // Catch:{ all -> 0x0503 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0503 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r1 = r16.getTinyResFallbackUrl()     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r4.replace(r6, r1)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildOnlineContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x008a:
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r10 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r12 = "NO"
            java.lang.String r15 = "text/html"
            if (r10 == 0) goto L_0x0227
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r10 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            byte[] r10 = r10.get(r4)     // Catch:{ all -> 0x0503 }
            boolean r9 = r7.mTryConcatOnlineHost     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x00c8
            if (r10 != 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c8
            java.lang.String r9 = r7.onlineHost     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x00c8
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r9 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r10 = r7.onlineHost     // Catch:{ all -> 0x0503 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            r13.<init>()     // Catch:{ all -> 0x0503 }
            java.lang.String r14 = r17.getHost()     // Catch:{ all -> 0x0503 }
            r13.append(r14)     // Catch:{ all -> 0x0503 }
            java.lang.String r14 = r17.getPath()     // Catch:{ all -> 0x0503 }
            r13.append(r14)     // Catch:{ all -> 0x0503 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0503 }
            java.lang.String r10 = r10.concat(r13)     // Catch:{ all -> 0x0503 }
            byte[] r10 = r9.get(r10)     // Catch:{ all -> 0x0503 }
        L_0x00c8:
            if (r10 == 0) goto L_0x0227
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0503 }
            r1.<init>(r10)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = com.alipay.mobile.h5container.api.H5PageLoader.mainUrl     // Catch:{ all -> 0x0503 }
            boolean r6 = android.text.TextUtils.equals(r5, r6)     // Catch:{ all -> 0x0503 }
            if (r6 == 0) goto L_0x00e4
            java.util.concurrent.Executor r5 = com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory.getSingleThreadExecutor()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$1 r6 = new com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$1     // Catch:{ all -> 0x0503 }
            r6.<init>(r4)     // Catch:{ all -> 0x0503 }
            r5.execute(r6)     // Catch:{ all -> 0x0503 }
            goto L_0x00f7
        L_0x00e4:
            boolean r6 = r7.mHasResourceOffline     // Catch:{ all -> 0x0503 }
            if (r6 != 0) goto L_0x00f7
            r6 = 1
            r7.mHasResourceOffline = r6     // Catch:{ all -> 0x0503 }
            java.util.concurrent.Executor r6 = com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory.getSingleThreadExecutor()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$2 r9 = new com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$2     // Catch:{ all -> 0x0503 }
            r9.<init>(r5)     // Catch:{ all -> 0x0503 }
            r6.execute(r9)     // Catch:{ all -> 0x0503 }
        L_0x00f7:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = "load response from "
            r5.<init>(r6)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = r7.mAppId     // Catch:{ all -> 0x0503 }
            r5.append(r6)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = " version:"
            r5.append(r6)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r6 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = r6.currentUseVersion     // Catch:{ all -> 0x0503 }
            r5.append(r6)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = " package "
            r5.append(r6)     // Catch:{ all -> 0x0503 }
            r5.append(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r5)     // Catch:{ all -> 0x0503 }
            r7.monitorMatchPerformance(r4, r2)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5FileUtil.getFileExtensionFromUrl(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r0.getMimeType()     // Catch:{ all -> 0x0503 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0503 }
            if (r2 == 0) goto L_0x0226
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0226
            java.lang.String r1 = "h5_check_mime_type"
            java.lang.String r1 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = "mime type check enabled: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r2)     // Catch:{ all -> 0x0503 }
            boolean r1 = r12.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x0226
            java.lang.String r1 = "try to implement mime type for : "
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = "h5_mime_type_url_map"
            java.lang.String r1 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r1)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r2 = "mime type map: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x01a8 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r2)     // Catch:{ Exception -> 0x01a8 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01a8 }
            if (r2 != 0) goto L_0x01a6
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$3 r2 = new com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$3     // Catch:{ Exception -> 0x01a8 }
            r2.<init>()     // Catch:{ Exception -> 0x01a8 }
            r3 = 0
            com.alibaba.a.b.c[] r3 = new com.alibaba.a.b.c[r3]     // Catch:{ Exception -> 0x01a8 }
            java.lang.Object r1 = com.alibaba.a.e.parseObject((java.lang.String) r1, r2, (com.alibaba.a.b.c[]) r3)     // Catch:{ Exception -> 0x01a8 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x01a8 }
            if (r1 == 0) goto L_0x0197
            int r2 = r1.size()     // Catch:{ Exception -> 0x01a8 }
            if (r2 <= 0) goto L_0x0197
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x01a8 }
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0198
        L_0x0197:
            r9 = 0
        L_0x0198:
            java.lang.String r1 = "mime type from configuration: "
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ Exception -> 0x01a9 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x01ae
        L_0x01a6:
            r9 = 0
            goto L_0x01ae
        L_0x01a8:
            r9 = 0
        L_0x01a9:
            java.lang.String r1 = "parse mime type url config exception"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x0503 }
        L_0x01ae:
            com.alipay.mobile.nebula.provider.H5ProviderManager r1 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()     // Catch:{ all -> 0x0503 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppUrlMapProvider> r2 = com.alipay.mobile.nebula.provider.H5AppUrlMapProvider.class
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0503 }
            java.lang.Object r1 = r1.getProvider(r2)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.provider.H5AppUrlMapProvider r1 = (com.alipay.mobile.nebula.provider.H5AppUrlMapProvider) r1     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x01e4
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0503 }
            if (r2 == 0) goto L_0x01e4
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r2 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r2.getVersion()     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r7.mAppId     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.mapUrl(r4, r3, r2)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5FileUtil.getMimeType((java.lang.String) r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = "mime type from url map: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r2)     // Catch:{ all -> 0x0503 }
            goto L_0x01e5
        L_0x01e4:
            r1 = r9
        L_0x01e5:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0503 }
            if (r2 == 0) goto L_0x01f5
            java.lang.String r1 = "mime type by default: "
            java.lang.String r1 = r1.concat(r15)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ all -> 0x0503 }
            goto L_0x01f6
        L_0x01f5:
            r15 = r1
        L_0x01f6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = "implement MimeType: "
            r1.<init>(r2)     // Catch:{ all -> 0x0503 }
            r1.append(r15)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = ", original url: "
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            r1.append(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = ", appId: "
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r7.mAppId     // Catch:{ all -> 0x0503 }
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = ", version: "
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r7.version     // Catch:{ all -> 0x0503 }
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ all -> 0x0503 }
            r0.setMimeType(r15)     // Catch:{ all -> 0x0503 }
        L_0x0226:
            return r0
        L_0x0227:
            byte[] r9 = com.alipay.mobile.nebulacore.appcenter.center.H5GlobalPackage.getContent(r4)     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x023d
            r16.onGlobalResourceHit(r17)     // Catch:{ all -> 0x0503 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0503 }
            r1.<init>(r9)     // Catch:{ all -> 0x0503 }
            r7.monitorMatchPerformance(r4, r2)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x023d:
            com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg r9 = com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg.getInstance()     // Catch:{ all -> 0x0503 }
            byte[] r9 = r9.getContent(r4)     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x0254
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0503 }
            r1.<init>(r9)     // Catch:{ all -> 0x0503 }
            r7.monitorMatchPerformance(r4, r2)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0254:
            java.lang.String r9 = r7.mAppId     // Catch:{ all -> 0x0503 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0503 }
            if (r9 != 0) goto L_0x028c
            java.lang.String r9 = r7.mAppId     // Catch:{ all -> 0x0503 }
            java.lang.String r10 = "_online"
            boolean r9 = r9.endsWith(r10)     // Catch:{ all -> 0x0503 }
            if (r9 != 0) goto L_0x028c
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r9 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = r9.currentUseVersion     // Catch:{ all -> 0x0503 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x028c
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0503 }
            if (r9 != 0) goto L_0x028c
            java.lang.String r9 = r7.onlineHost     // Catch:{ all -> 0x0503 }
            boolean r9 = r4.startsWith(r9)     // Catch:{ all -> 0x0503 }
            if (r9 == 0) goto L_0x028c
            java.lang.String r9 = "IO"
            java.util.concurrent.ThreadPoolExecutor r9 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r9)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$4 r10 = new com.alipay.mobile.nebulacore.core.H5ContentProviderImpl$4     // Catch:{ all -> 0x0503 }
            r10.<init>(r5)     // Catch:{ all -> 0x0503 }
            r9.execute(r10)     // Catch:{ all -> 0x0503 }
        L_0x028c:
            java.util.HashMap<java.lang.String, java.lang.String> r9 = r7.mContentMap     // Catch:{ all -> 0x0503 }
            java.lang.Object r9 = r9.remove(r5)     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0503 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0503 }
            if (r10 != 0) goto L_0x02a4
            java.lang.String r0 = "load response from map local."
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r15, (java.lang.String) r9)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x02a4:
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x02b4
            java.lang.String r1 = r7.offlineHost     // Catch:{ all -> 0x0503 }
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x02b4
            r1 = 1
            goto L_0x02b5
        L_0x02b4:
            r1 = 0
        L_0x02b5:
            java.lang.String r9 = "https://alipay.com/h5container/un_safe.html"
            boolean r9 = r9.equals(r4)     // Catch:{ all -> 0x0503 }
            if (r9 != 0) goto L_0x04ef
            if (r1 == 0) goto L_0x02c1
            goto L_0x04ef
        L_0x02c1:
            java.lang.String r1 = "https://alipay.com/h5container/redirect_link.html"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = "url"
            java.lang.String r10 = "####"
            if (r1 == 0) goto L_0x02e5
            int r0 = com.alipay.mobile.nebulacore.R.raw.h5_redirect_link     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r0)     // Catch:{ all -> 0x0503 }
            android.net.Uri r1 = android.net.Uri.parse(r18)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.getQueryParameter(r9)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = r0.replace(r10, r1)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r15, (java.lang.String) r0)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x02e5:
            java.lang.String r1 = "https://alipay.com/h5container/white_link.html"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x02f4
            int r0 = com.alipay.mobile.nebulacore.R.raw.h5_white_link     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent(r0)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x02f4:
            java.lang.String r1 = "https://alipay.com/h5container/security_link.html"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0313
            int r0 = com.alipay.mobile.nebulacore.R.raw.h5_security_link     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r0)     // Catch:{ all -> 0x0503 }
            android.net.Uri r1 = android.net.Uri.parse(r18)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.getQueryParameter(r9)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = r0.replace(r10, r1)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r15, (java.lang.String) r0)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0313:
            java.lang.String r1 = "https://a.alipayobjects.com/bridgeapi/1.0/jsready.js"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x033b
            java.lang.String r0 = "load response for h5 js bridge"
            com.alipay.mobile.nebula.util.H5Log.w(r8, r0)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.h5container.api.H5Page r0 = r7.mH5Page     // Catch:{ all -> 0x0503 }
            boolean r0 = r0 instanceof com.alipay.mobile.nebulacore.core.H5PageImpl     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x0333
            com.alipay.mobile.h5container.api.H5Page r0 = r7.mH5Page     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.core.H5PageImpl r0 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r0     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.web.H5ScriptLoader r0 = r0.getScriptLoader()     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = r0.composeBridge()     // Catch:{ all -> 0x0503 }
            goto L_0x0334
        L_0x0333:
            r9 = 0
        L_0x0334:
            java.lang.String r0 = "application/javascript"
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x033b:
            java.lang.String r1 = "/favicon.ico"
            boolean r1 = r5.endsWith(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x04e1
            java.lang.String r1 = "/favicon.png"
            boolean r1 = r5.endsWith(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x04e1
            java.lang.String r1 = "/favicon2.ico"
            boolean r1 = r5.endsWith(r1)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0355
            goto L_0x04e1
        L_0x0355:
            com.alipay.mobile.nebula.provider.H5ResProvider r1 = r7.resProvider     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0371
            com.alipay.mobile.nebula.provider.H5ResProvider r1 = r7.resProvider     // Catch:{ all -> 0x0503 }
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0371
            java.lang.String r1 = "load response from resource provider."
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.provider.H5ResProvider r1 = r7.resProvider     // Catch:{ all -> 0x0503 }
            java.io.InputStream r1 = r1.getResource(r4)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0371:
            boolean r1 = r4.startsWith(r11)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x03b3
            java.lang.String r1 = r7.getUrlFromOnline(r4)     // Catch:{ all -> 0x0503 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x0399
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            r1.<init>()     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r16.getTinyResFallbackUrl()     // Catch:{ all -> 0x0503 }
            r1.append(r2)     // Catch:{ all -> 0x0503 }
            r1.append(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildOnlineContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0399:
            java.lang.String r1 = r16.getTinyResFallbackUrl()     // Catch:{ all -> 0x0503 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x03b3
            r1 = 1
            r7.hasTinyGoOnline = r1     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r16.getTinyResFallbackUrl()     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r4.replace(r6, r1)     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildOnlineContent(r0, r4, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x03b3:
            boolean r0 = r7.enableFallback     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x03bc
            java.lang.String r0 = r7.getFallback(r5)     // Catch:{ all -> 0x0503 }
            goto L_0x03bd
        L_0x03bc:
            r0 = 0
        L_0x03bd:
            boolean r1 = r7.enableFallback     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x03e7
            boolean r1 = r7.enableFallbackUrl     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x03e7
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0503 }
            if (r1 != 0) goto L_0x03dd
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5UrlHelper.getPath(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r9 = com.alipay.mobile.nebula.util.H5FileUtil.getMimeType((java.lang.String) r1)     // Catch:{ all -> 0x0503 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0503 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0503 }
            r1.<init>(r0)     // Catch:{ all -> 0x0503 }
            goto L_0x03df
        L_0x03dd:
            r1 = 0
            r9 = 0
        L_0x03df:
            android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = "fallbackUrl"
            r0.<init>(r9, r2, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x03e7:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r6 = "pageLoad|loadFrom"
            if (r1 != 0) goto L_0x04a6
            if (r20 == 0) goto L_0x04a6
            com.alipay.mobile.nebulacore.web.H5InputStream r9 = new com.alipay.mobile.nebulacore.web.H5InputStream     // Catch:{ all -> 0x0503 }
            r9.<init>(r0, r7)     // Catch:{ all -> 0x0503 }
            java.io.InputStream r1 = r9.realStream     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x041c
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r1 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x041c
            if (r21 == 0) goto L_0x040e
            r1 = r16
            r2 = r9
            r3 = r4
            r4 = r0
            r5 = r18
            r6 = r19
            android.webkit.WebResourceResponse r0 = r1.getFallbackStreamAsync(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x040e:
            r1 = r16
            r2 = r9
            r3 = r4
            r4 = r0
            r5 = r18
            r6 = r19
            android.webkit.WebResourceResponse r0 = r1.getFallbackStream(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x041c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = "load response from fallback statusCode "
            r1.<init>(r4)     // Catch:{ all -> 0x0503 }
            int r4 = r9.statusCode     // Catch:{ all -> 0x0503 }
            r1.append(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r4 = " fallbackUrl:"
            r1.append(r4)     // Catch:{ all -> 0x0503 }
            r1.append(r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r1)     // Catch:{ all -> 0x0503 }
            boolean r1 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x044c
            if (r19 == 0) goto L_0x044c
            java.lang.String r1 = r19.getUrl()     // Catch:{ all -> 0x0503 }
            boolean r1 = android.text.TextUtils.equals(r5, r1)     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x044c
            java.lang.String r1 = "fallback"
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r6, r1)     // Catch:{ all -> 0x0503 }
        L_0x044c:
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r1 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            if (r1 == 0) goto L_0x0457
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage r1 = r7.contentPackage     // Catch:{ all -> 0x0503 }
            java.lang.String r1 = r1.getFallbackReason()     // Catch:{ all -> 0x0503 }
            goto L_0x0459
        L_0x0457:
            java.lang.String r1 = "contentPackageIsNull"
        L_0x0459:
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r4 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ all -> 0x0503 }
            r4.<init>()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r4 = r4.success()     // Catch:{ all -> 0x0503 }
            java.lang.String r5 = "H5_CONTAINER_MATCH_RES_FALLBACK"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r4 = r4.seedId(r5)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r4 = r4.appendUrl(r0)     // Catch:{ all -> 0x0503 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0503 }
            long r5 = r5 - r2
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r4.appendCostTime(r5)     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r7.mAppId     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendSubappId(r3)     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r7.version     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendPackageVersion(r3)     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = "fallbackReason"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r2.appendExtParams(r3, r1)     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = "statusCode"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0503 }
            r3.<init>()     // Catch:{ all -> 0x0503 }
            int r4 = r9.statusCode     // Catch:{ all -> 0x0503 }
            r3.append(r4)     // Catch:{ all -> 0x0503 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendExtParams(r2, r3)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r1)     // Catch:{ all -> 0x0503 }
            java.io.InputStream r1 = r9.realStream     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r0, (java.io.InputStream) r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x04a6:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04bb
            if (r19 == 0) goto L_0x04bb
            java.lang.String r0 = r19.getUrl()     // Catch:{ all -> 0x0503 }
            boolean r0 = android.text.TextUtils.equals(r5, r0)     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04bb
            java.lang.String r0 = "online"
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r6, r0)     // Catch:{ all -> 0x0503 }
        L_0x04bb:
            java.lang.String r0 = "load response from web "
            java.lang.String r1 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)     // Catch:{ all -> 0x0503 }
            boolean r0 = r7.mFirstReq     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04d2
            r7.setLocal(r12)     // Catch:{ all -> 0x0503 }
            r0 = 0
            r7.mFirstReq = r0     // Catch:{ all -> 0x0503 }
        L_0x04d2:
            com.alipay.mobile.nebula.resourcehandler.H5ResourceHandler r0 = r7.h5ResourceHandler     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04df
            com.alipay.mobile.nebula.resourcehandler.H5ResourceHandler r0 = r7.h5ResourceHandler     // Catch:{ all -> 0x0503 }
            android.webkit.WebResourceResponse r0 = r0.shouldInterceptRequest(r5)     // Catch:{ all -> 0x0503 }
            if (r0 == 0) goto L_0x04df
            return r0
        L_0x04df:
            r1 = 0
            return r1
        L_0x04e1:
            java.lang.String r0 = "favicon request intercepted"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = "image/x-icon"
            java.lang.String r1 = ""
            android.webkit.WebResourceResponse r0 = r7.buildContent((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x04ef:
            java.lang.String r0 = "load response forbidden by safe strategy."
            com.alipay.mobile.nebula.util.H5Log.w(r8, r0)     // Catch:{ all -> 0x0503 }
            java.lang.String r0 = r7.unsafeUrl     // Catch:{ all -> 0x0503 }
            com.alipay.mobile.nebulacore.web.H5InputStream r1 = new com.alipay.mobile.nebulacore.web.H5InputStream     // Catch:{ all -> 0x0503 }
            java.lang.String r2 = r7.unsafeUrl     // Catch:{ all -> 0x0503 }
            r1.<init>(r2, r7)     // Catch:{ all -> 0x0503 }
            r2 = 0
            android.webkit.WebResourceResponse r0 = r7.buildContent(r2, r0, r1)     // Catch:{ all -> 0x0503 }
            return r0
        L_0x0503:
            r0 = move-exception
            java.lang.String r1 = "load response from web catch exception "
            com.alipay.mobile.nebula.util.H5Log.e(r8, r1, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5ContentProviderImpl.getContent(android.net.Uri, java.lang.String, com.alipay.mobile.h5container.api.H5Page, boolean, boolean):android.webkit.WebResourceResponse");
    }

    private void monitorMatchPerformance(String str, long j) {
        if (this.random != null) {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            double d2 = MATCH_RES_SAMPLE_RATE_DEFAULT;
            if (h5ConfigProvider != null) {
                try {
                    d2 = Double.parseDouble(h5ConfigProvider.getConfig(KEY_MATCH_RES_SAMPLE_RATE));
                } catch (Exception unused) {
                    H5Log.e(TAG, "parse sample config failed");
                }
            }
            if (this.random.nextDouble() <= d2) {
                H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_MATCH_RES).appendCostTime(System.currentTimeMillis() - j).appendSubappId(this.mAppId).appendPackageVersion(this.version).appendUrl(str));
            }
        }
    }

    private String getTinyResFallbackUrl() {
        H5AppCenterPresetProvider h5AppCenterPresetProvider;
        if (TextUtils.isEmpty(this.tinyResFallbackUrl) && (h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName())) != null) {
            String tinyCommonApp = h5AppCenterPresetProvider.getTinyCommonApp();
            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
            if (h5AppProvider != null) {
                String version2 = h5AppProvider.getVersion(tinyCommonApp);
                this.tinyResFallbackUrl = h5AppProvider.getH5AppCdnBaseUrl(tinyCommonApp, version2);
                H5Log.d(TAG, "getTinyResFallbackUrl " + tinyCommonApp + " " + version2 + " " + this.tinyResFallbackUrl);
            }
        }
        return this.tinyResFallbackUrl;
    }

    private String getUrlFromOnline(String str) {
        e jSONObject;
        e eVar = this.tinyConfig;
        if (eVar != null && !eVar.isEmpty() && !"no".equalsIgnoreCase(H5Utils.getString(this.tinyConfig, "switch")) && (jSONObject = H5Utils.getJSONObject(this.tinyConfig, "content", (e) null)) != null && !jSONObject.isEmpty()) {
            String string = jSONObject.getString(str);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public byte[] getLocalResource(String str) {
        H5ContentPackage h5ContentPackage = this.contentPackage;
        if (h5ContentPackage != null) {
            return h5ContentPackage.get(str);
        }
        return null;
    }

    public int getLottieAnimationImgsCount(String str) {
        H5ContentPackage h5ContentPackage = this.contentPackage;
        int i2 = 0;
        if (h5ContentPackage == null) {
            return 0;
        }
        for (String startsWith : h5ContentPackage.keySet()) {
            if (startsWith.startsWith(str)) {
                i2++;
            }
        }
        return i2;
    }

    public String getContentPackageStatus() {
        H5ContentPackage h5ContentPackage = this.contentPackage;
        if (h5ContentPackage == null) {
            return "";
        }
        if (h5ContentPackage.size() > 0) {
            return "|" + this.contentPackage.getAppId() + "_Y_" + this.contentPackage.getVersion();
        }
        return "|" + this.contentPackage.getAppId() + "_N_" + this.contentPackage.getVersion();
    }

    private WebResourceResponse buildOnlineContent(Uri uri, String str, String str2) {
        H5LogProvider h5LogProvider = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
        if (h5LogProvider != null) {
            String str3 = "^url=" + str + "^targetUrl=" + str2;
            h5LogProvider.log("H5_AL_PAGE_RES_REDIRECT", this.mAppId, this.version, str3, str3);
        }
        H5InputStream h5InputStream = new H5InputStream(str2, this);
        H5Log.d(TAG, "load response from tinyRes online ".concat(String.valueOf(str2)));
        return buildContent(uri, str, h5InputStream);
    }

    private WebResourceResponse getFallbackStream(H5InputStream h5InputStream, String str, String str2, String str3, H5Page h5Page) {
        byte[] inputToByte = H5IOUtils.inputToByte(h5InputStream.realStream);
        if (inputToByte != null) {
            this.contentPackage.put(str, inputToByte);
        }
        handleFallbackInfo(h5InputStream, h5Page, str3, str, str2, false);
        try {
            h5InputStream.close();
        } catch (Throwable th) {
            H5Log.d(TAG, "getFallbackStream ".concat(String.valueOf(th)));
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputToByte);
        this.mInputStreamList.add(byteArrayInputStream);
        return buildContent(str2, (InputStream) byteArrayInputStream);
    }

    private WebResourceResponse getFallbackStreamAsync(H5InputStream h5InputStream, String str, String str2, String str3, H5Page h5Page) throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.mFallbackExecutor == null) {
            this.mFallbackExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        synchronized (this.mFallbackExecutor) {
            if (!this.mFallbackExecutor.isShutdown()) {
                final H5InputStream h5InputStream2 = h5InputStream;
                final String str4 = str;
                this.mFallbackExecutor.execute(new Runnable() {
                    public void run() {
                        int read;
                        byte[] buf = H5IOUtils.getBuf(EmiUtil.EMI_PLAN_REQUEST_CODE);
                        while (h5InputStream2.realStream != null && (read = h5InputStream2.realStream.read(buf)) != -1) {
                            try {
                                pipedOutputStream.write(buf, 0, read);
                                byteArrayOutputStream.write(buf, 0, read);
                            } catch (Throwable th) {
                                H5IOUtils.returnBuf(buf);
                                H5IOUtils.closeQuietly(pipedOutputStream);
                                H5IOUtils.closeQuietly(h5InputStream2);
                                throw th;
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!(H5ContentProviderImpl.this.contentPackage == null || byteArray == null)) {
                            H5ContentProviderImpl.this.contentPackage.put(str4, byteArray);
                        }
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(pipedOutputStream);
                        H5IOUtils.closeQuietly(h5InputStream2);
                    }
                });
                handleFallbackInfo(h5InputStream, h5Page, str3, str, str2, true);
                WebResourceResponse buildContent = buildContent(str2, (InputStream) pipedInputStream);
                return buildContent;
            }
            try {
                pipedOutputStream.close();
                h5InputStream.close();
                return null;
            } catch (Throwable th) {
                H5Log.e(TAG, "getFallbackStreamAsync", th);
                return null;
            }
        }
    }

    private void handleFallbackInfo(H5InputStream h5InputStream, H5Page h5Page, String str, String str2, String str3, boolean z) {
        H5Log.d(TAG, "load response from fallback statusCode " + h5InputStream.statusCode + " fallbackUrl:" + str3 + " add fallback to contentPackage " + str2 + " isAsync: " + z);
        if (this.mFirstReq) {
            setLocal("NO");
            this.mFirstReq = false;
        }
        if (Nebula.DEBUG && h5Page != null && TextUtils.equals(str, h5Page.getUrl())) {
            TestDataUtils.storeJSParams("pageLoad|loadFrom", "fallback");
        }
        String string = H5Utils.getString(this.mBundle, "url");
        H5Log.d(TAG, "fallback showProgress start_up_url is " + string + ", pureUrl is " + str2);
        if (TextUtils.equals(string, str2) && this.mH5Page != null) {
            H5Log.d(TAG, "fallback showProgress");
            this.mH5Page.sendEvent(H5Plugin.InternalEvents.SHOW_PROGRESSBAR_WHEN_FALLBACK, (e) null);
        }
    }

    public WebResourceResponse getContent(String str) {
        return getContent((Uri) null, str, (H5Page) null, true, false);
    }

    public WebResourceResponse getContent(String str, boolean z) {
        return getContent((Uri) null, str, (H5Page) null, z, false);
    }

    public void getContent(final String str, final H5ContentProvider.ResponseListen responseListen) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                try {
                    if (responseListen != null) {
                        WebResourceResponse content = H5ContentProviderImpl.this.getContent(str);
                        if (content != null) {
                            responseListen.onGetResponse(content);
                        } else {
                            responseListen.onGetResponse(H5ContentProviderImpl.this.buildContent(str, (InputStream) new H5InputStream(str, H5ContentProviderImpl.this)));
                        }
                    }
                } catch (Throwable th) {
                    H5Log.e(H5ContentProviderImpl.TAG, th);
                }
            }
        });
    }

    private boolean enableUseGetContentOnUi() {
        if (this.useGetContentOnUi == null) {
            if ("no".equalsIgnoreCase(H5Environment.getConfig("h5_enableUseGetContentOnUi"))) {
                this.useGetContentOnUi = Boolean.FALSE;
            } else {
                this.useGetContentOnUi = Boolean.TRUE;
            }
        }
        return this.useGetContentOnUi.booleanValue();
    }

    public void getContentOnUi(String str, H5ContentProvider.ResponseListen responseListen) {
        if (responseListen == null) {
            try {
                H5Log.d(TAG, "responseListen == null");
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        } else if (!enableUseGetContentOnUi()) {
            getContent(str, responseListen);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = this.contentPackage.get(str);
            if (bArr != null) {
                responseListen.onGetResponse(buildContent((Uri) null, str, new ByteArrayInputStream(bArr)));
                H5Log.d(TAG, "getContentOnUi form contentPackage:" + (System.currentTimeMillis() - currentTimeMillis) + " " + str);
                return;
            }
            final String str2 = str;
            final H5ContentProvider.ResponseListen responseListen2 = responseListen;
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    try {
                        final WebResourceResponse content = H5ContentProviderImpl.this.getContent(str2);
                        if (content != null) {
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    if (responseListen2 != null) {
                                        H5Log.d(H5ContentProviderImpl.TAG, "getContentOnUi form getContent:" + (System.currentTimeMillis() - currentTimeMillis) + " " + str2);
                                        responseListen2.onGetResponse(content);
                                    }
                                }
                            });
                            return;
                        }
                        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(H5IOUtils.inputToByte(new H5InputStream(str2, H5ContentProviderImpl.this)));
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                if (responseListen2 != null) {
                                    H5Log.d(H5ContentProviderImpl.TAG, "getContentOnUi form getContent:" + (System.currentTimeMillis() - currentTimeMillis) + " " + str2);
                                    responseListen2.onGetResponse(H5ContentProviderImpl.this.buildContent(str2, byteArrayInputStream));
                                }
                            }
                        });
                    } catch (Throwable th) {
                        H5Log.e(H5ContentProviderImpl.TAG, th);
                        H5ContentProvider.ResponseListen responseListen = responseListen2;
                        if (responseListen != null) {
                            responseListen.onGetResponse((WebResourceResponse) null);
                        }
                    }
                }
            });
        }
    }

    public void mapContent(String str, String str2) {
        this.mContentMap.put(str, str2);
    }

    public void setEnableFallbackUrl(boolean z) {
        this.enableFallbackUrl = z;
    }

    private String getFallback(String str) {
        String str2 = str;
        String str3 = this.mapHost ? this.onlineHost : this.offlineHost;
        if (TextUtils.isEmpty(this.cdnHost) || TextUtils.isEmpty(str3)) {
            H5Log.w(TAG, "cdn url or install host empty!");
            return null;
        } else if (!str2.startsWith(str3)) {
            H5Log.w(TAG, "url not starts with host");
            return null;
        } else {
            if (this.cdnHost != null && str3.endsWith("/") && !this.cdnHost.endsWith("/")) {
                this.cdnHost += "/";
            }
            String replace = str2.replace(str3, this.cdnHost);
            H5Log.d(TAG, "fallback final url ".concat(String.valueOf(replace)));
            if (this.mH5Page != null) {
                H5ContentPackage h5ContentPackage = this.contentPackage;
                String fallbackReason = h5ContentPackage != null ? h5ContentPackage.getFallbackReason() : "contentPackageIsNull";
                if (TextUtils.equals(str2, H5PageLoader.mainUrl)) {
                    H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_SESSION_FALLBACK, (String) null, "fallbackReason=" + fallbackReason + "^isNebulaApp=" + this.isNebulaApp, this.mH5Page.getPageData().getPageInfo(), "fallbackUrl=".concat(String.valueOf(replace)), "appId=" + this.mH5Page.getPageData().getAppId(), H5Logger.getUniteParam4(this.mH5Page.getPageData(), this.mH5Page.getParams()), "H-MM");
                }
                H5Logger.performanceLoggerV2(H5Logger.H5_AL_SESSION_HTTPPROXY_FAIL, (String) null, (String) null, this.mH5Page.getPageData().getPageInfo(), "fallbackUrl=".concat(String.valueOf(replace)), "appId=" + this.mH5Page.getPageData().getAppId(), H5Logger.getUniteParam4(this.mH5Page.getPageData(), this.mH5Page.getParams()), "H-MM");
            }
            return replace;
        }
    }

    private WebResourceResponse buildContent(int i2) {
        return new WebResourceResponse("text/html", AppConstants.UTF_8, H5Environment.getResources().openRawResource(i2));
    }

    private WebResourceResponse buildContent(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        byte[] bArr = null;
        try {
            bArr = str2.getBytes("utf-8");
        } catch (Exception e2) {
            H5Log.e(TAG, "failed to get byte array", e2);
        }
        return new WebResourceResponse(str, AppConstants.UTF_8, new ByteArrayInputStream(bArr));
    }

    private WebResourceResponse buildContent(Uri uri, String str, InputStream inputStream) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            if (uri == null) {
                uri = H5UrlHelper.parseUrl(str);
            }
            if (uri != null) {
                str2 = H5FileUtil.getMimeType(uri.getPath());
            }
            H5Log.d(TAG, "url:" + str + " mimeType:" + str2);
        }
        if (this.mFirstReq) {
            setLocal(H5Param.DEFAULT_LONG_PRESSO_LOGIN);
            setFirstReq(false);
        }
        return new WebResourceResponse(str2, AppConstants.UTF_8, inputStream);
    }

    /* access modifiers changed from: private */
    public WebResourceResponse buildContent(String str, InputStream inputStream) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = H5FileUtil.getMimeType(H5UrlHelper.getPath(str));
            H5Log.d(TAG, "url:" + str + " mimeType:" + str2);
        } else {
            str2 = null;
        }
        if (this.mFirstReq) {
            setLocal(H5Param.DEFAULT_LONG_PRESSO_LOGIN);
            setFirstReq(false);
        }
        return new WebResourceResponse(str2, AppConstants.UTF_8, inputStream);
    }

    public void onInputClose(H5InputStream h5InputStream) {
        H5Log.debug(TAG, "on input stream close.");
        this.mConnList.remove(h5InputStream);
    }

    public void onInputOpen(H5InputStream h5InputStream) {
        H5Log.debug(TAG, "on input stream open.");
        this.mConnList.add(h5InputStream);
    }

    public void onInputException() {
        this.hasInputException = true;
        H5Log.d(TAG, "h5InputStream exception");
    }

    public void clearInputException() {
        this.hasInputException = false;
    }

    public boolean hasInputException() {
        return this.hasInputException;
    }

    public void disconnect() {
        try {
            H5Log.debug(TAG, "disconnect connList " + this.mConnList.size());
            synchronized (this.mConnList) {
                for (int i2 = 0; i2 < this.mConnList.size(); i2++) {
                    H5InputStream h5InputStream = this.mConnList.get(i2);
                    if (h5InputStream != null) {
                        try {
                            h5InputStream.close();
                        } catch (Exception e2) {
                            H5Log.e(TAG, "close connection exception.", e2);
                        }
                    }
                }
                this.mConnList.clear();
            }
            H5Log.debug(TAG, "disconnect inputStreamList " + this.mInputStreamList.size());
            synchronized (this.mInputStreamList) {
                for (InputStream close : this.mInputStreamList) {
                    try {
                        close.close();
                    } catch (Exception e3) {
                        H5Log.e(TAG, (Throwable) e3);
                    }
                }
                this.mInputStreamList.clear();
            }
        } catch (Exception e4) {
            H5Log.e(TAG, (Throwable) e4);
        }
    }

    private void onGlobalResourceHit(final Uri uri) {
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                try {
                    if (uri != null) {
                        H5Logger.performanceH5Exception(H5Logger.H5_AL_SESSION_HTTPPROXY, (String) null, (String) null, (String) null, "^targetUrl=" + uri.toString() + "^localFile=" + uri.getPath(), H5Logger.getUniteParam4(H5ContentProviderImpl.this.mH5Page.getPageData(), H5ContentProviderImpl.this.mH5Page.getParams()), (String) null, "H-MM", "");
                    }
                } catch (Exception e2) {
                    H5Log.e(H5ContentProviderImpl.TAG, "reqEndLog catch exception ", e2);
                }
            }
        });
    }

    public void releaseContent() {
        H5Log.d(TAG, "releaseContent");
        H5ContentPackage h5ContentPackage = this.contentPackage;
        if (h5ContentPackage != null) {
            h5ContentPackage.releaseContent();
        }
        H5ContentPackagePool.clearPackage(this.sessionId);
        ExecutorService executorService = this.mFallbackExecutor;
        if (executorService != null) {
            try {
                executorService.shutdown();
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
        this.mH5Page = null;
    }

    private void setLocal(String str) {
        this.mIsLocal = str;
        this.mFirstReq = false;
    }

    public void reSetLocal() {
        this.mIsLocal = H5Param.DEFAULT_LONG_PRESSO_LOGIN;
        this.mFirstReq = true;
    }

    public H5ContentPackage getContentPackage() {
        return this.contentPackage;
    }

    public String getLocal() {
        return this.mIsLocal;
    }

    private void setFirstReq(boolean z) {
        this.mFirstReq = z;
    }
}
