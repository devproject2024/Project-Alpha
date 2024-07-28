package net.one97.paytm.locale.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.paytm.b.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.LangEntity;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;

public class LocaleDBQuery {
    private static String KEY_IS_UPDATE_LANG_PUSH_RECEIVED = "isTOUpdateLangPushReceived";
    private static String KEY_LAST_UPDATED_TIMESTAMP = "localeLastUpdatedTimeStamp";
    private static volatile LocaleDBQuery instance;
    private SQLiteDatabase mDB = this.mDBHelper.getWritableDatabase();
    private LocaleDBHelper mDBHelper = new LocaleDBHelper(d.b().a());

    private LocaleDBQuery() {
    }

    public static LocaleDBQuery getDB() {
        if (instance == null) {
            synchronized (LocaleDBQuery.class) {
                if (instance == null) {
                    instance = new LocaleDBQuery();
                }
            }
        }
        return instance;
    }

    public Map<String, String> getDataMap(int i2, String... strArr) {
        HashMap hashMap = new HashMap();
        Cursor data = getData(i2, strArr);
        if (data != null && data.moveToFirst()) {
            for (int i3 = 0; i3 < data.getCount(); i3++) {
                data.moveToPosition(i3);
                hashMap.put(data.getString(data.getColumnIndex(LocaleDBContract.BaseTable.KEY)), data.getString(data.getColumnIndex("message")));
            }
            closeCursor(data);
        }
        return hashMap;
    }

    public List<LangEntity> getDataList(int i2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        Cursor data = getData(i2, strArr);
        if (data == null || !data.moveToFirst()) {
            closeCursor(data);
            return arrayList;
        }
        for (int i3 = 0; i3 < data.getCount(); i3++) {
            data.moveToPosition(i3);
            arrayList.add(new LangEntity(data.getString(data.getColumnIndex(LocaleDBContract.BaseTable.KEY)), data.getString(data.getColumnIndex("message"))));
        }
        closeCursor(data);
        return arrayList;
    }

