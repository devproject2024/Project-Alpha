package com.paytm.android.chat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.utility.b;
import com.paytm.utility.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.g.b.k;

public final class SharedPreferencesUtil {
    public static final String FILE_NAME = "share_data";
    public static final SharedPreferencesUtil INSTANCE = new SharedPreferencesUtil();
    private static Context mAppContext;
    private static SharedPreferences sp;

    public static /* synthetic */ void isRegist$annotations() {
    }

    public static /* synthetic */ void mobileNumber$annotations() {
    }

    public static /* synthetic */ void nickname$annotations() {
    }

    public static /* synthetic */ void pFId$annotations() {
    }

    public static /* synthetic */ void profileImg$annotations() {
    }

    public static /* synthetic */ void sBToken$annotations() {
    }

    public static /* synthetic */ void token$annotations() {
    }

    public static /* synthetic */ void userId$annotations() {
    }

    private SharedPreferencesUtil() {
    }

    public static final void init(Context context) {
        mAppContext = context;
    }

    public static final void saveBoolean(String str, boolean z) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static final boolean getBoolean(String str, boolean z) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null) {
            return z;
        }
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public static final void saveString(String str, String str2) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static final String getString(String str, String str2) {
        Context context;
        k.c(str2, "defValue");
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null) {
            return "";
        }
        if (sharedPreferences == null) {
            k.a();
        }
        String string = sharedPreferences.getString(str, str2);
        return string == null ? str2 : string;
    }

    public static final void saveInt(String str, int i2) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            sharedPreferences.edit().putInt(str, i2).apply();
        }
    }

    public static final int getInt(String str, int i2) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null) {
            return i2;
        }
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences.getInt(str, i2);
    }

    public static final void saveLong(String str, long j) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    public static final long getLong(String str, long j) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null) {
            return j;
        }
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences.getLong(str, j);
    }

    public final void remove(String str) {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            a aVar = a.f42361a;
            k.a((Object) edit, "editor");
            a.a(edit);
        }
    }

    public static final void clear() {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            if (sharedPreferences == null) {
                k.a();
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            a aVar = a.f42361a;
            k.a((Object) edit, "editor");
            a.a(edit);
        }
    }

    public final boolean contains(String str) {
        Context context = mAppContext;
        if (context == null) {
            return false;
        }
        if (context == null) {
            k.a();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    public final Map<String, ?> getAll() {
        Context context;
        if (sp == null && (context = mAppContext) != null) {
            if (context == null) {
                k.a();
            }
            sp = context.getSharedPreferences(FILE_NAME, 0);
        }
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences == null) {
            k.a();
        }
        Map<String, ?> all = sharedPreferences.getAll();
        k.a((Object) all, "sp!!.all");
        return all;
    }

    public static final String getUserId() {
        return getString(Key.SELF_PROFILE_ID, H5BridgeContext.INVALID_ID);
    }

    public static final void saveUserId(String str) {
        saveString(Key.SELF_PROFILE_ID, str);
    }

    public static final String getNickname() {
        return getString(Key.SELF_PROFILE_NAME, "");
    }

    public static final void saveNickname(String str) {
        saveString(Key.SELF_PROFILE_NAME, str);
    }

    public static final String getMobileNumber() {
        return getString(Key.SELF_PROFILE_MOBILE_NUMBER, "");
    }

    public static final String getProfileImg() {
        return getString(Key.SELF_PROFILE_IMG, "");
    }

    public static final void saveProfileImg(String str) {
        saveString(Key.SELF_PROFILE_IMG, str);
    }

    public final long getProfileBirth() {
        try {
            return getLong(Key.SELF_PROFILE_BIRTH, 0);
        } catch (Exception | NullPointerException unused) {
            return 0;
        }
    }

    public static final void saveProfileBirth(long j) {
        try {
            saveLong(Key.SELF_PROFILE_BIRTH, j);
        } catch (Exception unused) {
        }
    }

    public final String getProfileGender() {
        return getString(Key.SELF_PROFILE_GENDER, "");
    }

    public static final void saveProfileGender(String str) {
        saveString(Key.SELF_PROFILE_GENDER, str);
    }

    public static final String getToken() {
        return AppUtilKt.sanitizeToken(getString(Key.SELF_TOKEN, ""));
    }

    public static final String getSBToken() {
        return getString(Key.SB_TOKEN, "");
    }

    public static final boolean isRegist() {
        return getBoolean(Key.IS_REGIST, false);
    }

    public static final String getPFId() {
        try {
            return getString(Key.PF_ID, H5BridgeContext.INVALID_ID);
        } catch (Exception unused) {
            long j = getLong(Key.PF_ID, -1);
            saveString(Key.PF_ID, String.valueOf(j));
            return String.valueOf(j);
        }
    }

    public static final void updateUserData(Context context) {
        clear();
        if (context != null) {
            String j = b.j(context);
            if (TextUtils.isEmpty(j)) {
                j = b.l(context);
            }
            saveString(Key.PF_ID, b.n(context));
            saveNickname(j);
            saveString(Key.SELF_PROFILE_MOBILE_NUMBER, b.l(context));
            saveProfileImg(b.D(context));
            saveString(Key.SELF_TOKEN, d.a(context));
        }
    }

    public static final class Key {
        public static final String DONT_SHOW_MARK_AS_READ = "dont_show_mark_as_read";
        public static final String FILTER_CACHE = "filter_cache";
        public static final Key INSTANCE = new Key();
        public static final String IS_LIGHT_COLOR_THEME = "is_light_color_theme";
        public static final String IS_PROFILE_SHOW = "is_profile_show";
        public static final String IS_REGIST = "is_regist";
        public static final String LAST_REGISTER_CALLED_FOR_VERSION = "last_regist_for_app_ver";
        public static final String PF_ID = "pf_id";
        public static final String SB_TOKEN = "sb_token";
        public static final String SELF_PROFILE_BIRTH = "self_profile_birth";
        public static final String SELF_PROFILE_GENDER = "self_profile_gender";
        public static final String SELF_PROFILE_ID = "self_profile_id";
        public static final String SELF_PROFILE_IMG = "self_profile_img";
        public static final String SELF_PROFILE_MOBILE_NUMBER = "self_profile_mobile_number";
        public static final String SELF_PROFILE_NAME = "self_profile_NAME";
        public static final String SELF_TOKEN = "self_token";
        public static final String SYNC_ALL_CONTACTS = "sync_all_contacts";
        public static final String friends_cache = "friends_cache";
        public static final String last_time_contacts_updated_to_sendbird = "last_time_contacts_updated_to_sendbird";
        public static final String settings_media_audio = "settings_media_audio";
        public static final String settings_media_documents = "settings_media_documents";
        public static final String settings_media_photos = "settings_media_photos";
        public static final String settings_media_save2camera_roll = "settings_media_save2camera_roll";
        public static final String settings_media_videos = "settings_media_videos";
        public static final String settings_notifications_lock_screen = "settings_notifications_lock_screen";
        public static final String settings_notifications_lock_screen_name = "settings_notifications_lock_screen_name";
        public static final String settings_notifications_lock_screen_preview = "settings_notifications_lock_screen_preview";
        public static final String settings_notifications_sound = "settings_notifications_sound";
        public static final String settings_notifications_vibrate = "settings_notifications_vibrate";
        public static final String site_id_filter = "siteIdFilter";
        public static final String view_friends_clicked_on_onboarding = "view_friends_clicked_on_onboarding";

        private Key() {
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f42361a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Method f42362b = a();

        private a() {
        }

        private static Method a() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }

        public static void a(SharedPreferences.Editor editor) {
            k.c(editor, "editor");
            try {
                if (f42362b != null) {
                    f42362b.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.apply();
        }
    }
}
