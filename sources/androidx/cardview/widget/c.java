package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.g;

class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f1971a = new RectF();

    public final void g(d dVar) {
    }

    c() {
    }

    public void a() {
        g.f1982a = new g.a() {
            public final void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f3 = 2.0f * f2;
                float width = (rectF.width() - f3) - 1.0f;
                float height = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    float f5 = -f4;
                    c.this.f1971a.set(f5, f5, f4, f4);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f4, rectF2.top + f4);
                    Paint paint2 = paint;
                    canvas.drawArc(c.this.f1971a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1971a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1971a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1971a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f4) - 1.0f, rectF2.top, (rectF2.right - f4) + 1.0f, rectF2.top + f4, paint2);
                    canvas.drawRect((rectF2.left + f4) - 1.0f, rectF2.bottom - f4, (rectF2.right - f4) + 1.0f, rectF2.bottom, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f2, rectF2.right, rectF2.bottom - f2, paint);
            }
        };
    }

    public final void f(d dVar) {
        Rect rect = new Rect();
        j(dVar).getPadding(rect);
        dVar.a((int) Math.ceil((double) j(dVar).a()), (int) Math.ceil((double) j(dVar).b()));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void h(d dVar) {
        j(dVar).a(dVar.b());
        f(dVar);
    }

    public final void a(d dVar, ColorStateList colorStateList) {
        g j = j(dVar);
        j.a(colorStateList);
        j.invalidateSelf();
    }

    public final ColorStateList i(d dVar) {
        return j(dVar).f1987e;
    }

    public final void a(d dVar, float f2) {
        g j = j(dVar);
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (j.f1984b != f3) {
                j.f1984b = f3;
                j.f1988f = true;
                j.invalidateSelf();
            }
            f(dVar);
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    public final float d(d dVar) {
        return j(dVar).f1984b;
    }

    public final void c(d dVar, float f2) {
        g j = j(dVar);
        j.a(f2, j.f1985c);
    }

    public final float e(d dVar) {
        return j(dVar).f1986d;
    }

    public final void b(d dVar, float f2) {
        g j = j(dVar);
        j.a(j.f1986d, f2);
        f(dVar);
    }

    public final float a(d dVar) {
        return j(dVar).f1985c;
    }

    public final float b(d dVar) {
        return j(dVar).a();
    }

    public final float c(d dVar) {
        return j(dVar).b();
    }

    private static g j(d dVar) {
        return (g) dVar.c();
    }

    public final void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        g gVar = new g(context.getResources(), colorStateList, f2, f3, f4);
        gVar.a(dVar.b());
        dVar.a(gVar);
        f(dVar);
    }
}
