package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f37652a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37653b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37654c;

    /* renamed from: d  reason: collision with root package name */
    public final int f37655d;

    /* renamed from: e  reason: collision with root package name */
    public final int f37656e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37657f;

    /* renamed from: g  reason: collision with root package name */
    public final int f37658g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37659h;

    /* renamed from: i  reason: collision with root package name */
    public final int f37660i;
    public final List<String> j;

    private b(Bundle bundle) {
        this.f37652a = bundle.getString("android.support.customtabs.trusted.DEFAULT_URL");
        this.f37653b = bundle.getInt("android.support.customtabs.trusted.STATUS_BAR_COLOR", 17170443);
        this.f37654c = bundle.getInt("android.support.customtabs.trusted.STATUS_BAR_COLOR_DARK", this.f37653b);
        this.f37655d = bundle.getInt("android.support.customtabs.trusted.NAVIGATION_BAR_COLOR", 17170443);
        this.f37656e = bundle.getInt("android.support.customtabs.trusted.NAVIGATION_BAR_COLOR_DARK", this.f37655d);
        this.f37657f = bundle.getInt("android.support.customtabs.trusted.SPLASH_IMAGE_DRAWABLE", 0);
        this.f37658g = bundle.getInt("android.support.customtabs.trusted.SPLASH_SCREEN_BACKGROUND_COLOR", 17170443);
        this.f37659h = bundle.getString("android.support.customtabs.trusted.FILE_PROVIDER_AUTHORITY");
        this.f37660i = bundle.getInt("android.support.customtabs.trusted.SPLASH_SCREEN_FADE_OUT_DURATION", 0);
        this.j = bundle.getStringArrayList("android.support.customtabs.trusted.ADDITIONAL_TRUSTED_ORIGINS");
    }

    public static b a(Activity activity) {
        Bundle bundle;
        try {
            bundle = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        return new b(bundle);
    }
}
