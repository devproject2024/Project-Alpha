package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import android.content.Intent;
import android.os.Bundle;
import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5LoadingViewImpl implements H5LoadingManager {
    public static final String LOADING_TIMEOUT = "loading_timeout";
    public static final String LOADING_TYPE = "loading_type";
    private static final String TAG = "H5LoadingViewImpl";
    private long mStartLoadingTime = 0;

    public void playExitAnimation() {
    }

    public void open(Bundle bundle, String str, String str2, H5StartAppInfo h5StartAppInfo, int i2) {
        Intent intent = new Intent(H5Utils.getContext(), H5LoadingActivity.class);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(LOADING_TIMEOUT, i2);
        bundle.putString(LOADING_TYPE, str2);
        bundle.putString("appId", str);
        intent.putExtras(bundle);
        intent.setFlags(268435456);
        H5Utils.getContext().startActivity(intent);
        H5LoadingUtil.setH5LoadingManager(this);
        H5LoadingUtil.setH5StartAppInfo(h5StartAppInfo);
        this.mStartLoadingTime = System.currentTimeMillis();
    }

    public long getStartLoadingTime() {
        return this.mStartLoadingTime;
    }

    public void exit() {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        if (h5LoadingActivity != null) {
            h5LoadingActivity.finish();
        } else {
            H5Log.d(TAG, "exit H5LoadingActivity==null");
        }
    }

    public void sendToWebFail() {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        if (h5LoadingActivity == null || h5LoadingActivity.isFinishing()) {
            H5Log.d(TAG, "sendToWebFail H5LoadingActivity==null");
        } else {
            h5LoadingActivity.sendToWebFail();
        }
    }

    public boolean isReady() {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        return h5LoadingActivity != null && !h5LoadingActivity.isFinishing();
    }

    public boolean pageDestroy() {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        return h5LoadingActivity == null || h5LoadingActivity.isFinishing();
    }

    public int getPageStatues() {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        if (h5LoadingActivity == null || h5LoadingActivity.isFinishing()) {
            return 0;
        }
        return h5LoadingActivity.getPageStatues();
    }

    public void setPageStatue(int i2) {
        H5LoadingActivity h5LoadingActivity = H5LoadingUtil.getH5LoadingActivity();
        if (h5LoadingActivity != null && !h5LoadingActivity.isFinishing()) {
            h5LoadingActivity.setPageStatue(i2);
        }
    }
}
