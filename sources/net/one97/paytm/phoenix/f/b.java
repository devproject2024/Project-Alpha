package net.one97.paytm.phoenix.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f59581a = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f59581a.post(runnable);
    }
}
