package net.one97.paytm.wallet.newdesign.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppExecutor {
    private static volatile AppExecutor INSTANCE;
    private static volatile HandlerThread handlerThread;
    private Handler bgHandler;
    private ExecutorService executorService;
    private Handler uiHandler;

    private AppExecutor() {
        initThreads();
    }

    public void initThreads() {
        if (handlerThread == null) {
            handlerThread = new HandlerThread("WalletAppExecutor");
        }
        if (!handlerThread.isAlive()) {
            handlerThread.start();
        }
        if (this.uiHandler == null) {
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
        if (this.bgHandler == null) {
            this.bgHandler = new Handler(handlerThread.getLooper());
        }
        if (this.executorService == null) {
            this.executorService = Executors.newFixedThreadPool(5);
        }
    }

    public static AppExecutor getExecutor() {
        if (INSTANCE == null) {
            synchronized (AppExecutor.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppExecutor();
                }
            }
        }
        return INSTANCE;
    }

    public void runOnUiThread(Runnable runnable) {
        this.uiHandler.post(runnable);
    }

    public void runOnHandlerThread(Runnable runnable) {
        this.bgHandler.post(runnable);
    }

    public Future<?> runOnBgThread(Runnable runnable) {
        return this.executorService.submit(runnable);
    }
}
