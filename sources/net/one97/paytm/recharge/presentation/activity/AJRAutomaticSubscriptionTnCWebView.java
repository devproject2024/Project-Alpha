package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.utility.b;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.automatic.R;

public final class AJRAutomaticSubscriptionTnCWebView extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f64694a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f64695b;

    public final void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_recharge_embed_web_view_layout);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            k.a();
        }
        supportActionBar.b(true);
        SpannableString spannableString = new SpannableString(getString(R.string.terms_and_conditions_title));
        spannableString.setSpan(new TypefaceSpan(getString(R.string.font_family_roboto_regular)), 0, spannableString.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        Resources system = Resources.getSystem();
        k.a((Object) system, "Resources.getSystem()");
        spannableString.setSpan(new AbsoluteSizeSpan((int) TypedValue.applyDimension(2, 19.0f, system.getDisplayMetrics())), 0, spannableString.length(), 33);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            k.a();
        }
        supportActionBar2.a((CharSequence) spannableString);
        View findViewById = findViewById(R.id.order_datails_webiew);
        if (findViewById != null) {
            this.f64694a = (WebView) findViewById;
            this.f64695b = findViewById(R.id.progressBar);
            WebView webView = this.f64694a;
            if (webView == null) {
                k.a();
            }
            webView.setWebViewClient(new a());
            WebView webView2 = this.f64694a;
            if (webView2 == null) {
                k.a();
            }
            WebSettings settings = webView2.getSettings();
            k.a((Object) settings, "mWebView!!.settings");
            settings.setBuiltInZoomControls(true);
            WebView webView3 = this.f64694a;
            if (webView3 == null) {
                k.a();
            }
            WebSettings settings2 = webView3.getSettings();
            k.a((Object) settings2, "mWebView!!.settings");
            settings2.setJavaScriptEnabled(true);
            WebView webView4 = this.f64694a;
            if (webView4 == null) {
                k.a();
            }
            WebSettings settings3 = webView4.getSettings();
            k.a((Object) settings3, "mWebView!!.settings");
            settings3.setDomStorageEnabled(true);
            WebView webView5 = this.f64694a;
            if (webView5 == null) {
                k.a();
            }
            WebSettings settings4 = webView5.getSettings();
            k.a((Object) settings4, "mWebView!!.settings");
            settings4.setTextZoom(100);
            WebView webView6 = this.f64694a;
            if (webView6 == null) {
                k.a();
            }
            WebSettings settings5 = webView6.getSettings();
            k.a((Object) settings5, "mWebView!!.settings");
            settings5.setCacheMode(-1);
            if (Build.VERSION.SDK_INT >= 21) {
                WebView webView7 = this.f64694a;
                if (webView7 == null) {
                    k.a();
                }
                WebSettings settings6 = webView7.getSettings();
                k.a((Object) settings6, "mWebView!!.settings");
                settings6.setMixedContentMode(0);
            }
            WebView webView8 = this.f64694a;
            if (webView8 == null) {
                k.a();
            }
            WebSettings settings7 = webView8.getSettings();
            k.a((Object) settings7, "mWebView!!.settings");
            settings7.setDomStorageEnabled(true);
            WebView webView9 = this.f64694a;
            if (webView9 == null) {
                k.a();
            }
            WebSettings settings8 = webView9.getSettings();
            k.a((Object) settings8, "mWebView!!.settings");
            settings8.setAllowUniversalAccessFromFileURLs(true);
            WebView webView10 = this.f64694a;
            if (webView10 == null) {
                k.a();
            }
            WebSettings settings9 = webView10.getSettings();
            k.a((Object) settings9, "mWebView!!.settings");
            settings9.setLoadWithOverviewMode(true);
            if (Build.VERSION.SDK_INT >= 17) {
                WebView webView11 = this.f64694a;
                if (webView11 == null) {
                    k.a();
                }
                WebSettings settings10 = webView11.getSettings();
                k.a((Object) settings10, "mWebView!!.settings");
                settings10.setMediaPlaybackRequiresUserGesture(false);
            }
            String stringExtra = getIntent().getStringExtra("url");
            WebView webView12 = this.f64694a;
            if (webView12 == null) {
                k.a();
            }
            webView12.loadUrl(stringExtra);
            return;
        }
        throw new u("null cannot be cast to non-null type android.webkit.WebView");
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final class a extends WebViewClient {
        public a() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            View a2 = AJRAutomaticSubscriptionTnCWebView.this.f64695b;
            if (a2 == null) {
                k.a();
            }
            a2.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            k.c(webView, "view");
            k.c(str, "url");
            View a2 = AJRAutomaticSubscriptionTnCWebView.this.f64695b;
            if (a2 == null) {
                k.a();
            }
            a2.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            k.c(webView, "view");
            k.c(str, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            k.c(str2, "failingUrl");
            Toast.makeText(webView.getContext(), AJRAutomaticSubscriptionTnCWebView.this.getString(R.string.msg_connection_problem), 1).show();
            View a2 = AJRAutomaticSubscriptionTnCWebView.this.f64695b;
            if (a2 == null) {
                k.a();
            }
            a2.setVisibility(8);
            AJRAutomaticSubscriptionTnCWebView.this.finish();
        }
    }

    public final void onBackPressed() {
        WebView webView = this.f64694a;
        if (webView != null) {
            if (webView == null) {
                k.a();
            }
            if (webView.canGoBack()) {
                WebView webView2 = this.f64694a;
                if (webView2 == null) {
                    k.a();
                }
                webView2.goBack();
                return;
            }
        }
        super.onBackPressed();
    }
}
