package com.paytm.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class n {
    public static String a(Context context) {
        return a(context, a());
    }

    public static String a() {
        String language = Locale.getDefault().getLanguage();
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("hi") || language.equalsIgnoreCase("ta") || language.equalsIgnoreCase("te") || language.equalsIgnoreCase("kn") || language.equalsIgnoreCase("pa") || language.equalsIgnoreCase("mr") || language.equalsIgnoreCase("gu") || language.equalsIgnoreCase("bn") || language.equalsIgnoreCase("ml") || language.equalsIgnoreCase("or")) {
            return language;
        }
        return "en";
    }

    public static int b() {
        String language = Locale.getDefault().getLanguage();
        if (language.equalsIgnoreCase("en")) {
            return 1;
        }
        if (language.equalsIgnoreCase("hi")) {
            return 2;
        }
        if (language.equalsIgnoreCase("ta")) {
            return 8;
        }
        if (language.equalsIgnoreCase("te")) {
            return 9;
        }
        if (language.equalsIgnoreCase("kn")) {
            return 7;
        }
        if (language.equalsIgnoreCase("pa")) {
            return 11;
        }
        if (language.equalsIgnoreCase("mr")) {
            return 5;
        }
        if (language.equalsIgnoreCase("gu")) {
            return 10;
        }
        if (language.equalsIgnoreCase("bn")) {
            return 3;
        }
        if (language.equalsIgnoreCase("ml")) {
            return 6;
        }
        if (language.equalsIgnoreCase("or")) {
            return 4;
        }
        return 1;
    }

    public static String a(Context context, String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getString("Locale.Helper.Selected.Language", str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static int a(Context context, int i2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getInt("Locale.Helper.Selected.Language.Id", i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static void b(Context context, String str) {
        d(context, str);
        e(context, str);
    }

    private static void d(Context context, String str) {
        try {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString("Locale.Helper.Selected.Language", str);
            edit.apply();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private static void e(Context context, String str) {
        Locale locale;
        try {
            if (TextUtils.isEmpty(str) || !str.equals("en")) {
                locale = new Locale(str);
            } else {
                locale = new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
            }
            Locale.setDefault(locale);
            Resources resources = context.getApplicationContext().getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static String c(Context context, String str) {
        if (str.equals("en")) {
            return context.getString(R.string.english_in_locale);
        }
        if (str.equals("hi")) {
            return context.getString(R.string.hindi_in_locale);
        }
        if (str.equals("bn")) {
            return context.getString(R.string.bengali_in_locale);
        }
        if (str.equals("or")) {
            return context.getString(R.string.odia_in_locale);
        }
        if (str.equals("ta")) {
            return context.getString(R.string.tamil_in_locale);
        }
        if (str.equals("te")) {
            return context.getString(R.string.telugu_in_locale);
        }
        if (str.equals("ml")) {
            return context.getString(R.string.malayalam_in_locale);
        }
        if (str.equals("kn")) {
            return context.getString(R.string.kannada_in_locale);
        }
        if (str.equals("mr")) {
            return context.getString(R.string.marathi_in_locale);
        }
        if (str.equals("pa")) {
            return context.getString(R.string.punjabi_in_locale);
        }
        if (str.equals("gu")) {
            return context.getString(R.string.gujarati_in_locale);
        }
        return context.getString(R.string.english_in_locale);
    }
}
