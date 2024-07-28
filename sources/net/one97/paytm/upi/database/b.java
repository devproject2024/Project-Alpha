package net.one97.paytm.upi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.one97.paytm.upi.common.PaytmLogs;

public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f66669a;

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static b a(Context context, String str) {
        if (f66669a == null) {
            synchronized (b.class) {
                if (f66669a == null) {
                    f66669a = new b(context, str);
                }
            }
        }
        return f66669a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE upi_recent_txns(id INTEGER PRIMARY KEY AUTOINCREMENT,txn_type TEXT,txn_mode TEXT,beneficiary_name TEXT,bank_name TEXT,ifsc TEXT,txn_amount TEXT,timestamp TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE mt_saved_beneficiaries(id INTEGER PRIMARY KEY AUTOINCREMENT,beneficiary_type TEXT,beneficiary_id TEXT,beneficiary_uuid TEXT,beneficiary_value TEXT,beneficiary_name TEXT,bank_name TEXT,ifsc TEXT,timestamp TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        PaytmLogs.d("upi sdk --", "onUpgrade of db called");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        PaytmLogs.d("upi sdk --", "onDowngrade of db called");
    }
}
