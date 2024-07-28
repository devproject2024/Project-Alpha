package com.google.zxing.client.android.c;

import android.app.Activity;
import com.google.zxing.client.a.g;
import com.google.zxing.client.a.q;
import com.google.zxing.client.android.R;
import java.text.DateFormat;
import java.util.Date;

public final class b extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final String f40169i = b.class.getSimpleName();
    private static final int[] j = {R.string.button_add_calendar};

    public b(Activity activity, q qVar) {
        super(activity, qVar);
    }

    private static String a(boolean z, Date date) {
        DateFormat dateFormat;
        if (z) {
            dateFormat = DateFormat.getDateInstance(2);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateFormat.format(date);
    }

    public final CharSequence a() {
        g gVar = (g) this.f40181g;
        StringBuilder sb = new StringBuilder(100);
        q.a(gVar.f40040a, sb);
        Date date = new Date(gVar.f40041b);
        q.a(a(gVar.f40042c, date), sb);
        Date date2 = gVar.f40043d < 0 ? null : new Date(gVar.f40043d);
        if (date2 != null) {
            q.a(a(gVar.f40044e, (!gVar.f40044e || date.equals(date2)) ? date2 : new Date(date2.getTime() - 86400000)), sb);
        }
        q.a(gVar.f40045f, sb);
        q.a(gVar.f40046g, sb);
        q.a(gVar.f40047h, sb);
        q.a(gVar.f40048i, sb);
        return sb.toString();
    }
}
