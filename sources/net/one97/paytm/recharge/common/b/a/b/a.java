package net.one97.paytm.recharge.common.b.a.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.g.b.k;

public final class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final C1173a f60879a = new C1173a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f60880b = f60880b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        k.c(context, "context");
        k.c(str, "dbName");
    }

    /* renamed from: net.one97.paytm.recharge.common.b.a.b.a$a  reason: collision with other inner class name */
    public static final class C1173a {
        private C1173a() {
        }

        public /* synthetic */ C1173a(byte b2) {
            this();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + f60880b + "( categoryid TEXT, response TEXT )");
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + f60880b);
        }
        onCreate(sQLiteDatabase);
    }
}
