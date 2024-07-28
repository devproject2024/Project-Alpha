package com.paytmmall.artifact.common.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.entity.CJREMIModel;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.common.entity.CJRItem;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;

public class AJRWebViewActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    String f15637a = "AJRWebViewActivity";

    /* renamed from: b  reason: collision with root package name */
    protected WebView f15638b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f15639c = false;

    /* renamed from: d  reason: collision with root package name */
    protected HashMap<String, String> f15640d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    protected boolean f15641e;

    /* renamed from: f  reason: collision with root package name */
    protected ValueCallback<Uri[]> f15642f;

    /* renamed from: g  reason: collision with root package name */
    protected Map<String, String> f15643g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    protected String f15644h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f15645i;
    protected String j;
    private boolean k = false;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public String m;
    private boolean n = false;
    private String o;
    private Menu p;
    private boolean q = false;
    /* access modifiers changed from: private */
    public boolean r;
    private WebViewClient s = new WebViewClient() {
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            if (str == null || !str.toLowerCase().contains("http://cta")) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(AJRWebViewActivity.this.l) && AJRWebViewActivity.this.l.equalsIgnoreCase("Order_summary") && !TextUtils.isEmpty(AJRWebViewActivity.this.m)) {
                    if (str.contains("myorders/" + AJRWebViewActivity.this.m)) {
                        AJRWebViewActivity aJRWebViewActivity = AJRWebViewActivity.this;
                        aJRWebViewActivity.setResult(-1, aJRWebViewActivity.b());
                        AJRWebViewActivity.this.finish();
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else if (TextUtils.isEmpty(AJRWebViewActivity.this.l) || !AJRWebViewActivity.this.l.equalsIgnoreCase("Contingency")) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJRWebViewActivity.this.finish();
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains("zestmoney")) {
                AJRWebViewActivity.this.f15643g.put("zestmoney", str);
            } else if (str.contains("emi-details")) {
                AJRWebViewActivity.this.f15643g.put("emi-details", str);
            }
            if (AJRWebViewActivity.this.getIntent().hasExtra(UpiConstants.FROM) && AJRWebViewActivity.this.getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("no_cost_emi")) {
                if (!AJRWebViewActivity.this.f15640d.isEmpty() && Uri.parse(str).getBooleanQueryParameter("login_required", false)) {
                    Intent intent = new Intent();
                    intent.putExtra("set_result_required", true);
                    t.e().resolveIntentByMainApp(AJRWebViewActivity.this, intent, "authActivity", 111);
                } else if (!TextUtils.isEmpty(str)) {
                    AJRWebViewActivity.a(AJRWebViewActivity.this, str);
                }
            }
            if (d.d(AJRWebViewActivity.this, str)) {
                return true;
            }
            if (str.toLowerCase().contains("mailto:care@paytm.com")) {
                AJRWebViewActivity.c(AJRWebViewActivity.this);
                return true;
            } else if (str.startsWith("market://")) {
                AJRWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    String host = str != null ? Uri.parse(str).getHost() : "";
                    if (!TextUtils.isEmpty(host) && t.a(host)) {
                        if (!AJRWebViewActivity.this.r || !str.contains("upi_landing")) {
                            com.paytmmall.artifact.d.a.a().a((Activity) AJRWebViewActivity.this, str);
                        } else {
                            AJRWebViewActivity.this.finish();
                        }
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            if (str.contains("zestmoney")) {
                AJRWebViewActivity.this.f15643g.put("zestmoney", str);
            } else if (str.contains("emi-details")) {
                AJRWebViewActivity.this.f15643g.put("emi-details", str);
            }
            AJRWebViewActivity.this.f15644h = str;
            AJRWebViewActivity.class.getName();
            "OnPageFinished  :  Url : ".concat(String.valueOf(str));
            boolean z = c.f15691a;
            super.onPageFinished(webView, str);
            if (AJRWebViewActivity.this.f15641e) {
                AJRWebViewActivity aJRWebViewActivity = AJRWebViewActivity.this;
                aJRWebViewActivity.f15641e = false;
                aJRWebViewActivity.f15638b.clearHistory();
            }
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public void onCreate(Bundle bundle) {
        HashMap<String, String> hashMap;
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_web_view);
        this.f15638b = (WebView) findViewById(R.id.payment_webview);
        this.f15638b.setWebViewClient(this.s);
        if (t.c().g() && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (getIntent().hasExtra("hide_webview_zoom")) {
            this.f15638b.getSettings().setBuiltInZoomControls(false);
        } else {
            this.f15638b.getSettings().setBuiltInZoomControls(true);
        }
        this.f15638b.getSettings().setJavaScriptEnabled(true);
        this.f15638b.getSettings().setDomStorageEnabled(true);
        this.f15638b.requestFocus(130);
        this.j = getIntent().getStringExtra("url");
        CJRItem cJRItem = (CJRItem) com.paytmmall.artifact.e.a.a((Object) getIntent().getSerializableExtra("extra_home_data"), CJRHomePageItem.class);
        if (this.j == null && cJRItem != null) {
            this.j = cJRItem.getURL();
        }
        this.r = getIntent().getBooleanExtra("finish_activity", false);
        Intent intent = getIntent();
        if (intent != null) {
            hashMap = b(intent.getStringExtra("zest_emi_header"));
        } else {
            hashMap = new HashMap<>();
        }
        this.f15640d = hashMap;
        this.f15645i = getIntent().getBooleanExtra("low_cost_emi", false);
        if (getIntent().getBooleanExtra("no_cost_emi", false)) {
            this.j += "&app_client=mall-app&version=" + t.c().c("VERSION_NAME");
            CookieManager instance = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT >= 21) {
                instance.removeAllCookies((ValueCallback) null);
            } else {
                instance.removeAllCookie();
            }
        }
        AJRWebViewActivity.class.getName();
        new StringBuilder("Url :").append(this.j);
        boolean z = c.f15691a;
        if (!TextUtils.isEmpty(this.j)) {
            if (this.f15640d.isEmpty()) {
                this.f15638b.loadUrl(this.j);
            } else {
                this.f15638b.getSettings().setAllowContentAccess(true);
                this.f15638b.getSettings().setAllowFileAccess(true);
                this.f15638b.setWebChromeClient(new a(this, (byte) 0));
                this.f15638b.addJavascriptInterface(new com.paytmmall.artifact.common.c(this), "PTOKENINTERFACE");
                this.f15638b.loadUrl(this.j, this.f15640d);
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(R.drawable.mall_no_home);
            supportActionBar.c(R.drawable.mall_no_home);
        }
        this.o = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(this.o) && cJRItem != null) {
            this.o = cJRItem.getName();
        }
        String str = this.j;
        if (!(str == null || supportActionBar == null)) {
            supportActionBar.a((CharSequence) str);
        }
        this.l = getIntent().getStringExtra(UpiConstants.FROM);
        this.m = getIntent().getStringExtra("order_id");
        this.k = getIntent().getBooleanExtra("Maintenance", false);
        this.f15639c = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f15639c) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                d.b(this, stringExtra, stringExtra2);
            }
        }
        if (TextUtils.isEmpty(this.l) || !this.l.equalsIgnoreCase("Contingency") || getIntent().getBooleanExtra("Close", true)) {
            supportActionBar.b(true);
        }
    }

    private static HashMap<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        try {
            return com.paytmmall.artifact.common.b.a.a.a(str);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return new HashMap<>();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str = this.o;
        if (str == null || !str.equalsIgnoreCase("Invoice")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.mall_invoice_menu_items, menu);
        this.p = menu;
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        Menu menu;
        if (i2 == 82 && (menu = this.p) != null) {
            menu.performIdentifierAction(R.id.menu_overflow, 0);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        t.e().resolveIntentByMainApp(this, new Intent(), "mainActivity", Integer.MIN_VALUE);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        if (this.n && this.f15639c) {
            a();
        }
    }

    public void onBackPressed() {
        if (this.f15639c) {
            a();
            return;
        }
        setResult(0, b());
        if (this.f15638b.canGoBack()) {
            this.f15638b.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onPause() {
        super.onPause();
        this.n = true;
        d.k();
        if (this.k) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == R.id.save) {
            try {
                this.q = false;
                c();
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        } else if (itemId == R.id.email) {
            try {
                this.q = true;
                c();
            } catch (Exception e3) {
                q.c(e3.getMessage());
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void c() {
        if (!y.a() || y.b(this)) {
            d();
        } else {
            y.a(this);
        }
    }

    private void d() {
        View findViewById = findViewById(R.id.payment_webview);
        findViewById.setDrawingCacheEnabled(true);
        Bitmap drawingCache = findViewById.getDrawingCache();
        String file = Environment.getExternalStorageDirectory().toString();
        File file2 = new File(file, "invoice0.jpg");
        int i2 = 0;
        while (file2.exists()) {
            i2++;
            file2 = new File(file, "invoice" + i2 + ".jpg");
        }
        try {
            if (!file2.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                MediaStore.Images.Media.insertImage(getContentResolver(), drawingCache, "Invoice", "invoice");
            }
            if (this.q) {
                String str = null;
                String str2 = Build.MANUFACTURER;
                try {
                    str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    q.c(e2.getMessage());
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("application/image");
                if (!TextUtils.isEmpty(d.g((Context) this))) {
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{d.g((Context) this)});
                }
                intent.putExtra("android.intent.extra.SUBJECT", "Your Invoice");
                intent.putExtra("android.intent.extra.TEXT", "\n\n\n\n\n-----------------------------------------------------------\nPaytm " + str + " on " + Character.toUpperCase(str2.charAt(0)) + str2.substring(1) + " " + Build.MODEL + " running Android " + Build.VERSION.RELEASE);
                StringBuilder sb = new StringBuilder("file:///mnt/sdcard/invoice");
                sb.append(i2);
                sb.append(".jpg");
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(sb.toString()));
                startActivity(Intent.createChooser(intent, "Send Mail..."));
                return;
            }
            d.b(this, getResources().getString(R.string.invoice_save), getResources().getString(R.string.invoice_save_body));
        } catch (FileNotFoundException e3) {
            q.c(e3.getMessage());
        } catch (Exception e4) {
            q.c(e4.getMessage());
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        char c2;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56) {
            if (iArr.length > 0) {
                int length = iArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    } else if (iArr[i3] != 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            z = false;
            if (z) {
                d();
                return;
            }
            int length2 = strArr.length;
            int i4 = 0;
            while (true) {
                c2 = 65535;
                if (i4 >= length2) {
                    break;
                }
                String str = strArr[i4];
                if (iArr[i4] != -1) {
                    i4++;
                } else if (!androidx.core.app.a.a((Activity) this, str)) {
                    c2 = 0;
                } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                    c2 = 1;
                }
            }
            if (c2 != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AJRWebViewActivity.this.b(dialogInterface, i2);
                        }
                    });
                    builder.setNegativeButton(getResources().getString(R.string.cancel), $$Lambda$AJRWebViewActivity$lM1dIhzO4z_cUBOSZZI68FUU18Q.INSTANCE);
                    builder.show();
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            q.c(e2.getMessage());
            return 0;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && i3 == -1) {
            this.f15640d.put(AppConstants.SSO_TOKEN, l.a((Context) this));
            this.f15638b.loadUrl(this.j, this.f15640d);
            this.f15641e = true;
        } else if (i2 == 8899 && this.f15642f != null) {
            Uri data = (intent == null || i3 != -1) ? null : intent.getData();
            if (data != null) {
                this.f15642f.onReceiveValue(new Uri[]{data});
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Intent b() {
        Bundle bundle = new Bundle();
        bundle.putAll(getIntent().getExtras());
        return new Intent().putExtras(bundle);
    }

    class a extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(AJRWebViewActivity aJRWebViewActivity, byte b2) {
            this();
        }

        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (AJRWebViewActivity.this.f15642f != null) {
                AJRWebViewActivity.this.f15642f.onReceiveValue((Object) null);
            }
            AJRWebViewActivity.this.f15642f = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            AJRWebViewActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 8899);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
        startActivity(intent);
        finish();
    }

    static /* synthetic */ void a(AJRWebViewActivity aJRWebViewActivity, String str) {
        Uri parse = Uri.parse(str);
        if (parse.getQueryParameterNames().contains("bank_id")) {
            String queryParameter = parse.getQueryParameter("bank_id");
            String queryParameter2 = parse.getQueryParameter("plan_id");
            String queryParameter3 = parse.getQueryParameter("offer_desc");
            String queryParameter4 = parse.getQueryParameter(PayUtility.BANK_NAME);
            String queryParameter5 = parse.getQueryParameter("cashback_amount");
            CJREMIModel cJREMIModel = new CJREMIModel();
            cJREMIModel.setOfferDetails(queryParameter3);
            cJREMIModel.setBankName(queryParameter4);
            cJREMIModel.setCashbackAmount(c(queryParameter5));
            cJREMIModel.setBank_id(c(queryParameter));
            cJREMIModel.setPlan_id(c(queryParameter2));
            Intent intent = new Intent();
            intent.putExtra("emi_data", cJREMIModel);
            aJRWebViewActivity.setResult(-1, intent);
            aJRWebViewActivity.finish();
        }
    }

    static /* synthetic */ void c(AJRWebViewActivity aJRWebViewActivity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"care@paytm.com"});
        try {
            aJRWebViewActivity.startActivity(Intent.createChooser(intent, aJRWebViewActivity.getResources().getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e2) {
            q.c(e2.getMessage());
        }
    }
}
