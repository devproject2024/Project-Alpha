package net.one97.paytm.payments.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.SetPasscodeModel;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.payments.a.a;
import net.one97.paytm.payments.b.b.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.h;
import net.one97.paytm.paymentsBank.utils.m;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class AJRSetPasscode extends PBBaseActivity implements c.b {

    /* renamed from: b  reason: collision with root package name */
    protected TextView f17167b;

    /* renamed from: c  reason: collision with root package name */
    protected c f17168c;

    /* renamed from: d  reason: collision with root package name */
    String f17169d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f17170e;

    /* renamed from: f  reason: collision with root package name */
    private c f17171f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17172g;

    /* renamed from: h  reason: collision with root package name */
    private String f17173h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f17174i = Boolean.FALSE;
    private TextView j;
    private ImageView k;
    private TextView l;
    private View m;

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public int e() {
        return R.layout.activity_set_passcode_v2;
    }

    /* access modifiers changed from: protected */
    public final TextView f() {
        return this.f17172g;
    }

    /* access modifiers changed from: protected */
    public final c g() {
        return this.f17171f;
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        h();
        setContentView(e());
        if (getIntent() != null) {
            this.f17174i = Boolean.valueOf(getIntent().getBooleanExtra("from_auth", false));
        }
        getSupportActionBar().f();
        ag_();
        this.f17170e = (ViewPager) findViewById(R.id.payment_bank_set_passcode_pager_passcode);
        this.f17172g = (TextView) findViewById(R.id.set_passcode_tv_error_msg);
        this.j = (TextView) findViewById(R.id.bottominfo_tv);
        this.k = (ImageView) findViewById(R.id.iv_bottom);
        this.m = findViewById(R.id.view_space);
        a aVar = new a(getSupportFragmentManager());
        this.f17170e.setAdapter(aVar);
        this.f17167b = (TextView) findViewById(R.id.payment_bank_set_passcode_tv_title);
        this.l = (TextView) findViewById(R.id.text_passcode_reason);
        if (this.f17174i.booleanValue()) {
            this.l.setText(getString(R.string.set_paytm_passcode_auth));
        }
        if (getIntent() != null && getIntent().hasExtra("show_feature_specific_view")) {
            this.f17169d = getIntent().getStringExtra("show_feature_specific_view");
            String str = this.f17169d;
            if ((str == null || !str.equals(a.b.DEVICE_BINDING_WALLET.name())) && !this.f17169d.equals(a.b.DEVICE_BINDING_PASSBOOK.name())) {
                this.f17167b.setText(getString(R.string.set_paytm_passcode));
            } else {
                this.f17167b.setText(getString(R.string.pb_setpasscode_device_binding_title));
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f17167b.setGravity(8388611);
                this.l.setText(R.string.pb_enter_passcode);
                this.l.setTextColor(androidx.core.content.b.c(this, R.color.color_8ba6c1));
                this.m.setVisibility(8);
            }
        }
        this.f17168c = (c) aVar.getItem(0);
        this.f17171f = (c) aVar.getItem(1);
        this.f17168c.f16236a = this;
        this.f17171f.f16236a = this;
        findViewById(R.id.set_passcode_img_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSetPasscode.this.a(view);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final String i() {
        return this.f17173h;
    }

    public final void a(String str) {
        this.f17173h = str;
    }

    /* access modifiers changed from: protected */
    public final ViewPager j() {
        return this.f17170e;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "set_passcode", "", "", "/bank/saving-account/set-passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        m.a(this, "passcode_set_new", "passcode ppbl", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f17168c.a();
        String str2 = this.f17169d;
        if (str2 == null || !str2.equals(a.b.DEVICE_BINDING_WALLET.name())) {
            this.f17167b.setText(R.string.confirm_your_paytm_passcode);
        } else {
            this.l.setText(R.string.pb_confirm_passcode);
        }
        this.l.setText(getString(R.string.pb_confirm_passcode));
        this.f17170e.setCurrentItem(1);
        this.f17173h = str;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "confirm_passcode", "", "", "/bank/saving-account/set-passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        m.a(this, "passcode_set_confirm", "passcode ppbl", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        if (!this.f17173h.equals(str)) {
            this.f17172g.setVisibility(0);
            this.f17171f.a(true);
            return;
        }
        this.f17171f.a(false);
        c();
        a(this.f17173h, str);
    }

    public final void a(String str, c cVar) {
        if (cVar == this.f17168c) {
            b(str);
        } else if (cVar == this.f17171f) {
            c(str);
        }
    }

    public final void b() {
        String str = this.f17169d;
        if (str == null || !str.equals(a.b.DEVICE_BINDING_WALLET.name())) {
            this.f17167b.setText(R.string.set_paytm_passcode);
        } else {
            this.f17167b.setText(R.string.pb_setpasscode_device_binding_title);
            this.l.setText(R.string.pb_enter_passcode);
        }
        this.f17172g.setVisibility(8);
        this.f17170e.setCurrentItem(0);
        this.f17168c.a();
        this.f17171f.a();
    }

    public final void a(boolean z) {
        if (z) {
            this.f17172g.setVisibility(0);
        } else {
            this.f17172g.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        setResult(-1, getIntent());
        finish();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        f.a((Context) this, networkCustomError, i2);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        try {
            g gVar = g.f16329a;
            d.b();
            String a2 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str);
            d.b();
            net.one97.paytm.bankCommon.g.f a3 = g.a(this, a2, com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str2), String.valueOf(System.currentTimeMillis()), new g.b<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                    AJRSetPasscode.this.ah_();
                    if (iJRPaytmDataModel instanceof ValidatePasscode) {
                        ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
                        AJRSetPasscode.this.c();
                        if (validatePasscode == null) {
                            return;
                        }
                        if (validatePasscode.getStatus() != null && validatePasscode.getStatus().equalsIgnoreCase("SUCCESS")) {
                            net.one97.paytm.bankCommon.h.b.a((Context) AJRSetPasscode.this, true);
                            Toast.makeText(AJRSetPasscode.this, R.string.passcode_set_success, 0).show();
                            AJRSetPasscode.this.k();
                        } else if (validatePasscode.getStatus() != null && validatePasscode.getStatus().equalsIgnoreCase("SUCCESS") && validatePasscode.getResponseCode() == 1900) {
                            net.one97.paytm.bankCommon.h.b.a((Context) AJRSetPasscode.this, true);
                            if (!TextUtils.isEmpty(validatePasscode.getMessage())) {
                                Toast.makeText(AJRSetPasscode.this, validatePasscode.getMessage(), 0).show();
                            }
                            AJRSetPasscode.this.k();
                        } else if (!TextUtils.isEmpty(validatePasscode.getMessage())) {
                            AJRSetPasscode aJRSetPasscode = AJRSetPasscode.this;
                            b.b((Context) aJRSetPasscode, aJRSetPasscode.getString(R.string.error), validatePasscode.getMessage());
                        }
                    }
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSetPasscode.this.ah_();
                    f.a((Context) AJRSetPasscode.this, networkCustomError, i2);
                }
            }, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
            if (b.c((Context) this)) {
                a(this, getString(R.string.please_wait));
                getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a3);
                return;
            }
            h hVar = h.f19510a;
            h.a(a3, this);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof SetPasscodeModel)) {
            ah_();
            SetPasscodeModel setPasscodeModel = (SetPasscodeModel) iJRPaytmDataModel;
            if (TextUtils.isEmpty(setPasscodeModel.status)) {
                return;
            }
            if (setPasscodeModel.status.equalsIgnoreCase("success") && setPasscodeModel.responseCode.equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                net.one97.paytm.bankCommon.h.b.a((Context) this, true);
                Toast.makeText(this, R.string.passcode_set_success, 0).show();
                setResult(-1, getIntent());
                finish();
            } else if (setPasscodeModel.status.equalsIgnoreCase("FAILURE") && setPasscodeModel.responseCode.equalsIgnoreCase("1304")) {
                net.one97.paytm.bankCommon.h.b.a((Context) this, true);
                if (!TextUtils.isEmpty(setPasscodeModel.message)) {
                    Toast.makeText(this, setPasscodeModel.message, 0).show();
                }
                setResult(-1, getIntent());
                finish();
            } else if (!TextUtils.isEmpty(setPasscodeModel.message)) {
                b.b((Context) this, getString(R.string.error), setPasscodeModel.message);
            }
        }
    }
}
