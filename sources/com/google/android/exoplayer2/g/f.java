package com.google.android.exoplayer2.g;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

public final class f implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f32517a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b  reason: collision with root package name */
    public final Handler f32518b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f32519c;

    /* renamed from: d  reason: collision with root package name */
    public EGLDisplay f32520d;

    /* renamed from: e  reason: collision with root package name */
    public EGLContext f32521e;

    /* renamed from: f  reason: collision with root package name */
    public EGLSurface f32522f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f32523g;

    /* renamed from: h  reason: collision with root package name */
    private final b f32524h;

    public interface b {
    }

    public static final class a extends RuntimeException {
        private a(String str) {
            super(str);
        }
    }

    public f(Handler handler) {
        this(handler, (byte) 0);
    }

    private f(Handler handler, byte b2) {
        this.f32518b = handler;
        this.f32524h = null;
        this.f32519c = new int[1];
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f32518b.post(this);
    }

    public final void run() {
        SurfaceTexture surfaceTexture = this.f32523g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
