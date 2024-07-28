package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.a.i;
import androidx.constraintlayout.a.a.a.o;
import androidx.constraintlayout.a.h;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<d> f2082a = null;

    /* renamed from: b  reason: collision with root package name */
    int f2083b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2084c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2085d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2086e;

    /* renamed from: f  reason: collision with root package name */
    public d f2087f;

    /* renamed from: g  reason: collision with root package name */
    public int f2088g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f2089h = -1;

    /* renamed from: i  reason: collision with root package name */
    public h f2090i;

    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public final void a(int i2, ArrayList<o> arrayList, o oVar) {
        HashSet<d> hashSet = this.f2082a;
        if (hashSet != null) {
            Iterator<d> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                i.a(it2.next().f2085d, i2, arrayList, oVar);
            }
        }
    }

    public final boolean a() {
        HashSet<d> hashSet = this.f2082a;
        if (hashSet != null && hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        HashSet<d> hashSet = this.f2082a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (it2.next().h().g()) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i2) {
        this.f2083b = i2;
        this.f2084c = true;
    }

    public final int c() {
        if (!this.f2084c) {
            return 0;
        }
        return this.f2083b;
    }

    public d(e eVar, a aVar) {
        this.f2085d = eVar;
        this.f2086e = aVar;
    }

    public final void d() {
        h hVar = this.f2090i;
        if (hVar == null) {
            this.f2090i = new h(h.a.UNRESTRICTED);
        } else {
            hVar.b();
        }
    }

    public final int e() {
        d dVar;
        if (this.f2085d.an == 8) {
            return 0;
        }
        if (this.f2089h < 0 || (dVar = this.f2087f) == null || dVar.f2085d.an != 8) {
            return this.f2088g;
        }
        return this.f2089h;
    }

    public final void f() {
        HashSet<d> hashSet;
        d dVar = this.f2087f;
        if (!(dVar == null || (hashSet = dVar.f2082a) == null)) {
            hashSet.remove(this);
            if (this.f2087f.f2082a.size() == 0) {
                this.f2087f.f2082a = null;
            }
        }
        this.f2082a = null;
        this.f2087f = null;
        this.f2088g = 0;
        this.f2089h = -1;
        this.f2084c = false;
        this.f2083b = 0;
    }

    public final boolean a(d dVar, int i2, int i3, boolean z) {
        if (dVar == null) {
            f();
            return true;
        } else if (!z && !a(dVar)) {
            return false;
        } else {
            this.f2087f = dVar;
            d dVar2 = this.f2087f;
            if (dVar2.f2082a == null) {
                dVar2.f2082a = new HashSet<>();
            }
            HashSet<d> hashSet = this.f2087f.f2082a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            if (i2 > 0) {
                this.f2088g = i2;
            } else {
                this.f2088g = 0;
            }
            this.f2089h = i3;
            return true;
        }
    }

    public final boolean a(d dVar, int i2) {
        return a(dVar, i2, -1, false);
    }

    public final boolean g() {
        return this.f2087f != null;
    }

    public final void b(int i2) {
        if (g()) {
            this.f2089h = i2;
        }
    }

    public final String toString() {
        return this.f2085d.ao + AppConstants.COLON + this.f2086e.toString();
    }

    public final d h() {
        switch (this.f2086e) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
            case LEFT:
                return this.f2085d.L;
            case RIGHT:
                return this.f2085d.J;
            case TOP:
                return this.f2085d.M;
            case BOTTOM:
                return this.f2085d.K;
            default:
                throw new AssertionError(this.f2086e.name());
        }
    }

    public final boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        a aVar = dVar.f2086e;
        a aVar2 = this.f2086e;
        if (aVar != aVar2) {
            switch (this.f2086e) {
                case CENTER:
                    if (aVar == a.BASELINE || aVar == a.CENTER_X || aVar == a.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    boolean z = aVar == a.LEFT || aVar == a.RIGHT;
                    if (dVar.f2085d instanceof h) {
                        return z || aVar == a.CENTER_X;
                    }
                    return z;
                case TOP:
                case BOTTOM:
                    boolean z2 = aVar == a.TOP || aVar == a.BOTTOM;
                    if (dVar.f2085d instanceof h) {
                        return z2 || aVar == a.CENTER_Y;
                    }
                    return z2;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.f2086e.name());
            }
        } else if (aVar2 != a.BASELINE || (dVar.f2085d.E && this.f2085d.E)) {
            return true;
        } else {
            return false;
        }
    }
}
