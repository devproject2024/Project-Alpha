package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f2996a;

    /* renamed from: b  reason: collision with root package name */
    float f2997b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f2998c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private int f2999d = 160;

    /* renamed from: e  reason: collision with root package name */
    private int f3000e = 119;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f3001f = new Paint(3);

    /* renamed from: g  reason: collision with root package name */
    private final BitmapShader f3002g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f3003h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    private final RectF f3004i = new RectF();
    private boolean j = true;
    private boolean k;
    private int l;
    private int m;

    private static boolean b(float f2) {
        return f2 > 0.05f;
    }

    public void setFilterBitmap(boolean z) {
        this.f3001f.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f3001f.setDither(z);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.f3000e, min, min, getBounds(), this.f2998c);
                int min2 = Math.min(this.f2998c.width(), this.f2998c.height());
                this.f2998c.inset(Math.max(0, (this.f2998c.width() - min2) / 2), Math.max(0, (this.f2998c.height() - min2) / 2));
                this.f2997b = ((float) min2) * 0.5f;
            } else {
                a(this.f3000e, this.l, this.m, getBounds(), this.f2998c);
            }
            this.f3004i.set(this.f2998c);
            if (this.f3002g != null) {
                this.f3003h.setTranslate(this.f3004i.left, this.f3004i.top);
                this.f3003h.preScale(this.f3004i.width() / ((float) this.f2996a.getWidth()), this.f3004i.height() / ((float) this.f2996a.getHeight()));
                this.f3002g.setLocalMatrix(this.f3003h);
                this.f3001f.setShader(this.f3002g);
            }
            this.j = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f2996a;
        if (bitmap != null) {
            a();
            if (this.f3001f.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f2998c, this.f3001f);
                return;
            }
            RectF rectF = this.f3004i;
            float f2 = this.f2997b;
            canvas.drawRoundRect(rectF, f2, f2, this.f3001f);
        }
    }

    public void setAlpha(int i2) {
        if (i2 != this.f3001f.getAlpha()) {
            this.f3001f.setAlpha(i2);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f3001f.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3001f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f3001f.getColorFilter();
    }

    public final void b() {
        this.k = true;
        this.j = true;
        c();
        this.f3001f.setShader(this.f3002g);
        invalidateSelf();
    }

    private void c() {
        this.f2997b = (float) (Math.min(this.m, this.l) / 2);
    }

    public final void a(float f2) {
        if (this.f2997b != f2) {
            this.k = false;
            if (b(f2)) {
                this.f3001f.setShader(this.f3002g);
            } else {
                this.f3001f.setShader((Shader) null);
            }
            this.f2997b = f2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            c();
        }
        this.j = true;
    }

    public int getIntrinsicWidth() {
        return this.l;
    }

    public int getIntrinsicHeight() {
        return this.m;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.f3000e != 119 || this.k || (bitmap = this.f2996a) == null || bitmap.hasAlpha() || this.f3001f.getAlpha() < 255 || b(this.f2997b)) {
            return -3;
        }
        return -1;
    }

    b(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f2999d = resources.getDisplayMetrics().densityDpi;
        }
        this.f2996a = bitmap;
        Bitmap bitmap2 = this.f2996a;
        if (bitmap2 != null) {
            this.l = bitmap2.getScaledWidth(this.f2999d);
            this.m = this.f2996a.getScaledHeight(this.f2999d);
            Bitmap bitmap3 = this.f2996a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f3002g = new BitmapShader(bitmap3, tileMode, tileMode);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f3002g = null;
    }
}
