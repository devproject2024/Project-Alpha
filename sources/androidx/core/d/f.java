package androidx.core.d;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f2853a = a(new Locale[0]);

    /* renamed from: b  reason: collision with root package name */
    private h f2854b;

    private f(h hVar) {
        this.f2854b = hVar;
    }

    public static f a(LocaleList localeList) {
        return new f(new i(localeList));
    }

    public static f a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a(new LocaleList(localeArr));
        }
        return new f(new g(localeArr));
    }

    public final Locale a(int i2) {
        return this.f2854b.a(i2);
    }

    public final int a() {
        return this.f2854b.b();
    }

    static Locale a(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && this.f2854b.equals(((f) obj).f2854b);
    }

    public final int hashCode() {
        return this.f2854b.hashCode();
    }

    public final String toString() {
        return this.f2854b.toString();
    }
}
