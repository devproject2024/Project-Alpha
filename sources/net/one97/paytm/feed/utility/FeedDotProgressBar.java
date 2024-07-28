package net.one97.paytm.feed.utility;

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
import net.one97.paytm.feed.R;

public class FeedDotProgressBar extends View {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f35358a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f35359b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Paint f35360c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Paint f35361d;

    /* renamed from: e  reason: collision with root package name */
    private long f35362e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f35363f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f35364g = true;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f35365h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f35366i;
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

    static /* synthetic */ int c(FeedDotProgressBar feedDotProgressBar) {
        int i2 = feedDotProgressBar.m;
        feedDotProgressBar.m = i2 + 1;
        return i2;
    }

    public FeedDotProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
        a();
    }

    public FeedDotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
        a();
    }

    public FeedDotProgressBar(Context context) {
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
                this.j = (float) ((getMeasuredWidth() / this.f35358a) / 4);
            } else {
                this.j = (float) (getMeasuredHeight() / 4);
            }
        }
        float f2 = this.j;
        this.k = (f2 / 3.0f) + f2;
        int i4 = this.f35358a;
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
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.FeedDotProgressBar, 0, 0);
            try {
                setDotAmount(obtainStyledAttributes.getInteger(R.styleable.FeedDotProgressBar_feedamount, 3));
                setDotRadius(obtainStyledAttributes.getInteger(R.styleable.FeedDotProgressBar_feedcircleSize, 8));
                long integer = (long) obtainStyledAttributes.getInteger(R.styleable.FeedDotProgressBar_feedduration, getResources().getInteger(17694721));
                this.f35362e = integer;
                setAnimationTime(integer);
                setStartColor(obtainStyledAttributes.getInteger(R.styleable.FeedDotProgressBar_feedstartColor, b.c(getContext(), R.color.feed_light_blue_A700)));
                setEndColor(obtainStyledAttributes.getInteger(R.styleable.FeedDotProgressBar_feedendColor, b.c(getContext(), R.color.feed_light_blue_A400)));
                setAnimationDirection(obtainStyledAttributes.getInt(R.styleable.FeedDotProgressBar_feedanimationDirectionbundle, 1));
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            setDotAmount(5);
            setAnimationTime((long) getResources().getInteger(17694721));
            setStartColor(b.c(getContext(), R.color.feed_light_blue_A700));
            setEndColor(b.c(getContext(), R.color.feed_light_blue_A400));
            setAnimationDirection(1);
        }
    }

    private void a() {
        this.f35359b = new Paint(5);
        this.f35359b.setColor(this.n);
        this.f35359b.setStrokeJoin(Paint.Join.ROUND);
        this.f35359b.setStrokeCap(Paint.Cap.ROUND);
        this.f35359b.setStrokeWidth(20.0f);
        this.f35360c = new Paint(this.f35359b);
        this.f35361d = new Paint(this.f35359b);
        this.f35365h = ValueAnimator.ofInt(new int[]{this.n, this.o});
        this.f35365h.setDuration(this.f35362e);
        this.f35365h.setEvaluator(new ArgbEvaluator());
        this.f35365h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedDotProgressBar.this.f35360c.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f35366i = ValueAnimator.ofInt(new int[]{this.o, this.n});
        this.f35366i.setDuration(this.f35362e);
        this.f35366i.setEvaluator(new ArgbEvaluator());
        this.f35366i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedDotProgressBar.this.f35361d.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setDotAmount(int i2) {
        this.f35358a = i2;
    }

    /* access modifiers changed from: package-private */
    public void setDotRadius(int i2) {
        this.j = (float) i2;
    }

    /* access modifiers changed from: package-private */
    public void setStartColor(int i2) {
        this.n = i2;
    }

    /* access modifiers changed from: package-private */
    public void setEndColor(int i2) {
        this.o = i2;
    }

    /* access modifiers changed from: package-private */
    public void setAnimationTime(long j2) {
        this.f35362e = j2;
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

    /* access modifiers changed from: package-private */
    public void setAnimationDirection(int i2) {
        this.p = i2;
    }

    private void a(Canvas canvas, int i2, float f2, float f3) {
        int i3 = this.m;
        if (i3 == i2) {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.j + f3, this.f35360c);
        } else if ((i2 == this.f35358a - 1 && i3 == 0 && !this.f35364g) || this.m - 1 == i2) {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.k - f3, this.f35361d);
        } else {
            canvas.drawCircle(this.l + f2, (float) (getMeasuredHeight() / 2), this.j, this.f35359b);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = 0.0f;
        if (this.p < 0) {
            float f3 = this.f35363f;
            for (int i2 = this.f35358a - 1; i2 >= 0; i2--) {
                a(canvas, i2, f2, f3);
                f2 += this.j * 3.0f;
            }
            return;
        }
        float f4 = this.f35363f;
        for (int i3 = 0; i3 < this.f35358a; i3++) {
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
        aVar.setDuration(this.f35362e);
        aVar.setRepeatCount(-1);
        aVar.setInterpolator(new LinearInterpolator());
        aVar.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
                FeedDotProgressBar.c(FeedDotProgressBar.this);
                if (FeedDotProgressBar.this.m == FeedDotProgressBar.this.f35358a) {
                    int unused = FeedDotProgressBar.this.m = 0;
                }
                FeedDotProgressBar.this.f35365h.start();
                if (!FeedDotProgressBar.this.f35364g) {
                    FeedDotProgressBar.this.f35366i.start();
                }
                boolean unused2 = FeedDotProgressBar.this.f35364g = false;
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

        /* synthetic */ a(FeedDotProgressBar feedDotProgressBar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            FeedDotProgressBar feedDotProgressBar = FeedDotProgressBar.this;
            float unused = feedDotProgressBar.f35363f = (feedDotProgressBar.k - FeedDotProgressBar.this.j) * f2;
            FeedDotProgressBar.this.invalidate();
        }
    }
}
