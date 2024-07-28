package com.travel.bus.common;

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
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.activity.CJRActionBarBaseActivity;
import com.travel.bus.busticket.i.h;
import com.travel.bus.busticket.i.p;
import com.travel.bus.busticket.i.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class AJREmbedWebView extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f22518a;

    /* renamed from: b  reason: collision with root package name */
    protected String f22519b;

    /* renamed from: c  reason: collision with root package name */
    protected WebView f22520c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22521d = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f22522e = 201;

    /* renamed from: f  reason: collision with root package name */
    private Resources f22523f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22524g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22525h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f22526i;
    private boolean j = false;
    private boolean k = false;
    private String l;
    private boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    private String q;
    /* access modifiers changed from: private */
    public String r;
    /* access modifiers changed from: private */
    public boolean s;
    private boolean t = false;
    /* access modifiers changed from: private */
    public String u;
    private HashMap<String, String> v = null;
    /* access modifiers changed from: private */
    public String w;
    /* access modifiers changed from: private */
    public DownloadManager x;
    /* access modifiers changed from: private */
    public long y;
    private BroadcastReceiver z = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            final Cursor query2 = AJREmbedWebView.this.x.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    query2.getString(query2.getColumnIndex("title"));
                    if (longExtra != ((long) query2.getInt(0)) || longExtra != AJREmbedWebView.this.y) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                                Cursor cursor = query2;
                                aJREmbedWebView.a(cursor.getString(cursor.getColumnIndex("local_uri")));
                                AJREmbedWebView.this.removeProgressDialog();
                            }
                        }, 10000);
                        return;
                    }
                    AJREmbedWebView.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                    AJREmbedWebView.this.removeProgressDialog();
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == AJREmbedWebView.this.y) {
                    AJREmbedWebView.this.removeProgressDialog();
                    if (!AJREmbedWebView.this.isFinishing() && AJREmbedWebView.this.f22526i.equalsIgnoreCase("downloadinvoice") && AJREmbedWebView.this.f22521d) {
                        AJREmbedWebView.this.finish();
                    }
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        this.mFrameLayout.addView(getLayoutInflater().inflate(R.layout.pre_b_activity_embed_web_view_layout, (ViewGroup) null));
        this.f22518a = (ProgressBar) findViewById(R.id.progressBar);
        setBackButtonEnabled(true);
        if (getIntent() != null && getIntent().hasExtra(UpiConstants.FROM)) {
            this.f22526i = getIntent().getStringExtra(UpiConstants.FROM);
        }
        try {
            if (!TextUtils.isEmpty(this.f22526i) && this.f22526i.equalsIgnoreCase("Offers")) {
                this.f22518a.setVisibility(8);
                this.q = getIntent().getStringExtra("HTML_STRING");
                this.f22520c = (WebView) findViewById(R.id.order_datails_webiew);
                this.f22520c.getSettings().setJavaScriptEnabled(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f22520c.setLayerType(2, (Paint) null);
                } else {
                    this.f22520c.setLayerType(1, (Paint) null);
                }
                this.f22520c.loadDataWithBaseURL("", this.q, "text/html", AppConstants.UTF_8, "");
                return;
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        this.f22523f = getResources();
        Intent intent = getIntent();
        CJRItem cJRItem = (intent == null || !intent.hasExtra("extra_home_data")) ? null : (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            this.f22519b = cJRItem.getURL().trim();
            str = cJRItem.getName();
        } else {
            str = null;
        }
        if (intent != null && intent.hasExtra("url")) {
            this.f22519b = intent.getStringExtra("url");
        }
        if (intent != null && intent.hasExtra("title")) {
            str = intent.getStringExtra("title");
            setTitle(str);
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(getString(R.string.travel_explore_heading))) {
                hideActionBar();
            }
        }
        if (intent != null && intent.hasExtra("url_post_data")) {
            this.l = intent.getStringExtra("url_post_data");
        }
        if (intent != null && intent.hasExtra("fromTrain")) {
            this.t = intent.getBooleanExtra("fromTrain", true);
        }
        if (intent != null && intent.hasExtra("is_url_to_post")) {
            this.m = intent.getBooleanExtra("is_url_to_post", false);
        }
        if (intent != null && intent.hasExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
            str = intent.getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            if (str.equalsIgnoreCase("Paytm Postpaid")) {
                this.u = str;
            }
        }
        if (intent != null && intent.hasExtra(e.I)) {
            this.v = (HashMap) intent.getSerializableExtra(e.I);
        }
        if (getString(R.string.auto_add_money).equalsIgnoreCase(str)) {
            this.s = true;
            setTitle(str);
        }
        this.f22520c = (WebView) findViewById(R.id.order_datails_webiew);
        this.f22520c.setWebViewClient(new a(this, (byte) 0));
        this.f22520c.getSettings().setBuiltInZoomControls(true);
        this.f22520c.getSettings().setJavaScriptEnabled(true);
        this.f22520c.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f22520c.setLayerType(2, (Paint) null);
        } else {
            this.f22520c.setLayerType(1, (Paint) null);
        }
        this.f22520c.getSettings().setTextZoom(100);
        this.f22520c.getSettings().setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f22520c.getSettings().setMixedContentMode(0);
        }
        this.f22520c.getSettings().setDomStorageEnabled(true);
        this.f22520c.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f22520c.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f22520c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f22520c.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = AJREmbedWebView.this.r = str.trim();
                AJREmbedWebView.a(AJREmbedWebView.this);
            }
        });
        if (!TextUtils.isEmpty(this.f22526i) && this.f22526i.equalsIgnoreCase("Contingency")) {
            this.n = true;
            getIntent().getStringExtra("title");
        }
        if (!TextUtils.isEmpty(this.f22526i) && this.f22526i.equalsIgnoreCase("File TDR")) {
            this.o = true;
        }
        if (!TextUtils.isEmpty(this.f22526i) && this.f22526i.equalsIgnoreCase("Cancel")) {
            this.p = true;
        }
        com.travel.bus.a.a();
        String K = com.travel.bus.a.b().K();
        if (TextUtils.isEmpty(K)) {
            K = "digitalcredit";
        }
        if (!TextUtils.isEmpty(p.a(getApplicationContext())) || TextUtils.isEmpty(this.f22519b) || !this.f22519b.contains(K)) {
            a();
        } else {
            Intent intent2 = new Intent();
            com.travel.bus.a.a();
            com.travel.bus.a.b().a((Context) this, intent2, 111);
        }
        com.travel.bus.a.a();
        this.w = com.travel.bus.a.b().L();
    }

    private void a() {
        String str;
        if (!TextUtils.isEmpty(this.f22519b)) {
            if (b(this.f22519b)) {
                if (this.v == null) {
                    this.v = new HashMap<>();
                }
                this.v.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, p.a(getApplicationContext()));
            }
            if (!this.n && !this.o) {
                this.f22519b = c.a(this, this.f22519b, "webview", "1");
            }
            if (!this.m || (str = this.l) == null) {
                HashMap<String, String> hashMap = this.v;
                if (hashMap != null) {
                    this.f22520c.loadUrl(this.f22519b, hashMap);
                } else {
                    this.f22520c.loadUrl(this.f22519b);
                }
            } else {
                this.f22520c.postUrl(this.f22519b, str.getBytes());
            }
        }
        b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && i3 == -1) {
            a();
        } else if (i2 == 201 && i3 == -1 && intent != null) {
            intent.getStringExtra("branch_share_url");
            com.travel.bus.a.a();
            com.travel.bus.a.b();
        }
    }

    private static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
            com.travel.bus.a.a();
            List<String> M = com.travel.bus.a.b().M();
            if (M != null) {
                for (int i2 = 0; i2 < M.size(); i2++) {
                    if (!TextUtils.isEmpty(M.get(i2)) && uri.contains(M.get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void b() {
        this.f22525h = getIntent().getBooleanExtra("Maintenance", false);
        this.j = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.j) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (this.n) {
            this.f22524g = getIntent().getBooleanExtra("Close", true);
        } else {
            this.f22524g = true;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        com.travel.bus.a.a();
        cJRHomePageItem.setUrl(com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent);
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
            com.travel.bus.a.a();
            com.travel.bus.a.b().b((Context) this, intent);
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!h.f22435c) {
            return false;
        }
        h.f22435c = false;
        getMenuInflater().inflate(R.menu.pre_b_webview_menu, menu);
        new Handler().post(new Runnable() {
            public final void run() {
                AJREmbedWebView.this.findViewById(R.id.share_link);
                try {
                    com.travel.bus.a.a();
                    com.paytm.b.a.a a2 = com.travel.bus.b.a.a(com.travel.bus.a.b().D());
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
                f();
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 375);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void d() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, GAUtil.CUSTOM_EVENT);
            hashMap.put("event_category", "scan_qr_code");
            hashMap.put("event_action", "scan_result_share_initiated");
            hashMap.put("vertical_name", "wallet");
            hashMap.put("event_label", this.f22519b);
            hashMap.put("user_id", b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f22519b
            java.lang.String r1 = "?isAppLink=true"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = r4.f22519b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0081
            java.lang.String r0 = r4.f22519b
            java.lang.String r1 = "bus-tickets"
            boolean r0 = r0.contains(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = "paytmmp://busticket"
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.lang.String r2 = r4.f22519b
            java.lang.String r3 = "flights"
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x002d
            java.lang.String r0 = "paytmmp://flightticket"
        L_0x002d:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0081
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = com.travel.bus.busticket.i.u.a(r4, r0)
            if (r0 == 0) goto L_0x0081
            com.travel.bus.a.a()
            com.travel.bus.a.b()
            r0.getURLType()
            java.lang.String r2 = "extra_home_data"
            r1.putExtra(r2, r0)
            java.lang.String r0 = "origin"
            java.lang.String r2 = "deeplinking"
            r1.putExtra(r0, r2)
            r4.startActivity(r1)
            goto L_0x0081
        L_0x0052:
            boolean r0 = r4.j
            if (r0 == 0) goto L_0x005a
            r4.c()
            goto L_0x0081
        L_0x005a:
            android.webkit.WebView r0 = r4.f22520c
            boolean r0 = r0.canGoBack()
            if (r0 == 0) goto L_0x0068
            android.webkit.WebView r0 = r4.f22520c
            r0.goBack()
            goto L_0x0081
        L_0x0068:
            java.lang.String r0 = r4.f22526i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = r4.f22526i
            java.lang.String r1 = "kyc"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x007e
            r4.c()
            goto L_0x0081
        L_0x007e:
            super.onBackPressed()
        L_0x0081:
            super.onBackPressed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.common.AJREmbedWebView.onBackPressed():void");
    }

    public void onPause() {
        super.onPause();
        b.u();
        if (this.n) {
            finish();
        }
    }

    public void onDestroy() {
        try {
            this.f22520c.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        AJREmbedWebView.this.f22520c.destroy();
                    } catch (Exception unused) {
                    }
                }
            }, 1000);
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 56) {
            if (s.a(iArr)) {
                e();
            } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ boolean f22530a = true;

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (this.f22530a) {
                                s.b(AJREmbedWebView.this.getApplicationContext());
                                AJREmbedWebView.this.finish();
                                return;
                            }
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                AJREmbedWebView.this.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                q.c(e2.getMessage());
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
                    if (b.v) {
                        q.c(e2.getMessage());
                    }
                }
            }
        }
        if (i2 != 375) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            b.b((Context) this, "", getString(R.string.please_go_to_settings_external_storage));
        } else {
            f();
        }
    }

    private void e() {
        if (this.r != null) {
            try {
                if (this.f22526i.equalsIgnoreCase("downloadinvoice") && this.f22521d) {
                    registerReceiver(this.z, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.r));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                String str = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalPublicDir(str, "myPDFfile" + SystemClock.currentThreadTimeMillis() + ".pdf");
                this.x = (DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                this.y = this.x.enqueue(request);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2, getResources().getString(com.travel.bus.R.string.no_pdf_view_msg), 0).show();
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
            int r0 = com.travel.bus.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x0035 }
            r0 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ Exception -> 0x0035 }
            r3.show()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.common.AJREmbedWebView.a(java.lang.String):void");
    }

    private void f() {
        d();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.f22520c.getWidth(), this.f22520c.getHeight(), Bitmap.Config.ARGB_8888);
            this.f22520c.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.qr_code_scanned_using_paytm) + StringUtility.NEW_LINE + this.f22519b);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.web_view_share_url));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
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
            if (TextUtils.isEmpty(AJREmbedWebView.this.f22526i) || !AJREmbedWebView.this.n) {
                if (str != null && (str.toLowerCase().contains(SDKConstants.PG_CALL_BACK) || (!TextUtils.isEmpty(AJREmbedWebView.this.w) && str.contains(AJREmbedWebView.this.w)))) {
                    if (str.equalsIgnoreCase("http://trans-null/") || str.equalsIgnoreCase("http://trans-0/")) {
                        AJREmbedWebView.h(AJREmbedWebView.this);
                    } else {
                        AJREmbedWebView.this.c(new String(str).replace(AJREmbedWebView.this.w, "").replace("/", ""));
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJREmbedWebView.this.c();
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AJREmbedWebView.this.f22518a.setVisibility(8);
            if (AJREmbedWebView.this.s) {
                return;
            }
            if (!TextUtils.isEmpty(AJREmbedWebView.this.u)) {
                AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                aJREmbedWebView.setTitle(aJREmbedWebView.u);
            } else if (AJREmbedWebView.this.p) {
                AJREmbedWebView.this.setTitle("Cancel");
            } else if (AJREmbedWebView.this.o) {
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
                        AJREmbedWebView.d(AJREmbedWebView.this, substring);
                        return true;
                    }
                } else if (Uri.parse(str).getScheme().equals("paytmmp")) {
                    com.travel.bus.a.a();
                    if (com.travel.bus.a.b().a(str)) {
                        com.travel.bus.a.a();
                        com.travel.bus.a.b();
                    } else {
                        AJREmbedWebView.d(AJREmbedWebView.this, str);
                    }
                    return true;
                } else if (str.startsWith("tel:")) {
                    AJREmbedWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } else if (str.equals("https://paytmmall.com/")) {
                    com.travel.bus.a.a();
                    com.travel.bus.a.b();
                } else if (str.contains("twitter.com")) {
                    if (b.h((Context) AJREmbedWebView.this, e.O)) {
                        AJREmbedWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                } else if (!str.contains("whatsapp://send")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                } else {
                    if (b.h((Context) AJREmbedWebView.this, e.aV)) {
                        AJREmbedWebView.f(AJREmbedWebView.this, Uri.parse(str).getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
                        return true;
                    }
                    b.b((Context) AJREmbedWebView.this, "", AJREmbedWebView.this.getString(R.string.msg_no_whatsapp));
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
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
            aJREmbedWebView.e();
        } else {
            s.b((Activity) aJREmbedWebView);
        }
    }

    static /* synthetic */ void h(AJREmbedWebView aJREmbedWebView) {
        Intent intent = new Intent();
        intent.putExtra("is_payment", true);
        com.travel.bus.a.a();
        com.travel.bus.a.b().e(aJREmbedWebView, intent);
        aJREmbedWebView.finish();
    }

    static /* synthetic */ void c(AJREmbedWebView aJREmbedWebView, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(aJREmbedWebView.getPackageManager()) != null) {
                aJREmbedWebView.startActivity(intent);
            }
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void d(AJREmbedWebView aJREmbedWebView, String str) {
        CJRHomePageItem a2 = u.a(aJREmbedWebView.getApplicationContext(), str);
        boolean z2 = true;
        Intent intent = null;
        if (a2 != null) {
            com.travel.bus.a.a();
            com.travel.bus.a.b();
            a2.getURLType();
            if ((a2.getURLType() != null && (a2.getURLType().equalsIgnoreCase(EventsModuleManager.MODULE_NAME) || a2.getURLType().equalsIgnoreCase("amusement"))) || a2.getURLType().equalsIgnoreCase("movietickets") || a2.getURLType().equalsIgnoreCase("movies-show-time") || a2.getURLType().equalsIgnoreCase("movie-details") || a2.getURLType().equalsIgnoreCase("busticket")) {
                intent.addFlags(67108864);
                intent.addFlags(268435456);
            }
            if (a2.getURLType() != null && !a2.getURLType().equalsIgnoreCase("external")) {
                intent.putExtra("extra_home_data", a2);
                intent.putExtra("origin", "deeplinking");
            }
            if ("deals".equalsIgnoreCase(a2.getURLType())) {
                intent.putExtra("is_deep_linking_data", true);
            }
        } else {
            com.travel.bus.a.a();
            com.travel.bus.a.b();
        }
        aJREmbedWebView.startActivity(intent);
        if (!aJREmbedWebView.t) {
            if (TextUtils.isEmpty(aJREmbedWebView.f22519b) || !aJREmbedWebView.f22519b.contains("trains/v1/order/retry/initiate")) {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        }
        aJREmbedWebView.finish();
    }

    static /* synthetic */ void f(AJREmbedWebView aJREmbedWebView, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        intent.setPackage(e.aV);
        aJREmbedWebView.startActivity(intent);
    }
}
