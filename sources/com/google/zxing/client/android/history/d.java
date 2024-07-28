package com.google.zxing.client.android.history;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.preference.PreferenceManager;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.google.zxing.a;
import com.google.zxing.r;
import com.google.zxing.t;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f40240a = {"id"};

    /* renamed from: d  reason: collision with root package name */
    private static final String f40241d = d.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f40242e = {CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "display", "format", "timestamp", "details"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f40243f = {"COUNT(1)"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f40244g = {"id", "details"};

    /* renamed from: b  reason: collision with root package name */
    public final Activity f40245b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40246c;

    public d(Activity activity) {
        this.f40245b = activity;
        this.f40246c = PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("preferences_history", true);
    }

    public final boolean a() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = new a(this.f40245b).getReadableDatabase();
            try {
                Cursor query = sQLiteDatabase.query("history", f40243f, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                query.moveToFirst();
                boolean z = false;
                if (query.getInt(0) > 0) {
                    z = true;
                }
                a(query, sQLiteDatabase);
                return z;
            } catch (Throwable th) {
                th = th;
                a((Cursor) null, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            a((Cursor) null, sQLiteDatabase);
            throw th;
        }
    }

    public final List<b> b() {
        SQLiteDatabase sQLiteDatabase;
        a aVar = new a(this.f40245b);
        ArrayList arrayList = new ArrayList();
        try {
            sQLiteDatabase = aVar.getReadableDatabase();
            try {
                Cursor query = sQLiteDatabase.query("history", f40242e, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    String string3 = query.getString(2);
                    arrayList.add(new b(new r(string, (byte[]) null, (t[]) null, a.valueOf(string3), query.getLong(3)), string2, query.getString(4)));
                }
                a(query, sQLiteDatabase);
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a((Cursor) null, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            a((Cursor) null, sQLiteDatabase);
            throw th;
        }
    }

    public final b a(int i2) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = new a(this.f40245b).getReadableDatabase();
            try {
                cursor = sQLiteDatabase.query("history", f40242e, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
                cursor.move(i2 + 1);
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                String string3 = cursor.getString(2);
                b bVar = new b(new r(string, (byte[]) null, (t[]) null, a.valueOf(string3), cursor.getLong(3)), string2, cursor.getString(4));
                a(cursor, sQLiteDatabase);
                return bVar;
            } catch (Throwable th) {
                th = th;
                a(cursor, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            a(cursor, sQLiteDatabase);
            throw th;
        }
    }

    public final void c() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = new a(this.f40245b).getWritableDatabase();
            try {
                cursor = sQLiteDatabase.query("history", f40240a, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            } catch (SQLiteException unused) {
                a(cursor2, sQLiteDatabase);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                cursor = null;
                th = th3;
                a(cursor, sQLiteDatabase);
                throw th;
            }
            try {
                cursor.move(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
                while (cursor.moveToNext()) {
                    sQLiteDatabase.delete("history", "id=".concat(String.valueOf(cursor.getString(0))), (String[]) null);
                }
                a(cursor, sQLiteDatabase);
            } catch (SQLiteException unused2) {
                cursor2 = cursor;
                a(cursor2, sQLiteDatabase);
            } catch (Throwable th4) {
                th = th4;
                a(cursor, sQLiteDatabase);
                throw th;
            }
        } catch (SQLiteException unused3) {
            sQLiteDatabase = null;
            a(cursor2, sQLiteDatabase);
        } catch (Throwable th5) {
            cursor = null;
            th = th5;
            sQLiteDatabase = null;
            a(cursor, sQLiteDatabase);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence d() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = new a(this.f40245b).getWritableDatabase();
            try {
                Cursor query = sQLiteDatabase.query("history", f40242e, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
                DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
                StringBuilder sb = new StringBuilder(1000);
                while (query.moveToNext()) {
                    sb.append('\"');
                    sb.append(b(query.getString(0)));
                    sb.append("\",");
                    sb.append('\"');
                    sb.append(b(query.getString(1)));
                    sb.append("\",");
                    sb.append('\"');
                    sb.append(b(query.getString(2)));
                    sb.append("\",");
                    sb.append('\"');
                    sb.append(b(query.getString(3)));
                    sb.append("\",");
                    long j = query.getLong(3);
                    sb.append('\"');
                    sb.append(b(dateTimeInstance.format(new Date(j))));
                    sb.append("\",");
                    sb.append('\"');
                    sb.append(b(query.getString(4)));
                    sb.append("\"\r\n");
                }
                a(query, sQLiteDatabase);
                return sb;
            } catch (Throwable th) {
                th = th;
                a((Cursor) null, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            a((Cursor) null, sQLiteDatabase);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e A[SYNTHETIC, Splitter:B:23:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095 A[SYNTHETIC, Splitter:B:29:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.net.Uri a(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = "BarcodeScanner"
            r0.<init>(r1, r2)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "History"
            r1.<init>(r0, r2)
            boolean r0 = r1.exists()
            r2 = 0
            if (r0 != 0) goto L_0x002a
            boolean r0 = r1.mkdirs()
            if (r0 != 0) goto L_0x002a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Couldn't make dir "
            r6.<init>(r0)
            r6.append(r1)
            return r2
        L_0x002a:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "history-"
            r3.<init>(r4)
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r4 = ".csv"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.<init>(r1, r3)
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            r1.<init>(r3, r4)     // Catch:{ IOException -> 0x0078, all -> 0x0075 }
            r1.write(r6)     // Catch:{ IOException -> 0x0073 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0073 }
            java.lang.String r3 = "file://"
            r6.<init>(r3)     // Catch:{ IOException -> 0x0073 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x0073 }
            r6.append(r3)     // Catch:{ IOException -> 0x0073 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0073 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ IOException -> 0x0073 }
            r1.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0072:
            return r6
        L_0x0073:
            r6 = move-exception
            goto L_0x007a
        L_0x0075:
            r6 = move-exception
            r1 = r2
            goto L_0x0093
        L_0x0078:
            r6 = move-exception
            r1 = r2
        L_0x007a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = "Couldn't access file "
            r3.<init>(r4)     // Catch:{ all -> 0x0092 }
            r3.append(r0)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = " due to "
            r3.append(r0)     // Catch:{ all -> 0x0092 }
            r3.append(r6)     // Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            return r2
        L_0x0092:
            r6 = move-exception
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ IOException -> 0x0098 }
        L_0x0098:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.history.d.a(java.lang.String):android.net.Uri");
    }

    private static String b(String str) {
        return str == null ? "" : str.replace("\"", "\"\"");
    }

    public static void a(Cursor cursor, SQLiteDatabase sQLiteDatabase) {
        if (cursor != null) {
            cursor.close();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
