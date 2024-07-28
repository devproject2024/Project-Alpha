package com.zhihu.matisse.internal.entity;

import com.paytm.android.chat.R;
import com.zhihu.matisse.b;
import java.util.List;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Set<b> f45778a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45779b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45780c;

    /* renamed from: d  reason: collision with root package name */
    public int f45781d;

    /* renamed from: e  reason: collision with root package name */
    public int f45782e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45783f;

    /* renamed from: g  reason: collision with root package name */
    public int f45784g;

    /* renamed from: h  reason: collision with root package name */
    public int f45785h;

    /* renamed from: i  reason: collision with root package name */
    public int f45786i;
    public List<com.zhihu.matisse.c.a> j;
    public boolean k;
    public a l;
    public int m;
    public int n;
    public float o;
    public com.zhihu.matisse.b.a p;
    public boolean q;
    public com.zhihu.matisse.d.c r;
    public boolean s;
    public boolean t;
    public int u;
    public com.zhihu.matisse.d.a v;
    public boolean w;
    public boolean x;

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f45787a = new c((byte) 0);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
    }

    private void g() {
        this.f45778a = null;
        this.f45779b = true;
        this.f45780c = false;
        this.f45781d = R.style.Matisse_Zhihu;
        this.f45782e = 0;
        this.f45783f = false;
        this.f45784g = 1;
        this.f45785h = 0;
        this.f45786i = 0;
        this.j = null;
        this.k = false;
        this.l = null;
        this.m = 3;
        this.n = 0;
        this.o = 0.5f;
        this.p = new com.paytm.android.chat.f.c();
        this.q = true;
        this.s = false;
        this.t = false;
        this.u = Integer.MAX_VALUE;
        this.w = true;
        this.x = false;
    }

    public final boolean b() {
        if (!this.f45783f) {
            return this.f45784g == 1 || (this.f45785h == 1 && this.f45786i == 1);
        }
        return false;
    }

    public final boolean c() {
        return this.f45782e != -1;
    }

    public final boolean d() {
        return this.f45780c && b.ofImage().containsAll(this.f45778a);
    }

    public final boolean e() {
        return this.f45780c && b.ofVideo().containsAll(this.f45778a);
    }

    public final boolean f() {
        return this.f45780c && b.ofGif().equals(this.f45778a);
    }

    public static c a() {
        c a2 = a.f45787a;
        a2.g();
        return a2;
    }
}
