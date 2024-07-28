package com.paytm.android.chat.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.greendao.gen.DaoMaster;
import com.greendao.gen.DaoSession;
import com.paytm.android.chat.c;
import com.paytm.utility.q;
import org.greenrobot.greendao.database.Database;

public class DatabaseManager {
    private static final String NAME = "payTM_chat.db";
    private static DevOpenHelper helper = null;
    private static DaoSession mDaoSession = null;
    private static final String password = "paytm_first_chat";

    public static synchronized void init(Context context) {
        synchronized (DatabaseManager.class) {
            helper = new DevOpenHelper(context, NAME, (SQLiteDatabase.CursorFactory) null);
            mDaoSession = new DaoMaster(helper.getWritableDb()).newSession();
        }
    }

    public static synchronized DaoSession getDaoSession() {
        DaoSession daoSession;
        synchronized (DatabaseManager.class) {
            if (mDaoSession == null) {
                init(c.a());
            }
            daoSession = mDaoSession;
        }
        return daoSession;
    }

    public static synchronized void closeDB() {
        synchronized (DatabaseManager.class) {
            if (helper != null) {
                helper.close();
            }
        }
    }

    public static synchronized void openDB() {
        synchronized (DatabaseManager.class) {
            if (helper != null) {
                mDaoSession = new DaoMaster(helper.getWritableDb()).newSession();
            }
        }
    }

    public static synchronized void clearDB() {
        synchronized (DatabaseManager.class) {
            if (helper != null) {
                DaoMaster.dropAllTables(helper.getWritableDb(), true);
                DaoMaster.createAllTables(helper.getWritableDb(), true);
            }
        }
    }

    public static class DevOpenHelper extends DaoMaster.OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onUpgrade(Database database, int i2, int i3) {
            q.a("Upgrading schema from version " + i2 + " to " + i3 + " by dropping all tables");
            DaoMaster.dropAllTables(database, true);
            onCreate(database);
            SharedPreferencesUtil.clear();
        }
    }
}
