package net.one97.paytm.wallet.newdesign.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.wallet.communicator.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f70461a;

    /* renamed from: b  reason: collision with root package name */
    private final int f70462b = 50;

    public c(Context context) {
        k.c(context, "context");
    }

    private long a(Context context) {
        k.c(context, "context");
        SQLiteDatabase sQLiteDatabase = this.f70461a;
        if (sQLiteDatabase == null) {
            k.a("mDatabase");
        }
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "recent_qr_table");
    }

    public final Long a(Context context, String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        String str3 = str;
        String str4 = str2;
        k.c(context, "context");
        k.c(str3, "qrJson");
        k.c(str4, "qrCodeId");
        net.one97.paytm.wallet.communicator.c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        a a3 = a.a(a2.getContext());
        k.a((Object) a3, "instance");
        if (a3.b()) {
            sQLiteDatabase = a3.c();
            k.a((Object) sQLiteDatabase, "instance.database");
        } else {
            sQLiteDatabase = a3.a();
            k.a((Object) sQLiteDatabase, "instance.open()");
        }
        this.f70461a = sQLiteDatabase;
        long a4 = a(context);
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str4);
        contentValues.put("qr_details_json", str3);
        contentValues.put("qr_timestamp", Long.valueOf(currentTimeMillis));
        if (a4 < ((long) this.f70462b)) {
            SQLiteDatabase sQLiteDatabase2 = this.f70461a;
            if (sQLiteDatabase2 == null) {
                k.a("mDatabase");
            }
            if (sQLiteDatabase2 != null) {
                return Long.valueOf(sQLiteDatabase2.insert("recent_qr_table", (String) null, contentValues));
            }
            return null;
        }
        SQLiteDatabase sQLiteDatabase3 = this.f70461a;
        if (sQLiteDatabase3 == null) {
            k.a("mDatabase");
        }
        Cursor query = sQLiteDatabase3 != null ? sQLiteDatabase3.query("recent_qr_table", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "qr_timestamp") : null;
        int i2 = -1;
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex(CJRQRScanResultModel.KEY_QR_CODE_ID));
            k.a((Object) string, "cursor.getString(cursor.…TableColumns.QR_CODE_ID))");
            SQLiteDatabase sQLiteDatabase4 = this.f70461a;
            if (sQLiteDatabase4 == null) {
                k.a("mDatabase");
            }
            i2 = (sQLiteDatabase4 != null ? Integer.valueOf(sQLiteDatabase4.delete("recent_qr_table", "qr_code_id=?", new String[]{string})) : null).intValue();
        }
        if (i2 <= 0) {
            return -1L;
        }
        SQLiteDatabase sQLiteDatabase5 = this.f70461a;
        if (sQLiteDatabase5 == null) {
            k.a("mDatabase");
        }
        if (sQLiteDatabase5 != null) {
            return Long.valueOf(sQLiteDatabase5.insert("recent_qr_table", (String) null, contentValues));
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r4 = "qrCodeId"
            kotlin.g.b.k.c(r5, r4)
            net.one97.paytm.wallet.communicator.c r4 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r0 = "WalletCommManager.getWalletCommunicator()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            android.content.Context r4 = r4.getContext()
            net.one97.paytm.wallet.newdesign.a.a r4 = net.one97.paytm.wallet.newdesign.a.a.a(r4)
            java.lang.String r0 = "instance"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            boolean r0 = r4.b()
            if (r0 == 0) goto L_0x0030
            android.database.sqlite.SQLiteDatabase r4 = r4.c()
            java.lang.String r0 = "instance.database"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            goto L_0x0039
        L_0x0030:
            android.database.sqlite.SQLiteDatabase r4 = r4.a()
            java.lang.String r0 = "instance.open()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
        L_0x0039:
            r3.f70461a = r4
            r4 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r1 = "SELECT qr_details_json FROM recent_qr_table WHERE qr_code_id = '"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            r0.append(r5)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = "'"
            r0.append(r5)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            android.database.sqlite.SQLiteDatabase r0 = r3.f70461a     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            if (r0 != 0) goto L_0x0058
            java.lang.String r1 = "mDatabase"
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
        L_0x0058:
            android.database.Cursor r5 = r0.rawQuery(r5, r4)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            if (r5 == 0) goto L_0x007c
            int r0 = r5.getCount()     // Catch:{ Exception -> 0x0077, all -> 0x0072 }
            if (r0 <= 0) goto L_0x007c
            r5.moveToNext()     // Catch:{ Exception -> 0x0077, all -> 0x0072 }
            java.lang.String r0 = "qr_details_json"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ Exception -> 0x0077, all -> 0x0072 }
            java.lang.String r4 = r5.getString(r0)     // Catch:{ Exception -> 0x0077, all -> 0x0072 }
            goto L_0x007c
        L_0x0072:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L_0x0091
        L_0x0077:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
            goto L_0x0084
        L_0x007c:
            a((android.database.Cursor) r5)
            goto L_0x008e
        L_0x0080:
            r5 = move-exception
            goto L_0x0091
        L_0x0082:
            r5 = move-exception
            r0 = r4
        L_0x0084:
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x008f }
            com.paytm.utility.q.b(r5)     // Catch:{ all -> 0x008f }
            a((android.database.Cursor) r0)
        L_0x008e:
            return r4
        L_0x008f:
            r5 = move-exception
            r4 = r0
        L_0x0091:
            a((android.database.Cursor) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.a.c.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public final int b(Context context, String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        k.c(context, "context");
        k.c(str, "qrJson");
        k.c(str2, "qrCodeId");
        net.one97.paytm.wallet.communicator.c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        a a3 = a.a(a2.getContext());
        k.a((Object) a3, "instance");
        if (a3.b()) {
            sQLiteDatabase = a3.c();
            k.a((Object) sQLiteDatabase, "instance.database");
        } else {
            sQLiteDatabase = a3.a();
            k.a((Object) sQLiteDatabase, "instance.open()");
        }
        this.f70461a = sQLiteDatabase;
        ContentValues contentValues = new ContentValues();
        contentValues.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str2);
        contentValues.put("qr_details_json", str);
        contentValues.put("qr_timestamp", Long.valueOf(System.currentTimeMillis()));
        SQLiteDatabase sQLiteDatabase2 = this.f70461a;
        if (sQLiteDatabase2 == null) {
            k.a("mDatabase");
        }
        return sQLiteDatabase2.update("recent_qr_table", contentValues, "qr_code_id=?", new String[]{str2});
    }

    public final void a(Context context, long j) {
        SQLiteDatabase sQLiteDatabase;
        k.c(context, "context");
        net.one97.paytm.wallet.communicator.c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        a a3 = a.a(a2.getContext());
        k.a((Object) a3, "instance");
        if (a3.b()) {
            sQLiteDatabase = a3.c();
            k.a((Object) sQLiteDatabase, "instance.database");
        } else {
            sQLiteDatabase = a3.a();
            k.a((Object) sQLiteDatabase, "instance.open()");
        }
        this.f70461a = sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.f70461a;
        if (sQLiteDatabase2 == null) {
            k.a("mDatabase");
        }
        Cursor query = sQLiteDatabase2 != null ? sQLiteDatabase2.query("recent_qr_table", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null) : null;
        k.a((Object) query, "cursor");
        query.moveToPosition(query.getCount());
        while (query.moveToPrevious() && query.getLong(query.getColumnIndex("qr_timestamp")) + j >= System.currentTimeMillis()) {
            SQLiteDatabase sQLiteDatabase3 = this.f70461a;
            if (sQLiteDatabase3 == null) {
                k.a("mDatabase");
            }
            sQLiteDatabase3.delete("recent_qr_table", "qr_code_id=?", new String[]{query.getString(query.getColumnIndex(CJRQRScanResultModel.KEY_QR_CODE_ID))});
        }
        a(query);
    }

    private static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }
}
