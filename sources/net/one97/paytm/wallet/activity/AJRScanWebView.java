package net.one97.paytm.wallet.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.be;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class AJRScanWebView extends PaytmActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f69919a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f69920b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f69921c;

    /* renamed from: d  reason: collision with root package name */
    private String f69922d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f69923e;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scan_web_view_layout);
        this.f69919a = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        setSupportActionBar((Toolbar) findViewById(R.id.scan_webview_toolbar));
        ((ImageView) findViewById(R.id.toolbar_btn_back)).setOnClickListener(this);
        this.f69923e = (ImageView) findViewById(R.id.toolbar_share_btn);
        this.f69923e.setOnClickListener(this);
        this.f69923e.setVisibility(4);
        n.bs = false;
        Intent intent = getIntent();
        if (intent.hasExtra("url")) {
            this.f69922d = intent.getStringExtra("url");
        }
        if (intent != null && intent.hasExtra("KEY_IS_SHARE_VISIBLE") && intent.getBooleanExtra("KEY_IS_SHARE_VISIBLE", false)) {
            this.f69923e.setVisibility(0);
        }
        if (intent != null && intent.hasExtra("KEY_HIDE_TITLE") && intent.getBooleanExtra("KEY_HIDE_TITLE", false)) {
            this.f69923e.setVisibility(8);
            findViewById(R.id.hscrollView).setVisibility(8);
        }
        this.f69920b = (WebView) findViewById(R.id.webiew);
        this.f69920b.setWebViewClient(new a());
        this.f69920b.setWebChromeClient(new WebChromeClient() {
            public final Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
            }
        });
        this.f69920b.getSettings().setBuiltInZoomControls(true);
        this.f69920b.getSettings().setJavaScriptEnabled(true);
        this.f69920b.getSettings().setDomStorageEnabled(true);
        this.f69920b.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = AJRScanWebView.this.f69921c = str;
                AJRScanWebView.a(AJRScanWebView.this);
            }
        });
        String str = this.f69922d;
        if (str != null) {
            this.f69920b.loadUrl(str);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 56) {
            if (s.a(iArr)) {
                a();
            } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ boolean f69926a = true;

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (this.f69926a) {
                                s.b(AJRScanWebView.this.getApplicationContext());
                                AJRScanWebView.this.finish();
                                return;
                            }
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                AJRScanWebView.this.startActivity(intent);
                            } catch (ActivityNotFoundException e2) {
                                q.d(String.valueOf(e2));
                                AJRScanWebView.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
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
                        q.d(String.valueOf(e2));
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
            c();
        }
    }

    private void a() {
        String str = this.f69921c;
        if (str != null) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            String str2 = Environment.DIRECTORY_DOWNLOADS;
            request.setDestinationInExternalPublicDir(str2, "myPDFfile" + SystemClock.currentThreadTimeMillis() + ".pdf");
            ((DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD)).enqueue(request);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.toolbar_btn_back) {
            finish();
        }
        if (view.getId() == R.id.toolbar_share_btn && !TextUtils.isEmpty(this.f69922d)) {
            if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                c();
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 375);
            }
        }
    }

    private void b() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, GAUtil.CUSTOM_EVENT);
            hashMap.put("event_category", "scan_qr_code");
            hashMap.put("event_action", "scan_result_share_initiated");
            hashMap.put("vertical_name", "wallet");
            hashMap.put("event_label", this.f69922d);
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception unused) {
        }
    }

    public class a extends WebViewClient {
        public a() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AJRScanWebView.this.setTitle(str);
            AJRScanWebView.b(AJRScanWebView.this);
            try {
                if (AJRScanWebView.this.getIntent() != null && AJRScanWebView.this.getIntent().hasExtra("KEY_IS_SHARE_VISIBLE") && AJRScanWebView.this.getIntent().getBooleanExtra("KEY_IS_SHARE_VISIBLE", false)) {
                    com.paytm.b.a.a a2 = be.a(AJRScanWebView.this.getApplicationContext());
                    if (!a2.b("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", false, true)) {
                        b.a().showToolTipView(AJRScanWebView.this, AJRScanWebView.this.f69923e, 80, "", androidx.core.content.b.c(AJRScanWebView.this, R.color.color_ebfbff), 0, false);
                        a2.a("IS_WEBVIEW_PREVIOUSLY_OPENED_ENCRYPT", true, true);
                    }
                }
            } catch (Exception unused) {
            }
            AJRScanWebView.this.f69919a.setVisibility(8);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent parseUri;
            try {
                if (AJRScanWebView.b(AJRScanWebView.this, str)) {
                    AJRScanWebView.c(AJRScanWebView.this, str);
                    return true;
                } else if (Uri.parse(str).getScheme().equals("market")) {
                    if (str.indexOf(b.a().getDeeplinkSchemeID() + AppConstants.COLON) != -1) {
                        return false;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        if (intent.resolveActivity(AJRScanWebView.this.getPackageManager()) != null) {
                            AJRScanWebView.this.startActivity(intent);
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                    return true;
                } else {
                    if (!Uri.parse(str).getScheme().equals(b.a().getDeeplinkSchemeID())) {
                        if (!Uri.parse(str).getScheme().equals("intent")) {
                            if (!str.startsWith("tel:")) {
                                return super.shouldOverrideUrlLoading(webView, str);
                            }
                            AJRScanWebView.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                            return true;
                        }
                    }
                    if ((str.startsWith("intent:/") || str.startsWith("intent://")) && (parseUri = Intent.parseUri(str, 1)) != null) {
                        webView.stopLoading();
                        if (AJRScanWebView.this.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                            AJRScanWebView.this.startActivity(parseUri);
                            AJRScanWebView.this.finish();
                        } else {
                            AJRScanWebView.this.a(parseUri.getStringExtra("browser_fallback_url"));
                        }
                    }
                    return true;
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e3));
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void setTitle(CharSequence charSequence) {
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.title);
        if (roboTextView != null) {
            roboTextView.setText(charSequence);
        }
    }

    private void c() {
        b();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
            intent.putExtra("android.intent.extra.TEXT", "");
            Bitmap createBitmap = Bitmap.createBitmap(this.f69920b.getWidth(), this.f69920b.getHeight(), Bitmap.Config.ARGB_8888);
            this.f69920b.draw(new Canvas(createBitmap));
            String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null);
            if (insertImage != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.qr_code_scanned_using_paytm) + StringUtility.NEW_LINE + this.f69922d);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.web_view_share_url));
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    static /* synthetic */ void a(AJRScanWebView aJRScanWebView) {
        if (!s.a() || s.c((Activity) aJRScanWebView)) {
            aJRScanWebView.a();
        } else {
            s.b((Activity) aJRScanWebView);
        }
    }

    static /* synthetic */ void b(AJRScanWebView aJRScanWebView) {
        RelativeLayout relativeLayout = (RelativeLayout) aJRScanWebView.findViewById(R.id.toolbar_layout);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    static /* synthetic */ boolean b(AJRScanWebView aJRScanWebView, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = b.a().getStringFromGTM(aJRScanWebView, "qr_available_schema").split(AppConstants.COMMA);
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!TextUtils.isEmpty(split[i2]) && str.toLowerCase().startsWith(split[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ void c(AJRScanWebView aJRScanWebView, String str) {
        if (TextUtils.isEmpty(str) && aJRScanWebView.isFinishing()) {
            return;
        }
        if (!str.toLowerCase().startsWith("paytmmp:")) {
            aJRScanWebView.a(str);
        } else if (b.a().isBranchShareUrl(str)) {
            b.a().shareBranchLink(aJRScanWebView, true, str);
        } else {
            b.a().handleDeepLink(aJRScanWebView, str, (Bundle) null);
        }
    }
}
