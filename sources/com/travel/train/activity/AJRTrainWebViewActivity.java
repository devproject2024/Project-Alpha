package com.travel.train.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class AJRTrainWebViewActivity extends CJRTrainBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f26142a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f26143b;

    /* renamed from: c  reason: collision with root package name */
    private String f26144c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f26145d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f26146e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f26147f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f26148g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26149h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f26150i = "AJRTrainWebViewActivity";
    private WebViewClient j = new WebViewClient() {
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ((ProgressBar) AJRTrainWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.toLowerCase().contains("mailto:care@paytm.com")) {
                AJRTrainWebViewActivity.a(AJRTrainWebViewActivity.this);
                return true;
            } else if (str.startsWith("market://")) {
                AJRTrainWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (!Uri.parse(str).getScheme().equals("paytmmp")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                AJRTrainWebViewActivity.a(AJRTrainWebViewActivity.this, str);
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AJRTrainWebViewActivity.this.findViewById(R.id.webview_load_indicator)).setVisibility(8);
            super.onPageFinished(webView, str);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_web_view);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("url")) {
            this.f26142a = getIntent().getStringExtra("url");
        }
        if (intent != null && intent.hasExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
            this.f26144c = intent.getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        }
        TextView textView = (TextView) findViewById(R.id.hotels_title);
        this.f26148g = (TextView) findViewById(R.id.booking_text);
        this.f26147f = (RelativeLayout) findViewById(R.id.overlay_lyt);
        this.f26147f.setOnClickListener(this);
        this.f26146e = (ImageView) findViewById(R.id.back_action_button);
        this.f26146e.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.f26146e.setRotation(180.0f);
        this.f26146e.setOnClickListener(this);
        this.f26145d = (ImageView) findViewById(R.id.close_btn);
        this.f26145d.setOnClickListener(this);
        this.f26143b = (WebView) findViewById(R.id.payment_webview);
        this.f26143b.setWebViewClient(this.j);
        if (!TextUtils.isEmpty(this.f26144c)) {
            textView.setText(this.f26144c);
        }
        SpannableString spannableString = new SpannableString("If you have reset your IRCTC password,\nClick here to resume the booking");
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), 38, 49, 0);
        spannableString.setSpan(new StyleSpan(1), 38, 49, 0);
        this.f26148g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f26148g.setText(spannableString);
        this.f26148g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainWebViewActivity.this.setResult(155, new Intent());
                AJRTrainWebViewActivity.this.finish();
            }
        });
        this.f26143b.getSettings().setBuiltInZoomControls(true);
        this.f26143b.getSettings().setLoadWithOverviewMode(true);
        this.f26143b.setInitialScale(140);
        this.f26143b.getSettings().setJavaScriptEnabled(true);
        this.f26143b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f26143b.setWebChromeClient(new WebChromeClient());
        if (!TextUtils.isEmpty(this.f26142a)) {
            this.f26143b.loadUrl(this.f26142a);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_action_button) {
            finish();
        } else if (id == R.id.close_btn) {
            this.f26149h = true;
            this.f26147f.setVisibility(8);
        } else if (id == R.id.overlay_lyt) {
            setResult(155, new Intent());
            finish();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56 && !s.a(iArr) && s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        s.b((Context) AJRTrainWebViewActivity.this);
                        AJRTrainWebViewActivity.this.finish();
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

    static /* synthetic */ void a(AJRTrainWebViewActivity aJRTrainWebViewActivity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"care@paytm.com"});
        try {
            aJRTrainWebViewActivity.startActivity(Intent.createChooser(intent, aJRTrainWebViewActivity.getResources().getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void a(AJRTrainWebViewActivity aJRTrainWebViewActivity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("origin", "deeplinking");
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) aJRTrainWebViewActivity, str, bundle);
    }
}
