package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import java.util.HashSet;

public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    boolean f33741a = false;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f33742b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f33743c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f33744d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f33745e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f33746f;

    /* renamed from: g  reason: collision with root package name */
    private final int f33747g;

    /* renamed from: h  reason: collision with root package name */
    private final int f33748h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f33749i = new RectF();
    private final Paint j;
    private final Matrix k = new Matrix();
    private final RectF l = new RectF();
    private Shader.TileMode m = Shader.TileMode.CLAMP;
    private Shader.TileMode n = Shader.TileMode.CLAMP;
    private boolean o = true;
    private float p = 0.0f;
    private final boolean[] q = {true, true, true, true};
    private float r = 0.0f;
    private ColorStateList s = ColorStateList.valueOf(-16777216);
    private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;

    public final int getOpacity() {
        return -3;
    }

    private a(Bitmap bitmap) {
        this.f33745e = bitmap;
        this.f33747g = bitmap.getWidth();
        this.f33748h = bitmap.getHeight();
        this.f33744d.set(0.0f, 0.0f, (float) this.f33747g, (float) this.f33748h);
        this.f33746f = new Paint();
        this.f33746f.setStyle(Paint.Style.FILL);
        this.f33746f.setAntiAlias(true);
        this.j = new Paint();
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setAntiAlias(true);
        this.j.setColor(this.s.getColorForState(getState(), -16777216));
        this.j.setStrokeWidth(this.r);
    }

    public static a a(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), a(layerDrawable.getDrawable(i2)));
            }
            return layerDrawable;
        }
        Bitmap b2 = b(drawable);
        return b2 != null ? new a(b2) : drawable;
    }

    private static Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean isStateful() {
        return this.s.isStateful();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.j.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.j.setColor(colorForState);
        return true;
    }

    /* renamed from: com.makeramen.roundedimageview.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33750a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33750a = r0
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x004b }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f33750a     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.makeramen.roundedimageview.a.AnonymousClass1.<clinit>():void");
        }
    }

    private void a() {
        float f2;
        float f3;
        float f4;
        int i2 = AnonymousClass1.f33750a[this.t.ordinal()];
        if (i2 == 1) {
            this.f33749i.set(this.f33742b);
            RectF rectF = this.f33749i;
            float f5 = this.r;
            rectF.inset(f5 / 2.0f, f5 / 2.0f);
            this.k.reset();
            this.k.setTranslate((float) ((int) (((this.f33749i.width() - ((float) this.f33747g)) * 0.5f) + 0.5f)), (float) ((int) (((this.f33749i.height() - ((float) this.f33748h)) * 0.5f) + 0.5f)));
        } else if (i2 == 2) {
            this.f33749i.set(this.f33742b);
            RectF rectF2 = this.f33749i;
            float f6 = this.r;
            rectF2.inset(f6 / 2.0f, f6 / 2.0f);
            this.k.reset();
            float f7 = 0.0f;
            if (((float) this.f33747g) * this.f33749i.height() > this.f33749i.width() * ((float) this.f33748h)) {
                f3 = this.f33749i.height() / ((float) this.f33748h);
                f2 = (this.f33749i.width() - (((float) this.f33747g) * f3)) * 0.5f;
            } else {
                f3 = this.f33749i.width() / ((float) this.f33747g);
                f7 = (this.f33749i.height() - (((float) this.f33748h) * f3)) * 0.5f;
                f2 = 0.0f;
            }
            this.k.setScale(f3, f3);
            Matrix matrix = this.k;
            float f8 = this.r;
            matrix.postTranslate(((float) ((int) (f2 + 0.5f))) + (f8 / 2.0f), ((float) ((int) (f7 + 0.5f))) + (f8 / 2.0f));
        } else if (i2 == 3) {
            this.k.reset();
            if (((float) this.f33747g) > this.f33742b.width() || ((float) this.f33748h) > this.f33742b.height()) {
                f4 = Math.min(this.f33742b.width() / ((float) this.f33747g), this.f33742b.height() / ((float) this.f33748h));
            } else {
                f4 = 1.0f;
            }
            this.k.setScale(f4, f4);
            this.k.postTranslate((float) ((int) (((this.f33742b.width() - (((float) this.f33747g) * f4)) * 0.5f) + 0.5f)), (float) ((int) (((this.f33742b.height() - (((float) this.f33748h) * f4)) * 0.5f) + 0.5f)));
            this.f33749i.set(this.f33744d);
            this.k.mapRect(this.f33749i);
            RectF rectF3 = this.f33749i;
            float f9 = this.r;
            rectF3.inset(f9 / 2.0f, f9 / 2.0f);
            this.k.setRectToRect(this.f33744d, this.f33749i, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f33749i.set(this.f33744d);
            this.k.setRectToRect(this.f33744d, this.f33742b, Matrix.ScaleToFit.END);
            this.k.mapRect(this.f33749i);
            RectF rectF4 = this.f33749i;
            float f10 = this.r;
            rectF4.inset(f10 / 2.0f, f10 / 2.0f);
            this.k.setRectToRect(this.f33744d, this.f33749i, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f33749i.set(this.f33744d);
            this.k.setRectToRect(this.f33744d, this.f33742b, Matrix.ScaleToFit.START);
            this.k.mapRect(this.f33749i);
            RectF rectF5 = this.f33749i;
            float f11 = this.r;
            rectF5.inset(f11 / 2.0f, f11 / 2.0f);
            this.k.setRectToRect(this.f33744d, this.f33749i, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f33749i.set(this.f33744d);
            this.k.setRectToRect(this.f33744d, this.f33742b, Matrix.ScaleToFit.CENTER);
            this.k.mapRect(this.f33749i);
            RectF rectF6 = this.f33749i;
            float f12 = this.r;
            rectF6.inset(f12 / 2.0f, f12 / 2.0f);
            this.k.setRectToRect(this.f33744d, this.f33749i, Matrix.ScaleToFit.FILL);
        } else {
            this.f33749i.set(this.f33742b);
            RectF rectF7 = this.f33749i;
            float f13 = this.r;
            rectF7.inset(f13 / 2.0f, f13 / 2.0f);
            this.k.reset();
            this.k.setRectToRect(this.f33744d, this.f33749i, Matrix.ScaleToFit.FILL);
        }
        this.f33743c.set(this.f33749i);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f33742b.set(rect);
        a();
    }

    public final void draw(Canvas canvas) {
        if (this.o) {
            BitmapShader bitmapShader = new BitmapShader(this.f33745e, this.m, this.n);
            if (this.m == Shader.TileMode.CLAMP && this.n == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.k);
            }
            this.f33746f.setShader(bitmapShader);
            this.o = false;
        }
        if (this.f33741a) {
            if (this.r > 0.0f) {
                canvas.drawOval(this.f33743c, this.f33746f);
                canvas.drawOval(this.f33749i, this.j);
                return;
            }
            canvas.drawOval(this.f33743c, this.f33746f);
        } else if (a(this.q)) {
            float f2 = this.p;
            if (this.r > 0.0f) {
                canvas.drawRoundRect(this.f33743c, f2, f2, this.f33746f);
                canvas.drawRoundRect(this.f33749i, f2, f2, this.j);
                a(canvas);
                if (!b(this.q) && this.p != 0.0f) {
                    float f3 = this.f33743c.left;
                    float f4 = this.f33743c.top;
                    float width = f3 + this.f33743c.width();
                    float height = f4 + this.f33743c.height();
                    float f5 = this.p;
                    float f6 = this.r / 2.0f;
                    if (!this.q[0]) {
                        canvas.drawLine(f3 - f6, f4, f3 + f5, f4, this.j);
                        canvas.drawLine(f3, f4 - f6, f3, f4 + f5, this.j);
                    }
                    if (!this.q[1]) {
                        Canvas canvas2 = canvas;
                        float f7 = width;
                        canvas2.drawLine((width - f5) - f6, f4, f7, f4, this.j);
                        canvas2.drawLine(width, f4 - f6, f7, f4 + f5, this.j);
                    }
                    if (!this.q[2]) {
                        Canvas canvas3 = canvas;
                        float f8 = height;
                        canvas3.drawLine((width - f5) - f6, height, width + f6, f8, this.j);
                        canvas3.drawLine(width, height - f5, width, f8, this.j);
                    }
                    if (!this.q[3]) {
                        canvas.drawLine(f3 - f6, height, f3 + f5, height, this.j);
                        canvas.drawLine(f3, height - f5, f3, height, this.j);
                        return;
                    }
                    return;
                }
                return;
            }
            canvas.drawRoundRect(this.f33743c, f2, f2, this.f33746f);
            a(canvas);
        } else {
            canvas.drawRect(this.f33743c, this.f33746f);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f33749i, this.j);
            }
        }
    }

    private void a(Canvas canvas) {
        if (!b(this.q) && this.p != 0.0f) {
            float f2 = this.f33743c.left;
            float f3 = this.f33743c.top;
            float width = this.f33743c.width() + f2;
            float height = this.f33743c.height() + f3;
            float f4 = this.p;
            if (!this.q[0]) {
                this.l.set(f2, f3, f2 + f4, f3 + f4);
                canvas.drawRect(this.l, this.f33746f);
            }
            if (!this.q[1]) {
                this.l.set(width - f4, f3, width, f4);
                canvas.drawRect(this.l, this.f33746f);
            }
            if (!this.q[2]) {
                this.l.set(width - f4, height - f4, width, height);
                canvas.drawRect(this.l, this.f33746f);
            }
            if (!this.q[3]) {
                this.l.set(f2, height - f4, f4 + f2, height);
                canvas.drawRect(this.l, this.f33746f);
            }
        }
    }

    public final int getAlpha() {
        return this.f33746f.getAlpha();
    }

    public final void setAlpha(int i2) {
        this.f33746f.setAlpha(i2);
        invalidateSelf();
    }

    public final ColorFilter getColorFilter() {
        return this.f33746f.getColorFilter();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f33746f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setDither(boolean z) {
        this.f33746f.setDither(z);
        invalidateSelf();
    }

    public final void setFilterBitmap(boolean z) {
        this.f33746f.setFilterBitmap(z);
        invalidateSelf();
    }

    public final int getIntrinsicWidth() {
        return this.f33747g;
    }

    public final int getIntrinsicHeight() {
        return this.f33748h;
    }

    public final a a(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
                }
                this.p = floatValue;
            } else {
                this.p = 0.0f;
            }
            boolean z = false;
            this.q[0] = f2 > 0.0f;
            this.q[1] = f3 > 0.0f;
            this.q[2] = f4 > 0.0f;
            boolean[] zArr = this.q;
            if (f5 > 0.0f) {
                z = true;
            }
            zArr[3] = z;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public final a a(float f2) {
        this.r = f2;
        this.j.setStrokeWidth(this.r);
        return this;
    }

    public final a a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.j.setColor(this.s.getColorForState(getState(), -16777216));
        return this;
    }

    public final a a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            a();
        }
        return this;
    }

    public final a a(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.o = true;
            invalidateSelf();
        }
        return this;
    }

    public final a b(Shader.TileMode tileMode) {
        if (this.n != tileMode) {
            this.n = tileMode;
            this.o = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
