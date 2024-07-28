package easypay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.upi.util.UpiContract;

public final class a implements SharedPreferences {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f46098a;

    /* renamed from: b  reason: collision with root package name */
    private Context f46099b;

    public a(Context context, String str) {
        if (context != null) {
            this.f46099b = context;
            this.f46098a = context.getSharedPreferences(str, 0);
        }
    }

    /* renamed from: a */
    public final C0775a edit() {
        return new C0775a();
    }

    public final Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = b(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getBoolean(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            android.content.SharedPreferences r0 = r2.f46098a
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "null"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r3 = r2.b(r3)
            if (r3 == 0) goto L_0x001b
            boolean r4 = java.lang.Boolean.parseBoolean(r3)
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.utils.a.getBoolean(java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = b(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float getFloat(java.lang.String r3, float r4) {
        /*
            r2 = this;
            android.content.SharedPreferences r0 = r2.f46098a
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "null"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r3 = r2.b(r3)
            if (r3 == 0) goto L_0x001b
            float r4 = java.lang.Float.parseFloat(r3)
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.utils.a.getFloat(java.lang.String, float):float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = b(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getInt(java.lang.String r3, int r4) {
        /*
            r2 = this;
            android.content.SharedPreferences r0 = r2.f46098a
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "null"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r3 = r2.b(r3)
            if (r3 == 0) goto L_0x001b
            int r4 = java.lang.Integer.parseInt(r3)
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.utils.a.getInt(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = b(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long getLong(java.lang.String r3, long r4) {
        /*
            r2 = this;
            android.content.SharedPreferences r0 = r2.f46098a
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "null"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.String r3 = r2.b(r3)
            if (r3 == 0) goto L_0x001b
            long r4 = java.lang.Long.parseLong(r3)
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.utils.a.getLong(java.lang.String, long):long");
    }

    public final String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f46098a;
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString(str, (String) null);
        return (string == null || string.equalsIgnoreCase("null")) ? str2 : b(string);
    }

    public final boolean contains(String str) {
        return this.f46098a.contains(str);
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f46098a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f46098a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(b(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 8);
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            return null;
        }
    }

    private String b(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(b(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(Base64.decode(str, 8)));
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            return null;
        }
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.f46098a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    private byte[] b() {
        String string = Settings.Secure.getString(this.f46099b.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        int length = string.length();
        if (length > 16) {
            string = string.substring(0, 16);
        } else if (length < 16) {
            for (int i2 = 16 - length; i2 > 0; i2--) {
                string = "0".concat(String.valueOf(string));
            }
        }
        char[] cArr = {'p', '@', 'y', '!', 'm', 'k', 'e', 'Y', '4', 'o', 'n', 'E', '9', '7', 'p', 'r'};
        char[] charArray = string.toCharArray();
        char[] cArr2 = new char[16];
        for (int i3 = 0; i3 < 16; i3++) {
            cArr2[i3] = (char) (cArr[i3] ^ charArray[i3]);
        }
        return new String(cArr2).getBytes();
    }

    /* renamed from: easypay.utils.a$a  reason: collision with other inner class name */
    public class C0775a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        protected SharedPreferences.Editor f46100a;

        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public C0775a() {
            this.f46100a = a.this.f46098a.edit();
        }

        /* renamed from: a */
        public final C0775a putString(String str, String str2) {
            if (str2 != null) {
                this.f46100a.putString(str, a.this.a(str2));
            } else {
                this.f46100a.putString(str, str2);
            }
            return this;
        }

        public final void apply() {
            this.f46100a.apply();
        }

        public final boolean commit() {
            return this.f46100a.commit();
        }

        public final /* bridge */ /* synthetic */ SharedPreferences.Editor clear() {
            this.f46100a.clear();
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor remove(String str) {
            this.f46100a.remove(str);
            this.f46100a.apply();
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f46100a.putString(str, a.this.a(Boolean.toString(z)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putFloat(String str, float f2) {
            this.f46100a.putString(str, a.this.a(Float.toString(f2)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putLong(String str, long j) {
            this.f46100a.putString(str, a.this.a(Long.toString(j)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putInt(String str, int i2) {
            this.f46100a.putString(str, a.this.a(Integer.toString(i2)));
            return this;
        }
    }
}
