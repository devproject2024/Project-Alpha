package com.paytm.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import com.paytm.utility.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.util.UpiContract;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42654a = new a((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f42655e = {'p', '@', 'y', '!', 'm', 'k', 'e', 'Y', '4', 'o', 'n', 'E', '9', '7', 'p', 'r'};

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f42656b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42657c = d.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final Context f42658d;

    public d(Context context) {
        k.c(context, "context");
        this.f42658d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Map<String, ?> a(List<String> list, com.paytm.b.a aVar) {
        k.c(list, "keyList");
        k.c(aVar, "cjrPreferenceManager");
        try {
            SharedPreferences sharedPreferences = this.f42658d.getSharedPreferences("app_pref", 0);
            k.a((Object) sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            this.f42656b = sharedPreferences;
            SharedPreferences sharedPreferences2 = this.f42656b;
            if (sharedPreferences2 == null) {
                k.a("preference");
            }
            Map<String, ?> all = sharedPreferences2.getAll();
            StringBuilder sb = new StringBuilder("getAllValuesFromOldPref: size ");
            sb.append(all.size());
            sb.append(" \n\n ");
            sb.append(all);
            k.a((Object) all, "list");
            return a(all, list, aVar);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Map<String, ?> a(List<String> list, f.a aVar, com.paytm.b.a aVar2) {
        k.c(list, "keyList");
        k.c(aVar, "prefName");
        k.c(aVar2, "cjrPreferenceManager");
        try {
            SharedPreferences sharedPreferences = this.f42658d.getSharedPreferences(aVar.getPrefname(), 0);
            k.a((Object) sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            this.f42656b = sharedPreferences;
            SharedPreferences sharedPreferences2 = this.f42656b;
            if (sharedPreferences2 == null) {
                k.a("preference");
            }
            Map<String, ?> all = sharedPreferences2.getAll();
            StringBuilder sb = new StringBuilder("getAllValuesPrivate: size ");
            sb.append(all.size());
            sb.append(" \n\n ");
            sb.append(all);
            k.a((Object) all, "list");
            return a(all, list, aVar2);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Map<String, ?> a(Map<String, ?> map, List<String> list, com.paytm.b.a aVar) {
        Map<String, ?> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (list.contains(str)) {
                if (value instanceof Set) {
                    hashMap.put(str, value);
                } else {
                    String a2 = a(String.valueOf(value), str, aVar);
                    CharSequence charSequence = a2;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        hashMap.put(str, a2);
                    }
                }
            }
        }
        return hashMap;
    }

    public final String a(String str) {
        k.c(str, "value");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            byte[] bytes = str.getBytes(kotlin.m.d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(instance.doFinal(bytes), 8);
        } catch (Exception e2) {
            String.valueOf(e2.getMessage());
            return null;
        }
    }

    public final String a(String str, String str2, com.paytm.b.a aVar) {
        k.c(str, "value");
        k.c(str2, "key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            k.a((Object) instance, "Cipher.getInstance(AES_ALGORITHM)");
            instance.init(2, secretKeySpec);
            byte[] decode = Base64.decode(str, 8);
            k.a((Object) decode, "Base64.decode(value, 8)");
            byte[] doFinal = instance.doFinal(decode);
            k.a((Object) doFinal, "cipher.doFinal(toDecrypt)");
            return new String(doFinal, kotlin.m.d.f47971a);
        } catch (Exception e2) {
            String.valueOf(e2.getMessage());
            if (aVar != null) {
                aVar.a(e2, str2, str);
            }
            return null;
        }
    }

    private final byte[] a() {
        String string = Settings.Secure.getString(this.f42658d.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        int length = string.length();
        if (length > 16) {
            k.a((Object) string, "androidId");
            if (string != null) {
                string = string.substring(0, 16);
                k.a((Object) string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else if (length < 16) {
            for (int i2 = 16 - length; i2 > 0; i2--) {
                string = "0".concat(String.valueOf(string));
            }
        }
        k.a((Object) string, "androidId");
        if (string != null) {
            char[] charArray = string.toCharArray();
            k.a((Object) charArray, "(this as java.lang.String).toCharArray()");
            char[] cArr = new char[16];
            for (int i3 = 0; i3 <= 15; i3++) {
                cArr[i3] = (char) (f42655e[i3] ^ charArray[i3]);
            }
            byte[] bytes = new String(cArr).getBytes(kotlin.m.d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
