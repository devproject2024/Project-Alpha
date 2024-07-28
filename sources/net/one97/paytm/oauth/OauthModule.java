package net.one97.paytm.oauth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.work.n;
import androidx.work.w;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.oauth.activity.AccountBlockLoginLogoutActivity;
import net.one97.paytm.oauth.activity.AccountUnblockActivity;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.asynctask.TokenUpgradeWorker;
import net.one97.paytm.oauth.e.e;
import net.one97.paytm.oauth.e.h;
import net.one97.paytm.oauth.e.i;
import net.one97.paytm.oauth.f.a;
import net.one97.paytm.oauth.fragment.UpdatePhoneConfirmBottomFragment;
import net.one97.paytm.oauth.fragment.ai;
import net.one97.paytm.oauth.fragment.bi;
import net.one97.paytm.oauth.fragment.s;
import net.one97.paytm.oauth.models.EmptyResModel;
import net.one97.paytm.oauth.models.TokenV3Data;
import net.one97.paytm.oauth.models.TokenV3ResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.b;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.o;

public class OauthModule {

    /* renamed from: a  reason: collision with root package name */
    private static b f52461a;

    public static void a(b bVar) {
        f52461a = bVar;
    }

    public static c a() {
        return f52461a.provideOathModuleConfig();
    }

