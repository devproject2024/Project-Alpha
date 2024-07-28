package com.travel.flight.utils;

import android.app.Activity;
import android.text.TextUtils;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import net.one97.paytmflight.a.a;

public final class e {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(str.trim());
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    public static String a(Activity activity, Locale locale, String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, locale).parse(str));
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            a.a(activity);
            return "";
        } catch (Exception e3) {
            q.b(e3.getMessage());
            a.a(activity);
            return "";
        }
    }
}
