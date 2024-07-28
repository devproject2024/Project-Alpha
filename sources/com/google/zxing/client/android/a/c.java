package com.google.zxing.client.android.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40121a = Pattern.compile(";");

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String a2 = z ? (z3 || z2) ? a("focus mode", supportedFocusModes, "auto") : a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && a2 == null) {
            a2 = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (a2 != null && !a2.equals(parameters.getFocusMode())) {
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
        if (str != null && !str.equals(parameters.getFlashMode())) {
            parameters.setFlashMode(str);
        }
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            float f2 = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z) {
                    f2 = 1.5f;
                }
                int round = Math.round(f2 / exposureCompensationStep);
                float f3 = exposureCompensationStep * ((float) round);
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    StringBuilder sb = new StringBuilder("Exposure compensation already set to ");
                    sb.append(max);
                    sb.append(" / ");
                    sb.append(f3);
                    return;
                }
                StringBuilder sb2 = new StringBuilder("Setting exposure compensation to ");
                sb2.append(max);
                sb2.append(" / ");
                sb2.append(f3);
                parameters.setExposureCompensation(max);
            }
        }
    }

    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            new StringBuilder("Old focus areas: ").append(a((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> a2 = a();
            new StringBuilder("Setting focus area to : ").append(a((Iterable<Camera.Area>) a2));
            parameters.setFocusAreas(a2);
        }
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            new StringBuilder("Old metering areas: ").append(parameters.getMeteringAreas());
            List<Camera.Area> a2 = a();
            new StringBuilder("Setting metering area to : ").append(a((Iterable<Camera.Area>) a2));
            parameters.setMeteringAreas(a2);
        }
    }

    private static List<Camera.Area> a() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    public static void c(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported() && !parameters.getVideoStabilization()) {
            parameters.setVideoStabilization(true);
        }
    }

    public static void d(Camera.Parameters parameters) {
        String a2;
        if (!"barcode".equals(parameters.getSceneMode()) && (a2 = a("scene mode", parameters.getSupportedSceneModes(), "barcode")) != null) {
            parameters.setSceneMode(a2);
        }
    }

    public static void e(Camera.Parameters parameters) {
        String a2;
        if (!"negative".equals(parameters.getColorEffect()) && (a2 = a("color effect", parameters.getSupportedColorEffects(), "negative")) != null) {
            parameters.setColorEffect(a2);
        }
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
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
            new StringBuilder("Supported preview sizes: ").append(sb);
        }
        double d2 = ((double) point.x) / ((double) point.y);
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
                    } else if (i4 == point.x && i5 == point.y) {
                        Point point2 = new Point(i2, i3);
                        new StringBuilder("Found preview size exactly matching screen size: ").append(point2);
                        return point2;
                    }
                }
            } else if (!arrayList.isEmpty()) {
                Camera.Size size3 = (Camera.Size) arrayList.get(0);
                Point point3 = new Point(size3.width, size3.height);
                new StringBuilder("Using largest suitable preview size: ").append(point3);
                return point3;
            } else {
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point4 = new Point(previewSize2.width, previewSize2.height);
                    new StringBuilder("No suitable preview sizes, using default: ").append(point4);
                    return point4;
                }
                throw new IllegalStateException("Parameters contained no preview size!");
            }
        }
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        StringBuilder sb = new StringBuilder("Requesting ");
        sb.append(str);
        sb.append(" value from among: ");
        sb.append(Arrays.toString(strArr));
        StringBuilder sb2 = new StringBuilder("Supported ");
        sb2.append(str);
        sb2.append(" values: ");
        sb2.append(collection);
        if (collection == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (collection.contains(str2)) {
                StringBuilder sb3 = new StringBuilder("Can set ");
                sb3.append(str);
                sb3.append(" to: ");
                sb3.append(str2);
                return str2;
            }
        }
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
