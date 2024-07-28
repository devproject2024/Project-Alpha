package com.business.common_module.zxingutils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.mapqr.vision.ViewFinder;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7409a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f7410b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7411c;

    /* renamed from: d  reason: collision with root package name */
    private Camera f7412d;

    /* renamed from: e  reason: collision with root package name */
    private b f7413e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f7414f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f7415g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7416h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7417i;
    private int j = -1;
    private int k;
    private int l;
    private final h m;

    public e(Context context) {
        this.f7410b = context;
        this.f7411c = new c(context);
        this.m = new h(this.f7411c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        com.business.common_module.utilities.LogUtility.d(f7409a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
        com.business.common_module.utilities.LogUtility.i(f7409a, "Resetting to saved camera params: ".concat(java.lang.String.valueOf(r8)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ae, code lost:
        if (r8 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        r2 = r0.getParameters();
        r2.unflatten(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.setParameters(r2);
        r7.f7411c.a(r0, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.business.common_module.utilities.LogUtility.d(f7409a, "Camera rejected even safe-mode parameters! No configuration");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c9, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0098 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00c1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.view.SurfaceHolder r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            android.hardware.Camera r0 = r7.f7412d     // Catch:{ all -> 0x00ca }
            if (r0 != 0) goto L_0x0016
            int r0 = r7.j     // Catch:{ all -> 0x00ca }
            android.hardware.Camera r0 = com.google.zxing.client.android.a.a.a.a(r0)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0010
            r7.f7412d = r0     // Catch:{ all -> 0x00ca }
            goto L_0x0016
        L_0x0010:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00ca }
            r8.<init>()     // Catch:{ all -> 0x00ca }
            throw r8     // Catch:{ all -> 0x00ca }
        L_0x0016:
            r0.setPreviewDisplay(r8)     // Catch:{ all -> 0x00ca }
            boolean r8 = r7.f7416h     // Catch:{ all -> 0x00ca }
            r1 = 1
            r2 = 0
            if (r8 != 0) goto L_0x0085
            r7.f7416h = r1     // Catch:{ all -> 0x00ca }
            com.business.common_module.zxingutils.c r8 = r7.f7411c     // Catch:{ all -> 0x00ca }
            android.hardware.Camera$Parameters r3 = r0.getParameters()     // Catch:{ all -> 0x00ca }
            android.content.Context r4 = r8.f7405a     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = "window"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ all -> 0x00ca }
            android.view.WindowManager r4 = (android.view.WindowManager) r4     // Catch:{ all -> 0x00ca }
            android.view.Display r4 = r4.getDefaultDisplay()     // Catch:{ all -> 0x00ca }
            android.graphics.Point r5 = new android.graphics.Point     // Catch:{ all -> 0x00ca }
            r5.<init>()     // Catch:{ all -> 0x00ca }
            r4.getSize(r5)     // Catch:{ all -> 0x00ca }
            r8.f7406b = r5     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = "CameraConfiguration"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = "Screen resolution: "
            r5.<init>(r6)     // Catch:{ all -> 0x00ca }
            android.graphics.Point r6 = r8.f7406b     // Catch:{ all -> 0x00ca }
            r5.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ca }
            com.business.common_module.utilities.LogUtility.i(r4, r5)     // Catch:{ all -> 0x00ca }
            android.graphics.Point r4 = r8.f7406b     // Catch:{ all -> 0x00ca }
            android.graphics.Point r3 = com.business.common_module.zxingutils.d.a((android.hardware.Camera.Parameters) r3, (android.graphics.Point) r4)     // Catch:{ all -> 0x00ca }
            r8.f7407c = r3     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "CameraConfiguration"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = "Camera resolution: "
            r4.<init>(r5)     // Catch:{ all -> 0x00ca }
            android.graphics.Point r8 = r8.f7407c     // Catch:{ all -> 0x00ca }
            r4.append(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00ca }
            com.business.common_module.utilities.LogUtility.i(r3, r8)     // Catch:{ all -> 0x00ca }
            int r8 = r7.k     // Catch:{ all -> 0x00ca }
            if (r8 <= 0) goto L_0x0085
            int r8 = r7.l     // Catch:{ all -> 0x00ca }
            if (r8 <= 0) goto L_0x0085
            int r8 = r7.k     // Catch:{ all -> 0x00ca }
            int r3 = r7.l     // Catch:{ all -> 0x00ca }
            r7.a((int) r8, (int) r3)     // Catch:{ all -> 0x00ca }
            r7.k = r2     // Catch:{ all -> 0x00ca }
            r7.l = r2     // Catch:{ all -> 0x00ca }
        L_0x0085:
            android.hardware.Camera$Parameters r8 = r0.getParameters()     // Catch:{ all -> 0x00ca }
            if (r8 != 0) goto L_0x008d
            r8 = 0
            goto L_0x0091
        L_0x008d:
            java.lang.String r8 = r8.flatten()     // Catch:{ all -> 0x00ca }
        L_0x0091:
            com.business.common_module.zxingutils.c r3 = r7.f7411c     // Catch:{ RuntimeException -> 0x0098 }
            r3.a(r0, r2)     // Catch:{ RuntimeException -> 0x0098 }
            monitor-exit(r7)
            return
        L_0x0098:
            java.lang.String r2 = f7409a     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "Camera rejected parameters. Setting only minimal safe-mode parameters"
            com.business.common_module.utilities.LogUtility.d(r2, r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = f7409a     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "Resetting to saved camera params: "
            java.lang.String r4 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x00ca }
            com.business.common_module.utilities.LogUtility.i(r2, r3)     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x00c8
            android.hardware.Camera$Parameters r2 = r0.getParameters()     // Catch:{ all -> 0x00ca }
            r2.unflatten(r8)     // Catch:{ all -> 0x00ca }
            r0.setParameters(r2)     // Catch:{ RuntimeException -> 0x00c1 }
            com.business.common_module.zxingutils.c r8 = r7.f7411c     // Catch:{ RuntimeException -> 0x00c1 }
            r8.a(r0, r1)     // Catch:{ RuntimeException -> 0x00c1 }
            monitor-exit(r7)
            return
        L_0x00c1:
            java.lang.String r8 = f7409a     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "Camera rejected even safe-mode parameters! No configuration"
            com.business.common_module.utilities.LogUtility.d(r8, r0)     // Catch:{ all -> 0x00ca }
        L_0x00c8:
            monitor-exit(r7)
            return
        L_0x00ca:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common_module.zxingutils.e.a(android.view.SurfaceHolder):void");
    }

    public final synchronized boolean a() {
        return this.f7412d != null;
    }

    public final synchronized void b() {
        if (this.f7412d != null) {
            this.f7412d.release();
            this.f7412d = null;
            this.f7414f = null;
            this.f7415g = null;
        }
    }

    public final synchronized void c() {
        Camera camera = this.f7412d;
        if (camera != null && !this.f7417i) {
            camera.startPreview();
            this.f7417i = true;
            this.f7413e = new b(this.f7410b, this.f7412d);
        }
    }

    public final synchronized void d() {
        if (this.f7413e != null) {
            this.f7413e.b();
            this.f7413e = null;
        }
        if (this.f7412d != null && this.f7417i) {
            this.f7412d.stopPreview();
            this.m.a((Handler) null, 0);
            this.f7417i = false;
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
            android.hardware.Camera r0 = r4.f7412d     // Catch:{ all -> 0x004e }
            r1 = 0
            if (r0 == 0) goto L_0x0025
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getFlashMode()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0025
            java.lang.String r2 = "on"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x004e }
            if (r2 != 0) goto L_0x0023
            java.lang.String r2 = "torch"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0025
        L_0x0023:
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r5 == r0) goto L_0x004c
            android.hardware.Camera r0 = r4.f7412d     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x004c
            com.business.common_module.zxingutils.b r0 = r4.f7413e     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0035
            com.business.common_module.zxingutils.b r0 = r4.f7413e     // Catch:{ all -> 0x004e }
            r0.b()     // Catch:{ all -> 0x004e }
        L_0x0035:
            com.business.common_module.zxingutils.c r0 = r4.f7411c     // Catch:{ all -> 0x004e }
            android.hardware.Camera r2 = r4.f7412d     // Catch:{ all -> 0x004e }
            android.hardware.Camera$Parameters r3 = r2.getParameters()     // Catch:{ all -> 0x004e }
            r0.a(r3, r5, r1)     // Catch:{ all -> 0x004e }
            r2.setParameters(r3)     // Catch:{ all -> 0x004e }
            com.business.common_module.zxingutils.b r5 = r4.f7413e     // Catch:{ all -> 0x004e }
            if (r5 == 0) goto L_0x004c
            com.business.common_module.zxingutils.b r5 = r4.f7413e     // Catch:{ all -> 0x004e }
            r5.a()     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r4)
            return
        L_0x004e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common_module.zxingutils.e.a(boolean):void");
    }

    public final synchronized void a(Handler handler, int i2) {
        Camera camera = this.f7412d;
        if (camera != null && this.f7417i) {
            this.m.a(handler, i2);
            camera.setOneShotPreviewCallback(this.m);
        }
    }

    public final synchronized Rect e() {
        if (this.f7414f == null) {
            if (this.f7412d == null) {
                return null;
            }
            Point point = this.f7411c.f7406b;
            if (point == null) {
                return null;
            }
            int i2 = (point.x * 5) / 8;
            if (i2 < 240) {
                i2 = 240;
            } else if (i2 > 1200) {
                i2 = ViewFinder.MAX_FRAME_WIDTH;
            }
            int i3 = (point.x - i2) / 2;
            int i4 = (point.y - i2) / 2;
            this.f7414f = new Rect(i3, i4, i3 + i2, i2 + i4);
            String str = f7409a;
            LogUtility.d(str, "Calculated framing rect: " + this.f7414f);
        }
        return this.f7414f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Rect f() {
        /*
            r6 = this;
            monitor-enter(r6)
            android.graphics.Rect r0 = r6.f7415g     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0057
            android.graphics.Rect r0 = r6.e()     // Catch:{ all -> 0x005b }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)
            return r1
        L_0x000e:
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x005b }
            r2.<init>(r0)     // Catch:{ all -> 0x005b }
            com.business.common_module.zxingutils.c r0 = r6.f7411c     // Catch:{ all -> 0x005b }
            android.graphics.Point r0 = r0.f7407c     // Catch:{ all -> 0x005b }
            com.business.common_module.zxingutils.c r3 = r6.f7411c     // Catch:{ all -> 0x005b }
            android.graphics.Point r3 = r3.f7406b     // Catch:{ all -> 0x005b }
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
            r6.f7415g = r2     // Catch:{ all -> 0x005b }
            goto L_0x0057
        L_0x0055:
            monitor-exit(r6)
            return r1
        L_0x0057:
            android.graphics.Rect r0 = r6.f7415g     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return r0
        L_0x005b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common_module.zxingutils.e.f():android.graphics.Rect");
    }

    private synchronized void a(int i2, int i3) {
        if (this.f7416h) {
            Point point = this.f7411c.f7406b;
            if (i2 > point.x) {
                i2 = point.x;
            }
            if (i3 > point.y) {
                i3 = point.y;
            }
            int i4 = (point.x - i2) / 2;
            int i5 = (point.y - i3) / 2;
            this.f7414f = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = f7409a;
            LogUtility.d(str, "Calculated manual framing rect: " + this.f7414f);
            this.f7415g = null;
            return;
        }
        this.k = i2;
        this.l = i3;
    }
}
