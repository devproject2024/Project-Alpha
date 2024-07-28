package com.travel.bus.busticket.i;

import android.app.Activity;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class r {
    public static String a(Activity activity, String str, String str2, String str3) {
        try {
            Locale locale = Locale.ENGLISH;
            return new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, locale).parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            o.a(activity);
            return "";
        } catch (Exception e3) {
            q.c(e3.getMessage());
            o.a(activity);
            return "";
        }
    }
}
