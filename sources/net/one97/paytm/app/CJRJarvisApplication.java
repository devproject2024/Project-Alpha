package net.one97.paytm.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.multidex.MultiDexApplication;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.AppsFlyerLib;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.PaymentsInitConfig;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.c;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.g;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.n;
import com.paytm.analytics.b;
import com.paytm.analytics.models.Config;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.ProfileInitConfig;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.erroranalytics.c.a;
import com.paytm.network.b.i;
import com.paytm.notification.g;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.PushConfig;
import com.paytm.notification.models.callback.ChannelProviderCallback;
import com.paytm.notification.models.callback.ErrorReportCallback;
import com.paytm.utility.a.b;
import com.paytm.utility.q;
import com.paytm.utility.x;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.utils.SFHomeHelper;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.squareup.picasso.v;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.a.b;
import net.one97.paytm.acceptPayment.configs.AcceptPaymentsInitConfig;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.appManager.a;
import net.one97.paytm.auth.OAuthDataProviderImpl;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.contactsdk.ContactSDKInterfaceImpl;
import net.one97.paytm.helper.d;
import net.one97.paytm.landingpage.utils.MBModuleCommunicator;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.moneytransfer.MoneyTransferImplProvider;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.payments.visascp.Server;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.payments.visascp.VisaSDK;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.receiver.CJRPhoneIncomingOutgoingStateReceiver;
import net.one97.paytm.upgradeKyc.helper.g;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.m;
import net.one97.paytm.upi.o;
import net.one97.paytm.upi.util.UpiContract;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ai;
import net.one97.paytm.utils.aj;
import net.one97.paytm.utils.ao;
import net.one97.paytm.utils.ap;
import net.one97.paytm.utils.aw;
import net.one97.paytm.utils.ay;

public class CJRJarvisApplication extends MultiDexApplication implements OnAccountsUpdateListener, p {
    private static Boolean A = Boolean.FALSE;
    private static Boolean B = Boolean.FALSE;
    private static boolean D;

    /* renamed from: f  reason: collision with root package name */
    private static Context f49001f;

    /* renamed from: g  reason: collision with root package name */
    private static CJRCatalog f49002g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f49003h = Boolean.TRUE;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f49004i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static CJRUrlUtmData l;
    private static VisaSCP o;
    private static a p;
    private static long r;
    private static boolean s;
    private static Trace t;
    private static Trace u;
    private static int v;
    /* access modifiers changed from: private */
    public static boolean w;
    /* access modifiers changed from: private */
    public static View x;
    /* access modifiers changed from: private */
    public static View y;
    private static Drawable z;
    private boolean C;

    /* renamed from: a  reason: collision with root package name */
    public CJRFrequentOrderList f49005a;

    /* renamed from: b  reason: collision with root package name */
    public CJRCatalogSavedState f49006b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49007c = false;

    /* renamed from: d  reason: collision with root package name */
    public CJRHomePageV2 f49008d;

    /* renamed from: e  reason: collision with root package name */
    ChannelProviderCallback f49009e = $$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY.INSTANCE;
    private AccountManager m;
    private CJRPhoneIncomingOutgoingStateReceiver n;
    private a q = new a();

    public static void a() {
        D = false;
    }

    public static boolean b() {
        return D;
    }

    public static void c() {
        f49004i = false;
    }

    public static void d() {
        j = false;
    }

    public static void e() {
        k = false;
    }

    public static Context getAppContext() {
        return f49001f;
    }

    public static boolean f() {
        return f49003h.booleanValue();
    }

    public static CJRUrlUtmData g() {
        return l;
    }

