package com.google.zxing.client.android.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.business.merchant_payments.mapqr.vision.ViewFinder;
import com.google.zxing.client.android.a.a.a;
import java.io.IOException;

public final class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f40122b = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final b f40123a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f40124c;

    /* renamed from: d  reason: collision with root package name */
    private Camera f40125d;

    /* renamed from: e  reason: collision with root package name */
    private a f40126e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f40127f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f40128g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f40129h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40130i;
    private int j = -1;
    private int k;
    private int l;
    private final f m;

    public static int a(int i2, int i3) {
        int i4 = (int) ((((double) i2) * 5.8d) / 8.0d);
        if (i4 < 240) {
            return 240;
        }
        return i4 > i3 ? i3 : i4;
    }

    public d(Context context) {
        this.f40124c = context;
        this.f40123a = new b(context);
        this.m = new f(this.f40123a);
    }

    public final synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        String str;
        Camera camera = this.f40125d;
        if (camera == null) {
            camera = a.a(this.j);
            if (camera != null) {
                this.f40125d = camera;
            } else {
                throw new IOException();
            }
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.f40129h) {
            this.f40129h = true;
            b bVar = this.f40123a;
            Camera.Parameters parameters = camera.getParameters();
            Display defaultDisplay = ((WindowManager) bVar.f40118a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            bVar.f40119b = point;
            new StringBuilder("Screen resolution: ").append(bVar.f40119b);
            bVar.f40120c = c.a(parameters, bVar.f40119b);
            new StringBuilder("Camera resolution: ").append(bVar.f40120c);
            if (this.k > 0 && this.l > 0) {
                b(this.k, this.l);
                this.k = 0;
                this.l = 0;
            }
        }
        Camera.Parameters parameters2 = camera.getParameters();
        if (parameters2 == null) {
            str = null;
        } else {
            str = parameters2.flatten();
        }
        try {
            this.f40123a.a(camera, false);
        } catch (RuntimeException unused) {
            if (str != null) {
                Camera.Parameters parameters3 = camera.getParameters();
                parameters3.unflatten(str);
                try {
                    camera.setParameters(parameters3);
                    this.f40123a.a(camera, true);
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    public final synchronized boolean a() {
        return this.f40125d != null;
    }

    public final synchronized void b() {
        if (this.f40125d != null) {
            this.f40125d.release();
            this.f40125d = null;
            this.f40127f = null;
            this.f40128g = null;
        }
    }

    public final synchronized void c() {
        Camera camera = this.f40125d;
        if (camera != null && !this.f40130i) {
            camera.startPreview();
            this.f40130i = true;
            this.f40126e = new a(this.f40124c, this.f40125d);
        }
    }

    public final synchronized void d() {
        if (this.f40126e != null) {
            this.f40126e.b();
            this.f40126e = null;
        }
        if (this.f40125d != null && this.f40130i) {
            this.f40125d.stopPreview();
            this.m.a((Handler) null, 0);
            this.f40130i = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r0 = (r0 = r0.getParameters()).getFlashMode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.hardware.Camera r0 = r4.f40125d     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r0.getFlashMode()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0024
            java.lang.String r2 = "on"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "torch"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0024
        L_0x0022:
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r5 == r0) goto L_0x004b
            android.hardware.Camera r0 = r4.f40125d     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x004b
            com.google.zxing.client.android.a.a r0 = r4.f40126e     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0034
            com.google.zxing.client.android.a.a r0 = r4.f40126e     // Catch:{ all -> 0x004d }
            r0.b()     // Catch:{ all -> 0x004d }
        L_0x0034:
            com.google.zxing.client.android.a.b r0 = r4.f40123a     // Catch:{ all -> 0x004d }
            android.hardware.Camera r2 = r4.f40125d     // Catch:{ all -> 0x004d }
            android.hardware.Camera$Parameters r3 = r2.getParameters()     // Catch:{ all -> 0x004d }
            r0.a(r3, r5, r1)     // Catch:{ all -> 0x004d }
            r2.setParameters(r3)     // Catch:{ all -> 0x004d }
            com.google.zxing.client.android.a.a r5 = r4.f40126e     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x004b
            com.google.zxing.client.android.a.a r5 = r4.f40126e     // Catch:{ all -> 0x004d }
            r5.a()     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r4)
            return
        L_0x004d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.a.d.a(boolean):void");
    }

    public final synchronized void a(Handler handler, int i2) {
        Camera camera = this.f40125d;
        if (camera != null && this.f40130i) {
            this.m.a(handler, i2);
            camera.setOneShotPreviewCallback(this.m);
        }
    }

    public final synchronized Rect e() {
        if (this.f40127f == null) {
            if (this.f40125d == null) {
                return null;
            }
            Point point = this.f40123a.f40119b;
            if (point == null) {
                return null;
            }
            int i2 = (point.x * 5) / 8;
            if (i2 < 240) {
                i2 = 240;
            } else if (i2 > 1200) {
                i2 = ViewFinder.MAX_FRAME_WIDTH;
            }
            int i3 = point.y;
            int i4 = (point.x - i2) / 2;
            int i5 = (point.y - i2) / 4;
            this.f40127f = new Rect(i4, i5, i4 + i2, i2 + i5);
            new StringBuilder("Calculated framing rect: ").append(this.f40127f);
        }
        return this.f40127f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Rect f() {
        /*
            r6 = this;
            monitor-enter(r6)
            android.graphics.Rect r0 = r6.f40128g     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0057
            android.graphics.Rect r0 = r6.e()     // Catch:{ all -> 0x005b }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)
            return r1
        L_0x000e:
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x005b }
            r2.<init>(r0)     // Catch:{ all -> 0x005b }
            com.google.zxing.client.android.a.b r0 = r6.f40123a     // Catch:{ all -> 0x005b }
            android.graphics.Point r0 = r0.f40120c     // Catch:{ all -> 0x005b }
            com.google.zxing.client.android.a.b r3 = r6.f40123a     // Catch:{ all -> 0x005b }
            android.graphics.Point r3 = r3.f40119b     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0055
            if (r3 != 0) goto L_0x0020
            goto L_0x0055
        L_0x0020:
            int r1 = r2.left     // Catch:{ all -> 0x005b }
            int r4 = r0.y     // Catch:{ all -> 0x005b }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x005b }
            int r1 = r1 / r4
            r2.left = r1     // Catch:{ all -> 0x005b }
            int r1 = r2.right     // Catch:{ all -> 0x005b }
            int r4 = r0.y     // Catch:{ all -> 0x005b }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x005b }
            int r1 = r1 / r4
            r2.right = r1     // Catch:{ all -> 0x005b }
            int r1 = r2.top     // Catch:{ all -> 0x005b }
            int r4 = r0.x     // Catch:{ all -> 0x005b }
            int r5 = r2.top     // Catch:{ all -> 0x005b }
            int r4 = r4 + r5
            int r1 = r1 * r4
            int r4 = r3.y     // Catch:{ all -> 0x005b }
            int r1 = r1 / r4
            r2.top = r1     // Catch:{ all -> 0x005b }
            int r1 = r2.bottom     // Catch:{ all -> 0x005b }
            int r0 = r0.x     // Catch:{ all -> 0x005b }
            int r4 = r2.top     // Catch:{ all -> 0x005b }
            int r0 = r0 + r4
            int r1 = r1 * r0
            int r0 = r3.y     // Catch:{ all -> 0x005b }
            int r1 = r1 / r0
            r2.bottom = r1     // Catch:{ all -> 0x005b }
            r6.f40128g = r2     // Catch:{ all -> 0x005b }
            goto L_0x0057
        L_0x0055:
            monitor-exit(r6)
            return r1
        L_0x0057:
            android.graphics.Rect r0 = r6.f40128g     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return r0
        L_0x005b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.a.d.f():android.graphics.Rect");
    }

    public final synchronized void a(int i2) {
        this.j = i2;
    }

    public final synchronized void b(int i2, int i3) {
        if (this.f40129h) {
            Point point = this.f40123a.f40119b;
            if (i2 > point.x) {
                i2 = point.x;
            }
            if (i3 > point.y) {
                i3 = point.y;
            }
            int i4 = (point.x - i2) / 2;
            int i5 = (point.y - i3) / 2;
            this.f40127f = new Rect(i4, i5, i2 + i4, i3 + i5);
            new StringBuilder("Calculated manual framing rect: ").append(this.f40127f);
            this.f40128g = null;
            return;
        }
        this.k = i2;
        this.l = i3;
    }
}
