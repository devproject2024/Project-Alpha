package net.one97.paytm.acceptPayment.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.utility.BackgroundTaskExecutor;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.j;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.m.p;
import kotlin.o;
import kotlin.x;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.a.m;
import net.one97.paytm.acceptPayment.webviewcomponents.MerchantLimitUpgradeHandler;
import net.one97.paytm.acceptPayment.webviewcomponents.MerchantLimitUpgradeWebViewClient;
import net.one97.paytm.acceptPayment.webviewcomponents.OnboardingReactHandler;
import net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity;
import net.one97.paytm.acceptPayment.webviewutils.b.e;

public final class AcceptPaymentWebViewActivity extends BaseWebViewActivity {

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.acceptPayment.webviewutils.b.f f52207c;

    /* renamed from: d  reason: collision with root package name */
    public VideoEnabledWebView f52208d;

    /* renamed from: e  reason: collision with root package name */
    private m f52209e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52210f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.acceptPayment.webviewutils.b.e f52211g;

    /* renamed from: h  reason: collision with root package name */
    private final int f52212h = H5PullContainer.DEFALUT_DURATION;

    /* renamed from: i  reason: collision with root package name */
    private i f52213i;
    private final String j;
    private ViewGroup k;
    private View l;
    private View m;
    /* access modifiers changed from: private */
    public boolean n;
    private final g o;

    private net.one97.paytm.acceptPayment.viewModel.c k() {
        return (net.one97.paytm.acceptPayment.viewModel.c) this.o.getValue();
    }

    public AcceptPaymentWebViewActivity() {
        String name = AcceptPaymentWebViewActivity.class.getName();
        k.b(name, "AcceptPaymentWebViewActivity::class.java.name");
        this.j = name;
        this.o = h.a(new a(this));
    }

    static final class a extends l implements kotlin.g.a.a<net.one97.paytm.acceptPayment.viewModel.c> {
        final /* synthetic */ AcceptPaymentWebViewActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
            super(0);
            this.this$0 = acceptPaymentWebViewActivity;
        }

        public final net.one97.paytm.acceptPayment.viewModel.c invoke() {
            ai a2 = am.a((FragmentActivity) this.this$0).a(net.one97.paytm.acceptPayment.viewModel.c.class);
            k.b(a2, "ViewModelProviders.of(th…iewViewmodel::class.java)");
            return (net.one97.paytm.acceptPayment.viewModel.c) a2;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m mVar = (m) androidx.databinding.f.a(this, R.layout.js_webkit_webview);
        this.f52209e = mVar;
        if (mVar != null) {
            mVar.a(k());
        }
        m mVar2 = this.f52209e;
        if (mVar2 != null) {
            mVar2.setLifecycleOwner(this);
        }
        View findViewById = findViewById(R.id.channels_web_view);
        k.b(findViewById, "findViewById(R.id.channels_web_view)");
        this.f52208d = (VideoEnabledWebView) findViewById;
        this.m = findViewById(R.id.nonVideoLayout);
        this.k = (ViewGroup) findViewById(R.id.videoLayout);
        this.l = getLayoutInflater().inflate(R.layout.ap_view_loading_video, (ViewGroup) null);
        new BackgroundTaskExecutor(getLifecycle()).execute(new b(this), new c(this));
    }

    static final /* synthetic */ class b extends j implements kotlin.g.a.a<x> {
        b(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
            super(0, acceptPaymentWebViewActivity, AcceptPaymentWebViewActivity.class, "init", "init()V", 0);
        }

        public final void invoke() {
            AcceptPaymentWebViewActivity.a((AcceptPaymentWebViewActivity) this.receiver);
        }
    }

    public static final class c implements BackgroundTaskExecutor.BackgroundTaskListener<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentWebViewActivity f52214a;

        public final void onError(Exception exc) {
            k.d(exc, "e");
        }

