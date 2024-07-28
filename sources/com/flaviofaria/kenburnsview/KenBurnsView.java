package com.flaviofaria.kenburnsview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class KenBurnsView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f31038a;

    /* renamed from: b  reason: collision with root package name */
    private e f31039b;

    /* renamed from: c  reason: collision with root package name */
    private a f31040c;

    /* renamed from: d  reason: collision with root package name */
    private d f31041d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f31042e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f31043f;

    /* renamed from: g  reason: collision with root package name */
    private long f31044g;

    /* renamed from: h  reason: collision with root package name */
    private long f31045h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31046i;
    private boolean j;

    public interface a {
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public KenBurnsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KenBurnsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KenBurnsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f31038a = new Matrix();
        this.f31039b = new c();
        this.f31042e = new RectF();
        this.j = true;
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0) {
            this.f31046i = true;
            return;
        }
        this.f31046i = false;
        this.f31045h = System.currentTimeMillis();
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        d();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        d();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int width = getWidth();
        int height = getHeight();
        if (width != 0 && height != 0) {
            this.f31042e.set(0.0f, 0.0f, (float) width, (float) height);
            c();
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (!this.f31046i && drawable != null) {
            if (this.f31043f.isEmpty()) {
                c();
            } else if (b()) {
                if (this.f31041d == null) {
                    a();
                }
                if (this.f31041d.f31053b != null) {
                    this.f31044g += System.currentTimeMillis() - this.f31045h;
                    d dVar = this.f31041d;
                    float interpolation = dVar.f31060i.getInterpolation(Math.min(((float) this.f31044g) / ((float) dVar.f31059h), 1.0f));
                    float width = dVar.f31052a.width() + (dVar.f31055d * interpolation);
                    float height = dVar.f31052a.height() + (dVar.f31056e * interpolation);
                    float centerX = (dVar.f31052a.centerX() + (dVar.f31057f * interpolation)) - (width / 2.0f);
                    float centerY = (dVar.f31052a.centerY() + (interpolation * dVar.f31058g)) - (height / 2.0f);
                    dVar.f31054c.set(centerX, centerY, width + centerX, height + centerY);
                    RectF rectF = dVar.f31054c;
                    float min = Math.min(this.f31043f.width() / rectF.width(), this.f31043f.height() / rectF.height()) * Math.min(this.f31042e.width() / rectF.width(), this.f31042e.height() / rectF.height());
                    this.f31038a.reset();
                    this.f31038a.postTranslate((-this.f31043f.width()) / 2.0f, (-this.f31043f.height()) / 2.0f);
                    this.f31038a.postScale(min, min);
                    this.f31038a.postTranslate((this.f31043f.centerX() - rectF.left) * min, (this.f31043f.centerY() - rectF.top) * min);
                    setImageMatrix(this.f31038a);
                    if (this.f31044g >= this.f31041d.f31059h) {
                        a();
                    }
                }
            }
            this.f31045h = System.currentTimeMillis();
            postInvalidateDelayed(16);
        }
        super.onDraw(canvas);
    }

    private void a() {
        if (b()) {
            this.f31041d = this.f31039b.a(this.f31043f, this.f31042e);
            this.f31044g = 0;
            this.f31045h = System.currentTimeMillis();
        }
    }

    private boolean b() {
        return !this.f31042e.isEmpty();
    }

    public void setTransitionGenerator(e eVar) {
        this.f31039b = eVar;
        a();
    }

    private void c() {
        if (this.f31043f == null) {
            this.f31043f = new RectF();
        }
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            this.f31043f.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    private void d() {
        c();
        if (this.j) {
            a();
        }
    }

    public void setTransitionListener(a aVar) {
        this.f31040c = aVar;
    }
}
