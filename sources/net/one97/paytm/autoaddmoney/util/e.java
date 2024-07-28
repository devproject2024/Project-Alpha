package net.one97.paytm.autoaddmoney.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;

public final class e implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f49284a = Executors.newSingleThreadExecutor();

    public final void execute(Runnable runnable) {
        k.c(runnable, "command");
        this.f49284a.execute(runnable);
    }
}
