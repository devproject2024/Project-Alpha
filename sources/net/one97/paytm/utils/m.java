package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.share.LinkGenerator;
import com.appsflyer.share.ShareInviteHelper;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.appsflyerModel.ReferalData;
import net.one97.paytm.appsflyerModel.ReferalResponse;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.i;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.ag;
import org.json.JSONObject;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f69757a = new m();

    private m() {
    }

    public static final class c implements AppsFlyerConversionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f69762a;

        public final void onAttributionFailure(String str) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        }

        public final void onConversionDataFail(String str) {
            k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        }

        c(Context context) {
            this.f69762a = context;
        }

        public final void onConversionDataSuccess(Map<String, ? extends Object> map) {
            String str;
            k.c(map, Item.CTA_URL_TYPE_MAP);
            try {
                if (map.containsKey("is_first_launch")) {
                    Object obj = map.get("is_first_launch");
                    if (obj == null) {
                        throw new u("null cannot be cast to non-null type kotlin.Boolean");
                    } else if (!((Boolean) obj).booleanValue()) {
                    } else {
                        if (map.containsKey("af_paytm_deeplink")) {
                            m mVar = m.f69757a;
                            m.a(this.f69762a, (String) map.get("af_paytm_deeplink"), (Map) map);
                        } else if (map.containsKey("referral_unique_link")) {
                            m mVar2 = m.f69757a;
                            m.a(map, this.f69762a, true);
                        } else if (map.containsKey("af_scheme") && map.get("af_scheme") != null && !TextUtils.isEmpty((String) map.get("af_scheme"))) {
                            String str2 = (String) map.get("af_scheme");
                            if (map.containsKey("af_scheme_parameter")) {
                                if (map.get("af_scheme_parameter") != null && !TextUtils.isEmpty((String) map.get("af_scheme_parameter"))) {
                                    m mVar3 = m.f69757a;
                                    str2 = str2 + "?" + m.a((String) map.get("af_scheme_parameter"));
                                }
                            }
                            if (map.containsKey("af_url") && map.get("af_url") != null && !TextUtils.isEmpty((String) map.get("af_url"))) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                if (str2 == null) {
                                    k.a();
                                }
                                if (p.a((CharSequence) str2, (CharSequence) "?", false)) {
                                    str = AppConstants.AND_SIGN;
                                } else {
                                    str = "?";
                                }
                                sb.append(str);
                                sb.append("url=");
                                sb.append((String) map.get("af_url"));
                                str2 = sb.toString();
                            }
                            if (map.containsKey("af_url_parameter") && map.get("af_url_parameter") != null && !TextUtils.isEmpty((String) map.get("af_url_parameter"))) {
                                m mVar4 = m.f69757a;
                                str2 = str2 + "?" + m.a((String) map.get("af_url_parameter"));
                            }
                            m mVar5 = m.f69757a;
                            m.a(this.f69762a, str2, (Map) map);
                        } else if (map.containsKey("af_dp")) {
                            m mVar6 = m.f69757a;
                            m.a(this.f69762a, (String) map.get("af_dp"), (Map) map);
                        } else {
                            String str3 = (String) map.get("af_sub1");
                            String str4 = (String) map.get("af_status");
                            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && p.a(str4, "Non-organic", true)) {
                                String concat = "paytmmp://".concat(String.valueOf(str3));
                                String a2 = m.f69757a.a(map);
                                if (!TextUtils.isEmpty(a2)) {
                                    concat = concat + a2;
                                }
                                m.f69757a.b(concat, this.f69762a);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    getClass().getSimpleName();
                    q.b(e2.getMessage());
                }
            }
        }

        public final void onAppOpenAttribution(Map<String, String> map) {
            k.c(map, Item.CTA_URL_TYPE_MAP);
            if (AppsFlyerLibCore.getInstance().getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(this.f69762a), false) > 1) {
                m mVar = m.f69757a;
                m.a((HashMap) map, this.f69762a);
            }
        }
    }

    public static void a(Context context) {
        k.c(context, "context");
        AppsFlyerLib.getInstance().init("wpZN8Fuq9nbFGqBnnDLU3H", new c(context), context.getApplicationContext());
    }

    public static String a(String str) {
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (TextUtils.isEmpty(str2)) {
                    str2 = str2 + next + '=' + string;
                } else {
                    str2 = str2 + '&' + next + '=' + string;
                }
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static x a(String str, Context context) {
        if (str == null) {
            return null;
        }
        f69757a.b(str, context);
        return x.f47997a;
    }

    /* access modifiers changed from: private */
    public final void b(String str, Context context) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    h.a aVar = h.f50349a;
                    h.a.a(context, str, (Bundle) null);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    getClass().getSimpleName();
                    q.b(e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final String a(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (!TextUtils.isEmpty(str)) {
                    if (value == null) {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    } else if (!TextUtils.isEmpty((CharSequence) value)) {
                        if (z) {
                            z = false;
                            sb.append("?");
                        } else {
                            sb.append(AppConstants.AND_SIGN);
                        }
                        sb.append(URLEncoder.encode(str, AppConstants.UTF_8));
                        sb.append("=");
                        sb.append(URLEncoder.encode((String) value, AppConstants.UTF_8));
                    }
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return null;
            }
            getClass().getSimpleName();
            q.b(e2.getMessage());
            return null;
        }
    }

    public static void a(Context context, String str) {
        String str2;
        k.c(str, "link");
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("referral_link", (String) null);
        String str3 = p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://staging.paytm.com/papi/v5/promocard/supercash/referral/association" : "https://gateway.paytm.com/api/v5/promocard/supercash/referral/association";
        if (TextUtils.isEmpty(a2)) {
            str2 = str3 + "?link=" + str + "&clicked_at=" + System.currentTimeMillis();
        } else {
            str2 = a2 + "?link=" + str + "&clicked_at=" + System.currentTimeMillis();
        }
        Map<String, String> hashMap = new HashMap<>();
        String b2 = t.b(context);
        k.a((Object) b2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, b2);
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = context;
        bVar.f42880d = str2;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42882f = hashMap;
        bVar.j = new b(context, str);
        bVar.f42885i = new ReferalResponse((Integer) null, (ReferalData) null, (ArrayList) null, 7, (g) null);
        bVar.f42878b = a.c.HOME;
        bVar.n = a.b.SILENT;
        bVar.o = "CJRAppsFlyerHelper";
        bVar.l().a();
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f69760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f69761b;

        b(Context context, String str) {
            this.f69760a = context;
            this.f69761b = str;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            String deeplink;
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof ReferalResponse) {
                ReferalResponse referalResponse = (ReferalResponse) iJRPaytmDataModel;
                Integer component1 = referalResponse.component1();
                ReferalData component2 = referalResponse.component2();
                if (component1 != null && component1.intValue() == 1 && component2 != null && (deeplink = component2.getDeeplink()) != null) {
                    m.f69757a.b(deeplink, this.f69760a);
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            if (i2 == 401 || i2 == 403 || i2 == 410) {
                Intent intent = new Intent("af_login_time_out_broadcast_event");
                intent.putExtra("referral_unique_link", this.f69761b);
                androidx.localbroadcastmanager.a.a.a(CJRJarvisApplication.getAppContext()).a(intent);
            }
        }
    }

    public static void a(Context context, String str, HashMap<String, String> hashMap, kotlin.g.a.m<? super String, ? super Integer, ? extends Object> mVar, int i2) {
        k.c(mVar, "generateShortUrl");
        LinkGenerator generateInviteUrl = ShareInviteHelper.generateInviteUrl(context);
        k.a((Object) generateInviteUrl, "linkGenerator");
        generateInviteUrl.setChannel(str);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (!p.a("af_dp", str2, true)) {
                    generateInviteUrl.addParameter(str2, str3);
                }
            }
            String str4 = hashMap.get("af_dp");
            if (!TextUtils.isEmpty(str4)) {
                if (str4 == null) {
                    k.a();
                }
                String a2 = p.a(str4, '&', '$');
                if (p.b(a2, "paytmmp://", false)) {
                    try {
                        String a3 = p.a(a2, "paytmmp:/", "", false);
                        generateInviteUrl.setBaseDeeplink("paytmmp:/");
                        generateInviteUrl.setDeeplinkPath(URLEncoder.encode(a3, AppConstants.UTF_8));
                    } catch (Exception unused) {
                    }
                } else {
                    generateInviteUrl.setBaseDeeplink(a2);
                }
            }
        }
        generateInviteUrl.setBrandDomain("p.paytm.me");
        generateInviteUrl.generateLink(context, new a(mVar, i2));
    }

    public static final class a implements CreateOneLinkHttpTask.ResponseListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.m f69758a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f69759b;

        a(kotlin.g.a.m mVar, int i2) {
            this.f69758a = mVar;
            this.f69759b = i2;
        }

        public final void onResponse(String str) {
            k.c(str, "s");
            this.f69758a.invoke(str, Integer.valueOf(this.f69759b));
        }

        public final void onResponseError(String str) {
            k.c(str, "s");
            this.f69758a.invoke(str, Integer.valueOf(this.f69759b));
        }
    }

    /* access modifiers changed from: private */
    public static void a(Map<String, ? extends Object> map, Context context, boolean z) {
        ag.a aVar = ag.f69605a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = ag.a.a(applicationContext);
        a2.a("appsflyer_map_data", new f().b(map), true);
        a2.a("af_is_deferred", z, true);
    }

    public static final /* synthetic */ void a(Context context, String str, Map map) {
        i iVar = i.f50350a;
        DeepLinkData a2 = i.a(context, str, (Bundle) null);
        if (a2 != null) {
            i iVar2 = i.f50350a;
            if (i.b(context, a2)) {
                a((Map<String, ? extends Object>) map, context, true);
                return;
            }
        }
        a(str, context);
    }

    public static final /* synthetic */ void a(HashMap hashMap, Context context) {
        String str;
        if (hashMap == null) {
            return;
        }
        if (hashMap.containsKey("af_paytm_deeplink")) {
            a((String) hashMap.get("af_paytm_deeplink"), context);
        } else if (hashMap.containsKey("referral_unique_link")) {
            String str2 = (String) hashMap.get("referral_unique_link");
            if (TextUtils.isEmpty(t.b(context))) {
                a((Map<String, ? extends Object>) hashMap, context, false);
                Intent intent = new Intent("af_non_deferred_login_broadcast_event");
                intent.putExtra("referral_unique_link", str2);
                androidx.localbroadcastmanager.a.a.a(CJRJarvisApplication.getAppContext()).a(intent);
            } else if (!TextUtils.isEmpty(str2) && com.paytm.utility.b.c(context)) {
                if (str2 == null) {
                    k.a();
                }
                a(context, str2);
            }
        } else if (hashMap.containsKey("af_scheme") && hashMap.get("af_scheme") != null && !TextUtils.isEmpty((CharSequence) hashMap.get("af_scheme"))) {
            String str3 = (String) hashMap.get("af_scheme");
            try {
                if (hashMap.containsKey("af_scheme_parameter")) {
                    if (hashMap.get("af_scheme_parameter") != null && !TextUtils.isEmpty((CharSequence) hashMap.get("af_scheme_parameter"))) {
                        str3 = str3 + "?" + a((String) hashMap.get("af_scheme_parameter"));
                    }
                }
                if (hashMap.containsKey("af_url") && hashMap.get("af_url") != null && !TextUtils.isEmpty((CharSequence) hashMap.get("af_url"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    if (str3 == null) {
                        k.a();
                    }
                    if (p.a((CharSequence) str3, (CharSequence) "?", false)) {
                        str = AppConstants.AND_SIGN;
                    } else {
                        str = "?";
                    }
                    sb.append(str);
                    sb.append("url=");
                    sb.append((String) hashMap.get("af_url"));
                    str3 = sb.toString();
                }
                if (hashMap.containsKey("af_url_parameter") && hashMap.get("af_url_parameter") != null && !TextUtils.isEmpty((CharSequence) hashMap.get("af_url_parameter"))) {
                    str3 = str3 + "?" + a((String) hashMap.get("af_url_parameter"));
                }
                a(str3, context);
            } catch (Exception unused) {
            }
        } else if (hashMap.containsKey("af_dp")) {
            a((String) hashMap.get("af_dp"), context);
        }
    }
}
