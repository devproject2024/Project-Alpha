package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.e.h.i;
import io.reactivex.rxjava3.h.a;

public final class e {
    public static void a() {
        if (!a.w) {
            return;
        }
        if ((Thread.currentThread() instanceof i) || a.a()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
