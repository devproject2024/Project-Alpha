package net.one97.paytm.games.fragment.pf;

import android.app.Activity;
import android.content.BroadcastReceiver;
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
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.v;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.share.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.y;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.games.R;
import net.one97.paytm.games.fragment.a.e;
import net.one97.paytm.games.model.CJRGenerateAuthAccessToken;
import net.one97.paytm.games.model.GamepindCasClient;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.view.pfg.custom.GamesWebView;
import org.json.JSONObject;

public final class a extends net.one97.paytm.games.fragment.b {

    /* renamed from: a  reason: collision with root package name */
    public static final c f35661a = new c((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f35662b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f35663c;

    /* renamed from: d  reason: collision with root package name */
    private d f35664d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f35665e;

    /* renamed from: f  reason: collision with root package name */
    private String f35666f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f35667g;

    /* renamed from: h  reason: collision with root package name */
    private String f35668h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f35669i;
    /* access modifiers changed from: private */
    public String j;
    private String k;
    private final kotlin.g l = v.a(this, y.b(net.one97.paytm.games.fragment.a.e.class), new b(new C0598a(this)), (kotlin.g.a.a<? extends al.b>) null);
    private final BroadcastReceiver m = new PFGameWebFragment$mAppLoginStateReceiver$1(this);
    private HashMap n;

    static final class k implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final k f35679a = new k();

        k() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    private View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: private */
    public final net.one97.paytm.games.fragment.a.e a() {
        return (net.one97.paytm.games.fragment.a.e) this.l.getValue();
    }

    static final class f<T> implements z<o<? extends Integer, ? extends CJRGenerateAuthAccessToken>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35673a;

        f(a aVar) {
            this.f35673a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            a.e(this.f35673a);
            int intValue = ((Number) oVar.getFirst()).intValue();
            if (intValue == 4) {
                this.f35673a.b();
            } else if (intValue == 5) {
                a.a(this.f35673a, (String) null, 6);
            } else if (intValue == 6) {
                CJRGenerateAuthAccessToken cJRGenerateAuthAccessToken = (CJRGenerateAuthAccessToken) oVar.getSecond();
                if (cJRGenerateAuthAccessToken == null) {
                    a.a(this.f35673a, (String) null, 6);
                } else if (cJRGenerateAuthAccessToken.code == 2055) {
                    a.a(this.f35673a, (GpCommonBaseResponse) cJRGenerateAuthAccessToken);
                } else if (cJRGenerateAuthAccessToken.code == 3012) {
                    a.b(this.f35673a, (GpCommonBaseResponse) cJRGenerateAuthAccessToken);
                } else if (net.one97.paytm.games.e.f.a((Object) cJRGenerateAuthAccessToken.access_token)) {
                    a.a(this.f35673a, (String) null, 6);
                } else {
                    this.f35673a.f35669i = cJRGenerateAuthAccessToken.access_token;
                    this.f35673a.a(true, false);
                    a.g(this.f35673a);
                }
            }
        }
    }

    static final class g<T> implements z<o<? extends Integer, ? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35674a;

        g(a aVar) {
            this.f35674a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            a.e(this.f35674a);
            int intValue = ((Number) oVar.getFirst()).intValue();
            if (intValue == 4) {
                this.f35674a.b();
            } else if (intValue == 5) {
                String string = this.f35674a.getString(R.string.com_gamepind_some_error);
                kotlin.g.b.k.a((Object) string, "getString(R.string.com_gamepind_some_error)");
                if (oVar.getSecond() instanceof String) {
                    string = string + " [" + oVar.getSecond() + ']';
                }
                a.a(this.f35674a, string, 2);
            } else if (intValue == 6) {
                Object second = oVar.getSecond();
                if (second != null) {
                    CJRSignupUser cJRSignupUser = (CJRSignupUser) second;
                    int i2 = cJRSignupUser.code;
                    if (i2 == 2001) {
                        net.one97.paytm.games.b.a.a(cJRSignupUser);
                        this.f35674a.a().a(3);
                    } else if (i2 == 2055) {
                        a.a(this.f35674a, (GpCommonBaseResponse) cJRSignupUser);
                    } else if (i2 != 3012) {
                        String c2 = this.f35674a.a((GpCommonBaseResponse) cJRSignupUser);
                        a aVar = this.f35674a;
                        new StringBuilder("unknown error code received from CAS API i.e ").append(cJRSignupUser.code);
                        a.a(aVar, c2, 2);
                    } else {
                        a.b(this.f35674a, (GpCommonBaseResponse) cJRSignupUser);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.games.model.core.CJRSignupUser");
                }
            }
        }
    }

    static final class h<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35675a;

        h(a aVar) {
            this.f35675a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null && num.intValue() == 1) {
                this.f35675a.a(false, false);
            } else if (num != null && num.intValue() == 2) {
                this.f35675a.a(true, false);
                this.f35675a.a().a("PFGameWebFragment", a.h(this.f35675a));
            } else if (num != null && num.intValue() == 3) {
                this.f35675a.a(true, false);
                if (this.f35675a.j != null) {
                    net.one97.paytm.games.fragment.a.e d2 = this.f35675a.a();
                    Context requireContext = this.f35675a.requireContext();
                    kotlin.g.b.k.a((Object) requireContext, "requireContext()");
                    String i2 = this.f35675a.j;
                    if (i2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.c(requireContext, "pContext");
                    kotlin.g.b.k.c(i2, "pMid");
                    com.paytm.network.a aVar = d2.f35653h;
                    if (aVar != null) {
                        aVar.b();
                    }
                    d2.f35654i.setValue(new o(4, null));
                    net.one97.paytm.games.e.j jVar = net.one97.paytm.games.e.j.f35626a;
                    d2.f35653h = net.one97.paytm.games.e.j.a(requireContext, i2, new e.a(d2));
                    return;
                }
                a.a(this.f35675a, (String) null, 6);
            }
        }
    }

