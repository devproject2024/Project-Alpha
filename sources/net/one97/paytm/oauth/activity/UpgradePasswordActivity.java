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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.models.CJRChangePwdStatus;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.utils.t;
import net.one97.paytm.oauth.view.PasswordStrengthLayout;

public final class UpgradePasswordActivity extends OAuthBaseActivity implements View.OnClickListener, t {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f52554a = true;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f52555b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f52556c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52557d = true;

    /* renamed from: e  reason: collision with root package name */
    private final String f52558e = y.b(UpgradePasswordActivity.class).b();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f52559f;

    public final View a(int i2) {
        if (this.f52559f == null) {
            this.f52559f = new HashMap();
        }
        View view = (View) this.f52559f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f52559f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upgrade_password);
        setTitle(getString(R.string.change_password));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.a((Drawable) new ColorDrawable(androidx.core.content.b.c(this, R.color.white)));
            supportActionBar.a(1.0f);
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.crossButtonCurrentPwd)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.crossButtonNewPwd)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.crossButtonNewPwdCheck)).setOnClickListener(onClickListener);
        ((RoboButton) a(R.id.btnUpdatePassword)).setOnClickListener(onClickListener);
        ((CheckBox) a(R.id.checkboxLogOutAllDevices)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.forgotPasswordTxt)).setOnClickListener(onClickListener);
        ImageView imageView = (ImageView) a(R.id.crossButtonCurrentPwd);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.hidepasswrd);
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.currentPassword);
        appCompatEditText.setVisibility(0);
        appCompatEditText.requestFocus();
        appCompatEditText.addTextChangedListener(new a(this));
        appCompatEditText.setOnFocusChangeListener(new b(this));
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.newPassword);
        InputFilter inputFilter = OAuthUtils.f56746a;
        k.a((Object) inputFilter, "OAuthUtils.spaceFilter");
        appCompatEditText2.setFilters(new InputFilter[]{inputFilter});
        appCompatEditText2.addTextChangedListener(new c(this));
        appCompatEditText2.setOnFocusChangeListener(new d(this));
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.newPasswordCheck);
        InputFilter inputFilter2 = OAuthUtils.f56746a;
        k.a((Object) inputFilter2, "OAuthUtils.spaceFilter");
        appCompatEditText3.setFilters(new InputFilter[]{inputFilter2});
        appCompatEditText3.addTextChangedListener(new e(this));
        appCompatEditText3.setOnFocusChangeListener(new f(this));
        RoboButton roboButton = (RoboButton) a(R.id.btnUpdatePassword);
        k.a((Object) roboButton, "btnUpdatePassword");
        roboButton.setText(getString(R.string.label_update_password));
        TextView textView = (TextView) a(R.id.forgotPasswordTxt);
        k.a((Object) textView, "forgotPasswordTxt");
        textView.setText(getString(R.string.forgot_password));
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilCurrentPwd);
        k.a((Object) textInputLayout, "tilCurrentPwd");
        textInputLayout.setHint(getString(R.string.current_password));
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilNewPwd);
        k.a((Object) textInputLayout2, "tilNewPwd");
        textInputLayout2.setHint(getString(R.string.new_paytm_password));
        TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.tilRetypeNewPwd);
        k.a((Object) textInputLayout3, "tilRetypeNewPwd");
        textInputLayout3.setHint(getString(R.string.retype_new_password));
        com.paytm.utility.b.c((TextView) (RoboButton) a(R.id.btnUpdatePassword));
        a((CheckBox) a(R.id.checkboxLogOutAllDevices));
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 619 && i3 == -1) {
            setResult(-1);
            finish();
        }
    }

    public final void onBackPressed() {
        b("back_button_clicked", new ArrayList());
        super.onBackPressed();
    }

    public final void onClick(View view) {
        String str;
        boolean z = false;
        if (k.a((Object) view, (Object) (RoboButton) a(R.id.btnUpdatePassword))) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.currentPassword);
            k.a((Object) appCompatEditText, "currentPassword");
            String valueOf = String.valueOf(appCompatEditText.getText());
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.newPassword);
            k.a((Object) appCompatEditText2, "newPassword");
            String valueOf2 = String.valueOf(appCompatEditText2.getText());
            AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.newPasswordCheck);
            k.a((Object) appCompatEditText3, "newPasswordCheck");
            String valueOf3 = String.valueOf(appCompatEditText3.getText());
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2) || TextUtils.isEmpty(valueOf3)) {
                str = getString(R.string.fill_all_fields);
            } else if (!valueOf2.equals(valueOf3)) {
                str = getString(R.string.password_do_not_match);
            } else if (valueOf.equals(valueOf2)) {
                str = getString(R.string.new_password_same_msg);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                com.paytm.utility.b.b((Context) this, "", str);
                List arrayList = new ArrayList();
                arrayList.add(((PasswordStrengthLayout) a(R.id.layoutPwdStrength)).getPasswordStrengthText());
                k.a((Object) str, "errMsg");
                arrayList.add(str);
                arrayList.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                b("save_clicked", (ArrayList) arrayList);
            } else {
                z = true;
            }
            if (z) {
                OAuthUtils.a((Activity) this);
                AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.currentPassword);
                k.a((Object) appCompatEditText4, "currentPassword");
                String valueOf4 = String.valueOf(appCompatEditText4.getText());
                AppCompatEditText appCompatEditText5 = (AppCompatEditText) a(R.id.newPassword);
                k.a((Object) appCompatEditText5, "newPassword");
                net.one97.paytm.oauth.b.b.a((Context) this, valueOf4, String.valueOf(appCompatEditText5.getText()), Boolean.valueOf(this.f52557d), Boolean.TRUE, (t) this);
            }
        } else if (k.a((Object) view, (Object) (TextView) a(R.id.forgotPasswordTxt))) {
            Intent intent = new Intent(this, ForgotPasswordContainerActivity.class);
            intent.putExtra(p.f56797b, "/change_password_security");
            intent.putExtra("is_change_password", true);
            startActivity(intent);
        } else if (k.a((Object) view, (Object) (ImageView) a(R.id.crossButtonCurrentPwd))) {
            if (!((AppCompatEditText) a(R.id.currentPassword)).hasFocus()) {
                ((AppCompatEditText) a(R.id.currentPassword)).setText("");
            } else if (!this.f52554a) {
                AppCompatEditText appCompatEditText6 = (AppCompatEditText) a(R.id.currentPassword);
                k.a((Object) appCompatEditText6, "currentPassword");
                appCompatEditText6.setTransformationMethod(new PasswordTransformationMethod());
                this.f52554a = true;
                ((ImageView) a(R.id.crossButtonCurrentPwd)).setImageResource(R.drawable.hidepasswrd);
            } else {
                AppCompatEditText appCompatEditText7 = (AppCompatEditText) a(R.id.currentPassword);
                k.a((Object) appCompatEditText7, "currentPassword");
                appCompatEditText7.setTransformationMethod((TransformationMethod) null);
                this.f52554a = false;
                ((ImageView) a(R.id.crossButtonCurrentPwd)).setImageResource(R.drawable.showpassword);
            }
        } else if (k.a((Object) view, (Object) (ImageView) a(R.id.crossButtonNewPwd))) {
            if (!((AppCompatEditText) a(R.id.newPassword)).hasFocus()) {
                ((AppCompatEditText) a(R.id.newPassword)).setText("");
            } else if (!this.f52555b) {
                AppCompatEditText appCompatEditText8 = (AppCompatEditText) a(R.id.newPassword);
                k.a((Object) appCompatEditText8, "newPassword");
                appCompatEditText8.setTransformationMethod(new PasswordTransformationMethod());
                this.f52555b = true;
                ((ImageView) a(R.id.crossButtonNewPwd)).setImageResource(R.drawable.hidepasswrd);
            } else {
                AppCompatEditText appCompatEditText9 = (AppCompatEditText) a(R.id.newPassword);
                k.a((Object) appCompatEditText9, "newPassword");
                appCompatEditText9.setTransformationMethod((TransformationMethod) null);
                this.f52555b = false;
                ((ImageView) a(R.id.crossButtonNewPwd)).setImageResource(R.drawable.showpassword);
            }
        } else if (k.a((Object) view, (Object) (ImageView) a(R.id.crossButtonNewPwdCheck))) {
            if (!((AppCompatEditText) a(R.id.newPasswordCheck)).hasFocus()) {
                ((AppCompatEditText) a(R.id.newPasswordCheck)).setText("");
            } else if (!this.f52556c) {
                AppCompatEditText appCompatEditText10 = (AppCompatEditText) a(R.id.newPasswordCheck);
                k.a((Object) appCompatEditText10, "newPasswordCheck");
                appCompatEditText10.setTransformationMethod(new PasswordTransformationMethod());
                ((ImageView) a(R.id.crossButtonNewPwdCheck)).setImageResource(R.drawable.hidepasswrd);
                this.f52556c = true;
            } else {
                AppCompatEditText appCompatEditText11 = (AppCompatEditText) a(R.id.newPasswordCheck);
                k.a((Object) appCompatEditText11, "newPasswordCheck");
                appCompatEditText11.setTransformationMethod((TransformationMethod) null);
                this.f52556c = false;
                ((ImageView) a(R.id.crossButtonNewPwdCheck)).setImageResource(R.drawable.showpassword);
            }
        } else if (k.a((Object) view, (Object) (CheckBox) a(R.id.checkboxLogOutAllDevices))) {
            this.f52557d = !this.f52557d;
            CheckBox checkBox = (CheckBox) a(R.id.checkboxLogOutAllDevices);
            k.a((Object) checkBox, "checkboxLogOutAllDevices");
            checkBox.setChecked(this.f52557d);
        }
    }

    public final void a() {
        com.paytm.utility.b.k(this, getString(R.string.please_wait));
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        Context context = this;
        com.paytm.utility.b.Z(context);
        if (iJRPaytmDataModel instanceof CJRChangePwdStatus) {
            CJRChangePwdStatus cJRChangePwdStatus = (CJRChangePwdStatus) iJRPaytmDataModel;
            if (kotlin.m.p.a(WebLogin.RESPONSE_CODE_SUCCESS, cJRChangePwdStatus.getmResponseCode(), true)) {
                q qVar = q.f56798a;
                q.c(false);
                List arrayList = new ArrayList();
                arrayList.add(((PasswordStrengthLayout) a(R.id.layoutPwdStrength)).getPasswordStrengthText());
                arrayList.add(SDKConstants.KEY_API);
                b("save_clicked", (ArrayList) arrayList);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setMessage(R.string.msg_password_changed_from_profile);
                builder.setPositiveButton(getString(R.string.ok), new g(this));
                builder.show();
                return;
            }
            List arrayList2 = new ArrayList();
            arrayList2.add(((PasswordStrengthLayout) a(R.id.layoutPwdStrength)).getPasswordStrengthText());
            String message = cJRChangePwdStatus.getMessage();
            k.a((Object) message, "dataModel.message");
            arrayList2.add(message);
            arrayList2.add(SDKConstants.KEY_API);
            String str = cJRChangePwdStatus.getmResponseCode();
            k.a((Object) str, "dataModel.getmResponseCode()");
            arrayList2.add(str);
            b("save_clicked", (ArrayList) arrayList2);
            com.paytm.utility.b.b(context, "", cJRChangePwdStatus.getMessage());
            ((AppCompatEditText) a(R.id.currentPassword)).setText("");
            ((AppCompatEditText) a(R.id.newPassword)).setText("");
            ((AppCompatEditText) a(R.id.newPasswordCheck)).setText("");
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52566a;

        g(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52566a = upgradePasswordActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f52566a.finish();
            UpgradePasswordActivity.a(this.f52566a);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.Z((Context) this);
        if (networkCustomError != null) {
            androidx.lifecycle.k lifecycle = getLifecycle();
            k.a((Object) lifecycle, "lifecycle");
            if (!lifecycle.a().isAtLeast(k.b.RESUMED) || OAuthUtils.a((Activity) this, (Fragment) null, networkCustomError)) {
                return;
            }
            if (iJRPaytmDataModel != null) {
                if (l.a((ErrorModel) iJRPaytmDataModel)) {
                    OauthModule.b().handleSessionTimeOut(this, networkCustomError, (String) null, (Bundle) null, true, false);
                }
                OAuthUtils.a(networkCustomError, (AppCompatActivity) this, y.b(UpgradePasswordActivity.class).b());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
        }
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52560a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52560a = upgradePasswordActivity;
        }

        public final void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() == 1) {
                UpgradePasswordActivity.b("current_password_entered", new ArrayList());
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ImageView imageView = (ImageView) this.f52560a.a(R.id.crossButtonCurrentPwd);
            kotlin.g.b.k.a((Object) imageView, "crossButtonCurrentPwd");
            imageView.setVisibility((charSequence == null || charSequence.length() != 0) ? 0 : 4);
        }
    }

    static final class b implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52561a;

        b(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52561a = upgradePasswordActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            int i2;
            ImageView imageView;
            if (!z) {
                imageView = (ImageView) this.f52561a.a(R.id.crossButtonCurrentPwd);
                i2 = R.drawable.cross_grey;
            } else {
                imageView = (ImageView) this.f52561a.a(R.id.crossButtonCurrentPwd);
                i2 = this.f52561a.f52554a ? R.drawable.hidepasswrd : R.drawable.showpassword;
            }
            imageView.setImageResource(i2);
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52562a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52562a = upgradePasswordActivity;
        }

        public final void afterTextChanged(Editable editable) {
            ((PasswordStrengthLayout) this.f52562a.a(R.id.layoutPwdStrength)).a(String.valueOf(editable));
            if (editable != null && editable.length() == 1) {
                UpgradePasswordActivity.b("new_password_entered", new ArrayList());
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ImageView imageView = (ImageView) this.f52562a.a(R.id.crossButtonNewPwd);
            kotlin.g.b.k.a((Object) imageView, "crossButtonNewPwd");
            imageView.setVisibility((charSequence == null || charSequence.length() != 0) ? 0 : 4);
        }
    }

    static final class d implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52563a;

        d(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52563a = upgradePasswordActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            ImageView imageView = (ImageView) this.f52563a.a(R.id.crossButtonNewPwd);
            kotlin.g.b.k.a((Object) imageView, "crossButtonNewPwd");
            imageView.setVisibility(0);
            if (!z) {
                ((ImageView) this.f52563a.a(R.id.crossButtonNewPwd)).setImageResource(R.drawable.cross_grey);
                PasswordStrengthLayout passwordStrengthLayout = (PasswordStrengthLayout) this.f52563a.a(R.id.layoutPwdStrength);
                kotlin.g.b.k.a((Object) passwordStrengthLayout, "layoutPwdStrength");
                passwordStrengthLayout.setVisibility(8);
                return;
            }
            PasswordStrengthLayout passwordStrengthLayout2 = (PasswordStrengthLayout) this.f52563a.a(R.id.layoutPwdStrength);
            kotlin.g.b.k.a((Object) passwordStrengthLayout2, "layoutPwdStrength");
            passwordStrengthLayout2.setVisibility(0);
            ((ImageView) this.f52563a.a(R.id.crossButtonNewPwd)).setImageResource(this.f52563a.f52555b ? R.drawable.hidepasswrd : R.drawable.showpassword);
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52564a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52564a = upgradePasswordActivity;
        }

        public final void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() == 1) {
                UpgradePasswordActivity.b("confirm_password_entered", new ArrayList());
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ImageView imageView = (ImageView) this.f52564a.a(R.id.crossButtonNewPwdCheck);
            kotlin.g.b.k.a((Object) imageView, "crossButtonNewPwdCheck");
            imageView.setVisibility((charSequence == null || charSequence.length() != 0) ? 0 : 4);
        }
    }

    static final class f implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpgradePasswordActivity f52565a;

        f(UpgradePasswordActivity upgradePasswordActivity) {
            this.f52565a = upgradePasswordActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            int i2;
            ImageView imageView;
            ImageView imageView2 = (ImageView) this.f52565a.a(R.id.crossButtonNewPwdCheck);
            kotlin.g.b.k.a((Object) imageView2, "crossButtonNewPwdCheck");
            imageView2.setVisibility(0);
            if (!z) {
                imageView = (ImageView) this.f52565a.a(R.id.crossButtonNewPwdCheck);
                i2 = R.drawable.cross_grey;
            } else {
                imageView = (ImageView) this.f52565a.a(R.id.crossButtonNewPwdCheck);
                i2 = this.f52565a.f52556c ? R.drawable.hidepasswrd : R.drawable.showpassword;
            }
            imageView.setImageResource(i2);
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "upgrade_password", str, arrayList, (String) null, "/upgrade_password", p.f56796a);
    }

    public static final /* synthetic */ void a(UpgradePasswordActivity upgradePasswordActivity) {
        try {
            List arrayList = new ArrayList();
            if (upgradePasswordActivity.f52557d) {
                o oVar = o.f56791a;
                o.b(com.paytm.utility.b.ab(upgradePasswordActivity));
                OauthModule.b().onLogout(upgradePasswordActivity, false, (VolleyError) null);
                OauthModule.b().openHomePage(upgradePasswordActivity, false, "/upgrade_password", true);
                arrayList.add("logout_all");
            } else {
                OauthModule.b().openHomePage(upgradePasswordActivity, false, "/upgrade_password", false);
                arrayList.add("logout_none");
            }
            b("password_change_success", (ArrayList) arrayList);
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }
}
