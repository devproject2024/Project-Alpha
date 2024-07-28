package net.one97.paytm.games.e;

import android.content.Context;
import android.net.Uri;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.t;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.games.e.a.d;
import net.one97.paytm.games.model.CJRGenerateAuthAccessToken;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GamepindTaskEngineClient;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpTasksListResponse;
import net.one97.paytm.games.model.PFGWalletBalancesResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.model.pfg.GamesHeaderSmsData;
import net.one97.paytm.games.model.pfg.LoyaltyTaskPushRequest;
import net.one97.paytm.games.model.pfg.PFGUserTransactionResponse;
import net.one97.paytm.games.model.pfg.TaskGratifyRequest;
import net.one97.paytm.upi.util.UpiConstants;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f35626a = new j();

    private j() {
    }

    public static a a(String str, b bVar) {
        k.c(str, "taskId");
        g a2 = g.a();
        k.a((Object) a2, "GpSingleton.getInstance()");
        Context b2 = a2.b();
        CJRSignupUser a3 = net.one97.paytm.games.b.a.a();
        if (a3 == null) {
            return null;
        }
        GamepindTaskEngineClient f2 = g.a().f();
        k.a((Object) f2, "GpSingleton.getInstance(…kEngineClient(appContext)");
        g a4 = g.a();
        k.a((Object) a4, "GpSingleton.getInstance()");
        String gtmString = a4.c().getGtmString("gamepind_task_push_url");
        CharSequence charSequence = gtmString;
        if (charSequence == null || p.a(charSequence)) {
            gtmString = f2.taskPushUrl;
        }
        CharSequence charSequence2 = gtmString;
        if (charSequence2 == null || p.a(charSequence2)) {
            gtmString = e.f35608a ? "https://securebox.gamepind.com/task-engine/v2/task/push/" : "https://tasks.gamepind.com/v2/task/push/";
        }
        Uri.Builder buildUpon = Uri.parse(gtmString + str).buildUpon();
        buildUpon.appendQueryParameter("showClaimed", "true");
        String builder = buildUpon.toString();
        Map<String, String> b3 = ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("AccessTokenAuthorization", c.a(a3.access_token)), t.a("apikeyauthorization", c.a(f2.getApiKey())), t.a("device_id", g.a().a(b2))});
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = b2;
        bVar2.f42880d = builder;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42882f = b3;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.n = a.b.SILENT;
        bVar2.o = a.c.GAMEPIND.name();
        bVar2.j = bVar;
        d dVar = d.f35594a;
        String str2 = a3.customer_id;
        k.a((Object) str2, "it.customer_id");
        String str3 = a3.masked_msisdn;
        k.a((Object) str3, "it.masked_msisdn");
        String str4 = f2.eventCode;
        k.a((Object) str4, "gpTaskEngineClient.eventCode");
        String str5 = f2.appCode;
        k.a((Object) str5, "gpTaskEngineClient.appCode");
        String str6 = f2.gameName;
        k.a((Object) str6, "gpTaskEngineClient.gameName");
        bVar2.f42884h = d.a(new LoyaltyTaskPushRequest(str2, str3, str4, str5, str6, (String) null, 32, (g) null));
        bVar2.v = "application/json";
        bVar2.f42885i = new GpTasksListResponse();
        bVar2.l().a();
        return null;
    }

    public static a a(String str, String str2, String str3, b bVar) {
        b bVar2 = bVar;
        String str4 = str;
        k.c(str, "pRuleId");
        String str5 = str2;
        k.c(str2, "pEventId");
        String str6 = str3;
        k.c(str3, "pClaimId");
        k.c(bVar2, "pListener");
        g a2 = g.a();
        k.a((Object) a2, "GpSingleton.getInstance()");
        Context b2 = a2.b();
        CJRSignupUser a3 = net.one97.paytm.games.b.a.a();
        if (a3 == null) {
            return null;
        }
        GamepindTaskEngineClient f2 = g.a().f();
        k.a((Object) f2, "GpSingleton.getInstance(…kEngineClient(appContext)");
        g a4 = g.a();
        k.a((Object) a4, "GpSingleton.getInstance()");
        String gtmString = a4.c().getGtmString("gamepind_task_gratify_url");
        CharSequence charSequence = gtmString;
        if (charSequence == null || p.a(charSequence)) {
            gtmString = f2.gratifyUrl;
        }
        CharSequence charSequence2 = gtmString;
        if (charSequence2 == null || p.a(charSequence2)) {
            gtmString = e.f35608a ? "https://securebox.gamepind.com/task-engine/task/claim/gratify" : "https://tasks.gamepind.com/task/claim/gratify";
        }
        Map<String, String> b3 = ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("AccessTokenAuthorization", c.a(a3.access_token)), t.a("apikeyauthorization", c.a(f2.getApiKey())), t.a("device_id", g.a().a(b2))});
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = b2;
        bVar3.f42880d = gtmString;
        bVar3.f42879c = a.C0715a.POST;
        bVar3.f42882f = b3;
        bVar3.f42878b = a.c.GAMEPIND;
        bVar3.n = a.b.SILENT;
        bVar3.o = a.c.GAMEPIND.name();
        bVar3.j = bVar2;
        d dVar = d.f35594a;
        String str7 = f2.appCode;
        k.a((Object) str7, "gpTaskEngineClient.appCode");
        String str8 = a3.customer_id;
        k.a((Object) str8, "it.customer_id");
        String str9 = a3.masked_msisdn;
        k.a((Object) str9, "it.masked_msisdn");
        bVar3.f42884h = d.a(new TaskGratifyRequest(str, str2, str3, str7, str8, str9));
        bVar3.v = "application/json";
        bVar3.f42885i = new GpCommonBaseResponse();
        bVar3.l().a();
        return null;
    }

    public static a a(b bVar) {
        k.c(bVar, "pListener");
        g a2 = g.a();
        k.a((Object) a2, "GpSingleton.getInstance()");
        Context b2 = a2.b();
        CJRSignupUser a3 = net.one97.paytm.games.b.a.a();
        String str = null;
        if (a3 == null) {
            return null;
        }
        g a4 = g.a();
        k.a((Object) a4, "GpSingleton.getInstance()");
        String gtmString = a4.c().getGtmString("gamepind_cas_base_url");
        if (f.a((Object) gtmString)) {
            gtmString = "https://secure.gamepind.com/cas";
        }
        GamepindCasClient d2 = g.a().d();
        Uri.Builder buildUpon = Uri.parse(gtmString + "/v1/s/user/invite").buildUpon();
        b bVar2 = b.f35599a;
        GamesHeaderSmsData value = b.a().getValue();
        if (value != null) {
            str = value.getTemplate();
        }
        buildUpon.appendQueryParameter("tn", str);
        Map<String, String> hashMap = new HashMap<>();
        k.a((Object) d2, "gpCasClient");
        String a5 = c.a(d2.getApiKey());
        k.a((Object) a5, "GamesUtils.getBasicTimed…Value(gpCasClient.apiKey)");
        hashMap.put("ApiKeyAuthorization", a5);
        String a6 = c.a(a3.access_token);
        k.a((Object) a6, "GamesUtils.getBasicTimed…nUpResponse.access_token)");
        hashMap.put("AccessTokenAuthorization", a6);
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        String a7 = g.a().a(b2);
        k.a((Object) a7, "GpSingleton.getInstance().getDeviceId(appContext)");
        hashMap.put("device_id", a7);
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = b2;
        bVar3.f42880d = buildUpon.toString();
        bVar3.f42879c = a.C0715a.GET;
        bVar3.f42882f = hashMap;
        bVar3.f42878b = a.c.GAMEPIND;
        bVar3.n = a.b.SILENT;
        bVar3.o = a.c.GAMEPIND.name();
        bVar3.j = bVar;
        bVar3.f42885i = new GpCommonBaseResponse();
        return bVar3.l();
    }

    public static a b(b bVar) {
        k.c(bVar, "pListener");
        CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
        if (a2 == null) {
            return null;
        }
        g a3 = g.a();
        k.a((Object) a3, "GpSingleton.getInstance()");
        Context b2 = a3.b();
        g a4 = g.a();
        k.a((Object) a4, "GpSingleton.getInstance()");
        String gtmString = a4.c().getGtmString("games_pfg_wallet_balances_url");
        CharSequence charSequence = gtmString;
        if (charSequence == null || p.a(charSequence)) {
            gtmString = "https://wallet.gamepind.com/api/wallet/getBalance";
        }
        Uri.Builder buildUpon = Uri.parse(gtmString).buildUpon();
        Map<String, String> hashMap = new HashMap<>();
        String a5 = c.a(a2.access_token);
        k.a((Object) a5, "GamesUtils.getBasicTimed…nUpResponse.access_token)");
        hashMap.put("AccessTokenAuthorization", a5);
        hashMap.put("Platform-CU", "android");
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        String a6 = g.a().a(b2);
        k.a((Object) a6, "GpSingleton.getInstance().getDeviceId(appContext)");
        hashMap.put("device_id", a6);
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = b2;
        bVar2.f42880d = buildUpon.toString();
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42882f = hashMap;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.n = a.b.SILENT;
        bVar2.o = a.c.GAMEPIND.name();
        bVar2.j = bVar;
        bVar2.f42885i = new PFGWalletBalancesResponse();
        a l = bVar2.l();
        l.a();
        return l;
    }

    public static a a(Context context, b bVar) {
        k.c(context, "pContext");
        k.c(bVar, "pListener");
        g a2 = g.a();
        k.a((Object) a2, "GpSingleton.getInstance()");
        String gtmString = a2.c().getGtmString("passFirstGamesStorefrontUrl");
        CharSequence charSequence = gtmString;
        boolean z = false;
        if (charSequence == null || p.a(charSequence)) {
            gtmString = "https://storefront.paytm.com/v2/h/pfg-passbook-store";
        }
        String c2 = com.paytm.utility.a.c(context, gtmString);
        Map<String, String> hashMap = new HashMap<>();
        String a3 = com.paytm.utility.a.a(context);
        CharSequence charSequence2 = a3;
        if (!(charSequence2 == null || p.a(charSequence2))) {
            hashMap.put("userId", a3);
        }
        String sSOToken = g.a().c().getSSOToken(context);
        CharSequence charSequence3 = sSOToken;
        if (charSequence3 == null || p.a(charSequence3)) {
            z = true;
        }
        if (!z) {
            hashMap.put(AppConstants.SSO_TOKEN, sSOToken);
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.n = a.b.SILENT;
        bVar2.o = a.c.GAMEPIND.name();
        bVar2.f42882f = hashMap;
        bVar2.f42880d = c2;
        bVar2.f42885i = new CJRHomePageV2();
        bVar2.j = bVar;
        a l = bVar2.l();
        l.a();
        return l;
    }

    public static a a(b bVar, int i2, int i3, int i4) {
        k.c(bVar, "pListener");
        CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
        if (a2 == null) {
            return null;
        }
        g a3 = g.a();
        k.a((Object) a3, "GpSingleton.getInstance()");
        Context b2 = a3.b();
        g a4 = g.a();
        k.a((Object) a4, "GpSingleton.getInstance()");
        String gtmString = a4.c().getGtmString("games_pfg_user_transaction_url");
        CharSequence charSequence = gtmString;
        if (charSequence == null || p.a(charSequence)) {
            gtmString = "https://wallet.gamepind.com/api/wallet/clientTransactionsQuery";
        }
        Uri.Builder buildUpon = Uri.parse(gtmString).buildUpon();
        buildUpon.appendQueryParameter("pageNum", String.valueOf(i2));
        buildUpon.appendQueryParameter("pageSize", "10");
        buildUpon.appendQueryParameter("accountType", String.valueOf(i3));
        buildUpon.appendQueryParameter("transType", String.valueOf(i4));
        Map<String, String> hashMap = new HashMap<>();
        String a5 = c.a(a2.access_token);
        k.a((Object) a5, "GamesUtils.getBasicTimed…nUpResponse.access_token)");
        hashMap.put("AccessTokenAuthorization", a5);
        hashMap.put("Platform-CU", "android");
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        String a6 = g.a().a(b2);
        k.a((Object) a6, "GpSingleton.getInstance().getDeviceId(appContext)");
        hashMap.put("device_id", a6);
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = b2;
        bVar2.f42880d = buildUpon.toString();
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42882f = hashMap;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.n = a.b.SILENT;
        bVar2.o = a.c.GAMEPIND.name();
        bVar2.j = bVar;
        bVar2.f42885i = new PFGUserTransactionResponse();
        a l = bVar2.l();
        l.a();
        return l;
    }

    public static a a(Context context, String str, b bVar) {
        GamepindCasClient d2 = g.a().d();
        CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
        Uri.Builder buildUpon = Uri.parse(a.b()).buildUpon();
        buildUpon.appendQueryParameter("destinationMID", str);
        buildUpon.appendQueryParameter("property", d2.property);
        Map<String, String> hashMap = new HashMap<>();
        String a3 = c.a(a2 != null ? a2.access_token : null);
        k.a((Object) a3, "GamesUtils.getBasicTimed…rBasicInfo?.access_token)");
        hashMap.put("accesstokenauthorization", a3);
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        k.a((Object) d2, "gamepindCasClient");
        String a4 = c.a(d2.getApiKey());
        k.a((Object) a4, "GamesUtils.getBasicTimed…gamepindCasClient.apiKey)");
        hashMap.put("apikeyauthorization", a4);
        String a5 = g.a().a(context);
        k.a((Object) a5, "GpSingleton.getInstance().getDeviceId(pContext)");
        hashMap.put("device_id", a5);
        hashMap.put("content-type", "application/json");
        hashMap.put("accept", "application/json");
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42880d = buildUpon.toString();
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42882f = hashMap;
        bVar2.j = bVar;
        bVar2.f42885i = new CJRGenerateAuthAccessToken();
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = a.c.GAMEPIND.name();
        a l = bVar2.l();
        l.a();
        k.a((Object) l, "cjrCommonNetworkCall");
        return l;
    }
}
