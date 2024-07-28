package androidx.constraintlayout.a.a.a;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public d f2027a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2028b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2029c = false;

    /* renamed from: d  reason: collision with root package name */
    p f2030d;

    /* renamed from: e  reason: collision with root package name */
    a f2031e = a.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    int f2032f;

    /* renamed from: g  reason: collision with root package name */
    public int f2033g;

    /* renamed from: h  reason: collision with root package name */
    int f2034h = 1;

    /* renamed from: i  reason: collision with root package name */
    g f2035i = null;
    public boolean j = false;
    List<d> k = new ArrayList();
    List<f> l = new ArrayList();

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f2030d = pVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2030d.f2066d.ao);
        sb.append(AppConstants.COLON);
        sb.append(this.f2031e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.f2033g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public void a(int i2) {
        if (!this.j) {
            this.j = true;
            this.f2033g = i2;
            for (d d2 : this.k) {
                d2.d();
            }
        }
    }

    public final void d() {
        for (f fVar : this.l) {
            if (!fVar.j) {
                return;
            }
        }
        this.f2029c = true;
        d dVar = this.f2027a;
        if (dVar != null) {
            dVar.d();
        }
        if (this.f2028b) {
            this.f2030d.d();
            return;
        }
        f fVar2 = null;
        int i2 = 0;
        for (f next : this.l) {
            if (!(next instanceof g)) {
                i2++;
                fVar2 = next;
            }
        }
        if (fVar2 != null && i2 == 1 && fVar2.j) {
            g gVar = this.f2035i;
            if (gVar != null) {
                if (gVar.j) {
                    this.f2032f = this.f2034h * this.f2035i.f2033g;
                } else {
                    return;
                }
            }
            a(fVar2.f2033g + this.f2032f);
        }
        d dVar2 = this.f2027a;
        if (dVar2 != null) {
            dVar2.d();
        }
    }

    public final void a(d dVar) {
        this.k.add(dVar);
        if (this.j) {
            dVar.d();
        }
    }

    public final void a() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.f2033g = 0;
        this.f2029c = false;
        this.f2028b = false;
    }
}
