package net.one97.paytm.oauth.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.k;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.a;
import net.one97.paytm.oauth.models.CJRChangePwdStatus;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.t;
import net.one97.paytm.oauth.view.PasswordStrengthLayout;

public class AJRChangePassword extends OAuthBaseActivity implements View.OnClickListener, t {

    /* renamed from: a  reason: collision with root package name */
    private Button f52486a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AppCompatEditText f52487b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppCompatEditText f52488c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppCompatEditText f52489d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52490e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52491f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f52492g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f52493h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f52494i = true;
    /* access modifiers changed from: private */
    public boolean j = true;
    /* access modifiers changed from: private */
    public boolean k = true;
    /* access modifiers changed from: private */
    public boolean l = true;
    private TextView m;
    /* access modifiers changed from: private */
    public PasswordStrengthLayout n;
    private TextInputLayout o;
    private TextInputLayout p;
    private TextInputLayout q;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_change_password);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        setTitle(getResources().getString(R.string.change_password));
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.b(true);
        supportActionBar.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        supportActionBar.a(1.0f);
        this.f52486a = (Button) findViewById(R.id.btn_save);
        this.f52487b = (AppCompatEditText) findViewById(R.id.current_password);
        this.f52488c = (AppCompatEditText) findViewById(R.id.new_password);
        this.f52489d = (AppCompatEditText) findViewById(R.id.new_password_check);
        this.f52490e = (ImageView) findViewById(R.id.cross_button_current_pwd);
        this.f52491f = (ImageView) findViewById(R.id.cross_button_new_pwd);
        this.f52492g = (ImageView) findViewById(R.id.cross_button_new_pwd_check);
        this.m = (TextView) findViewById(R.id.forgot_password_txt);
        this.f52488c.setFilters(new InputFilter[]{OAuthUtils.f56746a});
        this.f52489d.setFilters(new InputFilter[]{OAuthUtils.f56746a});
        this.n = (PasswordStrengthLayout) findViewById(R.id.layoutPwdStrength);
        this.f52493h = (CheckBox) findViewById(R.id.checkboxLogOutAllDevices);
        this.f52487b.setVisibility(0);
        this.f52486a.setOnClickListener(this);
        this.f52486a.setText(R.string.label_update_password);
        this.m.setText(R.string.forgot_password);
        this.o = (TextInputLayout) findViewById(R.id.tilCurrentPwd);
        this.p = (TextInputLayout) findViewById(R.id.tilNewPwd);
        this.q = (TextInputLayout) findViewById(R.id.tilRetypeNewPwd);
        this.o.setHint(getString(R.string.current_password));
        this.p.setHint(getString(R.string.new_paytm_password));
        this.q.setHint(getString(R.string.retype_new_password));
        b.c((TextView) this.f52486a);
        a.a();
        this.l = a.a("oauthCheckboxPassword", true);
        a(this.f52493h);
        a.a();
        a(Boolean.valueOf(a.a("oauthCheckboxPassword", true)), this.f52493h);
        this.f52487b.requestFocus();
        this.f52490e.setVisibility(0);
        this.f52490e.setImageResource(R.drawable.hidepasswrd);
        this.f52487b.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == 0) {
                    AJRChangePassword.this.f52490e.setVisibility(4);
                } else {
                    AJRChangePassword.this.f52490e.setVisibility(0);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    AJRChangePassword.b("current_password_entered", (ArrayList<String>) new ArrayList());
                }
            }
        });
        this.f52487b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    AJRChangePassword.this.f52490e.setImageResource(R.drawable.cross_grey);
                } else if (AJRChangePassword.this.f52494i) {
                    AJRChangePassword.this.f52490e.setImageResource(R.drawable.hidepasswrd);
                } else {
                    AJRChangePassword.this.f52490e.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52490e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!AJRChangePassword.this.f52487b.hasFocus()) {
                    AJRChangePassword.this.f52487b.setText("");
                } else if (!AJRChangePassword.this.f52494i) {
                    AJRChangePassword.this.f52487b.setTransformationMethod(new PasswordTransformationMethod());
                    boolean unused = AJRChangePassword.this.f52494i = true;
                    AJRChangePassword.this.f52490e.setImageResource(R.drawable.hidepasswrd);
                } else {
                    AJRChangePassword.this.f52487b.setTransformationMethod((TransformationMethod) null);
                    boolean unused2 = AJRChangePassword.this.f52494i = false;
                    AJRChangePassword.this.f52490e.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52488c.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == 0) {
                    AJRChangePassword.this.f52491f.setVisibility(4);
                } else {
                    AJRChangePassword.this.f52491f.setVisibility(0);
                }
            }

            public final void afterTextChanged(Editable editable) {
                AJRChangePassword.this.n.a(editable.toString());
                if (editable.length() == 1) {
                    AJRChangePassword.b("new_password_entered", (ArrayList<String>) new ArrayList());
                }
            }
        });
        this.f52488c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AJRChangePassword.this.f52491f.setVisibility(0);
                if (!z) {
                    AJRChangePassword.this.f52491f.setImageResource(R.drawable.cross_grey);
                    AJRChangePassword.this.n.setVisibility(8);
                    return;
                }
                AJRChangePassword.this.n.setVisibility(0);
                if (AJRChangePassword.this.j) {
                    AJRChangePassword.this.f52491f.setImageResource(R.drawable.hidepasswrd);
                } else {
                    AJRChangePassword.this.f52491f.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52491f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!AJRChangePassword.this.f52488c.hasFocus()) {
                    AJRChangePassword.this.f52488c.setText("");
                } else if (!AJRChangePassword.this.j) {
                    AJRChangePassword.this.f52488c.setTransformationMethod(new PasswordTransformationMethod());
                    boolean unused = AJRChangePassword.this.j = true;
                    AJRChangePassword.this.f52491f.setImageResource(R.drawable.hidepasswrd);
                } else {
                    AJRChangePassword.this.f52488c.setTransformationMethod((TransformationMethod) null);
                    boolean unused2 = AJRChangePassword.this.j = false;
                    AJRChangePassword.this.f52491f.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52489d.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == 0) {
                    AJRChangePassword.this.f52492g.setVisibility(4);
                } else {
                    AJRChangePassword.this.f52492g.setVisibility(0);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    AJRChangePassword.b("confirm_password_entered", (ArrayList<String>) new ArrayList());
                }
            }
        });
        this.f52489d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AJRChangePassword.this.f52492g.setVisibility(0);
                if (!z) {
                    AJRChangePassword.this.f52492g.setImageResource(R.drawable.cross_grey);
                } else if (AJRChangePassword.this.k) {
                    AJRChangePassword.this.f52492g.setImageResource(R.drawable.hidepasswrd);
                } else {
                    AJRChangePassword.this.f52492g.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52492g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!AJRChangePassword.this.f52489d.hasFocus()) {
                    AJRChangePassword.this.f52489d.setText("");
                } else if (!AJRChangePassword.this.k) {
                    AJRChangePassword.this.f52489d.setTransformationMethod(new PasswordTransformationMethod());
                    AJRChangePassword.this.f52492g.setImageResource(R.drawable.hidepasswrd);
                    boolean unused = AJRChangePassword.this.k = true;
                } else {
                    AJRChangePassword.this.f52489d.setTransformationMethod((TransformationMethod) null);
                    boolean unused2 = AJRChangePassword.this.k = false;
                    AJRChangePassword.this.f52492g.setImageResource(R.drawable.showpassword);
                }
            }
        });
        this.f52493h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRChangePassword aJRChangePassword = AJRChangePassword.this;
                boolean unused = aJRChangePassword.l = !aJRChangePassword.l;
                AJRChangePassword.this.f52493h.setChecked(AJRChangePassword.this.l);
            }
        });
        this.m.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        b("back_button_clicked", (ArrayList<String>) new ArrayList());
        super.onBackPressed();
    }

    public void onClick(View view) {
        String str;
        boolean z = true;
        if (view.getId() == R.id.btn_save) {
            String obj = this.f52487b.getText().toString();
            String obj2 = this.f52488c.getText().toString();
            String obj3 = this.f52489d.getText().toString();
            if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj3)) {
                str = getResources().getString(R.string.fill_all_fields);
            } else if (!obj2.equals(obj3)) {
                str = getResources().getString(R.string.password_do_not_match);
            } else if (obj.equals(obj2)) {
                str = getResources().getString(R.string.new_password_same_msg);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                b.b((Context) this, "", str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.n.getPasswordStrengthText());
                arrayList.add(str);
                arrayList.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                b("save_clicked", (ArrayList<String>) arrayList);
                z = false;
            }
            if (z) {
                OAuthUtils.a((Activity) this);
                net.one97.paytm.oauth.b.b.a((Context) this, this.f52487b.getText().toString(), this.f52488c.getText().toString(), Boolean.valueOf(this.l), Boolean.FALSE, (t) this);
            }
        } else if (view.getId() == R.id.forgot_password_txt) {
            b("forgot_password_clicked", (ArrayList<String>) new ArrayList());
            Intent intent = new Intent(this, ForgotPasswordContainerActivity.class);
            intent.putExtra(p.f56797b, "/change_password_security");
            intent.putExtra("is_change_password", true);
            startActivity(intent);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 619 && i3 == -1) {
            setResult(-1);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(OauthModule.b().getApplicationContext(), "change_password_security", str, arrayList, (String) null, "/change_password_security", p.f56796a);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        b.Z((Context) this);
        if (iJRPaytmDataModel instanceof CJRChangePwdStatus) {
            CJRChangePwdStatus cJRChangePwdStatus = (CJRChangePwdStatus) iJRPaytmDataModel;
            if (WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(cJRChangePwdStatus.getmResponseCode())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.n.getPasswordStrengthText());
                arrayList.add(SDKConstants.KEY_API);
                b("save_clicked", (ArrayList<String>) arrayList);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage(R.string.msg_password_changed_from_profile).setCancelable(false);
                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AJRChangePassword.this.a(dialogInterface, i2);
                    }
                });
                builder.show();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.n.getPasswordStrengthText());
            arrayList2.add(cJRChangePwdStatus.getMessage());
            arrayList2.add(SDKConstants.KEY_API);
            arrayList2.add(cJRChangePwdStatus.getmResponseCode());
            b("save_clicked", (ArrayList<String>) arrayList2);
            b.b((Context) this, "", cJRChangePwdStatus.getMessage());
            this.f52487b.setText("");
            this.f52488c.setText("");
            this.f52489d.setText("");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        finish();
        try {
            ArrayList arrayList = new ArrayList();
            if (this.l) {
                o oVar = o.f56791a;
                o.b(b.ab(this));
                OauthModule.b().onLogout(this, false, (VolleyError) null);
                OauthModule.b().openHomePage(this, false, "/change_password_security", true);
                arrayList.add("logout_all");
            } else {
                OauthModule.b().openHomePage(this, false, "/change_password_security", false);
                arrayList.add("logout_none");
            }
            b("password_change_success", (ArrayList<String>) arrayList);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b.Z((Context) this);
        if (networkCustomError != null && getLifecycle().a().isAtLeast(k.b.RESUMED) && !OAuthUtils.a((Activity) this, (Fragment) null, networkCustomError)) {
            if (l.a(new ErrorModel(i2, iJRPaytmDataModel))) {
                OauthModule.b().handleSessionTimeOut(this, networkCustomError, (String) null, (Bundle) null, true, false);
            }
            OAuthUtils.a(networkCustomError, (AppCompatActivity) this, AJRChangePassword.class.getName());
        }
    }

    public final void a() {
        b.k(this, getString(R.string.please_wait));
    }
}
