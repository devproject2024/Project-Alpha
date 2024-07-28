package com.google.zxing.client.android;

import android.content.Context;
import android.preference.PreferenceManager;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f40258a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, String> f40259b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f40260c = f40258a;

    /* renamed from: d  reason: collision with root package name */
    private static final Collection<String> f40261d = Arrays.asList(new String[]{"de", "en", H5Param.ENABLE_SCROLLBAR, "fr", "it", "ja", "ko", "nl", "pt", "ru", "uk", "zh-rCN", "zh-rTW", "zh-rHK"});

    static {
        HashMap hashMap = new HashMap();
        f40258a = hashMap;
        hashMap.put("AR", "com.ar");
        f40258a.put("AU", "com.au");
        f40258a.put("BR", "com.br");
        f40258a.put("BG", "bg");
        f40258a.put(Locale.CANADA.getCountry(), "ca");
        f40258a.put(Locale.CHINA.getCountry(), "cn");
        f40258a.put("CZ", "cz");
        f40258a.put("DK", "dk");
        f40258a.put("FI", "fi");
        f40258a.put(Locale.FRANCE.getCountry(), "fr");
        f40258a.put(Locale.GERMANY.getCountry(), "de");
        f40258a.put("GR", "gr");
        f40258a.put("HU", "hu");
        f40258a.put("ID", "co.id");
        f40258a.put("IL", "co.il");
        f40258a.put(Locale.ITALY.getCountry(), "it");
        f40258a.put(Locale.JAPAN.getCountry(), "co.jp");
        f40258a.put(Locale.KOREA.getCountry(), "co.kr");
        f40258a.put("NL", "nl");
        f40258a.put("PL", H5Param.PREFETCH_LOCATION);
        f40258a.put("PT", "pt");
        f40258a.put("RO", "ro");
        f40258a.put("RU", "ru");
        f40258a.put("SK", "sk");
        f40258a.put("SI", "si");
        f40258a.put("ES", H5Param.ENABLE_SCROLLBAR);
        f40258a.put("SE", "se");
        f40258a.put("CH", "ch");
        f40258a.put(Locale.TAIWAN.getCountry(), "tw");
        f40258a.put("TR", "com.tr");
        f40258a.put("UA", "com.ua");
        f40258a.put(Locale.UK.getCountry(), "co.uk");
        f40258a.put(Locale.US.getCountry(), "com");
        HashMap hashMap2 = new HashMap();
        f40259b = hashMap2;
        hashMap2.put("AU", "com.au");
        f40259b.put(Locale.FRANCE.getCountry(), "fr");
        f40259b.put(Locale.GERMANY.getCountry(), "de");
        f40259b.put(Locale.ITALY.getCountry(), "it");
        f40259b.put(Locale.JAPAN.getCountry(), "co.jp");
        f40259b.put("NL", "nl");
        f40259b.put("ES", H5Param.ENABLE_SCROLLBAR);
        f40259b.put("CH", "ch");
        f40259b.put(Locale.UK.getCountry(), "co.uk");
        f40259b.put(Locale.US.getCountry(), "com");
    }

    public static String a(Context context) {
        Map<String, String> map = f40260c;
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("preferences_search_country", "-");
        if (string == null || string.isEmpty() || "-".equals(string)) {
            string = b();
        }
        String str = map.get(string);
        return str == null ? "com" : str;
    }

    public static boolean a(String str) {
        return str.startsWith("http://google.com/books") || str.startsWith("http://books.google.");
    }

    private static String b() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return "US";
        }
        return locale.getCountry();
    }

    public static String a() {
        String str;
        Locale locale = Locale.getDefault();
        if (locale == null) {
            str = "en";
        } else {
            str = locale.getLanguage();
            if (Locale.SIMPLIFIED_CHINESE.getLanguage().equals(str)) {
                str = str + "-r" + b();
            }
        }
        if (f40261d.contains(str)) {
            return str;
        }
        return "en";
    }
}
