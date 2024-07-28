package net.one97.paytm.verifier.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.b.f;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify;
import net.one97.paytm.common.entity.verifier.CJRVerifierDoView;
import net.one97.paytm.common.entity.verifier.CJRVerifierRenderData;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.utils.z;
import net.one97.paytm.verifier.a.a;
import net.one97.paytm.verifier.a.c;
import net.one97.paytm.wallet.newdesign.utils.CustomWalletLoaderDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class VerificationProcessActivity extends PaytmActivity implements View.OnClickListener, b {
    /* access modifiers changed from: private */
    public boolean A = false;
    private String B;
    private View.OnKeyListener C = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            int i3 = 0;
            if (i2 != 67) {
                return false;
            }
            VerificationProcessActivity verificationProcessActivity = VerificationProcessActivity.this;
            boolean unused = verificationProcessActivity.A = !verificationProcessActivity.A;
            if (VerificationProcessActivity.this.o) {
                while (i3 < VerificationProcessActivity.this.q) {
                    if (view != VerificationProcessActivity.this.f69814b.getChildAt(i3)) {
                        i3++;
                    } else if (i3 == 0) {
                        return VerificationProcessActivity.a((EditText) VerificationProcessActivity.this.f69814b.getChildAt(i3), (EditText) null, VerificationProcessActivity.this.A);
                    } else {
                        return VerificationProcessActivity.a((EditText) VerificationProcessActivity.this.f69814b.getChildAt(i3), (EditText) VerificationProcessActivity.this.f69814b.getChildAt(i3 - 1), VerificationProcessActivity.this.A);
                    }
                }
            }
            return true;
        }
    };
    private TextWatcher D = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            try {
                VerificationProcessActivity.this.f69820h.setVisibility(8);
                if (VerificationProcessActivity.this.o) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < VerificationProcessActivity.this.q) {
                            EditText editText = (EditText) VerificationProcessActivity.this.f69814b.getChildAt(i2);
                            if (editText != null && TextUtils.isEmpty(editText.getText())) {
                                editText.requestFocus();
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (i2 == VerificationProcessActivity.this.q) {
                        VerificationProcessActivity.this.k.setEnabled(true);
                        VerificationProcessActivity.this.k.setClickable(true);
                        return;
                    }
                    VerificationProcessActivity.this.k.setEnabled(false);
                    VerificationProcessActivity.this.k.setClickable(false);
                } else if (!TextUtils.isEmpty(VerificationProcessActivity.this.f69816d.getText().toString())) {
                    VerificationProcessActivity.this.k.setEnabled(true);
                    VerificationProcessActivity.this.k.setClickable(true);
                } else {
                    VerificationProcessActivity.this.k.setEnabled(false);
                    VerificationProcessActivity.this.k.setClickable(false);
                }
            } catch (Exception unused) {
            }
        }
    };
    private CountDownTimer E = new CountDownTimer() {
        public final void onTick(long j) {
            try {
                VerificationProcessActivity.this.j.setText(VerificationProcessActivity.this.v + " (00:" + String.format("%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))}) + ")");
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }

        public final void onFinish() {
            try {
                VerificationProcessActivity.this.j.setText(VerificationProcessActivity.this.v);
                VerificationProcessActivity.this.j.setTextColor(Color.parseColor("#00b9f5"));
                VerificationProcessActivity.this.j.setClickable(true);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ImageView f69813a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f69814b;

    /* renamed from: c  reason: collision with root package name */
    private TextInputLayout f69815c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppCompatEditText f69816d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f69817e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f69818f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f69819g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f69820h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f69821i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public TextView k;
    private TextView l;
    private String m;
    private String n;
    /* access modifiers changed from: private */
    public boolean o = true;
    private CJRVerifierDoView p;
    /* access modifiers changed from: private */
    public int q = 6;
    private CJRVerifierRenderData r = null;
    private ProgressBar s;
    private String t = "";
    private String u = "";
    /* access modifiers changed from: private */
    public String v = "";
    private ScrollView w;
    private z x;
    private CustomWalletLoaderDialog y;
    private EditText z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_verification_process);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        this.f69813a = (ImageView) findViewById(R.id.iv_back_button);
        this.f69815c = (TextInputLayout) findViewById(R.id.layout_password_edittext);
        this.f69816d = (AppCompatEditText) findViewById(R.id.password_edittext);
        this.f69814b = (LinearLayout) findViewById(R.id.linear_lyt_passcode_edt);
        this.s = (ProgressBar) findViewById(R.id.pb_progress);
        this.f69817e = (TextView) findViewById(R.id.form_title);
        this.f69818f = (TextView) findViewById(R.id.form_sub_title);
        this.f69820h = (TextView) findViewById(R.id.passcode_error_lyt);
        this.f69819g = (TextView) findViewById(R.id.form_sub_title_dynamic);
        this.j = (TextView) findViewById(R.id.resend_otp);
        this.f69821i = (TextView) findViewById(R.id.form_tip_up);
        this.k = (TextView) findViewById(R.id.confirm_button);
        this.l = (TextView) findViewById(R.id.form_bottom_text);
        this.w = (ScrollView) findViewById(R.id.verification_scrollbar);
        this.f69816d.addTextChangedListener(this.D);
        this.x = new z(this);
        this.x.setCancelable(false);
        this.x.setCanceledOnTouchOutside(false);
        this.f69813a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationProcessActivity.this.onClick(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationProcessActivity.this.onClick(view);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationProcessActivity.this.onClick(view);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationProcessActivity.this.onClick(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("verifier_verifyID")) {
            this.m = intent.getStringExtra("verifier_verifyID");
            this.n = intent.getStringExtra("verifier_method");
            a("", "");
            a(true);
            net.one97.paytm.verifier.a.b.a(this, this, this.m, this.n);
        } else if (intent != null && intent.hasExtra("view_response")) {
            this.p = (CJRVerifierDoView) intent.getSerializableExtra("view_response");
            CJRVerifierDoView cJRVerifierDoView = this.p;
            if (cJRVerifierDoView != null) {
                this.m = cJRVerifierDoView.getResponse().getBody().getVerifyId();
                if (!TextUtils.isEmpty(this.p.getResponse().getBody().getMethod())) {
                    this.n = this.p.getResponse().getBody().getMethod();
                }
                if (this.p.getResponse().getBody().getRenderData() != null) {
                    this.r = this.p.getResponse().getBody().getRenderData();
                    if (this.r.getEncryption().equalsIgnoreCase("true")) {
                        a(this.p.getResponse().getBody().getRenderData().getAccountEncryptPubkey(), this.p.getResponse().getBody().getRenderData().getAccountEncryptSalt());
                    }
                }
                a(this.n);
                a(this.r, "");
            }
        }
    }

    private void a() {
        int a2 = c.a(40, this);
        int a3 = c.a(5, this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2, 1.0f);
        layoutParams.setMargins(a3, a3, a3, a3);
        for (int i2 = 0; i2 < this.q; i2++) {
            EditText editText = new EditText(this);
            editText.setGravity(17);
            editText.setLayoutParams(layoutParams);
            editText.setId(i2);
            a(editText);
            editText.setTextSize(16.0f);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            editText.setBackground(f.a(getResources(), (int) R.drawable.square_passcode_selector, (Resources.Theme) null));
            this.f69814b.addView(editText);
            editText.addTextChangedListener(this.D);
            editText.setOnKeyListener(this.C);
            if (i2 == 0) {
                this.z = editText;
            }
        }
    }

    private void a(EditText editText) {
        if (b()) {
            if (this.o) {
                editText.setInputType(18);
            } else {
                editText.setInputType(129);
            }
        } else if (this.o) {
            editText.setInputType(2);
        } else {
            editText.setInputType(144);
        }
    }

    private void a(CJRVerifierRenderData cJRVerifierRenderData, String str) {
        if (cJRVerifierRenderData != null) {
            c();
            String head_title = cJRVerifierRenderData.getHead_title();
            String form_title = cJRVerifierRenderData.getForm_title();
            String mobile_no = cJRVerifierRenderData.getMobile_no();
            this.v = cJRVerifierRenderData.getForm_input_tip_low();
            String form_button = cJRVerifierRenderData.getForm_button();
            String foot_tip = cJRVerifierRenderData.getFoot_tip();
            String form_input_tip_up = cJRVerifierRenderData.getForm_input_tip_up();
            if (!TextUtils.isEmpty(head_title)) {
                this.f69817e.setText(head_title);
            }
            if (!TextUtils.isEmpty(form_title)) {
                this.f69818f.setText(form_title);
            }
            if (!TextUtils.isEmpty(mobile_no)) {
                this.f69819g.setText(mobile_no);
            }
            if (!TextUtils.isEmpty(form_button)) {
                this.k.setText(form_button);
            }
            if (cJRVerifierRenderData.getHAS_OTHERS() == null || !cJRVerifierRenderData.getHAS_OTHERS().equalsIgnoreCase("true") || TextUtils.isEmpty(foot_tip)) {
                this.l.setVisibility(8);
            } else {
                this.l.setText(foot_tip);
                this.l.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.v)) {
                this.j.setText(this.v);
                this.j.setVisibility(0);
                d();
            } else {
                this.j.setVisibility(8);
            }
            if (!TextUtils.isEmpty(form_input_tip_up)) {
                this.f69821i.setText(form_input_tip_up);
                this.f69821i.setVisibility(0);
            } else {
                this.f69821i.setText("");
                this.f69821i.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f69820h.setText(str);
                this.f69820h.setVisibility(0);
            } else {
                this.f69820h.setVisibility(8);
            }
            g();
        }
    }

    public void onClick(View view) {
        String str;
        String str2;
        switch (view.getId()) {
            case R.id.confirm_button:
                if (this.o) {
                    String str3 = "";
                    for (int i2 = 0; i2 < this.q; i2++) {
                        str3 = str3 + ((EditText) this.f69814b.findViewById(i2)).getText().toString();
                    }
                    str = str3;
                } else if (TextUtils.isEmpty(this.f69816d.getText().toString())) {
                    str = "";
                } else {
                    str = this.f69816d.getText().toString();
                }
                if (b()) {
                    str = a.a(str, this.u, this.t);
                }
                if (!TextUtils.isEmpty(str)) {
                    e();
                    String str4 = this.m;
                    String str5 = this.n;
                    net.one97.paytm.j.c.a();
                    String a2 = net.one97.paytm.j.c.a("verifier_do_verify", (String) null);
                    if (URLUtil.isValidUrl(a2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("data", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("verifyId", str4);
                            jSONObject2.put("method", str5);
                            jSONObject2.put("validateData", jSONObject);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("head", net.one97.paytm.verifier.a.b.a("alipayplus.risk.identify.doVerify"));
                            jSONObject3.put("body", jSONObject2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("request", jSONObject3);
                            jSONObject4.put("signature", a.a(this, jSONObject3.toString()));
                            str2 = jSONObject4.toString();
                        } catch (JSONException e2) {
                            q.b(e2.getMessage());
                            str2 = "";
                        }
                        d.a(this, a2, this, hashMap, (Map<String, String>) null, a.C0715a.POST, str2, new CJRVerifierDoVerify(), a.c.PAYMENTS, a.b.SILENT).a();
                        return;
                    }
                    return;
                }
                return;
            case R.id.form_bottom_text:
                a("", "");
                e();
                this.B = this.n;
                net.one97.paytm.verifier.a.b.a(this, this, this.m, "MENU");
                return;
            case R.id.iv_back_button:
                onBackPressed();
                return;
            case R.id.resend_otp:
                d();
                a("", "");
                e();
                net.one97.paytm.verifier.a.b.a(this, this, this.m, this.n);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ed, code lost:
        if (r1.equals("MENU") == false) goto L_0x00fa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r8) {
        /*
            r7 = this;
            r0 = 0
            r7.a((boolean) r0)
            if (r8 == 0) goto L_0x025b
            boolean r1 = r8 instanceof net.one97.paytm.common.entity.verifier.CJRVerifierDoView
            java.lang.String r2 = "true"
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x014c
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView r8 = (net.one97.paytm.common.entity.verifier.CJRVerifierDoView) r8
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse r1 = r8.getResponse()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            java.lang.String r4 = r4.getVerifyId()
            r7.m = r4
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            java.lang.String r4 = r4.getMethod()
            if (r4 == 0) goto L_0x0032
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            java.lang.String r4 = r4.getMethod()
            r7.n = r4
        L_0x0032:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            java.lang.String r4 = r4.getIsFinish()
            if (r4 == 0) goto L_0x0045
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            java.lang.String r4 = r4.getIsFinish()
            goto L_0x0046
        L_0x0045:
            r4 = r3
        L_0x0046:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r5 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody$CJRVerifierDoViewResultInfo r5 = r5.getResultInfo()
            java.lang.String r5 = r5.getResultCode()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0063
            java.lang.String r6 = "SYSTEM_ERROR"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x0063
            r7.b((java.lang.String) r3)
        L_0x0063:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x006f
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 != 0) goto L_0x0081
        L_0x006f:
            java.lang.String r4 = r7.n
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0091
            java.lang.String r4 = r7.n
            java.lang.String r5 = "EXIT"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x0091
        L_0x0081:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r8 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r8.getRenderData()
            java.lang.String r8 = r8.getCallbackUrl()
            r7.b((java.lang.String) r8)
            return
        L_0x0091:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r4 = r4.getRenderData()
            if (r4 == 0) goto L_0x00d4
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r4 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r4 = r4.getRenderData()
            r7.r = r4
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r4 = r7.r
            java.lang.String r4 = r4.getEncryption()
            if (r4 == 0) goto L_0x00d4
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r4 = r7.r
            java.lang.String r4 = r4.getEncryption()
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00d4
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r2 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r2 = r2.getRenderData()
            java.lang.String r2 = r2.getAccountEncryptPubkey()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoView$CJRVerifierDoViewResponse$CJRVerifierDoViewBody r1 = r1.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r1 = r1.getRenderData()
            java.lang.String r1 = r1.getAccountEncryptSalt()
            r7.a((java.lang.String) r2, (java.lang.String) r1)
        L_0x00d4:
            java.lang.String r1 = r7.n
            r2 = -1
            int r4 = r1.hashCode()
            r5 = -848063872(0xffffffffcd739280, float:-2.55404032E8)
            r6 = 1
            if (r4 == r5) goto L_0x00f0
            r5 = 2362719(0x240d5f, float:3.310875E-39)
            if (r4 == r5) goto L_0x00e7
            goto L_0x00fa
        L_0x00e7:
            java.lang.String r4 = "MENU"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00fa
            goto L_0x00fb
        L_0x00f0:
            java.lang.String r0 = "VERIFIER_CASE_CANCEL"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00fa
            r0 = 1
            goto L_0x00fb
        L_0x00fa:
            r0 = -1
        L_0x00fb:
            r1 = 2021(0x7e5, float:2.832E-42)
            java.lang.String r2 = "verifier_last_method"
            java.lang.String r4 = "menu_response"
            if (r0 == 0) goto L_0x0139
            if (r0 == r6) goto L_0x0126
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r7.r
            if (r8 == 0) goto L_0x011b
            java.lang.String r8 = r8.getInputCharCount()
            if (r8 == 0) goto L_0x011b
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r7.r
            java.lang.String r8 = r8.getInputCharCount()
            int r8 = java.lang.Integer.parseInt(r8)
            r7.q = r8
        L_0x011b:
            java.lang.String r8 = r7.n
            r7.a((java.lang.String) r8)
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r7.r
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierRenderData) r8, (java.lang.String) r3)
            return
        L_0x0126:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.verifier.activity.VerificationSelectionActivity> r3 = net.one97.paytm.verifier.activity.VerificationSelectionActivity.class
            r0.<init>(r7, r3)
            r0.putExtra(r4, r8)
            java.lang.String r8 = r7.B
            r0.putExtra(r2, r8)
            r7.startActivityForResult(r0, r1)
            return
        L_0x0139:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.verifier.activity.VerificationSelectionActivity> r3 = net.one97.paytm.verifier.activity.VerificationSelectionActivity.class
            r0.<init>(r7, r3)
            r0.putExtra(r4, r8)
            java.lang.String r8 = r7.B
            r0.putExtra(r2, r8)
            r7.startActivityForResult(r0, r1)
            return
        L_0x014c:
            boolean r0 = r8 instanceof net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify
            if (r0 == 0) goto L_0x025b
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify r8 = (net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify) r8
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse r8 = r8.getResponse()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getVerifyId()
            r7.m = r0
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody$CJRVerifierDoVerifyResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getResultMsg()
            java.lang.String r1 = "SUCCESS"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x01d1
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getNextMethod()
            if (r0 == 0) goto L_0x0188
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getNextMethod()
            r7.n = r0
        L_0x0188:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getIsFinish()
            if (r0 == 0) goto L_0x01c1
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getIsFinish()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x01c1
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody$CJRVerifierDoVerifyResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getResultCode()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x01c1
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r0 = r0.getRenderData()
            java.lang.String r0 = r0.getCallbackUrl()
            r7.b((java.lang.String) r0)
        L_0x01c1:
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify.CJRVerifierDoVerifyResponse) r8)
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r7.r
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierRenderData) r8, (java.lang.String) r3)
            java.lang.String r8 = r7.n
            if (r8 == 0) goto L_0x01d0
            r7.a((java.lang.String) r8)
        L_0x01d0:
            return
        L_0x01d1:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getCanRetry()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x020a
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getCanRetry()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x020a
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody$CJRVerifierDoVerifyResultInfo r0 = r0.getResultInfo()
            r0.getResultMsg()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r0 = r7.r
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r8 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody$CJRVerifierDoVerifyResultInfo r8 = r8.getResultInfo()
            java.lang.String r8 = r8.getResultMsg()
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierRenderData) r0, (java.lang.String) r8)
            return
        L_0x020a:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getIsFinish()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x024c
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getIsFinish()
            java.lang.String r1 = "false"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x024c
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r0 = r8.getBody()
            java.lang.String r0 = r0.getNextMethod()
            r7.n = r0
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify.CJRVerifierDoVerifyResponse) r8)
            java.lang.String r0 = r7.n
            r7.a((java.lang.String) r0)
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r0 = r7.r
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r8 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody$CJRVerifierDoVerifyResultInfo r8 = r8.getResultInfo()
            java.lang.String r8 = r8.getResultMsg()
            r7.a((net.one97.paytm.common.entity.verifier.CJRVerifierRenderData) r0, (java.lang.String) r8)
            return
        L_0x024c:
            net.one97.paytm.common.entity.verifier.CJRVerifierDoVerify$CJRVerifierDoVerifyResponse$CJRVerifierDoVerifyBody r8 = r8.getBody()
            net.one97.paytm.common.entity.verifier.CJRVerifierRenderData r8 = r8.getRenderData()
            java.lang.String r8 = r8.getCallbackUrl()
            r7.b((java.lang.String) r8)
        L_0x025b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.verifier.activity.VerificationProcessActivity.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private void a(CJRVerifierDoVerify.CJRVerifierDoVerifyResponse cJRVerifierDoVerifyResponse) {
        a("", "");
        if (cJRVerifierDoVerifyResponse.getBody().getRenderData() != null) {
            this.r = cJRVerifierDoVerifyResponse.getBody().getRenderData();
            if (this.r.getEncryption() != null && this.r.getEncryption().equalsIgnoreCase("true")) {
                a(cJRVerifierDoVerifyResponse.getBody().getRenderData().getAccountEncryptPubkey(), cJRVerifierDoVerifyResponse.getBody().getRenderData().getAccountEncryptSalt());
            }
        }
    }

    private void a(String str) {
        LinearLayout linearLayout = this.f69814b;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (str.equalsIgnoreCase("MENU")) {
            Intent intent = new Intent(this, VerificationSelectionActivity.class);
            intent.putExtra("menu_response", this.p);
            intent.putExtra("verifier_last_method", this.B);
            startActivityForResult(intent, 2021);
            return;
        }
        CJRVerifierRenderData cJRVerifierRenderData = this.r;
        if (cJRVerifierRenderData == null || !"numeric".equalsIgnoreCase(cJRVerifierRenderData.getInputType())) {
            this.o = false;
            this.f69814b.setVisibility(8);
            this.f69815c.setVisibility(0);
            a((EditText) this.f69816d);
            return;
        }
        this.o = true;
        this.f69814b.setVisibility(0);
        this.f69815c.setVisibility(8);
        a();
    }

    private void a(boolean z2) {
        try {
            if (this.y == null) {
                this.y = new CustomWalletLoaderDialog(this);
            }
            if (z2) {
                this.w.setVisibility(8);
                this.y.showLoader();
                return;
            }
            this.w.setVisibility(0);
            this.y.dismissLoader();
            f();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(false);
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.t = str;
        } else {
            this.t = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.u = str2;
        } else {
            this.u = "";
        }
    }

    private boolean b() {
        return !TextUtils.isEmpty(this.t) && !TextUtils.isEmpty(this.u);
    }

    private void c() {
        if (this.o) {
            for (int i2 = 0; i2 < this.q; i2++) {
                ((EditText) this.f69814b.findViewById(i2)).setText("");
            }
            return;
        }
        this.f69816d.setText("");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 2021 || i3 != -1) {
            return;
        }
        if (intent != null && intent.hasExtra("verifier_callback_url")) {
            b(intent.getStringExtra("verifier_callback_url"));
        } else if (intent != null && intent.hasExtra("verifier_verifyID")) {
            this.m = intent.getStringExtra("verifier_verifyID");
            this.n = intent.getStringExtra("verifier_method");
            a("", "");
            e();
            net.one97.paytm.verifier.a.b.a(this, this, this.m, this.n);
        }
    }

    private void b(String str) {
        Intent intent = new Intent();
        intent.putExtra("verifier_callback_url", str);
        setResult(-1, intent);
        finish();
    }

    private void d() {
        try {
            this.j.setClickable(false);
            this.j.setTextColor(Color.parseColor("#999999"));
            if (this.E != null) {
                this.E.cancel();
                this.E.start();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void e() {
        z zVar = this.x;
        if (zVar != null && !zVar.isShowing()) {
            this.x.show();
        }
    }

    private void f() {
        z zVar = this.x;
        if (zVar != null && zVar.isShowing()) {
            this.x.dismiss();
        }
    }

    private void g() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (!this.o || this.z == null) {
                this.f69816d.requestFocus();
                inputMethodManager.showSoftInput(this.f69816d, 2);
                return;
            }
            this.z.requestFocus();
            inputMethodManager.showSoftInput(this.z, 2);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ boolean a(EditText editText, EditText editText2, boolean z2) {
        if (z2) {
            if (!editText.getText().toString().equals("")) {
                if (editText.getSelectionStart() != 0 || editText.getSelectionEnd() != 0) {
                    return false;
                }
                editText.setText("");
            } else if (editText2 != null) {
                editText2.setText("");
                editText2.setEnabled(true);
                editText2.requestFocus();
            }
        }
        return true;
    }
}
