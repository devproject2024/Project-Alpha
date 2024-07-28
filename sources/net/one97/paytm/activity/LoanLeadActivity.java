package net.one97.paytm.activity;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.c;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.model.LoanEnabledData;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.utils.an;

public class LoanLeadActivity extends PaytmActivity {

    /* renamed from: c  reason: collision with root package name */
    private static String f52269c = "/loan-home";

    /* renamed from: d  reason: collision with root package name */
    private static String f52270d = "";

    /* renamed from: i  reason: collision with root package name */
    private static Bundle f52271i;

    /* renamed from: a  reason: collision with root package name */
    Uri f52272a;

    /* renamed from: b  reason: collision with root package name */
    WebView f52273b;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f52274e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f52275f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f52276g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52277h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_loan_lead_actvitiy);
        this.f52277h = (ProgressBar) findViewById(R.id.progressbar);
        if (a.p(this)) {
            c.a();
            if (c.a("loanLeadEnabled", true)) {
                if (getIntent() == null || getIntent().getData() == null) {
                    this.f52277h.setVisibility(0);
                    c.a();
                    String a2 = c.a("loanLeadEnabledUrl", (String) null);
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "https://loanleads.paytm.com/home/isEnabled";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("Accept", "application/json");
                    c.a();
                    String a3 = c.a("loanLeadXToken", (String) null);
                    if (TextUtils.isEmpty(a3)) {
                        a3 = "hellopaytm99554";
                    }
                    c.a();
                    String a4 = c.a("loanLeadSolutionType", (String) null);
                    if (TextUtils.isEmpty(a4)) {
                        a4 = "CONSUMER";
                    }
                    hashMap.put("xtoken", a3);
                    hashMap.put("solutionType", a4);
                    hashMap.put("sso-token", a.q(CJRJarvisApplication.getAppContext()));
                    b bVar = new b();
                    bVar.f42877a = this;
                    bVar.n = a.b.USER_FACING;
                    bVar.f42880d = a2;
                    bVar.f42882f = hashMap;
                    bVar.o = "LoanLeadActivity.java";
                    bVar.f42878b = a.c.P2B;
                    bVar.f42885i = new LoanEnabledData();
                    bVar.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            LoanLeadActivity.this.f52277h.setVisibility(8);
                            LoanEnabledData loanEnabledData = (LoanEnabledData) iJRPaytmDataModel;
                            if (loanEnabledData == null || loanEnabledData.getMeta() == null || !loanEnabledData.getMeta().f53514a.equals("success") || loanEnabledData.getData() == null) {
                                LoanLeadActivity.this.a(false);
                            } else {
                                LoanLeadActivity.this.a(loanEnabledData.getData().f53515a);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            LoanLeadActivity.this.f52277h.setVisibility(8);
                            LoanLeadActivity.this.a(false);
                        }
                    };
                    bVar.l = true;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.l().a();
                    return;
                }
                a(true);
                return;
            }
        }
        a(false);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f52273b = (WebView) findViewById(R.id.webView);
            b();
            return;
        }
        if (f52271i == null) {
            f52271i = getIntent().getExtras();
        }
        a();
    }

    private void a() {
        if (f52271i != null) {
            Intent intent = new Intent(this, AJRRechargeUtilityActivity.class);
            intent.putExtras(f52271i);
            startActivity(intent);
        }
        finish();
    }

    private void b() {
        this.f52273b.setWebChromeClient(new WebChromeClient());
        this.f52273b.getSettings().setDomStorageEnabled(true);
        this.f52273b.getSettings().setJavaScriptEnabled(true);
        this.f52273b.addJavascriptInterface(new an(this), "JSReceiver");
        this.f52273b.setWebViewClient(new WebViewClient() {
            public final void onPageFinished(WebView webView, String str) {
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
                return true;
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1 && i3 == -1) {
            intent.getExtras().get("data");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("pic_uri", this.f52272a);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f52272a = (Uri) bundle.getParcelable("pic_uri");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 107) {
            Iterator<String> it2 = this.f52274e.iterator();
            while (true) {
                Uri uri = null;
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (!(Build.VERSION.SDK_INT > 22) || Build.VERSION.SDK_INT < 23 || checkSelfPermission(next) == 0) {
                    File externalCacheDir = getExternalCacheDir();
                    if (externalCacheDir != null) {
                        uri = Uri.fromFile(new File(externalCacheDir.getPath(), "profile.jpeg"));
                    }
                    ArrayList arrayList = new ArrayList();
                    PackageManager packageManager = getPackageManager();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    for (ResolveInfo next2 : packageManager.queryIntentActivities(intent, 0)) {
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(new ComponentName(next2.activityInfo.packageName, next2.activityInfo.name));
                        intent2.setPackage(next2.activityInfo.packageName);
                        if (uri != null) {
                            intent2.putExtra("output", uri);
                        }
                        arrayList.add(intent2);
                    }
                    startActivityForResult(Intent.createChooser(intent, "Select source"), 1);
                } else {
                    this.f52275f.add(next);
                }
            }
            if (this.f52275f.size() > 0 && Build.VERSION.SDK_INT >= 23 && shouldShowRequestPermissionRationale(this.f52275f.get(0))) {
                new c.a(this).b((CharSequence) "These permissions are mandatory for this action").a((CharSequence) Payload.RESPONSE_OK, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            LoanLeadActivity loanLeadActivity = LoanLeadActivity.this;
                            loanLeadActivity.requestPermissions((String[]) loanLeadActivity.f52275f.toArray(new String[LoanLeadActivity.this.f52275f.size()]), 107);
                        }
                    }
                }).b((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).a().show();
            }
        }
    }

    public void onPause() {
        super.onPause();
        WebView webView = this.f52273b;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.f52273b;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        WebView webView = this.f52273b;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
        WebView webView = this.f52273b;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }
}
