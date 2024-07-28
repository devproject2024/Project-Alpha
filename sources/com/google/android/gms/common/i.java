package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.s;

public class i {

    /* renamed from: b  reason: collision with root package name */
    private static i f8694b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8695a;

    private i(Context context) {
        this.f8695a = context.getApplicationContext();
    }

    public static i a(Context context) {
        s.a(context);
        synchronized (i.class) {
            if (f8694b == null) {
                n.a(context);
                f8694b = new i(context);
            }
        }
        return f8694b;
    }

    public final boolean a(int i2) {
        w wVar;
        String[] packagesForUid = c.a(this.f8695a).f8654a.getPackageManager().getPackagesForUid(i2);
        if (packagesForUid != null && packagesForUid.length != 0) {
            wVar = null;
            for (String a2 : packagesForUid) {
                wVar = a(a2);
                if (wVar.f9000a) {
                    break;
                }
            }
        } else {
            wVar = w.a("no pkgs");
        }
        if (!wVar.f9000a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (wVar.f9001b != null) {
                wVar.b();
            } else {
                wVar.b();
            }
        }
        return wVar.f9000a;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        o oVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                oVar = a(packageInfo, u.f8958a);
            } else {
                oVar = a(packageInfo, u.f8958a[0]);
            }
            if (oVar != null) {
                return true;
            }
        }
        return false;
    }

    private final w a(String str) {
        try {
            PackageInfo packageInfo = c.a(this.f8695a).f8654a.getPackageManager().getPackageInfo(str, 64);
            boolean f2 = h.f(this.f8695a);
            if (packageInfo == null) {
                return w.a("null pkg");
            }
            if (packageInfo.signatures != null) {
                if (packageInfo.signatures.length == 1) {
                    s sVar = new s(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    w a2 = n.a(str2, sVar, f2, false);
                    if (!a2.f9000a || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !n.a(str2, sVar, false, true).f9000a) {
                        return a2;
                    }
                    return w.a("debuggable release cert app rejected");
                }
            }
            return w.a("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return w.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private static o a(PackageInfo packageInfo, o... oVarArr) {
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
            return null;
        }
        s sVar = new s(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            if (oVarArr[i2].equals(sVar)) {
                return oVarArr[i2];
            }
        }
        return null;
    }
}
