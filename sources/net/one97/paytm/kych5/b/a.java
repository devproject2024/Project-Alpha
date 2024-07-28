package net.one97.paytm.kych5.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.kych5.a.c;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upi.util.UpiContract;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51045a = new a();

    private a() {
    }

    public static void a(Context context) {
        k.c(context, "ctx");
        d.a aVar = d.f66026a;
        String a2 = d.a.a() != null ? d.a("pbAddressDlUrl") : null;
        CharSequence charSequence = a2;
        if (charSequence == null || charSequence.length() == 0) {
            a2 = "https://dbt-ite.paytmbank.com/kyc/home";
        }
        a(context, a2);
    }

    public static void a(Context context, HashMap<String, String> hashMap, String str) {
        k.c(context, "ctx");
        String a2 = a(str, hashMap);
        if (a2 == null) {
            k.a();
        }
        a(context, a2);
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        Uri uri;
        k.c(context, "ctx");
        k.c(deepLinkData, "deepLinkDataa");
        d.a aVar = d.f66026a;
        String a2 = d.a.a() != null ? d.a("kycFraudRedressalH5Url") : null;
        HashMap hashMap = new HashMap();
        if (!(deepLinkData == null || deepLinkData.f50289g == null)) {
            Uri uri2 = deepLinkData.f50289g;
            Set<String> queryParameterNames = uri2 != null ? uri2.getQueryParameterNames() : null;
            if (!ab.d(queryParameterNames)) {
                queryParameterNames = null;
            }
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    hashMap.put(str, (deepLinkData == null || (uri = deepLinkData.f50289g) == null) ? null : uri.getQueryParameter(str));
                }
            }
        }
        CharSequence charSequence = a2;
        if (charSequence == null || charSequence.length() == 0) {
            a2 = "https://dbt-ite.paytmbank.com/kyc/home";
        }
        String a3 = a(a2, (HashMap<String, String>) hashMap);
        if (a3 == null) {
            k.a();
        }
        a(context, a3);
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        Uri build;
        if (hashMap != null) {
            try {
                if (hashMap.size() > 0) {
                    Uri parse = Uri.parse(str);
                    Uri.Builder buildUpon = parse != null ? parse.buildUpon() : null;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str2 = (String) entry.getKey();
                        String str3 = (String) entry.getValue();
                        if (buildUpon != null) {
                            buildUpon.appendQueryParameter(str2, str3);
                        }
                    }
                    if (buildUpon == null || (build = buildUpon.build()) == null) {
                        return null;
                    }
                    return build.toString();
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* renamed from: net.one97.paytm.kych5.b.a$a  reason: collision with other inner class name */
    public static final class C0923a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f51046a;

        C0923a(Context context) {
            this.f51046a = context;
        }

        public final void a(String str, c.b bVar) {
            k.c(str, "key");
            if (bVar != null) {
                switch (str.hashCode()) {
                    case -1940613496:
                        if (str.equals("networkType")) {
                            bVar.a(b.b(this.f51046a));
                            return;
                        }
                        break;
                    case -1459599807:
                        if (str.equals("lastName")) {
                            bVar.a(b.i(this.f51046a));
                            return;
                        }
                        break;
                    case -1400970552:
                        if (str.equals("buildType")) {
                            bVar.a("release");
                            return;
                        }
                        break;
                    case -1133543344:
                        if (str.equals("deviceLocale")) {
                            bVar.a(b.g());
                            return;
                        }
                        break;
                    case -1068855134:
                        if (str.equals("mobile")) {
                            bVar.a(b.l(this.f51046a));
                            return;
                        }
                        break;
                    case -836030906:
                        if (str.equals("userId")) {
                            bVar.a(b.n(this.f51046a));
                            return;
                        }
                        break;
                    case -662089212:
                        if (str.equals("appVersionCode")) {
                            bVar.a(1);
                            return;
                        }
                        break;
                    case -661774686:
                        if (str.equals("appVersionName")) {
                            bVar.a(b.Q(this.f51046a));
                            return;
                        }
                        break;
                    case 96619420:
                        if (str.equals(AppConstants.KEY_EMAIL)) {
                            bVar.a(b.m(this.f51046a));
                            return;
                        }
                        break;
                    case 132835675:
                        if (str.equals("firstName")) {
                            bVar.a(b.h(this.f51046a));
                            return;
                        }
                        break;
                    case 780988929:
                        if (str.equals("deviceName")) {
                            bVar.a(Build.MODEL);
                            return;
                        }
                        break;
                    case 802258218:
                        if (str.equals("ssoToken")) {
                            bVar.a(com.paytm.utility.d.a(this.f51046a));
                            return;
                        }
                        break;
                    case 1109191185:
                        if (str.equals("deviceId")) {
                            bVar.a(Settings.Secure.getString(this.f51046a.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
                            return;
                        }
                        break;
                    case 1812004436:
                        if (str.equals("osVersion")) {
                            bVar.a(Integer.valueOf(b.d()));
                            return;
                        }
                        break;
                    case 1874684019:
                        if (str.equals("platform")) {
                            bVar.a(StringSet.Android);
                            return;
                        }
                        break;
                    case 1998308679:
                        if (str.equals("deviceManufacturer")) {
                            bVar.a(Build.MANUFACTURER);
                            return;
                        }
                        break;
                }
                bVar.a("");
            }
        }
    }

    private static void a(Context context, String str) {
        c cVar = c.f51043a;
        c.a("kyc", new C0923a(context));
        Bundle bundle = new Bundle();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : bundle.keySet()) {
            buildUpon.appendQueryParameter(str2, bundle.getString(str2));
        }
        bundle.putBoolean("paytmShowTitleBar", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        net.one97.paytm.d.a.a aVar = net.one97.paytm.d.a.a.f50281a;
        net.one97.paytm.d.a.a.a("kyc", "912d8dad0bfe0d1e828ad64023a64d7a55a8a4d1", str, bundle, "");
    }
}
