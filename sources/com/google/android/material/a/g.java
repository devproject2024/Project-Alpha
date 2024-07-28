package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f35810a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f35811b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f35812c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f35810a);
        matrix2.getValues(this.f35811b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f35811b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f35810a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f35812c.setValues(this.f35811b);
        return this.f35812c;
    }
}
