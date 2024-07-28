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
import android.webkit.URLUtil;
import android.widget.AdapterView;
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
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.a.e;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import org.json.JSONException;
import org.json.JSONObject;

public class AddNewQuickPaymentActivity extends QuickPaymentActivity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    private ProgressBar F;
    /* access modifiers changed from: private */
    public String G;
    private String H;
    private String I;
    private String J;
    private String K;
    /* access modifiers changed from: private */
    public String L;
    /* access modifiers changed from: private */
    public String M;
    /* access modifiers changed from: private */
    public String N;
    /* access modifiers changed from: private */
    public String O;
    /* access modifiers changed from: private */
    public String P;
    private String Q;
    /* access modifiers changed from: private */
    public String R;
    private final int S = 101;
    private final String T;
    private final String U;
    /* access modifiers changed from: private */
    public AutoCompleteTextView V;
    /* access modifiers changed from: private */
    public e W;
    /* access modifiers changed from: private */
    public ArrayList<IJRPaytmDataModel> X;
    private RadioGroup.OnCheckedChangeListener Y;
    private TextWatcher Z;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f59904a;
    private TextWatcher aa;
    private TextWatcher ab;
    private View.OnFocusChangeListener ac;
    private View.OnFocusChangeListener ad;
    private TextView.OnEditorActionListener ae;
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener af;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59905c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f59906d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f59907e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f59908f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f59909g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f59910h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageView f59911i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public LinearLayout k;
    /* access modifiers changed from: private */
    public RadioButton l;
    /* access modifiers changed from: private */
    public RadioButton m;
    private RelativeLayout n;
    /* access modifiers changed from: private */
    public RelativeLayout o;
    /* access modifiers changed from: private */
    public TextInputLayout p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    /* access modifiers changed from: private */
    public TextInputLayout r;
    private TextInputLayout s;
    /* access modifiers changed from: private */
    public TextInputLayout t;
    /* access modifiers changed from: private */
    public AppCompatEditText u;
    /* access modifiers changed from: private */
    public AppCompatEditText v;
    /* access modifiers changed from: private */
    public AppCompatEditText w;
    /* access modifiers changed from: private */
    public AppCompatEditText x;
    /* access modifiers changed from: private */
    public AppCompatEditText y;
    /* access modifiers changed from: private */
    public boolean z = true;

    public AddNewQuickPaymentActivity() {
        Class<AddNewQuickPaymentActivity> cls = AddNewQuickPaymentActivity.class;
        this.T = cls.getName();
        this.U = cls.getName();
        this.X = new ArrayList<>();
        this.Y = new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == R.id.qp_paytm_rb) {
                    boolean unused = AddNewQuickPaymentActivity.this.B = true;
                    boolean unused2 = AddNewQuickPaymentActivity.this.z = false;
                    AddNewQuickPaymentActivity.this.v.requestFocus();
                    AddNewQuickPaymentActivity.this.m.setTypeface(Typeface.DEFAULT_BOLD);
                    AddNewQuickPaymentActivity.this.l.setTypeface(Typeface.DEFAULT);
                    AddNewQuickPaymentActivity.this.k.setVisibility(8);
                    AddNewQuickPaymentActivity.this.f59904a.setVisibility(0);
                    return;
                }
                boolean unused3 = AddNewQuickPaymentActivity.this.B = false;
                boolean unused4 = AddNewQuickPaymentActivity.this.z = true;
                AddNewQuickPaymentActivity.this.V.requestFocus();
                AddNewQuickPaymentActivity.this.m.setTypeface(Typeface.DEFAULT);
                AddNewQuickPaymentActivity.this.l.setTypeface(Typeface.DEFAULT_BOLD);
                AddNewQuickPaymentActivity.this.f59904a.setVisibility(8);
                AddNewQuickPaymentActivity.this.k.setVisibility(0);
            }
        };
        this.Z = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AddNewQuickPaymentActivity.f(AddNewQuickPaymentActivity.this);
                if (AddNewQuickPaymentActivity.this.C) {
                    boolean unused = AddNewQuickPaymentActivity.this.C = false;
                    AddNewQuickPaymentActivity.this.f59911i.setVisibility(8);
                }
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                if (b.X(charSequence.toString())) {
                    boolean unused2 = AddNewQuickPaymentActivity.this.A = true;
                    AddNewQuickPaymentActivity.e(AddNewQuickPaymentActivity.this, true);
                    return;
                }
                boolean unused3 = AddNewQuickPaymentActivity.this.A = false;
                AddNewQuickPaymentActivity.e(AddNewQuickPaymentActivity.this, false);
            }
        };
        this.aa = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AddNewQuickPaymentActivity.f(AddNewQuickPaymentActivity.this);
            }
        };
        this.ab = new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AddNewQuickPaymentActivity.f(AddNewQuickPaymentActivity.this);
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                AddNewQuickPaymentActivity.this.j.setVisibility(8);
                if (AddNewQuickPaymentActivity.this.D) {
                    boolean unused = AddNewQuickPaymentActivity.this.D = false;
                }
                if (TextUtils.isEmpty(obj)) {
                    AddNewQuickPaymentActivity.this.f59907e.setText(R.string.find_ifsc);
                    AddNewQuickPaymentActivity.this.f59907e.setVisibility(0);
                } else if (TextUtils.isEmpty(obj) || obj.length() != 11) {
                    AddNewQuickPaymentActivity.this.f59907e.setText(AddNewQuickPaymentActivity.this.getString(R.string.verify));
                } else {
                    AddNewQuickPaymentActivity.this.b(obj);
                }
            }
        };
        this.ac = new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    AddNewQuickPaymentActivity.this.t.setHint(AddNewQuickPaymentActivity.this.getResources().getString(R.string.qp_name_title));
                } else if (!TextUtils.isEmpty(AddNewQuickPaymentActivity.this.w.getText().toString())) {
                    AddNewQuickPaymentActivity.this.t.setHint(AddNewQuickPaymentActivity.this.getResources().getString(R.string.qp_name_title));
                } else {
                    TextInputLayout m = AddNewQuickPaymentActivity.this.t;
                    m.setHint(AddNewQuickPaymentActivity.this.R + "'s " + AddNewQuickPaymentActivity.this.G);
                }
            }
        };
        this.ad = new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    AddNewQuickPaymentActivity.this.p.setHint(AddNewQuickPaymentActivity.this.getResources().getString(R.string.amount));
                } else if (!TextUtils.isEmpty(AddNewQuickPaymentActivity.this.x.getText().toString())) {
                    AddNewQuickPaymentActivity.this.p.setHint(AddNewQuickPaymentActivity.this.getResources().getString(R.string.amount));
                } else if (AddNewQuickPaymentActivity.this.E) {
                    AddNewQuickPaymentActivity.this.p.setHint(AddNewQuickPaymentActivity.this.getString(R.string.qp_enter_amount_optional));
                } else {
                    AddNewQuickPaymentActivity.this.p.setHint(String.format(AddNewQuickPaymentActivity.this.getString(R.string.qp_enter_amount_for), new Object[]{AddNewQuickPaymentActivity.this.G}));
                }
            }
        };
        this.ae = new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return true;
                }
                if (AddNewQuickPaymentActivity.this.A) {
                    String obj = AddNewQuickPaymentActivity.this.V.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        return true;
                    }
                    AddNewQuickPaymentActivity.this.a(obj, false);
                    return true;
                }
                b.c((Activity) AddNewQuickPaymentActivity.this);
                return true;
            }
        };
        this.af = new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                IJRPaytmDataModel a2 = ((e) adapterView.getAdapter()).getItem(i2);
                if (a2 instanceof BeneficiaryEntity) {
                    BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a2;
                    if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                        BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                        String unused = AddNewQuickPaymentActivity.this.P = otherBankAccountDetail.bankName;
                        String unused2 = AddNewQuickPaymentActivity.this.N = otherBankAccountDetail.accountNumber;
                        String unused3 = AddNewQuickPaymentActivity.this.O = otherBankAccountDetail.ifscCode;
                        String unused4 = AddNewQuickPaymentActivity.this.L = otherBankAccountDetail.accountHolderName;
                        AddNewQuickPaymentActivity.this.r.setVisibility(8);
                        AddNewQuickPaymentActivity.this.o.setVisibility(0);
                        boolean unused5 = AddNewQuickPaymentActivity.this.z = true;
                        AddNewQuickPaymentActivity.this.f59908f.setText(AddNewQuickPaymentActivity.this.P);
                        AddNewQuickPaymentActivity.this.f59909g.setText(AddNewQuickPaymentActivity.this.O);
                        AddNewQuickPaymentActivity.this.V.setText(AddNewQuickPaymentActivity.this.N);
                        AddNewQuickPaymentActivity.this.u.setText(AddNewQuickPaymentActivity.this.O);
                        AddNewQuickPaymentActivity.this.y.setText(AddNewQuickPaymentActivity.this.L);
                        AddNewQuickPaymentActivity.this.b(true);
                        AddNewQuickPaymentActivity.this.b();
                    } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                        BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                        AddNewQuickPaymentActivity.this.r.setVisibility(8);
                        String unused6 = AddNewQuickPaymentActivity.this.M = uPIAccountDetail.vpa;
                        String unused7 = AddNewQuickPaymentActivity.this.L = uPIAccountDetail.accountHolderName;
                        AddNewQuickPaymentActivity.this.V.setText(uPIAccountDetail.vpa);
                        AddNewQuickPaymentActivity.this.u.setText(AddNewQuickPaymentActivity.this.O);
                        AddNewQuickPaymentActivity.this.y.setText(AddNewQuickPaymentActivity.this.L);
                        boolean unused8 = AddNewQuickPaymentActivity.this.A = true;
                        boolean unused9 = AddNewQuickPaymentActivity.this.C = true;
                        AddNewQuickPaymentActivity.this.f59911i.setVisibility(0);
                        AddNewQuickPaymentActivity.this.f59906d.setVisibility(8);
                        AddNewQuickPaymentActivity.this.b();
                    }
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_new_quick_payment);
        d.a().a("/personal-payments/category", "homescreen", (Activity) this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        b(getResources().getColor(R.color.white));
        this.f59905c = (TextView) findViewById(R.id.qp_name_tv);
        this.f59910h = (ImageView) findViewById(R.id.qp_icon_iv);
        this.j = (ImageView) findViewById(R.id.qp_ifsc_verified_iv);
        this.k = (LinearLayout) findViewById(R.id.qp_bank_ll);
        this.f59904a = (RelativeLayout) findViewById(R.id.qp_wallet_ll);
        this.l = (RadioButton) findViewById(R.id.qp_account_rb);
        this.m = (RadioButton) findViewById(R.id.qp_paytm_rb);
        this.V = (AutoCompleteTextView) findViewById(R.id.qp_account_number_et);
        this.n = (RelativeLayout) findViewById(R.id.qp_ifsc_layout);
        this.q = (TextInputLayout) findViewById(R.id.qp_account_vpa_til);
        this.f59906d = (TextView) findViewById(R.id.qp_verify_vpa_tv);
        this.f59907e = (TextView) findViewById(R.id.qp_ifsc_state_tv);
        this.u = (AppCompatEditText) findViewById(R.id.qp_ifsc_et);
        int i2 = 0;
        this.u.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        this.r = (TextInputLayout) findViewById(R.id.qp_ifsc_til);
        this.s = (TextInputLayout) findViewById(R.id.qp_mobile_number_til);
        this.v = (AppCompatEditText) findViewById(R.id.qp_mobile_number_et);
        this.p = (TextInputLayout) findViewById(R.id.qp_amounnt_til);
        this.x = (AppCompatEditText) findViewById(R.id.qp_amount_et);
        this.t = (TextInputLayout) findViewById(R.id.qp_name_til);
        this.w = (AppCompatEditText) findViewById(R.id.qp_name_et);
        this.y = (AppCompatEditText) findViewById(R.id.qp_account_name_et);
        this.f59911i = (ImageView) findViewById(R.id.qp_vpa_verified_iv);
        this.F = (ProgressBar) findViewById(R.id.qp_ifsc_progress);
        this.o = (RelativeLayout) findViewById(R.id.ifsc_value_rl);
        this.f59909g = (TextView) findViewById(R.id.ifsc_verified_value);
        this.f59908f = (TextView) findViewById(R.id.bank_verified_value);
        findViewById(R.id.qp_back_iv).setOnClickListener(this);
        ((RadioGroup) findViewById(R.id.qp_select_rg)).setOnCheckedChangeListener(this.Y);
        this.V.addTextChangedListener(this.Z);
        this.V.setThreshold(1);
        this.V.setOnEditorActionListener(this.ae);
        this.x.setOnFocusChangeListener(this.ad);
        this.w.setOnFocusChangeListener(this.ac);
        this.f59906d.setOnClickListener(this);
        this.f59907e.setOnClickListener(this);
        findViewById(R.id.qp_add_tv).setOnClickListener(this);
        this.w.addTextChangedListener(this.aa);
        this.v.addTextChangedListener(this.aa);
        this.u.addTextChangedListener(this.ab);
        this.o.setOnClickListener(this);
        if (a.m(this)) {
            d.a().a((Activity) this, (net.one97.paytm.landingpage.c.d) new net.one97.paytm.landingpage.c.d() {
                public final void a(NetworkCustomError networkCustomError) {
                }

                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
                        ArrayList<BeneficiaryEntity> beneficiariesList = ((CJRKYCBeneficiaryBase) iJRPaytmDataModel).getBeneficiariesList();
                        if (beneficiariesList != null) {
                            Iterator<BeneficiaryEntity> it2 = beneficiariesList.iterator();
                            while (it2.hasNext()) {
                                BeneficiaryEntity next = it2.next();
                                if (next.instrumentPreferences.otherBank != null || next.instrumentPreferences.upi != null) {
                                    AddNewQuickPaymentActivity.this.X.add(next);
                                }
                            }
                        }
                        if (AddNewQuickPaymentActivity.this.W == null) {
                            AddNewQuickPaymentActivity addNewQuickPaymentActivity = AddNewQuickPaymentActivity.this;
                            e unused = addNewQuickPaymentActivity.W = new e(addNewQuickPaymentActivity, addNewQuickPaymentActivity.X);
                            AddNewQuickPaymentActivity.this.V.setAdapter(AddNewQuickPaymentActivity.this.W);
                            AddNewQuickPaymentActivity.this.V.setOnItemClickListener(AddNewQuickPaymentActivity.this.af);
                            return;
                        }
                        AddNewQuickPaymentActivity.this.W.a((ArrayList<IJRPaytmDataModel>) AddNewQuickPaymentActivity.this.X);
                    }
                }
            });
        }
        Intent intent = getIntent();
        this.n.setVisibility(8);
        if (intent != null) {
            this.E = intent.getBooleanExtra("is_other_default_quick_pay", false);
            if (intent.hasExtra("tag_name")) {
                this.G = intent.getStringExtra("tag_name");
                this.f59905c.setText(this.G);
                ((TextView) findViewById(R.id.qp_message)).setText(getResources().getString(R.string.aqp_message));
            }
            if (intent.hasExtra("tag_url")) {
                this.I = intent.getStringExtra("tag_url");
                if (TextUtils.isEmpty(this.I)) {
                    this.f59910h.setImageResource(R.drawable.ic_other);
                } else {
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
                    a2.f43753a = this.I;
                    a2.a(this.f59910h);
                }
            }
            if (intent.hasExtra("tag_id")) {
                this.H = intent.getStringExtra("tag_id");
            }
            if (intent.hasExtra("tag_title")) {
                this.R = intent.getStringExtra("tag_title");
                TextInputLayout textInputLayout = this.t;
                textInputLayout.setHint(this.R + "'s " + getString(R.string.qp_name_optional));
            }
            if (intent.hasExtra("view_id")) {
                if (String.valueOf(net.one97.paytm.quickpay.utilities.e.BUSINESS.getCategoryId()).equalsIgnoreCase(intent.getStringExtra("view_id"))) {
                    findViewById(R.id.qp_select_rg).setVisibility(8);
                } else {
                    findViewById(R.id.qp_select_rg).setVisibility(0);
                }
            }
            if (this.E) {
                this.p.setHint(getString(R.string.qp_enter_amount_optional));
            } else {
                this.p.setHint(String.format(getString(R.string.qp_enter_amount_for), new Object[]{this.G}));
            }
            boolean z2 = this.E;
            TextInputLayout textInputLayout2 = this.t;
            if (z2) {
                i2 = 8;
            }
            textInputLayout2.setVisibility(i2);
        }
        a("category_screen_loaded", this.G, (String) null);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 101) {
            return;
        }
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("intent_extra_ifsc_code"))) {
            b(false);
            return;
        }
        this.P = intent.getStringExtra("intent_extra_bank_name");
        this.r.setVisibility(8);
        this.o.setVisibility(0);
        this.f59908f.setText(this.P);
        this.f59909g.setText(intent.getStringExtra("intent_extra_ifsc_code"));
        b(true);
    }

    public void onDestroy() {
        super.onDestroy();
        f.b(this).cancelAll((Object) this.T);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.qp_back_iv) {
            finish();
        } else if (id == R.id.qp_verify_vpa_tv) {
            String obj = this.V.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                a(obj, false);
            }
        } else if (id == R.id.qp_ifsc_state_tv) {
            this.r.setError((CharSequence) null);
            com.paytm.utility.b.c((Activity) this);
            if (this.f59907e.getText().toString().equalsIgnoreCase(getResources().getString(R.string.verify))) {
                if (a.m(this)) {
                    b(this.u.getText().toString());
                } else {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
                }
            } else if (this.f59907e.getText().toString().equalsIgnoreCase(getResources().getString(R.string.find_ifsc))) {
                Intent r2 = d.a().r(this);
                r2.putExtra("show_ifsc_new_design", true);
                startActivityForResult(r2, 101);
            }
        } else if (id == R.id.qp_add_tv) {
            b();
        } else if (id == R.id.ifsc_value_rl) {
            this.o.setVisibility(8);
            this.r.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, final boolean z2) {
        if (a.m(this)) {
            this.q.setError((CharSequence) null);
            com.paytm.utility.b.c((Activity) this);
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
                        AddNewQuickPaymentActivity.this.V.setText(c2);
                        AddNewQuickPaymentActivity.this.a(c2, "xyz", z2);
                    }
                });
                hVar.a(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.dismiss();
                        AddNewQuickPaymentActivity addNewQuickPaymentActivity = AddNewQuickPaymentActivity.this;
                        addNewQuickPaymentActivity.a(addNewQuickPaymentActivity.V.getText().toString(), "xyz", z2);
                    }
                });
                hVar.show();
                return;
            }
            a(str, "xyz", z2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.q.setError(getString(R.string.upi_empty_vpa_error));
            return false;
        } else if (str.length() > 255) {
            this.q.setError(getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (str.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            this.q.setError(getString(R.string.upi_invalid_upi));
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, final boolean z2) {
        a((Context) this, getResources().getString(R.string.verifying));
        d.a().a(str2, this.U, this.T, str, (net.one97.paytm.landingpage.c.e) new net.one97.paytm.landingpage.c.e() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                AddNewQuickPaymentActivity.this.a();
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        AddNewQuickPaymentActivity.this.q.setError("You have entered an incorrect UPI ID");
                        return;
                    }
                    String str = (String) baseUpiResponse.getMobileAppData();
                    if (str.toLowerCase().contains("success")) {
                        String substring = str.substring(str.indexOf("=") + 1);
                        if (!TextUtils.isEmpty(substring)) {
                            boolean unused = AddNewQuickPaymentActivity.this.C = true;
                            AddNewQuickPaymentActivity.this.f59911i.setVisibility(0);
                            AddNewQuickPaymentActivity.this.f59906d.setVisibility(8);
                            AddNewQuickPaymentActivity.this.y.setText(substring);
                            if (z2) {
                                AddNewQuickPaymentActivity.this.b();
                                return;
                            }
                            return;
                        }
                        AddNewQuickPaymentActivity.this.q.setError("You have entered an incorrect UPI ID");
                    }
                }
            }

            public final void a() {
                AddNewQuickPaymentActivity.this.a();
                AddNewQuickPaymentActivity.this.q.setError("You have entered an incorrect UPI ID");
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!TextUtils.isEmpty(str) && a.m(this)) {
            a(true);
            d.a().a((Activity) this, str, (net.one97.paytm.landingpage.c.d) new net.one97.paytm.landingpage.c.d() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    AddNewQuickPaymentActivity.this.a(false);
                    AddNewQuickPaymentActivity.a(AddNewQuickPaymentActivity.this, (CJRBankDetails) iJRPaytmDataModel);
                }

                public final void a(NetworkCustomError networkCustomError) {
                    AddNewQuickPaymentActivity.this.a(false);
                    AddNewQuickPaymentActivity.this.b(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            this.F.setVisibility(0);
            this.f59907e.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.F.setVisibility(8);
        this.f59907e.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            this.f59907e.setText(R.string.verified);
            this.j.setVisibility(0);
            this.D = true;
            return;
        }
        this.f59907e.setText(R.string.find_ifsc);
        this.j.setVisibility(8);
        this.D = false;
        this.r.setError(getString(R.string.enter_valid_ifsc));
    }

    /* access modifiers changed from: private */
    public void b() {
        this.J = this.w.getText().toString();
        this.K = this.x.getText().toString();
        if (this.B) {
            this.Q = this.v.getText().toString();
            if (!com.paytm.utility.b.b(this.Q)) {
                this.s.setError(getString(R.string.enter_valid_mobile_number));
                this.v.requestFocus();
                return;
            }
            StandingInstructionList standingInstructionList = new StandingInstructionList();
            if (!TextUtils.isEmpty(this.K)) {
                standingInstructionList.setAmount(this.K);
            }
            standingInstructionList.setType("QUICK_PAYMENTS");
            if (TextUtils.isEmpty(this.J)) {
                standingInstructionList.setReminderDisplayName(this.G);
            } else {
                standingInstructionList.setReminderDisplayName(this.J);
            }
            SupportingData supportingData = new SupportingData();
            standingInstructionList.setSupportingData(supportingData);
            supportingData.setTagName(this.G);
            supportingData.setTagUrl(this.I);
            supportingData.setTagId(this.H);
            supportingData.setPaymentType("personal");
            supportingData.setBeneficiaryMobileNumber(this.Q);
            supportingData.setStoreFrontTitle(this.R);
            a(standingInstructionList, "wallet");
            return;
        }
        this.L = this.y.getText().toString();
        if (!this.A) {
            this.N = this.V.getText().toString();
            this.O = this.u.getText().toString();
            if (!d.a().d(this.N)) {
                this.q.setError(getString(R.string.wallet_account_number_error));
                this.V.requestFocus();
            } else if (!this.D) {
                this.r.setError(getString(R.string.wallet_ifsc_code_error));
                this.u.requestFocus();
            } else {
                StandingInstructionList standingInstructionList2 = new StandingInstructionList();
                if (!TextUtils.isEmpty(this.K)) {
                    standingInstructionList2.setAmount(this.K);
                }
                standingInstructionList2.setType("QUICK_PAYMENTS");
                if (TextUtils.isEmpty(this.J)) {
                    standingInstructionList2.setReminderDisplayName(this.G);
                } else {
                    standingInstructionList2.setReminderDisplayName(this.J);
                }
                SupportingData supportingData2 = new SupportingData();
                standingInstructionList2.setSupportingData(supportingData2);
                supportingData2.setTagName(this.G);
                supportingData2.setTagUrl(this.I);
                supportingData2.setTagId(this.H);
                supportingData2.setPaymentType("personal");
                supportingData2.setBeneficiaryAccountNumber(this.N);
                supportingData2.setBeneficiaryIfscCode(this.O);
                supportingData2.setBeneficiaryName(this.L);
                supportingData2.setBeneficiaryBankName(this.P);
                a(standingInstructionList2, "bank_account");
            }
        } else if (this.C) {
            this.M = this.V.getText().toString();
            StandingInstructionList standingInstructionList3 = new StandingInstructionList();
            if (!TextUtils.isEmpty(this.K)) {
                standingInstructionList3.setAmount(this.K);
            }
            standingInstructionList3.setType("QUICK_PAYMENTS");
            if (TextUtils.isEmpty(this.J)) {
                standingInstructionList3.setReminderDisplayName(this.G);
            } else {
                standingInstructionList3.setReminderDisplayName(this.J);
            }
            SupportingData supportingData3 = new SupportingData();
            standingInstructionList3.setSupportingData(supportingData3);
            supportingData3.setTagName(this.G);
            supportingData3.setTagUrl(this.I);
            supportingData3.setTagId(this.H);
            supportingData3.setPaymentType("personal");
            supportingData3.setBeneficiaryUpiAddress(this.M);
            supportingData3.setBeneficiaryName(this.L);
            a(standingInstructionList3, "vpa");
        } else {
            String obj = this.V.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                a(obj, true);
                return;
            }
            this.q.setError("Please verify UPI ID");
            this.V.requestFocus();
        }
    }

    private void a(final StandingInstructionList standingInstructionList, final String str) {
        String a2 = d.b().a("addQuickPaymentUrl");
        if (URLUtil.isValidUrl(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) this));
            try {
                JSONObject jSONObject = new JSONObject(new com.google.gson.f().b(standingInstructionList));
                a((Context) this, getResources().getString(R.string.loading));
                d.a(this, a2, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AddNewQuickPaymentActivity.this.a();
                        if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                            QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                            if (quickPayAddResponse.getResponseCode() == 200) {
                                standingInstructionList.setId(String.valueOf(quickPayAddResponse.getPayload().getSiId()));
                                net.one97.paytm.quickpay.b.a.a((Context) AddNewQuickPaymentActivity.this, standingInstructionList);
                                net.one97.paytm.quickpay.d.a.a().a(standingInstructionList);
                                AddNewQuickPaymentActivity.a(AddNewQuickPaymentActivity.this, str, quickPayAddResponse.getPayload().getSiId());
                                return;
                            }
                            AddNewQuickPaymentActivity.this.a("Error", quickPayAddResponse.getResponseMessage());
                            return;
                        }
                        AddNewQuickPaymentActivity.this.a("Error", "Something went wrong");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AddNewQuickPaymentActivity.this.a();
                        AddNewQuickPaymentActivity.this.a("Error", "Something went wrong");
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str3)) {
                d.a().a(this, "my_payments", str, str2, str3, (String) null, "/personal-payments/category", "homescreen");
            } else {
                d.a().a(this, "my_payments", str, str2, "/personal-payments/category", "homescreen");
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void f(AddNewQuickPaymentActivity addNewQuickPaymentActivity) {
        addNewQuickPaymentActivity.s.setError((CharSequence) null);
        addNewQuickPaymentActivity.r.setError((CharSequence) null);
        addNewQuickPaymentActivity.q.setError((CharSequence) null);
    }

    static /* synthetic */ void e(AddNewQuickPaymentActivity addNewQuickPaymentActivity, boolean z2) {
        if (z2) {
            addNewQuickPaymentActivity.n.setVisibility(8);
            addNewQuickPaymentActivity.f59906d.setVisibility(0);
            return;
        }
        addNewQuickPaymentActivity.n.setVisibility(0);
        addNewQuickPaymentActivity.f59906d.setVisibility(8);
    }

    static /* synthetic */ void a(AddNewQuickPaymentActivity addNewQuickPaymentActivity, CJRBankDetails cJRBankDetails) {
        if (cJRBankDetails.getStatusCode() == null || !cJRBankDetails.getStatusCode().equalsIgnoreCase("SUCCESS") || cJRBankDetails.getResponse() == null) {
            addNewQuickPaymentActivity.b(false);
            return;
        }
        addNewQuickPaymentActivity.b(true);
        addNewQuickPaymentActivity.r.setVisibility(8);
        addNewQuickPaymentActivity.o.setVisibility(0);
        addNewQuickPaymentActivity.P = cJRBankDetails.getResponse().getBankName();
        addNewQuickPaymentActivity.f59909g.setText(cJRBankDetails.getResponse().getIfscCode());
        addNewQuickPaymentActivity.f59908f.setText(addNewQuickPaymentActivity.P);
    }

    static /* synthetic */ void a(AddNewQuickPaymentActivity addNewQuickPaymentActivity, String str, long j2) {
        addNewQuickPaymentActivity.a("frequent_payment_button_clicked", str, addNewQuickPaymentActivity.G);
        Intent intent = new Intent(addNewQuickPaymentActivity, QuickPaymentResultActivity.class);
        intent.putExtra("pay_mode", str);
        intent.putExtra("si_id", j2);
        intent.putExtra("name", addNewQuickPaymentActivity.G);
        intent.putExtra("tag_url", addNewQuickPaymentActivity.I);
        if (!TextUtils.isEmpty(addNewQuickPaymentActivity.K)) {
            intent.putExtra("amount", addNewQuickPaymentActivity.K);
        }
        if ("bank_account".equalsIgnoreCase(str)) {
            intent.putExtra("holder_name", addNewQuickPaymentActivity.L);
            intent.putExtra(PayUtility.ACCOUNT_NUMBER, addNewQuickPaymentActivity.N);
            intent.putExtra("ifsc_code", addNewQuickPaymentActivity.O);
            intent.putExtra("bannk_name", addNewQuickPaymentActivity.P);
        } else if ("wallet".equalsIgnoreCase(str)) {
            intent.putExtra("mobile_number", addNewQuickPaymentActivity.Q);
        } else if ("vpa".equalsIgnoreCase(str)) {
            intent.putExtra("vpa_address", addNewQuickPaymentActivity.M);
            intent.putExtra("holder_name", addNewQuickPaymentActivity.L);
        }
        addNewQuickPaymentActivity.startActivity(intent);
        addNewQuickPaymentActivity.finish();
    }
}
