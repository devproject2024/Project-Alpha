package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.video.h;

public interface h {

    /* renamed from: com.google.android.exoplayer2.video.h$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(h hVar, int i2, int i3, int i4, float f2) {
        }

        public static void $default$a(h hVar, int i2, long j) {
        }

        public static void $default$a(h hVar, Surface surface) {
        }

        public static void $default$a(h hVar, Format format) {
        }

        public static void $default$a(h hVar, d dVar) {
        }

        public static void $default$a(h hVar, String str, long j, long j2) {
        }

        public static void $default$b(h hVar, d dVar) {
        }
    }

    void a(int i2, int i3, int i4, float f2);

    void a(int i2, long j);

    void a(Surface surface);

    void a(Format format);

    void a(d dVar);

    void a(String str, long j, long j2);

    void b(d dVar);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f33715a;

        /* renamed from: b  reason: collision with root package name */
        private final h f33716b;

        public a(Handler handler, h hVar) {
            this.f33715a = hVar != null ? (Handler) com.google.android.exoplayer2.g.a.a(handler) : null;
            this.f33716b = hVar;
        }

        public final void a(d dVar) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(dVar) {
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
            this.f33716b.a(dVar);
        }

        public final void a(String str, long j, long j2) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(str, j, j2) {
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
            this.f33716b.a(str, j, j2);
        }

        public final void a(Format format) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(format) {
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
            this.f33716b.a(format);
        }

        public final void a(int i2, long j) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(i2, j) {
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1, this.f$2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, long j) {
            this.f33716b.a(i2, j);
        }

        public final void a(int i2, int i3, int i4, float f2) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(i2, i3, i4, f2) {
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ int f$2;
                    private final /* synthetic */ int f$3;
                    private final /* synthetic */ float f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        h.a.this.b(this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, int i3, int i4, float f2) {
            this.f33716b.a(i2, i3, i4, f2);
        }

        public final void a(Surface surface) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(surface) {
                    private final /* synthetic */ Surface f$1;

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
        public /* synthetic */ void b(Surface surface) {
            this.f33716b.a(surface);
        }

        public final void b(d dVar) {
            if (this.f33716b != null) {
                this.f33715a.post(new Runnable(dVar) {
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
            this.f33716b.b(dVar);
        }
    }
}
