package com.alipay.mobile.nebulacore.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PullHeader;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.h5container.api.H5WebContentImpl;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5ViewProvider;
import com.alipay.mobile.nebula.refresh.H5PullAdapter;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebula.view.H5Progress;
import com.alipay.mobile.nebula.view.H5PullHeaderView;
import com.alipay.mobile.nebula.view.H5WebContentView;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import java.util.regex.Pattern;

public class H5WebContent extends H5SimplePlugin {
    private static final int PULL_FRESH_TIMEOUT = 20000;
    private static final String SET_PULL_DOWN_TEXT = "setPullDownText";
    public static final String TAG = "H5WebContent";
    private static Pattern[] sDisablePullDownPatterns;
    /* access modifiers changed from: private */
    public boolean canPullDown;
    /* access modifiers changed from: private */
    public boolean canRefresh;
    private H5CloseHandler closeHandler;
    /* access modifiers changed from: private */
    public boolean dataReturn;
    /* access modifiers changed from: private */
    public boolean disablePullDownByConfig = false;
    private H5Bridge h5Bridge;
    /* access modifiers changed from: private */
    public H5PageImpl h5Page;
    /* access modifiers changed from: private */
    public H5Progress h5Progress;
    private H5WebContentView h5WebContentView;
    private View hDivider;
    private boolean isCustomBackground;
    private H5PullAdapter pullAdapter = new H5PullAdapter() {
        private H5PullHeaderView pullHeader;

        public void onLoading() {
            if (this.pullHeader != null && H5WebContent.this.h5Page != null) {
                this.pullHeader.showLoading();
                H5Log.d(H5WebContent.TAG, "onLoading,TimeoutRunnable begin,send event FIRE_PULL_TO_REFRESH ");
                H5WebContent.this.h5Page.sendEvent(H5Plugin.CommonEvents.FIRE_PULL_TO_REFRESH, (e) null);
                H5Utils.runOnMain(new TimeoutRunnable(), 20000);
            }
        }

        public boolean canRefresh() {
            return H5WebContent.this.canRefresh;
        }

        public boolean canPull() {
            return !H5WebContent.this.disablePullDownByConfig && H5WebContent.this.canPullDown;
        }

        public View getHeaderView() {
            Context context = H5WebContent.this.h5Page.getContext().getContext();
            if (this.pullHeader == null) {
                H5ViewProvider h5ViewProvider = (H5ViewProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ViewProvider.class.getName());
                if (h5ViewProvider != null) {
                    this.pullHeader = h5ViewProvider.createPullHeaderView(context, H5WebContent.this.pullContainer);
                    if (this.pullHeader == null) {
                        this.pullHeader = new H5PullHeader(context, H5WebContent.this.pullContainer);
                    }
                } else {
                    this.pullHeader = new H5PullHeader(context, H5WebContent.this.pullContainer);
                }
            }
            return this.pullHeader.getContentView();
        }

        public void onProgressUpdate(int i2) {
            this.pullHeader.onProgressUpdate(i2);
        }

        public void onOpen() {
            H5PullHeaderView h5PullHeaderView = this.pullHeader;
            if (h5PullHeaderView != null) {
                h5PullHeaderView.showOpen();
                H5Log.d(H5WebContent.TAG, "open ");
            }
        }

        public void onOver() {
            H5PullHeaderView h5PullHeaderView = this.pullHeader;
            if (h5PullHeaderView != null) {
                h5PullHeaderView.showOver();
            }
        }

        public void onFinish() {
            H5PullHeaderView h5PullHeaderView = this.pullHeader;
            if (h5PullHeaderView != null) {
                h5PullHeaderView.showFinish();
                boolean unused = H5WebContent.this.dataReturn = true;
            }
        }
    };
    /* access modifiers changed from: private */
    public H5PullContainer pullContainer;
    private String pullDownText;
    /* access modifiers changed from: private */
    public boolean pullFreshTimeOut;
    private boolean showDomain;
    private boolean showProgress;

    static {
        initConfig();
    }

    private static void initConfig() {
        String configWithProcessCache;
        b parseArray;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null && H5Utils.isUCM57() && (configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5_disablePullDownPatterns")) != null && (parseArray = H5Utils.parseArray(configWithProcessCache)) != null) {
            int size = parseArray.size();
            sDisablePullDownPatterns = new Pattern[size];
            for (int i2 = 0; i2 < size; i2++) {
                sDisablePullDownPatterns[i2] = H5PatternHelper.compile(parseArray.getString(i2));
            }
        }
    }

