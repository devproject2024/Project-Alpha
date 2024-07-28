package net.one97.paytm.games.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.c;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.e.i;
import net.one97.paytm.games.model.CJRGenerateAuthAccessToken;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.core.CJRGameInfo;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.upi.util.UpiConstants;

public class GpGameDataActivity extends GpBaseActivity implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f35475b = GpGameDataActivity.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private CJRGameInfo f35476c;

    /* renamed from: d  reason: collision with root package name */
    private GamepindCasClient f35477d;

    /* renamed from: e  reason: collision with root package name */
    private CJRSignupUser f35478e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f35479f;

    /* renamed from: g  reason: collision with root package name */
    private String f35480g;

    /* renamed from: h  reason: collision with root package name */
    private String f35481h;

    public void onCreate(Bundle bundle) {
        ShortcutManager shortcutManager;
        super.onCreate(bundle);
        getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        if (Build.VERSION.SDK_INT >= 26 && (shortcutManager = (ShortcutManager) getSystemService(ShortcutManager.class)) != null && shortcutManager.isRequestPinShortcutSupported()) {
            a a2 = i.a(getApplicationContext());
            if (f.a((Context) this, (String) null) && !a2.b("gamepind_home_shortcut_updated", false, false)) {
                Uri.Builder appendQueryParameter = Uri.parse("paytmmp://gamepind_weex").buildUpon().appendQueryParameter("clickSource", "shortcut");
                Intent splashIntent = g.a().c().getSplashIntent(this);
                splashIntent.setAction("android.intent.action.MAIN");
                splashIntent.setData(appendQueryParameter.build());
                ShortcutInfo build = new ShortcutInfo.Builder(this, f.b(this, (String) null)).setIcon(Icon.createWithResource(this, R.drawable.ic_gamepind_shortcut)).setShortLabel("Gamepind").setLongLabel("Gamepind").setIntent(splashIntent).build();
                a2.a("gamepind_home_shortcut_updated", true, true);
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(build);
                shortcutManager.updateShortcuts(arrayList);
            }
        }
        if (com.paytm.utility.a.p(this)) {
            b();
            return;
        }
        Intent loginScreenIntent = g.a().c().getLoginScreenIntent(this);
        loginScreenIntent.addFlags(67108864);
        startActivityForResult(loginScreenIntent, 3);
    }

    private void b() {
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
        this.f35479f = Uri.parse(cJRHomePageItem.getDeeplink());
        this.f35480g = this.f35479f.getQueryParameter("clickSource");
        if (f.a((Object) this.f35480g)) {
            this.f35480g = "others";
        }
        if ("shortcut".equalsIgnoreCase(this.f35480g)) {
            g.a().f35615b = true;
        }
        if (!com.paytm.utility.a.m(this)) {
            a(getString(R.string.com_gamepind_msg_network_connectivity), false);
            return;
        }
        this.f35481h = a(this.f35479f);
        if (f.a((Object) cJRHomePageItem.getContentID())) {
            a("PD-PID", true);
            return;
        }
        this.f35477d = g.a().d();
        a(getString(R.string.com_gamepind_msg_loading));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42880d = net.one97.paytm.games.e.a.a() + cJRHomePageItem.getContentID();
        bVar.f42879c = a.C0715a.GET;
        bVar.j = this;
        bVar.f42885i = new CJRGameInfo();
        bVar.f42878b = a.c.GAMEPIND;
        bVar.n = a.b.USER_FACING;
        bVar.o = f35475b;
        bVar.l().a();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!f.a((Activity) this)) {
            if (iJRPaytmDataModel instanceof CJRGameInfo) {
                this.f35476c = (CJRGameInfo) iJRPaytmDataModel;
                if (this.f35476c.attributes == null || f.a((Object) this.f35476c.attributes.html_5_link)) {
                    a("PD-URL", true);
                    return;
                }
                this.f35478e = net.one97.paytm.games.b.a.a();
                if (this.f35478e == null) {
                    net.one97.paytm.games.e.a.a((Context) this, (b) this, f35475b, a.b.USER_FACING, (String) null);
                } else {
                    c();
                }
            } else if (iJRPaytmDataModel instanceof CJRSignupUser) {
                a((CJRSignupUser) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRGenerateAuthAccessToken) {
                a((CJRGenerateAuthAccessToken) iJRPaytmDataModel);
            } else {
                a("UNK", true);
            }
        }
    }

    private void a(CJRSignupUser cJRSignupUser) {
        if (cJRSignupUser.code == 2001) {
            this.f35478e = cJRSignupUser;
            net.one97.paytm.games.b.a.a(this.f35478e);
            c();
        } else if (cJRSignupUser.code == 3012) {
            net.one97.paytm.games.b.a.a((CJRSignupUser) null);
            a((GpCommonBaseResponse) cJRSignupUser, "CS");
        } else {
            a("CS-" + cJRSignupUser.code, true);
        }
    }

    private void a(GpCommonBaseResponse gpCommonBaseResponse, String str) {
        a();
        String str2 = gpCommonBaseResponse.message;
        if (f.a((Object) str2)) {
            String string = getString(R.string.com_gamepind_some_error);
            if (gpCommonBaseResponse.code == 0) {
                str2 = string + " [" + str + "]";
            } else {
                str2 = string + " [" + str + gpCommonBaseResponse.code + "]";
            }
        }
        AlertDialog a2 = f.a((Activity) this, this.f35476c.name, str2, getString(R.string.com_gamepind_btn_cst), getString(R.string.com_gamepind_btn_ok), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                GpGameDataActivity.this.a(dialogInterface, i2);
            }
        });
        a2.setCanceledOnTouchOutside(false);
        a2.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            c.a((Activity) this);
        }
        finish();
    }

    private void a(CJRGenerateAuthAccessToken cJRGenerateAuthAccessToken) {
        if (cJRGenerateAuthAccessToken.code == 2055) {
            net.one97.paytm.games.b.a.a((CJRSignupUser) null);
            net.one97.paytm.games.e.a.a((Context) this, (b) this, f35475b, a.b.USER_FACING, (String) null);
        } else if (cJRGenerateAuthAccessToken.code == 3012) {
            net.one97.paytm.games.b.a.a((CJRSignupUser) null);
            a((GpCommonBaseResponse) cJRGenerateAuthAccessToken, "MT");
        } else if (f.a((Object) cJRGenerateAuthAccessToken.access_token)) {
            a("MT-" + cJRGenerateAuthAccessToken.code, true);
        } else {
            b(cJRGenerateAuthAccessToken.access_token);
        }
    }

    private void c() {
        if (this.f35476c.attributes.no_cp_token) {
            b((String) null);
        } else if (f.a((Object) this.f35476c.attributes.content_provider)) {
            a("PD-CP", true);
        } else {
            Uri.Builder buildUpon = Uri.parse(net.one97.paytm.games.e.a.b()).buildUpon();
            buildUpon.appendQueryParameter("destinationMID", this.f35476c.attributes.content_provider);
            buildUpon.appendQueryParameter("property", this.f35477d.property);
            HashMap hashMap = new HashMap();
            hashMap.put("accesstokenauthorization", c.a(this.f35478e.access_token));
            hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap.put("apikeyauthorization", c.a(this.f35477d.getApiKey()));
            hashMap.put("device_id", g.a().a(this));
            hashMap.put("content-type", "application/json");
            hashMap.put("accept", "application/json");
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42880d = buildUpon.toString();
            bVar.f42879c = a.C0715a.GET;
            bVar.f42882f = hashMap;
            bVar.j = this;
            bVar.f42885i = new CJRGenerateAuthAccessToken();
            bVar.f42878b = a.c.GAMEPIND;
            bVar.n = a.b.USER_FACING;
            bVar.o = f35475b;
            bVar.l().a();
        }
    }

    private void b(String str) {
        a();
        Uri.Builder buildUpon = Uri.parse(net.one97.paytm.games.e.a.c()).buildUpon();
        buildUpon.appendPath(String.valueOf(this.f35476c.product_id));
        buildUpon.appendQueryParameter("game_id", this.f35476c.attributes.operator);
        buildUpon.appendQueryParameter("source", this.f35477d.source);
        buildUpon.appendQueryParameter(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, this.f35476c.attributes.html_5_link);
        buildUpon.appendQueryParameter("customer_id", this.f35478e.customer_id);
        buildUpon.appendQueryParameter("user_id", this.f35478e.user_id);
        f.a(buildUpon, this.f35479f);
        a(buildUpon, this.f35479f.getQueryParameterNames());
        String str2 = str;
        c.a(this, buildUpon.build().toString(), f.a(this.f35476c), this.f35477d.property, str2, this.f35481h, this.f35480g, this.f35478e.masked_msisdn, this.f35479f.getBooleanQueryParameter("clearTop", true));
        finish();
    }

    private static void a(Uri.Builder builder, Set<String> set) {
        if (!set.contains("gp_playSource")) {
            builder.appendQueryParameter("gp_playSource", k.a() ? "paytmandroid" : "paytmmallandroid");
        }
    }

    private String a(Uri uri) {
        if (this.f35479f.getQueryParameterNames().contains("clearTop")) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("exitUrl");
        if (f.a((Object) queryParameter)) {
            return "gamepind_weex?clickSource=game-exit";
        }
        Uri parse = Uri.parse(queryParameter);
        return f.a((Object) parse.getQueryParameter("clickSource")) ? parse.buildUpon().appendQueryParameter("clickSource", "game-exit").build().toString() : queryParameter;
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!f.a((Activity) this)) {
            if (iJRPaytmDataModel instanceof CJRGenerateAuthAccessToken) {
                CJRGenerateAuthAccessToken cJRGenerateAuthAccessToken = (CJRGenerateAuthAccessToken) f.a(networkCustomError, (CJRGenerateAuthAccessToken) iJRPaytmDataModel, CJRGenerateAuthAccessToken.class);
                if (cJRGenerateAuthAccessToken == null) {
                    a("MT-H".concat(String.valueOf(i2)), true);
                } else {
                    a(cJRGenerateAuthAccessToken);
                }
            } else if (iJRPaytmDataModel instanceof CJRGameInfo) {
                a("PD-H".concat(String.valueOf(i2)), true);
            } else if (iJRPaytmDataModel instanceof CJRSignupUser) {
                CJRSignupUser cJRSignupUser = (CJRSignupUser) f.a(networkCustomError, (CJRSignupUser) iJRPaytmDataModel, CJRSignupUser.class);
                if (cJRSignupUser == null) {
                    a("CS-H".concat(String.valueOf(i2)), true);
                } else {
                    a(cJRSignupUser);
                }
            } else {
                a("UNK-H".concat(String.valueOf(i2)), true);
            }
        }
    }

    private void a(String str, boolean z) {
        a();
        if (z) {
            str = getString(R.string.com_gamepind_try_other_games) + " [" + str + "]";
        }
        Toast.makeText(this, str, 1).show();
        if (z && !g.a().i()) {
            startActivity(f.c(this));
        }
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            b();
        } else {
            a(getString(R.string.com_gamepind_login_required), false);
        }
    }
}
