package com.travel.flight.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.c;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.utils.i;
import com.travel.utils.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class AJREmbedWebView extends CJRActionBarBaseActivity {
    private String A;
    /* access modifiers changed from: private */
    public String B;
    /* access modifiers changed from: private */
    public boolean C;
    private boolean D = false;
    private HashMap<String, String> E = null;
    /* access modifiers changed from: private */
    public String F;
    /* access modifiers changed from: private */
    public DownloadManager G;
    /* access modifiers changed from: private */
    public long H;
    private BroadcastReceiver I = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            final Cursor query2 = AJREmbedWebView.this.G.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    query2.getString(query2.getColumnIndex("title"));
                    if (longExtra != ((long) query2.getInt(0)) || longExtra != AJREmbedWebView.this.H) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                                Cursor cursor = query2;
                                aJREmbedWebView.a(cursor.getString(cursor.getColumnIndex("local_uri")));
                                AJREmbedWebView.this.c();
                            }
                        }, 10000);
                        return;
                    }
                    AJREmbedWebView.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                    AJREmbedWebView.this.c();
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == AJREmbedWebView.this.H) {
                    AJREmbedWebView.this.c();
                    if (!AJREmbedWebView.this.isFinishing() && AJREmbedWebView.this.s.equalsIgnoreCase("downloadinvoice") && AJREmbedWebView.this.f23494d) {
                        AJREmbedWebView.this.finish();
                    }
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f23491a;

    /* renamed from: b  reason: collision with root package name */
    protected String f23492b;

    /* renamed from: c  reason: collision with root package name */
    protected WebView f23493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23494d = true;
    private final int o = 201;
    private Resources p;
    private boolean q = true;
    private boolean r = false;
    /* access modifiers changed from: private */
    public String s;
    private boolean t = false;
    private boolean u = false;
    private String v;
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public boolean y = false;
    /* access modifiers changed from: private */
    public boolean z = false;

    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(context);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        q.a(this);
        this.f23518h = (FrameLayout) findViewById(R.id.content_frame);
        this.f23518h.addView(getLayoutInflater().inflate(R.layout.pre_f_activity_embed_web_view_layout, (ViewGroup) null));
        this.f23491a = (ProgressBar) findViewById(R.id.progressBar);
        if (this.m != null) {
            this.n = true;
            this.m.c();
        }
        if (getIntent() != null && getIntent().hasExtra(UpiConstants.FROM)) {
            this.s = getIntent().getStringExtra(UpiConstants.FROM);
        }
        try {
            if (!TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase("Offers")) {
                this.f23491a.setVisibility(8);
                this.A = getIntent().getStringExtra("HTML_STRING");
                this.f23493c = (WebView) findViewById(R.id.order_datails_webiew);
                this.f23493c.getSettings().setJavaScriptEnabled(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f23493c.setLayerType(2, (Paint) null);
                } else {
                    this.f23493c.setLayerType(1, (Paint) null);
                }
                this.f23493c.loadDataWithBaseURL("", this.A, "text/html", AppConstants.UTF_8, "");
                return;
            }
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
        this.p = getResources();
        Intent intent = getIntent();
        CJRItem cJRItem = (intent == null || !intent.hasExtra("extra_home_data")) ? null : (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            this.f23492b = cJRItem.getURL().trim();
            str = cJRItem.getName();
        } else {
            str = null;
        }
        if (intent != null && intent.hasExtra("url")) {
            this.f23492b = intent.getStringExtra("url");
        }
        if (intent != null && intent.hasExtra("title")) {
            str = intent.getStringExtra("title");
            setTitle(str);
        }
        if (intent != null && intent.hasExtra("url_post_data")) {
            this.v = intent.getStringExtra("url_post_data");
        }
        if (intent != null && intent.hasExtra("fromTrain")) {
            this.D = intent.getBooleanExtra("fromTrain", true);
        }
        if (intent != null && intent.hasExtra("is_url_to_post")) {
            this.w = intent.getBooleanExtra("is_url_to_post", false);
        }
        if (intent != null && intent.hasExtra(net.one97.paytmflight.common.b.b.f30016f)) {
            this.E = (HashMap) intent.getSerializableExtra(net.one97.paytmflight.common.b.b.f30016f);
        }
        if (getString(R.string.auto_add_money).equalsIgnoreCase(str)) {
            this.C = true;
            setTitle(str);
        }
        this.f23493c = (WebView) findViewById(R.id.order_datails_webiew);
        this.f23493c.setWebViewClient(new a(this, (byte) 0));
        this.f23493c.getSettings().setBuiltInZoomControls(true);
        this.f23493c.getSettings().setJavaScriptEnabled(true);
        this.f23493c.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f23493c.setLayerType(2, (Paint) null);
        } else {
            this.f23493c.setLayerType(1, (Paint) null);
        }
        this.f23493c.getSettings().setTextZoom(100);
        this.f23493c.getSettings().setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f23493c.getSettings().setMixedContentMode(0);
        }
        this.f23493c.getSettings().setDomStorageEnabled(true);
        this.f23493c.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f23493c.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f23493c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f23493c.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = AJREmbedWebView.this.B = str.trim();
                AJREmbedWebView.a(AJREmbedWebView.this);
            }
        });
        if (!TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase("Contingency")) {
            this.x = true;
            getIntent().getStringExtra("title");
        }
        if (!TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase("File TDR")) {
            this.y = true;
        }
        if (!TextUtils.isEmpty(this.s) && this.s.equalsIgnoreCase("Cancel")) {
            this.z = true;
        }
        b.a();
        String M = b.b().M();
        if (TextUtils.isEmpty(M)) {
            M = "digitalcredit";
        }
        if (!TextUtils.isEmpty(com.travel.flight.flightorder.i.a.a(getApplicationContext())) || TextUtils.isEmpty(this.f23492b) || !this.f23492b.contains(M)) {
            d();
        } else {
            Intent intent2 = new Intent();
            b.a();
            b.b().a((Context) this, intent2, 111);
        }
        b.a();
        this.F = b.b().N();
    }

    private void d() {
        String str;
        if (!TextUtils.isEmpty(this.f23492b)) {
            if (b(this.f23492b)) {
                if (this.E == null) {
                    this.E = new HashMap<>();
                }
                this.E.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.travel.flight.flightorder.i.a.a(getApplicationContext()));
            }
            if (!this.x && !this.y) {
                this.f23492b = c.a(this, this.f23492b, "webview", "1");
            }
            if (!this.w || (str = this.v) == null) {
                HashMap<String, String> hashMap = this.E;
                if (hashMap != null) {
                    this.f23493c.loadUrl(this.f23492b, hashMap);
                } else {
                    this.f23493c.loadUrl(this.f23492b);
                }
            } else {
                this.f23493c.postUrl(this.f23492b, str.getBytes());
            }
        }
        e();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && i3 == -1) {
            d();
        } else if (i2 == 201 && i3 == -1 && intent != null) {
            intent.getStringExtra("branch_share_url");
            b.a();
            b.b();
        }
    }

    private static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
            b.a();
            List<String> O = b.b().O();
            if (O != null) {
                for (int i2 = 0; i2 < O.size(); i2++) {
                    if (!TextUtils.isEmpty(O.get(i2)) && uri.contains(O.get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void e() {
        this.r = getIntent().getBooleanExtra("Maintenance", false);
        this.t = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.t) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                com.paytm.utility.b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (this.x) {
            this.q = getIntent().getBooleanExtra("Close", true);
            if (this.q) {
                return;
            }
            return;
        }
        this.q = true;
    }

    /* access modifiers changed from: private */
    public void f() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrl(i.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        b.a();
        b.b().b(this, intent);
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    public synchronized void c(String str) {
        if (!isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra(UpiConstants.FROM, "Payment");
            intent.putExtra("order_id", str);
            intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, false);
            b.a();
            b.b().c(this, intent);
            finish();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        a();
        b();
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!net.one97.paytmflight.common.b.b.k) {
            return false;
        }
        net.one97.paytmflight.common.b.b.k = false;
        getMenuInflater().inflate(R.menu.pre_f_webview_menu, menu);
        new Handler().post(new Runnable() {
            public final void run() {
                AJREmbedWebView.this.findViewById(R.id.share_link);
                try {
                    com.paytm.b.a.a a2 = i.a(AJREmbedWebView.this.getApplicationContext());
                    if (!a2.b("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", false, true)) {
                        a2.a("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", true, true);
                    }
                } catch (Exception unused) {
                }
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.share_link) {
            if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                i();
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 375);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void g() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, GAUtil.CUSTOM_EVENT);
            hashMap.put("event_category", "scan_qr_code");
            hashMap.put("event_action", "scan_result_share_initiated");
            hashMap.put("vertical_name", "wallet");
            hashMap.put("event_label", this.f23492b);
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            b.a();
            b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        if (this.f23492b.contains("?isAppLink=true")) {
            if (!TextUtils.isEmpty(this.f23492b)) {
                String str = null;
                if (this.f23492b.contains("bus-tickets")) {
                    str = "paytmmp://busticket";
                }
                if (this.f23492b.contains("flights")) {
                    str = "paytmmp://flightticket";
                }
                b.a();
                b.b().a((Context) this, str);
            }
        } else if (this.t) {
            f();
        } else if (this.f23493c.canGoBack()) {
            this.f23493c.goBack();
        } else if (TextUtils.isEmpty(this.s) || !this.s.equalsIgnoreCase("kyc")) {
            super.onBackPressed();
        } else {
            f();
        }
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        com.paytm.utility.b.u();
        if (this.x) {
            finish();
        }
    }

    public void onDestroy() {
        try {
            this.f23493c.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        AJREmbedWebView.this.f23493c.destroy();
                    } catch (Exception unused) {
                    }
                }
            }, 1000);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 56) {
            if (s.a(iArr)) {
                h();
            } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ boolean f23498a = true;

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (this.f23498a) {
                                s.b(AJREmbedWebView.this.getApplicationContext());
                                AJREmbedWebView.this.finish();
                                return;
                            }
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                AJREmbedWebView.this.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                com.paytm.utility.q.b(e2.getMessage());
                                AJREmbedWebView.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }
                    });
                    builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    builder.show();
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                }
            }
        }
        if (i2 != 375) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            com.paytm.utility.b.b((Context) this, "", getString(R.string.please_go_to_settings_external_storage));
        } else {
            i();
        }
    }

    private void h() {
        if (this.B != null) {
            try {
                if (this.s.equalsIgnoreCase("downloadinvoice") && this.f23494d) {
                    registerReceiver(this.I, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.B));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                String str = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalPublicDir(str, "myPDFfile" + SystemClock.currentThreadTimeMillis() + ".pdf");
                this.G = (DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                this.H = this.G.enqueue(request);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2, getResources().getString(com.travel.flight.R.string.no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0035
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0035 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "application/pdf"
            r0.setDataAndType(r3, r1)     // Catch:{ Exception -> 0x0035 }
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0035 }
            r3 = 1
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0035 }
            r2.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0022 }
            r2.finish()     // Catch:{ ActivityNotFoundException -> 0x0022 }
            return
        L_0x0022:
            android.content.res.Resources r3 = r2.getResources()     // Catch:{ Exception -> 0x0035 }
            int r0 = com.travel.flight.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x0035 }
            r0 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ Exception -> 0x0035 }
            r3.show()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.activity.AJREmbedWebView.a(java.lang.String):void");
    }

    private void i() {
        g();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.f23493c.getWidth(), this.f23493c.getHeight(), Bitmap.Config.ARGB_8888);
            this.f23493c.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.qr_code_scanned_using_paytm) + StringUtility.NEW_LINE + this.f23492b);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.web_view_share_url));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
    }

    class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(AJREmbedWebView aJREmbedWebView, byte b2) {
            this();
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TextUtils.isEmpty(AJREmbedWebView.this.s) || !AJREmbedWebView.this.x) {
                if (str != null && (str.toLowerCase().contains(SDKConstants.PG_CALL_BACK) || (!TextUtils.isEmpty(AJREmbedWebView.this.F) && str.contains(AJREmbedWebView.this.F)))) {
                    if (str.equalsIgnoreCase("http://trans-null/") || str.equalsIgnoreCase("http://trans-0/")) {
                        AJREmbedWebView.h(AJREmbedWebView.this);
                    } else {
                        AJREmbedWebView.this.c(new String(str).replace(AJREmbedWebView.this.F, "").replace("/", ""));
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJREmbedWebView.this.f();
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AJREmbedWebView.this.f23491a.setVisibility(8);
            if (AJREmbedWebView.this.C) {
                return;
            }
            if (AJREmbedWebView.this.z) {
                AJREmbedWebView.this.setTitle("Cancel");
            } else if (AJREmbedWebView.this.y) {
                AJREmbedWebView.this.setTitle("File TDR");
            } else {
                AJREmbedWebView.this.setTitle(webView.getTitle());
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String substring;
            try {
                if (Uri.parse(str).getScheme().equals("market")) {
                    int indexOf = str.indexOf("paytmmp:");
                    if (indexOf == -1) {
                        AJREmbedWebView.c(AJREmbedWebView.this, str);
                        return true;
                    } else if (indexOf < str.length() && (substring = str.substring(indexOf)) != null) {
                        b.a();
                        b.b().a(AJREmbedWebView.this.getApplicationContext(), substring);
                        return true;
                    }
                } else if (Uri.parse(str).getScheme().equals("paytmmp")) {
                    b.a();
                    b.b();
                    b.a();
                    b.b().a(AJREmbedWebView.this.getApplicationContext(), str);
                    return true;
                } else if (str.startsWith("tel:")) {
                    AJREmbedWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } else if (str.equals("https://paytmmall.com/")) {
                    b.a();
                    b.b();
                } else if (str.contains("twitter.com")) {
                    if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, net.one97.paytmflight.common.b.b.f30017g)) {
                        AJREmbedWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                } else if (!str.contains("whatsapp://send")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                } else {
                    if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, net.one97.paytmflight.common.b.b.j)) {
                        AJREmbedWebView.e(AJREmbedWebView.this, Uri.parse(str).getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
                        return true;
                    }
                    com.paytm.utility.b.b((Context) AJREmbedWebView.this, "", AJREmbedWebView.this.getString(R.string.msg_no_whatsapp));
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    com.paytm.utility.q.b(e2.getMessage());
                }
                return false;
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }
    }

    static /* synthetic */ void a(AJREmbedWebView aJREmbedWebView) {
        if (!s.a() || s.c((Activity) aJREmbedWebView)) {
            aJREmbedWebView.h();
        } else {
            s.b((Activity) aJREmbedWebView);
        }
    }

    static /* synthetic */ void h(AJREmbedWebView aJREmbedWebView) {
        Intent intent = new Intent();
        intent.putExtra("is_payment", true);
        b.a();
        b.b().g(aJREmbedWebView, intent);
        aJREmbedWebView.finish();
    }

    static /* synthetic */ void c(AJREmbedWebView aJREmbedWebView, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(aJREmbedWebView.getPackageManager()) != null) {
                aJREmbedWebView.startActivity(intent);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void e(AJREmbedWebView aJREmbedWebView, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        intent.setPackage(net.one97.paytmflight.common.b.b.j);
        aJREmbedWebView.startActivity(intent);
    }
}
