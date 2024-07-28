package com.travel.utils;

import android.app.Activity;
import android.content.Context;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.travel.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f28525a = "CalenderUtils";

    public static String a(Activity activity, String str, String str2, String str3) {
        try {
            Locale locale = Locale.ENGLISH;
            return new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, locale).parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            b.a(activity, "net.one97.paytm.landingpage.activity.AJRMainActivity");
            return "";
        } catch (Exception e3) {
            q.c(e3.getMessage());
            b.a(activity, "net.one97.paytm.landingpage.activity.AJRMainActivity");
            return "";
        }
    }

    public static long a(Date date, Date date2, TimeUnit timeUnit) {
        return timeUnit.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS);
    }

    public static Date a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(6, -60);
        return instance.getTime();
    }

    public static boolean a(Activity activity, Date date) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.add(1, 1);
            if (date.compareTo(instance.getTime()) == 0) {
                b.b((Context) activity, activity.getResources().getString(R.string.error), activity.getResources().getString(R.string.select_other_check_in_date));
                return false;
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
        return true;
    }

    public static Date a(Date date, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, i2);
        return new Date(instance.getTimeInMillis());
    }

    public static final String b(Date date) {
        String str;
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i2 = instance.get(5);
        if (i2 < 11 || i2 > 13) {
            int i3 = i2 % 10;
            if (i3 == 1) {
                str = H5Param.SHOW_TITLEBAR;
            } else if (i3 == 2) {
                str = "nd";
            } else if (i3 == 3) {
                str = "rd";
            }
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date);
            return v.a(String.valueOf(i2), str, " ", instance2.getDisplayName(2, 2, Locale.getDefault()));
        }
        str = "th";
        Calendar instance22 = Calendar.getInstance();
        instance22.setTime(date);
        return v.a(String.valueOf(i2), str, " ", instance22.getDisplayName(2, 2, Locale.getDefault()));
    }
}
