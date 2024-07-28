package com.business.common_module.zxingutils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.google.zxing.client.android.a.e;

public final class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7394a;

    /* renamed from: b  reason: collision with root package name */
    private e f7395b;

    /* renamed from: c  reason: collision with root package name */
    private Sensor f7396c;

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public a(Context context) {
        this.f7394a = context;
    }

    public final void a(e eVar) {
        this.f7395b = eVar;
        if (e.readPref(PreferenceManager.getDefaultSharedPreferences(this.f7394a)) == e.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f7394a.getSystemService("sensor");
            this.f7396c = sensorManager.getDefaultSensor(5);
            Sensor sensor = this.f7396c;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3);
            }
        }
    }

    public final void a() {
        if (this.f7396c != null) {
            ((SensorManager) this.f7394a.getSystemService("sensor")).unregisterListener(this);
            this.f7395b = null;
            this.f7396c = null;
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        e eVar = this.f7395b;
        if (eVar == null) {
            return;
        }
        if (f2 <= 45.0f) {
            eVar.a(true);
        } else if (f2 >= 450.0f) {
            eVar.a(false);
        }
    }
}
