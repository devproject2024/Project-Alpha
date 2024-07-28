package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidCompiledStatement implements CompiledStatement {
    private static final String[] NO_STRING_ARGS = new String[0];
    private static final ApiCompatibility apiCompatibility = ApiCompatibilityUtils.getCompatibility();
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidCompiledStatement.class);
    private List<Object> args;
    private final boolean cacheStore;
    private final boolean cancelQueriesEnabled;
    private ApiCompatibility.CancellationHook cancellationHook;
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;

    public void setQueryTimeout(long j) {
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z, boolean z2) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
        this.cacheStore = z2;
    }

    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    public String getColumnName(int i2) throws SQLException {
        return getCursor().getColumnName(i2);
    }

    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (this.type.isOkForQuery()) {
            return new AndroidDatabaseResults(getCursor(), objectCache, this.cacheStore);
        }
        throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
    }

    public int runUpdate() throws SQLException {
        String str;
        if (this.type.isOkForUpdate()) {
            if (this.max == null) {
                str = this.sql;
            } else {
                str = this.sql + " " + this.max;
            }
            return execSql(this.db, "runUpdate", str, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
    }

    public int runExecute() throws SQLException {
        if (this.type.isOkForExecute()) {
            return execSql(this.db, "runExecute", this.sql, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
    }

    public void close() throws IOException {
        Cursor cursor2 = this.cursor;
        if (cursor2 != null && !cursor2.isClosed()) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e2) {
                throw new IOException("Problems closing Android cursor", e2);
            }
        }
        this.cancellationHook = null;
    }

    public void closeQuietly() {
        Cursor cursor2 = this.cursor;
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public void cancel() {
        ApiCompatibility.CancellationHook cancellationHook2 = this.cancellationHook;
        if (cancellationHook2 != null) {
            cancellationHook2.cancel();
        }
    }

    public void setObject(int i2, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i2, (Object) null);
            return;
        }
        switch (sqlType) {
            case STRING:
            case LONG_STRING:
            case DATE:
            case BOOLEAN:
            case CHAR:
            case BYTE:
            case SHORT:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
                this.args.add(i2, obj.toString());
                return;
            case BYTE_ARRAY:
            case SERIALIZABLE:
                this.args.add(i2, obj);
                return;
            case BLOB:
            case BIG_DECIMAL:
                throw new SQLException("Invalid Android type: ".concat(String.valueOf(sqlType)));
            default:
                throw new SQLException("Unknown sql argument type: ".concat(String.valueOf(sqlType)));
        }
    }

    public void setMaxRows(int i2) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i2);
    }

    public Cursor getCursor() throws SQLException {
        String str;
        if (this.cursor == null) {
            try {
                if (this.max == null) {
                    str = this.sql;
                } else {
                    str = this.sql + " LIMIT " + this.max;
                }
                if (this.cancelQueriesEnabled) {
                    this.cancellationHook = apiCompatibility.createCancellationHook();
                }
                this.cursor = apiCompatibility.rawQuery(this.db, str, getStringArray(), this.cancellationHook);
                this.cursor.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", (Object) this, (Object) str);
            } catch (android.database.SQLException e2) {
                throw SqlExceptionUtil.create("Problems executing Android query: ".concat(String.valueOf((Object) null)), e2);
            }
        }
        return this.cursor;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r5 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        logger.trace("executing statement {} changed {} rows: {}", (java.lang.Object) r3, (java.lang.Object) java.lang.Integer.valueOf(r2), (java.lang.Object) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r5 != null) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r5.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int execSql(android.database.sqlite.SQLiteDatabase r2, java.lang.String r3, java.lang.String r4, java.lang.Object[] r5) throws java.sql.SQLException {
        /*
            r2.execSQL(r4, r5)     // Catch:{ SQLException -> 0x002e }
            r5 = 0
            java.lang.String r0 = "SELECT CHANGES()"
            android.database.sqlite.SQLiteStatement r5 = r2.compileStatement(r0)     // Catch:{ SQLException -> 0x0015, all -> 0x0017 }
            long r0 = r5.simpleQueryForLong()     // Catch:{ SQLException -> 0x0015, all -> 0x0017 }
            int r2 = (int) r0
            if (r5 == 0) goto L_0x0022
        L_0x0011:
            r5.close()
            goto L_0x0022
        L_0x0015:
            goto L_0x001e
        L_0x0017:
            r2 = move-exception
            if (r5 == 0) goto L_0x001d
            r5.close()
        L_0x001d:
            throw r2
        L_0x001e:
            r2 = 1
            if (r5 == 0) goto L_0x0022
            goto L_0x0011
        L_0x0022:
            com.j256.ormlite.logger.Logger r5 = logger
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r1 = "executing statement {} changed {} rows: {}"
            r5.trace((java.lang.String) r1, (java.lang.Object) r3, (java.lang.Object) r0, (java.lang.Object) r4)
            return r2
        L_0x002e:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Problems executing "
            r5.<init>(r0)
            r5.append(r3)
            java.lang.String r3 = " Android statement: "
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            java.sql.SQLException r2 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidCompiledStatement.execSql(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.Object[]):int");
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return list.toArray(new Object[list.size()]);
    }

    private String[] getStringArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
