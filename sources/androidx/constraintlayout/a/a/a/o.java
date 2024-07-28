package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.b;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class o {

    /* renamed from: b  reason: collision with root package name */
    static int f2050b;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<e> f2051a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    int f2052c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2053d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f2054e = 0;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<a> f2055f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f2056g = -1;

    public o(int i2) {
        int i3 = f2050b;
        f2050b = i3 + 1;
        this.f2052c = i3;
        this.f2054e = i2;
    }

    public final boolean a(e eVar) {
        if (this.f2051a.contains(eVar)) {
            return false;
        }
        this.f2051a.add(eVar);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f2054e;
        sb.append(i2 == 0 ? "Horizontal" : i2 == 1 ? "Vertical" : i2 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.f2052c);
        sb.append("] <");
        String sb2 = sb.toString();
        Iterator<e> it2 = this.f2051a.iterator();
        while (it2.hasNext()) {
            sb2 = sb2 + " " + it2.next().ao;
        }
        return sb2 + " >";
    }

    public final void a(int i2, o oVar) {
        Iterator<e> it2 = this.f2051a.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            oVar.a(next);
            if (i2 == 0) {
                next.aJ = oVar.f2052c;
            } else {
                next.aK = oVar.f2052c;
            }
        }
        this.f2056g = oVar.f2052c;
    }

    public final int a(d dVar, int i2) {
        if (this.f2051a.size() == 0) {
            return 0;
        }
        return a(dVar, this.f2051a, i2);
    }

    private int a(d dVar, ArrayList<e> arrayList, int i2) {
        int b2;
        int b3;
        f fVar = (f) arrayList.get(0).V;
        dVar.b();
        fVar.a(dVar, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).a(dVar, false);
        }
        if (i2 == 0 && fVar.aR > 0) {
            b.a(fVar, dVar, arrayList, 0);
        }
        if (i2 == 1 && fVar.aS > 0) {
            b.a(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f2055f = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f2055f.add(new a(arrayList.get(i4), i2));
        }
        if (i2 == 0) {
            b2 = d.b((Object) fVar.J);
            b3 = d.b((Object) fVar.L);
            dVar.b();
        } else {
            b2 = d.b((Object) fVar.K);
            b3 = d.b((Object) fVar.M);
            dVar.b();
        }
        return b3 - b2;
    }

    public final void a(ArrayList<o> arrayList) {
        int size = this.f2051a.size();
        if (this.f2056g != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                o oVar = arrayList.get(i2);
                if (this.f2056g == oVar.f2052c) {
                    a(this.f2054e, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<e> f2057a;

        /* renamed from: b  reason: collision with root package name */
        int f2058b;

        /* renamed from: c  reason: collision with root package name */
        int f2059c;

        /* renamed from: d  reason: collision with root package name */
        int f2060d;

        /* renamed from: e  reason: collision with root package name */
        int f2061e;

        /* renamed from: f  reason: collision with root package name */
        int f2062f;

        /* renamed from: g  reason: collision with root package name */
        int f2063g;

        public a(e eVar, int i2) {
            this.f2057a = new WeakReference<>(eVar);
            this.f2058b = d.b((Object) eVar.J);
            this.f2059c = d.b((Object) eVar.K);
            this.f2060d = d.b((Object) eVar.L);
            this.f2061e = d.b((Object) eVar.M);
            this.f2062f = d.b((Object) eVar.N);
            this.f2063g = i2;
        }
    }
}
