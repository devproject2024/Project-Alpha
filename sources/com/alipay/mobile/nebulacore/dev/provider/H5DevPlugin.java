package com.alipay.mobile.nebulacore.dev.provider;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.res.H5ResourceManager;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H5DevPlugin extends H5SimplePlugin {
    private static final String ACTION_NBREPORT = "NBDebugReport";
    public static final String TAG = "H5DevPlugin";
    private H5DevDebugProvider h5DevDebugProvider = null;
    private H5Page h5Page;
    private String sessionId = "";
    private String title = "";
    private String url = "";
    private String userAgent = "";
    private String viewId = "";
    private APWebView webView = null;

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.h5DevDebugProvider = (H5DevDebugProvider) H5Utils.getProvider(H5DevDebugProvider.class.getName());
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(ACTION_NBREPORT);
        h5EventFilter.addAction(H5Param.H5_PAGE_CREATE_WEBVIEW);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_CLOSE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_CONSOLE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_CONSOLE_EXCEPTION);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_WEBVIEW_CREATE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_WEBVIEW_RELEASE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_JS_API_TO_NATIVE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_NETWORK_SRART);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_NETWORK_FINISH);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DEV_SCREENSHOT_UPLOAD);
    }

    public void onRelease() {
        this.h5DevDebugProvider = null;
        this.webView = null;
        this.h5Page = null;
        H5DebugConsolePool.getInstance().release(this.viewId);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (this.h5DevDebugProvider == null) {
            return false;
        }
        getData(h5Event);
        if (!TextUtils.isEmpty(this.viewId)) {
            if (!TextUtils.isEmpty(this.userAgent)) {
                this.h5DevDebugProvider.setUserAgent(this.viewId, this.userAgent);
            }
            if (!TextUtils.isEmpty(this.title)) {
                this.h5DevDebugProvider.setTitle(this.viewId, this.title);
            }
            if (!TextUtils.isEmpty(this.url)) {
                this.h5DevDebugProvider.setPageUrl(this.viewId, this.url);
            }
            if (!TextUtils.isEmpty(this.sessionId)) {
                this.h5DevDebugProvider.setSessionId(this.viewId, this.sessionId);
            }
        }
        if (H5Plugin.CommonEvents.H5_DEV_CONSOLE.equals(h5Event.getAction())) {
            String string = H5Utils.getString(h5Event.getParam(), "content");
            String string2 = H5Utils.getString(h5Event.getParam(), H5Param.FUNC, (String) null);
            if (TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                string2 = getFuncFromConsole(string);
            }
            this.h5DevDebugProvider.consoleLog("log", this.viewId, string, string2);
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_CONSOLE_EXCEPTION.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.consoleLog("error", this.viewId, H5Utils.getString(h5Event.getParam(), "content"), (String) null);
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_WEBVIEW_CREATE.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.pageLog("create", this.viewId, this.userAgent, this.url, this.title, (e) null);
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_WEBVIEW_RELEASE.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.pageLog("destroy", this.viewId, this.userAgent, this.url, this.title, (e) null);
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_JS_API_TO_NATIVE.equals(h5Event.getAction())) {
            String string3 = H5Utils.getString(h5Event.getParam(), "subType");
            String string4 = H5Utils.getString(h5Event.getParam(), "request");
            this.h5DevDebugProvider.jsApiLog(string3, this.viewId, H5Utils.getString(h5Event.getParam(), "eventId"), string4, "");
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_NETWORK_SRART.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.netWorkLog("start", this.viewId, h5Event.getParam());
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_NETWORK_FINISH.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.netWorkLog("finish", this.viewId, h5Event.getParam());
            return true;
        } else if (H5Plugin.CommonEvents.H5_DEV_SCREENSHOT_UPLOAD.equals(h5Event.getAction())) {
            this.h5DevDebugProvider.screenshot("upload", this.viewId);
            return true;
        } else if (!ACTION_NBREPORT.equals(h5Event.getAction())) {
            return false;
        } else {
            e param = h5Event.getParam();
            if (param != null && "extra".equals(H5Utils.getString(param, "type"))) {
                this.h5DevDebugProvider.pageLog("sync_state", this.viewId, "", "", "", H5Utils.getJSONObject(param, "content", (e) null));
            }
            return true;
        }
    }

    private String getFuncFromConsole(String str) {
        try {
            Pattern compile = H5PatternHelper.compile("invokeJS msgType callback func (.*)");
            if (compile == null) {
                return null;
            }
            Matcher matcher = compile.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (this.h5DevDebugProvider == null) {
            return false;
        }
        String action = h5Event.getAction();
        getData(h5Event);
        String str = null;
        if (H5Param.H5_PAGE_CREATE_WEBVIEW.equals(action)) {
            str = "create";
        } else if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(action)) {
            if (this.h5DevDebugProvider.getScheduler() != null) {
                this.h5DevDebugProvider.getScheduler().pause();
            }
            str = "update";
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action)) {
            if (this.h5DevDebugProvider.getScheduler() != null) {
                this.h5DevDebugProvider.getScheduler().resume();
            }
            if (H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DOM_DEBUG, false)) {
                loadVorlon(this.webView);
            }
            str = "finish";
        } else if (H5Plugin.InternalEvents.H5_PAGE_CLOSE.equals(action) && this.h5DevDebugProvider.getScheduler() != null) {
            this.h5DevDebugProvider.getScheduler().resume();
        }
        String str2 = str;
        if (str2 != null) {
            H5Log.d(TAG, "type:page subType:" + str2 + " viewId:" + this.viewId + " userAgent:" + this.userAgent + " url:" + this.url + " title:" + this.title);
            this.h5DevDebugProvider.pageLog(str2, this.viewId, this.userAgent, this.url, this.title, (e) null);
        }
        return false;
    }

    private void getData(H5Event h5Event) {
        if (h5Event.getTarget() instanceof H5Page) {
            this.h5Page = (H5Page) h5Event.getTarget();
            e param = h5Event.getParam();
            String str = null;
            if (param != null) {
                str = param.getString("url");
            }
            H5Page h5Page2 = this.h5Page;
            if (h5Page2 != null) {
                this.webView = h5Page2.getWebView();
                if (str == null) {
                    str = this.h5Page.getUrl();
                }
                this.url = str;
                this.title = this.h5Page.getTitle();
                this.viewId = H5BugmeIdGenerator.getBugmeViewId(this.h5Page);
                APWebView aPWebView = this.webView;
                if (!(aPWebView == null || aPWebView.getSettings() == null)) {
                    this.userAgent = this.webView.getSettings().getUserAgentString();
                }
                H5Session session = this.h5Page.getSession();
                if (session != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(session.hashCode());
                    this.sessionId = sb.toString();
                }
            }
        }
    }

    private void loadVorlon(APWebView aPWebView) {
        if (aPWebView != null) {
            String format = String.format(H5ResourceManager.getRaw(R.raw.h5_dev_vorlon), new Object[]{this.viewId, "https://bugme.anyproxy.io:5680", "https://hpmweb.alipay.com/bugme/domScript"});
            aPWebView.loadUrl("javascript:".concat(String.valueOf(format)));
            H5Log.debug(TAG, "vorlon script:".concat(String.valueOf(format)));
            this.h5DevDebugProvider.pageLog("sync_state", this.viewId, "", "", "", (e) null);
        }
    }
}
