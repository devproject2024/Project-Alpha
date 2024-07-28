package com.alipay.iap.android.webapp.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.a.a;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.mobile.h5container.api.H5Listener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Session;

public class AppSessionListener implements H5Listener {
    private static final String TAG = "AppSessionListener";
    private Bundle mBundle;
    private WebAppListener mListener;
    private int mPageCount;

    public AppSessionListener(Bundle bundle) {
        this.mBundle = bundle;
    }

    public void addWebAppListener(WebAppListener webAppListener) {
        this.mListener = webAppListener;
    }

    public void onSessionCreated(H5Session h5Session) {
        c.e();
    }

    public void onSessionDestroyed(H5Session h5Session) {
        c.e();
        Intent intent = new Intent();
        intent.setAction(AppEvent.APP_CLOSED);
        intent.putExtras(this.mBundle);
        a.a((Context) AppContainerKit.getInstance().getApplication()).a(intent);
    }

    public void onPageCreated(H5Page h5Page) {
        WebAppListener webAppListener;
        this.mPageCount++;
        new StringBuilder("onPageCreated: mPageCount=").append(this.mPageCount);
        c.e();
        if (this.mPageCount == 1 && (webAppListener = this.mListener) != null) {
            webAppListener.onAppCreated(this.mBundle);
        }
    }

    public void onPageDestroyed(H5Page h5Page) {
        boolean z = true;
        this.mPageCount--;
        new StringBuilder("onPageDestroyed: mPageCount = ").append(this.mPageCount);
        c.e();
        boolean z2 = this.mPageCount == 0;
        if (this.mListener == null) {
            z = false;
        }
        if (z2 && z) {
            this.mListener.onAppDestroyed(this.mBundle);
            this.mListener = null;
        }
    }
}
