package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.core.content.b;
import com.google.android.gms.common.util.e;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class i extends fw {

    /* renamed from: a  reason: collision with root package name */
    long f12163a;

    /* renamed from: b  reason: collision with root package name */
    private long f12164b;

    /* renamed from: c  reason: collision with root package name */
    private String f12165c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f12166d;

    /* renamed from: e  reason: collision with root package name */
    private AccountManager f12167e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f12168f;

    i(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        Calendar instance = Calendar.getInstance();
        this.f12164b = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f12165c = sb.toString();
        return false;
    }

    public final long N_() {
        w();
        return this.f12164b;
    }

    public final String c() {
        w();
        return this.f12165c;
    }

    public final boolean a(Context context) {
        if (this.f12166d == null) {
            this.f12166d = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f12166d = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f12166d.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        h();
        this.f12168f = null;
        this.f12163a = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        h();
        long a2 = j().a();
        if (a2 - this.f12163a > 86400000) {
            this.f12168f = null;
        }
        Boolean bool = this.f12168f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (b.a(k(), "android.permission.GET_ACCOUNTS") != 0) {
            J_().f11832g.a("Permission error checking for dasher/unicorn accounts");
            this.f12163a = a2;
            this.f12168f = Boolean.FALSE;
            return false;
        }
        if (this.f12167e == null) {
            this.f12167e = AccountManager.get(k());
        }
        try {
            Account[] result = this.f12167e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.f12167e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.f12168f = Boolean.TRUE;
                    this.f12163a = a2;
                    return true;
                }
                this.f12163a = a2;
                this.f12168f = Boolean.FALSE;
                return false;
            }
            this.f12168f = Boolean.TRUE;
            this.f12163a = a2;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            J_().f11829d.a("Exception checking account types", e2);
        }
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
