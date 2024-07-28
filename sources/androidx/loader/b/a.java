package androidx.loader.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.d.j;
import androidx.core.g.g;
import androidx.loader.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends c<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile a<D>.defpackage.a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile a<D>.defpackage.a mTask;
    long mUpdateThrottle;

    public void cancelLoadInBackground() {
    }

    public abstract D loadInBackground();

    public void onCanceled(D d2) {
    }

    /* renamed from: androidx.loader.b.a$a  reason: collision with other inner class name */
    final class C0058a extends d<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final CountDownLatch f3707a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        boolean f3708b;

        C0058a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public D a() {
            try {
                return a.this.onLoadInBackground();
            } catch (j e2) {
                if (this.f3726h.get()) {
                    return null;
                }
                throw e2;
            }
        }

        /* access modifiers changed from: protected */
        public final void a(D d2) {
            try {
                a.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.f3707a.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public final void b(D d2) {
            try {
                a.this.dispatchOnCancelled(this, d2);
            } finally {
                this.f3707a.countDown();
            }
        }

        public final void run() {
            this.f3708b = false;
            a.this.executePendingTask();
        }
    }

    public a(Context context) {
        this(context, d.f3722d);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new C0058a();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f3708b) {
                this.mTask.f3708b = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f3708b) {
            this.mTask.f3708b = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            a<D>.defpackage.a aVar = this.mTask;
            aVar.f3726h.set(true);
            boolean cancel = aVar.f3724f.cancel(false);
            if (cancel) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return cancel;
        }
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f3708b) {
                this.mTask.f3708b = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                a<D>.defpackage.a aVar = this.mTask;
                Executor executor = this.mExecutor;
                if (aVar.f3725g != d.c.PENDING) {
                    int i2 = d.AnonymousClass4.f3731a[aVar.f3725g.ordinal()];
                    if (i2 == 1) {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    } else if (i2 != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                } else {
                    aVar.f3725g = d.c.RUNNING;
                    aVar.f3723e.f3734b = null;
                    executor.execute(aVar.f3724f);
                }
            } else {
                this.mTask.f3708b = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(a<D>.defpackage.a aVar, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(a<D>.defpackage.a aVar, D d2) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d2);
        } else if (isAbandoned()) {
            onCanceled(d2);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d2);
        }
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        a<D>.defpackage.a aVar = this.mTask;
        if (aVar != null) {
            try {
                aVar.f3707a.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f3708b);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f3708b);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            g.a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            g.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
