package net.one97.paytm.paymentsBank.forgotpasscode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.q;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.g;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.payments.activity.AadharValidatePasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.a;
import net.one97.paytm.paymentsBank.forgotpasscode.model.DormantAccActivationResponse;
import net.one97.paytm.paymentsBank.forgotpasscode.model.OVDVerifyChallengeResponse;
import net.one97.paytm.paymentsBank.forgotpasscode.model.OvdOtpSendResponse;
import net.one97.paytm.paymentsBank.forgotpasscode.model.PrimaryKYCDocModel;
import net.one97.paytm.paymentsBank.fragment.e;
import net.one97.paytm.paymentsBank.pdc.b.a;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.m;
import net.one97.paytm.paymentsBank.utils.o;
import org.json.JSONException;
import org.json.JSONObject;

public class ForgotPasscodeChallengesActivity extends PBBaseActivity implements d, e.b {

    /* renamed from: b  reason: collision with root package name */
    private int f18360b = 0;

    /* renamed from: c  reason: collision with root package name */
    private CustProductList f18361c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18362d;

    /* renamed from: e  reason: collision with root package name */
    private String f18363e;

    /* renamed from: f  reason: collision with root package name */
    private String f18364f;

    /* renamed from: g  reason: collision with root package name */
    private a f18365g;

    /* renamed from: h  reason: collision with root package name */
    private String f18366h = "PASSCODE_RESET";

    /* renamed from: i  reason: collision with root package name */
    private String f18367i;

    public static void a(Context context) {
        Intent intent = new Intent(context, ForgotPasscodeChallengesActivity.class);
        intent.putExtra(SDKConstants.EXTRA_NEW_FLOW, false);
        context.startActivity(intent);
    }

    public static void b(Context context) {
        Intent intent = new Intent(context, ForgotPasscodeChallengesActivity.class);
        intent.putExtra(SDKConstants.EXTRA_NEW_FLOW, false);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_forgot_passcode_challenges);
        findViewById(R.id.container);
        this.f18362d = true;
        if (getIntent() != null && getIntent().hasExtra("activity_flow")) {
            this.f18366h = getIntent().getStringExtra("activity_flow");
        }
        net.one97.paytm.paymentsBank.forgotpasscode.a.a aVar = new net.one97.paytm.paymentsBank.forgotpasscode.a.a();
        this.f18365g = aVar;
        getSupportFragmentManager().a().b(R.id.container, aVar, (String) null).c();
        if (b.c((Context) this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new c();
            c.a(a2);
            return;
        }
        d();
    }

