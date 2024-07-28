package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class H5ScreenPlugin extends H5SimplePlugin {
    private static final String ALLOW_SYSTEM_SNAPSHOT = "allowSystemSnapshot";
    private static final String GET_TITLE_AND_STATUS_BAR_HEIGHT = "getTitleAndStatusBarHeight";
    private static final String GET_TITLE_AND_STATUS_BAR_HEIGHT_NEW = "getTitleAndStatusbarHeight";
    private static final String SET_LANDSCAPE = "setLandscape";
    private static final String SET_PORTRAIT = "setPortrait";
    private static final String SET_SCREEN_AUTOLOCK = "setScreenAutolock";

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(SET_LANDSCAPE);
        h5EventFilter.addAction(SET_PORTRAIT);
        h5EventFilter.addAction(ALLOW_SYSTEM_SNAPSHOT);
        h5EventFilter.addAction(SET_SCREEN_AUTOLOCK);
        h5EventFilter.addAction(GET_TITLE_AND_STATUS_BAR_HEIGHT);
        h5EventFilter.addAction(GET_TITLE_AND_STATUS_BAR_HEIGHT_NEW);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        Activity activity = h5Event.getActivity();
        if (activity != null && !activity.isFinishing()) {
            try {
                if (SET_LANDSCAPE.equals(action)) {
                    if (activity.getRequestedOrientation() != 0) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (SET_PORTRAIT.equals(action)) {
                    if (activity.getRequestedOrientation() != 1) {
                        activity.setRequestedOrientation(1);
                    }
                } else if (ALLOW_SYSTEM_SNAPSHOT.equals(action)) {
                    if (!H5Utils.getBoolean(h5Event.getParam(), "allow", true)) {
                        activity.getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    } else {
                        activity.getWindow().clearFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    }
                } else if (SET_SCREEN_AUTOLOCK.equals(action)) {
                    String string = H5Utils.getString(h5Event.getParam(), "actionType");
                    if (TextUtils.equals(string, "disable")) {
                        activity.getWindow().setFlags(128, 128);
                    } else if (TextUtils.equals(string, "enable")) {
                        activity.getWindow().clearFlags(128);
                    } else {
                        h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                        return true;
                    }
                } else if (GET_TITLE_AND_STATUS_BAR_HEIGHT.equals(action)) {
                    return getTitleAndStatusBarHeight(h5BridgeContext, h5Event);
                } else {
                    if (GET_TITLE_AND_STATUS_BAR_HEIGHT_NEW.equals(action)) {
                        return getTitleAndStatusBarHeight(h5BridgeContext, h5Event);
                    }
                }
            } catch (Exception e2) {
                H5Log.e("", (Throwable) e2);
            }
        }
        h5BridgeContext.sendSuccess();
        return true;
    }

    private boolean getTitleAndStatusBarHeight(H5BridgeContext h5BridgeContext, H5Event h5Event) {
        int dip2px = H5DimensionUtil.dip2px(H5Environment.getContext(), 1.0f);
        e eVar = new e();
        eVar.put("titleBarHeight", (Object) Float.valueOf(H5Environment.getContext().getResources().getDimension(R.dimen.h5_title_height) / ((float) dip2px)));
        eVar.put("density", (Object) Integer.valueOf(dip2px));
        Rect rect = new Rect();
        Activity activity = h5Event.getActivity();
        if (activity != null && dip2px > 0) {
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            eVar.put("statusBarHeight", (Object) Integer.valueOf(rect.top / dip2px));
        }
        h5BridgeContext.sendBridgeResult(eVar);
        return true;
    }
}
