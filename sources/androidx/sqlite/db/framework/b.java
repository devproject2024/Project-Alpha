package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.sqlite.db.c;
import java.io.File;

final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4557a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4558b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f4559c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4560d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4561e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a f4562f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4563g;

    b(Context context, String str, c.a aVar, boolean z) {
        this.f4557a = context;
        this.f4558b = str;
        this.f4559c = aVar;
        this.f4560d = z;
    }

    private a c() {
        a aVar;
        synchronized (this.f4561e) {
            if (this.f4562f == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f4558b == null || !this.f4560d) {
                    this.f4562f = new a(this.f4557a, this.f4558b, aVarArr, this.f4559c);
                } else {
                    this.f4562f = new a(this.f4557a, new File(this.f4557a.getNoBackupFilesDir(), this.f4558b).getAbsolutePath(), aVarArr, this.f4559c);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f4562f.setWriteAheadLoggingEnabled(this.f4563g);
                }
            }
            aVar = this.f4562f;
        }
        return aVar;
    }

    public final String a() {
        return this.f4558b;
    }

    public final void a(boolean z) {
        synchronized (this.f4561e) {
            if (this.f4562f != null) {
                this.f4562f.setWriteAheadLoggingEnabled(z);
            }
            this.f4563g = z;
        }
    }

    public final androidx.sqlite.db.b b() {
        return c().a();
    }

    public final void close() {
        c().close();
    }

    static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final a[] f4564a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f4565b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4566c;

        a(Context context, String str, final a[] aVarArr, final c.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f4541a, new DatabaseErrorHandler() {
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
                    if (r0 != null) goto L_0x0030;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
                    r3 = r0.iterator();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
                    if (r3.hasNext() != false) goto L_0x003a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
                    androidx.sqlite.db.c.a.a((java.lang.String) r3.next().second);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
                    androidx.sqlite.db.c.a.a(r3.f());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
                    throw r1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002a */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
                /* JADX WARNING: Removed duplicated region for block: B:7:0x0028 A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
                  PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0023, B:8:0x002a, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0023] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onCorruption(android.database.sqlite.SQLiteDatabase r3) {
                    /*
                        r2 = this;
                        androidx.sqlite.db.framework.a[] r0 = r9
                        androidx.sqlite.db.framework.a r3 = androidx.sqlite.db.framework.b.a.a(r0, r3)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r1 = "Corruption reported by sqlite on database: "
                        r0.<init>(r1)
                        java.lang.String r1 = r3.f()
                        r0.append(r1)
                        boolean r0 = r3.e()
                        if (r0 != 0) goto L_0x0022
                        java.lang.String r3 = r3.f()
                        androidx.sqlite.db.c.a.a((java.lang.String) r3)
                        return
                    L_0x0022:
                        r0 = 0
                        java.util.List r0 = r3.g()     // Catch:{ SQLiteException -> 0x002a, all -> 0x0028 }
                        goto L_0x002a
                    L_0x0028:
                        r1 = move-exception
                        goto L_0x002e
                    L_0x002a:
                        r3.close()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
                        goto L_0x0051
                    L_0x002e:
                        if (r0 == 0) goto L_0x0048
                        java.util.Iterator r3 = r0.iterator()
                    L_0x0034:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x004f
                        java.lang.Object r0 = r3.next()
                        android.util.Pair r0 = (android.util.Pair) r0
                        java.lang.Object r0 = r0.second
                        java.lang.String r0 = (java.lang.String) r0
                        androidx.sqlite.db.c.a.a((java.lang.String) r0)
                        goto L_0x0034
                    L_0x0048:
                        java.lang.String r3 = r3.f()
                        androidx.sqlite.db.c.a.a((java.lang.String) r3)
                    L_0x004f:
                        throw r1
                    L_0x0050:
                    L_0x0051:
                        if (r0 == 0) goto L_0x006c
                        java.util.Iterator r3 = r0.iterator()
                    L_0x0057:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x006b
                        java.lang.Object r0 = r3.next()
                        android.util.Pair r0 = (android.util.Pair) r0
                        java.lang.Object r0 = r0.second
                        java.lang.String r0 = (java.lang.String) r0
                        androidx.sqlite.db.c.a.a((java.lang.String) r0)
                        goto L_0x0057
                    L_0x006b:
                        return
                    L_0x006c:
                        java.lang.String r3 = r3.f()
                        androidx.sqlite.db.c.a.a((java.lang.String) r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.b.a.AnonymousClass1.onCorruption(android.database.sqlite.SQLiteDatabase):void");
                }
            });
            this.f4565b = aVar;
            this.f4564a = aVarArr;
        }

        /* access modifiers changed from: package-private */
        public final synchronized androidx.sqlite.db.b a() {
            this.f4566c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f4566c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        private a a(SQLiteDatabase sQLiteDatabase) {
            return a(this.f4564a, sQLiteDatabase);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f4565b.a((androidx.sqlite.db.b) a(sQLiteDatabase));
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f4566c = true;
            this.f4565b.a(a(sQLiteDatabase), i2, i3);
        }

        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f4566c = true;
            this.f4565b.b(a(sQLiteDatabase), i2, i3);
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f4566c) {
                this.f4565b.b(a(sQLiteDatabase));
            }
        }

        public final synchronized void close() {
            super.close();
            this.f4564a[0] = null;
        }

        static a a(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new a(sQLiteDatabase);
            }
            return aVarArr[0];
        }
    }
}
