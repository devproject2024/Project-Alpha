package com.business.common_module.zxingutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.preference.PreferenceManager;
import com.business.common_module.utilities.LogUtility;
import com.google.zxing.client.android.a.e;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f7405a;

    /* renamed from: b  reason: collision with root package name */
    Point f7406b;

    /* renamed from: c  reason: collision with root package name */
    Point f7407c;

    c(Context context) {
        this.f7405a = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            LogUtility.d("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        LogUtility.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            LogUtility.d("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f7405a);
        a(parameters, e.readPref(defaultSharedPreferences) == e.ON, z);
        d.a(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                d.e(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                d.d(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                d.c(parameters);
                d.a(parameters);
                d.b(parameters);
            }
        }
        parameters.setPreviewSize(this.f7407c.x, this.f7407c.y);
        LogUtility.i("CameraConfiguration", "Final camera parameters: " + parameters.flatten());
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
        if (this.f7407c.x != previewSize.width || this.f7407c.y != previewSize.height) {
            LogUtility.d("CameraConfiguration", "Camera said it supported preview size " + this.f7407c.x + 'x' + this.f7407c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.f7407c.x = previewSize.width;
            this.f7407c.y = previewSize.height;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Camera.Parameters parameters, boolean z, boolean z2) {
        d.a(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f7405a);
        if (!z2 && !defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            d.b(parameters, z);
        }
    }
}
