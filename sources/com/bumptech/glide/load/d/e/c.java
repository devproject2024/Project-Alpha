package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.a.a.b;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.d.e.g;
import com.bumptech.glide.load.m;
import java.nio.ByteBuffer;
import java.util.List;

public class c extends Drawable implements Animatable, b, g.b {

    /* renamed from: a  reason: collision with root package name */
    final a f7214a;

    /* renamed from: b  reason: collision with root package name */
    boolean f7215b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7216c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7217d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7218e;

    /* renamed from: f  reason: collision with root package name */
    private int f7219f;

    /* renamed from: g  reason: collision with root package name */
    private int f7220g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7221h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f7222i;
    private Rect j;
    private List<Object> k;

    public int getOpacity() {
        return -2;
    }

    public c(Context context, com.bumptech.glide.gifdecoder.a aVar, m<Bitmap> mVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.a(context), aVar, i2, i3, mVar, bitmap)));
    }

    c(a aVar) {
        this.f7218e = true;
        this.f7220g = -1;
        this.f7214a = (a) j.a(aVar, "Argument must not be null");
    }

    public final Bitmap a() {
        return this.f7214a.f7223a.f7232h;
    }

    public final ByteBuffer b() {
        return this.f7214a.f7223a.f7225a.a().asReadOnlyBuffer();
    }

    public void start() {
        this.f7217d = true;
        this.f7219f = 0;
        if (this.f7218e) {
            d();
        }
    }

    public void stop() {
        this.f7217d = false;
        e();
    }

    private void d() {
        j.a(!this.f7215b, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f7214a.f7223a.a() == 1) {
            invalidateSelf();
        } else if (!this.f7216c) {
            this.f7216c = true;
            this.f7214a.f7223a.a((g.b) this);
            invalidateSelf();
        }
    }

    private void e() {
        this.f7216c = false;
        this.f7214a.f7223a.b(this);
    }

    public boolean setVisible(boolean z, boolean z2) {
        j.a(!this.f7215b, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f7218e = z;
        if (!z) {
            e();
        } else if (this.f7217d) {
            d();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.f7214a.f7223a.k;
    }

    public int getIntrinsicHeight() {
        return this.f7214a.f7223a.l;
    }

    public boolean isRunning() {
        return this.f7216c;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7221h = true;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (!this.f7215b) {
            if (this.f7221h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), f());
                this.f7221h = false;
            }
            g gVar = this.f7214a.f7223a;
            if (gVar.f7229e != null) {
                bitmap = gVar.f7229e.f7235b;
            } else {
                bitmap = gVar.f7232h;
            }
            canvas.drawBitmap(bitmap, (Rect) null, f(), g());
        }
    }

    public void setAlpha(int i2) {
        g().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        g().setColorFilter(colorFilter);
    }

    private Rect f() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint g() {
        if (this.f7222i == null) {
            this.f7222i = new Paint(2);
        }
        return this.f7222i;
    }

    public Drawable.ConstantState getConstantState() {
        return this.f7214a;
    }

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f7223a;

        public final int getChangingConfigurations() {
            return 0;
        }

        a(g gVar) {
            this.f7223a = gVar;
        }

        public final Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public final Drawable newDrawable() {
            return new c(this);
        }
    }

    public final void c() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        g gVar = this.f7214a.f7223a;
        if ((gVar.f7229e != null ? gVar.f7229e.f7234a : -1) == this.f7214a.f7223a.a() - 1) {
            this.f7219f++;
        }
        int i2 = this.f7220g;
        if (i2 != -1 && this.f7219f >= i2) {
            List<Object> list = this.k;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.k.get(i3);
                }
            }
            stop();
        }
    }
}
