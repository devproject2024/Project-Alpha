package net.one97.paytm.phoenix.util;

import android.content.SharedPreferences;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.PhoenixManager;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59656a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f59657b = "H5_FRIDAY";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Object a(String str, String str2) {
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
            j jVar = j.f59646a;
            j.b("PhoenixManager", "context" + PhoenixManager.getContext());
            SharedPreferences sharedPreferences = PhoenixManager.getContext().getSharedPreferences(str, 0);
            k.a((Object) sharedPreferences, "PhoenixManager.getContex…dPreferences(fileName, 0)");
            return sharedPreferences;
        }
    }
}
