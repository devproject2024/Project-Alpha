package com.airbnb.lottie.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;

public final class c extends a {

    /* renamed from: h  reason: collision with root package name */
    private final Paint f5939h = new a(3);

    /* renamed from: i  reason: collision with root package name */
    private final Rect f5940i = new Rect();
    private final Rect j = new Rect();
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> k;

    c(f fVar, d dVar) {
        super(fVar, dVar);
    }

    public final void b(Canvas canvas, Matrix matrix, int i2) {
        Bitmap e2 = e();
        if (e2 != null && !e2.isRecycled()) {
            float a2 = h.a();
            this.f5939h.setAlpha(i2);
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.k;
            if (aVar != null) {
                this.f5939h.setColorFilter(aVar.f());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f5940i.set(0, 0, e2.getWidth(), e2.getHeight());
            this.j.set(0, 0, (int) (((float) e2.getWidth()) * a2), (int) (((float) e2.getHeight()) * a2));
            canvas.drawBitmap(e2, this.f5940i, this.j, this.f5939h);
            canvas.restore();
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Bitmap e2 = e();
        if (e2 != null) {
            rectF.set(0.0f, 0.0f, ((float) e2.getWidth()) * h.a(), ((float) e2.getHeight()) * h.a());
            this.f5924a.mapRect(rectF);
        }
    }

    private Bitmap e() {
        return this.f5925b.d(this.f5926c.f5947g);
    }

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            this.k = null;
        } else {
            this.k = new p(cVar);
        }
    }
}
