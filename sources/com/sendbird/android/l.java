package com.sendbird.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class l implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f44827a = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final List<Future<?>> f44828b = new ArrayList();

    l() {
    }

    private synchronized <T> Future<T> a(Future<T> future) {
        this.f44828b.add(future);
        return future;
    }

    private synchronized <T> ScheduledFuture<T> a(ScheduledFuture<T> scheduledFuture) {
        this.f44828b.add(scheduledFuture);
        return scheduledFuture;
    }

    private synchronized <T> List<Future<T>> a(List<Future<T>> list) {
        this.f44828b.addAll(list);
        return list;
    }

    public final synchronized void a() {
        a(false);
    }

    public final synchronized void a(boolean z) {
        for (Future<?> cancel : this.f44828b) {
            cancel.cancel(z);
        }
        this.f44828b.clear();
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return a(this.f44827a.schedule(runnable, j, timeUnit));
    }

    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return a(this.f44827a.schedule(callable, j, timeUnit));
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return a(this.f44827a.scheduleAtFixedRate(runnable, j, j2, timeUnit));
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return a(this.f44827a.scheduleWithFixedDelay(runnable, j, j2, timeUnit));
    }

    public final void shutdown() {
        this.f44827a.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.f44827a.shutdownNow();
    }

    public final boolean isShutdown() {
        return this.f44827a.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f44827a.isTerminated();
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f44827a.awaitTermination(j, timeUnit);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return a(this.f44827a.submit(callable));
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        return a(this.f44827a.submit(runnable, t));
    }

    public final Future<?> submit(Runnable runnable) {
        return a(this.f44827a.submit(runnable));
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return a(this.f44827a.invokeAll(collection));
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return a(this.f44827a.invokeAll(collection, j, timeUnit));
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.f44827a.invokeAny(collection);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f44827a.invokeAny(collection, j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        a(this.f44827a.schedule(runnable, 0, TimeUnit.MILLISECONDS));
    }
}
