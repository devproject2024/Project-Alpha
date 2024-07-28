package net.one97.paytm.upi.registration.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.a.c;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.database.UpiRoomDatabase;
import net.one97.paytm.upi.registration.a.d;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class a implements net.one97.paytm.upi.registration.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f68391b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f68392a;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.upi.d.a f68393c;

    public final void a(String str, String str2, a.C1389a aVar, String str3, String str4) {
    }

    public final void a(c.b bVar) {
    }

    public final void a(a.C1389a aVar, String str) {
    }

    public final void a(a.C1389a aVar, String str, String str2) {
    }

    public final void a(a.C1389a aVar, String str, String str2, String str3) {
    }

    public final void a(a.C1389a aVar, String str, String str2, HashMap<String, String> hashMap, String str3) {
    }

    public final void a(a.C1389a aVar, String str, String str2, boolean z, String str3, String str4) {
    }

    public final void b(a.C1389a aVar, String str) {
    }

    public final void b(a.C1389a aVar, String str, String str2) {
    }

    public final void c(String str) {
    }

    public final void c(a.C1389a aVar, String str) {
    }

    public final void c(a.C1389a aVar, String str, String str2) {
    }

    public final void d() {
    }

    private a(Context context) {
        this.f68392a = context.getApplicationContext();
        this.f68393c = UpiRoomDatabase.a(context).a();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f68391b == null) {
                f68391b = new a(context.getApplicationContext());
            }
            aVar = f68391b;
        }
        return aVar;
    }

    public final String a() {
        String b2 = PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void a(String str) {
        com.paytm.b.a.a pref = PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext());
        pref.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, str, true);
        pref.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME, System.currentTimeMillis(), true);
    }

    public final void j() {
        com.paytm.b.a.a pref = PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext());
        pref.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, true);
        pref.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME, true);
    }

    public final void b(String str) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a(UpiConstants.KEY_LIST_KEYS_RESPONSE, str, true);
    }

    public final String b() {
        String b2 = PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.KEY_LIST_KEYS_RESPONSE, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void a(final d.a aVar, final net.one97.paytm.upi.h.a aVar2, final String str) {
        new Thread(new Runnable() {
            public final void run() {
                final String str;
                try {
                    net.one97.paytm.upi.h.a aVar = aVar2;
                    String str2 = str;
                    if (aVar.f66976a != null) {
                        String challenge = aVar.f66976a.getChallenge(str2, UpiUtils.getDeviceId(aVar.f66977b));
                        if (!TextUtils.isEmpty(challenge)) {
                            str = "NPCI,20150822," + challenge;
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    if (TextUtils.isEmpty(str)) {
                                        CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "get_challenge_response_failure", "app_CL_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                                    } else {
                                        CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "get_challenge_response_success", "", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                                    }
                                    aVar.a(str);
                                }
                            });
                        }
                    }
                    str = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        if (TextUtils.isEmpty(str)) {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "get_challenge_response_failure", "app_CL_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        } else {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "get_challenge_response_success", "", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        aVar.a(str);
                    }
                });
            }
        }).start();
    }

    public final void b(final d.a aVar, final net.one97.paytm.upi.h.a aVar2, final String str) {
        new Thread(new Runnable() {
            public final void run() {
                net.one97.paytm.upi.h.a aVar = aVar2;
                String str = str;
                String deviceId = UpiUtils.getDeviceId(aVar.f66977b);
                String mobile = UpiUtils.getMobile(aVar.f66977b);
                String appId = UpiUtils.getAppId(aVar.f66977b);
                final boolean registerApp = aVar.f66976a.registerApp(appId, mobile, deviceId, net.one97.paytm.upi.h.a.a(appId, mobile, str, deviceId));
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        if (registerApp) {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "register_app_response_success", "", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        } else {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68392a, GAConstants.CATEGORY.UPI_ONB_V1, "register_app_response_failure", "app_CL_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        aVar.a(registerApp);
                    }
                });
            }
        }).start();
    }

    public final boolean e() {
        return PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b("is_upi_user", false, true);
    }

    public final boolean f() {
        return PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true);
    }

    public final void a(boolean z) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a("is_upi_user", z, true);
    }

    public final void b(boolean z) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, z, true);
    }

    public final boolean g() {
        return PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    public final void c(boolean z) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a(UpiConstants.PREF_KEY_IS_SAME_DEVICE, z, true);
    }

    public final void d(boolean z) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a(UpiConstants.PREF_KEY_IS_BANK_ACCOUNT_ADDED, z, true);
    }

    public final void e(boolean z) {
        PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).a(UpiConstants.PREF_KEY_IS_MPIN_SET, z, true);
    }

    public final boolean h() {
        return PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_BANK_ACCOUNT_ADDED, false, true);
    }

    public final boolean i() {
        return PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_MPIN_SET, false, true);
    }

    public final void m() {
        PackageManager packageManager = this.f68392a.getApplicationContext().getPackageManager();
        PackageManager packageManager2 = this.f68392a.getApplicationContext().getPackageManager();
        Boolean isRecurringMandateEnabled = UpiGTMLoader.getInstance().isRecurringMandateEnabled();
        if (!i() || !h() || !e() || f() || !isRecurringMandateEnabled.booleanValue()) {
            packageManager2.setComponentEnabledSetting(new ComponentName(this.f68392a.getPackageName(), "net.one97.paytm.upi.mandate.deeplink.UpiMandateDeepLinkActivity"), 2, 1);
        } else {
            packageManager2.setComponentEnabledSetting(new ComponentName(this.f68392a.getPackageName(), "net.one97.paytm.upi.mandate.deeplink.UpiMandateDeepLinkActivity"), 1, 1);
        }
        if (!i() || !h() || !e() || f() || !g()) {
            packageManager.setComponentEnabledSetting(new ComponentName(this.f68392a.getPackageName(), "net.one97.paytm.upi.deeplink.UPIDeeplinkActivity"), 2, 1);
        } else {
            packageManager.setComponentEnabledSetting(new ComponentName(this.f68392a.getPackageName(), "net.one97.paytm.upi.deeplink.UPIDeeplinkActivity"), 1, 1);
        }
    }

    public final void a(List<AccountProviderBody.AccountProvider> list) {
        this.f68393c.a(list);
    }

    public final List<AccountProviderBody.AccountProvider> k() {
        return this.f68393c.a();
    }

    public final Map<String, AccountProviderBody.AccountProvider> l() {
        HashMap hashMap = new HashMap();
        for (AccountProviderBody.AccountProvider next : this.f68393c.a()) {
            hashMap.put(next.getIfsc(), next);
        }
        return hashMap;
    }

    public final String n() {
        com.paytm.b.a.a pref = PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext());
        return pref.b("isKYCDone", -1, true) > 0 ? pref.b("kycType", "true", true) : "false";
    }

    public final boolean c() {
        if (UpiAppUtils.daysBetween(new Date(PaytmUpiPrefUtil.getPref(this.f68392a.getApplicationContext()).b(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME, 0, true)), new Date(System.currentTimeMillis())) > UpiGTMLoader.getInstance().getUpiNpciTokenExpiryDays()) {
            return true;
        }
        return false;
    }
}
