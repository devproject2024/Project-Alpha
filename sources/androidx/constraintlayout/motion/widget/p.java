package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.a.c;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.LinkedHashMap;

public final class p implements Comparable<p> {

    /* renamed from: a  reason: collision with root package name */
    static String[] f2369a = {CLPConstants.ARGUMENT_KEY_POSITION, "x", "y", StringSet.width, StringSet.height, "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    c f2370b;

    /* renamed from: c  reason: collision with root package name */
    int f2371c = 0;

    /* renamed from: d  reason: collision with root package name */
    float f2372d;

    /* renamed from: e  reason: collision with root package name */
    float f2373e;

    /* renamed from: f  reason: collision with root package name */
    public float f2374f;

    /* renamed from: g  reason: collision with root package name */
    public float f2375g;

    /* renamed from: h  reason: collision with root package name */
    public float f2376h;

    /* renamed from: i  reason: collision with root package name */
    public float f2377i;
    float j = Float.NaN;
    float k = Float.NaN;
    int l = c.f2299a;
    LinkedHashMap<String, a> m = new LinkedHashMap<>();
    int n = 0;
    double[] o = new double[18];
    double[] p = new double[18];

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.compare(this.f2373e, ((p) obj).f2373e);
    }

    public p() {
    }

    public p(int i2, int i3, i iVar, p pVar, p pVar2) {
        float f2;
        int i4;
        i iVar2 = iVar;
        p pVar3 = pVar;
        p pVar4 = pVar2;
        int i5 = iVar2.p;
        if (i5 == 1) {
            p pVar5 = pVar3;
            float f3 = ((float) iVar2.f2300b) / 100.0f;
            this.f2372d = f3;
            this.f2371c = iVar2.f2341i;
            float f4 = Float.isNaN(iVar2.j) ? f3 : iVar2.j;
            float f5 = Float.isNaN(iVar2.k) ? f3 : iVar2.k;
            float f6 = pVar4.f2376h - pVar5.f2376h;
            float f7 = pVar4.f2377i - pVar5.f2377i;
            this.f2373e = this.f2372d;
            f3 = !Float.isNaN(iVar2.l) ? iVar2.l : f3;
            float f8 = pVar5.f2374f;
            float f9 = pVar5.f2376h;
            float f10 = pVar5.f2375g;
            float f11 = pVar5.f2377i;
            float f12 = (pVar4.f2374f + (pVar4.f2376h / 2.0f)) - ((f9 / 2.0f) + f8);
            float f13 = (pVar4.f2375g + (pVar4.f2377i / 2.0f)) - (f10 + (f11 / 2.0f));
            float f14 = f12 * f3;
            float f15 = f6 * f4;
            float f16 = f15 / 2.0f;
            this.f2374f = (float) ((int) ((f8 + f14) - f16));
            float f17 = f3 * f13;
            float f18 = f7 * f5;
            float f19 = f18 / 2.0f;
            this.f2375g = (float) ((int) ((f10 + f17) - f19));
            this.f2376h = (float) ((int) (f9 + f15));
            this.f2377i = (float) ((int) (f11 + f18));
            float f20 = Float.isNaN(iVar2.m) ? 0.0f : iVar2.m;
            this.n = 1;
            p pVar6 = pVar;
            this.f2374f = (float) ((int) ((pVar6.f2374f + f14) - f16));
            this.f2375g = (float) ((int) ((pVar6.f2375g + f17) - f19));
            this.f2374f += (-f13) * f20;
            this.f2375g += f12 * f20;
            this.f2370b = c.a(iVar2.f2339g);
            this.l = iVar2.f2340h;
        } else if (i5 != 2) {
            float f21 = ((float) iVar2.f2300b) / 100.0f;
            this.f2372d = f21;
            this.f2371c = iVar2.f2341i;
            float f22 = Float.isNaN(iVar2.j) ? f21 : iVar2.j;
            float f23 = Float.isNaN(iVar2.k) ? f21 : iVar2.k;
            float f24 = pVar4.f2376h;
            float f25 = pVar3.f2376h;
            float f26 = pVar4.f2377i;
            float f27 = pVar3.f2377i;
            this.f2373e = this.f2372d;
            float f28 = pVar3.f2374f;
            float f29 = pVar3.f2375g;
            float f30 = (pVar4.f2374f + (f24 / 2.0f)) - (f28 + (f25 / 2.0f));
            float f31 = (pVar4.f2375g + (f26 / 2.0f)) - (f29 + (f27 / 2.0f));
            float f32 = (f24 - f25) * f22;
            float f33 = f32 / 2.0f;
            this.f2374f = (float) ((int) ((f28 + (f30 * f21)) - f33));
            float f34 = (f26 - f27) * f23;
            float f35 = f34 / 2.0f;
            this.f2375g = (float) ((int) ((f29 + (f31 * f21)) - f35));
            this.f2376h = (float) ((int) (f25 + f32));
            this.f2377i = (float) ((int) (f27 + f34));
            float f36 = Float.isNaN(iVar2.l) ? f21 : iVar2.l;
            float f37 = Float.isNaN(iVar2.o) ? 0.0f : iVar2.o;
            f21 = !Float.isNaN(iVar2.m) ? iVar2.m : f21;
            if (Float.isNaN(iVar2.n)) {
                i4 = 2;
                f2 = 0.0f;
            } else {
                f2 = iVar2.n;
                i4 = 2;
            }
            this.n = i4;
            p pVar7 = pVar;
            this.f2374f = (float) ((int) (((pVar7.f2374f + (f36 * f30)) + (f2 * f31)) - f33));
            this.f2375g = (float) ((int) (((pVar7.f2375g + (f30 * f37)) + (f31 * f21)) - f35));
            this.f2370b = c.a(iVar2.f2339g);
            this.l = iVar2.f2340h;
        } else {
            p pVar8 = pVar3;
            float f38 = ((float) iVar2.f2300b) / 100.0f;
            this.f2372d = f38;
            this.f2371c = iVar2.f2341i;
            float f39 = Float.isNaN(iVar2.j) ? f38 : iVar2.j;
            float f40 = Float.isNaN(iVar2.k) ? f38 : iVar2.k;
            float f41 = pVar4.f2376h;
            float f42 = pVar8.f2376h;
            float f43 = pVar4.f2377i;
            float f44 = pVar8.f2377i;
            this.f2373e = this.f2372d;
            float f45 = pVar8.f2374f;
            float f46 = pVar8.f2375g;
            float f47 = pVar4.f2374f + (f41 / 2.0f);
            float f48 = pVar4.f2375g + (f43 / 2.0f);
            float f49 = (f41 - f42) * f39;
            this.f2374f = (float) ((int) ((f45 + ((f47 - ((f42 / 2.0f) + f45)) * f38)) - (f49 / 2.0f)));
            float f50 = (f43 - f44) * f40;
            this.f2375g = (float) ((int) ((f46 + ((f48 - (f46 + (f44 / 2.0f))) * f38)) - (f50 / 2.0f)));
            this.f2376h = (float) ((int) (f42 + f49));
            this.f2377i = (float) ((int) (f44 + f50));
            this.n = 3;
            i iVar3 = iVar;
            if (!Float.isNaN(iVar3.l)) {
                this.f2374f = (float) ((int) (iVar3.l * ((float) ((int) (((float) i2) - this.f2376h)))));
            }
            if (!Float.isNaN(iVar3.m)) {
                this.f2375g = (float) ((int) (iVar3.m * ((float) ((int) (((float) i3) - this.f2377i)))));
            }
            this.f2370b = c.a(iVar3.f2339g);
            this.l = iVar3.f2340h;
        }
    }

