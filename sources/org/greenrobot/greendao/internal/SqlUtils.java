package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

public class SqlUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static StringBuilder appendProperty(StringBuilder sb, String str, Property property) {
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        sb.append('\"');
        sb.append(property.columnName);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder appendColumn(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder appendColumn(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder appendColumns(StringBuilder sb, String str, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            appendColumn(sb, str, strArr[i2]);
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append('\"');
            sb.append(strArr[i2]);
            sb.append('\"');
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendPlaceholders(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 < i2 - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder sb, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            appendColumn(sb, strArr[i2]).append("=?");
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder sb, String str, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            appendColumn(sb, str, strArr[i2]).append("=?");
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        appendColumns(sb, strArr);
        sb.append(") VALUES (");
        appendPlaceholders(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String createSqlSelect(String str, String str2, String[] strArr, boolean z) {
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        StringBuilder sb = new StringBuilder(z ? "SELECT DISTINCT " : "SELECT ");
        appendColumns(sb, str2, strArr).append(" FROM ");
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        return sb.toString();
    }

    public static String createSqlSelectCountStar(String str, String str2) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        sb.append(' ');
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String createSqlDelete(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            appendColumnsEqValue(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        appendColumnsEqualPlaceholders(sb, strArr);
        sb.append(" WHERE ");
        appendColumnsEqValue(sb, str2, strArr2);
        return sb.toString();
    }

    public static String createSqlCount(String str) {
        return "SELECT COUNT(*) FROM \"" + str + '\"';
    }

    public static String escapeBlobArgument(byte[] bArr) {
        return "X'" + toHex(bArr) + '\'';
    }

    public static String toHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
