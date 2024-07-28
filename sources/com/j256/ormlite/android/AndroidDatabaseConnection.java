package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.sendbird.android.constant.StringSet;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__5.0__";
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidDatabaseConnection.class);
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;

    public boolean isAutoCommitSupported() {
        return true;
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", (Object) this, (Object) sQLiteDatabase, (Object) Boolean.valueOf(z));
    }

    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", (Object) this, (Object) Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e2);
        }
    }

    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.db.inTransaction()) {
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            }
        } else if (!this.db.inTransaction()) {
            this.db.beginTransaction();
        }
    }

    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", (Object) this, (Object) str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems beginning transaction ".concat(String.valueOf(str)), e2);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", (Object) this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e2) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems commiting transaction", e2);
            }
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e2);
        }
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", (Object) this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e2) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e2);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e2);
        }
    }

    public int executeStatement(String str, int i2) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i2, boolean z) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled, z);
        logger.trace("{}: compiled statement got {}: {}", (Object) this, (Object) androidCompiledStatement, (Object) str);
        return androidCompiledStatement;
    }

    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        try {
            SQLiteStatement compileStatement = this.db.compileStatement(str);
            bindArgs(compileStatement, objArr, fieldTypeArr);
            long executeInsert = compileStatement.executeInsert();
            if (generatedKeyHolder != null) {
                generatedKeyHolder.addKey(Long.valueOf(executeInsert));
            }
            logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
            closeQuietly(compileStatement);
            return 1;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("inserting to database failed: ".concat(String.valueOf(str)), e2);
        } catch (Throwable th) {
            closeQuietly((SQLiteStatement) null);
            throw th;
        }
    }

    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, StringSet.updated);
    }

    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, StringSet.deleted);
    }

    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException {
        Cursor cursor;
        AndroidDatabaseResults androidDatabaseResults;
        android.database.SQLException e2;
        T t = null;
        try {
            cursor = this.db.rawQuery(str, toStrings(objArr));
            try {
                androidDatabaseResults = new AndroidDatabaseResults(cursor, objectCache, true);
            } catch (android.database.SQLException e3) {
                androidDatabaseResults = null;
                e2 = e3;
                try {
                    throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(androidDatabaseResults);
                    closeQuietly(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                androidDatabaseResults = null;
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                throw th;
            }
            try {
                logger.trace("{}: queried for one result: {}", (Object) this, (Object) str);
                if (androidDatabaseResults.first()) {
                    t = genericRowMapper.mapRow(androidDatabaseResults);
                    if (androidDatabaseResults.next()) {
                        Object obj = MORE_THAN_ONE;
                        IOUtils.closeQuietly(androidDatabaseResults);
                        closeQuietly(cursor);
                        return obj;
                    }
                }
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                return t;
            } catch (android.database.SQLException e4) {
                e2 = e4;
                throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e2);
            }
        } catch (android.database.SQLException e5) {
            androidDatabaseResults = null;
            e2 = e5;
            cursor = null;
            throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e2);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            androidDatabaseResults = null;
            IOUtils.closeQuietly(androidDatabaseResults);
            closeQuietly(cursor);
            throw th;
        }
    }

    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = this.db.compileStatement(str);
            long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
            logger.trace("{}: query for long simple query returned {}: {}", (Object) this, (Object) Long.valueOf(simpleQueryForLong), (Object) str);
            closeQuietly(sQLiteStatement);
            return simpleQueryForLong;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e2);
        } catch (Throwable th) {
            closeQuietly(sQLiteStatement);
            throw th;
        }
    }

    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        Cursor cursor;
        AndroidDatabaseResults androidDatabaseResults;
        android.database.SQLException e2;
        try {
            cursor = this.db.rawQuery(str, toStrings(objArr));
            try {
                androidDatabaseResults = new AndroidDatabaseResults(cursor, (ObjectCache) null, false);
            } catch (android.database.SQLException e3) {
                android.database.SQLException sQLException = e3;
                androidDatabaseResults = null;
                e2 = sQLException;
                try {
                    throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e2);
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(cursor);
                    IOUtils.closeQuietly(androidDatabaseResults);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                androidDatabaseResults = null;
                closeQuietly(cursor);
                IOUtils.closeQuietly(androidDatabaseResults);
                throw th;
            }
            try {
                long j = androidDatabaseResults.first() ? androidDatabaseResults.getLong(0) : 0;
                logger.trace("{}: query for long raw query returned {}: {}", (Object) this, (Object) Long.valueOf(j), (Object) str);
                closeQuietly(cursor);
                IOUtils.closeQuietly(androidDatabaseResults);
                return j;
            } catch (android.database.SQLException e4) {
                e2 = e4;
                throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e2);
            }
        } catch (android.database.SQLException e5) {
            androidDatabaseResults = null;
            e2 = e5;
            cursor = null;
            throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e2);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            androidDatabaseResults = null;
            closeQuietly(cursor);
            IOUtils.closeQuietly(androidDatabaseResults);
            throw th;
        }
    }

    public void close() throws IOException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", (Object) this, (Object) this.db);
        } catch (android.database.SQLException e2) {
            throw new IOException("problems closing the database connection", e2);
        }
    }

    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", (Object) this, (Object) this.db, (Object) Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e2);
        }
    }

    public boolean isTableExists(String str) {
        SQLiteDatabase sQLiteDatabase = this.db;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", (String[]) null);
        try {
            boolean z = rawQuery.getCount() > 0;
            logger.trace("{}: isTableExists '{}' returned {}", (Object) this, (Object) str, (Object) Boolean.valueOf(z));
            return z;
        } finally {
            rawQuery.close();
        }
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws SQLException {
        int i2;
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement compileStatement = this.db.compileStatement(str);
            try {
                bindArgs(compileStatement, objArr, fieldTypeArr);
                compileStatement.execute();
                closeQuietly(compileStatement);
                try {
                    sQLiteStatement = this.db.compileStatement("SELECT CHANGES()");
                    i2 = (int) sQLiteStatement.simpleQueryForLong();
                } catch (android.database.SQLException unused) {
                    i2 = 1;
                } catch (Throwable th) {
                    closeQuietly((SQLiteStatement) null);
                    throw th;
                }
                closeQuietly(sQLiteStatement);
                logger.trace("{} statement is compiled and executed, changed {}: {}", (Object) str2, (Object) Integer.valueOf(i2), (Object) str);
                return i2;
            } catch (android.database.SQLException e2) {
                e = e2;
                sQLiteStatement = compileStatement;
                try {
                    throw SqlExceptionUtil.create("updating database failed: ".concat(String.valueOf(str)), e);
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = compileStatement;
                closeQuietly(sQLiteStatement);
                throw th;
            }
        } catch (android.database.SQLException e3) {
            e = e3;
            throw SqlExceptionUtil.create("updating database failed: ".concat(String.valueOf(str)), e);
        }
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr != null) {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                byte[] bArr = objArr[i2];
                if (bArr == null) {
                    sQLiteStatement.bindNull(i2 + 1);
                } else {
                    SqlType sqlType = fieldTypeArr[i2].getSqlType();
                    switch (sqlType) {
                        case STRING:
                        case LONG_STRING:
                        case CHAR:
                            sQLiteStatement.bindString(i2 + 1, bArr.toString());
                            break;
                        case BOOLEAN:
                        case BYTE:
                        case SHORT:
                        case INTEGER:
                        case LONG:
                            sQLiteStatement.bindLong(i2 + 1, ((Number) bArr).longValue());
                            break;
                        case FLOAT:
                        case DOUBLE:
                            sQLiteStatement.bindDouble(i2 + 1, ((Number) bArr).doubleValue());
                            break;
                        case BYTE_ARRAY:
                        case SERIALIZABLE:
                            sQLiteStatement.bindBlob(i2 + 1, bArr);
                            break;
                        case DATE:
                        case BLOB:
                        case BIG_DECIMAL:
                            throw new SQLException("Invalid Android type: ".concat(String.valueOf(sqlType)));
                        default:
                            throw new SQLException("Unknown sql argument type: ".concat(String.valueOf(sqlType)));
                    }
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                strArr[i2] = null;
            } else {
                strArr[i2] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    private void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private void closeQuietly(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
    }

    static class OurSavePoint implements Savepoint {
        private String name;

        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        public String getSavepointName() {
            return this.name;
        }
    }
}
