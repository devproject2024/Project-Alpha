package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

final class g extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    static a f1982a;

    /* renamed from: g  reason: collision with root package name */
    private static final double f1983g = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    float f1984b;

    /* renamed from: c  reason: collision with root package name */
    float f1985c;

    /* renamed from: d  reason: collision with root package name */
    float f1986d;

    /* renamed from: e  reason: collision with root package name */
    ColorStateList f1987e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1988f = true;

    /* renamed from: h  reason: collision with root package name */
    private final int f1989h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f1990i;
    private Paint j;
    private Paint k;
    private final RectF l;
    private Path m;
    private float n;
    private final int o;
    private final int p;
    private boolean q = true;
    private boolean r = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    public final int getOpacity() {
        return -3;
    }

    g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(R.color.cardview_shadow_start_color);
        this.p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f1989h = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.f1990i = new Paint(5);
        a(colorStateList);
        this.j = new Paint(5);
        this.j.setStyle(Paint.Style.FILL);
        this.f1984b = (float) ((int) (f2 + 0.5f));
        this.l = new RectF();
        this.k = new Paint(this.j);
        this.k.setAntiAlias(false);
        a(f3, f4);
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1987e = colorStateList;
        this.f1990i.setColor(this.f1987e.getColorForState(getState(), this.f1987e.getDefaultColor()));
    }

    private static int a(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    public final void setAlpha(int i2) {
        this.f1990i.setAlpha(i2);
        this.j.setAlpha(i2);
        this.k.setAlpha(i2);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1988f = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float a2 = (float) a(f2);
            float a3 = (float) a(f3);
            if (a2 > a3) {
                if (!this.r) {
                    this.r = true;
                }
                a2 = a3;
            }
            if (this.f1986d != a2 || this.f1985c != a3) {
                this.f1986d = a2;
                this.f1985c = a3;
                this.n = (float) ((int) ((a2 * 1.5f) + ((float) this.f1989h) + 0.5f));
                this.f1988f = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.f1985c, this.f1984b, this.q));
        int ceil2 = (int) Math.ceil((double) b(this.f1985c, this.f1984b, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - f1983g) * ((double) f3))) : f2 * 1.5f;
    }

    static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f1983g) * ((double) f3))) : f2;
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1987e;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1990i.getColor() == colorForState) {
            return false;
        }
        this.f1990i.setColor(colorForState);
        this.f1988f = true;
        invalidateSelf();
        return true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.f1987e;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1990i.setColorFilter(colorFilter);
    }

    public final void draw(Canvas canvas) {
        int i2;
        Canvas canvas2 = canvas;
        if (this.f1988f) {
            Rect bounds = getBounds();
            float f2 = this.f1985c * 1.5f;
            this.l.set(((float) bounds.left) + this.f1985c, ((float) bounds.top) + f2, ((float) bounds.right) - this.f1985c, ((float) bounds.bottom) - f2);
            float f3 = this.f1984b;
            RectF rectF = new RectF(-f3, -f3, f3, f3);
            RectF rectF2 = new RectF(rectF);
            float f4 = this.n;
            rectF2.inset(-f4, -f4);
            Path path = this.m;
            if (path == null) {
                this.m = new Path();
            } else {
                path.reset();
            }
            this.m.setFillType(Path.FillType.EVEN_ODD);
            this.m.moveTo(-this.f1984b, 0.0f);
            this.m.rLineTo(-this.n, 0.0f);
            this.m.arcTo(rectF2, 180.0f, 90.0f, false);
            this.m.arcTo(rectF, 270.0f, -90.0f, false);
            this.m.close();
            float f5 = this.f1984b;
            float f6 = this.n;
            Paint paint = this.j;
            int i3 = this.o;
            RadialGradient radialGradient = r12;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f5 + f6, new int[]{i3, i3, this.p}, new float[]{0.0f, f5 / (f5 + f6), 1.0f}, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
            Paint paint2 = this.k;
            float f7 = this.f1984b;
            float f8 = this.n;
            int i4 = this.o;
            paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i4, i4, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.k.setAntiAlias(false);
            this.f1988f = false;
        }
        canvas2.translate(0.0f, this.f1986d / 2.0f);
        float f9 = this.f1984b;
        float f10 = (-f9) - this.n;
        float f11 = f9 + ((float) this.f1989h) + (this.f1986d / 2.0f);
        float f12 = f11 * 2.0f;
        boolean z = this.l.width() - f12 > 0.0f;
        boolean z2 = this.l.height() - f12 > 0.0f;
        int save = canvas.save();
        canvas2.translate(this.l.left + f11, this.l.top + f11);
        canvas2.drawPath(this.m, this.j);
        if (z) {
            i2 = save;
            canvas.drawRect(0.0f, f10, this.l.width() - f12, -this.f1984b, this.k);
        } else {
            i2 = save;
        }
        canvas2.restoreToCount(i2);
        int save2 = canvas.save();
        canvas2.translate(this.l.right - f11, this.l.bottom - f11);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.m, this.j);
        if (z) {
            canvas.drawRect(0.0f, f10, this.l.width() - f12, (-this.f1984b) + this.n, this.k);
        }
        canvas2.restoreToCount(save2);
        int save3 = canvas.save();
        canvas2.translate(this.l.left + f11, this.l.bottom - f11);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.m, this.j);
        if (z2) {
            canvas.drawRect(0.0f, f10, this.l.height() - f12, -this.f1984b, this.k);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        canvas2.translate(this.l.right - f11, this.l.top + f11);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.m, this.j);
        if (z2) {
            canvas.drawRect(0.0f, f10, this.l.height() - f12, -this.f1984b, this.k);
        }
        canvas2.restoreToCount(save4);
        canvas2.translate(0.0f, (-this.f1986d) / 2.0f);
        f1982a.a(canvas2, this.l, this.f1984b, this.f1990i);
    }

    /* access modifiers changed from: package-private */
    public final float a() {
        float f2 = this.f1985c;
        return (Math.max(f2, this.f1984b + ((float) this.f1989h) + (f2 / 2.0f)) * 2.0f) + ((this.f1985c + ((float) this.f1989h)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public final float b() {
        float f2 = this.f1985c;
        return (Math.max(f2, this.f1984b + ((float) this.f1989h) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1985c * 1.5f) + ((float) this.f1989h)) * 2.0f);
    }
}
