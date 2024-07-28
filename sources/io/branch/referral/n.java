package io.branch.referral;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.paytm.contactsSdk.database.ContactColumn;
import io.branch.referral.ah;
import io.branch.referral.m;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

final class n {

    /* renamed from: c  reason: collision with root package name */
    private static n f46547c;

    /* renamed from: a  reason: collision with root package name */
    final ah f46548a = new a();

    /* renamed from: b  reason: collision with root package name */
    final Context f46549b;

    static n a(Context context) {
        if (f46547c == null) {
            f46547c = new n(context);
        }
        return f46547c;
    }

    static n a() {
        return f46547c;
    }

    private n(Context context) {
        this.f46549b = context;
    }

    private static boolean c() {
        return c.b() || j.b();
    }

    public final ah.b b() {
        return ah.a(this.f46549b, c());
    }

    static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    class a extends ah {
        public a() {
        }
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || str.equals("bnc_no_value");
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar, JSONObject jSONObject) throws JSONException {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String[] strArr = s.f46572a;
        int length = strArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (strArr[i2].equals(sVar.f46574c)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            jSONObject.put(m.a.CPUType.getKey(), System.getProperty("os.arch"));
            jSONObject.put(m.a.DeviceBuildId.getKey(), Build.DISPLAY);
            String key = m.a.Locale.getKey();
            jSONObject.put(key, Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry());
            String key2 = m.a.ConnectionType.getKey();
            Context context = this.f46549b;
            String str = null;
            jSONObject.put(key2, (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? null : activeNetworkInfo.getType() == 1 ? "wifi" : "mobile");
            String key3 = m.a.DeviceCarrier.getKey();
            TelephonyManager telephonyManager = (TelephonyManager) this.f46549b.getSystemService(ContactColumn.PHONE_NUMBER);
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    str = networkOperatorName;
                }
            }
            jSONObject.put(key3, str);
            jSONObject.put(m.a.OSVersionAndroid.getKey(), Build.VERSION.RELEASE);
        }
    }
}
