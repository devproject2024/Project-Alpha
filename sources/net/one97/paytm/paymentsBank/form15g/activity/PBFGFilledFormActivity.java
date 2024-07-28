package net.one97.paytm.paymentsBank.form15g.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.a.a;
import net.one97.paytm.paymentsBank.form15g.a.c;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.form15g.model.Form15ghModel;
import net.one97.paytm.paymentsBank.form15g.model.SubmitForm15ghModel;
import net.one97.paytm.paymentsBank.fragment.k;
import net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.utils.j;

public class PBFGFilledFormActivity extends PaytmActivity implements g.a, g.b<IJRPaytmDataModel> {
    private String A;
    private boolean B;
    private boolean C;
    private TextView D;

    /* renamed from: a  reason: collision with root package name */
    EditText f18406a;

    /* renamed from: b  reason: collision with root package name */
    EditText f18407b;

    /* renamed from: c  reason: collision with root package name */
    CustomAmountTextInputEditText f18408c;

    /* renamed from: d  reason: collision with root package name */
    CustomAmountTextInputEditText f18409d;

    /* renamed from: e  reason: collision with root package name */
    TextWatcher f18410e = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable.toString()) && Integer.parseInt(editable.toString()) == 0) {
                PBFGFilledFormActivity.this.w.setError(PBFGFilledFormActivity.this.getString(R.string.pb_fg_form_no_cant_zero));
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PBFGFilledFormActivity.this.w.setError((CharSequence) null);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    TextWatcher f18411f = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            String replaceAll = editable.toString().replaceAll(AppConstants.COMMA, "");
            if (!TextUtils.isEmpty(replaceAll) && replaceAll.length() > 0) {
                double parseDouble = Double.parseDouble(replaceAll);
                if (parseDouble > PBFGFilledFormActivity.this.f18413h.getResponse().getExemptLimit()) {
                    PBFGFilledFormActivity.this.v.setError(PBFGFilledFormActivity.this.getString(R.string.pb_fg_total_inc_gt_exmpt_error, new Object[]{b.b(Double.valueOf(PBFGFilledFormActivity.this.f18413h.getResponse().getExemptLimit()))}));
                } else if (parseDouble < PBFGFilledFormActivity.this.f18413h.getResponse().getInterestProjection()) {
                    PBFGFilledFormActivity.this.v.setError(PBFGFilledFormActivity.this.getString(R.string.pb_fg_total_inc_les_error, new Object[]{b.b(Double.valueOf(PBFGFilledFormActivity.this.f18413h.getResponse().getInterestProjection()))}));
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PBFGFilledFormActivity.this.v.setError((CharSequence) null);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    TextWatcher f18412g = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            if (TextUtils.isEmpty(PBFGFilledFormActivity.this.f18408c.getText().toString())) {
                str = "0";
            } else {
                str = PBFGFilledFormActivity.this.f18408c.getNormalText();
            }
            String replaceAll = editable.toString().replaceAll(AppConstants.COMMA, "");
            if (!TextUtils.isEmpty(replaceAll) && replaceAll.length() > 0) {
                if (Double.parseDouble(replaceAll) > PBFGFilledFormActivity.this.f18413h.getResponse().getExemptLimit()) {
                    PBFGFilledFormActivity.this.x.setError(PBFGFilledFormActivity.this.getString(R.string.pb_fg_total_amt_shdnt_gt_ex, new Object[]{PBFGFilledFormActivity.this.f18413h.getResponse().getFormType(), b.b(Double.valueOf(PBFGFilledFormActivity.this.f18413h.getResponse().getExemptLimit()))}));
                } else if (Double.parseDouble(replaceAll) + PBFGFilledFormActivity.this.f18413h.getResponse().getInterestProjection() > Double.parseDouble(str)) {
                    PBFGFilledFormActivity.this.x.setError(PBFGFilledFormActivity.this.getString(R.string.pb_fg_total_amt_plus_fd_error, new Object[]{PBFGFilledFormActivity.this.f18413h.getResponse().getFormType(), b.T(str)}));
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PBFGFilledFormActivity.this.x.setError((CharSequence) null);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Form15ghModel f18413h;

    /* renamed from: i  reason: collision with root package name */
    private FGHStatusModel f18414i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private RadioButton n;
    private RadioButton o;
    private RadioButton p;
    private RadioGroup q;
    private RadioGroup r;
    private TextView s;
    private EditText t;
    private Button u;
    /* access modifiers changed from: private */
    public TextInputLayout v;
    /* access modifiers changed from: private */
    public TextInputLayout w;
    /* access modifiers changed from: private */
    public TextInputLayout x;
    private TextInputLayout y;
    private String z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        b.p();
        if (iJRPaytmDataModel instanceof SubmitForm15ghModel) {
            SubmitForm15ghModel submitForm15ghModel = (SubmitForm15ghModel) iJRPaytmDataModel;
            if (submitForm15ghModel.getResponse() != null && !TextUtils.isEmpty(submitForm15ghModel.getResponse().getErrorMessage())) {
                b.b((Context) this, getString(R.string.error), submitForm15ghModel.getResponse().getErrorMessage());
            } else if (!TextUtils.isEmpty(submitForm15ghModel.getMessage()) && submitForm15ghModel.getMessage().equalsIgnoreCase("PRODUCT_INITIATED")) {
                startActivity(new Intent(this, PBFGTackingActivity.class));
                finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_fg_filled_form_activity);
        this.s = (TextView) findViewById(R.id.tv_form_name);
        this.D = (TextView) findViewById(R.id.tv_financial_year);
        this.j = (TextView) findViewById(R.id.tv_fullname);
        this.k = (TextView) findViewById(R.id.tv_pancard_number);
        this.n = (RadioButton) findViewById(R.id.rb_taxAbleYes);
        findViewById(R.id.rb_taxAbleNo);
        this.o = (RadioButton) findViewById(R.id.rb_Yes_filed_form15g);
        this.p = (RadioButton) findViewById(R.id.rb_No_filed_form15g);
        this.f18406a = (EditText) findViewById(R.id.et_estimated_income_fd);
        this.f18408c = (CustomAmountTextInputEditText) findViewById(R.id.et_total_income_fd);
        this.t = (EditText) findViewById(R.id.et_no_of_form_filled);
        this.f18409d = (CustomAmountTextInputEditText) findViewById(R.id.et_total_amt_form15g_filled);
        this.q = (RadioGroup) findViewById(R.id.radioGroupTaxable);
        this.r = (RadioGroup) findViewById(R.id.radioGroup_filed_form);
        this.u = (Button) findViewById(R.id.btn_submit);
        findViewById(R.id.textInputLayout1);
        this.v = (TextInputLayout) findViewById(R.id.textInputLayout2);
        this.w = (TextInputLayout) findViewById(R.id.textInputLayout3);
        this.x = (TextInputLayout) findViewById(R.id.textInputLayout4);
        this.l = (TextView) findViewById(R.id.tv_form15G_filed_for_current_f_year);
        this.f18407b = (EditText) findViewById(R.id.et_latest_year_of_ITR);
        this.y = (TextInputLayout) findViewById(R.id.textInputLayout_latest_year_of_ITR);
        this.m = (TextView) findViewById(R.id.tv_latest_year_of_itr_filing);
        this.f18408c.setPrefix("");
        this.f18408c.setMaxDigitsBeforeDecimalPoint(11);
        this.f18409d.setPrefix("");
        this.f18409d.setMaxDigitsBeforeDecimalPoint(11);
        Intent intent = getIntent();
        this.f18413h = (Form15ghModel) intent.getSerializableExtra("FORM15GH_MODEL");
        this.f18414i = (FGHStatusModel) intent.getSerializableExtra("FORM15GH_STATUS");
        this.j.setText(this.f18413h.getResponse().getFullName());
        this.k.setText(this.f18413h.getResponse().getMaskedPan());
        EditText editText = this.f18406a;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18413h.getResponse().getInterestProjection());
        editText.setText(sb.toString());
        this.f18409d.addTextChangedListener(this.f18412g);
        this.f18408c.addTextChangedListener(this.f18411f);
        this.t.addTextChangedListener(this.f18410e);
        this.y.setVisibility(8);
        this.m.setVisibility(8);
        this.q.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                PBFGFilledFormActivity.this.b(radioGroup, i2);
            }
        });
        this.r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                PBFGFilledFormActivity.this.a(radioGroup, i2);
            }
        });
        findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGFilledFormActivity.this.a(view);
            }
        });
        if (this.f18413h.getResponse().getFormType().equalsIgnoreCase("Form15G")) {
            this.x.setHint(getString(R.string.pb_fg_total_amount_of_all_form_15g_filed, new Object[]{getString(R.string.pb_fg_name)}));
        } else if (this.f18413h.getResponse().getFormType().equalsIgnoreCase("Form15H")) {
            this.x.setHint(getString(R.string.pb_fg_total_amount_of_all_form_15g_filed, new Object[]{getString(R.string.pb_fh_name)}));
        }
        ((RadioButton) findViewById(R.id.rb_No_filed_form15g)).setTypeface(((RadioButton) findViewById(R.id.rb_No_filed_form15g)).getTypeface(), 1);
        ((RadioButton) findViewById(R.id.rb_taxAbleNo)).setTypeface(((RadioButton) findViewById(R.id.rb_taxAbleNo)).getTypeface(), 1);
        if (this.f18413h.getResponse().getFormType().equalsIgnoreCase("Form15G")) {
            this.s.setText(getString(R.string.pb_fg_name));
            this.l.setText(getString(R.string.pb_fg_filed_form15g, new Object[]{getString(R.string.pb_fg_name)}));
        } else if (this.f18413h.getResponse().getFormType().equalsIgnoreCase("Form15H")) {
            this.s.setText(getString(R.string.pb_fh_name));
            this.l.setText(getString(R.string.pb_fg_filed_form15g, new Object[]{getString(R.string.pb_fh_name)}));
        }
        TextView textView = this.D;
        textView.setText(getString(R.string.pb_fg_for_fy) + " " + this.f18414i.getResponse().getFinancialYr());
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGFilledFormActivity.this.d(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void d(android.view.View r20) {
        /*
            r19 = this;
            r11 = r19
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r0 = r11.f18408c
            java.lang.String r0 = r0.getNormalText()
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r1 = r11.f18409d
            java.lang.String r1 = r1.getNormalText()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            if (r2 != 0) goto L_0x0021
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0021
            double r5 = java.lang.Double.parseDouble(r0)
            goto L_0x0022
        L_0x0021:
            r5 = r3
        L_0x0022:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0032
            int r0 = r1.length()
            if (r0 <= 0) goto L_0x0032
            double r3 = java.lang.Double.parseDouble(r1)
        L_0x0032:
            boolean r0 = r11.C
            if (r0 == 0) goto L_0x0052
            android.widget.EditText r0 = r11.f18407b
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0052
            com.google.android.material.textfield.TextInputLayout r0 = r11.y
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_select_fy_year
            java.lang.String r1 = r11.getString(r1)
            r0.setError(r1)
            return
        L_0x0052:
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r0 = r11.f18408c
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006e
            com.google.android.material.textfield.TextInputLayout r0 = r11.v
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_est_inc_mandatory
            java.lang.String r1 = r11.getString(r1)
            r0.setError(r1)
            return
        L_0x006e:
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            double r0 = r0.getExemptLimit()
            r2 = 1
            r7 = 0
            int r8 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a0
            com.google.android.material.textfield.TextInputLayout r0 = r11.v
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_inc_gt_exmpt_error
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r3 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r3 = r3.getResponse()
            double r3 = r3.getExemptLimit()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            java.lang.String r3 = com.paytm.utility.b.b((java.lang.Double) r3)
            r2[r7] = r3
            java.lang.String r1 = r11.getString(r1, r2)
            r0.setError(r1)
            return
        L_0x00a0:
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            double r0 = r0.getInterestProjection()
            int r8 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x00d0
            com.google.android.material.textfield.TextInputLayout r0 = r11.v
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_inc_les_error
            java.lang.Object[] r2 = new java.lang.Object[r2]
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r3 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r3 = r3.getResponse()
            double r3 = r3.getInterestProjection()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            java.lang.String r3 = com.paytm.utility.b.b((java.lang.Double) r3)
            r2[r7] = r3
            java.lang.String r1 = r11.getString(r1, r2)
            r0.setError(r1)
            return
        L_0x00d0:
            boolean r0 = r11.B
            if (r0 == 0) goto L_0x00f0
            android.widget.EditText r0 = r11.t
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00f0
            com.google.android.material.textfield.TextInputLayout r0 = r11.w
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_form_no_mandatory
            java.lang.String r1 = r11.getString(r1)
            r0.setError(r1)
            return
        L_0x00f0:
            boolean r0 = r11.B
            if (r0 == 0) goto L_0x0110
            android.widget.EditText r0 = r11.t
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 != 0) goto L_0x0110
            com.google.android.material.textfield.TextInputLayout r0 = r11.w
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_form_no_cant_zero
            java.lang.String r1 = r11.getString(r1)
            r0.setError(r1)
            return
        L_0x0110:
            boolean r0 = r11.B
            if (r0 == 0) goto L_0x0177
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r0 = r11.f18409d
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0177
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            java.lang.String r0 = r0.getFormType()
            java.lang.String r1 = "Form15G"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x014c
            com.google.android.material.textfield.TextInputLayout r0 = r11.x
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_amt_mandatory
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r3 = r11.getString(r3)
            r2[r7] = r3
            java.lang.String r1 = r11.getString(r1, r2)
            r0.setError(r1)
            return
        L_0x014c:
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            java.lang.String r0 = r0.getFormType()
            java.lang.String r1 = "Form15H"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0174
            com.google.android.material.textfield.TextInputLayout r0 = r11.x
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_amt_mandatory
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fh_name
            java.lang.String r3 = r11.getString(r3)
            r2[r7] = r3
            java.lang.String r1 = r11.getString(r1, r2)
            r0.setError(r1)
            return
        L_0x0174:
            r3 = r11
            goto L_0x03cc
        L_0x0177:
            boolean r0 = r11.B
            r1 = 2
            if (r0 == 0) goto L_0x01b8
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            double r8 = r0.getExemptLimit()
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b8
            com.google.android.material.textfield.TextInputLayout r0 = r11.x
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_amt_shdnt_gt_ex
            java.lang.Object[] r1 = new java.lang.Object[r1]
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r4 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r4 = r4.getResponse()
            java.lang.String r4 = r4.getFormType()
            r1[r7] = r4
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r4 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r4 = r4.getResponse()
            double r4 = r4.getExemptLimit()
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r4 = com.paytm.utility.b.b((java.lang.Double) r4)
            r1[r2] = r4
            java.lang.String r1 = r11.getString(r3, r1)
            r0.setError(r1)
            return
        L_0x01b8:
            boolean r0 = r11.B
            if (r0 == 0) goto L_0x01ef
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r0 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r0 = r0.getResponse()
            double r8 = r0.getInterestProjection()
            double r3 = r3 + r8
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x01ef
            com.google.android.material.textfield.TextInputLayout r0 = r11.x
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_total_amt_plus_fd_error
            java.lang.Object[] r1 = new java.lang.Object[r1]
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r4 = r11.f18413h
            net.one97.paytm.paymentsBank.form15g.model.Form15ghResponceModel r4 = r4.getResponse()
            java.lang.String r4 = r4.getFormType()
            r1[r7] = r4
            java.lang.Double r4 = java.lang.Double.valueOf(r5)
            java.lang.String r4 = com.paytm.utility.b.b((java.lang.Double) r4)
            r1[r2] = r4
            java.lang.String r1 = r11.getString(r3, r1)
            r0.setError(r1)
            return
        L_0x01ef:
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_please_wait
            java.lang.String r0 = r11.getString(r0)
            com.paytm.utility.b.k(r11, r0)
            net.one97.paytm.paymentsBank.form15g.a r12 = net.one97.paytm.paymentsBank.form15g.a.a(r19)
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r0 = r11.f18408c
            java.lang.String r0 = r0.getNormalText()
            android.widget.EditText r3 = r11.t
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText r4 = r11.f18409d
            java.lang.String r4 = r4.getNormalText()
            boolean r5 = r11.B
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x021a
            r3 = r6
            r4 = r3
        L_0x021a:
            android.widget.EditText r5 = r11.f18406a
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r8 = r11.f18414i
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r8 = r8.getResponse()
            java.lang.String r8 = r8.getFinancialYr()
            java.lang.String r9 = "-"
            java.lang.String[] r8 = r8.split(r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r13 = r8[r7]
            r10.append(r13)
            r10.append(r9)
            r8 = r8[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            int r8 = r8 + r2
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            boolean r10 = r11.C
            if (r10 == 0) goto L_0x028d
            android.widget.EditText r10 = r11.f18407b
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String[] r10 = r10.split(r9)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r14 = r10[r7]
            int r14 = java.lang.Integer.parseInt(r14)
            int r14 = r14 + r2
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r13 = r13.substring(r1)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r10 = r10[r7]
            r14.append(r10)
            r14.append(r9)
            r14.append(r13)
            java.lang.String r10 = r14.toString()
            goto L_0x028e
        L_0x028d:
            r10 = r6
        L_0x028e:
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r13 = r11.f18414i
            boolean r14 = r11.C
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.Class r16 = r12.getClass()
            java.lang.String r2 = r16.getSimpleName()
            java.lang.String r7 = "screen_name"
            r1.put(r7, r2)
            android.content.Context r2 = r12.f18394a
            java.lang.String r2 = com.paytm.utility.a.q(r2)
            java.lang.String r7 = "user-token"
            r15.put(r7, r2)
            java.lang.String r2 = "Accept"
            java.lang.String r7 = "*/*"
            r15.put(r2, r7)
            java.lang.String r2 = "content-type"
            java.lang.String r7 = "application/json"
            r15.put(r2, r7)
            java.lang.String r2 = "cache-control"
            java.lang.String r7 = "no-cache"
            r15.put(r2, r7)
            net.one97.paytm.bankCommon.utils.d.a()
            java.lang.String r2 = "fg_decision_api"
            java.lang.String r2 = net.one97.paytm.bankCommon.utils.d.a(r2)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            r17 = r1
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x037c }
            r1.<init>()     // Catch:{ Exception -> 0x037c }
            r18 = r6
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x037a }
            r6.<init>()     // Catch:{ Exception -> 0x037a }
            java.lang.String r11 = "FORM15GH"
            r6.put(r11)     // Catch:{ Exception -> 0x037a }
            java.lang.String r11 = "products"
            r1.put(r11, r6)     // Catch:{ Exception -> 0x037a }
            java.lang.String r6 = "channel"
            java.lang.String r11 = "B2C_ANDROID"
            r1.put(r6, r11)     // Catch:{ Exception -> 0x037a }
            java.lang.String r6 = "whthrAccsTotax"
            r7.put(r6, r14)     // Catch:{ Exception -> 0x037a }
            java.lang.String r6 = "aggregateIncome"
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x037a }
            if (r11 == 0) goto L_0x0308
            r11 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x037a }
        L_0x0308:
            r7.put(r6, r4)     // Catch:{ Exception -> 0x037a }
            java.lang.String r4 = "currentEstmtIncome"
            r7.put(r4, r5)     // Catch:{ Exception -> 0x037a }
            java.lang.String[] r4 = r8.split(r9)     // Catch:{ Exception -> 0x037a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037a }
            r5.<init>()     // Catch:{ Exception -> 0x037a }
            r6 = 0
            r8 = r4[r6]     // Catch:{ Exception -> 0x037a }
            r5.append(r8)     // Catch:{ Exception -> 0x037a }
            r5.append(r9)     // Catch:{ Exception -> 0x037a }
            r6 = 1
            r4 = r4[r6]     // Catch:{ Exception -> 0x037a }
            r6 = 2
            java.lang.String r4 = r4.substring(r6)     // Catch:{ Exception -> 0x037a }
            r5.append(r4)     // Catch:{ Exception -> 0x037a }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x037a }
            java.lang.String r5 = "financialYr"
            r7.put(r5, r4)     // Catch:{ Exception -> 0x037a }
            boolean r4 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x037a }
            if (r4 != 0) goto L_0x0341
            java.lang.String r4 = "latestAssmntYr"
            r7.put(r4, r10)     // Catch:{ Exception -> 0x037a }
        L_0x0341:
            java.lang.String r4 = "totNumofForm"
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x037a }
            if (r5 == 0) goto L_0x034e
            r5 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x037a }
        L_0x034e:
            r7.put(r4, r3)     // Catch:{ Exception -> 0x037a }
            java.lang.String r3 = "totalEstmtIncome"
            r7.put(r3, r0)     // Catch:{ Exception -> 0x037a }
            java.lang.String r0 = "formType"
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r3 = r13.getResponse()     // Catch:{ Exception -> 0x037a }
            java.lang.String r3 = r3.getFormtype()     // Catch:{ Exception -> 0x037a }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x037a }
            if (r3 != 0) goto L_0x036f
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r3 = r13.getResponse()     // Catch:{ Exception -> 0x037a }
            java.lang.String r6 = r3.getFormtype()     // Catch:{ Exception -> 0x037a }
            goto L_0x0371
        L_0x036f:
            r6 = r18
        L_0x0371:
            r7.put(r0, r6)     // Catch:{ Exception -> 0x037a }
            java.lang.String r0 = "form15ghCustomization"
            r1.put(r0, r7)     // Catch:{ Exception -> 0x037a }
            goto L_0x0391
        L_0x037a:
            r0 = move-exception
            goto L_0x037e
        L_0x037c:
            r0 = move-exception
            r1 = 0
        L_0x037e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.paytm.utility.q.b(r0)
        L_0x0391:
            net.one97.paytm.bankCommon.g.b r0 = new net.one97.paytm.bankCommon.g.b
            net.one97.paytm.paymentsBank.form15g.model.SubmitForm15ghModel r5 = new net.one97.paytm.paymentsBank.form15g.model.SubmitForm15ghModel
            r5.<init>()
            java.lang.String r7 = r1.toString()
            com.paytm.network.a$c r8 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r9 = com.paytm.network.a.b.USER_FACING
            r10 = r17
            r1 = r0
            r3 = r19
            r4 = r19
            r6 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            android.content.Context r1 = r12.f18394a
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x03bc
            net.one97.paytm.bankCommon.g.c r1 = new net.one97.paytm.bankCommon.g.c
            r1.<init>()
            net.one97.paytm.bankCommon.g.c.a(r0)
            return
        L_0x03bc:
            r0 = -1
            net.one97.paytm.paymentsBank.form15g.model.Form15ghModel r1 = new net.one97.paytm.paymentsBank.form15g.model.Form15ghModel
            r1.<init>()
            com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
            r2.<init>()
            r3 = r19
            r3.onErrorResponse(r0, r1, r2)
        L_0x03cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGFilledFormActivity.d(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.rb_taxAbleYes) {
            ((RadioButton) findViewById(R.id.rb_taxAbleYes)).setTypeface(((RadioButton) findViewById(R.id.rb_taxAbleYes)).getTypeface(), 1);
            ((RadioButton) findViewById(R.id.rb_taxAbleNo)).setTypeface((Typeface) null, 0);
            this.z = this.n.getText().toString();
            this.C = true;
            this.y.setVisibility(0);
            this.m.setVisibility(0);
            c cVar = new c();
            cVar.f18404d = new a() {
                public final void dateCallback(String str) {
                    PBFGFilledFormActivity.this.b(str);
                }
            };
            Bundle bundle = new Bundle();
            bundle.putSerializable("FORM15GH_STATUS", this.f18414i);
            bundle.putString("FINANCIAL_YEAR", this.f18407b.getText().toString());
            cVar.setArguments(bundle);
            cVar.show(getSupportFragmentManager(), "PBFGFinancialYearBottomSheet");
            this.f18407b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PBFGFilledFormActivity.this.c(view);
                }
            });
        } else if (i2 == R.id.rb_taxAbleNo) {
            ((RadioButton) findViewById(R.id.rb_taxAbleNo)).setTypeface(((RadioButton) findViewById(R.id.rb_taxAbleNo)).getTypeface(), 1);
            ((RadioButton) findViewById(R.id.rb_taxAbleYes)).setTypeface((Typeface) null, 0);
            this.C = false;
            this.y.setVisibility(8);
            this.m.setVisibility(8);
            this.f18407b.setOnClickListener($$Lambda$PBFGFilledFormActivity$wNhgiJZhiW0SeAbZ3fzkYTcoHT4.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        this.f18407b.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        c cVar = new c();
        cVar.f18404d = new a() {
            public final void dateCallback(String str) {
                PBFGFilledFormActivity.this.a(str);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putSerializable("FORM15GH_STATUS", this.f18414i);
        bundle.putString("FINANCIAL_YEAR", this.f18407b.getText().toString());
        cVar.setArguments(bundle);
        cVar.show(getSupportFragmentManager(), "PBFGFinancialYearBottomSheet");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.f18407b.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.rb_Yes_filed_form15g) {
            ((RadioButton) findViewById(R.id.rb_No_filed_form15g)).setTypeface((Typeface) null, 0);
            ((RadioButton) findViewById(R.id.rb_Yes_filed_form15g)).setTypeface(((RadioButton) findViewById(R.id.rb_Yes_filed_form15g)).getTypeface(), 1);
            this.A = this.o.getText().toString();
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.B = true;
        } else if (i2 == R.id.rb_No_filed_form15g) {
            ((RadioButton) findViewById(R.id.rb_Yes_filed_form15g)).setTypeface((Typeface) null, 0);
            ((RadioButton) findViewById(R.id.rb_No_filed_form15g)).setTypeface(((RadioButton) findViewById(R.id.rb_No_filed_form15g)).getTypeface(), 1);
            this.B = false;
            this.A = this.p.getText().toString();
            this.w.setVisibility(8);
            this.x.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b.p();
        if (i2 == -1) {
            try {
                k.a().show(getSupportFragmentManager().a(), "dialog");
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else {
            j.a((Context) this, networkCustomError);
        }
    }
}
