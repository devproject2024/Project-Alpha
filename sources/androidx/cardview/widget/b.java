package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.View;

final class b implements e {
    public final void a() {
    }

    b() {
    }

    public final void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        dVar.a(new f(colorStateList, f2));
        View d2 = dVar.d();
        d2.setClipToOutline(true);
        d2.setElevation(f3);
        b(dVar, f4);
    }

    public final void a(d dVar, float f2) {
        f j = j(dVar);
        if (f2 != j.f1973a) {
            j.f1973a = f2;
            j.a((Rect) null);
            j.invalidateSelf();
        }
    }

    public final void b(d dVar, float f2) {
        j(dVar).a(f2, dVar.a(), dVar.b());
        f(dVar);
    }

    public final float a(d dVar) {
        return j(dVar).f1974b;
    }

    public final float d(d dVar) {
        return j(dVar).f1973a;
    }

    public final void c(d dVar, float f2) {
        dVar.d().setElevation(f2);
    }

    public final float e(d dVar) {
        return dVar.d().getElevation();
    }

    public final void f(d dVar) {
        if (!dVar.a()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float f2 = j(dVar).f1974b;
        float f3 = j(dVar).f1973a;
        int ceil = (int) Math.ceil((double) g.b(f2, f3, dVar.b()));
        int ceil2 = (int) Math.ceil((double) g.a(f2, f3, dVar.b()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }

    public final void a(d dVar, ColorStateList colorStateList) {
        f j = j(dVar);
        j.a(colorStateList);
        j.invalidateSelf();
    }

    public final ColorStateList i(d dVar) {
        return j(dVar).f1975c;
    }

    private static f j(d dVar) {
        return (f) dVar.c();
    }

    public final float b(d dVar) {
        return j(dVar).f1973a * 2.0f;
    }

    public final float c(d dVar) {
        return j(dVar).f1973a * 2.0f;
    }

    public final void g(d dVar) {
        b(dVar, j(dVar).f1974b);
    }

    public final void h(d dVar) {
        b(dVar, j(dVar).f1974b);
    }
}
