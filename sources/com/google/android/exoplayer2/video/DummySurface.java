package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.j;
import com.google.android.exoplayer2.g.l;

public final class DummySurface extends Surface {

    /* renamed from: b  reason: collision with root package name */
    private static int f33652b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f33653c;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f33654a;

    /* renamed from: d  reason: collision with root package name */
    private final a f33655d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33656e;

    /* synthetic */ DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z, byte b2) {
        this(aVar, surfaceTexture, z);
    }

    public static synchronized boolean a(Context context) {
        int i2;
        int i3;
        synchronized (DummySurface.class) {
            if (!f33653c) {
                if (ae.f32499a >= 24) {
                    if (ae.f32499a < 26) {
                        if (!"samsung".equals(ae.f32501c)) {
                            if ("XT1650".equals(ae.f32502d)) {
                            }
                        }
                    }
                    if (ae.f32499a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                        if (eglQueryString != null) {
                            if (eglQueryString.contains("EGL_EXT_protected_content")) {
                                i3 = eglQueryString.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
                                f33652b = i3;
                                f33653c = true;
                            }
                        }
                    }
                }
                i3 = 0;
                f33652b = i3;
                f33653c = true;
            }
            i2 = f33652b;
        }
        return i2 != 0;
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f33655d = aVar;
        this.f33654a = z;
    }

    public final void release() {
        super.release();
        synchronized (this.f33655d) {
            if (!this.f33656e) {
                a aVar = this.f33655d;
                com.google.android.exoplayer2.g.a.a(aVar.f33657a);
                aVar.f33657a.sendEmptyMessage(2);
                this.f33656e = true;
            }
        }
    }

    static class a extends HandlerThread implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        Handler f33657a;

        /* renamed from: b  reason: collision with root package name */
        private f f33658b;

        /* renamed from: c  reason: collision with root package name */
        private Error f33659c;

        /* renamed from: d  reason: collision with root package name */
        private RuntimeException f33660d;

        /* renamed from: e  reason: collision with root package name */
        private DummySurface f33661e;

        public a() {
            super("dummySurface");
        }

        public final DummySurface a(int i2) {
            boolean z;
            start();
            this.f33657a = new Handler(getLooper(), this);
            this.f33658b = new f(this.f33657a);
            synchronized (this) {
                z = false;
                this.f33657a.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f33661e == null && this.f33660d == null && this.f33659c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f33660d;
            if (runtimeException == null) {
                Error error = this.f33659c;
                if (error == null) {
                    return (DummySurface) com.google.android.exoplayer2.g.a.a(this.f33661e);
                }
                throw error;
            }
            throw runtimeException;
        }

        public final boolean handleMessage(Message message) {
            EGLSurface eGLSurface;
            f fVar;
            Message message2 = message;
            int i2 = message2.what;
            if (i2 == 1) {
                try {
                    int i3 = message2.arg1;
                    com.google.android.exoplayer2.g.a.a(this.f33658b);
                    f fVar2 = this.f33658b;
                    EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                    if (eglGetDisplay != null) {
                        int[] iArr = new int[2];
                        if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                            fVar2.f32520d = eglGetDisplay;
                            EGLConfig[] eGLConfigArr = new EGLConfig[1];
                            int[] iArr2 = new int[1];
                            boolean eglChooseConfig = EGL14.eglChooseConfig(fVar2.f32520d, f.f32517a, 0, eGLConfigArr, 0, 1, iArr2, 0);
                            if (!eglChooseConfig || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
                                throw new f.a(ae.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]));
                            }
                            EGLConfig eGLConfig = eGLConfigArr[0];
                            EGLContext eglCreateContext = EGL14.eglCreateContext(fVar2.f32520d, eGLConfig, EGL14.EGL_NO_CONTEXT, i3 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
                            if (eglCreateContext != null) {
                                fVar2.f32521e = eglCreateContext;
                                EGLDisplay eGLDisplay = fVar2.f32520d;
                                EGLContext eGLContext = fVar2.f32521e;
                                if (i3 == 1) {
                                    eGLSurface = EGL14.EGL_NO_SURFACE;
                                } else {
                                    eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i3 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                                    if (eGLSurface == null) {
                                        throw new f.a("eglCreatePbufferSurface failed");
                                    }
                                }
                                if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
                                    fVar2.f32522f = eGLSurface;
                                    GLES20.glGenTextures(1, fVar2.f32519c, 0);
                                    j.a();
                                    fVar2.f32523g = new SurfaceTexture(fVar2.f32519c[0]);
                                    fVar2.f32523g.setOnFrameAvailableListener(fVar2);
                                    this.f33661e = new DummySurface(this, (SurfaceTexture) com.google.android.exoplayer2.g.a.a(this.f33658b.f32523g), i3 != 0, (byte) 0);
                                    synchronized (this) {
                                        notify();
                                    }
                                    return true;
                                }
                                throw new f.a("eglMakeCurrent failed");
                            }
                            throw new f.a("eglCreateContext failed");
                        }
                        throw new f.a("eglInitialize failed");
                    }
                    throw new f.a("eglGetDisplay failed");
                } catch (RuntimeException e2) {
                    l.b("Failed to initialize dummy surface", e2);
                    this.f33660d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    try {
                        l.b("Failed to initialize dummy surface", e3);
                        this.f33659c = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
            } else if (i2 != 2) {
                return true;
            } else {
                try {
                    com.google.android.exoplayer2.g.a.a(this.f33658b);
                    fVar = this.f33658b;
                    fVar.f32518b.removeCallbacks(fVar);
                    if (fVar.f32523g != null) {
                        fVar.f32523g.release();
                        GLES20.glDeleteTextures(1, fVar.f32519c, 0);
                    }
                    if (fVar.f32520d != null && !fVar.f32520d.equals(EGL14.EGL_NO_DISPLAY)) {
                        EGLDisplay eGLDisplay2 = fVar.f32520d;
                        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
                        EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, EGL14.EGL_NO_CONTEXT);
                    }
                    if (fVar.f32522f != null && !fVar.f32522f.equals(EGL14.EGL_NO_SURFACE)) {
                        EGL14.eglDestroySurface(fVar.f32520d, fVar.f32522f);
                    }
                    if (fVar.f32521e != null) {
                        EGL14.eglDestroyContext(fVar.f32520d, fVar.f32521e);
                    }
                    if (ae.f32499a >= 19) {
                        EGL14.eglReleaseThread();
                    }
                    if (fVar.f32520d != null && !fVar.f32520d.equals(EGL14.EGL_NO_DISPLAY)) {
                        EGL14.eglTerminate(fVar.f32520d);
                    }
                    fVar.f32520d = null;
                    fVar.f32521e = null;
                    fVar.f32522f = null;
                    fVar.f32523g = null;
                } catch (Throwable th2) {
                    try {
                        l.b("Failed to release dummy surface", th2);
                    } catch (Throwable th3) {
                        quit();
                        throw th3;
                    }
                }
                quit();
                return true;
            }
        }
    }

    public static DummySurface a(Context context, boolean z) {
        if (ae.f32499a >= 17) {
            int i2 = 0;
            com.google.android.exoplayer2.g.a.b(!z || a(context));
            a aVar = new a();
            if (z) {
                i2 = f33652b;
            }
            return aVar.a(i2);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
