package net.one97.paytm.acceptPayment.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.business.merchant_payments.utility.AESSecurityUtil;
import java.util.Map;
import java.util.Set;

public class i implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static i f52058a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f52059b;

    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    private i(Context context) {
        if (context != null) {
            this.f52059b = context.getSharedPreferences("app_pref", 0);
        }
    }

    public static i a(Context context) {
        if (f52058a == null) {
            synchronized (i.class) {
                if (f52058a == null) {
                    f52058a = new i(context.getApplicationContext());
                }
            }
        }
        return f52058a;
    }

    /* renamed from: a */
    public final a edit() {
        return new a();
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String str, boolean z) {
        String string = this.f52059b.getString(str, (String) null);
        return !TextUtils.isEmpty(string) ? Boolean.parseBoolean(AESSecurityUtil.decrypt(string)) : z;
    }

    public float getFloat(String str, float f2) {
        String string = this.f52059b.getString(str, (String) null);
        return !TextUtils.isEmpty(string) ? Float.parseFloat(AESSecurityUtil.decrypt(string)) : f2;
    }

    public int getInt(String str, int i2) {
        String string = this.f52059b.getString(str, (String) null);
        try {
            return !TextUtils.isEmpty(string) ? Integer.parseInt(AESSecurityUtil.decrypt(string)) : i2;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public long getLong(String str, long j) {
        try {
            String string = this.f52059b.getString(str, (String) null);
            return (TextUtils.isEmpty(string) || TextUtils.isEmpty(AESSecurityUtil.decrypt(string))) ? j : Long.parseLong(AESSecurityUtil.decrypt(string));
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f52059b;
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString(str, (String) null);
        return string != null ? AESSecurityUtil.decrypt(string) : str2;
    }

    public boolean contains(String str) {
        return this.f52059b.contains(str);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f52059b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f52059b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public class a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        protected SharedPreferences.Editor f52060a;

        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public a() {
            this.f52060a = i.this.f52059b.edit();
        }

        public final void apply() {
            this.f52060a.apply();
        }

        public final boolean commit() {
            return this.f52060a.commit();
        }

        public final /* bridge */ /* synthetic */ SharedPreferences.Editor clear() {
            this.f52060a.clear();
            return this;
        }

        public final /* bridge */ /* synthetic */ SharedPreferences.Editor remove(String str) {
            this.f52060a.remove(str);
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f52060a.putString(str, AESSecurityUtil.encrypt(Boolean.toString(z)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putFloat(String str, float f2) {
            this.f52060a.putString(str, AESSecurityUtil.encrypt(Float.toString(f2)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putLong(String str, long j) {
            this.f52060a.putString(str, AESSecurityUtil.encrypt(Long.toString(j)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putInt(String str, int i2) {
            this.f52060a.putString(str, AESSecurityUtil.encrypt(Integer.toString(i2)));
            return this;
        }

        public final /* synthetic */ SharedPreferences.Editor putString(String str, String str2) {
            if (str2 != null) {
                this.f52060a.putString(str, AESSecurityUtil.encrypt(str2));
            } else {
                this.f52060a.putString(str, str2);
            }
            return this;
        }
    }
}
