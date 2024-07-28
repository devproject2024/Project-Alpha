package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r implements SensorEventListener {

    /* renamed from: ı  reason: contains not printable characters */
    private final String f280;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private long f281;

    /* renamed from: ǃ  reason: contains not printable characters */
    private final int f282;

    /* renamed from: ɩ  reason: contains not printable characters */
    private final float[][] f283 = new float[2][];

    /* renamed from: Ι  reason: contains not printable characters */
    private final long[] f284 = new long[2];

    /* renamed from: ι  reason: contains not printable characters */
    private final String f285;

    /* renamed from: І  reason: contains not printable characters */
    private final int f286;

    /* renamed from: і  reason: contains not printable characters */
    private double f287;

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public r(int i2, String str, String str2) {
        this.f282 = i2;
        this.f280 = str == null ? "" : str;
        this.f285 = str2 == null ? "" : str2;
        this.f286 = ((((i2 + 31) * 31) + this.f280.hashCode()) * 31) + this.f285.hashCode();
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static double m188(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d2 = 0.0d;
        for (int i2 = 0; i2 < min; i2++) {
            d2 += StrictMath.pow((double) (fArr[i2] - fArr2[i2]), 2.0d);
        }
        return Math.sqrt(d2);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m192(Sensor sensor) {
        return (sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static List<Float> m190(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.values != null && m192(sensorEvent.sensor)) {
            int type = sensorEvent.sensor.getType();
            String name = sensorEvent.sensor.getName();
            String vendor = sensorEvent.sensor.getVendor();
            long j = sensorEvent.timestamp;
            float[] fArr = sensorEvent.values;
            if (m191(type, name, vendor)) {
                long currentTimeMillis = System.currentTimeMillis();
                float[][] fArr2 = this.f283;
                float[] fArr3 = fArr2[0];
                if (fArr3 == null) {
                    fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                    this.f284[0] = currentTimeMillis;
                    return;
                }
                float[] fArr4 = fArr2[1];
                if (fArr4 == null) {
                    float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                    this.f283[1] = copyOf;
                    this.f284[1] = currentTimeMillis;
                    this.f287 = m188(fArr3, copyOf);
                } else if (50000000 <= j - this.f281) {
                    this.f281 = j;
                    if (Arrays.equals(fArr4, fArr)) {
                        this.f284[1] = currentTimeMillis;
                        return;
                    }
                    double r2 = m188(fArr3, fArr);
                    if (r2 > this.f287) {
                        this.f283[1] = Arrays.copyOf(fArr, fArr.length);
                        this.f284[1] = currentTimeMillis;
                        this.f287 = r2;
                    }
                }
            }
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final void m194(Map<r, Map<String, Object>> map, boolean z) {
        if (m189()) {
            map.put(this, m193());
            if (z) {
                int length = this.f283.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.f283[i2] = null;
                }
                int length2 = this.f284.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f284[i3] = 0;
                }
                this.f287 = 0.0d;
                this.f281 = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m193());
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m191(int i2, String str, String str2) {
        return this.f282 == i2 && this.f280.equals(str) && this.f285.equals(str2);
    }

    /* renamed from: ι  reason: contains not printable characters */
    private Map<String, Object> m193() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.f282));
        concurrentHashMap.put("sN", this.f280);
        concurrentHashMap.put("sV", this.f285);
        float[] fArr = this.f283[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", m190(fArr));
        }
        float[] fArr2 = this.f283[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", m190(fArr2));
        }
        return concurrentHashMap;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private boolean m189() {
        return this.f283[0] != null;
    }

    public final int hashCode() {
        return this.f286;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return m191(rVar.f282, rVar.f280, rVar.f285);
    }
}
