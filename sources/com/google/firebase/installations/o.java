package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.a.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final long f38985a = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f38986b = Pattern.compile("\\AA[\\w-]{38}\\z");

    o() {
    }

    public static boolean a(d dVar) {
        if (!TextUtils.isEmpty(dVar.c()) && dVar.f() + dVar.e() >= a() + f38985a) {
            return false;
        }
        return true;
    }

    public static long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    static boolean a(String str) {
        return str.contains(AppConstants.COLON);
    }

    static boolean b(String str) {
        return f38986b.matcher(str).matches();
    }
}
