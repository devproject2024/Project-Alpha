package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    float f1973a;

    /* renamed from: b  reason: collision with root package name */
    float f1974b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f1975c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f1976d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f1977e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f1978f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1979g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1980h = true;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1981i;
    private ColorStateList j;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    public final int getOpacity() {
        return -3;
    }

    f(ColorStateList colorStateList, float f2) {
        this.f1973a = f2;
        this.f1976d = new Paint(5);
        a(colorStateList);
        this.f1977e = new RectF();
        this.f1978f = new Rect();
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1975c = colorStateList;
        this.f1976d.setColor(this.f1975c.getColorForState(getState(), this.f1975c.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, boolean z, boolean z2) {
        if (f2 != this.f1974b || this.f1979g != z || this.f1980h != z2) {
            this.f1974b = f2;
            this.f1979g = z;
            this.f1980h = z2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1976d;
        if (this.f1981i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1981i);
            z = true;
        }
        RectF rectF = this.f1977e;
        float f2 = this.f1973a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1977e.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1978f.set(rect);
        if (this.f1979g) {
            float a2 = g.a(this.f1974b, this.f1973a, this.f1980h);
            this.f1978f.inset((int) Math.ceil((double) g.b(this.f1974b, this.f1973a, this.f1980h)), (int) Math.ceil((double) a2));
            this.f1977e.set(this.f1978f);
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f1978f, this.f1973a);
    }

    public final void setAlpha(int i2) {
        this.f1976d.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1976d.setColorFilter(colorFilter);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.f1981i = a(this.j, this.k);
        invalidateSelf();
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.f1981i = a(this.j, this.k);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1975c;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1976d.getColor();
        if (z) {
            this.f1976d.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.f1981i = a(colorStateList2, mode);
        return true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f1975c;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