    public List<LangEntity> getDataList(String str, String... strArr) {
        int languageIdFromLocale = LocaleDBContract.getLanguageIdFromLocale(str);
        ArrayList arrayList = new ArrayList();
        Cursor data = getData(languageIdFromLocale, strArr);
        if (data != null) {
            try {
                if (data.moveToFirst()) {
                    if (data.moveToFirst()) {
                        for (int i2 = 0; i2 < data.getCount(); i2++) {
                            data.moveToPosition(i2);
                            String string = data.getString(data.getColumnIndex(LocaleDBContract.BaseTable.KEY));
                            String string2 = data.getString(data.getColumnIndex("message"));
                            if (string2 != null) {
                                arrayList.add(new LangEntity(string, string2));
                            }
                        }
                        closeCursor(data);
                        return arrayList;
                    }
                }
            } catch (Exception e2) {
                r.a(LocaleDBQuery.class.getName(), "cursorWindowAllocation", (Throwable) e2);
            } catch (Throwable th) {
                closeCursor(data);
                throw th;
            }
        }
        closeCursor(data);
        closeCursor(data);
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r7.getCount() == 0) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateDataList(java.util.HashMap<java.lang.String, java.lang.String> r6, java.lang.String r7, java.lang.String... r8) {
        /*
            r5 = this;
            int r7 = net.one97.paytm.locale.storage.LocaleDBContract.getLanguageIdFromLocale(r7)
            android.database.Cursor r7 = r5.getData(r7, r8)
            r0 = 0
            if (r7 == 0) goto L_0x0011
            int r1 = r7.getCount()     // Catch:{ Exception -> 0x005a }
            if (r1 != 0) goto L_0x001e
        L_0x0011:
            int r1 = r8.length     // Catch:{ Exception -> 0x005a }
            r2 = 0
        L_0x0013:
            if (r2 >= r1) goto L_0x001e
            r3 = r8[r2]     // Catch:{ Exception -> 0x005a }
            r4 = 0
            r6.put(r3, r4)     // Catch:{ Exception -> 0x005a }
            int r2 = r2 + 1
            goto L_0x0013
        L_0x001e:
            if (r7 == 0) goto L_0x002c
            boolean r8 = r7.moveToFirst()     // Catch:{ Exception -> 0x005a }
            if (r8 == 0) goto L_0x002c
            boolean r8 = r7.moveToFirst()     // Catch:{ Exception -> 0x005a }
            if (r8 != 0) goto L_0x002f
        L_0x002c:
            closeCursor(r7)     // Catch:{ Exception -> 0x005a }
        L_0x002f:
            int r8 = r7.getCount()     // Catch:{ Exception -> 0x005a }
            if (r0 >= r8) goto L_0x0054
            r7.moveToPosition(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.String r8 = "key_name"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ Exception -> 0x005a }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = "message"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x005a }
            if (r1 == 0) goto L_0x0051
            r6.put(r8, r1)     // Catch:{ Exception -> 0x005a }
        L_0x0051:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x0054:
            closeCursor(r7)
            return
        L_0x0058:
            r6 = move-exception
            goto L_0x006a
        L_0x005a:
            r6 = move-exception
            java.lang.Class<net.one97.paytm.locale.storage.LocaleDBQuery> r8 = net.one97.paytm.locale.storage.LocaleDBQuery.class
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = "cursorWindowAllocation"
            net.one97.paytm.utils.r.a((java.lang.String) r8, (java.lang.String) r0, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0058 }
            closeCursor(r7)
            return
        L_0x006a:
            closeCursor(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.locale.storage.LocaleDBQuery.updateDataList(java.util.HashMap, java.lang.String, java.lang.String[]):void");
    }

    private Cursor getData(int i2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            SQLiteDatabase sQLiteDatabase = this.mDB;
            return sQLiteDatabase.query(LocaleDBContract.getTableName(i2), new String[]{LocaleDBContract.BaseTable.KEY, "message"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        String arraysToStr = arraysToStr(strArr);
        SQLiteDatabase sQLiteDatabase2 = this.mDB;
        String tableName = LocaleDBContract.getTableName(i2);
        String[] strArr2 = {LocaleDBContract.BaseTable.KEY, "message"};
        return sQLiteDatabase2.query(tableName, strArr2, "key_name in ( " + arraysToStr + " ) ", (String[]) null, (String) null, (String) null, (String) null);
    }

    private String arraysToStr(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                sb.append(" , ");
            }
            sb.append("'" + strArr[i2] + "'");
        }
        return sb.toString();
    }

    public synchronized boolean saveData(String str, String str2, String str3) {
        int languageIdFromLocale = LocaleDBContract.getLanguageIdFromLocale(str);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(LocaleDBContract.BaseTable.KEY, str2);
            contentValues.put(LocaleDBContract.LocaleToLangColumnName(str), str3);
            if (getDataList(languageIdFromLocale, str2).size() > 0) {
                this.mDB.update(LocaleDBContract.getTableName(languageIdFromLocale), contentValues, LocaleDBContract.BaseTable.KEY, new String[]{str2});
            } else {
                this.mDB.insert(LocaleDBContract.getTableName(languageIdFromLocale), (String) null, contentValues);
            }
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean saveData(int r8, java.util.ArrayList<net.one97.paytm.common.entity.LangEntity> r9, net.one97.paytm.locale.a.b.C0946b r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r9 == 0) goto L_0x00a6
            int r1 = r9.size()     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x000c
            goto L_0x00a6
        L_0x000c:
            boolean r1 = net.one97.paytm.locale.storage.LocaleDBContract.isIndexingEnabled()     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x001b
            android.database.sqlite.SQLiteDatabase r1 = r7.mDB     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = net.one97.paytm.locale.storage.LocaleDBContract.SQL_DROP_LOCALE_TABLE_INDEX(r8)     // Catch:{ all -> 0x00a3 }
            r1.execSQL(r2)     // Catch:{ all -> 0x00a3 }
        L_0x001b:
            getRowCount(r8)     // Catch:{ all -> 0x00a3 }
            android.database.sqlite.SQLiteDatabase r1 = r7.mDB     // Catch:{ all -> 0x00a3 }
            r1.beginTransaction()     // Catch:{ all -> 0x00a3 }
            int r1 = r9.size()     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r2.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r3 = 0
        L_0x002d:
            if (r3 >= r1) goto L_0x005b
            java.lang.Object r4 = r9.get(r3)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            net.one97.paytm.common.entity.LangEntity r4 = (net.one97.paytm.common.entity.LangEntity) r4     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            java.lang.String r5 = "key_name"
            java.lang.String r6 = r4.getKey()     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r2.put(r5, r6)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            java.lang.String r5 = "message"
            java.lang.String r4 = r4.getValue()     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r2.put(r5, r4)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            android.database.sqlite.SQLiteDatabase r4 = r7.mDB     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            java.lang.String r5 = net.one97.paytm.locale.storage.LocaleDBContract.getTableName(r8)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r6 = 0
            r4.insert(r5, r6, r2)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            int r4 = r3 % 100
            if (r4 != 0) goto L_0x0058
            r10.doUpdateProgress(r3, r1)     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
        L_0x0058:
            int r3 = r3 + 1
            goto L_0x002d
        L_0x005b:
            android.database.sqlite.SQLiteDatabase r9 = r7.mDB     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x008d, all -> 0x0077 }
            android.database.sqlite.SQLiteDatabase r9 = r7.mDB     // Catch:{ all -> 0x00a3 }
            r9.endTransaction()     // Catch:{ all -> 0x00a3 }
            boolean r9 = net.one97.paytm.locale.storage.LocaleDBContract.isIndexingEnabled()     // Catch:{ all -> 0x00a3 }
            if (r9 == 0) goto L_0x0074
            android.database.sqlite.SQLiteDatabase r9 = r7.mDB     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = net.one97.paytm.locale.storage.LocaleDBContract.SQL_CREATE_LOCALE_TABLE_INDEX(r8)     // Catch:{ all -> 0x00a3 }
            r9.execSQL(r8)     // Catch:{ all -> 0x00a3 }
        L_0x0074:
            monitor-exit(r7)
            r8 = 1
            return r8
        L_0x0077:
            r9 = move-exception
            android.database.sqlite.SQLiteDatabase r10 = r7.mDB     // Catch:{ all -> 0x00a3 }
            r10.endTransaction()     // Catch:{ all -> 0x00a3 }
            boolean r10 = net.one97.paytm.locale.storage.LocaleDBContract.isIndexingEnabled()     // Catch:{ all -> 0x00a3 }
            if (r10 == 0) goto L_0x008c
            android.database.sqlite.SQLiteDatabase r10 = r7.mDB     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = net.one97.paytm.locale.storage.LocaleDBContract.SQL_CREATE_LOCALE_TABLE_INDEX(r8)     // Catch:{ all -> 0x00a3 }
            r10.execSQL(r8)     // Catch:{ all -> 0x00a3 }
        L_0x008c:
            throw r9     // Catch:{ all -> 0x00a3 }
        L_0x008d:
            android.database.sqlite.SQLiteDatabase r9 = r7.mDB     // Catch:{ all -> 0x00a3 }
            r9.endTransaction()     // Catch:{ all -> 0x00a3 }
            boolean r9 = net.one97.paytm.locale.storage.LocaleDBContract.isIndexingEnabled()     // Catch:{ all -> 0x00a3 }
            if (r9 == 0) goto L_0x00a1
            android.database.sqlite.SQLiteDatabase r9 = r7.mDB     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = net.one97.paytm.locale.storage.LocaleDBContract.SQL_CREATE_LOCALE_TABLE_INDEX(r8)     // Catch:{ all -> 0x00a3 }
            r9.execSQL(r8)     // Catch:{ all -> 0x00a3 }
        L_0x00a1:
            monitor-exit(r7)
            return r0
        L_0x00a3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00a6:
            monitor-exit(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.locale.storage.LocaleDBQuery.saveData(int, java.util.ArrayList, net.one97.paytm.locale.a.b$b):boolean");
    }

    public static long getLastUpdatedTimeStamp(int i2) {
        a a2 = ag.a(d.b().a());
        return a2.b(KEY_LAST_UPDATED_TIMESTAMP + "_" + i2, 0, true);
    }

    public static void saveLastUpdatedTimeStamp(int i2) {
        a a2 = ag.a(d.b().a());
        a2.a(KEY_LAST_UPDATED_TIMESTAMP + "_" + i2, System.currentTimeMillis(), true);
    }

    public static boolean isToUpdateLangByPush() {
        return ag.a(d.b().a()).b(KEY_IS_UPDATE_LANG_PUSH_RECEIVED, false, true);
    }

    public static void savePushReceivedToUpdateLang(boolean z) {
        ag.a(d.b().a()).a(KEY_IS_UPDATE_LANG_PUSH_RECEIVED, z, true);
    }

    private static void closeCursor(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public static int getRowCount(int i2) {
        Cursor rawQuery = getDB().mDB.rawQuery("SELECT  message FROM " + LocaleDBContract.getTableName(i2), (String[]) null);
        int count = rawQuery.getCount();
        closeCursor(rawQuery);
        return count;
    }
}
