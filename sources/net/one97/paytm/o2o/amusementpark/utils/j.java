package net.one97.paytm.o2o.amusementpark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class j {
    public static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }
}
