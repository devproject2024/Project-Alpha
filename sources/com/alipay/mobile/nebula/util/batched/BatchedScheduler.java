package com.alipay.mobile.nebula.util.batched;

import android.os.Handler;
import android.os.HandlerThread;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BatchedScheduler<T> {
    /* access modifiers changed from: private */
    public final String TAG = ("Batched@" + getClass().getSimpleName());
    private final List<T> batchedList;
    private AtomicBoolean isPaused = new AtomicBoolean(false);
    private final Executor mainExecutor;
    private Handler scheduleHandler;
    private HandlerThread scheduleHandlerThread;
    private BatchedScheduler<T>.ScheduleRunnable scheduleRunnable = new ScheduleRunnable();

    /* access modifiers changed from: protected */
    public abstract void onSchedule(List<T> list);

    /* access modifiers changed from: protected */
    public long thresholdInterval() {
        return 500;
    }

    /* access modifiers changed from: protected */
    public int thresholdSize() {
        return 16;
    }

    public BatchedScheduler(Executor executor) {
        this.mainExecutor = executor;
        this.batchedList = new LinkedList();
        this.scheduleHandlerThread = new HandlerThread(this.TAG);
        this.scheduleHandlerThread.start();
        this.scheduleHandler = new Handler(this.scheduleHandlerThread.getLooper());
    }

    public void pause() {
        H5Log.d(this.TAG, "pause!");
        this.isPaused.set(true);
    }

    public void resume() {
        if (!this.isPaused.get()) {
            H5Log.d(this.TAG, "not resume because not paused");
            return;
        }
        H5Log.d(this.TAG, "resume!");
        int i2 = 0;
        this.isPaused.set(false);
        synchronized (this.batchedList) {
            H5Log.d(this.TAG, "=== resume schedule batched tasks begin====");
            int size = this.batchedList.size();
            int thresholdSize = size / thresholdSize();
            while (i2 <= thresholdSize) {
                int thresholdSize2 = thresholdSize() * i2;
                i2++;
                int thresholdSize3 = thresholdSize() * i2;
                if (thresholdSize3 > size) {
                    thresholdSize3 = size;
                }
                doExecute(new ArrayList(this.batchedList.subList(thresholdSize2, thresholdSize3)));
            }
            this.batchedList.clear();
            H5Log.d(this.TAG, "=== resume schedule batched tasks over====");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (com.alipay.mobile.nebula.util.batched.BatchedScheduler.ScheduleRunnable.access$100(r3.scheduleRunnable) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r3.scheduleRunnable.start();
        r3.scheduleHandler.postDelayed(r3.scheduleRunnable, thresholdInterval());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void post(T r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            android.os.HandlerThread r0 = r3.scheduleHandlerThread
            if (r0 != 0) goto L_0x000f
            java.lang.String r4 = r3.TAG
            java.lang.String r0 = "cannot post task because BatchedScheduler is shut down!"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            return
        L_0x000f:
            java.util.List<T> r0 = r3.batchedList
            monitor-enter(r0)
            java.util.List<T> r1 = r3.batchedList     // Catch:{ all -> 0x008d }
            r1.add(r4)     // Catch:{ all -> 0x008d }
            java.util.concurrent.atomic.AtomicBoolean r4 = r3.isPaused     // Catch:{ all -> 0x008d }
            boolean r4 = r4.get()     // Catch:{ all -> 0x008d }
            if (r4 == 0) goto L_0x0035
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            boolean r4 = r4.isScheduled     // Catch:{ all -> 0x008d }
            if (r4 == 0) goto L_0x0033
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            r4.cancel()     // Catch:{ all -> 0x008d }
            android.os.Handler r4 = r3.scheduleHandler     // Catch:{ all -> 0x008d }
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r1 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            r4.removeCallbacks(r1)     // Catch:{ all -> 0x008d }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x0035:
            java.util.List<T> r4 = r3.batchedList     // Catch:{ all -> 0x008d }
            int r4 = r4.size()     // Catch:{ all -> 0x008d }
            int r1 = r3.thresholdSize()     // Catch:{ all -> 0x008d }
            if (r4 <= r1) goto L_0x0073
            java.lang.String r4 = r3.TAG     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "schedule now! size: "
            r1.<init>(r2)     // Catch:{ all -> 0x008d }
            java.util.List<T> r2 = r3.batchedList     // Catch:{ all -> 0x008d }
            int r2 = r2.size()     // Catch:{ all -> 0x008d }
            r1.append(r2)     // Catch:{ all -> 0x008d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008d }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r1)     // Catch:{ all -> 0x008d }
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            boolean r4 = r4.isScheduled     // Catch:{ all -> 0x008d }
            if (r4 == 0) goto L_0x006e
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            r4.cancel()     // Catch:{ all -> 0x008d }
            android.os.Handler r4 = r3.scheduleHandler     // Catch:{ all -> 0x008d }
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r1 = r3.scheduleRunnable     // Catch:{ all -> 0x008d }
            r4.removeCallbacks(r1)     // Catch:{ all -> 0x008d }
        L_0x006e:
            r3.cloneAndExecute()     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable
            boolean r4 = r4.isScheduled
            if (r4 != 0) goto L_0x008c
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r4 = r3.scheduleRunnable
            r4.start()
            android.os.Handler r4 = r3.scheduleHandler
            com.alipay.mobile.nebula.util.batched.BatchedScheduler<T>$ScheduleRunnable r0 = r3.scheduleRunnable
            long r1 = r3.thresholdInterval()
            r4.postDelayed(r0, r1)
        L_0x008c:
            return
        L_0x008d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.batched.BatchedScheduler.post(java.lang.Object):void");
    }

    public void shutdown() {
        H5Log.d(this.TAG, "shutdown");
        if (this.scheduleHandlerThread != null) {
            this.scheduleHandler.removeCallbacks(this.scheduleRunnable);
            this.scheduleHandler = null;
            cloneAndExecute();
            this.scheduleHandlerThread.quit();
            this.scheduleHandlerThread = null;
        }
    }

    /* access modifiers changed from: private */
    public void cloneAndExecute() {
        H5Log.d(this.TAG, "cloneAndExecute");
        synchronized (this.batchedList) {
            if (this.batchedList.size() != 0) {
                ArrayList arrayList = new ArrayList(this.batchedList);
                this.batchedList.clear();
                doExecute(arrayList);
            }
        }
    }

    private void doExecute(final List<T> list) {
        String str = this.TAG;
        H5Log.d(str, "doExecute " + list.size() + " items");
        this.mainExecutor.execute(new Runnable() {
            public void run() {
                BatchedScheduler.this.onSchedule(list);
            }
        });
    }

    class ScheduleRunnable implements Runnable {
        private volatile boolean isCancelled;
        /* access modifiers changed from: private */
        public volatile boolean isScheduled;

        private ScheduleRunnable() {
            this.isScheduled = false;
            this.isCancelled = false;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            H5Log.d(BatchedScheduler.this.TAG, "start schedule");
            this.isCancelled = false;
            this.isScheduled = true;
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            H5Log.d(BatchedScheduler.this.TAG, "cancel schedule");
            this.isCancelled = true;
            this.isScheduled = false;
        }

        public void run() {
            if (!this.isCancelled) {
                BatchedScheduler.this.cloneAndExecute();
                this.isScheduled = false;
            }
        }
    }
}
