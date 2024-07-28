package net.one97.paytm.payments.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.widgets.PasscodeEditText;
import net.one97.paytm.payments.model.CJROauthAadharValidate;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.a;
import org.json.JSONObject;

public class AadharValidatePasscode extends PBBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f17182b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public PasscodeEditText f17183c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public PasscodeEditText f17184d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public PasscodeEditText f17185e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public PasscodeEditText f17186f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17187g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17188h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnKeyListener f17189i = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67 || keyEvent.getAction() != 0) {
                return false;
            }
            if (view == AadharValidatePasscode.this.f17183c) {
                AadharValidatePasscode.a(AadharValidatePasscode.this.f17183c, (EditText) null);
                return true;
            } else if (view == AadharValidatePasscode.this.f17184d) {
                AadharValidatePasscode.a(AadharValidatePasscode.this.f17184d, AadharValidatePasscode.this.f17183c);
                return true;
            } else if (view == AadharValidatePasscode.this.f17185e) {
                AadharValidatePasscode.a(AadharValidatePasscode.this.f17185e, AadharValidatePasscode.this.f17184d);
                return true;
            } else if (view != AadharValidatePasscode.this.f17186f) {
                return true;
            } else {
                AadharValidatePasscode.a(AadharValidatePasscode.this.f17186f, AadharValidatePasscode.this.f17185e);
                return true;
            }
        }
    };
    private TextWatcher j = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AadharValidatePasscode.this.a(false);
            AadharValidatePasscode.this.f17182b.setVisibility(8);
            AadharValidatePasscode.this.f17182b.setText("");
        }

        public final void afterTextChanged(Editable editable) {
            AadharValidatePasscode.this.e();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_aadhar_validate_passcode);
        String string = getString(R.string.pb_forgot_paytm_passcode);
        if (getIntent() != null && getIntent().hasExtra("title")) {
            string = getIntent().getStringExtra("title");
        }
        setTitle(string);
        ag_();
        this.f17182b = (TextView) findViewById(R.id.forgot_passcode_error_text);
        this.f17187g = (TextView) findViewById(R.id.forgot_passcode_title_text);
        findViewById(R.id.layout_aadhar_number);
        this.f17183c = (PasscodeEditText) findViewById(R.id.aadhar_edt_char1);
        this.f17184d = (PasscodeEditText) findViewById(R.id.aadhar_edt_char2);
        this.f17185e = (PasscodeEditText) findViewById(R.id.aadhar_edt_char3);
        this.f17186f = (PasscodeEditText) findViewById(R.id.aadhar_edt_char4);
        this.f17183c.addTextChangedListener(this.j);
        this.f17184d.addTextChangedListener(this.j);
        this.f17185e.addTextChangedListener(this.j);
        this.f17186f.addTextChangedListener(this.j);
        this.f17183c.setOnKeyListener(this.f17189i);
        this.f17184d.setOnKeyListener(this.f17189i);
        this.f17185e.setOnKeyListener(this.f17189i);
        this.f17186f.setOnKeyListener(this.f17189i);
        this.f17188h = (TextView) findViewById(R.id.hint_tv);
        ((TextView) findViewById(R.id.forgot_passcode_ok_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AadharValidatePasscode.this.a(view);
            }
        });
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AadharValidatePasscode.this.g();
            }
        }, 100);
        if (getIntent() != null && getIntent().hasExtra("subTitle")) {
            String stringExtra = getIntent().getStringExtra("subTitle");
            this.f17187g.setText(stringExtra);
            if (stringExtra.contains(a.C0315a.AADHAR.getPrimaryDocument())) {
                this.f17183c.setInputType(2);
                this.f17184d.setInputType(2);
                this.f17185e.setInputType(2);
                this.f17186f.setInputType(2);
                this.f17188h.setVisibility(8);
                return;
            }
            this.f17188h.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        Drawable drawable;
        int i2 = z ? R.drawable.pb_passcode_edt_error_bg : R.drawable.pb_passcode_edt_bg;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = getResources().getDrawable(i2, getTheme());
        } else {
            drawable = getResources().getDrawable(i2);
        }
        this.f17183c.setBackground(drawable);
        this.f17184d.setBackground(drawable);
        this.f17185e.setBackground(drawable);
        this.f17186f.setBackground(drawable);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null) {
            ah_();
            if (iJRPaytmDataModel instanceof CJROauthAadharValidate) {
                CJROauthAadharValidate cJROauthAadharValidate = (CJROauthAadharValidate) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(cJROauthAadharValidate.getAccessToken())) {
                    Intent intent = new Intent();
                    intent.putExtra("forgot_passcode_access", cJROauthAadharValidate.getAccessToken());
                    setResult(-1, intent);
                    finish();
                } else if ("FAILURE".equalsIgnoreCase(cJROauthAadharValidate.getStatus())) {
                    a(true);
                    b.b((Context) this, getString(R.string.error), cJROauthAadharValidate.getMessage());
                    f();
                } else {
                    a(true);
                    b.b((Context) this, getString(R.string.error), getString(R.string.some_went_wrong));
                    f();
                }
            }
        }
    }

    public void onBackPressed() {
        setResult(0, getIntent());
        super.onBackPressed();
    }

    private void f() {
        this.f17183c.removeTextChangedListener(this.j);
        this.f17184d.removeTextChangedListener(this.j);
        this.f17185e.removeTextChangedListener(this.j);
        this.f17186f.removeTextChangedListener(this.j);
        this.f17183c.setText("");
        this.f17184d.setText("");
        this.f17185e.setText("");
        this.f17186f.setText("");
        this.f17183c.requestFocus();
        this.f17183c.addTextChangedListener(this.j);
        this.f17184d.addTextChangedListener(this.j);
        this.f17185e.addTextChangedListener(this.j);
        this.f17186f.addTextChangedListener(this.j);
    }

    /* access modifiers changed from: private */
    public void e() {
        String str = "";
        if (TextUtils.isEmpty(this.f17183c.getText().toString())) {
            this.f17183c.requestFocus();
        } else if (TextUtils.isEmpty(this.f17184d.getText().toString())) {
            this.f17184d.requestFocus();
        } else if (TextUtils.isEmpty(this.f17185e.getText().toString())) {
            this.f17185e.requestFocus();
        } else if (TextUtils.isEmpty(this.f17186f.getText().toString())) {
            this.f17186f.requestFocus();
        } else {
            str = this.f17183c.getText().toString() + this.f17184d.getText().toString() + this.f17185e.getText().toString() + this.f17186f.getText().toString();
        }
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            g.a();
            String a2 = d.a("oauth_aadhar_validate");
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e((Context) this, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", com.paytm.utility.a.q(this));
                hashMap.put("Authorization", b.m());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("docType", "FIRST_FOUR_AADHAAR");
                    d.b();
                    jSONObject.put("docValue", com.paytm.e.a.b.a(d.a("pb_rsa_key"), str));
                    jSONObject.put("scope", "reset_secret");
                    String jSONObject2 = jSONObject.toString();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("screen_name", getClass().getSimpleName());
                    net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new CJROauthAadharValidate(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject2, a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
                    if (b.c((Context) this)) {
                        a(this, getString(R.string.please_wait));
                        new c();
                        c.a(bVar);
                        return;
                    }
                    a(bVar);
                } catch (Exception unused) {
                }
            }
        }
    }

    static /* synthetic */ void a(EditText editText, EditText editText2) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            editText.setText("");
        } else if (editText2 != null) {
            editText2.setText("");
            editText2.setEnabled(true);
            editText2.requestFocus();
        }
    }
}
