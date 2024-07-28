package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.appsflyer.internal.r;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AFSensorManager {
    public static volatile AFSensorManager sInstance;

    /* renamed from: ȷ  reason: contains not printable characters */
    private static final BitSet f39 = new BitSet(6);

    /* renamed from: ɪ  reason: contains not printable characters */
    private static final Handler f40 = new Handler(Looper.getMainLooper());

    /* renamed from: ı  reason: contains not printable characters */
    final Handler f41;
    /* access modifiers changed from: package-private */

    /* renamed from: Ɩ  reason: contains not printable characters */
    public int f42 = 1;

    /* renamed from: ǃ  reason: contains not printable characters */
    final Map<r, r> f43 = new HashMap(f39.size());
    /* access modifiers changed from: private */

    /* renamed from: ɨ  reason: contains not printable characters */
    public final Runnable f44 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f49) {
                if (AFSensorManager.this.f42 == 0) {
                    int unused = AFSensorManager.this.f42 = 1;
                }
                AFSensorManager.this.f41.postDelayed(AFSensorManager.this.f51, ((long) AFSensorManager.this.f42) * 500);
            }
        }
    };

    /* renamed from: ɩ  reason: contains not printable characters */
    final SensorManager f45;

    /* renamed from: ɹ  reason: contains not printable characters */
    final Runnable f46 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f49) {
                AFSensorManager aFSensorManager = AFSensorManager.this;
                try {
                    for (Sensor next : aFSensorManager.f45.getSensorList(-1)) {
                        if (AFSensorManager.m28(next.getType())) {
                            r rVar = new r(next.getType(), next.getName(), next.getVendor());
                            if (!aFSensorManager.f43.containsKey(rVar)) {
                                aFSensorManager.f43.put(rVar, rVar);
                            }
                            aFSensorManager.f45.registerListener(aFSensorManager.f43.get(rVar), next, 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                aFSensorManager.f52 = true;
                AFSensorManager.this.f41.postDelayed(AFSensorManager.this.f44, 100);
                AFSensorManager.this.f48 = true;
            }
        }
    };

    /* renamed from: ɾ  reason: contains not printable characters */
    long f47 = 0;

    /* renamed from: Ι  reason: contains not printable characters */
    boolean f48;

    /* renamed from: ι  reason: contains not printable characters */
    final Object f49 = new Object();

    /* renamed from: І  reason: contains not printable characters */
    final Runnable f50 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f49) {
                if (AFSensorManager.this.f48) {
                    AFSensorManager.this.f41.removeCallbacks(AFSensorManager.this.f46);
                    AFSensorManager.this.f41.removeCallbacks(AFSensorManager.this.f51);
                    AFSensorManager.this.m31();
                    AFSensorManager.this.f48 = false;
                }
            }
        }
    };

    /* renamed from: і  reason: contains not printable characters */
    final Runnable f51 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f49) {
                AFSensorManager.this.m31();
            }
        }
    };

    /* renamed from: Ӏ  reason: contains not printable characters */
    boolean f52;

    /* renamed from: ӏ  reason: contains not printable characters */
    private final Map<r, Map<String, Object>> f53 = new ConcurrentHashMap(f39.size());

    static {
        f39.set(1);
        f39.set(2);
        f39.set(4);
    }

    private AFSensorManager(SensorManager sensorManager, Handler handler) {
        this.f45 = sensorManager;
        this.f41 = handler;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static AFSensorManager m27(Context context) {
        if (sInstance != null) {
            return sInstance;
        }
        return m24((SensorManager) context.getApplicationContext().getSystemService("sensor"), f40);
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static AFSensorManager m24(SensorManager sensorManager, Handler handler) {
        if (sInstance == null) {
            synchronized (AFSensorManager.class) {
                if (sInstance == null) {
                    sInstance = new AFSensorManager(sensorManager, handler);
                }
            }
        }
        return sInstance;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static boolean m28(int i2) {
        return i2 >= 0 && f39.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public final void m31() {
        try {
            if (!this.f43.isEmpty()) {
                for (r next : this.f43.values()) {
                    this.f45.unregisterListener(next);
                    next.m194(this.f53, true);
                }
            }
        } catch (Throwable unused) {
        }
        this.f42 = 0;
        this.f52 = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final List<Map<String, Object>> m30() {
        for (r r1 : this.f43.values()) {
            r1.m194(this.f53, true);
        }
        Map<r, Map<String, Object>> map = this.f53;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.f53.values());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public final List<Map<String, Object>> m32() {
        synchronized (this.f49) {
            if (!this.f43.isEmpty() && this.f52) {
                for (r r2 : this.f43.values()) {
                    r2.m194(this.f53, false);
                }
            }
            if (this.f53.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.f53.values());
            return copyOnWriteArrayList2;
        }
    }
}
