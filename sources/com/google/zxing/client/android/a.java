package com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.zxing.client.android.a.d;

public final class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final Context f40106a;

    /* renamed from: b  reason: collision with root package name */
    d f40107b;

    /* renamed from: c  reason: collision with root package name */
    Sensor f40108c;

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public a(Context context) {
        this.f40106a = context;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        d dVar = this.f40107b;
        if (dVar == null) {
            return;
        }
        if (f2 <= 45.0f) {
            dVar.a(true);
        } else if (f2 >= 450.0f) {
            dVar.a(false);
        }
    }
}
