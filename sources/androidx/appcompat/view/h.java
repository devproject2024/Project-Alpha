package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<x> f1248a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    y f1249b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1250c;

    /* renamed from: d  reason: collision with root package name */
    private long f1251d = -1;

    /* renamed from: e  reason: collision with root package name */
    private Interpolator f1252e;

    /* renamed from: f  reason: collision with root package name */
    private final z f1253f = new z() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1255b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f1256c = 0;

        public final void onAnimationStart(View view) {
            if (!this.f1255b) {
                this.f1255b = true;
                if (h.this.f1249b != null) {
                    h.this.f1249b.onAnimationStart((View) null);
                }
            }
        }

        public final void onAnimationEnd(View view) {
            int i2 = this.f1256c + 1;
            this.f1256c = i2;
            if (i2 == h.this.f1248a.size()) {
                if (h.this.f1249b != null) {
                    h.this.f1249b.onAnimationEnd((View) null);
                }
                this.f1256c = 0;
                this.f1255b = false;
                h.this.f1250c = false;
            }
        }
    };

    public final h a(x xVar) {
        if (!this.f1250c) {
            this.f1248a.add(xVar);
        }
        return this;
    }

    public final h a(x xVar, x xVar2) {
        this.f1248a.add(xVar);
        xVar2.b(xVar.a());
        this.f1248a.add(xVar2);
        return this;
    }

    public final void a() {
        if (!this.f1250c) {
            Iterator<x> it2 = this.f1248a.iterator();
            while (it2.hasNext()) {
                x next = it2.next();
                long j = this.f1251d;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.f1252e;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.f1249b != null) {
                    next.a((y) this.f1253f);
                }
                next.c();
            }
            this.f1250c = true;
        }
    }

    public final void b() {
        if (this.f1250c) {
            Iterator<x> it2 = this.f1248a.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
            this.f1250c = false;
        }
    }

    public final h c() {
        if (!this.f1250c) {
            this.f1251d = 250;
        }
        return this;
    }

    public final h a(Interpolator interpolator) {
        if (!this.f1250c) {
            this.f1252e = interpolator;
        }
        return this;
    }

    public final h a(y yVar) {
        if (!this.f1250c) {
            this.f1249b = yVar;
        }
        return this;
    }
}
