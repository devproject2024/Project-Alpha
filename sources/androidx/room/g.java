package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.f;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public final class g {
    private static final String[] j = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f4417a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f4418b;

    /* renamed from: c  reason: collision with root package name */
    final j f4419c;

    /* renamed from: d  reason: collision with root package name */
    AtomicBoolean f4420d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f4421e;

    /* renamed from: f  reason: collision with root package name */
    volatile f f4422f;

    /* renamed from: g  reason: collision with root package name */
    final androidx.arch.core.b.b<b, c> f4423g;

    /* renamed from: h  reason: collision with root package name */
    h f4424h;

    /* renamed from: i  reason: collision with root package name */
    Runnable f4425i;
    private Map<String, Set<String>> k;
    private a l;
    private final f m;

    public g(j jVar, String... strArr) {
        this(jVar, new HashMap(), Collections.emptyMap(), strArr);
    }

    public g(j jVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f4420d = new AtomicBoolean(false);
        this.f4421e = false;
        this.f4423g = new androidx.arch.core.b.b<>();
        this.f4425i = new Runnable() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.util.Set<java.lang.Integer>} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: androidx.sqlite.db.c} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.util.Set<java.lang.Integer>} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.util.Set<java.lang.Integer>} */
            /* JADX WARNING: type inference failed for: r5v3, types: [boolean] */
            /* JADX WARNING: type inference failed for: r5v9, types: [boolean] */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
                r0.unlock();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0083, code lost:
                r5 = null;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0033 A[SYNTHETIC, Splitter:B:14:0x0033] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x007e A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000e] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x008f  */
            /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r11 = this;
                    androidx.room.g r0 = androidx.room.g.this
                    androidx.room.j r0 = r0.f4419c
                    java.util.concurrent.locks.Lock r0 = r0.getCloseLock()
                    r0.lock()
                    r1 = 0
                    r2 = 1
                    r3 = 0
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.room.j r5 = r4.f4419c     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    boolean r5 = r5.isOpen()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r5 != 0) goto L_0x001a
                L_0x0018:
                    r4 = 0
                    goto L_0x002d
                L_0x001a:
                    boolean r5 = r4.f4421e     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r5 != 0) goto L_0x0027
                    androidx.room.j r5 = r4.f4419c     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.sqlite.db.c r5 = r5.getOpenHelper()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    r5.b()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                L_0x0027:
                    boolean r4 = r4.f4421e     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r4 != 0) goto L_0x002c
                    goto L_0x0018
                L_0x002c:
                    r4 = 1
                L_0x002d:
                    if (r4 != 0) goto L_0x0033
                    r0.unlock()
                    return
                L_0x0033:
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    java.util.concurrent.atomic.AtomicBoolean r4 = r4.f4420d     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    boolean r4 = r4.compareAndSet(r2, r3)     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r4 != 0) goto L_0x0041
                    r0.unlock()
                    return
                L_0x0041:
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.room.j r4 = r4.f4419c     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    boolean r4 = r4.inTransaction()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r4 == 0) goto L_0x004f
                    r0.unlock()
                    return
                L_0x004f:
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.room.j r4 = r4.f4419c     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    boolean r4 = r4.mWriteAheadLoggingEnabled     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    if (r4 == 0) goto L_0x0079
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.room.j r4 = r4.f4419c     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.sqlite.db.c r4 = r4.getOpenHelper()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    androidx.sqlite.db.b r4 = r4.b()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    r4.a()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    java.util.Set r5 = r11.a()     // Catch:{ all -> 0x0073 }
                    r4.c()     // Catch:{ all -> 0x0071 }
                    r4.b()     // Catch:{ SQLiteException | IllegalStateException -> 0x0084, all -> 0x007e }
                    goto L_0x0084
                L_0x0071:
                    r6 = move-exception
                    goto L_0x0075
                L_0x0073:
                    r6 = move-exception
                    r5 = r1
                L_0x0075:
                    r4.b()     // Catch:{ SQLiteException | IllegalStateException -> 0x0084, all -> 0x007e }
                    throw r6     // Catch:{ SQLiteException | IllegalStateException -> 0x0084, all -> 0x007e }
                L_0x0079:
                    java.util.Set r5 = r11.a()     // Catch:{ SQLiteException | IllegalStateException -> 0x0083, all -> 0x007e }
                    goto L_0x0084
                L_0x007e:
                    r1 = move-exception
                    r0.unlock()
                    throw r1
                L_0x0083:
                    r5 = r1
                L_0x0084:
                    r0.unlock()
                    if (r5 == 0) goto L_0x00e6
                    boolean r0 = r5.isEmpty()
                    if (r0 != 0) goto L_0x00e6
                    androidx.room.g r0 = androidx.room.g.this
                    androidx.arch.core.b.b<androidx.room.g$b, androidx.room.g$c> r0 = r0.f4423g
                    monitor-enter(r0)
                    androidx.room.g r4 = androidx.room.g.this     // Catch:{ all -> 0x00e3 }
                    androidx.arch.core.b.b<androidx.room.g$b, androidx.room.g$c> r4 = r4.f4423g     // Catch:{ all -> 0x00e3 }
                    java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00e3 }
                L_0x009c:
                    boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00e3 }
                    if (r6 == 0) goto L_0x00e1
                    java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00e3 }
                    java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x00e3 }
                    java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00e3 }
                    androidx.room.g$c r6 = (androidx.room.g.c) r6     // Catch:{ all -> 0x00e3 }
                    int[] r7 = r6.f4433a     // Catch:{ all -> 0x00e3 }
                    int r7 = r7.length     // Catch:{ all -> 0x00e3 }
                    r9 = r1
                    r8 = 0
                L_0x00b3:
                    if (r8 >= r7) goto L_0x00d9
                    int[] r10 = r6.f4433a     // Catch:{ all -> 0x00e3 }
                    r10 = r10[r8]     // Catch:{ all -> 0x00e3 }
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00e3 }
                    boolean r10 = r5.contains(r10)     // Catch:{ all -> 0x00e3 }
                    if (r10 == 0) goto L_0x00d6
                    if (r7 != r2) goto L_0x00c8
                    java.util.Set<java.lang.String> r9 = r6.f4436d     // Catch:{ all -> 0x00e3 }
                    goto L_0x00d6
                L_0x00c8:
                    if (r9 != 0) goto L_0x00cf
                    java.util.HashSet r9 = new java.util.HashSet     // Catch:{ all -> 0x00e3 }
                    r9.<init>(r7)     // Catch:{ all -> 0x00e3 }
                L_0x00cf:
                    java.lang.String[] r10 = r6.f4434b     // Catch:{ all -> 0x00e3 }
                    r10 = r10[r8]     // Catch:{ all -> 0x00e3 }
                    r9.add(r10)     // Catch:{ all -> 0x00e3 }
                L_0x00d6:
                    int r8 = r8 + 1
                    goto L_0x00b3
                L_0x00d9:
                    if (r9 == 0) goto L_0x009c
                    androidx.room.g$b r6 = r6.f4435c     // Catch:{ all -> 0x00e3 }
                    r6.a(r9)     // Catch:{ all -> 0x00e3 }
                    goto L_0x009c
                L_0x00e1:
                    monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
                    return
                L_0x00e3:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
                    throw r1
                L_0x00e6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.g.AnonymousClass1.run():void");
            }

            /* JADX INFO: finally extract failed */
            private Set<Integer> a() {
                HashSet hashSet = new HashSet();
                Cursor query = g.this.f4419c.query(new androidx.sqlite.db.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                while (query.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(query.getInt(0)));
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
                if (!hashSet.isEmpty()) {
                    g.this.f4422f.a();
                }
                return hashSet;
            }
        };
        this.f4419c = jVar;
        this.l = new a(strArr.length);
        this.f4417a = new HashMap<>();
        this.k = map2;
        this.m = new f(this.f4419c);
        int length = strArr.length;
        this.f4418b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f4417a.put(lowerCase, Integer.valueOf(i2));
            String str = map.get(strArr[i2]);
            if (str != null) {
                this.f4418b[i2] = str.toLowerCase(Locale.US);
            } else {
                this.f4418b[i2] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            String lowerCase2 = ((String) next.getValue()).toLowerCase(Locale.US);
            if (this.f4417a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.f4417a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void a(androidx.sqlite.db.b bVar, int i2) {
        String str = this.f4418b[i2];
        StringBuilder sb = new StringBuilder();
        for (String a2 : j) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, a2);
            bVar.c(sb.toString());
        }
    }

    public final void a(b bVar) {
        c a2;
        String[] a3 = a(bVar.f4432a);
        int[] iArr = new int[a3.length];
        int length = a3.length;
        int i2 = 0;
        while (i2 < length) {
            Integer num = this.f4417a.get(a3[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + a3[i2]);
            }
        }
        c cVar = new c(bVar, iArr, a3);
        synchronized (this.f4423g) {
            a2 = this.f4423g.a(bVar, cVar);
        }
        if (a2 == null && this.l.a(iArr)) {
            a();
        }
    }

    private String[] a(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.k.containsKey(lowerCase)) {
                hashSet.addAll(this.k.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void b(b bVar) {
        a((b) new d(this, bVar));
    }

    public final void c(b bVar) {
        c b2;
        synchronized (this.f4423g) {
            b2 = this.f4423g.b(bVar);
        }
        if (b2 != null && this.l.b(b2.f4433a)) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(androidx.sqlite.db.b bVar) {
        if (!bVar.d()) {
            while (true) {
                try {
                    Lock closeLock = this.f4419c.getCloseLock();
                    closeLock.lock();
                    try {
                        int[] a2 = this.l.a();
                        if (a2 == null) {
                            closeLock.unlock();
                            return;
                        }
                        int length = a2.length;
                        bVar.a();
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = a2[i2];
                            if (i3 == 1) {
                                bVar.c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
                                String str = this.f4418b[i2];
                                StringBuilder sb = new StringBuilder();
                                for (String str2 : j) {
                                    sb.setLength(0);
                                    sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
                                    a(sb, str, str2);
                                    sb.append(" AFTER ");
                                    sb.append(str2);
                                    sb.append(" ON `");
                                    sb.append(str);
                                    sb.append("` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
                                    sb.append(i2);
                                    sb.append(" AND invalidated = 0; END");
                                    bVar.c(sb.toString());
                                }
                            } else if (i3 == 2) {
                                a(bVar, i2);
                            }
                        }
                        bVar.c();
                        bVar.b();
                        a aVar = this.l;
                        synchronized (aVar) {
                            aVar.f4431e = false;
                        }
                        closeLock.unlock();
                    } catch (Throwable th) {
                        closeLock.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException unused) {
                    return;
                }
            }
            while (true) {
            }
        }
    }

    private void a() {
        if (this.f4419c.isOpen()) {
            a(this.f4419c.getOpenHelper().b());
        }
    }

    public final <T> LiveData<T> a(String[] strArr, boolean z, Callable<T> callable) {
        f fVar = this.m;
        String[] a2 = a(strArr);
        int length = a2.length;
        int i2 = 0;
        while (i2 < length) {
            String str = a2[i2];
            if (this.f4417a.containsKey(str.toLowerCase(Locale.US))) {
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name ".concat(String.valueOf(str)));
            }
        }
        return new n(fVar.f4416b, fVar, z, callable, a2);
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f4433a;

        /* renamed from: b  reason: collision with root package name */
        final String[] f4434b;

        /* renamed from: c  reason: collision with root package name */
        final b f4435c;

        /* renamed from: d  reason: collision with root package name */
        final Set<String> f4436d;

        c(b bVar, int[] iArr, String[] strArr) {
            this.f4435c = bVar;
            this.f4433a = iArr;
            this.f4434b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.f4434b[0]);
                this.f4436d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f4436d = null;
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String[] f4432a;

        public abstract void a(Set<String> set);

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        protected b(String str, String... strArr) {
            this.f4432a = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.f4432a[strArr.length] = str;
        }

        public b(String[] strArr) {
            this.f4432a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final long[] f4427a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f4428b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f4429c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4430d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4431e;

        a(int i2) {
            this.f4427a = new long[i2];
            this.f4428b = new boolean[i2];
            this.f4429c = new int[i2];
            Arrays.fill(this.f4427a, 0);
            Arrays.fill(this.f4428b, false);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : iArr) {
                    long j = this.f4427a[i2];
                    this.f4427a[i2] = 1 + j;
                    if (j == 0) {
                        this.f4430d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : iArr) {
                    long j = this.f4427a[i2];
                    this.f4427a[i2] = j - 1;
                    if (j == 1) {
                        this.f4430d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final int[] a() {
            synchronized (this) {
                if (this.f4430d) {
                    if (!this.f4431e) {
                        int length = this.f4427a.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = 1;
                            if (i2 < length) {
                                boolean z = this.f4427a[i2] > 0;
                                if (z != this.f4428b[i2]) {
                                    int[] iArr = this.f4429c;
                                    if (!z) {
                                        i3 = 2;
                                    }
                                    iArr[i2] = i3;
                                } else {
                                    this.f4429c[i2] = 0;
                                }
                                this.f4428b[i2] = z;
                                i2++;
                            } else {
                                this.f4431e = true;
                                this.f4430d = false;
                                int[] iArr2 = this.f4429c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    static class d extends b {

        /* renamed from: b  reason: collision with root package name */
        final g f4437b;

        /* renamed from: c  reason: collision with root package name */
        final WeakReference<b> f4438c;

        d(g gVar, b bVar) {
            super(bVar.f4432a);
            this.f4437b = gVar;
            this.f4438c = new WeakReference<>(bVar);
        }

        public final void a(Set<String> set) {
            b bVar = (b) this.f4438c.get();
            if (bVar == null) {
                this.f4437b.c(this);
            } else {
                bVar.a(set);
            }
        }
    }
}
