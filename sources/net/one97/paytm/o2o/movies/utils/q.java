package net.one97.paytm.o2o.movies.utils;

import com.paytm.utility.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class q {
    public static String a(String str, String str2) {
        return a(b(c(str, str2), str2));
    }

    private static String a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i2 = instance.get(5);
        if (i2 > 10 && i2 < 19) {
            return new SimpleDateFormat("h:mm a EEE, d'th' MMM yy").format(date);
        }
        int i3 = i2 % 10;
        if (i3 == 1) {
            return new SimpleDateFormat("h:mm a EEE, d'st' MMM yy").format(date);
        }
        if (i3 == 2) {
            return new SimpleDateFormat("h:mm a EEE, d'nd' MMM yy").format(date);
        }
        if (i3 != 3) {
            return new SimpleDateFormat("h:mm a EEE, d'th' MMM yy").format(date);
        }
        return new SimpleDateFormat("h:mm a EEE, d'rd' MMM yy").format(date);
    }

    private static Date b(String str, String str2) {
        Date date = new Date();
        try {
            return new SimpleDateFormat(str2, new Locale(n.a())).parse(str);
        } catch (Exception e2) {
            new StringBuilder("Exception : ").append(e2.getStackTrace().toString());
            return date;
        }
    }

    private static String c(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat2.format(parse);
        } catch (Exception unused) {
            return "";
        }
    }
}
