package net.one97.paytm.fastscanner.a;

import android.hardware.Camera;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.o;
import net.one97.paytm.fastscanner.b.d;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f50405b = a.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f50406c = Pattern.compile(AppConstants.COMMA);

    /* renamed from: a  reason: collision with root package name */
    C0907a f50407a;

    /* renamed from: d  reason: collision with root package name */
    private C0907a f50408d;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Camera camera) {
        d.a aVar = d.a.f50429a;
        o<Integer, Integer> a2 = d.a.a();
        int intValue = a2.getFirst().intValue();
        int intValue2 = a2.getSecond().intValue();
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList<b> arrayList = new ArrayList<>();
        for (Camera.Size next : supportedPreviewSizes) {
            float f2 = ((float) next.width) / ((float) next.height);
            Iterator<Camera.Size> it2 = supportedPictureSizes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Camera.Size next2 = it2.next();
                if (Math.abs(f2 - (((float) next2.width) / ((float) next2.height))) < 0.1f) {
                    arrayList.add(new b(next, next2));
                    break;
                }
            }
        }
        b bVar = null;
        if (arrayList.size() == 0) {
            for (Camera.Size bVar2 : supportedPreviewSizes) {
                arrayList.add(new b(bVar2, (Camera.Size) null));
            }
        }
        int i2 = Integer.MAX_VALUE;
        if (arrayList.size() > 0) {
            for (b bVar3 : arrayList) {
                C0907a aVar2 = bVar3.f50411a;
                int abs = Math.abs(aVar2.f50409a - intValue) + Math.abs(aVar2.f50410b - intValue2);
                if (abs < i2) {
                    bVar = bVar3;
                    i2 = abs;
                }
            }
        }
        if (bVar != null) {
            this.f50408d = bVar.f50412b;
            this.f50407a = bVar.f50411a;
            return;
        }
        throw new RuntimeException("Could not find suitable preview size.");
    }

    /* access modifiers changed from: package-private */
    public final void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f50407a.f50409a, this.f50407a.f50410b);
        parameters.setPictureSize(this.f50408d.f50409a, this.f50408d.f50410b);
        parameters.setFocusMode(c(camera));
        d.a aVar = d.a.f50429a;
        parameters.setZoom(d.a.c());
        try {
            camera.setParameters(parameters);
        } catch (Exception unused) {
            List<Camera.Size> supportedPictureSizes = camera.getParameters().getSupportedPictureSizes();
            Camera.Size size = supportedPictureSizes.get(0);
            for (int i2 = 0; i2 < supportedPictureSizes.size(); i2++) {
                if (supportedPictureSizes.get(i2).width > size.width) {
                    size = supportedPictureSizes.get(i2);
                }
            }
            parameters.setPictureSize(size.width, size.height);
            List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            Camera.Size size2 = supportedPreviewSizes.get(0);
            for (int i3 = 0; i3 < supportedPreviewSizes.size(); i3++) {
                if (supportedPreviewSizes.get(i3).width > size2.width) {
                    size2 = supportedPreviewSizes.get(i3);
                }
            }
            parameters.setPreviewSize(size2.width, size2.height);
            parameters.setFocusMode(c(camera));
            try {
                camera.setParameters(parameters);
            } catch (Exception unused2) {
            }
        }
    }

    private static String c(Camera camera) {
        if (camera.getParameters().getSupportedFocusModes().contains("continuous-picture")) {
            return "continuous-picture";
        }
        return camera.getParameters().getSupportedFocusModes().contains("auto") ? "auto" : "fixed";
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        C0907a f50411a;

        /* renamed from: b  reason: collision with root package name */
        C0907a f50412b;

        b(Camera.Size size, Camera.Size size2) {
            this.f50411a = new C0907a(size.width, size.height);
            if (size2 != null) {
                this.f50412b = new C0907a(size2.width, size2.height);
            }
        }
    }

    /* renamed from: net.one97.paytm.fastscanner.a.a$a  reason: collision with other inner class name */
    static class C0907a {

        /* renamed from: a  reason: collision with root package name */
        int f50409a;

        /* renamed from: b  reason: collision with root package name */
        int f50410b;

        C0907a(int i2, int i3) {
            this.f50409a = i2;
            this.f50410b = i3;
        }
    }
}
