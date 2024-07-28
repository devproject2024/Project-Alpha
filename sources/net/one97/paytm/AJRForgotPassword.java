package net.one97.paytm;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gsonhtcfix.o;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRForgetPassword;
import net.one97.paytm.common.entity.CJRResetPassword;
import net.one97.paytm.common.entity.CJRVarifyOtp;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.CJRSmsReceiver;
import net.one97.paytm.utils.ah;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRForgotPassword extends CJRActionBarBaseActivity implements o, ah {

    /* renamed from: a  reason: collision with root package name */
    protected View.OnFocusChangeListener f51358a = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            View findViewById = AJRForgotPassword.this.findViewById(R.id.sep_1);
            if (findViewById == null) {
                return;
            }
            if (z) {
                findViewById.setBackgroundResource(R.drawable.edit_view_divider_selected);
            } else {
                findViewById.setBackgroundResource(R.drawable.edit_view_divider);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f51359b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f51360c;

    /* renamed from: d  reason: collision with root package name */
    private Button f51361d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Boolean f51362e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    private d f51363f;

    /* renamed from: g  reason: collision with root package name */
    private CJRSmsReceiver f51364g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputLayout f51365h;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.forgot_password, (ViewGroup) null));
        p();
        o();
        setTitle(getResources().getString(R.string.change_paytm_password));
        r();
        this.f51360c = (EditText) findViewById(R.id.edit_username);
        this.f51360c.setOnFocusChangeListener(this.f51358a);
        this.f51365h = (TextInputLayout) findViewById(R.id.text_input_username);
        this.f51361d = (Button) findViewById(R.id.get_password_btn);
        this.f51361d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Boolean unused = AJRForgotPassword.this.f51362e = Boolean.FALSE;
                AJRForgotPassword.this.b();
            }
        });
        if (getIntent().hasExtra("userName")) {
            ((EditText) findViewById(R.id.edit_username)).setText(getIntent().getStringExtra("userName"));
            b();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        u();
    }

    private boolean d() {
        return Pattern.compile("^[5789][0-9]{9}$").matcher(this.f51360c.getText().toString()).find();
    }

    private boolean e() {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*(\\+[_A-Za-z0-9-]+){0,1}@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(this.f51360c.getText().toString()).find();
    }

    public final void b() {
        boolean z;
        try {
            HashMap hashMap = new HashMap();
            String obj = ((EditText) findViewById(R.id.edit_username)).getText().toString();
            if (TextUtils.isEmpty(obj)) {
                this.f51365h.setError(getResources().getString(R.string.username_error));
                return;
            }
            this.f51359b = TextUtils.isDigitsOnly(obj);
            if (this.f51359b) {
                z = d();
            } else {
                z = e();
            }
            if (z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("username", obj);
                    jSONObject.put("sendotp", "both");
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Authorization", b.m());
                c.a();
                a a2 = d.a(this, b.e((Context) this, c.a("forgotPassword", (String) null)), this, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRForgetPassword(), a.c.AUTH, a.b.USER_FACING);
                if (com.paytm.utility.a.m(this)) {
                    a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
                    a2.a();
                    return;
                }
                r.a(a2, (Context) this, (DialogInterface.OnCancelListener) this);
            } else if (this.f51359b) {
                this.f51365h.setError(getResources().getString(R.string.valid_mobile_number_msg));
            } else {
                this.f51365h.setError(getResources().getString(R.string.valid_email_id_msg));
            }
        } catch (Exception unused) {
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        d dVar;
        if (iJRPaytmDataModel instanceof CJRForgetPassword) {
            m();
            CJRForgetPassword cJRForgetPassword = (CJRForgetPassword) iJRPaytmDataModel;
            String status = cJRForgetPassword.getStatus();
            if (TextUtils.isEmpty(status) || !status.equalsIgnoreCase("SUCCESS")) {
                if (!TextUtils.isEmpty(cJRForgetPassword.getError())) {
                    b.b((Context) this, getResources().getString(R.string.error), cJRForgetPassword.getError());
                }
            } else if (cJRForgetPassword.getType().equalsIgnoreCase(AppConstants.KEY_EMAIL)) {
                if (!TextUtils.isEmpty(cJRForgetPassword.getMessage())) {
                    b.b((Context) this, "", cJRForgetPassword.getMessage());
                } else {
                    b.b((Context) this, "", getResources().getString(R.string.forgot_password_email_msg));
                }
            } else if (!this.f51362e.booleanValue()) {
                f();
                if (!isFinishing()) {
                    String code = cJRForgetPassword.getCode();
                    String detail = cJRForgetPassword.getDetail();
                    String userName = cJRForgetPassword.getUserName();
                    String string = getString(R.string.change_password_enter_otp, new Object[]{this.f51360c.getText().toString()});
                    String str = string + getResources().getString(R.string.enter_new_password);
                    if (detail != null) {
                        if (TextUtils.isDigitsOnly(this.f51360c.getText().toString())) {
                            str = string + getString(R.string.enter_otp_sent_mail, new Object[]{detail});
                        } else {
                            str = getString(R.string.instruction_sent_mail, new Object[]{this.f51360c.getText().toString()}) + getString(R.string.reset_enter_otp, new Object[]{userName}) + " " + getResources().getString(R.string.fp_create_new_password);
                        }
                    }
                    d dVar2 = this.f51363f;
                    if (dVar2 != null && dVar2.isShowing()) {
                        this.f51363f.dismiss();
                    }
                    this.f51363f = new d(this, str, code, this);
                    this.f51363f.setCanceledOnTouchOutside(false);
                    this.f51363f.show();
                }
            } else {
                f();
            }
        } else if (iJRPaytmDataModel instanceof CJRVarifyOtp) {
            m();
            CJRVarifyOtp cJRVarifyOtp = (CJRVarifyOtp) iJRPaytmDataModel;
            String status2 = cJRVarifyOtp.getStatus();
            if (!TextUtils.isEmpty(status2) && status2.equalsIgnoreCase("SUCCESS")) {
                d dVar3 = this.f51363f;
                if (dVar3 != null && dVar3.isShowing()) {
                    this.f51363f.dismiss();
                }
                Intent intent = new Intent(this, AJRChangePasswordUsingMobile.class);
                intent.putExtra("change_password_code", cJRVarifyOtp.getCode());
                if (!TextUtils.isEmpty(this.f51360c.getText().toString())) {
                    intent.putExtra("extra_home_data", this.f51360c.getText().toString());
                }
                startActivity(intent);
                finish();
            } else if (!TextUtils.isEmpty(cJRVarifyOtp.getMessage()) && (dVar = this.f51363f) != null && dVar.isShowing()) {
                this.f51363f.a(cJRVarifyOtp.getMessage());
                d dVar4 = this.f51363f;
                if (dVar4.f52353a != null) {
                    dVar4.f52353a.setEnabled(true);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRResetPassword) {
            m();
            CJRResetPassword cJRResetPassword = (CJRResetPassword) iJRPaytmDataModel;
            String status3 = cJRResetPassword.getStatus();
            if (!TextUtils.isEmpty(status3) && status3.equalsIgnoreCase("SUCCESS")) {
                b.b((Context) this, getResources().getString(R.string.contact_us_success), cJRResetPassword.getMessage());
            } else if (!TextUtils.isEmpty(cJRResetPassword.getMessage())) {
                b.b((Context) this, getResources().getString(R.string.error), cJRResetPassword.getMessage());
            }
        }
    }

    private void f() {
        try {
            if (!isFinishing()) {
                if ((!s.a() || s.d((Context) this)) && this.f51364g == null) {
                    this.f51364g = new CJRSmsReceiver();
                    this.f51364g.f69560a = this;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                    intentFilter.setPriority(1000);
                    registerReceiver(this.f51364g, intentFilter);
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getSimpleName());
                    sb.append(" : register");
                    com.paytm.utility.a.c();
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void u() {
        try {
            if (this.f51364g != null) {
                unregisterReceiver(this.f51364g);
                this.f51364g.f69560a = null;
                this.f51364g = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                com.paytm.utility.a.c();
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        m();
        if (networkCustomError != null && networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                return;
            }
            b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        j();
        k();
        return super.onPrepareOptionsMenu(menu);
    }

    public final void c() {
        this.f51362e = Boolean.TRUE;
        b();
    }

    public final void b(String str, String str2) {
        d dVar;
        String e2;
        if (!isFinishing() && (dVar = this.f51363f) != null && dVar.isShowing() && (e2 = b.e(str, str2)) != null) {
            d dVar2 = this.f51363f;
            if (!(e2 == null || dVar2.f52354b == null)) {
                dVar2.f52354b.setText(e2);
            }
            u();
        }
    }

    public final void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
        o oVar = new o();
        oVar.a("code", str2);
        oVar.a("otp", str);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Authorization", b.m());
        c.a();
        String a2 = c.a("forgotPasswordOTP", (String) null);
        if (a2 == null) {
            b.b((Context) this, "", getResources().getString(R.string.bad_url));
            return;
        }
        a a3 = d.a(this, a2, this, hashMap, (Map<String, String>) null, a.C0715a.POST, oVar.toString(), new CJRVarifyOtp(), a.c.AUTH, a.b.USER_FACING);
        if (com.paytm.utility.a.m(this)) {
            a3.a();
        } else {
            r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }
}
