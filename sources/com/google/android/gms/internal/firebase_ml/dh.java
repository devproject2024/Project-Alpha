package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.util.n;
import java.util.Locale;

public final class dh {

    /* renamed from: a  reason: collision with root package name */
    private static final j f9798a = new j("CommonUtils", "");

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            j jVar = f9798a;
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Exception thrown when trying to get app version ");
            sb.append(valueOf);
            jVar.c(sb.toString());
            return "";
        }
    }

    static String a(Locale locale) {
        if (n.d()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb.append("-");
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }
}
