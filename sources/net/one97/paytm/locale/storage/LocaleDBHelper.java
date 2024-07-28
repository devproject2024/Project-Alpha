package net.one97.paytm.locale.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class LocaleDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AppLocale.db";
    public static final int DATABASE_VERSION = 2;

    public LocaleDBHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createTablesAndIndex(0, sQLiteDatabase);
        createTablesAndIndex(1, sQLiteDatabase);
        createTablesAndIndex(2, sQLiteDatabase);
        createTablesAndIndex(3, sQLiteDatabase);
        createTablesAndIndex(4, sQLiteDatabase);
        createTablesAndIndex(5, sQLiteDatabase);
        createTablesAndIndex(6, sQLiteDatabase);
        createTablesAndIndex(7, sQLiteDatabase);
        createTablesAndIndex(8, sQLiteDatabase);
        createTablesAndIndex(9, sQLiteDatabase);
        createTablesAndIndex(10, sQLiteDatabase);
    }

    private void createTablesAndIndex(int i2, SQLiteDatabase sQLiteDatabase) {
        createTablesAndIndexOptional(i2, sQLiteDatabase, true);
    }

    private void createTablesAndIndexOptional(int i2, SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL(LocaleDBContract.SQL_CREATE_TABLE(i2));
        if (LocaleDBContract.isIndexingEnabled() && z) {
            sQLiteDatabase.execSQL(LocaleDBContract.SQL_CREATE_LOCALE_TABLE_INDEX(i2));
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 <= i2 || i2 != 1) {
            onCreate(sQLiteDatabase);
        } else {
            addUniqueConstraintsInAllTable(sQLiteDatabase);
        }
    }

    private void addUniqueConstraintsInAllTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        addUniqueConstraints(0, sQLiteDatabase);
        addUniqueConstraints(1, sQLiteDatabase);
        addUniqueConstraints(2, sQLiteDatabase);
        addUniqueConstraints(3, sQLiteDatabase);
        addUniqueConstraints(4, sQLiteDatabase);
        addUniqueConstraints(5, sQLiteDatabase);
        addUniqueConstraints(6, sQLiteDatabase);
        addUniqueConstraints(7, sQLiteDatabase);
        addUniqueConstraints(8, sQLiteDatabase);
        addUniqueConstraints(9, sQLiteDatabase);
        addUniqueConstraints(10, sQLiteDatabase);
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void addUniqueConstraints(int i2, SQLiteDatabase sQLiteDatabase) {
        try {
            if (LocaleDBContract.isIndexingEnabled()) {
                sQLiteDatabase.execSQL(LocaleDBContract.SQL_DROP_LOCALE_TABLE_INDEX(i2));
            }
            sQLiteDatabase.execSQL("ALTER TABLE " + LocaleDBContract.getTableName(i2) + " RENAME TO " + LocaleDBContract.getTempTableName(i2));
            createTablesAndIndexOptional(i2, sQLiteDatabase, false);
            sQLiteDatabase.execSQL("INSERT INTO " + LocaleDBContract.getTableName(i2) + " SELECT * FROM " + LocaleDBContract.getTempTableName(i2));
            StringBuilder sb = new StringBuilder("DROP TABLE ");
            sb.append(LocaleDBContract.getTempTableName(i2));
            sQLiteDatabase.execSQL(sb.toString());
            if (LocaleDBContract.isIndexingEnabled()) {
                sQLiteDatabase.execSQL(LocaleDBContract.SQL_CREATE_LOCALE_TABLE_INDEX(i2));
            }
        } catch (Exception unused) {
        }
    }
}