    private void a(boolean z) {
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            if (z) {
                a(this, getString(R.string.please_wait));
            }
            this.f18360b++;
            HashMap hashMap = new HashMap();
            hashMap.put("authorization", com.paytm.utility.a.q(this));
            hashMap.put("uid", net.one97.paytm.bankCommon.mapping.a.n((Context) this));
            hashMap.put("verification_type", this.f18366h);
            hashMap.put("client", "ANDROID");
            getSystemService(ContactColumn.PHONE_NUMBER);
            hashMap.put(SDKConstants.X_DEVICE_IDENTIFIER, b.e((Context) this));
            net.one97.paytm.bankCommon.utils.d.b();
            String a2 = net.one97.paytm.bankCommon.utils.d.a("forgotPasscodeL1");
            if (!URLUtil.isValidUrl(a2)) {
                a2 = net.one97.paytm.bankOpen.f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v1/twoFactorAuthenticationL1" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/twoFactorAuthenticationL1";
            }
            String str = a2;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            JSONObject jSONObject = new JSONObject();
            try {
                Map<String, String> b2 = com.paytm.utility.c.b((Context) this, false);
                net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
                net.one97.paytm.bankCommon.utils.g.a(b2, this);
                jSONObject.put("device_info", new JSONObject(b2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(str, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new OvdOtpSendResponse(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap2);
            new c();
            c.a(bVar);
            return;
        }
        d();
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        ah_();
        if (iJRPaytmDataModel instanceof OvdOtpSendResponse) {
            OvdOtpSendResponse ovdOtpSendResponse = (OvdOtpSendResponse) iJRPaytmDataModel;
            if ("success".equalsIgnoreCase(ovdOtpSendResponse.getStatus())) {
                this.f18364f = ovdOtpSendResponse.getChallengeToken();
                if ("OVD".equalsIgnoreCase(ovdOtpSendResponse.getChallengeType())) {
                    b(true);
                } else if ("otp".equalsIgnoreCase(ovdOtpSendResponse.getChallengeType())) {
                    this.f18363e = ovdOtpSendResponse.getOtpToken();
                    net.one97.paytm.paymentsBank.forgotpasscode.a.b bVar = new net.one97.paytm.paymentsBank.forgotpasscode.a.b();
                    this.f18365g = bVar;
                    getSupportFragmentManager().a().b(R.id.container, bVar, (String) null).c();
                } else if ("PDC".equalsIgnoreCase(ovdOtpSendResponse.getChallengeType())) {
                    h();
                }
            } else {
                String string = getString(R.string.some_went_wrong);
                if (!TextUtils.isEmpty(ovdOtpSendResponse.getMessage())) {
                    string = ovdOtpSendResponse.getMessage();
                }
                if (TextUtils.isEmpty(this.f18364f)) {
                    com.paytm.utility.g.b(this, getString(R.string.error), string, new g.c() {
                        public final void onDialogDismissed() {
                            ForgotPasscodeChallengesActivity.this.k();
                        }
                    });
                } else {
                    net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), string);
                }
            }
        } else if (iJRPaytmDataModel instanceof OVDVerifyChallengeResponse) {
            OVDVerifyChallengeResponse oVDVerifyChallengeResponse = (OVDVerifyChallengeResponse) iJRPaytmDataModel;
            this.f18364f = oVDVerifyChallengeResponse.getChallengeToken();
            if ("success".equalsIgnoreCase(oVDVerifyChallengeResponse.getStatus())) {
                if ("ACTIVATE_ACCOUNT".equalsIgnoreCase(this.f18366h) && "COMPLETED".equalsIgnoreCase(oVDVerifyChallengeResponse.getChallengeType())) {
                    String str = this.f18364f;
                    if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
                        a(this, getString(R.string.please_wait));
                        this.f18360b++;
                        HashMap hashMap = new HashMap();
                        hashMap.put("user-token", com.paytm.utility.a.q(this));
                        hashMap.put("client-id", "PS");
                        hashMap.put("workflow-token", str);
                        hashMap.put("content-type", "application/json");
                        String stringFromGTM = o.a().getStringFromGTM("dormantAccActivation");
                        if (!URLUtil.isValidUrl(stringFromGTM)) {
                            stringFromGTM = o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://product-origin-ite.paytmbank.com/product/ext/v1/dormant-account" : "https://product.paytmbank.com/product/ext/v1/dormant-account";
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("screen_name", getClass().getSimpleName());
                        net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(stringFromGTM, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new DormantAccActivationResponse(), (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap2);
                        new c();
                        c.a(bVar2);
                        return;
                    }
                    d();
                } else if (!TextUtils.isEmpty(oVDVerifyChallengeResponse.getAccess_token()) && "COMPLETED".equalsIgnoreCase(oVDVerifyChallengeResponse.getChallengeType())) {
                    if (this.f18367i.equals("ovd")) {
                        m.a(this, "passcode_forgot_enter_kyc", "forgot passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                    }
                    Intent intent = new Intent(this, AJRForgotPasscode.class);
                    intent.putExtra("forgot_passcode_access", oVDVerifyChallengeResponse.getAccess_token());
                    startActivityForResult(intent, 9856);
                    finish();
                } else if ("OVD".equalsIgnoreCase(oVDVerifyChallengeResponse.getChallengeType())) {
                    b(true);
                } else if ("otp".equalsIgnoreCase(oVDVerifyChallengeResponse.getChallengeType())) {
                    net.one97.paytm.paymentsBank.forgotpasscode.a.b bVar3 = new net.one97.paytm.paymentsBank.forgotpasscode.a.b();
                    this.f18365g = bVar3;
                    getSupportFragmentManager().a().b(R.id.container, bVar3, (String) null).c();
                } else if ("PDC".equalsIgnoreCase(oVDVerifyChallengeResponse.getChallengeType())) {
                    h();
                }
            } else if (!TextUtils.isEmpty(oVDVerifyChallengeResponse.getMessage())) {
                if (this.f18367i.equals("ovd")) {
                    m.a(this, "passcode_forgot_enter_kyc_wrong", "forgot passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                }
                if (oVDVerifyChallengeResponse.getResponseCode().intValue() == 1939) {
                    if (oVDVerifyChallengeResponse.getResponseCode().intValue() == 1939 || oVDVerifyChallengeResponse.getResponseCode().intValue() == 1938) {
                        if (this.f18365g == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(oVDVerifyChallengeResponse.getMessage())) {
                            this.f18365g.a(oVDVerifyChallengeResponse.getMessage());
                        } else {
                            this.f18365g.a((Object) null);
                        }
                    } else if (oVDVerifyChallengeResponse.getResponseCode().intValue() == 1941) {
                        a(oVDVerifyChallengeResponse.getMessage());
                    } else {
                        net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), oVDVerifyChallengeResponse.getMessage());
                    }
                } else if (oVDVerifyChallengeResponse.getResponseCode().intValue() == 1941) {
                    a(oVDVerifyChallengeResponse.getMessage());
                } else {
                    net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), getString(R.string.some_went_wrong));
                }
            }
        } else if (iJRPaytmDataModel instanceof CustProductList) {
            this.f18361c = (CustProductList) iJRPaytmDataModel;
            if ("ACTIVATE_ACCOUNT".equalsIgnoreCase(this.f18366h)) {
                net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
                if (net.one97.paytm.paymentsBank.utils.a.e(this.f18361c)) {
                    q a2 = getSupportFragmentManager().a();
                    int i2 = R.id.container;
                    e.a aVar2 = e.f18497a;
                    net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
                    a2.b(i2, e.a.a(net.one97.paytm.paymentsBank.utils.a.a(this.f18361c, true), false), (String) null).c();
                    return;
                }
                q a3 = getSupportFragmentManager().a();
                int i3 = R.id.container;
                e.a aVar4 = e.f18497a;
                net.one97.paytm.paymentsBank.utils.a aVar5 = net.one97.paytm.paymentsBank.utils.a.f19494a;
                a3.b(i3, e.a.a(net.one97.paytm.paymentsBank.utils.a.a(this.f18361c, true), true), (String) null).c();
            } else if (this.f18362d) {
                a(false);
            } else {
                b(false);
            }
        } else if (!(iJRPaytmDataModel instanceof DormantAccActivationResponse)) {
        } else {
            if (!"success".equalsIgnoreCase(((DormantAccActivationResponse) iJRPaytmDataModel).getStatus())) {
                com.paytm.utility.g.b(this, getString(R.string.error), getString(R.string.some_went_wrong));
            } else if (!isFinishing() && !isDestroyed()) {
                new AlertDialog.Builder(this).setMessage(getString(R.string.pb_activated_saving_acc)).setCancelable(true).setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        ForgotPasscodeChallengesActivity.this.a(dialogInterface);
                    }
                }).setPositiveButton(getString(R.string.pb_add_money), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        ForgotPasscodeChallengesActivity.this.a(dialogInterface, i2);
                    }
                }).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.container;
        e.a aVar = e.f18497a;
        net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        a2.b(i2, e.a.a(net.one97.paytm.paymentsBank.utils.a.a(this.f18361c, true), true), (String) null).c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        o.a().checkDeepLinking(this, "paytmmp://payment_bank?featuretype=bank_landing&open_screen=add_money");
        finish();
    }

    private void a(String str) {
        com.paytm.utility.g.b(this, getString(R.string.error), str, new g.c() {
            public final void onDialogDismissed() {
                ForgotPasscodeChallengesActivity.this.j();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        finish();
    }

    private void h() {
        net.one97.paytm.paymentsBank.forgotpasscode.a.c cVar = new net.one97.paytm.paymentsBank.forgotpasscode.a.c();
        Bundle bundle = new Bundle();
        String string = getString(R.string.pb_ovd_pdc_desc);
        bundle.putString("title", getString(R.string.pb_ovd_pdc_title, new Object[]{string}));
        bundle.putString("subTitle", "");
        bundle.putString("desc", getString(R.string.pb_pdc_enter_last_6_digit, new Object[]{"8", string}));
        bundle.putString("challengeType", "PDC");
        bundle.putInt("digits", 8);
        bundle.putString("accno", this.f18361c.getIsaAccNum());
        cVar.setArguments(bundle);
        this.f18365g = cVar;
        getSupportFragmentManager().a().b(R.id.container, cVar, (String) null).c();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        j.a((Context) this, networkCustomError, i2);
    }

    private void b(boolean z) {
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            if (z) {
                a(this, getString(R.string.please_wait));
            }
            a a2 = a.a(this);
            a2.f18369a = this;
            a2.a((g.b<IJRPaytmDataModel>) new g.b(z, a2) {
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ a f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(Object obj) {
                    ForgotPasscodeChallengesActivity.this.a(this.f$1, this.f$2, (IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    ForgotPasscodeChallengesActivity.this.a(this.f$1, i2, iJRPaytmDataModel, networkCustomError);
                }
            });
            return;
        }
        d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        if (z) {
            ah_();
        }
        if (this.f18361c == null) {
            com.paytm.utility.g.b(this, getString(R.string.error), getString(R.string.pb_pdc_something_went_wrong), new g.c() {
                public final void onDialogDismissed() {
                    ForgotPasscodeChallengesActivity.this.i();
                }
            });
            return;
        }
        PrimaryKYCDocModel primaryKYCDocModel = (PrimaryKYCDocModel) iJRPaytmDataModel;
        if (primaryKYCDocModel == null) {
            return;
        }
        if (primaryKYCDocModel.getError() != null && !TextUtils.isEmpty(primaryKYCDocModel.getError().f18391a)) {
            net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), primaryKYCDocModel.getError().f18391a);
        } else if (primaryKYCDocModel.getPrimaryDocument() == null) {
        } else {
            if (!this.f18362d) {
                Intent intent = new Intent(this, AadharValidatePasscode.class);
                intent.putExtra("subTitle", aVar.f18370b);
                startActivityForResult(intent, 7);
                return;
            }
            String string = getString(R.string.pb_ovd_verify_kyc_doc);
            Bundle bundle = new Bundle();
            String str3 = "";
            if (primaryKYCDocModel.getPrimaryDocument().equalsIgnoreCase(a.C0315a.AADHAR.getPrimaryDocument())) {
                str = getString(R.string.pb_ovd_adhar);
                str2 = getString(R.string.pb_ovd_enter_first_4_digit, new Object[]{str});
                bundle.putBoolean("et_enabled", false);
            } else if (primaryKYCDocModel.getPrimaryDocument().equalsIgnoreCase(a.C0315a.NREGA_JOB.getPrimaryDocument())) {
                str = getString(R.string.pb_ovd_nrega);
                str2 = getString(R.string.pb_ovd_enter_last_4_digit, new Object[]{str});
                bundle.putBoolean("et_enabled", true);
            } else if (primaryKYCDocModel.getPrimaryDocument().equalsIgnoreCase(a.C0315a.PASSPORT.getPrimaryDocument())) {
                str = getString(R.string.pb_ovd_passport);
                str2 = getString(R.string.pb_ovd_enter_last_4_digit, new Object[]{str});
                bundle.putBoolean("et_enabled", true);
            } else if (primaryKYCDocModel.getPrimaryDocument().equalsIgnoreCase(a.C0315a.DRIVING_LICENSE.getPrimaryDocument())) {
                str = getString(R.string.pb_ovd_dl);
                str2 = getString(R.string.pb_ovd_enter_last_4_digit, new Object[]{str});
                bundle.putBoolean("et_enabled", true);
            } else if (primaryKYCDocModel.getPrimaryDocument().equalsIgnoreCase(a.C0315a.VOTER_ID_CARD.getPrimaryDocument())) {
                str = getString(R.string.pb_ovd_voter_id);
                str2 = getString(R.string.pb_ovd_enter_last_4_digit, new Object[]{str});
                bundle.putBoolean("et_enabled", true);
            } else {
                str = str3;
                str2 = str;
            }
            int i2 = R.string.pb_ovd_as_per_bank_recd;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = TextUtils.isEmpty(this.f18361c.getIsaAccNum()) ? str3 : this.f18361c.getIsaAccNum();
            String string2 = getString(i2, objArr);
            net.one97.paytm.paymentsBank.forgotpasscode.a.c cVar = new net.one97.paytm.paymentsBank.forgotpasscode.a.c();
            bundle.putString("title", string);
            bundle.putString("subTitle", string2);
            bundle.putString("desc", str2);
            bundle.putString("challengeType", "ovd");
            if (!TextUtils.isEmpty(this.f18361c.getIsaAccNum())) {
                str3 = this.f18361c.getIsaAccNum();
            }
            bundle.putString("accno", str3);
            bundle.putInt("digits", 4);
            cVar.setArguments(bundle);
            this.f18365g = cVar;
            getSupportFragmentManager().a().b(R.id.container, cVar, (String) null).c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (z) {
            ah_();
        }
        j.a((Activity) this, (Exception) networkCustomError, (String) null, (Bundle) null);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 7) {
            if (i3 == -1) {
                if (intent != null && intent.hasExtra("forgot_passcode_access")) {
                    Intent intent2 = new Intent(this, AJRForgotPasscode.class);
                    intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
                    startActivityForResult(intent2, 9856);
                } else {
                    return;
                }
            }
            finish();
        }
    }

    public void onFragmentAction(int i2, Object obj) {
        int i3 = i2;
        if (i3 == 101) {
            b(true);
        } else if (i3 == 102) {
            a(true);
        } else if (i3 == 100) {
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("challengeType");
            String str2 = (String) hashMap.get("challengeVal");
            this.f18367i = str;
            if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
                a(this, getString(R.string.please_wait));
                this.f18360b++;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("authorization", com.paytm.utility.a.q(this));
                hashMap2.put("uid", net.one97.paytm.bankCommon.mapping.a.n((Context) this));
                hashMap2.put("verification_type", this.f18366h);
                hashMap2.put("client", "ANDROID");
                getSystemService(ContactColumn.PHONE_NUMBER);
                hashMap2.put(SDKConstants.X_DEVICE_IDENTIFIER, b.e((Context) this));
                net.one97.paytm.bankCommon.utils.d.b();
                String a2 = net.one97.paytm.bankCommon.utils.d.a("forgotPasscodeL2");
                if (!URLUtil.isValidUrl(a2)) {
                    a2 = net.one97.paytm.bankOpen.f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v1/twoFactorAuthenticationL2" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/twoFactorAuthenticationL2";
                }
                String str3 = a2;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("screen_name", getClass().getSimpleName());
                JSONObject jSONObject = new JSONObject();
                try {
                    if (str.equalsIgnoreCase("otp")) {
                        jSONObject.put("otpToken", this.f18363e);
                    }
                    jSONObject.put("challenge_value", str2);
                    jSONObject.put("challenge_type", str.toUpperCase());
                    jSONObject.put("challengeToken", this.f18364f);
                    Map<String, String> b2 = com.paytm.utility.c.b((Context) this, false);
                    net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
                    net.one97.paytm.bankCommon.utils.g.a(b2, this);
                    jSONObject.put("device_info", new JSONObject(b2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(str3, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new OVDVerifyChallengeResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap3);
                new c();
                c.a(bVar);
                return;
            }
            d();
        }
    }

    public final void e() {
        a(true);
    }

    public final void f() {
        finish();
    }

    public final void g() {
        finish();
    }
}
