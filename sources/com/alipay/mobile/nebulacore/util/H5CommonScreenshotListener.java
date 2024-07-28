package com.alipay.mobile.nebulacore.util;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.dev.H5BugmeLogCollector;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.util.H5ScreenShotObserver;
import java.util.List;

public class H5CommonScreenshotListener implements H5ScreenShotObserver.H5ScreenShotListener {
    private static final String TAG = "H5CommonScreenshotListener";

    public void onScreenShot() {
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                H5Service h5Service;
                H5Page topH5Page;
                try {
                    if (!("no".equalsIgnoreCase(H5Environment.getConfig("h5_flush_ucLog")) || (h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())) == null || (topH5Page = h5Service.getTopH5Page()) == null)) {
                        topH5Page.sendEvent("flushUcLog", (e) null);
                    }
                    H5BugmeLogCollector.flushAppLog();
                    List<String> allThreadsTraces = H5PerformanceUtils.getAllThreadsTraces();
                    if (allThreadsTraces != null) {
                        H5Log.d(H5CommonScreenshotListener.TAG, "All Threads Traces: ###" + allThreadsTraces.size());
                        for (String d2 : allThreadsTraces) {
                            H5Log.d(H5CommonScreenshotListener.TAG, d2);
                        }
                    }
                } catch (Throwable th) {
                    H5Log.e(H5CommonScreenshotListener.TAG, th);
                }
            }
        });
    }
}
