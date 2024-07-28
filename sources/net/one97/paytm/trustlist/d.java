package net.one97.paytm.trustlist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.gson.f;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.trustlist.MessageInfo;
import net.one97.paytm.common.entity.trustlist.TrustManagerOtpModel;

public final class d {
    public static void a() {
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        q.a("count::".concat(String.valueOf(writableDatabase.delete("trustmanagerSmsTable", (String) null, (String[]) null))));
        writableDatabase.close();
    }

    public static void a(String str, String str2, String str3, MessageInfo messageInfo, String str4) {
        StringBuilder sb = new StringBuilder("111  amount ");
        sb.append(str);
        sb.append(" time ");
        sb.append(str2);
        sb.append(" manualOtp ");
        sb.append(str3);
        String a2 = b.a(str);
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", a2);
        contentValues.put("time", str2);
        contentValues.put("manualOtp", str3);
        contentValues.put("retryCount", 0);
        contentValues.put("mask_mobile_no", str4);
        StringBuilder sb2 = new StringBuilder(" amount ");
        sb2.append(a2);
        sb2.append(" time ");
        sb2.append(str2);
        sb2.append(" manualOtp ");
        sb2.append(str3);
        sb2.append(" otpMsg ");
        sb2.append(new f().b(messageInfo));
        sb2.append(" maskNumber ");
        sb2.append(str4);
        if (messageInfo != null) {
            new StringBuilder("otpMsg is not null ").append(messageInfo);
            contentValues.put("smsList", new f().b(messageInfo));
        }
        writableDatabase.insert("trustmanagerSmsTable", (String) null, contentValues);
        writableDatabase.close();
    }

    public static TrustManagerOtpModel b() {
        Cursor query = TMDbManager.a().f65169a.getReadableDatabase().query("trustmanagerSmsTable", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "time ASC", "1");
        MessageInfo messageInfo = null;
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        String string = query.getString(query.getColumnIndex("amount"));
        String string2 = query.getString(query.getColumnIndex("txnId"));
        String string3 = query.getString(query.getColumnIndex("time"));
        String string4 = query.getString(query.getColumnIndex("manualOtp"));
        String string5 = query.getString(query.getColumnIndex("smsList"));
        String string6 = query.getString(query.getColumnIndex("mask_mobile_no"));
        int i2 = query.getInt(query.getColumnIndex("retryCount"));
        if (!TextUtils.isEmpty(string5)) {
            messageInfo = (MessageInfo) new f().a(string5, MessageInfo.class);
        }
        MessageInfo messageInfo2 = messageInfo;
        if (query != null) {
            query.close();
        }
        return new TrustManagerOtpModel(messageInfo2, string2, string, string3, i2, string4, string6);
    }

    public static void a(String str, String str2) {
        String a2 = b.a(str);
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txnId", str2);
        writableDatabase.update("trustmanagerSmsTable", contentValues, "amount = ?", new String[]{a2});
        writableDatabase.close();
    }

    public static synchronized long a(String str) {
        long delete;
        synchronized (d.class) {
            String a2 = b.a(str);
            SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
            delete = (long) writableDatabase.delete("trustmanagerSmsTable", "amount =?", new String[]{a2});
            writableDatabase.close();
        }
        return delete;
    }

    public static synchronized long b(String str) {
        long delete;
        synchronized (d.class) {
            SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
            delete = (long) writableDatabase.delete("trustmanagerSmsTable", "txnId =?", new String[]{str});
            writableDatabase.close();
        }
        return delete;
    }

    public static synchronized void a(String str, int i2) {
        synchronized (d.class) {
            SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("retryCount", Integer.valueOf(i2));
            writableDatabase.update("trustmanagerSmsTable", contentValues, "txnId =?", new String[]{str});
            writableDatabase.close();
        }
    }
}
