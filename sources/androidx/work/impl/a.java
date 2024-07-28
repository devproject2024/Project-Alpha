package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.d.e;
import androidx.work.s;

public final class a implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f5109a = e.a(Looper.getMainLooper());

    public final void a(long j, Runnable runnable) {
        this.f5109a.postDelayed(runnable, j);
    }

    public final void a(Runnable runnable) {
        this.f5109a.removeCallbacks(runnable);
    }
}
