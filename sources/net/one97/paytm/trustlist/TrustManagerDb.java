package net.one97.paytm.trustlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TrustManagerDb extends SQLiteOpenHelper {
    public TrustManagerDb(Context context) {
        super(context, "trustmanager.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trustmanagerSmsTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, txnId TEXT , amount TEXT , time TEXT , smsList TEXT  , manualOtp TEXT  , mask_mobile_no TEXT  , retryCount INTEGER DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deductionSmsTable ( _id INTEGER PRIMARY KEY AUTOINCREMENT, time TEXT , smsList TEXT  , sender TEXT  )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'trustmanagerSmsTable'");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'deductionSmsTable'");
        onCreate(sQLiteDatabase);
    }
}
