package net.one97.paytm.nativesdk;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;

public final class WebViewActivity extends PaytmActivity {
    public static final Companion Companion = new Companion((g) null);
    public static final String ENABLE_WEB_SETTINGS = "enable_web_settings";
    public static final String SHOW_CROSS_BUTTON = "show_cross_button";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String contentDisposition;
    private boolean enableWebSettings = true;
    /* access modifiers changed from: private */
    public String mimetype;
    private boolean showCrossButton;
    /* access modifiers changed from: private */
    public String url;
    public String webUrl;
    private final WebViewActivity$webViewClient$1 webViewClient = new WebViewActivity$webViewClient$1(this);

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final String getWebUrl() {
        String str = this.webUrl;
        if (str == null) {
            k.a("webUrl");
        }
        return str;
    }

    public final void setWebUrl(String str) {
        k.c(str, "<set-?>");
        this.webUrl = str;
    }

    public final boolean getShowCrossButton() {
        return this.showCrossButton;
    }

    public final void setShowCrossButton(boolean z) {
        this.showCrossButton = z;
    }

    public final boolean getEnableWebSettings() {
        return this.enableWebSettings;
    }

    public final void setEnableWebSettings(boolean z) {
        this.enableWebSettings = z;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_native_web_view);
        String stringExtra = getIntent().getStringExtra(Constants.WEB_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.webUrl = stringExtra;
        this.showCrossButton = getIntent().getBooleanExtra("show_cross_button", true);
        this.enableWebSettings = getIntent().getBooleanExtra(ENABLE_WEB_SETTINGS, true);
        initWebView();
    }

    private final void initWebView() {
        if (this.enableWebSettings) {
            WebView webView = (WebView) _$_findCachedViewById(R.id.web_view);
            k.a((Object) webView, "web_view");
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
        }
        WebView webView2 = (WebView) _$_findCachedViewById(R.id.web_view);
        String str = this.webUrl;
        if (str == null) {
            k.a("webUrl");
        }
        webView2.loadUrl(str);
        webView2.setWebViewClient(this.webViewClient);
        ((WebView) _$_findCachedViewById(R.id.web_view)).setDownloadListener(new WebViewActivity$initWebView$3(this));
        if (this.showCrossButton) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.cross_button);
            ExtensionsKt.visible(appCompatImageView);
            appCompatImageView.setOnClickListener(new WebViewActivity$initWebView$$inlined$apply$lambda$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void download(String str, String str2, String str3) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str2, str3));
        Object systemService = getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
        if (systemService != null) {
            ((DownloadManager) systemService).enqueue(request);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.DownloadManager");
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        String str;
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if ((!(iArr.length == 0)) && iArr[0] == 0 && (str = this.url) != null && this.contentDisposition != null && this.mimetype != null) {
                if (str == null) {
                    k.a();
                }
                String str2 = this.contentDisposition;
                if (str2 == null) {
                    k.a();
                }
                String str3 = this.mimetype;
                if (str3 == null) {
                    k.a();
                }
                download(str, str2, str3);
            }
        }
    }
}
