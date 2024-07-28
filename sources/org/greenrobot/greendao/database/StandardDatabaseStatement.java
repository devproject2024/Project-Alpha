package org.greenrobot.greendao.database;

import android.database.sqlite.SQLiteStatement;

public class StandardDatabaseStatement implements DatabaseStatement {
    private final SQLiteStatement delegate;

    public StandardDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.delegate = sQLiteStatement;
    }

    public void execute() {
        this.delegate.execute();
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }

    public void bindNull(int i2) {
        this.delegate.bindNull(i2);
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public void bindString(int i2, String str) {
        this.delegate.bindString(i2, str);
    }

    public void bindBlob(int i2, byte[] bArr) {
        this.delegate.bindBlob(i2, bArr);
    }

    public void bindLong(int i2, long j) {
        this.delegate.bindLong(i2, j);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void bindDouble(int i2, double d2) {
        this.delegate.bindDouble(i2, d2);
    }

    public void close() {
        this.delegate.close();
    }

    public Object getRawStatement() {
        return this.delegate;
    }
}
