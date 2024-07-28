package com.paytmmall.clpartifact.threading;

public class Task {
    public static void runOnMainThread(Runnable runnable) {
        WorkExecutorImpl.getInstance().executeOnMainThread(runnable);
    }

    public static void runOnIOThread(Runnable runnable) {
        WorkExecutorImpl.getInstance().executeOnIOThread(runnable);
    }

    public static void runOnComputation(Runnable runnable) {
        WorkExecutorImpl.getInstance().executeOnComputationThread(runnable);
    }
}
