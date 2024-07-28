package net.one97.paytm.paymentsBank.pdc.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.k;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJRIMPSInitiateDataModel;
import net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse;
import net.one97.paytm.bankCommon.model.PDCAtmPinSetResponse;
import net.one97.paytm.bankCommon.model.PermBlockDCResponse;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.payments.c.c.b;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.ManageDebitCardActivity;
import net.one97.paytm.paymentsBank.b.a;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.fragment.j;
import net.one97.paytm.paymentsBank.model.nach.NachConsentResponse;
import net.one97.paytm.paymentsBank.pdc.a.m;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.utils.h;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class PDCPasscodePinActivity extends PaytmActivity implements c.a, c.b, d, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    Fragment f18678a = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f18679b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f18680c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressDialog f18681d;

    /* renamed from: e  reason: collision with root package name */
    private String f18682e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f18683f;

    /* renamed from: g  reason: collision with root package name */
    private String f18684g;

    /* renamed from: h  reason: collision with root package name */
    private String f18685h;

    /* renamed from: i  reason: collision with root package name */
    private String f18686i;
    private String j;
    private boolean k;
    private int l;
    private boolean m;

    public final void a(boolean z) {
    }

    public void onFragmentAction(int i2, Object obj) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        j jVar;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        c(false);
        if (iJRPaytmDataModel instanceof PBVerifyPasscodeResponse) {
            PBVerifyPasscodeResponse pBVerifyPasscodeResponse = (PBVerifyPasscodeResponse) iJRPaytmDataModel;
            if (pBVerifyPasscodeResponse.getError() == null) {
                ((m) this.f18678a).b(false);
                if (!TextUtils.isEmpty(this.f18680c)) {
                    this.f18683f = pBVerifyPasscodeResponse.getAccessToken();
                    if (this.f18680c.equals("verifyPassAndActivatePin")) {
                        Intent intent = new Intent(this, PDCVerifyDebitAndAccNoActivity.class);
                        intent.putExtra("accessToken", this.f18683f);
                        startActivityForResult(intent, 101);
                    } else if (this.f18680c.equals("verifyPasscodeAndBlockPDC")) {
                        f();
                    } else if (this.f18680c.equalsIgnoreCase("verifyPasscodeAndSendConsent")) {
                        g();
                    } else if (this.f18680c.equalsIgnoreCase("atmPinForgot")) {
                        this.f18678a = m.b(getString(R.string.pdc_set_new_atm_pin_reset), getString(R.string.set_atm_pin_desc), getString(R.string.pdc_confirm_new_atm_pin_reset), this, this);
                        getSupportFragmentManager().a().b(R.id.container_framelayout, this.f18678a, (String) null).c();
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                PDCPasscodePinActivity.this.j();
                            }
                        }, 100);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("accessToken", pBVerifyPasscodeResponse.getAccessToken());
                        setResult(-1, intent2);
                        finish();
                    }
                }
            } else {
                ((m) this.f18678a).a(pBVerifyPasscodeResponse.getErrorDescription());
            }
        } else if (iJRPaytmDataModel instanceof CJRIMPSInitiateDataModel) {
            Intent intent3 = new Intent();
            intent3.putExtra("imps_data", (CJRIMPSInitiateDataModel) iJRPaytmDataModel);
            setResult(-1, intent3);
            finish();
        } else if (iJRPaytmDataModel instanceof PDCAtmPinSetResponse) {
            PDCAtmPinSetResponse pDCAtmPinSetResponse = (PDCAtmPinSetResponse) iJRPaytmDataModel;
            if ("SUCCESS".equalsIgnoreCase(pDCAtmPinSetResponse.getStatus())) {
                if (this.f18680c.equalsIgnoreCase("verifyPassAndActivatePin")) {
                    net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "confirm_new_atm_card_pin", "", "", "/bank/savings-account/debit-card/confirm_new_pin", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    b bVar = b.f17264a;
                    if (b.d()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("goToScreen", "activate_pdc_success");
                        b bVar2 = b.f17264a;
                        b.a(this, bundle);
                    } else {
                        Intent intent4 = new Intent(this, ManageDebitCardActivity.class);
                        intent4.setFlags(603979776);
                        intent4.putExtra("fromATMPinChangePage", 101);
                        startActivity(intent4);
                    }
                    finish();
                } else if (this.f18680c.equalsIgnoreCase("atmPinReset")) {
                    if (TextUtils.isEmpty(this.f18685h)) {
                        this.f18685h = this.f18686i;
                        this.f18678a = m.b(getString(R.string.pdc_set_new_atm_pin_reset), getString(R.string.set_atm_pin_desc), getString(R.string.pdc_confirm_new_atm_pin_reset), this, this);
                        Bundle arguments = this.f18678a.getArguments();
                        arguments.putInt("isFrom", 2);
                        this.f18678a.setArguments(arguments);
                        getSupportFragmentManager().a().b(R.id.container_framelayout, this.f18678a, (String) null).c();
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                PDCPasscodePinActivity.this.i();
                            }
                        }, 100);
                        return;
                    }
                    net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "confirm_atm_card_pin", "", "", "/bank/savings-account/debit-card/confirm_pin", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    c();
                } else if (this.f18680c.equalsIgnoreCase("atmPinForgot")) {
                    c();
                } else if (!this.f18680c.equals("atmPinValidation")) {
                }
            } else if (ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(pDCAtmPinSetResponse.getStatus())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), pDCAtmPinSetResponse.getmStatusMessage());
            } else {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), pDCAtmPinSetResponse.getErrorMessage());
            }
        } else if (iJRPaytmDataModel instanceof PermBlockDCResponse) {
            PermBlockDCResponse permBlockDCResponse = (PermBlockDCResponse) iJRPaytmDataModel;
            if ("SUCCESS".equalsIgnoreCase(permBlockDCResponse.getStatus())) {
                setResult(-1);
                finish();
                return;
            }
            a(permBlockDCResponse.getMessage());
        } else if (iJRPaytmDataModel instanceof NachConsentResponse) {
            NachConsentResponse nachConsentResponse = (NachConsentResponse) iJRPaytmDataModel;
            if ("SUCCESS".equalsIgnoreCase(nachConsentResponse.getStatus())) {
                if (this.k) {
                    jVar = j.a(getString(R.string.pb_nach_accepted_mandate));
                } else {
                    jVar = j.a(getString(R.string.pb_nach_rejected_mandate));
                }
                jVar.show(getSupportFragmentManager(), j.class.getSimpleName());
                return;
            }
            a(nachConsentResponse.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        com.paytm.utility.b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.a_pdc_passcode_pin);
        this.f18679b = this;
        this.f18681d = new ProgressDialog(this.f18679b);
        this.f18680c = getIntent().getStringExtra("ENTER_HEADER");
        this.l = getIntent().getIntExtra("from_page", 101);
        this.f18684g = getIntent().getStringExtra("cardNumberAlias");
        this.m = getIntent().getBooleanExtra("isFromH5", false);
        new Handler();
        if (!TextUtils.isEmpty(this.f18680c)) {
            this.f18682e = getIntent().getStringExtra("pdc_qrcode_id");
            String str2 = "";
            if (this.f18680c.equalsIgnoreCase("pdcPasscodeValidation")) {
                net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "passcode_verification_atm_card", "", "", "/bank/savings-account/passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                this.f18678a = m.a((!k.b() && !k.b()) ? getString(R.string.forgot_passcode) : str2, getString(R.string.pdc_enter_passcode_title), str2, this, this);
            } else if (this.f18680c.equals("verifyPassAndActivatePin")) {
                net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "passcode_verification_atm_card", "", "", "/bank/savings-account/passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                if (!k.b() && !k.b()) {
                    str2 = getString(R.string.forgot_passcode);
                }
                this.f18678a = m.a(str2, getString(R.string.pdc_enter_passcode_title_to_set_debit_card), getString(R.string.pdc_passcode_desc), this, this);
            } else if (this.f18680c.equalsIgnoreCase("atmPinSet")) {
                this.f18678a = m.b(getString(R.string.set_your_atm_pin), getString(R.string.set_atm_pin_desc), getString(R.string.confirm_atm_pin), this, this);
            } else if (this.f18680c.equalsIgnoreCase("atmPinValidation")) {
                this.f18678a = m.a((String) null, getString(R.string.confirm_atm_pin), (String) null, this, this);
            } else if (this.f18680c.equalsIgnoreCase("atmPinReset")) {
                this.f18678a = m.a(getString(R.string.forgot_atm_pin), getString(R.string.pdc_enter_four_digit_atm_pin), (String) null, this, this);
            } else if (this.f18680c.equalsIgnoreCase("atmPinForgot")) {
                net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "passcode_verification_atm_card", "", "", "/bank/savings-account/passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                if (!k.b()) {
                    str2 = getString(R.string.forgot_passcode);
                }
                this.f18678a = m.a(str2, getString(R.string.pdc_enter_passcode_title_to_reset_debit_card), (String) null, this, this);
            } else if (this.f18680c.equalsIgnoreCase("verifyPasscodeAndBlockPDC")) {
                this.f18684g = getIntent().getStringExtra("cardAlias");
                if (!k.b()) {
                    str2 = getString(R.string.forgot_passcode);
                }
                this.f18678a = m.a(str2, getString(R.string.pb_block_dc_passcode_page_title), (String) null, this, this);
            } else if (this.f18680c.equalsIgnoreCase("verifyPasscodeAndSendConsent")) {
                this.j = getIntent().getStringExtra("postParams");
                this.k = getIntent().getBooleanExtra("isAcceptingMandate", false);
                getString(R.string.pb_passcode_title_nach_accept);
                if (this.k) {
                    str = getString(R.string.pb_passcode_title_nach_accept);
                } else {
                    str = getString(R.string.pb_passcode_title_nach_reject);
                }
                String stringExtra = getIntent().getStringExtra("desc");
                if (!k.b()) {
                    str2 = getString(R.string.forgot_passcode);
                }
                this.f18678a = m.a(str2, str, stringExtra, this, this);
            }
            if (this.f18678a != null) {
                getSupportFragmentManager().a().b(R.id.container_framelayout, this.f18678a, (String) null).c();
                b(true);
                String stringExtra2 = getIntent().getStringExtra("passcodeToolbarTitle");
                if (stringExtra2 != null) {
                    setTitle(stringExtra2);
                }
            } else {
                finish();
            }
        }
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PDCPasscodePinActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onDestroy() {
        com.paytm.utility.b.c((Activity) this);
        super.onDestroy();
    }

    private void b(boolean z) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (z) {
                inputMethodManager.showSoftInputFromInputMethod(currentFocus.getWindowToken(), 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        if (z) {
            if (!this.f18681d.isShowing()) {
                this.f18681d = ProgressDialog.show(this, "", getString(R.string.pb_please_wait_progress_msg), true);
            }
        } else if (this.f18681d.isShowing()) {
            this.f18681d.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    private void c() {
        if (this.l == 100) {
            setResult(-1);
        } else if (this.m) {
            Intent intent = new Intent();
            intent.putExtra("isPassCodeSet", true);
            setResult(-1, intent);
        } else {
            Intent intent2 = new Intent(this, ManageDebitCardActivity.class);
            intent2.setFlags(603979776);
            intent2.putExtra("fromATMPinChangePage", 102);
            startActivity(intent2);
        }
        finish();
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), str);
        } else {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
        }
    }

    public final void a(String str, c cVar) {
        if (this.f18680c.equalsIgnoreCase("pdcPasscodeValidation")) {
            c(str);
        } else if (this.f18680c.equals("verifyPassAndActivatePin")) {
            if (TextUtils.isEmpty(this.f18683f)) {
                c(str);
            } else {
                d(str);
            }
        } else if (this.f18680c.equalsIgnoreCase("atmPinSet")) {
            d(str);
        } else if (this.f18680c.equalsIgnoreCase("atmPinValidation")) {
            b(str);
        } else if (this.f18680c.equals("atmPinReset")) {
            if (TextUtils.isEmpty(this.f18685h)) {
                this.f18686i = str;
                b(str);
                return;
            }
            String str2 = this.f18685h;
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f b2 = a.b((Object) this, str2, str, this.f18684g, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            if (com.paytm.utility.b.c(this.f18679b)) {
                b(false);
                c(true);
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(b2);
                return;
            }
            b(b2);
        } else if (this.f18680c.equalsIgnoreCase("atmPinForgot")) {
            if (TextUtils.isEmpty(this.f18683f)) {
                c(str);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            f a2 = net.one97.paytm.paymentsBank.b.a.a((Object) this, this.f18683f, str, this.f18684g, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            if (com.paytm.utility.b.c(this.f18679b)) {
                b(false);
                c(true);
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            b(a2);
        } else if (this.f18680c.equals("verifyPasscodeAndBlockPDC")) {
            c(str);
        } else if (this.f18680c.equalsIgnoreCase("verifyPasscodeAndSendConsent")) {
            c(str);
        }
    }

    private void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = net.one97.paytm.paymentsBank.b.a.a((Object) this, str, this.f18684g, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (com.paytm.utility.b.c(this.f18679b)) {
            b(false);
            c(true);
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
            return;
        }
        b(a2);
    }

    private void c(String str) {
        try {
            net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
            f a2 = net.one97.paytm.bankCommon.utils.g.a(this.f18679b, str, new net.one97.paytm.bankCommon.f.b<String>() {
                public final void a(String str, String str2) {
                    PDCPasscodePinActivity.this.c(false);
                    if (!TextUtils.isEmpty(str)) {
                        ((m) PDCPasscodePinActivity.this.f18678a).b(false);
                        if (!TextUtils.isEmpty(PDCPasscodePinActivity.this.f18680c)) {
                            String unused = PDCPasscodePinActivity.this.f18683f = str;
                            if (PDCPasscodePinActivity.this.f18680c.equals("verifyPassAndActivatePin")) {
                                Intent intent = new Intent(PDCPasscodePinActivity.this, PDCVerifyDebitAndAccNoActivity.class);
                                intent.putExtra("accessToken", PDCPasscodePinActivity.this.f18683f);
                                PDCPasscodePinActivity.this.startActivityForResult(intent, 101);
                            } else if (PDCPasscodePinActivity.this.f18680c.equals("verifyPasscodeAndBlockPDC")) {
                                PDCPasscodePinActivity.this.f();
                            } else if (PDCPasscodePinActivity.this.f18680c.equalsIgnoreCase("verifyPasscodeAndSendConsent")) {
                                PDCPasscodePinActivity.this.g();
                            } else if (PDCPasscodePinActivity.this.f18680c.equalsIgnoreCase("atmPinForgot")) {
                                PDCPasscodePinActivity pDCPasscodePinActivity = PDCPasscodePinActivity.this;
                                String string = pDCPasscodePinActivity.getString(R.string.pdc_set_new_atm_pin_reset);
                                String string2 = PDCPasscodePinActivity.this.getString(R.string.set_atm_pin_desc);
                                String string3 = PDCPasscodePinActivity.this.getString(R.string.pdc_confirm_new_atm_pin_reset);
                                PDCPasscodePinActivity pDCPasscodePinActivity2 = PDCPasscodePinActivity.this;
                                pDCPasscodePinActivity.f18678a = m.b(string, string2, string3, pDCPasscodePinActivity2, pDCPasscodePinActivity2);
                                PDCPasscodePinActivity.this.getSupportFragmentManager().a().b(R.id.container_framelayout, PDCPasscodePinActivity.this.f18678a, (String) null).c();
                                new Handler().postDelayed(new Runnable() {
                                    public final void run() {
                                        PDCPasscodePinActivity.AnonymousClass1.this.a();
                                    }
                                }, 100);
                            } else {
                                Intent intent2 = new Intent();
                                intent2.putExtra("accessToken", str);
                                PDCPasscodePinActivity.this.setResult(-1, intent2);
                                PDCPasscodePinActivity.this.finish();
                            }
                        }
                    } else {
                        ((m) PDCPasscodePinActivity.this.f18678a).a(str2);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a() {
                    ((InputMethodManager) PDCPasscodePinActivity.this.getSystemService("input_method")).toggleSoftInput(2, 0);
                }

                public final void a(int i2, NetworkCustomError networkCustomError) {
                    PDCPasscodePinActivity.this.c(false);
                    net.one97.paytm.bankCommon.utils.f.a((Context) PDCPasscodePinActivity.this, networkCustomError, i2);
                }
            });
            if (a2 == null) {
                return;
            }
            if (com.paytm.utility.b.c(this.f18679b)) {
                b(false);
                c(true);
                getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            h hVar = h.f19510a;
            h.a(a2, this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f c2 = net.one97.paytm.paymentsBank.b.a.c((Object) this, this.f18683f, this.f18682e, str, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (com.paytm.utility.b.c(this.f18679b)) {
            b(false);
            c(true);
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(c2);
            return;
        }
        b(c2);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c(false);
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    public final void b() {
        super.onBackPressed();
    }

    public void onBackPressed() {
        b(false);
        super.onBackPressed();
    }

    public final void a() {
        if (this.f18680c.equalsIgnoreCase("pdcPasscodeValidation") || this.f18680c.equals("verifyPassAndActivatePin") || this.f18680c.equals("verifyPasscodeAndBlockPDC") || this.f18680c.equalsIgnoreCase("verifyPasscodeAndSendConsent")) {
            net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "forgot_passcode_clicked", "", "", "/bank/savings-account/passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            d();
        } else if (!this.f18680c.equalsIgnoreCase("atmPinSet") && !this.f18680c.equalsIgnoreCase("atmPinValidation")) {
            if (this.f18680c.equalsIgnoreCase("atmPinReset")) {
                Intent intent = new Intent(this, PDCPasscodePinActivity.class);
                intent.putExtra("cardNumberAlias", this.f18684g);
                intent.putExtra("ENTER_HEADER", "atmPinForgot");
                intent.putExtra("from_page", this.l);
                intent.putExtra("isFromH5", this.m);
                if (this.l == 100 || this.m) {
                    startActivityForResult(intent, 109);
                } else {
                    startActivity(intent);
                }
            } else if (this.f18680c.equalsIgnoreCase("atmPinForgot") && TextUtils.isEmpty(this.f18683f)) {
                net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "forgot_passcode_clicked", "", "", "/bank/savings-account/passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                d();
            }
        }
    }

    private void d() {
        b bVar = b.f17264a;
        if (b.b()) {
            b bVar2 = b.f17264a;
            b.d(this, new Bundle());
        } else if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            ForgotPasscodeChallengesActivity.a((Context) this);
        } else {
            e();
        }
    }

    private void e() {
        if (!isFinishing()) {
            net.one97.paytm.paymentsBank.fragment.k.a().show(getSupportFragmentManager().a(), "dialog");
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            if (i3 == -1) {
                this.f18678a = m.b(getString(R.string.set_your_atm_pin), getString(R.string.set_atm_pin_desc), getString(R.string.confirm_atm_pin), this, this);
                Bundle arguments = this.f18678a.getArguments();
                arguments.putInt("isFrom", 1);
                this.f18678a.setArguments(arguments);
                getSupportFragmentManager().a().b(R.id.container_framelayout, this.f18678a, (String) null).c();
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        PDCPasscodePinActivity.this.h();
                    }
                }, 100);
                return;
            }
            finish();
        } else if (i2 == 6428 && i3 == -1) {
            finish();
        } else if (i2 == 6733 && i3 == -1) {
            if (intent != null && intent.hasExtra("forgot_passcode_access")) {
                Intent intent2 = new Intent(this, AJRForgotPasscode.class);
                intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
                startActivityForResult(intent2, 6428);
            }
        } else if (i2 != 109 || i3 != -1) {
        } else {
            if (this.l == 100) {
                setResult(-1);
                finish();
            } else if (this.m) {
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* access modifiers changed from: private */
    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, this.f18684g, UpiConstants.B2C_ANDROID, "", a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (a2 != null) {
            a(a2);
        } else {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_pdc_something_went_wrong));
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        net.one97.paytm.bankCommon.g.b bVar;
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        String str = this.j;
        a.c cVar = a.c.PAYMENTSBANK;
        a.b bVar2 = a.b.USER_FACING;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(this));
        hashMap2.put("Content-Type", "application/json");
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = net.one97.paytm.bankCommon.utils.d.a("nachGetConsentURL");
        if (!URLUtil.isValidUrl(a2)) {
            bVar = null;
        } else {
            bVar = new net.one97.paytm.bankCommon.g.b(com.paytm.utility.c.b(a2, (Context) this), (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new NachConsentResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, str, a.C0715a.POST, cVar, bVar2, (HashMap<String, String>) hashMap);
        }
        if (bVar != null) {
            a((f) bVar);
        }
    }

    private void a(f fVar) {
        if (com.paytm.utility.b.c(this.f18679b)) {
            c(true);
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(fVar);
            return;
        }
        b(fVar);
    }

    private void b(f fVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(fVar) {
            private final /* synthetic */ f f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                PDCPasscodePinActivity.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (com.paytm.utility.b.c((Context) this)) {
            c(true);
            getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(fVar);
            return;
        }
        b(fVar);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
