package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.sqlite.db.c;
import androidx.sqlite.db.e;
import androidx.sqlite.db.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class j {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private final Map<String, Object> mBackingFieldMap = new ConcurrentHashMap();
    @Deprecated
    public List<b> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    @Deprecated
    public volatile androidx.sqlite.db.b mDatabase;
    private final g mInvalidationTracker = createInvalidationTracker();
    private androidx.sqlite.db.c mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;

    public static abstract class b {
        public void a(androidx.sqlite.db.b bVar) {
        }
    }

    public abstract void clearAllTables();

    /* access modifiers changed from: protected */
    public abstract g createInvalidationTracker();

    /* access modifiers changed from: protected */
    public abstract androidx.sqlite.db.c createOpenHelper(a aVar);

    /* access modifiers changed from: package-private */
    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    /* access modifiers changed from: package-private */
    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public void init(a aVar) {
        this.mOpenHelper = createOpenHelper(aVar);
        androidx.sqlite.db.c cVar = this.mOpenHelper;
        if (cVar instanceof o) {
            ((o) cVar).f4492a = aVar;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar.f4379g == c.WRITE_AHEAD_LOGGING) {
                z = true;
            }
            this.mOpenHelper.a(z);
        }
        this.mCallbacks = aVar.f4377e;
        this.mQueryExecutor = aVar.f4380h;
        this.mTransactionExecutor = new s(aVar.f4381i);
        this.mAllowMainThreadQueries = aVar.f4378f;
        this.mWriteAheadLoggingEnabled = z;
        if (aVar.j) {
            g gVar = this.mInvalidationTracker;
            gVar.f4424h = new h(aVar.f4374b, aVar.f4375c, gVar, gVar.f4419c.getQueryExecutor());
        }
    }

    public androidx.sqlite.db.c getOpenHelper() {
        return this.mOpenHelper;
    }

    public boolean isOpen() {
        androidx.sqlite.db.b bVar = this.mDatabase;
        return bVar != null && bVar.e();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|(1:12)|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r6 = this;
            boolean r0 = r6.isOpen()
            if (r0 == 0) goto L_0x004b
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r6.mCloseLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            androidx.room.g r1 = r6.mInvalidationTracker     // Catch:{ all -> 0x0046 }
            androidx.room.h r2 = r1.f4424h     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x003d
            androidx.room.h r2 = r1.f4424h     // Catch:{ all -> 0x0046 }
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.f4447i     // Catch:{ all -> 0x0046 }
            r4 = 0
            r5 = 1
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x003a
            androidx.room.g r3 = r2.f4442d     // Catch:{ all -> 0x0046 }
            androidx.room.g$b r4 = r2.f4443e     // Catch:{ all -> 0x0046 }
            r3.c(r4)     // Catch:{ all -> 0x0046 }
            androidx.room.e r3 = r2.f4444f     // Catch:{ RemoteException -> 0x0033 }
            if (r3 == 0) goto L_0x0033
            androidx.room.d r4 = r2.f4446h     // Catch:{ RemoteException -> 0x0033 }
            int r5 = r2.f4441c     // Catch:{ RemoteException -> 0x0033 }
            r3.a((androidx.room.d) r4, (int) r5)     // Catch:{ RemoteException -> 0x0033 }
        L_0x0033:
            android.content.Context r3 = r2.f4439a     // Catch:{ all -> 0x0046 }
            android.content.ServiceConnection r2 = r2.j     // Catch:{ all -> 0x0046 }
            r3.unbindService(r2)     // Catch:{ all -> 0x0046 }
        L_0x003a:
            r2 = 0
            r1.f4424h = r2     // Catch:{ all -> 0x0046 }
        L_0x003d:
            androidx.sqlite.db.c r1 = r6.mOpenHelper     // Catch:{ all -> 0x0046 }
            r1.close()     // Catch:{ all -> 0x0046 }
            r0.unlock()
            return
        L_0x0046:
            r1 = move-exception
            r0.unlock()
            throw r1
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.j.close():void");
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.b().a((e) new androidx.sqlite.db.a(str, objArr));
    }

    public Cursor query(e eVar) {
        return query(eVar, (CancellationSignal) null);
    }

    public Cursor query(e eVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal == null || Build.VERSION.SDK_INT < 16) {
            return this.mOpenHelper.b().a(eVar);
        }
        return this.mOpenHelper.b().a(eVar, cancellationSignal);
    }

    public f compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.b().a(str);
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        androidx.sqlite.db.b b2 = this.mOpenHelper.b();
        this.mInvalidationTracker.a(b2);
        b2.a();
    }

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.b().b();
        if (!inTransaction()) {
            g gVar = this.mInvalidationTracker;
            if (gVar.f4420d.compareAndSet(false, true)) {
                gVar.f4419c.getQueryExecutor().execute(gVar.f4425i);
            }
        }
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.b().c();
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw e3;
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }

    public void internalInitInvalidationTracker(androidx.sqlite.db.b bVar) {
        g gVar = this.mInvalidationTracker;
        synchronized (gVar) {
            if (!gVar.f4421e) {
                bVar.c("PRAGMA temp_store = MEMORY;");
                bVar.c("PRAGMA recursive_triggers='ON';");
                bVar.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                gVar.a(bVar);
                gVar.f4422f = bVar.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                gVar.f4421e = true;
            }
        }
    }

    public g getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.b().d();
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        /* access modifiers changed from: package-private */
        public final c resolve(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT < 16 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }
    }

    public static class a<T extends j> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4455a;

        /* renamed from: b  reason: collision with root package name */
        private final String f4456b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f4457c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f4458d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f4459e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f4460f;

        /* renamed from: g  reason: collision with root package name */
        private c.C0072c f4461g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4462h;

        /* renamed from: i  reason: collision with root package name */
        private c f4463i = c.AUTOMATIC;
        private boolean j;
        private boolean k = true;
        private boolean l;
        private final d m = new d();
        private Set<Integer> n;
        private Set<Integer> o;
        private String p;
        private File q;

        a(Context context, Class<T> cls, String str) {
            this.f4457c = context;
            this.f4455a = cls;
            this.f4456b = str;
        }

        public final a<T> a(c.C0072c cVar) {
            this.f4461g = cVar;
            return this;
        }

        public final a<T> a(androidx.room.a.a... aVarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (androidx.room.a.a aVar : aVarArr) {
                this.o.add(Integer.valueOf(aVar.startVersion));
                this.o.add(Integer.valueOf(aVar.endVersion));
            }
            this.m.a(aVarArr);
            return this;
        }

        public final a<T> a() {
            this.f4462h = true;
            return this;
        }

        public final a<T> a(Executor executor) {
            this.f4459e = executor;
            return this;
        }

        public final a<T> b() {
            this.k = false;
            this.l = true;
            return this;
        }

        public final a<T> a(b bVar) {
            if (this.f4458d == null) {
                this.f4458d = new ArrayList<>();
            }
            this.f4458d.add(bVar);
            return this;
        }

        public final T c() {
            Executor executor;
            if (this.f4457c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f4455a != null) {
                if (this.f4459e == null && this.f4460f == null) {
                    Executor c2 = androidx.arch.core.a.a.c();
                    this.f4460f = c2;
                    this.f4459e = c2;
                } else {
                    Executor executor2 = this.f4459e;
                    if (executor2 != null && this.f4460f == null) {
                        this.f4460f = executor2;
                    } else if (this.f4459e == null && (executor = this.f4460f) != null) {
                        this.f4459e = executor;
                    }
                }
                Set<Integer> set = this.o;
                if (!(set == null || this.n == null)) {
                    for (Integer next : set) {
                        if (this.n.contains(next)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ".concat(String.valueOf(next)));
                        }
                    }
                }
                if (this.f4461g == null) {
                    this.f4461g = new androidx.sqlite.db.framework.c();
                }
                if (!(this.p == null && this.q == null)) {
                    if (this.f4456b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    } else if (this.p == null || this.q == null) {
                        this.f4461g = new p(this.p, this.q, this.f4461g);
                    } else {
                        throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                    }
                }
                Context context = this.f4457c;
                String str = this.f4456b;
                c.C0072c cVar = this.f4461g;
                d dVar = this.m;
                ArrayList<b> arrayList = this.f4458d;
                boolean z = this.f4462h;
                c resolve = this.f4463i.resolve(context);
                Executor executor3 = this.f4459e;
                Executor executor4 = this.f4460f;
                boolean z2 = this.j;
                boolean z3 = this.k;
                boolean z4 = this.l;
                boolean z5 = z3;
                boolean z6 = z4;
                a aVar = new a(context, str, cVar, dVar, arrayList, z, resolve, executor3, executor4, z2, z5, z6, this.n, this.p, this.q);
                T t = (j) i.a(this.f4455a, j.DB_IMPL_SUFFIX);
                t.init(aVar);
                return t;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, androidx.room.a.a>> f4464a = new HashMap<>();

        public final void a(androidx.room.a.a... aVarArr) {
            for (androidx.room.a.a aVar : aVarArr) {
                int i2 = aVar.startVersion;
                int i3 = aVar.endVersion;
                TreeMap treeMap = this.f4464a.get(Integer.valueOf(i2));
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    this.f4464a.put(Integer.valueOf(i2), treeMap);
                }
                androidx.room.a.a aVar2 = (androidx.room.a.a) treeMap.get(Integer.valueOf(i3));
                if (aVar2 != null) {
                    StringBuilder sb = new StringBuilder("Overriding migration ");
                    sb.append(aVar2);
                    sb.append(" with ");
                    sb.append(aVar);
                }
                treeMap.put(Integer.valueOf(i3), aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final List<androidx.room.a.a> a(List<androidx.room.a.a> list, boolean z, int i2, int i3) {
            Set set;
            boolean z2;
            do {
                if (z) {
                    if (i2 >= i3) {
                        return list;
                    }
                } else if (i2 <= i3) {
                    return list;
                }
                TreeMap treeMap = this.f4464a.get(Integer.valueOf(i2));
                if (treeMap != null) {
                    if (z) {
                        set = treeMap.descendingKeySet();
                    } else {
                        set = treeMap.keySet();
                    }
                    Iterator it2 = set.iterator();
                    while (true) {
                        z2 = true;
                        boolean z3 = false;
                        if (!it2.hasNext()) {
                            z2 = false;
                            continue;
                            break;
                        }
                        int intValue = ((Integer) it2.next()).intValue();
                        if (!z ? !(intValue < i3 || intValue >= i2) : !(intValue > i3 || intValue <= i2)) {
                            z3 = true;
                            continue;
                        }
                        if (z3) {
                            list.add((androidx.room.a.a) treeMap.get(Integer.valueOf(intValue)));
                            i2 = intValue;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z2);
            return null;
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
