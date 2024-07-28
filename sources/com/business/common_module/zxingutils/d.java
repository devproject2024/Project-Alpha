package com.business.common_module.zxingutils;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.business.common_module.utilities.LogUtility;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7408a = Pattern.compile(";");

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String a2 = z ? (z3 || z2) ? a("focus mode", supportedFocusModes, "auto") : a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && a2 == null) {
            a2 = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (a2 == null) {
            return;
        }
        if (a2.equals(parameters.getFocusMode())) {
            LogUtility.i("CameraConfiguration", "Focus mode already set to ".concat(String.valueOf(a2)));
        } else {
            parameters.setFocusMode(a2);
        }
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = a("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = a("flash mode", supportedFlashModes, StringSet.off);
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            LogUtility.i("CameraConfiguration", "Flash mode already set to ".concat(String.valueOf(str)));
            return;
        }
        LogUtility.i("CameraConfiguration", "Setting flash mode to ".concat(String.valueOf(str)));
        parameters.setFlashMode(str);
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0)) {
            float f2 = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z) {
                    f2 = 1.5f;
                }
                int round = Math.round(f2 / exposureCompensationStep);
                float f3 = exposureCompensationStep * ((float) round);
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    LogUtility.i("CameraConfiguration", "Exposure compensation already set to " + max + " / " + f3);
                    return;
                }
                LogUtility.i("CameraConfiguration", "Setting exposure compensation to " + max + " / " + f3);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        LogUtility.i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            LogUtility.i("CameraConfiguration", "Old focus areas: " + a((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> a2 = a();
            LogUtility.i("CameraConfiguration", "Setting focus area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setFocusAreas(a2);
            return;
        }
        LogUtility.i("CameraConfiguration", "Device does not support focus areas");
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            LogUtility.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> a2 = a();
            LogUtility.i("CameraConfiguration", "Setting metering area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setMeteringAreas(a2);
            return;
        }
        LogUtility.i("CameraConfiguration", "Device does not support metering areas");
    }

    private static List<Camera.Area> a() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    public static void c(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            LogUtility.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            LogUtility.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            LogUtility.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            LogUtility.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String a2 = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (a2 != null) {
            parameters.setSceneMode(a2);
        }
    }

    public static void e(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            LogUtility.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String a2 = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (a2 != null) {
            parameters.setColorEffect(a2);
        }
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        Point point2 = point;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            LogUtility.d("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList<>(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                Camera.Size size = (Camera.Size) obj;
                Camera.Size size2 = (Camera.Size) obj2;
                int i2 = size.height * size.width;
                int i3 = size2.height * size2.width;
                if (i3 < i2) {
                    return -1;
                }
                return i3 > i2 ? 1 : 0;
            }
        });
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            LogUtility.i("CameraConfiguration", "Supported preview sizes: ".concat(String.valueOf(sb)));
        }
        double d2 = ((double) point2.x) / ((double) point2.y);
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (it2.hasNext()) {
                Camera.Size size2 = (Camera.Size) it2.next();
                int i2 = size2.width;
                int i3 = size2.height;
                if (i2 * i3 < 153600) {
                    it2.remove();
                } else {
                    if (i2 < i3) {
                        z = true;
                    }
                    int i4 = z ? i3 : i2;
                    int i5 = z ? i2 : i3;
                    if (Math.abs((((double) i4) / ((double) i5)) - d2) > 0.15d) {
                        it2.remove();
                    } else if (i4 == point2.x && i5 == point2.y) {
                        Point point3 = new Point(i2, i3);
                        LogUtility.i("CameraConfiguration", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                        return point3;
                    }
                }
            } else if (!arrayList.isEmpty()) {
                Camera.Size size3 = (Camera.Size) arrayList.get(0);
                Point point4 = new Point(size3.width, size3.height);
                LogUtility.i("CameraConfiguration", "Using largest suitable preview size: ".concat(String.valueOf(point4)));
                return point4;
            } else {
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point5 = new Point(previewSize2.width, previewSize2.height);
                    LogUtility.i("CameraConfiguration", "No suitable preview sizes, using default: ".concat(String.valueOf(point5)));
                    return point5;
                }
                throw new IllegalStateException("Parameters contained no preview size!");
            }
        }
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        LogUtility.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        LogUtility.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    LogUtility.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        LogUtility.i("CameraConfiguration", "No supported values match");
        return null;
    }

    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area next : iterable) {
            sb.append(next.rect);
            sb.append(':');
            sb.append(next.weight);
            sb.append(' ');
        }
        return sb.toString();
    }
}
