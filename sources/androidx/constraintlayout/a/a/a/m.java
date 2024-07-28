package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

final class m {

    /* renamed from: a  reason: collision with root package name */
    public static int f2039a;

    /* renamed from: b  reason: collision with root package name */
    public int f2040b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2041c = false;

    /* renamed from: d  reason: collision with root package name */
    p f2042d = null;

    /* renamed from: e  reason: collision with root package name */
    p f2043e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<p> f2044f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    int f2045g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f2046h;

    public m(p pVar, int i2) {
        int i3 = f2039a;
        this.f2045g = i3;
        f2039a = i3 + 1;
        this.f2042d = pVar;
        this.f2043e = pVar;
        this.f2046h = i2;
    }

    private long a(f fVar, long j) {
        p pVar = fVar.f2030d;
        if (pVar instanceof k) {
            return j;
        }
        int size = fVar.k.size();
        long j2 = j;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2030d != pVar) {
                    j2 = Math.max(j2, a(fVar2, ((long) fVar2.f2032f) + j));
                }
            }
        }
        if (fVar != pVar.j) {
            return j2;
        }
        long b2 = j + pVar.b();
        return Math.max(Math.max(j2, a(pVar.k, b2)), b2 - ((long) pVar.k.f2032f));
    }

    private long b(f fVar, long j) {
        p pVar = fVar.f2030d;
        if (pVar instanceof k) {
            return j;
        }
        int size = fVar.k.size();
        long j2 = j;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f2030d != pVar) {
                    j2 = Math.min(j2, b(fVar2, ((long) fVar2.f2032f) + j));
                }
            }
        }
        if (fVar != pVar.k) {
            return j2;
        }
        long b2 = j - pVar.b();
        return Math.min(Math.min(j2, b(pVar.j, b2)), b2 - ((long) pVar.j.f2032f));
    }

    public final long a(f fVar, int i2) {
        long j;
        int i3;
        p pVar = this.f2042d;
        long j2 = 0;
        if (pVar instanceof c) {
            if (((c) pVar).f2070h != i2) {
                return 0;
            }
        } else if (i2 == 0) {
            if (!(pVar instanceof l)) {
                return 0;
            }
        } else if (!(pVar instanceof n)) {
            return 0;
        }
        f fVar2 = i2 == 0 ? fVar.f2100i.j : fVar.j.j;
        f fVar3 = i2 == 0 ? fVar.f2100i.k : fVar.j.k;
        boolean contains = this.f2042d.j.l.contains(fVar2);
        boolean contains2 = this.f2042d.k.l.contains(fVar3);
        long b2 = this.f2042d.b();
        if (contains && contains2) {
            long a2 = a(this.f2042d.j, 0);
            long b3 = b(this.f2042d.k, 0);
            long j3 = a2 - b2;
            if (j3 >= ((long) (-this.f2042d.k.f2032f))) {
                j3 += (long) this.f2042d.k.f2032f;
            }
            long j4 = ((-b3) - b2) - ((long) this.f2042d.j.f2032f);
            if (j4 >= ((long) this.f2042d.j.f2032f)) {
                j4 -= (long) this.f2042d.j.f2032f;
            }
            float d2 = this.f2042d.f2066d.d(i2);
            if (d2 > 0.0f) {
                j2 = (long) ((((float) j4) / d2) + (((float) j3) / (1.0f - d2)));
            }
            float f2 = (float) j2;
            j = ((long) this.f2042d.j.f2032f) + ((long) ((f2 * d2) + 0.5f)) + b2 + ((long) ((f2 * (1.0f - d2)) + 0.5f));
            i3 = this.f2042d.k.f2032f;
        } else if (contains) {
            return Math.max(a(this.f2042d.j, (long) this.f2042d.j.f2032f), ((long) this.f2042d.j.f2032f) + b2);
        } else {
            if (contains2) {
                return Math.max(-b(this.f2042d.k, (long) this.f2042d.k.f2032f), ((long) (-this.f2042d.k.f2032f)) + b2);
            }
            j = ((long) this.f2042d.j.f2032f) + this.f2042d.b();
            i3 = this.f2042d.k.f2032f;
        }
        return j - ((long) i3);
    }
}
