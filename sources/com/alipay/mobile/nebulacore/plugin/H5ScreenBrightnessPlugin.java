package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;

public class H5ScreenBrightnessPlugin extends H5SimplePlugin {
    private static final String BRIGHTNESS = "brightness";
    private static final String GET_SCREEN_BRIGHTNESS = "getScreenBrightness";
    private static final String SET_SCREEN_BRIGHTNESS = "setScreenBrightness";
    public static final String TAG = "H5ScreenBrightnessPlugin";
    private Activity activity;

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(SET_SCREEN_BRIGHTNESS);
        h5EventFilter.addAction(GET_SCREEN_BRIGHTNESS);
    }

    public void onRelease() {
        this.activity = null;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        this.activity = h5Event.getActivity();
        if (GET_SCREEN_BRIGHTNESS.equals(action)) {
            e eVar = new e();
            float screenBrightness = getScreenBrightness();
            H5Log.d(TAG, "currentBrightness: ".concat(String.valueOf(screenBrightness)));
            eVar.put(BRIGHTNESS, (Object) Float.valueOf(screenBrightness));
            eVar.put("success", (Object) Boolean.TRUE);
            h5BridgeContext.sendBridgeResult(eVar);
        } else if (SET_SCREEN_BRIGHTNESS.equals(action)) {
            e param = h5Event.getParam();
            if (!param.containsKey(BRIGHTNESS)) {
                h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                return true;
            }
            try {
                float floatValue = param.getFloat(BRIGHTNESS).floatValue();
                H5Log.d(TAG, "setBrightness: ".concat(String.valueOf(floatValue)));
                if (floatValue < 0.0f || floatValue > 1.0f) {
                    h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                    return true;
                }
                setScreenBrightness(floatValue);
                h5BridgeContext.sendBridgeResult("success", Boolean.TRUE);
            } catch (Exception e2) {
                H5Log.e(TAG, "exception", e2);
                h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            }
        }
        return true;
    }

    private void setScreenBrightness(float f2) {
        try {
            StringBuilder sb = new StringBuilder("value before");
            sb.append(f2);
            sb.append(" value after");
            float f3 = f2 * 255.0f;
            sb.append(f3);
            H5Log.d(TAG, sb.toString());
            Window window = this.activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f3 / 255.0f;
            window.setAttributes(attributes);
            Settings.System.putInt(this.activity.getContentResolver(), "screen_brightness", (int) f3);
        } catch (Exception e2) {
            H5Log.e(TAG, "exception", e2);
        }
    }

    private float getScreenBrightness() {
        try {
            return ((float) Settings.System.getInt(this.activity.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (Exception e2) {
            H5Log.e(TAG, "exception", e2);
            return 0.0f;
        }
    }
}
