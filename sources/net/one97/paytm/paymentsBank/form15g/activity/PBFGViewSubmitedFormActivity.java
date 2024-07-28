package net.one97.paytm.paymentsBank.form15g.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;

public class PBFGViewSubmitedFormActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private FGHStatusModel f18438a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f18439b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18440c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18441d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18442e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18443f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f18444g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f18445h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f18446i;
    private EditText j;
    private TextView k;
    private TextView l;
    private TextView m;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_fg_view_submited_form_activity);
        this.f18441d = (TextView) findViewById(R.id.tv_form15G_title);
        this.f18439b = (TextView) findViewById(R.id.tv_fullname);
        this.f18442e = (TextView) findViewById(R.id.tv_taxable_selected_val);
        this.f18443f = (TextView) findViewById(R.id.tv_other_bank_selected_val);
        this.f18440c = (TextView) findViewById(R.id.tv_pancard_number);
        this.f18444g = (EditText) findViewById(R.id.et_estimated_income_fd);
        this.f18445h = (EditText) findViewById(R.id.et_total_income_fd);
        this.f18446i = (EditText) findViewById(R.id.et_no_of_form_filled);
        this.j = (EditText) findViewById(R.id.et_total_amt_form15g_filled);
        findViewById(R.id.textInputLayout1);
        findViewById(R.id.textInputLayout2);
        findViewById(R.id.textInputLayout3);
        findViewById(R.id.textInputLayout4);
        this.k = (TextView) findViewById(R.id.tv_financial_year);
        this.l = (TextView) findViewById(R.id.tv_form15G_filed_for_current_f_year);
        this.m = (TextView) findViewById(R.id.totalAmountOtherFormTv);
        findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGViewSubmitedFormActivity.this.a(view);
            }
        });
        this.f18438a = (FGHStatusModel) getIntent().getSerializableExtra("FORM15GH_STATUS");
        String string = getString(R.string.pb_fg_name);
        FGHStatusModel fGHStatusModel = this.f18438a;
        if (!(fGHStatusModel == null || fGHStatusModel.getResponse() == null)) {
            if (this.f18438a.getResponse().getFormtype().equalsIgnoreCase("Form15G")) {
                string = getString(R.string.pb_fg_name);
            } else if (this.f18438a.getResponse().getFormtype().equalsIgnoreCase("Form15H")) {
                string = getString(R.string.pb_fh_name);
            }
            this.f18441d.setText(string);
            TextView textView = this.k;
            textView.setText(getString(R.string.pb_fg_for_fy) + " " + this.f18438a.getResponse().getFinancialYr());
            this.l.setText(getString(R.string.pb_fg_filed_form15g, new Object[]{string}));
            this.m.setText(getString(R.string.pb_fg_total_amount_of_all_form_15g_filed, new Object[]{string}));
        }
        FGHStatusModel fGHStatusModel2 = this.f18438a;
        if (fGHStatusModel2 != null && fGHStatusModel2.getResponse() != null) {
            this.f18439b.setText(this.f18438a.getResponse().getFullName());
            if (this.f18438a.getResponse() == null || !this.f18438a.getResponse().getWhthrAccsTotax()) {
                this.f18442e.setText(getString(R.string.no).toUpperCase());
            } else {
                this.f18442e.setText(getString(R.string.yes).toUpperCase());
            }
            this.f18440c.setText(this.f18438a.getResponse().getMaskedPan());
            EditText editText = this.f18444g;
            editText.setText(getString(R.string.pb_fg_rs) + this.f18438a.getResponse().getCurrentEstmtIncome());
            this.f18446i.setText(this.f18438a.getResponse().getTotNumofForm());
            EditText editText2 = this.j;
            editText2.setText(getString(R.string.pb_fg_rs) + this.f18438a.getResponse().getAggregateIncome());
            EditText editText3 = this.f18445h;
            editText3.setText(getString(R.string.pb_fg_rs) + this.f18438a.getResponse().getTotalEstmtIncome());
            if (Integer.parseInt(this.f18438a.getResponse().getTotNumofForm()) == 0) {
                this.f18443f.setText(getString(R.string.no).toUpperCase());
            } else if (Integer.parseInt(this.f18438a.getResponse().getTotNumofForm()) > 0) {
                this.f18443f.setText(getString(R.string.yes).toUpperCase());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