    public static final /* synthetic */ String a(a aVar) {
        String str = aVar.f35666f;
        if (str == null) {
            kotlin.g.b.k.a("mProperty");
        }
        return str;
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static a a(Bundle bundle) {
            kotlin.g.b.k.c(bundle, "arguments");
            a aVar = new a();
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    /* renamed from: net.one97.paytm.games.fragment.pf.a$a  reason: collision with other inner class name */
    public static final class C0598a extends kotlin.g.b.l implements kotlin.g.a.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0598a(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    public static final class b extends kotlin.g.b.l implements kotlin.g.a.a<an> {
        final /* synthetic */ kotlin.g.a.a $ownerProducer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(kotlin.g.a.a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        public final an invoke() {
            an viewModelStore = ((ao) this.$ownerProducer.invoke()).getViewModelStore();
            kotlin.g.b.k.a((Object) viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        androidx.localbroadcastmanager.a.a.a(context).a(this.m, new IntentFilter("action_update_login_status"));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.com_gamepind_activity_game_web, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        GamesWebView gamesWebView = (GamesWebView) a(R.id.game_webview);
        kotlin.g.b.k.a((Object) gamesWebView, "game_webview");
        this.f35665e = gamesWebView;
        WebView webView = this.f35665e;
        if (webView == null) {
            kotlin.g.b.k.a("mWebView");
        }
        if (webView != null) {
            ((GamesWebView) webView).setMIsInViewPager$paytmGamepind_release(true);
            a(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
            requireContext();
            GamepindCasClient d2 = a2.d();
            kotlin.g.b.k.a((Object) d2, "GpSingleton.getInstance(…sClient(requireContext())");
            String str = d2.property;
            kotlin.g.b.k.a((Object) str, "gpCasClient.property");
            this.f35666f = str;
            a().f35654i.observe(getViewLifecycleOwner(), new f(this));
            a().f35633e.observe(getViewLifecycleOwner(), new g(this));
            a().f35632d.observe(getViewLifecycleOwner(), new h(this));
            ProgressBar progressBar = (ProgressBar) a(R.id.com_gamepind_progress_bar_linear);
            kotlin.g.b.k.a((Object) progressBar, "com_gamepind_progress_bar_linear");
            progressBar.setVisibility(8);
            WebView webView2 = this.f35665e;
            if (webView2 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings = webView2.getSettings();
            kotlin.g.b.k.a((Object) settings, "mWebView.settings");
            settings.setTextZoom(100);
            WebView webView3 = this.f35665e;
            if (webView3 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView3.setWebViewClient(new i(this));
            WebView webView4 = this.f35665e;
            if (webView4 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView4.setWebChromeClient(new j(this));
            WebView webView5 = this.f35665e;
            if (webView5 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings2 = webView5.getSettings();
            kotlin.g.b.k.a((Object) settings2, "mWebView.settings");
            settings2.setJavaScriptEnabled(true);
            WebView webView6 = this.f35665e;
            if (webView6 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings3 = webView6.getSettings();
            kotlin.g.b.k.a((Object) settings3, "mWebView.settings");
            settings3.setUseWideViewPort(true);
            WebView webView7 = this.f35665e;
            if (webView7 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings4 = webView7.getSettings();
            kotlin.g.b.k.a((Object) settings4, "mWebView.settings");
            settings4.setDomStorageEnabled(true);
            WebView webView8 = this.f35665e;
            if (webView8 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings5 = webView8.getSettings();
            Context requireContext = requireContext();
            kotlin.g.b.k.a((Object) requireContext, "requireContext()");
            File cacheDir = requireContext.getCacheDir();
            kotlin.g.b.k.a((Object) cacheDir, "requireContext().cacheDir");
            settings5.setAppCachePath(cacheDir.getAbsolutePath());
            WebView webView9 = this.f35665e;
            if (webView9 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView9.getSettings().setAppCacheEnabled(true);
            WebView webView10 = this.f35665e;
            if (webView10 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings6 = webView10.getSettings();
            kotlin.g.b.k.a((Object) settings6, "mWebView.settings");
            File dir = requireContext().getDir("databases-rooter", 0);
            kotlin.g.b.k.a((Object) dir, "requireContext().getDir(…r\", Context.MODE_PRIVATE)");
            settings6.setDatabasePath(dir.getAbsolutePath());
            WebView webView11 = this.f35665e;
            if (webView11 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings7 = webView11.getSettings();
            kotlin.g.b.k.a((Object) settings7, "mWebView.settings");
            settings7.setDatabaseEnabled(true);
            WebView webView12 = this.f35665e;
            if (webView12 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings8 = webView12.getSettings();
            kotlin.g.b.k.a((Object) settings8, "mWebView.settings");
            StringBuilder sb = new StringBuilder();
            WebView webView13 = this.f35665e;
            if (webView13 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings9 = webView13.getSettings();
            kotlin.g.b.k.a((Object) settings9, "mWebView.settings");
            sb.append(settings9.getUserAgentString());
            String str2 = this.f35666f;
            if (str2 == null) {
                kotlin.g.b.k.a("mProperty");
            }
            sb.append(str2);
            settings8.setUserAgentString(sb.toString());
            this.f35664d = new d(this);
            WebView webView14 = this.f35665e;
            if (webView14 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            d dVar = this.f35664d;
            if (dVar == null) {
                kotlin.g.b.k.a("mPowerPlayAndroidJsInterface");
            }
            webView14.addJavascriptInterface(dVar, "PowerPlayAndroid");
            WebView webView15 = this.f35665e;
            if (webView15 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView15.setLongClickable(true);
            WebView webView16 = this.f35665e;
            if (webView16 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView16.setOnLongClickListener(k.f35679a);
            WebView webView17 = this.f35665e;
            if (webView17 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView17.setHapticFeedbackEnabled(true);
            WebView webView18 = this.f35665e;
            if (webView18 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings10 = webView18.getSettings();
            kotlin.g.b.k.a((Object) settings10, "mWebView.settings");
            settings10.setAllowUniversalAccessFromFileURLs(true);
            WebView webView19 = this.f35665e;
            if (webView19 == null) {
                kotlin.g.b.k.a("mWebView");
            }
            WebSettings settings11 = webView19.getSettings();
            kotlin.g.b.k.a((Object) settings11, "mWebView.settings");
            settings11.setLoadWithOverviewMode(true);
            if (Build.VERSION.SDK_INT >= 17) {
                WebView webView20 = this.f35665e;
                if (webView20 == null) {
                    kotlin.g.b.k.a("mWebView");
                }
                WebSettings settings12 = webView20.getSettings();
                kotlin.g.b.k.a((Object) settings12, "mWebView.settings");
                settings12.setMediaPlaybackRequiresUserGesture(false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                WebView webView21 = this.f35665e;
                if (webView21 == null) {
                    kotlin.g.b.k.a("mWebView");
                }
                WebSettings settings13 = webView21.getSettings();
                kotlin.g.b.k.a((Object) settings13, "mWebView.settings");
                settings13.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView22 = this.f35665e;
                if (webView22 == null) {
                    kotlin.g.b.k.a("mWebView");
                }
                webView22.setLayerType(2, (Paint) null);
            } else {
                WebView webView23 = this.f35665e;
                if (webView23 == null) {
                    kotlin.g.b.k.a("mWebView");
                }
                webView23.setLayerType(1, (Paint) null);
            }
            ((Button) a(R.id.com_pfg_rooter_btn_login)).setOnClickListener(new l(this));
            ((Button) a(R.id.com_gamepind_web_error_btn)).setOnClickListener(new m(this));
            net.one97.paytm.games.e.g a3 = net.one97.paytm.games.e.g.a();
            kotlin.g.b.k.a((Object) a3, "GpSingleton.getInstance()");
            String gtmString = a3.c().getGtmString("pfgRooterUrl");
            if (gtmString == null) {
                gtmString = "https://www.rootersports.com/ipl2020?external_env=PAYTM_TAB&utm_source=paytm&utm_medium=paytminbox&utm_campaign=IPL_2020_Paytm_Inbox";
            }
            this.f35668h = gtmString;
            net.one97.paytm.games.e.g a4 = net.one97.paytm.games.e.g.a();
            kotlin.g.b.k.a((Object) a4, "GpSingleton.getInstance()");
            String gtmString2 = a4.c().getGtmString("pfgRooterMerchantId");
            if (gtmString2 == null) {
                gtmString2 = "cas_rooter_sports_prod";
            }
            this.j = gtmString2;
            net.one97.paytm.games.e.g a5 = net.one97.paytm.games.e.g.a();
            kotlin.g.b.k.a((Object) a5, "GpSingleton.getInstance()");
            String gtmString3 = a5.c().getGtmString("pfgRooterPId");
            if (gtmString3 == null) {
                gtmString3 = "319306564";
            }
            this.k = gtmString3;
            c();
            net.one97.paytm.games.e.g.a().c().sendOpenScreenWithDeviceInfo(net.one97.paytm.games.e.f.c(requireContext(), "/inbox/rooter/webview"), "inbox", requireContext());
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.games.view.pfg.custom.GamesWebView");
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35680a;

        l(a aVar) {
            this.f35680a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
            kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
            Intent loginScreenIntent = a2.c().getLoginScreenIntent(this.f35680a.requireContext());
            loginScreenIntent.addFlags(67108864);
            this.f35680a.startActivityForResult(loginScreenIntent, 3);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35681a;

        m(a aVar) {
            this.f35681a = aVar;
        }

        public final void onClick(View view) {
            if (net.one97.paytm.games.e.f.a(this.f35681a.getContext())) {
                this.f35681a.c();
            } else {
                Toast.makeText(this.f35681a.getContext(), this.f35681a.getString(R.string.com_gamepind_no_internet_available), 0).show();
            }
        }
    }

    public final void onStart() {
        super.onStart();
        a("onStart");
    }

    public final void onResume() {
        super.onResume();
        a("onResume");
    }

    public final void onPause() {
        a("onPause");
        super.onPause();
    }

    public final void onStop() {
        a("onStop");
        super.onStop();
    }

    public final void onDetach() {
        androidx.localbroadcastmanager.a.a.a(requireContext()).a(this.m);
        super.onDetach();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            c();
        }
    }

    public static final class i extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35676a;

        i(a aVar) {
            this.f35676a = aVar;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f35676a.f35663c = str;
            this.f35676a.b();
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!net.one97.paytm.games.e.f.a(this.f35676a.getContext())) {
                this.f35676a.a(true);
                return true;
            }
            String str = null;
            if ((webResourceRequest != null ? webResourceRequest.getUrl() : null) != null) {
                str = webResourceRequest.getUrl().toString();
            }
            if (net.one97.paytm.games.e.c.a((Activity) this.f35676a.requireActivity(), str) || super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!net.one97.paytm.games.e.f.a(this.f35676a.getContext())) {
                this.f35676a.a(true);
                return true;
            } else if (net.one97.paytm.games.e.c.a((Activity) this.f35676a.requireActivity(), str) || super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            } else {
                return false;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f35676a.f35663c = null;
            a.e(this.f35676a);
            if (this.f35676a.f35667g != 0 && this.f35676a.getContext() != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.f35676a.f35667g;
                this.f35676a.f35667g = 0;
                net.one97.paytm.games.e.f.a(this.f35676a.getContext(), "rooter", "/inbox/rooter/webview", "rooter_screen_loaded", "", "", currentTimeMillis);
            }
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            CharSequence j = this.f35676a.f35663c;
            if (!(j == null || p.a(j))) {
                int errorCode = webResourceError != null ? webResourceError.getErrorCode() : -1;
                a aVar = this.f35676a;
                if (webResourceRequest != null) {
                    webResourceRequest.getUrl();
                }
                a.a(aVar, errorCode);
            }
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            CharSequence j = this.f35676a.f35663c;
            if (!(j == null || p.a(j))) {
                a.a(this.f35676a, i2);
            }
        }
    }

    public static final class j extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35677a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f35678b;

        j(a aVar) {
            this.f35677a = aVar;
        }

        public final Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            if (defaultVideoPoster != null) {
                return defaultVideoPoster;
            }
            if (this.f35678b == null) {
                this.f35678b = BitmapFactory.decodeResource(this.f35677a.getResources(), R.drawable.com_gamepind_def_video_poster);
            }
            return this.f35678b;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        final a f35670a;

        public d(a aVar) {
            kotlin.g.b.k.c(aVar, "hostFrgmt");
            this.f35670a = aVar;
        }

        @JavascriptInterface
        public final String getAppInfo() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_id", net.one97.paytm.games.e.g.a().a(this.f35670a.requireContext()));
                jSONObject.put("property", a.a(this.f35670a));
                jSONObject.put("mv_cas_oauth_token", this.f35670a.f35669i);
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "`object`.toString()");
            return jSONObject2;
        }

        @JavascriptInterface
        public final void sendOpenScreenEvent(String str) {
            Context context = this.f35670a.getContext();
            if (context != null) {
                net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
                kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
                a2.c().sendOpenScreenWithDeviceInfo(net.one97.paytm.games.e.f.c(context, str), "inbox", context);
            }
        }

        @JavascriptInterface
        public final boolean isInternetAvailable(boolean z) {
            Context context = this.f35670a.getContext();
            if (net.one97.paytm.games.e.f.a(context)) {
                return true;
            }
            if (!z) {
                return false;
            }
            new Handler(Looper.getMainLooper()).post(new C0599a(context));
            return false;
        }

        /* renamed from: net.one97.paytm.games.fragment.pf.a$d$a  reason: collision with other inner class name */
        static final class C0599a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f35671a;

            C0599a(Context context) {
                this.f35671a = context;
            }

            public final void run() {
                Context context = this.f35671a;
                if (context != null) {
                    Toast.makeText(context, context.getString(R.string.com_gamepind_no_internet_available), 0).show();
                }
            }
        }

        @JavascriptInterface
        public final void sendCustomEvent(String str, String str2, String str3, String str4, String str5) {
            Context context = this.f35670a.getContext();
            if (context != null) {
                net.one97.paytm.games.e.f.a(context, net.one97.paytm.games.e.f.c(context, str), str2, str3, str4, str5);
            }
        }

        @JavascriptInterface
        public final void share(String str) {
            kotlin.g.b.k.c(str, "pMessage");
            net.one97.paytm.games.e.f.a(this.f35670a.requireContext(), "Share using", str);
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f35672a;

            b(d dVar) {
                this.f35672a = dVar;
            }

            public final void run() {
                if (this.f35672a.f35670a.getContext() != null) {
                    a.a(this.f35672a.f35670a, (String) null, 6);
                }
            }
        }

        @JavascriptInterface
        public final void onCASError() {
            new Handler(Looper.getMainLooper()).post(new b(this));
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lav_progress_bar);
        if (lottieAnimationView != null) {
            net.one97.paytm.games.e.a.g.a(lottieAnimationView);
            net.one97.paytm.games.e.f.a(lottieAnimationView);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z, boolean z2) {
        if (((ConstraintLayout) a(R.id.com_pfg_rooter_login_views)) == null) {
            return;
        }
        if (z) {
            net.one97.paytm.games.e.a.g.c((ConstraintLayout) a(R.id.com_pfg_rooter_login_views));
            if (z2) {
                ((ImageView) a(R.id.com_gamepind_web_error_icon)).setImageDrawable(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_internet));
                Button button = (Button) a(R.id.com_gamepind_web_error_btn);
                kotlin.g.b.k.a((Object) button, "com_gamepind_web_error_btn");
                button.setBackground(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_btn_bckgrnd));
                net.one97.paytm.games.e.a.g.a((RelativeLayout) a(R.id.com_gamepind_container_web_error));
                net.one97.paytm.games.e.a.g.c((LinearLayout) a(R.id.root_activity));
                return;
            }
            net.one97.paytm.games.e.a.g.a((LinearLayout) a(R.id.root_activity));
            net.one97.paytm.games.e.a.g.c((RelativeLayout) a(R.id.com_gamepind_container_web_error));
            return;
        }
        net.one97.paytm.games.e.a.g.a((ConstraintLayout) a(R.id.com_pfg_rooter_login_views));
        ((ImageView) a(R.id.com_pfg_rooter_login_iv_logo)).setImageDrawable(getResources().getDrawable(R.drawable.ic_pfg_rooter_logo));
        net.one97.paytm.games.e.a.g.c((RelativeLayout) a(R.id.com_gamepind_container_web_error));
        net.one97.paytm.games.e.a.g.c((LinearLayout) a(R.id.root_activity));
    }

    /* access modifiers changed from: private */
    public final String a(GpCommonBaseResponse gpCommonBaseResponse) {
        String str;
        String str2 = gpCommonBaseResponse.message;
        CharSequence charSequence = str2;
        if (charSequence == null || p.a(charSequence)) {
            str2 = getString(R.string.com_gamepind_some_error);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (gpCommonBaseResponse.code == 0) {
            str = " [CS]";
        } else {
            str = " [CS" + String.valueOf(gpCommonBaseResponse.code) + "]";
        }
        sb.append(str);
        return sb.toString();
    }

    static /* synthetic */ void a(a aVar, String str, int i2) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        aVar.a(0, str);
    }

    private final void a(int i2, String str) {
        String str2;
        try {
            if (str.length() == 0) {
                str = getString(R.string.com_gamepind_something_went_retry);
                kotlin.g.b.k.a((Object) str, "getString(R.string.com_g…ind_something_went_retry)");
            }
            a(com.paytm.utility.b.r(getContext()), true);
            if (i2 != 3012) {
                if (net.one97.paytm.games.e.f.a(getContext())) {
                    str2 = getString(R.string.com_gamepind_some_error);
                } else {
                    str2 = getString(R.string.com_gamepind_web_err_internet_title);
                }
                kotlin.g.b.k.a((Object) str2, "if (GpHelper.isInternetO…le)\n                    }");
                ((ImageView) a(R.id.com_gamepind_web_error_icon)).setImageDrawable(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_internet));
                Button button = (Button) a(R.id.com_gamepind_web_error_btn);
                kotlin.g.b.k.a((Object) button, "com_gamepind_web_error_btn");
                button.setBackground(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_btn_bckgrnd));
                TextView textView = (TextView) a(R.id.com_gamepind_web_error_title);
                kotlin.g.b.k.a((Object) textView, "com_gamepind_web_error_title");
                textView.setText(str2);
                TextView textView2 = (TextView) a(R.id.com_gamepind_web_error_msg);
                kotlin.g.b.k.a((Object) textView2, "com_gamepind_web_error_msg");
                textView2.setText(getString(R.string.com_gamepind_web_err_internet_msg));
                net.one97.paytm.games.e.a.g.a((Button) a(R.id.com_gamepind_web_error_btn));
                net.one97.paytm.games.e.a.g.a((ImageView) a(R.id.com_gamepind_web_error_icon));
            } else {
                ((ImageView) a(R.id.com_gamepind_web_error_icon)).setImageDrawable(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_internet));
                Button button2 = (Button) a(R.id.com_gamepind_web_error_btn);
                kotlin.g.b.k.a((Object) button2, "com_gamepind_web_error_btn");
                button2.setBackground(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_btn_bckgrnd));
                TextView textView3 = (TextView) a(R.id.com_gamepind_web_error_title);
                kotlin.g.b.k.a((Object) textView3, "com_gamepind_web_error_title");
                textView3.setText("Blocked");
                TextView textView4 = (TextView) a(R.id.com_gamepind_web_error_msg);
                kotlin.g.b.k.a((Object) textView4, "com_gamepind_web_error_msg");
                textView4.setText(str);
                net.one97.paytm.games.e.a.g.b((Button) a(R.id.com_gamepind_web_error_btn));
                net.one97.paytm.games.e.a.g.b((ImageView) a(R.id.com_gamepind_web_error_icon));
            }
            Toast.makeText(getContext(), str, 1).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        CharSequence charSequence = this.j;
        boolean z = false;
        if (!(charSequence == null || p.a(charSequence))) {
            CharSequence charSequence2 = this.f35668h;
            if (!(charSequence2 == null || p.a(charSequence2))) {
                CharSequence charSequence3 = this.k;
                if (charSequence3 == null || p.a(charSequence3)) {
                    z = true;
                }
                if (!z) {
                    a().a();
                    return;
                }
            }
        }
        a(this, (String) null, 6);
    }

    private final void a(String str) {
        if (this.f35665e != null) {
            WebView webView = this.f35665e;
            if (webView == null) {
                kotlin.g.b.k.a("mWebView");
            }
            webView.loadUrl("javascript:onScreenStateChanged('" + str + "');");
        }
    }

    public static final class e extends com.google.gson.b.a<ArrayList<Integer>> {
        e() {
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.root_activity);
            kotlin.g.b.k.a((Object) linearLayout, "root_activity");
            linearLayout.setVisibility(8);
            ((ImageView) a(R.id.com_gamepind_web_error_icon)).setImageDrawable(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_internet));
            Button button = (Button) a(R.id.com_gamepind_web_error_btn);
            kotlin.g.b.k.a((Object) button, "com_gamepind_web_error_btn");
            button.setBackground(androidx.core.content.b.a(requireContext(), R.drawable.pfg_web_err_btn_bckgrnd));
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.com_gamepind_container_web_error);
            kotlin.g.b.k.a((Object) relativeLayout, "com_gamepind_container_web_error");
            relativeLayout.setVisibility(0);
            if (!net.one97.paytm.games.e.f.a(getContext())) {
                ((TextView) a(R.id.com_gamepind_web_error_title)).setText(R.string.com_gamepind_web_err_internet_title);
                ((TextView) a(R.id.com_gamepind_web_error_msg)).setText(R.string.com_gamepind_web_err_internet_msg);
                return;
            }
            ((TextView) a(R.id.com_gamepind_web_error_title)).setText(R.string.com_gamepind_web_err_other_title);
            ((TextView) a(R.id.com_gamepind_web_error_msg)).setText(R.string.com_gamepind_some_error);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.root_activity);
        kotlin.g.b.k.a((Object) linearLayout2, "root_activity");
        linearLayout2.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.com_gamepind_container_web_error);
        kotlin.g.b.k.a((Object) relativeLayout2, "com_gamepind_container_web_error");
        relativeLayout2.setVisibility(8);
    }

    public final void a(int i2, Object obj) {
        kotlin.g.b.k.c(obj, "pEventData");
        if (!net.one97.paytm.games.e.f.a((Activity) getActivity())) {
            super.a(i2, obj);
            if (i2 == 3 && obj == NetworkInfo.State.CONNECTED) {
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.com_gamepind_container_web_error);
                kotlin.g.b.k.a((Object) relativeLayout, "com_gamepind_container_web_error");
                if (relativeLayout.getVisibility() == 0) {
                    c();
                    a(false);
                }
            }
        }
    }

    public static final /* synthetic */ void e(a aVar) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) aVar.a(R.id.lav_progress_bar);
        if (lottieAnimationView != null) {
            net.one97.paytm.games.e.a.g.b(lottieAnimationView);
        }
    }

    public static final /* synthetic */ void a(a aVar, GpCommonBaseResponse gpCommonBaseResponse) {
        net.one97.paytm.games.b.a.a((CJRSignupUser) null);
        if (aVar.a().f35634f.decrementAndGet() >= 0) {
            aVar.a().a(2);
        } else {
            aVar.a(2055, aVar.a(gpCommonBaseResponse));
        }
    }

    public static final /* synthetic */ void b(a aVar, GpCommonBaseResponse gpCommonBaseResponse) {
        net.one97.paytm.games.b.a.a((CJRSignupUser) null);
        aVar.a(3012, aVar.a(gpCommonBaseResponse));
    }

    public static final /* synthetic */ void g(a aVar) {
        CharSequence charSequence = aVar.f35662b;
        if (charSequence == null || p.a(charSequence)) {
            aVar.f35667g = System.currentTimeMillis();
            Uri.Builder buildUpon = Uri.parse(aVar.f35668h).buildUpon();
            kotlin.g.b.k.a((Object) buildUpon, "Uri.parse(mBaseUrl).buildUpon()");
            buildUpon.appendQueryParameter("device_id", net.one97.paytm.games.e.g.a().a(aVar.requireContext()));
            buildUpon.appendQueryParameter(Constants.URL_MEDIA_SOURCE, aVar.k);
            String str = aVar.f35669i;
            if (str != null) {
                buildUpon.appendQueryParameter("mv_cas_oauth_token", str);
                String str2 = aVar.f35666f;
                if (str2 == null) {
                    kotlin.g.b.k.a("mProperty");
                }
                buildUpon.appendQueryParameter("property", str2);
            }
            aVar.f35662b = buildUpon.toString();
        }
        aVar.b();
        WebView webView = aVar.f35665e;
        if (webView == null) {
            kotlin.g.b.k.a("mWebView");
        }
        webView.loadUrl(aVar.f35662b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getString("source");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String h(net.one97.paytm.games.fragment.pf.a r1) {
        /*
            android.os.Bundle r1 = r1.getArguments()
            if (r1 == 0) goto L_0x000f
            java.lang.String r0 = "source"
            java.lang.String r1 = r1.getString(r0)
            if (r1 != 0) goto L_0x0011
        L_0x000f:
            java.lang.String r1 = "rooter"
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.fragment.pf.a.h(net.one97.paytm.games.fragment.pf.a):java.lang.String");
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        ArrayList arrayList;
        net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
        kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
        String gtmString = a2.c().getGtmString("gamepind_web_error_codes");
        if (net.one97.paytm.games.e.f.a((Object) gtmString)) {
            gtmString = "[-2,-8]";
        }
        try {
            arrayList = (ArrayList) new com.google.gson.f().a(gtmString, new e().getType());
        } catch (Exception unused) {
            arrayList = new ArrayList();
        }
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        if (arrayList.contains(Integer.valueOf(i2))) {
            aVar.f35662b = aVar.f35663c;
            aVar.a(true);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
