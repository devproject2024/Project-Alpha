package com.alipay.mobile.nebulacore.dev.provider;

import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.dev.H5BugmeLogCollector;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.process.H5IpcServer;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.api.NebulaService;
import com.alipay.mobile.nebulacore.dev.ui.H5DevSettingsActivity;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.HashMap;

public class H5BugMeManagerImpl implements H5BugMeManager {
    private static final String TAG = "H5BugMeManagerImpl";
    private LruCache<String, Boolean> mAccessCache = new LruCache<>(10);
    private boolean mAlreadySetup = false;
    private boolean mBugMeAccessCheckedInTiny = false;
    private boolean mBugMeHasAccessInTiny = false;
    private String[] mDomainWhiteList = null;
    private boolean mDumpEnabled = H5BugmeLogCollector.enabled();
    private H5DevDebugProvider mH5DevDebugProvider = null;
    private H5DevPlugin mH5DevPlugin = null;

    public void setUp() {
        if (!this.mAlreadySetup) {
            H5Log.d(TAG, "setUpBugMe");
            if (H5Utils.isMainProcess()) {
                H5DevConfig.resetBugMeSettings();
            }
            if (H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DEBUG_SWITCH, false) || this.mDumpEnabled) {
                ensureProviderAndPlugin();
            }
            this.mAlreadySetup = true;
        }
    }

    private void ensureProviderAndPlugin() {
        if (this.mH5DevPlugin == null) {
            H5Log.d(TAG, "create DevPlugin & BugMeProvider");
            this.mH5DevPlugin = new H5DevPlugin();
            this.mH5DevDebugProvider = new H5WalletDevDebugProvider(this);
            H5Utils.getH5ProviderManager().setProvider(H5DevDebugProvider.class.getName(), this.mH5DevDebugProvider);
            Nebula.getService().getPluginManager().register((H5Plugin) this.mH5DevPlugin);
        }
    }

    private void releaseProviderAndPlugin() {
        if (this.mH5DevPlugin != null) {
            H5Log.d(TAG, "release DevPlugin & BugMeProvider");
            H5Utils.getH5ProviderManager().removeProvider(H5DevDebugProvider.class.getName());
            Nebula.getService().getPluginManager().unregister((H5Plugin) this.mH5DevPlugin);
            this.mH5DevPlugin = null;
            this.mH5DevDebugProvider = null;
        }
    }

    public void release() {
        if (!this.mDumpEnabled) {
            releaseProviderAndPlugin();
        }
        this.mAccessCache.evictAll();
        this.mDomainWhiteList = null;
        H5DevConfig.resetBugMeSettings();
        this.mAlreadySetup = false;
    }

    public void setWebViewDebugging(String str, APWebView aPWebView) {
        if (!TextUtils.isEmpty(str) && aPWebView != null) {
            boolean z = Nebula.DEBUG;
            if (!z && H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_WIRED_DEBUG, false)) {
                z = hasAccessToDebug(str);
            }
            aPWebView.setWebContentsDebuggingEnabled(z);
        }
    }

    public void setDomainWhiteList(String[] strArr) {
        this.mDomainWhiteList = strArr;
        this.mAccessCache.evictAll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasAccessToDebug(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "h5_bug_me_super_user"
            boolean r0 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r0, r1)
            r2 = 1
            if (r0 == 0) goto L_0x0012
            return r2
        L_0x0012:
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5UrlHelper.purifyUrl(r7)
            android.util.LruCache<java.lang.String, java.lang.Boolean> r3 = r6.mAccessCache
            java.lang.Object r3 = r3.get(r0)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            if (r3 == 0) goto L_0x0025
            boolean r7 = r3.booleanValue()
            return r7
        L_0x0025:
            java.lang.String r3 = "h5_bug_me_debug_switch"
            boolean r3 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r3, r1)
            if (r3 == 0) goto L_0x0048
            r3 = 0
        L_0x002e:
            java.lang.String[] r4 = r6.mDomainWhiteList
            if (r4 == 0) goto L_0x0047
            int r5 = r4.length
            if (r1 >= r5) goto L_0x0047
            r4 = r4[r1]
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0044
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0044
            r3 = 1
        L_0x0044:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0047:
            r1 = r3
        L_0x0048:
            android.util.LruCache<java.lang.String, java.lang.Boolean> r0 = r6.mAccessCache
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r0.put(r7, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.provider.H5BugMeManagerImpl.hasAccessToDebug(java.lang.String):boolean");
    }

    public void openSettingPanel(boolean z) {
        if (z) {
            H5DevConfig.setBooleanConfig(H5DevConfig.H5_BUG_ME_SHOW_ICON, true);
            H5DevConfig.setBooleanConfig(H5DevConfig.H5_BUG_ME_SUPER_USER, true);
        }
        try {
            Intent intent = new Intent(H5Environment.getContext(), H5DevSettingsActivity.class);
            intent.addFlags(268435456);
            H5Environment.startActivity((H5Context) null, intent);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public void onBugMeSwitched(boolean z) {
        if (z) {
            ensureProviderAndPlugin();
            this.mAccessCache.evictAll();
            H5DevDebugProvider h5DevDebugProvider = this.mH5DevDebugProvider;
            if (h5DevDebugProvider != null) {
                h5DevDebugProvider.welcome("NebulaSDK", "welcome", "NebulaSDK", "welcome to Hybrid Inspector");
            }
        } else {
            release();
        }
        H5Trace.setEnabled(z);
    }

    public void logServiceWorkerOnReceiveValue(HashMap<String, String> hashMap, String str) {
        boolean z = false;
        try {
            if (this.mH5DevDebugProvider != null) {
                z = hasAccessToDebug(hashMap.get("url"));
            } else if (!H5Utils.isMainProcess()) {
                if (!this.mBugMeAccessCheckedInTiny) {
                    H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
                    if (h5EventHandlerService != null) {
                        this.mBugMeHasAccessInTiny = ((H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class)).hasAccessToDebug(hashMap.get("url"));
                        if (this.mBugMeHasAccessInTiny) {
                            setUp();
                        }
                        this.mBugMeAccessCheckedInTiny = true;
                    }
                } else {
                    z = this.mBugMeHasAccessInTiny;
                }
            }
            if (z) {
                logServiceWorkerCallback(hashMap, str);
            }
        } catch (Throwable th) {
            H5Log.e(TAG, "CORE_EVENT_CONSOLE_CALLBACK", th);
        }
    }

    private void logServiceWorkerCallback(HashMap<String, String> hashMap, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.mH5DevDebugProvider != null) {
            String str6 = hashMap.get(AppConstants.NOTIFICATION_DETAILS.EVENT);
            String str7 = hashMap.get("msg");
            String concat = "worker_".concat(String.valueOf(str));
            String str8 = hashMap.get("url");
            NebulaService service = Nebula.getService();
            String str9 = "";
            if (service != null) {
                H5Page topH5Page = service.getTopH5Page();
                try {
                    str5 = topH5Page.getTitle();
                } catch (Throwable unused) {
                    str5 = (topH5Page.getH5TitleBar() == null || topH5Page.getH5TitleBar().getTitle() == null) ? str9 : topH5Page.getH5TitleBar().getTitle().toString();
                }
                if (topH5Page.getWebView() != null) {
                    str9 = topH5Page.getWebView().getSettings().getUserAgentString();
                }
                str2 = H5BugmeIdGenerator.getSessionId(topH5Page);
                str4 = str9;
                str3 = str5;
            } else {
                str2 = str9;
                str4 = str2;
                str3 = str4;
            }
            this.mH5DevDebugProvider.setTitle(concat, str3);
            this.mH5DevDebugProvider.setUserAgent(concat, str4);
            this.mH5DevDebugProvider.setPageUrl(concat, str8);
            this.mH5DevDebugProvider.setSessionId(concat, str2);
            if ("OnReportConsoleMessage".equals(str6)) {
                this.mH5DevDebugProvider.consoleLog("log", concat, str7, (String) null);
            } else if ("OnStarted".equals(str6)) {
                this.mH5DevDebugProvider.pageLog("create", concat, str4, str8, str3, (e) null);
            } else if ("onStopped".equals(str6)) {
                this.mH5DevDebugProvider.pageLog("destroy", concat, str4, str8, str3, (e) null);
            } else if ("OnReportException".equals(str6)) {
                H5Log.e(TAG, "Worker OnReportException: ".concat(String.valueOf(str7)));
                this.mH5DevDebugProvider.consoleLog("error", concat, str7, (String) null);
            }
        }
    }
}
