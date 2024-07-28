package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.a;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<a.C0757a> readyAsyncCalls = new ArrayDeque();
    private final Deque<a.C0757a> runningAsyncCalls = new ArrayDeque();
    private final Deque<a> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    public Dispatcher() {
    }

    public final synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public final void setMaxRequests(int i2) {
        if (i2 > 0) {
            synchronized (this) {
                this.maxRequests = i2;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i2)));
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final void setMaxRequestsPerHost(int i2) {
        if (i2 > 0) {
            synchronized (this) {
                this.maxRequestsPerHost = i2;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i2)));
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    /* access modifiers changed from: package-private */
    public final void enqueue(a.C0757a aVar) {
        synchronized (this) {
            this.readyAsyncCalls.add(aVar);
        }
        promoteAndExecute();
    }

    public final synchronized void cancelAll() {
        for (a.C0757a aVar : this.readyAsyncCalls) {
            a.this.cancel();
        }
        for (a.C0757a aVar2 : this.runningAsyncCalls) {
            a.this.cancel();
        }
        for (a cancel : this.runningSyncCalls) {
            cancel.cancel();
        }
    }

    private boolean promoteAndExecute() {
        int i2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<a.C0757a> it2 = this.readyAsyncCalls.iterator();
            while (it2.hasNext()) {
                a.C0757a next = it2.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                } else if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it2.remove();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            i2 = 0;
            z = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        while (i2 < size) {
            a.C0757a aVar = (a.C0757a) arrayList.get(i2);
            ExecutorService executorService2 = executorService();
            if (a.C0757a.f45047b || !Thread.holdsLock(a.this.f45039a.dispatcher())) {
                try {
                    executorService2.execute(aVar);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    a.this.f45044f.callFailed(a.this, interruptedIOException);
                    aVar.f45048a.onFailure(a.this, interruptedIOException);
                    a.this.f45039a.dispatcher().finished(aVar);
                } catch (Throwable th) {
                    a.this.f45039a.dispatcher().finished(aVar);
                    throw th;
                }
                i2++;
            } else {
                throw new AssertionError();
            }
        }
        return z;
    }

    private int runningCallsForHost(a.C0757a aVar) {
        int i2 = 0;
        for (a.C0757a next : this.runningAsyncCalls) {
            if (!a.this.f45043e && next.a().equals(aVar.a())) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void executed(a aVar) {
        this.runningSyncCalls.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void finished(a.C0757a aVar) {
        finished(this.runningAsyncCalls, aVar);
    }

    /* access modifiers changed from: package-private */
    public final void finished(a aVar) {
        finished(this.runningSyncCalls, aVar);
    }

    private <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    public final synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (a.C0757a aVar : this.readyAsyncCalls) {
            arrayList.add(a.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        for (a.C0757a aVar : this.runningAsyncCalls) {
            arrayList.add(a.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }
}
