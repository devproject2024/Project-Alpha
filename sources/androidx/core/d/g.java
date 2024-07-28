package androidx.core.d;

import java.util.HashSet;
import java.util.Locale;

final class g implements h {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f2855c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f2856d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f2857e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f2858f = f.a("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f2859a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2860b;

    public final Object a() {
        return null;
    }

    public final Locale a(int i2) {
        if (i2 < 0) {
            return null;
        }
        Locale[] localeArr = this.f2859a;
        if (i2 < localeArr.length) {
            return localeArr[i2];
        }
        return null;
    }

    public final int b() {
        return this.f2859a.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Locale[] localeArr = ((g) obj).f2859a;
        if (this.f2859a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f2859a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f2859a;
            if (i3 >= localeArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + localeArr[i3].hashCode();
            i3++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2859a;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.f2859a.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    g(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2859a = f2855c;
            this.f2860b = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < localeArr.length) {
            Locale locale = localeArr[i2];
            if (locale == null) {
                throw new NullPointerException("list[" + i2 + "] is null");
            } else if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i2] = locale2;
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append('-');
                    sb.append(locale2.getCountry());
                }
                if (i2 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
                i2++;
            } else {
                throw new IllegalArgumentException("list[" + i2 + "] is a repetition");
            }
        }
        this.f2859a = localeArr2;
        this.f2860b = sb.toString();
    }
}
