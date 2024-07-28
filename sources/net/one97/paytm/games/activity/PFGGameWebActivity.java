package net.one97.paytm.games.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.PFGGameWebActivity;
import net.one97.paytm.games.activity.pfg.PFGBeansHistoryActivity;
import net.one97.paytm.games.activity.pfg.PFGGameExitActivity;
import net.one97.paytm.games.d.a;
import net.one97.paytm.games.e.a.d;
import net.one97.paytm.games.e.e;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.e.h;
import net.one97.paytm.games.fragment.pfg.PFGHomeFragment;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GamesGboClient;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpPostTxnDataResponse;
import net.one97.paytm.games.model.GpTxnDatum;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.model.pfg.Game;
import net.one97.paytm.games.model.pfg.JoinGame;
import net.one97.paytm.games.model.pfg.JoinGameResponse;
import net.one97.paytm.games.services.GpBillingJobIntentService;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class PFGGameWebActivity extends GpBaseActivity implements View.OnClickListener, com.paytm.network.listener.b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f35510b = PFGGameWebActivity.class.getSimpleName();
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View f35511c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WebView f35512d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f35513e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f35514f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f35515g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f35516h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f35517i;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public Game m;
    /* access modifiers changed from: private */
    public long n;
    private net.one97.paytm.games.d.a o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public ArrayList<String> r;
    /* access modifiers changed from: private */
    public HashMap<String, String> s;
    /* access modifiers changed from: private */
    public String t;
    private String u;
    /* access modifiers changed from: private */
    public int v = -1;
    private boolean w;
    /* access modifiers changed from: private */
    public b x;
    /* access modifiers changed from: private */
    public String y;
    private HashMap<String, String> z;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        final Intent intent = getIntent();
        this.m = (Game) intent.getParcelableExtra("object1");
        this.k = this.m.getGameId();
        this.l = intent.getStringExtra("url");
        Game game = this.m;
        CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
        if (a2 == null) {
            finish();
        } else {
            if ("2".equals(game.getOrientaion())) {
                this.j = H5Param.LONG_LANDSCAPE;
            } else if ("1".equals(game.getOrientaion())) {
                this.j = "portrait";
            }
            String str2 = a2.access_token;
            String str3 = a2.masked_msisdn;
            AnonymousClass5 r4 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    try {
                        String str = new String(iJRPaytmDataModel.getNetworkResponse().data);
                        d dVar = d.f35594a;
                        JoinGameResponse joinGameResponse = (JoinGameResponse) d.a(str, JoinGameResponse.class);
                        if (!(joinGameResponse == null || joinGameResponse.getData() == null)) {
                            if (!f.a((Object) ((JoinGame) joinGameResponse.getData()).getUrl())) {
                                String unused = PFGGameWebActivity.this.A = ((JoinGame) joinGameResponse.getData()).getUrl();
                                if (!PFGGameWebActivity.this.A.isEmpty()) {
                                    Uri.Builder buildUpon = Uri.parse(PFGGameWebActivity.this.A).buildUpon();
                                    if (!f.a((Object) PFGGameWebActivity.this.l)) {
                                        f.a(buildUpon, Uri.parse(PFGGameWebActivity.this.l));
                                    }
                                    String unused2 = PFGGameWebActivity.this.A = com.paytm.utility.c.a(this, buildUpon.build().toString(), "webview", "1");
                                    if (f.a((Context) PFGGameWebActivity.this)) {
                                        PFGGameWebActivity.this.e();
                                        return;
                                    } else {
                                        PFGGameWebActivity.this.a(true);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        PFGGameWebActivity.s(PFGGameWebActivity.this);
                    } catch (Exception unused3) {
                        PFGGameWebActivity.s(PFGGameWebActivity.this);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    PFGGameWebActivity.s(PFGGameWebActivity.this);
                }
            };
            String gtmString = g.a().c().getGtmString("games_join_game_url");
            if (f.a((Object) gtmString)) {
                gtmString = e.f35608a ? "https://stagingapps.gamepind.com/api/game/getJoinGameUrl/<gameId>" : "https://apps.gamepind.com/api/game/getJoinGameUrl/<gameId>";
            }
            GamepindCasClient d2 = g.a().d();
            if ("241823467".equals(game.getGameId())) {
                str = e.f35608a ? "http://eventstaging.gamepind.com/event-center/m/game-list.html" : "https://gpl.gamepind.com/event-center/m/game-list.html";
            } else {
                str = game.getUrl();
            }
            Uri.Builder appendQueryParameter = Uri.parse(gtmString.replace("<gameId>", game.getGameId())).buildUpon().appendQueryParameter(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, str).appendQueryParameter("property", d2.property);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String builder = appendQueryParameter.appendQueryParameter("lastPlaytime", sb.toString()).appendQueryParameter("playtimes", "").appendQueryParameter("userId", str3).appendQueryParameter("destinationMID", game.getDestinationMID()).toString();
            GamesGboClient h2 = g.a().h();
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Content-Type", "application/json;charset=UTF-8");
            hashMap.put("Accept", "application/json;charset=UTF-8");
            hashMap.put("Channel-CU", h2.mChannelCu);
            hashMap.put("Channel", h2.mChannel.toLowerCase());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f.b((Context) this));
            hashMap.put("Build-CU", sb2.toString());
            hashMap.put("property", d2.property);
            hashMap.put(StringSet.token, str2);
            hashMap.put("device_id", g.a().a(this));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.GAMEPIND;
            bVar.f42879c = a.C0715a.GET;
            bVar.n = a.b.USER_FACING;
            bVar.o = PFGHomeFragment.class.getName();
            bVar.l = true;
            bVar.f42880d = builder;
            bVar.f42882f = hashMap;
            bVar.f42885i = new GpCommonBaseResponse();
            bVar.j = r4;
            bVar.l().a();
        }
        setRequestedOrientation(f.a(this.j));
        getWindow().addFlags(1152);
        setContentView(R.layout.com_gamepind_activity_game_web);
        a(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (this.m != null) {
            this.f35511c = findViewById(R.id.com_gamepind_game_top_strip);
            if (f.a(this.j) == 0) {
                this.f35511c.getLayoutParams().height = (int) ((getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                ((ImageView) findViewById(R.id.com_gamepind_header_logo)).setImageResource(R.drawable.games_logo);
            }
        }
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.com_gamepind_progress_bar_linear);
        this.f35512d = (WebView) findViewById(R.id.game_webview);
        this.f35513e = (ViewGroup) findViewById(R.id.root_activity);
        this.f35514f = (ViewGroup) findViewById(R.id.com_gamepind_container_web_error);
        findViewById(R.id.com_gamepind_img_more).setOnClickListener(this);
        this.f35512d.getSettings().setTextZoom(100);
        this.f35512d.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                String unused = PFGGameWebActivity.this.y = str;
                progressBar.setVisibility(0);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return net.one97.paytm.games.e.c.a((Activity) PFGGameWebActivity.this, str) || super.shouldOverrideUrlLoading(webView, str);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                String uri = webResourceRequest.getUrl() == null ? null : webResourceRequest.getUrl().toString();
                return net.one97.paytm.games.e.c.a((Activity) PFGGameWebActivity.this, uri) || super.shouldOverrideUrlLoading(webView, uri);
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PFGGameWebActivity.this.x.showNativeViews("1".equals(PFGGameWebActivity.this.m.isShowTitlebar()), false);
                String str2 = null;
                String unused = PFGGameWebActivity.this.y = null;
                progressBar.setVisibility(8);
                if (PFGGameWebActivity.this.n != 0) {
                    long currentTimeMillis = System.currentTimeMillis() - PFGGameWebActivity.this.n;
                    long unused2 = PFGGameWebActivity.this.n = 0;
                    if (PFGGameWebActivity.this.m != null) {
                        str2 = PFGGameWebActivity.this.m.getGameName();
                    }
                    String str3 = str2;
                    String stringExtra = intent.getStringExtra("clickSource");
                    if (f.a((Object) stringExtra)) {
                        stringExtra = "others";
                    }
                    f.a((Context) PFGGameWebActivity.this, "gamepind_webview", "/inbox/games/webview", "game_screen_loaded", stringExtra, str3, currentTimeMillis);
                }
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int i2;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (!f.a((Object) PFGGameWebActivity.this.y)) {
                    if (webResourceError == null) {
                        i2 = -1;
                    } else {
                        i2 = webResourceError.getErrorCode();
                    }
                    PFGGameWebActivity pFGGameWebActivity = PFGGameWebActivity.this;
                    if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                        webResourceRequest.getUrl();
                    }
                    PFGGameWebActivity.a(pFGGameWebActivity, i2);
                }
            }

            public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                if (!f.a((Object) PFGGameWebActivity.this.y)) {
                    PFGGameWebActivity.a(PFGGameWebActivity.this, i2);
                }
            }
        });
        this.f35512d.setWebChromeClient(new WebChromeClient() {

            /* renamed from: c  reason: collision with root package name */
            private Bitmap f35523c;

            public final void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                progressBar.setProgress(i2);
            }

            public final Bitmap getDefaultVideoPoster() {
                Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
                if (defaultVideoPoster != null) {
                    return defaultVideoPoster;
                }
                if (this.f35523c == null) {
                    this.f35523c = BitmapFactory.decodeResource(PFGGameWebActivity.this.getResources(), R.drawable.com_gamepind_def_video_poster);
                }
                return this.f35523c;
            }
        });
        this.f35512d.getSettings().setJavaScriptEnabled(true);
        this.f35512d.getSettings().setUseWideViewPort(true);
        this.f35512d.getSettings().setDomStorageEnabled(true);
        this.f35512d.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
        this.f35512d.getSettings().setAppCacheEnabled(true);
        this.f35512d.getSettings().setDatabasePath(getDir("databases", 0).getAbsolutePath());
        this.f35512d.getSettings().setDatabaseEnabled(true);
        GamepindCasClient d3 = g.a().d();
        WebSettings settings = this.f35512d.getSettings();
        settings.setUserAgentString(this.f35512d.getSettings().getUserAgentString() + d3.property);
        this.x = new b(this);
        this.f35512d.addJavascriptInterface(this.x, "PowerPlayAndroid");
        this.f35512d.addJavascriptInterface(new a(this), "GamepindPlayBillingUtils");
        this.f35512d.setHapticFeedbackEnabled(true);
        this.f35512d.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f35512d.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f35512d.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f35512d.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f35512d.setLayerType(2, (Paint) null);
        } else {
            this.f35512d.setLayerType(1, (Paint) null);
        }
        this.f35517i = g.a().d().property;
        this.f35516h = intent.getStringExtra("masked_msisdn");
        if (f.a((Object) this.f35516h)) {
            this.f35516h = null;
        }
        this.f35515g = intent.getStringExtra("mv_cas_oauth_token");
        this.z = new HashMap<>();
        this.n = System.currentTimeMillis();
        GpBillingJobIntentService.a((Context) this);
        net.one97.paytm.games.c.a c2 = g.a().c();
        c2.sendOpenScreenWithDeviceInfo(f.c(this, "/inbox/games/webview" + "/" + this.m.getGameName()), "inbox", this);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        b("resume");
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(6);
        }
        getWindow().addFlags(1152);
    }

    public void onStop() {
        b("sleep");
        super.onStop();
    }

    public void onDestroy() {
        try {
            this.f35512d.destroy();
            if (f.a("gamepind_delete_webview_cache", false)) {
                deleteDatabase("webviewCache.db");
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.games.d.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void c() {
        net.one97.paytm.games.c.a c2 = g.a().c();
        c2.sendOpenScreenWithDeviceInfo("/inbox/games/webview/exit" + "-" + this.k, "inbox", this);
        this.f35512d.loadUrl(H5Param.ABOUT_BLANK);
        if (g.a().i()) {
            finish();
        } else if (g.a().f35615b) {
            startActivity(f.c(this));
            finish();
        } else {
            String stringExtra = getIntent().getStringExtra("exitUrl");
            if (f.a((Object) stringExtra)) {
                finish();
                return;
            }
            Uri parse = Uri.parse(g.a().c().getDeeplinkScheme() + "://" + stringExtra);
            Uri.Builder buildUpon = parse.buildUpon();
            if (!parse.getQueryParameterNames().contains("clickSource")) {
                buildUpon.appendQueryParameter("clickSource", "others");
            }
            net.one97.paytm.games.e.c.a((Activity) this, buildUpon.build().toString());
            finish();
        }
    }

    private void b(String str) {
        WebView webView = this.f35512d;
        webView.loadUrl("javascript:callJS('" + str + "');");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.com_gamepind_img_more) {
            f.a(this, "/inbox/games/webview", "gamepind_ingame", "triple_dot_clicked", (String) null, (String) null);
            d();
        } else if (id != R.id.com_gamepind_web_error_btn) {
        } else {
            if (f.a((Context) this)) {
                e();
                a(false);
                return;
            }
            Toast.makeText(this, getString(R.string.com_gamepind_no_internet_available), 0).show();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        Intent intent = new Intent(this, GpGameMenuActivity.class);
        intent.putExtra("object1", this.m);
        startActivity(intent);
    }

    static class b extends h {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public PFGGameWebActivity f35533b;

        b(PFGGameWebActivity pFGGameWebActivity) {
            super(pFGGameWebActivity);
            this.f35533b = pFGGameWebActivity;
        }

        @JavascriptInterface
        public final void showProgressDialog(final String str) {
            this.f35533b.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.f35533b.a(str);
                }
            });
        }

        @JavascriptInterface
        public final void dismissProgressDialog() {
            this.f35533b.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.f35533b.a();
                }
            });
        }

        @JavascriptInterface
        public final String getAppInfo() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_id", g.a().a(this.f35533b));
                jSONObject.put("property", this.f35533b.f35517i);
                jSONObject.put("mv_cas_oauth_token", this.f35533b.f35515g);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public final void openScreen(String str) {
            switch (str.hashCode()) {
                case -1397005470:
                    str.equals("PP-S4-STORE");
                    return;
                case 320262186:
                    if (!str.equals("PP-S1-L")) {
                        return;
                    }
                    return;
                case 1338222816:
                    if (!str.equals("PP-S2-ED")) {
                        return;
                    }
                    return;
                case 1338252946:
                    if (!str.equals("PP-S3-PB")) {
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @JavascriptInterface
        public final boolean canShowNativeViews() {
            return this.f35533b.m != null;
        }

        @JavascriptInterface
        public final void showNativeViews(boolean z, boolean z2) {
            if (canShowNativeViews()) {
                this.f35533b.f35511c.post(new Runnable(z) {
                    private final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        PFGGameWebActivity.b.this.a(this.f$1);
                    }
                });
                if (z2) {
                    this.f35533b.d();
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(boolean z) {
            this.f35533b.f35511c.setVisibility(z ? 0 : 8);
        }

        @JavascriptInterface
        public final void sendOpenScreenEvent(String str) {
            g.a().c().sendOpenScreenWithDeviceInfo(f.c(this.f35533b, str), "inbox", this.f35533b);
        }

        @JavascriptInterface
        public final void sendCustomEvent(String str, String str2, String str3, String str4, String str5) {
            PFGGameWebActivity pFGGameWebActivity = this.f35533b;
            f.a(pFGGameWebActivity, f.c(pFGGameWebActivity, str), str2, str3, str4, str5);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f35533b.c();
        }

        @JavascriptInterface
        public final void closeWebView() {
            this.f35533b.f35512d.post(new Runnable() {
                public final void run() {
                    PFGGameWebActivity.b.this.a();
                }
            });
        }

        @JavascriptInterface
        public final void goBeansHistory() {
            this.f35533b.startActivity(new Intent(this.f35533b, PFGBeansHistoryActivity.class));
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        PFGGameWebActivity f35529a;

        a(PFGGameWebActivity pFGGameWebActivity) {
            this.f35529a = pFGGameWebActivity;
        }

        @JavascriptInterface
        public final boolean canPurchase() {
            return f.a("gamepind_google_billing_enabled", true);
        }

        @JavascriptInterface
        public final void purchase(String str, String str2, String str3, String str4) {
            if (!f.a((Activity) this.f35529a)) {
                PFGGameWebActivity.m(this.f35529a);
                String unused = this.f35529a.p = str;
                String unused2 = this.f35529a.q = str2;
                com.google.gson.f fVar = new com.google.gson.f();
                ArrayList unused3 = this.f35529a.r = (ArrayList) fVar.a(str3, new com.google.gson.b.a<ArrayList<String>>() {
                }.getType());
                HashMap unused4 = this.f35529a.s = (HashMap) fVar.a(str4, new com.google.gson.b.a<HashMap<String, String>>() {
                }.getType());
                if (this.f35529a.s == null || this.f35529a.s.isEmpty()) {
                    this.f35529a.c("sps data map is invalid");
                } else {
                    this.f35529a.runOnUiThread(new Runnable() {
                        public final void run() {
                            PFGGameWebActivity.o(a.this.f35529a);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        this.f35512d.post(new Runnable() {
            public final void run() {
                WebView j = PFGGameWebActivity.this.f35512d;
                j.loadUrl("javascript:new SPS().onPurchaseUpdated('" + str + "');");
            }
        });
    }

    private void a(String str, String str2, String str3) {
        String str4 = this.s.get("sps_txn_id");
        this.s.put("code", str);
        this.s.put("message", str2);
        this.s.put("status", str3);
        String b2 = new com.google.gson.f().b(this.s);
        c(b2);
        try {
            JSONObject jSONObject = new JSONObject(net.one97.paytm.games.e.d.a((Context) this).b());
            jSONObject.putOpt(str4, b2);
            net.one97.paytm.games.e.d.a((Context) this).b(jSONObject.toString());
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        if (f.a((Context) this)) {
            GpBillingJobIntentService.a((Context) this);
        } else {
            this.w = true;
        }
    }

    class c implements a.C0594a {
        private c() {
        }

        /* synthetic */ c(PFGGameWebActivity pFGGameWebActivity, byte b2) {
            this();
        }

        public final void Y_() {
            if (PFGGameWebActivity.this.p != null) {
                PFGGameWebActivity.o(PFGGameWebActivity.this);
            }
        }

        public final void a(String str, int i2) {
            if (i2 == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(net.one97.paytm.games.e.d.a((Context) PFGGameWebActivity.this).a());
                    jSONObject.remove(PFGGameWebActivity.this.p);
                    net.one97.paytm.games.e.d.a((Context) PFGGameWebActivity.this).a(jSONObject.toString());
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x006d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r22, java.util.List<com.android.billingclient.api.g> r23) {
            /*
                r21 = this;
                r1 = r21
                r2 = r22
                if (r2 != 0) goto L_0x002f
                if (r23 == 0) goto L_0x002f
                boolean r0 = r23.isEmpty()
                if (r0 != 0) goto L_0x002f
                java.util.Iterator r0 = r23.iterator()
            L_0x0012:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x002f
                java.lang.Object r3 = r0.next()
                com.android.billingclient.api.g r3 = (com.android.billingclient.api.g) r3
                java.lang.String r4 = r3.a()
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r5 = r5.p
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0012
                goto L_0x0030
            L_0x002f:
                r3 = 0
            L_0x0030:
                net.one97.paytm.games.activity.PFGGameWebActivity r0 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.util.HashMap r0 = r0.s
                java.lang.String r4 = "sps_txn_id"
                java.lang.Object r0 = r0.get(r4)
                r11 = r0
                java.lang.String r11 = (java.lang.String) r11
                java.util.ArrayList r13 = new java.util.ArrayList
                r0 = 1
                r13.<init>(r0)
                r14 = 0
                if (r3 != 0) goto L_0x006d
                net.one97.paytm.games.model.GpTxnDatum r0 = new net.one97.paytm.games.model.GpTxnDatum
                net.one97.paytm.games.activity.PFGGameWebActivity r3 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r6 = r3.p
                net.one97.paytm.games.activity.PFGGameWebActivity r3 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r7 = r3.q
                r8 = 0
                r9 = 0
                net.one97.paytm.games.activity.PFGGameWebActivity r3 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r12 = r3.f35516h
                r5 = r0
                r5.<init>(r6, r7, r8, r9, r11, r12)
                r13.add(r0)
                net.one97.paytm.games.activity.PFGGameWebActivity r0 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                int unused = r0.v = r2
                goto L_0x00e0
            L_0x006d:
                net.one97.paytm.games.activity.PFGGameWebActivity r0 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r5 = r3.b()
                java.lang.String unused = r0.t = r5
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00c4 }
                r0.<init>()     // Catch:{ JSONException -> 0x00c4 }
                r0.put(r4, r11)     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r4 = "sku_type"
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r5 = r5.q     // Catch:{ JSONException -> 0x00c4 }
                r0.put(r4, r5)     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r4 = "is_verified"
                r0.put(r4, r14)     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r4 = "account_id"
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r5 = r5.f35516h     // Catch:{ JSONException -> 0x00c4 }
                r0.put(r4, r5)     // Catch:{ JSONException -> 0x00c4 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00c4 }
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this     // Catch:{ JSONException -> 0x00c4 }
                net.one97.paytm.games.e.d r5 = net.one97.paytm.games.e.d.a((android.content.Context) r5)     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r5 = r5.a()     // Catch:{ JSONException -> 0x00c4 }
                r4.<init>(r5)     // Catch:{ JSONException -> 0x00c4 }
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r5 = r5.p     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00c4 }
                r4.put(r5, r0)     // Catch:{ JSONException -> 0x00c4 }
                net.one97.paytm.games.activity.PFGGameWebActivity r0 = net.one97.paytm.games.activity.PFGGameWebActivity.this     // Catch:{ JSONException -> 0x00c4 }
                net.one97.paytm.games.e.d r0 = net.one97.paytm.games.e.d.a((android.content.Context) r0)     // Catch:{ JSONException -> 0x00c4 }
                java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x00c4 }
                r0.a((java.lang.String) r4)     // Catch:{ JSONException -> 0x00c4 }
                goto L_0x00cc
            L_0x00c4:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
            L_0x00cc:
                net.one97.paytm.games.model.GpTxnDatum r0 = new net.one97.paytm.games.model.GpTxnDatum
                net.one97.paytm.games.activity.PFGGameWebActivity r4 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r4 = r4.q
                net.one97.paytm.games.activity.PFGGameWebActivity r5 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r5 = r5.f35516h
                r0.<init>(r3, r4, r11, r5)
                r13.add(r0)
            L_0x00e0:
                net.one97.paytm.games.model.GpPostTxnDataRequest r0 = new net.one97.paytm.games.model.GpPostTxnDataRequest
                r0.<init>()
                java.lang.String r3 = "online"
                r0.setFlag(r3)
                net.one97.paytm.games.activity.PFGGameWebActivity r3 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r3 = r3.getPackageName()
                r0.setPackageName(r3)
                r0.setResponseCode(r2)
                java.lang.String r2 = net.one97.paytm.games.e.e.a(r22)
                r0.setResponseMessage(r2)
                r0.setItems(r13)
                net.one97.paytm.games.activity.PFGGameWebActivity r2 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.Object r3 = r13.get(r14)
                net.one97.paytm.games.model.GpTxnDatum r3 = (net.one97.paytm.games.model.GpTxnDatum) r3
                java.util.TreeMap r2 = net.one97.paytm.games.activity.PFGGameWebActivity.a((net.one97.paytm.games.activity.PFGGameWebActivity) r2, (net.one97.paytm.games.model.GpTxnDatum) r3)
                net.one97.paytm.games.e.g r3 = net.one97.paytm.games.e.g.a()
                net.one97.paytm.games.model.GamepindSpsClient r3 = r3.e()
                java.lang.String r3 = r3.checksumHashKey
                java.lang.String r2 = com.paytm.d.a.a(r2, r3)
                r0.setChecksumhash(r2)
                net.one97.paytm.games.activity.PFGGameWebActivity r2 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                r18 = 0
                java.lang.String r19 = net.one97.paytm.games.activity.PFGGameWebActivity.f35510b
                com.paytm.network.a$b r20 = com.paytm.network.a.b.USER_FACING
                r15 = r2
                r16 = r0
                r17 = r2
                net.one97.paytm.games.e.a.a(r15, r16, r17, r18, r19, r20)
                net.one97.paytm.games.activity.PFGGameWebActivity r0 = net.one97.paytm.games.activity.PFGGameWebActivity.this
                java.lang.String r2 = "Saving transaction status..."
                r0.a((java.lang.String) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.PFGGameWebActivity.c.a(int, java.util.List):void");
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 2002) {
            return;
        }
        if (i3 == -1) {
            b(H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
            c();
            return;
        }
        b("resume");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a();
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof GpPostTxnDataResponse)) {
            GpPostTxnDataResponse gpPostTxnDataResponse = (GpPostTxnDataResponse) iJRPaytmDataModel;
            if (gpPostTxnDataResponse.getCode() == 2002 || gpPostTxnDataResponse.getCode() == 2001) {
                this.u = new com.google.gson.f().b(gpPostTxnDataResponse.getClient_sdk_response());
                try {
                    JSONObject jSONObject = new JSONObject(net.one97.paytm.games.e.d.a((Context) this).a());
                    String str = (String) jSONObject.opt(this.p);
                    if (str != null) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        jSONObject2.put("is_verified", true);
                        jSONObject.put(this.p, jSONObject2.toString());
                        net.one97.paytm.games.e.d.a((Context) this).a(jSONObject.toString());
                    }
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
                c(this.u);
                this.o.a(this.t);
            } else if (gpPostTxnDataResponse.getClient_sdk_response() != null) {
                this.u = new com.google.gson.f().b(gpPostTxnDataResponse.getClient_sdk_response());
                c(this.u);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a();
        if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof GpPostTxnDataResponse)) {
            return;
        }
        if (this.t == null) {
            a("4042", e.a(this.v), "TXN_FAILED");
        } else {
            a("4037", "This Transaction is in Processing", "TXN_PENDING");
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            TextView textView = (TextView) findViewById(R.id.com_gamepind_web_error_title);
            TextView textView2 = (TextView) findViewById(R.id.com_gamepind_web_error_msg);
            this.f35513e.setVisibility(8);
            this.f35514f.setVisibility(0);
            if (!f.a((Context) this)) {
                textView.setText(R.string.com_gamepind_web_err_internet_title);
                textView2.setText(R.string.com_gamepind_web_err_internet_msg);
                return;
            }
            textView.setText(R.string.com_gamepind_web_err_other_title);
            textView2.setText(R.string.com_gamepind_some_error);
            return;
        }
        this.f35513e.setVisibility(0);
        this.f35514f.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void e() {
        HashMap<String, String> hashMap = this.z;
        if (hashMap == null) {
            this.f35512d.loadUrl(this.A);
        } else {
            this.f35512d.loadUrl(this.A, hashMap);
        }
    }

    public final void a(int i2, Object obj) {
        if (!f.a((Activity) this)) {
            super.a(i2, obj);
            if (i2 == 3 && obj == NetworkInfo.State.CONNECTED) {
                if (this.w) {
                    GpBillingJobIntentService.a((Context) this);
                    this.w = false;
                }
                if (this.f35514f.getVisibility() == 0 && this.A != null) {
                    e();
                    a(false);
                }
            }
        }
    }

    public void onBackPressed() {
        Game game = this.m;
        if (game == null || !"241823467".equals(game.getGameId())) {
            Game game2 = this.m;
            String gameId = game2 != null ? game2.getGameId() : "";
            int a2 = f.a(this.j);
            Intent intent = new Intent(this, PFGGameExitActivity.class);
            intent.putExtra(CLPConstants.PRODUCT_ID, gameId);
            intent.putExtra("orientation", a2);
            startActivityForResult(intent, 2002);
            b("sleep");
            return;
        }
        this.f35512d.post(new Runnable("javascript:onDeviceBackPressed();") {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PFGGameWebActivity.this.d(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        this.f35512d.loadUrl(str);
    }

    static /* synthetic */ void a(PFGGameWebActivity pFGGameWebActivity, int i2) {
        ArrayList arrayList;
        String gtmString = g.a().c().getGtmString("gamepind_web_error_codes");
        if (f.a((Object) gtmString)) {
            gtmString = "[-2,-8]";
        }
        try {
            arrayList = (ArrayList) new com.google.gson.f().a(gtmString, new com.google.gson.b.a<ArrayList<Integer>>() {
            }.getType());
        } catch (Exception unused) {
            arrayList = new ArrayList();
        }
        if (arrayList.contains(Integer.valueOf(i2))) {
            if (!pFGGameWebActivity.y.equalsIgnoreCase(pFGGameWebActivity.A)) {
                pFGGameWebActivity.z = null;
            }
            pFGGameWebActivity.A = pFGGameWebActivity.y;
            pFGGameWebActivity.a(true);
        }
    }

    static /* synthetic */ void m(PFGGameWebActivity pFGGameWebActivity) {
        pFGGameWebActivity.p = null;
        pFGGameWebActivity.q = null;
        pFGGameWebActivity.r = null;
        pFGGameWebActivity.s = null;
        pFGGameWebActivity.t = null;
        pFGGameWebActivity.u = null;
        pFGGameWebActivity.v = -1;
    }

    static /* synthetic */ void o(PFGGameWebActivity pFGGameWebActivity) {
        net.one97.paytm.games.d.a aVar = pFGGameWebActivity.o;
        if (aVar == null || aVar.f35575d != 0) {
            pFGGameWebActivity.o = new net.one97.paytm.games.d.a(pFGGameWebActivity, new c(pFGGameWebActivity, (byte) 0));
            return;
        }
        net.one97.paytm.games.d.a aVar2 = pFGGameWebActivity.o;
        aVar2.a((Runnable) new Runnable(pFGGameWebActivity.p, pFGGameWebActivity.q, pFGGameWebActivity.r, pFGGameWebActivity.f35516h, pFGGameWebActivity) {

            /* renamed from: a */
            final /* synthetic */ String f35577a;

            /* renamed from: b */
            final /* synthetic */ String f35578b;

            /* renamed from: c */
            final /* synthetic */ ArrayList f35579c;

            /* renamed from: d */
            final /* synthetic */ String f35580d;

            /* renamed from: e */
            final /* synthetic */ Activity f35581e;

            public final void run(
/*
Method generation error in method: net.one97.paytm.games.d.a.2.run():void, dex: classes13.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.games.d.a.2.run():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
    }

    static /* synthetic */ TreeMap a(PFGGameWebActivity pFGGameWebActivity, GpTxnDatum gpTxnDatum) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("spsTxnId", gpTxnDatum.getSpsTxnId());
        treeMap.put("skuType", gpTxnDatum.getSkuType());
        treeMap.put("skuId", gpTxnDatum.getSkuId());
        StringBuilder sb = new StringBuilder();
        sb.append(gpTxnDatum.getPurchaseTime());
        treeMap.put("purchaseTime", sb.toString());
        treeMap.put("purchaseToken", gpTxnDatum.getPurchaseToken());
        if (!f.a((Object) pFGGameWebActivity.f35516h)) {
            treeMap.put("accountId", pFGGameWebActivity.f35516h);
        }
        return treeMap;
    }

    static /* synthetic */ void s(PFGGameWebActivity pFGGameWebActivity) {
        if (!f.a((Activity) pFGGameWebActivity)) {
            Toast.makeText(pFGGameWebActivity, R.string.com_gamepind_some_error, 0).show();
            pFGGameWebActivity.finish();
        }
    }
}
