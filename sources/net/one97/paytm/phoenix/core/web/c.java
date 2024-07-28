package net.one97.paytm.phoenix.core.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.provider.PhoenixAppInfoProvider;
import net.one97.paytm.phoenix.provider.PhoenixProgressHandler;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.i;
import net.one97.paytm.phoenix.util.j;

public final class c extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    String f59417a;

    /* renamed from: b  reason: collision with root package name */
    private PhoenixProgressHandler f59418b;

    public c(String str, PhoenixProgressHandler phoenixProgressHandler) {
        k.c(str, "defaultErrorUrl");
        k.c(phoenixProgressHandler, "progressHandler");
        this.f59417a = str;
        this.f59418b = phoenixProgressHandler;
    }

    public final void onPageFinished(WebView webView, String str) {
        PhoenixProgressHandler phoenixProgressHandler;
        super.onPageFinished(webView, str);
        j jVar = j.f59646a;
        j.a("PhoenixWebViewClient", "onPageFinished: ".concat(String.valueOf(str)));
        if (!(webView == null || (phoenixProgressHandler = this.f59418b) == null)) {
            phoenixProgressHandler.onPageFinished$phoenix_debug();
        }
        Context context = webView != null ? webView.getContext() : null;
        if (context instanceof PhoenixActivity) {
            PhoenixActivity phoenixActivity = (PhoenixActivity) context;
            if (!phoenixActivity.j) {
                phoenixActivity.j = true;
                webView.postDelayed(new a(webView), 10);
            }
        }
        f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PhoenixAppInfoProvider.class.getName();
        k.a((Object) name, "PhoenixAppInfoProvider::class.java.name");
        PhoenixAppInfoProvider phoenixAppInfoProvider = (PhoenixAppInfoProvider) b2.a(name);
        if (phoenixAppInfoProvider != null) {
            phoenixAppInfoProvider.stopWebPageLoadStartToFinishTrace();
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f59419a;

        a(WebView webView) {
            this.f59419a = webView;
        }

        public final void run() {
            a.a(this.f59419a);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i2, SafeBrowsingResponse safeBrowsingResponse) {
        super.onSafeBrowsingHit(webView, webResourceRequest, i2, safeBrowsingResponse);
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        Integer.valueOf(i2);
        if (!a(webView) && webView != null) {
            webView.postDelayed(new C1149c(this, webView), 100);
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String str;
        String obj;
        if (webResourceRequest != null && webResourceRequest.isForMainFrame() && webResourceError != null) {
            Uri url = webResourceRequest.getUrl();
            String str2 = "";
            if (url == null || (str = url.toString()) == null) {
                str = str2;
            }
            k.a((Object) str, "request.url?.toString() ?: \"\"");
            CharSequence description = webResourceError.getDescription();
            if (!(description == null || (obj = description.toString()) == null)) {
                str2 = obj;
            }
            onReceivedError(webView, webResourceError.getErrorCode(), str2, str);
        }
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
        String name = PhoenixAppInfoProvider.class.getName();
        k.a((Object) name, "PhoenixAppInfoProvider::class.java.name");
        PhoenixAppInfoProvider phoenixAppInfoProvider = (PhoenixAppInfoProvider) b2.a(name);
        if (phoenixAppInfoProvider != null) {
            phoenixAppInfoProvider.stopPhoenixActivityToWebPageStartTrace(str);
        }
        if (phoenixAppInfoProvider != null) {
            phoenixAppInfoProvider.startWebPageLoadStartToFinishTrace(str);
        }
        j jVar = j.f59646a;
        j.a("PhoenixWebViewClient", "onPageStarted: ".concat(String.valueOf(str)));
        Context context = webView != null ? webView.getContext() : null;
        if (context instanceof PhoenixActivity) {
            ((PhoenixActivity) context).j = false;
        }
        if (webView != null) {
            this.f59418b.onPageStarted$phoenix_debug();
        }
    }

    public final void onScaleChanged(WebView webView, float f2, float f3) {
        super.onScaleChanged(webView, f2, f3);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        j jVar = j.f59646a;
        j.a("PhoenixWebViewClient", "shouldOverrideUrlLoading-URL: ".concat(String.valueOf(str)));
        return super.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r14.getUrl();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r13, android.webkit.WebResourceRequest r14) {
        /*
            r12 = this;
            r0 = 0
            if (r14 == 0) goto L_0x000e
            android.net.Uri r1 = r14.getUrl()
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.toString()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 == 0) goto L_0x00a0
            r14 = 0
            java.lang.String r2 = "tel:"
            boolean r14 = kotlin.m.p.b(r1, r2, r14)
            r2 = 1
            if (r14 == 0) goto L_0x0032
            android.content.Intent r14 = new android.content.Intent
            android.net.Uri r0 = android.net.Uri.parse(r1)
            java.lang.String r1 = "android.intent.action.DIAL"
            r14.<init>(r1, r0)
            if (r13 == 0) goto L_0x0031
            android.content.Context r13 = r13.getContext()
            if (r13 == 0) goto L_0x0031
            r13.startActivity(r14)
        L_0x0031:
            return r2
        L_0x0032:
            net.one97.paytm.phoenix.util.g r14 = net.one97.paytm.phoenix.util.g.f59641a
            java.lang.String r14 = net.one97.paytm.phoenix.util.g.a((java.lang.String) r1)
            if (r13 == 0) goto L_0x003f
            android.content.Context r3 = r13.getContext()
            goto L_0x0040
        L_0x003f:
            r3 = r0
        L_0x0040:
            boolean r4 = r3 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r4 == 0) goto L_0x0062
            r4 = r3
            net.one97.paytm.phoenix.ui.PhoenixActivity r4 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r4
            java.lang.String r4 = r4.v
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.d.f r5 = (kotlin.d.f) r5
            kotlinx.coroutines.CoroutineScope r6 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r5)
            r7 = 0
            r8 = 0
            net.one97.paytm.phoenix.core.web.c$b r5 = new net.one97.paytm.phoenix.core.web.c$b
            r5.<init>(r14, r3, r4, r0)
            r9 = r5
            kotlin.g.a.m r9 = (kotlin.g.a.m) r9
            r10 = 3
            r11 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
        L_0x0062:
            r14 = r1
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r3 = "paytmmp://"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r14 = kotlin.m.p.a((java.lang.CharSequence) r14, (java.lang.CharSequence) r3, false)
            if (r14 == 0) goto L_0x0094
            net.one97.paytm.phoenix.util.j r14 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r14 = r1.toString()
            java.lang.String r3 = "shouldOverrideUrlLoading:WebResourceRequest"
            net.one97.paytm.phoenix.util.j.b(r3, r14)
            if (r13 == 0) goto L_0x0080
            android.content.Context r0 = r13.getContext()
        L_0x0080:
            android.content.Intent r13 = new android.content.Intent
            java.lang.String r14 = "android.intent.action.VIEW"
            r13.<init>(r14)
            android.net.Uri r14 = android.net.Uri.parse(r1)
            r13.setData(r14)
            if (r0 == 0) goto L_0x0093
            r0.startActivity(r13)
        L_0x0093:
            return r2
        L_0x0094:
            boolean r14 = a(r13, r1)
            if (r14 == 0) goto L_0x009f
            boolean r13 = super.shouldOverrideUrlLoading(r13, r1)
            return r13
        L_0x009f:
            return r2
        L_0x00a0:
            if (r14 == 0) goto L_0x00ac
            android.net.Uri r14 = r14.getUrl()
            if (r14 == 0) goto L_0x00ac
            java.lang.String r0 = r14.toString()
        L_0x00ac:
            boolean r13 = r12.shouldOverrideUrlLoading((android.webkit.WebView) r13, (java.lang.String) r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.core.web.c.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.webkit.WebView r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x000a
            android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x0008 }
            goto L_0x000b
        L_0x0008:
            r4 = move-exception
            goto L_0x0065
        L_0x000a:
            r4 = 0
        L_0x000b:
            boolean r1 = r4 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity     // Catch:{ Exception -> 0x0008 }
            if (r1 == 0) goto L_0x0068
            net.one97.paytm.phoenix.util.g r1 = net.one97.paytm.phoenix.util.g.f59641a     // Catch:{ Exception -> 0x0008 }
            if (r5 != 0) goto L_0x0015
            java.lang.String r5 = ""
        L_0x0015:
            java.lang.String r5 = net.one97.paytm.phoenix.util.g.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0008 }
            net.one97.paytm.phoenix.core.c r1 = net.one97.paytm.phoenix.core.c.f59399a     // Catch:{ Exception -> 0x0008 }
            net.one97.paytm.phoenix.api.f r1 = r1.b()     // Catch:{ Exception -> 0x0008 }
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider> r2 = net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider.class
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0008 }
            java.lang.String r3 = "PhoenixAppPermissionProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0008 }
            java.lang.Object r1 = r1.a(r2)     // Catch:{ Exception -> 0x0008 }
            net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider r1 = (net.one97.paytm.phoenix.provider.PhoenixAppPermissionProvider) r1     // Catch:{ Exception -> 0x0008 }
            if (r1 == 0) goto L_0x0068
            r2 = r4
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x0008 }
            boolean r1 = r1.doesAppHasPermissionToOpenThisDomain(r5, r2)     // Catch:{ Exception -> 0x0008 }
            r2 = 1
            if (r1 != r2) goto L_0x0068
            if (r5 == 0) goto L_0x0068
            net.one97.paytm.phoenix.ui.PhoenixActivity r4 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r4     // Catch:{ Exception -> 0x0008 }
            boolean r4 = r4.z     // Catch:{ Exception -> 0x0008 }
            if (r4 == 0) goto L_0x0064
            if (r5 == 0) goto L_0x005c
            java.lang.String r4 = r5.toLowerCase()     // Catch:{ Exception -> 0x0008 }
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0008 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0008 }
            java.lang.String r5 = "paytm"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0008 }
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r0)     // Catch:{ Exception -> 0x0008 }
            if (r4 == 0) goto L_0x0064
            return r0
        L_0x005c:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0008 }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0008 }
            throw r4     // Catch:{ Exception -> 0x0008 }
        L_0x0064:
            return r2
        L_0x0065:
            r4.printStackTrace()
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.core.web.c.a(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
    }

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    /* renamed from: net.one97.paytm.phoenix.core.web.c$c  reason: collision with other inner class name */
    static final class C1149c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f59420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebView f59421b;

        C1149c(c cVar, WebView webView) {
            this.f59420a = cVar;
            this.f59421b = webView;
        }

        public final void run() {
            this.f59421b.loadUrl(i.a(this.f59420a.f59417a));
        }
    }

    public final boolean a(WebView webView) {
        return k.a((Object) webView != null ? webView.getUrl() : null, (Object) i.a(this.f59417a));
    }

    @kotlin.d.b.a.f(b = "PhoenixWebViewClient.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.core.web.PhoenixWebViewClient$shouldOverrideUrlLoading$1$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $appName;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $domain;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Context context, String str2, d dVar) {
            super(2, dVar);
            this.$domain = str;
            this.$context = context;
            this.$appName = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.$domain, this.$context, this.$appName, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                new net.one97.paytm.phoenix.util.c();
                net.one97.paytm.phoenix.util.c.a(this.$domain, ((PhoenixActivity) this.$context).f59606d, this.$context, this.$appName);
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
