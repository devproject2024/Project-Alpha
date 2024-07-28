package net.one97.paytm.feed.ui.feed;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.d;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.ui.base.FeedNoBindingBaseActivity;

public final class FeedWebViewActivity extends FeedNoBindingBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34900a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private WebView f34901b;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f34902c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f34903d;

    /* renamed from: e  reason: collision with root package name */
    private String f34904e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f34905f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f34906g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f34907h = "";

    /* renamed from: i  reason: collision with root package name */
    private FeedItem f34908i;

    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r3 = r6.f34903d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0121, code lost:
        if (r3 != null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0123, code lost:
        r3.setTextColor(android.graphics.Color.parseColor("#000000"));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x011f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            int r7 = net.one97.paytm.feed.R.layout.feed_webview_activity
            r6.setContentView((int) r7)
            int r7 = net.one97.paytm.feed.R.id.webView
            android.view.View r7 = r6.findViewById(r7)
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            r6.f34901b = r7
            int r7 = net.one97.paytm.feed.R.id.toolbar
            android.view.View r7 = r6.findViewById(r7)
            androidx.appcompat.widget.Toolbar r7 = (androidx.appcompat.widget.Toolbar) r7
            r6.f34902c = r7
            int r7 = net.one97.paytm.feed.R.id.title
            android.view.View r7 = r6.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f34903d = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "url"
            java.lang.String r7 = r7.getStringExtra(r0)
            java.lang.String r0 = "intent.getStringExtra(URL)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.f34904e = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "title"
            java.lang.String r7 = r7.getStringExtra(r0)
            java.lang.String r0 = "intent.getStringExtra(TITLE)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.f34905f = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "toolbar_color"
            java.lang.String r7 = r7.getStringExtra(r0)
            r6.f34906g = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "statusbar_color"
            java.lang.String r7 = r7.getStringExtra(r0)
            r6.f34907h = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "feedItem"
            android.os.Parcelable r7 = r7.getParcelableExtra(r0)
            net.one97.paytm.feed.repository.models.FeedItem r7 = (net.one97.paytm.feed.repository.models.FeedItem) r7
            r6.f34908i = r7
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "fullscreen"
            boolean r7 = r7.hasExtra(r0)
            r1 = 21
            if (r7 != 0) goto L_0x00ad
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r1) goto L_0x00ad
            java.lang.String r7 = r6.f34907h
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00ad
            java.lang.String r7 = r6.f34907h
            android.view.Window r2 = r6.getWindow()
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r2.clearFlags(r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2.addFlags(r3)
            java.lang.String r3 = "window"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception | IllegalArgumentException -> 0x00ac }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ Exception | IllegalArgumentException -> 0x00ac }
            r2.setStatusBarColor(r7)     // Catch:{ Exception | IllegalArgumentException -> 0x00ac }
            goto L_0x00ad
        L_0x00ac:
        L_0x00ad:
            android.content.Intent r7 = r6.getIntent()
            boolean r7 = r7.hasExtra(r0)
            r0 = 0
            r2 = 1
            if (r7 != 0) goto L_0x013d
            java.lang.String r7 = r6.f34905f
            androidx.appcompat.widget.Toolbar r3 = r6.f34902c
            if (r3 == 0) goto L_0x00c5
            r6.setSupportActionBar(r3)
            r3.setContentInsetStartWithNavigation(r0)
        L_0x00c5:
            androidx.appcompat.app.ActionBar r3 = r6.getSupportActionBar()
            if (r3 == 0) goto L_0x00d4
            r3.b((boolean) r2)
            r3.a((boolean) r2)
            r3.c((boolean) r0)
        L_0x00d4:
            androidx.appcompat.widget.Toolbar r3 = r6.f34902c
            if (r3 == 0) goto L_0x00e2
            net.one97.paytm.feed.ui.feed.FeedWebViewActivity$c r4 = new net.one97.paytm.feed.ui.feed.FeedWebViewActivity$c
            r4.<init>(r6)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setNavigationOnClickListener(r4)
        L_0x00e2:
            java.lang.String r3 = r6.f34906g     // Catch:{ Exception -> 0x012d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x012d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x012d }
            if (r3 != 0) goto L_0x012e
            androidx.appcompat.widget.Toolbar r3 = r6.f34902c     // Catch:{ Exception -> 0x012d }
            if (r3 == 0) goto L_0x00f9
            java.lang.String r4 = r6.f34906g     // Catch:{ Exception -> 0x012d }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x012d }
            r3.setBackgroundColor(r4)     // Catch:{ Exception -> 0x012d }
        L_0x00f9:
            android.widget.TextView r3 = r6.f34903d     // Catch:{ Exception -> 0x012d }
            if (r3 == 0) goto L_0x0106
            java.lang.String r4 = "#ffffff"
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x012d }
            r3.setTextColor(r4)     // Catch:{ Exception -> 0x012d }
        L_0x0106:
            androidx.appcompat.widget.Toolbar r3 = r6.f34902c     // Catch:{ Exception -> 0x011f }
            if (r3 == 0) goto L_0x012e
            android.graphics.drawable.Drawable r3 = r3.getNavigationIcon()     // Catch:{ Exception -> 0x011f }
            if (r3 == 0) goto L_0x012e
            r4 = r6
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ Exception -> 0x011f }
            int r5 = net.one97.paytm.feed.R.color.feed_white     // Catch:{ Exception -> 0x011f }
            int r4 = androidx.core.content.b.c(r4, r5)     // Catch:{ Exception -> 0x011f }
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch:{ Exception -> 0x011f }
            r3.setColorFilter(r4, r5)     // Catch:{ Exception -> 0x011f }
            goto L_0x012e
        L_0x011f:
            android.widget.TextView r3 = r6.f34903d     // Catch:{ Exception -> 0x012d }
            if (r3 == 0) goto L_0x012e
            java.lang.String r4 = "#000000"
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x012d }
            r3.setTextColor(r4)     // Catch:{ Exception -> 0x012d }
            goto L_0x012e
        L_0x012d:
        L_0x012e:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L_0x013d
            android.widget.TextView r3 = r6.f34903d
            if (r3 == 0) goto L_0x013d
            r3.setText(r7)
        L_0x013d:
            java.lang.String r7 = r6.f34904e
            android.webkit.WebView r3 = r6.f34901b
            if (r3 == 0) goto L_0x016b
            android.webkit.WebSettings r4 = r3.getSettings()
            java.lang.String r5 = "settings"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r4.setJavaScriptEnabled(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x015e
            android.webkit.WebSettings r1 = r3.getSettings()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setMixedContentMode(r0)
        L_0x015e:
            net.one97.paytm.feed.ui.feed.FeedWebViewActivity$b r0 = new net.one97.paytm.feed.ui.feed.FeedWebViewActivity$b
            r0.<init>()
            android.webkit.WebViewClient r0 = (android.webkit.WebViewClient) r0
            r3.setWebViewClient(r0)
            r3.loadUrl(r7)
        L_0x016b:
            net.one97.paytm.feed.events.a r7 = net.one97.paytm.feed.events.a.f34284a
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.feed.events.a.a((long) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.FeedWebViewActivity.onCreate(android.os.Bundle):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedWebViewActivity f34910a;

        c(FeedWebViewActivity feedWebViewActivity) {
            this.f34910a = feedWebViewActivity;
        }

        public final void onClick(View view) {
            this.f34910a.onBackPressed();
        }
    }

    final class b extends WebViewClient {
        public b() {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            k.c(webView, "view");
            k.c(str, "url");
            webView.loadUrl(str);
            return true;
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            k.c(webView, "view");
            k.c(sslErrorHandler, "handler");
            k.c(sslError, "error");
            sslErrorHandler.proceed();
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str, String str2, String str3, String str4, FeedItem feedItem) {
            k.c(context, "context");
            k.c(str2, "url");
            k.c(str3, "tColor");
            k.c(str4, "sColor");
            try {
                net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
                d.a aVar2 = new d.a(net.one97.paytm.feed.a.a.a());
                aVar2.b();
                aVar2.a(Color.parseColor("#2196F3"));
                aVar2.a(context.getResources().getString(R.string.feed_powered_by_paytm), PendingIntent.getBroadcast(context, 0, new Intent(), 134217728));
                d c2 = aVar2.c();
                k.a((Object) c2, "builder.build()");
                c2.f1901a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
                c2.f1901a.putExtra(" org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
                c2.f1901a.setPackage("com.android.chrome");
                c2.a(context, Uri.parse(str2));
                if (feedItem != null) {
                    net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.b(true);
                    net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
                    net.one97.paytm.feed.events.a.a(System.currentTimeMillis());
                    net.one97.paytm.feed.events.a aVar4 = net.one97.paytm.feed.events.a.f34284a;
                    net.one97.paytm.feed.events.a.a(feedItem);
                }
            } catch (ActivityNotFoundException unused) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(false);
                Intent intent = new Intent(context, FeedWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("feedItem", feedItem);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("title", str);
                }
                intent.putExtra("toolbar_color", str3);
                intent.putExtra("statusbar_color", str4);
                context.startActivity(intent);
            }
        }

        public static void a(Context context, String str, String str2, FeedItem feedItem) {
            k.c(context, "context");
            k.c(str, "title");
            k.c(str2, "url");
            try {
                net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
                d.a aVar2 = new d.a(net.one97.paytm.feed.a.a.a());
                aVar2.b();
                aVar2.a(context.getResources().getString(R.string.feed_powered_by_paytm), PendingIntent.getBroadcast(context, 0, new Intent(), 134217728));
                aVar2.a(Color.parseColor("#032B73"));
                d c2 = aVar2.c();
                k.a((Object) c2, "builder.build()");
                c2.f1901a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
                c2.f1901a.putExtra(" org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
                c2.f1901a.setPackage("com.android.chrome");
                c2.a(context, Uri.parse(str2));
                if (feedItem != null) {
                    net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.b(true);
                    net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
                    net.one97.paytm.feed.events.a.a(System.currentTimeMillis());
                    net.one97.paytm.feed.events.a aVar4 = net.one97.paytm.feed.events.a.f34284a;
                    net.one97.paytm.feed.events.a.a(feedItem);
                }
            } catch (ActivityNotFoundException unused) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(false);
                Intent intent = new Intent(context, FeedWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("feedItem", feedItem);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("title", str);
                }
                context.startActivity(intent);
            }
        }

        public static void a(Context context, String str, String str2) {
            k.c(context, "context");
            k.c(str, "title");
            k.c(str2, "url");
            try {
                net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
                d.a aVar2 = new d.a(net.one97.paytm.feed.a.a.a());
                aVar2.b();
                aVar2.a(context.getResources().getString(R.string.feed_powered_by_paytm), PendingIntent.getBroadcast(context, 0, new Intent(), 134217728));
                aVar2.a(Color.parseColor("#032B73"));
                d c2 = aVar2.c();
                k.a((Object) c2, "builder.build()");
                c2.f1901a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
                c2.f1901a.putExtra(" org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
                c2.f1901a.setPackage("com.android.chrome");
                c2.a(context, Uri.parse(str2));
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(true);
                net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(System.currentTimeMillis());
            } catch (ActivityNotFoundException unused) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(false);
                Intent intent = new Intent(context, FeedWebViewActivity.class);
                intent.putExtra("url", str2);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("title", str);
                }
                context.startActivity(intent);
            }
        }

        public static void a(Context context, String str, String str2, String str3, String str4) {
            k.c(context, "context");
            k.c(str2, "url");
            k.c(str3, "tColor");
            k.c(str4, "sColor");
            try {
                net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
                d.a aVar2 = new d.a(net.one97.paytm.feed.a.a.a());
                aVar2.b();
                aVar2.a(Color.parseColor("#2196F3"));
                aVar2.a(context.getResources().getString(R.string.feed_powered_by_paytm), PendingIntent.getBroadcast(context, 0, new Intent(), 134217728));
                d c2 = aVar2.c();
                k.a((Object) c2, "builder.build()");
                c2.f1901a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
                c2.f1901a.putExtra(" org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
                c2.f1901a.setPackage("com.android.chrome");
                c2.a(context, Uri.parse(str2));
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(true);
                net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(System.currentTimeMillis());
            } catch (ActivityNotFoundException unused) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.b(false);
                Intent intent = new Intent(context, FeedWebViewActivity.class);
                intent.putExtra("url", str2);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("title", str);
                }
                intent.putExtra("toolbar_color", str3);
                intent.putExtra("statusbar_color", str4);
                context.startActivity(intent);
            }
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
        net.one97.paytm.feed.events.a.b(System.currentTimeMillis());
        if (this.f34908i != null) {
            net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
            FeedItem feedItem = this.f34908i;
            if (feedItem == null) {
                k.a();
            }
            net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(feedItem, net.one97.paytm.feed.events.a.e());
        }
    }
}
