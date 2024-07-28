package androidx.core.d;

import android.os.LocaleList;
import java.util.Locale;

final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f2861a;

    i(LocaleList localeList) {
        this.f2861a = localeList;
    }

    public final Object a() {
        return this.f2861a;
    }

    public final Locale a(int i2) {
        return this.f2861a.get(i2);
    }

    public final int b() {
        return this.f2861a.size();
    }

    public final boolean equals(Object obj) {
        return this.f2861a.equals(((h) obj).a());
    }

    public final int hashCode() {
        return this.f2861a.hashCode();
    }

    public final String toString() {
        return this.f2861a.toString();
    }
}
