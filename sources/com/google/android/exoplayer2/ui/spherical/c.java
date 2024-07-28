package com.google.android.exoplayer2.ui.spherical;

import com.google.android.exoplayer2.g.j;
import com.google.android.exoplayer2.video.a.d;
import java.nio.FloatBuffer;

final class c {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f33618a = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* renamed from: b  reason: collision with root package name */
    static final String[] f33619b = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: c  reason: collision with root package name */
    static final float[] f33620c = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    static final float[] f33621d = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    static final float[] f33622e = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    static final float[] f33623f = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: g  reason: collision with root package name */
    static final float[] f33624g = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: h  reason: collision with root package name */
    int f33625h;

    /* renamed from: i  reason: collision with root package name */
    a f33626i;
    a j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;

    c() {
    }

    public static boolean a(d dVar) {
        d.a aVar = dVar.f33674a;
        d.a aVar2 = dVar.f33675b;
        return aVar.f33678a.length == 1 && aVar.f33678a[0].f33679a == 0 && aVar2.f33678a.length == 1 && aVar2.f33678a[0].f33679a == 0;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f33627a;

        /* renamed from: b  reason: collision with root package name */
        final FloatBuffer f33628b;

        /* renamed from: c  reason: collision with root package name */
        final FloatBuffer f33629c;

        /* renamed from: d  reason: collision with root package name */
        final int f33630d;

        public a(d.b bVar) {
            this.f33627a = bVar.f33681c.length / 3;
            this.f33628b = j.a(bVar.f33681c);
            this.f33629c = j.a(bVar.f33682d);
            int i2 = bVar.f33680b;
            if (i2 == 1) {
                this.f33630d = 5;
            } else if (i2 != 2) {
                this.f33630d = 4;
            } else {
                this.f33630d = 6;
            }
        }
    }
}
