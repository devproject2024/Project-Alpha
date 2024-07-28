package com.alipay.mobile.nebula.dev;

import android.os.Process;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.nebula.webview.APWebView;

public class H5BugmeIdGenerator {
    private static int sId = 0;
    private static int sPid = Process.myPid();
    private static int sRequestId = 0;

    public static synchronized int nextRequestId() {
        int i2;
        synchronized (H5BugmeIdGenerator.class) {
            i2 = sRequestId;
            sRequestId = i2 + 1;
        }
        return i2;
    }

    public static synchronized int nextId() {
        int i2;
        synchronized (H5BugmeIdGenerator.class) {
            i2 = sId;
            sId = i2 + 1;
        }
        return i2;
    }

    public static String getBugmeViewId(H5Page h5Page) {
        APWebView webView;
        if (h5Page == null || (webView = h5Page.getWebView()) == null) {
            return "";
        }
        return "view_" + webView.hashCode() + "_" + sPid;
    }

    public static String getSessionId(H5Page h5Page) {
        H5Session session;
        if (h5Page == null || (session = h5Page.getSession()) == null) {
            return "";
        }
        return "session_" + session.hashCode() + "_" + sPid;
    }
}
