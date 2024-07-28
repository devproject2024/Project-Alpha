package com.google.android.exoplayer2.ui.spherical;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.aa;
import com.google.android.exoplayer2.g.j;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.video.a.a;
import com.google.android.exoplayer2.video.a.c;
import com.google.android.exoplayer2.video.a.d;
import com.google.android.exoplayer2.video.e;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d implements a, e {

    /* renamed from: a  reason: collision with root package name */
    final AtomicBoolean f33631a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f33632b = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    final c f33633c = new c();

    /* renamed from: d  reason: collision with root package name */
    final c f33634d = new c();

    /* renamed from: e  reason: collision with root package name */
    final aa<Long> f33635e = new aa<>();

    /* renamed from: f  reason: collision with root package name */
    final aa<com.google.android.exoplayer2.video.a.d> f33636f = new aa<>();

    /* renamed from: g  reason: collision with root package name */
    final float[] f33637g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    final float[] f33638h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    int f33639i;
    SurfaceTexture j;
    volatile int k = 0;
    private int l = -1;
    private byte[] m;

    public final SurfaceTexture a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        j.a();
        c cVar = this.f33633c;
        String[] strArr = c.f33618a;
        String[] strArr2 = c.f33619b;
        String join = TextUtils.join(StringUtility.NEW_LINE, strArr);
        String join2 = TextUtils.join(StringUtility.NEW_LINE, strArr2);
        int glCreateProgram = GLES20.glCreateProgram();
        j.a();
        j.a(35633, join, glCreateProgram);
        j.a(35632, join2, glCreateProgram);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            new StringBuilder("Unable to link shader program: \n").append(GLES20.glGetProgramInfoLog(glCreateProgram));
            l.d();
        }
        j.a();
        cVar.k = glCreateProgram;
        cVar.l = GLES20.glGetUniformLocation(cVar.k, "uMvpMatrix");
        cVar.m = GLES20.glGetUniformLocation(cVar.k, "uTexMatrix");
        cVar.n = GLES20.glGetAttribLocation(cVar.k, "aPosition");
        cVar.o = GLES20.glGetAttribLocation(cVar.k, "aTexCoords");
        cVar.p = GLES20.glGetUniformLocation(cVar.k, "uTexture");
        j.a();
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr2));
        GLES20.glBindTexture(36197, iArr2[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        j.a();
        this.f33639i = iArr2[0];
        this.j = new SurfaceTexture(this.f33639i);
        this.j.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                d.this.a(surfaceTexture);
            }
        });
        return this.j;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.f33631a.set(true);
    }

    public final void a(long j2, long j3, Format format) {
        int i2;
        float f2;
        float f3;
        int i3;
        Format format2 = format;
        this.f33635e.a(j3, Long.valueOf(j2));
        byte[] bArr = format2.t;
        int i4 = format2.s;
        byte[] bArr2 = this.m;
        int i5 = this.l;
        this.m = bArr;
        if (i4 == -1) {
            i4 = this.k;
        }
        this.l = i4;
        if (i5 != this.l || !Arrays.equals(bArr2, this.m)) {
            com.google.android.exoplayer2.video.a.d dVar = null;
            byte[] bArr3 = this.m;
            if (bArr3 != null) {
                dVar = com.google.android.exoplayer2.video.a.e.a(bArr3, this.l);
            }
            if (dVar == null || !c.a(dVar)) {
                int i6 = this.l;
                com.google.android.exoplayer2.g.a.a(true);
                com.google.android.exoplayer2.g.a.a(true);
                com.google.android.exoplayer2.g.a.a(true);
                com.google.android.exoplayer2.g.a.a(true);
                com.google.android.exoplayer2.g.a.a(true);
                float radians = (float) Math.toRadians(180.0d);
                float radians2 = (float) Math.toRadians(360.0d);
                float f4 = radians / 36.0f;
                float f5 = radians2 / 72.0f;
                float[] fArr = new float[15984];
                float[] fArr2 = new float[10656];
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < 36; i9 = i2) {
                    float f6 = radians / 2.0f;
                    float f7 = (((float) i9) * f4) - f6;
                    i2 = i9 + 1;
                    float f8 = (((float) i2) * f4) - f6;
                    int i10 = i8;
                    int i11 = i7;
                    int i12 = 0;
                    while (i12 < 73) {
                        int i13 = i2;
                        int i14 = 0;
                        while (i14 < 2) {
                            if (i14 == 0) {
                                f3 = f7;
                                f2 = f3;
                            } else {
                                f3 = f8;
                                f2 = f7;
                            }
                            float f9 = ((float) i12) * f5;
                            float f10 = f5;
                            int i15 = i10 + 1;
                            double d2 = (double) ((f9 + 3.1415927f) - (radians2 / 2.0f));
                            float f11 = f4;
                            double d3 = (double) f3;
                            int i16 = i6;
                            int i17 = i14;
                            fArr[i10] = -((float) (Math.sin(d2) * 50.0d * Math.cos(d3)));
                            int i18 = i15 + 1;
                            float f12 = radians;
                            fArr[i15] = (float) (Math.sin(d3) * 50.0d);
                            int i19 = i18 + 1;
                            fArr[i18] = (float) (Math.cos(d2) * 50.0d * Math.cos(d3));
                            int i20 = i11 + 1;
                            fArr2[i11] = f9 / radians2;
                            int i21 = i20 + 1;
                            fArr2[i20] = (((float) (i9 + i17)) * f11) / f12;
                            if (i12 == 0 && i17 == 0) {
                                i3 = i17;
                            } else {
                                if (i12 == 72) {
                                    i3 = i17;
                                    if (i3 != 1) {
                                    }
                                } else {
                                    i3 = i17;
                                }
                                i11 = i21;
                                i10 = i19;
                                i14 = i3 + 1;
                                long j4 = j3;
                                i6 = i16;
                                f7 = f2;
                                f4 = f11;
                                f5 = f10;
                                radians = f12;
                            }
                            System.arraycopy(fArr, i19 - 3, fArr, i19, 3);
                            i19 += 3;
                            System.arraycopy(fArr2, i21 - 2, fArr2, i21, 2);
                            i21 += 2;
                            i11 = i21;
                            i10 = i19;
                            i14 = i3 + 1;
                            long j42 = j3;
                            i6 = i16;
                            f7 = f2;
                            f4 = f11;
                            f5 = f10;
                            radians = f12;
                        }
                        int i22 = i6;
                        float f13 = radians;
                        float f14 = f4;
                        float f15 = f5;
                        float f16 = f7;
                        i12++;
                        long j5 = j3;
                        i2 = i13;
                    }
                    long j6 = j3;
                    i7 = i11;
                    i8 = i10;
                }
                dVar = new com.google.android.exoplayer2.video.a.d(new d.a(new d.b(0, fArr, fArr2, 1)), i6);
            }
            this.f33636f.a(j3, dVar);
        }
    }

    public final void a(long j2, float[] fArr) {
        this.f33634d.f33672c.a(j2, fArr);
    }

    public final void b() {
        this.f33635e.a();
        c cVar = this.f33634d;
        cVar.f33672c.a();
        cVar.f33673d = false;
        this.f33632b.set(true);
    }
}
