package com.paytmmall.clpartifact.threading;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WorkExecutorImpl implements WorkExecutor {
    private static WorkExecutorImpl sInstance;
    private Executor COMPUTATION = Executors.newFixedThreadPool(3, $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts.INSTANCE);
    private Executor IO = Executors.newFixedThreadPool(3, $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts.INSTANCE);
    private final Object mLock = new Object();
    private Handler mMainThreadHandler;

    public static WorkExecutor getInstance() {
        if (sInstance == null) {
            synchronized (WorkExecutorImpl.class) {
                if (sInstance == null) {
                    sInstance = new WorkExecutorImpl();
                }
            }
        }
        return sInstance;
    }

    private WorkExecutorImpl() {
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public void executeOnIOThread(Runnable runnable) {
        this.IO.execute(runnable);
    }

    public void executeOnComputationThread(Runnable runnable) {
        this.COMPUTATION.execute(runnable);
    }

    private void postToMainThread(Runnable runnable) {
        if (this.mMainThreadHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainThreadHandler == null) {
                    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.mMainThreadHandler.post(runnable);
    }

    public void executeOnMainThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            postToMainThread(runnable);
        }
    }
}
