package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Locale;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f37576a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37577b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37578c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37579d;

    /* renamed from: e  reason: collision with root package name */
    public final String f37580e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37581f;

    /* renamed from: g  reason: collision with root package name */
    public final String f37582g;

    /* renamed from: h  reason: collision with root package name */
    public final String f37583h;

    /* renamed from: i  reason: collision with root package name */
    public final String f37584i;
    public final String j;

    public q(Context context) {
        Resources resources = context.getResources();
        Locale locale = (resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale;
        HashMap hashMap = new HashMap();
        hashMap.put("error_initializing_player", "An error occurred while initializing the YouTube player.");
        hashMap.put("get_youtube_app_title", "Get YouTube App");
        hashMap.put("get_youtube_app_text", "This app won't run without the YouTube App, which is missing from your device");
        hashMap.put("get_youtube_app_action", "Get YouTube App");
        hashMap.put("enable_youtube_app_title", "Enable YouTube App");
        hashMap.put("enable_youtube_app_text", "This app won't work unless you enable the YouTube App.");
        hashMap.put("enable_youtube_app_action", "Enable YouTube App");
        hashMap.put("update_youtube_app_title", "Update YouTube App");
        hashMap.put("update_youtube_app_text", "This app won't work unless you update the YouTube App.");
        hashMap.put("update_youtube_app_action", "Update YouTube App");
        z.a(hashMap, locale.getLanguage());
        String valueOf = String.valueOf(locale.getLanguage());
        String valueOf2 = String.valueOf(locale.getCountry());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("_");
        sb.append(valueOf2);
        z.a(hashMap, sb.toString());
        this.f37576a = (String) hashMap.get("error_initializing_player");
        this.f37577b = (String) hashMap.get("get_youtube_app_title");
        this.f37578c = (String) hashMap.get("get_youtube_app_text");
        this.f37579d = (String) hashMap.get("get_youtube_app_action");
        this.f37580e = (String) hashMap.get("enable_youtube_app_title");
        this.f37581f = (String) hashMap.get("enable_youtube_app_text");
        this.f37582g = (String) hashMap.get("enable_youtube_app_action");
        this.f37583h = (String) hashMap.get("update_youtube_app_title");
        this.f37584i = (String) hashMap.get("update_youtube_app_text");
        this.j = (String) hashMap.get("update_youtube_app_action");
    }
}
