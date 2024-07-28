package net.one97.paytm.upgradeKyc.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.paytm.utility.s;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharGenOTP;
import net.one97.paytm.common.entity.upgradeKyc.KycCheckDoc;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.KycSmsReceiver;
import net.one97.paytm.upgradeKyc.utils.g;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class AadhaarOtpActivity extends UpgradeKycBaseActivity implements View.OnClickListener, KycSmsReceiver.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextInputLayout f65225a;

    /* renamed from: b  reason: collision with root package name */
    private Button f65226b;

    /* renamed from: d  reason: collision with root package name */
    private String f65227d;

    /* renamed from: e  reason: collision with root package name */
    private String f65228e;

    /* renamed from: f  reason: collision with root package name */
    private KycSmsReceiver f65229f;

    /* renamed from: g  reason: collision with root package name */
    private String f65230g = "";

    /* renamed from: h  reason: collision with root package name */
    private boolean f65231h = false;

    /* renamed from: i  reason: collision with root package name */
    private KycAadharEkycDetails.KycResponse f65232i = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a aVar = e.f66028b;
        e.a.b().a("/kyc-wallet-upgrade/aadhaar-otp", "kyc", (Context) this);
        setTitle("");
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
        this.f65225a = (TextInputLayout) findViewById(R.id.activity_aadhaar_otp_enter_text_layout);
        TextView textView = (TextView) findViewById(R.id.ekyc_subheading_tv);
        ((TextView) findViewById(R.id.activity_aadhaar_otp_request)).setOnClickListener(this);
        this.f65226b = (Button) findViewById(R.id.activity_aadhaar_otp_btn_verify);
        findViewById(R.id.activity_upgrade_kyc_using_doc).setOnClickListener(this);
        findViewById(R.id.upgrade_kyc_right_arrow_iv).setOnClickListener(this);
        findViewById(R.id.havent_got_otp).setOnClickListener(this);
        this.f65226b.setOnClickListener(this);
        this.f65227d = getIntent().getStringExtra("reference_number");
        if (getIntent() != null && getIntent().hasExtra("coming_from_screen")) {
            this.f65230g = getIntent().getStringExtra("coming_from_screen");
        }
        TextView textView2 = (TextView) findViewById(R.id.aadhaar_number);
        if (getIntent() != null) {
            if (getIntent().getExtras() == null || !getIntent().hasExtra("number")) {
                textView2.setVisibility(8);
                textView.setText(getString(R.string.aadhaar_otp_subheading));
            } else {
                textView2.setVisibility(0);
                this.f65228e = getIntent().getStringExtra("number").replaceAll("-", "");
                if (this.f65228e.length() <= 14) {
                    textView2.setText(getString(R.string.aadhaar_text_with_number, new Object[]{this.f65228e}));
                } else {
                    textView2.setText(getString(R.string.vid_text_with_number, new Object[]{this.f65228e}));
                }
            }
            if (getIntent().getExtras() != null && getIntent().hasExtra("delinkingRequiredDedup")) {
                this.f65231h = getIntent().getBooleanExtra("delinkingRequiredDedup", false);
            }
        }
        this.f65225a.getEditText().addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AadhaarOtpActivity.this.f65225a.setErrorEnabled(false);
                AadhaarOtpActivity.this.f65225a.setError("");
            }
        });
    }

    public void onPause() {
        super.onPause();
        b.p();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kyc_landing_menu, menu);
        return true;
    }

    public void onClick(View view) {
        Class<AadhaarOtpActivity> cls = AadhaarOtpActivity.class;
        this.f65225a.setErrorEnabled(false);
        String str = "";
        this.f65225a.setError(str);
        String str2 = null;
        if (view.getId() == R.id.activity_aadhaar_otp_btn_verify) {
            HashMap hashMap = new HashMap();
            hashMap.put("kyc_aadhaar_otp_user_id", b.n((Context) this));
            e.a aVar = e.f66028b;
            e.a.b().a("kyc_aadhaar_otp_verify_otp_clicked", (HashMap<String, Object>) hashMap, (Context) this);
            if (TextUtils.isEmpty(this.f65225a.getEditText().getText())) {
                this.f65225a.setErrorEnabled(true);
                this.f65225a.setError(getString(R.string.error_enter_otp));
            } else if (getIntent().getExtras() != null && !TextUtils.isEmpty(this.f65227d)) {
                if (b.c((Context) this)) {
                    this.f65226b.setEnabled(false);
                }
                String str3 = this.f65227d;
                String obj = this.f65225a.getEditText().getText().toString();
                if (Build.VERSION.SDK_INT < 21) {
                    d();
                    return;
                }
                d.a aVar2 = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar3 = d.f66026a;
                    d.a.a();
                    d.a("ekyc_otp_verify_v3");
                }
                if (!URLUtil.isValidUrl((String) null)) {
                    b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                String str4 = b.e((Context) this, (String) null) + "&minorFlowAvailable=true";
                HashMap hashMap2 = new HashMap();
                hashMap2.put("session_token", a.q(this));
                String e2 = b.e();
                String f2 = b.f();
                KycAadharEkycDetails kycAadharEkycDetails = new KycAadharEkycDetails();
                kycAadharEkycDetails.setIv(f2);
                kycAadharEkycDetails.setKey(e2);
                JSONObject jSONObject = new JSONObject();
                try {
                    e.a aVar4 = e.f66028b;
                    hashMap2.put("x-keyiv", f.a(e.a.b().c(), e2 + ':' + f2));
                    net.one97.paytm.upgradeKyc.utils.a aVar5 = new net.one97.paytm.upgradeKyc.utils.a(getAssets().open("uidai_auth.cer"));
                    byte[] a2 = net.one97.paytm.upgradeKyc.utils.a.a();
                    String a3 = aVar5.a(a2);
                    Class<AadhaarOtpActivity> cls2 = cls;
                    String str5 = str4;
                    String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                    String str6 = "<Pid ts=\"" + format + "\" ver=\"2.0\" wadh=\"pc0K1hVqt6oaWRjtxuFDfkB7aCL356jpGa28E1WIZ/4=\"><Pv otp=\"" + obj + "\" /></Pid>";
                    new g();
                    String a4 = net.one97.paytm.upgradeKyc.utils.a.a(a2, g.a(str6.getBytes()), format, false);
                    String a5 = net.one97.paytm.upgradeKyc.utils.a.a(a2, str6.getBytes(), format, true);
                    getSystemService(ContactColumn.PHONE_NUMBER);
                    jSONObject.put("userId", b.n((Context) this));
                    jSONObject.put("referenceNumber", str3);
                    jSONObject.put("encHMac", a4);
                    jSONObject.put("encryptedPid", a5);
                    jSONObject.put("certificateExpiry", aVar5.b());
                    jSONObject.put("sessionKey", a3);
                    jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, "201301");
                    jSONObject.put("timeStamp", format);
                    jSONObject.put("channel", "mobile");
                    if (!TextUtils.isEmpty(b.d((Context) this))) {
                        jSONObject.put("deviceCode", b.d((Context) this));
                    } else {
                        jSONObject.put("deviceCode", "0-0");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(b.s((Context) this))) {
                        jSONObject2.put("latitude", b.s((Context) this));
                    } else {
                        jSONObject2.put("latitude", "0.0");
                    }
                    if (!TextUtils.isEmpty(b.t((Context) this))) {
                        jSONObject2.put("longitude", b.t((Context) this));
                    } else {
                        jSONObject2.put("longitude", "0.0");
                    }
                    jSONObject.put("location", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject.put("deviceDetails", jSONObject3);
                    jSONObject3.put("rdsId", str);
                    jSONObject3.put("rdsVer", str);
                    jSONObject3.put("dpId", str);
                    jSONObject3.put("dc", str);
                    jSONObject3.put("mi", str);
                    jSONObject3.put("mc", str);
                    String a6 = f.a(f2, e2, jSONObject.toString());
                    a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a7 = a.C1317a.a();
                    a7.f42877a = this;
                    a7.f42879c = a.C0715a.POST;
                    a7.f42882f = hashMap2;
                    a7.f42885i = kycAadharEkycDetails;
                    a7.f42884h = a6;
                    a7.f42880d = str5;
                    a7.o = cls2.getName();
                    a7.n = a.b.USER_FACING;
                    a7.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            AadhaarOtpActivity.a(AadhaarOtpActivity.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            l.a();
                            if (!l.a((Context) AadhaarOtpActivity.this, networkCustomError)) {
                                a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                                a.C1317a.a((Context) AadhaarOtpActivity.this, networkCustomError);
                            }
                        }
                    };
                    com.paytm.network.a l = a7.l();
                    if (b.c((Context) this)) {
                        b.k(this, getString(R.string.please_wait));
                        l.a();
                        return;
                    }
                    a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) this, l);
                } catch (Exception e3) {
                    d();
                    e3.printStackTrace();
                }
            }
        } else {
            Class<AadhaarOtpActivity> cls3 = cls;
            if (view.getId() == R.id.activity_aadhaar_otp_request) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("kyc_aadhaar_otp_user_id", b.n((Context) this));
                e.a aVar8 = e.f66028b;
                e.a.b().a("kyc_aadhaar_otp_request_another_otp_clicked", (HashMap<String, Object>) hashMap3, (Context) this);
                d.a aVar9 = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar10 = d.f66026a;
                    d.a.a();
                    str2 = d.a("ekyc_gen_otp_v3");
                }
                if (!URLUtil.isValidUrl(str2)) {
                    b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                String e4 = b.e((Context) this, str2);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("session_token", com.paytm.utility.a.q(this));
                String e5 = b.e();
                String f3 = b.f();
                try {
                    e.a aVar11 = e.f66028b;
                    hashMap4.put("x-keyiv", f.a(e.a.b().c(), e5 + ':' + f3));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                KycAadharGenOTP kycAadharGenOTP = new KycAadharGenOTP();
                kycAadharGenOTP.setIv(f3);
                kycAadharGenOTP.setKey(e5);
                if (this.f65231h) {
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(this.f65228e)) {
                            jSONObject4.put("aadhar", this.f65228e);
                        }
                        str = f.a(f3, e5, jSONObject4.toString());
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                a.C1317a aVar12 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.b a8 = a.C1317a.a();
                a8.f42877a = this;
                a8.f42879c = a.C0715a.POST;
                a8.f42882f = hashMap4;
                a8.f42885i = new KycCheckDoc();
                a8.f42884h = str;
                a8.f42880d = e4;
                a8.o = cls3.getName();
                a8.n = a.b.USER_FACING;
                a8.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AadhaarOtpActivity.a(AadhaarOtpActivity.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        l.a((Context) AadhaarOtpActivity.this, networkCustomError);
                    }
                };
                com.paytm.network.a l2 = a8.l();
                if (b.c((Context) this)) {
                    b.k(this, getString(R.string.please_wait));
                    l2.a();
                    return;
                }
                a.C1317a aVar13 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) this, l2);
            } else if (view.getId() == R.id.activity_upgrade_kyc_using_doc || view.getId() == R.id.upgrade_kyc_right_arrow_iv || view.getId() == R.id.havent_got_otp) {
                HashMap hashMap5 = new HashMap();
                hashMap5.put("kyc_aadhaar_otp_user_id", b.n((Context) this));
                e.a aVar14 = e.f66028b;
                e.a.b().a("kyc_aadhaar_otp_other_kyc_options_clicked", (HashMap<String, Object>) hashMap5, (Context) this);
                if (this.f65230g.equalsIgnoreCase(net.one97.paytm.upgradeKyc.d.l.class.getName())) {
                    startActivity(new Intent(this, UpgradeKycActivity.class));
                } else {
                    d();
                }
                finish();
            }
        }
    }

    private void d() {
        Intent intent = new Intent(this, InPersonVerification.class);
        intent.putExtra("doc_type", "Aadhaar Card");
        intent.putExtra("doc_number", getIntent().getStringExtra("aadhaarNum"));
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(h hVar, View view) {
        hVar.dismiss();
        d();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(h hVar, View view) {
        hVar.dismiss();
        d();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.dismiss();
        e.a aVar = e.f66028b;
        Intent intent = new Intent(this, e.a.b().b().getClass());
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onStop() {
        e();
        super.onStop();
    }

    public final void a(String str, String str2) {
        String f2;
        if (!isFinishing() && (f2 = b.f(str, str2)) != null) {
            this.f65225a.getEditText().setText(f2);
            e();
        }
    }

    private void e() {
        try {
            if (this.f65229f != null) {
                unregisterReceiver(this.f65229f);
                this.f65229f.f66314a = null;
                this.f65229f = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                b.j();
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s", new Object[]{"1000007", "1600039"});
        e.a aVar = e.f66028b;
        e.a.b().a((Context) this, format);
        dialogInterface.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        finish();
    }

    private void f() {
        String str;
        String str2;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("saveEkycRefNumber");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = b.e((Context) this, str);
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(this));
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f65227d)) {
                jSONObject.put("uuid", this.f65227d);
            }
            str2 = jSONObject.toString();
        } catch (JSONException e3) {
            e3.printStackTrace();
            str2 = "";
        }
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = this;
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = new EkycDataResponse();
        a2.f42884h = str2;
        a2.o = AadhaarOtpActivity.class.getName();
        a2.n = a.b.USER_FACING;
        a2.f42880d = e2;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                AadhaarOtpActivity.a(AadhaarOtpActivity.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                l.a((Context) AadhaarOtpActivity.this, networkCustomError);
            }
        };
        com.paytm.network.a l = a2.l();
        if (b.c((Context) this)) {
            l.a();
            return;
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this, l);
    }

    public final int a() {
        return R.layout.activity_aadhaar_otp;
    }

    public final int b() {
        return R.layout.kyc_base_layout;
    }

    public void onStart() {
        try {
            if (!isFinishing()) {
                if (!s.a() || s.d((Context) this)) {
                    if (this.f65229f == null) {
                        this.f65229f = new KycSmsReceiver();
                        this.f65229f.f66314a = this;
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                        intentFilter.setPriority(1000);
                        registerReceiver(this.f65229f, intentFilter);
                        StringBuilder sb = new StringBuilder();
                        sb.append(getClass().getSimpleName());
                        sb.append(" : register");
                        b.j();
                    }
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
        super.onStart();
    }

    static /* synthetic */ void a(AadhaarOtpActivity aadhaarOtpActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof KycAadharEkycDetails) {
            aadhaarOtpActivity.f65226b.setEnabled(true);
            KycAadharEkycDetails kycAadharEkycDetails = (KycAadharEkycDetails) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(kycAadharEkycDetails.getIsMinor())) {
                j.e(aadhaarOtpActivity.getApplicationContext(), kycAadharEkycDetails.getIsMinor());
            }
            if (kycAadharEkycDetails.getStatusCode() == null || kycAadharEkycDetails.getStatusMessage() == null) {
                if (kycAadharEkycDetails.getErrorErrorCode() != null && kycAadharEkycDetails.getErrorErrorCode().equalsIgnoreCase("900001") && !TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage())) {
                    b.p();
                    h hVar = new h(aadhaarOtpActivity);
                    hVar.a();
                    hVar.a(kycAadharEkycDetails.getErrorErrorMessage());
                    hVar.a(-2, aadhaarOtpActivity.getString(R.string.msg_see_other_options), new View.OnClickListener(hVar) {
                        private final /* synthetic */ h f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            AadhaarOtpActivity.this.d(this.f$1, view);
                        }
                    });
                    hVar.a(-1, aadhaarOtpActivity.getString(R.string.kyc_try_again), new View.OnClickListener() {
                        public final void onClick(View view) {
                            h.this.dismiss();
                        }
                    });
                    hVar.show();
                } else if (kycAadharEkycDetails.getErrorErrorCode() != null && ((kycAadharEkycDetails.getErrorErrorCode().equalsIgnoreCase("203") || kycAadharEkycDetails.getErrorErrorCode().equalsIgnoreCase("201")) && !TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage()))) {
                    b.p();
                    h hVar2 = new h(aadhaarOtpActivity);
                    hVar2.a();
                    hVar2.a(kycAadharEkycDetails.getErrorErrorMessage());
                    hVar2.a(-3, aadhaarOtpActivity.getString(R.string.msg_see_other_options), new View.OnClickListener(hVar2) {
                        private final /* synthetic */ h f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            AadhaarOtpActivity.this.b(this.f$1, view);
                        }
                    });
                    hVar2.show();
                } else if (kycAadharEkycDetails.getErrorErrorCode() == null || ((!kycAadharEkycDetails.getErrorErrorCode().equalsIgnoreCase("9761") && !kycAadharEkycDetails.getErrorErrorCode().equalsIgnoreCase("9762")) || TextUtils.isEmpty(kycAadharEkycDetails.getErrorErrorMessage()))) {
                    aadhaarOtpActivity.d();
                } else {
                    b.p();
                    h hVar3 = new h(aadhaarOtpActivity);
                    hVar3.a();
                    hVar3.a(kycAadharEkycDetails.getErrorErrorMessage());
                    hVar3.a(-3, aadhaarOtpActivity.getString(R.string.ok), new View.OnClickListener(hVar3) {
                        private final /* synthetic */ h f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            AadhaarOtpActivity.this.a(this.f$1, view);
                        }
                    });
                    hVar3.show();
                }
            } else if (kycAadharEkycDetails.getStatusCode().equals(WebLogin.RESPONSE_CODE_SUCCESS) && kycAadharEkycDetails.getStatusMessage().equalsIgnoreCase("success") && kycAadharEkycDetails.getKycResponse() != null) {
                aadhaarOtpActivity.f65232i = kycAadharEkycDetails.getKycResponse();
                String str = null;
                d.a aVar = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar2 = d.f66026a;
                    d.a.a();
                    str = d.a("kyc_checkdoc_url");
                }
                if (!URLUtil.isValidUrl(str)) {
                    b.b((Context) aadhaarOtpActivity, aadhaarOtpActivity.getResources().getString(R.string.error), aadhaarOtpActivity.getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                String e2 = b.e((Context) aadhaarOtpActivity, str);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", com.paytm.utility.a.q(aadhaarOtpActivity));
                hashMap.put("reference_number", aadhaarOtpActivity.f65227d);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("docCode", "aadhar");
                    if (!TextUtils.isEmpty(aadhaarOtpActivity.f65228e)) {
                        jSONObject.put("docId", aadhaarOtpActivity.f65228e);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.b a2 = a.C1317a.a();
                a2.f42877a = aadhaarOtpActivity;
                a2.f42879c = a.C0715a.POST;
                a2.f42882f = hashMap;
                a2.f42885i = new KycCheckDoc();
                a2.f42884h = jSONObject2;
                a2.f42880d = e2;
                a2.o = AadhaarOtpActivity.class.getName();
                a2.n = a.b.USER_FACING;
                a2.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AadhaarOtpActivity.a(AadhaarOtpActivity.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        l.a((Context) AadhaarOtpActivity.this, networkCustomError);
                    }
                };
                com.paytm.network.a l = a2.l();
                if (b.c((Context) aadhaarOtpActivity)) {
                    l.a();
                    return;
                }
                a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) aadhaarOtpActivity, l);
            }
        } else if (iJRPaytmDataModel instanceof EkycDataResponse) {
            EkycDataResponse ekycDataResponse = (EkycDataResponse) iJRPaytmDataModel;
            if (ekycDataResponse.getStatusCode() == 200) {
                b.p();
            } else if (!TextUtils.isEmpty(ekycDataResponse.getMessage())) {
                b.p();
                b.b((Context) aadhaarOtpActivity, aadhaarOtpActivity.getResources().getString(R.string.error), ekycDataResponse.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof KycCheckDoc) {
            KycCheckDoc kycCheckDoc = (KycCheckDoc) iJRPaytmDataModel;
            if (kycCheckDoc == null) {
                return;
            }
            if (kycCheckDoc.getStatus().equalsIgnoreCase("success")) {
                if (kycCheckDoc.getData() != null && !TextUtils.isEmpty(kycCheckDoc.getData().getVerifyOtp())) {
                    if (kycCheckDoc.getData().getVerifyOtp().equalsIgnoreCase("1")) {
                        b.p();
                        Intent intent = new Intent(aadhaarOtpActivity, KycAadhaarAlreadyLinked.class);
                        if (!TextUtils.isEmpty(aadhaarOtpActivity.f65227d)) {
                            intent.putExtra("reference_number", aadhaarOtpActivity.f65227d);
                        }
                        if (!TextUtils.isEmpty(kycCheckDoc.getData().getMobile())) {
                            intent.putExtra("previouslyLinkedNum", kycCheckDoc.getData().getMobile());
                        }
                        if (!TextUtils.isEmpty(aadhaarOtpActivity.f65228e)) {
                            intent.putExtra("aadhaar", aadhaarOtpActivity.f65228e);
                        }
                        KycAadharEkycDetails.KycResponse kycResponse = aadhaarOtpActivity.f65232i;
                        if (kycResponse != null) {
                            intent.putExtra("aadhaarData", kycResponse);
                        }
                        aadhaarOtpActivity.startActivity(intent);
                        aadhaarOtpActivity.finish();
                    } else if (kycCheckDoc.getData().getVerifyOtp().equalsIgnoreCase("0") && !TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                        b.p();
                        AlertDialog.Builder builder = new AlertDialog.Builder(aadhaarOtpActivity);
                        builder.setMessage(kycCheckDoc.getMessage());
                        builder.setCancelable(false);
                        builder.setNegativeButton(aadhaarOtpActivity.getString(R.string.kyc_report_issue), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AadhaarOtpActivity.this.b(dialogInterface, i2);
                            }
                        });
                        builder.setPositiveButton(aadhaarOtpActivity.getString(R.string.ok), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AadhaarOtpActivity.this.a(dialogInterface, i2);
                            }
                        });
                        builder.show();
                    }
                }
            } else if (kycCheckDoc.getStatus().equalsIgnoreCase("error") && kycCheckDoc.getResponseCode().equalsIgnoreCase("4024")) {
                String h2 = j.h(aadhaarOtpActivity.getApplicationContext());
                if (TextUtils.isEmpty(h2) || !h2.equalsIgnoreCase("true")) {
                    aadhaarOtpActivity.f();
                    return;
                }
                b.p();
                Intent intent2 = new Intent(aadhaarOtpActivity, KycParentConsentRequired.class);
                KycAadharEkycDetails.KycResponse kycResponse2 = aadhaarOtpActivity.f65232i;
                if (kycResponse2 != null) {
                    intent2.putExtra("aadhaarData", kycResponse2);
                }
                intent2.putExtra("reference_number", aadhaarOtpActivity.f65227d);
                aadhaarOtpActivity.startActivity(intent2);
                aadhaarOtpActivity.finish();
            } else if (kycCheckDoc.getStatus().equalsIgnoreCase("error")) {
                b.p();
                if (!TextUtils.isEmpty(kycCheckDoc.getMessage())) {
                    b.b((Context) aadhaarOtpActivity, aadhaarOtpActivity.getString(R.string.error), kycCheckDoc.getMessage());
                } else {
                    b.b((Context) aadhaarOtpActivity, aadhaarOtpActivity.getString(R.string.error), aadhaarOtpActivity.getString(R.string.msg_invalid_url));
                }
            } else {
                aadhaarOtpActivity.f();
            }
        } else if (iJRPaytmDataModel instanceof KycAadharGenOTP) {
            KycAadharGenOTP kycAadharGenOTP = (KycAadharGenOTP) iJRPaytmDataModel;
            if (kycAadharGenOTP.getStatusMessage() == null || kycAadharGenOTP.getStatusCode() == null) {
                b.p();
                if (kycAadharGenOTP.getSubErrorMessage() != null) {
                    aadhaarOtpActivity.f65225a.setErrorEnabled(true);
                    aadhaarOtpActivity.f65225a.setError(kycAadharGenOTP.getSubErrorMessage());
                } else if (kycAadharGenOTP.getErrorErrorMessage() != null) {
                    aadhaarOtpActivity.f65225a.setErrorEnabled(true);
                    aadhaarOtpActivity.f65225a.setError(kycAadharGenOTP.getErrorErrorMessage());
                } else if (kycAadharGenOTP.getErrorMessage() != null) {
                    aadhaarOtpActivity.f65225a.setErrorEnabled(true);
                    aadhaarOtpActivity.f65225a.setError(kycAadharGenOTP.getErrorMessage());
                }
            } else if (kycAadharGenOTP.getStatusMessage().equalsIgnoreCase("success") && kycAadharGenOTP.getStatusCode().equals("00") && !TextUtils.isEmpty(kycAadharGenOTP.getReferenceNumber())) {
                aadhaarOtpActivity.f65227d = kycAadharGenOTP.getReferenceNumber();
                b.p();
                b.b((Context) aadhaarOtpActivity, aadhaarOtpActivity.getString(R.string.kyc_success), aadhaarOtpActivity.getString(R.string.otp_sent_aadhaar));
            }
        }
    }
}
