package net.one97.paytm.wallet.newdesign.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f70457b;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f70458a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteOpenHelper f70459c;

    private a() {
    }

    private a(Context context) {
        this.f70459c = b.a(context, "paytm.db");
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f70457b == null) {
                synchronized (b.class) {
                    if (f70457b == null) {
                        f70457b = new a(context);
                    }
                }
            }
            aVar = f70457b;
        }
        return aVar;
    }

    public final SQLiteDatabase a() {
        this.f70458a = this.f70459c.getWritableDatabase();
        return this.f70458a;
    }

    public final boolean b() {
        SQLiteDatabase sQLiteDatabase = this.f70458a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.isOpen();
        }
        return false;
    }

    public final SQLiteDatabase c() {
        return this.f70458a;
    }

    public final long a(String str, String str2, String str3) {
        try {
            if (!b()) {
                a();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("param_1", str);
            contentValues.put("param_2", str2);
            contentValues.put("type", str3);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            return this.f70458a.insert("event_logs", (String) null, contentValues);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int d() {
        try {
            if (!b()) {
                a();
            }
            return this.f70458a.delete("event_logs", (String) null, (String[]) null);
        } catch (Exception unused) {
            return -1;
        }
    }
}
