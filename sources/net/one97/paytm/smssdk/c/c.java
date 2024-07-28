package net.one97.paytm.smssdk.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.smssdk.b;
import net.one97.paytm.smssdk.model.Payload;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f65075a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f65076b = Uri.parse("content://sms/inbox");

    private c() {
    }

    public static List<Payload> a(Context context, long j, long j2) {
        k.c(context, "context");
        if (j == 0) {
            Calendar instance = Calendar.getInstance();
            b bVar = b.f65064b;
            Integer num = b.a().f65050g;
            if (num == null) {
                k.a();
            }
            instance.add(13, -num.intValue());
            k.a((Object) instance, "c");
            j = instance.getTimeInMillis();
        }
        q.d(" startTimeSync : " + j + " endTimeSync : " + j2);
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(f65076b, (String[]) null, "date>" + j + " and date<=" + j2, (String[]) null, "date ASC");
        int i2 = 0;
        while (true) {
            Boolean valueOf = query != null ? Boolean.valueOf(query.moveToNext()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                String string = query.getString(query.getColumnIndex("_id"));
                String string2 = query.getString(query.getColumnIndex(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS));
                b bVar2 = b.f65074a;
                k.a((Object) string2, "phoneNumber");
                b bVar3 = b.f65064b;
                String str = b.a().f65045b;
                if (str == null) {
                    k.a();
                }
                if (b.a(string2, str) && string2.length() < 10) {
                    String string3 = query.getString(query.getColumnIndex("body"));
                    b bVar4 = b.f65074a;
                    k.a((Object) string3, "smsBody");
                    b bVar5 = b.f65064b;
                    String str2 = b.a().f65048e;
                    if (str2 == null) {
                        k.a();
                    }
                    if (!b.a(string3, str2)) {
                        Calendar instance2 = Calendar.getInstance();
                        String string4 = query.getString(query.getColumnIndex(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
                        k.a((Object) string4, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                        long parseLong = Long.parseLong(string4);
                        k.a((Object) instance2, "calendar");
                        instance2.setTimeInMillis(parseLong);
                        String date = instance2.getTime().toString();
                        k.a((Object) date, "finaldate.toString()");
                        arrayList.add(new Payload(string3, parseLong, string2));
                        StringBuilder sb = new StringBuilder("count : ");
                        i2++;
                        sb.append(i2);
                        sb.append(" _id ");
                        sb.append(string);
                        sb.append(" From : ");
                        sb.append(string2);
                        sb.append("\n Sms Date: ");
                        sb.append(date);
                        sb.append("\n Sms timeStamp : ");
                        sb.append(date);
                        sb.append("\nMessage : ");
                        sb.append(string3);
                        sb.append(StringUtility.NEW_LINE);
                        q.d(sb.toString());
                    }
                }
            } else {
                query.close();
                return arrayList;
            }
        }
    }
}
