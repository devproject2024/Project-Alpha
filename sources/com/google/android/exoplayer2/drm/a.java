package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.g.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class a<T extends g> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<DrmInitData.SchemeData> f31363a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f31364b;

    /* renamed from: c  reason: collision with root package name */
    final int f31365c;

    /* renamed from: d  reason: collision with root package name */
    final k f31366d;

    /* renamed from: e  reason: collision with root package name */
    final UUID f31367e;

    /* renamed from: f  reason: collision with root package name */
    final a<T>.defpackage.b f31368f;

    /* renamed from: g  reason: collision with root package name */
    int f31369g;

    /* renamed from: h  reason: collision with root package name */
    byte[] f31370h;

    /* renamed from: i  reason: collision with root package name */
    h.b f31371i;
    private final h<T> j;
    private final int k;
    private final HashMap<String, String> l;
    private final com.google.android.exoplayer2.g.h<b> m;
    private int n;
    private HandlerThread o;
    private a<T>.defpackage.a p;
    private T q;
    private d.a r;
    private byte[] s;
    private h.a t;

    public interface c<T extends g> {
        void a();

        void a(a<T> aVar);

        void a(Exception exc);
    }

    public a(UUID uuid, h<T> hVar, c<T> cVar, List<DrmInitData.SchemeData> list, int i2, byte[] bArr, HashMap<String, String> hashMap, k kVar, Looper looper, com.google.android.exoplayer2.g.h<b> hVar2, int i3) {
        if (i2 == 1 || i2 == 3) {
            com.google.android.exoplayer2.g.a.a(bArr);
        }
        this.f31367e = uuid;
        this.f31364b = cVar;
        this.j = hVar;
        this.k = i2;
        if (bArr != null) {
            this.s = bArr;
            this.f31363a = null;
        } else {
            this.f31363a = Collections.unmodifiableList((List) com.google.android.exoplayer2.g.a.a(list));
        }
        this.l = hashMap;
        this.f31366d = kVar;
        this.f31365c = i3;
        this.m = hVar2;
        this.f31369g = 2;
        this.f31368f = new b(looper);
        this.o = new HandlerThread("DrmRequestHandler");
        this.o.start();
        this.p = new C0532a(this.o.getLooper());
    }

    public final void a() {
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == 1 && this.f31369g != 1 && a(true)) {
            b(true);
        }
    }

    public final boolean b() {
        int i2 = this.n - 1;
        this.n = i2;
        if (i2 != 0) {
            return false;
        }
        this.f31369g = 0;
        this.f31368f.removeCallbacksAndMessages((Object) null);
        this.p.removeCallbacksAndMessages((Object) null);
        this.p = null;
        this.o.quit();
        this.o = null;
        this.q = null;
        this.r = null;
        this.t = null;
        this.f31371i = null;
        if (this.f31370h != null) {
            this.f31370h = null;
            this.m.a($$Lambda$UbYciWXRzB6AqGYY3q9pKtxHxE.INSTANCE);
        }
        return true;
    }

    public final void c() {
        this.f31371i = this.j.d();
        this.p.a(0, this.f31371i, true);
    }

    public final void d() {
        if (a(false)) {
            b(true);
        }
    }

    public final void a(Exception exc) {
        c(exc);
    }

    public final int e() {
        return this.f31369g;
    }

    public final d.a f() {
        if (this.f31369g == 1) {
            return this.r;
        }
        return null;
    }

    public final T g() {
        return this.q;
    }

    public final Map<String, String> h() {
        if (this.f31370h == null) {
            return null;
        }
        return this.j.e();
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean a(boolean z) {
        if (i()) {
            return true;
        }
        try {
            this.f31370h = this.j.a();
            this.m.a($$Lambda$R7HLWMk9LWgRjwLIyPY2pPC5OQ.INSTANCE);
            this.q = this.j.f();
            this.f31369g = 3;
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.f31364b.a(this);
                return false;
            }
            c((Exception) e2);
            return false;
        } catch (Exception e3) {
            c(e3);
            return false;
        }
    }

    @RequiresNonNull({"sessionId"})
    private void b(boolean z) {
        int i2 = this.k;
        if (i2 == 0 || i2 == 1) {
            if (this.s == null) {
                c(z);
                return;
            }
            long j2 = j();
            if (this.k == 0 && j2 <= 60) {
                "Offline license has expired or will expire soon. Remaining seconds: ".concat(String.valueOf(j2));
                l.a();
                c(z);
            } else if (j2 <= 0) {
                c((Exception) new j());
            } else {
                this.f31369g = 4;
                this.m.a($$Lambda$M6zES6ky4E17FHLzqmpZh_Nme6o.INSTANCE);
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                com.google.android.exoplayer2.g.a.a(this.s);
                c(z);
            }
        } else if (this.s == null) {
            c(z);
        } else {
            c(z);
        }
    }

    private long j() {
        if (!com.google.android.exoplayer2.c.f31287d.equals(this.f31367e)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.google.android.exoplayer2.g.a.a(l.a(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void c(boolean z) {
        try {
            this.t = this.j.b();
            this.p.a(1, this.t, z);
        } catch (Exception e2) {
            b(e2);
        }
    }

    private void b(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.f31364b.a(this);
        } else {
            c(exc);
        }
    }

    private void c(Exception exc) {
        this.r = new d.a(exc);
        this.m.a(new h.a(exc) {
            private final /* synthetic */ Exception f$0;

            {
                this.f$0 = r1;
            }

            public final void sendTo(Object obj) {
                ((b) obj).n();
            }
        });
        if (this.f31369g != 4) {
            this.f31369g = 1;
        }
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean i() {
        int i2 = this.f31369g;
        return i2 == 3 || i2 == 4;
    }

    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                a aVar = a.this;
                if (obj != aVar.f31371i) {
                    return;
                }
                if (aVar.f31369g == 2 || aVar.i()) {
                    aVar.f31371i = null;
                    if (obj2 instanceof Exception) {
                        aVar.f31364b.a((Exception) obj2);
                    } else {
                        aVar.f31364b.a();
                    }
                }
            } else if (i2 == 1) {
                a.a(a.this, obj, obj2);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.a$a  reason: collision with other inner class name */
    class C0532a extends Handler {
        public C0532a(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, Object obj, boolean z) {
            obtainMessage(i2, z ? 1 : 0, 0, obj).sendToTarget();
        }

        public final void handleMessage(Message message) {
            Object obj;
            int i2;
            Object obj2 = message.obj;
            try {
                int i3 = message.what;
                if (i3 == 0) {
                    obj = a.this.f31366d.a();
                } else if (i3 == 1) {
                    obj = a.this.f31366d.b();
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e2) {
                boolean z = false;
                if ((message.arg1 == 1) && (i2 = message.arg2 + 1) <= a.this.f31365c) {
                    Message obtain = Message.obtain(message);
                    obtain.arg2 = i2;
                    sendMessageDelayed(obtain, (long) Math.min((i2 - 1) * 1000, 5000));
                    z = true;
                }
                if (!z) {
                    obj = e2;
                } else {
                    return;
                }
            }
            a.this.f31368f.obtainMessage(message.what, Pair.create(obj2, obj)).sendToTarget();
        }
    }

    public final void a(int i2) {
        if (i2 == 2 && this.k == 0 && this.f31369g == 4) {
            ae.a(this.f31370h);
            b(false);
        }
    }

    static /* synthetic */ void a(a aVar, Object obj, Object obj2) {
        if (obj == aVar.t && aVar.i()) {
            aVar.t = null;
            if (obj2 instanceof Exception) {
                aVar.b((Exception) obj2);
                return;
            }
            try {
                if (aVar.k == 3) {
                    ae.a(aVar.s);
                    aVar.m.a($$Lambda$M6zES6ky4E17FHLzqmpZh_Nme6o.INSTANCE);
                    return;
                }
                byte[] c2 = aVar.j.c();
                if (!((aVar.k != 2 && (aVar.k != 0 || aVar.s == null)) || c2 == null || c2.length == 0)) {
                    aVar.s = c2;
                }
                aVar.f31369g = 4;
                aVar.m.a($$Lambda$gs7D0Fp8oJyVdlpKBPhSf60bukE.INSTANCE);
            } catch (Exception e2) {
                aVar.b(e2);
            }
        }
    }
}
