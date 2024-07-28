package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.g;
import com.paytm.utility.h;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.minkycotp.KycVerifyOtpActivity;
import net.one97.paytm.upgradeKyc.utils.c;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.utils.m;

public class MinKycPanAadharUpgradeActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f65372a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f65373b;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f65374d;

    /* renamed from: e  reason: collision with root package name */
    private RadioGroup f65375e;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f65376f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f65377g;

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f65378h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f65379i;
    private RadioButton j;
    private TextInputEditText k;
    private TextInputEditText l;
    /* access modifiers changed from: private */
    public TextInputLayout m;
    /* access modifiers changed from: private */
    public TextInputLayout n;
    private CheckBox o;
    private ImageView p;
    private Button q;
    private ScrollView r;
    private LinearLayout s;
    private RoboTextView t;
    private boolean u = false;
    private String v;
    private View.OnClickListener w = new View.OnClickListener() {
        public final void onClick(View view) {
            MinKycPanAadharUpgradeActivity.this.e(view);
        }
    };

    public final int b() {
        return -1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put(d.cv, d.ea);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.ej);
        hashMap.put("event_category", d.eg);
        hashMap.put("event_action", "kyc_do_it_later_clicked");
        e.a aVar = e.f66028b;
        e.a.b().a(GAUtil.CUSTOM_EVENT, (HashMap<String, Object>) hashMap, view.getContext());
        finish();
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        boolean z;
        boolean z2;
        Bundle extras2;
        super.onCreate(bundle);
        e.a aVar = e.f66028b;
        e.a.b().a("/min-kyc/popup/aadhaar-pan", "wallet", (Context) this);
        this.s = (LinearLayout) findViewById(R.id.min_kyc_heade_ll);
        this.f65372a = (TextView) findViewById(R.id.min_kyc_imp_tv);
        this.f65373b = (TextView) findViewById(R.id.min_kyc_imp_desc_tv);
        this.f65374d = (ImageView) findViewById(R.id.min_kyc_cross_iv);
        this.f65375e = (RadioGroup) findViewById(R.id.min_kyc_pan_aadhar_rg);
        this.f65376f = (RadioButton) findViewById(R.id.min_kyc_pan_rb);
        this.f65377g = (RadioButton) findViewById(R.id.min_kyc_other_doc_rb_passport);
        this.f65378h = (RadioButton) findViewById(R.id.min_kyc_other_doc_voter_id_rb);
        this.f65379i = (RadioButton) findViewById(R.id.min_kyc_other_doc_driving_rb);
        this.j = (RadioButton) findViewById(R.id.min_kyc_other_doc_jobcard_rb);
        this.k = (TextInputEditText) findViewById(R.id.min_kyc_enter_doc_num_et);
        this.l = (TextInputEditText) findViewById(R.id.min_kyc_enter_name_on_doc_et);
        this.n = (TextInputLayout) findViewById(R.id.min_kyc_til_name_on_doc);
        this.m = (TextInputLayout) findViewById(R.id.min_kyc_til_doc_number);
        this.o = (CheckBox) findViewById(R.id.min_kyc_self_agree_cb);
        this.q = (Button) findViewById(R.id.min_kyc_submit_btn);
        this.r = (ScrollView) findViewById(R.id.min_kyc_parent_scroll_container);
        this.r.setVisibility(8);
        this.p = (ImageView) findViewById(R.id.min_kyc_back_iv);
        this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new InputFilter.AllCaps()});
        this.l.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        findViewById(R.id.min_kyc_back_iv).setOnClickListener(this.w);
        this.t = (RoboTextView) findViewById(R.id.min_kyc_later_tv);
        this.t.setOnClickListener(this.w);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.u = getIntent().getBooleanExtra("min_kyc_coming_from_sign_up", false);
        }
        ((RadioGroup) findViewById(R.id.min_kyc_pan_aadhar_rg)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                MinKycPanAadharUpgradeActivity.this.a(radioGroup, i2);
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        if (this.u) {
            this.s.setVisibility(0);
            this.f65374d.setVisibility(8);
            this.p.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            if (getIntent() == null || (extras2 = getIntent().getExtras()) == null) {
                z = false;
                z2 = false;
            } else {
                z2 = extras2.getBoolean("show_pop_up");
                z = extras2.getBoolean("show_do_it_later", false);
            }
            if (!z2) {
                this.s.setVisibility(0);
                this.f65374d.setVisibility(8);
                this.p.setVisibility(0);
                if (z) {
                    d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                        d.a.a();
                        if (net.one97.paytm.upgradeKyc.helper.d.a("min_kyc_signup_later", false)) {
                            this.t.setVisibility(0);
                        }
                    }
                }
                this.t.setVisibility(8);
            } else {
                this.s.setVisibility(8);
                this.f65374d.setVisibility(0);
            }
        }
        if (this.u) {
            this.f65372a.setText(getString(R.string.min_kyc_paytm_acc_created));
            this.f65373b.setText(getString(R.string.min_kyc_desc));
        } else {
            this.f65372a.setText(getString(R.string.kyc_important));
            this.f65373b.setText(getText(R.string.min_kyc_other_doc_heading));
        }
        if (!this.u) {
            if (!(getIntent() == null || (extras = getIntent().getExtras()) == null)) {
                if (!extras.getBoolean("min_kyc_mandate_pop_up")) {
                    this.f65374d.setVisibility(0);
                } else {
                    this.f65374d.setVisibility(8);
                }
            }
            this.f65374d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MinKycPanAadharUpgradeActivity.this.d(view);
                }
            });
        }
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MinKycPanAadharUpgradeActivity.this.c(view);
            }
        });
        AnonymousClass1 r7 = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                MinKycPanAadharUpgradeActivity.this.m.setError("");
                MinKycPanAadharUpgradeActivity.this.n.setError("");
            }
        };
        this.k.addTextChangedListener(r7);
        this.l.addTextChangedListener(r7);
        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getBooleanExtra("kyc_status_api_call", false)) {
                String str = null;
                d.a aVar4 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar5 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                    d.a.a();
                    str = net.one97.paytm.upgradeKyc.helper.d.a("min_kyc_status_v3_url");
                }
                if (!TextUtils.isEmpty(a.q(this)) && URLUtil.isValidUrl(str)) {
                    String e2 = b.e(getApplicationContext(), str);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", a.q(getApplicationContext()));
                    KYCStatusV2 kYCStatusV2 = new KYCStatusV2();
                    a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a2 = a.C1317a.a();
                    a2.f42877a = this;
                    a2.f42879c = a.C0715a.GET;
                    a2.f42882f = hashMap;
                    a2.f42885i = kYCStatusV2;
                    a2.f42880d = e2;
                    a2.o = MinKycPanAadharUpgradeActivity.class.getName();
                    a2.n = a.b.USER_FACING;
                    a2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            MinKycPanAadharUpgradeActivity.a(MinKycPanAadharUpgradeActivity.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            l.a();
                            l.a((Context) MinKycPanAadharUpgradeActivity.this, networkCustomError);
                        }
                    };
                    com.paytm.network.a l2 = a2.l();
                    if (b.c(getApplicationContext())) {
                        b.k(this, getString(R.string.please_wait));
                        l2.a();
                    }
                }
            } else {
                this.r.setVisibility(0);
            }
            String stringExtra = getIntent().getStringExtra("min_kyc_desc");
            if (stringExtra != null) {
                this.f65373b.setText(stringExtra);
            }
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            if (cJRHomePageItem != null) {
                this.v = cJRHomePageItem.getCallBackUrl();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        this.k.setText("");
        this.l.setText("");
        this.k.requestFocus();
        a((View) this.n);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(b.h((Context) this))) {
            sb.append(b.h((Context) this));
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(b.i((Context) this))) {
            sb.append(b.i((Context) this));
        }
        if (!TextUtils.isEmpty(sb)) {
            this.l.setText(sb.toString());
        }
        if (i2 == R.id.min_kyc_pan_rb) {
            e.a aVar = e.f66028b;
            e.a.b().a(this, "wallet_min_kyc_popup", "pan_clicked", new ArrayList(), "", "/min-kyc/popup/aadhaar-pan", "wallet");
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setHint(getString(R.string.kyc_enter_pan));
            this.n.setHint(getString(R.string.kyc_your_name_on_pan));
            this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new InputFilter.AllCaps()});
            this.k.setInputType(4096);
            a((EditText) this.k);
        } else if (i2 == R.id.min_kyc_other_doc_rb_passport) {
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setHint(getString(R.string.kyc_passport_number));
            this.n.setHint(getString(R.string.passport_name));
            this.k.setInputType(4096);
            this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new net.one97.paytm.upgradeKyc.utils.b(), new InputFilter.AllCaps()});
            a((EditText) this.k);
        } else if (i2 == R.id.min_kyc_other_doc_voter_id_rb) {
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setHint(getString(R.string.voter_id_number));
            this.n.setHint(getString(R.string.voter_id_name));
            this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
            this.k.setInputType(4096);
            a((EditText) this.k);
        } else if (i2 == R.id.min_kyc_other_doc_driving_rb) {
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setHint(getString(R.string.driving_license_number));
            this.n.setHint(getString(R.string.driving_license_name));
            this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
            this.k.setInputType(4096);
            a((EditText) this.k);
        } else if (i2 == R.id.min_kyc_other_doc_jobcard_rb) {
            this.n.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setHint(getString(R.string.nrega_number));
            this.n.setHint(getString(R.string.nrega_name));
            this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
            this.k.setInputType(4096);
            a((EditText) this.k);
        }
    }

    private void a(EditText editText) {
        editText.postDelayed(new Runnable(editText) {
            private final /* synthetic */ EditText f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MinKycPanAadharUpgradeActivity.this.c(this.f$1);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        e.a aVar = e.f66028b;
        e.a.b().a(this, "wallet_min_kyc_popup", "close_clicked", new ArrayList(), "", "/min-kyc/popup/aadhaar-pan", "wallet");
        if (!TextUtils.isEmpty(this.v)) {
            try {
                String decode = URLDecoder.decode(this.v, AppConstants.UTF_8);
                e.a aVar2 = e.f66028b;
                e.a.b().a((Context) this, decode);
                b.c((Activity) this);
                finish();
            } catch (Exception unused) {
            }
        } else {
            b.c((Activity) this);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        boolean e2 = e();
        HashMap hashMap = new HashMap();
        hashMap.put(net.one97.paytm.common.utility.d.cv, net.one97.paytm.common.utility.d.ea);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.common.utility.d.ej);
        hashMap.put("event_category", net.one97.paytm.common.utility.d.eg);
        hashMap.put("event_action", "kyc_submit_clicked");
        e.a aVar = e.f66028b;
        e.a.b().a(GAUtil.CUSTOM_EVENT, (HashMap<String, Object>) hashMap, view.getContext());
        if (!e2) {
            return;
        }
        if (m.a(getApplicationContext())) {
            startActivityForResult(new Intent(this, KycVerifyOtpActivity.class), 1111);
        } else {
            d();
        }
    }

    private void b(EditText editText) {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    private void a(View view) {
        view.post(new Runnable(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MinKycPanAadharUpgradeActivity.this.b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        int i2 = getResources().getDisplayMetrics().heightPixels;
        int height = view.getHeight();
        int height2 = ((ViewGroup) view).getChildAt(0).getHeight();
        if (height2 != 0) {
            this.r.smoothScrollBy(0, ((height - (height2 * (i2 / height2))) / 2) * -1);
        }
    }

    private boolean e() {
        if (this.f65375e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select any of the above document.", 0).show();
            return false;
        }
        if (this.f65376f.isChecked()) {
            if (TextUtils.isEmpty(this.k.getText().toString())) {
                b(this.m.getEditText());
                a((View) this.m);
                this.m.setError(getString(R.string.empty_pan_error));
                return false;
            } else if (!b.W(this.k.getText().toString())) {
                b(this.m.getEditText());
                a((View) this.m);
                this.m.setError(getString(R.string.error_valid_pan));
                return false;
            }
        }
        if (this.f65377g.isChecked() && TextUtils.isEmpty(this.k.getText().toString())) {
            b(this.m.getEditText());
            a((View) this.m);
            this.m.setError(getString(R.string.error_passport_number));
            return false;
        } else if (this.f65378h.isChecked() && TextUtils.isEmpty(this.k.getText().toString())) {
            b(this.m.getEditText());
            a((View) this.m);
            this.m.setError(getString(R.string.error_voterid));
            return false;
        } else if (this.f65379i.isChecked() && TextUtils.isEmpty(this.k.getText().toString())) {
            b(this.m.getEditText());
            a((View) this.m);
            this.m.setError(getString(R.string.error_drivingid));
            return false;
        } else if (this.j.isChecked() && TextUtils.isEmpty(this.k.getText().toString())) {
            b(this.m.getEditText());
            a((View) this.m);
            this.m.setError(getString(R.string.error_nregaid));
            return false;
        } else if (TextUtils.isEmpty(this.l.getText().toString())) {
            b(this.n.getEditText());
            a((View) this.n);
            this.n.setError(getString(R.string.kyc_enter_name_error));
            return false;
        } else if (this.o.isChecked()) {
            return true;
        } else {
            b.b((Context) this, getString(R.string.alert), getString(R.string.accept_tnc_declaration));
            return false;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 5678 && i3 == -1) {
            finish();
        }
        if (i2 == 1111 && i3 == -1) {
            d();
        }
        super.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.dismiss();
        finish();
    }

    public final int a() {
        return R.layout.activity_min_kyc_pan_aadhar_details_fetch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r19 = this;
            r8 = r19
            java.lang.String r0 = "pan"
            net.one97.paytm.upgradeKyc.helper.d$a r1 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r1 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r1 == 0) goto L_0x0018
            net.one97.paytm.upgradeKyc.helper.d$a r1 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r1 = "kyc_save_profile_info"
            java.lang.String r1 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r1)
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            boolean r2 = android.webkit.URLUtil.isValidUrl(r1)
            if (r2 != 0) goto L_0x0037
            android.content.res.Resources r0 = r19.getResources()
            int r1 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r0 = r0.getString(r1)
            android.content.res.Resources r1 = r19.getResources()
            int r2 = net.one97.paytm.upgradeKyc.R.string.msg_invalid_url
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x0037:
            java.lang.String r9 = com.paytm.utility.b.e((android.content.Context) r8, (java.lang.String) r1)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r1 = com.paytm.utility.a.q(r19)
            java.lang.String r2 = "session_token"
            r10.put(r2, r1)
            java.lang.String r11 = com.paytm.utility.b.e()
            java.lang.String r12 = com.paytm.utility.b.f()
            net.one97.paytm.upgradeKyc.helper.e$a r1 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x0081 }
            net.one97.paytm.upgradeKyc.helper.f r1 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0081 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081 }
            r2.<init>()     // Catch:{ Exception -> 0x0081 }
            r2.append(r11)     // Catch:{ Exception -> 0x0081 }
            r3 = 58
            r2.append(r3)     // Catch:{ Exception -> 0x0081 }
            r2.append(r12)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r1 = net.one97.paytm.common.utility.f.a(r1, r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = "x-keyiv"
            r10.put(r2, r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json; charset=utf-8"
            r10.put(r1, r2)     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            net.one97.paytm.common.entity.CJRAadharPanSave r13 = new net.one97.paytm.common.entity.CJRAadharPanSave
            r13.<init>()
            r13.setIv(r12)
            r13.setKey(r11)
            com.google.android.material.textfield.TextInputEditText r1 = r8.k
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            java.lang.String r2 = "-"
            java.lang.String r3 = ""
            java.lang.String r14 = r1.replaceAll(r2, r3)
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0158 }
            r7.<init>()     // Catch:{ JSONException -> 0x0158 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0158 }
            r6.<init>()     // Catch:{ JSONException -> 0x0158 }
            android.widget.RadioGroup r1 = r8.f65375e     // Catch:{ JSONException -> 0x0158 }
            int r1 = r1.getCheckedRadioButtonId()     // Catch:{ JSONException -> 0x0158 }
            int r2 = net.one97.paytm.upgradeKyc.R.id.min_kyc_other_doc_rb_passport     // Catch:{ JSONException -> 0x0158 }
            java.lang.String r3 = "docCode"
            if (r1 != r2) goto L_0x00c9
            java.lang.String r0 = "passport"
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0158 }
        L_0x00c2:
            r18 = r9
            r16 = r13
            r9 = r6
            r13 = r7
            goto L_0x0131
        L_0x00c9:
            android.widget.RadioGroup r1 = r8.f65375e     // Catch:{ JSONException -> 0x0158 }
            int r1 = r1.getCheckedRadioButtonId()     // Catch:{ JSONException -> 0x0158 }
            int r2 = net.one97.paytm.upgradeKyc.R.id.min_kyc_other_doc_driving_rb     // Catch:{ JSONException -> 0x0158 }
            if (r1 != r2) goto L_0x00d9
            java.lang.String r0 = "dl"
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0158 }
            goto L_0x00c2
        L_0x00d9:
            android.widget.RadioGroup r1 = r8.f65375e     // Catch:{ JSONException -> 0x0158 }
            int r1 = r1.getCheckedRadioButtonId()     // Catch:{ JSONException -> 0x0158 }
            int r2 = net.one97.paytm.upgradeKyc.R.id.min_kyc_other_doc_jobcard_rb     // Catch:{ JSONException -> 0x0158 }
            if (r1 != r2) goto L_0x00e9
            java.lang.String r0 = "nrega_job"
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0158 }
            goto L_0x00c2
        L_0x00e9:
            android.widget.RadioGroup r1 = r8.f65375e     // Catch:{ JSONException -> 0x0158 }
            int r1 = r1.getCheckedRadioButtonId()     // Catch:{ JSONException -> 0x0158 }
            int r2 = net.one97.paytm.upgradeKyc.R.id.min_kyc_other_doc_voter_id_rb     // Catch:{ JSONException -> 0x0158 }
            if (r1 != r2) goto L_0x00fa
            java.lang.String r0 = "voter"
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0158 }
            goto L_0x00c2
        L_0x00fa:
            android.widget.RadioGroup r1 = r8.f65375e     // Catch:{ JSONException -> 0x0158 }
            int r1 = r1.getCheckedRadioButtonId()     // Catch:{ JSONException -> 0x0158 }
            int r2 = net.one97.paytm.upgradeKyc.R.id.min_kyc_pan_rb     // Catch:{ JSONException -> 0x0158 }
            if (r1 != r2) goto L_0x00c2
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0158 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0158 }
            r4.<init>()     // Catch:{ JSONException -> 0x0158 }
            r4.add(r0)     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ JSONException -> 0x0158 }
            java.lang.String r2 = "wallet_min_kyc_popup"
            java.lang.String r3 = "submit_clicked"
            java.lang.String r5 = ""
            java.lang.String r16 = "kyc"
            java.lang.String r17 = "wallet"
            r1 = r19
            r18 = r9
            r9 = r6
            r6 = r16
            r16 = r13
            r13 = r7
            r7 = r17
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x015c }
        L_0x0131:
            java.lang.String r0 = "docValue"
            r9.put(r0, r14)     // Catch:{ JSONException -> 0x015c }
            r13.put(r9)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r0 = "documents"
            r15.put(r0, r13)     // Catch:{ JSONException -> 0x015c }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x015c }
            r0.<init>()     // Catch:{ JSONException -> 0x015c }
            java.lang.String r1 = "name"
            com.google.android.material.textfield.TextInputEditText r2 = r8.l     // Catch:{ JSONException -> 0x015c }
            android.text.Editable r2 = r2.getText()     // Catch:{ JSONException -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x015c }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r1 = "data"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x015c }
            goto L_0x015c
        L_0x0158:
            r18 = r9
            r16 = r13
        L_0x015c:
            java.lang.String r0 = r15.toString()
            com.paytm.utility.q.a(r0)
            java.lang.String r0 = net.one97.paytm.common.utility.f.a(r12, r11, r0)     // Catch:{ Exception -> 0x0168 }
            goto L_0x0169
        L_0x0168:
        L_0x0169:
            net.one97.paytm.upgradeKyc.helper.a$a r1 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r1 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            r1.f42877a = r8
            com.paytm.network.a$a r2 = com.paytm.network.a.C0715a.POST
            r1.f42879c = r2
            r1.f42882f = r10
            r2 = r16
            r1.f42885i = r2
            r1.f42884h = r0
            r0 = r18
            r1.f42880d = r0
            r0 = 0
            r1.k = r0
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity> r0 = net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity.class
            java.lang.String r0 = r0.getName()
            r1.o = r0
            com.paytm.network.a$b r0 = com.paytm.network.a.b.USER_FACING
            r1.n = r0
            net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity$2 r0 = new net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity$2
            r0.<init>()
            r1.j = r0
            com.paytm.network.a r0 = r1.l()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r19)
            if (r1 == 0) goto L_0x01ae
            int r1 = net.one97.paytm.upgradeKyc.R.string.please_wait
            java.lang.String r1 = r8.getString(r1)
            com.paytm.utility.b.k(r8, r1)
            r0.a()
            return
        L_0x01ae:
            net.one97.paytm.upgradeKyc.helper.a$a r1 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            net.one97.paytm.upgradeKyc.helper.a.C1317a.a((android.content.Context) r8, (com.paytm.network.a) r0)
            com.paytm.utility.b.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity.d():void");
    }

    static /* synthetic */ void a(MinKycPanAadharUpgradeActivity minKycPanAadharUpgradeActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRAadharPanSave) {
            CJRAadharPanSave cJRAadharPanSave = (CJRAadharPanSave) iJRPaytmDataModel;
            b.p();
            if (cJRAadharPanSave == null || cJRAadharPanSave.getErrorErrorMessage() == null) {
                if (cJRAadharPanSave != null && !TextUtils.isEmpty(cJRAadharPanSave.getStatusCode()) && cJRAadharPanSave.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    j.a((Context) minKycPanAadharUpgradeActivity, cJRAadharPanSave.isMinKyc());
                    if (minKycPanAadharUpgradeActivity.u) {
                        minKycPanAadharUpgradeActivity.finish();
                    } else if (!TextUtils.isEmpty(minKycPanAadharUpgradeActivity.v)) {
                        try {
                            String decode = URLDecoder.decode(minKycPanAadharUpgradeActivity.v, AppConstants.UTF_8);
                            e.a aVar = e.f66028b;
                            e.a.b().a((Context) minKycPanAadharUpgradeActivity, decode);
                            minKycPanAadharUpgradeActivity.finish();
                        } catch (Exception unused) {
                        }
                    } else {
                        e.a aVar2 = e.f66028b;
                        e.a.b().a(minKycPanAadharUpgradeActivity, "wallet_min_kyc_popup", "success", new ArrayList(), "", "/min-kyc/popup/success", "wallet");
                        Intent intent = new Intent(minKycPanAadharUpgradeActivity, MinKycDetailsSubmittedActivity.class);
                        Bundle bundle = new Bundle();
                        if (minKycPanAadharUpgradeActivity.f65375e.getCheckedRadioButtonId() == R.id.min_kyc_pan_rb) {
                            bundle.putString("min_kyc_details_submiited", "Pan");
                        } else if (minKycPanAadharUpgradeActivity.f65375e.getCheckedRadioButtonId() == R.id.min_kyc_other_doc_voter_id_rb) {
                            bundle.putString("min_kyc_details_submiited", "Voter ID");
                        } else if (minKycPanAadharUpgradeActivity.f65375e.getCheckedRadioButtonId() == R.id.min_kyc_other_doc_rb_passport) {
                            bundle.putString("min_kyc_details_submiited", "Passport");
                        } else if (minKycPanAadharUpgradeActivity.f65375e.getCheckedRadioButtonId() == R.id.min_kyc_other_doc_jobcard_rb) {
                            bundle.putString("min_kyc_details_submiited", "NREGA Job Card");
                        } else if (minKycPanAadharUpgradeActivity.f65375e.getCheckedRadioButtonId() == R.id.min_kyc_other_doc_driving_rb) {
                            bundle.putString("min_kyc_details_submiited", "Driving License");
                        }
                        bundle.putBoolean("min_kyc_success_via_deep_link", false);
                        intent.putExtras(bundle);
                        minKycPanAadharUpgradeActivity.startActivity(intent);
                        minKycPanAadharUpgradeActivity.finish();
                    }
                }
            } else if (!TextUtils.isEmpty(cJRAadharPanSave.getErrorErrorCode())) {
                String errorErrorCode = cJRAadharPanSave.getErrorErrorCode();
                char c2 = 65535;
                switch (errorErrorCode.hashCode()) {
                    case 1596805:
                        if (errorErrorCode.equals("4009")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1750743:
                        if (errorErrorCode.equals("9561")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1750744:
                        if (errorErrorCode.equals("9562")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    h hVar = new h(minKycPanAadharUpgradeActivity);
                    hVar.setTitle(minKycPanAadharUpgradeActivity.getString(R.string.error));
                    hVar.a(cJRAadharPanSave.getErrorErrorMessage());
                    hVar.a(-3, minKycPanAadharUpgradeActivity.getString(R.string.ok), new View.OnClickListener(hVar) {
                        private final /* synthetic */ h f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            MinKycPanAadharUpgradeActivity.this.a(this.f$1, view);
                        }
                    });
                    hVar.show();
                } else if (c2 != 1 && c2 != 2) {
                    g.b(minKycPanAadharUpgradeActivity, minKycPanAadharUpgradeActivity.getString(R.string.error), minKycPanAadharUpgradeActivity.getString(R.string.some_went_wrong));
                } else if (!minKycPanAadharUpgradeActivity.isFinishing() && !minKycPanAadharUpgradeActivity.isDestroyed()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(minKycPanAadharUpgradeActivity);
                    builder.setMessage(minKycPanAadharUpgradeActivity.getString(R.string.kyc_dedup_dialog_error));
                    builder.setCancelable(false);
                    builder.setPositiveButton(minKycPanAadharUpgradeActivity.getString(R.string.kyc_ok_text), $$Lambda$MinKycPanAadharUpgradeActivity$70pQmkaAYhAJMx_2TJhv9Do7ajM.INSTANCE);
                    builder.show();
                }
            }
        } else if (iJRPaytmDataModel instanceof KYCStatusV2) {
            KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
            b.p();
            String kycExpiryTime = kYCStatusV2.getKycExpiryTime();
            j.b(minKycPanAadharUpgradeActivity.getApplicationContext(), kYCStatusV2.isMinKycEligible());
            if (!TextUtils.isEmpty(kycExpiryTime)) {
                j.d(minKycPanAadharUpgradeActivity.getApplicationContext(), c.a(kycExpiryTime));
            }
            if (!TextUtils.isEmpty(kYCStatusV2.getIsMinor())) {
                j.e(minKycPanAadharUpgradeActivity.getApplicationContext(), kYCStatusV2.getIsMinor());
            }
            if (kYCStatusV2.getIsKycDone() == 1) {
                if (!TextUtils.isEmpty(minKycPanAadharUpgradeActivity.v)) {
                    try {
                        String decode2 = URLDecoder.decode(minKycPanAadharUpgradeActivity.v, AppConstants.UTF_8);
                        e.a aVar3 = e.f66028b;
                        e.a.b().a((Context) minKycPanAadharUpgradeActivity, decode2);
                        minKycPanAadharUpgradeActivity.finish();
                    } catch (Exception unused2) {
                    }
                } else {
                    minKycPanAadharUpgradeActivity.startActivity(new Intent(minKycPanAadharUpgradeActivity, WalletUpgradedSuccessActivity.class));
                    minKycPanAadharUpgradeActivity.finish();
                }
            } else if (kYCStatusV2.isMinKycStatus()) {
                j.a(minKycPanAadharUpgradeActivity.getApplicationContext(), kYCStatusV2.isMinKycStatus());
                if (!TextUtils.isEmpty(minKycPanAadharUpgradeActivity.v)) {
                    try {
                        String decode3 = URLDecoder.decode(minKycPanAadharUpgradeActivity.v, AppConstants.UTF_8);
                        e.a aVar4 = e.f66028b;
                        e.a.b().a((Context) minKycPanAadharUpgradeActivity, decode3);
                        minKycPanAadharUpgradeActivity.finish();
                    } catch (Exception unused3) {
                    }
                } else {
                    Intent intent2 = new Intent(minKycPanAadharUpgradeActivity, MinKycDetailsSubmittedActivity.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("min_kyc_success_via_deep_link", true);
                    intent2.putExtras(bundle2);
                    minKycPanAadharUpgradeActivity.startActivity(intent2);
                    minKycPanAadharUpgradeActivity.finish();
                }
                minKycPanAadharUpgradeActivity.r.setVisibility(8);
            } else {
                minKycPanAadharUpgradeActivity.r.setVisibility(0);
            }
        }
    }
}
