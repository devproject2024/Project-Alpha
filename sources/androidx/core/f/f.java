package androidx.core.f;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f2961a = new Locale("", "");

    public static int a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f2961a)) {
            String a2 = b.a(locale);
            if (a2 == null) {
                byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
                if (directionality == 1 || directionality == 2) {
                    return 1;
                }
                return 0;
            } else if (a2.equalsIgnoreCase("Arab") || a2.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }
}
