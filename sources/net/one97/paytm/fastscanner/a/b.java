package net.one97.paytm.fastscanner.a;

import android.hardware.Camera;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f50413c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static b f50414f;

    /* renamed from: a  reason: collision with root package name */
    public Camera f50415a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50416b;

    /* renamed from: d  reason: collision with root package name */
    private final a f50417d;

    /* renamed from: e  reason: collision with root package name */
    private final c f50418e;

    private b() {
        this.f50417d = new a();
        this.f50418e = new c(this.f50417d);
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public final void a() throws IOException {
        if (this.f50415a == null) {
            this.f50415a = Camera.open();
            if (this.f50415a != null) {
                if (p.a(Build.MODEL, "nexus 5x", true)) {
                    Camera camera = this.f50415a;
                    if (camera != null) {
                        camera.setDisplayOrientation(270);
                    }
                } else {
                    Camera camera2 = this.f50415a;
                    if (camera2 != null) {
                        camera2.setDisplayOrientation(90);
                    }
                }
                a aVar = this.f50417d;
                Camera camera3 = this.f50415a;
                if (camera3 == null) {
                    k.a();
                }
                aVar.a(camera3);
                a aVar2 = this.f50417d;
                Camera camera4 = this.f50415a;
                if (camera4 == null) {
                    k.a();
                }
                aVar2.b(camera4);
                return;
            }
            throw new IOException();
        }
    }

    public final void b() {
        Camera camera = this.f50415a;
        if (camera != null) {
            if (camera == null) {
                k.a();
            }
            camera.release();
            this.f50416b = false;
            this.f50415a = null;
            f50414f = null;
        }
    }

    public final void c() {
        Camera camera = this.f50415a;
        if (camera != null && this.f50416b) {
            if (camera == null) {
                k.a();
            }
            camera.stopPreview();
            this.f50418e.a(0);
            this.f50416b = false;
        }
    }

    public final void a(int i2) {
        if (this.f50415a != null && this.f50416b) {
            this.f50418e.a(i2);
            Camera camera = this.f50415a;
            if (camera == null) {
                k.a();
            }
            camera.setOneShotPreviewCallback(this.f50418e);
        }
    }

    public final boolean d() {
        List<String> supportedFlashModes;
        Camera camera = this.f50415a;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (!(parameters == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null || supportedFlashModes.size() == 0)) {
                    return k.a((Object) "torch", (Object) parameters.getFlashMode());
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a() {
            if (b.f50414f == null) {
                b.f50414f = new b((byte) 0);
            }
        }
    }
}
