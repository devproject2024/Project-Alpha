package net.one97.paytm;

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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJREMIModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;

public class AJRWebViewActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f51771a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f51772b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f51773c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f51774d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f51775e;

    /* renamed from: f  reason: collision with root package name */
    private ActionBar f51776f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f51777g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51778h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f51779i;
    private Menu j;
    private String k;
    private boolean l = false;
    /* access modifiers changed from: private */
    public boolean m;
    private WebViewClient n = new WebViewClient() {
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            if (str == null || !str.toLowerCase().contains("http://cta")) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(AJRWebViewActivity.this.f51774d) && AJRWebViewActivity.this.f51774d.equalsIgnoreCase("Order_summary") && !TextUtils.isEmpty(AJRWebViewActivity.this.f51775e)) {
                    if (str.contains("myorders/" + AJRWebViewActivity.this.f51775e)) {
                        AJRWebViewActivity aJRWebViewActivity = AJRWebViewActivity.this;
                        aJRWebViewActivity.setResult(-1, aJRWebViewActivity.d());
                        AJRWebViewActivity.this.finish();
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else if (TextUtils.isEmpty(AJRWebViewActivity.this.f51774d) || !AJRWebViewActivity.this.f51774d.equalsIgnoreCase("Contingency")) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJRWebViewActivity.this.finish();
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AJRWebViewActivity.this.getIntent().hasExtra(UpiConstants.FROM) && AJRWebViewActivity.this.getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("no_cost_emi") && !TextUtils.isEmpty(str)) {
                AJRWebViewActivity.a(AJRWebViewActivity.this, str);
            }
            if (b.v(AJRWebViewActivity.this, str)) {
                return true;
            }
            if (str != null && str.toLowerCase().contains("mailto:care@paytm.com")) {
                AJRWebViewActivity.d(AJRWebViewActivity.this);
                return true;
            } else if (str.startsWith("market://")) {
                AJRWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (!Uri.parse(str).getScheme().equals("paytmmp")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                if (!AJRWebViewActivity.this.m || !str.contains("upi_landing")) {
                    AJRWebViewActivity.b(AJRWebViewActivity.this, str);
                } else {
                    AJRWebViewActivity.this.finish();
                }
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            super.onPageFinished(webView, str);
        }
    };

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_web_view);
        this.f51771a = (WebView) findViewById(R.id.payment_webview);
        this.f51771a.setWebViewClient(this.n);
        if (getIntent().hasExtra(UpiConstants.FROM) && getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("electricity")) {
            this.f51771a.getSettings().setLoadWithOverviewMode(true);
            this.f51771a.getSettings().setUseWideViewPort(true);
        }
        if (getIntent().hasExtra("hide_webview_zoom")) {
            this.f51771a.getSettings().setBuiltInZoomControls(false);
        } else {
            this.f51771a.getSettings().setBuiltInZoomControls(true);
        }
        this.f51771a.getSettings().setJavaScriptEnabled(true);
        this.f51771a.getSettings().setDomStorageEnabled(true);
        this.f51771a.requestFocus(130);
        this.k = getIntent().getStringExtra("url");
        CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
        if (this.k == null && cJRItem != null) {
            this.k = cJRItem.getURL();
        }
        this.m = getIntent().getBooleanExtra("finish_activity", false);
        if (!TextUtils.isEmpty(this.k)) {
            this.f51771a.loadUrl(this.k);
        }
        this.f51776f = getSupportActionBar();
        this.f51776f.b((int) R.drawable.no_home_icon);
        this.f51776f.c((int) R.drawable.no_home_icon);
        this.f51779i = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(this.f51779i) && cJRItem != null) {
            this.f51779i = cJRItem.getName();
        }
        if (!TextUtils.isEmpty(this.f51779i)) {
            this.f51776f.a((CharSequence) this.f51779i);
        }
        this.f51774d = getIntent().getStringExtra(UpiConstants.FROM);
        this.f51775e = getIntent().getStringExtra("order_id");
        this.f51773c = getIntent().getBooleanExtra("Maintenance", false);
        this.f51777g = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f51777g) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (TextUtils.isEmpty(this.f51774d) || !this.f51774d.equalsIgnoreCase("Contingency")) {
            this.f51772b = true;
            this.f51776f.b(true);
            return;
        }
        this.f51772b = getIntent().getBooleanExtra("Close", true);
        if (this.f51772b) {
            this.f51776f.b(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str = this.f51779i;
        if (str == null || !str.equalsIgnoreCase("Invoice")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.invoice_menu_items, menu);
        this.j = menu;
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        Menu menu;
        if (i2 == 82 && (menu = this.j) != null) {
            menu.performIdentifierAction(R.id.menu_overflow, 0);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    private void a() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrl(ag.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent(this, AJRMainActivity.class);
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        startActivity(intent);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        if (this.f51778h && this.f51777g) {
            a();
        }
    }

    public void onBackPressed() {
        if (this.f51777g) {
            a();
            return;
        }
        setResult(0, d());
        if (this.f51771a.canGoBack()) {
            this.f51771a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onPause() {
        super.onPause();
        this.f51778h = true;
        com.paytm.utility.a.k();
        if (this.f51773c) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.email) {
                try {
                    this.l = true;
                    b();
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            } else if (itemId == R.id.save) {
                try {
                    this.l = false;
                    b();
                } catch (Exception e3) {
                    if (b.v) {
                        q.b(e3.getMessage());
                    }
                }
            }
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void b() {
        if (!s.a() || s.c((Activity) this)) {
            c();
        } else {
            s.b((Activity) this);
        }
    }

    private void c() {
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
            if (this.l) {
                String str = null;
                String str2 = Build.MANUFACTURER;
                try {
                    str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    q.b(e2.getMessage());
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("application/image");
                if (com.paytm.utility.a.c((Context) this) != null) {
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{com.paytm.utility.a.c((Context) this)});
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
            b.b((Context) this, getResources().getString(R.string.invoice_save), getResources().getString(R.string.invoice_save_body));
        } catch (FileNotFoundException e3) {
            q.b(e3.getMessage());
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (s.a(iArr)) {
            c();
        } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        s.b((Context) AJRWebViewActivity.this);
                        AJRWebViewActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                builder.show();
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public Intent d() {
        Bundle bundle = new Bundle();
        if (getIntent().getExtras() != null) {
            bundle.putAll(getIntent().getExtras());
        }
        return new Intent().putExtras(bundle);
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
            cJREMIModel.setCashbackAmount(a(queryParameter5));
            cJREMIModel.setBank_id(a(queryParameter));
            cJREMIModel.setPlan_id(a(queryParameter2));
            Intent intent = new Intent();
            intent.putExtra("emi_data", cJREMIModel);
            aJRWebViewActivity.setResult(-1, intent);
            aJRWebViewActivity.finish();
        }
    }

    static /* synthetic */ void d(AJRWebViewActivity aJRWebViewActivity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"care@paytm.com"});
        try {
            aJRWebViewActivity.startActivity(Intent.createChooser(intent, aJRWebViewActivity.getResources().getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e2) {
            q.b(e2.getMessage());
        }
    }

    static /* synthetic */ void b(AJRWebViewActivity aJRWebViewActivity, String str) {
        h.a aVar = h.f50349a;
        h.a.a(aJRWebViewActivity, str, (Bundle) null);
    }
}
