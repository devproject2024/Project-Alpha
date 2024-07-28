package net.one97.paytm.bankCommon.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytm.utility.s;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.f;

public class PBWebViewActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f16194a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16195b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16196c = false;

    /* renamed from: d  reason: collision with root package name */
    private ActionBar f16197d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16198e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16199f = false;

    /* renamed from: g  reason: collision with root package name */
    private String f16200g;

    /* renamed from: h  reason: collision with root package name */
    private String f16201h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16202i = false;
    private boolean j;
    private WebViewClient k = new WebViewClient() {
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ((ProgressBar) PBWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (b.v(PBWebViewActivity.this, str) || !str.startsWith("market://")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            PBWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            ((ProgressBar) PBWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            super.onPageFinished(webView, str);
        }
    };

    public void attachBaseContext(Context context) {
        if (f.d()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(f.a().getBaseContext(context));
        a.a((Context) this);
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, PBWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_web_view);
        this.f16194a = (WebView) findViewById(R.id.payment_webview);
        this.f16194a.setWebViewClient(this.k);
        this.f16194a.getSettings().setBuiltInZoomControls(true);
        this.f16194a.getSettings().setJavaScriptEnabled(true);
        this.f16194a.getSettings().setDomStorageEnabled(true);
        this.f16194a.requestFocus(130);
        this.f16201h = getIntent().getStringExtra("url");
        this.j = getIntent().getBooleanExtra("finish_activity", false);
        if (!TextUtils.isEmpty(this.f16201h)) {
            this.f16194a.loadUrl(this.f16201h);
        }
        this.f16197d = getSupportActionBar();
        this.f16197d.b(R.drawable.pb_no_home_icon);
        this.f16197d.c(R.drawable.pb_no_home_icon);
        this.f16200g = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.f16200g)) {
            this.f16197d.a((CharSequence) this.f16200g);
        }
        this.f16195b = true;
        this.f16197d.b(true);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f16199f = true;
        b.u();
        if (this.f16196c) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPressed();
        return true;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56 && !s.a(iArr) && s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        s.b((Context) PBWebViewActivity.this);
                        PBWebViewActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                builder.show();
            } catch (Exception e2) {
                if (b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onBackPressed() {
        Bundle bundle = new Bundle();
        bundle.putAll(getIntent().getExtras());
        setResult(0, new Intent().putExtras(bundle));
        if (this.f16194a.canGoBack()) {
            this.f16194a.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
