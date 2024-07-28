package com.airbnb.lottie;

import android.graphics.Rect;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.c.h;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final n f5974a = new n();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<com.airbnb.lottie.c.c.d>> f5975b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, g> f5976c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, c> f5977d;

    /* renamed from: e  reason: collision with root package name */
    public List<h> f5978e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.a.h<com.airbnb.lottie.c.d> f5979f;

    /* renamed from: g  reason: collision with root package name */
    public androidx.a.d<com.airbnb.lottie.c.c.d> f5980g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.airbnb.lottie.c.c.d> f5981h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f5982i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    int n = 0;
    private final HashSet<String> o = new HashSet<>();

    public final void a(String str) {
        com.airbnb.lottie.f.d.a(str);
        this.o.add(str);
    }

    public final void a(int i2) {
        this.n += i2;
    }

    public final void a(boolean z) {
        this.f5974a.f6173a = z;
    }

    public final com.airbnb.lottie.c.c.d a(long j2) {
        return this.f5980g.a(j2, null);
    }

    public final float a() {
        return (float) ((long) ((b() / this.l) * 1000.0f));
    }

    public final h b(String str) {
        this.f5978e.size();
        for (int i2 = 0; i2 < this.f5978e.size(); i2++) {
            h hVar = this.f5978e.get(i2);
            boolean z = true;
            if (!hVar.f5969b.equalsIgnoreCase(str) && (!hVar.f5969b.endsWith(h.f5968a) || !hVar.f5969b.substring(0, hVar.f5969b.length() - 1).equalsIgnoreCase(str))) {
                z = false;
            }
            if (z) {
                return hVar;
            }
        }
        return null;
    }

    public final float b() {
        return this.k - this.j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (com.airbnb.lottie.c.c.d a2 : this.f5981h) {
            sb.append(a2.a("\t"));
        }
        return sb.toString();
    }
}
