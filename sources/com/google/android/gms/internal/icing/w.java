package com.google.android.gms.internal.icing;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static volatile af<Boolean> f10277a = af.zzv();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f10278b = new Object();

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
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            throw new IllegalArgumentException(sb.toString());
        } else if (f10277a.isPresent()) {
            return f10277a.get().booleanValue();
        } else {
            synchronized (f10278b) {
                if (f10277a.isPresent()) {
                    boolean booleanValue = f10277a.get().booleanValue();
                    return booleanValue;
                }
                boolean z2 = false;
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && a(context)) {
                            z2 = true;
                        }
                        f10277a = af.zzb(Boolean.valueOf(z2));
                        return f10277a.get().booleanValue();
                    }
                }
                z = true;
                z2 = true;
                f10277a = af.zzb(Boolean.valueOf(z2));
                return f10277a.get().booleanValue();
            }
        }
    }
}
