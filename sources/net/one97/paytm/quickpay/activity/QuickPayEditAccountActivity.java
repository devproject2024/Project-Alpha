package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.h;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.requestmoney.b.a.a;

public class QuickPayEditAccountActivity extends QuickPaymentActivity implements View.OnClickListener {
    private final int A = 201;
    private final String B = QuickPayEditAccountActivity.class.getName();
    private TextView.OnEditorActionListener C = new TextView.OnEditorActionListener() {
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return true;
            }
            if (QuickPayEditAccountActivity.this.t) {
                String obj = QuickPayEditAccountActivity.this.x.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return true;
                }
                QuickPayEditAccountActivity.this.a(obj, false);
                return true;
            }
            b.c((Activity) QuickPayEditAccountActivity.this);
            return true;
        }
    };
    private RadioGroup.OnCheckedChangeListener D = new RadioGroup.OnCheckedChangeListener() {
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R.id.qp_paytm_rb) {
                QuickPayEditAccountActivity.this.a(true);
            } else {
                QuickPayEditAccountActivity.this.a(false);
            }
        }
    };
    private TextWatcher E = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            QuickPayEditAccountActivity.c(QuickPayEditAccountActivity.this);
            if (QuickPayEditAccountActivity.this.v) {
                boolean unused = QuickPayEditAccountActivity.this.v = false;
                QuickPayEditAccountActivity.this.f59969f.setVisibility(8);
            }
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            if (b.X(charSequence.toString())) {
                boolean unused2 = QuickPayEditAccountActivity.this.t = true;
                QuickPayEditAccountActivity.d(QuickPayEditAccountActivity.this, true);
                return;
            }
            boolean unused3 = QuickPayEditAccountActivity.this.t = false;
            QuickPayEditAccountActivity.d(QuickPayEditAccountActivity.this, false);
        }
    };
    private TextWatcher F = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            QuickPayEditAccountActivity.c(QuickPayEditAccountActivity.this);
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            QuickPayEditAccountActivity.this.f59970g.setVisibility(8);
            if (QuickPayEditAccountActivity.this.w) {
                boolean unused = QuickPayEditAccountActivity.this.w = false;
            }
            if (TextUtils.isEmpty(obj)) {
                QuickPayEditAccountActivity.this.f59968e.setText(R.string.find_ifsc);
            } else if (TextUtils.isEmpty(obj) || obj.length() != 11) {
                QuickPayEditAccountActivity.this.f59968e.setText(QuickPayEditAccountActivity.this.getString(R.string.verify));
            } else {
                QuickPayEditAccountActivity.this.b(obj);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f59965a;

    /* renamed from: c  reason: collision with root package name */
    private SupportingData f59966c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f59967d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f59968e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59969f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59970g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f59971h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f59972i;
    private RadioButton j;
    private RelativeLayout k;
    /* access modifiers changed from: private */
    public TextInputLayout l;
    /* access modifiers changed from: private */
    public TextInputLayout m;
    private TextInputLayout n;
    private TextInputLayout o;
    private AppCompatEditText p;
    private AppCompatEditText q;
    /* access modifiers changed from: private */
    public AppCompatEditText r;
    private boolean s = true;
    /* access modifiers changed from: private */
    public boolean t;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public AutoCompleteTextView x;
    private ProgressBar y;
    private String z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_quick_pay_edit_account);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        b(getResources().getColor(R.color.white));
        Intent intent = getIntent();
        if (intent != null) {
            this.f59966c = (SupportingData) intent.getSerializableExtra("support_entity");
        }
        this.l = (TextInputLayout) findViewById(R.id.qp_account_vpa_til);
        this.m = (TextInputLayout) findViewById(R.id.qp_account_name_til);
        this.x = (AutoCompleteTextView) findViewById(R.id.qp_account_number_et);
        this.f59970g = (ImageView) findViewById(R.id.qp_ifsc_verified_iv);
        this.f59971h = (LinearLayout) findViewById(R.id.qp_bank_ll);
        this.f59965a = (RelativeLayout) findViewById(R.id.qp_wallet_ll);
        this.f59972i = (RadioButton) findViewById(R.id.qp_account_rb);
        this.j = (RadioButton) findViewById(R.id.qp_paytm_rb);
        this.k = (RelativeLayout) findViewById(R.id.qp_ifsc_layout);
        this.f59967d = (TextView) findViewById(R.id.qp_verify_vpa_tv);
        this.f59968e = (TextView) findViewById(R.id.qp_ifsc_state_tv);
        this.p = (AppCompatEditText) findViewById(R.id.qp_ifsc_et);
        this.p.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        this.n = (TextInputLayout) findViewById(R.id.qp_ifsc_til);
        this.o = (TextInputLayout) findViewById(R.id.qp_mobile_number_til);
        this.q = (AppCompatEditText) findViewById(R.id.qp_mobile_number_et);
        this.r = (AppCompatEditText) findViewById(R.id.qp_account_name_et);
        this.f59969f = (ImageView) findViewById(R.id.qp_vpa_verified_iv);
        this.y = (ProgressBar) findViewById(R.id.qp_ifsc_progress);
        SupportingData supportingData = this.f59966c;
        if (supportingData != null) {
            String beneficiaryMobileNumber = supportingData.getBeneficiaryMobileNumber();
            if (!TextUtils.isEmpty(beneficiaryMobileNumber)) {
                a(true);
                this.j.setChecked(true);
                this.f59972i.setChecked(false);
                this.q.setText(beneficiaryMobileNumber);
            }
            String beneficiaryUpiAddress = this.f59966c.getBeneficiaryUpiAddress();
            if (!TextUtils.isEmpty(beneficiaryUpiAddress)) {
                a(false);
                this.v = true;
                String beneficiaryName = this.f59966c.getBeneficiaryName();
                this.x.setText(beneficiaryUpiAddress);
                this.r.setText(beneficiaryName);
                this.k.setVisibility(8);
            }
            String beneficiaryAccountNumber = this.f59966c.getBeneficiaryAccountNumber();
            if (!TextUtils.isEmpty(beneficiaryAccountNumber)) {
                a(false);
                b(true);
                this.w = true;
                String beneficiaryIfscCode = this.f59966c.getBeneficiaryIfscCode();
                String beneficiaryName2 = this.f59966c.getBeneficiaryName();
                this.x.setText(beneficiaryAccountNumber);
                this.p.setText(beneficiaryIfscCode);
                this.r.setText(beneficiaryName2);
            }
        }
        findViewById(R.id.qpea_back_iv).setOnClickListener(this);
        findViewById(R.id.qpe_save_tv).setOnClickListener(this);
        findViewById(R.id.qp_verify_vpa_tv).setOnClickListener(this);
        findViewById(R.id.qp_ifsc_state_tv).setOnClickListener(this);
        ((RadioGroup) findViewById(R.id.qp_select_rg)).setOnCheckedChangeListener(this.D);
        this.p.addTextChangedListener(this.F);
        this.x.addTextChangedListener(this.E);
        this.x.setOnEditorActionListener(this.C);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 201) {
            return;
        }
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("intent_extra_ifsc_code"))) {
            b(false);
            return;
        }
        this.p.setText(intent.getStringExtra("intent_extra_ifsc_code"));
        this.z = intent.getStringExtra("intent_extra_bank_name");
        b(true);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.qpea_back_iv) {
            onBackPressed();
        } else if (id == R.id.qpe_save_tv) {
            b();
        } else if (id == R.id.qp_verify_vpa_tv) {
            String obj = this.x.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                a(obj, false);
            }
        } else if (id == R.id.qp_ifsc_state_tv) {
            this.n.setError((CharSequence) null);
            b.c((Activity) this);
            if (this.f59968e.getText().toString().equalsIgnoreCase(getResources().getString(R.string.verify))) {
                if (a.m(this)) {
                    b(this.p.getText().toString());
                } else {
                    b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
                }
            } else if (this.f59968e.getText().toString().equalsIgnoreCase(getResources().getString(R.string.find_ifsc))) {
                Intent r2 = d.a().r(this);
                r2.putExtra("show_ifsc_new_design", true);
                startActivityForResult(r2, 201);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent();
        if (this.u) {
            String obj = this.q.getText().toString();
            if (!b.b(obj)) {
                this.o.setError(getString(R.string.enter_valid_mobile_number));
                this.q.requestFocus();
                return;
            }
            this.f59966c.setBeneficiaryMobileNumber(obj);
            this.f59966c.setBeneficiaryAccountNumber((String) null);
            this.f59966c.setBeneficiaryIfscCode((String) null);
            this.f59966c.setBeneficiaryName((String) null);
            this.f59966c.setBeneficiaryUpiAddress((String) null);
            this.f59966c.setBeneficiaryBankName((String) null);
            intent.putExtra("support_entity", this.f59966c);
            setResult(-1, intent);
            finish();
        } else if (!this.t) {
            String obj2 = this.x.getText().toString();
            String obj3 = this.p.getText().toString();
            String obj4 = this.r.getText().toString();
            if (!d.a().d(obj2)) {
                this.l.setError(getString(R.string.wallet_account_number_error));
                this.x.requestFocus();
            } else if (!this.w) {
                this.n.setError(getString(R.string.wallet_ifsc_code_error));
                this.p.requestFocus();
            } else if (TextUtils.isEmpty(obj4)) {
                this.m.setError(getString(R.string.wallet_account_name_error));
                this.r.requestFocus();
            } else {
                this.f59966c.setBeneficiaryAccountNumber(obj2);
                this.f59966c.setBeneficiaryIfscCode(obj3);
                this.f59966c.setBeneficiaryName(obj4);
                this.f59966c.setBeneficiaryBankName(this.z);
                this.f59966c.setBeneficiaryMobileNumber((String) null);
                this.f59966c.setBeneficiaryUpiAddress((String) null);
                intent.putExtra("support_entity", this.f59966c);
                setResult(-1, intent);
                finish();
            }
        } else if (this.v) {
            String obj5 = this.r.getText().toString();
            if (TextUtils.isEmpty(obj5)) {
                this.m.setError(getString(R.string.wallet_account_name_error));
                this.r.requestFocus();
                return;
            }
            this.f59966c.setBeneficiaryUpiAddress(this.x.getText().toString());
            this.f59966c.setBeneficiaryName(obj5);
            this.f59966c.setBeneficiaryMobileNumber((String) null);
            this.f59966c.setBeneficiaryAccountNumber((String) null);
            this.f59966c.setBeneficiaryIfscCode((String) null);
            this.f59966c.setBeneficiaryBankName((String) null);
            intent.putExtra("support_entity", this.f59966c);
            setResult(-1, intent);
            finish();
        } else {
            String obj6 = this.x.getText().toString();
            if (!TextUtils.isEmpty(obj6)) {
                a(obj6, true);
                return;
            }
            this.l.setError("Please verify UPI ID");
            this.x.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            this.u = true;
            this.s = false;
            this.q.requestFocus();
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.f59972i.setTypeface(Typeface.DEFAULT);
            this.f59971h.setVisibility(8);
            this.f59965a.setVisibility(0);
            return;
        }
        this.u = false;
        this.s = true;
        this.x.requestFocus();
        this.j.setTypeface(Typeface.DEFAULT);
        this.f59972i.setTypeface(Typeface.DEFAULT_BOLD);
        this.f59965a.setVisibility(8);
        this.f59971h.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void a(String str, final boolean z2) {
        if (a.m(this)) {
            this.l.setError((CharSequence) null);
            b.c((Activity) this);
            if (!a(str)) {
                return;
            }
            if (str.toLowerCase().contains(".com")) {
                final String c2 = d.a().c(str);
                final h hVar = new h(this);
                hVar.a(String.format(getString(R.string.did_you_mean_to_enter_quick), new Object[]{c2}));
                hVar.a(-1, CommonPayParams.Builder.YES, new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.dismiss();
                        QuickPayEditAccountActivity.this.x.setText(c2);
                        QuickPayEditAccountActivity.this.a(c2, "xyz", z2);
                    }
                });
                hVar.a(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.dismiss();
                        QuickPayEditAccountActivity quickPayEditAccountActivity = QuickPayEditAccountActivity.this;
                        quickPayEditAccountActivity.a(quickPayEditAccountActivity.x.getText().toString(), "xyz", z2);
                    }
                });
                hVar.show();
                return;
            }
            a(str, "xyz", z2);
            return;
        }
        b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l.setError(getString(R.string.upi_empty_vpa_error));
            return false;
        } else if (str.length() > 255) {
            this.l.setError(getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (str.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            this.l.setError(getString(R.string.upi_invalid_upi));
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, final boolean z2) {
        a((Context) this, getResources().getString(R.string.verifying));
        net.one97.paytm.upi.requestmoney.b.a.b c2 = g.c();
        AnonymousClass7 r2 = new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                QuickPayEditAccountActivity.this.a();
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        QuickPayEditAccountActivity.this.l.setError("You have entered an incorrect UPI ID");
                        return;
                    }
                    String str = (String) baseUpiResponse.getMobileAppData();
                    if (str.toLowerCase().contains("success")) {
                        String substring = str.substring(str.indexOf("=") + 1);
                        if (!TextUtils.isEmpty(substring)) {
                            boolean unused = QuickPayEditAccountActivity.this.v = true;
                            QuickPayEditAccountActivity.this.f59969f.setVisibility(0);
                            QuickPayEditAccountActivity.this.f59967d.setVisibility(8);
                            QuickPayEditAccountActivity.this.m.setVisibility(0);
                            QuickPayEditAccountActivity.this.r.setText(substring);
                            if (z2) {
                                QuickPayEditAccountActivity.this.b();
                                return;
                            }
                            return;
                        }
                        QuickPayEditAccountActivity.this.l.setError("You have entered an incorrect UPI ID");
                    }
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                QuickPayEditAccountActivity.this.a();
                QuickPayEditAccountActivity.this.l.setError("You have entered an incorrect UPI ID");
            }
        };
        String str3 = this.B;
        c2.a(r2, str3, str, str2, str3);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!TextUtils.isEmpty(str) && com.paytm.utility.a.m(this)) {
            c(true);
            d.a().a((Activity) this, str, (net.one97.paytm.landingpage.c.d) new net.one97.paytm.landingpage.c.d() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    QuickPayEditAccountActivity.this.c(false);
                    QuickPayEditAccountActivity.a(QuickPayEditAccountActivity.this, (CJRBankDetails) iJRPaytmDataModel);
                }

                public final void a(NetworkCustomError networkCustomError) {
                    QuickPayEditAccountActivity.this.c(false);
                    QuickPayEditAccountActivity.this.b(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            this.f59968e.setText(R.string.verified);
            this.f59970g.setVisibility(0);
            this.w = true;
            return;
        }
        this.f59968e.setText(R.string.find_ifsc);
        this.f59970g.setVisibility(8);
        this.w = false;
        this.n.setError(getString(R.string.enter_valid_ifsc));
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (z2) {
            this.y.setVisibility(0);
            this.f59968e.setVisibility(8);
            this.f59970g.setVisibility(8);
            return;
        }
        this.y.setVisibility(8);
        this.f59968e.setVisibility(0);
    }

    static /* synthetic */ void c(QuickPayEditAccountActivity quickPayEditAccountActivity) {
        quickPayEditAccountActivity.o.setError((CharSequence) null);
        quickPayEditAccountActivity.m.setError((CharSequence) null);
        quickPayEditAccountActivity.n.setError((CharSequence) null);
        quickPayEditAccountActivity.l.setError((CharSequence) null);
    }

    static /* synthetic */ void d(QuickPayEditAccountActivity quickPayEditAccountActivity, boolean z2) {
        if (z2) {
            quickPayEditAccountActivity.k.setVisibility(8);
            quickPayEditAccountActivity.m.setVisibility(8);
            quickPayEditAccountActivity.f59967d.setVisibility(0);
            return;
        }
        quickPayEditAccountActivity.k.setVisibility(0);
        quickPayEditAccountActivity.m.setVisibility(0);
        quickPayEditAccountActivity.f59967d.setVisibility(8);
    }

    static /* synthetic */ void a(QuickPayEditAccountActivity quickPayEditAccountActivity, CJRBankDetails cJRBankDetails) {
        if (cJRBankDetails.getStatusCode() == null || !cJRBankDetails.getStatusCode().equalsIgnoreCase("SUCCESS") || cJRBankDetails.getResponse() == null) {
            quickPayEditAccountActivity.b(false);
            return;
        }
        quickPayEditAccountActivity.b(true);
        quickPayEditAccountActivity.z = cJRBankDetails.getResponse().getBankName();
    }
}
