package net.one97.paytm.upgradeKyc.camera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.WindowManager;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.upgradeKyc.helper.b;

public final class a {
    @Deprecated
    public static final C1298a l = new C1298a((byte) 0);
    private static final SparseIntArray y;
    /* access modifiers changed from: private */
    public static final Comparator<Size> z = b.f65649a;

    /* renamed from: a  reason: collision with root package name */
    kotlin.g.a.b<? super Bitmap, x> f65640a = g.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    int f65641b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f65642c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public CameraCaptureSession f65643d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public CaptureRequest.Builder f65644e;

    /* renamed from: f  reason: collision with root package name */
    b.a f65645f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public int f65646g;

    /* renamed from: h  reason: collision with root package name */
    boolean f65647h;

    /* renamed from: i  reason: collision with root package name */
    int f65648i;
    /* access modifiers changed from: package-private */
    public final c j;
    final AutoFitTextureView k;
    private final CameraManager m;
    private Size n;
    private String o;
    private HandlerThread p;
    /* access modifiers changed from: private */
    public CameraDevice q;
    /* access modifiers changed from: private */
    public CaptureRequest r;
    private Surface s;
    private boolean t;
    private int u;
    private final h v;
    private final d w;
    private final Activity x;

    static final class g extends l implements kotlin.g.a.b<Bitmap, x> {
        public static final g INSTANCE = new g();

        g() {
            super(1);
        }

