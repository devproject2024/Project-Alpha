package com.travel.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f28553a = new s();

    private s() {
    }

    public static boolean a(String str) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context, double d2, double d3, String str) {
        k.c(context, "context");
        k.c(str, "name");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + d2 + ',' + d3 + '(' + str + ')')));
        } catch (Exception unused) {
        }
    }

    public static boolean a(String str, String str2) {
        boolean z;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "Calendar.getInstance()");
            String format = simpleDateFormat.format(instance.getTime());
            if (parse.equals(format)) {
                z = parse2.after(parse);
            } else if (parse.before(simpleDateFormat.parse(format))) {
                return false;
            } else {
                z = parse2.after(parse);
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b(String str) {
        k.c(str, "dateFormate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "calendar");
        String format = simpleDateFormat.format(instance.getTime());
        k.a((Object) format, "mDateFormat.format(calendar.time)");
        return format;
    }

    public static String c(String str) {
        k.c(str, "dateFormate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        k.a((Object) instance, "calendar");
        String format = simpleDateFormat.format(instance.getTime());
        k.a((Object) format, "mDateFormat.format(calendar.time)");
        return format;
    }
}
