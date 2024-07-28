package com.google.android.exoplayer2.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.o;
import java.util.Collections;
import java.util.List;

public final class l extends b implements Handler.Callback {

    /* renamed from: g  reason: collision with root package name */
    private final Handler f31646g;

    /* renamed from: h  reason: collision with root package name */
    private final k f31647h;

    /* renamed from: i  reason: collision with root package name */
    private final h f31648i;
    private final o j;
    private boolean k;
    private boolean l;
    private int m;
    private Format n;
    private f o;
    private i p;
    private j q;
    private j r;
    private int s;

    public final boolean t() {
        return true;
    }

    public l(k kVar, Looper looper) {
        this(kVar, looper, h.f31594a);
    }

    private l(k kVar, Looper looper, h hVar) {
        super(3);
        Handler handler;
        this.f31647h = (k) a.a(kVar);
        if (looper == null) {
            handler = null;
        } else {
            handler = ae.a(looper, (Handler.Callback) this);
        }
        this.f31646g = handler;
        this.f31648i = hVar;
        this.j = new o();
    }

    public final int a(Format format) {
        return this.f31648i.a(format) ? a((e<?>) null, format.l) ? 4 : 2 : com.google.android.exoplayer2.g.o.c(format.f31069i) ? 1 : 0;
    }

    public final void a(Format[] formatArr, long j2) throws i {
        this.n = formatArr[0];
        if (this.o != null) {
            this.m = 1;
        } else {
            this.o = this.f31648i.b(this.n);
        }
    }

    public final void a(long j2, long j3) throws i {
        boolean z;
        if (!this.l) {
            if (this.r == null) {
                this.o.a(j2);
                try {
                    this.r = (j) this.o.b();
                } catch (g e2) {
                    throw i.createForRenderer(e2, this.f31139b);
                }
            }
            if (this.f31140c == 2) {
                if (this.q != null) {
                    long y = y();
                    z = false;
                    while (y <= j2) {
                        this.s++;
                        y = y();
                        z = true;
                    }
                } else {
                    z = false;
                }
                j jVar = this.r;
                if (jVar != null) {
                    if (jVar.c()) {
                        if (!z && y() == Long.MAX_VALUE) {
                            if (this.m == 2) {
                                x();
                            } else {
                                v();
                                this.l = true;
                            }
                        }
                    } else if (this.r.f31314b <= j2) {
                        j jVar2 = this.q;
                        if (jVar2 != null) {
                            jVar2.e();
                        }
                        this.q = this.r;
                        this.r = null;
                        this.s = this.q.a(j2);
                        z = true;
                    }
                }
                if (z) {
                    a(this.q.b(j2));
                }
                if (this.m != 2) {
                    while (!this.k) {
                        try {
                            if (this.p == null) {
                                this.p = (i) this.o.a();
                                if (this.p == null) {
                                    return;
                                }
                            }
                            if (this.m == 1) {
                                this.p.f31289a = 4;
                                this.o.a(this.p);
                                this.p = null;
                                this.m = 2;
                                return;
                            }
                            int a2 = a(this.j, (com.google.android.exoplayer2.c.e) this.p, false);
                            if (a2 == -4) {
                                if (this.p.c()) {
                                    this.k = true;
                                } else {
                                    this.p.f31643e = this.j.f32757a.m;
                                    this.p.g();
                                }
                                this.o.a(this.p);
                                this.p = null;
                            } else if (a2 == -3) {
                                return;
                            }
                        } catch (g e3) {
                            throw i.createForRenderer(e3, this.f31139b);
                        }
                    }
                }
            }
        }
    }

    public final void r() {
        this.n = null;
        a((List<b>) Collections.emptyList());
        w();
    }

    public final boolean u() {
        return this.l;
    }

    private void v() {
        this.p = null;
        this.s = -1;
        j jVar = this.q;
        if (jVar != null) {
            jVar.e();
            this.q = null;
        }
        j jVar2 = this.r;
        if (jVar2 != null) {
            jVar2.e();
            this.r = null;
        }
    }

    private void w() {
        v();
        this.o.d();
        this.o = null;
        this.m = 0;
    }

    private void x() {
        w();
        this.o = this.f31648i.b(this.n);
    }

    private long y() {
        int i2 = this.s;
        if (i2 == -1 || i2 >= this.q.b()) {
            return Long.MAX_VALUE;
        }
        return this.q.a_(this.s);
    }

    private void a(List<b> list) {
        Handler handler = this.f31646g;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void b(List<b> list) {
        this.f31647h.a(list);
    }

    public final void a(long j2, boolean z) {
        a((List<b>) Collections.emptyList());
        this.k = false;
        this.l = false;
        if (this.m != 0) {
            x();
            return;
        }
        v();
        this.o.c();
    }
}
