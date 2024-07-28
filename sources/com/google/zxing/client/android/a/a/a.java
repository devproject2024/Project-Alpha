package com.google.zxing.client.android.a.a;

import android.hardware.Camera;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40117a = a.class.getName();

    private a() {
    }

    public static Camera a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        boolean z = i2 >= 0;
        if (!z) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        if (i2 < numberOfCameras) {
            return Camera.open(i2);
        }
        if (z) {
            return null;
        }
        return Camera.open(0);
    }
}
