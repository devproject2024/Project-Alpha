package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.j;
import com.google.android.exoplayer2.ui.spherical.b;
import com.google.android.exoplayer2.ui.spherical.c;
import com.google.android.exoplayer2.ui.spherical.f;
import com.google.android.exoplayer2.video.a.d;
import com.google.android.exoplayer2.video.e;
import com.google.android.exoplayer2.z;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private final SensorManager f33590a;

    /* renamed from: b  reason: collision with root package name */
    private final Sensor f33591b;

    /* renamed from: c  reason: collision with root package name */
    private final b f33592c;

    /* renamed from: d  reason: collision with root package name */
    private final a f33593d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f33594e;

    /* renamed from: f  reason: collision with root package name */
    private final f f33595f;

    /* renamed from: g  reason: collision with root package name */
    private final d f33596g;

    /* renamed from: h  reason: collision with root package name */
    private SurfaceTexture f33597h;

    /* renamed from: i  reason: collision with root package name */
    private Surface f33598i;
    private z.c j;

    public SphericalSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SphericalSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33594e = new Handler(Looper.getMainLooper());
        this.f33590a = (SensorManager) com.google.android.exoplayer2.g.a.a(context.getSystemService("sensor"));
        Sensor defaultSensor = ae.f32499a >= 18 ? this.f33590a.getDefaultSensor(15) : null;
        this.f33591b = defaultSensor == null ? this.f33590a.getDefaultSensor(11) : defaultSensor;
        this.f33596g = new d();
        this.f33593d = new a(this.f33596g);
        this.f33595f = new f(context, this.f33593d);
        this.f33592c = new b(((WindowManager) com.google.android.exoplayer2.g.a.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), this.f33595f, this.f33593d);
        setEGLContextClientVersion(2);
        setRenderer(this.f33593d);
        setOnTouchListener(this.f33595f);
    }

    public final void setDefaultStereoMode(int i2) {
        this.f33596g.k = i2;
    }

    public final void setVideoComponent(z.c cVar) {
        z.c cVar2 = this.j;
        if (cVar != cVar2) {
            if (cVar2 != null) {
                Surface surface = this.f33598i;
                if (surface != null) {
                    cVar2.a(surface);
                }
                this.j.b((e) this.f33596g);
                this.j.b((com.google.android.exoplayer2.video.a.a) this.f33596g);
            }
            this.j = cVar;
            z.c cVar3 = this.j;
            if (cVar3 != null) {
                cVar3.a((e) this.f33596g);
                this.j.a((com.google.android.exoplayer2.video.a.a) this.f33596g);
                this.j.b(this.f33598i);
            }
        }
    }

    public final void setSingleTapListener(e eVar) {
        this.f33595f.f33640a = eVar;
    }

    public final void onResume() {
        super.onResume();
        Sensor sensor = this.f33591b;
        if (sensor != null) {
            this.f33590a.registerListener(this.f33592c, sensor, 0);
        }
    }

    public final void onPause() {
        if (this.f33591b != null) {
            this.f33590a.unregisterListener(this.f33592c);
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33594e.post(new Runnable() {
            public final void run() {
                SphericalSurfaceView.this.a();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        Surface surface = this.f33598i;
        if (surface != null) {
            z.c cVar = this.j;
            if (cVar != null) {
                cVar.a(surface);
            }
            a(this.f33597h, this.f33598i);
            this.f33597h = null;
            this.f33598i = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f33597h;
        Surface surface = this.f33598i;
        this.f33597h = surfaceTexture;
        this.f33598i = new Surface(surfaceTexture);
        z.c cVar = this.j;
        if (cVar != null) {
            cVar.b(this.f33598i);
        }
        a(surfaceTexture2, surface);
    }

    private static void a(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    class a implements GLSurfaceView.Renderer, b.a, f.a {

        /* renamed from: b  reason: collision with root package name */
        private final d f33600b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f33601c = new float[16];

        /* renamed from: d  reason: collision with root package name */
        private final float[] f33602d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final float[] f33603e = new float[16];

        /* renamed from: f  reason: collision with root package name */
        private final float[] f33604f = new float[16];

        /* renamed from: g  reason: collision with root package name */
        private final float[] f33605g = new float[16];

        /* renamed from: h  reason: collision with root package name */
        private float f33606h;

        /* renamed from: i  reason: collision with root package name */
        private float f33607i;
        private final float[] j = new float[16];
        private final float[] k = new float[16];

        public a(d dVar) {
            this.f33600b = dVar;
            Matrix.setIdentityM(this.f33603e, 0);
            Matrix.setIdentityM(this.f33604f, 0);
            Matrix.setIdentityM(this.f33605g, 0);
            this.f33607i = 3.1415927f;
        }

        public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalSurfaceView.this.f33594e.post(new Runnable(this.f33600b.a()) {
                private final /* synthetic */ SurfaceTexture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SphericalSurfaceView.this.a(this.f$1);
                }
            });
        }

        public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            boolean z = false;
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            if (f2 > 1.0f) {
                z = true;
            }
            Matrix.perspectiveM(this.f33601c, 0, z ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f2))) * 2.0d) : 90.0f, f2, 0.1f, 100.0f);
        }

        public final void onDrawFrame(GL10 gl10) {
            float[] fArr;
            c.a aVar;
            float[] fArr2;
            synchronized (this) {
                Matrix.multiplyMM(this.k, 0, this.f33603e, 0, this.f33605g, 0);
                Matrix.multiplyMM(this.j, 0, this.f33604f, 0, this.k, 0);
            }
            Matrix.multiplyMM(this.f33602d, 0, this.f33601c, 0, this.j, 0);
            d dVar = this.f33600b;
            float[] fArr3 = this.f33602d;
            GLES20.glClear(16384);
            j.a();
            if (dVar.f33631a.compareAndSet(true, false)) {
                ((SurfaceTexture) com.google.android.exoplayer2.g.a.a(dVar.j)).updateTexImage();
                j.a();
                if (dVar.f33632b.compareAndSet(true, false)) {
                    Matrix.setIdentityM(dVar.f33637g, 0);
                }
                long timestamp = dVar.j.getTimestamp();
                Long b2 = dVar.f33635e.b(timestamp);
                if (b2 != null) {
                    com.google.android.exoplayer2.video.a.c cVar = dVar.f33634d;
                    float[] fArr4 = dVar.f33637g;
                    float[] a2 = cVar.f33672c.a(b2.longValue());
                    if (a2 != null) {
                        float[] fArr5 = cVar.f33671b;
                        float f2 = a2[0];
                        float f3 = -a2[1];
                        float f4 = -a2[2];
                        float length = Matrix.length(f2, f3, f4);
                        if (length != 0.0f) {
                            fArr2 = fArr4;
                            Matrix.setRotateM(fArr5, 0, (float) Math.toDegrees((double) length), f2 / length, f3 / length, f4 / length);
                        } else {
                            fArr2 = fArr4;
                            Matrix.setIdentityM(fArr5, 0);
                        }
                        if (!cVar.f33673d) {
                            com.google.android.exoplayer2.video.a.c.a(cVar.f33670a, cVar.f33671b);
                            cVar.f33673d = true;
                        }
                        Matrix.multiplyMM(fArr2, 0, cVar.f33670a, 0, cVar.f33671b, 0);
                    }
                }
                d a3 = dVar.f33636f.a(timestamp);
                if (a3 != null) {
                    c cVar2 = dVar.f33633c;
                    if (c.a(a3)) {
                        cVar2.f33625h = a3.f33676c;
                        cVar2.f33626i = new c.a(a3.f33674a.f33678a[0]);
                        if (a3.f33677d) {
                            aVar = cVar2.f33626i;
                        } else {
                            aVar = new c.a(a3.f33675b.f33678a[0]);
                        }
                        cVar2.j = aVar;
                    }
                }
            }
            Matrix.multiplyMM(dVar.f33638h, 0, fArr3, 0, dVar.f33637g, 0);
            c cVar3 = dVar.f33633c;
            int i2 = dVar.f33639i;
            float[] fArr6 = dVar.f33638h;
            c.a aVar2 = cVar3.f33626i;
            if (aVar2 != null) {
                GLES20.glUseProgram(cVar3.k);
                j.a();
                GLES20.glEnableVertexAttribArray(cVar3.n);
                GLES20.glEnableVertexAttribArray(cVar3.o);
                j.a();
                if (cVar3.f33625h == 1) {
                    fArr = c.f33621d;
                } else if (cVar3.f33625h == 2) {
                    fArr = c.f33623f;
                } else {
                    fArr = c.f33620c;
                }
                GLES20.glUniformMatrix3fv(cVar3.m, 1, false, fArr, 0);
                GLES20.glUniformMatrix4fv(cVar3.l, 1, false, fArr6, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i2);
                GLES20.glUniform1i(cVar3.p, 0);
                j.a();
                GLES20.glVertexAttribPointer(cVar3.n, 3, 5126, false, 12, aVar2.f33628b);
                j.a();
                GLES20.glVertexAttribPointer(cVar3.o, 2, 5126, false, 8, aVar2.f33629c);
                j.a();
                GLES20.glDrawArrays(aVar2.f33630d, 0, aVar2.f33627a);
                j.a();
                GLES20.glDisableVertexAttribArray(cVar3.n);
                GLES20.glDisableVertexAttribArray(cVar3.o);
            }
        }

        public final synchronized void a(float[] fArr, float f2) {
            System.arraycopy(fArr, 0, this.f33603e, 0, this.f33603e.length);
            this.f33607i = -f2;
            a();
        }

        private void a() {
            Matrix.setRotateM(this.f33604f, 0, -this.f33606h, (float) Math.cos((double) this.f33607i), (float) Math.sin((double) this.f33607i), 0.0f);
        }

        public final synchronized void a(PointF pointF) {
            this.f33606h = pointF.y;
            a();
            Matrix.setRotateM(this.f33605g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }
    }
}
