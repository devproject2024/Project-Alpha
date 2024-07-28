package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36119a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f36120b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    public Drawable f36121c;

    /* renamed from: d  reason: collision with root package name */
    private final a f36122d;

    /* renamed from: e  reason: collision with root package name */
    private final View f36123e;

    /* renamed from: f  reason: collision with root package name */
    private final Path f36124f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f36125g = new Paint(7);

    /* renamed from: h  reason: collision with root package name */
    private c.d f36126h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36127i;
    private boolean j;

    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f36119a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            f36119a = 1;
        } else {
            f36119a = 0;
        }
    }

    public b(a aVar) {
        this.f36122d = aVar;
        this.f36123e = (View) aVar;
        this.f36123e.setWillNotDraw(false);
        this.f36120b.setColor(0);
    }

    public final void a() {
        if (f36119a == 0) {
            this.f36127i = true;
            this.j = false;
            this.f36123e.buildDrawingCache();
            Bitmap drawingCache = this.f36123e.getDrawingCache();
            if (!(drawingCache != null || this.f36123e.getWidth() == 0 || this.f36123e.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.f36123e.getWidth(), this.f36123e.getHeight(), Bitmap.Config.ARGB_8888);
                this.f36123e.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f36125g;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f36127i = false;
            this.j = true;
        }
    }

    public final void b() {
        if (f36119a == 0) {
            this.j = false;
            this.f36123e.destroyDrawingCache();
            this.f36125g.setShader((Shader) null);
            this.f36123e.invalidate();
        }
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            this.f36126h = null;
        } else {
            c.d dVar2 = this.f36126h;
            if (dVar2 == null) {
                this.f36126h = new c.d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (com.google.android.material.g.a.a(dVar.f36134c, b(dVar))) {
                this.f36126h.f36134c = Float.MAX_VALUE;
            }
        }
        e();
    }

    public final c.d c() {
        c.d dVar = this.f36126h;
        if (dVar == null) {
            return null;
        }
        c.d dVar2 = new c.d(dVar);
        if (dVar2.a()) {
            dVar2.f36134c = b(dVar2);
        }
        return dVar2;
    }

    public final void a(int i2) {
        this.f36120b.setColor(i2);
        this.f36123e.invalidate();
    }

    public final void a(Drawable drawable) {
        this.f36121c = drawable;
        this.f36123e.invalidate();
    }

    private void e() {
        if (f36119a == 1) {
            this.f36124f.rewind();
            c.d dVar = this.f36126h;
            if (dVar != null) {
                this.f36124f.addCircle(dVar.f36132a, this.f36126h.f36133b, this.f36126h.f36134c, Path.Direction.CW);
            }
        }
        this.f36123e.invalidate();
    }

    private float b(c.d dVar) {
        return com.google.android.material.g.a.a(dVar.f36132a, dVar.f36133b, (float) this.f36123e.getWidth(), (float) this.f36123e.getHeight());
    }

    public final void a(Canvas canvas) {
        if (f()) {
            int i2 = f36119a;
            if (i2 == 0) {
                canvas.drawCircle(this.f36126h.f36132a, this.f36126h.f36133b, this.f36126h.f36134c, this.f36125g);
                if (g()) {
                    canvas.drawCircle(this.f36126h.f36132a, this.f36126h.f36133b, this.f36126h.f36134c, this.f36120b);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f36124f);
                this.f36122d.a(canvas);
                if (g()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.f36123e.getWidth(), (float) this.f36123e.getHeight(), this.f36120b);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.f36122d.a(canvas);
                if (g()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.f36123e.getWidth(), (float) this.f36123e.getHeight(), this.f36120b);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f36119a);
            }
        } else {
            this.f36122d.a(canvas);
            if (g()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.f36123e.getWidth(), (float) this.f36123e.getHeight(), this.f36120b);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (h()) {
            Rect bounds = this.f36121c.getBounds();
            float width = this.f36126h.f36132a - (((float) bounds.width()) / 2.0f);
            float height = this.f36126h.f36133b - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.f36121c.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public final boolean d() {
        return this.f36122d.c() && !f();
    }

    private boolean f() {
        c.d dVar = this.f36126h;
        boolean z = dVar == null || dVar.a();
        return f36119a == 0 ? !z && this.j : !z;
    }

    private boolean g() {
        return !this.f36127i && Color.alpha(this.f36120b.getColor()) != 0;
    }

    private boolean h() {
        return (this.f36127i || this.f36121c == null || this.f36126h == null) ? false : true;
    }
}
