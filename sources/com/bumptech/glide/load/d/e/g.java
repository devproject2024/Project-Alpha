package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.e.b.f;
import com.bumptech.glide.f.d;
import com.bumptech.glide.g.j;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.List;

final class g {

    /* renamed from: a  reason: collision with root package name */
    final com.bumptech.glide.gifdecoder.a f7225a;

    /* renamed from: b  reason: collision with root package name */
    final List<b> f7226b;

    /* renamed from: c  reason: collision with root package name */
    final i f7227c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7228d;

    /* renamed from: e  reason: collision with root package name */
    a f7229e;

    /* renamed from: f  reason: collision with root package name */
    boolean f7230f;

    /* renamed from: g  reason: collision with root package name */
    a f7231g;

    /* renamed from: h  reason: collision with root package name */
    Bitmap f7232h;

    /* renamed from: i  reason: collision with root package name */
    a f7233i;
    int j;
    int k;
    int l;
    private final Handler m;
    private final e n;
    private boolean o;
    private boolean p;
    private h<Bitmap> q;
    private m<Bitmap> r;

    public interface b {
        void c();
    }

    private g(e eVar, i iVar, com.bumptech.glide.gifdecoder.a aVar, h<Bitmap> hVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f7226b = new ArrayList();
        this.f7227c = iVar;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.n = eVar;
        this.m = handler;
        this.q = hVar;
        this.f7225a = aVar;
        a(mVar, bitmap);
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        if (this.f7230f) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f7226b.contains(bVar)) {
            boolean isEmpty = this.f7226b.isEmpty();
            this.f7226b.add(bVar);
            if (isEmpty) {
                c();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(b bVar) {
        this.f7226b.remove(bVar);
        if (this.f7226b.isEmpty()) {
            this.f7228d = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f7225a.d();
    }

    private void c() {
        if (!this.f7228d) {
            this.f7228d = true;
            this.f7230f = false;
            d();
        }
    }

    private void d() {
        if (this.f7228d && !this.o) {
            if (this.p) {
                j.a(this.f7233i == null, "Pending target must be null when starting from the first frame");
                this.f7225a.f();
                this.p = false;
            }
            a aVar = this.f7233i;
            if (aVar != null) {
                this.f7233i = null;
                a(aVar);
                return;
            }
            this.o = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f7225a.c());
            this.f7225a.b();
            this.f7231g = new a(this.m, this.f7225a.e(), uptimeMillis);
            this.q.b((com.bumptech.glide.e.a<?>) com.bumptech.glide.e.h.b(e())).b((Object) this.f7225a).a(this.f7231g);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Bitmap bitmap = this.f7232h;
        if (bitmap != null) {
            this.n.a(bitmap);
            this.f7232h = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.o = false;
        if (this.f7230f) {
            this.m.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f7228d) {
            this.f7233i = aVar;
        } else {
            if (aVar.f7235b != null) {
                b();
                a aVar2 = this.f7229e;
                this.f7229e = aVar;
                for (int size = this.f7226b.size() - 1; size >= 0; size--) {
                    this.f7226b.get(size).c();
                }
                if (aVar2 != null) {
                    this.m.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            d();
        }
    }

    class c implements Handler.Callback {
        c() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                g.this.f7227c.a((com.bumptech.glide.e.a.j<?>) (a) message.obj);
                return false;
            }
        }
    }

    static class a extends com.bumptech.glide.e.a.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f7234a;

        /* renamed from: b  reason: collision with root package name */
        Bitmap f7235b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f7236c;

        /* renamed from: d  reason: collision with root package name */
        private final long f7237d;

        public final /* synthetic */ void a(Object obj, f fVar) {
            this.f7235b = (Bitmap) obj;
            this.f7236c.sendMessageAtTime(this.f7236c.obtainMessage(1, this), this.f7237d);
        }

        a(Handler handler, int i2, long j) {
            this.f7236c = handler;
            this.f7234a = i2;
            this.f7237d = j;
        }

        public final void a(Drawable drawable) {
            this.f7235b = null;
        }
    }

    private static com.bumptech.glide.load.g e() {
        return new d(Double.valueOf(Math.random()));
    }

    g(com.bumptech.glide.b bVar, com.bumptech.glide.gifdecoder.a aVar, int i2, int i3, m<Bitmap> mVar, Bitmap bitmap) {
        this(bVar.f6425a, com.bumptech.glide.b.b(bVar.f6426b.getBaseContext()), aVar, com.bumptech.glide.b.b(bVar.f6426b.getBaseContext()).d().b((com.bumptech.glide.e.a<?>) ((com.bumptech.glide.e.h) ((com.bumptech.glide.e.h) com.bumptech.glide.e.h.b(com.bumptech.glide.load.b.j.f6876b).d()).a(true)).a(i2, i3)), mVar, bitmap);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.m<android.graphics.Bitmap> r4, android.graphics.Bitmap r5) {
        /*
            r3 = this;
            java.lang.String r0 = "Argument must not be null"
            java.lang.Object r1 = com.bumptech.glide.g.j.a(r4, (java.lang.String) r0)
            com.bumptech.glide.load.m r1 = (com.bumptech.glide.load.m) r1
            r3.r = r1
            java.lang.Object r0 = com.bumptech.glide.g.j.a(r5, (java.lang.String) r0)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r3.f7232h = r0
            com.bumptech.glide.h<android.graphics.Bitmap> r0 = r3.q
            com.bumptech.glide.e.h r1 = new com.bumptech.glide.e.h
            r1.<init>()
            r2 = 1
            com.bumptech.glide.e.a r4 = r1.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r4, (boolean) r2)
            com.bumptech.glide.h r4 = r0.b((com.bumptech.glide.e.a<?>) r4)
            r3.q = r4
            int r4 = com.bumptech.glide.g.k.a((android.graphics.Bitmap) r5)
            r3.j = r4
            int r4 = r5.getWidth()
            r3.k = r4
            int r4 = r5.getHeight()
            r3.l = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.e.g.a(com.bumptech.glide.load.m, android.graphics.Bitmap):void");
    }
}
