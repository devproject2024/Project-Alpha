package net.one97.paytm.common.widgets;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.core.content.b;

public class DotProgressBar extends View {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f49785a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f49786b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Paint f49787c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Paint f49788d;

    /* renamed from: e  reason: collision with root package name */
    private long f49789e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f49790f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f49791g = true;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f49792h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f49793i;
    /* access modifiers changed from: private */
    public float j;
    /* access modifiers changed from: private */
    public float k;
    private float l;
    /* access modifiers changed from: private */
    public int m;
    private int n;
    private int o;
    private int p;
    private boolean q = false;

    static /* synthetic */ int c(DotProgressBar dotProgressBar) {
        int i2 = dotProgressBar.m;
        dotProgressBar.m = i2 + 1;
        return i2;
    }

    public DotProgressBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet);
        a();
    }

    public DotProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
        a();
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
        a();
    }

    public DotProgressBar(Context context) {
        super(context);
        a((AttributeSet) null);
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        if (this.j <= 0.0f) {
            if (getMeasuredHeight() > getMeasuredWidth()) {
                this.j = (float) ((getMeasuredWidth() / this.f49785a) / 4);
            } else {
                this.j = (float) (getMeasuredHeight() / 4);
            }
        }
        float f2 = this.j;
        this.k = (f2 / 3.0f) + f2;
        int i4 = this.f49785a;
        float f3 = (((float) i4) * f2 * 2.0f) + (f2 * ((float) (i4 - 1)));
        if (!this.q) {
            this.l = ((((float) getMeasuredWidth()) - f3) / 2.0f) + this.j;
        } else {
            this.l = 10.0f;
        }
    }

    public void setXCoordinateChange(boolean z) {
        this.q = z;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.DotProgressBar, 0, 0);
            try {
                setDotAmount(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_amount, 3));
                setDotRadius(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_circleSize, 8));
                long integer = (long) obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_duration, getResources().getInteger(17694721));
                this.f49789e = integer;
                setAnimationTime(integer);
                setStartColor(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_startColor, b.c(getContext(), R.color.light_blue_A700)));
                setEndColor(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_endColor, b.c(getContext(), R.color.light_blue_A400)));
                setAnimationDirection(obtainStyledAttributes.getInt(R.styleable.DotProgressBar_animationDirectionbundle, 1));
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            setDotAmount(5);
            setAnimationTime((long) getResources().getInteger(17694721));
            setStartColor(b.c(getContext(), R.color.light_blue_A700));
            setEndColor(b.c(getContext(), R.color.light_blue_A400));
            setAnimationDirection(1);
        }
    }

    private void a() {
        this.f49786b = new Paint(5);
        this.f49786b.setColor(this.n);
        this.f49786b.setStrokeJoin(Paint.Join.ROUND);
        this.f49786b.setStrokeCap(Paint.Cap.ROUND);
        this.f49786b.setStrokeWidth(20.0f);
        this.f49787c = new Paint(this.f49786b);
        this.f49788d = new Paint(this.f49786b);
        this.f49792h = ValueAnimator.ofInt(new int[]{this.n, this.o});
        this.f49792h.setDuration(this.f49789e);
        this.f49792h.setEvaluator(new ArgbEvaluator());
        this.f49792h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotProgressBar.this.f49787c.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f49793i = ValueAnimator.ofInt(new int[]{this.o, this.n});
        this.f49793i.setDuration(this.f49789e);
        this.f49793i.setEvaluator(new ArgbEvaluator());
        this.f49793i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotProgressBar.this.f49788d.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
    }

    public void setDotAmount(int i2) {
        this.f49785a = i2;
    }

    public void setDotRadius(int i2) {
        this.j = (float) i2;
    }

    public void setStartColor(int i2) {
        this.n = i2;
    }

    public void setEndColor(int i2) {
        this.o = i2;
    }

    public void setAnimationTime(long j2) {
        this.f49789e = j2;
    }

    private void setDotPosition(int i2) {
        this.m = i2;
    }

    public void setxCoordinate(float f2) {
        this.l = f2;
    }

    public int getAnimationDirection() {
        return this.p;
    }

    public void setAnimationDirection(int i2) {
        this.p = i2;
    }

    private void a(Canvas canvas, int i2, float f2, float f3) {
        int i3 = this.m;
        if (i3 == i2) {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.j + f3, this.f49787c);
        } else if ((i2 == this.f49785a - 1 && i3 == 0 && !this.f49791g) || this.m - 1 == i2) {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.k - f3, this.f49788d);
        } else {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.j, this.f49786b);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = 0.0f;
        if (this.p < 0) {
            float f3 = this.f49790f;
            for (int i2 = this.f49785a - 1; i2 >= 0; i2--) {
                a(canvas, i2, f2, f3);
                f2 += this.j * 3.0f;
            }
            return;
        }
        float f4 = this.f49790f;
        for (int i3 = 0; i3 < this.f49785a; i3++) {
            a(canvas, i3, f2, f4);
            f2 += this.j * 3.0f;
        }
    }

    private void b() {
        clearAnimation();
        postInvalidate();
    }

    private void c() {
        a aVar = new a(this, (byte) 0);
        aVar.setDuration(this.f49789e);
        aVar.setRepeatCount(-1);
        aVar.setInterpolator(new LinearInterpolator());
        aVar.setAnimationListener(new b() {
            public final void onAnimationRepeat(Animation animation) {
                DotProgressBar.c(DotProgressBar.this);
                if (DotProgressBar.this.m == DotProgressBar.this.f49785a) {
                    int unused = DotProgressBar.this.m = 0;
                }
                DotProgressBar.this.f49792h.start();
                if (!DotProgressBar.this.f49791g) {
                    DotProgressBar.this.f49793i.start();
                }
                boolean unused2 = DotProgressBar.this.f49791g = false;
            }
        });
        startAnimation(aVar);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 8 || i2 == 4) {
            b();
        } else {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    class a extends Animation {
        private a() {
        }

        /* synthetic */ a(DotProgressBar dotProgressBar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            DotProgressBar dotProgressBar = DotProgressBar.this;
            float unused = dotProgressBar.f49790f = (dotProgressBar.k - DotProgressBar.this.j) * f2;
            DotProgressBar.this.invalidate();
        }
    }
}
