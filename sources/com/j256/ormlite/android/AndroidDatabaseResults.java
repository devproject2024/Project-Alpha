package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndroidDatabaseResults implements DatabaseResults {
    private static final int MIN_NUM_COLUMN_NAMES_MAP = 8;
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    private final boolean cacheStore;
    private final Map<String, Integer> columnNameMap;
    private final String[] columnNames;
    private final Cursor cursor;
    private final ObjectCache objectCache;

    public AndroidDatabaseResults(Cursor cursor2, ObjectCache objectCache2, boolean z) {
        this.cursor = cursor2;
        this.columnNames = cursor2.getColumnNames();
        if (this.columnNames.length >= 8) {
            this.columnNameMap = new HashMap();
            int i2 = 0;
            while (true) {
                String[] strArr = this.columnNames;
                if (i2 >= strArr.length) {
                    break;
                }
                this.columnNameMap.put(strArr[i2], Integer.valueOf(i2));
                i2++;
            }
        } else {
            this.columnNameMap = null;
        }
        this.objectCache = objectCache2;
        this.cacheStore = z;
    }

    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    public String[] getColumnNames() {
        int columnCount = getColumnCount();
        String[] strArr = new String[columnCount];
        for (int i2 = 0; i2 < columnCount; i2++) {
            strArr[i2] = this.cursor.getColumnName(i2);
        }
        return strArr;
    }

    public boolean first() {
        return this.cursor.moveToFirst();
    }

    public boolean next() {
        return this.cursor.moveToNext();
    }

    public boolean last() {
        return this.cursor.moveToLast();
    }

    public boolean previous() {
        return this.cursor.moveToPrevious();
    }

    public boolean moveRelative(int i2) {
        return this.cursor.move(i2);
    }

    public boolean moveAbsolute(int i2) {
        return this.cursor.moveToPosition(i2);
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    public int findColumn(String str) throws SQLException {
        int lookupColumn = lookupColumn(str);
        if (lookupColumn >= 0) {
            return lookupColumn;
        }
        StringBuilder sb = new StringBuilder(str.length() + 4);
        databaseType.appendEscapedEntityName(sb, str);
        int lookupColumn2 = lookupColumn(sb.toString());
        if (lookupColumn2 >= 0) {
            return lookupColumn2;
        }
        String[] columnNames2 = this.cursor.getColumnNames();
        throw new SQLException("Unknown field '" + str + "' from the Android sqlite cursor, not in:" + Arrays.toString(columnNames2));
    }

    public String getString(int i2) {
        return this.cursor.getString(i2);
    }

    public boolean getBoolean(int i2) {
        return !this.cursor.isNull(i2) && this.cursor.getShort(i2) != 0;
    }

    public char getChar(int i2) throws SQLException {
        String string = this.cursor.getString(i2);
        if (string == null || string.length() == 0) {
            return 0;
        }
        if (string.length() == 1) {
            return string.charAt(0);
        }
        throw new SQLException("More than 1 character stored in database column: ".concat(String.valueOf(i2)));
    }

    public byte getByte(int i2) {
        return (byte) getShort(i2);
    }

    public byte[] getBytes(int i2) {
        return this.cursor.getBlob(i2);
    }

    public short getShort(int i2) {
        return this.cursor.getShort(i2);
    }

    public int getInt(int i2) {
        return this.cursor.getInt(i2);
    }

    public long getLong(int i2) {
        return this.cursor.getLong(i2);
    }

    public float getFloat(int i2) {
        return this.cursor.getFloat(i2);
    }

    public double getDouble(int i2) {
        return this.cursor.getDouble(i2);
    }

    public Timestamp getTimestamp(int i2) throws SQLException {
        throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
    }

    public InputStream getBlobStream(int i2) {
        return new ByteArrayInputStream(this.cursor.getBlob(i2));
    }

    public BigDecimal getBigDecimal(int i2) throws SQLException {
        throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
    }

    public Object getObject(int i2) throws SQLException {
        throw new SQLException("Android does not support Object type.");
    }

    public boolean wasNull(int i2) {
        return this.cursor.isNull(i2);
    }

    public ObjectCache getObjectCacheForRetrieve() {
        return this.objectCache;
    }

    public ObjectCache getObjectCacheForStore() {
        if (this.cacheStore) {
            return this.objectCache;
        }
        return null;
    }

    public void close() {
        this.cursor.close();
    }

    public void closeQuietly() {
        close();
    }

    public Cursor getRawCursor() {
        return this.cursor;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    private int lookupColumn(String str) {
        Map<String, Integer> map = this.columnNameMap;
        if (map == null) {
            int i2 = 0;
            while (true) {
                String[] strArr = this.columnNames;
                if (i2 >= strArr.length) {
                    return -1;
                }
                if (strArr[i2].equals(str)) {
                    return i2;
                }
                i2++;
            }
        } else {
            Integer num = map.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
    }
}
