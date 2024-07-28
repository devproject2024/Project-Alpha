package net.one97.paytm.wallet.views;

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
import com.android.volley.toolbox.NetworkImageView;
import net.one97.paytm.R;

public class CircleImageView extends NetworkImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageView.ScaleType f72324a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f72325b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f72326c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f72327d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f72328e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f72329f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f72330g;

    /* renamed from: h  reason: collision with root package name */
    private int f72331h;

    /* renamed from: i  reason: collision with root package name */
    private int f72332i;
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

    public CircleImageView(Context context) {
        super(context);
        this.f72326c = new RectF();
        this.f72327d = new RectF();
        this.f72328e = new Matrix();
        this.f72329f = new Paint();
        this.f72330g = new Paint();
        this.f72331h = -16777216;
        this.f72332i = 0;
        a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72326c = new RectF();
        this.f72327d = new RectF();
        this.f72328e = new Matrix();
        this.f72329f = new Paint();
        this.f72330g = new Paint();
        this.f72331h = -16777216;
        this.f72332i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i2, 0);
        this.f72332i = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f72331h = obtainStyledAttributes.getColor(3, -16777216);
        this.s = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        super.setScaleType(f72324a);
        this.q = true;
        if (this.r) {
            b();
            this.r = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f72324a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f72324a) {
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
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.n, this.f72329f);
            if (this.f72332i != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.o, this.f72330g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    public int getBorderColor() {
        return this.f72331h;
    }

    public void setBorderColor(int i2) {
        if (i2 != this.f72331h) {
            this.f72331h = i2;
            this.f72330g.setColor(this.f72331h);
            invalidate();
        }
    }

    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public int getBorderWidth() {
        return this.f72332i;
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.f72332i) {
            this.f72332i = i2;
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
            this.f72329f.setColorFilter(this.p);
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
                bitmap = Bitmap.createBitmap(2, 2, f72325b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f72325b);
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
            this.f72329f.setAntiAlias(true);
            this.f72329f.setShader(this.k);
            this.f72330g.setStyle(Paint.Style.STROKE);
            this.f72330g.setAntiAlias(true);
            this.f72330g.setColor(this.f72331h);
            this.f72330g.setStrokeWidth((float) this.f72332i);
            this.m = this.j.getHeight();
            this.l = this.j.getWidth();
            this.f72327d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.o = Math.min((this.f72327d.height() - ((float) this.f72332i)) / 2.0f, (this.f72327d.width() - ((float) this.f72332i)) / 2.0f);
            this.f72326c.set(this.f72327d);
            if (!this.s) {
                RectF rectF = this.f72326c;
                int i2 = this.f72332i;
                rectF.inset((float) i2, (float) i2);
            }
            this.n = Math.min(this.f72326c.height() / 2.0f, this.f72326c.width() / 2.0f);
            c();
            invalidate();
        }
    }

    private void c() {
        float f2;
        float f3;
        this.f72328e.set((Matrix) null);
        float f4 = 0.0f;
        if (((float) this.l) * this.f72326c.height() > this.f72326c.width() * ((float) this.m)) {
            f3 = this.f72326c.height() / ((float) this.m);
            f2 = (this.f72326c.width() - (((float) this.l) * f3)) * 0.5f;
        } else {
            f3 = this.f72326c.width() / ((float) this.l);
            f4 = (this.f72326c.height() - (((float) this.m) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        this.f72328e.setScale(f3, f3);
        this.f72328e.postTranslate(((float) ((int) (f2 + 0.5f))) + this.f72326c.left, ((float) ((int) (f4 + 0.5f))) + this.f72326c.top);
        this.k.setLocalMatrix(this.f72328e);
    }
}
