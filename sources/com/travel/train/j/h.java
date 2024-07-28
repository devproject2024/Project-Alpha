package com.travel.train.j;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.train.model.trainticket.a;
import com.travel.train.model.trainticket.c;
import java.util.ArrayList;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f27560a = "CJRTrainContactUtil";

    public static Cursor a(Context context) {
        try {
            return context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "display_name", "data1", ContactColumn.CONTACT_ID, "data2", "data3", "photo_id", "photo_thumb_uri", "data4"}, "mimetype='vnd.android.cursor.item/phone_v2' ", (String[]) null, "display_name ASC");
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.c(e2.getMessage());
            return null;
        }
    }

    public static List<c> b(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id", "display_name", ContactColumn.CONTACT_ID, "data1"}, "mimetype='vnd.android.cursor.item/email_v2' ", (String[]) null, "display_name ASC");
            if (query != null) {
                while (query.moveToNext()) {
                    int columnIndex = query.getColumnIndex("display_name");
                    int columnIndex2 = query.getColumnIndex("data1");
                    if (columnIndex >= 0 && columnIndex2 >= 0) {
                        String string = query.getString(columnIndex);
                        String string2 = query.getString(columnIndex2);
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.add(new c(string, string2.toLowerCase()));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
            arrayList.clear();
        }
        return arrayList;
    }

    public static List<a> a(Cursor cursor) {
        a aVar = a.f27481b;
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex("display_name");
                int columnIndex2 = cursor.getColumnIndex("data1");
                int columnIndex3 = cursor.getColumnIndex("photo_thumb_uri");
                while (cursor.moveToNext()) {
                    if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex3 >= 0) {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        String string3 = cursor.getString(columnIndex3);
                        if (!TextUtils.isEmpty(string2)) {
                            a aVar2 = new a(string, string2);
                            aVar2.setPhotoUri(string3);
                            aVar2.setColor(aVar.a());
                            arrayList.add(aVar2);
                        }
                    }
                }
                cursor.close();
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
        return arrayList;
    }

    public static String a(String str) {
        return str.replaceAll("\\s|\\+|\\(|\\)|-", "");
    }
}