    public H5WebContent(H5PageImpl h5PageImpl) {
        int i2 = 0;
        this.h5Page = h5PageImpl;
        this.canPullDown = true;
        this.showProgress = false;
        this.pullFreshTimeOut = true;
        this.dataReturn = true;
        this.isCustomBackground = false;
        this.closeHandler = new H5CloseHandler();
        this.h5Bridge = h5PageImpl.getBridge();
        if (sDisablePullDownPatterns != null) {
            String string = H5Utils.getString(h5PageImpl.getParams(), "url");
            Pattern[] patternArr = sDisablePullDownPatterns;
            int length = patternArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (patternArr[i2].matcher(string).find()) {
                    this.disablePullDownByConfig = true;
                    H5Log.d(TAG, "disable pullDown by config");
                    break;
                } else {
                    i2++;
                }
            }
        }
        initComponent();
    }

    public void setUrlProviderMargin(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i2;
        this.h5WebContentView.getProviderLayout().setLayoutParams(layoutParams);
    }

    public void onRelease() {
        this.h5Page = null;
        this.closeHandler = null;
        this.h5Bridge = null;
    }

    public H5Page getPage() {
        return this.h5Page;
    }

    public View getContent() {
        return this.h5WebContentView.getContentView();
    }

    private void initComponent() {
        Context context = this.h5Page.getContext().getContext();
        H5ViewProvider h5ViewProvider = (H5ViewProvider) Nebula.getProviderManager().getProvider(H5ViewProvider.class.getName());
        if (h5ViewProvider != null) {
            this.h5WebContentView = h5ViewProvider.createWebContentView(context);
        }
        if (h5ViewProvider == null || this.h5WebContentView == null) {
            this.h5WebContentView = new H5WebContentImpl(context);
        }
        this.hDivider = this.h5WebContentView.getHdivider();
        this.isCustomBackground = this.h5WebContentView.isCustomBackground();
        H5Log.d(TAG, "isCustomBackground " + this.isCustomBackground);
        this.h5Progress = this.h5WebContentView.getProgress();
        this.pullContainer = this.h5WebContentView.getPullContainer();
        this.pullContainer.setContentView(this.h5Page.getWebView().getView());
        this.pullContainer.setPullableView(this.h5Page.getWebView());
        this.pullContainer.setPullAdapter(this.pullAdapter);
        refreshView();
    }

    public void refreshView() {
        boolean z = H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_SHOW_PROGRESS, false);
        this.h5Progress.setVisibility(z ? 0 : 8);
        this.showProgress = z;
        this.showDomain = H5Utils.getBoolean(this.h5Page.getParams(), "showDomain", true);
        this.canRefresh = H5Utils.getBoolean(this.h5Page.getParams(), "pullRefresh", false);
        this.canPullDown = H5Utils.getBoolean(this.h5Page.getParams(), "canPullDown", true);
        updateProvider();
    }

    private void updateProvider() {
        if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isH5app, false) || this.canRefresh) {
            this.h5WebContentView.showProviderVisibility(false);
        } else {
            this.h5WebContentView.showProviderVisibility(true);
        }
        this.pullContainer.notifyViewChanged();
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PROGRESS);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACKGROUND);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_CLOSE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_RELOAD);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TITLEBAR_TITLE_CLICK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TITLEBAR_SUBTITLE_CLICK);
        h5EventFilter.addAction(H5Plugin.CommonEvents.CLOSE_WEBVIEW);
        h5EventFilter.addAction("pullRefresh");
        h5EventFilter.addAction("canPullDown");
        h5EventFilter.addAction("showDomain");
        h5EventFilter.addAction(H5Plugin.CommonEvents.SHOW_PROGRESS_BAR);
        h5EventFilter.addAction(H5Plugin.CommonEvents.FIRE_PULL_TO_REFRESH);
        h5EventFilter.addAction(H5Plugin.CommonEvents.RESTORE_PULL_TO_REFRESH);
        h5EventFilter.addAction(SET_PULL_DOWN_TEXT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_RPC_FAILED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_ERROR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.SHOW_PROGRESSBAR_WHEN_FALLBACK);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(action) || H5Plugin.InternalEvents.H5_TOOLBAR_RELOAD.equals(action)) {
            if (this.showProgress) {
                this.h5Progress.setProgress(0);
                this.h5Progress.setVisibility(0);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action)) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5WebContent.this.onPageFinished();
                }
            }, 300);
        } else if (H5Plugin.InternalEvents.H5_PAGE_PROGRESS.equals(action)) {
            this.h5Progress.updateProgress(H5Utils.getInt(param, H5Param.PROGRESS));
        } else if (!H5Plugin.InternalEvents.H5_PAGE_BACKGROUND.equals(action) && H5Plugin.InternalEvents.H5_PAGE_ERROR.equals(action)) {
            this.h5Page.hideLoadingView();
        }
        return false;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (H5Plugin.InternalEvents.H5_TITLEBAR_TITLE_CLICK.equals(action) || H5Plugin.InternalEvents.H5_TITLEBAR_SUBTITLE_CLICK.equals(action)) {
            e eVar = new e();
            eVar.put("data", (Object) param);
            this.h5Page.getBridge().sendToWeb(action, eVar, (H5CallBack) null);
        } else if ("pullRefresh".equals(action)) {
            this.canRefresh = H5Utils.getBoolean(param, "pullRefresh", false);
            updateProvider();
        } else if ("canPullDown".equals(action)) {
            this.canPullDown = H5Utils.getBoolean(param, "canPullDown", true);
        } else if ("showDomain".equals(action)) {
            this.showDomain = H5Utils.getBoolean(param, "showDomain", true);
        } else if (H5Plugin.CommonEvents.CLOSE_WEBVIEW.equals(action)) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
        } else if (H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK.equals(action) || H5Plugin.InternalEvents.H5_TOOLBAR_BACK.equals(action)) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_BACK, (e) null);
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_CLOSE.equals(action)) {
            handleCloseEvent();
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_RELOAD.equals(action)) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RELOAD, (e) null);
        } else if (H5Plugin.CommonEvents.SHOW_PROGRESS_BAR.equals(action)) {
            this.showProgress = H5Utils.getBoolean(param, H5Param.LONG_SHOW_PROGRESS, false);
            if (!this.showProgress) {
                this.h5Progress.setVisibility(8);
            }
        } else if (H5Plugin.InternalEvents.SHOW_PROGRESSBAR_WHEN_FALLBACK.equals(action)) {
            H5Log.d(TAG, H5Plugin.InternalEvents.SHOW_PROGRESSBAR_WHEN_FALLBACK);
            this.h5Progress.setVisibility(0);
        } else if (H5Plugin.CommonEvents.FIRE_PULL_TO_REFRESH.equals(action)) {
            firePullToRefresh(action);
        } else if (H5Plugin.CommonEvents.RESTORE_PULL_TO_REFRESH.equals(action)) {
            H5Log.d(TAG, "handleEvent restorePullToRefresh");
            this.dataReturn = true;
            restorePullToRefresh();
        } else if (!SET_PULL_DOWN_TEXT.equals(action)) {
            return false;
        } else {
            this.pullDownText = H5Utils.getString(param, "pullDownText");
            if (!TextUtils.isEmpty(this.pullDownText)) {
                this.h5WebContentView.setProviderText(this.pullDownText);
                this.h5WebContentView.getH5ProviderDomain().setMaxLines(1);
                this.h5WebContentView.getH5ProviderDomain().setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.h5WebContentView.setProviderLogo((Drawable) null);
                this.h5WebContentView.setProviderUc((String) null);
            }
            h5BridgeContext.sendSuccess();
        }
        return true;
    }

    private void restorePullToRefresh() {
        if (!this.pullContainer.isBackToTop()) {
            this.pullFreshTimeOut = false;
            H5Log.d(TAG, "invoke restorePullToRefresh,not backToTop");
            this.h5Progress.setVisibility(8);
            this.pullContainer.fitContent();
            return;
        }
        H5Log.d(TAG, "invoke restorePullToRefresh,already backToTop");
    }

    private void firePullToRefresh(String str) {
        PullFreshCallback pullFreshCallback = new PullFreshCallback();
        if (this.dataReturn) {
            this.h5Page.getBridge().sendToWeb(str, (e) null, pullFreshCallback);
            H5Log.d(TAG, "sendToWeb FIRE_PULL_TO_REFRESH");
            this.dataReturn = false;
            return;
        }
        H5Log.d(TAG, "date not return,not sendToWeb FIRE_PULL_TO_REFRESH");
    }

    /* access modifiers changed from: private */
    public void onPageFinished() {
        int i2;
        if (this.h5Page != null) {
            this.h5Progress.setVisibility(8);
            this.pullContainer.fitContent();
            if (this.h5Page.getAutoHideLoading()) {
                this.h5Page.hideLoadingView();
            }
            String host = H5UrlHelper.getHost(this.h5Page.getUrl());
            if (TextUtils.isEmpty(host) || !this.showDomain) {
                this.h5WebContentView.setProviderText("");
                return;
            }
            boolean z = false;
            if (!TextUtils.isEmpty(this.pullDownText)) {
                this.h5WebContentView.setProviderText(this.pullDownText);
                this.h5WebContentView.getH5ProviderDomain().setMaxLines(1);
                this.h5WebContentView.getH5ProviderDomain().setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.h5WebContentView.setProviderLogo((Drawable) null);
                this.h5WebContentView.setProviderUc((String) null);
            } else {
                String string = H5Environment.getResources().getString(R.string.h5_provider, new Object[]{host});
                H5PageImpl h5PageImpl = this.h5Page;
                if (!(h5PageImpl == null || h5PageImpl.getWebView() == null || this.h5Page.getWebView().getType() != WebViewType.THIRD_PARTY)) {
                    this.h5WebContentView.setProviderLogo(H5Environment.getResources().getDrawable(R.drawable.h5_uclogo));
                    H5WebContentView h5WebContentView2 = this.h5WebContentView;
                    h5WebContentView2.setProviderUc("  " + H5Environment.getResources().getString(R.string.h5_browser_provider));
                }
                this.h5WebContentView.setProviderText(string);
            }
            if (this.canPullDown && (i2 = H5Utils.getInt(this.h5Page.getParams(), (String) H5Param.LONG_BOUNCE_TOP_COLOR, (int) H5Param.DEFAULT_LONG_BOUNCE_TOP_COLOR)) != -657927) {
                H5WebContentView h5WebContentView3 = this.h5WebContentView;
                Drawable drawable = H5Environment.getResources().getDrawable(R.drawable.h5_uclogo_white);
                if (this.h5Page.getWebView() != null && this.h5Page.getWebView().getType() == WebViewType.THIRD_PARTY) {
                    z = true;
                }
                h5WebContentView3.switchCustomContentBg(i2, drawable, z);
            }
        }
    }

    class PullFreshCallback implements H5CallBack {
        public PullFreshCallback() {
        }

        public void onCallBack(e eVar) {
            boolean z = H5Utils.getBoolean(eVar, "prevent", false);
            H5Log.d(H5WebContent.TAG, "FIRE_PULL_TO_REFRESH event prevent: ".concat(String.valueOf(z)));
            if (z) {
                H5Log.d(H5WebContent.TAG, "set e.preventDefault(),not send H5_PAGE_RELOAD");
                return;
            }
            H5Log.d(H5WebContent.TAG, "not set e.preventDefault(),sendEvent H5_PAGE_RELOAD");
            H5WebContent.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RELOAD, (e) null);
            boolean unused = H5WebContent.this.dataReturn = true;
        }
    }

    class TimeoutRunnable implements Runnable {
        public TimeoutRunnable() {
        }

        public void run() {
            H5Log.d(H5WebContent.TAG, "TimeoutRunnable timeout,pullFreshTimeOut :" + H5WebContent.this.pullFreshTimeOut);
            if (H5WebContent.this.pullFreshTimeOut) {
                H5Log.d(H5WebContent.TAG, "TimeoutRunnable timeout,invoke restorePullToRefresh");
                H5WebContent.this.h5Progress.setVisibility(8);
                H5WebContent.this.pullContainer.fitContent();
                boolean unused = H5WebContent.this.pullFreshTimeOut = true;
                boolean unused2 = H5WebContent.this.dataReturn = true;
                return;
            }
            boolean unused3 = H5WebContent.this.pullFreshTimeOut = true;
        }
    }

    public View getHdivider() {
        return this.hDivider;
    }

    public H5LoadingView getH5LoadingView() {
        H5WebContentView h5WebContentView2 = this.h5WebContentView;
        if (h5WebContentView2 != null) {
            return h5WebContentView2.getH5LoadingView();
        }
        return null;
    }

    private void handleCloseEvent() {
        if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isTinyApp, false)) {
            this.h5Page.sendEvent(H5Plugin.CommonEvents.EXIT_SESSION, (e) null);
        } else {
            pageClose();
        }
    }

    private void pageClose() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.closeHandler.lastClose < 500) {
            H5Log.d(TAG, "ignore bridge, perform close!");
            performClose();
            return;
        }
        H5Log.d(TAG, "send close event to bridge!");
        H5CloseHandler h5CloseHandler = this.closeHandler;
        h5CloseHandler.waiting = true;
        h5CloseHandler.lastClose = currentTimeMillis;
        H5Bridge h5Bridge2 = this.h5Bridge;
        if (h5Bridge2 != null) {
            h5Bridge2.sendToWeb("closeWindow", (e) null, h5CloseHandler);
        }
    }

    /* access modifiers changed from: private */
    public void performClose() {
        this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
    }

    class H5CloseHandler implements H5CallBack {
        public long lastClose = 0;
        public boolean waiting = false;

        public H5CloseHandler() {
        }

        public void onCallBack(e eVar) {
            this.waiting = false;
            boolean z = H5Utils.getBoolean(eVar, "prevent", false);
            H5Log.d(H5WebContent.TAG, "close event prevent ".concat(String.valueOf(z)));
            if (!z) {
                H5WebContent.this.performClose();
            }
        }
    }
}
