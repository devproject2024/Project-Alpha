package it.sephiroth.android.library.imagezoom.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    protected Bitmap f47864a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f47865b;

    /* renamed from: c  reason: collision with root package name */
    protected int f47866c;

    /* renamed from: d  reason: collision with root package name */
    protected int f47867d;

    public final int getOpacity() {
        return -3;
    }

    public a(Bitmap bitmap) {
        this.f47864a = bitmap;
        Bitmap bitmap2 = this.f47864a;
        if (bitmap2 != null) {
            this.f47866c = bitmap2.getWidth();
            this.f47867d = this.f47864a.getHeight();
        } else {
            this.f47866c = 0;
            this.f47867d = 0;
        }
        this.f47865b = new Paint();
        this.f47865b.setDither(true);
        this.f47865b.setFilterBitmap(true);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f47864a;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f47864a, 0.0f, 0.0f, this.f47865b);
        }
    }

    public final void setAlpha(int i2) {
        this.f47865b.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f47865b.setColorFilter(colorFilter);
    }

    public final int getIntrinsicWidth() {
        return this.f47866c;
    }

    public final int getIntrinsicHeight() {
        return this.f47867d;
    }

    public final int getMinimumWidth() {
        return this.f47866c;
    }

    public final int getMinimumHeight() {
        return this.f47867d;
    }
}
