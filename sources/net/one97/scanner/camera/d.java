package net.one97.scanner.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.IOException;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    float f72465a;

    /* renamed from: b  reason: collision with root package name */
    public c f72466b;

    /* renamed from: c  reason: collision with root package name */
    final Object f72467c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public Camera f72468d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public int f72469e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public com.google.android.gms.common.images.a f72470f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f72471g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f72472h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f72473i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public Thread n;
    /* access modifiers changed from: private */
    public c o;
    /* access modifiers changed from: private */
    public Map<byte[], ByteBuffer> p;

    /* synthetic */ d(byte b2) {
        this();
    }

    public static float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.google.android.gms.vision.a<?>> f72474a;

        /* renamed from: b  reason: collision with root package name */
        private d f72475b = new d((byte) 0);

        public a(Context context, List<com.google.android.gms.vision.a<?>> list) {
            if (context != null) {
                this.f72474a = list;
                Context unused = this.f72475b.f72471g = context;
                return;
            }
            throw new IllegalArgumentException("No context supplied.");
        }

        public final a a() {
            float unused = this.f72475b.f72473i = 15.0f;
            return this;
        }

        public final a a(String str) {
            String unused = this.f72475b.l = str;
            return this;
        }

        public final a b(String str) {
            String unused = this.f72475b.m = str;
            return this;
        }

        public final a a(int i2, int i3) {
            if (i2 <= 0) {
                i2 = TarConstants.EOF_BLOCK;
            }
            if (i3 <= 0) {
                i3 = 1280;
            }
            if (i2 <= 0 || i2 > 1000000 || i3 <= 0 || i3 > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + i2 + "x" + i3);
            }
            int unused = this.f72475b.j = i2;
            int unused2 = this.f72475b.k = i3;
            return this;
        }

        public final a b() {
            int unused = this.f72475b.f72469e = 0;
            return this;
        }

        public final d c() {
            d dVar = this.f72475b;
            dVar.getClass();
            c unused = dVar.o = new c(this.f72474a);
            return this.f72475b;
        }
    }

    public final void a() {
        synchronized (this.f72467c) {
            b();
            this.o.a();
        }
    }

    public final d a(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.f72467c) {
            if (this.f72468d != null) {
                return this;
            }
            try {
                this.f72468d = c();
            } catch (Exception e2) {
                this.f72468d = null;
                Toast.makeText(this.f72471g, "Can't create Camera", 0).show();
                if (this.f72466b != null) {
                    this.f72466b.a();
                }
                e2.printStackTrace();
            }
            try {
                if (this.f72468d != null) {
                    this.f72468d.setPreviewDisplay(surfaceHolder);
                    this.f72468d.startPreview();
                    this.n = new Thread(this.o);
                    this.o.a(true);
                    this.n.start();
                }
            } catch (Exception e3) {
                Toast.makeText(this.f72471g, "Can't create Camera", 0).show();
                if (this.f72466b != null) {
                    this.f72466b.a();
                }
                e3.printStackTrace();
            }
        }
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f72467c
            monitor-enter(r0)
            net.one97.scanner.camera.d$c r1 = r5.o     // Catch:{ all -> 0x004e }
            r2 = 0
            r1.a(r2)     // Catch:{ all -> 0x004e }
            java.lang.Thread r1 = r5.n     // Catch:{ all -> 0x004e }
            r2 = 0
            if (r1 == 0) goto L_0x0015
            java.lang.Thread r1 = r5.n     // Catch:{ InterruptedException -> 0x0013 }
            r1.join()     // Catch:{ InterruptedException -> 0x0013 }
        L_0x0013:
            r5.n = r2     // Catch:{ all -> 0x004e }
        L_0x0015:
            java.util.Map<byte[], java.nio.ByteBuffer> r1 = r5.p     // Catch:{ all -> 0x004e }
            r1.clear()     // Catch:{ all -> 0x004e }
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004c
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ all -> 0x004e }
            r1.stopPreview()     // Catch:{ all -> 0x004e }
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ all -> 0x004e }
            r1.setPreviewCallbackWithBuffer(r2)     // Catch:{ all -> 0x004e }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x003a }
            r3 = 11
            if (r1 < r3) goto L_0x0034
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ Exception -> 0x003a }
            r1.setPreviewTexture(r2)     // Catch:{ Exception -> 0x003a }
            goto L_0x0045
        L_0x0034:
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ Exception -> 0x003a }
            r1.setPreviewDisplay(r2)     // Catch:{ Exception -> 0x003a }
            goto L_0x0045
        L_0x003a:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "Failed to clear camera preview: "
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            r3.append(r1)     // Catch:{ all -> 0x004e }
        L_0x0045:
            android.hardware.Camera r1 = r5.f72468d     // Catch:{ all -> 0x004e }
            r1.release()     // Catch:{ all -> 0x004e }
            r5.f72468d = r2     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.scanner.camera.d.b():void");
    }

    private d() {
        this.f72465a = 0.0f;
        this.f72467c = new Object();
        this.f72469e = 0;
        this.f72473i = 30.0f;
        this.j = TarConstants.EOF_BLOCK;
        this.k = 768;
        this.l = null;
        this.m = null;
        this.p = new HashMap();
    }

    private static Camera a(int i2) {
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

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera c() throws java.lang.Exception {
        /*
            r8 = this;
            java.lang.String r0 = "Can't create Camera"
            int r1 = r8.f72469e
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x000b:
            int r5 = android.hardware.Camera.getNumberOfCameras()
            r6 = -1
            if (r4 >= r5) goto L_0x001d
            android.hardware.Camera.getCameraInfo(r4, r2)
            int r5 = r2.facing
            if (r5 != r1) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x001d:
            r4 = -1
        L_0x001e:
            if (r4 == r6) goto L_0x0174
            r1 = 0
            android.hardware.Camera r2 = a((int) r4)     // Catch:{ Exception -> 0x0163 }
            if (r2 != 0) goto L_0x0028
            return r1
        L_0x0028:
            int r1 = r8.j
            int r5 = r8.k
            net.one97.scanner.camera.d$d r1 = a(r2, r1, r5)
            if (r1 == 0) goto L_0x015b
            com.google.android.gms.common.images.a r5 = r1.f72487b
            com.google.android.gms.common.images.a r1 = r1.f72486a
            r8.f72470f = r1
            float r1 = r8.f72473i
            int[] r1 = a((android.hardware.Camera) r2, (float) r1)
            if (r1 == 0) goto L_0x0153
            android.hardware.Camera$Parameters r6 = r2.getParameters()
            if (r5 == 0) goto L_0x004d
            int r7 = r5.f8720a
            int r5 = r5.f8721b
            r6.setPictureSize(r7, r5)
        L_0x004d:
            com.google.android.gms.common.images.a r5 = r8.f72470f
            int r5 = r5.f8720a
            com.google.android.gms.common.images.a r7 = r8.f72470f
            int r7 = r7.f8721b
            r6.setPreviewSize(r5, r7)
            r5 = r1[r3]
            r7 = 1
            r1 = r1[r7]
            r6.setPreviewFpsRange(r5, r1)
            r1 = 17
            r6.setPreviewFormat(r1)
            android.content.Context r1 = r8.f72471g
            java.lang.String r5 = "window"
            java.lang.Object r1 = r1.getSystemService(r5)
            android.view.WindowManager r1 = (android.view.WindowManager) r1
            android.view.Display r1 = r1.getDefaultDisplay()
            int r1 = r1.getRotation()
            if (r1 == 0) goto L_0x0081
            if (r1 == r7) goto L_0x0089
            r5 = 2
            if (r1 == r5) goto L_0x0086
            r5 = 3
            if (r1 == r5) goto L_0x0083
        L_0x0081:
            r1 = 0
            goto L_0x008b
        L_0x0083:
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x008b
        L_0x0086:
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x008b
        L_0x0089:
            r1 = 90
        L_0x008b:
            android.hardware.Camera$CameraInfo r5 = new android.hardware.Camera$CameraInfo
            r5.<init>()
            android.hardware.Camera.getCameraInfo(r4, r5)
            int r4 = r5.facing
            if (r4 != r7) goto L_0x00a1
            int r4 = r5.orientation
            int r4 = r4 + r1
            int r4 = r4 % 360
            int r1 = 360 - r4
            int r1 = r1 % 360
            goto L_0x00a9
        L_0x00a1:
            int r4 = r5.orientation
            int r4 = r4 - r1
            int r4 = r4 + 360
            int r4 = r4 % 360
            r1 = r4
        L_0x00a9:
            int r5 = r4 / 90
            r8.f72472h = r5
            r2.setDisplayOrientation(r1)
            r6.setRotation(r4)
            java.lang.String r1 = r8.l
            java.lang.String r4 = " is not supported on this device."
            if (r1 == 0) goto L_0x00da
            java.util.List r1 = r6.getSupportedFocusModes()
            java.lang.String r5 = r8.l
            boolean r1 = r1.contains(r5)
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = r8.l
            r6.setFocusMode(r1)
            goto L_0x00da
        L_0x00cb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "Camera focus mode: "
            r1.<init>(r5)
            java.lang.String r5 = r8.l
            r1.append(r5)
            r1.append(r4)
        L_0x00da:
            java.lang.String r1 = r6.getFocusMode()
            r8.l = r1
            java.lang.String r1 = r8.m
            if (r1 == 0) goto L_0x010b
            java.util.List r1 = r6.getSupportedFlashModes()
            if (r1 == 0) goto L_0x010b
            java.util.List r1 = r6.getSupportedFlashModes()
            java.lang.String r5 = r8.m
            boolean r1 = r1.contains(r5)
            if (r1 == 0) goto L_0x00fc
            java.lang.String r1 = r8.m
            r6.setFlashMode(r1)
            goto L_0x010b
        L_0x00fc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "Camera flash mode: "
            r1.<init>(r5)
            java.lang.String r5 = r8.m
            r1.append(r5)
            r1.append(r4)
        L_0x010b:
            java.lang.String r1 = r6.getFlashMode()
            r8.m = r1
            r2.setParameters(r6)
            net.one97.scanner.camera.d$b r1 = new net.one97.scanner.camera.d$b
            r1.<init>(r8, r3)
            r2.setPreviewCallbackWithBuffer(r1)
            com.google.android.gms.common.images.a r1 = r8.f72470f     // Catch:{ OutOfMemoryError -> 0x0141 }
            byte[] r1 = r8.a((com.google.android.gms.common.images.a) r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            r2.addCallbackBuffer(r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            com.google.android.gms.common.images.a r1 = r8.f72470f     // Catch:{ OutOfMemoryError -> 0x0141 }
            byte[] r1 = r8.a((com.google.android.gms.common.images.a) r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            r2.addCallbackBuffer(r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            com.google.android.gms.common.images.a r1 = r8.f72470f     // Catch:{ OutOfMemoryError -> 0x0141 }
            byte[] r1 = r8.a((com.google.android.gms.common.images.a) r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            r2.addCallbackBuffer(r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            com.google.android.gms.common.images.a r1 = r8.f72470f     // Catch:{ OutOfMemoryError -> 0x0141 }
            byte[] r1 = r8.a((com.google.android.gms.common.images.a) r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            r2.addCallbackBuffer(r1)     // Catch:{ OutOfMemoryError -> 0x0141 }
            goto L_0x0152
        L_0x0141:
            android.content.Context r1 = r8.f72471g
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)
            r0.show()
            net.one97.scanner.camera.c r0 = r8.f72466b
            if (r0 == 0) goto L_0x0152
            r0.a()
        L_0x0152:
            return r2
        L_0x0153:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not find suitable preview frames per second range."
            r0.<init>(r1)
            throw r0
        L_0x015b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not find suitable preview size."
            r0.<init>(r1)
            throw r0
        L_0x0163:
            android.content.Context r2 = r8.f72471g
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r0, r3)
            r0.show()
            net.one97.scanner.camera.c r0 = r8.f72466b
            if (r0 == 0) goto L_0x0173
            r0.a()
        L_0x0173:
            return r1
        L_0x0174:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not find requested camera."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.scanner.camera.d.c():android.hardware.Camera");
    }

    /* renamed from: net.one97.scanner.camera.d$d  reason: collision with other inner class name */
    static class C1467d {

        /* renamed from: a  reason: collision with root package name */
        com.google.android.gms.common.images.a f72486a;

        /* renamed from: b  reason: collision with root package name */
        com.google.android.gms.common.images.a f72487b;

        public C1467d(Camera.Size size, Camera.Size size2) {
            this.f72486a = new com.google.android.gms.common.images.a(size.width, size.height);
            if (size2 != null) {
                this.f72487b = new com.google.android.gms.common.images.a(size2.width, size2.height);
            }
        }
    }

    private static int[] a(Camera camera, float f2) {
        int i2 = (int) (f2 * 1000.0f);
        int[] iArr = null;
        int i3 = Integer.MAX_VALUE;
        for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i2 - next[0]) + Math.abs(i2 - next[1]);
            if (abs < i3) {
                iArr = next;
                i3 = abs;
            }
        }
        return iArr;
    }

    private byte[] a(com.google.android.gms.common.images.a aVar) {
        byte[] bArr = new byte[(((int) Math.ceil(((double) ((long) ((aVar.f8721b * aVar.f8720a) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.p.put(bArr, wrap);
        return bArr;
    }

    class b implements Camera.PreviewCallback {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            c d2 = d.this.o;
            synchronized (d2.f72479b) {
                if (d2.f72482e != null) {
                    camera.addCallbackBuffer(d2.f72482e.array());
                    d2.f72482e = null;
                }
                if (d.this.p.containsKey(bArr)) {
                    d2.f72480c = SystemClock.elapsedRealtime() - d2.f72478a;
                    d2.f72481d++;
                    d2.f72482e = (ByteBuffer) d.this.p.get(bArr);
                    d2.f72479b.notifyAll();
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ boolean f72477f = (!d.class.desiredAssertionStatus());

        /* renamed from: a  reason: collision with root package name */
        long f72478a = SystemClock.elapsedRealtime();

        /* renamed from: b  reason: collision with root package name */
        final Object f72479b = new Object();

        /* renamed from: c  reason: collision with root package name */
        long f72480c;

        /* renamed from: d  reason: collision with root package name */
        int f72481d = 0;

        /* renamed from: e  reason: collision with root package name */
        ByteBuffer f72482e;

        /* renamed from: h  reason: collision with root package name */
        private List<com.google.android.gms.vision.a<?>> f72484h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f72485i = true;

        c(List<com.google.android.gms.vision.a<?>> list) {
            this.f72484h = list;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (f72477f || d.this.n.getState() == Thread.State.TERMINATED) {
                for (com.google.android.gms.vision.a<?> a2 : this.f72484h) {
                    a2.a();
                }
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z) {
            synchronized (this.f72479b) {
                this.f72485i = z;
                this.f72479b.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|3|2) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = r6.f72484h.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
            if (r0.hasNext() == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
            r0.next().b(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
            net.one97.scanner.camera.d.c(r6.f72483g).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
            net.one97.scanner.camera.d.c(r6.f72483g).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r0 = r6.f72479b
                monitor-enter(r0)
            L_0x0003:
                boolean r1 = r6.f72485i     // Catch:{ all -> 0x0089 }
                if (r1 == 0) goto L_0x0013
                java.nio.ByteBuffer r1 = r6.f72482e     // Catch:{ all -> 0x0089 }
                if (r1 != 0) goto L_0x0013
                java.lang.Object r1 = r6.f72479b     // Catch:{ InterruptedException -> 0x0011 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0003
            L_0x0011:
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                return
            L_0x0013:
                boolean r1 = r6.f72485i     // Catch:{ all -> 0x0089 }
                if (r1 != 0) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                return
            L_0x0019:
                com.google.android.gms.vision.b$a r1 = new com.google.android.gms.vision.b$a     // Catch:{ all -> 0x0089 }
                r1.<init>()     // Catch:{ all -> 0x0089 }
                java.nio.ByteBuffer r2 = r6.f72482e     // Catch:{ all -> 0x0089 }
                net.one97.scanner.camera.d r3 = net.one97.scanner.camera.d.this     // Catch:{ all -> 0x0089 }
                com.google.android.gms.common.images.a r3 = r3.f72470f     // Catch:{ all -> 0x0089 }
                int r3 = r3.f8720a     // Catch:{ all -> 0x0089 }
                net.one97.scanner.camera.d r4 = net.one97.scanner.camera.d.this     // Catch:{ all -> 0x0089 }
                com.google.android.gms.common.images.a r4 = r4.f72470f     // Catch:{ all -> 0x0089 }
                int r4 = r4.f8721b     // Catch:{ all -> 0x0089 }
                r5 = 17
                com.google.android.gms.vision.b$a r1 = r1.a(r2, r3, r4, r5)     // Catch:{ all -> 0x0089 }
                int r2 = r6.f72481d     // Catch:{ all -> 0x0089 }
                com.google.android.gms.vision.b$a r1 = r1.a((int) r2)     // Catch:{ all -> 0x0089 }
                long r2 = r6.f72480c     // Catch:{ all -> 0x0089 }
                com.google.android.gms.vision.b$a r1 = r1.a((long) r2)     // Catch:{ all -> 0x0089 }
                net.one97.scanner.camera.d r2 = net.one97.scanner.camera.d.this     // Catch:{ all -> 0x0089 }
                int r2 = r2.f72472h     // Catch:{ all -> 0x0089 }
                com.google.android.gms.vision.b$a r1 = r1.b(r2)     // Catch:{ all -> 0x0089 }
                com.google.android.gms.vision.b r1 = r1.a()     // Catch:{ all -> 0x0089 }
                java.nio.ByteBuffer r2 = r6.f72482e     // Catch:{ all -> 0x0089 }
                r3 = 0
                r6.f72482e = r3     // Catch:{ all -> 0x0089 }
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                java.util.List<com.google.android.gms.vision.a<?>> r0 = r6.f72484h     // Catch:{ all -> 0x007a }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007a }
            L_0x005c:
                boolean r3 = r0.hasNext()     // Catch:{ all -> 0x007a }
                if (r3 == 0) goto L_0x006c
                java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x007a }
                com.google.android.gms.vision.a r3 = (com.google.android.gms.vision.a) r3     // Catch:{ all -> 0x007a }
                r3.b(r1)     // Catch:{ all -> 0x007a }
                goto L_0x005c
            L_0x006c:
                net.one97.scanner.camera.d r0 = net.one97.scanner.camera.d.this
                android.hardware.Camera r0 = r0.f72468d
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x007a:
                net.one97.scanner.camera.d r0 = net.one97.scanner.camera.d.this
                android.hardware.Camera r0 = r0.f72468d
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0089:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.scanner.camera.d.c.run():void");
        }
    }

    private static C1467d a(Camera camera, int i2, int i3) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList<C1467d> arrayList = new ArrayList<>();
        for (Camera.Size next : supportedPreviewSizes) {
            float f2 = ((float) next.width) / ((float) next.height);
            Iterator<Camera.Size> it2 = supportedPictureSizes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Camera.Size next2 = it2.next();
                if (Math.abs(f2 - (((float) next2.width) / ((float) next2.height))) < 0.1f) {
                    arrayList.add(new C1467d(next, next2));
                    break;
                }
            }
        }
        C1467d dVar = null;
        if (arrayList.size() == 0) {
            for (Camera.Size dVar2 : supportedPreviewSizes) {
                arrayList.add(new C1467d(dVar2, (Camera.Size) null));
            }
        }
        int i4 = Integer.MAX_VALUE;
        for (C1467d dVar3 : arrayList) {
            com.google.android.gms.common.images.a aVar = dVar3.f72486a;
            int abs = Math.abs(aVar.f8720a - i2) + Math.abs(aVar.f8721b - i3);
            if (abs < i4) {
                dVar = dVar3;
                i4 = abs;
            }
        }
        return dVar;
    }
}
