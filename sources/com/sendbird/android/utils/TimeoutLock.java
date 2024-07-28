package com.sendbird.android.utils;

import com.sendbird.android.log.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class TimeoutLock {
    private static final long DEFAULT_TIMEOUT = 10000;
    /* access modifiers changed from: private */
    public final CountDownLatch countDownLatch;
    /* access modifiers changed from: private */
    public final AtomicBoolean interrupted;
    private final AtomicBoolean isWaiting;
    private final AtomicReference<Future<?>> job;
    private final TimeUnit timeUnit;
    private final long timeout;
    private final ScheduledExecutorService timer;

    public static class TimeoutException extends Exception {
        TimeoutException(String str) {
            super(str);
        }
    }

    public TimeoutLock() {
        this(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    public TimeoutLock(long j, TimeUnit timeUnit2) {
        this.timer = Executors.newSingleThreadScheduledExecutor();
        this.countDownLatch = new CountDownLatch(1);
        this.interrupted = new AtomicBoolean(false);
        this.isWaiting = new AtomicBoolean(false);
        this.job = new AtomicReference<>();
        this.timeout = j;
        this.timeUnit = timeUnit2;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void await() throws InterruptedException, TimeoutException {
        Logger.d(">> TimeoutLock::await(%s)", this);
        if (this.countDownLatch.getCount() == 0) {
            cancel();
            Logger.d("-- return TimeoutLock already released ");
        } else if (!this.interrupted.getAndSet(false)) {
            Logger.d("++ isWaiting : " + this.isWaiting.get());
            if (!this.isWaiting.getAndSet(true)) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                try {
                    this.job.set(this.timer.schedule(new Runnable() {
                        public final void run() {
                            boolean z = true;
                            Logger.d("++ TimeoutLock::Timeout( count=%s)", Long.valueOf(TimeoutLock.this.countDownLatch.getCount()));
                            TimeoutLock.this.interrupted.set(false);
                            AtomicBoolean atomicBoolean = atomicBoolean;
                            if (TimeoutLock.this.countDownLatch.getCount() <= 0) {
                                z = false;
                            }
                            atomicBoolean.compareAndSet(false, z);
                            TimeoutLock.this.countDownLatch.countDown();
                        }
                    }, this.timeout, this.timeUnit));
                    this.countDownLatch.await();
                    this.isWaiting.set(false);
                    cancel();
                    Logger.d("++ await end interrupted=%s, isTimeout=%s", this.interrupted, Boolean.valueOf(atomicBoolean.get()));
                    if (this.interrupted.getAndSet(false)) {
                        throw new InterruptedException("a job was interrupted");
                    } else if (atomicBoolean.getAndSet(false)) {
                        throw new TimeoutException("exceed the timed out");
                    }
                } catch (Throwable th) {
                    this.isWaiting.set(false);
                    cancel();
                    throw th;
                }
            }
        } else {
            throw new InterruptedException("a job was interrupted");
        }
    }

    private void cancel() {
        Future andSet = this.job.getAndSet((Object) null);
        if (andSet != null) {
            Logger.d(">> TimeoutLock::cancel() job : ".concat(String.valueOf(andSet)));
            andSet.cancel(false);
        }
    }

    public final void release() {
        Logger.d(">> TimeoutLock::release(%s)", this);
        cancel();
        this.countDownLatch.countDown();
    }

    public final void interrupt() {
        Logger.i(">> TimeoutLock::isWaiting() : " + this.isWaiting.get(), new Object[0]);
        if (this.isWaiting.get()) {
            Logger.i(">> TimeoutLock::interrupt()", new Object[0]);
            this.interrupted.set(true);
            release();
        }
    }
}
