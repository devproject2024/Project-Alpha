package com.google.zxing.client.a;

import com.alipay.mobile.nebula.filecache.FileCache;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g extends q {
    private static final Pattern j = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] k = {FileCache.EXPIRE_TIME, 86400000, 3600000, 60000, 1000};
    private static final Pattern l = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: a  reason: collision with root package name */
    public final String f40040a;

    /* renamed from: b  reason: collision with root package name */
    public final long f40041b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40042c;

    /* renamed from: d  reason: collision with root package name */
    public final long f40043d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f40044e;

    /* renamed from: f  reason: collision with root package name */
    public final String f40045f;

    /* renamed from: g  reason: collision with root package name */
    public final String f40046g;

    /* renamed from: h  reason: collision with root package name */
    public final String[] f40047h;

    /* renamed from: i  reason: collision with root package name */
    public final String f40048i;
    private final double m;
    private final double n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(r.CALENDAR);
        long j2;
        this.f40040a = str;
        try {
            this.f40041b = a(str2);
            if (str3 == null) {
                long a2 = a((CharSequence) str4);
                if (a2 < 0) {
                    j2 = -1;
                } else {
                    j2 = a2 + this.f40041b;
                }
                this.f40043d = j2;
            } else {
                try {
                    this.f40043d = a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = false;
            this.f40042c = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.f40044e = z;
            this.f40045f = str5;
            this.f40046g = str6;
            this.f40047h = strArr;
            this.f40048i = str7;
            this.m = d2;
            this.n = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f40040a, sb);
        a(a(this.f40042c, this.f40041b), sb);
        a(a(this.f40044e, this.f40043d), sb);
        a(this.f40045f, sb);
        a(this.f40046g, sb);
        a(this.f40047h, sb);
        a(this.f40048i, sb);
        return sb.toString();
    }

    private static long a(String str) throws ParseException {
        if (!l.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } else if (str.length() != 16 || str.charAt(15) != 'Z') {
            return b(str);
        } else {
            long b2 = b(str.substring(0, 15));
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            long j2 = b2 + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(j2));
            return j2 + ((long) gregorianCalendar.get(16));
        }
    }

    private static String a(boolean z, long j2) {
        DateFormat dateFormat;
        if (j2 < 0) {
            return null;
        }
        if (z) {
            dateFormat = DateFormat.getDateInstance(2);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateFormat.format(Long.valueOf(j2));
    }

    private static long a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        Matcher matcher = j.matcher(charSequence);
        if (!matcher.matches()) {
            return -1;
        }
        long j2 = 0;
        int i2 = 0;
        while (i2 < k.length) {
            int i3 = i2 + 1;
            String group = matcher.group(i3);
            if (group != null) {
                j2 += k[i2] * ((long) Integer.parseInt(group));
            }
            i2 = i3;
        }
        return j2;
    }

    private static long b(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }
}
