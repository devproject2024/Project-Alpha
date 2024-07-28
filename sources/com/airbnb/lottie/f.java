package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.c.h;
import com.airbnb.lottie.e.s;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String t = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public d f6063a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final e f6064b = new e();

    /* renamed from: c  reason: collision with root package name */
    float f6065c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    boolean f6066d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f6067e = false;

    /* renamed from: f  reason: collision with root package name */
    final ArrayList<a> f6068f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    final ValueAnimator.AnimatorUpdateListener f6069g = new ValueAnimator.AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.p != null) {
                f.this.p.a(f.this.f6064b.b());
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    ImageView.ScaleType f6070h;

    /* renamed from: i  reason: collision with root package name */
    b f6071i;
    String j;
    b k;
    public com.airbnb.lottie.b.a l;
    public a m;
    public q n;
    public boolean o;
    /* access modifiers changed from: package-private */
    public com.airbnb.lottie.c.c.b p;
    boolean q;
    public boolean r;
    boolean s = true;
    private final Matrix u = new Matrix();
    private final Set<Object> v = new HashSet();
    private int w = PriceRangeSeekBar.INVALID_POINTER_ID;
    private boolean x = false;

    interface a {
        void a();
    }

    public int getOpacity() {
        return -3;
    }

    public f() {
        this.f6064b.addUpdateListener(this.f6069g);
    }

    public final boolean a(d dVar) {
        boolean z = false;
        if (this.f6063a == dVar) {
            return false;
        }
        this.x = false;
        b();
        this.f6063a = dVar;
        a();
        e eVar = this.f6064b;
        if (eVar.f6115f == null) {
            z = true;
        }
        eVar.f6115f = dVar;
        if (z) {
            eVar.a((float) ((int) Math.max(eVar.f6113d, dVar.j)), (float) ((int) Math.min(eVar.f6114e, dVar.k)));
        } else {
            eVar.a((float) ((int) dVar.j), (float) ((int) dVar.k));
        }
        float f2 = eVar.f6112c;
        eVar.f6112c = 0.0f;
        eVar.a((float) ((int) f2));
        eVar.a();
        c(this.f6064b.getAnimatedFraction());
        d(this.f6065c);
        h();
        Iterator it2 = new ArrayList(this.f6068f).iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).a();
            it2.remove();
        }
        this.f6068f.clear();
        dVar.a(this.q);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable((Drawable) null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.p = new com.airbnb.lottie.c.c.b(this, s.a(this.f6063a), this.f6063a.f5981h, this.f6063a);
    }

    public final void b() {
        if (this.f6064b.isRunning()) {
            this.f6064b.cancel();
        }
        this.f6063a = null;
        this.p = null;
        this.f6071i = null;
        this.f6064b.c();
        invalidateSelf();
    }

    public void invalidateSelf() {
        if (!this.x) {
            this.x = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public void setAlpha(int i2) {
        this.w = i2;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d.a("Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        this.x = false;
        c.a("Drawable#draw");
        if (this.f6067e) {
            try {
                a(canvas);
            } catch (Throwable unused) {
                d.b();
            }
        } else {
            a(canvas);
        }
        c.b("Drawable#draw");
    }

    private void a(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f6070h) {
            c(canvas);
        } else {
            d(canvas);
        }
    }

    public void start() {
        c();
    }

    public boolean isRunning() {
        return e();
    }

    public final void c() {
        float f2;
        if (this.p == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.c();
                }
            });
            return;
        }
        if (this.f6066d || this.f6064b.getRepeatCount() == 0) {
            this.f6064b.e();
        }
        if (!this.f6066d) {
            if (this.f6064b.f6111b < 0.0f) {
                f2 = this.f6064b.h();
            } else {
                f2 = this.f6064b.i();
            }
            c((int) f2);
            this.f6064b.f();
        }
    }

    public final void d() {
        float f2;
        if (this.p == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.d();
                }
            });
            return;
        }
        if (this.f6066d || this.f6064b.getRepeatCount() == 0) {
            this.f6064b.g();
        }
        if (!this.f6066d) {
            if (this.f6064b.f6111b < 0.0f) {
                f2 = this.f6064b.h();
            } else {
                f2 = this.f6064b.i();
            }
            c((int) f2);
            this.f6064b.f();
        }
    }

    public final void a(final int i2) {
        if (this.f6063a == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(i2);
                }
            });
        } else {
            this.f6064b.a(i2);
        }
    }

    public final void a(final float f2) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(f2);
                }
            });
        } else {
            a((int) g.a(dVar.j, this.f6063a.k, f2));
        }
    }

    public final void b(final int i2) {
        if (this.f6063a == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.b(i2);
                }
            });
        } else {
            this.f6064b.b(((float) i2) + 0.99f);
        }
    }

    public final void b(final float f2) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.b(f2);
                }
            });
        } else {
            b((int) g.a(dVar.j, this.f6063a.k, f2));
        }
    }

    public final void a(final String str) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(str);
                }
            });
            return;
        }
        h b2 = dVar.b(str);
        if (b2 != null) {
            a((int) b2.f5970c);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + AppUtility.CENTER_DOT);
    }

    public final void b(final String str) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.b(str);
                }
            });
            return;
        }
        h b2 = dVar.b(str);
        if (b2 != null) {
            b((int) (b2.f5970c + b2.f5971d));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + AppUtility.CENTER_DOT);
    }

    public final void c(final String str) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.c(str);
                }
            });
            return;
        }
        h b2 = dVar.b(str);
        if (b2 != null) {
            int i2 = (int) b2.f5970c;
            a(i2, ((int) b2.f5971d) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + AppUtility.CENTER_DOT);
    }

    public final void a(final String str, final String str2, final boolean z) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(str, str2, z);
                }
            });
            return;
        }
        h b2 = dVar.b(str);
        if (b2 != null) {
            int i2 = (int) b2.f5970c;
            h b3 = this.f6063a.b(str2);
            if (str2 != null) {
                a(i2, (int) (b3.f5970c + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + AppUtility.CENTER_DOT);
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + AppUtility.CENTER_DOT);
    }

    public final void a(final int i2, final int i3) {
        if (this.f6063a == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(i2, i3);
                }
            });
        } else {
            this.f6064b.a((float) i2, ((float) i3) + 0.99f);
        }
    }

    public final void a(final float f2, final float f3) {
        d dVar = this.f6063a;
        if (dVar == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(f2, f3);
                }
            });
        } else {
            a((int) g.a(dVar.j, this.f6063a.k, f2), (int) g.a(this.f6063a.j, this.f6063a.k, f3));
        }
    }

    public final void c(final int i2) {
        if (this.f6063a == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.c(i2);
                }
            });
        } else {
            this.f6064b.a((float) i2);
        }
    }

    public final void c(final float f2) {
        if (this.f6063a == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.c(f2);
                }
            });
            return;
        }
        c.a("Drawable#setProgress");
        this.f6064b.a(g.a(this.f6063a.j, this.f6063a.k, f2));
        c.b("Drawable#setProgress");
    }

    public final void d(int i2) {
        this.f6064b.setRepeatCount(i2);
    }

    public final boolean e() {
        e eVar = this.f6064b;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public final void d(float f2) {
        this.f6065c = f2;
        h();
    }

    public final boolean f() {
        return this.n == null && this.f6063a.f5979f.b() > 0;
    }

    private void h() {
        d dVar = this.f6063a;
        if (dVar != null) {
            float f2 = this.f6065c;
            setBounds(0, 0, (int) (((float) dVar.f5982i.width()) * f2), (int) (((float) this.f6063a.f5982i.height()) * f2));
        }
    }

    public int getIntrinsicWidth() {
        d dVar = this.f6063a;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.f5982i.width()) * this.f6065c);
    }

    public int getIntrinsicHeight() {
        d dVar = this.f6063a;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.f5982i.height()) * this.f6065c);
    }

    public final List<com.airbnb.lottie.c.e> a(com.airbnb.lottie.c.e eVar) {
        if (this.p == null) {
            d.a("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.p.a(eVar, 0, arrayList, new com.airbnb.lottie.c.e(new String[0]));
        return arrayList;
    }

    public final <T> void a(final com.airbnb.lottie.c.e eVar, final T t2, final c<T> cVar) {
        if (this.p == null) {
            this.f6068f.add(new a() {
                public final void a() {
                    f.this.a(eVar, t2, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar.f5964a != null) {
            eVar.f5964a.a(t2, cVar);
        } else {
            List<com.airbnb.lottie.c.e> a2 = a(eVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a2.get(i2).f5964a.a(t2, cVar);
            }
            if (a2.isEmpty()) {
                z = false;
            }
        }
        if (z) {
            invalidateSelf();
            if (t2 == k.A) {
                c(this.f6064b.b());
            }
        }
    }

    public final Bitmap d(String str) {
        b g2 = g();
        if (g2 != null) {
            return g2.a(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final b g() {
        if (getCallback() == null) {
            return null;
        }
        b bVar = this.f6071i;
        if (bVar != null && !bVar.a(i())) {
            this.f6071i = null;
        }
        if (this.f6071i == null) {
            this.f6071i = new b(getCallback(), this.j, this.k, this.f6063a.f5976c);
        }
        return this.f6071i;
    }

    private Context i() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private float b(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f6063a.f5982i.width()), ((float) canvas.getHeight()) / ((float) this.f6063a.f5982i.height()));
    }

    private void c(Canvas canvas) {
        float f2;
        if (this.p != null) {
            int i2 = -1;
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.f6063a.f5982i.width());
            float height = ((float) bounds.height()) / ((float) this.f6063a.f5982i.height());
            if (this.s) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f2 = 1.0f / min;
                    width /= f2;
                    height /= f2;
                } else {
                    f2 = 1.0f;
                }
                if (f2 > 1.0f) {
                    i2 = canvas.save();
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f3 = width2 * min;
                    float f4 = min * height2;
                    canvas.translate(width2 - f3, height2 - f4);
                    canvas.scale(f2, f2, f3, f4);
                }
            }
            this.u.reset();
            this.u.preScale(width, height);
            this.p.a(canvas, this.u, this.w);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void d(Canvas canvas) {
        float f2;
        if (this.p != null) {
            float f3 = this.f6065c;
            float b2 = b(canvas);
            if (f3 > b2) {
                f2 = this.f6065c / b2;
            } else {
                b2 = f3;
                f2 = 1.0f;
            }
            int i2 = -1;
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width = ((float) this.f6063a.f5982i.width()) / 2.0f;
                float height = ((float) this.f6063a.f5982i.height()) / 2.0f;
                float f4 = width * b2;
                float f5 = height * b2;
                float f6 = this.f6065c;
                canvas.translate((width * f6) - f4, (f6 * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.u.reset();
            this.u.preScale(b2, b2);
            this.p.a(canvas, this.u, this.w);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void stop() {
        this.f6068f.clear();
        this.f6064b.f();
    }
}
