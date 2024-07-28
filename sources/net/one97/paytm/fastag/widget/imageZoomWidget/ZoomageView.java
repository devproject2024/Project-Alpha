package net.one97.paytm.fastag.widget.imageZoomWidget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.fastag.R;

public class ZoomageView extends AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f13963a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13964b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13965c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView.ScaleType f13966d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f13967e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f13968f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f13969g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f13970h;

    /* renamed from: i  reason: collision with root package name */
    private float f13971i;
    private float j;
    private float k;
    private float l;
    private final RectF m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private PointF t;
    private float u;
    private float v;
    private int w;
    private ScaleGestureDetector x;

    public ZoomageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ZoomageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13963a = 0.6f;
        this.f13964b = 8.0f;
        this.f13965c = 200;
        this.f13967e = new Matrix();
        this.f13968f = new Matrix();
        this.f13969g = new float[9];
        this.f13970h = null;
        this.f13971i = 0.6f;
        this.j = 8.0f;
        this.k = 0.6f;
        this.l = 8.0f;
        this.m = new RectF();
        this.t = new PointF(0.0f, 0.0f);
        this.u = 1.0f;
        this.v = 1.0f;
        this.w = 1;
        this.x = new ScaleGestureDetector(context, this);
        ScaleGestureDetector scaleGestureDetector = this.x;
        if (Build.VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(false);
        }
        this.f13966d = getScaleType();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ZoomageView);
        this.o = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_zoomable, true);
        this.n = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_translatable, true);
        this.q = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_animateOnReset, true);
        this.r = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_autoCenter, true);
        this.p = obtainStyledAttributes.getBoolean(R.styleable.ZoomageView_zoomage_restrictBounds, false);
        this.f13971i = obtainStyledAttributes.getFloat(R.styleable.ZoomageView_zoomage_minScale, 0.6f);
        this.j = obtainStyledAttributes.getFloat(R.styleable.ZoomageView_zoomage_maxScale, 8.0f);
        int i3 = obtainStyledAttributes.getInt(R.styleable.ZoomageView_zoomage_autoResetMode, 0);
        int i4 = 3;
        if (i3 == 1) {
            i4 = 1;
        } else if (i3 == 2) {
            i4 = 2;
        } else if (i3 != 3) {
            i4 = 0;
        }
        this.s = i4;
        a();
        obtainStyledAttributes.recycle();
    }

    private void a() {
        float f2 = this.f13971i;
        float f3 = this.j;
        if (f2 >= f3) {
            throw new IllegalStateException("minScale must be less than maxScale");
        } else if (f2 < 0.0f) {
            throw new IllegalStateException("minScale must be greater than 0");
        } else if (f3 < 0.0f) {
            throw new IllegalStateException("maxScale must be greater than 0");
        }
    }

    public void setScaleRange(float f2, float f3) {
        this.f13971i = f2;
        this.j = f3;
        this.f13970h = null;
        a();
    }

    public void setTranslatable(boolean z) {
        this.n = z;
    }

    public void setZoomable(boolean z) {
        this.o = z;
    }

    public boolean getRestrictBounds() {
        return this.p;
    }

    public void setRestrictBounds(boolean z) {
        this.p = z;
    }

    public boolean getAnimateOnReset() {
        return this.q;
    }

    public void setAnimateOnReset(boolean z) {
        this.q = z;
    }

    public int getAutoResetMode() {
        return this.s;
    }

    public void setAutoResetMode(int i2) {
        this.s = i2;
    }

    public boolean getAutoCenter() {
        return this.r;
    }

    public void setAutoCenter(boolean z) {
        this.r = z;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.f13966d = scaleType;
        this.f13970h = null;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setScaleType(this.f13966d);
        }
    }

    private float getCurrentDisplayedWidth() {
        if (getDrawable() != null) {
            return ((float) getDrawable().getIntrinsicWidth()) * this.f13969g[0];
        }
        return 0.0f;
    }

    private float getCurrentDisplayedHeight() {
        if (getDrawable() != null) {
            return ((float) getDrawable().getIntrinsicHeight()) * this.f13969g[4];
        }
        return 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (!isEnabled() || (!this.o && !this.n)) {
            return super.onTouchEvent(motionEvent);
        }
        if (getScaleType() != ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
        }
        if (this.f13970h == null) {
            this.f13970h = new float[9];
            this.f13968f = new Matrix(getImageMatrix());
            this.f13968f.getValues(this.f13970h);
            float f8 = this.f13971i;
            float[] fArr = this.f13970h;
            this.k = f8 * fArr[0];
            this.l = this.j * fArr[0];
        }
        this.f13967e.set(getImageMatrix());
        this.f13967e.getValues(this.f13969g);
        float[] fArr2 = this.f13969g;
        if (getDrawable() != null) {
            this.m.set(fArr2[2], fArr2[5], (((float) getDrawable().getIntrinsicWidth()) * fArr2[0]) + fArr2[2], (((float) getDrawable().getIntrinsicHeight()) * fArr2[4]) + fArr2[5]);
        }
        this.x.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 0 || motionEvent.getPointerCount() != this.w) {
            this.t.set(this.x.getFocusX(), this.x.getFocusY());
        } else if (motionEvent.getActionMasked() == 2) {
            float focusX = this.x.getFocusX();
            float focusY = this.x.getFocusY();
            if (this.n) {
                float f9 = focusX - this.t.x;
                if (this.p) {
                    if (getCurrentDisplayedWidth() >= ((float) getWidth())) {
                        if (this.m.left <= 0.0f && this.m.left + f9 > 0.0f && !this.x.isInProgress()) {
                            f7 = this.m.left;
                        } else if (this.m.right >= ((float) getWidth()) && this.m.right + f9 < ((float) getWidth()) && !this.x.isInProgress()) {
                            f6 = (float) getWidth();
                            f5 = this.m.right;
                            f9 = f6 - f5;
                        }
                    } else if (!this.x.isInProgress()) {
                        if (this.m.left >= 0.0f && this.m.left + f9 < 0.0f) {
                            f7 = this.m.left;
                        } else if (this.m.right <= ((float) getWidth()) && this.m.right + f9 > ((float) getWidth())) {
                            f6 = (float) getWidth();
                            f5 = this.m.right;
                            f9 = f6 - f5;
                        }
                    }
                    f9 = -f7;
                }
                if (this.m.right + f9 < 0.0f) {
                    f9 = -this.m.right;
                } else if (this.m.left + f9 > ((float) getWidth())) {
                    f9 = ((float) getWidth()) - this.m.left;
                }
                float f10 = focusY - this.t.y;
                if (this.p) {
                    if (getCurrentDisplayedHeight() >= ((float) getHeight())) {
                        if (this.m.top <= 0.0f && this.m.top + f10 > 0.0f && !this.x.isInProgress()) {
                            f4 = this.m.top;
                        } else if (this.m.bottom >= ((float) getHeight()) && this.m.bottom + f10 < ((float) getHeight()) && !this.x.isInProgress()) {
                            f3 = (float) getHeight();
                            f2 = this.m.bottom;
                            f10 = f3 - f2;
                        }
                    } else if (!this.x.isInProgress()) {
                        if (this.m.top >= 0.0f && this.m.top + f10 < 0.0f) {
                            f4 = this.m.top;
                        } else if (this.m.bottom <= ((float) getHeight()) && this.m.bottom + f10 > ((float) getHeight())) {
                            f3 = (float) getHeight();
                            f2 = this.m.bottom;
                            f10 = f3 - f2;
                        }
                    }
                    f10 = -f4;
                }
                if (this.m.bottom + f10 < 0.0f) {
                    f10 = -this.m.bottom;
                } else if (this.m.top + f10 > ((float) getHeight())) {
                    f10 = ((float) getHeight()) - this.m.top;
                }
                this.f13967e.postTranslate(f9, f10);
            }
            if (this.o) {
                Matrix matrix = this.f13967e;
                float f11 = this.v;
                matrix.postScale(f11, f11, focusX, focusY);
            }
            setImageMatrix(this.f13967e);
            this.t.set(focusX, focusY);
        }
        if (motionEvent.getActionMasked() == 1) {
            this.v = 1.0f;
            int i2 = this.s;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c();
                    } else if (i2 == 3) {
                        b();
                    }
                } else if (this.f13969g[0] >= this.f13970h[0]) {
                    c();
                } else {
                    b();
                }
            } else if (this.f13969g[0] <= this.f13970h[0]) {
                c();
            } else {
                b();
            }
        }
        this.w = motionEvent.getPointerCount();
        return true;
    }

    private void b() {
        if (this.r) {
            e();
            f();
        }
    }

    private void c() {
        a(this.q);
    }

    private void a(boolean z) {
        if (z) {
            d();
        } else {
            setImageMatrix(this.f13968f);
        }
    }

    private void d() {
        final Matrix matrix = new Matrix(getImageMatrix());
        matrix.getValues(this.f13969g);
        float[] fArr = this.f13970h;
        float f2 = fArr[0];
        float[] fArr2 = this.f13969g;
        final float f3 = f2 - fArr2[0];
        final float f4 = fArr[4] - fArr2[4];
        final float f5 = fArr[2] - fArr2[2];
        final float f6 = fArr[5] - fArr2[5];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            final Matrix f13972a = new Matrix(ZoomageView.this.getImageMatrix());

            /* renamed from: b  reason: collision with root package name */
            final float[] f13973b = new float[9];

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f13972a.set(matrix);
                this.f13972a.getValues(this.f13973b);
                float[] fArr = this.f13973b;
                fArr[2] = fArr[2] + (f5 * floatValue);
                fArr[5] = fArr[5] + (f6 * floatValue);
                fArr[0] = fArr[0] + (f3 * floatValue);
                fArr[4] = fArr[4] + (f4 * floatValue);
                this.f13972a.setValues(fArr);
                ZoomageView.this.setImageMatrix(this.f13972a);
            }
        });
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    private void e() {
        if (getCurrentDisplayedWidth() > ((float) getWidth())) {
            if (this.m.left > 0.0f) {
                a(2, 0.0f);
            } else if (this.m.right < ((float) getWidth())) {
                a(2, (this.m.left + ((float) getWidth())) - this.m.right);
            }
        } else if (this.m.left < 0.0f) {
            a(2, 0.0f);
        } else if (this.m.right > ((float) getWidth())) {
            a(2, (this.m.left + ((float) getWidth())) - this.m.right);
        }
    }

    private void f() {
        if (getCurrentDisplayedHeight() > ((float) getHeight())) {
            if (this.m.top > 0.0f) {
                a(5, 0.0f);
            } else if (this.m.bottom < ((float) getHeight())) {
                a(5, (this.m.top + ((float) getHeight())) - this.m.bottom);
            }
        } else if (this.m.top < 0.0f) {
            a(5, 0.0f);
        } else if (this.m.bottom > ((float) getHeight())) {
            a(5, (this.m.top + ((float) getHeight())) - this.m.bottom);
        }
    }

    private void a(final int i2, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f13969g[i2], f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            final float[] f13980a = new float[9];

            /* renamed from: b  reason: collision with root package name */
            Matrix f13981b = new Matrix();

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f13981b.set(ZoomageView.this.getImageMatrix());
                this.f13981b.getValues(this.f13980a);
                this.f13980a[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f13981b.setValues(this.f13980a);
                ZoomageView.this.setImageMatrix(this.f13981b);
            }
        });
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = this.u * scaleGestureDetector.getScaleFactor();
        float[] fArr = this.f13969g;
        this.v = scaleFactor / fArr[0];
        float f2 = this.v * fArr[0];
        float f3 = this.k;
        if (f2 < f3) {
            this.v = f3 / fArr[0];
        } else {
            float f4 = this.l;
            if (f2 > f4) {
                this.v = f4 / fArr[0];
            }
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.u = this.f13969g[0];
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.v = 1.0f;
    }
}
