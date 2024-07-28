package org.npci.upi.security.pinactivitycomponent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.paytm.contactsSdk.database.Tables;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class i extends SQLiteOpenHelper {
    public i(Context context) {
        super(context, "contactsManager", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public String a(String str, String str2, String str3) {
        List a2 = a();
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return ((ar) a2.get(0)).a();
    }

    public List a() {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT  * FROM contacts", (String[]) null);
        if (rawQuery.moveToFirst()) {
            do {
                ar arVar = new ar();
                arVar.a(rawQuery.getString(1));
                arVar.b(rawQuery.getString(2));
                arVar.c(rawQuery.getString(3));
                arrayList.add(arVar);
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(ar arVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("k0", arVar.a());
        contentValues.put(StringSet.token, arVar.b());
        contentValues.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, arVar.c());
        writableDatabase.insert(Tables.CONTACTS, (String) null, contentValues);
        writableDatabase.close();
    }

    public int b(ar arVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("k0", arVar.a());
        contentValues.put(StringSet.token, arVar.b());
        contentValues.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, arVar.c());
        return writableDatabase.update(Tables.CONTACTS, contentValues, "k0 = ?", new String[]{arVar.a()});
    }

    public String b() {
        List a2 = a();
        return (a2 == null || a2.isEmpty()) ? "" : ((ar) a2.get(0)).b();
    }

    public void c() {
        ad.b("DB Handler", "Deleting all");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("delete from contacts");
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE contacts(id INTEGER PRIMARY KEY,k0 TEXT,token TEXT,date TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sQLiteDatabase);
    }
}
