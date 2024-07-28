package com.business.common_module;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public final class b extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Drawable> f7310a;

    /* renamed from: b  reason: collision with root package name */
    private int f7311b = -12;

    public b(Context context, int i2) {
        super(context, i2);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return bounds.right;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        if (this.f7311b == -12) {
            Drawable a2 = a();
            canvas.save();
            canvas.translate(f2, (float) (((i4 + i6) / 2) - (a2.getIntrinsicHeight() / 2)));
            a2.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, charSequence, i2, i3, f2, i4, i5, i6, paint);
    }

    private Drawable a() {
        WeakReference<Drawable> weakReference = this.f7310a;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.f7310a = new WeakReference<>(drawable2);
        return drawable2;
    }
}
