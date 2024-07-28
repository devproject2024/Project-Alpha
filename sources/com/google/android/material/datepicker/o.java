package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import com.google.android.material.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

final class o {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference<n> f36261a = new AtomicReference<>();

    static Calendar b() {
        return b((Calendar) null);
    }

    static Calendar a(Calendar calendar) {
        Calendar b2 = b(calendar);
        Calendar b3 = b((Calendar) null);
        b3.set(b2.get(1), b2.get(2), b2.get(5));
        return b3;
    }

    private static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    private static java.text.DateFormat a(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return dateInstance;
    }

    static SimpleDateFormat c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String a(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
    }

    static DateFormat a(Locale locale) {
        return a("yMMMd", locale);
    }

    static DateFormat b(Locale locale) {
        return a("MMMd", locale);
    }

    static DateFormat c(Locale locale) {
        return a("MMMEd", locale);
    }

    static DateFormat d(Locale locale) {
        return a("yMMMEd", locale);
    }

    static java.text.DateFormat e(Locale locale) {
        return a(2, locale);
    }

    static java.text.DateFormat g(Locale locale) {
        return a(0, locale);
    }

    static SimpleDateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private static int a(String str, String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 < 0) {
                        break;
                    } else if (i3 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i3) == '\'');
            }
            i3 += i2;
        }
        return i3;
    }

    static Calendar a() {
        n nVar = f36261a.get();
        if (nVar == null) {
            nVar = n.a();
        }
        java.util.TimeZone timeZone = nVar.f36260b;
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        if (nVar.f36259a != null) {
            instance.setTimeInMillis(nVar.f36259a.longValue());
        }
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return instance;
    }

    private static Calendar b(Calendar calendar) {
        Calendar instance = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    static long a(long j) {
        Calendar b2 = b((Calendar) null);
        b2.setTimeInMillis(j);
        return a(b2).getTimeInMillis();
    }

    static java.text.DateFormat f(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) a(2, locale);
        String pattern = simpleDateFormat.toPattern();
        int a2 = a(pattern, "yY", 1, 0);
        if (a2 < pattern.length()) {
            String str = "EMd";
            int a3 = a(pattern, str, 1, a2);
            if (a3 < pattern.length()) {
                str = str + AppConstants.COMMA;
            }
            pattern = pattern.replace(pattern.substring(a(pattern, str, -1, a2) + 1, a3), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat;
    }
}
