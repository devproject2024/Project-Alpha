package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

final class ad {

    /* renamed from: a  reason: collision with root package name */
    final HandlerThread f45365a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b  reason: collision with root package name */
    final d f45366b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f45367c;

    /* renamed from: d  reason: collision with root package name */
    long f45368d;

    /* renamed from: e  reason: collision with root package name */
    long f45369e;

    /* renamed from: f  reason: collision with root package name */
    long f45370f;

    /* renamed from: g  reason: collision with root package name */
    long f45371g;

    /* renamed from: h  reason: collision with root package name */
    long f45372h;

    /* renamed from: i  reason: collision with root package name */
    long f45373i;
    long j;
    long k;
    int l;
    int m;
    int n;

    ad(d dVar) {
        this.f45366b = dVar;
        this.f45365a.start();
        ai.a(this.f45365a.getLooper());
        this.f45367c = new a(this.f45365a.getLooper(), this);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f45367c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, int i2) {
        int a2 = ai.a(bitmap);
        Handler handler = this.f45367c;
        handler.sendMessage(handler.obtainMessage(i2, a2, 0));
    }

    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final ad f45374a;

        a(Looper looper, ad adVar) {
            super(looper);
            this.f45374a = adVar;
        }

        public final void handleMessage(final Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f45374a.f45368d++;
            } else if (i2 == 1) {
                this.f45374a.f45369e++;
            } else if (i2 == 2) {
                ad adVar = this.f45374a;
                long j = (long) message.arg1;
                adVar.m++;
                adVar.f45371g += j;
                adVar.j = adVar.f45371g / ((long) adVar.m);
            } else if (i2 == 3) {
                ad adVar2 = this.f45374a;
                long j2 = (long) message.arg1;
                adVar2.n++;
                adVar2.f45372h += j2;
                adVar2.k = adVar2.f45372h / ((long) adVar2.m);
            } else if (i2 != 4) {
                w.f45444a.post(new Runnable() {
                    public final void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
            } else {
                ad adVar3 = this.f45374a;
                adVar3.l++;
                adVar3.f45370f += ((Long) message.obj).longValue();
                adVar3.f45373i = adVar3.f45370f / ((long) adVar3.l);
            }
        }
    }
}
