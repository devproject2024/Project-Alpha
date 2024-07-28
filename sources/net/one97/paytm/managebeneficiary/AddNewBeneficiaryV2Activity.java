package net.one97.paytm.managebeneficiary;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.managebeneficiary.a;
import net.one97.paytm.upi.util.UpiUtils;

public class AddNewBeneficiaryV2Activity extends BeneficiaryActivity implements View.OnClickListener, a.C0953a {
    private String A = "";
    /* access modifiers changed from: private */
    public b B;
    private boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E = true;
    private CheckBox F;
    /* access modifiers changed from: private */
    public CheckBox G;
    private CheckBox H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    /* access modifiers changed from: private */
    public boolean O;
    /* access modifiers changed from: private */
    public TableRow P;
    /* access modifiers changed from: private */
    public String Q;
    private RadioGroup.OnCheckedChangeListener R = new RadioGroup.OnCheckedChangeListener() {
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R.id.bene_paytm_rb) {
                AddNewBeneficiaryV2Activity.this.u.setTypeface(Typeface.DEFAULT_BOLD);
                AddNewBeneficiaryV2Activity.this.t.setTypeface(Typeface.DEFAULT);
                e.a(AddNewBeneficiaryV2Activity.this, "beneficiary_wallet", "pb_mb_paytm_wallet", "/beneficiary/wallet/add_new");
                AddNewBeneficiaryV2Activity.this.v.setVisibility(8);
                AddNewBeneficiaryV2Activity.this.w.setVisibility(0);
                return;
            }
            AddNewBeneficiaryV2Activity.this.u.setTypeface(Typeface.DEFAULT);
            AddNewBeneficiaryV2Activity.this.t.setTypeface(Typeface.DEFAULT_BOLD);
            e.a(AddNewBeneficiaryV2Activity.this, "beneficiary_wallet", "bank_account", "/beneficiary/wallet/add_new");
            AddNewBeneficiaryV2Activity.this.w.setVisibility(8);
            AddNewBeneficiaryV2Activity.this.v.setVisibility(0);
        }
    };
    private TextWatcher S = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AddNewBeneficiaryV2Activity.this.l.setError((CharSequence) null);
            AddNewBeneficiaryV2Activity.this.j.setError((CharSequence) null);
            AddNewBeneficiaryV2Activity.this.f53198i.setError((CharSequence) null);
            AddNewBeneficiaryV2Activity.this.l.setErrorEnabled(false);
            AddNewBeneficiaryV2Activity.this.j.setErrorEnabled(false);
            AddNewBeneficiaryV2Activity.this.f53198i.setErrorEnabled(false);
        }
    };
    /* access modifiers changed from: private */
    public c T = new c() {
        public final void a(CJRAddBeneficiary cJRAddBeneficiary) {
            if (cJRAddBeneficiary == null) {
                AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity = AddNewBeneficiaryV2Activity.this;
                b.a((Context) addNewBeneficiaryV2Activity, addNewBeneficiaryV2Activity.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
            } else if (cJRAddBeneficiary.getError() != null) {
                if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                    AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity2 = AddNewBeneficiaryV2Activity.this;
                    b.a((Context) addNewBeneficiaryV2Activity2, addNewBeneficiaryV2Activity2.getString(R.string.pb_mb_error), cJRAddBeneficiary.getError().getErrorMsg());
                    return;
                }
                AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity3 = AddNewBeneficiaryV2Activity.this;
                b.a((Context) addNewBeneficiaryV2Activity3, addNewBeneficiaryV2Activity3.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
            } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                String string = AddNewBeneficiaryV2Activity.this.getString(R.string.pb_mb_add_success_msg);
                AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity4 = AddNewBeneficiaryV2Activity.this;
                e.a(addNewBeneficiaryV2Activity4, string, addNewBeneficiaryV2Activity4.Q);
            }
        }
    };
    private TextWatcher U = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AddNewBeneficiaryV2Activity.this.k.setError((CharSequence) null);
            AddNewBeneficiaryV2Activity.this.k.setErrorEnabled(false);
        }

        public final void afterTextChanged(Editable editable) {
            String obj = AddNewBeneficiaryV2Activity.this.o.getText().toString();
            boolean unused = AddNewBeneficiaryV2Activity.this.x = false;
            AddNewBeneficiaryV2Activity.this.r.setVisibility(8);
            if (TextUtils.isEmpty(obj) || obj.length() != 11) {
                AddNewBeneficiaryV2Activity.this.f53192c.setText(R.string.pb_mb_find_ifsc);
                return;
            }
            AddNewBeneficiaryV2Activity.this.f53192c.setText(R.string.verify);
            AddNewBeneficiaryV2Activity.this.b(obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f53191a = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (AddNewBeneficiaryV2Activity.this.B == null) {
                    return;
                }
                if (AddNewBeneficiaryV2Activity.this.s.getCheckedRadioButtonId() == R.id.bene_paytm_rb) {
                    AddNewBeneficiaryV2Activity.this.c();
                } else {
                    AddNewBeneficiaryV2Activity.this.b();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f53192c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f53193d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f53194e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f53195f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f53196g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f53197h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextInputLayout f53198i;
    /* access modifiers changed from: private */
    public TextInputLayout j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    /* access modifiers changed from: private */
    public TextInputLayout l;
    private AppCompatEditText m;
    private AppCompatEditText n;
    /* access modifiers changed from: private */
    public AppCompatEditText o;
    private AppCompatEditText p;
    private ProgressBar q;
    /* access modifiers changed from: private */
    public ImageView r;
    /* access modifiers changed from: private */
    public RadioGroup s;
    /* access modifiers changed from: private */
    public RadioButton t;
    /* access modifiers changed from: private */
    public RadioButton u;
    /* access modifiers changed from: private */
    public LinearLayout v;
    /* access modifiers changed from: private */
    public LinearLayout w;
    /* access modifiers changed from: private */
    public boolean x;
    private boolean y;
    private boolean z;

    public final void a(boolean z2) {
        this.m.setVisibility(0);
        this.z = z2;
        if (this.z) {
            b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_new_beneficiary_v2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        findViewById(R.id.bene_back_arrow_iv).setOnClickListener(this);
        this.s = (RadioGroup) findViewById(R.id.bene_select_rg);
        this.s.setOnCheckedChangeListener(this.R);
        this.t = (RadioButton) findViewById(R.id.bene_account_rb);
        this.u = (RadioButton) findViewById(R.id.bene_paytm_rb);
        this.v = (LinearLayout) findViewById(R.id.bene_bank_ll);
        this.w = (LinearLayout) findViewById(R.id.bene_wallet_ll);
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.f53198i = (TextInputLayout) findViewById(R.id.layout_account_number);
        this.m = (AppCompatEditText) findViewById(R.id.edit_account_number);
        this.m.addTextChangedListener(this.S);
        this.j = (TextInputLayout) findViewById(R.id.layout_account_holder_name);
        this.n = (AppCompatEditText) findViewById(R.id.edit_account_holeder_name);
        this.n.addTextChangedListener(this.S);
        this.k = (TextInputLayout) findViewById(R.id.layout_ifsc_code);
        this.o = (AppCompatEditText) findViewById(R.id.edit_ifsc_code);
        this.o.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        this.o.addTextChangedListener(this.U);
        this.q = (ProgressBar) findViewById(R.id.beneficiary_ifsc_progress);
        this.r = (ImageView) findViewById(R.id.ifsc_verified_image);
        this.f53192c = (TextView) findViewById(R.id.tv_find_ifsc_code);
        this.f53192c.setOnClickListener(this);
        this.l = (TextInputLayout) findViewById(R.id.layout_mobile_number);
        this.p = (AppCompatEditText) findViewById(R.id.edit_mobile_number);
        this.p.addTextChangedListener(this.S);
        this.P = (TableRow) findViewById(R.id.bank_bank_layout);
        this.P.setVisibility(8);
        this.F = (CheckBox) findViewById(R.id.bank_bank_cb);
        this.G = (CheckBox) findViewById(R.id.bank_wallet_cb);
        this.H = (CheckBox) findViewById(R.id.wallet_wallet_cb);
        this.H.setChecked(true);
        this.f53195f = (TextView) findViewById(R.id.bene_bank_bank_setting_tv);
        this.f53195f.setOnClickListener(this);
        this.f53195f.setEnabled(false);
        this.f53196g = (TextView) findViewById(R.id.bene_bank_wallet_setting_tv);
        this.f53196g.setOnClickListener(this);
        this.f53196g.setEnabled(false);
        this.f53197h = (TextView) findViewById(R.id.bene_wallet_wallet_setting_tv);
        this.f53197h.setOnClickListener(this);
        this.f53193d = (TextView) findViewById(R.id.bene_bank_add_tv);
        this.f53193d.setOnClickListener(this);
        this.f53194e = (TextView) findViewById(R.id.bene_wallet_add_tv);
        this.f53194e.setOnClickListener(this);
        if (f.a().getBoolean("needToShowAdvanceSetting", false)) {
            this.f53195f.setVisibility(0);
            this.f53196g.setVisibility(0);
            this.f53197h.setVisibility(0);
        } else {
            this.f53195f.setVisibility(8);
            this.f53196g.setVisibility(8);
            this.f53197h.setVisibility(8);
        }
        if (getIntent() != null && getIntent().hasExtra("mobileNumber")) {
            String stringExtra = getIntent().getStringExtra("mobileNumber");
            if (!TextUtils.isEmpty(getIntent().getStringExtra("mobileNumber"))) {
                this.p.setText(stringExtra);
                this.u.setChecked(true);
            }
        }
        if (getIntent() != null && getIntent().hasExtra("from_p2p")) {
            this.Q = getIntent().getStringExtra("from_p2p");
        }
        f.a().getBankAccStatus(this, new net.one97.paytm.managebeneficiary.a.a() {
            public final void a(int i2) {
                if (i2 == 3) {
                    boolean unused = AddNewBeneficiaryV2Activity.this.O = true;
                    AddNewBeneficiaryV2Activity.this.P.setVisibility(0);
                    return;
                }
                AddNewBeneficiaryV2Activity.this.P.setVisibility(8);
                boolean unused2 = AddNewBeneficiaryV2Activity.this.D = true;
                AddNewBeneficiaryV2Activity.this.G.setChecked(true);
                AddNewBeneficiaryV2Activity.this.f53196g.setEnabled(true);
                AddNewBeneficiaryV2Activity.this.f53196g.setTextColor(AddNewBeneficiaryV2Activity.this.getResources().getColor(R.color.color_00b9f5));
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001) {
            if (intent == null || TextUtils.isEmpty(intent.getStringExtra("intent_extra_ifsc_code"))) {
                c(false);
                return;
            }
            this.o.setText(intent.getStringExtra("intent_extra_ifsc_code"));
            c(true);
            this.A = intent.getStringExtra("intent_extra_bank_name");
        } else if (i2 == 2012 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i3 == -1 && i2 == 101) {
            String stringExtra = intent.getStringExtra("which_setting");
            if ("bank_bank_setting".equals(stringExtra)) {
                if (intent.hasExtra("transfer_limit")) {
                    this.I = intent.getStringExtra("transfer_limit");
                }
                if (intent.hasExtra("max_no_transac")) {
                    this.L = intent.getStringExtra("max_no_transac");
                }
            } else if ("bank_wallet_setting".equals(stringExtra)) {
                if (intent.hasExtra("transfer_limit")) {
                    this.J = intent.getStringExtra("transfer_limit");
                }
                if (intent.hasExtra("max_no_transac")) {
                    this.M = intent.getStringExtra("max_no_transac");
                }
            } else if ("wallet_wallet_setting".equals(stringExtra)) {
                if (intent.hasExtra("transfer_limit")) {
                    this.K = intent.getStringExtra("transfer_limit");
                }
                if (intent.hasExtra("max_no_transac")) {
                    this.N = intent.getStringExtra("max_no_transac");
                }
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bene_back_arrow_iv) {
            onBackPressed();
        } else if (id == R.id.tv_find_ifsc_code) {
            if (this.f53192c.getText().toString().equalsIgnoreCase(getResources().getString(R.string.verify))) {
                b(this.o.getText().toString());
            } else if (this.f53192c.getText().toString().equalsIgnoreCase(getResources().getString(R.string.pb_mb_find_ifsc))) {
                startActivityForResult(f.a().getIfscConfirmActivity(this), 1001);
            }
        } else if (id == R.id.bene_bank_bank_setting_tv) {
            a("bank_bank_setting");
        } else if (id == R.id.bene_bank_wallet_setting_tv) {
            a("bank_wallet_setting");
        } else if (id == R.id.bene_wallet_wallet_setting_tv) {
            a("wallet_wallet_setting");
        } else if (id == R.id.bene_bank_add_tv) {
            this.z = false;
            a(view);
        } else if (id == R.id.bene_wallet_add_tv) {
            a(view);
        }
    }

    private void a(View view) {
        if (view.getId() == R.id.bene_bank_add_tv) {
            if (!d()) {
                this.f53198i.setError(getString(R.string.pb_mb_enter_valid_account_number));
                this.m.requestFocus();
            } else if (!e()) {
                this.j.setError(getString(R.string.pb_mb_enter_valid_account_holder_name));
                this.n.requestFocus();
            } else if (!f()) {
                this.k.setError(getString(R.string.pb_mb_enter_valid_ifsc));
                this.o.requestFocus();
            } else if ("PYTM0123456".equalsIgnoreCase(this.o.getText().toString()) && !TextUtils.isEmpty(this.m.getText().toString()) && this.m.getText().toString().trim().length() < 12) {
                this.f53198i.setError(getString(R.string.pb_mb_money_transfer_paytm_ifsc_check));
                this.m.requestFocus();
            } else if (!this.C && !this.D) {
                Toast.makeText(this, "Please check at least one checkbox", 0).show();
            } else if (this.x) {
                b();
            } else {
                this.y = true;
                b(this.o.getText().toString());
            }
        } else if (b.b(this.p.getText().toString())) {
            c();
        } else {
            this.l.setError(getString(R.string.pb_mb_enter_valid_mobile_number));
            this.p.requestFocus();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.F.isChecked()) {
            this.C = true;
            this.f53195f.setTextColor(getResources().getColor(R.color.color_00b9f5));
            this.f53195f.setEnabled(true);
        }
        if (this.G.isChecked()) {
            this.D = true;
            this.f53196g.setTextColor(getResources().getColor(R.color.color_00b9f5));
            this.f53196g.setEnabled(true);
        }
        if (this.H.isChecked()) {
            this.E = true;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();
        int id = view.getId();
        if (id == R.id.bank_bank_cb) {
            if (isChecked) {
                this.C = true;
                this.f53195f.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53195f.setEnabled(true);
                return;
            }
            this.C = false;
            this.f53195f.setTextColor(getResources().getColor(R.color.color_909090));
            this.f53195f.setEnabled(false);
        } else if (id == R.id.bank_wallet_cb) {
            if (!this.O) {
                this.D = true;
                this.f53196g.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53196g.setEnabled(true);
                this.G.setChecked(true);
            } else if (isChecked) {
                this.D = true;
                this.f53196g.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53196g.setEnabled(true);
            } else {
                this.D = false;
                this.f53196g.setTextColor(getResources().getColor(R.color.color_909090));
                this.f53196g.setEnabled(false);
            }
        } else if (id == R.id.wallet_wallet_cb) {
            this.E = true;
            this.H.setChecked(true);
        }
    }

    private void a(String str) {
        Intent intent = new Intent(this, AdvanceSettingBeneficiaryActivity.class);
        intent.putExtra("which_setting", str);
        if ("bank_bank_setting".equals(str)) {
            intent.putExtra("transfer_limit", this.I);
            intent.putExtra("max_no_transac", this.L);
        } else if ("bank_wallet_setting".equals(str)) {
            intent.putExtra("transfer_limit", this.J);
            intent.putExtra("max_no_transac", this.M);
        } else if ("wallet_wallet_setting".equals(str)) {
            intent.putExtra("transfer_limit", this.K);
            intent.putExtra("max_no_transac", this.N);
        }
        startActivityForResult(intent, 101);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b.c((Context) this)) {
            b(true);
            f.a().initIfscHelper(this, str, new net.one97.paytm.managebeneficiary.a.b() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    AddNewBeneficiaryV2Activity.this.b(false);
                    AddNewBeneficiaryV2Activity.a(AddNewBeneficiaryV2Activity.this, (CJRBankDetails) iJRPaytmDataModel);
                }

                public final void a() {
                    AddNewBeneficiaryV2Activity.this.b(false);
                    AddNewBeneficiaryV2Activity.this.c(false);
                }
            });
            return;
        }
        b(false);
        a(this, getString(R.string.no_internet));
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            this.q.setVisibility(0);
            this.f53192c.setVisibility(8);
            this.r.setVisibility(8);
            return;
        }
        this.q.setVisibility(8);
        this.f53192c.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (z2) {
            this.f53192c.setText(R.string.pb_mb_verified);
            this.r.setVisibility(0);
            this.x = true;
            return;
        }
        this.f53192c.setText(R.string.pb_mb_find_ifsc);
        this.r.setVisibility(8);
        this.x = false;
        this.k.setError(getString(R.string.pb_mb_enter_valid_ifsc));
    }

    /* access modifiers changed from: private */
    public void b() {
        ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList;
        BeneficiaryEntity.OtherBank otherBank;
        BeneficiaryEntity.InstrumentPreferences instrumentPreferences;
        BeneficiaryEntity beneficiaryEntity;
        String obj = this.m.getText().toString();
        String obj2 = this.o.getText().toString();
        String obj3 = this.n.getText().toString();
        if (!this.z) {
            a(obj, obj3, obj2);
        } else if (b.c((Context) this)) {
            a(this, getString(R.string.pb_mb_resending_otp));
            BeneficiaryEntity beneficiaryEntity2 = new BeneficiaryEntity();
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences2 = new BeneficiaryEntity.InstrumentPreferences();
            BeneficiaryEntity.OtherBank otherBank2 = new BeneficiaryEntity.OtherBank();
            ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList2 = new ArrayList<>();
            BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
            BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
            source.upi = "DISABLED";
            if (this.D) {
                source.wallet = "ENABLED";
            } else {
                source.wallet = "DISABLED";
            }
            if (this.C) {
                source.oba = "ENABLED";
            } else {
                source.oba = "DISABLED";
            }
            ArrayList<BeneficiaryEntity.Limit> arrayList3 = new ArrayList<>();
            if (f.a().getBoolean("needToShowAdvanceSetting", false)) {
                beneficiaryEntity = beneficiaryEntity2;
                if (this.C) {
                    instrumentPreferences = instrumentPreferences2;
                    if (!TextUtils.isEmpty(this.I)) {
                        BeneficiaryEntity.Limit limit = new BeneficiaryEntity.Limit();
                        limit.ruleId = "LIMITS-2";
                        otherBank = otherBank2;
                        BeneficiaryEntity.RuleParam ruleParam = new BeneficiaryEntity.RuleParam();
                        arrayList = arrayList2;
                        ruleParam.amount = this.I;
                        ruleParam.source = "oba";
                        ruleParam.duration = "1";
                        ruleParam.durationUnit = "MONTH";
                        limit.ruleParams = ruleParam;
                        arrayList3.add(limit);
                    } else {
                        otherBank = otherBank2;
                        arrayList = arrayList2;
                    }
                    if (!TextUtils.isEmpty(this.L)) {
                        BeneficiaryEntity.Limit limit2 = new BeneficiaryEntity.Limit();
                        limit2.ruleId = "LIMITS-1";
                        BeneficiaryEntity.RuleParam ruleParam2 = new BeneficiaryEntity.RuleParam();
                        ruleParam2.txn = this.L;
                        ruleParam2.source = "oba";
                        ruleParam2.duration = "1";
                        ruleParam2.durationUnit = "MONTH";
                        limit2.ruleParams = ruleParam2;
                        arrayList3.add(limit2);
                    }
                } else {
                    instrumentPreferences = instrumentPreferences2;
                    otherBank = otherBank2;
                    arrayList = arrayList2;
                }
                if (this.D) {
                    if (!TextUtils.isEmpty(this.J)) {
                        BeneficiaryEntity.Limit limit3 = new BeneficiaryEntity.Limit();
                        limit3.ruleId = "LIMITS-2";
                        BeneficiaryEntity.RuleParam ruleParam3 = new BeneficiaryEntity.RuleParam();
                        ruleParam3.amount = this.J;
                        ruleParam3.source = "wallet";
                        ruleParam3.duration = "1";
                        ruleParam3.durationUnit = "MONTH";
                        limit3.ruleParams = ruleParam3;
                        arrayList3.add(limit3);
                    }
                    if (!TextUtils.isEmpty(this.M)) {
                        BeneficiaryEntity.Limit limit4 = new BeneficiaryEntity.Limit();
                        limit4.ruleId = "LIMITS-1";
                        BeneficiaryEntity.RuleParam ruleParam4 = new BeneficiaryEntity.RuleParam();
                        ruleParam4.txn = this.M;
                        ruleParam4.source = "wallet";
                        ruleParam4.duration = "1";
                        ruleParam4.durationUnit = "MONTH";
                        limit4.ruleParams = ruleParam4;
                        arrayList3.add(limit4);
                    }
                }
            } else {
                beneficiaryEntity = beneficiaryEntity2;
                instrumentPreferences = instrumentPreferences2;
                otherBank = otherBank2;
                arrayList = arrayList2;
            }
            BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
            otherBankAccountDetail.accountNumber = obj;
            otherBankAccountDetail.accountHolderName = obj3;
            otherBankAccountDetail.ifscCode = obj2;
            otherBankAccountDetail.bankName = this.A;
            otherBankAccount.source = source;
            if (f.a().getBoolean("needToShowAdvanceSetting", false)) {
                otherBankAccount.limits = arrayList3;
            }
            otherBankAccount.accountDetail = otherBankAccountDetail;
            ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList4 = arrayList;
            arrayList4.add(otherBankAccount);
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences3 = instrumentPreferences;
            instrumentPreferences3.otherBank = otherBank;
            instrumentPreferences3.otherBank.accounts = arrayList4;
            BeneficiaryEntity beneficiaryEntity3 = beneficiaryEntity;
            beneficiaryEntity3.instrumentPreferences = instrumentPreferences3;
            h.a(this, beneficiaryEntity3, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    AddNewBeneficiaryV2Activity.this.a();
                    CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                    if (cJRAddBeneficiary.getError() != null) {
                        if (AddNewBeneficiaryV2Activity.this.B != null) {
                            AddNewBeneficiaryV2Activity.this.B.dismiss();
                        }
                        if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                            g a2 = f.a();
                            AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity = AddNewBeneficiaryV2Activity.this;
                            a2.showAlertForBeneficiary(addNewBeneficiaryV2Activity, addNewBeneficiaryV2Activity.getString(R.string.pb_mb_error), cJRAddBeneficiary.getError().getErrorMsg());
                            return;
                        }
                        g a3 = f.a();
                        AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity2 = AddNewBeneficiaryV2Activity.this;
                        a3.showAlertForBeneficiary(addNewBeneficiaryV2Activity2, addNewBeneficiaryV2Activity2.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                    } else if ("1".equalsIgnoreCase(cJRAddBeneficiary.getAskOTP())) {
                        if (AddNewBeneficiaryV2Activity.this.B == null || !AddNewBeneficiaryV2Activity.this.B.isShowing()) {
                            AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity3 = AddNewBeneficiaryV2Activity.this;
                            b unused = addNewBeneficiaryV2Activity3.B = new b(addNewBeneficiaryV2Activity3, cJRAddBeneficiary.getReferenceNumber(), AddNewBeneficiaryV2Activity.this.f53191a, AddNewBeneficiaryV2Activity.this.T);
                            AddNewBeneficiaryV2Activity.this.B.show();
                            return;
                        }
                        AddNewBeneficiaryV2Activity.this.B.f53257a = cJRAddBeneficiary.getReferenceNumber();
                    } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        String beneficiaryAddSuccessMsg = f.a().getBeneficiaryAddSuccessMsg(AddNewBeneficiaryV2Activity.this);
                        AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity4 = AddNewBeneficiaryV2Activity.this;
                        e.a(addNewBeneficiaryV2Activity4, beneficiaryAddSuccessMsg, addNewBeneficiaryV2Activity4.Q);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AddNewBeneficiaryV2Activity.this.a();
                    g a2 = f.a();
                    AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity = AddNewBeneficiaryV2Activity.this;
                    a2.showAlertForBeneficiary(addNewBeneficiaryV2Activity, addNewBeneficiaryV2Activity.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                }
            });
        } else {
            a(this, getString(R.string.no_internet));
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        String obj = this.p.getText().toString();
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_mb_resending_otp));
            BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
            BeneficiaryEntity.Wallet wallet = new BeneficiaryEntity.Wallet();
            ArrayList<BeneficiaryEntity.WalletAccount> arrayList = new ArrayList<>();
            BeneficiaryEntity.WalletAccount walletAccount = new BeneficiaryEntity.WalletAccount();
            BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
            source.upi = "disabled";
            source.wallet = "enabled";
            source.oba = "disabled";
            ArrayList<BeneficiaryEntity.Limit> arrayList2 = new ArrayList<>();
            if (this.E && f.a().getBoolean("needToShowAdvanceSetting", false)) {
                if (!TextUtils.isEmpty(this.K)) {
                    BeneficiaryEntity.Limit limit = new BeneficiaryEntity.Limit();
                    limit.ruleId = "LIMITS-2";
                    BeneficiaryEntity.RuleParam ruleParam = new BeneficiaryEntity.RuleParam();
                    ruleParam.amount = this.K;
                    ruleParam.source = "wallet";
                    ruleParam.duration = "1";
                    ruleParam.durationUnit = "MONTH";
                    limit.ruleParams = ruleParam;
                    arrayList2.add(limit);
                }
                if (!TextUtils.isEmpty(this.N)) {
                    BeneficiaryEntity.Limit limit2 = new BeneficiaryEntity.Limit();
                    limit2.ruleId = "LIMITS-1";
                    BeneficiaryEntity.RuleParam ruleParam2 = new BeneficiaryEntity.RuleParam();
                    ruleParam2.txn = this.N;
                    ruleParam2.source = "wallet";
                    ruleParam2.duration = "1";
                    ruleParam2.durationUnit = "MONTH";
                    limit2.ruleParams = ruleParam2;
                    arrayList2.add(limit2);
                }
            }
            BeneficiaryEntity.WalletAccountDetail walletAccountDetail = new BeneficiaryEntity.WalletAccountDetail();
            walletAccountDetail.beneficiaryPhone = obj;
            walletAccount.source = source;
            if (f.a().getBoolean("needToShowAdvanceSetting", false)) {
                walletAccount.limits = arrayList2;
            }
            walletAccount.accountDetail = walletAccountDetail;
            arrayList.add(walletAccount);
            instrumentPreferences.wallet = wallet;
            instrumentPreferences.wallet.accounts = arrayList;
            beneficiaryEntity.instrumentPreferences = instrumentPreferences;
            h.a(this, beneficiaryEntity, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    AddNewBeneficiaryV2Activity.this.a();
                    CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                    if (cJRAddBeneficiary.getError() != null) {
                        if (AddNewBeneficiaryV2Activity.this.B != null) {
                            AddNewBeneficiaryV2Activity.this.B.dismiss();
                        }
                        if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                            g a2 = f.a();
                            AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity = AddNewBeneficiaryV2Activity.this;
                            a2.showAlertForBeneficiary(addNewBeneficiaryV2Activity, addNewBeneficiaryV2Activity.getString(R.string.pb_mb_error), cJRAddBeneficiary.getError().getErrorMsg());
                            return;
                        }
                        g a3 = f.a();
                        AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity2 = AddNewBeneficiaryV2Activity.this;
                        a3.showAlertForBeneficiary(addNewBeneficiaryV2Activity2, addNewBeneficiaryV2Activity2.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                    } else if ("1".equalsIgnoreCase(cJRAddBeneficiary.getAskOTP())) {
                        if (AddNewBeneficiaryV2Activity.this.B == null || !AddNewBeneficiaryV2Activity.this.B.isShowing()) {
                            AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity3 = AddNewBeneficiaryV2Activity.this;
                            b unused = addNewBeneficiaryV2Activity3.B = new b(addNewBeneficiaryV2Activity3, cJRAddBeneficiary.getReferenceNumber(), AddNewBeneficiaryV2Activity.this.f53191a, AddNewBeneficiaryV2Activity.this.T);
                            AddNewBeneficiaryV2Activity.this.B.show();
                            return;
                        }
                        AddNewBeneficiaryV2Activity.this.B.f53257a = cJRAddBeneficiary.getReferenceNumber();
                    } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        String beneficiaryAddSuccessMsg = f.a().getBeneficiaryAddSuccessMsg(AddNewBeneficiaryV2Activity.this);
                        AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity4 = AddNewBeneficiaryV2Activity.this;
                        e.a(addNewBeneficiaryV2Activity4, beneficiaryAddSuccessMsg, addNewBeneficiaryV2Activity4.Q);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AddNewBeneficiaryV2Activity.this.a();
                    if (networkCustomError != null) {
                        try {
                            if (TextUtils.isEmpty(networkCustomError.getMessage()) || (!networkCustomError.getMessage().equalsIgnoreCase("410") && !networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                                b.b((Context) AddNewBeneficiaryV2Activity.this, AddNewBeneficiaryV2Activity.this.getString(R.string.pb_mb_error), AddNewBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                            } else {
                                f.a().handleError(AddNewBeneficiaryV2Activity.this, networkCustomError, (String) null, (Bundle) null, false);
                            }
                        } catch (Resources.NotFoundException e2) {
                            if (b.v) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            if (b.v) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            });
            return;
        }
        a(this, getString(R.string.no_internet));
    }

    private void a(String str, String str2, String str3) {
        this.m.setVisibility(8);
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
        bundle.putString("accountHolderName", str2);
        bundle.putString("bankName", this.A);
        bundle.putString("ifsc", str3);
        aVar.setArguments(bundle);
        aVar.setCancelable(false);
        aVar.show(getSupportFragmentManager(), "add_benef_bottom_sheet");
    }

    private boolean d() {
        String obj = this.m.getText().toString();
        return !TextUtils.isEmpty(obj) && obj.length() > 8 && obj.length() < 19;
    }

    private boolean e() {
        return !TextUtils.isEmpty(this.n.getText().toString());
    }

    private boolean f() {
        String obj = this.o.getText().toString();
        return !TextUtils.isEmpty(obj) && obj.length() == 11;
    }

    static /* synthetic */ void a(AddNewBeneficiaryV2Activity addNewBeneficiaryV2Activity, CJRBankDetails cJRBankDetails) {
        if (cJRBankDetails.getStatusCode() == null || !cJRBankDetails.getStatusCode().equalsIgnoreCase("SUCCESS") || cJRBankDetails.getResponse() == null) {
            addNewBeneficiaryV2Activity.c(false);
            return;
        }
        addNewBeneficiaryV2Activity.c(true);
        addNewBeneficiaryV2Activity.A = cJRBankDetails.getResponse().getBankName();
        if (addNewBeneficiaryV2Activity.y) {
            addNewBeneficiaryV2Activity.b();
            addNewBeneficiaryV2Activity.y = false;
        }
    }
}
