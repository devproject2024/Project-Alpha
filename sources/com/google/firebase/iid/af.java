package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.util.n;
import com.google.firebase.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38794a;

    /* renamed from: b  reason: collision with root package name */
    private String f38795b;

    /* renamed from: c  reason: collision with root package name */
    private String f38796c;

    /* renamed from: d  reason: collision with root package name */
    private int f38797d;

    /* renamed from: e  reason: collision with root package name */
    private int f38798e = 0;

    public af(Context context) {
        this.f38794a = context;
    }

    public final boolean a() {
        return b() != 0;
    }

    public final synchronized int b() {
        if (this.f38798e != 0) {
            return this.f38798e;
        }
        PackageManager packageManager = this.f38794a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        if (!n.f()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f38798e = 1;
                return this.f38798e;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            if (n.f()) {
                this.f38798e = 2;
            } else {
                this.f38798e = 1;
            }
            return this.f38798e;
        }
        this.f38798e = 2;
        return this.f38798e;
    }

    public static String a(c cVar) {
        String str = cVar.c().f38756c;
        if (str != null) {
            return str;
        }
        String str2 = cVar.c().f38755b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] split = str2.split(AppConstants.COLON);
        if (split.length < 2) {
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public final synchronized String c() {
        if (this.f38795b == null) {
            f();
        }
        return this.f38795b;
    }

    public final synchronized String d() {
        if (this.f38796c == null) {
            f();
        }
        return this.f38796c;
    }

    public final synchronized int e() {
        PackageInfo a2;
        if (this.f38797d == 0 && (a2 = a("com.google.android.gms")) != null) {
            this.f38797d = a2.versionCode;
        }
        return this.f38797d;
    }

    private synchronized void f() {
        PackageInfo a2 = a(this.f38794a.getPackageName());
        if (a2 != null) {
            this.f38795b = Integer.toString(a2.versionCode);
            this.f38796c = a2.versionName;
        }
    }

    private PackageInfo a(String str) {
        try {
            return this.f38794a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            return null;
        }
    }
}
