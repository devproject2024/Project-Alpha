package net.one97.paytm.phoenix.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.web.PhoenixJavascriptInterface;
import net.one97.paytm.phoenix.core.web.b;
import net.one97.paytm.phoenix.core.web.d;
import net.one97.paytm.phoenix.data.PhoenixMenuDialogItems;
import net.one97.paytm.phoenix.data.PhoenixMiniAppDialogItems;
import net.one97.paytm.phoenix.manager.EventPubSubManager;
import net.one97.paytm.phoenix.manager.SessionPluginManager;
import net.one97.paytm.phoenix.provider.PaytmH5AppAnalyticsProvider;
import net.one97.paytm.phoenix.provider.PhoenixLoadingViewProvider;
import net.one97.paytm.phoenix.provider.PhoenixProgressHandler;
import net.one97.paytm.phoenix.provider.SplashIconViewProvider;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.phoenix.util.CircularProgressBar;
import net.one97.paytm.phoenix.util.k;
import net.one97.paytm.phoenix.util.o;
import net.one97.paytm.phoenix.viewmodel.Event;
import net.one97.paytm.phoenix.viewmodel.PhoenixViewModel;
import net.one97.paytm.phoenix.viewmodel.ViewModelFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PhoenixActivity extends PaytmActivity implements androidx.lifecycle.q, PhoenixProgressHandler.ProgressCallback {
    public static final e L = new e((byte) 0);
    public f A = new f();
    public boolean B;
    public long C;
    public boolean D;
    public TextView E;
    public Boolean F = Boolean.FALSE;
    public Map<String, Object> G = new LinkedHashMap();
    public String H;
    public CircularProgressBar I;
    public Bundle J;
    Runnable K = new q(this);
    private List<? extends Object> M;
    private List<? extends net.one97.paytm.phoenix.api.d> N;
    private boolean O;
    private net.one97.paytm.phoenix.core.web.c P;
    private net.one97.paytm.phoenix.api.b Q;
    private PhoenixViewModel R;
    private net.one97.paytm.phoenix.manager.b S = new net.one97.paytm.phoenix.manager.b();
    private SplashIconViewProvider T;
    private PhoenixLoadingViewProvider U;
    private Integer V = 0;
    private boolean W;
    private boolean X;
    private boolean Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.phoenix.d.b f59603a;
    private boolean aa;
    private boolean ab;
    private final Map<Integer, String> ac = new LinkedHashMap();
    private final d ad = new d();
    private boolean ae = true;
    private boolean af;
    private boolean ag;
    private String ah = "";
    private net.one97.paytm.phoenix.a.b ai;
    private PhoenixMiniAppDialogItems aj;
    private Toolbar ak;
    private ProgressBar al;
    private final PhoenixActivity$listener$1 am = new PhoenixActivity$listener$1(this);
    private HashMap an;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.phoenix.core.c f59604b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.phoenix.core.a f59605c;

    /* renamed from: d  reason: collision with root package name */
    public String f59606d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f59607e;

    /* renamed from: f  reason: collision with root package name */
    public SessionPluginManager f59608f;

    /* renamed from: g  reason: collision with root package name */
    public EventPubSubManager f59609g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59610h = true;

    /* renamed from: i  reason: collision with root package name */
    public PhoenixProgressHandler f59611i = new PhoenixProgressHandler();
    public boolean j;
    public final n k = new n();
    public final m l = new m();
    public final a m = new a();
    public final m n = new m();
    public final c o = new c();
    public final h p = new h();
    public final g q = new g();
    public final k r = new k();
    public final i s = new i();
    public final b t = new b();
    public final j u = new j();
    public String v = "";
    public boolean w;
    public JSONArray x = new JSONArray();
    public l y = new l();
    public boolean z;

    public static final class a extends net.one97.paytm.phoenix.util.a {
    }

    public static final class b extends net.one97.paytm.phoenix.util.a {
    }

    public static final class c extends net.one97.paytm.phoenix.util.a {
    }

    public static final class d extends net.one97.paytm.phoenix.util.a {
    }

    public static final class f extends net.one97.paytm.phoenix.util.a {
    }

    public static final class g extends net.one97.paytm.phoenix.util.a {
    }

    public static final class h extends net.one97.paytm.phoenix.util.a {
    }

    public static final class i extends net.one97.paytm.phoenix.util.a {
    }

    public static final class j extends net.one97.paytm.phoenix.util.a {
    }

    public static final class k extends net.one97.paytm.phoenix.util.a {
    }

    public static final class l extends net.one97.paytm.phoenix.util.a {
    }

    public static final class m extends net.one97.paytm.phoenix.util.a {
    }

    public static final class n extends net.one97.paytm.phoenix.util.a {
    }

    public final View a(int i2) {
        if (this.an == null) {
            this.an = new HashMap();
        }
        View view = (View) this.an.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.an.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class o<T> implements z<Event<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59613a;

        o(PhoenixActivity phoenixActivity) {
            this.f59613a = phoenixActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) ((Event) obj).getContentIfNotHandled();
            if (str != null) {
                WebView webView = (WebView) this.f59613a.a(R.id.webView);
                kotlin.g.b.k.a((Object) webView, "webView");
                net.one97.paytm.phoenix.core.web.a.a(webView, str);
            }
        }
    }

    static final class p<T> implements z<Event<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59614a;

        p(PhoenixActivity phoenixActivity) {
            this.f59614a = phoenixActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) ((Event) obj).getContentIfNotHandled();
            if (str != null) {
                Toast.makeText(this.f59614a.getBaseContext(), str, 0).show();
            }
        }
    }

    public final void a() {
        this.f59610h = false;
    }

    public final TextView b() {
        TextView textView = this.E;
        if (textView == null) {
            kotlin.g.b.k.a("title");
        }
        return textView;
    }

    public final CircularProgressBar c() {
        CircularProgressBar circularProgressBar = this.I;
        if (circularProgressBar == null) {
            kotlin.g.b.k.a("titleLoading");
        }
        return circularProgressBar;
    }

    public final void onCreate(Bundle bundle) {
        Toolbar toolbar;
        String str;
        String str2;
        String str3;
        String str4;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        Bundle extras4;
        Bundle extras5;
        Bundle extras6;
        Bundle extras7;
        Bundle extras8;
        String stringExtra;
        SplashIconViewProvider splashIconViewProvider;
        super.onCreate(bundle);
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "OnCreate");
        setContentView(R.layout.ph5_phoenix_activity);
        Intent intent = getIntent();
        kotlin.g.b.k.a((Object) intent, "intent");
        this.J = intent.getExtras();
        Bundle bundle2 = this.J;
        this.z = bundle2 != null ? bundle2.getBoolean("devModeEnabled", false) : false;
        Bundle bundle3 = this.J;
        if (bundle3 != null) {
            bundle3.remove("devModeEnabled");
        }
        ViewModelFactory.Companion companion = ViewModelFactory.Companion;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        this.R = (PhoenixViewModel) companion.getViewModel(applicationContext).create(PhoenixViewModel.class);
        PhoenixViewModel phoenixViewModel = this.R;
        if (phoenixViewModel == null) {
            kotlin.g.b.k.a("phoenixViewModel");
        }
        androidx.lifecycle.q qVar = this;
        phoenixViewModel.getJavaScript().observe(qVar, new o(this));
        PhoenixViewModel phoenixViewModel2 = this.R;
        if (phoenixViewModel2 == null) {
            kotlin.g.b.k.a("phoenixViewModel");
        }
        phoenixViewModel2.getToastText().observe(qVar, new p(this));
        Context context = this;
        androidx.localbroadcastmanager.a.a.a(context).a(this.am, new IntentFilter("PHOENIX_EXIT_SESSION_INTENT"));
        if (!PhoenixManager.INSTANCE.isDebug$phoenix_debug()) {
            getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        net.one97.paytm.phoenix.manager.a aVar = new net.one97.paytm.phoenix.manager.a();
        PhoenixViewModel phoenixViewModel3 = this.R;
        if (phoenixViewModel3 == null) {
            kotlin.g.b.k.a("phoenixViewModel");
        }
        aVar.f59597a = phoenixViewModel3;
        this.Q = aVar;
        androidx.lifecycle.k lifecycle = getLifecycle();
        Activity activity = this;
        EventPubSubManager eventPubSubManager = new EventPubSubManager(activity);
        this.f59609g = eventPubSubManager;
        lifecycle.a(eventPubSubManager);
        androidx.lifecycle.k lifecycle2 = getLifecycle();
        SessionPluginManager sessionPluginManager = new SessionPluginManager(activity);
        this.f59608f = sessionPluginManager;
        lifecycle2.a(sessionPluginManager);
        Bundle bundle4 = this.J;
        String str5 = null;
        this.H = bundle4 != null ? bundle4.getString(H5Param.APP_TYPE, "") : null;
        net.one97.paytm.phoenix.util.j jVar2 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "appType: " + this.H);
        String str6 = this.H;
        if (str6 != null && (kotlin.m.p.a(str6, "EXTERNAL_TRANSACTIONAL", true) || kotlin.m.p.a(str6, "EXTERNAL_NON_TRANSACTIONAL", true))) {
            this.D = true;
        }
        this.C = PhoenixManager.INSTANCE.getLastPageOpenTimeStamp();
        Bundle bundle5 = this.J;
        Object obj = bundle5 != null ? bundle5.get(H5Param.LONG_SHOW_PROGRESS) : null;
        if (obj instanceof String) {
            net.one97.paytm.phoenix.util.g gVar = net.one97.paytm.phoenix.util.g.f59641a;
            this.W = net.one97.paytm.phoenix.util.g.b((String) obj);
        } else if (obj instanceof Boolean) {
            this.W = ((Boolean) obj).booleanValue();
        }
        net.one97.paytm.phoenix.util.j jVar3 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", H5Param.LONG_SHOW_PROGRESS + this.W);
        Bundle bundle6 = this.J;
        this.aa = kotlin.g.b.k.a((Object) bundle6 != null ? bundle6.getString("overrideSplashClose", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO) : null, (Object) H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        net.one97.paytm.phoenix.util.j jVar4 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "overrideSplashClose" + this.aa);
        Bundle bundle7 = this.J;
        this.F = bundle7 != null ? Boolean.valueOf(bundle7.getBoolean("overrideCrossToBack", false)) : null;
        net.one97.paytm.phoenix.util.j jVar5 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "overrideCrossToBack" + this.F);
        net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PhoenixLoadingViewProvider.class.getName();
        kotlin.g.b.k.a((Object) name, "PhoenixLoadingViewProvider::class.java.name");
        this.U = (PhoenixLoadingViewProvider) b2.a(name);
        this.f59611i.registerObserver(this);
        Bundle bundle8 = this.J;
        this.X = kotlin.g.b.k.a((Object) bundle8 != null ? bundle8.getString("showSplash", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO) : null, (Object) H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        net.one97.paytm.phoenix.util.j jVar6 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "showSplash" + this.X);
        if (this.X) {
            net.one97.paytm.phoenix.api.f b3 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name2 = SplashIconViewProvider.class.getName();
            kotlin.g.b.k.a((Object) name2, "SplashIconViewProvider::class.java.name");
            this.T = (SplashIconViewProvider) b3.a(name2);
            if (this.f59610h && (splashIconViewProvider = this.T) != null) {
                WeakReference weakReference = new WeakReference(this);
                View findViewById = findViewById(16908290);
                kotlin.g.b.k.a((Object) findViewById, "findViewById(android.R.id.content)");
                splashIconViewProvider.showSplashView(weakReference, (FrameLayout) findViewById);
            }
        } else {
            this.f59610h = false;
        }
        Bundle bundle9 = this.J;
        Object obj2 = bundle9 != null ? bundle9.get("showLoading") : null;
        if (obj2 instanceof String) {
            net.one97.paytm.phoenix.util.g gVar2 = net.one97.paytm.phoenix.util.g.f59641a;
            this.Y = net.one97.paytm.phoenix.util.g.b((String) obj2);
        } else if (obj2 instanceof Boolean) {
            this.Y = ((Boolean) obj2).booleanValue();
        }
        net.one97.paytm.phoenix.util.j jVar7 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "showLoading" + this.Y);
        Bundle bundle10 = this.J;
        this.ag = bundle10 != null ? bundle10.getBoolean("showLoadingView") : false;
        net.one97.paytm.phoenix.util.j jVar8 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "showLoadingView" + this.ag);
        Bundle bundle11 = this.J;
        if (Build.VERSION.SDK_INT <= 19) {
            View a2 = a(R.id.shadowView);
            kotlin.g.b.k.a((Object) a2, "shadowView");
            a2.setVisibility(0);
        }
        if (this.D) {
            net.one97.paytm.phoenix.util.j jVar9 = net.one97.paytm.phoenix.util.j.f59646a;
            net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "initToolbar if: " + this.D);
            View findViewById2 = findViewById(R.id.toolbar_merchant);
            kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.toolbar_merchant)");
            toolbar = (Toolbar) findViewById2;
        } else {
            net.one97.paytm.phoenix.util.j jVar10 = net.one97.paytm.phoenix.util.j.f59646a;
            net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "initToolbar else: " + this.D);
            View findViewById3 = findViewById(R.id.toolbar);
            kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.toolbar)");
            toolbar = (Toolbar) findViewById3;
        }
        this.ak = toolbar;
        Toolbar toolbar2 = this.ak;
        if (toolbar2 == null) {
            kotlin.g.b.k.a("toolbar");
        }
        setSupportActionBar(toolbar2);
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(false);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.c(false);
            }
        }
        if (this.D) {
            Boolean valueOf = bundle11 != null ? Boolean.valueOf(bundle11.getBoolean(H5Param.LONG_SHOW_TITLEBAR)) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.booleanValue()) {
                Bundle sParamsBundle = PhoenixManager.INSTANCE.getSParamsBundle();
                Boolean valueOf2 = sParamsBundle != null ? Boolean.valueOf(sParamsBundle.containsKey("paytmChangeStatusBarColor")) : null;
                if (valueOf2 == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf2.booleanValue()) {
                    bundle11.putString("paytmChangeStatusBarColor", "#FFFFFF");
                    bundle11.putInt("statusBarStyle", 1);
                    if (Build.VERSION.SDK_INT >= 23) {
                        Window window = getWindow();
                        kotlin.g.b.k.a((Object) window, "window");
                        View decorView = window.getDecorView();
                        kotlin.g.b.k.a((Object) decorView, "window.decorView");
                        decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    }
                }
                Bundle sParamsBundle2 = PhoenixManager.INSTANCE.getSParamsBundle();
                Boolean valueOf3 = sParamsBundle2 != null ? Boolean.valueOf(sParamsBundle2.containsKey(H5Param.LONG_TITLE_COLOR)) : null;
                if (valueOf3 == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf3.booleanValue()) {
                    bundle11.putString(H5Param.LONG_TITLE_COLOR, "#333333");
                }
                View a3 = a(R.id.toolbar_separator);
                kotlin.g.b.k.a((Object) a3, "toolbar_separator");
                a3.setVisibility(0);
            }
            Toolbar toolbar3 = this.ak;
            if (toolbar3 == null) {
                kotlin.g.b.k.a("toolbar");
            }
            View findViewById4 = toolbar3.findViewById(R.id.tv_toolbar_title_merchant);
            kotlin.g.b.k.a((Object) findViewById4, "toolbar.findViewById(R.i…v_toolbar_title_merchant)");
            this.E = (TextView) findViewById4;
            ProgressBar progressBar = (ProgressBar) a(R.id.progressBarBottomMerchant);
            kotlin.g.b.k.a((Object) progressBar, "progressBarBottomMerchant");
            this.al = progressBar;
            CircularProgressBar circularProgressBar = (CircularProgressBar) a(R.id.pb_title_loading_merchant);
            kotlin.g.b.k.a((Object) circularProgressBar, "pb_title_loading_merchant");
            this.I = circularProgressBar;
        } else {
            ProgressBar progressBar2 = (ProgressBar) a(R.id.progressBarBottom);
            kotlin.g.b.k.a((Object) progressBar2, "progressBarBottom");
            this.al = progressBar2;
            Toolbar toolbar4 = this.ak;
            if (toolbar4 == null) {
                kotlin.g.b.k.a("toolbar");
            }
            View findViewById5 = toolbar4.findViewById(R.id.tv_toolbar_title);
            kotlin.g.b.k.a((Object) findViewById5, "toolbar.findViewById(R.id.tv_toolbar_title)");
            this.E = (TextView) findViewById5;
            CircularProgressBar circularProgressBar2 = (CircularProgressBar) a(R.id.pb_title_loading);
            kotlin.g.b.k.a((Object) circularProgressBar2, "pb_title_loading");
            this.I = circularProgressBar2;
        }
        net.one97.paytm.phoenix.util.j jVar11 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params :", "initToolbar CUSTOMIZE_TITLE_BAR");
        H5Event h5Event = new H5Event("paytmCustomizeTitleBar", com.alipay.mobile.h5container.api.H5Event.TYPE_CALL, a(bundle11), (String) null, false, 24, (kotlin.g.b.g) null);
        h5Event.setActivity(activity);
        net.one97.paytm.phoenix.core.c.f59399a.a().a(h5Event, d());
        Toolbar toolbar5 = this.ak;
        if (toolbar5 == null) {
            kotlin.g.b.k.a("toolbar");
        }
        Drawable overflowIcon = toolbar5.getOverflowIcon();
        if (overflowIcon == null) {
            kotlin.g.b.k.a();
        }
        overflowIcon.setColorFilter(androidx.core.content.b.c(context, 17170444), PorterDuff.Mode.SRC_ATOP);
        Toolbar toolbar6 = this.ak;
        if (toolbar6 == null) {
            kotlin.g.b.k.a("toolbar");
        }
        toolbar6.setOverflowIcon(overflowIcon);
        Boolean valueOf4 = bundle11 != null ? Boolean.valueOf(bundle11.getBoolean(H5Param.LONG_SHOW_TITLEBAR)) : null;
        if (valueOf4 == null) {
            kotlin.g.b.k.a();
        }
        if (valueOf4.booleanValue()) {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.clearFlags(67108864);
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.main_layout);
            kotlin.g.b.k.a((Object) linearLayout, "main_layout");
            linearLayout.setFitsSystemWindows(true);
        } else if (bundle11 == null || bundle11.getBoolean("renderWithinSafeArea")) {
            Window window3 = getWindow();
            if (window3 != null) {
                window3.clearFlags(67108864);
            }
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.main_layout);
            kotlin.g.b.k.a((Object) linearLayout2, "main_layout");
            linearLayout2.setFitsSystemWindows(true);
        } else {
            LinearLayout linearLayout3 = (LinearLayout) a(R.id.main_layout);
            kotlin.g.b.k.a((Object) linearLayout3, "main_layout");
            linearLayout3.setFitsSystemWindows(false);
            getWindow().setFlags(67108864, 67108864);
            if (Build.VERSION.SDK_INT >= 19) {
                new net.one97.paytm.phoenix.util.o();
                int i2 = R.id.main_layout;
                WebView webView = (WebView) a(R.id.webView);
                kotlin.g.b.k.a((Object) webView, "webView");
                kotlin.g.b.k.c(webView, "webView");
                kotlin.g.b.k.c(context, "context");
                Activity activity2 = (Activity) context;
                Window window4 = activity2.getWindow();
                kotlin.g.b.k.a((Object) window4, "(context as Activity).window");
                View decorView2 = window4.getDecorView();
                kotlin.g.b.k.a((Object) decorView2, "(context as Activity).window.decorView");
                View findViewById6 = activity2.findViewById(i2);
                if (findViewById6 != null) {
                    decorView2.getViewTreeObserver().addOnGlobalLayoutListener(new o.a(context, decorView2, (ViewGroup) findViewById6, webView));
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
        }
        Bundle bundle12 = this.J;
        if (bundle12 == null || (str = bundle12.getString("appUniqueId")) == null) {
            str = "";
        }
        this.f59606d = str;
        net.one97.paytm.phoenix.util.j jVar12 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "appUniqueId" + this.f59606d);
        if (this.W) {
            ProgressBar progressBar3 = this.al;
            if (progressBar3 == null) {
                kotlin.g.b.k.a("progressBar");
            }
            progressBar3.setVisibility(0);
        }
        Bundle bundle13 = this.J;
        if (bundle13 == null || (str2 = bundle13.getString(H5Param.LONG_BACK_BEHAVIOR)) == null) {
            str2 = H5Param.DEFAULT_LONG_BACK_BEHAVIOR;
        }
        this.Z = str2;
        net.one97.paytm.phoenix.util.j jVar13 = net.one97.paytm.phoenix.util.j.f59646a;
        StringBuilder sb = new StringBuilder("backBehaviour");
        String str7 = this.Z;
        if (str7 == null) {
            kotlin.g.b.k.a("backBehaviour");
        }
        sb.append(str7);
        net.one97.paytm.phoenix.util.j.b("Startup Params", sb.toString());
        Bundle bundle14 = this.J;
        this.ae = bundle14 != null ? bundle14.getBoolean("showCrossButton") : true;
        net.one97.paytm.phoenix.util.j jVar14 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "showCrossButton" + this.ae);
        Bundle bundle15 = this.J;
        this.O = bundle15 != null ? bundle15.getBoolean("paytmChangeWebSetting") : true;
        net.one97.paytm.phoenix.util.j jVar15 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "webSettingsVal" + this.O);
        net.one97.paytm.phoenix.util.j jVar16 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "devModeEnabled" + this.z);
        Bundle bundle16 = this.J;
        this.af = bundle16 != null ? bundle16.getBoolean("overrideDefaultLoadingCancelBehaviour") : false;
        net.one97.paytm.phoenix.util.j jVar17 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "overrideDefaultLoadingCancelBehaviour" + this.af);
        net.one97.paytm.phoenix.util.j jVar18 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "appTypeMerchant" + this.D);
        Intent intent2 = getIntent();
        String stringExtra2 = intent2 != null ? intent2.getStringExtra(H5Param.LONG_DEFAULT_TITLE) : null;
        net.one97.paytm.phoenix.util.j jVar19 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "DEFAULT_TITLE".concat(String.valueOf(stringExtra2)));
        WebView webView2 = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView2, "webView");
        WebView webView3 = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView3, "webView");
        webView2.setWebChromeClient(new net.one97.paytm.phoenix.core.web.b(webView3, this.S, this.f59611i, stringExtra2, PhoenixManager.INSTANCE.getPhoenixOnShowFileChooser()));
        PhoenixManager.INSTANCE.setPhoenixOnShowFileChooser((b.a) null);
        this.P = new net.one97.paytm.phoenix.core.web.c("phoenixErrorPage.html", this.f59611i);
        WebView webView4 = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView4, "webView");
        WebSettings settings = webView4.getSettings();
        kotlin.g.b.k.a((Object) settings, "webView.settings");
        settings.setMediaPlaybackRequiresUserGesture(this.O);
        WebView webView5 = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView5, "webView");
        net.one97.paytm.phoenix.core.web.c cVar = this.P;
        if (cVar == null) {
            kotlin.g.b.k.a("phoenixWebViewClient");
        }
        webView5.setWebViewClient(cVar);
        this.f59604b = net.one97.paytm.phoenix.core.c.f59399a;
        WebView webView6 = (WebView) a(R.id.webView);
        net.one97.paytm.phoenix.core.c cVar2 = this.f59604b;
        if (cVar2 == null) {
            kotlin.g.b.k.a("service");
        }
        webView6.addJavascriptInterface(new PhoenixJavascriptInterface(activity, cVar2), "PhoenixNativeBridge");
        WebView webView7 = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView7, "webView");
        net.one97.paytm.phoenix.core.web.d dVar = new net.one97.paytm.phoenix.core.web.d(webView7, PhoenixManager.INSTANCE.isDebug$phoenix_debug() || this.z);
        WebSettings settings2 = dVar.f59422a.getSettings();
        if (settings2 != null) {
            try {
                String userAgentString = settings2.getUserAgentString();
                settings2.setUserAgentString(userAgentString + " AppContainer/10.5.10 AppContainer PhoenixContainer/1.0.0-9.1.0-CA-83248-RC2");
                settings2.setJavaScriptEnabled(true);
            } catch (NullPointerException e2) {
                net.one97.paytm.phoenix.util.j jVar20 = net.one97.paytm.phoenix.util.j.f59646a;
                net.one97.paytm.phoenix.util.j.a("WebViewHelper", "exception detail", e2);
            }
            settings2.setDefaultTextEncodingName("utf-8");
            settings2.setSupportMultipleWindows(false);
            settings2.setJavaScriptCanOpenWindowsAutomatically(true);
            settings2.setSavePassword(false);
            settings2.setSaveFormData(false);
            settings2.setLoadsImagesAutomatically(true);
            settings2.setPluginState(WebSettings.PluginState.ON);
            settings2.setDomStorageEnabled(true);
            settings2.setAllowFileAccess(true);
            String a4 = kotlin.g.b.k.a(net.one97.paytm.phoenix.util.i.a(dVar.f59422a.getContext()), (Object) "/phoenix_container");
            net.one97.paytm.phoenix.util.i.b(a4);
            settings2.setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT < 19) {
                boolean unused = net.one97.paytm.phoenix.util.i.b(a4 + "/databases");
                settings2.setDatabasePath(a4 + "/databases");
            }
            boolean unused2 = net.one97.paytm.phoenix.util.i.b(a4 + "/phoenixCache");
            settings2.setAppCachePath(a4 + "/phoenixCache");
            settings2.setAppCacheEnabled(true);
            settings2.getUserAgentString();
            Context context2 = dVar.f59422a.getContext();
            kotlin.g.b.k.a((Object) context2, "webView.context");
            settings2.setCacheMode(net.one97.paytm.phoenix.util.k.a(context2) == k.a.NETWORK_NO_CONNECTION ? 1 : -1);
            settings2.setBuiltInZoomControls(true);
            settings2.setSupportZoom(true);
            settings2.setLoadWithOverviewMode(true);
            settings2.setUseWideViewPort(true);
            settings2.setGeolocationEnabled(true);
            boolean unused3 = net.one97.paytm.phoenix.util.i.b(a4 + "/geolocation");
            settings2.setGeolocationDatabasePath(a4 + "/geolocation");
            settings2.setMediaPlaybackRequiresUserGesture(false);
            settings2.setDisplayZoomControls(false);
            settings2.setAllowFileAccessFromFileURLs(true);
            settings2.setAllowUniversalAccessFromFileURLs(true);
            settings2.setTextSize(WebSettings.TextSize.NORMAL);
        }
        dVar.f59422a.setDownloadListener(new d.a(dVar));
        if (dVar.f59423b && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        Intent intent3 = getIntent();
        if (!(intent3 == null || (stringExtra = intent3.getStringExtra("url_asset_path")) == null)) {
            ((WebView) a(R.id.webView)).loadUrl(stringExtra);
        }
        Bundle bundle17 = this.J;
        String string = bundle17 != null ? bundle17.getString("navColor") : null;
        Bundle bundle18 = this.J;
        if ((bundle18 != null ? bundle18.getString("navColor") : null) != null) {
            Bundle bundle19 = this.J;
            String string2 = bundle19 != null ? bundle19.getString("navColor") : null;
            if (string2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) string2, "bundle?.getString(\"navColor\")!!");
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Window window5 = getWindow();
                    kotlin.g.b.k.a((Object) window5, "window");
                    window5.setNavigationBarColor(Color.parseColor(string2));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        net.one97.paytm.phoenix.util.j jVar21 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params", "navColor".concat(String.valueOf(string)));
        Intent intent4 = getIntent();
        if (intent4 == null || (extras8 = intent4.getExtras()) == null || (str3 = extras8.getString("app_name")) == null) {
            str3 = "";
        }
        this.v = str3;
        Intent intent5 = getIntent();
        if (intent5 == null || (extras7 = intent5.getExtras()) == null || (str4 = extras7.getString("category")) == null) {
            str4 = "";
        }
        this.ah = str4;
        Map hashMap = new HashMap();
        hashMap.put("event_category", "mini_app_opened");
        hashMap.put("event_action", "deeplink");
        hashMap.put("event_label", this.v);
        hashMap.put("event_label2", this.ah);
        hashMap.put("event_label3", this.f59606d);
        a(hashMap, GAUtil.CUSTOM_EVENT);
        Map<String, List<net.one97.paytm.phoenix.api.d>> mapOfTempPlugins = PhoenixManager.INSTANCE.getMapOfTempPlugins();
        this.N = mapOfTempPlugins.get(this.f59606d + this.C);
        Map<String, List<Object>> mapOfTempProviders = PhoenixManager.INSTANCE.getMapOfTempProviders();
        this.M = mapOfTempProviders.get(this.f59606d + this.C);
        Intent intent6 = getIntent();
        String string3 = (intent6 == null || (extras6 = intent6.getExtras()) == null) ? null : extras6.getString("title");
        Intent intent7 = getIntent();
        String string4 = (intent7 == null || (extras5 = intent7.getExtras()) == null) ? null : extras5.getString("subtitle");
        Intent intent8 = getIntent();
        String string5 = (intent8 == null || (extras4 = intent8.getExtras()) == null) ? null : extras4.getString("deeplink");
        Intent intent9 = getIntent();
        String string6 = (intent9 == null || (extras3 = intent9.getExtras()) == null) ? null : extras3.getString(H5Param.MENU_ICON);
        Intent intent10 = getIntent();
        String string7 = (intent10 == null || (extras2 = intent10.getExtras()) == null) ? null : extras2.getString(H5TabbarUtils.MATCH_TYPE_PATH);
        Intent intent11 = getIntent();
        if (!(intent11 == null || (extras = intent11.getExtras()) == null)) {
            str5 = extras.getString("qParam");
        }
        net.one97.paytm.phoenix.util.j jVar22 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "data : " + string3 + ' ' + string4 + ' ' + string5 + ' ' + string6 + ' ' + string7 + ' ' + str5);
        this.aj = new PhoenixMiniAppDialogItems(string4, string3, string5, string6, this.v, string7, str5);
        net.one97.paytm.phoenix.util.g gVar3 = net.one97.paytm.phoenix.util.g.f59641a;
        this.G = net.one97.paytm.phoenix.util.g.a(this.v, this.f59606d);
    }

    public final void a(Map<String, Object> map, String str) {
        kotlin.g.b.k.c(map, "mapData");
        kotlin.g.b.k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PaytmH5AppAnalyticsProvider.class.getName();
        kotlin.g.b.k.a((Object) name, "PaytmH5AppAnalyticsProvider::class.java.name");
        PaytmH5AppAnalyticsProvider paytmH5AppAnalyticsProvider = (PaytmH5AppAnalyticsProvider) b2.a(name);
        if (paytmH5AppAnalyticsProvider != null) {
            paytmH5AppAnalyticsProvider.sendAppAnalytics(this, this.v, str, map, this.f59606d);
        }
    }

    public final net.one97.paytm.phoenix.api.b d() {
        net.one97.paytm.phoenix.api.b bVar = this.Q;
        if (bVar == null) {
            kotlin.g.b.k.a("bridgeContext");
        }
        return bVar;
    }

    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.D) {
            if (this.ae) {
                ((RelativeLayout) a(R.id.rvBackLayout)).setOnClickListener(new s(this));
            } else {
                AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.ivCrossButton);
                kotlin.g.b.k.a((Object) appCompatImageView, "ivCrossButton");
                appCompatImageView.setVisibility(8);
            }
            ((AppCompatImageView) a(R.id.ivDots)).setOnClickListener(new t(this));
        } else if (this.ae) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.iv_toolbar_cross);
            kotlin.g.b.k.a((Object) appCompatImageView2, "iv_toolbar_cross");
            appCompatImageView2.setVisibility(0);
            ((AppCompatImageView) a(R.id.iv_toolbar_cross)).setOnClickListener(new r(this));
        } else {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.iv_toolbar_cross);
            kotlin.g.b.k.a((Object) appCompatImageView3, "iv_toolbar_cross");
            appCompatImageView3.setVisibility(8);
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59616a;

        r(PhoenixActivity phoenixActivity) {
            this.f59616a = phoenixActivity;
        }

        public final void onClick(View view) {
            ((WebView) this.f59616a.a(R.id.webView)).destroy();
            this.f59616a.r.b("onDestroy");
            this.f59616a.finish();
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59617a;

        s(PhoenixActivity phoenixActivity) {
            this.f59617a = phoenixActivity;
        }

        public final void onClick(View view) {
            this.f59617a.G.put("event_label", "cross tapped");
            PhoenixActivity phoenixActivity = this.f59617a;
            phoenixActivity.a(phoenixActivity.G, GAUtil.CUSTOM_EVENT);
            ((WebView) this.f59617a.a(R.id.webView)).destroy();
            this.f59617a.r.b("onDestroy");
            this.f59617a.finish();
        }
    }

    static final class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59618a;

        t(PhoenixActivity phoenixActivity) {
            this.f59618a = phoenixActivity;
        }

        public final void onClick(View view) {
            this.f59618a.G.put("event_label", "menu clicked");
            PhoenixActivity phoenixActivity = this.f59618a;
            phoenixActivity.a(phoenixActivity.G, GAUtil.CUSTOM_EVENT);
            PhoenixActivity.b(this.f59618a);
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.g.b.k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            if (this.w && this.x.length() > 0) {
                int length = this.x.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Object opt = this.x.opt(i2);
                    if (i2 == menuItem.getItemId()) {
                        this.y.b(opt);
                    }
                }
            }
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final Toolbar e() {
        Toolbar toolbar = this.ak;
        if (toolbar == null) {
            kotlin.g.b.k.a("toolbar");
        }
        return toolbar;
    }

    public final JSONObject a(Bundle bundle) {
        int i2;
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("Startup Params :", "getStartUpParams");
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            Object obj = bundle.get(H5Param.LONG_SHOW_TITLEBAR);
            if (obj == null) {
                obj = Boolean.TRUE;
            }
            kotlin.g.b.k.a(obj, "bundle.get(SHOW_TITLE_BAR) ?: true");
            Object obj2 = bundle.get("paytmShowTitleBar");
            if (obj2 == null) {
                obj2 = Boolean.TRUE;
            }
            kotlin.g.b.k.a(obj2, "bundle.get(PAYTM_SHOW_TITLE_BAR) ?: true");
            if (obj2 instanceof String) {
                net.one97.paytm.phoenix.util.g gVar = net.one97.paytm.phoenix.util.g.f59641a;
                jSONObject.put("paytmShowTitleBar", net.one97.paytm.phoenix.util.g.b((String) obj2));
            } else if (obj2 instanceof Boolean) {
                jSONObject.put("paytmShowTitleBar", ((Boolean) obj2).booleanValue());
            }
            if (obj instanceof String) {
                net.one97.paytm.phoenix.util.g gVar2 = net.one97.paytm.phoenix.util.g.f59641a;
                jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, net.one97.paytm.phoenix.util.g.b((String) obj));
            } else if (obj instanceof Boolean) {
                jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, ((Boolean) obj).booleanValue());
            }
            boolean z2 = jSONObject.getBoolean(H5Param.LONG_SHOW_TITLEBAR);
            boolean z3 = jSONObject.getBoolean("paytmShowTitleBar");
            net.one97.paytm.phoenix.util.j jVar2 = net.one97.paytm.phoenix.util.j.f59646a;
            net.one97.paytm.phoenix.util.j.b("Startup Params :", "showTitleBar:".concat(String.valueOf(z2)));
            net.one97.paytm.phoenix.util.j jVar3 = net.one97.paytm.phoenix.util.j.f59646a;
            net.one97.paytm.phoenix.util.j.b("Startup Params :", "paytmShowTitleBar:".concat(String.valueOf(z3)));
            if (z2 && z3) {
                jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, z2);
            } else if (z2 && !z3) {
                jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, z3);
            } else if (!z2 && z3) {
                jSONObject.put(H5Param.LONG_SHOW_TITLEBAR, z2);
            }
            if (bundle.containsKey(H5Param.LONG_TITLE_COLOR)) {
                if (this.D) {
                    i2 = "#333333";
                } else {
                    i2 = -16777216;
                }
                Object obj3 = bundle.get(H5Param.LONG_TITLE_COLOR);
                if (obj3 != null) {
                    i2 = obj3;
                }
                kotlin.g.b.k.a(i2, "bundle.get(SET_TITLE_TEX… ?: defaultTitleTextColor");
                if (i2 instanceof String) {
                    jSONObject.put(H5Param.LONG_TITLE_COLOR, i2);
                } else if (i2 instanceof Integer) {
                    jSONObject.put(H5Param.LONG_TITLE_COLOR, "#" + Integer.toHexString(((Number) i2).intValue()));
                }
            }
            if (bundle.containsKey(H5Param.LONG_TITLE_BAR_COLOR)) {
                int i3 = bundle.get(H5Param.LONG_TITLE_BAR_COLOR);
                if (i3 == null) {
                    i3 = 0;
                }
                kotlin.g.b.k.a(i3, "bundle.get(TITLE_BAR_COLOR) ?: 0");
                if (i3 instanceof String) {
                    jSONObject.put(H5Param.LONG_TITLE_BAR_COLOR, i3);
                } else if (i3 instanceof Integer) {
                    jSONObject.put(H5Param.LONG_TITLE_BAR_COLOR, "#" + Integer.toHexString(((Number) i3).intValue()));
                }
            }
            jSONObject.put(H5Plugin.CommonEvents.SHOW_BACK_BUTTON, bundle.getBoolean(H5Plugin.CommonEvents.SHOW_BACK_BUTTON, true));
            jSONObject.put("paytmChangeStatusBarColor", bundle.getString("paytmChangeStatusBarColor", "#808080"));
            jSONObject.put("paytmChangeBackButtonColor", bundle.getString("paytmChangeBackButtonColor", "#000000"));
            jSONObject.put("appIconUrl", bundle.getString("appIconUrl", ""));
            if (bundle.getInt(H5Param.LONG_BACKBTN_TEXTCOLOR, -1) != -1) {
                jSONObject.put(H5Param.LONG_BACKBTN_TEXTCOLOR, bundle.getInt(H5Param.LONG_BACKBTN_TEXTCOLOR));
            } else {
                jSONObject.put(H5Param.LONG_BACKBTN_TEXTCOLOR, bundle.getString(H5Param.LONG_BACKBTN_TEXTCOLOR));
            }
            jSONObject.put(H5Param.LONG_DEFAULT_TITLE, bundle.getString(H5Param.LONG_DEFAULT_TITLE, ""));
            int i4 = bundle.get("statusBarStyle");
            if (i4 == null) {
                i4 = 0;
            }
            jSONObject.put("statusBarStyle", i4);
            jSONObject.put("showMenuButton", bundle.getBoolean("showMenuButton", true));
            jSONObject.put("appTypeMerchant", this.D);
            jSONObject.put("showStatusBar", bundle.getBoolean("showStatusBar", true));
            jSONObject.put("overrideCrossToBack", this.F);
            Object obj4 = bundle.get("showTitleLoading");
            if (obj4 == null) {
                obj4 = H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
            }
            kotlin.g.b.k.a(obj4, "bundle.get(SHOW_TITLE_LOADING) ?: \"NO\"");
            if (obj4 instanceof String) {
                net.one97.paytm.phoenix.util.g gVar3 = net.one97.paytm.phoenix.util.g.f59641a;
                jSONObject.put("showTitleLoading", net.one97.paytm.phoenix.util.g.b((String) obj4));
            } else if (obj4 instanceof Boolean) {
                jSONObject.put("showTitleLoading", ((Boolean) obj4).booleanValue());
            } else {
                jSONObject.put("showTitleLoading", obj4);
            }
        }
        return jSONObject;
    }

    public final void onBackPressed() {
        if (this.n.countObservers() > 0) {
            this.n.b("");
            return;
        }
        String str = this.Z;
        if (str == null) {
            kotlin.g.b.k.a("backBehaviour");
        }
        if (kotlin.g.b.k.a((Object) str, (Object) "pop")) {
            finish();
        }
        if (this.f59607e) {
            net.one97.paytm.phoenix.core.web.c cVar = this.P;
            if (cVar == null) {
                kotlin.g.b.k.a("phoenixWebViewClient");
            }
            if (cVar.a((WebView) a(R.id.webView)) && this.f59603a != null) {
                net.one97.paytm.phoenix.d.b bVar = this.f59603a;
                if (bVar == null) {
                    kotlin.g.b.k.a("errorCallback");
                }
                if (bVar != null) {
                    net.one97.paytm.phoenix.d.b bVar2 = this.f59603a;
                    if (bVar2 == null) {
                        kotlin.g.b.k.a("errorCallback");
                    }
                    if (bVar2.f59536a != null) {
                        net.one97.paytm.phoenix.d.b bVar3 = this.f59603a;
                        if (bVar3 == null) {
                            kotlin.g.b.k.a("errorCallback");
                        }
                        String str2 = bVar3.f59536a;
                        net.one97.paytm.phoenix.d.b bVar4 = this.f59603a;
                        if (bVar4 == null) {
                            kotlin.g.b.k.a("errorCallback");
                        }
                        H5Event h5Event = new H5Event((String) null, (String) null, (JSONObject) null, str2, bVar4.f59537b, 7, (kotlin.g.b.g) null);
                        h5Event.setActivity(this);
                        net.one97.paytm.phoenix.api.b bVar5 = this.Q;
                        if (bVar5 == null) {
                            kotlin.g.b.k.a("bridgeContext");
                        }
                        bVar5.c(h5Event, new JSONObject());
                        return;
                    }
                }
            }
            if (((WebView) a(R.id.webView)).canGoBack()) {
                ((WebView) a(R.id.webView)).goBack();
            } else {
                super.onBackPressed();
            }
        }
    }

    public final String f() {
        return this.f59606d;
    }

    public final void a(String[] strArr) {
        kotlin.g.b.k.c(strArr, "permissionToRequest");
        androidx.core.app.a.a(this, strArr, 101);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0166, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            super.onActivityResult(r12, r13, r14)
            net.one97.paytm.phoenix.util.j r0 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onActivityResult: requestCode and resultcode"
            r0.<init>(r1)
            r0.append(r12)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PhoenixActivity: "
            net.one97.paytm.phoenix.util.j.b(r1, r0)
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider> r2 = net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider.class
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "PhoenixActivityResultProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object r0 = r0.a(r2)
            net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider r0 = (net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider) r0
            java.util.Map<java.lang.Integer, java.lang.String> r2 = r11.ac
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            if (r2 != 0) goto L_0x0049
            net.one97.paytm.phoenix.core.a r2 = r11.f59605c
            if (r2 == 0) goto L_0x0048
            java.lang.String r2 = r2.k
            goto L_0x0049
        L_0x0048:
            r2 = r3
        L_0x0049:
            if (r0 == 0) goto L_0x0053
            r4 = r11
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Object r0 = r0.onActivityResult(r4, r12, r13, r14)
            goto L_0x0054
        L_0x0053:
            r0 = r3
        L_0x0054:
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "onActivityResult: actionName and result "
            r4.<init>(r5)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            net.one97.paytm.phoenix.util.j.b(r1, r4)
            java.lang.String r4 = "paytmPayment"
            r5 = -1
            if (r2 != 0) goto L_0x0071
            goto L_0x0243
        L_0x0071:
            int r6 = r2.hashCode()
            java.lang.String r7 = "it"
            r8 = 0
            r9 = 1
            switch(r6) {
                case -582107739: goto L_0x0238;
                case -567028024: goto L_0x021c;
                case -450254537: goto L_0x0169;
                case -102536757: goto L_0x015a;
                case 600163783: goto L_0x0139;
                case 677282122: goto L_0x012b;
                case 700206469: goto L_0x011c;
                case 1306974590: goto L_0x008c;
                case 1756156877: goto L_0x007e;
                default: goto L_0x007c;
            }
        L_0x007c:
            goto L_0x0243
        L_0x007e:
            java.lang.String r14 = "paytmNavigateTo"
            boolean r14 = r2.equals(r14)
            if (r14 == 0) goto L_0x0243
            net.one97.paytm.phoenix.ui.PhoenixActivity$j r14 = r11.u
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0247
        L_0x008c:
            java.lang.String r6 = "paytmPickFile"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0243
            java.util.ArrayList r0 = new java.util.ArrayList
            r6 = 10
            r0.<init>(r6)
            if (r14 == 0) goto L_0x00a1
            android.content.ClipData r3 = r14.getClipData()
        L_0x00a1:
            if (r3 != 0) goto L_0x00a4
            r9 = 0
        L_0x00a4:
            java.lang.String r3 = ""
            if (r9 == 0) goto L_0x00fc
            if (r14 == 0) goto L_0x0116
            android.content.ClipData r14 = r14.getClipData()
            if (r14 == 0) goto L_0x0116
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            int r6 = r14.getItemCount()
        L_0x00b7:
            if (r8 >= r6) goto L_0x0116
            android.content.ClipData$Item r7 = r14.getItemAt(r8)
            java.lang.String r9 = "it.getItemAt(i)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.net.Uri r7 = r7.getUri()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "image"
            r9.<init>(r10)
            r9.append(r8)
            java.lang.String r10 = "="
            r9.append(r10)
            java.lang.String r10 = r7.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.io.PrintStream r10 = java.lang.System.out
            r10.println(r9)
            net.one97.paytm.phoenix.util.l r9 = net.one97.paytm.phoenix.util.l.f59649a
            r9 = r11
            android.content.Context r9 = (android.content.Context) r9
            java.lang.String r10 = "uri"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)
            java.lang.String r7 = net.one97.paytm.phoenix.util.l.a(r9, r7)
            if (r7 != 0) goto L_0x00f6
            r7 = r3
        L_0x00f6:
            r0.add(r7)
            int r8 = r8 + 1
            goto L_0x00b7
        L_0x00fc:
            if (r14 == 0) goto L_0x0116
            android.net.Uri r14 = r14.getData()
            if (r14 == 0) goto L_0x0116
            net.one97.paytm.phoenix.util.l r6 = net.one97.paytm.phoenix.util.l.f59649a
            r6 = r11
            android.content.Context r6 = (android.content.Context) r6
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            java.lang.String r14 = net.one97.paytm.phoenix.util.l.a(r6, r14)
            if (r14 != 0) goto L_0x0113
            r14 = r3
        L_0x0113:
            r0.add(r14)
        L_0x0116:
            net.one97.paytm.phoenix.ui.PhoenixActivity$g r14 = r11.q
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0247
        L_0x011c:
            java.lang.String r14 = "paytmCaptureImageFromCamera"
            boolean r14 = r2.equals(r14)
            if (r14 == 0) goto L_0x0243
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            net.one97.paytm.phoenix.ui.PhoenixActivity$c r14 = r11.o
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0166
        L_0x012b:
            java.lang.String r14 = "paytmGetLocation"
            boolean r14 = r2.equals(r14)
            if (r14 == 0) goto L_0x0243
            net.one97.paytm.phoenix.ui.PhoenixActivity$i r14 = r11.s
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0247
        L_0x0139:
            java.lang.String r6 = "paytmOpenGallery"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0243
            if (r14 == 0) goto L_0x0155
            android.net.Uri r14 = r14.getData()
            if (r14 == 0) goto L_0x0155
            net.one97.paytm.phoenix.util.l r0 = net.one97.paytm.phoenix.util.l.f59649a
            r0 = r11
            android.content.Context r0 = (android.content.Context) r0
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            java.lang.String r3 = net.one97.paytm.phoenix.util.l.a(r0, r14)
        L_0x0155:
            net.one97.paytm.phoenix.ui.PhoenixActivity$h r14 = r11.p
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0166
        L_0x015a:
            java.lang.String r14 = "paytmAuthenticateOnDevice"
            boolean r14 = r2.equals(r14)
            if (r14 == 0) goto L_0x0243
            net.one97.paytm.phoenix.ui.PhoenixActivity$b r14 = r11.t
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
        L_0x0166:
            r0 = r3
            goto L_0x0247
        L_0x0169:
            java.lang.String r6 = "phoenixHtmlPickFile"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0243
            if (r13 != r5) goto L_0x020d
            if (r14 == 0) goto L_0x01bf
            android.os.Bundle r0 = r14.getExtras()
            if (r0 == 0) goto L_0x01bf
            java.lang.String r6 = "data"
            java.lang.Object r0 = r0.get(r6)
            if (r0 == 0) goto L_0x01bf
            net.one97.paytm.phoenix.manager.b r12 = r11.S     // Catch:{ Exception -> 0x01b7 }
            android.net.Uri[] r13 = new android.net.Uri[r9]     // Catch:{ Exception -> 0x01b7 }
            net.one97.paytm.phoenix.util.e r0 = net.one97.paytm.phoenix.util.e.f59639a     // Catch:{ Exception -> 0x01b7 }
            android.content.Context r0 = r11.getApplicationContext()     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r2 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x01b7 }
            android.os.Bundle r14 = r14.getExtras()     // Catch:{ Exception -> 0x01b7 }
            if (r14 == 0) goto L_0x019c
            java.lang.Object r3 = r14.get(r6)     // Catch:{ Exception -> 0x01b7 }
        L_0x019c:
            if (r3 == 0) goto L_0x01af
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ Exception -> 0x01b7 }
            android.net.Uri r14 = net.one97.paytm.phoenix.util.e.a(r0, r3)     // Catch:{ Exception -> 0x01b7 }
            if (r14 != 0) goto L_0x01a9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01b7 }
        L_0x01a9:
            r13[r8] = r14     // Catch:{ Exception -> 0x01b7 }
            r12.a(r13)     // Catch:{ Exception -> 0x01b7 }
            return
        L_0x01af:
            kotlin.u r12 = new kotlin.u     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r13 = "null cannot be cast to non-null type android.graphics.Bitmap"
            r12.<init>(r13)     // Catch:{ Exception -> 0x01b7 }
            throw r12     // Catch:{ Exception -> 0x01b7 }
        L_0x01b7:
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r12 = "Some Issues with File Picker"
            net.one97.paytm.phoenix.util.j.b(r1, r12)
            return
        L_0x01bf:
            java.lang.String r0 = "null cannot be cast to non-null type android.net.Uri"
            if (r14 == 0) goto L_0x01e8
            android.net.Uri r6 = r14.getData()
            if (r6 == 0) goto L_0x01e8
            android.net.Uri r12 = r14.getData()
            boolean r12 = r12 instanceof android.net.Uri
            if (r12 == 0) goto L_0x01e7
            android.net.Uri r12 = r14.getData()
            android.net.Uri[] r13 = new android.net.Uri[r9]
            if (r12 == 0) goto L_0x01e1
            r13[r8] = r12
            net.one97.paytm.phoenix.manager.b r12 = r11.S
            r12.a(r13)
            goto L_0x01e7
        L_0x01e1:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r0)
            throw r12
        L_0x01e7:
            return
        L_0x01e8:
            if (r14 == 0) goto L_0x01ef
            java.lang.String r6 = r14.getDataString()
            goto L_0x01f0
        L_0x01ef:
            r6 = r3
        L_0x01f0:
            if (r6 == 0) goto L_0x0216
            java.lang.String r14 = r14.getDataString()
            android.net.Uri r14 = android.net.Uri.parse(r14)
            android.net.Uri[] r3 = new android.net.Uri[r9]
            if (r14 == 0) goto L_0x0207
            r3[r8] = r14
            net.one97.paytm.phoenix.manager.b r0 = r11.S
            r0.a(r3)
            r3 = r14
            goto L_0x0216
        L_0x0207:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r0)
            throw r12
        L_0x020d:
            net.one97.paytm.phoenix.manager.b r14 = r11.S
            android.webkit.ValueCallback<android.net.Uri[]> r14 = r14.f59599a
            if (r14 == 0) goto L_0x0216
            r14.onReceiveValue(r3)
        L_0x0216:
            net.one97.paytm.phoenix.ui.PhoenixActivity$d r14 = r11.ad
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0166
        L_0x021c:
            java.lang.String r14 = "paytmLogin"
            boolean r14 = r2.equals(r14)
            if (r14 == 0) goto L_0x0243
            net.one97.paytm.phoenix.util.j r14 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r14 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Login Result: "
            java.lang.String r14 = r3.concat(r14)
            net.one97.paytm.phoenix.util.j.b(r1, r14)
            net.one97.paytm.phoenix.ui.PhoenixActivity$a r14 = r11.m
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0247
        L_0x0238:
            boolean r14 = r2.equals(r4)
            if (r14 == 0) goto L_0x0243
            net.one97.paytm.phoenix.ui.PhoenixActivity$m r14 = r11.l
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
            goto L_0x0247
        L_0x0243:
            net.one97.paytm.phoenix.ui.PhoenixActivity$d r14 = r11.ad
            net.one97.paytm.phoenix.util.a r14 = (net.one97.paytm.phoenix.util.a) r14
        L_0x0247:
            if (r13 == r5) goto L_0x025a
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "paytmAddMoney"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0258
            goto L_0x025a
        L_0x0258:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x025a:
            net.one97.paytm.phoenix.util.j r2 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r2 = java.lang.String.valueOf(r13)
            java.lang.String r3 = "Observable Result: "
            java.lang.String r2 = r3.concat(r2)
            net.one97.paytm.phoenix.util.j.b(r1, r2)
            if (r13 != r5) goto L_0x028d
            net.one97.paytm.phoenix.util.j r2 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r2 = "resultCode: "
            java.lang.String r13 = r2.concat(r13)
            net.one97.paytm.phoenix.util.j.b(r1, r13)
            net.one97.paytm.phoenix.util.j r13 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r13 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "resultData: "
            java.lang.String r13 = r2.concat(r13)
            net.one97.paytm.phoenix.util.j.b(r1, r13)
            r14.b(r0)
            goto L_0x029f
        L_0x028d:
            net.one97.paytm.phoenix.util.j r13 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r13 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "actionCancelled  Result: "
            java.lang.String r13 = r2.concat(r13)
            net.one97.paytm.phoenix.util.j.b(r1, r13)
            r14.a(r0)
        L_0x029f:
            java.util.Map<java.lang.Integer, java.lang.String> r13 = r11.ac
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r13.remove(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.ui.PhoenixActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 101) {
            if (!(iArr.length == 0)) {
                this.k.b(new kotlin.o(strArr, iArr));
            } else {
                this.k.a(Boolean.FALSE);
            }
        }
    }

    public final Observable g() {
        return this.k;
    }

    public final Observable h() {
        return this.m;
    }

    public final Observable i() {
        return this.u;
    }

    public final Observable j() {
        return this.ad;
    }

    public static final class e {
        private e() {
        }

        public /* synthetic */ e(byte b2) {
            this();
        }

        public static void a(Context context, String str, Bundle bundle) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(str, "urlOrAssetPath");
            Intent intent = new Intent(context, PhoenixActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("url_asset_path", str);
            intent.putExtra("url", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        }
    }

    public final void a(Intent intent, int i2, String str) {
        this.ac.put(Integer.valueOf(i2), str);
        super.startActivityForResult(intent, i2);
    }

    public final void onProgressUpdate(int i2) {
        ProgressBar progressBar = this.al;
        if (progressBar == null) {
            kotlin.g.b.k.a("progressBar");
        }
        progressBar.setProgress(i2);
        this.V = Integer.valueOf(i2);
        if (this.f59610h) {
            SplashIconViewProvider splashIconViewProvider = this.T;
            if (splashIconViewProvider != null) {
                splashIconViewProvider.updateProgress(i2);
                return;
            }
            return;
        }
        PhoenixLoadingViewProvider phoenixLoadingViewProvider = this.U;
        if (phoenixLoadingViewProvider != null) {
            phoenixLoadingViewProvider.updateProgress(i2);
        }
    }

    public final void onPageFinished() {
        if (this.f59610h && !this.aa) {
            SplashIconViewProvider splashIconViewProvider = this.T;
            if (splashIconViewProvider != null) {
                splashIconViewProvider.hideSplashView();
            }
            this.f59610h = false;
        }
        if (this.af) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isResultRequired", false);
            H5Event h5Event = new H5Event("paytmHideLoadingView", com.alipay.mobile.h5container.api.H5Event.TYPE_CALL, jSONObject, (String) null, false, 24, (kotlin.g.b.g) null);
            h5Event.setActivity(this);
            net.one97.paytm.phoenix.core.c.f59399a.a().a(h5Event, d());
        } else {
            this.ab = false;
            PhoenixLoadingViewProvider phoenixLoadingViewProvider = this.U;
            if (phoenixLoadingViewProvider != null) {
                phoenixLoadingViewProvider.hideLoadingView(this);
            }
        }
        ProgressBar progressBar = this.al;
        if (progressBar == null) {
            kotlin.g.b.k.a("progressBar");
        }
        progressBar.setVisibility(8);
    }

    public final void onPageStarted() {
        if (this.W) {
            ProgressBar progressBar = this.al;
            if (progressBar == null) {
                kotlin.g.b.k.a("progressBar");
            }
            progressBar.setVisibility(0);
        }
        if ((this.Y || this.ag) && !this.f59610h && !this.ab) {
            this.ab = true;
            PhoenixLoadingViewProvider phoenixLoadingViewProvider = this.U;
            if (phoenixLoadingViewProvider != null) {
                phoenixLoadingViewProvider.showLoadingView(this);
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        ((WebView) a(R.id.webView)).clearCache(true);
        ((WebView) a(R.id.webView)).destroy();
        this.G.clear();
        androidx.localbroadcastmanager.a.a.a((Context) this).a((BroadcastReceiver) this.am);
        this.r.b("onDestroy");
        this.f59611i.unregisterObserver(this);
    }

    public final void onStop() {
        super.onStop();
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "onStop");
        this.r.b("onStop");
    }

    public final void onResume() {
        super.onResume();
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "onResume");
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        List<? extends net.one97.paytm.phoenix.api.d> list = this.N;
        PhoenixManager.addTempPlugins(list, this.f59606d + this.C);
        net.one97.paytm.phoenix.util.j jVar2 = net.one97.paytm.phoenix.util.j.f59646a;
        StringBuilder sb = new StringBuilder(" add for url ");
        WebView webView = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView, "webView");
        sb.append(webView.getUrl());
        net.one97.paytm.phoenix.util.j.b("Phoenixmanager PhoenixFetchValuesForKeysPlugin", sb.toString());
        List<? extends Object> list2 = this.M;
        PhoenixManager.addTempProviders(list2, this.f59606d + this.C);
        PhoenixManager.INSTANCE.setLastOpenedAppUniqueId(this.f59606d);
        if (this.z && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public final void onPause() {
        super.onPause();
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "onPause");
        PhoenixManager.removeTempPlugins(this.f59606d + this.C);
        net.one97.paytm.phoenix.util.j jVar2 = net.one97.paytm.phoenix.util.j.f59646a;
        StringBuilder sb = new StringBuilder(" removed for url ");
        WebView webView = (WebView) a(R.id.webView);
        kotlin.g.b.k.a((Object) webView, "webView");
        sb.append(webView.getUrl());
        net.one97.paytm.phoenix.util.j.b("Phoenixmanager PhoenixFetchValuesForKeysPlugin", sb.toString());
        PhoenixManager.removeTempProviders(this.f59606d + this.C);
        if (this.z && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
    }

    static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59615a;

        q(PhoenixActivity phoenixActivity) {
            this.f59615a = phoenixActivity;
        }

        public final void run() {
            this.f59615a.k();
        }
    }

    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            k();
        }
    }

    /* access modifiers changed from: private */
    public final void k() {
        if (this.B) {
            Window window = getWindow();
            kotlin.g.b.k.a((Object) window, "window");
            View decorView = window.getDecorView();
            kotlin.g.b.k.a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(3846);
        }
    }

    public static final class u implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59619a;

        public u(PhoenixActivity phoenixActivity) {
            this.f59619a = phoenixActivity;
        }

        public final void onSystemUiVisibilityChange(int i2) {
            if ((i2 & 4) == 0 && this.f59619a.B) {
                new Handler().postDelayed(this.f59619a.K, 3000);
            }
        }
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        if (this.w) {
            if (menu != null) {
                menu.clear();
            }
            if (this.x.length() > 0) {
                int length = this.x.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Object opt = this.x.opt(i2);
                    if (!(opt instanceof String)) {
                        opt = null;
                    }
                    String str = (String) opt;
                    if (menu != null) {
                        menu.add(0, i2, 0, str);
                    }
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public static final /* synthetic */ void b(PhoenixActivity phoenixActivity) {
        List<PhoenixMenuDialogItems> arrayList = new ArrayList<>();
        PhoenixMenuDialogItems phoenixMenuDialogItems = new PhoenixMenuDialogItems(1, "", "Invite Friends");
        PhoenixMenuDialogItems phoenixMenuDialogItems2 = new PhoenixMenuDialogItems(2, "", "Add to Homescreen");
        arrayList.add(phoenixMenuDialogItems);
        arrayList.add(phoenixMenuDialogItems2);
        if (arrayList.size() > 0) {
            phoenixActivity.ai = new net.one97.paytm.phoenix.a.b(phoenixActivity);
            net.one97.paytm.phoenix.a.b bVar = phoenixActivity.ai;
            if (bVar != null) {
                androidx.fragment.app.j supportFragmentManager = phoenixActivity.getSupportFragmentManager();
                net.one97.paytm.phoenix.a.b bVar2 = phoenixActivity.ai;
                bVar.show(supportFragmentManager, bVar2 != null ? bVar2.getTag() : null);
            }
            net.one97.paytm.phoenix.a.b bVar3 = phoenixActivity.ai;
            if (bVar3 != null) {
                kotlin.g.b.k.c(arrayList, "menuItemsList");
                bVar3.f59375a = arrayList;
            }
            Bundle bundle = new Bundle();
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems = phoenixActivity.aj;
            if (phoenixMiniAppDialogItems == null) {
                kotlin.g.b.k.a("miniDialogData");
            }
            bundle.putSerializable("data", phoenixMiniAppDialogItems);
            net.one97.paytm.phoenix.a.b bVar4 = phoenixActivity.ai;
            if (bVar4 != null) {
                bVar4.setArguments(bundle);
                return;
            }
            return;
        }
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b("PhoenixActivity", "menu dialog items list size is 0");
    }
}
