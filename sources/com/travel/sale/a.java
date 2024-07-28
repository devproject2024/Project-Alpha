package com.travel.sale;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.CalendarContract;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.TimeZone;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f25714a = "Paytm";

    /* renamed from: b  reason: collision with root package name */
    private String f25715b = "Paytm";

    /* renamed from: c  reason: collision with root package name */
    private String f25716c = "Paytm";

    /* renamed from: d  reason: collision with root package name */
    private String f25717d = "Paytm";

    /* renamed from: e  reason: collision with root package name */
    private String f25718e = "Paytm";

    /* renamed from: f  reason: collision with root package name */
    private String f25719f = "1";

    /* renamed from: g  reason: collision with root package name */
    private String f25720g = "1";

    /* renamed from: h  reason: collision with root package name */
    private int f25721h = 15;

    public final void a(Context context, String str, String str2, long j, long j2) {
        String lastPathSegment;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        k.c(context2, "context");
        k.c(str3, "eventTitle");
        k.c(str4, "eventDescription");
        String a2 = a(context);
        CharSequence charSequence = a2;
        if (charSequence == null || charSequence.length() == 0) {
            k.c(context2, "context");
            ContentValues contentValues = new ContentValues();
            contentValues.put("account_name", this.f25714a);
            contentValues.put(UpiConstants.EXTRA_ACCOUNT_TYPE, this.f25715b);
            contentValues.put("name", this.f25715b);
            contentValues.put("calendar_displayName", this.f25717d);
            contentValues.put("ownerAccount", this.f25718e);
            contentValues.put("sync_events", this.f25719f);
            contentValues.put("calendar_access_level", 700);
            ContentResolver contentResolver = context.getContentResolver();
            k.a((Object) contentResolver, "context.getContentResolver()");
            Uri uri = CalendarContract.Calendars.CONTENT_URI;
            k.a((Object) uri, "CalendarContract.Calendars.CONTENT_URI");
            String str5 = this.f25715b;
            k.c(uri, "uri");
            Uri build = uri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", str5).appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, str5).build();
            if (build != null) {
                String.valueOf(contentResolver.insert(build, contentValues));
            }
            a2 = a(context);
        }
        k.c(context2, "context");
        k.c(str3, "eventTitle");
        k.c(str4, "eventDescription");
        CharSequence charSequence2 = a2;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("calendar_id", a2);
            contentValues2.put("title", str3);
            contentValues2.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, str4);
            contentValues2.put("dtstart", Long.valueOf(j));
            contentValues2.put("dtend", Long.valueOf(j2));
            TimeZone timeZone = TimeZone.getDefault();
            k.a((Object) timeZone, "TimeZone.getDefault()");
            contentValues2.put("eventTimezone", timeZone.getID());
            contentValues2.put("hasAlarm", Boolean.TRUE);
            ContentResolver contentResolver2 = context.getContentResolver();
            k.a((Object) contentResolver2, "context.getContentResolver()");
            Uri insert = contentResolver2.insert(CalendarContract.Events.CONTENT_URI, contentValues2);
            Long valueOf = (insert == null || (lastPathSegment = insert.getLastPathSegment()) == null) ? null : Long.valueOf(Long.parseLong(lastPathSegment));
            if (valueOf != null) {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", valueOf);
                contentValues3.put("minutes", Integer.valueOf(this.f25721h));
                contentValues3.put("method", 1);
                contentResolver2.insert(CalendarContract.Reminders.CONTENT_URI, contentValues3);
            }
        }
    }

    private String a(Context context) {
        k.c(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        k.a((Object) contentResolver, "context.getContentResolver()");
        Cursor query = contentResolver.query(CalendarContract.Calendars.CONTENT_URI, new String[]{"name", "calendar_displayName", "calendar_color", "visible", "ownerAccount", "_id"}, "ownerAccount=?", new String[]{this.f25718e}, (String) null, (CancellationSignal) null);
        String str = "";
        while (true) {
            if (query == null) {
                k.a();
            }
            if (!query.moveToNext()) {
                return str;
            }
            str = query.getString(5);
            k.a((Object) str, "cursor.getString(5)");
        }
    }
}
