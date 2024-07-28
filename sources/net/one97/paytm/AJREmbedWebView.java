package net.one97.paytm;

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
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.ac;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.ContextResponse;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.b;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.f;
import net.one97.paytm.utils.m;
import net.one97.paytm.utils.t;

public class AJREmbedWebView extends CJRActionBarBaseActivity {
    private String C;
    private boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public boolean F = false;
    /* access modifiers changed from: private */
    public boolean G = false;
    private String H;
    /* access modifiers changed from: private */
    public String I;
    /* access modifiers changed from: private */
    public boolean J;
    private boolean K = false;
    /* access modifiers changed from: private */
    public String L;
    private HashMap<String, String> M = null;
    /* access modifiers changed from: private */
    public String N;
    /* access modifiers changed from: private */
    public DownloadManager O;
    /* access modifiers changed from: private */
    public long P;
    private String Q = "myPDFfile";
    /* access modifiers changed from: private */
    public String R = "";

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f51339a;

    /* renamed from: b  reason: collision with root package name */
    protected String f51340b;

    /* renamed from: c  reason: collision with root package name */
    protected WebView f51341c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51342d = true;

    /* renamed from: e  reason: collision with root package name */
    BroadcastReceiver f51343e = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|14|15|16) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00ac */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r9, android.content.Intent r10) {
            /*
                r8 = this;
                java.lang.String r9 = "extra_download_id"
                r0 = -1
                long r0 = r10.getLongExtra(r9, r0)
                android.os.Bundle r10 = r10.getExtras()
                android.app.DownloadManager$Query r2 = new android.app.DownloadManager$Query
                r2.<init>()
                r3 = 1
                long[] r4 = new long[r3]
                long r9 = r10.getLong(r9)
                r5 = 0
                r4[r5] = r9
                r2.setFilterById(r4)
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                android.app.DownloadManager r9 = r9.O
                android.database.Cursor r9 = r9.query(r2)
                boolean r10 = r9.moveToFirst()
                if (r10 == 0) goto L_0x010d
                java.lang.String r10 = "status"
                int r10 = r9.getColumnIndex(r10)
                int r10 = r9.getInt(r10)
                r2 = 8
                if (r10 != r2) goto L_0x00d0
                java.lang.String r10 = "title"
                int r10 = r9.getColumnIndex(r10)
                r9.getString(r10)
                int r10 = r9.getInt(r5)
                long r6 = (long) r10
                int r10 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r10 != 0) goto L_0x00cf
                net.one97.paytm.AJREmbedWebView r10 = net.one97.paytm.AJREmbedWebView.this
                long r6 = r10.P
                int r10 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r10 != 0) goto L_0x00cf
                net.one97.paytm.AJREmbedWebView r10 = net.one97.paytm.AJREmbedWebView.this
                java.lang.String r0 = "local_uri"
                int r0 = r9.getColumnIndex(r0)
                java.lang.String r9 = r9.getString(r0)
                boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00c7 }
                if (r0 != 0) goto L_0x00be
                android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r0 = "net.one97.paytm"
                android.content.Context r1 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00c7 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
                r2.<init>()     // Catch:{ Exception -> 0x00c7 }
                r2.append(r0)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r0 = ".provider"
                r2.append(r0)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00c7 }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r9 = r9.getPath()     // Catch:{ Exception -> 0x00c7 }
                r2.<init>(r9)     // Catch:{ Exception -> 0x00c7 }
                android.net.Uri r9 = androidx.core.content.FileProvider.getUriForFile(r1, r0, r2)     // Catch:{ Exception -> 0x00c7 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r1 = "android.intent.action.VIEW"
                r0.<init>(r1)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r1 = "application/pdf"
                r0.setDataAndType(r9, r1)     // Catch:{ Exception -> 0x00c7 }
                r9 = 67108864(0x4000000, float:1.5046328E-36)
                r0.setFlags(r9)     // Catch:{ Exception -> 0x00c7 }
                r0.setFlags(r3)     // Catch:{ Exception -> 0x00c7 }
                r10.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00ac }
                goto L_0x00be
            L_0x00ac:
                android.content.res.Resources r9 = r10.getResources()     // Catch:{ Exception -> 0x00c7 }
                r0 = 2131959730(0x7f131fb2, float:1.9556109E38)
                java.lang.String r9 = r9.getString(r0)     // Catch:{ Exception -> 0x00c7 }
                android.widget.Toast r9 = android.widget.Toast.makeText(r10, r9, r5)     // Catch:{ Exception -> 0x00c7 }
                r9.show()     // Catch:{ Exception -> 0x00c7 }
            L_0x00be:
                android.content.BroadcastReceiver r9 = r10.f51343e     // Catch:{ Exception -> 0x00c7 }
                if (r9 == 0) goto L_0x00c7
                android.content.BroadcastReceiver r9 = r10.f51343e     // Catch:{ Exception -> 0x00c7 }
                r10.unregisterReceiver(r9)     // Catch:{ Exception -> 0x00c7 }
            L_0x00c7:
                r10.finish()
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                r9.m()
            L_0x00cf:
                return
            L_0x00d0:
                r2 = 16
                if (r10 != r2) goto L_0x010d
                int r9 = r9.getInt(r5)
                long r9 = (long) r9
                int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r2 != 0) goto L_0x010d
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                long r9 = r9.P
                int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r2 != 0) goto L_0x010d
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                r9.m()
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                boolean r9 = r9.isFinishing()
                if (r9 != 0) goto L_0x010d
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                java.lang.String r9 = r9.j
                java.lang.String r10 = "downloadinvoice"
                boolean r9 = r9.equalsIgnoreCase(r10)
                if (r9 == 0) goto L_0x010d
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                boolean r9 = r9.f51342d
                if (r9 == 0) goto L_0x010d
                net.one97.paytm.AJREmbedWebView r9 = net.one97.paytm.AJREmbedWebView.this
                r9.finish()
            L_0x010d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJREmbedWebView.AnonymousClass9.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final String f51344f = "appsflyerShare";

    /* renamed from: g  reason: collision with root package name */
    private Resources f51345g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51346h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f51347i = false;
    /* access modifiers changed from: private */
    public String j;
    private boolean k = false;
    private boolean l = false;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.activity_embed_web_view_layout, (ViewGroup) null));
        this.f51339a = (ProgressBar) findViewById(R.id.progressBar);
        o();
        p();
        if (getIntent() != null && getIntent().hasExtra(UpiConstants.FROM)) {
            this.j = getIntent().getStringExtra(UpiConstants.FROM);
        }
        try {
            if (!TextUtils.isEmpty(this.j) && this.j.equalsIgnoreCase("Offers")) {
                this.f51339a.setVisibility(8);
                this.H = getIntent().getStringExtra("HTML_STRING");
                this.f51341c = (WebView) findViewById(R.id.order_datails_webiew);
                this.f51341c.getSettings().setJavaScriptEnabled(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f51341c.setLayerType(2, (Paint) null);
                } else {
                    this.f51341c.setLayerType(1, (Paint) null);
                }
                this.f51341c.loadDataWithBaseURL("", this.H, "text/html", AppConstants.UTF_8, "");
                return;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        r();
        this.f51345g = getResources();
        Intent intent = getIntent();
        CJRItem cJRItem = (intent == null || !intent.hasExtra("extra_home_data")) ? null : (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            this.f51340b = cJRItem.getURL().trim();
            str = cJRItem.getName();
        } else {
            str = null;
        }
        if (intent != null && intent.hasExtra("url")) {
            this.f51340b = intent.getStringExtra("url");
        }
        if (intent != null && intent.hasExtra("title")) {
            str = intent.getStringExtra("title");
            setTitle(str);
        }
        if (intent != null && intent.hasExtra("url_post_data")) {
            this.C = intent.getStringExtra("url_post_data");
        }
        if (intent != null && intent.hasExtra("fromTrain")) {
            this.K = intent.getBooleanExtra("fromTrain", true);
        }
        if (intent != null && intent.hasExtra("is_url_to_post")) {
            this.D = intent.getBooleanExtra("is_url_to_post", false);
        }
        if (intent != null && intent.hasExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
            str = intent.getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            if (str.equalsIgnoreCase("Paytm Postpaid")) {
                this.L = str;
            }
        }
        if (intent != null && intent.hasExtra("postpaidWebViewTitle")) {
            this.R = intent.getStringExtra("postpaidWebViewTitle");
        }
        if (intent != null && intent.hasExtra(b.I)) {
            this.M = (HashMap) intent.getSerializableExtra(b.I);
        }
        if (getString(R.string.auto_add_money).equalsIgnoreCase(str)) {
            this.J = true;
            setTitle(str);
        }
        this.f51341c = (WebView) findViewById(R.id.order_datails_webiew);
        this.f51341c.setWebViewClient(new a(this, (byte) 0));
        this.f51341c.getSettings().setBuiltInZoomControls(true);
        this.f51341c.getSettings().setJavaScriptEnabled(true);
        this.f51341c.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f51341c.setLayerType(2, (Paint) null);
        } else {
            this.f51341c.setLayerType(1, (Paint) null);
        }
        this.f51341c.getSettings().setTextZoom(100);
        this.f51341c.getSettings().setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f51341c.getSettings().setMixedContentMode(0);
        }
        this.f51341c.getSettings().setDomStorageEnabled(true);
        this.f51341c.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f51341c.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f51341c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21 && this.f51341c != null) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.f51341c, true);
        }
        this.f51341c.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = AJREmbedWebView.this.I = str.trim();
                AJREmbedWebView.a(AJREmbedWebView.this);
            }
        });
        if (!TextUtils.isEmpty(this.j) && this.j.equalsIgnoreCase("Contingency")) {
            this.E = true;
            getIntent().getStringExtra("title");
        }
        if (!TextUtils.isEmpty(this.j) && this.j.equalsIgnoreCase("File TDR")) {
            this.F = true;
        }
        if (!TextUtils.isEmpty(this.j) && this.j.equalsIgnoreCase("Cancel")) {
            this.G = true;
        }
        c.a();
        String a2 = c.a("digitalcredit", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "digitalcredit";
        }
        if (!TextUtils.isEmpty(t.b(getApplicationContext())) || TextUtils.isEmpty(this.f51340b) || !this.f51340b.contains(a2)) {
            b();
        } else {
            startActivityForResult(new Intent(this, AJRAuthActivity.class), 111);
        }
        c.a();
        this.N = c.a("shopSummary", (String) null);
    }

    private void b() {
        String str;
        if (getIntent() == null || !getIntent().getBooleanExtra("is_merchant_call", false)) {
            if (!TextUtils.isEmpty(this.f51340b)) {
                if (a(this.f51340b)) {
                    if (this.M == null) {
                        this.M = new HashMap<>();
                    }
                    this.M.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, t.b(getApplicationContext()));
                }
                if (!this.E && !this.F) {
                    this.f51340b = com.paytm.utility.c.a(this, this.f51340b, "webview", "1");
                }
                if (!this.D || (str = this.C) == null) {
                    HashMap<String, String> hashMap = this.M;
                    if (hashMap != null) {
                        this.f51341c.loadUrl(this.f51340b, hashMap);
                    } else {
                        this.f51341c.loadUrl(this.f51340b);
                    }
                } else {
                    this.f51341c.postUrl(this.f51340b, str.getBytes());
                }
            }
            d();
            return;
        }
        this.f51341c.addJavascriptInterface(new ac(new ac.a() {
            public final void a() {
                if (!AJREmbedWebView.this.isFinishing()) {
                    AJREmbedWebView.this.finish();
                }
            }
        }), "CommunicationWindow");
        c();
    }

    private void c() {
        getSupportActionBar().f();
        c.a();
        String a2 = c.a("accept_payment_merchant_context", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("x-auth-ump", "umpapp-3754-36d-aqr-cn7");
            hashMap.put("x-user-token", t.b(getApplicationContext()));
            hashMap.put("Cookie", "XSRF-TOKEN=a182960c-acf5-49b8-8b43-0245577f32fd; SESSION=a9098618-be1a-4b27-8a73-e738cdffb361");
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = a2;
            bVar.f42882f = hashMap;
            bVar.f42885i = new ContextResponse();
            bVar.o = "AJREmbedWebView";
            bVar.n = a.b.SILENT;
            bVar.f42878b = a.c.CASHBACK;
            bVar.f42877a = this;
            bVar.j = new com.paytm.network.listener.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    ContextResponse contextResponse = (ContextResponse) iJRPaytmDataModel;
                    if (contextResponse.getMerchants() != null && contextResponse.getMerchants().size() > 0 && contextResponse.getMerchants().get(0).getMid() != null) {
                        AJREmbedWebView.this.f51341c.loadUrl(AJREmbedWebView.this.f51340b, AJREmbedWebView.b(AJREmbedWebView.this, contextResponse.getMerchants().get(0).getMid()));
                    }
                }
            };
            com.paytm.network.a l2 = bVar.l();
            if (com.paytm.utility.a.m(this)) {
                l2.a();
                this.f51339a.setVisibility(8);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && i3 == -1) {
            b();
        }
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
            c.a();
            List<String> E2 = c.E();
            if (E2 != null) {
                for (int i2 = 0; i2 < E2.size(); i2++) {
                    if (!TextUtils.isEmpty(E2.get(i2)) && uri.contains(E2.get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void d() {
        o();
        this.f51347i = getIntent().getBooleanExtra("Maintenance", false);
        this.k = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.k) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                com.paytm.utility.b.b((Context) this, stringExtra, stringExtra2);
            }
        }
        if (this.E) {
            this.f51346h = getIntent().getBooleanExtra("Close", true);
            if (!this.f51346h) {
                s();
                return;
            }
            return;
        }
        this.f51346h = true;
    }

    /* access modifiers changed from: private */
    public void e() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrl(ag.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent(this, AJRMainActivity.class);
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        startActivity(intent);
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f51339a.setVisibility(8);
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f51339a.setVisibility(8);
        String string = this.f51345g.getString(R.string.network_error_heading);
        com.paytm.utility.b.b((Context) this, string, this.f51345g.getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
    }

    /* access modifiers changed from: private */
    public synchronized void b(String str) {
        if (!isFinishing()) {
            Intent intent = new Intent(this, AJROrderSummaryActivity.class);
            intent.putExtra(UpiConstants.FROM, "Payment");
            intent.putExtra("order_id", str);
            intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, false);
            startActivity(intent);
            finish();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!b.bt) {
            return false;
        }
        b.bt = false;
        getMenuInflater().inflate(R.menu.webview_menu, menu);
        new Handler().post(new Runnable() {
            public final void run() {
                View findViewById = AJREmbedWebView.this.findViewById(R.id.share_link);
                try {
                    com.paytm.b.a.a a2 = ag.a(AJREmbedWebView.this.getApplicationContext());
                    if (!a2.b("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", false, true)) {
                        ab.a(AJREmbedWebView.this, findViewById, 80, "", androidx.core.content.b.c(AJREmbedWebView.this, R.color.color_ebfbff), 0);
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
                v();
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 375);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void f() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, GAUtil.CUSTOM_EVENT);
            hashMap.put("event_category", "scan_qr_code");
            hashMap.put("event_action", "scan_result_share_initiated");
            hashMap.put("vertical_name", "wallet");
            hashMap.put("event_label", this.f51340b);
            hashMap.put("user_id", com.paytm.utility.a.a((Context) this));
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        if (TextUtils.isEmpty(this.f51340b) || !this.f51340b.contains("?isAppLink=true")) {
            if (this.k) {
                e();
            } else if (this.f51341c.canGoBack()) {
                this.f51341c.goBack();
            } else if (TextUtils.isEmpty(this.j) || !this.j.equalsIgnoreCase("kyc")) {
                super.onBackPressed();
            } else {
                e();
            }
        } else if (!TextUtils.isEmpty(this.f51340b)) {
            String str = this.f51340b.contains("bus-tickets") ? "paytmmp://busticket" : null;
            if (this.f51340b.contains("flights")) {
                str = "paytmmp://flightticket";
            }
            h.a aVar = h.f50349a;
            h.a.a(this, str, (Bundle) null);
        }
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        com.paytm.utility.a.k();
        if (this.E) {
            finish();
        }
    }

    public void onDestroy() {
        try {
            this.f51341c.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        AJREmbedWebView.this.f51341c.destroy();
                    } catch (Exception unused) {
                    }
                }
            }, 1000);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 56) {
            if (s.a(iArr)) {
                u();
            } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ boolean f51353a = true;

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (this.f51353a) {
                                s.b(AJREmbedWebView.this.getApplicationContext());
                                AJREmbedWebView.this.finish();
                                return;
                            }
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                AJREmbedWebView.this.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                q.b(e2.getMessage());
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
                        q.b(e2.getMessage());
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
            v();
        }
    }

    private void u() {
        if (this.I != null) {
            try {
                if (this.j != null && this.j.equalsIgnoreCase("downloadinvoice") && this.f51342d) {
                    this.Q = "Invoice_";
                    registerReceiver(this.f51343e, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.I));
                request.addRequestHeader(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, t.b(getApplicationContext()));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                String str = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalFilesDir(this, str, this.Q + SystemClock.currentThreadTimeMillis() + ".pdf");
                this.O = (DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                this.P = this.O.enqueue(request);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void v() {
        f();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.f51341c.getWidth(), this.f51341c.getHeight(), Bitmap.Config.ARGB_8888);
            this.f51341c.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.qr_code_scanned_using_paytm) + StringUtility.NEW_LINE + this.f51340b);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.web_view_share_url));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
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
            if (TextUtils.isEmpty(AJREmbedWebView.this.j) || !AJREmbedWebView.this.E) {
                if (str != null && (str.toLowerCase().contains(SDKConstants.PG_CALL_BACK) || (!TextUtils.isEmpty(AJREmbedWebView.this.N) && str.contains(AJREmbedWebView.this.N)))) {
                    if (str.equalsIgnoreCase("http://trans-null/") || str.equalsIgnoreCase("http://trans-0/")) {
                        AJREmbedWebView.h(AJREmbedWebView.this);
                    } else {
                        AJREmbedWebView.this.b(str.replace(AJREmbedWebView.this.N, "").replace("/", ""));
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            } else {
                AJREmbedWebView.this.e();
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AJREmbedWebView.this.f51339a.setVisibility(8);
            if (AJREmbedWebView.this.J) {
                return;
            }
            if (!TextUtils.isEmpty(AJREmbedWebView.this.L)) {
                AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                aJREmbedWebView.setTitle(aJREmbedWebView.L);
            } else if (AJREmbedWebView.this.G) {
                AJREmbedWebView.this.setTitle("Cancel");
            } else if (AJREmbedWebView.this.F) {
                AJREmbedWebView.this.setTitle("File TDR");
            } else if (!TextUtils.isEmpty(AJREmbedWebView.this.R)) {
                AJREmbedWebView aJREmbedWebView2 = AJREmbedWebView.this;
                aJREmbedWebView2.setTitle(aJREmbedWebView2.R);
            } else if (!TextUtils.isEmpty(AJREmbedWebView.this.A)) {
                AJREmbedWebView aJREmbedWebView3 = AJREmbedWebView.this;
                aJREmbedWebView3.setTitle(aJREmbedWebView3.A);
            } else {
                AJREmbedWebView.this.setTitle(webView.getTitle());
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            String substring;
            try {
                if (Uri.parse(str).getScheme().equals("market")) {
                    int indexOf = str.indexOf("paytmmp:");
                    if (indexOf == -1) {
                        AJREmbedWebView.d(AJREmbedWebView.this, str);
                        return true;
                    } else if (indexOf < str.length() && (substring = str.substring(indexOf)) != null) {
                        AJREmbedWebView.e(AJREmbedWebView.this, substring);
                        return true;
                    }
                } else if (Uri.parse(str).getScheme().equals("paytmmp")) {
                    if ("appsflyerShare".equalsIgnoreCase(Uri.parse(str).getHost())) {
                        AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                        k.c(aJREmbedWebView, "activity");
                        if (!(str == null || (parse = Uri.parse(str)) == null)) {
                            String queryParameter = parse.getQueryParameter("campaign");
                            HashMap hashMap = new HashMap();
                            hashMap.put("af_dp", "paytmmp://" + parse.getQueryParameter("b_key"));
                            m mVar = m.f69757a;
                            m.a(aJREmbedWebView, queryParameter, hashMap, new f.a(parse, str, aJREmbedWebView), 0);
                        }
                    } else {
                        AJREmbedWebView.e(AJREmbedWebView.this, str);
                    }
                    return true;
                } else if (str.startsWith("tel:")) {
                    AJREmbedWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } else if (str.contains("twitter.com")) {
                    if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, b.O)) {
                        AJREmbedWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                } else if (!str.contains("whatsapp://send")) {
                    if (!str.startsWith("intent:/")) {
                        if (!str.startsWith("intent://")) {
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                    }
                    Context context = webView.getContext();
                    Intent parseUri = Intent.parseUri(str, 1);
                    if (parseUri != null) {
                        webView.stopLoading();
                        if (context.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                            context.startActivity(parseUri);
                        } else {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(parseUri.getStringExtra("browser_fallback_url"))));
                        }
                        return true;
                    }
                } else if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, b.aV)) {
                    AJREmbedWebView.g(AJREmbedWebView.this, Uri.parse(str).getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
                    return true;
                } else {
                    com.paytm.utility.b.b((Context) AJREmbedWebView.this, "", AJREmbedWebView.this.getString(R.string.msg_no_whatsapp));
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
                return false;
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && str.contains("paytm.com/papi/postpaid/v1/user/submitLead")) {
                ag.a(AJREmbedWebView.this.getApplicationContext()).a("isCreditCard", true, true);
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    static /* synthetic */ void a(AJREmbedWebView aJREmbedWebView) {
        if (!s.a() || s.c((Activity) aJREmbedWebView)) {
            aJREmbedWebView.u();
        } else {
            s.b((Activity) aJREmbedWebView);
        }
    }

    static /* synthetic */ HashMap b(AJREmbedWebView aJREmbedWebView, String str) {
        HashMap hashMap = new HashMap();
        if (d.b().c(aJREmbedWebView.f51340b) || a(aJREmbedWebView.f51340b)) {
            hashMap.put("x-app-token", t.b(aJREmbedWebView.getApplicationContext()));
        }
        hashMap.put("x-app-mid", str);
        hashMap.put("x-app-client", "android");
        hashMap.put("source", "consumer_app");
        hashMap.put("Accept-Language", n.a((Context) aJREmbedWebView, "en"));
        return hashMap;
    }

    static /* synthetic */ void h(AJREmbedWebView aJREmbedWebView) {
        c.a();
        net.one97.paytm.payments.d.a.a((Activity) aJREmbedWebView, c.ar());
    }

    static /* synthetic */ void d(AJREmbedWebView aJREmbedWebView, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (intent.resolveActivity(aJREmbedWebView.getPackageManager()) != null) {
                aJREmbedWebView.startActivity(intent);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void e(AJREmbedWebView aJREmbedWebView, String str) {
        final CJRHomePageItem a2 = net.one97.paytm.utils.ac.a(aJREmbedWebView.getApplicationContext(), str);
        Bundle a3 = net.one97.paytm.marketplace.a.a((HashMap<String, Serializable>) new HashMap<String, Serializable>() {
            {
                put("extra_home_data", a2);
            }
        });
        h.a aVar = h.f50349a;
        if (!h.a.a(aJREmbedWebView, net.one97.paytm.marketplace.a.a(a2, a2.getURLType()), a3)) {
            if (!aJREmbedWebView.K) {
                if (!(!TextUtils.isEmpty(aJREmbedWebView.f51340b) && aJREmbedWebView.f51340b.contains("trains/v1/order/retry/initiate"))) {
                    return;
                }
            }
            aJREmbedWebView.finish();
        }
    }

    static /* synthetic */ void g(AJREmbedWebView aJREmbedWebView, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        intent.setPackage(b.aV);
        aJREmbedWebView.startActivity(intent);
    }
}
