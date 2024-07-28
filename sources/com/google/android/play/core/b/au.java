package com.google.android.play.core.b;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class au {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37273a;

    public au(Context context) {
        this.f37273a = context;
    }

    private static String a(Locale locale) {
        String str;
        String valueOf = String.valueOf(locale.getLanguage());
        if (!locale.getCountry().isEmpty()) {
            String valueOf2 = String.valueOf(locale.getCountry());
            str = valueOf2.length() == 0 ? new String("_") : "_".concat(valueOf2);
        } else {
            str = "";
        }
        String valueOf3 = String.valueOf(str);
        return valueOf3.length() == 0 ? new String(valueOf) : valueOf.concat(valueOf3);
    }

    public final List<String> a() {
        Configuration configuration = this.f37273a.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 24) {
            return Collections.singletonList(a(configuration.locale));
        }
        LocaleList locales = configuration.getLocales();
        ArrayList arrayList = new ArrayList(locales.size());
        for (int i2 = 0; i2 < locales.size(); i2++) {
            arrayList.add(a(locales.get(i2)));
        }
        return arrayList;
    }
}
