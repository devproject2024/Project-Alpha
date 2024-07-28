package com.bumptech.glide.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6478a;

    public d(Context context) {
        this.f6478a = context;
    }

    public final List<b> a() {
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f6478a.getPackageManager().getApplicationInfo(this.f6478a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                new StringBuilder("Got app info metadata: ").append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(a(str));
                    Log.isLoggable("ManifestParser", 3);
                }
            }
            Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }

    private static b a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                a(cls, e2);
            } catch (IllegalAccessException e3) {
                a(cls, e3);
            } catch (NoSuchMethodException e4) {
                a(cls, e4);
            } catch (InvocationTargetException e5) {
                a(cls, e5);
            }
            if (obj instanceof b) {
                return (b) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: ".concat(String.valueOf(obj)));
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for ".concat(String.valueOf(cls)), exc);
    }
}
