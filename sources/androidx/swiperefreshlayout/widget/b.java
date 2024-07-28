package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.g.f;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class b extends Drawable implements Animatable {

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f4597d = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private static final Interpolator f4598e = new androidx.interpolator.a.a.b();

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f4599f = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    final a f4600a = new a();

    /* renamed from: b  reason: collision with root package name */
    float f4601b;

    /* renamed from: c  reason: collision with root package name */
    boolean f4602c;

    /* renamed from: g  reason: collision with root package name */
    private float f4603g;

    /* renamed from: h  reason: collision with root package name */
    private Resources f4604h;

    /* renamed from: i  reason: collision with root package name */
    private Animator f4605i;

    public final int getOpacity() {
        return -3;
    }

    public b(Context context) {
        this.f4604h = ((Context) f.a(context)).getResources();
        this.f4600a.a(f4599f);
        this.f4600a.a(2.5f);
        invalidateSelf();
        final a aVar = this.f4600a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.a(floatValue, aVar);
                b.this.a(floatValue, aVar, false);
                b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f4597d);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                b.this.f4601b = 0.0f;
            }

            public final void onAnimationRepeat(Animator animator) {
                b.this.a(1.0f, aVar, true);
                aVar.c();
                a aVar = aVar;
                aVar.a(aVar.a());
                if (b.this.f4602c) {
                    b.this.f4602c = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.a(false);
                    return;
                }
                b.this.f4601b += 1.0f;
            }
        });
        this.f4605i = ofFloat;
    }

    private void a(float f2, float f3, float f4, float f5) {
        a aVar = this.f4600a;
        float f6 = this.f4604h.getDisplayMetrics().density;
        aVar.a(f3 * f6);
        aVar.q = f2 * f6;
        aVar.a(0);
        aVar.r = (int) (f4 * f6);
        aVar.s = (int) (f5 * f6);
    }

    public final void a(int i2) {
        if (i2 == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void a(boolean z) {
        this.f4600a.a(z);
        invalidateSelf();
    }

    public final void a(float f2) {
        a aVar = this.f4600a;
        if (f2 != aVar.p) {
            aVar.p = f2;
        }
        invalidateSelf();
    }

    public final void b(float f2) {
        a aVar = this.f4600a;
        aVar.f4614e = 0.0f;
        aVar.f4615f = f2;
        invalidateSelf();
    }

    public final void c(float f2) {
        this.f4600a.f4616g = f2;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4603g, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.f4600a;
        RectF rectF = aVar.f4610a;
        float f2 = aVar.q + (aVar.f4617h / 2.0f);
        if (aVar.q <= 0.0f) {
            f2 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) aVar.r) * aVar.p) / 2.0f, aVar.f4617h / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f2, ((float) bounds.centerY()) - f2, ((float) bounds.centerX()) + f2, ((float) bounds.centerY()) + f2);
        float f3 = (aVar.f4614e + aVar.f4616g) * 360.0f;
        float f4 = ((aVar.f4615f + aVar.f4616g) * 360.0f) - f3;
        aVar.f4611b.setColor(aVar.u);
        aVar.f4611b.setAlpha(aVar.t);
        float f5 = aVar.f4617h / 2.0f;
        rectF.inset(f5, f5);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.f4613d);
        float f6 = -f5;
        rectF.inset(f6, f6);
        canvas.drawArc(rectF, f3, f4, false, aVar.f4611b);
        if (aVar.n) {
            if (aVar.o == null) {
                aVar.o = new Path();
                aVar.o.setFillType(Path.FillType.EVEN_ODD);
            } else {
                aVar.o.reset();
            }
            aVar.o.moveTo(0.0f, 0.0f);
            aVar.o.lineTo(((float) aVar.r) * aVar.p, 0.0f);
            aVar.o.lineTo((((float) aVar.r) * aVar.p) / 2.0f, ((float) aVar.s) * aVar.p);
            aVar.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) aVar.r) * aVar.p) / 2.0f), rectF.centerY() + (aVar.f4617h / 2.0f));
            aVar.o.close();
            aVar.f4612c.setColor(aVar.u);
            aVar.f4612c.setAlpha(aVar.t);
            canvas.save();
            canvas.rotate(f3 + f4, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.o, aVar.f4612c);
            canvas.restore();
        }
        canvas.restore();
    }

    public final void setAlpha(int i2) {
        this.f4600a.t = i2;
        invalidateSelf();
    }

    public final int getAlpha() {
        return this.f4600a.t;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4600a.f4611b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final boolean isRunning() {
        return this.f4605i.isRunning();
    }

    public final void start() {
        this.f4605i.cancel();
        this.f4600a.c();
        if (this.f4600a.f4615f != this.f4600a.f4614e) {
            this.f4602c = true;
            this.f4605i.setDuration(666);
            this.f4605i.start();
            return;
        }
        this.f4600a.a(0);
        this.f4600a.d();
        this.f4605i.setDuration(1332);
        this.f4605i.start();
    }

    public final void stop() {
        this.f4605i.cancel();
        this.f4603g = 0.0f;
        this.f4600a.a(false);
        this.f4600a.a(0);
        this.f4600a.d();
        invalidateSelf();
    }

    static void a(float f2, a aVar) {
        if (f2 > 0.75f) {
            float f3 = (f2 - 0.75f) / 0.25f;
            int b2 = aVar.b();
            int i2 = aVar.f4618i[aVar.a()];
            int i3 = (b2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID;
            int i4 = (b2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID;
            int i5 = (b2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID;
            int i6 = b2 & PriceRangeSeekBar.INVALID_POINTER_ID;
            aVar.u = ((i3 + ((int) (((float) (((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID) - i3)) * f3))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID) - i4)) * f3))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID) - i5)) * f3))) << 8) | (i6 + ((int) (f3 * ((float) ((i2 & PriceRangeSeekBar.INVALID_POINTER_ID) - i6)))));
            return;
        }
        aVar.u = aVar.b();
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, a aVar, boolean z) {
        float f3;
        float f4;
        if (this.f4602c) {
            a(f2, aVar);
            float floor = (float) (Math.floor((double) (aVar.m / 0.8f)) + 1.0d);
            aVar.f4614e = aVar.k + (((aVar.l - 0.01f) - aVar.k) * f2);
            aVar.f4615f = aVar.l;
            aVar.f4616g = aVar.m + ((floor - aVar.m) * f2);
        } else if (f2 != 1.0f || z) {
            float f5 = aVar.m;
            if (f2 < 0.5f) {
                float f6 = aVar.k;
                float f7 = f6;
                f3 = (f4598e.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f6;
                f4 = f7;
            } else {
                f3 = aVar.k + 0.79f;
                f4 = f3 - (((1.0f - f4598e.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            aVar.f4614e = f4;
            aVar.f4615f = f3;
            aVar.f4616g = f5 + (0.20999998f * f2);
            this.f4603g = (f2 + this.f4601b) * 216.0f;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final RectF f4610a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f4611b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        final Paint f4612c = new Paint();

        /* renamed from: d  reason: collision with root package name */
        final Paint f4613d = new Paint();

        /* renamed from: e  reason: collision with root package name */
        float f4614e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4615f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4616g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        float f4617h = 5.0f;

        /* renamed from: i  reason: collision with root package name */
        int[] f4618i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p = 1.0f;
        float q;
        int r;
        int s;
        int t = PriceRangeSeekBar.INVALID_POINTER_ID;
        int u;

        a() {
            this.f4611b.setStrokeCap(Paint.Cap.SQUARE);
            this.f4611b.setAntiAlias(true);
            this.f4611b.setStyle(Paint.Style.STROKE);
            this.f4612c.setStyle(Paint.Style.FILL);
            this.f4612c.setAntiAlias(true);
            this.f4613d.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public final void a(int[] iArr) {
            this.f4618i = iArr;
            a(0);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.j = i2;
            this.u = this.f4618i[this.j];
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            return (this.j + 1) % this.f4618i.length;
        }

        /* access modifiers changed from: package-private */
        public final void a(float f2) {
            this.f4617h = f2;
            this.f4611b.setStrokeWidth(f2);
        }

        /* access modifiers changed from: package-private */
        public final int b() {
            return this.f4618i[this.j];
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.k = this.f4614e;
            this.l = this.f4615f;
            this.m = this.f4616g;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.f4614e = 0.0f;
            this.f4615f = 0.0f;
            this.f4616g = 0.0f;
        }
    }
}
