package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import com.paytm.utility.b;
import com.paytm.utility.s;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJREMIModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.utils.x;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRWebViewActivity extends AppBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private final int f74156a = 201;

    /* renamed from: b  reason: collision with root package name */
    private WebView f74157b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f74158c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f74159d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f74160e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f74161f;

    /* renamed from: g  reason: collision with root package name */
    private ActionBar f74162g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f74163h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f74164i = false;
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
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            if (str == null || !str.toLowerCase().contains("http://cta")) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(AJRWebViewActivity.this.f74160e) && AJRWebViewActivity.this.f74160e.equalsIgnoreCase("Order_summary") && !TextUtils.isEmpty(AJRWebViewActivity.this.f74161f)) {
                    if (str.contains("myorders/" + AJRWebViewActivity.this.f74161f)) {
                        AJRWebViewActivity aJRWebViewActivity = AJRWebViewActivity.this;
                        aJRWebViewActivity.setResult(-1, aJRWebViewActivity.d());
                        AJRWebViewActivity.this.finish();
                        return;
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else if (TextUtils.isEmpty(AJRWebViewActivity.this.f74160e) || !AJRWebViewActivity.this.f74160e.equalsIgnoreCase("Contingency")) {
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
                if (AJRWebViewActivity.this.n && str.contains("upi_landing")) {
                    AJRWebViewActivity.this.finish();
                } else if (net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.isBranchShareUrl(str)) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.shareBranchLink(AJRWebViewActivity.this, str);
                } else {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.launchDeeplink(str, AJRWebViewActivity.this, (String) null);
                }
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AJRWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            super.onPageFinished(webView, str);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movies_web_view);
        this.f74157b = (WebView) findViewById(R.id.payment_webview);
        this.f74157b.setWebViewClient(this.o);
        if (net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.isDebugType() && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (getIntent().hasExtra(UpiConstants.FROM) && getIntent().getStringExtra(UpiConstants.FROM).equalsIgnoreCase("electricity")) {
            this.f74157b.getSettings().setLoadWithOverviewMode(true);
            this.f74157b.getSettings().setUseWideViewPort(true);
        }
        if (getIntent().hasExtra("hide_webview_zoom")) {
            this.f74157b.getSettings().setBuiltInZoomControls(false);
        } else {
            this.f74157b.getSettings().setBuiltInZoomControls(true);
        }
        this.f74157b.getSettings().setJavaScriptEnabled(true);
        this.f74157b.getSettings().setDomStorageEnabled(true);
        this.f74157b.requestFocus(130);
        this.l = getIntent().getStringExtra("url");
        CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
        if (this.l == null && cJRItem != null) {
            this.l = cJRItem.getURL();
        }
        this.n = getIntent().getBooleanExtra("finish_activity", false);
        if (!TextUtils.isEmpty(this.l)) {
            this.f74157b.loadUrl(this.l);
        }
        this.f74162g = getSupportActionBar();
        this.f74162g.b(R.drawable.movie_no_home);
        this.f74162g.c(R.drawable.movie_no_home);
        this.j = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(this.j) && cJRItem != null) {
            this.j = cJRItem.getName();
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.f74162g.a((CharSequence) this.j);
        }
        this.f74160e = getIntent().getStringExtra(UpiConstants.FROM);
        this.f74161f = getIntent().getStringExtra("order_id");
        this.f74159d = getIntent().getBooleanExtra("Maintenance", false);
        this.f74163h = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f74163h) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (TextUtils.isEmpty(this.f74160e) || !this.f74160e.equalsIgnoreCase("Contingency")) {
            this.f74158c = true;
            this.f74162g.b(true);
            return;
        }
        this.f74158c = getIntent().getBooleanExtra("Close", true);
        if (this.f74158c) {
            this.f74162g.b(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str = this.j;
        if (str == null || !str.equalsIgnoreCase("Invoice")) {
            return true;
        }
        getMenuInflater().inflate(R.menu.movie_invoice_menu_items, menu);
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
        cJRHomePageItem.setUrl(x.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity"));
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
        if (this.f74164i && this.f74163h) {
            a();
        }
    }

    public void onBackPressed() {
        if (this.f74163h) {
            a();
            return;
        }
        setResult(0, d());
        if (this.f74157b.canGoBack()) {
            this.f74157b.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onPause() {
        super.onPause();
        this.f74164i = true;
        b.u();
        if (this.f74159d) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (menuItem.getItemId() == R.id.save) {
            try {
                this.m = false;
                b();
            } catch (Exception unused) {
            }
        } else if (menuItem.getItemId() == R.id.email) {
            this.m = true;
            b();
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

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089 A[Catch:{ FileNotFoundException | Exception -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ExcHandler: FileNotFoundException | Exception (unused java.lang.Throwable), SYNTHETIC, Splitter:B:4:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r10 = this;
            int r0 = net.one97.paytm.o2o.movies.R.id.payment_webview
            android.view.View r0 = r10.findViewById(r0)
            r1 = 1
            r0.setDrawingCacheEnabled(r1)
            android.graphics.Bitmap r0 = r0.getDrawingCache()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.toString()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "invoice0.jpg"
            r3.<init>(r2, r4)
            r4 = 0
            r5 = 0
        L_0x001f:
            boolean r6 = r3.exists()
            java.lang.String r7 = ".jpg"
            java.lang.String r8 = "invoice"
            if (r6 == 0) goto L_0x0041
            int r5 = r5 + 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            r3.append(r5)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r2, r3)
            r3 = r6
            goto L_0x001f
        L_0x0041:
            boolean r2 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            if (r2 != 0) goto L_0x0062
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r6 = 100
            r0.compress(r3, r6, r2)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r2.flush()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r2.close()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r3 = "Invoice"
            android.provider.MediaStore.Images.Media.insertImage(r2, r0, r3, r8)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
        L_0x0062:
            boolean r0 = r10.m     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            if (r0 == 0) goto L_0x00ff
            r0 = 0
            java.lang.String r2 = android.os.Build.MANUFACTURER     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            android.content.pm.PackageManager r3 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0077, FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r6 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x0077, FileNotFoundException | Exception -> 0x0116 }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r6, r4)     // Catch:{ NameNotFoundException -> 0x0077, FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = r3.versionName     // Catch:{ NameNotFoundException -> 0x0077, FileNotFoundException | Exception -> 0x0116 }
        L_0x0077:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r6 = "android.intent.action.SEND"
            r3.<init>(r6)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r6 = "application/image"
            r3.setType(r6)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r6 = com.paytm.utility.b.m((android.content.Context) r10)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            if (r6 == 0) goto L_0x0096
            java.lang.String r6 = "android.intent.extra.EMAIL"
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r9 = com.paytm.utility.b.m((android.content.Context) r10)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8[r4] = r9     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r3.putExtra(r6, r8)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
        L_0x0096:
            java.lang.String r6 = "android.intent.extra.SUBJECT"
            java.lang.String r8 = "Your Invoice"
            r3.putExtra(r6, r8)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r6 = "android.intent.extra.TEXT"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r9 = "\n\n\n\n\n-----------------------------------------------------------\nPaytm "
            r8.<init>(r9)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = " on "
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            char r0 = r2.charAt(r4)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            char r0 = java.lang.Character.toUpperCase(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = r2.substring(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = " "
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = android.os.Build.MODEL     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = " running Android "
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = android.os.Build.VERSION.RELEASE     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r8.append(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = r8.toString()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r3.putExtra(r6, r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = "android.intent.extra.STREAM"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r2 = "file:///mnt/sdcard/invoice"
            r1.<init>(r2)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r1.append(r5)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r1.append(r7)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r3.putExtra(r0, r1)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = "Send Mail..."
            android.content.Intent r0 = android.content.Intent.createChooser(r3, r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            r10.startActivity(r0)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            return
        L_0x00ff:
            android.content.res.Resources r0 = r10.getResources()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            int r1 = net.one97.paytm.o2o.movies.R.string.invoice_save     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            android.content.res.Resources r1 = r10.getResources()     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            int r2 = net.one97.paytm.o2o.movies.R.string.invoice_save_body     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
            com.paytm.utility.b.b((android.content.Context) r10, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ FileNotFoundException | Exception -> 0x0116 }
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRWebViewActivity.c():void");
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
            } catch (Exception unused) {
            }
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1 && intent != null) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.shareBranchLink(this, intent.getStringExtra("branch_share_url"));
        }
    }

    /* access modifiers changed from: private */
    public Intent d() {
        Bundle bundle = new Bundle();
        bundle.putAll(getIntent().getExtras());
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
        } catch (ActivityNotFoundException unused) {
        }
    }
}
