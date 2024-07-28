package com.google.android.exoplayer2.b;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.h;
import com.google.android.exoplayer2.c.d;

public interface h {

    /* renamed from: com.google.android.exoplayer2.b.h$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(h hVar, int i2, long j, long j2) {
        }

        public static void $default$b(h hVar, int i2) {
        }

        public static void $default$b(h hVar, Format format) {
        }

        public static void $default$b(h hVar, String str, long j, long j2) {
        }

        public static void $default$c(h hVar, d dVar) {
        }

        public static void $default$d(h hVar, d dVar) {
        }
    }

    void a(int i2, long j, long j2);

    void b(int i2);

    void b(Format format);

    void b(String str, long j, long j2);

    void c(d dVar);

    void d(d dVar);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f31188a;

        /* renamed from: b  reason: collision with root package name */
        private final h f31189b;

        public a(Handler handler, h hVar) {
            this.f31188a = hVar != null ? (Handler) com.google.android.exoplayer2.g.a.a(handler) : null;
            this.f31189b = hVar;
        }

        public final void a(d dVar) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(dVar) {
                    private final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        h.a.this.d(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(d dVar) {
            this.f31189b.c(dVar);
        }

        public final void a(String str, long j, long j2) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(str, j, j2) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j, long j2) {
            this.f31189b.b(str, j, j2);
        }

        public final void a(Format format) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(format) {
                    private final /* synthetic */ Format f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Format format) {
            this.f31189b.b(format);
        }

        public final void a(int i2, long j, long j2) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(i2, j, j2) {
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ long f$2;
                    private final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, long j, long j2) {
            this.f31189b.a(i2, j, j2);
        }

        public final void b(d dVar) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(dVar) {
                    private final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        h.a.this.c(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(d dVar) {
            this.f31189b.d(dVar);
        }

        public final void a(int i2) {
            if (this.f31189b != null) {
                this.f31188a.post(new Runnable(i2) {
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            this.f31189b.b(i2);
        }
    }
}
