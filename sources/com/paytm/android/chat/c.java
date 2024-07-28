package com.paytm.android.chat;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import c.a.a.j;
import c.a.a.k;
import com.imsdk.CPCSendbirdWrapperProvider;
import com.paytm.android.chat.bean.SettingsInfoBean;
import com.paytm.android.chat.c.a.b;
import com.paytm.android.chat.c.b.a;
import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.interceptors.ErrorInterceptor;
import com.paytm.android.chat.network.interceptors.TokenInterceptor;
import com.paytm.android.chat.utils.ChatConfigUtil;
import com.paytm.android.chat.utils.DatabaseManager;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.utils.TopActivityManager;
import com.paytm.utility.q;
import dagger.a.g;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static SettingsInfoBean f41832a = new SettingsInfoBean();

    /* renamed from: b  reason: collision with root package name */
    private static Application f41833b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f41834c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f41835d = "old_user";

    /* renamed from: e  reason: collision with root package name */
    private static String f41836e = "";

    /* renamed from: f  reason: collision with root package name */
    private static Activity f41837f;

    public static synchronized void a(Application application, String str, String str2) {
        synchronized (c.class) {
            f41836e = str;
            if (!f41834c) {
                q.a("ChatApplication--->onCreate aar test");
                SharedPreferencesUtil.init(application);
                CPCSendbirdWrapperProvider.getSendbirdWrapper(application, str);
                UrlManager.setServerAddr(str2);
                f41833b = application;
                if (Build.VERSION.SDK_INT >= 14) {
                    application.registerActivityLifecycleCallbacks(TopActivityManager.getInstance());
                }
                k.a aVar = new k.a();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new TokenInterceptor());
                arrayList.add(new ErrorInterceptor());
                aVar.a(arrayList);
                j.b().a(aVar.a());
                f41832a.settings_media_save2camera_roll = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_media_save2camera_roll, false);
                f41832a.settings_media_photos = SharedPreferencesUtil.getInt(SharedPreferencesUtil.Key.settings_media_photos, 0);
                f41832a.settings_media_videos = SharedPreferencesUtil.getInt(SharedPreferencesUtil.Key.settings_media_videos, 0);
                f41832a.settings_media_documents = SharedPreferencesUtil.getInt(SharedPreferencesUtil.Key.settings_media_documents, 0);
                f41832a.settings_media_audio = SharedPreferencesUtil.getInt(SharedPreferencesUtil.Key.settings_media_audio, 0);
                f41832a.settings_notifications_sound = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_notifications_sound, true);
                f41832a.settings_notifications_vibrate = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_notifications_vibrate, true);
                f41832a.settings_notifications_lock_screen = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen, false);
                f41832a.settings_notifications_lock_screen_preview = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen_preview, true);
                f41832a.settings_notifications_lock_screen_name = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.settings_notifications_lock_screen_name, true);
                DBManager.INSTANCE.init(application);
                DatabaseManager.init(application);
                b.a aVar2 = new b.a((byte) 0);
                aVar2.f41841b = (com.paytm.android.chat.c.b.c) g.a(new com.paytm.android.chat.c.b.c("CONSUMER"));
                aVar2.f41840a = (a) g.a(new a());
                if (aVar2.f41840a == null) {
                    aVar2.f41840a = new a();
                }
                g.a(aVar2.f41841b, com.paytm.android.chat.c.b.c.class);
                ChatConfigUtil.Companion.getInstance().chatConfig = new b(aVar2.f41840a, aVar2.f41841b, (byte) 0).a();
                f41834c = true;
            }
        }
    }

    public static Application a() {
        return f41833b;
    }

    public static void a(Activity activity) {
        f41837f = activity;
    }

    public static String a(int i2, String str) {
        Activity activity = f41837f;
        if (activity != null) {
            return TextUtils.isEmpty(activity.getString(i2)) ? str : f41837f.getString(i2);
        }
        try {
            String string = f41833b.getString(i2);
            return TextUtils.isEmpty(string) ? str : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        return f41835d;
    }

    public static void c() {
        f41835d = "new_user";
    }

    public static void d() {
        if (f41834c) {
            com.paytm.a aVar = com.paytm.a.f40823c;
            com.paytm.a.b();
            com.paytm.a.a();
        }
    }

    public static void e() {
        f41837f = null;
    }

    public static SettingsInfoBean f() {
        return f41832a;
    }

    public static String g() {
        return f41836e;
    }
}
