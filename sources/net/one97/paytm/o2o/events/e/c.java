package net.one97.paytm.o2o.events.e;

import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f73766a = c.class.getSimpleName();

    public static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static String a(Date date) {
        if (date != null) {
            return new SimpleDateFormat("EEE").format(date);
        }
        return null;
    }

    public static String b(Date date) {
        if (date != null) {
            return new SimpleDateFormat("MMM").format(date);
        }
        return null;
    }

    public static String c(Date date) {
        if (date != null) {
            return new SimpleDateFormat("d").format(date);
        }
        return null;
    }

    public static String a(String str, Locale locale) {
        try {
            return new SimpleDateFormat("h:mm a", locale).format(new SimpleDateFormat("HH:mm:ss", locale).parse(str));
        } catch (ParseException unused) {
            q.c("Parse exception");
            return null;
        }
    }
}
