package com.google.android.gms.measurement.internal;

public class fx {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f12002a = {"app_background", "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter", "session_start_with_rollout", "firebase_campaign"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f12003b = {"_ab", "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep", "_ssr", "_cmp"};

    public static String a(String str) {
        return hj.a(str, f12003b, f12002a);
    }

    public static String b(String str) {
        return hj.a(str, f12002a, f12003b);
    }
}
