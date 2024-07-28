package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.google.android.exoplayer2.video.a.c;

final class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f33611a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f33612b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f33613c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f33614d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private final Display f33615e;

    /* renamed from: f  reason: collision with root package name */
    private final a[] f33616f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33617g;

    public interface a {
        void a(float[] fArr, float f2);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public b(Display display, a... aVarArr) {
        this.f33615e = display;
        this.f33616f = aVarArr;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f33611a, sensorEvent.values);
        float[] fArr = this.f33611a;
        int rotation = this.f33615e.getRotation();
        if (rotation != 0) {
            int i2 = 130;
            int i3 = 129;
            if (rotation == 1) {
                i2 = 2;
            } else if (rotation == 2) {
                i2 = 129;
                i3 = 130;
            } else if (rotation == 3) {
                i3 = 1;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.f33612b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f33612b, i2, i3, fArr);
        }
        SensorManager.remapCoordinateSystem(this.f33611a, 1, 131, this.f33612b);
        SensorManager.getOrientation(this.f33612b, this.f33614d);
        float f2 = this.f33614d[2];
        Matrix.rotateM(this.f33611a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr3 = this.f33611a;
        if (!this.f33617g) {
            c.a(this.f33613c, fArr3);
            this.f33617g = true;
        }
        float[] fArr4 = this.f33612b;
        System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        Matrix.multiplyMM(fArr3, 0, this.f33612b, 0, this.f33613c, 0);
        a(this.f33611a, f2);
    }

    private void a(float[] fArr, float f2) {
        for (a a2 : this.f33616f) {
            a2.a(fArr, f2);
        }
    }
}
