package net.one97.paytm.h5paytmsdk.d;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.nebula.util.H5Utils;
import java.io.File;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.h5paytmsdk.a.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17100a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f17101b = "H5_FRIDAY";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(String str, String str2) {
            k.c(str, "key");
            k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            try {
                return a(str2).getString(str, "");
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public static Object b(String str, String str2) {
            k.c(str, "key");
            k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            SharedPreferences a2 = a(str2);
            try {
                return a2.getString(str, "");
            } catch (Exception unused) {
                try {
                    return Integer.valueOf(a2.getInt(str, -1));
                } catch (Exception unused2) {
                    try {
                        return Long.valueOf(a2.getLong(str, -1));
                    } catch (Exception unused3) {
                        try {
                            return Float.valueOf(a2.getFloat(str, 0.0f));
                        } catch (Exception unused4) {
                            try {
                                return Boolean.valueOf(a2.getBoolean(str, false));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return "";
                            }
                        }
                    }
                }
            }
        }

        public static SharedPreferences a(String str) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            SharedPreferences sharedPreferences = H5Utils.getContext().getSharedPreferences(str, 0);
            k.a((Object) sharedPreferences, "H5Utils.getContext().get…dPreferences(fileName, 0)");
            return sharedPreferences;
        }

        public static String b(String str) {
            k.c(str, "subAppName");
            b a2 = b.a();
            k.a((Object) a2, "IAPIntegrationHelper.getInstance()");
            Map<String, SubAppConfig> b2 = a2.b();
            if (b2 == null || b2.get(str) == null) {
                return null;
            }
            byte[] bytes = str.getBytes(d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(bytes, 2);
        }

        public static void c(String str, String str2) {
            k.c(str, "oldFilename");
            k.c(str2, "newFileName");
            SharedPreferences a2 = a(str);
            SharedPreferences a3 = a(str2);
            Map<String, ?> all = a2.getAll();
            k.a((Object) all, "oldSharedPreference.all");
            for (Map.Entry next : all.entrySet()) {
                String str3 = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof Boolean) {
                    a3.edit().putBoolean(str3, ((Boolean) value).booleanValue()).apply();
                } else if (value instanceof String) {
                    a3.edit().putString(str3, (String) value).apply();
                } else if (value instanceof Integer) {
                    a3.edit().putInt(str3, ((Number) value).intValue()).apply();
                } else if (value instanceof Long) {
                    a3.edit().putLong(str3, ((Number) value).longValue()).apply();
                } else if (value instanceof Float) {
                    a3.edit().putFloat(str3, ((Number) value).floatValue()).apply();
                }
            }
        }

        public static boolean c(String str) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            H5Utils.getContext().getSharedPreferences(str, 0).edit().clear().apply();
            if (Build.VERSION.SDK_INT >= 24) {
                return H5Utils.getContext().deleteSharedPreferences(str);
            }
            return e(str);
        }

        private static boolean e(String str) {
            File file = new File(H5Utils.getContext().getFilesDir().getParent().toString() + "/shared_prefs/" + str + ".xml");
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }

        public static boolean d(String str) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            return new File(H5Utils.getContext().getFilesDir().getParent().toString() + "/shared_prefs/" + str + ".xml").exists();
        }
    }
}
