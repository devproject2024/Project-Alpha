package androidx.constraintlayout.a;

import java.util.Arrays;
import java.util.HashSet;

public final class h {
    private static int q = 1;
    private static int r = 1;
    private static int s = 1;
    private static int t = 1;
    private static int u = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2166a;

    /* renamed from: b  reason: collision with root package name */
    public int f2167b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2168c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2169d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f2170e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2171f = false;

    /* renamed from: g  reason: collision with root package name */
    float[] f2172g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    float[] f2173h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    a f2174i;
    b[] j = new b[16];
    int k = 0;
    public int l = 0;
    boolean m = false;
    int n = -1;
    float o = 0.0f;
    HashSet<b> p = null;
    private String v;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void a() {
        r++;
    }

    public h(a aVar) {
        this.f2174i = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.k;
            if (i2 >= i3) {
                b[] bVarArr = this.j;
                if (i3 >= bVarArr.length) {
                    this.j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.j;
                int i4 = this.k;
                bVarArr2[i4] = bVar;
                this.k = i4 + 1;
                return;
            } else if (this.j[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.j[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.j;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.k--;
                return;
            }
            i3++;
        }
    }

    public final void a(d dVar, b bVar) {
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3].a(dVar, bVar, false);
        }
        this.k = 0;
    }

    public final void a(d dVar, float f2) {
        this.f2170e = f2;
        this.f2171f = true;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int i2 = this.k;
        this.f2168c = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3].a(dVar, this, false);
        }
        this.k = 0;
    }

    public final void b() {
        this.v = null;
        this.f2174i = a.UNKNOWN;
        this.f2169d = 0;
        this.f2167b = -1;
        this.f2168c = -1;
        this.f2170e = 0.0f;
        this.f2171f = false;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int i2 = this.k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.j[i3] = null;
        }
        this.k = 0;
        this.l = 0;
        this.f2166a = false;
        Arrays.fill(this.f2173h, 0.0f);
    }

    public final String toString() {
        if (this.v != null) {
            return "" + this.v;
        }
        return "" + this.f2167b;
    }
}
