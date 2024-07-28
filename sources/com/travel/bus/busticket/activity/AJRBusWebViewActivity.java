package com.travel.bus.busticket.activity;

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
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.i.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJREMIModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRBusWebViewActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private final int f21914a = 201;

    /* renamed from: b  reason: collision with root package name */
    private WebView f21915b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21916c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21917d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f21918e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f21919f;

    /* renamed from: g  reason: collision with root package name */
    private ActionBar f21920g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21921h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21922i = false;
    private String j;
    private Menu k;
    private String l;
    private boolean m = false;
    /* access modifiers changed from: private */
    public boolean n;
    private WebViewClient o = new WebViewClient() {
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ((LottieAnimationView) AJRBusWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            if (str == null || !str.toLowerCase().contains("http://cta")) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(AJRBusWebViewActivity.this.f21918e) && AJRBusWebViewActivity.this.f21918e.equalsIgnoreCase("Order_summary") && !TextUtils.isEmpty(AJRBusWebViewActivity.this.f21919f)) {
                    if (str.contains("myorders/" + AJRBusWebViewActivity.this.f21919f)) {
                        AJRBusWebViewActivity aJRBusWebViewActivity = AJRBusWebViewActivity.this;
                        aJRBusWebViewActivity.setResult(-1, aJRBusWebViewActivity.d());
                        AJRBusWebViewActivity.this.finish();
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else if (TextUtils.isEmpty(AJRBusWebViewActivity.this.f21918e) || !AJRBusWebViewActivity.this.f21918e.equalsIgnoreCase("Contingency")) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJRBusWebViewActivity.this.finish();
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AJRBusWebViewActivity.this.getIntent().hasExtra(UpiConstants.FROM) && AJRBusWebViewActivity.this.getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("no_cost_emi") && !TextUtils.isEmpty(str)) {
                AJRBusWebViewActivity.a(AJRBusWebViewActivity.this, str);
            }
            if (b.v(AJRBusWebViewActivity.this, str)) {
                return true;
            }
            if (str != null && str.toLowerCase().contains("mailto:care@paytm.com")) {
                AJRBusWebViewActivity.d(AJRBusWebViewActivity.this);
                return true;
            } else if (str.startsWith("market://")) {
                AJRBusWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (!Uri.parse(str).getScheme().equals("paytmmp")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                if (!AJRBusWebViewActivity.this.n || !str.contains("upi_landing")) {
                    a.a();
                    if (a.b().a(str)) {
                        a.a();
                        a.b();
                    } else {
                        AJRBusWebViewActivity.b(AJRBusWebViewActivity.this, str);
                    }
                } else {
                    AJRBusWebViewActivity.this.finish();
                }
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ((LottieAnimationView) AJRBusWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            super.onPageFinished(webView, str);
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_activity_web_view);
        this.f21915b = (WebView) findViewById(R.id.payment_webview);
        this.f21915b.setWebViewClient(this.o);
        if (getIntent().hasExtra(UpiConstants.FROM) && getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("electricity")) {
            this.f21915b.getSettings().setLoadWithOverviewMode(true);
            this.f21915b.getSettings().setUseWideViewPort(true);
        }
        if (getIntent().hasExtra("hide_webview_zoom")) {
            this.f21915b.getSettings().setBuiltInZoomControls(false);
        } else {
            this.f21915b.getSettings().setBuiltInZoomControls(true);
        }
        this.f21915b.getSettings().setJavaScriptEnabled(true);
        this.f21915b.getSettings().setDomStorageEnabled(true);
        this.f21915b.requestFocus(130);
        this.l = getIntent().getStringExtra("url");
        CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
        if (this.l == null && cJRItem != null) {
            this.l = cJRItem.getURL();
        }
        this.n = getIntent().getBooleanExtra("finish_activity", false);
        if (!TextUtils.isEmpty(this.l)) {
            this.f21915b.loadUrl(this.l);
        }
        this.f21920g = getSupportActionBar();
        this.j = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(this.j) && cJRItem != null) {
            this.j = cJRItem.getName();
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.f21920g.a((CharSequence) this.j);
        }
        this.f21918e = getIntent().getStringExtra(UpiConstants.FROM);
        this.f21919f = getIntent().getStringExtra("order_id");
        this.f21917d = getIntent().getBooleanExtra("Maintenance", false);
        this.f21921h = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f21921h) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (TextUtils.isEmpty(this.f21918e) || !this.f21918e.equalsIgnoreCase("Contingency")) {
            this.f21916c = true;
            this.f21920g.b(true);
            return;
        }
        this.f21916c = getIntent().getBooleanExtra("Close", true);
        if (this.f21916c) {
            this.f21920g.b(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str = this.j;
        if (str == null || !str.equalsIgnoreCase("Invoice")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.pre_b_invoice_menu_items, menu);
        this.k = menu;
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        Menu menu;
        if (i2 == 82 && (menu = this.k) != null) {
            menu.performIdentifierAction(R.id.menu_overflow, 0);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    private void a() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrl(com.travel.bus.b.a.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        a.a();
        a.b().a((Context) this, intent);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
        if (this.f21922i && this.f21921h) {
            a();
        }
    }

    public void onBackPressed() {
        if (this.f21921h) {
            a();
            return;
        }
        setResult(0, d());
        if (this.f21915b.canGoBack()) {
            this.f21915b.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onPause() {
        super.onPause();
        this.f21922i = true;
        b.u();
        if (this.f21917d) {
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
                this.m = false;
                b();
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        } else if (itemId == R.id.email) {
            try {
                this.m = true;
                b();
            } catch (Exception e3) {
                if (b.v) {
                    q.c(e3.getMessage());
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
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
            if (this.m) {
                String str = null;
                String str2 = Build.MANUFACTURER;
                try {
                    str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    q.c(e2.getMessage());
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("application/image");
                if (b.m((Context) this) != null) {
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{b.m((Context) this)});
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
            q.c(e3.getMessage());
        } catch (Exception e4) {
            q.c(e4.getMessage());
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
                        s.b((Context) AJRBusWebViewActivity.this);
                        AJRBusWebViewActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), $$Lambda$AJRBusWebViewActivity$iH1fLdLEDPf6oNoxd5F_AU8STJw.INSTANCE);
                builder.show();
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            q.c(e2.getMessage());
            return 0;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1 && intent != null) {
            intent.getStringExtra("branch_share_url");
            a.a();
            a.b();
        }
    }

    /* access modifiers changed from: private */
    public Intent d() {
        Bundle bundle = new Bundle();
        bundle.putAll(getIntent().getExtras());
        return new Intent().putExtras(bundle);
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    static /* synthetic */ void a(AJRBusWebViewActivity aJRBusWebViewActivity, String str) {
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
            aJRBusWebViewActivity.setResult(-1, intent);
            aJRBusWebViewActivity.finish();
        }
    }

    static /* synthetic */ void d(AJRBusWebViewActivity aJRBusWebViewActivity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"care@paytm.com"});
        try {
            aJRBusWebViewActivity.startActivity(Intent.createChooser(intent, aJRBusWebViewActivity.getResources().getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void b(AJRBusWebViewActivity aJRBusWebViewActivity, String str) {
        CJRHomePageItem a2 = u.a(aJRBusWebViewActivity.getApplicationContext(), str);
        if (a2 != null) {
            a.a();
            a.b();
            a2.getURLType();
        } else {
            a.a();
            a.b();
        }
        if (a2 == null || TextUtils.isEmpty(a2.getDeeplink())) {
            Toast.makeText(aJRBusWebViewActivity, "Something Went Wrong!!!", 0).show();
            return;
        }
        a.a();
        a.b().b(a2.getDeeplink(), (Context) aJRBusWebViewActivity);
    }
}
