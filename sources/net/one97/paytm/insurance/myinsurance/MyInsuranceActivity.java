package net.one97.paytm.insurance.myinsurance;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import net.one97.paytm.common.entity.insurance.SelectQuoteResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.activities.InsuranceBaseActivity;
import net.one97.paytm.insurance.common.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MyInsuranceActivity extends InsuranceBaseActivity implements com.paytm.network.listener.b {

    /* renamed from: h  reason: collision with root package name */
    private static final String f14036h = MyInsuranceActivity.class.getSimpleName();
    /* access modifiers changed from: private */
    public static int l = -1;

    /* renamed from: a  reason: collision with root package name */
    private String f14037a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14038b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final int f14039c = 3;

    /* renamed from: d  reason: collision with root package name */
    private File f14040d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f14041e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WebView f14042f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f14043g;

    /* renamed from: i  reason: collision with root package name */
    private final c f14044i = new c(this);
    /* access modifiers changed from: private */
    public Handler j;
    private Uri k;
    private a m;
    private boolean n = false;
    private boolean o = true;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> p;
    private ValueCallback<Uri> q;
    private d r;
    private net.one97.paytm.insurance.common.a.a s;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        Uri data;
        Uri data2;
        ValueCallback<Uri> valueCallback;
        ValueCallback<Uri> valueCallback2;
        Uri uri;
        ValueCallback<Uri[]> valueCallback3;
        Uri data3;
        ValueCallback<Uri[]> valueCallback4;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            try {
                if (this.p != null) {
                    this.p.onReceiveValue((Object) null);
                    this.p = null;
                }
                if (this.q != null) {
                    this.q.onReceiveValue((Object) null);
                    this.q = null;
                }
            } catch (Exception unused) {
            }
        } else if (i2 == 4) {
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_SETTINGS");
            intent2.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent2);
        } else {
            if (i2 == 344 && intent != null) {
                String stringExtra = intent.getStringExtra("order_id");
                boolean booleanExtra = intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
                if (!booleanExtra && !booleanExtra) {
                    Intent a2 = net.one97.paytm.insurance.b.d.a(this, Boolean.FALSE, Boolean.TRUE);
                    a2.putExtra("order_id", stringExtra);
                    f.a.a aVar = f.a.a.f13515a;
                    a2.putExtra("insurance_type", ((Integer) Objects.requireNonNull(f.a.a.c())).toString());
                    startActivity(a2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (!(i2 != 3 || (data3 = intent.getData()) == null || (valueCallback4 = this.p) == null)) {
                    valueCallback4.onReceiveValue(new Uri[]{data3});
                    this.p = null;
                }
                if (!(i2 != 2 || (uri = this.k) == null || (valueCallback3 = this.p) == null)) {
                    valueCallback3.onReceiveValue(new Uri[]{uri});
                    this.p = null;
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                if (i2 == 2) {
                    Uri uri2 = this.k;
                    if (!(uri2 == null || (valueCallback2 = this.q) == null)) {
                        valueCallback2.onReceiveValue(uri2);
                        this.q = null;
                    }
                } else if (!(i2 != 3 || (data2 = intent.getData()) == null || (valueCallback = this.q) == null)) {
                    valueCallback.onReceiveValue(data2);
                    this.q = null;
                }
            } else if (i2 == 2) {
                if (this.m != null) {
                    w.a().a(this.k).a((af) this.m);
                }
            } else if (!(i2 != 3 || intent == null || (data = intent.getData()) == null || this.m == null)) {
                w.a().a(data).a((af) this.m);
            }
            if (i2 == 111) {
                Intent intent3 = getIntent();
                if (!(intent3 == null || (extras = intent3.getExtras()) == null)) {
                    this.f14037a = extras.getString("url");
                }
                e();
                g();
                this.n = false;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f14037a = intent.getStringExtra("url");
            this.o = intent.getBooleanExtra("isLoginRequired", true);
        }
        if (!com.paytm.utility.b.c((Context) this)) {
            a(true);
        } else if (!this.o || com.paytm.utility.b.r((Context) this)) {
            e();
            g();
            this.n = false;
        } else {
            String name = MyInsuranceActivity.class.getName();
            String string = getString(R.string.hello_sign_in);
            Intent intent2 = new Intent(this, net.one97.paytm.insurance.b.c.a().getAJRAuthActivity());
            if (name != null) {
                intent2.putExtra("resultant activity", name);
                com.paytm.utility.b.j();
            }
            intent2.putExtra("sign_in_sign_up_with_step_2", true);
            if (!TextUtils.isEmpty(string)) {
                intent2.putExtra("sign_in_title", string);
            }
            if (!TextUtils.isEmpty((CharSequence) null)) {
                intent2.putExtra("sign_up_title", (String) null);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("origin", "deeplinking");
            bundle2.putString("url", getIntent().getStringExtra("url"));
            bundle2.putString("id", getIntent().getStringExtra("id"));
            bundle2.putString("source", getIntent().getStringExtra("source"));
            intent2.putExtra("resultant activity_bundle", bundle2);
            startActivityForResult(intent2, 111);
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

    private void e() {
        setContentView(R.layout.lyt_my_insurance);
        this.m = new a(this);
        this.j = new b(this);
        f();
    }

    private void f() {
        net.one97.paytm.insurance.b.a.a();
        String a2 = net.one97.paytm.insurance.b.a.a("myInsWhitelistUrl");
        if (!TextUtils.isEmpty(a2)) {
            this.f14043g = a2.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
            String[] strArr = this.f14043g;
            if (strArr == null || strArr.length == 0) {
                this.n = false;
            } else {
                this.n = true;
            }
        } else {
            this.n = false;
        }
    }

    private void a(String[] strArr) {
        for (String a2 : strArr) {
            if (!androidx.core.app.a.a((Activity) this, a2)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Cannot Proceed without Permission(s)");
                builder.setMessage("Please allow the necessary permissions. One or more permissions were denied permanently");
                builder.setPositiveButton(Payload.RESPONSE_OK, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        Intent intent = new Intent();
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", MyInsuranceActivity.this.getPackageName(), (String) null));
                        MyInsuranceActivity.this.startActivityForResult(intent, 4);
                    }
                }).show();
                return;
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int i3 = 0;
        if (i2 == 2) {
            while (i3 < iArr.length) {
                if (iArr[i3] != 0) {
                    a(strArr);
                    return;
                }
                i3++;
            }
            Message message = new Message();
            message.what = 3;
            message.obj = "javascript:accessGiven(\"camera\");";
            this.j.sendMessage(message);
        } else if (i2 == 3) {
            while (i3 < iArr.length) {
                if (iArr[i3] != 0) {
                    a(strArr);
                    return;
                }
                i3++;
            }
            Message message2 = new Message();
            message2.what = 3;
            message2.obj = "javascript:accessGiven(\"gallery\");";
            this.j.sendMessage(message2);
        }
    }

    private void g() {
        this.f14042f = new WebView(this);
        this.f14042f.setWebViewClient(new WebViewClient() {
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                MyInsuranceActivity.this.d();
            }
        });
        this.f14042f.getSettings().setJavaScriptEnabled(true);
        this.f14042f.getSettings().setCacheMode(2);
        this.r = new d(this);
        this.f14042f.setWebChromeClient(this.r);
        this.f14042f.addJavascriptInterface(this.f14044i, StringSet.Android);
        a(this, getString(R.string.please_wait));
        this.f14042f.loadUrl(this.f14037a);
        ((FrameLayout) findViewById(R.id.ins_main_layout)).addView(this.f14042f);
    }

    /* access modifiers changed from: private */
    public boolean h() {
        if (Build.VERSION.SDK_INT >= 23) {
            return androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        this.f14042f.loadUrl("javascript:onBackPressed();");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        WebView webView = this.f14042f;
        if (webView != null && !webView.canGoBack()) {
            finish();
        }
        this.f14042f.loadUrl("javascript:onBackPressed();");
        return true;
    }

    public final void a() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            String str = "img_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
            this.f14041e = str;
            File createTempFile = File.createTempFile(str, ".png", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            this.f14041e = createTempFile.getAbsolutePath();
            this.f14040d = createTempFile;
        } catch (Exception unused) {
        }
        File file = this.f14040d;
        if (file != null) {
            Uri uriForFile = FileProvider.getUriForFile(this, "com.paytm.business.provider", file);
            this.k = uriForFile;
            intent.putExtra("output", uriForFile);
            if (Build.VERSION.SDK_INT >= 21) {
                intent.addFlags(1);
                intent.addFlags(2);
            } else if (getPackageManager() != null) {
                for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 65536)) {
                    grantUriPermission(resolveInfo.activityInfo.packageName, this.k, 3);
                }
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 2);
            }
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            a.C0191a aVar = net.one97.paytm.insurance.common.a.a.f13991c;
            this.s = a.C0191a.a((CJROrderSummary) iJRPaytmDataModel);
            this.s.a((Context) this, getSupportFragmentManager());
        }
    }

    public class c {

        /* renamed from: b  reason: collision with root package name */
        private Context f14054b;

        @JavascriptInterface
        public final String getUserAddress() {
            return "";
        }

        c(Context context) {
            this.f14054b = context;
        }

        @JavascriptInterface
        public final String getAuthData() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(StringSet.token, net.one97.paytm.insurance.b.c.a().getSSOToken(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("userId", net.one97.paytm.insurance.b.c.a().getUserId(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("full_name", com.paytm.utility.b.aa(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("first_name", com.paytm.utility.b.h(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("last_name", com.paytm.utility.b.i(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("dob", com.paytm.utility.b.F(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("gender", com.paytm.utility.b.G(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put(AppConstants.KEY_EMAIL, com.paytm.utility.b.m(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(MyInsuranceActivity.this.getApplicationContext()));
                jSONObject.put("Authorization", com.paytm.utility.b.m());
                if (Build.VERSION.SDK_INT < 21) {
                    int i2 = Build.VERSION.SDK_INT;
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        }

        @JavascriptInterface
        public final void openDeepLink(String str) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_internal_flow", true);
            net.one97.paytm.insurance.b.c.a().handleDeepLink(MyInsuranceActivity.this, str, bundle);
        }

        @JavascriptInterface
        public final void openCSTScreen(String str) {
            MyInsuranceActivity.a(MyInsuranceActivity.this, str);
        }

        @JavascriptInterface
        public final void sharePost(String str) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "Check out my new Offer");
            intent.putExtra("android.intent.extra.TEXT", str);
            if (intent.resolveActivity(MyInsuranceActivity.this.getPackageManager()) != null) {
                MyInsuranceActivity.this.startActivity(Intent.createChooser(intent, "Share URL"));
            }
        }

        @JavascriptInterface
        public final void sessionExpiryEvent() {
            if (MyInsuranceActivity.this.j != null) {
                Message message = new Message();
                message.what = 0;
                MyInsuranceActivity.this.j.sendMessage(message);
                MyInsuranceActivity.this.finish();
            }
        }

        @JavascriptInterface
        public final void downloadPDF(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    String guessFileName = URLUtil.guessFileName(str, (String) null, MimeTypeMap.getFileExtensionFromUrl(str));
                    MyInsuranceActivity myInsuranceActivity = MyInsuranceActivity.this;
                    String str3 = Environment.DIRECTORY_DOWNLOADS;
                    request.setDestinationInExternalFilesDir(myInsuranceActivity, str3, guessFileName + ".pdf");
                    MyInsuranceActivity.this.registerReceiver(new BroadcastReceiver() {
                        public final void onReceive(Context context, Intent intent) {
                            Toast.makeText(context, "Pdf download complete.", 1).show();
                        }
                    }, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                    ((DownloadManager) MyInsuranceActivity.this.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD)).enqueue(request);
                } catch (Exception unused) {
                }
            }
        }

        @JavascriptInterface
        public final void openOrderSummary(String str, String str2) {
            net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
            MyInsuranceActivity myInsuranceActivity = MyInsuranceActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append(Double.valueOf(str2).longValue());
            a2.openOrderSummary(myInsuranceActivity, sb.toString(), str);
        }

        @JavascriptInterface
        public final void onBackPressed() {
            if (MyInsuranceActivity.this.j != null) {
                Message message = new Message();
                message.what = 1;
                MyInsuranceActivity.this.j.sendMessage(message);
            }
        }

        @JavascriptInterface
        public final void showErrorToast(String str) {
            if (MyInsuranceActivity.this.j != null) {
                Message message = new Message();
                message.what = 2;
                message.obj = str;
                MyInsuranceActivity.this.j.sendMessage(message);
            }
        }

        @JavascriptInterface
        public final void openUrl(String str, String str2) {
            if (MyInsuranceActivity.this.j != null) {
                Message message = new Message();
                message.what = 6;
                HashMap hashMap = new HashMap(2);
                hashMap.put("url", str);
                hashMap.put("title", str2);
                message.obj = hashMap;
                MyInsuranceActivity.this.j.sendMessage(message);
            }
        }

        @JavascriptInterface
        public final String getGtmUrl(String str) {
            net.one97.paytm.insurance.b.a.a();
            return net.one97.paytm.insurance.b.a.a(str);
        }

        @JavascriptInterface
        public final void startCameraForImageUpload(int i2) {
            int unused = MyInsuranceActivity.l = i2;
            String[] strArr = {"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (MyInsuranceActivity.b(MyInsuranceActivity.this)) {
                androidx.core.app.a.a(MyInsuranceActivity.this, strArr, 2);
            } else {
                MyInsuranceActivity.this.a();
            }
        }

        @JavascriptInterface
        public final void startGalleryForImageUpload(int i2) {
            int unused = MyInsuranceActivity.l = i2;
            String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (!MyInsuranceActivity.this.h()) {
                androidx.core.app.a.a(MyInsuranceActivity.this, strArr, 3);
            } else if (Build.VERSION.SDK_INT <= 21 && Build.VERSION.SDK_INT >= 19) {
                Intent b2 = MyInsuranceActivity.b();
                if (b2.resolveActivity(MyInsuranceActivity.this.getPackageManager()) != null) {
                    MyInsuranceActivity.this.startActivityForResult(b2, 3);
                }
            }
        }

        @JavascriptInterface
        public final String appVersion() {
            try {
                return MyInsuranceActivity.this.getPackageManager().getPackageInfo(MyInsuranceActivity.this.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
                return null;
            }
        }

        @JavascriptInterface
        public final String getAppData() {
            JSONObject jSONObject = new JSONObject();
            try {
                f.a.a aVar = f.a.a.f13515a;
                if (f.a.a.c() != null) {
                    f.a.a aVar2 = f.a.a.f13515a;
                    jSONObject.put("insuranceType", f.a.a.c().toString());
                }
                jSONObject.put("leadId", MyInsuranceActivity.this.getIntent().getStringExtra("id"));
                jSONObject.put("listingUrl", MyInsuranceActivity.this.getIntent().getStringExtra("listingUrl"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public final void checkoutCart(String str) {
            if (com.paytm.utility.b.c((Context) MyInsuranceActivity.this)) {
                try {
                    new common.insuranceOrderSummary.b(MyInsuranceActivity.this, (SelectQuoteResponse) new f().a(str, SelectQuoteResponse.class)).a();
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            } else {
                MyInsuranceActivity.this.a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.ins_no_connection));
        builder.setMessage(getResources().getString(R.string.ins_no_internet));
        builder.setPositiveButton(getResources().getString(R.string.ins_ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (z) {
                    MyInsuranceActivity.this.finish();
                }
            }
        });
        if (!isFinishing()) {
            builder.show();
        }
    }

    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MyInsuranceActivity> f14052a;

        public b(MyInsuranceActivity myInsuranceActivity) {
            super(Looper.getMainLooper());
            this.f14052a = new WeakReference<>(myInsuranceActivity);
        }

        public final void handleMessage(Message message) {
            WeakReference<MyInsuranceActivity> weakReference = this.f14052a;
            if (weakReference != null && weakReference.get() != null) {
                MyInsuranceActivity myInsuranceActivity = (MyInsuranceActivity) this.f14052a.get();
                int i2 = message.what;
                Intent intent = null;
                if (i2 == 0) {
                    net.one97.paytm.insurance.b.c.a().signOut((Activity) this.f14052a.get(), false, (VolleyError) null);
                } else if (i2 == 1) {
                    myInsuranceActivity.finish();
                } else if (i2 == 2) {
                    Toast.makeText(myInsuranceActivity, (String) message.obj, 1).show();
                } else if (i2 == 3) {
                    ((MyInsuranceActivity) this.f14052a.get()).f14042f.loadUrl((String) message.obj);
                } else if (i2 == 6) {
                    HashMap hashMap = (HashMap) message.obj;
                    String str = (String) hashMap.get("url");
                    String str2 = (String) hashMap.get("title");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            intent = new Intent(myInsuranceActivity, Class.forName(net.one97.paytm.insurance.b.c.a().getEmbedWebViewClassName()));
                        } catch (ClassNotFoundException e2) {
                            e2.printStackTrace();
                        }
                        if (intent != null) {
                            intent.putExtra("url", str);
                            intent.putExtra("title", str2);
                            myInsuranceActivity.startActivity(intent);
                        }
                    }
                }
            }
        }
    }

    static class a implements af {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<MyInsuranceActivity> f14049a;

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
        }

        public final void onPrepareLoad(Drawable drawable) {
        }

        public a(MyInsuranceActivity myInsuranceActivity) {
            this.f14049a = new WeakReference<>(myInsuranceActivity);
        }

        public final void onBitmapLoaded(final Bitmap bitmap, w.d dVar) {
            WeakReference<MyInsuranceActivity> weakReference = this.f14049a;
            if (weakReference != null && weakReference.get() != null) {
                new Thread(new Runnable() {
                    public final void run() {
                        if (a.this.f14049a != null && a.this.f14049a.get() != null) {
                            float height = ((float) bitmap.getHeight()) / (((float) bitmap.getWidth()) * 1.0f);
                            int c2 = MyInsuranceActivity.l;
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            Bitmap.createScaledBitmap(bitmap, c2, (int) (((float) c2) * height), false).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            Message message = new Message();
                            message.what = 3;
                            message.obj = "javascript:processImage(\"" + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0) + "\");";
                            if (((MyInsuranceActivity) a.this.f14049a.get()).j != null) {
                                ((MyInsuranceActivity) a.this.f14049a.get()).j.sendMessage(message);
                            }
                            try {
                                File file = new File(((MyInsuranceActivity) a.this.f14049a.get()).f14041e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        }
    }

    class d extends WebChromeClient {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<MyInsuranceActivity> f14057b;

        public d(MyInsuranceActivity myInsuranceActivity) {
            this.f14057b = new WeakReference<>(myInsuranceActivity);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
            if (r0.equals("image/*") == false) goto L_0x0036;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onShowFileChooser(android.webkit.WebView r7, android.webkit.ValueCallback<android.net.Uri[]> r8, android.webkit.WebChromeClient.FileChooserParams r9) {
            /*
                r6 = this;
                java.lang.String[] r0 = r9.getAcceptTypes()
                java.lang.ref.WeakReference<net.one97.paytm.insurance.myinsurance.MyInsuranceActivity> r1 = r6.f14057b
                java.lang.Object r1 = r1.get()
                r2 = 1
                if (r1 != 0) goto L_0x000e
                return r2
            L_0x000e:
                if (r0 == 0) goto L_0x009e
                int r1 = r0.length
                if (r1 <= 0) goto L_0x009e
                r1 = 0
                r0 = r0[r1]
                r3 = -1
                int r4 = r0.hashCode()
                if (r4 == 0) goto L_0x002c
                r5 = 1911932022(0x71f5c476, float:2.4339627E30)
                if (r4 == r5) goto L_0x0023
                goto L_0x0036
            L_0x0023:
                java.lang.String r4 = "image/*"
                boolean r0 = r0.equals(r4)
                if (r0 == 0) goto L_0x0036
                goto L_0x0037
            L_0x002c:
                java.lang.String r1 = ""
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0036
                r1 = 1
                goto L_0x0037
            L_0x0036:
                r1 = -1
            L_0x0037:
                r0 = 0
                java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
                java.lang.String r4 = "android.permission.READ_EXTERNAL_STORAGE"
                if (r1 == 0) goto L_0x006c
                if (r1 == r2) goto L_0x0041
                goto L_0x009e
            L_0x0041:
                java.lang.String r7 = "android.permission.CAMERA"
                java.lang.String[] r7 = new java.lang.String[]{r7, r4, r3}
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r9 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                boolean r9 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.b((net.one97.paytm.insurance.myinsurance.MyInsuranceActivity) r9)
                if (r9 == 0) goto L_0x005b
                if (r8 == 0) goto L_0x0054
                r8.onReceiveValue(r0)
            L_0x0054:
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r8 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                r9 = 2
                androidx.core.app.a.a(r8, r7, r9)
                goto L_0x006b
            L_0x005b:
                java.lang.ref.WeakReference<net.one97.paytm.insurance.myinsurance.MyInsuranceActivity> r7 = r6.f14057b
                java.lang.Object r7 = r7.get()
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r7 = (net.one97.paytm.insurance.myinsurance.MyInsuranceActivity) r7
                r7.a()
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r7 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                android.webkit.ValueCallback unused = r7.p = r8
            L_0x006b:
                return r2
            L_0x006c:
                java.lang.ref.WeakReference<net.one97.paytm.insurance.myinsurance.MyInsuranceActivity> r7 = r6.f14057b
                java.lang.Object r7 = r7.get()
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r7 = (net.one97.paytm.insurance.myinsurance.MyInsuranceActivity) r7
                boolean r7 = r7.h()
                r9 = 3
                if (r7 != 0) goto L_0x008a
                java.lang.String[] r7 = new java.lang.String[]{r4, r3}
                if (r8 == 0) goto L_0x0084
                r8.onReceiveValue(r0)
            L_0x0084:
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r8 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                androidx.core.app.a.a(r8, r7, r9)
                goto L_0x009d
            L_0x008a:
                java.lang.ref.WeakReference<net.one97.paytm.insurance.myinsurance.MyInsuranceActivity> r7 = r6.f14057b
                r7.get()
                android.content.Intent r7 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.b()
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r0 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                android.webkit.ValueCallback unused = r0.p = r8
                net.one97.paytm.insurance.myinsurance.MyInsuranceActivity r8 = net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.this
                r8.startActivityForResult(r7, r9)
            L_0x009d:
                return r2
            L_0x009e:
                boolean r7 = super.onShowFileChooser(r7, r8, r9)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.myinsurance.MyInsuranceActivity.d.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
        }
    }

    static /* synthetic */ void a(MyInsuranceActivity myInsuranceActivity, String str) {
        String str2 = net.one97.paytm.insurance.b.c.a().getOrderDetailUrl() + str;
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = myInsuranceActivity;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42878b = a.c.INSURANCE;
        bVar.f42880d = com.paytm.utility.b.b((Context) myInsuranceActivity, str2) + "&actions=1";
        bVar.f42884h = null;
        bVar.f42882f = null;
        bVar.f42885i = new CJROrderSummary();
        bVar.o = "InsurancePostPaymentFragment";
        bVar.j = myInsuranceActivity;
        bVar.n = a.b.SILENT;
        bVar.l().a();
    }

    static /* synthetic */ boolean b(MyInsuranceActivity myInsuranceActivity) {
        return androidx.core.content.b.a((Context) myInsuranceActivity, "android.permission.CAMERA") != 0 || !myInsuranceActivity.h();
    }

    static /* synthetic */ Intent b() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        return intent;
    }
}
