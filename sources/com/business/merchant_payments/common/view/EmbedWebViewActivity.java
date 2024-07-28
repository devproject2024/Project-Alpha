package com.business.merchant_payments.common.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.databinding.f;
import com.business.common_module.utilities.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.GTMScreenViewsConstants;
import com.business.merchant_payments.common.viewmodel.EmbedWebViewViewModel;
import com.business.merchant_payments.databinding.MpEmbedWebViewActivityBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import java.util.HashMap;
import java.util.Map;

public class EmbedWebViewActivity extends BaseActivity {
    public MpEmbedWebViewActivityBinding embedWebViewActivityBinding;
    public EmbedWebViewViewModel embedWebViewViewModel;
    public boolean isTokenRequired;
    public String pageTitle;
    public String url;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromIntent();
        initDataBinding();
        initToolBar();
        setWebViewClient();
    }

    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            if (getResources().getString(R.string.mp_legal_privacy_policy).equals(getIntent().getStringExtra("intent_extra_page_title"))) {
                GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                singleInstance.pushScreenEvent(GTMScreenViewsConstants.GTMString + "/legal_privacy");
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332 || !isBackHandledForDeepLink()) {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.url = intent.getStringExtra("intent_extra_url");
            this.pageTitle = intent.getStringExtra("intent_extra_page_title");
            this.isTokenRequired = intent.getBooleanExtra("is_token_required_in_webview", false);
        }
    }

    private void initDataBinding() {
        this.embedWebViewActivityBinding = (MpEmbedWebViewActivityBinding) f.a(this, R.layout.mp_embed_web_view_activity);
        EmbedWebViewViewModel embedWebViewViewModel2 = new EmbedWebViewViewModel(this.url);
        this.embedWebViewViewModel = embedWebViewViewModel2;
        this.embedWebViewActivityBinding.setEmbedWebViewViewModel(embedWebViewViewModel2);
    }

    private void initToolBar() {
        MpEmbedWebViewActivityBinding mpEmbedWebViewActivityBinding = this.embedWebViewActivityBinding;
        if (mpEmbedWebViewActivityBinding != null) {
            setSupportActionBar(mpEmbedWebViewActivityBinding.toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().b(true);
                this.embedWebViewActivityBinding.tvTitle.setText(this.pageTitle);
            }
        }
    }

    private void setWebViewClient() {
        this.embedWebViewActivityBinding.webview.setWebViewClient(new CustomWebViewClient());
        this.embedWebViewActivityBinding.webview.setWebChromeClient(new CustomWebChromeClient());
        this.embedWebViewActivityBinding.webview.getSettings().setJavaScriptEnabled(true);
        this.embedWebViewActivityBinding.webview.getSettings().setDomStorageEnabled(true);
        if (this.isTokenRequired) {
            this.embedWebViewActivityBinding.webview.loadUrl(this.url, getHeaders(this));
            return;
        }
        this.embedWebViewActivityBinding.webview.loadUrl(this.url);
    }

    public static Map<String, String> getHeaders(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("x-auth-ump", AppConstants.KeyValues.HEADER_CLIENT_ID_VALUE);
        hashMap.put("x-user-token", APSharedPreferences.getInstance().getUserToken());
        hashMap.put("x-user-mid", APSharedPreferences.getInstance().getMerchantMid());
        return hashMap;
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (this.embedWebViewActivityBinding.webview.canGoBack()) {
            this.embedWebViewActivityBinding.webview.goBack();
        } else if (!isBackHandledForDeepLink()) {
            super.onBackPressed();
        }
    }

    private boolean isBackHandledForDeepLink() {
        if (getIntent() == null || !getIntent().getBooleanExtra("is_from_deepLink", false)) {
            return false;
        }
        finish();
        return true;
    }

    public class CustomWebViewClient extends WebViewClient {
        public CustomWebViewClient() {
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            EmbedWebViewActivity.this.embedWebViewViewModel.setProgressBarVisibility(8);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            EmbedWebViewActivity.this.embedWebViewViewModel.setProgressBarVisibility(8);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            EmbedWebViewActivity.this.embedWebViewViewModel.setProgressBarVisibility(0);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url = webResourceRequest.getUrl();
            String uri = url.toString();
            if (!TextUtils.isEmpty(uri)) {
                if (url.toString().toLowerCase().startsWith("tel:")) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(url);
                    EmbedWebViewActivity.this.startActivity(intent);
                    return true;
                } else if (c.a(uri)) {
                    PaymentsConfig.getInstance().getDeepLinkUtils().a(EmbedWebViewActivity.this, uri);
                    return true;
                } else if (c.b(uri) || c.d(uri)) {
                    c.a(uri, (Context) EmbedWebViewActivity.this);
                    return true;
                } else if (c.c(uri)) {
                    c.a((Context) EmbedWebViewActivity.this, uri);
                    return true;
                } else if (url.toString().toLowerCase().startsWith("mailto:")) {
                    c.a((Context) EmbedWebViewActivity.this, new String[]{url.toString().substring(7)});
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.toLowerCase().startsWith("tel:")) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(EmbedWebViewActivity.this.url));
                EmbedWebViewActivity.this.startActivity(intent);
                return true;
            } else if (c.a(str)) {
                PaymentsConfig.getInstance().getDeepLinkUtils().a(EmbedWebViewActivity.this, str);
                return true;
            } else if (c.b(str) || c.d(str)) {
                c.a(str, (Context) EmbedWebViewActivity.this);
                return true;
            } else if (!c.c(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                c.a((Context) EmbedWebViewActivity.this, str);
                return true;
            }
        }
    }

    public class CustomWebChromeClient extends WebChromeClient {
        public CustomWebChromeClient() {
        }

        public Bitmap getDefaultVideoPoster() {
            if (super.getDefaultVideoPoster() == null) {
                return BitmapFactory.decodeResource(PaymentsConfig.getInstance().getAppContext().getResources(), R.drawable.ic_launcher);
            }
            return super.getDefaultVideoPoster();
        }
    }
}
