package com.paytmmall.clpartifact.threading;

public interface WorkExecutor {
    void executeOnComputationThread(Runnable runnable);

    void executeOnIOThread(Runnable runnable);

    void executeOnMainThread(Runnable runnable);

    boolean isMainThread();
}
