package com.alipay.mobile.nebula.callback;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5OnShareCallback implements H5CallBack, Runnable {
    public static int TIMEOUT = 300;
    private boolean hasCallback = false;
    private OnShareResultListener onShareResultListener;

    public interface OnShareResultListener {
        void onShareResult(e eVar);
    }

    public H5OnShareCallback(OnShareResultListener onShareResultListener2) {
        this.onShareResultListener = onShareResultListener2;
        H5Utils.runOnMain(this, (long) TIMEOUT);
    }

    public void onCallBack(e eVar) {
        if (!this.hasCallback) {
            this.hasCallback = true;
            this.onShareResultListener.onShareResult(eVar);
        }
    }

    public void run() {
        if (!this.hasCallback) {
            this.hasCallback = true;
            e eVar = new e();
            eVar.put("prevent", (Object) Boolean.FALSE);
            this.onShareResultListener.onShareResult(eVar);
        }
    }
}
