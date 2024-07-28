package net.one97.paytm.payments.c.c;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.mapping.d;
import net.one97.paytm.bankCommon.utils.e;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.d.a.a.a;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.upi.util.UpiContract;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f17264a = new b();

    private b() {
    }

    public static void a(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.K(), (String) null);
    }

    public static void a(Context context, Bundle bundle, String str) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        a(context, bundle, n.L(), str);
    }

    public static void b(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.M(), (String) null);
    }

    public static void c(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.N(), (String) null);
    }

    public static void d(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.O(), (String) null);
    }

    public static void e(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.P(), (String) null);
    }

    public static void f(Context context, Bundle bundle) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        a(context, bundle, n.Q(), (String) null);
    }

    public static boolean a() {
        return n.I();
    }

    public static boolean b() {
        return n.J();
    }

    public static boolean c() {
        return n.R();
    }

    public static boolean d() {
        return n.H();
    }

    public static boolean e() {
        return n.S();
    }

    public static boolean f() {
        return n.T();
    }

    public static boolean g() {
        return n.U();
    }

    public static final class a implements a.C0252a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f17265a;

        a(Context context) {
            this.f17265a = context;
        }

        public final void a(String str, a.b bVar) {
            k.c(str, "key");
            if (bVar != null) {
                switch (str.hashCode()) {
                    case -1940613496:
                        if (str.equals("networkType")) {
                            bVar.a(com.paytm.utility.b.b(this.f17265a));
                            return;
                        }
                        break;
                    case -1459599807:
                        if (str.equals("lastName")) {
                            bVar.a(com.paytm.utility.b.i(this.f17265a));
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
                            bVar.a(com.paytm.utility.b.g());
                            return;
                        }
                        break;
                    case -1068855134:
                        if (str.equals("mobile")) {
                            bVar.a(com.paytm.utility.b.l(this.f17265a));
                            return;
                        }
                        break;
                    case -884431007:
                        if (str.equals("bankScopeToken")) {
                            e.a aVar = e.f16328a;
                            bVar.a(e.a.a(this.f17265a));
                            return;
                        }
                        break;
                    case -836030906:
                        if (str.equals("userId")) {
                            bVar.a(com.paytm.utility.b.n(this.f17265a));
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
                            bVar.a(com.paytm.utility.b.Q(this.f17265a));
                            return;
                        }
                        break;
                    case 96619420:
                        if (str.equals(AppConstants.KEY_EMAIL)) {
                            bVar.a(com.paytm.utility.b.m(this.f17265a));
                            return;
                        }
                        break;
                    case 132835675:
                        if (str.equals("firstName")) {
                            bVar.a(com.paytm.utility.b.h(this.f17265a));
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
                            bVar.a(d.a(this.f17265a));
                            return;
                        }
                        break;
                    case 1109191185:
                        if (str.equals("deviceId")) {
                            bVar.a(Settings.Secure.getString(this.f17265a.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
                            return;
                        }
                        break;
                    case 1812004436:
                        if (str.equals("osVersion")) {
                            bVar.a(Integer.valueOf(com.paytm.utility.b.d()));
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

    private static void a(Context context, Bundle bundle, String str, String str2) {
        k.c(context, "ctx");
        k.c(bundle, "bundle");
        net.one97.paytm.d.a.a.a aVar = net.one97.paytm.d.a.a.a.f16781a;
        net.one97.paytm.d.a.a.a.a(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, new a(context));
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str3 : bundle.keySet()) {
            buildUpon.appendQueryParameter(str3, bundle.getString(str3));
        }
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            buildUpon.appendPath(str2);
        }
        bundle.putBoolean("paytmShowTitleBar", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString("paytmChangeStatusBarColor", n.X());
        bundle.putInt("statusBarStyle", 1);
        String uri = buildUpon.build().toString();
        k.a((Object) uri, "uriBuilder.build().toString()");
        q.d(uri);
        net.one97.paytm.d.a.b bVar = net.one97.paytm.d.a.b.f16783a;
        net.one97.paytm.d.a.b.a(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, "c6afc1a63f4644376e516db2ed73f2acb82315b6", uri, bundle, "");
    }
}