        public final void invoke(Bitmap bitmap) {
            k.c(bitmap, "it");
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Bitmap) obj);
            return x.f47997a;
        }
    }

    public a(Activity activity, AutoFitTextureView autoFitTextureView) {
        k.c(activity, "activity");
        k.c(autoFitTextureView, "textureView");
        this.x = activity;
        this.k = autoFitTextureView;
        Object systemService = this.k.getContext().getSystemService("camera");
        if (systemService != null) {
            this.m = (CameraManager) systemService;
            this.o = H5BridgeContext.INVALID_ID;
            this.f65645f = b.a.AUTO;
            this.t = true;
            this.j = new c(this);
            this.v = new h(this);
            this.w = new d(this);
            return;
        }
        throw new u("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    public static final class c extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65650a;

        c(a aVar) {
            this.f65650a = aVar;
        }

        private final void a(CaptureResult captureResult) {
            int i2 = this.f65650a.f65646g;
            if (i2 == 0) {
                return;
            }
            if (i2 == 1) {
                this.f65650a.f65648i++;
                captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (!this.f65650a.f65647h) {
                    a aVar = this.f65650a;
                    aVar.f65647h = true;
                    a.j(aVar);
                }
            } else if (i2 == 2) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num == null || num.intValue() == 5 || num.intValue() == 4) {
                    a aVar2 = this.f65650a;
                    C1298a unused = a.l;
                    aVar2.f65646g = 3;
                }
            } else if (i2 == 3) {
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num2 == null || num2.intValue() != 5) {
                    a aVar3 = this.f65650a;
                    C1298a unused2 = a.l;
                    aVar3.f65646g = 4;
                    a.j(this.f65650a);
                }
            }
        }

        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            k.c(cameraCaptureSession, "session");
            k.c(captureRequest, "request");
            k.c(captureResult, "partialResult");
            a(captureResult);
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            k.c(cameraCaptureSession, "session");
            k.c(captureRequest, "request");
            k.c(totalCaptureResult, "result");
            a(totalCaptureResult);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.camera.a$a  reason: collision with other inner class name */
    static final class C1298a {
        private C1298a() {
        }

        public /* synthetic */ C1298a(byte b2) {
            this();
        }

        /* access modifiers changed from: private */
        public static Size b(Size[] sizeArr, int i2, int i3, int i4, int i5, Size size) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int width = size.getWidth();
            int height = size.getHeight();
            for (Size size2 : sizeArr) {
                if (size2.getWidth() <= i4 && size2.getHeight() <= i5 && size2.getHeight() == (size2.getWidth() * height) / width) {
                    if (size2.getWidth() < i2 || size2.getHeight() < i3) {
                        arrayList2.add(size2);
                    } else {
                        arrayList.add(size2);
                    }
                }
            }
            Collection collection = arrayList;
            if (!collection.isEmpty()) {
                Object min = Collections.min(collection, a.z);
                k.a(min, "Collections.min(bigEnoug…sByArea\n                )");
                return (Size) min;
            }
            Collection collection2 = arrayList2;
            if (!(!collection2.isEmpty())) {
                return sizeArr[0];
            }
            Object max = Collections.max(collection2, a.z);
            k.a(max, "Collections.max(notBigEn…sByArea\n                )");
            return (Size) max;
        }
    }

    static final class b<T> implements Comparator<Size> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f65649a = new b();

        b() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            k.a((Object) size, "lhs");
            k.a((Object) size2, "rhs");
            return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.append(0, 90);
        y.append(1, 0);
        y.append(2, 270);
        y.append(3, AppConstants.READ_TIME_OUT);
    }

    public static final class h implements TextureView.SurfaceTextureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65654a;

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        h(a aVar) {
            this.f65654a = aVar;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f65654a.c(i2, i3);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f65654a.a(i2, i3);
        }
    }

    public static final class d extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65651a;

        public final void onError(CameraDevice cameraDevice, int i2) {
            k.c(cameraDevice, "camera");
        }

        d(a aVar) {
            this.f65651a = aVar;
        }

        public final void onOpened(CameraDevice cameraDevice) {
            k.c(cameraDevice, "camera");
            this.f65651a.q = cameraDevice;
            a.k(this.f65651a);
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            k.c(cameraDevice, "camera");
            cameraDevice.close();
            this.f65651a.q = null;
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, int i3) {
        if (androidx.core.content.b.a(this.k.getContext(), "android.permission.CAMERA") == 0) {
            b(i2, i3);
            c(i2, i3);
            this.m.openCamera(this.o, this.w, this.f65642c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r2 = r1.getOutputSizes(net.one97.paytm.upi.util.UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        if (r13.u != 180) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(int r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "activity.windowManager"
            android.hardware.camera2.CameraManager r1 = r13.m     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String[] r1 = r1.getCameraIdList()     // Catch:{ CameraAccessException -> 0x0163 }
            int r2 = r1.length     // Catch:{ CameraAccessException -> 0x0163 }
            r3 = 0
            r4 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x0167
            r5 = r1[r4]     // Catch:{ CameraAccessException -> 0x0163 }
            android.hardware.camera2.CameraManager r6 = r13.m     // Catch:{ CameraAccessException -> 0x0163 }
            android.hardware.camera2.CameraCharacteristics r6 = r6.getCameraCharacteristics(r5)     // Catch:{ CameraAccessException -> 0x0163 }
            android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ CameraAccessException -> 0x0163 }
            int r8 = r13.f65641b     // Catch:{ CameraAccessException -> 0x0163 }
            if (r7 != 0) goto L_0x0023
            goto L_0x015f
        L_0x0023:
            int r7 = r7.intValue()     // Catch:{ CameraAccessException -> 0x0163 }
            if (r7 != r8) goto L_0x015f
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Object r1 = r6.get(r1)     // Catch:{ CameraAccessException -> 0x0163 }
            android.hardware.camera2.params.StreamConfigurationMap r1 = (android.hardware.camera2.params.StreamConfigurationMap) r1     // Catch:{ CameraAccessException -> 0x0163 }
            if (r1 == 0) goto L_0x0040
            r2 = 256(0x100, float:3.59E-43)
            android.util.Size[] r2 = r1.getOutputSizes(r2)     // Catch:{ CameraAccessException -> 0x0163 }
            if (r2 == 0) goto L_0x0040
            java.util.List r2 = kotlin.a.f.b(r2)     // Catch:{ CameraAccessException -> 0x0163 }
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ CameraAccessException -> 0x0163 }
            java.util.Comparator<android.util.Size> r4 = z     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Object r2 = java.util.Collections.max(r2, r4)     // Catch:{ CameraAccessException -> 0x0163 }
            r12 = r2
            android.util.Size r12 = (android.util.Size) r12     // Catch:{ CameraAccessException -> 0x0163 }
            android.app.Activity r2 = r13.x     // Catch:{ CameraAccessException -> 0x0163 }
            android.view.WindowManager r2 = r2.getWindowManager()     // Catch:{ CameraAccessException -> 0x0163 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ CameraAccessException -> 0x0163 }
            android.view.Display r2 = r2.getDefaultDisplay()     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r4 = "activity.windowManager.defaultDisplay"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ CameraAccessException -> 0x0163 }
            int r2 = r2.getRotation()     // Catch:{ CameraAccessException -> 0x0163 }
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ CameraAccessException -> 0x0163 }
            if (r4 == 0) goto L_0x0071
            int r4 = r4.intValue()     // Catch:{ CameraAccessException -> 0x0163 }
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r13.u = r4     // Catch:{ CameraAccessException -> 0x0163 }
            r4 = 2
            if (r2 == 0) goto L_0x0099
            r7 = 1
            if (r2 == r7) goto L_0x0099
            if (r2 == r4) goto L_0x008c
            r8 = 3
            if (r2 == r8) goto L_0x0080
            goto L_0x0099
        L_0x0080:
            int r2 = r13.u     // Catch:{ CameraAccessException -> 0x0163 }
            if (r2 == 0) goto L_0x008a
            int r2 = r13.u     // Catch:{ CameraAccessException -> 0x0163 }
            r8 = 180(0xb4, float:2.52E-43)
            if (r2 != r8) goto L_0x0099
        L_0x008a:
            r3 = 1
            goto L_0x0099
        L_0x008c:
            int r2 = r13.u     // Catch:{ CameraAccessException -> 0x0163 }
            r8 = 90
            if (r2 == r8) goto L_0x008a
            int r2 = r13.u     // Catch:{ CameraAccessException -> 0x0163 }
            r8 = 270(0x10e, float:3.78E-43)
            if (r2 != r8) goto L_0x0099
            goto L_0x008a
        L_0x0099:
            android.graphics.Point r2 = new android.graphics.Point     // Catch:{ CameraAccessException -> 0x0163 }
            r2.<init>()     // Catch:{ CameraAccessException -> 0x0163 }
            android.app.Activity r7 = r13.x     // Catch:{ CameraAccessException -> 0x0163 }
            android.view.WindowManager r7 = r7.getWindowManager()     // Catch:{ CameraAccessException -> 0x0163 }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)     // Catch:{ CameraAccessException -> 0x0163 }
            android.view.Display r0 = r7.getDefaultDisplay()     // Catch:{ CameraAccessException -> 0x0163 }
            r0.getSize(r2)     // Catch:{ CameraAccessException -> 0x0163 }
            int r0 = r2.x     // Catch:{ CameraAccessException -> 0x0163 }
            int r7 = r2.y     // Catch:{ CameraAccessException -> 0x0163 }
            if (r3 == 0) goto L_0x00bb
            int r0 = r2.y     // Catch:{ CameraAccessException -> 0x0163 }
            int r7 = r2.x     // Catch:{ CameraAccessException -> 0x0163 }
            r9 = r14
            r8 = r15
            goto L_0x00bd
        L_0x00bb:
            r8 = r14
            r9 = r15
        L_0x00bd:
            r14 = 1920(0x780, float:2.69E-42)
            if (r0 <= r14) goto L_0x00c4
            r10 = 1920(0x780, float:2.69E-42)
            goto L_0x00c5
        L_0x00c4:
            r10 = r0
        L_0x00c5:
            r14 = 1080(0x438, float:1.513E-42)
            if (r7 <= r14) goto L_0x00cc
            r11 = 1080(0x438, float:1.513E-42)
            goto L_0x00cd
        L_0x00cc:
            r11 = r7
        L_0x00cd:
            if (r1 != 0) goto L_0x00d2
            kotlin.g.b.k.a()     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x00d2:
            java.lang.Class<android.graphics.SurfaceTexture> r14 = android.graphics.SurfaceTexture.class
            android.util.Size[] r7 = r1.getOutputSizes(r14)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r14 = "streamConfigurationMap!!…rfaceTexture::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r14 = "largest"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)     // Catch:{ CameraAccessException -> 0x0163 }
            android.util.Size r14 = net.one97.paytm.upgradeKyc.camera.a.C1298a.b(r7, r8, r9, r10, r11, r12)     // Catch:{ CameraAccessException -> 0x0163 }
            r13.n = r14     // Catch:{ CameraAccessException -> 0x0163 }
            android.app.Activity r14 = r13.x     // Catch:{ CameraAccessException -> 0x0163 }
            android.content.res.Resources r14 = r14.getResources()     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r15 = "activity.resources"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)     // Catch:{ CameraAccessException -> 0x0163 }
            android.content.res.Configuration r14 = r14.getConfiguration()     // Catch:{ CameraAccessException -> 0x0163 }
            int r14 = r14.orientation     // Catch:{ CameraAccessException -> 0x0163 }
            if (r14 != r4) goto L_0x0117
            net.one97.paytm.upgradeKyc.camera.AutoFitTextureView r14 = r13.k     // Catch:{ CameraAccessException -> 0x0163 }
            android.util.Size r15 = r13.n     // Catch:{ CameraAccessException -> 0x0163 }
            if (r15 != 0) goto L_0x0104
            kotlin.g.b.k.a()     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x0104:
            int r15 = r15.getWidth()     // Catch:{ CameraAccessException -> 0x0163 }
            android.util.Size r0 = r13.n     // Catch:{ CameraAccessException -> 0x0163 }
            if (r0 != 0) goto L_0x010f
            kotlin.g.b.k.a()     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x010f:
            int r0 = r0.getHeight()     // Catch:{ CameraAccessException -> 0x0163 }
            r14.setAspectRatio(r15, r0)     // Catch:{ CameraAccessException -> 0x0163 }
            goto L_0x0132
        L_0x0117:
            net.one97.paytm.upgradeKyc.camera.AutoFitTextureView r14 = r13.k     // Catch:{ CameraAccessException -> 0x0163 }
            android.util.Size r15 = r13.n     // Catch:{ CameraAccessException -> 0x0163 }
            if (r15 != 0) goto L_0x0120
            kotlin.g.b.k.a()     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x0120:
            int r15 = r15.getHeight()     // Catch:{ CameraAccessException -> 0x0163 }
            android.util.Size r0 = r13.n     // Catch:{ CameraAccessException -> 0x0163 }
            if (r0 != 0) goto L_0x012b
            kotlin.g.b.k.a()     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x012b:
            int r0 = r0.getWidth()     // Catch:{ CameraAccessException -> 0x0163 }
            r14.setAspectRatio(r15, r0)     // Catch:{ CameraAccessException -> 0x0163 }
        L_0x0132:
            android.hardware.camera2.CameraCharacteristics$Key r14 = android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Object r14 = r6.get(r14)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.Boolean r15 = java.lang.Boolean.FALSE     // Catch:{ CameraAccessException -> 0x0163 }
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r15)     // Catch:{ CameraAccessException -> 0x0163 }
            r13.t = r14     // Catch:{ CameraAccessException -> 0x0163 }
            java.io.PrintStream r14 = java.lang.System.out     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r0 = "isFlashSuporteddd ="
            r15.<init>(r0)     // Catch:{ CameraAccessException -> 0x0163 }
            boolean r0 = r13.t     // Catch:{ CameraAccessException -> 0x0163 }
            r15.append(r0)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r15 = r15.toString()     // Catch:{ CameraAccessException -> 0x0163 }
            r14.println(r15)     // Catch:{ CameraAccessException -> 0x0163 }
            java.lang.String r14 = "cameraId"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r14)     // Catch:{ CameraAccessException -> 0x0163 }
            r13.o = r5     // Catch:{ CameraAccessException -> 0x0163 }
            return
        L_0x015f:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0163:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.camera.a.b(int, int):void");
    }

    /* access modifiers changed from: private */
    public final void c(int i2, int i3) {
        WindowManager windowManager = this.x.getWindowManager();
        k.a((Object) windowManager, "activity.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        k.a((Object) defaultDisplay, "activity.windowManager.defaultDisplay");
        int rotation = defaultDisplay.getRotation();
        Matrix matrix = new Matrix();
        float f2 = (float) i2;
        float f3 = (float) i3;
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        Size size = this.n;
        if (size == null) {
            k.a();
        }
        float height = (float) size.getHeight();
        Size size2 = this.n;
        if (size2 == null) {
            k.a();
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, height, (float) size2.getWidth());
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        if (1 == rotation || 3 == rotation) {
            rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            Size size3 = this.n;
            if (size3 == null) {
                k.a();
            }
            float height2 = f3 / ((float) size3.getHeight());
            Size size4 = this.n;
            if (size4 == null) {
                k.a();
            }
            float max = Math.max(height2, f2 / ((float) size4.getWidth()));
            matrix.postScale(max, max, centerX, centerY);
            matrix.postRotate((float) ((rotation - 2) * 90), centerX, centerY);
        } else if (2 == rotation) {
            matrix.postRotate(180.0f, centerX, centerY);
        }
        this.k.setTransform(matrix);
    }

    public static final class f extends CameraCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65653a;

        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            k.c(cameraCaptureSession, "cameraCaptureSession");
        }

        f(a aVar) {
            this.f65653a = aVar;
        }

        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            k.c(cameraCaptureSession, "cameraCaptureSession");
            if (this.f65653a.q != null) {
                try {
                    this.f65653a.f65643d = cameraCaptureSession;
                    CaptureRequest.Builder c2 = this.f65653a.f65644e;
                    if (c2 == null) {
                        k.a();
                    }
                    c2.set(CaptureRequest.CONTROL_AF_MODE, 4);
                    a aVar = this.f65653a;
                    CaptureRequest.Builder c3 = this.f65653a.f65644e;
                    if (c3 == null) {
                        k.a();
                    }
                    aVar.r = c3.build();
                    CameraCaptureSession b2 = this.f65653a.f65643d;
                    if (b2 == null) {
                        k.a();
                    }
                    CaptureRequest d2 = this.f65653a.r;
                    if (d2 == null) {
                        k.a();
                    }
                    b2.setRepeatingRequest(d2, this.f65653a.j, this.f65653a.f65642c);
                    a aVar2 = this.f65653a;
                    CaptureRequest.Builder c4 = this.f65653a.f65644e;
                    if (c4 == null) {
                        k.a();
                    }
                    aVar2.a(c4, true);
                } catch (CameraAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CaptureRequest.Builder builder, boolean z2) {
        if (z2) {
            builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        int i2 = b.f65655a[this.f65645f.ordinal()];
        if (i2 == 1) {
            int i3 = Build.VERSION.SDK_INT;
            builder.set(CaptureRequest.FLASH_MODE, 2);
        } else if (i2 != 2) {
            builder.set(CaptureRequest.FLASH_MODE, 0);
        } else {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 2);
        }
    }

    public static final class e extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65652a;

        e(a aVar) {
            this.f65652a = aVar;
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            k.c(cameraCaptureSession, "session");
            k.c(captureRequest, "request");
            k.c(totalCaptureResult, "result");
            a.g(this.f65652a);
            a.h(this.f65652a);
        }
    }

    public final void a() {
        this.p = new HandlerThread("camera_background_thread");
        HandlerThread handlerThread = this.p;
        if (handlerThread == null) {
            k.a();
        }
        handlerThread.start();
        HandlerThread handlerThread2 = this.p;
        if (handlerThread2 == null) {
            k.a();
        }
        this.f65642c = new Handler(handlerThread2.getLooper());
        if (this.k.isAvailable()) {
            a(this.k.getWidth(), this.k.getHeight());
        } else {
            this.k.setSurfaceTextureListener(this.v);
        }
    }

    public final void b() {
        CameraCaptureSession cameraCaptureSession = this.f65643d;
        if (cameraCaptureSession != null) {
            if (cameraCaptureSession == null) {
                k.a();
            }
            cameraCaptureSession.close();
            this.f65643d = null;
        }
        CameraDevice cameraDevice = this.q;
        if (cameraDevice != null) {
            if (cameraDevice == null) {
                k.a();
            }
            cameraDevice.close();
            this.q = null;
        }
        if (this.f65642c != null) {
            HandlerThread handlerThread = this.p;
            if (handlerThread == null) {
                k.a();
            }
            handlerThread.quitSafely();
            this.p = null;
            this.f65642c = null;
        }
    }

    public static final /* synthetic */ void g(a aVar) {
        if (aVar.k.isAvailable()) {
            kotlin.g.a.b<? super Bitmap, x> bVar = aVar.f65640a;
            Bitmap bitmap = aVar.k.getBitmap();
            k.a((Object) bitmap, "textureView.bitmap");
            bVar.invoke(bitmap);
        }
    }

    public static final /* synthetic */ void h(a aVar) {
        try {
            CaptureRequest.Builder builder = aVar.f65644e;
            if (builder == null) {
                k.a();
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            CaptureRequest.Builder builder2 = aVar.f65644e;
            if (builder2 == null) {
                k.a();
            }
            aVar.a(builder2, false);
            CameraCaptureSession cameraCaptureSession = aVar.f65643d;
            if (cameraCaptureSession == null) {
                k.a();
            }
            CaptureRequest.Builder builder3 = aVar.f65644e;
            if (builder3 == null) {
                k.a();
            }
            cameraCaptureSession.capture(builder3.build(), aVar.j, aVar.f65642c);
            aVar.f65646g = 0;
            CameraCaptureSession cameraCaptureSession2 = aVar.f65643d;
            if (cameraCaptureSession2 == null) {
                k.a();
            }
            CaptureRequest captureRequest = aVar.r;
            if (captureRequest == null) {
                k.a();
            }
            cameraCaptureSession2.setRepeatingRequest(captureRequest, aVar.j, aVar.f65642c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final /* synthetic */ void j(a aVar) {
        try {
            CameraDevice cameraDevice = aVar.q;
            if (cameraDevice == null) {
                k.a();
            }
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(2);
            Surface surface = aVar.s;
            if (surface == null) {
                k.a();
            }
            createCaptureRequest.addTarget(surface);
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
            k.a((Object) createCaptureRequest, "captureBuilder");
            aVar.a(createCaptureRequest, true);
            WindowManager windowManager = aVar.x.getWindowManager();
            k.a((Object) windowManager, "activity.windowManager");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            k.a((Object) defaultDisplay, "activity.windowManager.defaultDisplay");
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(((y.get(defaultDisplay.getRotation()) + aVar.u) + 270) % 360));
            CameraCaptureSession cameraCaptureSession = aVar.f65643d;
            if (cameraCaptureSession == null) {
                k.a();
            }
            cameraCaptureSession.stopRepeating();
            CameraCaptureSession cameraCaptureSession2 = aVar.f65643d;
            if (cameraCaptureSession2 == null) {
                k.a();
            }
            cameraCaptureSession2.abortCaptures();
            CameraCaptureSession cameraCaptureSession3 = aVar.f65643d;
            if (cameraCaptureSession3 == null) {
                k.a();
            }
            cameraCaptureSession3.capture(createCaptureRequest.build(), new e(aVar), (Handler) null);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static final /* synthetic */ void k(a aVar) {
        try {
            SurfaceTexture surfaceTexture = aVar.k.getSurfaceTexture();
            Size size = aVar.n;
            if (size == null) {
                k.a();
            }
            int width = size.getWidth();
            Size size2 = aVar.n;
            if (size2 == null) {
                k.a();
            }
            surfaceTexture.setDefaultBufferSize(width, size2.getHeight());
            if (aVar.s == null) {
                aVar.s = new Surface(surfaceTexture);
            }
            Surface surface = aVar.s;
            CameraDevice cameraDevice = aVar.q;
            if (cameraDevice == null) {
                k.a();
            }
            aVar.f65644e = cameraDevice.createCaptureRequest(1);
            CaptureRequest.Builder builder = aVar.f65644e;
            if (builder == null) {
                k.a();
            }
            if (surface == null) {
                k.a();
            }
            builder.addTarget(surface);
            CameraDevice cameraDevice2 = aVar.q;
            if (cameraDevice2 == null) {
                k.a();
            }
            cameraDevice2.createCaptureSession(Collections.singletonList(surface), new f(aVar), aVar.f65642c);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }
}
