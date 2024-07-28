package net.one97.paytm.h5paytmsdk.c;

import android.content.SharedPreferences;
import com.alipay.mobile.nebula.util.H5SharedPreUtil;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.h5paytmsdk.d.e;

public final class ad {
    public static void a(String str, String str2, String str3) {
        k.c(str, "s");
        k.c(str2, "s1");
        if (str3 == null) {
            H5SharedPreUtil.saveStringData(str, str2);
            return;
        }
        e.a aVar = e.f17100a;
        k.c(str, "key");
        k.c(str2, "value");
        k.c(str3, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        try {
            e.a.a(str3).edit().putString(str, str2).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, long j, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            H5SharedPreUtil.saveLongData(str, j);
            return;
        }
        e.a aVar = e.f17100a;
        k.c(str, "key");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        try {
            e.a.a(str2).edit().putLong(str, j).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, int i2, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            try {
                H5SharedPreUtil.getSharedPreferences().edit().putInt(str, i2).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            e.a aVar = e.f17100a;
            k.c(str, "key");
            k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            try {
                e.a.a(str2).edit().putInt(str, i2).apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(String str, float f2, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            try {
                H5SharedPreUtil.getSharedPreferences().edit().putFloat(str, f2).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            e.a aVar = e.f17100a;
            k.c(str, "key");
            k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            try {
                e.a.a(str2).edit().putFloat(str, f2).apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void a(String str, boolean z, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            try {
                H5SharedPreUtil.getSharedPreferences().edit().putBoolean(str, z).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            e.a aVar = e.f17100a;
            k.c(str, "key");
            k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
            try {
                e.a.a(str2).edit().putBoolean(str, z).apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static Object a(String str, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            SharedPreferences sharedPreferences = H5SharedPreUtil.getSharedPreferences();
            try {
                return sharedPreferences.getString(str, "");
            } catch (Exception unused) {
                try {
                    return Integer.valueOf(sharedPreferences.getInt(str, -1));
                } catch (Exception unused2) {
                    try {
                        return Long.valueOf(sharedPreferences.getLong(str, -1));
                    } catch (Exception unused3) {
                        try {
                            return Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                        } catch (Exception unused4) {
                            try {
                                return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return "";
                            }
                        }
                    }
                }
            }
        } else {
            e.a aVar = e.f17100a;
            return e.a.b(str, str2);
        }
    }

    public static String b(String str, String str2) {
        k.c(str, "s");
        if (str2 == null) {
            String stringData = H5SharedPreUtil.getStringData(str);
            H5SharedPreUtil.removeData(str);
            return stringData;
        }
        e.a aVar = e.f17100a;
        String a2 = e.a.a(str, str2);
        e.a aVar2 = e.f17100a;
        k.c(str, "key");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        try {
            e.a.a(str2).edit().remove(str).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
