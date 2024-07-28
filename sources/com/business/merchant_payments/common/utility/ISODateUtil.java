package com.business.merchant_payments.common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ISODateUtil {
    public static final SimpleDateFormat ALT_ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

    public static long parseIso8601(String str) throws ParseException {
        if (str != null) {
            try {
                return ISO_DATE_FORMAT.parse(str).getTime();
            } catch (ParseException unused) {
                return ALT_ISO_DATE_FORMAT.parse(str).getTime();
            }
        } else {
            throw new ParseException("Unable to parse null timestamp", -1);
        }
    }

    public static long parseIso8601(String str, long j) {
        try {
            return parseIso8601(str);
        } catch (ParseException unused) {
            return j;
        }
    }

    public static String createIso8601TimeStamp(long j) {
        return ISO_DATE_FORMAT.format(new Date(j));
    }

    static {
        ISO_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        ALT_ISO_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
    }
}
