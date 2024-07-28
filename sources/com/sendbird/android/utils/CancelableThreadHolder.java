package com.sendbird.android.utils;

import com.sendbird.android.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CancelableThreadHolder {
    /* access modifiers changed from: private */
    public CountDownLatch countDownLatch;
    /* access modifiers changed from: private */
    public final AtomicBoolean interrupted = new AtomicBoolean(false);
    private final AtomicBoolean isWaiting = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final List<Future<?>> jobList = new ArrayList();
    private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

    public final synchronized void sleep(long j) throws InterruptedException {
        if (this.interrupted.getAndSet(false)) {
            throw new InterruptedException("CancelableThreadHolder thread has been interrupted");
        } else if (!this.isWaiting.getAndSet(true)) {
            try {
                this.countDownLatch = new CountDownLatch(1);
                synchronized (this.jobList) {
                    this.jobList.add(this.timer.schedule(new Runnable() {
                        public final void run() {
                            Logger.d("__ timeout : " + CancelableThreadHolder.this.jobList.size());
                            CancelableThreadHolder.this.interrupted.set(false);
                            if (CancelableThreadHolder.this.countDownLatch != null) {
                                CancelableThreadHolder.this.countDownLatch.countDown();
                            }
                        }
                    }, j, TimeUnit.MILLISECONDS));
                }
                this.countDownLatch.await();
                if (this.countDownLatch != null) {
                    this.countDownLatch.countDown();
                    this.countDownLatch = null;
                }
                this.isWaiting.set(false);
                cancelAll();
                if (this.interrupted.getAndSet(false)) {
                    throw new InterruptedException("CancelableThreadHolder thread has been interrupted");
                }
            } catch (Throwable th) {
                if (this.countDownLatch != null) {
                    this.countDownLatch.countDown();
                    this.countDownLatch = null;
                }
                this.isWaiting.set(false);
                cancelAll();
                throw th;
            }
        }
    }

    private void cancelAll() {
        Logger.d("__ cancelAll size : " + this.jobList.size());
        synchronized (this.jobList) {
            for (Future<?> cancel : this.jobList) {
                cancel.cancel(false);
            }
            this.jobList.clear();
        }
    }

    public final boolean isInterrupted() {
        return this.interrupted.get();
    }

    public final void awake() {
        Logger.d("__ awake()");
        cancelAll();
        CountDownLatch countDownLatch2 = this.countDownLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
    }

    public final void interrupt() {
        Logger.d(">> CancelableThreadHolder interrupt()");
        this.interrupted.set(true);
        awake();
    }
}
