package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

class AsyncOperationExecutor implements Handler.Callback, Runnable {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private volatile int maxOperationCountToMerge = 50;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
    private volatile int waitForMergeMillis = 50;

    AsyncOperationExecutor() {
    }

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i2 = this.lastSequenceNumber + 1;
            this.lastSequenceNumber = i2;
            asyncOperation.sequenceNumber = i2;
            this.queue.add(asyncOperation);
            this.countOperationsEnqueued++;
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public void setMaxOperationCountToMerge(int i2) {
        this.maxOperationCountToMerge = i2;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    public void setWaitForMergeMillis(int i2) {
        this.waitForMergeMillis = i2;
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public synchronized boolean isCompleted() {
        return this.countOperationsEnqueued == this.countOperationsCompleted;
    }

    public synchronized void waitForCompletion() {
        while (!isCompleted()) {
            try {
                wait();
            } catch (InterruptedException e2) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e2);
            }
        }
    }

    public synchronized boolean waitForCompletion(int i2) {
        if (!isCompleted()) {
            try {
                wait((long) i2);
            } catch (InterruptedException e2) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e2);
            }
        }
        return isCompleted();
    }

    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.queue.poll(1, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = (AsyncOperation) this.queue.poll();
                        if (poll2 == null) {
                            this.executorRunning = false;
                            this.executorRunning = false;
                            return;
                        }
                    }
                }
                if (!poll2.isMergeTx() || (poll = this.queue.poll((long) this.waitForMergeMillis, TimeUnit.MILLISECONDS)) == null) {
                    executeOperationAndPostCompleted(poll2);
                } else if (poll2.isMergeableWith(poll)) {
                    mergeTxAndExecute(poll2, poll);
                } else {
                    executeOperationAndPostCompleted(poll2);
                    executeOperationAndPostCompleted(poll);
                }
            } catch (InterruptedException e2) {
                try {
                    DaoLog.w(Thread.currentThread().getName() + " was interruppted", e2);
                    return;
                } finally {
                    this.executorRunning = false;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation r8, org.greenrobot.greendao.async.AsyncOperation r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Async transaction could not be ended, success so far was: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r8)
            r1.add(r9)
            org.greenrobot.greendao.database.Database r8 = r8.getDatabase()
            r8.beginTransaction()
            r9 = 0
            r2 = 0
        L_0x0016:
            int r3 = r1.size()     // Catch:{ all -> 0x00ae }
            r4 = 1
            if (r2 >= r3) goto L_0x0062
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00ae }
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch:{ all -> 0x00ae }
            r7.executeOperation(r3)     // Catch:{ all -> 0x00ae }
            boolean r5 = r3.isFailed()     // Catch:{ all -> 0x00ae }
            if (r5 != 0) goto L_0x0062
            int r5 = r1.size()     // Catch:{ all -> 0x00ae }
            int r5 = r5 - r4
            if (r2 != r5) goto L_0x005f
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r5 = r7.queue     // Catch:{ all -> 0x00ae }
            java.lang.Object r5 = r5.peek()     // Catch:{ all -> 0x00ae }
            org.greenrobot.greendao.async.AsyncOperation r5 = (org.greenrobot.greendao.async.AsyncOperation) r5     // Catch:{ all -> 0x00ae }
            int r6 = r7.maxOperationCountToMerge     // Catch:{ all -> 0x00ae }
            if (r2 >= r6) goto L_0x005b
            boolean r3 = r3.isMergeableWith(r5)     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x005b
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r3 = r7.queue     // Catch:{ all -> 0x00ae }
            java.lang.Object r3 = r3.remove()     // Catch:{ all -> 0x00ae }
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch:{ all -> 0x00ae }
            if (r3 != r5) goto L_0x0053
            r1.add(r3)     // Catch:{ all -> 0x00ae }
            goto L_0x005f
        L_0x0053:
            org.greenrobot.greendao.DaoException r1 = new org.greenrobot.greendao.DaoException     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "Internal error: peeked op did not match removed op"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x00ae }
            throw r1     // Catch:{ all -> 0x00ae }
        L_0x005b:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x00ae }
            goto L_0x0063
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0062:
            r4 = 0
        L_0x0063:
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x0068 }
            r9 = r4
            goto L_0x0074
        L_0x0068:
            r8 = move-exception
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.concat(r2)
            org.greenrobot.greendao.DaoLog.i(r0, r8)
        L_0x0074:
            if (r9 == 0) goto L_0x0091
            int r8 = r1.size()
            java.util.Iterator r9 = r1.iterator()
        L_0x007e:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r9.next()
            org.greenrobot.greendao.async.AsyncOperation r0 = (org.greenrobot.greendao.async.AsyncOperation) r0
            r0.mergedOperationsCount = r8
            r7.handleOperationCompleted(r0)
            goto L_0x007e
        L_0x0090:
            return
        L_0x0091:
            java.lang.String r8 = "Reverted merged transaction because one of the operations failed. Executing operations one by one instead..."
            org.greenrobot.greendao.DaoLog.i(r8)
            java.util.Iterator r8 = r1.iterator()
        L_0x009a:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ad
            java.lang.Object r9 = r8.next()
            org.greenrobot.greendao.async.AsyncOperation r9 = (org.greenrobot.greendao.async.AsyncOperation) r9
            r9.reset()
            r7.executeOperationAndPostCompleted(r9)
            goto L_0x009a
        L_0x00ad:
            return
        L_0x00ae:
            r1 = move-exception
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x00b3 }
            goto L_0x00bf
        L_0x00b3:
            r8 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r9 = r0.concat(r9)
            org.greenrobot.greendao.DaoLog.i(r9, r8)
        L_0x00bf:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.async.AsyncOperationExecutor.mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation, org.greenrobot.greendao.async.AsyncOperation):void");
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.setCompleted();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            this.handlerMainThread.sendMessage(this.handlerMainThread.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            this.countOperationsCompleted++;
            if (this.countOperationsCompleted == this.countOperationsEnqueued) {
                notifyAll();
            }
        }
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        executeOperation(asyncOperation);
        handleOperationCompleted(asyncOperation);
    }

    private void executeOperation(AsyncOperation asyncOperation) {
        asyncOperation.timeStarted = System.currentTimeMillis();
        try {
            switch (asyncOperation.type) {
                case Delete:
                    asyncOperation.dao.delete(asyncOperation.parameter);
                    break;
                case DeleteInTxIterable:
                    asyncOperation.dao.deleteInTx((Iterable) asyncOperation.parameter);
                    break;
                case DeleteInTxArray:
                    asyncOperation.dao.deleteInTx((T[]) (Object[]) asyncOperation.parameter);
                    break;
                case Insert:
                    asyncOperation.dao.insert(asyncOperation.parameter);
                    break;
                case InsertInTxIterable:
                    asyncOperation.dao.insertInTx((Iterable) asyncOperation.parameter);
                    break;
                case InsertInTxArray:
                    asyncOperation.dao.insertInTx((T[]) (Object[]) asyncOperation.parameter);
                    break;
                case InsertOrReplace:
                    asyncOperation.dao.insertOrReplace(asyncOperation.parameter);
                    break;
                case InsertOrReplaceInTxIterable:
                    asyncOperation.dao.insertOrReplaceInTx((Iterable) asyncOperation.parameter);
                    break;
                case InsertOrReplaceInTxArray:
                    asyncOperation.dao.insertOrReplaceInTx((T[]) (Object[]) asyncOperation.parameter);
                    break;
                case Update:
                    asyncOperation.dao.update(asyncOperation.parameter);
                    break;
                case UpdateInTxIterable:
                    asyncOperation.dao.updateInTx((Iterable) asyncOperation.parameter);
                    break;
                case UpdateInTxArray:
                    asyncOperation.dao.updateInTx((T[]) (Object[]) asyncOperation.parameter);
                    break;
                case TransactionRunnable:
                    executeTransactionRunnable(asyncOperation);
                    break;
                case TransactionCallable:
                    executeTransactionCallable(asyncOperation);
                    break;
                case QueryList:
                    asyncOperation.result = ((Query) asyncOperation.parameter).forCurrentThread().list();
                    break;
                case QueryUnique:
                    asyncOperation.result = ((Query) asyncOperation.parameter).forCurrentThread().unique();
                    break;
                case DeleteByKey:
                    asyncOperation.dao.deleteByKey(asyncOperation.parameter);
                    break;
                case DeleteAll:
                    asyncOperation.dao.deleteAll();
                    break;
                case Load:
                    asyncOperation.result = asyncOperation.dao.load(asyncOperation.parameter);
                    break;
                case LoadAll:
                    asyncOperation.result = asyncOperation.dao.loadAll();
                    break;
                case Count:
                    asyncOperation.result = Long.valueOf(asyncOperation.dao.count());
                    break;
                case Refresh:
                    asyncOperation.dao.refresh(asyncOperation.parameter);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.type);
            }
        } catch (Throwable th) {
            asyncOperation.throwable = th;
        }
        asyncOperation.timeCompleted = System.currentTimeMillis();
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            ((Runnable) asyncOperation.parameter).run();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            asyncOperation.result = ((Callable) asyncOperation.parameter).call();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener == null) {
            return false;
        }
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        return false;
    }
}
