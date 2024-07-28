package com.google.firebase.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.b;
import com.google.firebase.a.c;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f38722a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f38723b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f38724c;

    /* renamed from: d  reason: collision with root package name */
    private final c f38725d;

    public a(Context context, String str, c cVar) {
        Context context2;
        if (Build.VERSION.SDK_INT < 24 || b.e(context)) {
            context2 = context;
        } else {
            context2 = b.d(context);
        }
        this.f38723b = context2;
        this.f38724c = context.getSharedPreferences("com.google.firebase.common.prefs:".concat(String.valueOf(str)), 0);
        this.f38725d = cVar;
        this.f38722a = new AtomicBoolean(a());
    }

    private boolean a() {
        ApplicationInfo applicationInfo;
        if (this.f38724c.contains("firebase_data_collection_default_enabled")) {
            return this.f38724c.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f38723b.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f38723b.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }
}
