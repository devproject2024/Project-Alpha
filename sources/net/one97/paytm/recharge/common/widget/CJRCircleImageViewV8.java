package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.recharge.R;

public class CJRCircleImageViewV8 extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageView.ScaleType f61850a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f61851b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f61852c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f61853d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f61854e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f61855f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f61856g;

    /* renamed from: h  reason: collision with root package name */
    private int f61857h;

    /* renamed from: i  reason: collision with root package name */
    private int f61858i;
    private Bitmap j;
    private BitmapShader k;
    private int l;
    private int m;
    private float n;
    private float o;
    private ColorFilter p;
    private boolean q;
    private boolean r;
    private boolean s;

    public CJRCircleImageViewV8(Context context) {
        super(context);
        this.f61852c = new RectF();
        this.f61853d = new RectF();
        this.f61854e = new Matrix();
        this.f61855f = new Paint();
        this.f61856g = new Paint();
        this.f61857h = -16777216;
        this.f61858i = 0;
        a();
    }

    public CJRCircleImageViewV8(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRCircleImageViewV8(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f61852c = new RectF();
        this.f61853d = new RectF();
        this.f61854e = new Matrix();
        this.f61855f = new Paint();
        this.f61856g = new Paint();
        this.f61857h = -16777216;
        this.f61858i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i2, 0);
        this.f61858i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_border_width, 0);
        this.f61857h = obtainStyledAttributes.getColor(R.styleable.CircleImageView_border_color, -16777216);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_border_overlay, false);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        super.setScaleType(f61850a);
        this.q = true;
        if (this.r) {
            b();
            this.r = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f61850a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f61850a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.n, this.f61855f);
            if (this.f61858i != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.o, this.f61856g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    public int getBorderColor() {
        return this.f61857h;
    }

    public void setBorderColor(int i2) {
        if (i2 != this.f61857h) {
            this.f61857h = i2;
            this.f61856g.setColor(this.f61857h);
            invalidate();
        }
    }

    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public int getBorderWidth() {
        return this.f61858i;
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.f61858i) {
            this.f61858i = i2;
            b();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.s) {
            this.s = z;
            b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.j = bitmap;
        b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.j = a(drawable);
        b();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        this.j = a(getDrawable());
        b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.j = a(getDrawable());
        b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.p) {
            this.p = colorFilter;
            this.f61855f.setColorFilter(this.p);
            invalidate();
        }
    }

    private static Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f61851b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f61851b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void b() {
        if (!this.q) {
            this.r = true;
            return;
        }
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.k = new BitmapShader(bitmap, tileMode, tileMode);
            this.f61855f.setAntiAlias(true);
            this.f61855f.setShader(this.k);
            this.f61856g.setStyle(Paint.Style.STROKE);
            this.f61856g.setAntiAlias(true);
            this.f61856g.setColor(this.f61857h);
            this.f61856g.setStrokeWidth((float) this.f61858i);
            this.m = this.j.getHeight();
            this.l = this.j.getWidth();
            this.f61853d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.o = Math.min((this.f61853d.height() - ((float) this.f61858i)) / 2.0f, (this.f61853d.width() - ((float) this.f61858i)) / 2.0f);
            this.f61852c.set(this.f61853d);
            if (!this.s) {
                RectF rectF = this.f61852c;
                int i2 = this.f61858i;
                rectF.inset((float) i2, (float) i2);
            }
            this.n = Math.min(this.f61852c.height() / 2.0f, this.f61852c.width() / 2.0f);
            c();
            invalidate();
        }
    }

    private void c() {
        float f2;
        float f3;
        this.f61854e.set((Matrix) null);
        float f4 = 0.0f;
        if (((float) this.l) * this.f61852c.height() > this.f61852c.width() * ((float) this.m)) {
            f3 = this.f61852c.height() / ((float) this.m);
            f2 = (this.f61852c.width() - (((float) this.l) * f3)) * 0.5f;
        } else {
            f3 = this.f61852c.width() / ((float) this.l);
            f4 = (this.f61852c.height() - (((float) this.m) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        this.f61854e.setScale(f3, f3);
        this.f61854e.postTranslate(((float) ((int) (f2 + 0.5f))) + this.f61852c.left, ((float) ((int) (f4 + 0.5f))) + this.f61852c.top);
        this.k.setLocalMatrix(this.f61854e);
    }
}
