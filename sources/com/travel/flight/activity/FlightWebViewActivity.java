package com.travel.flight.activity;

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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.ActionBar;
import com.paytm.utility.b;
import com.paytm.utility.s;
import com.travel.common.TravelBaseActivity;
import com.travel.flight.R;
import com.travel.flight.utils.i;
import com.travel.utils.q;
import java.io.File;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJREMIModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiConstants;

public class FlightWebViewActivity extends TravelBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private final int f23521a = 201;

    /* renamed from: b  reason: collision with root package name */
    private WebView f23522b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23523c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23524d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f23525e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f23526f;

    /* renamed from: g  reason: collision with root package name */
    private ActionBar f23527g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23528h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23529i = false;
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
            if (str == null || !str.toLowerCase().contains("http://cta")) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(FlightWebViewActivity.this.f23525e) && FlightWebViewActivity.this.f23525e.equalsIgnoreCase("Order_summary") && !TextUtils.isEmpty(FlightWebViewActivity.this.f23526f)) {
                    if (str.contains("myorders/" + FlightWebViewActivity.this.f23526f)) {
                        FlightWebViewActivity flightWebViewActivity = FlightWebViewActivity.this;
                        flightWebViewActivity.setResult(-1, flightWebViewActivity.d());
                        FlightWebViewActivity.this.finish();
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else if (TextUtils.isEmpty(FlightWebViewActivity.this.f23525e) || !FlightWebViewActivity.this.f23525e.equalsIgnoreCase("Contingency")) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                FlightWebViewActivity.this.finish();
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (FlightWebViewActivity.this.getIntent().hasExtra(UpiConstants.FROM) && FlightWebViewActivity.this.getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("no_cost_emi") && !TextUtils.isEmpty(str)) {
                FlightWebViewActivity.a(FlightWebViewActivity.this, str);
            }
            if (b.v(FlightWebViewActivity.this, str)) {
                return true;
            }
            if (str != null && str.toLowerCase().contains("mailto:care@paytm.com")) {
                FlightWebViewActivity.d(FlightWebViewActivity.this);
                return true;
            } else if (str.startsWith("market://")) {
                FlightWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (!Uri.parse(str).getScheme().equals("paytmmp")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                if (!FlightWebViewActivity.this.n || !str.contains("upi_landing")) {
                    com.travel.flight.b.a();
                    com.travel.flight.b.b();
                    com.travel.flight.b.a();
                    com.travel.flight.b.b().a(FlightWebViewActivity.this.getApplicationContext(), str);
                } else {
                    FlightWebViewActivity.this.finish();
                }
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setContentView((View) linearLayout);
        this.f23522b = new WebView(this);
        this.f23522b.setWebViewClient(this.o);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        linearLayout.addView(this.f23522b, layoutParams);
        com.travel.flight.b.a();
        if (com.travel.flight.b.b().ab() && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (getIntent().hasExtra(UpiConstants.FROM) && getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("electricity")) {
            this.f23522b.getSettings().setLoadWithOverviewMode(true);
            this.f23522b.getSettings().setUseWideViewPort(true);
        }
        if (getIntent().hasExtra("hide_webview_zoom")) {
            this.f23522b.getSettings().setBuiltInZoomControls(false);
        } else {
            this.f23522b.getSettings().setBuiltInZoomControls(true);
        }
        this.f23522b.getSettings().setJavaScriptEnabled(true);
        this.f23522b.getSettings().setDomStorageEnabled(true);
        this.f23522b.requestFocus(130);
        this.l = getIntent().getStringExtra("url");
        CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
        if (this.l == null && cJRItem != null) {
            this.l = cJRItem.getURL();
        }
        this.n = getIntent().getBooleanExtra("finish_activity", false);
        if (!TextUtils.isEmpty(this.l)) {
            this.f23522b.loadUrl(this.l);
        }
        this.f23527g = getSupportActionBar();
        this.j = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(this.j) && cJRItem != null) {
            this.j = cJRItem.getName();
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.f23527g.a((CharSequence) this.j);
        }
        this.f23525e = getIntent().getStringExtra(UpiConstants.FROM);
        this.f23526f = getIntent().getStringExtra("order_id");
        this.f23524d = getIntent().getBooleanExtra("Maintenance", false);
        this.f23528h = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f23528h) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (TextUtils.isEmpty(this.f23525e) || !this.f23525e.equalsIgnoreCase("Contingency")) {
            this.f23523c = true;
            this.f23527g.b(true);
            return;
        }
        this.f23523c = getIntent().getBooleanExtra("Close", true);
        if (this.f23523c) {
            this.f23527g.b(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str = this.j;
        if (str == null || !str.equalsIgnoreCase("Invoice")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.pre_f_invoice_menu_items, menu);
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
        cJRHomePageItem.setUrl(i.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        com.travel.flight.b.a();
        com.travel.flight.b.b().b(this, intent);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(context);
    }

    public void onResume() {
        super.onResume();
        if (this.f23529i && this.f23528h) {
            a();
        }
        q.a(this);
    }

    public void onBackPressed() {
        if (this.f23528h) {
            a();
            return;
        }
        setResult(0, d());
        if (this.f23522b.canGoBack()) {
            this.f23522b.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onPause() {
        super.onPause();
        this.f23529i = true;
        b.u();
        if (this.f23524d) {
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
                    com.paytm.utility.q.b(e2.getMessage());
                }
            }
        } else if (itemId == R.id.email) {
            try {
                this.m = true;
                b();
            } catch (Exception e3) {
                if (b.v) {
                    com.paytm.utility.q.b(e3.getMessage());
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
        String file = Environment.getExternalStorageDirectory().toString();
        File file2 = new File(file, "invoice0.jpg");
        int i2 = 0;
        while (file2.exists()) {
            i2++;
            file2 = new File(file, "invoice" + i2 + ".jpg");
        }
        try {
            if (this.m) {
                String str = null;
                String str2 = Build.MANUFACTURER;
                try {
                    str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    com.paytm.utility.q.b(e2.getMessage());
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
        } catch (Exception e3) {
            com.paytm.utility.q.b(e3.getMessage());
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
                        s.b((Context) FlightWebViewActivity.this);
                        FlightWebViewActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                builder.show();
            } catch (Exception e2) {
                if (b.v) {
                    com.paytm.utility.q.b(e2.getMessage());
                }
            }
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            com.paytm.utility.q.b(e2.getMessage());
            return 0;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1 && intent != null) {
            intent.getStringExtra("branch_share_url");
            com.travel.flight.b.a();
            com.travel.flight.b.b();
        }
    }

    /* access modifiers changed from: private */
    public Intent d() {
        Bundle bundle = new Bundle();
        bundle.putAll(getIntent().getExtras());
        return new Intent().putExtras(bundle);
    }

    static /* synthetic */ void a(FlightWebViewActivity flightWebViewActivity, String str) {
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
            flightWebViewActivity.setResult(-1, intent);
            flightWebViewActivity.finish();
        }
    }

    static /* synthetic */ void d(FlightWebViewActivity flightWebViewActivity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"care@paytm.com"});
        try {
            flightWebViewActivity.startActivity(Intent.createChooser(intent, flightWebViewActivity.getResources().getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }
}