    public static b b() {
        if (f52461a == null) {
            try {
                Class.forName("net.one97.paytm.auth.OAuthDataProviderImpl").getMethod("initOAuthModule", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        return f52461a;
    }

    public static void a(j jVar, h hVar, i iVar, boolean z, boolean z2) {
        if (!OAuthUtils.b() && !a.f55979a) {
            a a2 = a.a(z, z2);
            a2.f55982b = hVar;
            a2.f55983c = iVar;
            androidx.fragment.app.q a3 = jVar.a();
            a3.a((Fragment) a2, a.class.getName());
            a3.c();
        }
    }

    public static void a(Bundle bundle, j jVar, e eVar) {
        if (bundle.getSerializable("auth_flow") == b.SESSION_EXPIRY) {
            a(jVar, eVar, bundle, false);
        } else {
            a(jVar, eVar, bundle, true);
        }
    }

    private static void a(j jVar, e eVar, Bundle bundle, boolean z) {
        bi.b bVar = bi.f56437b;
        bi biVar = new bi();
        biVar.setArguments(bundle);
        biVar.setCancelable(z);
        biVar.a(eVar);
        androidx.fragment.app.q a2 = jVar.a();
        a2.a((Fragment) biVar, bi.class.getName());
        a2.c();
    }

    public static void a(j jVar) {
        UpdatePhoneConfirmBottomFragment.a aVar = UpdatePhoneConfirmBottomFragment.f56184b;
        UpdatePhoneConfirmBottomFragment updatePhoneConfirmBottomFragment = new UpdatePhoneConfirmBottomFragment();
        androidx.fragment.app.q a2 = jVar.a();
        a2.a((Fragment) updatePhoneConfirmBottomFragment, UpdatePhoneConfirmBottomFragment.class.getName());
        a2.c();
    }

    public static void b(j jVar) {
        a.a();
        if (a.a("enableAddEmailPopUp", true) && com.paytm.utility.b.r(b().getApplicationContext())) {
            net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
            if (net.one97.paytm.oauth.utils.q.j() && TextUtils.isEmpty(com.paytm.utility.b.m(b().getApplicationContext()))) {
                a.a();
                int i2 = 7;
                int a2 = a.a("addEmailInterval", 7);
                if (a2 != 0) {
                    i2 = a2;
                }
                long currentTimeMillis = System.currentTimeMillis();
                net.one97.paytm.oauth.utils.q qVar2 = net.one97.paytm.oauth.utils.q.f56798a;
                if (currentTimeMillis - net.one97.paytm.oauth.utils.q.m() > ((long) (i2 * 24 * 60 * 60 * 1000))) {
                    s.a aVar = s.f56612b;
                    s a3 = s.a.a(Bundle.EMPTY);
                    a3.setCancelable(false);
                    androidx.fragment.app.q a4 = jVar.a();
                    a4.a((Fragment) a3, s.class.getName());
                    a4.c();
                    net.one97.paytm.oauth.utils.q qVar3 = net.one97.paytm.oauth.utils.q.f56798a;
                    net.one97.paytm.oauth.utils.q.c(System.currentTimeMillis());
                }
            }
        }
    }

    public static void c(j jVar) {
        Bundle bundle = new Bundle();
        bundle.putString("screen_name", "edit_profile_page");
        s.a aVar = s.f56612b;
        s a2 = s.a.a(bundle);
        a2.setCancelable(false);
        androidx.fragment.app.q a3 = jVar.a();
        a3.a((Fragment) a2, s.class.getName());
        a3.c();
    }

    public static void c() {
        n nVar = (n) new n.a(TokenUpgradeWorker.class).c();
        if (androidx.work.impl.j.b(b().getApplicationContext()) != null) {
            androidx.work.impl.j.b(b().getApplicationContext()).a((w) nVar);
        }
    }

    public static void a(HashMap<String, String> hashMap, com.paytm.network.listener.b bVar) {
        String sSOToken = b().getSSOToken();
        if (TextUtils.isEmpty(sSOToken)) {
            net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
            sSOToken = net.one97.paytm.oauth.utils.q.u();
        }
        if (!TextUtils.isEmpty(sSOToken)) {
            o oVar = o.f56791a;
            if (o.a()) {
                Context applicationContext = b().getApplicationContext();
                a.a();
                String a2 = a.a("oauthTokenSv1");
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = com.paytm.utility.b.e(applicationContext, a2);
                    net.one97.paytm.oauth.utils.s sVar = net.one97.paytm.oauth.utils.s.f56801a;
                    HashMap<String, String> a3 = net.one97.paytm.oauth.utils.s.a();
                    a3.put("session_token", sSOToken);
                    if (hashMap != null && !hashMap.isEmpty()) {
                        for (Map.Entry next : hashMap.entrySet()) {
                            a3.put(next.getKey(), next.getValue());
                        }
                    }
                    o oVar2 = o.f56791a;
                    o.a(e2, l.a(a.C0715a.DELETE), a3, "");
                    com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(OAuthMainActivity.class.getName());
                    a4.n = a.b.SILENT;
                    a4.f42879c = a.C0715a.DELETE;
                    a4.f42880d = e2;
                    a4.f42882f = a3;
                    a4.j = bVar;
                    a4.f42885i = new EmptyResModel();
                    com.paytm.network.a l = a4.l();
                    if (!com.paytm.network.b.b.a(applicationContext)) {
                        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
                    } else {
                        l.a();
                    }
                }
            } else {
                Context applicationContext2 = b().getApplicationContext();
                a.a();
                String a5 = a.a("signout");
                if (URLUtil.isValidUrl(a5)) {
                    String e3 = com.paytm.utility.b.e(applicationContext2, a5);
                    net.one97.paytm.oauth.utils.s sVar2 = net.one97.paytm.oauth.utils.s.f56801a;
                    HashMap<String, String> a6 = net.one97.paytm.oauth.utils.s.a();
                    a6.put("access_token", sSOToken);
                    if (hashMap != null && !hashMap.isEmpty()) {
                        for (Map.Entry next2 : hashMap.entrySet()) {
                            a6.put(next2.getKey(), next2.getValue());
                        }
                    }
                    com.paytm.network.b a7 = net.one97.paytm.oauth.b.b.a(OauthModule.class.getName());
                    a7.n = a.b.SILENT;
                    a7.f42879c = a.C0715a.DELETE;
                    a7.f42880d = e3;
                    a7.f42882f = a6;
                    a7.j = bVar;
                    a7.f42885i = new EmptyResModel();
                    com.paytm.network.a l2 = a7.l();
                    if (!com.paytm.network.b.b.a(applicationContext2)) {
                        bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
                    } else {
                        l2.a();
                    }
                }
            }
        }
    }

    public static void a(final com.paytm.network.listener.b bVar, a.c cVar) {
        AnonymousClass1 r0 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                    TokenV3ResModel tokenV3ResModel = (TokenV3ResModel) iJRPaytmDataModel;
                    l.a(tokenV3ResModel);
                    com.paytm.network.listener.b bVar = bVar;
                    if (bVar != null) {
                        k.c(tokenV3ResModel, "tokenV3ResModel");
                        CJRPGTokenList cJRPGTokenList = new CJRPGTokenList();
                        cJRPGTokenList.setNetworkResponse(tokenV3ResModel.getNetworkResponse());
                        cJRPGTokenList.setPGTokenList(new ArrayList());
                        Iterator<TokenV3Data> it2 = tokenV3ResModel.getTokens().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            TokenV3Data next = it2.next();
                            if (k.a((Object) "wallet", (Object) next.getScope())) {
                                CJRPGToken cJRPGToken = new CJRPGToken();
                                cJRPGToken.setScopes(next.getScope());
                                cJRPGToken.setToken(next.getAccessToken());
                                Long expiresIn = next.getExpiresIn();
                                cJRPGToken.setExpires(expiresIn != null ? expiresIn.longValue() : 0);
                                b b2 = OauthModule.b();
                                k.a((Object) b2, "OauthModule.getOathDataProvider()");
                                cJRPGToken.setResourceOwnerId(b2.getUserId());
                                cJRPGTokenList.getPGTokenList().add(cJRPGToken);
                                new StringBuilder("Wallet Token:").append(next.getAccessToken());
                            }
                        }
                        bVar.onApiSuccess(cJRPGTokenList);
                    }
                } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                    l.a((CJRPGTokenList) iJRPaytmDataModel);
                    com.paytm.network.listener.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onApiSuccess(iJRPaytmDataModel);
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                o oVar = o.f56791a;
                if (o.a() && i2 == net.one97.paytm.oauth.utils.n.f56787f.intValue()) {
                    i2 = net.one97.paytm.oauth.utils.n.f56785d.intValue();
                    networkCustomError.setStatusCode(net.one97.paytm.oauth.utils.n.f56785d.intValue());
                }
                com.paytm.network.listener.b bVar = bVar;
                if (bVar != null) {
                    bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            }
        };
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        String s = net.one97.paytm.oauth.utils.q.s();
        o oVar = o.f56791a;
        if (!o.a() || TextUtils.isEmpty(s)) {
            String sSOToken = b().getSSOToken();
            Context applicationContext = b().getApplicationContext();
            a.a();
            String a2 = a.a("getalltokens");
            if (URLUtil.isValidUrl(a2)) {
                String e2 = com.paytm.utility.b.e(applicationContext, a2);
                net.one97.paytm.oauth.utils.s sVar = net.one97.paytm.oauth.utils.s.f56801a;
                HashMap<String, String> a3 = net.one97.paytm.oauth.utils.s.a();
                a3.put("access_token", sSOToken);
                com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(OauthModule.class.getName());
                a4.n = a.b.SILENT;
                a4.f42879c = a.C0715a.GET;
                a4.f42880d = e2;
                a4.f42882f = a3;
                a4.j = r0;
                a4.f42885i = new CJRPGTokenList();
                if (cVar != null) {
                    a4.f42878b = cVar;
                }
                com.paytm.network.a l = a4.l();
                if (!com.paytm.network.b.b.a(applicationContext)) {
                    r0.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
                } else {
                    l.a();
                }
            }
        } else {
            net.one97.paytm.oauth.b.b.a(s, (com.paytm.network.listener.b) r0, cVar);
        }
    }

    public static void d() {
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.p();
    }

    public static void a(Context context, Boolean bool, String str) {
        if (!bool.booleanValue()) {
            Intent intent = new Intent(context, AccountBlockLoginLogoutActivity.class);
            intent.putExtra("logout", bool);
            context.startActivity(intent);
        } else if (bool.booleanValue()) {
            a.a();
            if (a.a("oauthAccountBlockLogout", true)) {
                Intent intent2 = new Intent(context, AccountBlockLoginLogoutActivity.class);
                intent2.putExtra("logout", bool);
                intent2.putExtra("mobileNumber", str);
                context.startActivity(intent2);
            }
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AccountUnblockActivity.class);
        intent.putExtra("mobileNumber", str);
        context.startActivity(intent);
    }

    public static void a(final com.paytm.network.listener.b bVar, String str) {
        AnonymousClass2 r0 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                bVar.onApiSuccess(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (i2 == net.one97.paytm.oauth.utils.n.f56783b.intValue() || i2 == net.one97.paytm.oauth.utils.n.f56790i.intValue()) {
                    i2 = net.one97.paytm.oauth.utils.n.f56785d.intValue();
                    networkCustomError.setStatusCode(net.one97.paytm.oauth.utils.n.f56785d.intValue());
                }
                bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        Context applicationContext = b().getApplicationContext();
        a.a();
        String a2 = a.a("oauthV2UserSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2 + "?fetch_strategy=" + str);
            net.one97.paytm.oauth.utils.s sVar = net.one97.paytm.oauth.utils.s.f56801a;
            HashMap<String, String> a3 = net.one97.paytm.oauth.utils.s.a();
            a3.put("verification_type", "oauth_token");
            a3.put("data", b().getSSOToken());
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.GET), a3, "");
            com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(ai.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.GET;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.j = r0;
            a4.f42885i = new CJRUserInfoV2();
            com.paytm.network.a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                r0.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(j jVar, h hVar) {
        if (jVar.f() <= 0 || !(jVar.b(0) instanceof com.google.android.material.bottomsheet.b)) {
            net.one97.paytm.oauth.a.a aVar = new net.one97.paytm.oauth.a.a();
            aVar.f52466a = hVar;
            aVar.setCancelable(false);
            androidx.fragment.app.q a2 = jVar.a();
            a2.a((Fragment) aVar, net.one97.paytm.oauth.a.a.class.getName());
            a2.c();
        }
    }
}
