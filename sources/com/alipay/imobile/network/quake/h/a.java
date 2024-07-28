package com.alipay.imobile.network.quake.h;

import com.alipay.imobile.network.quake.i.g;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f14827a = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(g.f14903a);
            return simpleDateFormat;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f14828b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* renamed from: c  reason: collision with root package name */
    private static final DateFormat[] f14829c = new DateFormat[15];

    public static String a(Date date) {
        return f14827a.get().format(date);
    }

    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f14827a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f14828b) {
            int length = f14828b.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat dateFormat = f14829c[i2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f14828b[i2], Locale.US);
                    dateFormat.setTimeZone(g.f14903a);
                    f14829c[i2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }
}
