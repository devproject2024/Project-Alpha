package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.util.e;
import com.sendbird.android.constant.StringSet;

public final class du extends dc {

    /* renamed from: a  reason: collision with root package name */
    private final dt f11815a = new dt(this, k(), "google_app_measurement_local.db");

    /* renamed from: b  reason: collision with root package name */
    private boolean f11816b;

    du(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final void z() {
        h();
        try {
            int delete = C().delete(StringSet.messages, (String) null, (String[]) null) + 0;
            if (delete > 0) {
                J_().k.a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error resetting local analytics data. error", e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0124 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0124 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d5 A[SYNTHETIC, Splitter:B:55:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0124 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "Error writing entry to local database"
            r17.h()
            boolean r0 = r1.f11816b
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.String r5 = "type"
            r4.put(r5, r0)
            java.lang.String r0 = "entry"
            r5 = r19
            r4.put(r0, r5)
            r5 = 5
            r6 = 0
            r7 = 5
        L_0x0026:
            if (r6 >= r5) goto L_0x0137
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r17.C()     // Catch:{ SQLiteFullException -> 0x010b, SQLiteDatabaseLockedException -> 0x00f8, SQLiteException -> 0x00d0, all -> 0x00cb }
            if (r10 != 0) goto L_0x003f
            r1.f11816b = r9     // Catch:{ SQLiteFullException -> 0x003c, SQLiteDatabaseLockedException -> 0x00c5, SQLiteException -> 0x0038 }
            if (r10 == 0) goto L_0x0037
            r10.close()
        L_0x0037:
            return r3
        L_0x0038:
            r0 = move-exception
            r13 = r8
            goto L_0x00c3
        L_0x003c:
            r0 = move-exception
            goto L_0x010e
        L_0x003f:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00c8, SQLiteDatabaseLockedException -> 0x00c5, SQLiteException -> 0x00c0, all -> 0x00bb }
            r11 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r13 = r10.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00c8, SQLiteDatabaseLockedException -> 0x00c5, SQLiteException -> 0x00c0, all -> 0x00bb }
            if (r13 == 0) goto L_0x0060
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            if (r0 == 0) goto L_0x0060
            long r11 = r13.getLong(r3)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r0 = move-exception
            goto L_0x012c
        L_0x005a:
            r0 = move-exception
            goto L_0x00c3
        L_0x005c:
            r0 = move-exception
            r8 = r13
            goto L_0x010e
        L_0x0060:
            java.lang.String r0 = "messages"
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r16 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00a3
            com.google.android.gms.measurement.internal.dy r5 = r17.J_()     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            java.lang.String r8 = "Data loss, local db full"
            r5.a(r8)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            long r14 = r14 - r11
            r11 = 1
            long r14 = r14 + r11
            java.lang.String r5 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r8 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            r8[r3] = r11     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            int r5 = r10.delete(r0, r5, r8)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            long r11 = (long) r5     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00a3
            com.google.android.gms.measurement.internal.dy r5 = r17.J_()     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            java.lang.String r8 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            r5.a(r8, r3, r9, r11)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
        L_0x00a3:
            r3 = 0
            r10.insertOrThrow(r0, r3, r4)     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x005c, SQLiteDatabaseLockedException -> 0x00b9, SQLiteException -> 0x005a, all -> 0x0057 }
            if (r13 == 0) goto L_0x00b2
            r13.close()
        L_0x00b2:
            if (r10 == 0) goto L_0x00b7
            r10.close()
        L_0x00b7:
            r2 = 1
            return r2
        L_0x00b9:
            r8 = r13
            goto L_0x00fa
        L_0x00bb:
            r0 = move-exception
            r3 = r8
            r13 = r3
            goto L_0x012c
        L_0x00c0:
            r0 = move-exception
            r3 = r8
            r13 = r3
        L_0x00c3:
            r8 = r10
            goto L_0x00d3
        L_0x00c5:
            r3 = r8
            r8 = r3
            goto L_0x00fa
        L_0x00c8:
            r0 = move-exception
            r3 = r8
            goto L_0x010e
        L_0x00cb:
            r0 = move-exception
            r3 = r8
            r10 = r3
            r13 = r10
            goto L_0x012c
        L_0x00d0:
            r0 = move-exception
            r3 = r8
            r13 = r8
        L_0x00d3:
            if (r8 == 0) goto L_0x00de
            boolean r3 = r8.inTransaction()     // Catch:{ all -> 0x00f5 }
            if (r3 == 0) goto L_0x00de
            r8.endTransaction()     // Catch:{ all -> 0x00f5 }
        L_0x00de:
            com.google.android.gms.measurement.internal.dy r3 = r17.J_()     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x00f5 }
            r3.a(r2, r0)     // Catch:{ all -> 0x00f5 }
            r3 = 1
            r1.f11816b = r3     // Catch:{ all -> 0x00f5 }
            if (r13 == 0) goto L_0x00ef
            r13.close()
        L_0x00ef:
            if (r8 == 0) goto L_0x0124
            r8.close()
            goto L_0x0124
        L_0x00f5:
            r0 = move-exception
            r10 = r8
            goto L_0x012c
        L_0x00f8:
            r3 = r8
            r10 = r8
        L_0x00fa:
            long r11 = (long) r7
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x012a }
            int r7 = r7 + 20
            if (r8 == 0) goto L_0x0105
            r8.close()
        L_0x0105:
            if (r10 == 0) goto L_0x0124
            r10.close()
            goto L_0x0124
        L_0x010b:
            r0 = move-exception
            r3 = r8
            r10 = r8
        L_0x010e:
            com.google.android.gms.measurement.internal.dy r3 = r17.J_()     // Catch:{ all -> 0x012a }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x012a }
            r3.a(r2, r0)     // Catch:{ all -> 0x012a }
            r3 = 1
            r1.f11816b = r3     // Catch:{ all -> 0x012a }
            if (r8 == 0) goto L_0x011f
            r8.close()
        L_0x011f:
            if (r10 == 0) goto L_0x0124
            r10.close()
        L_0x0124:
            int r6 = r6 + 1
            r3 = 0
            r5 = 5
            goto L_0x0026
        L_0x012a:
            r0 = move-exception
            r13 = r8
        L_0x012c:
            if (r13 == 0) goto L_0x0131
            r13.close()
        L_0x0131:
            if (r10 == 0) goto L_0x0136
            r10.close()
        L_0x0136:
            throw r0
        L_0x0137:
            com.google.android.gms.measurement.internal.dy r0 = r17.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r2 = "Failed to write entry to local database"
            r0.a(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.du.a(int, byte[]):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:83|84|85|86) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:98|99|100|101) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:68|69|70|71|214) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x016e, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0171, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x018f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0192, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01d6, code lost:
        r13 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01ea, code lost:
        r13 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x01fd, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01fe, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0215, code lost:
        if (r23.inTransaction() != false) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0217, code lost:
        r23.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0227, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x022c, code lost:
        r23.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x023a, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x023f, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r10 = null;
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0258, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x025d, code lost:
        r23.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0264, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0267, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x026c, code lost:
        r23.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        r10 = null;
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r10 = null;
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0095, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a6, code lost:
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        J_().f11828c.a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0107, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x010a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0126, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        J_().f11828c.a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x013b, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0158, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        J_().f11828c.a("Failed to load user property from local database");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00f8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0128 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x015a */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:54:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), PHI: r23 
      PHI: (r23v11 android.database.sqlite.SQLiteDatabase) = (r23v15 android.database.sqlite.SQLiteDatabase), (r23v19 android.database.sqlite.SQLiteDatabase) binds: [B:51:0x00ae, B:39:0x008d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:39:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0211 A[SYNTHETIC, Splitter:B:163:0x0211] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0260 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> A() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "Error reading entries from local database"
            r24.h()
            boolean r0 = r1.f11816b
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r24.D()
            if (r0 != 0) goto L_0x0019
            return r4
        L_0x0019:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x001d:
            if (r7 >= r5) goto L_0x0270
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r24.C()     // Catch:{ SQLiteFullException -> 0x0247, SQLiteDatabaseLockedException -> 0x0230, SQLiteException -> 0x020b, all -> 0x0206 }
            if (r15 != 0) goto L_0x0040
            r1.f11816b = r9     // Catch:{ SQLiteFullException -> 0x003a, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x0034, all -> 0x002e }
            if (r15 == 0) goto L_0x002d
            r15.close()
        L_0x002d:
            return r3
        L_0x002e:
            r0 = move-exception
            r10 = r3
            r23 = r15
            goto L_0x0265
        L_0x0034:
            r0 = move-exception
            r10 = r3
            r23 = r15
            goto L_0x020f
        L_0x003a:
            r0 = move-exception
            r10 = r3
            r23 = r15
            goto L_0x024b
        L_0x0040:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x01f7, all -> 0x01f3 }
            com.google.android.gms.measurement.internal.ke r0 = r24.H_()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x01f7, all -> 0x01f3 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.o.av     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x01f7, all -> 0x01f3 }
            boolean r0 = r0.d(r3, r10)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x01f7, all -> 0x01f3 }
            r10 = 100
            java.lang.String r11 = "entry"
            java.lang.String r12 = "type"
            java.lang.String r13 = "rowid"
            r19 = -1
            if (r0 == 0) goto L_0x00aa
            long r16 = a(r15)     // Catch:{ SQLiteFullException -> 0x00a5, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x00a0, all -> 0x009b }
            int r0 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x003a, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x0034, all -> 0x002e }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x003a, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x0034, all -> 0x002e }
            r14[r6] = r16     // Catch:{ SQLiteFullException -> 0x003a, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x0034, all -> 0x002e }
            goto L_0x006f
        L_0x006d:
            r0 = r3
            r14 = r0
        L_0x006f:
            java.lang.String r16 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x00a5, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x00a0, all -> 0x009b }
            r17 = 0
            r18 = 0
            java.lang.String r21 = "rowid asc"
            java.lang.String r22 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x00a5, SQLiteDatabaseLockedException -> 0x01fd, SQLiteException -> 0x00a0, all -> 0x009b }
            r10 = r15
            r11 = r16
            r13 = r0
            r23 = r15
            r15 = r17
            r16 = r18
            r17 = r21
            r18 = r22
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x0098, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x0095, all -> 0x0092 }
            goto L_0x00c4
        L_0x0092:
            r0 = move-exception
            goto L_0x01e2
        L_0x0095:
            r0 = move-exception
            goto L_0x01e8
        L_0x0098:
            r0 = move-exception
            goto L_0x01f0
        L_0x009b:
            r0 = move-exception
            r23 = r15
            goto L_0x01e2
        L_0x00a0:
            r0 = move-exception
            r23 = r15
            goto L_0x01e8
        L_0x00a5:
            r0 = move-exception
            r23 = r15
            goto L_0x01f0
        L_0x00aa:
            r23 = r15
            java.lang.String r0 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01df }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01df }
            r10 = r23
            r11 = r0
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01df }
        L_0x00c4:
            r10 = r0
        L_0x00c5:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x01da, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x01d2, all -> 0x01cd }
            if (r0 == 0) goto L_0x0195
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            if (r0 != 0) goto L_0x010b
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            int r0 = r12.length     // Catch:{ a -> 0x00f8 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ a -> 0x00f8 }
            r11.setDataPosition(r6)     // Catch:{ a -> 0x00f8 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r0 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ a -> 0x00f8 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ a -> 0x00f8 }
            com.google.android.gms.measurement.internal.zzan r0 = (com.google.android.gms.measurement.internal.zzan) r0     // Catch:{ a -> 0x00f8 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            if (r0 == 0) goto L_0x00c5
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x00f6:
            r0 = move-exception
            goto L_0x0107
        L_0x00f8:
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = "Failed to load event from local database"
            r0.a(r12)     // Catch:{ all -> 0x00f6 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x0107:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
        L_0x010b:
            java.lang.String r13 = "Failed to load user property from local database"
            if (r0 != r9) goto L_0x013f
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            int r0 = r12.length     // Catch:{ a -> 0x0128 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ a -> 0x0128 }
            r11.setDataPosition(r6)     // Catch:{ a -> 0x0128 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkl> r0 = com.google.android.gms.measurement.internal.zzkl.CREATOR     // Catch:{ a -> 0x0128 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ a -> 0x0128 }
            com.google.android.gms.measurement.internal.zzkl r0 = (com.google.android.gms.measurement.internal.zzkl) r0     // Catch:{ a -> 0x0128 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x0135
        L_0x0126:
            r0 = move-exception
            goto L_0x013b
        L_0x0128:
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ all -> 0x0126 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x0126 }
            r0.a(r13)     // Catch:{ all -> 0x0126 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            r0 = r3
        L_0x0135:
            if (r0 == 0) goto L_0x00c5
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x013b:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
        L_0x013f:
            if (r0 != r11) goto L_0x0172
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            int r0 = r12.length     // Catch:{ a -> 0x015a }
            r11.unmarshall(r12, r6, r0)     // Catch:{ a -> 0x015a }
            r11.setDataPosition(r6)     // Catch:{ a -> 0x015a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzv> r0 = com.google.android.gms.measurement.internal.zzv.CREATOR     // Catch:{ a -> 0x015a }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ a -> 0x015a }
            com.google.android.gms.measurement.internal.zzv r0 = (com.google.android.gms.measurement.internal.zzv) r0     // Catch:{ a -> 0x015a }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x0167
        L_0x0158:
            r0 = move-exception
            goto L_0x016e
        L_0x015a:
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ all -> 0x0158 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x0158 }
            r0.a(r13)     // Catch:{ all -> 0x0158 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            r0 = r3
        L_0x0167:
            if (r0 == 0) goto L_0x00c5
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x016e:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            throw r0     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
        L_0x0172:
            r11 = 3
            if (r0 != r11) goto L_0x0182
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            java.lang.String r11 = "Skipping app launch break"
            r0.a(r11)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x0182:
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            java.lang.String r11 = "Unknown record type in local database"
            r0.a(r11)     // Catch:{ SQLiteFullException -> 0x0192, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x018f }
            goto L_0x00c5
        L_0x018f:
            r0 = move-exception
            goto L_0x020f
        L_0x0192:
            r0 = move-exception
            goto L_0x024b
        L_0x0195:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x01da, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x01d2, all -> 0x01cd }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x01da, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x01d2, all -> 0x01cd }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x01da, SQLiteDatabaseLockedException -> 0x01d6, SQLiteException -> 0x01d2, all -> 0x01cd }
            r13 = r23
            int r0 = r13.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            if (r0 >= r11) goto L_0x01b8
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.a(r11)     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
        L_0x01b8:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01cb, SQLiteDatabaseLockedException -> 0x0232, SQLiteException -> 0x01c9 }
            if (r10 == 0) goto L_0x01c3
            r10.close()
        L_0x01c3:
            if (r13 == 0) goto L_0x01c8
            r13.close()
        L_0x01c8:
            return r4
        L_0x01c9:
            r0 = move-exception
            goto L_0x01fa
        L_0x01cb:
            r0 = move-exception
            goto L_0x0203
        L_0x01cd:
            r0 = move-exception
            r13 = r23
            goto L_0x0265
        L_0x01d2:
            r0 = move-exception
            r13 = r23
            goto L_0x020f
        L_0x01d6:
            r13 = r23
            goto L_0x0232
        L_0x01da:
            r0 = move-exception
            r13 = r23
            goto L_0x024b
        L_0x01df:
            r0 = move-exception
            r13 = r23
        L_0x01e2:
            r10 = r3
            goto L_0x0265
        L_0x01e5:
            r0 = move-exception
            r13 = r23
        L_0x01e8:
            r10 = r3
            goto L_0x020f
        L_0x01ea:
            r13 = r23
            goto L_0x01fe
        L_0x01ed:
            r0 = move-exception
            r13 = r23
        L_0x01f0:
            r10 = r3
            goto L_0x024b
        L_0x01f3:
            r0 = move-exception
            r13 = r15
            r10 = r3
            goto L_0x0244
        L_0x01f7:
            r0 = move-exception
            r13 = r15
            r10 = r3
        L_0x01fa:
            r23 = r13
            goto L_0x020f
        L_0x01fd:
            r13 = r15
        L_0x01fe:
            r10 = r3
            goto L_0x0232
        L_0x0200:
            r0 = move-exception
            r13 = r15
            r10 = r3
        L_0x0203:
            r23 = r13
            goto L_0x024b
        L_0x0206:
            r0 = move-exception
            r10 = r3
            r23 = r10
            goto L_0x0265
        L_0x020b:
            r0 = move-exception
            r10 = r3
            r23 = r10
        L_0x020f:
            if (r23 == 0) goto L_0x021a
            boolean r11 = r23.inTransaction()     // Catch:{ all -> 0x0264 }
            if (r11 == 0) goto L_0x021a
            r23.endTransaction()     // Catch:{ all -> 0x0264 }
        L_0x021a:
            com.google.android.gms.measurement.internal.dy r11 = r24.J_()     // Catch:{ all -> 0x0264 }
            com.google.android.gms.measurement.internal.ea r11 = r11.f11828c     // Catch:{ all -> 0x0264 }
            r11.a(r2, r0)     // Catch:{ all -> 0x0264 }
            r1.f11816b = r9     // Catch:{ all -> 0x0264 }
            if (r10 == 0) goto L_0x022a
            r10.close()
        L_0x022a:
            if (r23 == 0) goto L_0x0260
            r23.close()
            goto L_0x0260
        L_0x0230:
            r10 = r3
            r13 = r10
        L_0x0232:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0243 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x023d
            r10.close()
        L_0x023d:
            if (r13 == 0) goto L_0x0260
            r13.close()
            goto L_0x0260
        L_0x0243:
            r0 = move-exception
        L_0x0244:
            r23 = r13
            goto L_0x0265
        L_0x0247:
            r0 = move-exception
            r10 = r3
            r23 = r10
        L_0x024b:
            com.google.android.gms.measurement.internal.dy r11 = r24.J_()     // Catch:{ all -> 0x0264 }
            com.google.android.gms.measurement.internal.ea r11 = r11.f11828c     // Catch:{ all -> 0x0264 }
            r11.a(r2, r0)     // Catch:{ all -> 0x0264 }
            r1.f11816b = r9     // Catch:{ all -> 0x0264 }
            if (r10 == 0) goto L_0x025b
            r10.close()
        L_0x025b:
            if (r23 == 0) goto L_0x0260
            r23.close()
        L_0x0260:
            int r7 = r7 + 1
            goto L_0x001d
        L_0x0264:
            r0 = move-exception
        L_0x0265:
            if (r10 == 0) goto L_0x026a
            r10.close()
        L_0x026a:
            if (r23 == 0) goto L_0x026f
            r23.close()
        L_0x026f:
            throw r0
        L_0x0270:
            com.google.android.gms.measurement.internal.dy r0 = r24.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.a(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.du.A():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0083, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean B() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.h()
            boolean r1 = r11.f11816b
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = r11.D()
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0015:
            if (r3 >= r1) goto L_0x008c
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.C()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            if (r5 != 0) goto L_0x0027
            r11.f11816b = r6     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            if (r5 == 0) goto L_0x0026
            r5.close()
        L_0x0026:
            return r2
        L_0x0027:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0072, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0049 }
            if (r5 == 0) goto L_0x0046
            r5.close()
        L_0x0046:
            return r6
        L_0x0047:
            r0 = move-exception
            goto L_0x0086
        L_0x0049:
            r7 = move-exception
            if (r5 == 0) goto L_0x0055
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0047 }
            if (r8 == 0) goto L_0x0055
            r5.endTransaction()     // Catch:{ all -> 0x0047 }
        L_0x0055:
            com.google.android.gms.measurement.internal.dy r8 = r11.J_()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.measurement.internal.ea r8 = r8.f11828c     // Catch:{ all -> 0x0047 }
            r8.a(r0, r7)     // Catch:{ all -> 0x0047 }
            r11.f11816b = r6     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0083
            r5.close()
            goto L_0x0083
        L_0x0066:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0047 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0083
            r5.close()
            goto L_0x0083
        L_0x0072:
            r7 = move-exception
            com.google.android.gms.measurement.internal.dy r8 = r11.J_()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.measurement.internal.ea r8 = r8.f11828c     // Catch:{ all -> 0x0047 }
            r8.a(r0, r7)     // Catch:{ all -> 0x0047 }
            r11.f11816b = r6     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0083
            r5.close()
        L_0x0083:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0086:
            if (r5 == 0) goto L_0x008b
            r5.close()
        L_0x008b:
            throw r0
        L_0x008c:
            com.google.android.gms.measurement.internal.dy r0 = r11.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.du.B():boolean");
    }

    private static long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(StringSet.messages, new String[]{"rowid"}, "type=?", new String[]{"3"}, (String) null, (String) null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase C() throws SQLiteException {
        if (this.f11816b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f11815a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f11816b = true;
        return null;
    }

    private final boolean D() {
        return k().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ z a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ ge b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ dr c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ hm d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ hl e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ du r() {
        return super.r();
    }

    public final /* bridge */ /* synthetic */ is s() {
        return super.s();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
