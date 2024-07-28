package androidx.transition;

import android.animation.TypeEvaluator;

final class d implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f4775a;

    public final /* bridge */ /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        float[] fArr3 = this.f4775a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            float f3 = fArr[i2];
            fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
        }
        return fArr3;
    }

    d(float[] fArr) {
        this.f4775a = fArr;
    }
}
