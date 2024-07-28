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
import java.util.HashMap;

public abstract class s {
    private static float k = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    protected androidx.constraintlayout.motion.a.b f2410a;

    /* renamed from: b  reason: collision with root package name */
    protected int f2411b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f2412c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f2413d = ((float[][]) Array.newInstance(float.class, new int[]{10, 3}));

    /* renamed from: e  reason: collision with root package name */
    String f2414e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f2415f = false;

    /* renamed from: g  reason: collision with root package name */
    long f2416g;

    /* renamed from: h  reason: collision with root package name */
    float f2417h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    private int f2418i;
    private float[] j = new float[3];

    public abstract boolean a(View view, float f2, long j2, e eVar);

    public String toString() {
        String str = this.f2414e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f2418i; i2++) {
            str = str + "[" + this.f2412c[i2] + " , " + decimalFormat.format(this.f2413d[i2]) + "] ";
        }
        return str;
    }

    public final float a(float f2, long j2, View view, e eVar) {
        long j3 = j2;
        View view2 = view;
        e eVar2 = eVar;
        this.f2410a.a((double) f2, this.j);
        float[] fArr = this.j;
        float f3 = fArr[1];
        boolean z = false;
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.f2415f = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f2417h)) {
            this.f2417h = eVar2.a(view2, this.f2414e);
            if (Float.isNaN(this.f2417h)) {
                this.f2417h = 0.0f;
            }
        }
        this.f2417h = (float) ((((double) this.f2417h) + ((((double) (j3 - this.f2416g)) * 1.0E-9d) * ((double) f3))) % 1.0d);
        String str = this.f2414e;
        float f4 = this.f2417h;
        if (!eVar2.f2309a.containsKey(view2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, new float[]{f4});
            eVar2.f2309a.put(view2, hashMap);
        } else {
            HashMap hashMap2 = eVar2.f2309a.get(view2);
            if (!hashMap2.containsKey(str)) {
                hashMap2.put(str, new float[]{f4});
                eVar2.f2309a.put(view2, hashMap2);
            } else {
                float[] fArr2 = (float[]) hashMap2.get(str);
                if (fArr2.length <= 0) {
                    fArr2 = Arrays.copyOf(fArr2, 1);
                }
                fArr2[0] = f4;
                hashMap2.put(str, fArr2);
            }
        }
        this.f2416g = j3;
        float f5 = this.j[0];
        float a2 = (a(this.f2417h) * f5) + this.j[2];
        if (!(f5 == 0.0f && i2 == 0)) {
            z = true;
        }
        this.f2415f = z;
        return a2;
    }

    /* access modifiers changed from: protected */
    public final float a(float f2) {
        float abs;
        switch (this.f2411b) {
            case 1:
                return Math.signum(f2 * k);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f2 * k));
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f2 * k));
        }
        return 1.0f - abs;
    }

    static s a(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.constraintlayout.motion.widget.s a(java.lang.String r1, long r2) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x007d;
                case -1249320805: goto L_0x0073;
                case -1225497657: goto L_0x0068;
                case -1225497656: goto L_0x005d;
                case -1225497655: goto L_0x0052;
                case -1001078227: goto L_0x0047;
                case -908189618: goto L_0x003d;
                case -908189617: goto L_0x0033;
                case -40300674: goto L_0x0029;
                case -4379043: goto L_0x001f;
                case 37232917: goto L_0x0014;
                case 92909918: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "alpha"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 0
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "transitionPathRotate"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 5
            goto L_0x0088
        L_0x001f:
            java.lang.String r0 = "elevation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 1
            goto L_0x0088
        L_0x0029:
            java.lang.String r0 = "rotation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 2
            goto L_0x0088
        L_0x0033:
            java.lang.String r0 = "scaleY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 7
            goto L_0x0088
        L_0x003d:
            java.lang.String r0 = "scaleX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 6
            goto L_0x0088
        L_0x0047:
            java.lang.String r0 = "progress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 11
            goto L_0x0088
        L_0x0052:
            java.lang.String r0 = "translationZ"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 10
            goto L_0x0088
        L_0x005d:
            java.lang.String r0 = "translationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 9
            goto L_0x0088
        L_0x0068:
            java.lang.String r0 = "translationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 8
            goto L_0x0088
        L_0x0073:
            java.lang.String r0 = "rotationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 4
            goto L_0x0088
        L_0x007d:
            java.lang.String r0 = "rotationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0087
            r1 = 3
            goto L_0x0088
        L_0x0087:
            r1 = -1
        L_0x0088:
            switch(r1) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00c9;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00ab;
                case 7: goto L_0x00a5;
                case 8: goto L_0x009f;
                case 9: goto L_0x0099;
                case 10: goto L_0x0093;
                case 11: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            r1 = 0
            return r1
        L_0x008d:
            androidx.constraintlayout.motion.widget.s$e r1 = new androidx.constraintlayout.motion.widget.s$e
            r1.<init>()
            goto L_0x00d4
        L_0x0093:
            androidx.constraintlayout.motion.widget.s$n r1 = new androidx.constraintlayout.motion.widget.s$n
            r1.<init>()
            goto L_0x00d4
        L_0x0099:
            androidx.constraintlayout.motion.widget.s$m r1 = new androidx.constraintlayout.motion.widget.s$m
            r1.<init>()
            goto L_0x00d4
        L_0x009f:
            androidx.constraintlayout.motion.widget.s$l r1 = new androidx.constraintlayout.motion.widget.s$l
            r1.<init>()
            goto L_0x00d4
        L_0x00a5:
            androidx.constraintlayout.motion.widget.s$j r1 = new androidx.constraintlayout.motion.widget.s$j
            r1.<init>()
            goto L_0x00d4
        L_0x00ab:
            androidx.constraintlayout.motion.widget.s$i r1 = new androidx.constraintlayout.motion.widget.s$i
            r1.<init>()
            goto L_0x00d4
        L_0x00b1:
            androidx.constraintlayout.motion.widget.s$d r1 = new androidx.constraintlayout.motion.widget.s$d
            r1.<init>()
            goto L_0x00d4
        L_0x00b7:
            androidx.constraintlayout.motion.widget.s$h r1 = new androidx.constraintlayout.motion.widget.s$h
            r1.<init>()
            goto L_0x00d4
        L_0x00bd:
            androidx.constraintlayout.motion.widget.s$g r1 = new androidx.constraintlayout.motion.widget.s$g
            r1.<init>()
            goto L_0x00d4
        L_0x00c3:
            androidx.constraintlayout.motion.widget.s$f r1 = new androidx.constraintlayout.motion.widget.s$f
            r1.<init>()
            goto L_0x00d4
        L_0x00c9:
            androidx.constraintlayout.motion.widget.s$c r1 = new androidx.constraintlayout.motion.widget.s$c
            r1.<init>()
            goto L_0x00d4
        L_0x00cf:
            androidx.constraintlayout.motion.widget.s$a r1 = new androidx.constraintlayout.motion.widget.s$a
            r1.<init>()
        L_0x00d4:
            r1.f2416g = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.s.a(java.lang.String, long):androidx.constraintlayout.motion.widget.s");
    }

    public void a(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.f2412c;
        int i4 = this.f2418i;
        iArr[i4] = i2;
        float[][] fArr = this.f2413d;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.f2411b = Math.max(this.f2411b, i3);
        this.f2418i++;
    }

    public void a(int i2) {
        int i3 = this.f2418i;
        if (i3 == 0) {
            new StringBuilder("Error no points added to ").append(this.f2414e);
            return;
        }
        k.a(this.f2412c, this.f2413d, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f2412c;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, new int[]{i5, 3});
        int i6 = 0;
        for (int i7 = 0; i7 < this.f2418i; i7++) {
            if (i7 > 0) {
                int[] iArr2 = this.f2412c;
                if (iArr2[i7] == iArr2[i7 - 1]) {
                }
            }
            dArr[i6] = ((double) this.f2412c[i7]) * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[][] fArr = this.f2413d;
            dArr3[0] = (double) fArr[i7][0];
            dArr2[i6][1] = (double) fArr[i7][1];
            dArr2[i6][2] = (double) fArr[i7][2];
            i6++;
        }
        this.f2410a = androidx.constraintlayout.motion.a.b.a(i2, dArr, dArr2);
    }

    static class c extends s {
        c() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2, j, view, eVar));
            }
            return this.f2415f;
        }
    }

    static class a extends s {
        a() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setAlpha(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class f extends s {
        f() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setRotation(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class g extends s {
        g() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setRotationX(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class h extends s {
        h() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setRotationY(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class d extends s {
        d() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            return this.f2415f;
        }

        public final boolean a(View view, e eVar, float f2, long j, double d2, double d3) {
            view.setRotation(a(f2, j, view, eVar) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.f2415f;
        }
    }

    static class i extends s {
        i() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setScaleX(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class j extends s {
        j() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setScaleY(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class l extends s {
        l() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setTranslationX(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class m extends s {
        m() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            view.setTranslationY(a(f2, j, view, eVar));
            return this.f2415f;
        }
    }

    static class n extends s {
        n() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2, j, view, eVar));
            }
            return this.f2415f;
        }
    }

    static class b extends s {

        /* renamed from: i  reason: collision with root package name */
        String f2419i;
        SparseArray<androidx.constraintlayout.widget.a> j;
        SparseArray<float[]> k = new SparseArray<>();
        float[] l;
        float[] m;

        public b(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
            this.f2419i = str.split(AppConstants.COMMA)[1];
            this.j = sparseArray;
        }

        public final void a(int i2) {
            int size = this.j.size();
            int a2 = this.j.valueAt(0).a();
            double[] dArr = new double[size];
            int i3 = a2 + 2;
            this.l = new float[i3];
            this.m = new float[a2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, new int[]{size, i3});
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.j.keyAt(i4);
                float[] valueAt = this.k.valueAt(i4);
                dArr[i4] = ((double) keyAt) * 0.01d;
                this.j.valueAt(i4).a(this.l);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.l;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                dArr2[i4][a2] = (double) valueAt[0];
                dArr2[i4][a2 + 1] = (double) valueAt[1];
            }
            this.f2410a = androidx.constraintlayout.motion.a.b.a(i2, dArr, dArr2);
        }

        public final void a(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public final void a(int i2, androidx.constraintlayout.widget.a aVar, float f2, int i3, float f3) {
            this.j.append(i2, aVar);
            this.k.append(i2, new float[]{f2, f3});
            this.f2411b = Math.max(this.f2411b, i3);
        }

        public final boolean a(View view, float f2, long j2, e eVar) {
            this.f2410a.a((double) f2, this.l);
            float[] fArr = this.l;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.f2416g;
            if (Float.isNaN(this.f2417h)) {
                this.f2417h = eVar.a(view, this.f2419i);
                if (Float.isNaN(this.f2417h)) {
                    this.f2417h = 0.0f;
                }
            }
            this.f2417h = (float) ((((double) this.f2417h) + ((((double) j3) * 1.0E-9d) * ((double) f3))) % 1.0d);
            this.f2416g = j2;
            float a2 = a(this.f2417h);
            this.f2415f = false;
            for (int i2 = 0; i2 < this.m.length; i2++) {
                this.f2415f |= ((double) this.l[i2]) != 0.0d;
                this.m[i2] = (this.l[i2] * a2) + f4;
            }
            this.j.valueAt(0).a(view, this.m);
            if (f3 != 0.0f) {
                this.f2415f = true;
            }
            return this.f2415f;
        }
    }

    static class e extends s {

        /* renamed from: i  reason: collision with root package name */
        boolean f2420i = false;

        e() {
        }

        public final boolean a(View view, float f2, long j, e eVar) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2, j, view, eVar));
            } else if (this.f2420i) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f2420i = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f2, j, view, eVar))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.f2415f;
        }
    }

    static class k {
        static void a(int[] iArr, float[][] fArr, int i2) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i2;
            iArr2[1] = 0;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int i7 = iArr[i6];
                    int i8 = i5;
                    int i9 = i8;
                    while (i8 < i6) {
                        if (iArr[i8] <= i7) {
                            a(iArr, fArr, i9, i8);
                            i9++;
                        }
                        i8++;
                    }
                    a(iArr, fArr, i9, i6);
                    int i10 = i3 + 1;
                    iArr2[i3] = i9 - 1;
                    int i11 = i10 + 1;
                    iArr2[i10] = i5;
                    int i12 = i11 + 1;
                    iArr2[i11] = i6;
                    i3 = i12 + 1;
                    iArr2[i12] = i9 + 1;
                }
            }
        }

        private static void a(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }
}
