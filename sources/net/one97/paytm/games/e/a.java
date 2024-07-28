package net.one97.paytm.games.e;

import android.content.Context;
import android.net.Uri;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.games.activity.pfg.PFGBeansHistoryActivity;
import net.one97.paytm.games.e.a.e;
import net.one97.paytm.games.fragment.pfg.PFGHomeFragment;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GamepindSpsClient;
import net.one97.paytm.games.model.GamesGboClient;
import net.one97.paytm.games.model.GamesPcsClient;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpPostTxnDataRequest;
import net.one97.paytm.games.model.GpPostTxnDataResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.model.pfg.BeansInfo;
import net.one97.paytm.games.model.pfg.HomePageResponse;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a {
    public static String a() {
        String gtmString = g.a().c().getGtmString("gamepind_prod_detail_url");
        return f.a((Object) gtmString) ? "https://catalog.paytm.com/v1/mobile/product/" : gtmString;
    }

    public static String b() {
        String gtmString = g.a().c().getGtmString("gamepind_gen_token_url");
        return f.a((Object) gtmString) ? "https://secure.gamepind.com/cas/v1/s/accessToken" : gtmString;
    }

    public static String c() {
        String gtmString = g.a().c().getGtmString("gamepind_cms_serve_game_url");
        return f.a((Object) gtmString) ? "https://cms.gamepind.com/cms/v1/serve/game" : gtmString;
    }

    public static void a(Context context, b bVar, String str, a.b bVar2, String str2) {
        String gtmString = g.a().c().getGtmString("gamepind_cas_signup_url");
        if (f.a((Object) gtmString)) {
            gtmString = "https://secure.gamepind.com/cas/v1/open-id/oauth";
        }
        GamepindCasClient d2 = g.a().d();
        if (f.a((Object) str2)) {
            str2 = d2.source;
        }
        Uri.Builder buildUpon = Uri.parse(gtmString).buildUpon();
        buildUpon.appendPath(d2.mapperId);
        buildUpon.appendQueryParameter("redirect_uri", "ajax");
        buildUpon.appendQueryParameter("source", str2);
        buildUpon.appendQueryParameter("property", d2.property);
        String builder = buildUpon.toString();
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.SSO_TOKEN, g.a().c().getSSOToken(context));
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put("apikeyauthorization", c.a(d2.getApiKey()));
        hashMap.put("device_id", g.a().a(context));
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42880d = builder;
        bVar3.f42879c = a.C0715a.GET;
        bVar3.f42882f = hashMap;
        bVar3.j = bVar;
        bVar3.f42885i = new CJRSignupUser();
        bVar3.f42878b = a.c.GAMEPIND;
        bVar3.n = bVar2;
        bVar3.o = str;
        bVar3.l().a();
    }

    public static void a(Context context, GpPostTxnDataRequest gpPostTxnDataRequest, b bVar, int i2, String str, a.b bVar2) {
        String gtmString = g.a().c().getGtmString("gamepind_sps_billing_verification_url");
        if (f.a((Object) gtmString)) {
            gtmString = e.f35608a ? "http://securebox.gamepind.com/sps/v1/verify-google-billing" : "https://payments.gamepind.com/sps/v1/verify-google-billing";
        }
        GamepindSpsClient e2 = g.a().e();
        HashMap hashMap = new HashMap();
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put("accept", "application/json");
        hashMap.put("content-type", "application/json");
        hashMap.put("APIKeyAuthorization", c.a(e2.getApiKey()));
        hashMap.put("device_id", g.a().a(context));
        String b2 = new f().b(gpPostTxnDataRequest);
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42878b = a.c.GAMEPIND;
        bVar3.n = bVar2;
        bVar3.f42880d = gtmString;
        bVar3.f42882f = hashMap;
        bVar3.f42879c = a.C0715a.POST;
        bVar3.f42885i = new GpPostTxnDataResponse();
        bVar3.f42884h = b2;
        bVar3.o = str;
        bVar3.j = bVar;
        bVar3.q = new DefaultRetryPolicy(e2.verifyTimeoutMillis, i2, 1.0f);
        bVar3.l().a();
    }

    public static void a(Context context, HashMap<String, String> hashMap, b bVar, String str, a.b bVar2) {
        try {
            JSONObject jSONObject = new JSONObject(hashMap);
            String gtmString = g.a().c().getGtmString("gamepind_sps_dummy_response_url");
            if (f.a((Object) gtmString)) {
                gtmString = e.f35608a ? "http://securebox.gamepind.com/sps/v1/dummy-response" : "https://payments.gamepind.com/sps/v1/dummy-response";
            }
            GamepindSpsClient e2 = g.a().e();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("accept", "application/json");
            hashMap2.put("content-type", "application/json");
            hashMap2.put("APIKeyAuthorization", c.a(e2.getApiKey()));
            hashMap2.put("device_id", g.a().a(context));
            com.paytm.network.b bVar3 = new com.paytm.network.b();
            bVar3.f42877a = context;
            bVar3.f42878b = a.c.GAMEPIND;
            bVar3.n = bVar2;
            bVar3.f42880d = gtmString;
            bVar3.f42882f = hashMap2;
            bVar3.f42879c = a.C0715a.POST;
            bVar3.f42885i = new GpCommonBaseResponse();
            bVar3.f42884h = jSONObject.toString();
            bVar3.o = str;
            bVar3.j = bVar;
            bVar3.q = new DefaultRetryPolicy(2500, 4, 1.0f);
            bVar3.l().a();
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, b bVar) {
        String gtmString = g.a().c().getGtmString("games_game_game_all_data_url");
        if (f.a((Object) gtmString)) {
            gtmString = e.f35608a ? "http://stagingapps.gamepind.com/api/game/getGameAllData" : "https://apps.gamepind.com/api/game/getGameAllData";
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = PFGHomeFragment.class.getName();
        bVar2.f42880d = gtmString;
        bVar2.f42882f = a(context, "", "");
        bVar2.f42885i = new HomePageResponse();
        bVar2.j = bVar;
        bVar2.l().a();
    }

    public static void a(Context context, String str, String str2, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        String gtmString = g.a().c().getGtmString("games_mylibrary_synchronize_gamerecord_url");
        if (f.a((Object) gtmString)) {
            gtmString = e.f35608a ? "http://stagingapps.gamepind.com/api/mylibrary/synchronizeGameRecord" : "https://apps.gamepind.com/api/mylibrary/synchronizeGameRecord";
        }
        try {
            GamesGboClient h2 = g.a().h();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept", "application/json;charset=UTF-8");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Channel-CU", h2.mChannelCu);
            hashMap.put("Channel", h2.mChannel.toLowerCase());
            e eVar = e.f35596a;
            String a2 = e.a(str2);
            String str3 = "gameType=" + URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&userId=" + URLEncoder.encode(a2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&deviceId=" + URLEncoder.encode(g.a().a(context), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&gameIds=" + URLEncoder.encode("", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42878b = a.c.GAMEPIND;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.n = a.b.USER_FACING;
            bVar2.o = PFGHomeFragment.class.getName();
            bVar2.f42880d = gtmString;
            bVar2.f42882f = hashMap;
            bVar2.f42884h = str3;
            bVar2.f42885i = iJRPaytmDataModel;
            bVar2.j = bVar;
            bVar2.l().a();
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, b bVar) {
        String gtmString = g.a().c().getGtmString("games_pcs_passbook_url");
        if (f.a((Object) gtmString)) {
            gtmString = e.f35608a ? "http://pcs-stag.powerplay.net.in/pp/v1/passbook" : "https://pcs.gamepind.com/pp/v1/passbook";
        }
        String uri = Uri.parse(gtmString).buildUpon().appendQueryParameter("page_size", str).appendQueryParameter("count", str2).appendQueryParameter("start_date", str3).appendQueryParameter("end_date", str4).appendQueryParameter("transaction_type", str5).build().toString();
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = PFGBeansHistoryActivity.class.getName();
        bVar2.l = true;
        bVar2.f42880d = uri;
        bVar2.f42882f = a(context);
        bVar2.f42885i = new BeansInfo();
        bVar2.j = bVar;
        bVar2.l().a();
    }

    public static Map<String, String> a(Context context, String str, String str2) {
        GamesGboClient h2 = g.a().h();
        GamepindCasClient d2 = g.a().d();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=UTF-8");
        hashMap.put("Accept", "application/json;charset=UTF-8");
        hashMap.put("Channel-CU", h2.mChannelCu);
        hashMap.put("Channel", h2.mChannel.toLowerCase());
        StringBuilder sb = new StringBuilder();
        sb.append(f.b(context));
        hashMap.put("Build-CU", sb.toString());
        hashMap.put("property", d2.property);
        hashMap.put("userId", str2);
        hashMap.put(StringSet.token, str);
        hashMap.put("device_id", g.a().a(context));
        return hashMap;
    }

    private static Map<String, String> a(Context context) {
        GamesPcsClient g2 = g.a().g();
        GamesGboClient h2 = g.a().h();
        GamepindCasClient d2 = g.a().d();
        CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
        String str = g2.getApiKey() + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + System.currentTimeMillis();
        String str2 = "";
        String str3 = (a2 == null || f.a((Object) a2.access_token)) ? str2 : a2.access_token;
        String str4 = (a2 == null || f.a((Object) a2.customer_id)) ? str2 : a2.customer_id;
        if (a2 != null && !f.a((Object) a2.masked_msisdn)) {
            str2 = a2.masked_msisdn;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=UTF-8");
        hashMap.put("Accept", "application/json;charset=UTF-8");
        hashMap.put("Channel-CU", h2.mChannelCu);
        hashMap.put("Channel", h2.mChannel.toLowerCase());
        StringBuilder sb = new StringBuilder();
        sb.append(f.b(context));
        hashMap.put("Build-CU", sb.toString());
        hashMap.put("property", d2.property);
        hashMap.put("device_id", g.a().a(context));
        hashMap.put("AccessTokenAuthorization", c.a(str3));
        hashMap.put("MIDAuthorization", c.a(str));
        hashMap.put("customer_id", str4);
        hashMap.put("maskid", str2);
        return hashMap;
    }
}
