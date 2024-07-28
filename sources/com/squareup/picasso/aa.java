package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import com.squareup.picasso.w;
import com.squareup.picasso.z;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class aa {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f45351d = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public boolean f45352a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45353b;

    /* renamed from: c  reason: collision with root package name */
    Object f45354c;

    /* renamed from: e  reason: collision with root package name */
    private final w f45355e;

    /* renamed from: f  reason: collision with root package name */
    private final z.a f45356f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45357g;

    /* renamed from: h  reason: collision with root package name */
    private int f45358h;

    /* renamed from: i  reason: collision with root package name */
    private int f45359i;
    private int j;
    private int k;
    private Drawable l;
    private Drawable m;

    aa(w wVar, Uri uri, int i2) {
        this.f45357g = true;
        if (!wVar.o) {
            this.f45355e = wVar;
            this.f45356f = new z.a(uri, i2, wVar.l);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    aa() {
        this.f45357g = true;
        this.f45355e = null;
        this.f45356f = new z.a((Uri) null, 0, (Bitmap.Config) null);
    }

    public final aa a() {
        if (this.f45358h != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.l == null) {
            this.f45357g = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public final aa a(int i2) {
        if (!this.f45357g) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.l == null) {
            this.f45358h = i2;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public final aa a(Drawable drawable) {
        if (!this.f45357g) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.f45358h == 0) {
            this.l = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public final aa b(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.m == null) {
            this.f45359i = i2;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public final aa b(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.f45359i == 0) {
            this.m = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public final aa b() {
        this.f45353b = true;
        return this;
    }

    public final aa a(int i2, int i3) {
        this.f45356f.a(i2, i3);
        return this;
    }

    public final aa c() {
        z.a aVar = this.f45356f;
        if (!aVar.f45487c) {
            aVar.f45485a = true;
            aVar.f45486b = 17;
            return this;
        }
        throw new IllegalStateException("Center crop can not be used after calling centerInside");
    }

    public final aa d() {
        this.f45356f.d();
        return this;
    }

    public final aa a(ah ahVar) {
        this.f45356f.a(ahVar);
        return this;
    }

    public final aa a(s sVar, s... sVarArr) {
        if (sVar != null) {
            this.j = sVar.index | this.j;
            if (sVarArr.length > 0) {
                int length = sVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    s sVar2 = sVarArr[i2];
                    if (sVar2 != null) {
                        this.j = sVar2.index | this.j;
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Memory policy cannot be null.");
                    }
                }
            }
            return this;
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public final aa a(t tVar) {
        if (tVar != null) {
            this.k = tVar.index | this.k;
            return this;
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    public final Bitmap e() throws IOException {
        long nanoTime = System.nanoTime();
        ai.a();
        if (this.f45353b) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.f45356f.a()) {
            return null;
        } else {
            z a2 = a(nanoTime);
            m mVar = new m(this.f45355e, a2, this.j, this.k, this.f45354c, ai.a(a2, new StringBuilder()));
            w wVar = this.f45355e;
            return c.a(wVar, wVar.f45449f, this.f45355e.f45450g, this.f45355e.f45451h, (a) mVar).a();
        }
    }

    public final void f() {
        a((e) null);
    }

    public final void a(e eVar) {
        long nanoTime = System.nanoTime();
        if (this.f45353b) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.f45356f.a()) {
            if (!this.f45356f.c()) {
                this.f45356f.a(w.e.LOW);
            }
            z a2 = a(nanoTime);
            String a3 = ai.a(a2, new StringBuilder());
            if (!s.shouldReadFromMemoryCache(this.j) || this.f45355e.b(a3) == null) {
                this.f45355e.b((a) new k(this.f45355e, a2, this.j, this.k, this.f45354c, a3, eVar));
                return;
            }
            if (this.f45355e.n) {
                String b2 = a2.b();
                ai.a("Main", "completed", b2, "from " + w.d.MEMORY);
            }
            if (eVar != null) {
                eVar.onSuccess();
            }
        }
    }

    public final void a(af afVar) {
        Bitmap b2;
        long nanoTime = System.nanoTime();
        ai.b();
        if (afVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f45353b) {
            Drawable drawable = null;
            if (!this.f45356f.a()) {
                this.f45355e.a(afVar);
                if (this.f45357g) {
                    drawable = g();
                }
                afVar.onPrepareLoad(drawable);
                return;
            }
            z a2 = a(nanoTime);
            String a3 = ai.a(a2);
            if (!s.shouldReadFromMemoryCache(this.j) || (b2 = this.f45355e.b(a3)) == null) {
                if (this.f45357g) {
                    drawable = g();
                }
                afVar.onPrepareLoad(drawable);
                this.f45355e.a((a) new ag(this.f45355e, afVar, a2, this.j, this.k, this.m, a3, this.f45354c, this.f45359i));
                return;
            }
            this.f45355e.a(afVar);
            afVar.onBitmapLoaded(b2, w.d.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public final void a(ImageView imageView) {
        a(imageView, (e) null);
    }

    public final void a(ImageView imageView, e eVar) {
        Bitmap b2;
        ImageView imageView2 = imageView;
        e eVar2 = eVar;
        long nanoTime = System.nanoTime();
        ai.b();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f45356f.a()) {
            this.f45355e.a(imageView2);
            if (this.f45357g) {
                x.a(imageView2, g());
            }
        } else {
            if (this.f45353b) {
                if (!this.f45356f.b()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f45357g) {
                            x.a(imageView2, g());
                        }
                        this.f45355e.a(imageView2, new h(this, imageView2, eVar2));
                        return;
                    }
                    this.f45356f.a(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            z a2 = a(nanoTime);
            String a3 = ai.a(a2);
            if (!s.shouldReadFromMemoryCache(this.j) || (b2 = this.f45355e.b(a3)) == null) {
                if (this.f45357g) {
                    x.a(imageView2, g());
                }
                this.f45355e.a((a) new n(this.f45355e, imageView, a2, this.j, this.k, this.f45359i, this.m, a3, this.f45354c, eVar, this.f45352a));
                return;
            }
            this.f45355e.a(imageView2);
            x.a(imageView, this.f45355e.f45448e, b2, w.d.MEMORY, this.f45352a, this.f45355e.m);
            if (this.f45355e.n) {
                String b3 = a2.b();
                ai.a("Main", "completed", b3, "from " + w.d.MEMORY);
            }
            if (eVar2 != null) {
                eVar.onSuccess();
            }
        }
    }

    private Drawable g() {
        if (this.f45358h == 0) {
            return this.l;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f45355e.f45448e.getDrawable(this.f45358h);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f45355e.f45448e.getResources().getDrawable(this.f45358h);
        }
        TypedValue typedValue = new TypedValue();
        this.f45355e.f45448e.getResources().getValue(this.f45358h, typedValue, true);
        return this.f45355e.f45448e.getResources().getDrawable(typedValue.resourceId);
    }

    private z a(long j2) {
        int andIncrement = f45351d.getAndIncrement();
        z e2 = this.f45356f.e();
        e2.f45476a = andIncrement;
        e2.f45477b = j2;
        boolean z = this.f45355e.n;
        if (z) {
            ai.a("Main", "created", e2.b(), e2.toString());
        }
        z a2 = this.f45355e.a(e2);
        if (a2 != e2) {
            a2.f45476a = andIncrement;
            a2.f45477b = j2;
            if (z) {
                ai.a("Main", "changed", a2.a(), "into ".concat(String.valueOf(a2)));
            }
        }
        return a2;
    }
}
