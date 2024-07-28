package org.greenrobot.greendao.database;

public interface DatabaseStatement {
    void bindBlob(int i2, byte[] bArr);

    void bindDouble(int i2, double d2);

    void bindLong(int i2, long j);

    void bindNull(int i2);

    void bindString(int i2, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