        c(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
            this.f52214a = acceptPaymentWebViewActivity;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            k.d((x) obj, "data");
            AcceptPaymentWebViewActivity.b(this.f52214a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getStringExtra("deeplink_url");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c() {
        /*
            r2 = this;
            android.content.Intent r0 = r2.getIntent()
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "deeplink_url"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = "paytmmp://accept_money"
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity.c():java.lang.String");
    }

    private final o<String, String> j() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("pageId")) == null) {
            str = "ump_page";
        }
        Intent intent2 = getIntent();
        return new o<>(str, intent2 != null ? intent2.getStringExtra("url") : null);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == this.f52212h && intent != null && intent.getData() != null) {
            Uri[] uriArr = {intent.getData()};
            if (g() != null) {
                g().onReceiveValue(uriArr);
                a((ValueCallback<Uri[]>) null);
            }
        }
        if (i2 == 2001) {
            try {
                i iVar = this.f52213i;
                if (iVar == null) {
                    k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
                }
                String b2 = net.one97.paytm.acceptPayment.utils.b.b(iVar.f52229b);
                k.b(b2, "AcceptPaymentUtils.decodeUrl(config.url)");
                String a2 = p.a(p.a(b2, "&addBankSuccess=false", "", false), "&addBankSuccess=true", "", false);
                if (i3 == -1) {
                    net.one97.paytm.acceptPayment.b.a b3 = net.one97.paytm.acceptPayment.configs.a.a().b();
                    i iVar2 = this.f52213i;
                    if (iVar2 == null) {
                        k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
                    }
                    String str = iVar2.f52228a;
                    b3.a((Context) this, net.one97.paytm.acceptPayment.utils.b.a(str, a2 + "&addBankSuccess=true"));
                } else {
                    net.one97.paytm.acceptPayment.b.a b4 = net.one97.paytm.acceptPayment.configs.a.a().b();
                    i iVar3 = this.f52213i;
                    if (iVar3 == null) {
                        k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
                    }
                    String str2 = iVar3.f52228a;
                    b4.a((Context) this, net.one97.paytm.acceptPayment.utils.b.a(str2, a2 + "&addBankSuccess=false"));
                }
                finish();
            } catch (Exception unused) {
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(ValueCallback<Uri[]> valueCallback, String str) {
        k.d(valueCallback, "filePathCallback");
        k.d(str, "type");
        a(valueCallback);
        if (net.one97.paytm.acceptPayment.webviewutils.a.c(this)) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            startActivityForResult(intent, this.f52212h);
            return;
        }
        androidx.core.app.a.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
        valueCallback.onReceiveValue((Object) null);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.d(strArr, "permissions");
        k.d(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    static final class d implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentWebViewActivity f52215a;

        d(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
            this.f52215a = acceptPaymentWebViewActivity;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (net.one97.paytm.acceptPayment.webviewutils.a.c(this.f52215a)) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setMimeType(str4);
                request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
                request.addRequestHeader("User-Agent", str2);
                request.setDescription("Downloading file...");
                request.setTitle(URLUtil.guessFileName(str, str3, str4));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str3, str4));
                Object systemService = this.f52215a.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                if (systemService != null) {
                    ((DownloadManager) systemService).enqueue(request);
                    Toast.makeText(this.f52215a.getApplicationContext(), "Downloading File", 1).show();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
            }
            s.b((Activity) this.f52215a);
        }
    }

    public static final class e extends net.one97.paytm.acceptPayment.webviewutils.b.e {
        public final void onProgressChanged(WebView webView, int i2) {
            k.d(webView, "view");
        }

        e(Handler handler, View view, ViewGroup viewGroup, View view2, VideoEnabledWebView videoEnabledWebView) {
            super(handler, view, viewGroup, view2, videoEnabledWebView);
        }
    }

    static final class f implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentWebViewActivity f52216a;

        f(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
            this.f52216a = acceptPaymentWebViewActivity;
        }

        public final void a(boolean z) {
            if (z) {
                Window window = this.f52216a.getWindow();
                k.b(window, "window");
                WindowManager.LayoutParams attributes = window.getAttributes();
                k.b(attributes, "window.attributes");
                int i2 = attributes.flags | TarConstants.EOF_BLOCK;
                attributes.flags = i2;
                attributes.flags = i2 | 128;
                Window window2 = this.f52216a.getWindow();
                k.b(window2, "window");
                window2.setAttributes(attributes);
                Window window3 = this.f52216a.getWindow();
                k.b(window3, "window");
                View decorView = window3.getDecorView();
                k.b(decorView, "window.decorView");
                decorView.setSystemUiVisibility(1);
                this.f52216a.setRequestedOrientation(0);
                this.f52216a.n = true;
                return;
            }
            Window window4 = this.f52216a.getWindow();
            k.b(window4, "window");
            WindowManager.LayoutParams attributes2 = window4.getAttributes();
            k.b(attributes2, "window.attributes");
            int i3 = attributes2.flags & -1025;
            attributes2.flags = i3;
            attributes2.flags = i3 & -129;
            Window window5 = this.f52216a.getWindow();
            k.b(window5, "window");
            window5.setAttributes(attributes2);
            Window window6 = this.f52216a.getWindow();
            k.b(window6, "window");
            View decorView2 = window6.getDecorView();
            k.b(decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(0);
            this.f52216a.setRequestedOrientation(1);
            this.f52216a.n = false;
        }
    }

    public final void a(String str) {
        k.d(str, "urlOrScript");
        VideoEnabledWebView videoEnabledWebView = this.f52208d;
        if (videoEnabledWebView == null) {
            k.a("videoEnabledWebView");
        }
        videoEnabledWebView.loadUrl(str);
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        if (this.n) {
            setRequestedOrientation(1);
            return;
        }
        VideoEnabledWebView videoEnabledWebView = this.f52208d;
        if (videoEnabledWebView == null) {
            k.a("videoEnabledWebView");
        }
        videoEnabledWebView.loadUrl("javascript:onBackPressed();");
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        k.d(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (i2 == 4) {
            if (!this.f52210f) {
                finish();
            }
            if (this.n) {
                setRequestedOrientation(1);
            } else {
                String component2 = j().component2();
                if (component2 != null) {
                    net.one97.paytm.acceptPayment.b.b.a();
                    if (component2.equals(net.one97.paytm.acceptPayment.b.b.c(PaymentsGTMConstants.AP_SETTLE_NOW_URL))) {
                        VideoEnabledWebView videoEnabledWebView = this.f52208d;
                        if (videoEnabledWebView == null) {
                            k.a("videoEnabledWebView");
                        }
                        if (!videoEnabledWebView.canGoBack()) {
                            finish();
                        }
                    }
                }
                if (h() != null) {
                    Message message = new Message();
                    message.what = 3;
                    message.obj = "javascript:onMessageReceive(\"hardwareBackButtonPress\",\"\");";
                    h().sendMessage(message);
                }
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final void a(double d2, double d3, int i2, String str) {
        k.d(str, "locationCallback");
        String a2 = this.f52207c != null ? net.one97.paytm.acceptPayment.webviewutils.b.f.a(d2, d3, i2, str) : null;
        VideoEnabledWebView videoEnabledWebView = this.f52208d;
        if (videoEnabledWebView == null) {
            k.a("videoEnabledWebView");
        }
        if (videoEnabledWebView != null) {
            videoEnabledWebView.loadUrl(a2);
        }
    }

    public final void d() {
        net.one97.paytm.acceptPayment.viewModel.c k2 = k();
        if (k2 != null) {
            k2.f52186b.postValue(8);
            k2.f52187c.postValue(Boolean.FALSE);
        }
        this.f52210f = true;
    }

    public final void a(String str, String str2) {
        net.one97.paytm.acceptPayment.viewModel.c k2;
        k.d(str, "errorDesc");
        k.d(str2, "failingUrl");
        if (!this.f52210f) {
            i iVar = this.f52213i;
            if (iVar == null) {
                k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
            }
            if (p.a(str2, iVar.f52229b, true) && (k2 = k()) != null) {
                k2.f52187c.postValue(Boolean.FALSE);
                k2.f52185a.postValue(0);
            }
        }
    }

    public final Object b(String str) {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        return extras.get(str);
    }

    public final net.one97.paytm.acceptPayment.webviewutils.b.f e() {
        return this.f52207c;
    }

    public final void finish() {
        org.greenrobot.eventbus.c.a().d(new d((byte) 0));
        super.finish();
    }

    public final void f() {
        net.one97.paytm.acceptPayment.configs.a a2 = net.one97.paytm.acceptPayment.configs.a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        a2.b().a((Activity) this);
    }

    public static final /* synthetic */ void a(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
        String str;
        Class cls;
        Class cls2;
        o<String, String> j2 = acceptPaymentWebViewActivity.j();
        g gVar = new g(j2.component1(), j2.component2());
        String str2 = gVar.f52226a;
        h a2 = g.a(gVar.f52226a);
        if (a2 instanceof e) {
            String str3 = gVar.f52227b;
            if (str3 == null) {
                k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
                str3 = net.one97.paytm.acceptPayment.b.b.b();
            }
            str = net.one97.paytm.acceptPayment.webviewutils.b.d.a(str3, g.a());
        } else if (a2 instanceof c) {
            String str4 = gVar.f52227b;
            if (str4 == null) {
                k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
                str4 = net.one97.paytm.acceptPayment.b.b.f();
            }
            str = net.one97.paytm.acceptPayment.webviewutils.b.d.a(str4, g.a());
        } else if (a2 instanceof f) {
            String str5 = gVar.f52227b;
            if (str5 == null) {
                str5 = "";
            }
            str = net.one97.paytm.acceptPayment.webviewutils.b.d.a(str5, g.a());
        } else if (a2 instanceof b) {
            str = gVar.f52227b;
            if (str == null) {
                str = "";
            }
        } else {
            throw new kotlin.m();
        }
        k.b(str, "getUrl()");
        Map<String, String> a3 = g.a();
        HashMap hashMap = new HashMap();
        k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
        hashMap.put("x-app-client", net.one97.paytm.acceptPayment.b.b.c());
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        hashMap.put("x-app-token", com.paytm.utility.d.a(b2.a()));
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.acceptPayment.b.a b3 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b3, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        sb.append(com.paytm.utility.b.a(b3.a()));
        sb.append("-IN");
        hashMap.put("Accept-Language", sb.toString());
        hashMap.put("source", "PaytmAndroid");
        net.one97.paytm.acceptPayment.b.a b4 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b4, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        hashMap.put(AppConstants.VERSION_NAME, com.paytm.utility.b.Q(b4.a()));
        net.one97.paytm.acceptPayment.b.a b5 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b5, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        hashMap.put(AppConstants.VERSION_CODE, String.valueOf(net.one97.paytm.acceptPayment.utils.b.a(b5.a())));
        hashMap.put(Constants.RISK_OS_TYPE, StringSet.Android);
        hashMap.put("isFeatureMapAvailable", "true");
        String D = net.one97.paytm.acceptPayment.d.a.f52050a.D();
        if (D == null) {
            D = "";
        }
        hashMap.put("x-app-mid", D);
        h a4 = g.a(gVar.f52226a);
        if (a4 instanceof c) {
            cls = MerchantLimitUpgradeHandler.class;
        } else if (a4 instanceof e) {
            cls = OnboardingReactHandler.class;
        } else {
            cls = net.one97.paytm.acceptPayment.webviewutils.b.c.class;
        }
        Class cls3 = cls;
        if (g.a(gVar.f52226a) instanceof c) {
            cls2 = MerchantLimitUpgradeWebViewClient.class;
        } else {
            cls2 = net.one97.paytm.acceptPayment.webviewutils.b.a.class;
        }
        i iVar = new i(str2, str, a3, hashMap, "UMP", cls3, cls2);
        acceptPaymentWebViewActivity.f52213i = iVar;
        Object newInstance = iVar.f52232e.getConstructor(new Class[]{BaseWebViewActivity.class}).newInstance(new Object[]{acceptPaymentWebViewActivity});
        k.b(newInstance, "config.reactHandlerClass…s.java).newInstance(this)");
        net.one97.paytm.acceptPayment.webviewutils.b.c cVar = (net.one97.paytm.acceptPayment.webviewutils.b.c) newInstance;
        acceptPaymentWebViewActivity.a(cVar);
        i iVar2 = acceptPaymentWebViewActivity.f52213i;
        if (iVar2 == null) {
            k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
        }
        acceptPaymentWebViewActivity.f52207c = new net.one97.paytm.acceptPayment.webviewutils.b.f(cVar, iVar2.f52231d);
    }

    public static final /* synthetic */ void b(AcceptPaymentWebViewActivity acceptPaymentWebViewActivity) {
        WebSettings settings;
        WebSettings settings2;
        WebSettings settings3;
        VideoEnabledWebView videoEnabledWebView = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView == null) {
            k.a("videoEnabledWebView");
        }
        WebSettings settings4 = videoEnabledWebView.getSettings();
        if (settings4 != null) {
            settings4.setJavaScriptEnabled(true);
        }
        i iVar = acceptPaymentWebViewActivity.f52213i;
        if (iVar == null) {
            k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
        }
        Constructor<? extends net.one97.paytm.acceptPayment.webviewutils.b.a> constructor = iVar.f52233f.getConstructor(new Class[]{Handler.class, String.class, String.class});
        Object[] objArr = new Object[3];
        objArr[0] = acceptPaymentWebViewActivity.h();
        objArr[1] = "";
        i iVar2 = acceptPaymentWebViewActivity.f52213i;
        if (iVar2 == null) {
            k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
        }
        objArr[2] = iVar2.f52229b;
        net.one97.paytm.acceptPayment.webviewutils.b.a aVar = (net.one97.paytm.acceptPayment.webviewutils.b.a) constructor.newInstance(objArr);
        VideoEnabledWebView videoEnabledWebView2 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView2 == null) {
            k.a("videoEnabledWebView");
        }
        if (!(videoEnabledWebView2 == null || (settings3 = videoEnabledWebView2.getSettings()) == null)) {
            settings3.setDomStorageEnabled(true);
        }
        VideoEnabledWebView videoEnabledWebView3 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView3 == null) {
            k.a("videoEnabledWebView");
        }
        if (!(videoEnabledWebView3 == null || (settings2 = videoEnabledWebView3.getSettings()) == null)) {
            settings2.setSupportMultipleWindows(true);
        }
        VideoEnabledWebView videoEnabledWebView4 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView4 == null) {
            k.a("videoEnabledWebView");
        }
        if (!(videoEnabledWebView4 == null || (settings = videoEnabledWebView4.getSettings()) == null)) {
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        VideoEnabledWebView videoEnabledWebView5 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView5 == null) {
            k.a("videoEnabledWebView");
        }
        if (videoEnabledWebView5 != null) {
            videoEnabledWebView5.addJavascriptInterface(acceptPaymentWebViewActivity.f52207c, "CommunicationWindow");
        }
        VideoEnabledWebView videoEnabledWebView6 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView6 == null) {
            k.a("videoEnabledWebView");
        }
        if (videoEnabledWebView6 != null) {
            videoEnabledWebView6.setDownloadListener(new d(acceptPaymentWebViewActivity));
        }
        Handler h2 = acceptPaymentWebViewActivity.h();
        View view = acceptPaymentWebViewActivity.m;
        ViewGroup viewGroup = acceptPaymentWebViewActivity.k;
        View view2 = acceptPaymentWebViewActivity.l;
        VideoEnabledWebView videoEnabledWebView7 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView7 == null) {
            k.a("videoEnabledWebView");
        }
        e eVar = new e(h2, view, viewGroup, view2, videoEnabledWebView7);
        acceptPaymentWebViewActivity.f52211g = eVar;
        eVar.a(new f(acceptPaymentWebViewActivity));
        VideoEnabledWebView videoEnabledWebView8 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView8 == null) {
            k.a("videoEnabledWebView");
        }
        if (videoEnabledWebView8 != null) {
            videoEnabledWebView8.setWebViewClient(aVar);
        }
        VideoEnabledWebView videoEnabledWebView9 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView9 == null) {
            k.a("videoEnabledWebView");
        }
        if (videoEnabledWebView9 != null) {
            videoEnabledWebView9.setWebChromeClient(acceptPaymentWebViewActivity.f52211g);
        }
        VideoEnabledWebView videoEnabledWebView10 = acceptPaymentWebViewActivity.f52208d;
        if (videoEnabledWebView10 == null) {
            k.a("videoEnabledWebView");
        }
        i iVar3 = acceptPaymentWebViewActivity.f52213i;
        if (iVar3 == null) {
            k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
        }
        String str = iVar3.f52229b;
        i iVar4 = acceptPaymentWebViewActivity.f52213i;
        if (iVar4 == null) {
            k.a(Constants.EASY_PAY_CONFIG_PREF_KEY);
        }
        videoEnabledWebView10.loadUrl(str, iVar4.f52230c);
        acceptPaymentWebViewActivity.setRequestedOrientation(1);
    }
}
