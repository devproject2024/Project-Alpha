package net.one97.paytm.upi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f66666b;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f66667a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteOpenHelper f66668c;

    private a() {
    }

    private a(Context context) {
        this.f66668c = b.a(context, "upi_paytm.db");
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f66666b == null) {
                synchronized (b.class) {
                    if (f66666b == null) {
                        f66666b = new a(context);
                    }
                }
            }
            aVar = f66666b;
        }
        return aVar;
    }

    public final SQLiteDatabase a() {
        this.f66667a = this.f66668c.getWritableDatabase();
        return this.f66667a;
    }

    public final boolean b() {
        SQLiteDatabase sQLiteDatabase = this.f66667a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.isOpen();
        }
        return false;
    }
}
