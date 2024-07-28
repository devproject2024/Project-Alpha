package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.motion.a.c;
import androidx.constraintlayout.motion.widget.r;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;

final class m implements Comparable<m> {
    static String[] r = {CLPConstants.ARGUMENT_KEY_POSITION, "x", "y", StringSet.width, StringSet.height, "pathRotate"};
    private float A;
    private float B;
    private float C;

    /* renamed from: a  reason: collision with root package name */
    float f2351a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    int f2352b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2353c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2354d = false;

    /* renamed from: e  reason: collision with root package name */
    float f2355e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    float f2356f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    float f2357g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f2358h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f2359i = 1.0f;
    float j = 1.0f;
    float k = Float.NaN;
    float l = Float.NaN;
    float m = 0.0f;
    float n = 0.0f;
    float o = 0.0f;
    float p = Float.NaN;
    float q = Float.NaN;
    LinkedHashMap<String, a> s = new LinkedHashMap<>();
    int t = 0;
    double[] u = new double[18];
    double[] v = new double[18];
    private c w;
    private int x = 0;
    private float y;
    private float z;

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.compare(this.y, ((m) obj).y);
    }

    static boolean a(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, float f4, float f5) {
        this.z = f2;
        this.A = f3;
        this.B = f4;
        this.C = f5;
    }

    public final void a(HashMap<String, r> hashMap, int i2) {
        for (String next : hashMap.keySet()) {
            r rVar = hashMap.get(next);
            char c2 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c2 = 12;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c2 = 13;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals(H5Param.PROGRESS)) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -760884510:
                    if (next.equals("transformPivotX")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -760884509:
                    if (next.equals("transformPivotY")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            float f2 = 1.0f;
            float f3 = 0.0f;
            switch (c2) {
                case 0:
                    if (!Float.isNaN(this.f2351a)) {
                        f2 = this.f2351a;
                    }
                    rVar.a(i2, f2);
                    break;
                case 1:
                    if (!Float.isNaN(this.f2355e)) {
                        f3 = this.f2355e;
                    }
                    rVar.a(i2, f3);
                    break;
                case 2:
                    if (!Float.isNaN(this.f2356f)) {
                        f3 = this.f2356f;
                    }
                    rVar.a(i2, f3);
                    break;
                case 3:
                    if (!Float.isNaN(this.f2357g)) {
                        f3 = this.f2357g;
                    }
                    rVar.a(i2, f3);
                    break;
                case 4:
                    if (!Float.isNaN(this.f2358h)) {
                        f3 = this.f2358h;
                    }
                    rVar.a(i2, f3);
                    break;
                case 5:
                    if (!Float.isNaN(this.k)) {
                        f3 = this.k;
                    }
                    rVar.a(i2, f3);
                    break;
                case 6:
                    if (!Float.isNaN(this.l)) {
                        f3 = this.l;
                    }
                    rVar.a(i2, f3);
                    break;
                case 7:
                    if (!Float.isNaN(this.p)) {
                        f3 = this.p;
                    }
                    rVar.a(i2, f3);
                    break;
                case 8:
                    if (!Float.isNaN(this.q)) {
                        f3 = this.q;
                    }
                    rVar.a(i2, f3);
                    break;
                case 9:
                    if (!Float.isNaN(this.f2359i)) {
                        f2 = this.f2359i;
                    }
                    rVar.a(i2, f2);
                    break;
                case 10:
                    if (!Float.isNaN(this.j)) {
                        f2 = this.j;
                    }
                    rVar.a(i2, f2);
                    break;
                case 11:
                    if (!Float.isNaN(this.m)) {
                        f3 = this.m;
                    }
                    rVar.a(i2, f3);
                    break;
                case 12:
                    if (!Float.isNaN(this.n)) {
                        f3 = this.n;
                    }
                    rVar.a(i2, f3);
                    break;
                case 13:
                    if (!Float.isNaN(this.o)) {
                        f3 = this.o;
                    }
                    rVar.a(i2, f3);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        break;
                    } else {
                        String str = next.split(AppConstants.COMMA)[1];
                        if (!this.s.containsKey(str)) {
                            break;
                        } else {
                            a aVar = this.s.get(str);
                            if (!(rVar instanceof r.b)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(next);
                                sb.append(" splineSet not a CustomSet frame = ");
                                sb.append(i2);
                                sb.append(", value");
                                sb.append(aVar.b());
                                sb.append(rVar);
                                break;
                            } else {
                                ((r.b) rVar).a(i2, aVar);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public final void a(e eVar, androidx.constraintlayout.widget.c cVar, int i2) {
        a((float) eVar.l(), (float) eVar.m(), (float) eVar.n(), (float) eVar.o());
        c.a e2 = cVar.e(i2);
        this.f2352b = e2.f2539b.f2563c;
        this.f2353c = e2.f2539b.f2562b;
        this.f2351a = (e2.f2539b.f2562b == 0 || this.f2352b != 0) ? e2.f2539b.f2564d : 0.0f;
        this.f2354d = e2.f2542e.l;
        this.f2355e = e2.f2542e.m;
        this.f2356f = e2.f2542e.f2567b;
        this.f2357g = e2.f2542e.f2568c;
        this.f2358h = e2.f2542e.f2569d;
        this.f2359i = e2.f2542e.f2570e;
        this.j = e2.f2542e.f2571f;
        this.k = e2.f2542e.f2572g;
        this.l = e2.f2542e.f2573h;
        this.m = e2.f2542e.f2574i;
        this.n = e2.f2542e.j;
        this.o = e2.f2542e.k;
        this.w = androidx.constraintlayout.motion.a.c.a(e2.f2540c.f2556c);
        this.p = e2.f2540c.f2560g;
        this.x = e2.f2540c.f2558e;
        this.q = e2.f2539b.f2565e;
        for (String next : e2.f2543f.keySet()) {
            a aVar = e2.f2543f.get(next);
            if (aVar.f2508b != a.C0034a.STRING_TYPE) {
                this.s.put(next, aVar);
            }
        }
    }
}
