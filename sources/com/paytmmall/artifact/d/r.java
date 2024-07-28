package com.paytmmall.artifact.d;

import android.content.Context;
import java.util.Locale;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static String f15735a = "LocaleHelper";

    public static int a() {
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

    private static String a(Context context, String str) {
        try {
            return u.a(context.getApplicationContext()).b("Locale.Helper.Selected.Language", str, false);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(Context context) {
        String language = Locale.getDefault().getLanguage();
        if (!language.equalsIgnoreCase("en") && !language.equalsIgnoreCase("hi") && !language.equalsIgnoreCase("ta") && !language.equalsIgnoreCase("te") && !language.equalsIgnoreCase("kn") && !language.equalsIgnoreCase("pa") && !language.equalsIgnoreCase("mr") && !language.equalsIgnoreCase("gu") && !language.equalsIgnoreCase("bn") && !language.equalsIgnoreCase("ml") && !language.equalsIgnoreCase("or")) {
            language = "en";
        }
        return a(context, language);
    }
}
