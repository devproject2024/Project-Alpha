package org.greenrobot.greendao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.sqlcipher.database.SQLiteDatabase;

public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    public void onCreate(Database database) {
    }

    public void onOpen(Database database) {
    }

    public void onUpgrade(Database database, int i2, int i3) {
    }

    public DatabaseOpenHelper(Context context2, String str, int i2) {
        this(context2, str, (SQLiteDatabase.CursorFactory) null, i2);
    }

    public DatabaseOpenHelper(Context context2, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context2, str, cursorFactory, i2);
        this.loadSQLCipherNativeLibs = true;
        this.context = context2;
        this.name = str;
        this.version = i2;
    }

    public void setLoadSQLCipherNativeLibs(boolean z) {
        this.loadSQLCipherNativeLibs = z;
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    /* access modifiers changed from: protected */
    public Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(wrap(sQLiteDatabase), i2, i3);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            this.encryptedHelper = new EncryptedHelper(this.context, this.name, this.version, this.loadSQLCipherNativeLibs);
        }
        return this.encryptedHelper;
    }

    public Database getEncryptedWritableDb(String str) {
        EncryptedHelper checkEncryptedHelper = checkEncryptedHelper();
        return checkEncryptedHelper.wrap(checkEncryptedHelper.getWritableDatabase(str));
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        EncryptedHelper checkEncryptedHelper = checkEncryptedHelper();
        return checkEncryptedHelper.wrap(checkEncryptedHelper.getWritableDatabase(cArr));
    }

    public Database getEncryptedReadableDb(String str) {
        EncryptedHelper checkEncryptedHelper = checkEncryptedHelper();
        return checkEncryptedHelper.wrap(checkEncryptedHelper.getReadableDatabase(str));
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        EncryptedHelper checkEncryptedHelper = checkEncryptedHelper();
        return checkEncryptedHelper.wrap(checkEncryptedHelper.getReadableDatabase(cArr));
    }

    class EncryptedHelper extends net.sqlcipher.database.SQLiteOpenHelper {
        public EncryptedHelper(Context context, String str, int i2, boolean z) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            if (z) {
                net.sqlcipher.database.SQLiteDatabase.loadLibs(context);
            }
        }

        public void onCreate(net.sqlcipher.database.SQLiteDatabase sQLiteDatabase) {
            DatabaseOpenHelper.this.onCreate(wrap(sQLiteDatabase));
        }

        public void onUpgrade(net.sqlcipher.database.SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            DatabaseOpenHelper.this.onUpgrade(wrap(sQLiteDatabase), i2, i3);
        }

        public void onOpen(net.sqlcipher.database.SQLiteDatabase sQLiteDatabase) {
            DatabaseOpenHelper.this.onOpen(wrap(sQLiteDatabase));
        }

        /* access modifiers changed from: protected */
        public Database wrap(net.sqlcipher.database.SQLiteDatabase sQLiteDatabase) {
            return new EncryptedDatabase(sQLiteDatabase);
        }
    }
}
