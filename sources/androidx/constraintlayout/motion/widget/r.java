package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    protected androidx.constraintlayout.motion.a.b f2401a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f2402b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f2403c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    String f2404d;

    /* renamed from: e  reason: collision with root package name */
    private int f2405e;

    public abstract void a(View view, float f2);

    public String toString() {
        String str = this.f2404d;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f2405e; i2++) {
            str = str + "[" + this.f2402b[i2] + " , " + decimalFormat.format((double) this.f2403c[i2]) + "] ";
        }
        return str;
    }

    public final float a(float f2) {
        return (float) this.f2401a.a((double) f2);
    }

    public final float b(float f2) {
        return (float) this.f2401a.b((double) f2);
    }

    public void a(int i2, float f2) {
        int[] iArr = this.f2402b;
        if (iArr.length < this.f2405e + 1) {
            this.f2402b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2403c;
            this.f2403c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f2402b;
        int i3 = this.f2405e;
        iArr2[i3] = i2;
        this.f2403c[i3] = f2;
        this.f2405e = i3 + 1;
    }

    public void a(int i2) {
        int i3 = this.f2405e;
        if (i3 != 0) {
            int[] iArr = this.f2402b;
            float[] fArr = this.f2403c;
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3 - 1;
            int i4 = 2;
            iArr2[1] = 0;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int i8 = iArr[i7];
                    int i9 = i6;
                    int i10 = i9;
                    while (i9 < i7) {
                        if (iArr[i9] <= i8) {
                            m.a(iArr, fArr, i10, i9);
                            i10++;
                        }
                        i9++;
                    }
                    m.a(iArr, fArr, i10, i7);
                    int i11 = i4 + 1;
                    iArr2[i4] = i10 - 1;
                    int i12 = i11 + 1;
                    iArr2[i11] = i6;
                    int i13 = i12 + 1;
                    iArr2[i12] = i7;
                    i4 = i13 + 1;
                    iArr2[i13] = i10 + 1;
                }
            }
            int i14 = 1;
            for (int i15 = 1; i15 < this.f2405e; i15++) {
                int[] iArr3 = this.f2402b;
                if (iArr3[i15 - 1] != iArr3[i15]) {
                    i14++;
                }
            }
            double[] dArr = new double[i14];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, new int[]{i14, 1});
            int i16 = 0;
            for (int i17 = 0; i17 < this.f2405e; i17++) {
                if (i17 > 0) {
                    int[] iArr4 = this.f2402b;
                    if (iArr4[i17] == iArr4[i17 - 1]) {
                    }
                }
                dArr[i16] = ((double) this.f2402b[i17]) * 0.01d;
                dArr2[i16][0] = (double) this.f2403c[i17];
                i16++;
            }
            this.f2401a = androidx.constraintlayout.motion.a.b.a(i2, dArr, dArr2);
        }
    }

    static class c extends r {
        c() {
        }

        public final void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    static class a extends r {
        a() {
        }

        public final void a(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    static class h extends r {
        h() {
        }

        public final void a(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class i extends r {
        i() {
        }

        public final void a(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class j extends r {
        j() {
        }

        public final void a(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class e extends r {
        e() {
        }

        public final void a(View view, float f2) {
            view.setPivotX(a(f2));
        }
    }

    static class f extends r {
        f() {
        }

        public final void a(View view, float f2) {
            view.setPivotY(a(f2));
        }
    }

    static class d extends r {
        public final void a(View view, float f2) {
        }

        d() {
        }
    }

    static class k extends r {
        k() {
        }

        public final void a(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class l extends r {
        l() {
        }

        public final void a(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    static class n extends r {
        n() {
        }

        public final void a(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class o extends r {
        o() {
        }

        public final void a(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class p extends r {
        p() {
        }

        public final void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    static class b extends r {

        /* renamed from: e  reason: collision with root package name */
        String f2406e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<androidx.constraintlayout.widget.a> f2407f;

        /* renamed from: g  reason: collision with root package name */
        float[] f2408g;

        public b(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
            this.f2406e = str.split(AppConstants.COMMA)[1];
            this.f2407f = sparseArray;
        }

        public final void a(int i2) {
            int size = this.f2407f.size();
            int a2 = this.f2407f.valueAt(0).a();
            double[] dArr = new double[size];
            this.f2408g = new float[a2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, new int[]{size, a2});
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = ((double) this.f2407f.keyAt(i3)) * 0.01d;
                this.f2407f.valueAt(i3).a(this.f2408g);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f2408g;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.f2401a = androidx.constraintlayout.motion.a.b.a(i2, dArr, dArr2);
        }

        public final void a(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public final void a(int i2, androidx.constraintlayout.widget.a aVar) {
            this.f2407f.append(i2, aVar);
        }

        public final void a(View view, float f2) {
            this.f2401a.a((double) f2, this.f2408g);
            this.f2407f.valueAt(0).a(view, this.f2408g);
        }
    }

    static class g extends r {

        /* renamed from: e  reason: collision with root package name */
        boolean f2409e = false;

        g() {
        }

        public final void a(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f2409e) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f2409e = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    static class m {
        static void a(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }
}
