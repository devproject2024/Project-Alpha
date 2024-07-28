package com.google.android.exoplayer2.video.a;

import android.opengl.Matrix;
import com.google.android.exoplayer2.g.aa;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f33670a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f33671b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final aa<float[]> f33672c = new aa<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f33673d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float sqrt = (float) Math.sqrt((double) ((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8])));
        fArr[0] = fArr2[10] / sqrt;
        fArr[2] = fArr2[8] / sqrt;
        fArr[8] = (-fArr2[8]) / sqrt;
        fArr[10] = fArr2[10] / sqrt;
    }
}
