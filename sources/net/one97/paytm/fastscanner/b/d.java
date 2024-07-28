package net.one97.paytm.fastscanner.b;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.view.SurfaceHolder;
import com.sendbird.android.constant.StringSet;
import java.io.IOException;
import java.util.List;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.fastscanner.R;
import net.one97.paytm.fastscanner.a.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f50426a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static b f50427b = b.STOPPED;

    /* renamed from: c  reason: collision with root package name */
    private static net.one97.paytm.fastscanner.a f50428c = new net.one97.paytm.fastscanner.a();

    public enum b {
        INITIALISED,
        PREVIEW,
        STOPPED
    }

    private d() {
    }

    public static b a() {
        return f50427b;
    }

    public static net.one97.paytm.fastscanner.a b() {
        return f50428c;
    }

    public static void a(Context context) {
        k.c(context, "context");
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        b.a.a();
        f.a().a(context);
    }

    public static void c() throws IOException, RuntimeException {
        f50427b = b.INITIALISED;
        try {
            b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
            net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
            if (e2 != null) {
                e2.a();
            }
        } catch (Exception unused) {
            b.a aVar2 = net.one97.paytm.fastscanner.a.b.f50413c;
            net.one97.paytm.fastscanner.a.b e3 = net.one97.paytm.fastscanner.a.b.f50414f;
            if (e3 != null) {
                e3.c();
            }
            b.a aVar3 = net.one97.paytm.fastscanner.a.b.f50413c;
            net.one97.paytm.fastscanner.a.b e4 = net.one97.paytm.fastscanner.a.b.f50414f;
            if (e4 != null) {
                e4.b();
            }
            b.a aVar4 = net.one97.paytm.fastscanner.a.b.f50413c;
            b.a.a();
            b.a aVar5 = net.one97.paytm.fastscanner.a.b.f50413c;
            net.one97.paytm.fastscanner.a.b e5 = net.one97.paytm.fastscanner.a.b.f50414f;
            if (e5 != null) {
                e5.a();
            }
        }
    }

    public static void a(SurfaceHolder surfaceHolder) {
        k.c(surfaceHolder, "surfaceHolder");
        if (f50427b != b.STOPPED) {
            f50427b = b.PREVIEW;
            try {
                b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
                net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
                if (e2 != null) {
                    k.c(surfaceHolder, "surfaceHolder");
                    if (e2.f50415a != null && !e2.f50416b) {
                        Camera camera = e2.f50415a;
                        if (camera == null) {
                            k.a();
                        }
                        camera.setPreviewDisplay(surfaceHolder);
                        Camera camera2 = e2.f50415a;
                        if (camera2 == null) {
                            k.a();
                        }
                        camera2.startPreview();
                        e2.f50416b = true;
                    }
                }
                b.a aVar2 = net.one97.paytm.fastscanner.a.b.f50413c;
                net.one97.paytm.fastscanner.a.b e3 = net.one97.paytm.fastscanner.a.b.f50414f;
                if (e3 != null) {
                    e3.a(R.id.decode);
                }
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("Camera has not been initialized. Please use (FastScanCameraController.StartCamera()");
        }
    }

    public static void d() {
        f50427b = b.STOPPED;
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            e2.c();
        }
        f50428c.removeMessages(R.id.decode_succeeded);
        net.one97.paytm.fastscanner.c.a aVar2 = net.one97.paytm.fastscanner.c.a.f50448b;
        net.one97.paytm.fastscanner.c.a.a(false);
    }

    public static void e() {
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            e2.b();
        }
    }

    public static void f() {
        f.a().b();
    }

    public static void a(boolean z) {
        List<String> supportedFlashModes;
        try {
            b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
            net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
            if (e2 != null && e2.f50415a != null) {
                Camera camera = e2.f50415a;
                if (camera == null) {
                    k.a();
                }
                Camera.Parameters parameters = camera.getParameters();
                if (parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null) {
                    if (supportedFlashModes.size() != 0) {
                        String flashMode = parameters.getFlashMode();
                        if (z) {
                            if (!k.a((Object) "torch", (Object) flashMode) && supportedFlashModes.contains("torch")) {
                                parameters.setFlashMode("torch");
                                Camera camera2 = e2.f50415a;
                                if (camera2 == null) {
                                    k.a();
                                }
                                camera2.setParameters(parameters);
                            }
                        } else if (!k.a((Object) StringSet.off, (Object) flashMode) && supportedFlashModes.contains(StringSet.off)) {
                            parameters.setFlashMode(StringSet.off);
                            Camera camera3 = e2.f50415a;
                            if (camera3 == null) {
                                k.a();
                            }
                            camera3.setParameters(parameters);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static Camera g() {
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            return e2.f50415a;
        }
        return null;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f50429a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static int f50430b;

        /* renamed from: c  reason: collision with root package name */
        private static Integer[] f50431c = {0, 1};

        /* renamed from: d  reason: collision with root package name */
        private static o<Integer, Integer> f50432d = new o<>(1280, 960);

        private a() {
        }

        public static o<Integer, Integer> a() {
            return f50432d;
        }

        public static void b() {
            f50430b = 0;
        }

        public static void a(int i2, int i3) {
            f50432d = new o<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }

        public static int c() {
            return f50430b;
        }
    }

    public static boolean h() {
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            return e2.d();
        }
        return false;
    }

    public static void a(Intent intent) {
        k.c(intent, "intent");
        Uri data = intent.getData();
        if (data != null) {
            f.a().a(R.id.decode_from_gallery_file, data);
        }
    }

    public static void i() {
        f50427b = b.STOPPED;
        b.a aVar = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            e2.c();
        }
        b.a aVar2 = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e3 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e3 != null) {
            e3.b();
        }
        f50428c.removeMessages(R.id.decode_succeeded);
        f.a().b();
    }
}
