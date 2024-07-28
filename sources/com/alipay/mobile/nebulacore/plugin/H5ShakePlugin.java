package com.alipay.mobile.nebulacore.plugin;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5ShakePlugin extends H5SimplePlugin {
    /* access modifiers changed from: private */
    public static int COUNTS_LIMITED = 3;
    /* access modifiers changed from: private */
    public static int SPEED_THRESHOLD = 1400;
    private static final String TAG = "H5ShakePlugin";
    /* access modifiers changed from: private */
    public static int UPTATE_INTERVAL_TIME = 100;
    /* access modifiers changed from: private */
    public int counts = 0;
    /* access modifiers changed from: private */
    public H5BridgeContext lastBridgeContext;
    /* access modifiers changed from: private */
    public long lastUpdateTime;
    /* access modifiers changed from: private */
    public float lastX;
    /* access modifiers changed from: private */
    public float lastY;
    /* access modifiers changed from: private */
    public float lastZ;
    private SensorEventListener listener = null;
    private boolean registered;

    static /* synthetic */ int access$608(H5ShakePlugin h5ShakePlugin) {
        int i2 = h5ShakePlugin.counts;
        h5ShakePlugin.counts = i2 + 1;
        return i2;
    }

    private SensorEventListener getListenerDelayed() {
        if (this.listener == null) {
            this.listener = new SensorEventListener() {
                public void onAccuracyChanged(Sensor sensor, int i2) {
                }

                public void onSensorChanged(SensorEvent sensorEvent) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long access$000 = currentTimeMillis - H5ShakePlugin.this.lastUpdateTime;
                    if (access$000 >= ((long) H5ShakePlugin.UPTATE_INTERVAL_TIME)) {
                        long unused = H5ShakePlugin.this.lastUpdateTime = currentTimeMillis;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        float access$200 = f2 - H5ShakePlugin.this.lastX;
                        float access$300 = f3 - H5ShakePlugin.this.lastY;
                        float access$400 = f4 - H5ShakePlugin.this.lastZ;
                        float unused2 = H5ShakePlugin.this.lastX = f2;
                        float unused3 = H5ShakePlugin.this.lastY = f3;
                        float unused4 = H5ShakePlugin.this.lastZ = f4;
                        double sqrt = (Math.sqrt((double) (((access$200 * access$200) + (access$300 * access$300)) + (access$400 * access$400))) / ((double) access$000)) * 10000.0d;
                        H5Log.d(H5ShakePlugin.TAG, "onSensorChanged x " + f2 + " y " + f3 + " z " + f4);
                        H5Log.d(H5ShakePlugin.TAG, "speed ".concat(String.valueOf(sqrt)));
                        if (sqrt >= ((double) H5ShakePlugin.SPEED_THRESHOLD)) {
                            H5Log.d(H5ShakePlugin.TAG, "counts" + H5ShakePlugin.this.counts);
                            if (H5ShakePlugin.this.counts < H5ShakePlugin.COUNTS_LIMITED) {
                                H5ShakePlugin.access$608(H5ShakePlugin.this);
                                return;
                            }
                            int unused5 = H5ShakePlugin.this.counts = 0;
                            H5ShakePlugin.this.unregisterListener();
                            if (H5ShakePlugin.this.lastBridgeContext != null) {
                                if (!"no".equalsIgnoreCase(H5Environment.getConfig("h5_use_watchShake"))) {
                                    H5ShakePlugin.this.lastBridgeContext.sendSuccess();
                                } else {
                                    H5ShakePlugin.this.lastBridgeContext.sendBridgeResult((e) null);
                                }
                                H5BridgeContext unused6 = H5ShakePlugin.this.lastBridgeContext = null;
                            }
                        }
                    }
                }
            };
        }
        return this.listener;
    }

    private SensorEventListener getListener() {
        if (this.listener == null) {
            this.listener = new SensorEventListener() {
                public void onAccuracyChanged(Sensor sensor, int i2) {
                }

                public void onSensorChanged(SensorEvent sensorEvent) {
                    float[] fArr = sensorEvent.values;
                    boolean z = false;
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    float f4 = fArr[2];
                    H5Log.d(H5ShakePlugin.TAG, "onSensorChanged x " + f2 + " y " + f3 + " z " + f4);
                    if (Math.abs(f2) > 12.0f || Math.abs(f3) > 12.0f || Math.abs(f4) > 12.0f) {
                        z = true;
                    }
                    if (z) {
                        H5ShakePlugin.this.unregisterListener();
                        if (H5ShakePlugin.this.lastBridgeContext != null) {
                            if (!"no".equalsIgnoreCase(H5Environment.getConfig("h5_use_watchShake"))) {
                                H5ShakePlugin.this.lastBridgeContext.sendSuccess();
                            } else {
                                H5ShakePlugin.this.lastBridgeContext.sendBridgeResult((e) null);
                            }
                            H5BridgeContext unused = H5ShakePlugin.this.lastBridgeContext = null;
                        }
                    }
                }
            };
        }
        return this.listener;
    }

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.registered = false;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.VIBRATE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.WATCH_SHAKE);
    }

    public void onRelease() {
        unregisterListener();
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.VIBRATE.equals(action)) {
            vibrate();
            return true;
        } else if (!H5Plugin.CommonEvents.WATCH_SHAKE.equals(action)) {
            return false;
        } else {
            if (h5Event.getParam() != null && !h5Event.getParam().isEmpty() && h5Event.getParam().size() != 1) {
                return false;
            }
            unregisterListener();
            registerListener();
            this.lastBridgeContext = h5BridgeContext;
            return true;
        }
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) H5Environment.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
    }

    private void registerListener() {
        SensorEventListener sensorEventListener;
        if (!this.registered) {
            SensorManager sensorManager = (SensorManager) H5Environment.getContext().getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_use_watchShake_delayed"));
            String string = H5Utils.getString(parseObject, "h5_use_watchShake_is_delayed");
            String string2 = H5Utils.getString(parseObject, "h5_use_watchShake_is_adjust");
            if (!"no".equalsIgnoreCase(string)) {
                if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string2)) {
                    UPTATE_INTERVAL_TIME = H5Utils.parseInt(H5Utils.getString(parseObject, "h5_use_watchShake_interval_time"));
                    SPEED_THRESHOLD = H5Utils.parseInt(H5Utils.getString(parseObject, "h5_use_watchShake_speed_threshold"));
                    COUNTS_LIMITED = H5Utils.parseInt(H5Utils.getString(parseObject, "h5_use_watchShake_counts_limited"));
                }
                sensorEventListener = getListenerDelayed();
            } else {
                sensorEventListener = getListener();
            }
            sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
            this.registered = true;
        }
    }

    /* access modifiers changed from: private */
    public void unregisterListener() {
        SensorEventListener sensorEventListener;
        if (this.registered) {
            SensorManager sensorManager = (SensorManager) H5Environment.getContext().getSystemService("sensor");
            if (!"no".equalsIgnoreCase(H5Environment.getConfig("h5_use_watchShake_delayed"))) {
                sensorEventListener = getListenerDelayed();
            } else {
                sensorEventListener = getListener();
            }
            sensorManager.unregisterListener(sensorEventListener);
            this.registered = false;
        }
    }
}
