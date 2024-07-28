package com.paytm.e.a;

import android.os.Handler;

public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42689a;

    /* renamed from: b  reason: collision with root package name */
    public a f42690b;

    /* renamed from: c  reason: collision with root package name */
    private final f f42691c;

    /* renamed from: d  reason: collision with root package name */
    private final d f42692d;

    /* renamed from: e  reason: collision with root package name */
    private final long f42693e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f42694f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    private long f42695g = Long.MIN_VALUE;

    public interface a {
        void a();

        void a(long j);
    }

    public e(f fVar, d dVar) {
        this.f42691c = fVar;
        this.f42692d = dVar;
        this.f42693e = 100;
    }

    public final void run() {
        if (!this.f42689a) {
            long a2 = this.f42692d.a();
            long a3 = a(a2);
            if (this.f42695g != a3) {
                this.f42695g = a3;
                a aVar = this.f42690b;
                if (aVar != null && !this.f42689a) {
                    aVar.a();
                }
            }
            long b2 = (this.f42691c.b(a(a2) + 1) * 1000) - a2;
            a aVar2 = this.f42690b;
            if (aVar2 != null && !this.f42689a) {
                aVar2.a(b2);
            }
            long a4 = this.f42692d.a();
            long b3 = a4 - (this.f42691c.b(a(a4)) * 1000);
            long j = this.f42693e;
            this.f42694f.postDelayed(this, j - (b3 % j));
        }
    }

    private long a(long j) {
        return this.f42691c.a(j / 1000);
    }
}
