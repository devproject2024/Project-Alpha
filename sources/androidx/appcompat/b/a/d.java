package androidx.appcompat.b.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.a;

public final class d extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private static final float f1197b = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1198a = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private float f1199c;

    /* renamed from: d  reason: collision with root package name */
    private float f1200d;

    /* renamed from: e  reason: collision with root package name */
    private float f1201e;

    /* renamed from: f  reason: collision with root package name */
    private float f1202f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1203g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f1204h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private final int f1205i;
    private boolean j = false;
    private float k;
    private float l;
    private int m = 2;

    public final int getOpacity() {
        return -3;
    }

    public d(Context context) {
        this.f1198a.setStyle(Paint.Style.STROKE);
        this.f1198a.setStrokeJoin(Paint.Join.MITER);
        this.f1198a.setStrokeCap(Paint.Cap.BUTT);
        this.f1198a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        int color = obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0);
        if (color != this.f1198a.getColor()) {
            this.f1198a.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f);
        if (this.f1198a.getStrokeWidth() != dimension) {
            this.f1198a.setStrokeWidth(dimension);
            this.l = (float) (((double) (dimension / 2.0f)) * Math.cos((double) f1197b));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
        if (this.f1203g != z) {
            this.f1203g = z;
            invalidateSelf();
        }
        float round = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (round != this.f1202f) {
            this.f1202f = round;
            invalidateSelf();
        }
        this.f1205i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1200d = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f1199c = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f1201e = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i2 = this.m;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? a.h(this) == 0 : a.h(this) == 1))) {
            z = true;
        }
        float f2 = this.f1199c;
        float sqrt = (float) Math.sqrt((double) (f2 * f2 * 2.0f));
        float f3 = this.f1200d;
        float f4 = this.k;
        float f5 = ((sqrt - f3) * f4) + f3;
        float f6 = f3 + ((this.f1201e - f3) * f4);
        float round = (float) Math.round(((this.l - 0.0f) * f4) + 0.0f);
        float f7 = ((f1197b - 0.0f) * this.k) + 0.0f;
        float f8 = z ? 0.0f : -180.0f;
        double d2 = (double) f5;
        float f9 = f8 + (((z ? 180.0f : 0.0f) - f8) * this.k);
        double d3 = (double) f7;
        boolean z2 = z;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(d2 * Math.sin(d3));
        this.f1204h.rewind();
        float strokeWidth = this.f1202f + this.f1198a.getStrokeWidth();
        float f10 = strokeWidth + (((-this.l) - strokeWidth) * this.k);
        float f11 = (-f6) / 2.0f;
        this.f1204h.moveTo(f11 + round, 0.0f);
        this.f1204h.rLineTo(f6 - (round * 2.0f), 0.0f);
        this.f1204h.moveTo(f11, f10);
        this.f1204h.rLineTo(round2, round3);
        this.f1204h.moveTo(f11, -f10);
        this.f1204h.rLineTo(round2, -round3);
        this.f1204h.close();
        canvas.save();
        float strokeWidth2 = this.f1198a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth2);
        float f12 = this.f1202f;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f12))) / 4) * 2)) + (strokeWidth2 * 1.5f) + f12);
        if (this.f1203g) {
            canvas2.rotate(f9 * ((float) (this.j ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f1204h, this.f1198a);
        canvas.restore();
    }

    public final void setAlpha(int i2) {
        if (i2 != this.f1198a.getAlpha()) {
            this.f1198a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1198a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getIntrinsicHeight() {
        return this.f1205i;
    }

    public final int getIntrinsicWidth() {
        return this.f1205i;
    }

    public final void setProgress(float f2) {
        if (this.k != f2) {
            this.k = f2;
            invalidateSelf();
        }
    }
}
