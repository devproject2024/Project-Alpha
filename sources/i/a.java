package i;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class a extends w {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        Class<a> cls = a.class;
        synchronized (cls) {
            if (head == null) {
                head = new a();
                new C0779a().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 != 0 && z) {
                aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                aVar.timeoutAt = j + nanoTime;
            } else if (z) {
                aVar.timeoutAt = aVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = aVar.remainingNanos(nanoTime);
            a aVar2 = head;
            while (true) {
                if (aVar2.next == null) {
                    break;
                } else if (remainingNanos < aVar2.next.remainingNanos(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.next;
                }
            }
            aVar.next = aVar2.next;
            aVar2.next = aVar;
            if (aVar2 == head) {
                cls.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = head; aVar2 != null; aVar2 = aVar2.next) {
                if (aVar2.next == aVar) {
                    aVar2.next = aVar.next;
                    aVar.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final u sink(final u uVar) {
        return new u() {
            public final void write(c cVar, long j) throws IOException {
                x.a(cVar.f46277b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        r rVar = cVar.f46276a;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += (long) (rVar.f46322c - rVar.f46321b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            rVar = rVar.f46325f;
                        }
                        a.this.enter();
                        try {
                            uVar.write(cVar, j2);
                            j -= j2;
                            a.this.exit(true);
                        } catch (IOException e2) {
                            throw a.this.exit(e2);
                        } catch (Throwable th) {
                            a.this.exit(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public final void flush() throws IOException {
                a.this.enter();
                try {
                    uVar.flush();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public final void close() throws IOException {
                a.this.enter();
                try {
                    uVar.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public final w timeout() {
                return a.this;
            }

            public final String toString() {
                return "AsyncTimeout.sink(" + uVar + ")";
            }
        };
    }

    public final v source(final v vVar) {
        return new v() {
            public final long read(c cVar, long j) throws IOException {
                a.this.enter();
                try {
                    long read = vVar.read(cVar, j);
                    a.this.exit(true);
                    return read;
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public final void close() throws IOException {
                a.this.enter();
                try {
                    vVar.close();
                    a.this.exit(true);
                } catch (IOException e2) {
                    throw a.this.exit(e2);
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            public final w timeout() {
                return a.this;
            }

            public final String toString() {
                return "AsyncTimeout.source(" + vVar + ")";
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: i.a$a  reason: collision with other inner class name */
    static final class C0779a extends Thread {
        C0779a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<i.a> r0 = i.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                i.a r1 = i.a.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                i.a r2 = i.a.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                i.a.head = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: i.a.C0779a.run():void");
        }
    }

    static a awaitTimeout() throws InterruptedException {
        Class<a> cls = a.class;
        a aVar = head.next;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = aVar.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            cls.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = aVar.next;
        aVar.next = null;
        return aVar;
    }
}
