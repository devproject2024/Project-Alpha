package com.google.zxing.client.android.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.preference.PreferenceManager;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final Context f40118a;

    /* renamed from: b  reason: collision with root package name */
    public Point f40119b;

    /* renamed from: c  reason: collision with root package name */
    Point f40120c;

    b(Context context) {
        this.f40118a = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters != null) {
            new StringBuilder("Initial camera parameters: ").append(parameters.flatten());
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f40118a);
            a(parameters, e.readPref(defaultSharedPreferences) == e.ON, z);
            c.a(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z);
            if (!z) {
                if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                    c.e(parameters);
                }
                if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                    c.d(parameters);
                }
                if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                    c.c(parameters);
                    c.a(parameters);
                    c.b(parameters);
                }
            }
            parameters.setPreviewSize(this.f40120c.x, this.f40120c.y);
            new StringBuilder("Final camera parameters: ").append(parameters.flatten());
            if (Build.MODEL.equalsIgnoreCase("nexus 5x")) {
                camera.setDisplayOrientation(270);
            } else {
                camera.setDisplayOrientation(90);
            }
            camera.setParameters(parameters);
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            if (previewSize == null) {
                return;
            }
            if (this.f40120c.x != previewSize.width || this.f40120c.y != previewSize.height) {
                StringBuilder sb = new StringBuilder("Camera said it supported preview size ");
                sb.append(this.f40120c.x);
                sb.append('x');
                sb.append(this.f40120c.y);
                sb.append(", but after setting it, preview size is ");
                sb.append(previewSize.width);
                sb.append('x');
                sb.append(previewSize.height);
                this.f40120c.x = previewSize.width;
                this.f40120c.y = previewSize.height;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Camera.Parameters parameters, boolean z, boolean z2) {
        c.a(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f40118a);
        if (!z2 && !defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            c.b(parameters, z);
        }
    }
}
