package androidx.core.f;

import android.icu.util.ULocale;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2933a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2934b;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2933a = cls.getMethod("getScript", new Class[]{String.class});
                    f2934b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
                }
            } catch (Exception unused) {
                f2933a = null;
                f2934b = null;
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            try {
                f2934b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f2934b.invoke((Object) null, new Object[]{locale})).getScript();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return locale.getScript();
            }
        } else {
            String b2 = b(locale);
            if (b2 != null) {
                return a(b2);
            }
            return null;
        }
    }

    private static String a(String str) {
        try {
            if (f2933a != null) {
                return (String) f2933a.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f2934b != null) {
                return (String) f2934b.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return locale2;
    }
}