    static boolean a(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* access modifiers changed from: package-private */
    public final void a(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.f2374f;
        float f3 = this.f2375g;
        float f4 = this.f2376h;
        float f5 = this.f2377i;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public static void a(float f2, float f3, float[] fArr, int[] iArr, double[] dArr) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 != 0) {
                if (i3 == 1) {
                    f4 = f8;
                } else if (i3 == 2) {
                    f6 = f8;
                } else if (i3 == 3) {
                    f5 = f8;
                } else if (i3 == 4) {
                    f7 = f8;
                }
            }
        }
        float f9 = f4 - ((f5 * 0.0f) / 2.0f);
        float f10 = f6 - ((f7 * 0.0f) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void a(double[] dArr, int[] iArr) {
        float[] fArr = {this.f2373e, this.f2374f, this.f2375g, this.f2376h, this.f2377i, this.j};
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < 6) {
                dArr[i2] = (double) fArr[iArr[i3]];
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(String str, double[] dArr, int i2) {
        a aVar = this.m.get(str);
        int i3 = 0;
        if (aVar.a() == 1) {
            dArr[0] = (double) aVar.b();
            return 1;
        }
        int a2 = aVar.a();
        float[] fArr = new float[a2];
        aVar.a(fArr);
        while (i3 < a2) {
            dArr[i2] = (double) fArr[i3];
            i3++;
            i2++;
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, float f4, float f5) {
        this.f2374f = f2;
        this.f2375g = f3;
        this.f2376h = f4;
        this.f2377i = f5;
    }

    public final void a(c.a aVar) {
        this.f2370b = androidx.constraintlayout.motion.a.c.a(aVar.f2540c.f2556c);
        this.l = aVar.f2540c.f2557d;
        this.j = aVar.f2540c.f2560g;
        this.f2371c = aVar.f2540c.f2558e;
        this.k = aVar.f2539b.f2565e;
        for (String next : aVar.f2543f.keySet()) {
            a aVar2 = aVar.f2543f.get(next);
            if (aVar2.f2508b != a.C0034a.STRING_TYPE) {
                this.m.put(next, aVar2);
            }
        }
    }
}
