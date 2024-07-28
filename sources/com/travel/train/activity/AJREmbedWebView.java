package com.travel.train.activity;

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
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.c;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.e.a;
import com.travel.train.j.g;
import com.travel.train.j.w;
import com.travel.train.widget.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class AJREmbedWebView extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f25817a;

    /* renamed from: b  reason: collision with root package name */
    protected ProgressBar f25818b;

    /* renamed from: c  reason: collision with root package name */
    protected String f25819c;

    /* renamed from: d  reason: collision with root package name */
    protected WebView f25820d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25821e = true;

    /* renamed from: f  reason: collision with root package name */
    private final int f25822f = 201;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25823g = true;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f25824h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25825i = false;
    private String j;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public boolean q;
    private boolean r = false;
    /* access modifiers changed from: private */
    public String s;
    private HashMap<String, String> t = null;
    /* access modifiers changed from: private */
    public String u;
    /* access modifiers changed from: private */
    public DownloadManager v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public String x = "AJREmbedWebView";
    private BroadcastReceiver y = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            final Cursor query2 = AJREmbedWebView.this.v.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    if (longExtra != ((long) query2.getInt(0)) || longExtra != AJREmbedWebView.this.w) {
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
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == AJREmbedWebView.this.w) {
                    AJREmbedWebView.this.removeProgressDialog();
                    if (!AJREmbedWebView.this.isFinishing() && AJREmbedWebView.this.f25824h.equalsIgnoreCase("downloadinvoice") && AJREmbedWebView.this.f25821e) {
                        AJREmbedWebView.this.finish();
                    }
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_action_bar_layout);
        String string = getResources().getString(R.string.app_name);
        setSupportActionBar((Toolbar) findViewById(R.id.base_toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(string);
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJREmbedWebView.this.a(view);
            }
        });
        this.f25817a = (FrameLayout) findViewById(R.id.content_frame);
        this.f25817a.addView(getLayoutInflater().inflate(R.layout.pre_t_activity_embed_web_view_layout, (ViewGroup) null));
        this.f25818b = (ProgressBar) findViewById(R.id.progressBar);
        if (getIntent() != null && getIntent().hasExtra(UpiConstants.FROM)) {
            this.f25824h = getIntent().getStringExtra(UpiConstants.FROM);
        }
        try {
            if (!TextUtils.isEmpty(this.f25824h) && this.f25824h.equalsIgnoreCase("Offers")) {
                this.f25818b.setVisibility(8);
                this.o = getIntent().getStringExtra("HTML_STRING");
                this.f25820d = (WebView) findViewById(R.id.order_datails_webiew);
                this.f25820d.getSettings().setJavaScriptEnabled(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f25820d.setLayerType(2, (Paint) null);
                } else {
                    this.f25820d.setLayerType(1, (Paint) null);
                }
                this.f25820d.loadDataWithBaseURL("", this.o, "text/html", AppConstants.UTF_8, "");
                return;
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        Intent intent = getIntent();
        CJRItem cJRItem = (intent == null || !intent.hasExtra("extra_home_data")) ? null : (CJRItem) intent.getSerializableExtra("extra_home_data");
        if (cJRItem != null) {
            this.f25819c = cJRItem.getURL().trim();
            str = cJRItem.getName();
        } else {
            str = null;
        }
        if (intent != null && intent.hasExtra("url")) {
            this.f25819c = intent.getStringExtra("url");
        }
        if (intent != null && intent.hasExtra("title")) {
            str = intent.getStringExtra("title");
            setTitle(str);
        }
        if (intent != null && intent.hasExtra("url_post_data")) {
            this.j = intent.getStringExtra("url_post_data");
        }
        if (intent != null && intent.hasExtra("fromTrain")) {
            this.r = intent.getBooleanExtra("fromTrain", true);
        }
        if (intent != null && intent.hasExtra("is_url_to_post")) {
            this.k = intent.getBooleanExtra("is_url_to_post", false);
        }
        if (intent != null && intent.hasExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
            str = intent.getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            if (str.equalsIgnoreCase("Paytm Postpaid")) {
                this.s = str;
            }
        }
        if (intent != null && intent.hasExtra(e.I)) {
            this.t = (HashMap) intent.getSerializableExtra(e.I);
        }
        if (str != null && getResources().getString(R.string.train_auto_add_money).equalsIgnoreCase(str)) {
            this.q = true;
            setTitle(str);
        }
        this.f25820d = (WebView) findViewById(R.id.order_datails_webiew);
        this.f25820d.setWebViewClient(new a(this, (byte) 0));
        this.f25820d.getSettings().setBuiltInZoomControls(true);
        this.f25820d.getSettings().setJavaScriptEnabled(true);
        this.f25820d.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f25820d.setLayerType(2, (Paint) null);
        } else {
            this.f25820d.setLayerType(1, (Paint) null);
        }
        this.f25820d.getSettings().setTextZoom(100);
        this.f25820d.getSettings().setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f25820d.getSettings().setMixedContentMode(0);
        }
        this.f25820d.getSettings().setDomStorageEnabled(true);
        this.f25820d.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f25820d.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f25820d.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f25820d.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = AJREmbedWebView.this.p = str.trim();
                AJREmbedWebView.a(AJREmbedWebView.this);
            }
        });
        if (!TextUtils.isEmpty(this.f25824h) && this.f25824h.equalsIgnoreCase("Contingency")) {
            this.l = true;
        }
        if (!TextUtils.isEmpty(this.f25824h) && this.f25824h.equalsIgnoreCase("File TDR")) {
            this.m = true;
        }
        if (!TextUtils.isEmpty(this.f25824h) && this.f25824h.equalsIgnoreCase("Cancel")) {
            this.n = true;
        }
        b.a();
        String g2 = b.b().g();
        if (TextUtils.isEmpty(g2)) {
            g2 = "digitalcredit";
        }
        if (!TextUtils.isEmpty(com.travel.train.j.e.b(getApplicationContext())) || TextUtils.isEmpty(this.f25819c) || !this.f25819c.contains(g2)) {
            a();
        } else {
            Intent intent2 = new Intent();
            b.a();
            b.b().a((Context) this, intent2, 111);
        }
        b.a();
        this.u = b.b().h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (findViewById(R.id.train_toolbar_title) != null) {
                ((TextView) findViewById(R.id.train_toolbar_title)).setText(charSequence2);
            }
        }
    }

    private void a() {
        String str;
        if (!TextUtils.isEmpty(this.f25819c)) {
            if (b(this.f25819c)) {
                if (this.t == null) {
                    this.t = new HashMap<>();
                }
                this.t.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.travel.train.j.e.b(getApplicationContext()));
            }
            if (!this.l && !this.m) {
                this.f25819c = c.a(this, this.f25819c, "webview", "1");
            }
            if (!this.k || (str = this.j) == null) {
                HashMap<String, String> hashMap = this.t;
                if (hashMap != null) {
                    this.f25820d.loadUrl(this.f25819c, hashMap);
                } else {
                    this.f25820d.loadUrl(this.f25819c);
                }
            } else {
                this.f25820d.postUrl(this.f25819c, str.getBytes());
            }
        }
        b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && i3 == -1) {
            a();
        }
    }

    private static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
            b.a();
            List<String> j2 = b.b().j();
            if (j2 != null) {
                for (int i2 = 0; i2 < j2.size(); i2++) {
                    if (!TextUtils.isEmpty(j2.get(i2)) && uri.contains(j2.get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void b() {
        this.f25825i = getIntent().getBooleanExtra("maintaince_error_503", false);
        if (this.f25825i) {
            String stringExtra = getIntent().getStringExtra("alert_title");
            String stringExtra2 = getIntent().getStringExtra("alert_message");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                com.paytm.utility.b.b((Context) this, stringExtra, stringExtra2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrl(w.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("maintaince_error_503", true);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        b.a();
        b.b().a((Context) this, intent);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!g.w) {
            return false;
        }
        g.w = false;
        getMenuInflater().inflate(R.menu.pre_t_webview_menu, menu);
        new Handler().post(new Runnable() {
            public final void run() {
                com.paytm.b.a.a aVar;
                String str;
                f fVar;
                View findViewById = AJREmbedWebView.this.findViewById(R.id.share_link);
                try {
                    com.paytm.b.a.a a2 = w.a(AJREmbedWebView.this.getApplicationContext());
                    if (!a2.b("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", false, true)) {
                        AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                        int c2 = androidx.core.content.b.c(AJREmbedWebView.this, R.color.color_ebfbff);
                        if (findViewById.getTag() != null) {
                            ((f) findViewById.getTag()).b();
                            findViewById.setTag((Object) null);
                            str = "IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT";
                            aVar = a2;
                        } else {
                            Resources resources = aJREmbedWebView.getResources();
                            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dimen_20dp);
                            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.cart_12sp);
                            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.wallet_3_dp);
                            a.C0487a aVar2 = new a.C0487a();
                            aVar2.f26648b = "";
                            aVar2.p = (LinearLayout) aJREmbedWebView.getLayoutInflater().inflate(R.layout.pre_t_web_view_tooltip, (ViewGroup) null);
                            aVar2.o = 100;
                            aVar2.r = true;
                            aVar2.f26650d = -1;
                            aVar2.f26651e = (float) dimensionPixelSize2;
                            aVar2.f26655i = c2;
                            aVar2.j = dimensionPixelSize;
                            aVar2.k = dimensionPixelSize;
                            aVar2.l = dimensionPixelSize;
                            aVar2.m = dimensionPixelSize;
                            aVar2.n = (float) dimensionPixelSize3;
                            str = "IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT";
                            aVar = a2;
                            com.travel.train.e.a aVar3 = new com.travel.train.e.a(aVar2.f26647a, aVar2.f26648b, aVar2.f26649c, aVar2.f26650d, aVar2.f26651e, aVar2.f26652f, aVar2.f26653g, aVar2.f26654h, aVar2.f26655i, aVar2.j, aVar2.k, aVar2.l, aVar2.m, aVar2.n, aVar2.r, aVar2.p, aVar2.q, aVar2.o, (byte) 0);
                            f.a aVar4 = new f.a(aJREmbedWebView);
                            View view = findViewById;
                            aVar4.f28403b = view;
                            aVar4.f28404c = aVar3;
                            aVar4.f28405d = 80;
                            if (aVar4.f28405d == 8388611 || aVar4.f28405d == 8388613) {
                                if (Build.VERSION.SDK_INT < 17 || aVar4.f28403b.getLayoutDirection() != 1) {
                                    aVar4.f28405d &= 7;
                                } else {
                                    aVar4.f28405d = aVar4.f28405d == 8388611 ? 5 : 3;
                                }
                            }
                            if (!(aVar4.f28405d == 48 || aVar4.f28405d == 80 || aVar4.f28405d == 3)) {
                                if (aVar4.f28405d != 5) {
                                    throw new IllegalArgumentException("Unsupported gravity - " + aVar4.f28405d);
                                }
                            }
                            if (!aVar4.f28404c.o) {
                                fVar = new f(aVar4.f28402a, aVar4.f28403b, aVar4.f28405d, aVar4.f28404c, 0);
                            } else {
                                fVar = new f(aVar4.f28402a, aVar4.f28403b, aVar4.f28405d, aVar4.f28404c, 0);
                            }
                            fVar.a();
                            view.setTag(fVar);
                            fVar.f28390a = new f.b(view) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ View f28376a;

                                {
                                    this.f28376a = r1;
                                }

                                public final void a() {
                                    this.f28376a.setTag((Object) null);
                                }
                            };
                        }
                        aVar.a(str, true, true);
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
            hashMap.put("event_label", this.f25819c);
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            b.a();
            b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        if (this.f25819c.contains("?isAppLink=true")) {
            if (!TextUtils.isEmpty(this.f25819c)) {
                String str = null;
                if (this.f25819c.contains("bus-tickets")) {
                    str = "paytmmp://busticket";
                }
                if (this.f25819c.contains("flights")) {
                    str = "paytmmp://flightticket";
                }
                if (this.f25819c.contains("train")) {
                    str = "paytmmp://trainticket";
                }
                if (!TextUtils.isEmpty(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("origin", "deeplinking");
                    b.a();
                    b.b().a((Context) this, str, bundle);
                }
            }
        } else if (this.f25825i) {
            c();
        } else if (this.f25820d.canGoBack()) {
            this.f25820d.goBack();
        } else if (TextUtils.isEmpty(this.f25824h) || !this.f25824h.equalsIgnoreCase("kyc")) {
            super.onBackPressed();
        } else {
            c();
        }
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        com.paytm.utility.b.u();
        if (this.l) {
            finish();
        }
    }

    public void onDestroy() {
        try {
            this.f25820d.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        AJREmbedWebView.this.f25820d.destroy();
                    } catch (Exception unused) {
                    }
                }
            }, 1000);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
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
                        final /* synthetic */ boolean f25829a = true;

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (this.f25829a) {
                                s.b(AJREmbedWebView.this.getApplicationContext());
                                AJREmbedWebView.this.finish();
                                return;
                            }
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                AJREmbedWebView.this.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                String unused = AJREmbedWebView.this.x;
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
                    if (com.paytm.utility.b.v) {
                        q.c(e2.getMessage());
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
            f();
        }
    }

    private void e() {
        if (this.p != null) {
            try {
                if (this.f25824h.equalsIgnoreCase("downloadinvoice") && this.f25821e) {
                    registerReceiver(this.y, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.p));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                String str = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalPublicDir(str, "myPDFfile" + SystemClock.currentThreadTimeMillis() + ".pdf");
                this.v = (DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                this.w = this.v.enqueue(request);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2, getResources().getString(com.travel.train.R.string.no_pdf_view_msg), 0).show();
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
            int r0 = com.travel.train.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x0035 }
            r0 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ Exception -> 0x0035 }
            r3.show()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJREmbedWebView.a(java.lang.String):void");
    }

    private void f() {
        d();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.f25820d.getWidth(), this.f25820d.getHeight(), Bitmap.Config.ARGB_8888);
            this.f25820d.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.qr_code_scanned_using_paytm) + StringUtility.NEW_LINE + this.f25819c);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.web_view_share_url));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
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
            if (TextUtils.isEmpty(AJREmbedWebView.this.f25824h) || !AJREmbedWebView.this.l) {
                if (str != null && (str.toLowerCase().contains(SDKConstants.PG_CALL_BACK) || (!TextUtils.isEmpty(AJREmbedWebView.this.u) && str.contains(AJREmbedWebView.this.u)))) {
                    if (str.equalsIgnoreCase("http://trans-null/") || str.equalsIgnoreCase("http://trans-0/")) {
                        AJREmbedWebView.i(AJREmbedWebView.this);
                    } else {
                        AJREmbedWebView.this.c(str.replace(AJREmbedWebView.this.u, "").replace("/", ""));
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
            AJREmbedWebView.this.f25818b.setVisibility(8);
            if (AJREmbedWebView.this.q) {
                return;
            }
            if (!TextUtils.isEmpty(AJREmbedWebView.this.s)) {
                AJREmbedWebView aJREmbedWebView = AJREmbedWebView.this;
                aJREmbedWebView.setTitle(aJREmbedWebView.s);
            } else if (AJREmbedWebView.this.n) {
                AJREmbedWebView.this.setTitle("Cancel");
            } else if (AJREmbedWebView.this.m) {
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
                    AJREmbedWebView.d(AJREmbedWebView.this, str);
                    return true;
                } else if (str.startsWith("tel:")) {
                    AJREmbedWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } else if (str.equals("https://paytmmall.com/")) {
                    b.a();
                    b.b();
                } else if (str.contains("twitter.com")) {
                    if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, e.O)) {
                        AJREmbedWebView.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                } else if (!str.contains("whatsapp://send")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                } else {
                    if (com.paytm.utility.b.h((Context) AJREmbedWebView.this, e.aV)) {
                        AJREmbedWebView.f(AJREmbedWebView.this, Uri.parse(str).getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
                        return true;
                    }
                    com.paytm.utility.b.b((Context) AJREmbedWebView.this, "", AJREmbedWebView.this.getString(R.string.msg_no_whatsapp));
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    String unused = AJREmbedWebView.this.x;
                    q.c(e2.getMessage());
                }
                return false;
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && str.contains("paytm.com/papi/postpaid/v1/user/submitLead")) {
                w.a(AJREmbedWebView.this.getApplicationContext()).a("isCreditCard", true, true);
            }
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

    static /* synthetic */ void i(AJREmbedWebView aJREmbedWebView) {
        Intent intent = new Intent();
        intent.putExtra("is_payment", true);
        b.a();
        b.b().b(aJREmbedWebView, intent);
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
                q.c(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void d(AJREmbedWebView aJREmbedWebView, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.FROM, "deeplinking");
        b.a();
        b.b().a((Context) aJREmbedWebView, str, bundle);
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
