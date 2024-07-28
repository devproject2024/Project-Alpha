package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections = new LinkedList<>();
    private final Runnable connectionsCleanupRunnable = new Runnable() {
        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    };
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : DEFAULT_KEEP_ALIVE_DURATION_MS;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, parseLong);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), parseLong);
        } else {
            systemDefault = new ConnectionPool(5, parseLong);
        }
    }

    public ConnectionPool(int i2, long j) {
        this.maxIdleConnections = i2;
        this.keepAliveDurationNs = j * 1000 * 1000;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    public final synchronized int getConnectionCount() {
        return this.connections.size();
    }

    @Deprecated
    public final synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    public final synchronized int getMultiplexedConnectionCount() {
        int i2;
        i2 = 0;
        Iterator it2 = this.connections.iterator();
        while (it2.hasNext()) {
            if (((Connection) it2.next()).isFramed()) {
                i2++;
            }
        }
        return i2;
    }

    public final synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        r0 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.squareup.okhttp.Connection get(com.squareup.okhttp.Address r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.util.LinkedList<com.squareup.okhttp.Connection> r1 = r8.connections     // Catch:{ all -> 0x007c }
            java.util.LinkedList<com.squareup.okhttp.Connection> r2 = r8.connections     // Catch:{ all -> 0x007c }
            int r2 = r2.size()     // Catch:{ all -> 0x007c }
            java.util.ListIterator r1 = r1.listIterator(r2)     // Catch:{ all -> 0x007c }
        L_0x000e:
            boolean r2 = r1.hasPrevious()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x006d
            java.lang.Object r2 = r1.previous()     // Catch:{ all -> 0x007c }
            com.squareup.okhttp.Connection r2 = (com.squareup.okhttp.Connection) r2     // Catch:{ all -> 0x007c }
            com.squareup.okhttp.Route r3 = r2.getRoute()     // Catch:{ all -> 0x007c }
            com.squareup.okhttp.Address r3 = r3.getAddress()     // Catch:{ all -> 0x007c }
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x000e
            boolean r3 = r2.isAlive()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x000e
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x007c }
            long r5 = r2.getIdleStartTimeNs()     // Catch:{ all -> 0x007c }
            long r3 = r3 - r5
            long r5 = r8.keepAliveDurationNs     // Catch:{ all -> 0x007c }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x000e
            r1.remove()     // Catch:{ all -> 0x007c }
            boolean r3 = r2.isFramed()     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x006c
            com.squareup.okhttp.internal.Platform r3 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ SocketException -> 0x0052 }
            java.net.Socket r4 = r2.getSocket()     // Catch:{ SocketException -> 0x0052 }
            r3.tagSocket(r4)     // Catch:{ SocketException -> 0x0052 }
            goto L_0x006c
        L_0x0052:
            r3 = move-exception
            java.net.Socket r2 = r2.getSocket()     // Catch:{ all -> 0x007c }
            com.squareup.okhttp.internal.Util.closeQuietly((java.net.Socket) r2)     // Catch:{ all -> 0x007c }
            com.squareup.okhttp.internal.Platform r2 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "Unable to tagSocket(): "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x007c }
            java.lang.String r3 = r4.concat(r3)     // Catch:{ all -> 0x007c }
            r2.logW(r3)     // Catch:{ all -> 0x007c }
            goto L_0x000e
        L_0x006c:
            r0 = r2
        L_0x006d:
            if (r0 == 0) goto L_0x007a
            boolean r9 = r0.isFramed()     // Catch:{ all -> 0x007c }
            if (r9 == 0) goto L_0x007a
            java.util.LinkedList<com.squareup.okhttp.Connection> r9 = r8.connections     // Catch:{ all -> 0x007c }
            r9.addFirst(r0)     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r8)
            return r0
        L_0x007c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.ConnectionPool.get(com.squareup.okhttp.Address):com.squareup.okhttp.Connection");
    }

    /* access modifiers changed from: package-private */
    public final void recycle(Connection connection) {
        if (connection.isFramed() || !connection.clearOwner()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            synchronized (this) {
                addConnection(connection);
                connection.incrementRecycleCount();
                connection.resetIdleStartTime();
            }
        } catch (SocketException e2) {
            Platform.get().logW("Unable to untagSocket(): ".concat(String.valueOf(e2)));
            Util.closeQuietly(connection.getSocket());
        }
    }

    private void addConnection(Connection connection) {
        boolean isEmpty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (isEmpty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public final void share(Connection connection) {
        if (!connection.isFramed()) {
            throw new IllegalArgumentException();
        } else if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }

    public final void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
            notifyAll();
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Util.closeQuietly(((Connection) arrayList.get(i2)).getSocket());
        }
    }

    /* access modifiers changed from: private */
    public void runCleanupUntilPoolIsEmpty() {
        do {
        } while (performCleanup());
    }

    /* access modifiers changed from: package-private */
    public final boolean performCleanup() {
        synchronized (this) {
            if (this.connections.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            long nanoTime = System.nanoTime();
            long j = this.keepAliveDurationNs;
            ListIterator<Connection> listIterator = this.connections.listIterator(this.connections.size());
            long j2 = j;
            int i2 = 0;
            while (listIterator.hasPrevious()) {
                Connection previous = listIterator.previous();
                long idleStartTimeNs = (previous.getIdleStartTimeNs() + this.keepAliveDurationNs) - nanoTime;
                if (idleStartTimeNs > 0) {
                    if (previous.isAlive()) {
                        if (previous.isIdle()) {
                            i2++;
                            j2 = Math.min(j2, idleStartTimeNs);
                        }
                    }
                }
                listIterator.remove();
                arrayList.add(previous);
            }
            ListIterator<Connection> listIterator2 = this.connections.listIterator(this.connections.size());
            while (listIterator2.hasPrevious() && i2 > this.maxIdleConnections) {
                Connection previous2 = listIterator2.previous();
                if (previous2.isIdle()) {
                    arrayList.add(previous2);
                    listIterator2.remove();
                    i2--;
                }
            }
            if (arrayList.isEmpty()) {
                try {
                    long j3 = j2 / 1000000;
                    Long.signum(j3);
                    wait(j3, (int) (j2 - (1000000 * j3)));
                    return true;
                } catch (InterruptedException unused) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Util.closeQuietly(((Connection) arrayList.get(i3)).getSocket());
                    }
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void replaceCleanupExecutorForTests(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }
}
