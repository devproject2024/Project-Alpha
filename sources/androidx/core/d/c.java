package androidx.core.d;

import android.content.res.Configuration;
import android.os.Build;

public final class c {
    public static f a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return f.a(configuration.getLocales());
        }
        return f.a(configuration.locale);
    }
}
