package com.travel.citybus.best.e;

import android.text.InputFilter;
import android.text.Spanned;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f23051a = new c();

    private c() {
    }

    public static InputFilter a() {
        return a.f23052a;
    }

    public static String a(String str, long j) {
        k.c(str, "format");
        try {
            String format = new SimpleDateFormat(str).format(new Date(j));
            k.a((Object) format, "inputFormat.format(date)");
            return format;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            k.a((Object) parse, "inputFormat.parse(inputString)");
            DateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(parse);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(long j) {
        String str;
        String str2;
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 % 60;
        String str3 = "00";
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i2 == 0) {
            str = str3;
        } else if (j3 < 10) {
            str = "0".concat(String.valueOf(j3));
        } else {
            str = String.valueOf(j3);
        }
        int i3 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i3 == 0) {
            str2 = str3;
        } else if (j4 < 10) {
            str2 = "0".concat(String.valueOf(j4));
        } else {
            str2 = String.valueOf(j4);
        }
        if (j5 != 0) {
            if (j5 < 10) {
                str3 = "0".concat(String.valueOf(j5));
            } else {
                str3 = String.valueOf(j5);
            }
        }
        if (i2 > 0) {
            return str + ':' + str2 + ':' + str3;
        } else if (i3 <= 0) {
            return "00:00:".concat(String.valueOf(str3));
        } else {
            return "00:" + j4 + ':' + str3;
        }
    }

    static final class a implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23052a = new a();

        a() {
        }

        public final /* synthetic */ CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            String str;
            while (true) {
                if (i2 >= i3) {
                    str = null;
                    break;
                } else if (!Pattern.compile("[1234567890]*").matcher(String.valueOf(charSequence.charAt(i2))).matches()) {
                    str = "";
                    break;
                } else {
                    i2++;
                }
            }
            return str;
        }
    }
}
