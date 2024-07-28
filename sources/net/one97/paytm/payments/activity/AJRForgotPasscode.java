package net.one97.paytm.payments.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.ResetPasscodeTokenModal;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.common.widgets.PasscodeEditText;
import net.one97.paytm.payments.model.CJRResetPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.h;
import net.one97.paytm.paymentsBank.utils.o;

public class AJRForgotPasscode extends PBBaseActivity implements View.OnClickListener, PinEntryView.b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f17156b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f17157c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17158d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17159e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17160f;

    /* renamed from: g  reason: collision with root package name */
    private PinEntryView f17161g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f17162h;

    /* renamed from: i  reason: collision with root package name */
    private PasscodeEditText f17163i;
    /* access modifiers changed from: private */
    public RelativeLayout j;
    /* access modifiers changed from: private */
    public RelativeLayout k;
    /* access modifiers changed from: private */
    public RelativeLayout l;
    private String m = "";
    private boolean n = true;
    private Boolean o = Boolean.FALSE;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public ImageView q;
    private ImageView r;
    private String s;
    private String t;
    private TextView u;

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_forgot_passcode_v2);
        this.u = (TextView) findViewById(R.id.subTitleTv);
        this.f17163i = (PasscodeEditText) findViewById(R.id.payment_bank_edt_password);
        this.j = (RelativeLayout) findViewById(R.id.forgot_passcode_passcode_layout);
        this.k = (RelativeLayout) findViewById(R.id.forgot_passcode_password_layout);
        this.l = (RelativeLayout) findViewById(R.id.forgot_passcode_success_fail_RL);
        this.f17156b = (TextView) findViewById(R.id.forgot_passcode_title_text);
        this.f17157c = (TextView) findViewById(R.id.forgot_passcode_status_text);
        this.q = (ImageView) findViewById(R.id.forgot_passcode_success_fail_img);
        this.r = (ImageView) findViewById(R.id.payment_bank_set_passcode_img_done);
        this.f17158d = (TextView) findViewById(R.id.forgot_passcode_not_match_passcode);
        this.f17159e = (TextView) findViewById(R.id.forgot_passcode_ErrorText);
        this.f17160f = (TextView) findViewById(R.id.text_show);
        this.f17162h = (LinearLayout) findViewById(R.id.ll_password);
        this.f17161g = (PinEntryView) findViewById(R.id.otpView);
        this.f17161g.setOnPinEnteredListener(this);
        this.l.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        ((TextView) findViewById(R.id.forgot_passcode_ok_button)).setOnClickListener(this);
        ((Button) findViewById(R.id.forgot_passcode_finish_button)).setOnClickListener(this);
        ((TextView) findViewById(R.id.forgot_passcode_forgot_password)).setOnClickListener(this);
        this.f17160f.setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(this);
        this.f17163i.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AJRForgotPasscode.this.g();
            }
        });
        Intent intent = getIntent();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (intent == null || !intent.hasExtra("forgot_passcode_access")) {
            this.f17163i.requestFocus();
            inputMethodManager.showSoftInput(this.f17163i, 1);
            return;
        }
        this.l.setVisibility(8);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.f17156b.setText(R.string.set_new_passcode);
        this.m = intent.getStringExtra("forgot_passcode_access");
        this.f17161g.setText("");
        this.f17161g.requestFocus();
        inputMethodManager.showSoftInput(this.f17161g, 1);
    }

    private void e() {
        this.f17161g.setDigitBackground(this.o.booleanValue() ? R.color.fp_color_ffefef : R.color.prv_passcode_color);
        this.f17162h.setBackground((Drawable) null);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f17161g.setText("");
        this.f17161g.requestFocus();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.o = Boolean.FALSE;
        e();
        this.f17159e.setVisibility(8);
        this.f17158d.setVisibility(8);
    }

    private Boolean h() {
        return Boolean.valueOf(this.f17161g.getText().toString().length() == this.f17161g.getDigits());
    }

    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.forgot_passcode_forgot_password) {
            Intent intent = new Intent(this, o.a().getAJRForgotPasswordClass());
            if (b.l(getApplicationContext()) != null) {
                str = b.l(getApplicationContext());
            } else {
                str = b.m(getApplicationContext());
            }
            intent.putExtra("userName", str);
            startActivity(intent);
        } else if (id == R.id.forgot_passcode_finish_button) {
            setResult(-1, new Intent());
            finish();
        } else if (id == R.id.text_show) {
            int selectionEnd = this.f17163i.getSelectionEnd();
            int selectionStart = this.f17163i.getSelectionStart();
            if (this.n) {
                this.f17163i.setTransformationMethod((TransformationMethod) null);
                this.f17160f.setText(R.string.hide);
                this.n = false;
            } else {
                this.f17163i.setTransformationMethod(new PasswordTransformationMethod());
                this.f17160f.setText(R.string.show);
                this.n = true;
            }
            this.f17163i.setSelection(selectionStart, selectionEnd);
        } else if (id == R.id.iv_back) {
            onBackPressed();
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null) {
            ah_();
            if (iJRPaytmDataModel instanceof ResetPasscodeTokenModal) {
                ResetPasscodeTokenModal resetPasscodeTokenModal = (ResetPasscodeTokenModal) iJRPaytmDataModel;
                if (resetPasscodeTokenModal.getScope() == null || !resetPasscodeTokenModal.getScope().equalsIgnoreCase("reset_secret")) {
                    if (resetPasscodeTokenModal.getError() == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(resetPasscodeTokenModal.getErrorDescription())) {
                        b.b((Context) this, getString(R.string.error), resetPasscodeTokenModal.getErrorDescription());
                        return;
                    }
                    this.l.setVisibility(8);
                    this.j.setVisibility(8);
                    this.k.setVisibility(0);
                    this.o = Boolean.TRUE;
                    e();
                    this.f17159e.setText(getString(R.string.forgot_passcode_invalid_password));
                    this.f17159e.setVisibility(0);
                } else if (resetPasscodeTokenModal.getAccessToken() != null) {
                    this.l.setVisibility(8);
                    this.j.setVisibility(0);
                    this.k.setVisibility(8);
                    this.f17156b.setText(R.string.set_new_passcode);
                    this.m = resetPasscodeTokenModal.getAccessToken();
                }
            } else if (iJRPaytmDataModel instanceof CJRResetPasscode) {
                CJRResetPasscode cJRResetPasscode = (CJRResetPasscode) iJRPaytmDataModel;
                c();
                if (cJRResetPasscode != null) {
                    this.p = 5;
                    if (cJRResetPasscode.getStatus() == null || !cJRResetPasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                        this.q.setImageResource(R.drawable.pb_passcode_fail);
                        this.l.setVisibility(0);
                        this.f17156b.setVisibility(8);
                        this.j.setVisibility(8);
                        this.k.setVisibility(8);
                        if (cJRResetPasscode.getMessage() != null) {
                            this.f17157c.setText(cJRResetPasscode.getMessage());
                        } else {
                            this.f17157c.setText(R.string.failed_change_passcode);
                        }
                    } else {
                        this.f17157c.setText(R.string.succesfull_change_passcode);
                        this.q.setImageResource(R.drawable.pb_passcode_success);
                        this.l.setVisibility(0);
                        this.f17156b.setVisibility(8);
                        this.j.setVisibility(8);
                        this.k.setVisibility(8);
                    }
                }
            }
        }
    }

    public final void af_() {
        g();
    }

    public final void a(String str) {
        if (this.p == 0 && h().booleanValue()) {
            this.p = 1;
        }
        if (this.p == 1 && h().booleanValue()) {
            this.s = "";
            this.s = this.f17161g.getText().toString();
            f();
            this.f17156b.setText(getString(R.string.confirm_new_passcode));
            this.u.setText(getString(R.string.pb_confirm_passcode));
            this.p = 2;
        } else if (this.p == 2 && h().booleanValue()) {
            this.t = "";
            this.t = this.f17161g.getText().toString();
            if (this.s.equalsIgnoreCase(this.t)) {
                this.r.setVisibility(0);
                this.p = 4;
                try {
                    g gVar = g.f16329a;
                    d.b();
                    String a2 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), this.s);
                    d.b();
                    f a3 = g.a(this, a2, com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), this.t), String.valueOf(System.currentTimeMillis()), new g.b<IJRPaytmDataModel>() {
                        public final /* synthetic */ void onResponse(Object obj) {
                            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                            AJRForgotPasscode.this.ah_();
                            AJRForgotPasscode.this.f();
                            if (iJRPaytmDataModel instanceof ValidatePasscode) {
                                ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
                                AJRForgotPasscode.this.c();
                                if (validatePasscode != null) {
                                    int unused = AJRForgotPasscode.this.p = 5;
                                    if (validatePasscode.getStatus() == null || !validatePasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                                        AJRForgotPasscode.this.q.setImageResource(R.drawable.pb_passcode_fail);
                                        AJRForgotPasscode.this.l.setVisibility(0);
                                        AJRForgotPasscode.this.f17156b.setVisibility(8);
                                        AJRForgotPasscode.this.j.setVisibility(8);
                                        AJRForgotPasscode.this.k.setVisibility(8);
                                        if (validatePasscode.getMessage() != null) {
                                            AJRForgotPasscode.this.f17157c.setText(validatePasscode.getMessage());
                                        } else {
                                            AJRForgotPasscode.this.f17157c.setText(R.string.failed_change_passcode);
                                        }
                                    } else {
                                        AJRForgotPasscode.this.f17157c.setText(R.string.succesfull_change_passcode);
                                        AJRForgotPasscode.this.q.setImageResource(R.drawable.pb_passcode_success);
                                        AJRForgotPasscode.this.l.setVisibility(0);
                                        AJRForgotPasscode.this.f17156b.setVisibility(8);
                                        AJRForgotPasscode.this.j.setVisibility(8);
                                        AJRForgotPasscode.this.k.setVisibility(8);
                                    }
                                }
                            }
                        }
                    }, new g.a() {
                        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            AJRForgotPasscode.this.ah_();
                            net.one97.paytm.bankCommon.utils.f.a((Context) AJRForgotPasscode.this, networkCustomError, i2);
                        }
                    }, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName(), this.m);
                    if (b.c((Context) this)) {
                        a(this, getString(R.string.please_wait));
                        getApplicationContext();
                        new c();
                        c.a(a3);
                        return;
                    }
                    h hVar = h.f19510a;
                    h.a(a3, this);
                } catch (Exception unused) {
                }
            } else {
                f();
                this.p = 2;
                this.o = Boolean.TRUE;
                e();
                this.f17158d.setVisibility(0);
            }
        }
    }
}
