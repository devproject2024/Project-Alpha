package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

public abstract class ImageViewTouchBase extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f47836a;

    /* renamed from: b  reason: collision with root package name */
    private float f47837b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f47838c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47839d;

    /* renamed from: e  reason: collision with root package name */
    private int f47840e;

    /* renamed from: f  reason: collision with root package name */
    private int f47841f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f47842g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47843h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f47844i;
    private b j;
    protected it.sephiroth.android.library.easing.b k;
    protected Matrix l;
    protected Matrix m;
    protected Matrix n;
    protected Handler o;
    protected Runnable p;
    protected boolean q;
    protected final Matrix r;
    protected final float[] s;
    protected a t;
    protected final int u;
    protected RectF v;
    protected RectF w;
    protected RectF x;
    private c y;

    public enum a {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    public interface b {
    }

    public interface c {
    }

    /* access modifiers changed from: protected */
    public void a(float f2) {
    }

    public float getRotation() {
        return 0.0f;
    }

    public ImageViewTouchBase(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new it.sephiroth.android.library.easing.a();
        this.l = new Matrix();
        this.m = new Matrix();
        this.o = new Handler();
        this.p = null;
        this.q = false;
        this.f47836a = -1.0f;
        this.f47837b = -1.0f;
        this.r = new Matrix();
        this.s = new float[9];
        this.f47840e = -1;
        this.f47841f = -1;
        this.f47842g = new PointF();
        this.t = a.NONE;
        this.u = 200;
        this.v = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        a(context, attributeSet, i2);
    }

    public void setOnDrawableChangedListener(b bVar) {
        this.j = bVar;
    }

    public void setOnLayoutChangeListener(c cVar) {
        this.y = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, AttributeSet attributeSet, int i2) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void setDisplayType(a aVar) {
        if (aVar != this.t) {
            this.q = false;
            this.t = aVar;
            this.f47843h = true;
            requestLayout();
        }
    }

    public a getDisplayType() {
        return this.t;
    }

    /* access modifiers changed from: protected */
    public void setMinScale(float f2) {
        this.f47837b = f2;
    }

    /* access modifiers changed from: protected */
    public void setMaxScale(float f2) {
        this.f47836a = f2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0124, code lost:
        if (r9 != getScale()) goto L_0x0126;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            r16 = this;
            r0 = r16
            super.onLayout(r17, r18, r19, r20, r21)
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 0
            if (r17 == 0) goto L_0x0029
            int r3 = r0.f47840e
            int r4 = r0.f47841f
            int r5 = r20 - r18
            r0.f47840e = r5
            int r5 = r21 - r19
            r0.f47841f = r5
            int r5 = r0.f47840e
            int r3 = r5 - r3
            int r6 = r0.f47841f
            int r4 = r6 - r4
            android.graphics.PointF r7 = r0.f47842g
            float r5 = (float) r5
            float r5 = r5 / r1
            r7.x = r5
            float r5 = (float) r6
            float r5 = r5 / r1
            r7.y = r5
            goto L_0x002b
        L_0x0029:
            r3 = 0
            r4 = 0
        L_0x002b:
            java.lang.Runnable r5 = r0.p
            r6 = 0
            if (r5 == 0) goto L_0x0035
            r0.p = r6
            r5.run()
        L_0x0035:
            android.graphics.drawable.Drawable r5 = r16.getDrawable()
            if (r5 == 0) goto L_0x014e
            if (r17 != 0) goto L_0x0045
            boolean r7 = r0.f47843h
            if (r7 != 0) goto L_0x0045
            boolean r7 = r0.f47844i
            if (r7 == 0) goto L_0x015a
        L_0x0045:
            it.sephiroth.android.library.imagezoom.ImageViewTouchBase$a r7 = r0.t
            r0.a((it.sephiroth.android.library.imagezoom.ImageViewTouchBase.a) r7)
            android.graphics.Matrix r7 = r0.l
            float r7 = r0.c((android.graphics.Matrix) r7)
            float r8 = r16.getScale()
            r9 = 1065353216(0x3f800000, float:1.0)
            float r10 = r9 / r7
            float r10 = java.lang.Math.min(r9, r10)
            android.graphics.Matrix r11 = r0.l
            int r12 = r0.f47840e
            float r12 = (float) r12
            int r13 = r0.f47841f
            float r13 = (float) r13
            int r14 = r5.getIntrinsicWidth()
            float r14 = (float) r14
            int r5 = r5.getIntrinsicHeight()
            float r5 = (float) r5
            r11.reset()
            int r15 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r15 > 0) goto L_0x0091
            int r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x007a
            goto L_0x0091
        L_0x007a:
            float r15 = r12 / r14
            float r9 = r13 / r5
            float r9 = java.lang.Math.min(r15, r9)
            r11.postScale(r9, r9)
            float r14 = r14 * r9
            float r12 = r12 - r14
            float r12 = r12 / r1
            float r5 = r5 * r9
            float r13 = r13 - r5
            float r13 = r13 / r1
            r11.postTranslate(r12, r13)
            goto L_0x00a7
        L_0x0091:
            float r9 = r12 / r14
            float r15 = r13 / r5
            float r9 = java.lang.Math.min(r9, r15)
            r11.postScale(r9, r9)
            float r14 = r14 * r9
            float r12 = r12 - r14
            float r12 = r12 / r1
            float r5 = r5 * r9
            float r13 = r13 - r5
            float r13 = r13 / r1
            r11.postTranslate(r12, r13)
        L_0x00a7:
            android.graphics.Matrix r1 = r0.l
            float r1 = r0.c((android.graphics.Matrix) r1)
            boolean r5 = r0.f47844i
            if (r5 != 0) goto L_0x00fb
            boolean r5 = r0.f47843h
            if (r5 == 0) goto L_0x00b6
            goto L_0x00fb
        L_0x00b6:
            if (r17 == 0) goto L_0x00f8
            boolean r5 = r0.f47839d
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r5 != 0) goto L_0x00c0
            r0.f47837b = r6
        L_0x00c0:
            boolean r5 = r0.f47838c
            if (r5 != 0) goto L_0x00c6
            r0.f47836a = r6
        L_0x00c6:
            android.graphics.Matrix r5 = r16.getImageViewMatrix()
            r0.setImageMatrix(r5)
            int r3 = -r3
            float r3 = (float) r3
            int r4 = -r4
            float r4 = (float) r4
            r0.a((float) r3, (float) r4)
            boolean r3 = r0.q
            if (r3 != 0) goto L_0x00e0
            it.sephiroth.android.library.imagezoom.ImageViewTouchBase$a r1 = r0.t
            float r1 = r0.a((it.sephiroth.android.library.imagezoom.ImageViewTouchBase.a) r1)
            r9 = r1
            goto L_0x0126
        L_0x00e0:
            float r3 = r8 - r10
            float r3 = java.lang.Math.abs(r3)
            double r3 = (double) r3
            r5 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x00f5
            float r7 = r7 / r1
            float r7 = r7 * r8
            r9 = r7
            goto L_0x0126
        L_0x00f5:
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0126
        L_0x00f8:
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0129
        L_0x00fb:
            android.graphics.Matrix r1 = r0.n
            if (r1 == 0) goto L_0x010b
            android.graphics.Matrix r3 = r0.m
            r3.set(r1)
            r0.n = r6
            float r1 = r16.getScale()
            goto L_0x0116
        L_0x010b:
            android.graphics.Matrix r1 = r0.m
            r1.reset()
            it.sephiroth.android.library.imagezoom.ImageViewTouchBase$a r1 = r0.t
            float r1 = r0.a((it.sephiroth.android.library.imagezoom.ImageViewTouchBase.a) r1)
        L_0x0116:
            r9 = r1
            android.graphics.Matrix r1 = r16.getImageViewMatrix()
            r0.setImageMatrix(r1)
            float r1 = r16.getScale()
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0129
        L_0x0126:
            r0.c((float) r9)
        L_0x0129:
            r0.q = r2
            float r1 = r16.getMaxScale()
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x013b
            float r1 = r16.getMinScale()
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x013e
        L_0x013b:
            r0.c((float) r9)
        L_0x013e:
            r16.b()
            boolean r1 = r0.f47843h
            if (r1 == 0) goto L_0x0147
            r0.f47843h = r2
        L_0x0147:
            boolean r1 = r0.f47844i
            if (r1 == 0) goto L_0x014d
            r0.f47844i = r2
        L_0x014d:
            return
        L_0x014e:
            boolean r1 = r0.f47844i
            if (r1 == 0) goto L_0x0154
            r0.f47844i = r2
        L_0x0154:
            boolean r1 = r0.f47843h
            if (r1 == 0) goto L_0x015a
            r0.f47843h = r2
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.imagezoom.ImageViewTouchBase.onLayout(boolean, int, int, int, int):void");
    }

    public final void a() {
        this.m = new Matrix();
        float a2 = a(this.t);
        setImageMatrix(getImageViewMatrix());
        if (a2 != getScale()) {
            c(a2);
        }
        postInvalidate();
    }

    private float a(a aVar) {
        if (aVar == a.FIT_TO_SCREEN) {
            return 1.0f;
        }
        if (aVar == a.FIT_IF_BIGGER) {
            return Math.min(1.0f, 1.0f / c(this.l));
        }
        return 1.0f / c(this.l);
    }

    public void setImageResource(int i2) {
        setImageDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, (Matrix) null, -1.0f, -1.0f);
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f2, float f3) {
        if (bitmap != null) {
            setImageDrawable(new it.sephiroth.android.library.imagezoom.a.a(bitmap), matrix, f2, f3);
        } else {
            setImageDrawable((Drawable) null, matrix, f2, f3);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, (Matrix) null, -1.0f, -1.0f);
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (getWidth() <= 0) {
            final Drawable drawable2 = drawable;
            final Matrix matrix2 = matrix;
            final float f4 = f2;
            final float f5 = f3;
            this.p = new Runnable() {
                public final void run() {
                    ImageViewTouchBase.this.setImageDrawable(drawable2, matrix2, f4, f5);
                }
            };
            return;
        }
        a(drawable, matrix, f2, f3);
    }

    /* access modifiers changed from: protected */
    public void a(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.l.reset();
            super.setImageDrawable((Drawable) null);
        }
        if (f2 == -1.0f || f3 == -1.0f) {
            this.f47837b = -1.0f;
            this.f47836a = -1.0f;
            this.f47839d = false;
            this.f47838c = false;
        } else {
            float min = Math.min(f2, f3);
            float max = Math.max(min, f3);
            this.f47837b = min;
            this.f47836a = max;
            this.f47839d = true;
            this.f47838c = true;
            if (this.t == a.FIT_TO_SCREEN || this.t == a.FIT_IF_BIGGER) {
                if (this.f47837b >= 1.0f) {
                    this.f47839d = false;
                    this.f47837b = -1.0f;
                }
                if (this.f47836a <= 1.0f) {
                    this.f47838c = true;
                    this.f47836a = -1.0f;
                }
            }
        }
        if (matrix != null) {
            this.n = new Matrix(matrix);
        }
        this.f47844i = true;
        requestLayout();
    }

    public float getMaxScale() {
        float f2;
        if (this.f47836a == -1.0f) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                f2 = 1.0f;
            } else {
                f2 = Math.max(((float) drawable.getIntrinsicWidth()) / ((float) this.f47840e), ((float) drawable.getIntrinsicHeight()) / ((float) this.f47841f)) * 8.0f;
            }
            this.f47836a = f2;
        }
        return this.f47836a;
    }

    public float getMinScale() {
        if (this.f47837b == -1.0f) {
            float f2 = 1.0f;
            if (getDrawable() != null) {
                f2 = Math.min(1.0f, 1.0f / c(this.l));
            }
            this.f47837b = f2;
        }
        return this.f47837b;
    }

    public Matrix getImageViewMatrix() {
        return b(this.m);
    }

    private Matrix b(Matrix matrix) {
        this.r.set(this.l);
        this.r.postConcat(matrix);
        return this.r;
    }

    public void setImageMatrix(Matrix matrix) {
        Matrix imageMatrix = getImageMatrix();
        if ((matrix != null || imageMatrix.isIdentity()) && matrix != null) {
            imageMatrix.equals(matrix);
        }
        super.setImageMatrix(matrix);
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.m);
    }

    private float c(Matrix matrix) {
        matrix.getValues(this.s);
        return this.s[0];
    }

    public RectF getBitmapRect() {
        return d(this.m);
    }

    private RectF d(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix b2 = b(matrix);
        this.v.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        b2.mapRect(this.v);
        return this.v;
    }

    public float getScale() {
        return c(this.m);
    }

    public float getBaseScale() {
        return c(this.l);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (getDrawable() != null) {
            RectF a2 = a(this.m);
            if (a2.left != 0.0f || a2.top != 0.0f) {
                a(a2.left, a2.top);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final RectF a(Matrix matrix) {
        float f2;
        float f3;
        float f4;
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.w.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF d2 = d(matrix);
        float height = d2.height();
        float width = d2.width();
        float f5 = (float) this.f47841f;
        if (height < f5) {
            f2 = ((f5 - height) / 2.0f) - d2.top;
        } else if (d2.top > 0.0f) {
            f2 = -d2.top;
        } else {
            f2 = d2.bottom < f5 ? ((float) this.f47841f) - d2.bottom : 0.0f;
        }
        float f6 = (float) this.f47840e;
        if (width < f6) {
            f6 = (f6 - width) / 2.0f;
            f4 = d2.left;
        } else {
            if (d2.left > 0.0f) {
                f3 = -d2.left;
            } else if (d2.right < f6) {
                f4 = d2.right;
            } else {
                f3 = 0.0f;
            }
            this.w.set(f3, f2, 0.0f, 0.0f);
            return this.w;
        }
        f3 = f6 - f4;
        this.w.set(f3, f2, 0.0f, 0.0f);
        return this.w;
    }

    private void a(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.m.postTranslate(f2, f3);
            setImageMatrix(getImageViewMatrix());
        }
    }

    private void b(float f2, float f3, float f4) {
        this.m.postScale(f2, f2, f3, f4);
        setImageMatrix(getImageViewMatrix());
    }

    /* access modifiers changed from: protected */
    public PointF getCenter() {
        return this.f47842g;
    }

    private void c(float f2) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        if (f2 < getMinScale()) {
            f2 = getMinScale();
        }
        PointF center = getCenter();
        a(f2, center.x, center.y);
    }

    public final void b(float f2) {
        PointF center = getCenter();
        a(f2, center.x, center.y, 50.0f);
    }

    /* access modifiers changed from: protected */
    public final void a(float f2, float f3, float f4) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        b(f2 / getScale(), f3, f4);
        getScale();
        b();
    }

    public final void c(float f2, float f3) {
        a((double) f2, (double) f3);
    }

    /* access modifiers changed from: protected */
    public final void a(double d2, double d3) {
        RectF bitmapRect = getBitmapRect();
        this.x.set((float) d2, (float) d3, 0.0f, 0.0f);
        a(bitmapRect, this.x);
        a(this.x.left, this.x.top);
        b();
    }

    /* access modifiers changed from: protected */
    public final void a(RectF rectF, RectF rectF2) {
        if (rectF != null) {
            if (rectF.top >= 0.0f && rectF.bottom <= ((float) this.f47841f)) {
                rectF2.top = 0.0f;
            }
            if (rectF.left >= 0.0f && rectF.right <= ((float) this.f47840e)) {
                rectF2.left = 0.0f;
            }
            if (rectF.top + rectF2.top >= 0.0f && rectF.bottom > ((float) this.f47841f)) {
                rectF2.top = (float) ((int) (0.0f - rectF.top));
            }
            if (rectF.bottom + rectF2.top <= ((float) (this.f47841f + 0)) && rectF.top < 0.0f) {
                rectF2.top = (float) ((int) (((float) (this.f47841f + 0)) - rectF.bottom));
            }
            if (rectF.left + rectF2.left >= 0.0f) {
                rectF2.left = (float) ((int) (0.0f - rectF.left));
            }
            float f2 = rectF.right + rectF2.left;
            int i2 = this.f47840e;
            if (f2 <= ((float) (i2 + 0))) {
                rectF2.left = (float) ((int) (((float) (i2 + 0)) - rectF.right));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void d(float f2, float f3) {
        final double d2 = (double) f2;
        final double d3 = (double) f3;
        final long currentTimeMillis = System.currentTimeMillis();
        this.o.post(new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            double f47850a;

            /* renamed from: b  reason: collision with root package name */
            double f47851b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ double f47852c = 300.0d;

            {
                this.f47850a = 0.0d;
                this.f47851b = 0.0d;
            }

            public final void run() {
                double min = Math.min(this.f47852c, (double) (System.currentTimeMillis() - currentTimeMillis));
                double d2 = min;
                double a2 = ImageViewTouchBase.this.k.a(d2, d2, this.f47852c);
                double a3 = ImageViewTouchBase.this.k.a(d2, d3, this.f47852c);
                ImageViewTouchBase.this.a(a2 - this.f47850a, a3 - this.f47851b);
                this.f47850a = a2;
                this.f47851b = a3;
                if (min < this.f47852c) {
                    ImageViewTouchBase.this.o.post(this);
                    return;
                }
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                RectF a4 = imageViewTouchBase.a(imageViewTouchBase.m);
                if (a4.left != 0.0f || a4.top != 0.0f) {
                    ImageViewTouchBase.this.c(a4.left, a4.top);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a(float f2, float f3, float f4, float f5) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final float scale = getScale();
        final float f6 = f2 - scale;
        Matrix matrix = new Matrix(this.m);
        matrix.postScale(f2, f2, f3, f4);
        RectF a2 = a(matrix);
        final float f7 = f3 + (a2.left * f2);
        final float f8 = f4 + (a2.top * f2);
        final float f9 = f5;
        this.o.post(new Runnable() {
            public final void run() {
                float min = Math.min(f9, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.a(scale + ((float) ImageViewTouchBase.this.k.b((double) min, (double) f6, (double) f9)), f7, f8);
                if (min < f9) {
                    ImageViewTouchBase.this.o.post(this);
                    return;
                }
                ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
                imageViewTouchBase.a(imageViewTouchBase.getScale());
                ImageViewTouchBase.this.b();
            }
        });
    }
}
