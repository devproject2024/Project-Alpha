package net.one97.paytm.wallet.newdesign.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.paytm.utility.q;

public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f70460a;

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 8);
    }

    public static b a(Context context, String str) {
        if (f70460a == null) {
            synchronized (b.class) {
                if (f70460a == null) {
                    f70460a = new b(context, str);
                }
            }
        }
        return f70460a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE event_logs(id INTEGER PRIMARY KEY,param_1 TEXT,param_2 TEXT,time TEXT,type TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE contact_logs(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE contact_logs_temp(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE quick_pay(id TEXT PRIMARY KEY,quick_pay_details TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE recent_qr_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,qr_code_id TEXT,qr_details_json TEXT,qr_timestamp INTEGER)");
        sQLiteDatabase.execSQL("CREATE INDEX timeStampIndex ON recent_qr_table(qr_timestamp)");
        sQLiteDatabase.execSQL("CREATE TABLE cst_reasons(_id TEXT PRIMARY KEY,reason_level TEXT,cst_reasons_detail TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            sQLiteDatabase.execSQL("CREATE TABLE contact_logs(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE contact_logs_temp(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        }
        if (i2 < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_logs");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_logs_temp");
            sQLiteDatabase.execSQL("CREATE TABLE contact_logs(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE contact_logs_temp(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        }
        if (i2 < 5) {
            q.a(" onUpgrade");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLMatchTable");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLTeamTable");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLResultTable");
        }
        if (i2 < 6) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS quick_pay");
            sQLiteDatabase.execSQL("CREATE TABLE quick_pay(id TEXT PRIMARY KEY,quick_pay_details TEXT)");
        }
        if (i2 < 7) {
            sQLiteDatabase.execSQL("CREATE TABLE recent_qr_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,qr_code_id TEXT,qr_details_json TEXT,qr_timestamp INTEGER)");
            sQLiteDatabase.execSQL("CREATE INDEX timeStampIndex ON recent_qr_table(qr_timestamp)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cst_reasons");
            sQLiteDatabase.execSQL("CREATE TABLE cst_reasons(_id TEXT PRIMARY KEY,reason_level TEXT,cst_reasons_detail TEXT)");
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_logs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contact_logs_temp");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS quick_pay");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLMatchTable");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLTeamTable");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IPLResultTable");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_logs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recent_qr_table");
        sQLiteDatabase.execSQL("CREATE TABLE contact_logs(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE contact_logs_temp(id INTEGER PRIMARY KEY,contact_id TEXT,contact_number TEXT UNIQUE,formatted_contact_number TEXT,display_name TEXT,user TEXT,update_time TEXT,contact_version TEXT,is_deleted TEXT,is_paytm_contact TEXT,is_synced_with_server TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE quick_pay(id TEXT PRIMARY KEY,quick_pay_details TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE event_logs(id INTEGER PRIMARY KEY,param_1 TEXT,param_2 TEXT,time TEXT,type TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE recent_qr_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,qr_code_id TEXT,qr_details_json TEXT,qr_timestamp INTEGER)");
        sQLiteDatabase.execSQL("CREATE INDEX timeStampIndex ON recent_qr_table(qr_timestamp)");
    }
}
