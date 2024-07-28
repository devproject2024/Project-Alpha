package com.bumptech.glide.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.load.g;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, g> f6583a = new ConcurrentHashMap();

    public static g a(Context context) {
        String str;
        String packageName = context.getPackageName();
        g gVar = (g) f6583a.get(packageName);
        if (gVar != null) {
            return gVar;
        }
        PackageInfo b2 = b(context);
        if (b2 != null) {
            str = String.valueOf(b2.versionCode);
        } else {
            str = UUID.randomUUID().toString();
        }
        d dVar = new d(str);
        g putIfAbsent = f6583a.putIfAbsent(packageName, dVar);
        return putIfAbsent == null ? dVar : putIfAbsent;
    }

    private static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            new StringBuilder("Cannot resolve info for").append(context.getPackageName());
            return null;
        }
    }
}
