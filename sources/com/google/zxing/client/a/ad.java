package com.google.zxing.client.a;

import com.google.zxing.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ad extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40001a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40002b = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean a(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f40001a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f40002b.matcher(str);
        if (!matcher2.find() || matcher2.start() != 0) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ q a(r rVar) {
        String b2 = b(rVar);
        if (b2.startsWith("URL:") || b2.startsWith("URI:")) {
            return new ac(b2.substring(4).trim(), (String) null);
        }
        String trim = b2.trim();
        if (a(trim)) {
            return new ac(trim, (String) null);
        }
        return null;
    }
}
