package com.paytm.network.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.paytm.networkmodule.R;
import com.paytm.utility.q;

public class AJRCommonNetworkDialogActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f42867a;

    /* renamed from: b  reason: collision with root package name */
    private Button f42868b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f42869c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f42870d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f42871e;

    /* renamed from: f  reason: collision with root package name */
    private String f42872f;

    /* renamed from: g  reason: collision with root package name */
    private String f42873g;

    /* renamed from: h  reason: collision with root package name */
    private String f42874h;

    /* renamed from: i  reason: collision with root package name */
    private String f42875i;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private String m;
    private boolean n;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.w_custom_dialog);
        getWindow().setLayout(-1, -2);
        this.f42868b = (Button) findViewById(R.id.w_custom_dialog_btn_positive);
        this.f42869c = (TextView) findViewById(R.id.w_custom_dialog_btn_negative);
        this.f42870d = (TextView) findViewById(R.id.w_custom_dialog_title);
        this.f42871e = (TextView) findViewById(R.id.w_custom_dialog_message);
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getStringExtra("display_error_content");
            this.j = intent.getStringExtra("alert_title");
            this.f42872f = intent.getStringExtra("positive-button-text");
            this.f42873g = intent.getStringExtra("negative-button-text");
            this.f42874h = intent.getStringExtra("vertical_error_code");
            this.f42867a = intent.getStringExtra("vertical_email_id");
            this.f42875i = intent.getStringExtra("vertical_url");
            this.l = intent.getBooleanExtra("dde_found", false);
            this.k = intent.getStringExtra("alert_message");
            this.n = intent.getBooleanExtra("should-display-title", false);
        }
        if (!this.n) {
            this.f42870d.setVisibility(8);
        } else {
            this.f42870d.setVisibility(0);
        }
        setTitle(this.j);
        this.f42871e.setText(this.k);
        this.f42868b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRCommonNetworkDialogActivity.this.l && AJRCommonNetworkDialogActivity.this.l) {
                    AJRCommonNetworkDialogActivity aJRCommonNetworkDialogActivity = AJRCommonNetworkDialogActivity.this;
                    String a2 = aJRCommonNetworkDialogActivity.a();
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{aJRCommonNetworkDialogActivity.f42867a != null ? aJRCommonNetworkDialogActivity.f42867a : "error@paytm.com"});
                    intent.putExtra("android.intent.extra.SUBJECT", "Something went wrong");
                    intent.putExtra("android.intent.extra.TEXT", a2);
                    intent.setType("message/rfc822");
                    aJRCommonNetworkDialogActivity.startActivity(Intent.createChooser(intent, "Select Email Sending App :"));
                }
                AJRCommonNetworkDialogActivity.this.finish();
            }
        });
        if (!TextUtils.isEmpty(this.f42872f)) {
            this.f42868b.setText(this.f42872f);
        } else if (!TextUtils.isEmpty(this.f42873g)) {
            this.f42869c.setText(this.f42873g);
        }
        if (TextUtils.isEmpty(this.f42872f) && TextUtils.isEmpty(this.f42873g)) {
            this.f42868b.setText(getString(R.string.ok));
            this.f42869c.setVisibility(8);
        }
        setFinishOnTouchOutside(false);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f42870d.setText(getString(R.string.alert));
        } else {
            this.f42870d.setText(charSequence);
        }
    }

    public void onClick(View view) {
        if (!isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        String str;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String str4 = Build.VERSION.RELEASE;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.d(e2.getMessage());
            str = null;
        }
        return getString(R.string.error_reporting_mail_body, new Object[]{str2, str3, str4, str, this.f42875i, this.f42874h, this.m});
    }
}
