package net.one97.paytm.upgradeKyc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f66317a = c.class.getSimpleName();

    public static String a(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        return new SimpleDateFormat("dd MMM yyyy", Locale.US).format(date);
    }

    public static Date b(String str) {
        try {
            return new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }
}
