package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f8256c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static b f8257d;

    /* renamed from: a  reason: collision with root package name */
    final Lock f8258a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    final SharedPreferences f8259b;

    public static b a(Context context) {
        s.a(context);
        f8256c.lock();
        try {
            if (f8257d == null) {
                f8257d = new b(context.getApplicationContext());
            }
            return f8257d;
        } finally {
            f8256c.unlock();
        }
    }

    private b(Context context) {
        this.f8259b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        this.f8258a.lock();
        try {
            this.f8259b.edit().putString(str, str2).apply();
        } finally {
            this.f8258a.unlock();
        }
    }

    public final GoogleSignInAccount a() {
        return b(a("defaultGoogleSignInAccount"));
    }

    private final GoogleSignInAccount b(String str) {
        String a2;
        if (!TextUtils.isEmpty(str) && (a2 = a(b("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.a(a2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final GoogleSignInOptions b() {
        return c(a("defaultGoogleSignInAccount"));
    }

    private final GoogleSignInOptions c(String str) {
        String a2;
        if (!TextUtils.isEmpty(str) && (a2 = a(b("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.a(a2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        this.f8258a.lock();
        try {
            return this.f8259b.getString(str, (String) null);
        } finally {
            this.f8258a.unlock();
        }
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(AppConstants.COLON);
        sb.append(str2);
        return sb.toString();
    }
}
