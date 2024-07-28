package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class z {
    private static final long u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    int f45476a;

    /* renamed from: b  reason: collision with root package name */
    long f45477b;

    /* renamed from: c  reason: collision with root package name */
    int f45478c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f45479d;

    /* renamed from: e  reason: collision with root package name */
    public final int f45480e;

    /* renamed from: f  reason: collision with root package name */
    public final String f45481f;

    /* renamed from: g  reason: collision with root package name */
    public final List<ah> f45482g;

    /* renamed from: h  reason: collision with root package name */
    public final int f45483h;

    /* renamed from: i  reason: collision with root package name */
    public final int f45484i;
    public final boolean j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final boolean r;
    public final Bitmap.Config s;
    public final w.e t;

    /* synthetic */ z(Uri uri, int i2, String str, List list, int i3, int i4, boolean z, boolean z2, int i5, boolean z3, float f2, float f3, float f4, boolean z4, boolean z5, Bitmap.Config config, w.e eVar, byte b2) {
        this(uri, i2, str, list, i3, i4, z, z2, i5, z3, f2, f3, f4, z4, z5, config, eVar);
    }

    private z(Uri uri, int i2, String str, List<ah> list, int i3, int i4, boolean z, boolean z2, int i5, boolean z3, float f2, float f3, float f4, boolean z4, boolean z5, Bitmap.Config config, w.e eVar) {
        this.f45479d = uri;
        this.f45480e = i2;
        this.f45481f = str;
        if (list == null) {
            this.f45482g = null;
        } else {
            this.f45482g = Collections.unmodifiableList(list);
        }
        this.f45483h = i3;
        this.f45484i = i4;
        this.j = z;
        this.l = z2;
        this.k = i5;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = z4;
        this.r = z5;
        this.s = config;
        this.t = eVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f45480e;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f45479d);
        }
        List<ah> list = this.f45482g;
        if (list != null && !list.isEmpty()) {
            for (ah key : this.f45482g) {
                sb.append(' ');
                sb.append(key.key());
            }
        }
        if (this.f45481f != null) {
            sb.append(" stableKey(");
            sb.append(this.f45481f);
            sb.append(')');
        }
        if (this.f45483h > 0) {
            sb.append(" resize(");
            sb.append(this.f45483h);
            sb.append(',');
            sb.append(this.f45484i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r) {
            sb.append(" purgeable");
        }
        if (this.s != null) {
            sb.append(' ');
            sb.append(this.s);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        long nanoTime = System.nanoTime() - this.f45477b;
        if (nanoTime > u) {
            return b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return "[R" + this.f45476a + ']';
    }

    public final boolean c() {
        return (this.f45483h == 0 && this.f45484i == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return c() || this.n != 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return this.f45482g != null;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f45485a;

        /* renamed from: b  reason: collision with root package name */
        int f45486b;

        /* renamed from: c  reason: collision with root package name */
        boolean f45487c;

        /* renamed from: d  reason: collision with root package name */
        private Uri f45488d;

        /* renamed from: e  reason: collision with root package name */
        private int f45489e;

        /* renamed from: f  reason: collision with root package name */
        private String f45490f;

        /* renamed from: g  reason: collision with root package name */
        private int f45491g;

        /* renamed from: h  reason: collision with root package name */
        private int f45492h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f45493i;
        private float j;
        private float k;
        private float l;
        private boolean m;
        private boolean n;
        private List<ah> o;
        private Bitmap.Config p;
        private w.e q;

        a(Uri uri, int i2, Bitmap.Config config) {
            this.f45488d = uri;
            this.f45489e = i2;
            this.p = config;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return (this.f45488d == null && this.f45489e == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return (this.f45491g == 0 && this.f45492h == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public final boolean c() {
            return this.q != null;
        }

        public final a a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i3 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i3 == 0 && i2 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f45491g = i2;
                this.f45492h = i3;
                return this;
            }
        }

        public final a d() {
            if (!this.f45485a) {
                this.f45487c = true;
                return this;
            }
            throw new IllegalStateException("Center inside can not be used after calling centerCrop");
        }

        public final a a(w.e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.q == null) {
                this.q = eVar;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public final a a(ah ahVar) {
            if (ahVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (ahVar.key() != null) {
                if (this.o == null) {
                    this.o = new ArrayList(2);
                }
                this.o.add(ahVar);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public final z e() {
            if (this.f45487c && this.f45485a) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f45485a && this.f45491g == 0 && this.f45492h == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.f45487c && this.f45491g == 0 && this.f45492h == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.q == null) {
                    this.q = w.e.NORMAL;
                }
                z zVar = r2;
                z zVar2 = new z(this.f45488d, this.f45489e, this.f45490f, this.o, this.f45491g, this.f45492h, this.f45485a, this.f45487c, this.f45486b, this.f45493i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, (byte) 0);
                return zVar;
            }
        }
    }
}
