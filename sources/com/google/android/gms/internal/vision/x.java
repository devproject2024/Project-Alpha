package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ai<Boolean> f11271a = ai.zzbx();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f11272b = new Object();

    private static boolean a(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean a(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        } else if (f11271a.isPresent()) {
            return f11271a.get().booleanValue();
        } else {
            synchronized (f11272b) {
                if (f11271a.isPresent()) {
                    boolean booleanValue = f11271a.get().booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && a(context)) {
                            z2 = true;
                        }
                        f11271a = ai.zzc(Boolean.valueOf(z2));
                        return f11271a.get().booleanValue();
                    }
                }
                z = true;
                z2 = true;
                f11271a = ai.zzc(Boolean.valueOf(z2));
                return f11271a.get().booleanValue();
            }
        }
    }
}
