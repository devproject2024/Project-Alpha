package net.one97.paytm.p2b.view.CustomView;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.p2b.R;

public class CircleProgressImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageView.ScaleType f12832a = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f12833b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private static float f12834c = 0.805f;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private Context E;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f12835d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f12836e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f12837f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f12838g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f12839h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f12840i;
    private float j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Bitmap o;
    private int p;
    private int q;
    private float r;
    private float s;
    private float t;
    private float u;
    private ValueAnimator v;
    private ColorFilter w;
    private boolean x;
    private boolean y;
    private boolean z;

    public CircleProgressImageView(Context context) {
        super(context);
        this.f12835d = new RectF();
        this.f12836e = new RectF();
        this.f12837f = new Matrix();
        this.f12838g = new Paint(1);
        this.f12839h = new Paint(1);
        this.f12840i = new Paint(1);
        this.j = 0.0f;
        this.k = -16777216;
        this.l = 0;
        this.m = 0;
        this.n = -16776961;
        this.u = 0.0f;
        this.D = false;
        a();
    }

    public CircleProgressImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.E = context;
    }

    public CircleProgressImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12835d = new RectF();
        this.f12836e = new RectF();
        this.f12837f = new Matrix();
        this.f12838g = new Paint(1);
        this.f12839h = new Paint(1);
        this.f12840i = new Paint(1);
        this.j = 0.0f;
        this.k = -16777216;
        this.l = 0;
        this.m = 0;
        this.n = -16776961;
        this.u = 0.0f;
        this.D = false;
        this.E = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.P2bCircleProgreesImageView, i2, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.P2bCircleProgreesImageView_p2b_border_width, 0);
        this.k = obtainStyledAttributes.getColor(R.styleable.P2bCircleProgreesImageView_p2b_border_color, -16777216);
        this.z = obtainStyledAttributes.getBoolean(R.styleable.P2bCircleProgreesImageView_p2b_border_overlay, false);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.P2bCircleProgreesImageView_p2b_draw_anticlockwise, false);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.P2bCircleProgreesImageView_p2b_enable_touch, false);
        this.m = obtainStyledAttributes.getColor(R.styleable.P2bCircleProgreesImageView_p2b_fill_color, 0);
        this.r = obtainStyledAttributes.getFloat(R.styleable.P2bCircleProgreesImageView_p2b_centercircle_diammterer, f12834c);
        this.n = obtainStyledAttributes.getColor(R.styleable.P2bCircleProgreesImageView_p2b_progress_color, -16776961);
        this.j = obtainStyledAttributes.getFloat(R.styleable.P2bCircleProgreesImageView_p2b_progress_startAngle, 0.0f);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        this.v = ValueAnimator.ofFloat(new float[]{0.0f, this.u});
        this.v.setDuration(100);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircleProgressImageView.this.setValueWithNoAnimation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        super.setScaleType(f12832a);
        this.x = true;
        this.y = true;
        if (this.y) {
            c();
            this.y = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f12832a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f12832a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.C) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.rotate(this.j, this.f12835d.centerX(), this.f12835d.centerY());
        if (this.l > 0) {
            this.f12839h.setColor(this.k);
            canvas.drawArc(this.f12836e, 0.0f, 360.0f, true, this.f12839h);
        }
        this.f12839h.setColor(this.n);
        float f2 = (this.u / 100.0f) * 360.0f;
        RectF rectF = this.f12836e;
        if (this.A) {
            f2 = -f2;
        }
        canvas.drawArc(rectF, 0.0f, f2, false, this.f12839h);
        canvas.restore();
        canvas.drawCircle(this.f12835d.centerX(), this.f12835d.centerY(), this.s, this.f12838g);
        if (this.m != 0) {
            canvas.drawCircle(this.f12835d.centerX(), this.f12835d.centerY(), this.s, this.f12840i);
        }
    }

    public void setValue(float f2) {
        if (this.D) {
            if (this.v.isRunning()) {
                this.v.cancel();
            }
            this.v.setFloatValues(new float[]{this.u, f2});
            this.v.start();
            return;
        }
        setValueWithNoAnimation(f2, false);
    }

    public void setValueWithNoAnimation(float f2) {
        setValueWithNoAnimation(f2, false);
    }

    public void setValueWithNoAnimation(float f2, boolean z2) {
        this.u = f2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        c();
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        c();
    }

    public void setProgressAnimationState(boolean z2) {
        this.D = z2;
    }

    public void setProgressAnimatorInterpolator(TimeInterpolator timeInterpolator) {
        this.v.setInterpolator(timeInterpolator);
    }

    public int getBorderColor() {
        return this.k;
    }

    public void setBorderColor(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            this.f12839h.setColor(this.k);
            invalidate();
        }
    }

    public void setBorderProgressColor(int i2) {
        if (i2 != this.n) {
            this.n = i2;
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    @Deprecated
    public int getFillColor() {
        return this.m;
    }

    @Deprecated
    public void setFillColor(int i2) {
        if (i2 != this.m) {
            this.m = i2;
            this.f12840i.setColor(i2);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i2) {
        setFillColor(getContext().getResources().getColor(i2));
    }

    public int getBorderWidth() {
        return this.l;
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            c();
        }
    }

    public void setBorderOverlay(boolean z2) {
        if (z2 != this.z) {
            this.z = z2;
            c();
        }
    }

    public void setDisableCircularTransformation(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            if (this.C) {
                this.o = null;
            } else {
                this.o = a(getDrawable());
            }
            c();
        }
    }

    public ColorFilter getColorFilter() {
        return this.w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.w) {
            this.w = colorFilter;
            b();
            invalidate();
        }
    }

    private void b() {
        Paint paint = this.f12838g;
        if (paint != null) {
            paint.setColorFilter(this.w);
        }
    }

    private Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f12833b);
            } else {
                bitmap = Bitmap.createBitmap(a(this.E), a(this.E), f12833b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    private void c() {
        int i2;
        if (!this.x) {
            this.y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            this.f12838g.setAntiAlias(true);
            this.f12838g.setColor(0);
            this.f12839h.setStyle(Paint.Style.STROKE);
            this.f12839h.setAntiAlias(true);
            this.f12839h.setColor(this.k);
            this.f12839h.setStrokeWidth((float) this.l);
            this.f12839h.setStrokeCap(Paint.Cap.ROUND);
            this.f12840i.setStyle(Paint.Style.FILL);
            this.f12840i.setAntiAlias(true);
            this.f12840i.setColor(this.m);
            this.q = getHeight();
            this.p = getWidth();
            this.f12836e.set(d());
            this.t = Math.min((this.f12836e.height() - ((float) this.l)) / 2.0f, (this.f12836e.width() - ((float) this.l)) / 2.0f);
            this.f12835d.set(this.f12836e);
            if (!this.z && (i2 = this.l) > 0) {
                this.f12835d.inset((float) i2, (float) i2);
            }
            this.s = Math.min(this.f12835d.height() / 2.0f, this.f12835d.width() / 2.0f);
            if (this.r > 1.0f) {
                this.r = 1.0f;
            }
            this.s *= this.r;
            b();
            invalidate();
        }
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i3 : size;
        }
        return Math.min(i3, size);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(a(i2, a(this.E)), a(i3, a(this.E)));
    }

    private RectF d() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f2 = (float) min;
        return new RectF(((float) getBorderWidth()) + paddingLeft, ((float) getBorderWidth()) + paddingTop, (paddingLeft + f2) - ((float) getBorderWidth()), (paddingTop + f2) - ((float) getBorderWidth()));
    }

    private static int a(Context context) {
        if (context == null) {
            return 70;
        }
        return (int) ((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 70.0f);
    }
}
