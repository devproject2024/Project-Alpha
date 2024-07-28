package com.business.merchant_payments.common.repo;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    public final Executor diskIO;
    public final Executor mainThread;
    public final Executor networkIO;

    public AppExecutors(Executor executor, Executor executor2, Executor executor3) {
        this.diskIO = executor;
        this.networkIO = executor2;
        this.mainThread = executor3;
    }

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new MainThreadExecutor());
    }

    public Executor diskIO() {
        return this.diskIO;
    }

    public Executor networkIO() {
        return this.networkIO;
    }

    public Executor mainThread() {
        return this.mainThread;
    }

    public static class MainThreadExecutor implements Executor {
        public Handler mainThreadHandler;

        public MainThreadExecutor() {
            this.mainThreadHandler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.mainThreadHandler.post(runnable);
        }
    }
}
