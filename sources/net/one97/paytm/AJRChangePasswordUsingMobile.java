package net.one97.paytm;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRVarifyOtp;
import net.one97.paytm.common.entity.ResetLoginPassword;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.utility.c;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import org.json.JSONObject;

public class AJRChangePasswordUsingMobile extends CJRActionBarBaseActivity implements View.OnClickListener {
    private ImageView C;

    /* renamed from: a  reason: collision with root package name */
    private Button f51329a;

    /* renamed from: b  reason: collision with root package name */
    private AppCompatEditText f51330b;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatEditText f51331c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f51332d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f51333e;

    /* renamed from: f  reason: collision with root package name */
    private String f51334f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f51335g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f51336h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f51337i;
    private boolean j = true;
    private boolean k = true;
    private ImageView l;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.activity_change_password, (ViewGroup) null));
        if (getIntent().getStringExtra("change_password_code") != null) {
            this.f51334f = getIntent().getStringExtra("change_password_code");
        }
        this.f51335g = getIntent().getBooleanExtra("change_password_new_api", false);
        setTitle(getResources().getString(R.string.new_password_create));
        this.f51333e = getResources();
        r();
        p();
        o();
        setTitle(getResources().getString(R.string.change_paytm_password));
        this.f51329a = (Button) findViewById(R.id.btn_save);
        this.f51332d = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        this.f51330b = (AppCompatEditText) findViewById(R.id.new_password);
        this.f51331c = (AppCompatEditText) findViewById(R.id.new_password_check);
        this.f51336h = (TextView) findViewById(R.id.forgot_password_txt);
        this.f51337i = (RelativeLayout) findViewById(R.id.lyt_current_password);
        this.l = (ImageView) findViewById(R.id.cross_button_new_pwd);
        this.C = (ImageView) findViewById(R.id.cross_button_new_pwd_check);
        this.f51337i.setVisibility(8);
        this.f51336h.setVisibility(8);
        ((TextView) findViewById(R.id.password_change_txt)).setText(R.string.password_change_info);
        this.f51329a.setText(R.string.save);
        this.f51336h.setText(getResources().getString(R.string.forgot_password));
        ((AppCompatEditText) findViewById(R.id.current_password)).setText(R.string.current_password);
        this.f51330b.setText(R.string.new_paytm_password);
        this.f51331c.setText(R.string.retype_new_password);
        int t = ((int) ((float) a.t(this))) / 2;
        findViewById(R.id.lyt_change_password).setPadding(t, t, t, t);
        this.f51329a.setOnClickListener(this);
        if (!TextUtils.isEmpty(getIntent().getStringExtra("extra_home_data"))) {
            TextView textView = (TextView) findViewById(R.id.txt_description);
            textView.setVisibility(0);
            textView.setText(getString(R.string.please_select_new_password_msg, new Object[]{getIntent().getStringExtra("extra_home_data")}));
        } else {
            findViewById(R.id.txt_description).setVisibility(8);
        }
        b.c((TextView) this.f51329a);
        int t2 = a.t(this) / 2;
        this.f51330b.setPadding(0, t2, 0, t2);
        this.f51331c.setPadding(0, t2, 0, t2);
        ((RelativeLayout.LayoutParams) this.f51329a.getLayoutParams()).setMargins(0, t2, 0, 0);
        this.f51330b.requestFocus();
        this.l.setVisibility(0);
        this.l.setImageResource(R.drawable.showpassword);
        this.f51330b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AJRChangePasswordUsingMobile.this.b(view, z);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRChangePasswordUsingMobile.this.b(view);
            }
        });
        this.f51331c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AJRChangePasswordUsingMobile.this.a(view, z);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRChangePasswordUsingMobile.this.a(view);
            }
        });
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, boolean z) {
        this.l.setVisibility(0);
        if (!z) {
            this.l.setImageResource(R.drawable.cross_grey);
        } else if (this.j) {
            this.l.setImageResource(R.drawable.showpassword);
        } else {
            this.l.setImageResource(R.drawable.hidepasswrd);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (!this.f51330b.hasFocus()) {
            this.f51330b.setText("");
        } else if (!this.j) {
            this.f51330b.setTransformationMethod(new PasswordTransformationMethod());
            this.j = true;
            this.l.setImageResource(R.drawable.showpassword);
        } else {
            this.f51330b.setTransformationMethod((TransformationMethod) null);
            this.j = false;
            this.l.setImageResource(R.drawable.hidepasswrd);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z) {
        this.C.setVisibility(0);
        if (!z) {
            this.C.setImageResource(R.drawable.cross_grey);
        } else if (this.k) {
            this.C.setImageResource(R.drawable.showpassword);
        } else {
            this.C.setImageResource(R.drawable.hidepasswrd);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!this.f51331c.hasFocus()) {
            this.f51331c.setText("");
        } else if (!this.k) {
            this.f51331c.setTransformationMethod(new PasswordTransformationMethod());
            this.k = true;
            this.C.setImageResource(R.drawable.showpassword);
        } else {
            this.f51331c.setTransformationMethod((TransformationMethod) null);
            this.k = false;
            this.C.setImageResource(R.drawable.hidepasswrd);
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

    private void b() {
        this.f51330b.setText("");
        this.f51331c.setText("");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f51332d.setVisibility(8);
        if (iJRPaytmDataModel instanceof CJRVarifyOtp) {
            CJRVarifyOtp cJRVarifyOtp = (CJRVarifyOtp) iJRPaytmDataModel;
            if (TextUtils.isEmpty(cJRVarifyOtp.getStatus()) || !cJRVarifyOtp.getStatus().equalsIgnoreCase("SUCCESS")) {
                b.b((Context) this, getResources().getString(R.string.error), cJRVarifyOtp.getMessage());
                b();
                return;
            }
            Toast.makeText(this, this.f51333e.getString(R.string.msg_password_changed), 0).show();
            finish();
            try {
                c.a(this, "favorite_number_list");
                if (a.m(this)) {
                    net.one97.paytm.j.c.a();
                    String a2 = net.one97.paytm.j.c.a("signout", (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Authorization", b.m());
                    hashMap.put("access_token", t.b((Context) this));
                    if (a2 != null) {
                        a.c();
                        d.a(this, a2, new com.paytm.network.listener.b() {
                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            }

                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            }
                        }, hashMap, (Map<String, String>) null, a.C0715a.DELETE, (String) null, (IJRPaytmDataModel) null, a.c.AUTH, a.b.SILENT).a();
                    }
                }
            } catch (Exception e2) {
                try {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                } catch (Exception e3) {
                    q.b(e3.getMessage());
                    return;
                }
            }
            com.paytm.b.a.a a3 = ag.a(getApplicationContext());
            a3.a("sso_token=", (String) null, true);
            a3.a("first name", (String) null, true);
            a3.a("last name", (String) null, true);
            a3.a(AppConstants.KEY_EMAIL, (String) null, true);
            a3.a("mobile", (String) null, true);
            a3.a("user_dob", (String) null, true);
            a3.a("user_gender", (String) null, true);
            a3.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, (String) null, true);
            t.b(this, "0");
            t.a((Context) this, 0);
            t.b(this, "0");
            t.a((Context) this, (String) null);
            Intent intent = new Intent(this, AJRMainActivity.class);
            intent.putExtra("intent_extra_start_login", true);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "featured");
            intent.putExtra("resultant fragment position", 0);
            startActivity(intent);
        } else if (iJRPaytmDataModel instanceof ResetLoginPassword) {
            m();
            ResetLoginPassword resetLoginPassword = (ResetLoginPassword) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(resetLoginPassword.getStatus()) && resetLoginPassword.getStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                b.b((Context) this, getResources().getString(R.string.error), resetLoginPassword.getMessage());
                b();
            } else if (!TextUtils.isEmpty(resetLoginPassword.getCode())) {
                Intent intent2 = getIntent();
                intent2.putExtra("code", resetLoginPassword.getCode());
                intent2.putExtra("newPassword", this.f51330b.getText().toString());
                setResult(-1, intent2);
                finish();
            } else if (!TextUtils.isEmpty(resetLoginPassword.getStatusCode()) && resetLoginPassword.getStatusCode().equals(WebLogin.RESPONSE_CODE_SUCCESS) && !TextUtils.isEmpty(resetLoginPassword.getState()) && !TextUtils.isEmpty(resetLoginPassword.getDisplayMessage())) {
                Intent intent3 = getIntent();
                intent3.putExtra("state", resetLoginPassword.getState());
                intent3.putExtra("displayMessage", resetLoginPassword.getDisplayMessage());
                intent3.putExtra("newPassword", this.f51330b.getText().toString());
                setResult(-1, intent3);
                finish();
            }
        }
    }

    public void onClick(View view) {
        boolean z;
        if (view.getId() == R.id.btn_save) {
            String obj = this.f51330b.getText().toString();
            String obj2 = this.f51331c.getText().toString();
            if (obj == null || obj2 == null || obj.trim().length() <= 0 || obj2.trim().length() <= 0) {
                b.b((Context) this, "", getResources().getString(R.string.fill_all_fields));
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
            if (this.f51335g) {
                String obj3 = this.f51330b.getText().toString();
                String obj4 = this.f51331c.getText().toString();
                net.one97.paytm.j.c.a();
                String a2 = net.one97.paytm.j.c.a("resetLoginPassword", (String) null);
                if (a2 == null) {
                    b.b((Context) this, "", getResources().getString(R.string.bad_url));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", this.f51334f);
                    jSONObject.put("password", obj4);
                    jSONObject.put("confirmpassword", obj3);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                com.paytm.network.a a3 = d.a(this, a2, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new ResetLoginPassword(), a.c.AUTH, a.b.SILENT);
                if (com.paytm.utility.a.m(this)) {
                    a((Context) this, getString(R.string.changing_password));
                    a3.a();
                    return;
                }
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
                return;
            }
            String obj5 = this.f51330b.getText().toString();
            String obj6 = this.f51331c.getText().toString();
            net.one97.paytm.j.c.a();
            String a4 = net.one97.paytm.j.c.a("resetPassword", (String) null);
            if (a4 == null) {
                b.b((Context) this, "", getResources().getString(R.string.bad_url));
                return;
            }
            StringBuilder sb = new StringBuilder("url:");
            net.one97.paytm.j.c.a();
            sb.append(net.one97.paytm.j.c.a("resetPassword", (String) null));
            com.paytm.utility.a.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", this.f51334f);
                jSONObject2.put("password", obj6);
                jSONObject2.put("confirmPassword", obj5);
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            new StringBuilder("params:").append(jSONObject2.toString());
            com.paytm.utility.a.c();
            a.C0715a aVar = a.C0715a.POST;
            String jSONObject3 = jSONObject2.toString();
            com.paytm.network.a a5 = d.a(this, a4, this, (Map<String, String>) null, (Map<String, String>) null, aVar, jSONObject3, new CJRVarifyOtp(), a.c.AUTH, a.b.SILENT);
            if (com.paytm.utility.a.m(this)) {
                a5.a();
                this.f51332d.setVisibility(0);
                return;
            }
            r.a(a5, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }
}
