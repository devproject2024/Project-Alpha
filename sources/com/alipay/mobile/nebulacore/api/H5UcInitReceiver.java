package com.alipay.mobile.nebulacore.api;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5PageReadyListener;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5UcReadyCallBack;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H5UcInitReceiver extends BroadcastReceiver {
    public static final String TAG = "H5UcInitReceiver";
    private boolean callBackPageReady = false;
    private List<H5Bundle> h5BundleList = Collections.synchronizedList(new ArrayList());
    private List<H5Context> h5ContextList = Collections.synchronizedList(new ArrayList());
    private List<H5PageReadyListener> h5PageReadyListenerList = Collections.synchronizedList(new ArrayList());
    private List<H5UcReadyCallBack> h5UcReadyCallBackList = Collections.synchronizedList(new ArrayList());

    public H5UcInitReceiver(boolean z) {
        this.callBackPageReady = z;
    }

    public void addH5Context(H5Context h5Context) {
        this.h5ContextList.add(h5Context);
    }

    public void addH5Bundle(H5Bundle h5Bundle) {
        this.h5BundleList.add(h5Bundle);
    }

    public void addH5PageReadyListener(H5PageReadyListener h5PageReadyListener) {
        this.h5PageReadyListenerList.add(h5PageReadyListener);
    }

    public void addH5UcReadyCallBack(H5UcReadyCallBack h5UcReadyCallBack) {
        this.h5UcReadyCallBackList.add(h5UcReadyCallBack);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null && H5Param.H5_ACTION_UC_INIT_FINISH.equals(intent.getAction())) {
            H5Log.d(TAG, "receive " + this.callBackPageReady);
            try {
                int i2 = 0;
                if (!this.callBackPageReady) {
                    boolean z = H5Utils.getBoolean(intent.getExtras(), "result", false);
                    if (this.h5UcReadyCallBackList != null && !this.h5UcReadyCallBackList.isEmpty()) {
                        for (H5UcReadyCallBack usIsReady : this.h5UcReadyCallBackList) {
                            H5Log.d(TAG, "!callBackPageReady uc init result ".concat(String.valueOf(z)));
                            usIsReady.usIsReady(z);
                        }
                    }
                    if (this.h5UcReadyCallBackList != null && !this.h5UcReadyCallBackList.isEmpty()) {
                        this.h5UcReadyCallBackList.clear();
                        return;
                    }
                    return;
                }
                if (this.h5ContextList != null && !this.h5ContextList.isEmpty() && this.h5BundleList != null && !this.h5BundleList.isEmpty() && this.h5PageReadyListenerList != null && !this.h5PageReadyListenerList.isEmpty()) {
                    boolean z2 = H5Utils.getBoolean(intent.getExtras(), "result", false);
                    for (H5Context next : this.h5ContextList) {
                        if (next != null && (next.getContext() instanceof Activity)) {
                            Activity activity = (Activity) next.getContext();
                            if (activity == null) {
                                return;
                            }
                            if (!activity.isFinishing()) {
                                H5Log.d(TAG, "callBackPageReady uc init result ".concat(String.valueOf(z2)));
                                H5PageReadyListener h5PageReadyListener = this.h5PageReadyListenerList.get(i2);
                                H5Bundle h5Bundle = this.h5BundleList.get(i2);
                                if (!(h5PageReadyListener == null || h5Bundle == null)) {
                                    h5PageReadyListener.getH5Page(Nebula.getService().createPage(next, h5Bundle));
                                }
                            } else {
                                return;
                            }
                        }
                        i2++;
                    }
                }
                if (this.h5ContextList != null && !this.h5ContextList.isEmpty()) {
                    this.h5ContextList.clear();
                }
                if (this.h5BundleList != null && !this.h5BundleList.isEmpty()) {
                    this.h5BundleList.clear();
                }
                if (this.h5PageReadyListenerList != null && !this.h5PageReadyListenerList.isEmpty()) {
                    this.h5PageReadyListenerList.clear();
                }
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }
}
