package androidx.room.b;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import com.business.merchant_payments.common.utility.AppUtility;
import java.util.Arrays;

public final class b {
    public static Cursor a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
                    int type = cursor.getType(i2);
                    if (type == 0) {
                        objArr[i2] = null;
                    } else if (type == 1) {
                        objArr[i2] = Long.valueOf(cursor.getLong(i2));
                    } else if (type == 2) {
                        objArr[i2] = Double.valueOf(cursor.getDouble(i2));
                    } else if (type == 3) {
                        objArr[i2] = cursor.getString(i2);
                    } else if (type == 4) {
                        objArr[i2] = cursor.getBlob(i2);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            return a(cursor.getColumnNames(), str);
        }
        return -1;
    }

    public static int b(Cursor cursor, String str) {
        String str2;
        int a2 = a(cursor, str);
        if (a2 >= 0) {
            return a2;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception unused) {
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    private static int a(String[] strArr, String str) {
        String concat = AppUtility.CENTER_DOT.concat(String.valueOf(str));
        String str2 = AppUtility.CENTER_DOT + str + "`";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str3 = strArr[i2];
            if (str3.length() >= str.length() + 2) {
                if (str3.endsWith(concat)) {
                    return i2;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }
}
