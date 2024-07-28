package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.b.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.q;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class g extends a<Void> implements q {

    /* renamed from: a  reason: collision with root package name */
    private Semaphore f8263a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private Set<e> f8264b;

    public g(Context context, Set<e> set) {
        super(context);
        this.f8264b = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final Void loadInBackground() {
        int i2 = 0;
        for (e a2 : this.f8264b) {
            if (a2.a((q) this)) {
                i2++;
            }
        }
        try {
            this.f8263a.tryAcquire(i2, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public final void onStartLoading() {
        this.f8263a.drainPermits();
        forceLoad();
    }

    public final void a() {
        this.f8263a.release();
    }
}
