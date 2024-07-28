package com.paytmmall.clpartifact.common;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {
    private static long MILLISEC_DIFF;
    private static final SimpleDateFormat serverHeaderParser = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    private static final SimpleDateFormat timeParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);

    static {
        timeParser.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static void setServerTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MILLISEC_DIFF = System.currentTimeMillis() - serverHeaderParser.parse(str).getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static long currentMillisec() {
        return System.currentTimeMillis() - MILLISEC_DIFF;
    }

    public static long getTimeDiff(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        long millisec = getMillisec(str);
        if (millisec > 0) {
            return millisec - currentMillisec();
        }
        return 0;
    }

    public static long getMillisec(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return timeParser.parse(str).getTime();
        } catch (ParseException unused) {
            return 0;
        }
    }

    public static long getNextDayMillisec() {
        return dayAfter(1);
    }

    public static long dayAfter(int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        gregorianCalendar.add(5, i2);
        return gregorianCalendar.getTimeInMillis();
    }

    public static String getDay(String str) {
        long millisec = getMillisec(str);
        if (millisec <= 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(millisec);
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(instance.getTime());
    }

    public static String getTime(String str) {
        return getTime(str, "hh:mm aa");
    }

    public static String getTime(String str, String str2) {
        long millisec = getMillisec(str);
        if (millisec <= 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(millisec);
        return new SimpleDateFormat(str2, Locale.ENGLISH).format(instance.getTime());
    }
}
