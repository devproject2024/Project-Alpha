package com.karza.aadhaarsdk;

import a.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AadharActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public ValueCallback<Uri[]> f13407a;

    /* renamed from: b  reason: collision with root package name */
    public ValueCallback<Uri> f13408b;

    /* renamed from: c  reason: collision with root package name */
    public String f13409c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f13410d = null;

    /* renamed from: e  reason: collision with root package name */
    public WebView f13411e;

    /* renamed from: f  reason: collision with root package name */
    public WebSettings f13412f;

    public class a extends WebChromeClient {
        public /* synthetic */ a() {
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            File file;
            ValueCallback<Uri[]> valueCallback2 = AadharActivity.this.f13407a;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue((Object) null);
            }
            AadharActivity.this.f13407a = valueCallback;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(AadharActivity.this.getPackageManager()) != null) {
                try {
                    file = AadharActivity.a();
                    try {
                        intent.putExtra("PhotoPath", AadharActivity.this.f13409c);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    file = null;
                }
                if (file != null) {
                    AadharActivity.this.f13409c = "file:" + file.getAbsolutePath();
                    intent.putExtra("output", Uri.fromFile(file));
                } else {
                    intent = null;
                }
            }
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType("*/*");
            Intent[] intentArr = intent != null ? new Intent[]{intent} : new Intent[0];
            Intent intent3 = new Intent("android.intent.action.CHOOSER");
            intent3.putExtra("android.intent.extra.INTENT", intent2);
            intent3.putExtra("android.intent.extra.TITLE", "Image Chooser");
            intent3.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            AadharActivity.this.startActivityForResult(intent3, 1);
            return true;
        }
    }

    public static File a() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return File.createTempFile("JPEG_" + format + "_", ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ValueCallback<Uri> valueCallback;
        Uri uri;
        Uri[] uriArr;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            if (i2 != 1 || this.f13407a == null) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            if (i3 == -1) {
                if (intent == null) {
                    String str = this.f13409c;
                    if (str != null) {
                        uriArr = new Uri[]{Uri.parse(str)};
                        this.f13407a.onReceiveValue(uriArr);
                        this.f13407a = null;
                    }
                } else {
                    String dataString = intent.getDataString();
                    if (dataString != null) {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                        this.f13407a.onReceiveValue(uriArr);
                        this.f13407a = null;
                    }
                }
            }
            uriArr = null;
            this.f13407a.onReceiveValue(uriArr);
            this.f13407a = null;
        } else if (i4 > 19) {
        } else {
            if (i2 != 1 || (valueCallback = this.f13408b) == null) {
                super.onActivityResult(i2, i3, intent);
            } else if (i2 == 1 && valueCallback != null) {
                if (i3 == -1) {
                    if (intent == null) {
                        try {
                            uri = this.f13410d;
                        } catch (Exception e2) {
                            Toast.makeText(getApplicationContext(), "activity :".concat(String.valueOf(e2)), 1).show();
                        }
                    } else {
                        uri = intent.getData();
                    }
                    this.f13408b.onReceiveValue(uri);
                    this.f13408b = null;
                }
                uri = null;
                this.f13408b.onReceiveValue(uri);
                this.f13408b = null;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_aadhar);
        String stringExtra = getIntent().getStringExtra("KARZA-TOKEN");
        String stringExtra2 = getIntent().getStringExtra("EMAIL");
        String stringExtra3 = getIntent().getStringExtra("MOBILE");
        String stringExtra4 = getIntent().getStringExtra("CLIENT");
        HashMap hashMap = new HashMap();
        hashMap.put("k-token", stringExtra);
        hashMap.put(AppConstants.KEY_EMAIL, stringExtra2);
        hashMap.put("mobile", stringExtra3);
        hashMap.put("client", stringExtra4);
        ArrayList arrayList = new ArrayList();
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                arrayList.add(str + "=" + str2);
            }
        }
        String join = TextUtils.join(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, arrayList);
        try {
            getApplicationContext().getAssets().open("udai.html");
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
        b bVar = new b("", this);
        this.f13411e = (WebView) findViewById(R.id.aadharwebview);
        this.f13412f = this.f13411e.getSettings();
        this.f13412f.setAllowFileAccess(true);
        this.f13412f.setJavaScriptEnabled(true);
        this.f13412f.setLoadWithOverviewMode(true);
        this.f13411e.loadUrl("https://app.karza.in/aadhaar-xml/?".concat(String.valueOf(join)));
        this.f13411e.addJavascriptInterface(new a.a.a.a(), "interception");
        this.f13411e.addJavascriptInterface(bVar, "kauth");
        this.f13411e.setWebChromeClient(new a());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.f13411e.canGoBack()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.f13411e.goBack();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
