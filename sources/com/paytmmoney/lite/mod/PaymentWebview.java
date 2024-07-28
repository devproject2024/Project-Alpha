package com.paytmmoney.lite.mod;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.play.core.splitcompat.a;
import com.paytmmoney.lite.mod.util.MoneyUtils;
import com.paytmmoney.lite.mod.widget.WarningBottomSheet;
import easypay.manager.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class PaymentWebview extends AppCompatActivity implements WarningBottomSheet.Listener {
    private HashMap _$_findViewCache;
    private String liteVersion = "";
    private String paymentGateway = "";
    /* access modifiers changed from: private */
    public String paymentSuccessUrl = "";
    private String paymentUrl = "";
    /* access modifiers changed from: private */
    public ProgressBar progress_bar;
    private Toolbar toolbar;
    private String transactionId = "";

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

    public static final /* synthetic */ ProgressBar access$getProgress_bar$p(PaymentWebview paymentWebview) {
        ProgressBar progressBar = paymentWebview.progress_bar;
        if (progressBar == null) {
            k.a("progress_bar");
        }
        return progressBar;
    }

    public final void okClick(Integer num) {
        int i2 = R.id.yes_btn;
        if (num != null && num.intValue() == i2) {
            handleRedirectLogic("", false);
            super.onBackPressed();
        }
    }

    static final class PMGateWayType {
        public static final String GATEWAY_BILLDESK = "billdesk";
        public static final String GATEWAY_PAYTM = "paytm";
        public static final PMGateWayType INSTANCE = new PMGateWayType();

        private PMGateWayType() {
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pm_payment_webivew);
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        View findViewById = findViewById(R.id.progress_bar);
        k.a((Object) findViewById, "findViewById(R.id.progress_bar)");
        this.progress_bar = (ProgressBar) findViewById;
        if (extras != null) {
            if (extras.get("payment_url") != null) {
                Object obj = extras.get("payment_url");
                if (obj != null) {
                    this.paymentUrl = (String) obj;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (extras.get(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID) != null) {
                Object obj2 = extras.get(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
                if (obj2 != null) {
                    this.transactionId = (String) obj2;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (extras.get(SDKConstants.GA_PAYMENT_GATEWAY) != null) {
                Object obj3 = extras.get(SDKConstants.GA_PAYMENT_GATEWAY);
                if (obj3 != null) {
                    this.paymentGateway = (String) obj3;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (extras.get("paymentSuccessUrl") != null) {
                Object obj4 = extras.get("paymentSuccessUrl");
                if (obj4 != null) {
                    this.paymentSuccessUrl = (String) obj4;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (extras.get("liteVersion") != null) {
                Object obj5 = extras.get("liteVersion");
                if (obj5 != null) {
                    this.liteVersion = (String) obj5;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            initWebViewSetup(this.paymentUrl);
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            setSupportActionBar(toolbar2);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.a((CharSequence) "Make Payment");
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.b(true);
            }
            getSupportActionBar();
            invalidateOptionsMenu();
        }
    }

    private final Map<String, String> getAuthHeaders(Context context) {
        Map<String, String> hashMap = new HashMap<>();
        String requestId = MoneyUtils.getRequestId();
        k.a((Object) requestId, "MoneyUtils.getRequestId()");
        hashMap.put("x-request-id", requestId);
        String authValue = PaytmMoneyManager.INSTANCE.getAuthValue();
        if (authValue != null) {
            hashMap.put("Authorization", authValue);
        }
        hashMap.put("x-client-utc-offset", String.valueOf(MoneyUtils.getUtcOffset()));
        String paytmLiteUserAgent = MoneyUtils.getPaytmLiteUserAgent(context, this.liteVersion);
        k.a((Object) paytmLiteUserAgent, "getPaytmLiteUserAgent(context,liteVersion)");
        hashMap.put("x-user-agent", paytmLiteUserAgent);
        String ssoToken = PaytmMoneyManager.INSTANCE.getSsoToken(context);
        if (ssoToken != null) {
            hashMap.put("x-sso-token", ssoToken);
        }
        hashMap.put("Accept-Encoding", "identity");
        return hashMap;
    }

    private final void initWebViewSetup(String str) {
        WebView webView;
        WebSettings settings;
        WebSettings settings2;
        new HashMap().put("Cookie", "");
        WebView webView2 = (WebView) _$_findCachedViewById(R.id.payment_web_view);
        if (!(webView2 == null || (settings2 = webView2.getSettings()) == null)) {
            settings2.setJavaScriptEnabled(true);
        }
        if (!(Build.VERSION.SDK_INT > 18 || (webView = (WebView) _$_findCachedViewById(R.id.payment_web_view)) == null || (settings = webView.getSettings()) == null)) {
            settings.setSavePassword(false);
        }
        WebView webView3 = (WebView) _$_findCachedViewById(R.id.payment_web_view);
        if (webView3 != null) {
            webView3.setWebViewClient(new PaymentWebview$initWebViewSetup$1(this));
        }
        WebView webView4 = (WebView) _$_findCachedViewById(R.id.payment_web_view);
        if (webView4 != null) {
            webView4.setWebChromeClient(new WebChromeClient());
        }
        ((WebView) _$_findCachedViewById(R.id.payment_web_view)).setOnKeyListener(new PaymentWebview$initWebViewSetup$2());
        if (p.a(this.paymentGateway, "paytm", true)) {
            WebView webView5 = (WebView) _$_findCachedViewById(R.id.payment_web_view);
            if (webView5 != null) {
                webView5.loadUrl(str, getAuthHeaders(this));
                return;
            }
            return;
        }
        ((WebView) _$_findCachedViewById(R.id.payment_web_view)).loadUrl(str);
    }

    /* access modifiers changed from: private */
    public final void handleRedirectLogic(String str, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isPaymentDone", z);
        jSONObject.put("payment_url", str);
        jSONObject.put(Constants.RISK_TRANSACTION_ID, this.transactionId);
        intent.putExtra("payload", jSONObject.toString());
        setResult(-1, intent);
        finish();
    }

    public final void onBackPressed() {
        WarningBottomSheet newInstance = WarningBottomSheet.Companion.newInstance();
        newInstance.show(getSupportFragmentManager(), newInstance.getTag());
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
