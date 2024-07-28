package net.one97.paytm.payments.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.k;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.model.ResetPasscodeTokenModal;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.payments.model.CJRLogoutAllDevices;
import net.one97.paytm.payments.model.CJRResetPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.utils.h;

public class AJRChangePasscode extends PBBaseActivity implements View.OnClickListener, PinEntryView.b {

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17143b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f17144c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f17145d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f17146e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17147f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f17148g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f17149h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17150i;
    /* access modifiers changed from: private */
    public TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private PinEntryView n;
    private Boolean o = Boolean.FALSE;
    /* access modifiers changed from: private */
    public String p = null;
    /* access modifiers changed from: private */
    public int q = 0;
    private String r;
    private String s;

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_passcode);
        getSupportActionBar().f();
        this.f17145d = (RelativeLayout) findViewById(R.id.bottomLayout);
        this.k = (TextView) findViewById(R.id.text_passcode_reason);
        this.j = (TextView) findViewById(R.id.bottominfo_tv);
        ((ImageView) findViewById(R.id.set_passcode_img_close)).setOnClickListener(this);
        this.f17146e = (TextView) findViewById(R.id.change_passcode_title_text);
        this.f17147f = (TextView) findViewById(R.id.change_passcode_last_attmpt);
        this.f17143b = (RelativeLayout) findViewById(R.id.change_passcode_content_RL);
        this.f17148g = (TextView) findViewById(R.id.chnge_passcode_not_match_passcode);
        this.f17149h = (TextView) findViewById(R.id.chnge_passcode_forgot_passcode);
        this.f17144c = (RelativeLayout) findViewById(R.id.passcode_success_fail_RL);
        this.l = (ImageView) findViewById(R.id.passcode_success_fail);
        this.m = (ImageView) findViewById(R.id.payment_bank_set_passcode_img_done);
        this.f17150i = (TextView) findViewById(R.id.passcode_status_text);
        this.n = (PinEntryView) findViewById(R.id.otpView);
        this.n.setOnPinEnteredListener(this);
        ((Button) findViewById(R.id.change_passcode_ok_button)).setOnClickListener(this);
        if (k.b()) {
            this.f17149h.setVisibility(8);
        } else {
            this.f17149h.setOnClickListener(this);
        }
        f();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.change_passcode_ok_button) {
            finish();
        } else if (view.getId() == R.id.chnge_passcode_forgot_passcode) {
            net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
            if (net.one97.paytm.payments.c.c.b.b()) {
                net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                net.one97.paytm.payments.c.c.b.d(this, new Bundle());
            } else if (a.c((Context) this)) {
                ForgotPasscodeChallengesActivity.a((Context) this);
            } else {
                d();
            }
        } else if (view.getId() == R.id.set_passcode_img_close) {
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 131 && i3 == -1) {
            finish();
        } else if (i2 == 7 && i3 == -1 && intent != null && intent.hasExtra("forgot_passcode_access")) {
            Intent intent2 = new Intent(this, AJRForgotPasscode.class);
            intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
            startActivityForResult(intent2, 131);
        }
    }

    private void e() {
        this.n.setDigitBackground(this.o.booleanValue() ? R.color.fp_color_ffefef : R.color.prv_passcode_color);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null) {
            ah_();
            f();
            if (iJRPaytmDataModel instanceof ResetPasscodeTokenModal) {
                ResetPasscodeTokenModal resetPasscodeTokenModal = (ResetPasscodeTokenModal) iJRPaytmDataModel;
                if (resetPasscodeTokenModal.getScope() == null || !resetPasscodeTokenModal.getScope().equalsIgnoreCase("reset_secret")) {
                    if (resetPasscodeTokenModal.getError() != null) {
                        g();
                        this.f17148g.setText(resetPasscodeTokenModal.getErrorDescription());
                        this.q = 0;
                    }
                } else if (resetPasscodeTokenModal.getAccessToken() != null) {
                    this.f17146e.setText(R.string.set_new_passcode);
                    this.p = resetPasscodeTokenModal.getAccessToken();
                    this.q = 2;
                    this.f17149h.setVisibility(8);
                    this.j.setVisibility(0);
                }
            } else if (iJRPaytmDataModel instanceof CJRResetPasscode) {
                CJRResetPasscode cJRResetPasscode = (CJRResetPasscode) iJRPaytmDataModel;
                this.q = 5;
                if (cJRResetPasscode.getStatus() == null || !cJRResetPasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                    a(Boolean.FALSE, cJRResetPasscode.getMessage());
                } else {
                    a(Boolean.TRUE, (String) null);
                }
            } else if (!(iJRPaytmDataModel instanceof CJRLogoutAllDevices)) {
            } else {
                if (((CJRLogoutAllDevices) iJRPaytmDataModel).getResponseCode().equalsIgnoreCase("127")) {
                    startActivityForResult(new Intent(this, AadharValidatePasscode.class), 7);
                } else {
                    b.b((Context) this, getString(R.string.error), getString(R.string.pb_bank_passcode_error));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool, String str) {
        c();
        if (bool.booleanValue()) {
            this.f17150i.setText(R.string.succesfull_change_passcode);
            this.l.setImageResource(R.drawable.pb_passcode_success);
        } else {
            if (str != null) {
                this.f17150i.setText(str);
            } else {
                this.f17150i.setText(R.string.failed_change_passcode);
            }
            this.l.setImageResource(R.drawable.pb_passcode_fail);
        }
        this.f17143b.setVisibility(8);
        this.f17145d.setVisibility(8);
        this.f17144c.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.n.setText("");
        this.n.requestFocus();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.o = Boolean.TRUE;
        e();
        this.f17148g.setVisibility(0);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        f();
        if (this.q == 1) {
            this.q = 0;
        }
    }

    private Boolean h() {
        return Boolean.valueOf(this.n.getText().toString().length() == this.n.getDigits());
    }

    public final void a(String str) {
        if (this.q == 0 && h().booleanValue()) {
            this.q = 1;
        }
        if (this.q == 1 && h().booleanValue()) {
            String obj = this.n.getText().toString();
            try {
                g gVar = g.f16329a;
                f b2 = g.b(this, obj, new net.one97.paytm.bankCommon.f.b<String>() {
                    public final void a(String str, String str2) {
                        AJRChangePasscode.this.ah_();
                        AJRChangePasscode.this.f();
                        if (!TextUtils.isEmpty(str)) {
                            AJRChangePasscode.this.f17146e.setText(R.string.set_new_passcode);
                            String unused = AJRChangePasscode.this.p = str;
                            int unused2 = AJRChangePasscode.this.q = 2;
                            AJRChangePasscode.this.f17149h.setVisibility(8);
                            AJRChangePasscode.this.j.setVisibility(0);
                            return;
                        }
                        AJRChangePasscode.this.g();
                        AJRChangePasscode.this.f17148g.setText(str2);
                        int unused3 = AJRChangePasscode.this.q = 0;
                    }

                    public final void a(int i2, NetworkCustomError networkCustomError) {
                        AJRChangePasscode.this.ah_();
                        net.one97.paytm.bankCommon.utils.f.a((Context) AJRChangePasscode.this, networkCustomError, i2);
                    }
                });
                if (b.c((Context) this)) {
                    a(this, getString(R.string.please_wait));
                    getApplicationContext();
                    new c();
                    c.a(b2);
                    return;
                }
                h hVar = h.f19510a;
                h.a(b2, this);
            } catch (Exception unused) {
            }
        } else if (this.q == 2 && h().booleanValue()) {
            this.r = "";
            this.r = this.n.getText().toString();
            f();
            this.f17146e.setText(getString(R.string.confirm_new_passcode));
            this.q = 3;
            this.j.setVisibility(0);
            this.k.setText(getString(R.string.pb_confirm_passcode_text));
        } else if (this.q == 3 && h().booleanValue()) {
            this.s = "";
            this.s = this.n.getText().toString();
            if (this.r.equalsIgnoreCase(this.s)) {
                this.m.setVisibility(0);
                this.q = 4;
                try {
                    g gVar2 = g.f16329a;
                    d.b();
                    String a2 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), this.r);
                    d.b();
                    f a3 = g.a(this, a2, com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), this.s), String.valueOf(System.currentTimeMillis()), new g.b<IJRPaytmDataModel>() {
                        public final /* synthetic */ void onResponse(Object obj) {
                            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                            AJRChangePasscode.this.ah_();
                            AJRChangePasscode.this.f();
                            if (iJRPaytmDataModel instanceof ValidatePasscode) {
                                ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
                                AJRChangePasscode.this.c();
                                if (validatePasscode != null) {
                                    int unused = AJRChangePasscode.this.q = 5;
                                    if (validatePasscode.getStatus() == null || !validatePasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                                        AJRChangePasscode.this.a(Boolean.FALSE, validatePasscode.getMessage());
                                    } else {
                                        AJRChangePasscode.this.a(Boolean.TRUE, (String) null);
                                    }
                                }
                            }
                        }
                    }, new g.a() {
                        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            AJRChangePasscode.this.ah_();
                            net.one97.paytm.bankCommon.utils.f.a((Context) AJRChangePasscode.this, networkCustomError, i2);
                        }
                    }, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName(), this.p);
                    if (b.c((Context) this)) {
                        a(this, getString(R.string.please_wait));
                        getApplicationContext();
                        new c();
                        c.a(a3);
                        return;
                    }
                    h hVar2 = h.f19510a;
                    h.a(a3, this);
                } catch (Exception unused2) {
                }
            } else {
                this.q = 3;
                f();
                g();
                this.f17148g.setText(R.string.not_match_passcode);
            }
        }
    }

    public final void af_() {
        this.o = Boolean.FALSE;
        e();
        this.f17148g.setVisibility(8);
        this.f17147f.setVisibility(8);
    }
}
