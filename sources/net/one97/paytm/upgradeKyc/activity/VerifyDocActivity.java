package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.common.widgets.a.d;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.minkycotp.KycVerifyOtpActivity;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.utils.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VerifyDocActivity extends UpgradeKycBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, d {

    /* renamed from: a  reason: collision with root package name */
    private RadioGroup f65420a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextInputLayout f65421b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f65422d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextInputLayout f65423e;

    /* renamed from: f  reason: collision with root package name */
    private TextInputEditText f65424f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputEditText f65425g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputEditText f65426h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<TncData> f65427i;
    private boolean j;
    private boolean k;
    private CheckBox l;
    private NestedScrollView m;
    private TextView n;
    /* access modifiers changed from: private */
    public LottieAnimationView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private String s;
    private boolean t = false;
    private TextWatcher u = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            VerifyDocActivity.this.f65421b.setError("");
            VerifyDocActivity.this.f65422d.setError("");
            VerifyDocActivity.this.f65423e.setError("");
        }
    };
    private TextWatcher v = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            VerifyDocActivity.this.f65421b.setError("");
            VerifyDocActivity.this.f65422d.setError("");
            VerifyDocActivity.this.f65423e.setError("");
        }
    };

    public void onCreate(Bundle bundle) {
        CJRHomePageItem cJRHomePageItem;
        super.onCreate(bundle);
        a("/kyc/detail-screen", "kyc_new", "signal");
        e.a aVar = e.f66028b;
        e.a.b().a("/kyc-wallet-upgrade/non-aadhar", "kyc", (Context) this);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("is_from_onboarding_flow")) {
            this.t = getIntent().getExtras().getBoolean("is_from_onboarding_flow");
        }
        setTitle("");
        a(false);
        this.m = (NestedScrollView) findViewById(R.id.sv);
        this.f65421b = (TextInputLayout) findViewById(R.id.lyt_number);
        this.f65422d = (TextInputLayout) findViewById(R.id.lyt_name);
        this.f65423e = (TextInputLayout) findViewById(R.id.lyt_expiry_date);
        this.q = (TextView) findViewById(R.id.terms_text_complete);
        this.f65424f = (TextInputEditText) findViewById(R.id.et_number);
        this.f65425g = (TextInputEditText) findViewById(R.id.et_name);
        this.f65426h = (TextInputEditText) findViewById(R.id.et_expiry_date);
        this.f65425g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        this.l = (CheckBox) findViewById(R.id.terms_checkbox);
        this.r = (TextView) findViewById(R.id.terms_text);
        findViewById(R.id.button_proceed).setOnClickListener(this);
        findViewById(R.id.terms_text).setOnClickListener(this);
        this.f65426h.setOnClickListener(this);
        this.f65420a = (RadioGroup) findViewById(R.id.rg_docs);
        this.f65420a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                VerifyDocActivity.this.a(radioGroup, i2);
            }
        });
        this.f65420a.check(R.id.rb_passport);
        this.o = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.f65426h.addTextChangedListener(this.u);
        this.f65425g.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                VerifyDocActivity.this.f65421b.setError("");
                VerifyDocActivity.this.f65422d.setError("");
                VerifyDocActivity.this.f65423e.setError("");
                String obj = VerifyDocActivity.this.f65425g.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    VerifyDocActivity.this.f65425g.setText(obj.substring(0, obj.length() - 1));
                }
                VerifyDocActivity.this.f65425g.setSelection(VerifyDocActivity.this.f65425g.getText().length());
            }
        });
        this.f65424f.addTextChangedListener(this.v);
        TextView textView = (TextView) findViewById(R.id.kyc_again_doubt_tv);
        this.n = (TextView) findViewById(R.id.kyc_again_know_more_tv);
        if (this.t) {
            this.p = (TextView) findViewById(R.id.skip_min_kyc);
            this.p.setOnClickListener(this);
            this.p.setVisibility(0);
        }
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerifyDocActivity.this.c(view);
            }
        });
        Intent intent = getIntent();
        if (intent.hasExtra("extra_home_data") && (cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data")) != null) {
            String kyc_name = cJRHomePageItem.getKyc_name();
            String aadhar_number = cJRHomePageItem.getAadhar_number();
            this.s = cJRHomePageItem.getCallBackUrl();
            if (!TextUtils.isEmpty(kyc_name)) {
                this.f65425g.setText(kyc_name);
            }
            if (!TextUtils.isEmpty(aadhar_number)) {
                this.f65424f.setText(aadhar_number);
            }
        }
        String string = getString(R.string.kyc_i_agree_to_the);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(String.format(string, new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getString(R.string.kyc_terms_and_conditions) + "</a> "})));
        this.r.setVisibility(0);
        this.r.setLinkTextColor(b.c(this, R.color.paytm_blue));
        this.r.setText(spannableStringBuilder);
        textView.setText(getString(R.string.why_kyc));
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            getIntent().getStringExtra("vertical");
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
        this.f65421b.setOnFocusChangeListener(this);
        this.f65422d.setOnFocusChangeListener(this);
        this.f65423e.setOnFocusChangeListener(this);
        this.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerifyDocActivity.this.a(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        a("/kyc/detail-screen", "checkbox_clicked", (HashMap<String, Object>) null, "signal");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        this.f65421b.setError("");
        this.f65422d.setError("");
        this.f65423e.setError("");
        this.f65424f.setText("");
        this.f65425g.setText("");
        this.f65426h.setText("");
        if (i2 == R.id.rb_voter_id || i2 == R.id.rb_job_card) {
            this.f65421b.setVisibility(0);
            this.f65422d.setVisibility(0);
            this.f65423e.setVisibility(8);
        } else {
            this.f65421b.setVisibility(0);
            this.f65422d.setVisibility(0);
            this.f65423e.setVisibility(0);
        }
        if (i2 == R.id.rb_passport) {
            this.f65424f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), new InputFilter.AllCaps()});
        } else {
            this.f65424f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        }
        this.q.setText(getString(R.string.aadhaar_tnc_complete, new Object[]{g()}));
        HashMap hashMap = new HashMap();
        if (i2 == R.id.rb_voter_id) {
            hashMap.put("event_label", "voter id");
        }
        if (i2 == R.id.rb_passport) {
            hashMap.put("event_label", "passport");
        }
        if (i2 == R.id.rb_job_card) {
            hashMap.put("event_label", "nrega job card");
        }
        if (i2 == R.id.rb_driving_license) {
            hashMap.put("event_label", "driving license");
        }
        if (i2 == R.id.rb_voter_id) {
            this.f65421b.setHint(getString(R.string.voter_id_number));
            this.f65422d.setHint(getString(R.string.voter_id_name));
        } else if (i2 == R.id.rb_job_card) {
            this.f65421b.setHint(getString(R.string.nrega_number));
            this.f65422d.setHint(getString(R.string.nrega_name));
        } else if (i2 == R.id.rb_driving_license) {
            this.f65421b.setHint(getString(R.string.driving_license_number));
            this.f65422d.setHint(getString(R.string.driving_license_name));
            this.f65423e.setHint(getString(R.string.driving_license_expiry));
        } else if (i2 == R.id.rb_passport) {
            this.f65421b.setHint(getString(R.string.kyc_passport_number));
            this.f65422d.setHint(getString(R.string.passport_name));
            this.f65423e.setHint(getString(R.string.passport_expiry));
        }
        a("/kyc/detail-screen", "document_radio_button_selected", hashMap, "signal");
    }

    private void a(boolean z) {
        String str;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_v2_url");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = com.paytm.utility.b.e((Context) this, str);
            a.C1317a aVar3 = a.f66022a;
            Map<String, String> a2 = a.C1317a.a(this);
            a.C1317a aVar4 = a.f66022a;
            com.paytm.network.b a3 = a.C1317a.a();
            a3.f42877a = this;
            a3.f42879c = a.C0715a.GET;
            a3.f42882f = a2;
            a3.f42885i = new KYCFetchTnc();
            a3.f42880d = e2;
            a3.o = VerifyDocActivity.class.getName();
            a3.n = a.b.USER_FACING;
            a3.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    VerifyDocActivity.a(VerifyDocActivity.this, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    l.a();
                    l.a((Context) VerifyDocActivity.this, networkCustomError);
                }
            };
            com.paytm.network.a l2 = a3.l();
            if (com.paytm.utility.b.c((Context) this)) {
                if (z) {
                    net.one97.paytm.common.widgets.a.a(this.o);
                }
                l2.a();
                return;
            }
            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            a.C1317a.a((Context) this, l2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
    }

    public void onClick(View view) {
        boolean z = false;
        if (view.getId() == R.id.button_proceed) {
            a("/kyc/detail-screen", "submit_button_clicked", (HashMap<String, Object>) null, "signal");
            if (TextUtils.isEmpty(this.f65424f.getText())) {
                a(this.f65421b.getEditText());
                a((View) this.f65421b);
                TextInputLayout textInputLayout = this.f65421b;
                textInputLayout.setError(getString(R.string.please_enter) + " " + this.f65421b.getHint());
            } else if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_passport && !com.paytm.utility.b.U(this.f65424f.getText().toString())) {
                a(this.f65421b.getEditText());
                a((View) this.f65421b);
                this.f65421b.setError(getString(R.string.error_passport_number));
            } else if (TextUtils.isEmpty(this.f65425g.getText())) {
                a(this.f65422d.getEditText());
                a((View) this.f65422d);
                TextInputLayout textInputLayout2 = this.f65422d;
                textInputLayout2.setError(getString(R.string.please_enter) + " " + this.f65422d.getHint());
            } else if ((this.f65420a.getCheckedRadioButtonId() == R.id.rb_passport || this.f65420a.getCheckedRadioButtonId() == R.id.rb_driving_license) && TextUtils.isEmpty(this.f65426h.getText())) {
                a(this.f65423e.getEditText());
                a((View) this.f65423e);
                TextInputLayout textInputLayout3 = this.f65423e;
                textInputLayout3.setError(getString(R.string.please_enter) + " " + this.f65423e.getHint());
            } else if (!this.l.isChecked()) {
                com.paytm.utility.b.b((Context) this, getString(R.string.alert), getString(R.string.tnc_accept));
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
            if (m.a(getApplicationContext())) {
                startActivityForResult(new Intent(this, KycVerifyOtpActivity.class), 1111);
            } else {
                d();
            }
        } else if (view.getId() == R.id.terms_text) {
            this.k = false;
            if (this.f65427i != null) {
                e();
                return;
            }
            this.j = true;
            a(true);
        } else if (view.getId() == R.id.et_expiry_date) {
            String obj = this.f65426h.getText().toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            if (TextUtils.isEmpty(obj)) {
                obj = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            }
            net.one97.paytm.common.widgets.e eVar = new net.one97.paytm.common.widgets.e();
            eVar.f49899a = this;
            Bundle bundle = new Bundle();
            bundle.putString("date_format", "dd-MM-yyyy");
            Calendar instance = Calendar.getInstance();
            instance.add(5, 4);
            bundle.putString("min_date", simpleDateFormat.format(instance.getTime()));
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 50);
            bundle.putString("max_date", simpleDateFormat.format(instance2.getTime()));
            bundle.putString("default_dob", obj);
            eVar.setArguments(bundle);
            eVar.show(getSupportFragmentManager(), "DatePickerFragment");
        } else if (view.getId() == R.id.skip_min_kyc) {
            a("skip");
        }
    }

    private void a(String str) {
        Intent intent = getIntent();
        intent.putExtra("result", str);
        setResult(-1, intent);
        finish();
    }

    private void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("kyc_user_id", com.paytm.utility.b.n((Context) this));
        hashMap.put("kyc_document_type", g());
        e.a aVar = e.f66028b;
        e.a.b().a("kyc_verify_document_proceed_clicked", (HashMap<String, Object>) hashMap, (Context) this);
        h();
    }

    public void setSelectedDate(String str) {
        this.f65426h.setText(str);
    }

    private void e() {
        try {
            if (this.f65427i != null && this.f65427i.size() > 0) {
                net.one97.paytm.upgradeKyc.d.m a2 = net.one97.paytm.upgradeKyc.d.m.a(this.f65427i);
                a2.f65713a = new m.a() {
                    public final void onTncAccepted() {
                        VerifyDocActivity.this.k();
                    }
                };
                a2.show(getSupportFragmentManager(), "KycTNCFragment");
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.l.setChecked(true);
    }

    private void f() {
        if (this.f65427i == null) {
            a(true);
            this.k = true;
            net.one97.paytm.common.widgets.a.b(this.o);
            return;
        }
        this.k = false;
        String str = null;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_user_url");
        }
        if (!URLUtil.isValidUrl(str)) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = com.paytm.utility.b.e((Context) this, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            getSystemService(ContactColumn.PHONE_NUMBER);
            jSONObject.put("deviceId", com.paytm.utility.b.e((Context) this));
            if (this.f65427i != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<TncData> it2 = this.f65427i.iterator();
                while (it2.hasNext()) {
                    TncData next = it2.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("code", next.getCode());
                        jSONObject2.put("version", next.getVersion());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("tnCList", jSONArray);
            }
        } catch (JSONException unused) {
        }
        String jSONObject3 = jSONObject.toString();
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        a3.f42877a = this;
        a3.f42879c = a.C0715a.PUT;
        a3.f42882f = a2;
        a3.f42885i = new KYCTncAccept();
        a3.f42884h = jSONObject3;
        a3.o = VerifyDocActivity.class.getName();
        a3.f42880d = e2;
        a3.n = a.b.USER_FACING;
        a3.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                VerifyDocActivity.a(VerifyDocActivity.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                if (l.a((Context) VerifyDocActivity.this, networkCustomError)) {
                    net.one97.paytm.common.widgets.a.b(VerifyDocActivity.this.o);
                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) VerifyDocActivity.this, networkCustomError);
                }
            }
        };
        com.paytm.network.a l2 = a3.l();
        if (com.paytm.utility.b.c((Context) this)) {
            l2.a();
            return;
        }
        net.one97.paytm.common.widgets.a.b(this.o);
        a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this, l2);
    }

    private String g() {
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_passport) {
            return "Passport";
        }
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_driving_license) {
            return "Driving License";
        }
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_job_card) {
            return "NREGA Job Card";
        }
        return this.f65420a.getCheckedRadioButtonId() == R.id.rb_voter_id ? "Voter ID" : "";
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 104 && i3 == -1) {
            setResult(-1);
            finish();
        }
        if (i2 == 1111 && i3 == -1) {
            d();
        }
    }

    private void a(View view) {
        view.post(new Runnable(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                VerifyDocActivity.this.b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        int i2 = getResources().getDisplayMetrics().heightPixels;
        int height = view.getHeight();
        int height2 = ((ViewGroup) view).getChildAt(0).getHeight();
        if (height2 != 0) {
            this.m.a(0, ((height - (height2 * (i2 / height2))) / 2) * -1, false);
        }
    }

    private void a(EditText editText) {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    private void h() {
        String str;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("kyc_save_profile_info");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = com.paytm.utility.b.e((Context) this, str);
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(this));
        String e3 = com.paytm.utility.b.e();
        String f2 = com.paytm.utility.b.f();
        try {
            e.a aVar3 = e.f66028b;
            String c2 = e.a.b().c();
            hashMap.put("x-keyiv", f.a(c2, e3 + ':' + f2));
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        } catch (Exception unused) {
        }
        CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
        cJRAadharPanSave.setIv(f2);
        cJRAadharPanSave.setKey(e3);
        String obj = this.f65424f.getText().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("docCode", j());
            jSONObject2.put("docValue", obj);
            jSONArray.put(jSONObject2);
            jSONObject.put("documents", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", this.f65425g.getText().toString());
            jSONObject.put("data", jSONObject3);
        } catch (JSONException unused2) {
        }
        String jSONObject4 = jSONObject.toString();
        try {
            jSONObject4 = f.a(f2, e3, jSONObject4);
        } catch (Exception unused3) {
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = this;
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = cJRAadharPanSave;
        a2.f42884h = jSONObject4;
        a2.o = VerifyDocActivity.class.getName();
        a2.f42880d = e2;
        a2.k = false;
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                VerifyDocActivity.a(VerifyDocActivity.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                if (!l.a((Context) VerifyDocActivity.this, networkCustomError)) {
                    com.paytm.utility.b.p();
                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) VerifyDocActivity.this, networkCustomError);
                }
            }
        };
        com.paytm.network.a l2 = a2.l();
        if (com.paytm.utility.b.c((Context) this)) {
            net.one97.paytm.common.widgets.a.a(this.o);
            l2.a();
        }
    }

    public void onBackPressed() {
        com.paytm.utility.b.c((Activity) this);
        if (this.t) {
            a(H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
        } else {
            super.onBackPressed();
        }
    }

    private boolean i() {
        if (TextUtils.isEmpty(this.s)) {
            return false;
        }
        try {
            String decode = URLDecoder.decode(this.s, AppConstants.UTF_8);
            e.a aVar = e.f66028b;
            e.a.b().a((Context) this, decode);
            finish();
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private void b(String str) {
        g.b(this, getString(R.string.error), str);
    }

    private String j() {
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_passport) {
            return "passport";
        }
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_driving_license) {
            return "dl";
        }
        if (this.f65420a.getCheckedRadioButtonId() == R.id.rb_job_card) {
            return "nrega_job";
        }
        return this.f65420a.getCheckedRadioButtonId() == R.id.rb_voter_id ? "voter" : "";
    }

    public final int a() {
        return R.layout.activity_verify_doc;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (view.getId() == R.id.et_number) {
                a("/kyc/detail-screen", "passport_number_entered", (HashMap<String, Object>) null, "signal");
            }
            if (view.getId() == R.id.et_name) {
                a("/kyc/detail-screen", "full_name_entered", (HashMap<String, Object>) null, "signal");
            }
            if (view.getId() == R.id.et_expiry_date) {
                a("/kyc/detail-screen", "expiry_date_entered", (HashMap<String, Object>) null, "signal");
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            String a2 = net.one97.paytm.upgradeKyc.helper.d.a("kycAgainLearnMoreUrl");
            try {
                e.a aVar3 = e.f66028b;
                Intent intent = new Intent(this, Class.forName(e.a.b().d()));
                intent.putExtra("url", a2);
                startActivity(intent);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r3.equals("4009") != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.VerifyDocActivity r6, com.paytm.network.model.IJRPaytmDataModel r7) {
        /*
            com.airbnb.lottie.LottieAnimationView r0 = r6.o
            net.one97.paytm.common.widgets.a.b(r0)
            if (r7 == 0) goto L_0x01a6
            boolean r0 = r7 instanceof net.one97.paytm.common.entity.CJRAadharPanSave
            r1 = -1
            if (r0 == 0) goto L_0x00d2
            net.one97.paytm.common.entity.CJRAadharPanSave r7 = (net.one97.paytm.common.entity.CJRAadharPanSave) r7
            com.airbnb.lottie.LottieAnimationView r0 = r6.o
            net.one97.paytm.common.widgets.a.b(r0)
            r0 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0073
            java.lang.String r3 = r7.getErrorErrorMessage()
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = r7.getErrorErrorCode()
            int r4 = r3.hashCode()
            r5 = 2
            switch(r4) {
                case 1596805: goto L_0x003e;
                case 1750743: goto L_0x0034;
                case 1750744: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0047
        L_0x002a:
            java.lang.String r0 = "9562"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0047
            r0 = 1
            goto L_0x0048
        L_0x0034:
            java.lang.String r0 = "9561"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0047
            r0 = 2
            goto L_0x0048
        L_0x003e:
            java.lang.String r4 = "4009"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r0 = -1
        L_0x0048:
            if (r0 == 0) goto L_0x0068
            if (r0 == r2) goto L_0x005b
            if (r0 == r5) goto L_0x005b
            com.paytm.utility.b.p()
            int r7 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r7 = r6.getString(r7)
            r6.b((java.lang.String) r7)
            return
        L_0x005b:
            com.paytm.utility.b.p()
            int r7 = net.one97.paytm.upgradeKyc.R.string.kyc_dedup_dialog_error
            java.lang.String r7 = r6.getString(r7)
            r6.b((java.lang.String) r7)
            return
        L_0x0068:
            com.paytm.utility.b.p()
            java.lang.String r7 = r7.getErrorErrorMessage()
            r6.b((java.lang.String) r7)
            return
        L_0x0073:
            if (r7 == 0) goto L_0x00ce
            java.util.List r1 = r7.getDocuments()
            if (r1 == 0) goto L_0x00ce
            java.util.List r1 = r7.getDocuments()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00ce
            java.util.List r7 = r7.getDocuments()
            java.util.Iterator r7 = r7.iterator()
        L_0x008d:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00be
            java.lang.Object r1 = r7.next()
            net.one97.paytm.common.entity.CJRAadharPanDocList r1 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r1
            if (r1 == 0) goto L_0x008d
            java.lang.String r3 = r1.getDocCode()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x008d
            java.lang.String r3 = r1.getDocCode()
            java.lang.String r4 = r6.j()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x008d
            java.lang.String r1 = r1.getDocValue()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x008d
            r0 = 1
        L_0x00be:
            net.one97.paytm.upgradeKyc.utils.j.a((android.content.Context) r6, (boolean) r2)
            if (r0 == 0) goto L_0x00c7
            r6.f()
            return
        L_0x00c7:
            r6.i()
            com.paytm.utility.b.p()
            return
        L_0x00ce:
            com.paytm.utility.b.p()
            return
        L_0x00d2:
            boolean r0 = r7 instanceof net.one97.paytm.common.entity.auth.KYCFetchTnc
            java.lang.String r2 = "error"
            java.lang.String r3 = "success"
            if (r0 == 0) goto L_0x0139
            boolean r0 = r6.j
            if (r0 == 0) goto L_0x00e4
            com.airbnb.lottie.LottieAnimationView r0 = r6.o
            net.one97.paytm.common.widgets.a.b(r0)
        L_0x00e4:
            net.one97.paytm.common.entity.auth.KYCFetchTnc r7 = (net.one97.paytm.common.entity.auth.KYCFetchTnc) r7
            java.lang.String r0 = r7.getStatus()
            if (r0 == 0) goto L_0x010e
            java.lang.String r0 = r7.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x010e
            java.lang.String r0 = r7.getMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0138
            int r0 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r0, (java.lang.String) r7)
            return
        L_0x010e:
            java.lang.String r0 = r7.getStatus()
            if (r0 == 0) goto L_0x0138
            java.lang.String r0 = r7.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0138
            java.util.ArrayList r0 = r7.getTncDataList()
            if (r0 == 0) goto L_0x0138
            java.util.ArrayList r7 = r7.getTncDataList()
            r6.f65427i = r7
            boolean r7 = r6.j
            if (r7 == 0) goto L_0x0131
            r6.e()
        L_0x0131:
            boolean r7 = r6.k
            if (r7 == 0) goto L_0x0138
            r6.f()
        L_0x0138:
            return
        L_0x0139:
            boolean r0 = r7 instanceof net.one97.paytm.common.entity.auth.KYCTncAccept
            if (r0 == 0) goto L_0x01a6
            com.airbnb.lottie.LottieAnimationView r0 = r6.o
            net.one97.paytm.common.widgets.a.b(r0)
            net.one97.paytm.common.entity.auth.KYCTncAccept r7 = (net.one97.paytm.common.entity.auth.KYCTncAccept) r7
            java.lang.String r0 = r7.getStatus()
            if (r0 == 0) goto L_0x016c
            java.lang.String r0 = r7.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x016c
            java.lang.String r0 = r7.getMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01a6
            int r0 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r0, (java.lang.String) r7)
            return
        L_0x016c:
            java.lang.String r0 = r7.getStatus()
            if (r0 == 0) goto L_0x01a6
            java.lang.String r0 = r7.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x01a6
            java.lang.String r7 = r7.getResponseCode()
            java.lang.String r0 = "2004"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x01a6
            boolean r7 = r6.i()
            if (r7 != 0) goto L_0x01a6
            boolean r7 = r6.t
            if (r7 == 0) goto L_0x0196
            r6.a((java.lang.String) r3)
            return
        L_0x0196:
            android.content.Intent r7 = new android.content.Intent
            java.lang.Class<net.one97.paytm.upgradeKyc.kycV3.activity.MinKycStatusSuccessActivity> r0 = net.one97.paytm.upgradeKyc.kycV3.activity.MinKycStatusSuccessActivity.class
            r7.<init>(r6, r0)
            r6.startActivity(r7)
            r6.setResult(r1)
            r6.finish()
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.VerifyDocActivity.a(net.one97.paytm.upgradeKyc.activity.VerifyDocActivity, com.paytm.network.model.IJRPaytmDataModel):void");
    }
}
