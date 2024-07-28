package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    protected androidx.constraintlayout.widget.a f2314a;

    /* renamed from: b  reason: collision with root package name */
    String f2315b;

    /* renamed from: c  reason: collision with root package name */
    int f2316c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2317d = 0;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<o> f2318e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private androidx.constraintlayout.motion.a.b f2319f;

    /* renamed from: g  reason: collision with root package name */
    private c f2320g;

    public abstract void a(View view, float f2);

    static class o {

        /* renamed from: a  reason: collision with root package name */
        int f2333a;

        /* renamed from: b  reason: collision with root package name */
        float f2334b;

        /* renamed from: c  reason: collision with root package name */
        float f2335c;

        /* renamed from: d  reason: collision with root package name */
        float f2336d;

        public o(int i2, float f2, float f3, float f4) {
            this.f2333a = i2;
            this.f2334b = f4;
            this.f2335c = f3;
            this.f2336d = f2;
        }
    }

    public String toString() {
        String str = this.f2315b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<o> it2 = this.f2318e.iterator();
        while (it2.hasNext()) {
            o next = it2.next();
            str = str + "[" + next.f2333a + " , " + decimalFormat.format((double) next.f2334b) + "] ";
        }
        return str;
    }

    public final float a(float f2) {
        c cVar = this.f2320g;
        if (cVar.f2330h != null) {
            cVar.f2330h.a((double) f2, cVar.f2331i);
        } else {
            cVar.f2331i[0] = (double) cVar.f2327e[0];
            cVar.f2331i[1] = (double) cVar.f2324b[0];
        }
        return (float) (cVar.f2331i[0] + (cVar.f2323a.a((double) f2) * cVar.f2331i[1]));
    }

    public final float b(float f2) {
        return (float) this.f2320g.a(f2);
    }

    public final void a(int i2, int i3, int i4, float f2, float f3, float f4, androidx.constraintlayout.widget.a aVar) {
        this.f2318e.add(new o(i2, f2, f3, f4));
        if (i4 != -1) {
            this.f2317d = i4;
        }
        this.f2316c = i3;
        this.f2314a = aVar;
    }

    public final void c(float f2) {
        int i2;
        Class<double> cls = double.class;
        int size = this.f2318e.size();
        if (size != 0) {
            Collections.sort(this.f2318e, new Comparator<o>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return Integer.compare(((o) obj).f2333a, ((o) obj2).f2333a);
                }
            });
            double[] dArr = new double[size];
            double[][] dArr2 = (double[][]) Array.newInstance(cls, new int[]{size, 2});
            this.f2320g = new c(this.f2316c, this.f2317d, size);
            Iterator<o> it2 = this.f2318e.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                o next = it2.next();
                dArr[i3] = ((double) next.f2336d) * 0.01d;
                dArr2[i3][0] = (double) next.f2334b;
                dArr2[i3][1] = (double) next.f2335c;
                c cVar = this.f2320g;
                int i4 = next.f2333a;
                float f3 = next.f2336d;
                float f4 = next.f2335c;
                float f5 = next.f2334b;
                cVar.f2325c[i3] = ((double) i4) / 100.0d;
                cVar.f2326d[i3] = f3;
                cVar.f2327e[i3] = f4;
                cVar.f2324b[i3] = f5;
                i3++;
                dArr2 = dArr2;
            }
            double[][] dArr3 = dArr2;
            c cVar2 = this.f2320g;
            cVar2.k = f2;
            double[][] dArr4 = (double[][]) Array.newInstance(cls, new int[]{cVar2.f2325c.length, 2});
            cVar2.f2331i = new double[(cVar2.f2324b.length + 1)];
            cVar2.j = new double[(cVar2.f2324b.length + 1)];
            if (cVar2.f2325c[0] > 0.0d) {
                cVar2.f2323a.a(0.0d, cVar2.f2326d[0]);
            }
            int length = cVar2.f2325c.length - 1;
            if (cVar2.f2325c[length] < 1.0d) {
                cVar2.f2323a.a(1.0d, cVar2.f2326d[length]);
            }
            for (int i5 = 0; i5 < dArr4.length; i5++) {
                dArr4[i5][0] = (double) cVar2.f2327e[i5];
                for (int i6 = 0; i6 < cVar2.f2324b.length; i6++) {
                    dArr4[i6][1] = (double) cVar2.f2324b[i6];
                }
                cVar2.f2323a.a(cVar2.f2325c[i5], cVar2.f2326d[i5]);
            }
            androidx.constraintlayout.motion.a.f fVar = cVar2.f2323a;
            double d2 = 0.0d;
            for (float f6 : fVar.f2223b) {
                d2 += (double) f6;
            }
            double d3 = 0.0d;
            for (int i7 = 1; i7 < fVar.f2223b.length; i7++) {
                int i8 = i7 - 1;
                d3 += (fVar.f2224c[i7] - fVar.f2224c[i8]) * ((double) ((fVar.f2223b[i8] + fVar.f2223b[i7]) / 2.0f));
            }
            for (int i9 = 0; i9 < fVar.f2223b.length; i9++) {
                float[] fArr = fVar.f2223b;
                fArr[i9] = (float) (((double) fArr[i9]) * (d2 / d3));
            }
            fVar.f2225d[0] = 0.0d;
            int i10 = 1;
            while (i10 < fVar.f2223b.length) {
                int i11 = i10 - 1;
                double d4 = fVar.f2224c[i10] - fVar.f2224c[i11];
                double[] dArr5 = fVar.f2225d;
                dArr5[i10] = dArr5[i11] + (d4 * ((double) ((fVar.f2223b[i11] + fVar.f2223b[i10]) / 2.0f)));
                i10++;
                fVar = fVar;
            }
            fVar.f2228g = true;
            if (cVar2.f2325c.length > 1) {
                i2 = 0;
                cVar2.f2330h = androidx.constraintlayout.motion.a.b.a(0, cVar2.f2325c, dArr4);
            } else {
                i2 = 0;
                cVar2.f2330h = null;
            }
            this.f2319f = androidx.constraintlayout.motion.a.b.a(i2, dArr, dArr3);
        }
    }

    static class d extends g {
        d() {
        }

        public final void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    static class a extends g {
        a() {
        }

        public final void a(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.g$g  reason: collision with other inner class name */
    static class C0032g extends g {
        C0032g() {
        }

        public final void a(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    static class h extends g {
        h() {
        }

        public final void a(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    static class i extends g {
        i() {
        }

        public final void a(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    static class e extends g {
        public final void a(View view, float f2) {
        }

        e() {
        }
    }

    static class j extends g {
        j() {
        }

        public final void a(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    static class k extends g {
        k() {
        }

        public final void a(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    static class l extends g {
        l() {
        }

        public final void a(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    static class m extends g {
        m() {
        }

        public final void a(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    static class n extends g {
        n() {
        }

        public final void a(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    static class b extends g {

        /* renamed from: f  reason: collision with root package name */
        float[] f2322f = new float[1];

        b() {
        }

        public final void a(View view, float f2) {
            this.f2322f[0] = a(f2);
            this.f2314a.a(view, this.f2322f);
        }
    }

    static class f extends g {

        /* renamed from: f  reason: collision with root package name */
        boolean f2332f = false;

        f() {
        }

        public final void a(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (!this.f2332f) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f2332f = true;
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

    static class c {

        /* renamed from: a  reason: collision with root package name */
        androidx.constraintlayout.motion.a.f f2323a = new androidx.constraintlayout.motion.a.f();

        /* renamed from: b  reason: collision with root package name */
        float[] f2324b;

        /* renamed from: c  reason: collision with root package name */
        double[] f2325c;

        /* renamed from: d  reason: collision with root package name */
        float[] f2326d;

        /* renamed from: e  reason: collision with root package name */
        float[] f2327e;

        /* renamed from: f  reason: collision with root package name */
        float[] f2328f;

        /* renamed from: g  reason: collision with root package name */
        int f2329g;

        /* renamed from: h  reason: collision with root package name */
        androidx.constraintlayout.motion.a.b f2330h;

        /* renamed from: i  reason: collision with root package name */
        double[] f2331i;
        double[] j;
        float k;
        public HashMap<String, androidx.constraintlayout.widget.a> l = new HashMap<>();
        private final int m;

        c(int i2, int i3, int i4) {
            this.f2329g = i2;
            this.m = i3;
            this.f2323a.f2226e = i2;
            this.f2324b = new float[i4];
            this.f2325c = new double[i4];
            this.f2326d = new float[i4];
            this.f2327e = new float[i4];
            this.f2328f = new float[i4];
        }

        public final double a(float f2) {
            androidx.constraintlayout.motion.a.b bVar = this.f2330h;
            if (bVar != null) {
                double d2 = (double) f2;
                bVar.b(d2, this.j);
                this.f2330h.a(d2, this.f2331i);
            } else {
                double[] dArr = this.j;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d3 = (double) f2;
            double a2 = this.f2323a.a(d3);
            double b2 = this.f2323a.b(d3);
            double[] dArr2 = this.j;
            return dArr2[0] + (a2 * dArr2[1]) + (b2 * this.f2331i[1]);
        }
    }
}
