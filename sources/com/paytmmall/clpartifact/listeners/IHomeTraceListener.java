package com.paytmmall.clpartifact.listeners;

import android.app.Activity;

public interface IHomeTraceListener {
    void initH5(Activity activity);

    void logAppStartTimeHawkeye(Activity activity);

    void runAfterHomeSettle(Activity activity);

    void stopAppClickToHomeRenderingTrace();

    void stopMainActivityTrace(Activity activity);
}
