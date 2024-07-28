package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.g.ac;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class x implements y {

    /* renamed from: a  reason: collision with root package name */
    public static final b f32464a = a(false, -9223372036854775807L);

    /* renamed from: b  reason: collision with root package name */
    public static final b f32465b = a(true, -9223372036854775807L);

    /* renamed from: c  reason: collision with root package name */
    public static final b f32466c = new b(2, -9223372036854775807L, (byte) 0);

    /* renamed from: d  reason: collision with root package name */
    public static final b f32467d = new b(3, -9223372036854775807L, (byte) 0);

    /* renamed from: e  reason: collision with root package name */
    public IOException f32468e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f32469f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public c<? extends d> f32470g;

    public interface a<T extends d> {
        b a(T t, long j, long j2, IOException iOException, int i2);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    public interface d {
        void a();

        void b() throws IOException, InterruptedException;
    }

    public interface e {
        void g();
    }

    public final void a() throws IOException {
    }

    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f32471a;

        /* renamed from: b  reason: collision with root package name */
        final long f32472b;

        /* synthetic */ b(int i2, long j, byte b2) {
            this(i2, j);
        }

        private b(int i2, long j) {
            this.f32471a = i2;
            this.f32472b = j;
        }

        public final boolean a() {
            int i2 = this.f32471a;
            return i2 == 0 || i2 == 1;
        }
    }

    public x(String str) {
        this.f32469f = ae.a(str);
    }

    public static b a(boolean z, long j) {
        return new b(z ? 1 : 0, j, (byte) 0);
    }

    public final boolean b() {
        return this.f32468e != null;
    }

    public final <T extends d> long a(T t, a<T> aVar, int i2) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.g.a.b(myLooper != null);
        this.f32468e = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new c(myLooper, t, aVar, i2, elapsedRealtime).a(0);
        return elapsedRealtime;
    }

    public final boolean c() {
        return this.f32470g != null;
    }

    public final void d() {
        this.f32470g.a(false);
    }

    public final void a(e eVar) {
        c<? extends d> cVar = this.f32470g;
        if (cVar != null) {
            cVar.a(true);
        }
        if (eVar != null) {
            this.f32469f.execute(new f(eVar));
        }
        this.f32469f.shutdown();
    }

    final class c<T extends d> extends Handler implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f32473a;

        /* renamed from: c  reason: collision with root package name */
        private final T f32475c;

        /* renamed from: d  reason: collision with root package name */
        private final long f32476d;

        /* renamed from: e  reason: collision with root package name */
        private a<T> f32477e;

        /* renamed from: f  reason: collision with root package name */
        private IOException f32478f;

        /* renamed from: g  reason: collision with root package name */
        private int f32479g;

        /* renamed from: h  reason: collision with root package name */
        private volatile Thread f32480h;

        /* renamed from: i  reason: collision with root package name */
        private volatile boolean f32481i;
        private volatile boolean j;

        public c(Looper looper, T t, a<T> aVar, int i2, long j2) {
            super(looper);
            this.f32475c = t;
            this.f32477e = aVar;
            this.f32473a = i2;
            this.f32476d = j2;
        }

        public final void a(long j2) {
            com.google.android.exoplayer2.g.a.b(x.this.f32470g == null);
            c unused = x.this.f32470g = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                a();
            }
        }

        public final void a(boolean z) {
            this.j = z;
            this.f32478f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f32481i = true;
                this.f32475c.a();
                if (this.f32480h != null) {
                    this.f32480h.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f32477e.a(this.f32475c, elapsedRealtime, elapsedRealtime - this.f32476d, true);
                this.f32477e = null;
            }
        }

        public final void run() {
            try {
                this.f32480h = Thread.currentThread();
                if (!this.f32481i) {
                    ac.a("load:" + this.f32475c.getClass().getSimpleName());
                    this.f32475c.b();
                    ac.a();
                }
                if (!this.j) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e2) {
                if (!this.j) {
                    obtainMessage(3, e2).sendToTarget();
                }
            } catch (InterruptedException unused) {
                com.google.android.exoplayer2.g.a.b(this.f32481i);
                if (!this.j) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                l.b("Unexpected exception loading stream", e3);
                if (!this.j) {
                    obtainMessage(3, new g(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                l.b("OutOfMemory error loading stream", e4);
                if (!this.j) {
                    obtainMessage(3, new g(e4)).sendToTarget();
                }
            } catch (Error e5) {
                l.b("Unexpected error loading stream", e5);
                if (!this.j) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                ac.a();
                throw th;
            }
        }

        public final void handleMessage(Message message) {
            long j2;
            if (!this.j) {
                if (message.what == 0) {
                    a();
                } else if (message.what != 4) {
                    b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = elapsedRealtime - this.f32476d;
                    if (this.f32481i) {
                        this.f32477e.a(this.f32475c, elapsedRealtime, j3, false);
                        return;
                    }
                    int i2 = message.what;
                    if (i2 == 1) {
                        this.f32477e.a(this.f32475c, elapsedRealtime, j3, false);
                    } else if (i2 == 2) {
                        try {
                            this.f32477e.a(this.f32475c, elapsedRealtime, j3);
                        } catch (RuntimeException e2) {
                            l.b("Unexpected exception handling load completed", e2);
                            IOException unused = x.this.f32468e = new g(e2);
                        }
                    } else if (i2 == 3) {
                        this.f32478f = (IOException) message.obj;
                        this.f32479g++;
                        b a2 = this.f32477e.a(this.f32475c, elapsedRealtime, j3, this.f32478f, this.f32479g);
                        if (a2.f32471a == 3) {
                            IOException unused2 = x.this.f32468e = this.f32478f;
                        } else if (a2.f32471a != 2) {
                            if (a2.f32471a == 1) {
                                this.f32479g = 1;
                            }
                            if (a2.f32472b != -9223372036854775807L) {
                                j2 = a2.f32472b;
                            } else {
                                j2 = (long) Math.min((this.f32479g - 1) * 1000, 5000);
                            }
                            a(j2);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        private void a() {
            this.f32478f = null;
            x.this.f32469f.execute(x.this.f32470g);
        }

        private void b() {
            c unused = x.this.f32470g = null;
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f32482a;

        public f(e eVar) {
            this.f32482a = eVar;
        }

        public final void run() {
            this.f32482a.g();
        }
    }
}
