package com.alipay.mobile.nebulacore.plugin;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.alibaba.a.a;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils;

public class H5ErrorPagePlugin extends H5SimplePlugin {
    private static final String START_FEEDBACK = "startFeedBack";
    private static final String TAG = "H5ErrorPagePlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(START_FEEDBACK);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!START_FEEDBACK.equals(h5Event.getAction())) {
            return false;
        }
        if (h5Event.getH5page() == null || h5Event.getH5page().getPageData() == null) {
            h5BridgeContext.sendError(H5Event.Error.UNKNOWN_ERROR.ordinal(), "call failed");
            return true;
        }
        if (h5Event.getH5page().getPageData().isShowErrorPage()) {
            startFeedBack();
        } else {
            h5BridgeContext.sendNoRightToInvoke();
        }
        return true;
    }

    private void startFeedBack() {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                Bitmap bitmap;
                H5Page h5Page = null;
                try {
                    if (!(Nebula.getService() == null || Nebula.getService().getTopSession() == null || Nebula.getService().getTopSession().getTopPage() == null)) {
                        h5Page = Nebula.getService().getTopSession().getTopPage();
                    }
                    if (h5Page == null) {
                        return;
                    }
                    if (h5Page.getPageData() != null) {
                        if (h5Page.getWebView() == null || h5Page.getWebView().getType() != WebViewType.THIRD_PARTY) {
                            bitmap = H5PerformanceUtils.takeScreenShot(h5Page);
                        } else {
                            int measuredWidth = h5Page.getWebView().getView().getMeasuredWidth();
                            int measuredHeight = h5Page.getWebView().getView().getMeasuredHeight();
                            bitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                            h5Page.getWebView().getCurrentPageSnapshot(new Rect(0, 0, measuredWidth, measuredHeight), new Rect(0, 0, measuredWidth, measuredHeight), bitmap, false, 0);
                        }
                        String str = "";
                        if (bitmap != null) {
                            String tempPath = new FileCache(h5Page.getContext().getContext(), h5Page.getPageData().getAppId()).getTempPath(h5Page.getContext().getContext(), String.valueOf(System.currentTimeMillis()), "png");
                            if (H5FileUtil.create(tempPath, true)) {
                                H5ImageUtil.writeImage(bitmap, Bitmap.CompressFormat.PNG, tempPath);
                                str = tempPath;
                            }
                        }
                        String jSONString = a.toJSONString(H5ErrorPagePlugin.this.getFeedbackReportData());
                        Bundle bundle = new Bundle();
                        bundle.putString("feedBackBizId", h5Page.getPageData().getAppId());
                        bundle.putString("feedBackImage", str);
                        bundle.putString("feedBackInfo", jSONString);
                        b.a().f14954a.a(h5Page.getPageData().getAppId(), "20000049", bundle);
                    }
                } catch (Exception e2) {
                    H5Log.e(H5ErrorPagePlugin.TAG, (Throwable) e2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public FeedbackReportData getFeedbackReportData() {
        return new FeedbackReportData();
    }

    public class FeedbackReportData {
        public String bizCode;
        public String bizMsg;
        public String bizUrl;
        public String viewName;

        public FeedbackReportData() {
        }
    }
}
