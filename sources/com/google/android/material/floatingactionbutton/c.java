package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.material.k.m;
import com.google.android.material.k.n;

final class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Paint f36321a;

    /* renamed from: b  reason: collision with root package name */
    float f36322b;

    /* renamed from: c  reason: collision with root package name */
    int f36323c;

    /* renamed from: d  reason: collision with root package name */
    int f36324d;

    /* renamed from: e  reason: collision with root package name */
    int f36325e;

    /* renamed from: f  reason: collision with root package name */
    int f36326f;

    /* renamed from: g  reason: collision with root package name */
    boolean f36327g = true;

    /* renamed from: h  reason: collision with root package name */
    private final n f36328h = new n();

    /* renamed from: i  reason: collision with root package name */
    private final Path f36329i = new Path();
    private final Rect j = new Rect();
    private final RectF k = new RectF();
    private final RectF l = new RectF();
    private final a m = new a(this, (byte) 0);
    private int n;
    private m o;
    private ColorStateList p;

    c(m mVar) {
        this.o = mVar;
        this.f36321a = new Paint(1);
        this.f36321a.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.n = colorStateList.getColorForState(getState(), this.n);
        }
        this.p = colorStateList;
        this.f36327g = true;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f36321a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        if (this.f36327g) {
            Paint paint = this.f36321a;
            Rect rect = this.j;
            copyBounds(rect);
            float height = this.f36322b / ((float) rect.height());
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{androidx.core.graphics.a.a(this.f36323c, this.n), androidx.core.graphics.a.a(this.f36324d, this.n), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.f36324d, 0), this.n), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.f36326f, 0), this.n), androidx.core.graphics.a.a(this.f36326f, this.n), androidx.core.graphics.a.a(this.f36325e, this.n)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.f36327g = false;
        }
        float strokeWidth = this.f36321a.getStrokeWidth() / 2.0f;
        copyBounds(this.j);
        this.k.set(this.j);
        float min = Math.min(this.o.f36554f.a(a()), this.k.width() / 2.0f);
        if (this.o.a(a())) {
            this.k.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.k, min, min, this.f36321a);
        }
    }

    public final void getOutline(Outline outline) {
        if (this.o.a(a())) {
            outline.setRoundRect(getBounds(), this.o.f36554f.a(a()));
            return;
        }
        copyBounds(this.j);
        this.k.set(this.j);
        this.f36328h.a(this.o, 1.0f, this.k, this.f36329i);
        if (this.f36329i.isConvex()) {
            outline.setConvexPath(this.f36329i);
        }
    }

    public final boolean getPadding(Rect rect) {
        if (!this.o.a(a())) {
            return true;
        }
        int round = Math.round(this.f36322b);
        rect.set(round, round, round, round);
        return true;
    }

    private RectF a() {
        this.l.set(getBounds());
        return this.l;
    }

    public final void a(m mVar) {
        this.o = mVar;
        invalidateSelf();
    }

    public final void setAlpha(int i2) {
        this.f36321a.setAlpha(i2);
        invalidateSelf();
    }

    public final int getOpacity() {
        return this.f36322b > 0.0f ? -3 : -2;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.f36327g = true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.n)) == this.n)) {
            this.f36327g = true;
            this.n = colorForState;
        }
        if (this.f36327g) {
            invalidateSelf();
        }
        return this.f36327g;
    }

    public final Drawable.ConstantState getConstantState() {
        return this.m;
    }

    class a extends Drawable.ConstantState {
        public final int getChangingConfigurations() {
            return 0;
        }

        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final Drawable newDrawable() {
            return c.this;
        }
    }
}
