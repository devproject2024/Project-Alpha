package net.one97.paytm.trustlist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.trustlist.MessageInfo;

public final class a {
    public static void a() {
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        writableDatabase.delete("deductionSmsTable", (String) null, (String[]) null);
        writableDatabase.close();
    }

    public static ArrayList<MessageInfo> a(String str, String str2, String str3) {
        q.a("DeductionMsgTable getMessages startTime " + str + " endTime " + str2 + " amount " + str3);
        if (str3.endsWith(".00")) {
            str3 = str3.replace(".00", "");
        }
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        Cursor query = writableDatabase.query("deductionSmsTable", (String[]) null, "time >=? AND time <=? AND smsList LIKE '%" + str3 + "%'", new String[]{str, str2}, (String) null, (String) null, (String) null);
        ArrayList<MessageInfo> arrayList = new ArrayList<>();
        q.a("DeductionMsgTable getMessages 111 cursor.getCount() " + query.getCount());
        while (query.moveToNext()) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setBody(query.getString(query.getColumnIndex("smsList")));
            messageInfo.setSender(query.getString(query.getColumnIndex("sender")));
            messageInfo.setTime(query.getString(query.getColumnIndex("time")));
            q.a("DeductionMsgTable getMessages 222 ".concat(String.valueOf(messageInfo)));
            arrayList.add(messageInfo);
        }
        writableDatabase.close();
        if (query != null) {
            query.close();
        }
        return arrayList;
    }
}
