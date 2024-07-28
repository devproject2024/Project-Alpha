package net.one97.paytm.dynamic.module.money;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.paytmmoney.lite.mod.helper.IMoneyListener;
import com.paytmmoney.lite.mod.util.PMConstants;
import kotlin.g.b.k;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.j.c;

public final class PaytmMoneyModuleHelper implements IMoneyListener {
    private static final String CLIENT_ID = "Paytm";
    public static final PaytmMoneyModuleHelper INSTANCE = new PaytmMoneyModuleHelper();
    private static final String MINI_BUNDLE_VER = "1";

    public final String getAppVersion() {
        return "9.1.3";
    }

    public final String getAuthValue() {
        return "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=";
    }

    public final String getBuildType() {
        return "release";
    }

    public final String getClientId() {
        return CLIENT_ID;
    }

    public final String getUserPancard(Context context) {
        return "";
    }

    public final void openHomePage(Activity activity) {
    }

    private PaytmMoneyModuleHelper() {
    }

    public final String getUserId(Context context) {
        return a.a(context);
    }

    public final boolean isUserSignedIn(Context context) {
        return a.p(context);
    }

    private final void openSmartLinkUrl(Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(PMConstants.PAYTM_MONEY_SMART_LINK));
        if (activity != null) {
            activity.startActivity(intent);
        }
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean openPaytmMoneyNativeApp(android.app.Activity r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = "com.paytmmoney"
            boolean r0 = com.paytm.utility.b.h((android.content.Context) r0, (java.lang.String) r1)
            r1 = 0
            if (r0 == 0) goto L_0x0050
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0050 }
            r0.<init>()     // Catch:{ Exception -> 0x0050 }
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0050 }
            r3 = 1
            if (r2 == 0) goto L_0x0020
            int r2 = r2.length()     // Catch:{ Exception -> 0x0050 }
            if (r2 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r2 = 0
            goto L_0x0021
        L_0x0020:
            r2 = 1
        L_0x0021:
            if (r2 != 0) goto L_0x0040
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = com.paytmmoney.lite.mod.util.MoneyUtils.getDeepLinkUriForNative(r6)     // Catch:{ Exception -> 0x0050 }
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0050 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0050 }
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "android.intent.action.VIEW"
            r0.setAction(r2)     // Catch:{ Exception -> 0x0050 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0050 }
            r0.setData(r6)     // Catch:{ Exception -> 0x0050 }
        L_0x0040:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r6)     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x004a
            r5.startActivity(r0)     // Catch:{ Exception -> 0x0050 }
        L_0x004a:
            if (r5 == 0) goto L_0x004f
            r5.finish()
        L_0x004f:
            return r3
        L_0x0050:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.money.PaytmMoneyModuleHelper.openPaytmMoneyNativeApp(android.app.Activity, java.lang.String):boolean");
    }

    public final void openPaytmAuth(Activity activity) {
        Intent intent = new Intent(activity, AJRAuthActivity.class);
        if (activity != null) {
            activity.startActivityForResult(intent, 3);
        }
    }

    public final Object getGtmValue(Context context, String str) {
        q.d("getGtmValue key - ".concat(String.valueOf(str)));
        if (str == null) {
            return null;
        }
        int hashCode = str.hashCode();
        if (hashCode != 268182484) {
            if (hashCode != 1682752763 || !str.equals(CJRConstants.GTM_IS_LITE_ON_KEY)) {
                return null;
            }
            q.d("getGtmValue GTM_IS_LITE_ON_KEY called");
            k.a((Object) c.a(), "GTMLoader.getInstance()");
            return Boolean.valueOf(c.an());
        } else if (!str.equals(CJRConstants.GTM_H5_BUNDLE_KEY)) {
            return null;
        } else {
            q.d("getGtmValue GTM_H5_BUNDLE_KEY called");
            k.a((Object) c.a(), "GTMLoader.getInstance()");
            return c.am();
        }
    }

    public final void loadPage(Activity activity, String str, String str2, String str3, String str4, Bundle bundle) {
        q.d("MOD:: loadPage context - ".concat(String.valueOf(activity)));
        q.d("MOD:: loadPage url - ".concat(String.valueOf(str3)));
        q.d("MOD:: loadPage deepLinkUri - ".concat(String.valueOf(str4)));
        q.d("MOD:: loadPage bundle - ".concat(String.valueOf(bundle)));
        Boolean bool = null;
        String genericRequestParams = str3 != null ? INSTANCE.getGenericRequestParams(str3) : null;
        if (!URLUtil.isValidUrl(genericRequestParams)) {
            if (str4 != null) {
                bool = Boolean.valueOf(INSTANCE.openPaytmMoneyNativeApp(activity, str4));
            }
            if (bool == null) {
                k.a();
            }
            if (!bool.booleanValue()) {
                openSmartLinkUrl(activity);
            }
        } else if (genericRequestParams != null && str != null && str2 != null) {
            u.a().a(str, str2, genericRequestParams, bundle, str4, (Context) activity);
        }
    }

    public final String getSSOToken(Context context) {
        String q = a.q(context);
        k.a((Object) q, "ApplaunchUtility.getSSOToken(context)");
        return q;
    }

    private final String getGenericRequestParams(String str) {
        String uri = Uri.parse(str).buildUpon().appendQueryParameter("ver", "1").appendQueryParameter("origin", "paytm").build().toString();
        k.a((Object) uri, "uri.buildUpon()\n        …      .build().toString()");
        return uri;
    }
}
