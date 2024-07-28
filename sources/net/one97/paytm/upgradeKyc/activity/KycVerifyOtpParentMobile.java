package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.SendOtpErrorModel;
import net.one97.paytm.common.entity.upgradeKyc.SendOtpMinorKycModel;
import net.one97.paytm.common.entity.upgradeKyc.ValidateOtpMinorKycModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.q;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class KycVerifyOtpParentMobile extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f65350a;

    /* renamed from: b  reason: collision with root package name */
    private String f65351b;

    /* renamed from: d  reason: collision with root package name */
    private q f65352d;

    /* renamed from: e  reason: collision with root package name */
    private KycAadharEkycDetails.KycResponse f65353e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f65354f;

    public final View a(int i2) {
        if (this.f65354f == null) {
            this.f65354f = new HashMap();
        }
        View view = (View) this.f65354f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65354f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            if (getIntent().hasExtra("parentMobileNumber")) {
                this.f65350a = getIntent().getStringExtra("parentMobileNumber");
                if (!TextUtils.isEmpty(this.f65350a)) {
                    TextView textView = (TextView) a(R.id.enter_otp_tv);
                    k.a((Object) textView, "enter_otp_tv");
                    textView.setText(getString(R.string.enter_opt_sent_to_parent, new Object[]{this.f65350a}));
                } else {
                    TextView textView2 = (TextView) a(R.id.enter_otp_tv);
                    k.a((Object) textView2, "enter_otp_tv");
                    textView2.setText(getString(R.string.enter_opt_sent_to_parent_without_mobile_number));
                }
            }
            if (getIntent().hasExtra("reference_number")) {
                this.f65351b = getIntent().getStringExtra("reference_number");
            }
            if (getIntent().hasExtra("aadhaarData")) {
                this.f65353e = (KycAadharEkycDetails.KycResponse) getIntent().getSerializableExtra("aadhaarData");
            }
        }
        this.f65352d = new q();
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        int i2 = R.id.otp_boxes_container;
        q qVar = this.f65352d;
        if (qVar == null) {
            k.a();
        }
        a2.a(i2, (Fragment) qVar);
        a2.b();
        View.OnClickListener onClickListener = this;
        ((TextView) a(R.id.resend_otp_tv)).setOnClickListener(onClickListener);
        ((Button) a(R.id.otp_done_btn)).setOnClickListener(onClickListener);
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.verify_otp_minor_kyc;
    }

    public final void onClick(View view) {
        Class<KycVerifyOtpParentMobile> cls;
        String str;
        String str2;
        String str3;
        Class<KycVerifyOtpParentMobile> cls2 = KycVerifyOtpParentMobile.class;
        if (view == null || view.getId() != R.id.otp_done_btn) {
            cls = cls2;
            str = "";
        } else {
            q qVar = this.f65352d;
            if (qVar != null) {
                StringBuilder sb = new StringBuilder("");
                EditText editText = (EditText) qVar.b(R.id.edit_otp_char1);
                k.a((Object) editText, "edit_otp_char1");
                cls = cls2;
                str2 = "";
                boolean z = false;
                if (TextUtils.isEmpty(editText.getText())) {
                    TextView textView = (TextView) qVar.b(R.id.error_otp_tv);
                    k.a((Object) textView, "error_otp_tv");
                    textView.setVisibility(0);
                } else {
                    EditText editText2 = (EditText) qVar.b(R.id.edit_otp_char2);
                    k.a((Object) editText2, "edit_otp_char2");
                    if (TextUtils.isEmpty(editText2.getText())) {
                        TextView textView2 = (TextView) qVar.b(R.id.error_otp_tv);
                        k.a((Object) textView2, "error_otp_tv");
                        textView2.setVisibility(0);
                    } else {
                        EditText editText3 = (EditText) qVar.b(R.id.edit_otp_char3);
                        k.a((Object) editText3, "edit_otp_char3");
                        if (TextUtils.isEmpty(editText3.getText())) {
                            TextView textView3 = (TextView) qVar.b(R.id.error_otp_tv);
                            k.a((Object) textView3, "error_otp_tv");
                            textView3.setVisibility(0);
                        } else {
                            EditText editText4 = (EditText) qVar.b(R.id.edit_otp_char4);
                            k.a((Object) editText4, "edit_otp_char4");
                            if (TextUtils.isEmpty(editText4.getText())) {
                                TextView textView4 = (TextView) qVar.b(R.id.error_otp_tv);
                                k.a((Object) textView4, "error_otp_tv");
                                textView4.setVisibility(0);
                            } else {
                                EditText editText5 = (EditText) qVar.b(R.id.edit_otp_char5);
                                k.a((Object) editText5, "edit_otp_char5");
                                if (TextUtils.isEmpty(editText5.getText())) {
                                    TextView textView5 = (TextView) qVar.b(R.id.error_otp_tv);
                                    k.a((Object) textView5, "error_otp_tv");
                                    textView5.setVisibility(0);
                                } else {
                                    EditText editText6 = (EditText) qVar.b(R.id.edit_otp_char6);
                                    k.a((Object) editText6, "edit_otp_char6");
                                    if (TextUtils.isEmpty(editText6.getText())) {
                                        TextView textView6 = (TextView) qVar.b(R.id.error_otp_tv);
                                        k.a((Object) textView6, "error_otp_tv");
                                        textView6.setVisibility(0);
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    EditText editText7 = (EditText) qVar.b(R.id.edit_otp_char1);
                    k.a((Object) editText7, "edit_otp_char1");
                    sb.append(editText7.getText().toString());
                    EditText editText8 = (EditText) qVar.b(R.id.edit_otp_char2);
                    k.a((Object) editText8, "edit_otp_char2");
                    sb.append(editText8.getText().toString());
                    EditText editText9 = (EditText) qVar.b(R.id.edit_otp_char3);
                    k.a((Object) editText9, "edit_otp_char3");
                    sb.append(editText9.getText().toString());
                    EditText editText10 = (EditText) qVar.b(R.id.edit_otp_char4);
                    k.a((Object) editText10, "edit_otp_char4");
                    sb.append(editText10.getText().toString());
                    EditText editText11 = (EditText) qVar.b(R.id.edit_otp_char5);
                    k.a((Object) editText11, "edit_otp_char5");
                    sb.append(editText11.getText().toString());
                    EditText editText12 = (EditText) qVar.b(R.id.edit_otp_char6);
                    k.a((Object) editText12, "edit_otp_char6");
                    sb.append(editText12.getText().toString());
                }
                str3 = sb.toString();
            } else {
                cls = cls2;
                str2 = "";
                str3 = null;
            }
            CharSequence charSequence = str3;
            if (!TextUtils.isEmpty(charSequence)) {
                d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("minorKycValidateOtp") : null;
                if (URLUtil.isValidUrl(a2)) {
                    Context context = this;
                    String e2 = com.paytm.utility.b.e(context, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.d.a(context));
                    String str4 = this.f65351b;
                    if (str4 != null) {
                        if (str4 == null) {
                            k.a();
                        }
                        hashMap.put("reference_number", str4);
                    }
                    hashMap.put("action", "MINOR_KYC");
                    if (!TextUtils.isEmpty(charSequence)) {
                        Map map = hashMap;
                        if (str3 == null) {
                            k.a();
                        }
                        map.put("otp", str3);
                    }
                    if (!TextUtils.isEmpty(this.f65350a)) {
                        String str5 = this.f65350a;
                        if (str5 == null) {
                            k.a();
                        }
                        hashMap.put("mobileNo", str5);
                    }
                    a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    str = str2;
                    com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new ValidateOtpMinorKycModel((String) null, (String) null, (SendOtpErrorModel) null, (String) null, 15, (g) null)).b(str).c(cls.getName()).a(e2).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c(this)).l();
                    if (com.paytm.utility.b.c(context)) {
                        com.paytm.utility.b.k(context, getString(R.string.please_wait));
                        l.a();
                    } else {
                        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        k.a((Object) l, "ntwrkCall");
                        a.C1317a.a(context, l);
                    }
                } else {
                    str = str2;
                    com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
                }
            } else {
                str = str2;
            }
        }
        if (view != null && view.getId() == R.id.resend_otp_tv) {
            d.a aVar4 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            String a3 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("minorKycSendOtp") : null;
            if (URLUtil.isValidUrl(a3)) {
                Context context2 = this;
                String e3 = com.paytm.utility.b.e(context2, a3);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("session_token", com.paytm.utility.d.a(context2));
                String str6 = this.f65351b;
                if (str6 != null) {
                    if (str6 == null) {
                        k.a();
                    }
                    hashMap2.put("reference_number", str6);
                }
                hashMap2.put("action", "MINOR_KYC");
                if (!TextUtils.isEmpty(this.f65350a)) {
                    String str7 = this.f65350a;
                    if (str7 == null) {
                        k.a();
                    }
                    hashMap2.put("mobileNo", str7);
                }
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l2 = a.C1317a.a().a(context2).a(a.C0715a.POST).a((Map<String, String>) hashMap2).a((IJRPaytmDataModel) new SendOtpMinorKycModel((String) null, (String) null, (SendOtpErrorModel) null, (String) null, 15, (g) null)).b(str).c(cls.getName()).a(e3).a(a.b.SILENT).a((com.paytm.network.listener.b) new b(this)).l();
                if (com.paytm.utility.b.c(context2)) {
                    com.paytm.utility.b.k(context2, getString(R.string.please_wait));
                    l2.a();
                    return;
                }
                a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                k.a((Object) l2, "ntwrkCall");
                a.C1317a.a(context2, l2);
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerifyOtpParentMobile f65356a;

        b(KycVerifyOtpParentMobile kycVerifyOtpParentMobile) {
            this.f65356a = kycVerifyOtpParentMobile;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError != null) {
                l.a();
                l.a((Context) this.f65356a, networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            KycVerifyOtpParentMobile.a(this.f65356a, iJRPaytmDataModel);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerifyOtpParentMobile f65355a;

        a(KycVerifyOtpParentMobile kycVerifyOtpParentMobile) {
            this.f65355a = kycVerifyOtpParentMobile;
        }

        public final void run() {
            KycVerifyOtpParentMobile.a(this.f65355a);
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerifyOtpParentMobile f65357a;

        c(KycVerifyOtpParentMobile kycVerifyOtpParentMobile) {
            this.f65357a = kycVerifyOtpParentMobile;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            KycVerifyOtpParentMobile.a(this.f65357a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError != null) {
                l.a();
                l.a((Context) this.f65357a, networkCustomError);
            }
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerifyOtpParentMobile f65358a;

        d(KycVerifyOtpParentMobile kycVerifyOtpParentMobile) {
            this.f65358a = kycVerifyOtpParentMobile;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            KycVerifyOtpParentMobile.a(this.f65358a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "p2");
            l.a();
            l.a((Context) this.f65358a, networkCustomError);
        }
    }

    public static final /* synthetic */ void a(KycVerifyOtpParentMobile kycVerifyOtpParentMobile, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        com.paytm.utility.b.p();
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof SendOtpMinorKycModel)) {
            SendOtpMinorKycModel sendOtpMinorKycModel = (SendOtpMinorKycModel) iJRPaytmDataModel;
            if (TextUtils.isEmpty(sendOtpMinorKycModel.getStatusCode()) || !p.a(sendOtpMinorKycModel.getStatusCode(), WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                if (sendOtpMinorKycModel.getError() != null && !TextUtils.isEmpty(sendOtpMinorKycModel.getError().getErrorCode()) && !TextUtils.isEmpty(sendOtpMinorKycModel.getError().getErrorMsg())) {
                    com.paytm.utility.b.b((Context) kycVerifyOtpParentMobile, kycVerifyOtpParentMobile.getString(R.string.error), sendOtpMinorKycModel.getError().getErrorMsg());
                }
            } else if (!TextUtils.isEmpty(sendOtpMinorKycModel.getRefNumber())) {
                kycVerifyOtpParentMobile.f65351b = sendOtpMinorKycModel.getRefNumber();
                TextView textView = (TextView) kycVerifyOtpParentMobile.a(R.id.resend_otp_tv);
                k.a((Object) textView, "resend_otp_tv");
                textView.setEnabled(false);
                TextView textView2 = (TextView) kycVerifyOtpParentMobile.a(R.id.resend_otp_tv);
                k.a((Object) textView2, "resend_otp_tv");
                textView2.setText(kycVerifyOtpParentMobile.getString(R.string.otp_sent));
                new Handler().postDelayed(new a(kycVerifyOtpParentMobile), 5000);
            }
        } else if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof ValidateOtpMinorKycModel)) {
            ValidateOtpMinorKycModel validateOtpMinorKycModel = (ValidateOtpMinorKycModel) iJRPaytmDataModel;
            if (TextUtils.isEmpty(validateOtpMinorKycModel.getStatusCode()) || !p.a(validateOtpMinorKycModel.getStatusCode(), WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                if (validateOtpMinorKycModel.getError() != null && !TextUtils.isEmpty(validateOtpMinorKycModel.getError().getErrorCode()) && !TextUtils.isEmpty(validateOtpMinorKycModel.getError().getErrorMsg())) {
                    com.paytm.utility.b.b((Context) kycVerifyOtpParentMobile, kycVerifyOtpParentMobile.getString(R.string.error), validateOtpMinorKycModel.getError().getErrorMsg());
                }
            } else if (!TextUtils.isEmpty(validateOtpMinorKycModel.getRefNumber())) {
                kycVerifyOtpParentMobile.f65351b = validateOtpMinorKycModel.getRefNumber();
                String str2 = null;
                d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                    if (d.a.a() == null) {
                        k.a();
                    }
                    str2 = net.one97.paytm.upgradeKyc.helper.d.a("saveEkycRefNumber");
                }
                if (!URLUtil.isValidUrl(str2)) {
                    com.paytm.utility.b.b((Context) kycVerifyOtpParentMobile, kycVerifyOtpParentMobile.getResources().getString(R.string.error), kycVerifyOtpParentMobile.getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                Context context = kycVerifyOtpParentMobile;
                String e2 = com.paytm.utility.b.e(context, str2);
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(context);
                k.a((Object) a2, "CJRNetUtility.getSSOToken(this)");
                hashMap.put("session_token", a2);
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(kycVerifyOtpParentMobile.f65351b)) {
                        jSONObject.put("uuid", kycVerifyOtpParentMobile.f65351b);
                    }
                    str = jSONObject.toString();
                    k.a((Object) str, "reqJsonObject.toString()");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    str = "";
                }
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(context).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new EkycDataResponse()).b(str).c(KycVerifyOtpParentMobile.class.getName()).a(a.b.USER_FACING).a(e2).a((com.paytm.network.listener.b) new d(kycVerifyOtpParentMobile)).l();
                if (com.paytm.utility.b.c(context)) {
                    com.paytm.utility.b.k(context, kycVerifyOtpParentMobile.getString(R.string.please_wait));
                    l.a();
                    return;
                }
                a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                k.a((Object) l, "ntwrkCall");
                a.C1317a.a(context, l);
            }
        } else if (iJRPaytmDataModel instanceof EkycDataResponse) {
            com.paytm.utility.b.p();
            EkycDataResponse ekycDataResponse = (EkycDataResponse) iJRPaytmDataModel;
            if (ekycDataResponse.getStatusCode() == 200) {
                return;
            }
            if (!TextUtils.isEmpty(ekycDataResponse.getMessage())) {
                com.paytm.utility.b.b((Context) kycVerifyOtpParentMobile, kycVerifyOtpParentMobile.getResources().getString(R.string.error), ekycDataResponse.getMessage());
            } else {
                com.paytm.utility.b.b((Context) kycVerifyOtpParentMobile, kycVerifyOtpParentMobile.getResources().getString(R.string.error), kycVerifyOtpParentMobile.getString(R.string.msg_invalid_url));
            }
        }
    }

    public static final /* synthetic */ void a(KycVerifyOtpParentMobile kycVerifyOtpParentMobile) {
        TextView textView = (TextView) kycVerifyOtpParentMobile.a(R.id.resend_otp_tv);
        k.a((Object) textView, "resend_otp_tv");
        textView.setEnabled(true);
        ((TextView) kycVerifyOtpParentMobile.a(R.id.resend_otp_tv)).setText(R.string.kyc_resend_otp);
    }
}
