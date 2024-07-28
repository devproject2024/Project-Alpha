package net.one97.paytm.deeplink;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.extension.StringExtensionKt;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.j.a;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.c;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f50350a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final String f50351b;

    static {
        String name = i.class.getName();
        k.a((Object) name, "DeepLinkUtil::class.java.name");
        f50351b = name;
    }

    private i() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        if (com.paytm.utility.b.a(r2, r10) == false) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.deeplink.DeepLinkData a(android.content.Context r10, java.lang.String r11, android.os.Bundle r12) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r10, r0)
            net.one97.paytm.deeplink.DeepLinkData r1 = new net.one97.paytm.deeplink.DeepLinkData
            r1.<init>()
            r1.f50290h = r12
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001c
            int r2 = r2.length()
            if (r2 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            r5 = 38
            r6 = 36
            java.lang.String r7 = "url"
            java.lang.String r8 = "deepLinkData"
            r9 = 0
            if (r2 != 0) goto L_0x009f
            if (r11 != 0) goto L_0x002e
            kotlin.g.b.k.a()
        L_0x002e:
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r12 = "deepLinkUrl"
            kotlin.g.b.k.c(r11, r12)
            kotlin.g.b.k.c(r1, r8)
            java.lang.String r12 = kotlin.m.p.a((java.lang.String) r11, (char) r6, (char) r5)
            android.net.Uri r12 = android.net.Uri.parse(r12)
            if (r12 != 0) goto L_0x0044
            return r9
        L_0x0044:
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r10 = "uri"
            kotlin.g.b.k.c(r12, r10)
            boolean r10 = r12.isOpaque()
            if (r10 == 0) goto L_0x0054
            goto L_0x0088
        L_0x0054:
            java.lang.String r10 = r12.getQueryParameter(r7)
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0066
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r2 = 0
            goto L_0x0067
        L_0x0066:
            r2 = 1
        L_0x0067:
            if (r2 != 0) goto L_0x0087
            net.one97.paytm.j.c r2 = net.one97.paytm.j.c.a()
            java.lang.String r5 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.util.List r2 = net.one97.paytm.j.c.F()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x007e
            r0 = 1
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            if (r0 == 0) goto L_0x0087
            boolean r10 = com.paytm.utility.b.a((java.util.List<java.lang.String>) r2, (java.lang.String) r10)
            if (r10 == 0) goto L_0x0088
        L_0x0087:
            r3 = 1
        L_0x0088:
            if (r3 != 0) goto L_0x008b
            return r9
        L_0x008b:
            r1.f50289g = r12
            r1.f50283a = r11
            java.lang.String r10 = a(r12)
            if (r10 != 0) goto L_0x0096
            return r9
        L_0x0096:
            java.lang.String r11 = b(r12)
            r1.f50284b = r10
            r1.f50288f = r11
            return r1
        L_0x009f:
            if (r12 == 0) goto L_0x00f6
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r10 = "bundle"
            kotlin.g.b.k.c(r12, r10)
            kotlin.g.b.k.c(r1, r8)
            r1.f50290h = r12
            java.lang.String r10 = ""
            r1.f50283a = r10
            java.lang.String r10 = r12.getString(r7, r9)
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x00c1
            int r11 = r11.length()
            if (r11 != 0) goto L_0x00c2
        L_0x00c1:
            r3 = 1
        L_0x00c2:
            if (r3 != 0) goto L_0x00d8
            if (r10 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            java.lang.String r11 = kotlin.m.p.a((java.lang.String) r10, (char) r6, (char) r5)
            android.net.Uri r11 = android.net.Uri.parse(r11)
            if (r11 != 0) goto L_0x00d4
            return r9
        L_0x00d4:
            r1.f50289g = r11
            r1.f50283a = r10
        L_0x00d8:
            android.net.Uri r10 = r1.f50289g
            java.lang.String r10 = a(r10)
            java.lang.String r11 = "url_type"
            java.lang.String r10 = r12.getString(r11, r10)
            r1.f50284b = r10
            android.net.Uri r10 = r1.f50289g
            java.lang.String r10 = b(r10)
            java.lang.String r11 = "featuretype"
            java.lang.String r10 = r12.getString(r11, r10)
            r1.f50288f = r10
            return r1
        L_0x00f6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.i.a(android.content.Context, java.lang.String, android.os.Bundle):net.one97.paytm.deeplink.DeepLinkData");
    }

    private static String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        String host = uri.getHost();
        CharSequence charSequence = host;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        if (p.a(host, "homepage_secondary", true) || p.a(host, CLPConstants.GA_CHANNEL_NAME, true)) {
            return "homepage_secondary";
        }
        if (p.a(host, "deals", true)) {
            return "deals";
        }
        if (p.a(host, "paytmmall.com", true)) {
            return Utility.VERTICAL_NAME_MALL;
        }
        if (!host.equals("paytminsurance.co.in")) {
            return host;
        }
        if (f.a(uri.getPathSegments())) {
            return "insurance_buy";
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1) {
            return host;
        }
        String str = "/" + pathSegments.get(1);
        switch (str.hashCode()) {
            case -506571694:
                return str.equals("/car-insurance") ? "fourwheelerins" : host;
            case -379614149:
                if (str.equals("/term-life-insurance")) {
                    return "lifeins";
                }
                return host;
            case 150866648:
                if (str.equals("/health-insurance")) {
                    return "healthins";
                }
                return host;
            case 1818113669:
                if (str.equals("/two-wheeler-insurance")) {
                    return "twowheelerins";
                }
                return host;
            default:
                return host;
        }
    }

    private static String b(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getQueryParameter("featuretype");
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        if (deepLinkData != null) {
            c(context, deepLinkData);
            Intent intent = new Intent();
            intent.setData(Uri.parse(deepLinkData.f50286d));
            intent.putExtra("notificationBundle", deepLinkData.f50290h);
            a.a(context, intent);
        }
    }

    public static void a(Context context, Uri uri) {
        k.c(context, "context");
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("from");
            CharSequence charSequence = queryParameter;
            if (!(charSequence == null || charSequence.length() == 0) && p.a(queryParameter, "smart_notification", true)) {
                String host = uri.getHost();
                StringBuilder sb = new StringBuilder("smart notification  urlType : ");
                if (host == null) {
                    k.a();
                }
                sb.append(host);
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.a.a(context) != null ? com.paytm.utility.a.a(context) : "";
                k.a((Object) a2, "if (ApplaunchUtility.get…etUserId(context) else \"\"");
                hashMap.put("user_id", a2);
                hashMap.put("event_category", "smart_notification");
                hashMap.put("event_action", "smart_notification_clicked");
                hashMap.put("event_label", host);
                String queryParameter2 = uri.getQueryParameter("utm_source");
                String queryParameter3 = uri.getQueryParameter("utm_campaign");
                String queryParameter4 = uri.getQueryParameter("utm_medium");
                if (!StringExtensionKt.isEmptyOrNull(queryParameter2)) {
                    if (queryParameter2 != null) {
                        hashMap.put("utm_source", queryParameter2);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                }
                if (!StringExtensionKt.isEmptyOrNull(queryParameter3)) {
                    if (queryParameter3 != null) {
                        hashMap.put("utm_campaign", queryParameter3);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                }
                if (!StringExtensionKt.isEmptyOrNull(queryParameter4)) {
                    if (queryParameter4 != null) {
                        hashMap.put("utm_medium", queryParameter4);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                }
                a.b("smart_notification", (Map<String, Object>) hashMap, context);
            }
        }
    }

    public static boolean b(Context context, DeepLinkData deepLinkData) {
        boolean z;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (!com.paytm.utility.a.p(context)) {
            if (UpiConstants.UPI_RESET_TOKEN.equalsIgnoreCase(deepLinkData.f50288f)) {
                z = false;
            } else {
                z = ac.a(deepLinkData);
            }
            if (z || p.a(UpiConstants.URL_TYPE_CASH_WALLET, deepLinkData.f50284b, true) || p.a("paytm_wifi", deepLinkData.f50284b, true)) {
                return true;
            }
            ab abVar = ab.f50295a;
            if (ab.b(deepLinkData) || p.a("channels_home", deepLinkData.f50284b, true) || p.a("channels_detail", deepLinkData.f50284b, true) || p.a("channels_followed_stores", deepLinkData.f50284b, true) || p.a("fastag_toll", deepLinkData.f50284b, true) || p.a("edu-forms", deepLinkData.f50284b, true) || p.a("edu-coaching", deepLinkData.f50284b, true) || p.a("edu-explore", deepLinkData.f50284b, true) || p.a("edu-deals", deepLinkData.f50284b, true) || p.a("education-forms", deepLinkData.f50284b, true) || p.a("edu-predictor", deepLinkData.f50284b, true) || p.a("order_summary", deepLinkData.f50284b, true)) {
                return true;
            }
            ai aiVar = ai.f50315a;
            if (p.a(ai.a(), deepLinkData.f50284b, true) || p.a("saved_card", deepLinkData.f50284b, true) || p.a("add_card", deepLinkData.f50284b, true) || p.a("active_subscription", deepLinkData.f50284b, true) || p.a("passcode", deepLinkData.f50284b, true) || p.a("profile", deepLinkData.f50284b, true) || p.a("payment_preference", deepLinkData.f50284b, true)) {
                return true;
            }
            a aVar = a.f50291a;
            k.c(deepLinkData, "deepLinkData");
            if (a.a(deepLinkData)) {
                return true;
            }
            v vVar = v.f50378a;
            k.c(deepLinkData, "deepLinkData");
            if (v.a(deepLinkData)) {
                return true;
            }
            e eVar = e.f50333a;
            if (e.b(deepLinkData)) {
                return true;
            }
            aj ajVar = aj.f50320a;
            if (aj.b(deepLinkData)) {
                return true;
            }
            f fVar = f.f50341a;
            k.c(deepLinkData, "deepLinkData");
            if (f.b(deepLinkData)) {
                return true;
            }
            ae aeVar = ae.f50307a;
            k.c(deepLinkData, "deepLinkData");
            if (ae.a(deepLinkData)) {
                return true;
            }
            af afVar = af.f50311a;
            if (af.b(deepLinkData)) {
                return true;
            }
            r rVar = r.f50366a;
            if (r.b(deepLinkData)) {
                return true;
            }
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData, Bundle bundle) {
        boolean z;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Intent intent = new Intent(context, AJRAuthActivity.class);
        if (deepLinkData.f50290h != null) {
            intent.addFlags(67108864);
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            z = bundle.getBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN);
        } else {
            z = false;
        }
        intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, z);
        intent.putExtra("deeplink", deepLinkData.f50283a);
        intent.putExtra(UpiConstants.EXTRA_KEY_DEEPLINK_BUNDLE, deepLinkData.f50290h);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void c(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (deepLinkData.f50283a != null) {
            deepLinkData.f50285c = c.b(context, deepLinkData.f50283a);
            if (deepLinkData.f50285c != null) {
                String str = deepLinkData.f50285c;
                if (str == null) {
                    k.a();
                }
                Uri parse = Uri.parse(p.a(str, '$', '&'));
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter("url");
                    String host = parse.getHost();
                    deepLinkData.f50287e = host;
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Set<String> queryParameterNames = parse.getQueryParameterNames();
                        if (queryParameterNames != null) {
                            for (String next : queryParameterNames) {
                                if (!p.a(next, "url", true)) {
                                    String queryParameter2 = parse.getQueryParameter(next);
                                    if (p.a(next, "related_category", true)) {
                                        queryParameter2 = URLEncoder.encode(queryParameter2, "utf-8");
                                    }
                                    if (queryParameter == null) {
                                        k.a();
                                    }
                                    if (!p.a((CharSequence) queryParameter, (CharSequence) "?", false)) {
                                        queryParameter = queryParameter + '?' + next + '=' + queryParameter2;
                                    } else {
                                        queryParameter = queryParameter + '&' + next + '=' + queryParameter2;
                                    }
                                }
                            }
                            CharSequence charSequence = queryParameter;
                            if (!TextUtils.isEmpty(charSequence)) {
                                if (queryParameter == null) {
                                    k.a();
                                }
                                if (p.a(charSequence, (CharSequence) AppConstants.AND_SIGN, false) && !p.a(charSequence, (CharSequence) "?", false)) {
                                    queryParameter = new l(AppConstants.AND_SIGN).replaceFirst(charSequence, "?");
                                }
                            }
                            if (queryParameter == null) {
                                k.a();
                            }
                            if (queryParameter.charAt(queryParameter.length() - 1) == '/') {
                                queryParameter = queryParameter.substring(0, queryParameter.length() - 1);
                                k.b(queryParameter, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            CharSequence charSequence2 = queryParameter;
                            if (!TextUtils.isEmpty(charSequence2) && !p.a(charSequence2, (CharSequence) "versionidentifier", false) && !TextUtils.isEmpty(host) && !p.a(host, "train_order_summary", true) && !p.a(host, "train_order_summary_v2", true)) {
                                if (!p.a(charSequence2, (CharSequence) "?", false)) {
                                    queryParameter = queryParameter + "?versionidentifier=1";
                                } else {
                                    queryParameter = queryParameter + "&versionidentifier=1";
                                }
                            }
                            deepLinkData.f50286d = queryParameter;
                            return;
                        }
                        return;
                    }
                    deepLinkData.f50286d = deepLinkData.f50283a;
                    deepLinkData.f50287e = deepLinkData.f50284b;
                }
            }
        }
    }
}