    public static void a(CJRUrlUtmData cJRUrlUtmData) {
        l = cJRUrlUtmData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        r0 = android.view.LayoutInflater.from(getAppContext()).inflate(net.one97.paytm.paytm_finance.R.layout.action_bar_layout_home, (android.view.ViewGroup) null);
        r1 = z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r1 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        r1 = androidx.core.content.b.f.a(getAppContext().getResources(), (int) net.one97.paytm.paytm_finance.R.drawable.background_splash, (android.content.res.Resources.Theme) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        z = r1;
        r1 = A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        x = r0;
        A.notify();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View h() {
        /*
            java.lang.Boolean r0 = A
            monitor-enter(r0)
            java.lang.Boolean r1 = A     // Catch:{ all -> 0x0062 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0062 }
            r2 = 0
            if (r1 == 0) goto L_0x002a
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0062 }
            android.os.Looper r3 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0062 }
            if (r1 == r3) goto L_0x0018
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r2
        L_0x0018:
            android.view.View r1 = x     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0026
            java.lang.Boolean r1 = A     // Catch:{ InterruptedException -> 0x0022 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0062 }
        L_0x0026:
            android.view.View r1 = x     // Catch:{ all -> 0x0062 }
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r1
        L_0x002a:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0062 }
            A = r1     // Catch:{ all -> 0x0062 }
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            android.content.Context r0 = getAppContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2131558445(0x7f0d002d, float:1.8742206E38)
            android.view.View r0 = r0.inflate(r1, r2)
            android.graphics.drawable.Drawable r1 = z
            if (r1 != 0) goto L_0x0051
            android.content.Context r1 = getAppContext()
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131231048(0x7f080148, float:1.8078166E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.f.a((android.content.res.Resources) r1, (int) r3, (android.content.res.Resources.Theme) r2)
        L_0x0051:
            z = r1
            java.lang.Boolean r1 = A
            monitor-enter(r1)
            x = r0     // Catch:{ all -> 0x005f }
            java.lang.Boolean r2 = A     // Catch:{ all -> 0x005f }
            r2.notify()     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            return r0
        L_0x005f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r0
        L_0x0062:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.app.CJRJarvisApplication.h():android.view.View");
    }

    public static View i() {
        synchronized (B) {
            if (!B.booleanValue()) {
                B = Boolean.TRUE;
                View inflate = LayoutInflater.from(getAppContext()).inflate(R.layout.home_activity_main, (ViewGroup) null);
                SFHomeHelper.INSTANCE.initHomeView(getAppContext());
                synchronized (B) {
                    y = inflate;
                    B.notify();
                }
                return inflate;
            } else if (Looper.getMainLooper() != Looper.myLooper()) {
                return null;
            } else {
                if (y == null) {
                    try {
                        B.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                View view = y;
                return view;
            }
        }
    }

    public void onCreate() {
        String processName;
        w = false;
        c.a((Context) this);
        com.google.firebase.perf.a.a();
        Trace b2 = com.google.firebase.perf.a.b("app_click_home_render_trace");
        t = b2;
        b2.start();
        com.google.firebase.perf.a.a();
        Trace b3 = com.google.firebase.perf.a.b("app_click_window_focus_trace");
        u = b3;
        b3.start();
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                CJRJarvisApplication.s();
            }
        }, 30000);
        super.onCreate();
        Trace a2 = com.google.firebase.perf.a.a("Application_initializeModulesTrace");
        ab.a().getLifecycle().a(this);
        D = true;
        f49001f = getApplicationContext();
        com.google.firebase.crashlytics.c.a().b(com.paytm.utility.a.a(getApplicationContext()));
        v = D();
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                SFGsonUtils.INSTANCE.getPojo("{}", Item.class, false);
            }
        });
        x.a("androidapp", "market-app", "9a071762-a499-4bd9-914a-4361e7c3f4bc", "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=", "690mw4l105f61a99844c20ui56ni3s78d", "1", "1", "paytmmp", "paytm");
        i.a(f49001f, "690mw4l105f61a99844c20ui56ni3s78d", "1", "1", new ap());
        com.google.firebase.remoteconfig.a a3 = com.google.firebase.remoteconfig.a.a();
        h.a(a3.f39306b, g.a(a3, new n.a().a(ag.a(this).b("firebaseMinimumFetchIntervalInSeconds", 3600, true)).a()));
        p = new a(this, a3, new kotlin.g.a.a<kotlin.x>() {
            public final /* synthetic */ Object invoke() {
                boolean unused = CJRJarvisApplication.w = true;
                CJRJarvisApplication.this.E();
                androidx.localbroadcastmanager.a.a.a((Context) CJRJarvisApplication.this).a(new Intent("SEND_REMOTE_CONFIG_LOADED_MESSAGE"));
                return kotlin.x.f47997a;
            }
        });
        d.f49586a = new net.one97.paytm.landingpage.utils.a();
        e.a();
        a aVar = p;
        com.google.firebase.remoteconfig.a aVar2 = aVar.f49019a;
        a.C0863a aVar3 = a.f49018b;
        aVar2.a(a.C0863a.b());
        com.google.firebase.remoteconfig.a aVar4 = aVar.f49019a;
        Task<f> b4 = aVar4.f39307c.b();
        Task<f> b5 = aVar4.f39308d.b();
        h.b(b4, b5).b(aVar4.f39306b, new com.google.firebase.remoteconfig.e(aVar4, b4, b5)).a(new a.d(aVar));
        AsyncTask.SERIAL_EXECUTOR.execute(new a.e(aVar));
        net.one97.paytm.j.c.a();
        i.a(net.one97.paytm.j.c.a("networkEnableOldThreadPool", true));
        net.one97.paytm.j.c.a();
        i.a(net.one97.paytm.j.c.a("networkThreadCount", 8));
        net.one97.paytm.j.c.a();
        String a4 = net.one97.paytm.j.c.a("sslPinningConfigV2", (String) null);
        getApplicationContext();
        i.b();
        getApplicationContext();
        i.a(a4);
        q.d(a4);
        Trace a5 = com.google.firebase.perf.a.a("Application_executeOnMainThreadTrace");
        try {
            com.paytm.erroranalytics.e.a((Context) this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        com.paytm.network.i.a();
        com.paytm.network.a.a.a.a();
        com.paytm.network.f.a((Context) this);
        b.a();
        PaytmSDK.init("9.1.3", this);
        net.one97.paytm.upi.i.a(this);
        net.one97.paytm.upi.i a6 = net.one97.paytm.upi.i.a();
        a6.f66987h = false;
        a6.f66988i = "release";
        o oVar = new o();
        a6.m = oVar;
        a6.l = new m();
        a6.k = oVar;
        UpiGTMLoader.getInstance().setOnCustomNewGTMEvent(oVar);
        net.one97.paytm.upi.h.a.a(this, new a.C1347a() {
            public final void onServiceConnected() {
            }

            public final void onServiceDisconnected() {
                l.a(CJRJarvisApplication.class.getSimpleName(), "initNpciLibrary", new Throwable("NPCI :serviceDisconnected"));
            }
        });
        MoneyTransferImplProvider.k();
        MBModuleCommunicator.init();
        OAuthDataProviderImpl.initOAuthModule();
        net.one97.paytm.recharge.g.a(this);
        if (net.one97.paytm.o.a.f12660a == null) {
            net.one97.paytm.o.a aVar5 = new net.one97.paytm.o.a();
            net.one97.paytm.o.a.f12660a = aVar5;
            net.one97.paytm.paymentslimit.a.b.f59274a = aVar5;
        }
        AcceptPaymentsInitConfig.Builder acceptPaymentsListener = new AcceptPaymentsInitConfig.Builder(this).setAcceptPaymentsListener(new net.one97.paytm.acceptPayment.a());
        com.business.common_module.b.h hVar = r9;
        com.business.common_module.b.h hVar2 = new com.business.common_module.b.h("androidapp", "market-app", "9a071762-a499-4bd9-914a-4361e7c3f4bc", "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=", "umpapp-3754-36d-aqr-cn7", "690mw4l105f61a99844c20ui56ni3s78d");
        AcceptPaymentsInitConfig build = acceptPaymentsListener.setApplicationKeys(hVar).build();
        if (net.one97.paytm.acceptPayment.configs.a.f52046a == null) {
            net.one97.paytm.acceptPayment.configs.a.f52046a = new net.one97.paytm.acceptPayment.configs.a(build);
        }
        PaymentsConfig.init(new PaymentsInitConfig.Builder(net.one97.paytm.acceptPayment.configs.a.f52046a.f52047b).setApplicationContext(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()).setClientName("Accept Payments").setAppBuildConfiguration(new com.business.common_module.b.a("net.one97.paytm.acceptPayment", "release", "prod", "1.0")).setApplicationKeys(net.one97.paytm.acceptPayment.configs.a.f52046a.f52048c).setGAEventPublisher(new net.one97.paytm.acceptPayment.e.d()).setAppSharedPreference(net.one97.paytm.acceptPayment.e.a.a.f52055a).setMerchantDataProvider(net.one97.paytm.acceptPayment.d.a.f52050a).setGtmDataProvider(new net.one97.paytm.acceptPayment.e.e()).setErrorHandlerListener(new net.one97.paytm.acceptPayment.e.c()).setCommonUtils(new net.one97.paytm.acceptPayment.e.a()).setDeepLinkTargetScreenIntentString("key_deeplink_target_screen_id").setDeepLinkUtils(new net.one97.paytm.acceptPayment.e.b()).setHawkEyeNetworkInterface(new net.one97.paytm.acceptPayment.e.f("Payments")).setCommonHeaderInterface(new net.one97.paytm.acceptPayment.e.h()).setNativeAppKeyManager(new net.one97.paytm.acceptPayment.e.g()).build());
        ProfileConfig.init(new ProfileInitConfig.Builder(net.one97.paytm.acceptPayment.configs.a.f52046a.f52047b).setApplicationContext(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()).setClientName("Accept Payments").setAppBuildConfiguration(new com.business.common_module.b.a("net.one97.paytm.acceptPayment", "release", "prod", "1.0")).setApplicationKeys(net.one97.paytm.acceptPayment.configs.a.f52046a.f52048c).setGAEventPublisher(new net.one97.paytm.acceptPayment.e.d()).setAppSharedPreference(net.one97.paytm.acceptPayment.e.a.a.f52055a).setMerchantDataProvider(net.one97.paytm.acceptPayment.d.a.f52050a).setGtmDataProvider(new net.one97.paytm.acceptPayment.e.e()).setErrorHandlerListener(new net.one97.paytm.acceptPayment.e.c()).setCommonUtils(new net.one97.paytm.acceptPayment.e.a()).setDeepLinkTargetScreenIntentString("key_deeplink_target_screen_id").setDeepLinkUtils(new net.one97.paytm.acceptPayment.e.b()).setHawkEyeNetworkInterface(new net.one97.paytm.acceptPayment.e.f("Profile")).setCommonHeaderInterface(new net.one97.paytm.acceptPayment.e.h()).setNativeAppKeyManager(new net.one97.paytm.acceptPayment.e.g()).build());
        net.one97.paytm.wallet.communicator.b.d();
        g.a aVar6 = net.one97.paytm.upgradeKyc.helper.g.f66031a;
        g.a.a();
        d.a aVar7 = net.one97.paytm.helper.d.f50549a;
        d.a.a();
        net.one97.paytm.addmoney.b.o();
        net.one97.paytm.p2b.b.r();
        net.one97.paytm.passbook.e.a();
        CLPArtifact.init(getAppContext(), new net.one97.paytm.q.a());
        net.one97.paytm.j.c.a();
        com.paytm.utility.a.b(net.one97.paytm.j.c.a("key_child_site_id", (String) null));
        net.one97.paytm.j.c.a();
        com.paytm.utility.a.a(net.one97.paytm.j.c.a("key_site_id", (String) null));
        try {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("paytm_ga_enabled", true)) {
                b.C0683b bVar = com.paytm.analytics.b.f40911e;
                AnonymousClass5 r0 = new com.paytm.analytics.a() {
                    public final void a(Throwable th) {
                        q.b("onError(): " + th.getMessage());
                        com.google.firebase.crashlytics.c.a().a(th);
                    }
                };
                long currentTimeMillis = System.currentTimeMillis();
                new Thread(new b.C0683b.c(r0, this, currentTimeMillis)).start();
                StringBuilder sb = new StringBuilder("***** init() UI thread took [");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append("] ms ***** ");
                net.one97.paytm.notification.a.b();
            } else {
                b.C0683b bVar2 = com.paytm.analytics.b.f40911e;
                b.C0683b.c();
            }
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
        try {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("notification_sdk_enabled", true)) {
                NotificationProjectConfig build2 = new NotificationProjectConfig.Builder().setAppId("paytmnotifications-4f440").setAppKey("1:877176097642:android:39faf9b2fdb5d986").setSenderId("877176097642").setApiKey("AIzaSyB1e6IH5qXcm-78Hev_VS-wqs6h63Q-U2Y").setFlashPrimaryColorFromResource(17170443).setFlashSecondaryColorFromResource(R.color.color_504efa).showFlashFromPush(false).build();
                PushConfig build3 = new PushConfig.Builder().setAppVersion("9.1.3").setClientName("androidapp").setSecret("632b6388699b11e8adc0fa7ae01bbebc").setConfigEndPoints("https://push-config.paytm.com").setSDKMode("loginSdk").setMsgIcon(Integer.valueOf(R.drawable.ic_paytm_white)).build();
                g.c cVar = com.paytm.notification.g.f43191a;
                Context applicationContext = getApplicationContext();
                ChannelProviderCallback channelProviderCallback = this.f49009e;
                AnonymousClass4 r9 = new ErrorReportCallback() {
                    public final void onSetUserIdentifier(String str) {
                        com.google.firebase.crashlytics.c.a().b(str);
                    }

                    public final void onError(Throwable th) {
                        com.google.firebase.crashlytics.c.a().a(th);
                    }

                    public final void onErrorLog(String str) {
                        com.google.firebase.crashlytics.c.a().a(str);
                    }
                };
                k.c(applicationContext, "context");
                k.c(build3, "pushConfig");
                k.c(build2, "projectConfig");
                new Thread(new g.c.C0726c(r9, applicationContext, channelProviderCallback, build3, build2)).start();
            }
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
        try {
            net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
            net.one97.paytm.utils.m.a((Context) this);
            net.one97.paytm.utils.m mVar2 = net.one97.paytm.utils.m.f69757a;
            k.c(this, "activity");
            try {
                AppsFlyerLib.getInstance().setAndroidIdData(Settings.Secure.getString(getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID));
            } catch (Exception e5) {
                try {
                    if (com.paytm.utility.b.v) {
                        mVar2.getClass().getSimpleName();
                        q.b(e5.getMessage());
                    }
                } catch (Exception e6) {
                    if (com.paytm.utility.b.v) {
                        mVar2.getClass().getSimpleName();
                        q.b(e6.getMessage());
                    }
                }
            }
            AppsFlyerLib.getInstance().setCollectIMEI(false);
            AppsFlyerLib.getInstance().setOneLinkCustomDomain("p.paytm.me");
            AppsFlyerLib.getInstance().setAppInviteOneLink("xCTH");
            AppsFlyerLib.getInstance().setCurrencyCode("INR");
            AppsFlyerLib.getInstance().startTracking(this);
        } catch (Exception e7) {
            if (com.paytm.utility.b.v) {
                getClass().getSimpleName();
                q.b(e7.getMessage());
            }
        }
        ContactsSdk.INSTANCE.init(ContactSDKInterfaceImpl.f50280a);
        a5.stop();
        androidx.appcompat.app.e.m();
        com.paytm.ads.a.a(this, "9.1.3");
        if (Build.VERSION.SDK_INT >= 28 && (processName = getProcessName()) != null && !"net.one97.paytm".equals(processName)) {
            WebView.setDataDirectorySuffix(processName);
        }
        net.one97.paytm.common.b.d.f49586a.n(this);
        com.paytm.c.b.a(ay.f69701a);
        b.a aVar8 = com.paytm.utility.a.b.f43681a;
        aj ajVar = aj.f69609a;
        k.c(ajVar, "hawkeyeListener");
        com.paytm.utility.a.b.f43682b = ajVar;
        a2.stop();
    }

    public static VisaSCP a(Context context) {
        if (o == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return o;
            }
            net.one97.paytm.j.c.a();
            o = VisaSDK.getInstance(context, net.one97.paytm.j.c.a("google_safety_net_api_key", (String) null));
        }
        VisaSDK.setServer(Server.PRODUCTION);
        return o;
    }

    public static void j() {
        f49003h = Boolean.TRUE;
        w.a aVar = new w.a(f49001f);
        Context context = f49001f;
        v vVar = new v(context, aw.a(context));
        if (aVar.f45453a == null) {
            aVar.f45453a = vVar;
            try {
                w.a(aVar.a());
            } catch (IllegalStateException e2) {
                ao.a(CJRJarvisApplication.class, e2.getMessage());
            }
        } else {
            throw new IllegalStateException("Downloader already set.");
        }
    }

    private int D() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return -1;
        }
    }

    public static CJRCatalog k() {
        return f49002g;
    }

    public static void a(CJRCatalog cJRCatalog) {
        f49002g = cJRCatalog;
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (i2 >= 15) {
            try {
                ai.INSTANCE.evictAll();
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            ai.INSTANCE.evictAll();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onAccountsUpdated(final Account[] accountArr) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    if (accountArr != null) {
                        ArrayList<DeviceAccount> arrayList = new ArrayList<>();
                        for (Account account : accountArr) {
                            if (account.type != null && (account.type.equalsIgnoreCase("com.google") || account.type.equalsIgnoreCase("com.samsung.android.coreapps") || account.type.equalsIgnoreCase("com.twitter.android.auth.login"))) {
                                arrayList.add(new DeviceAccount(account.type, account.name));
                            }
                        }
                        net.one97.paytm.f.a.a().f50398e = arrayList;
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f49001f = this;
        com.google.android.play.core.splitcompat.a.a((Context) this);
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                View unused = CJRJarvisApplication.x = CJRJarvisApplication.h();
                View unused2 = CJRJarvisApplication.y = CJRJarvisApplication.i();
            }
        });
    }

    public static void l() {
        try {
            com.paytm.utility.b.r();
            g.c cVar = com.paytm.notification.g.f43191a;
            g.c.a(com.paytm.utility.b.n(getAppContext()));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void m() {
        try {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("paytm_ga_enabled", true)) {
                b.C0683b bVar = com.paytm.analytics.b.f40911e;
                Config.Builder messageVersion = new Config.Builder().clientName("androidapp").secret("632b6388699b11e8adc0fa7ae01bbebc").appVersion("9.1.3").messageVersion(2);
                net.one97.paytm.notification.d dVar = net.one97.paytm.notification.d.f55977a;
                Config.Builder deviceId = messageVersion.customDimension(net.one97.paytm.notification.d.a()).deviceId(com.paytm.utility.b.A(getAppContext()));
                net.one97.paytm.j.c.a();
                Config.Builder serverEndPoints = deviceId.serverEndPoints(net.one97.paytm.j.c.a("signalSdkUrl", (String) null));
                net.one97.paytm.j.c.a();
                Config.Builder uploadFrequency = serverEndPoints.uploadFrequency(Integer.valueOf(net.one97.paytm.j.c.a("signal_batch_freq", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder isLocationEnable = uploadFrequency.isLocationEnable(Boolean.valueOf(net.one97.paytm.j.c.a("paytm_location_enabled", true)));
                net.one97.paytm.j.c.a();
                Config.Builder locationSchedulingTime = isLocationEnable.locationSchedulingTime(Integer.valueOf(net.one97.paytm.j.c.a("location_scheduling_time_sec", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder locationNightModeStartHour = locationSchedulingTime.locationNightModeStartHour(Integer.valueOf(net.one97.paytm.j.c.a("location_night_mode_start_hour", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder locationNightModeEndHour = locationNightModeStartHour.locationNightModeEndHour(Integer.valueOf(net.one97.paytm.j.c.a("location_night_mode_end_hour", 0)));
                net.one97.paytm.j.c.a();
                b.C0683b.a(locationNightModeEndHour.sameLocationThreshold(Integer.valueOf(net.one97.paytm.j.c.a("same_location_iteration_threshold", 0))).timeSyncFrequency(Integer.valueOf((int) TimeUnit.HOURS.toSeconds(1))).build());
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void n() {
        try {
            com.paytm.erroranalytics.e a2 = com.paytm.erroranalytics.e.a();
            a.C0712a aVar = new a.C0712a();
            aVar.f42719b = com.paytm.utility.a.a(getAppContext());
            aVar.f42718a = com.paytm.utility.a.d(getAppContext());
            aVar.f42724g = "release";
            aVar.f42725h = "paytm";
            net.one97.paytm.j.c.a();
            aVar.f42723f = net.one97.paytm.j.c.a("errorSdkUrl", (String) null);
            aVar.f42726i = "androidapp";
            net.one97.paytm.j.c.a();
            aVar.j = net.one97.paytm.j.c.a("error_sdk_event_scheduling_time_sec", 0);
            net.one97.paytm.j.c.a();
            aVar.k = net.one97.paytm.j.c.a("show_error_analytics_logs", false);
            a2.a(aVar.a());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static net.one97.paytm.appManager.a o() {
        return p;
    }

    public static void p() {
        Trace trace = t;
        if (trace != null) {
            trace.stop();
            t = null;
        }
    }

    public static void q() {
        Trace trace = u;
        if (trace != null) {
            trace.stop();
            u = null;
        }
    }

    public static void r() {
        t = null;
    }

    public static int t() {
        return v;
    }

    public static boolean u() {
        return w;
    }

    /* access modifiers changed from: private */
    public void E() {
        net.one97.paytm.appManager.a aVar = p;
        if (aVar != null && !this.C) {
            aVar.a((Context) this);
            this.C = true;
        }
    }

    public static View x() {
        return h();
    }

    public static void y() {
        x = null;
        A = Boolean.FALSE;
    }

    public static View z() {
        return i();
    }

    public static void A() {
        y = null;
        B = Boolean.FALSE;
    }

    public static Drawable B() {
        return z;
    }

    @aa(a = k.a.ON_START)
    public void onAppForground() {
        s = false;
        androidx.localbroadcastmanager.a.a.a(f49001f).a(new Intent("ACTION_ON_APP_FOREGROUND"));
        registerActivityLifecycleCallbacks(this.q);
        this.n = new CJRPhoneIncomingOutgoingStateReceiver();
        registerReceiver(this.n, new IntentFilter("android.intent.action.PHONE_STATE"));
        try {
            if (this.m == null) {
                this.m = AccountManager.get(this);
                this.m.addOnAccountsUpdatedListener(this, (Handler) null, true);
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.j.a.a();
        net.one97.paytm.appManager.storage.b.a aVar = net.one97.paytm.appManager.storage.b.a.f49053c;
        net.one97.paytm.appManager.storage.b.a.a(false);
        if (w) {
            E();
        }
        if (!D && !TextUtils.isEmpty(com.paytm.utility.a.q(getAppContext())) && com.paytm.utility.a.p(getAppContext())) {
            SFInterface.INSTANCE.notifySuccessTransaction(H5Param.MENU_REFRESH);
        }
        if (net.one97.paytm.common.b.d.f49586a != null && !D) {
            net.one97.paytm.common.b.d.f49586a.n(this);
        }
    }

    @aa(a = k.a.ON_STOP)
    public void onAppStop() {
        t = null;
        u = null;
        r = System.currentTimeMillis();
        s = true;
        unregisterReceiver(this.n);
        try {
            if (this.m != null) {
                this.m.removeOnAccountsUpdatedListener(this);
                this.m = null;
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.j.a.b();
        unregisterActivityLifecycleCallbacks(this.q);
        net.one97.paytm.common.b.d.f49586a.o(this);
    }

    public static void s() {
        t = null;
        u = null;
    }

    public static void v() {
        p.c().f49025a = false;
        e.b();
    }

    public static boolean w() {
        return p.c().f49025a;
    }
}
