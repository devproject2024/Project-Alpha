package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;

public final class g extends a {

    /* renamed from: h  reason: collision with root package name */
    private final RectF f5951h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final Paint f5952i = new a();
    private final float[] j = new float[8];
    private final Path k = new Path();
    private final d l;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> m;

    g(f fVar, d dVar) {
        super(fVar, dVar);
        this.l = dVar;
        this.f5952i.setAlpha(0);
        this.f5952i.setStyle(Paint.Style.FILL);
        this.f5952i.setColor(dVar.l);
    }

    public final void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.l.l);
        if (alpha != 0) {
            int intValue = (int) ((((float) i2) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.f5930g.f5783e == null ? 100 : this.f5930g.f5783e.f().intValue()))) / 100.0f) * 255.0f);
            this.f5952i.setAlpha(intValue);
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.m;
            if (aVar != null) {
                this.f5952i.setColorFilter(aVar.f());
            }
            if (intValue > 0) {
                float[] fArr = this.j;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.l.j;
                float[] fArr2 = this.j;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.l.j;
                this.j[5] = (float) this.l.k;
                float[] fArr3 = this.j;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.l.k;
                matrix.mapPoints(this.j);
                this.k.reset();
                Path path = this.k;
                float[] fArr4 = this.j;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.k;
                float[] fArr5 = this.j;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.k;
                float[] fArr6 = this.j;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.k;
                float[] fArr7 = this.j;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.k;
                float[] fArr8 = this.j;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.k.close();
                canvas.drawPath(this.k, this.f5952i);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f5951h.set(0.0f, 0.0f, (float) this.l.j, (float) this.l.k);
        this.f5924a.mapRect(this.f5951h);
        rectF.set(this.f5951h);
    }

    public final <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            this.m = null;
        } else {
            this.m = new p(cVar);
        }
    }
}
