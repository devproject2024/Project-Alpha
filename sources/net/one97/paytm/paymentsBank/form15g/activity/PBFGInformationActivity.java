package net.one97.paytm.paymentsBank.form15g.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.form15g.model.Form15ghModel;
import net.one97.paytm.paymentsBank.utils.o;

public class PBFGInformationActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private Form15ghModel f18418a;

    /* renamed from: b  reason: collision with root package name */
    private FGHStatusModel f18419b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18420c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18421d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18422e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18423f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18424g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_fg_information_activity);
        setTheme(R.style.JarvisAppThemeNoActionBar);
        TextView textView = (TextView) findViewById(R.id.tv_know_more_link);
        this.f18421d = (TextView) findViewById(R.id.tv_submit_form15g_title);
        this.f18423f = (TextView) findViewById(R.id.tv_eligibility_criteria1);
        this.f18420c = (TextView) findViewById(R.id.tv_form15G_title);
        this.f18424g = (TextView) findViewById(R.id.tv_financial_year);
        this.f18422e = (TextView) findViewById(R.id.tv_eligibility_criteria5);
        textView.setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGInformationActivity.this.c(view);
            }
        });
        ((Button) findViewById(R.id.btn_proceed)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGInformationActivity.this.b(view);
            }
        });
        findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBFGInformationActivity.this.a(view);
            }
        });
        Intent intent = getIntent();
        this.f18418a = (Form15ghModel) intent.getSerializableExtra("FORM15GH_MODEL");
        this.f18419b = (FGHStatusModel) intent.getSerializableExtra("FORM15GH_STATUS");
        if (this.f18418a.getResponse().getFormType().equalsIgnoreCase("Form15G")) {
            this.f18420c.setText(getString(R.string.pb_fg_name));
            this.f18421d.setText(getString(R.string.pb_fg_submit_form_15g_fixed_deposits, new Object[]{getString(R.string.pb_fg_name)}));
        } else if (this.f18418a.getResponse().getFormType().equalsIgnoreCase("Form15H")) {
            this.f18420c.setText(getString(R.string.pb_fh_name));
            this.f18421d.setText(getString(R.string.pb_fg_submit_form_15g_fixed_deposits, new Object[]{getString(R.string.pb_fh_name)}));
        }
        this.f18424g.setText(getString(R.string.pb_fg_for_fy) + " " + this.f18419b.getResponse().getFinancialYr());
        String[] split = this.f18419b.getResponse().getFinancialYr().split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(split[0]) + 2);
        String str = (Integer.parseInt(split[0]) + 1) + "-" + sb.toString().substring(2);
        this.f18422e.setText(getResources().getString(R.string.pb_fg_eligibility_criteria5) + " " + a.c(Double.valueOf(this.f18418a.getResponse().getExemptLimit())) + " " + getString(R.string.pb_fg_eligibility_criteria51, new Object[]{this.f18419b.getResponse().getFinancialYr(), str}));
        String[] split2 = this.f18419b.getResponse().getFinancialYr().split("-");
        if (this.f18418a.getResponse().getFormType().equalsIgnoreCase("Form15G")) {
            TextView textView2 = this.f18423f;
            String string = getString(R.string.pb_f15g_less_then_60);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Integer.parseInt(split2[0]) + 1);
            textView2.setText(Html.fromHtml(String.format(string, new Object[]{this.f18418a.getResponse().getAgeLimit(), this.f18419b.getResponse().getFinancialYr(), sb2.toString()})));
        } else if (this.f18418a.getResponse().getFormType().equalsIgnoreCase("Form15H")) {
            TextView textView3 = this.f18423f;
            String string2 = getString(R.string.pb_f15h_above_60);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Integer.parseInt(split2[0]) + 1);
            textView3.setText(Html.fromHtml(String.format(string2, new Object[]{this.f18418a.getResponse().getAgeLimit(), this.f18418a.getResponse().getAgeLimit(), this.f18419b.getResponse().getFinancialYr(), sb3.toString()})));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        d.b();
        a2.openWebViewActivity(this, d.a("know_more_fd_url"), getString(R.string.pb_fg_title_web));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Intent intent = new Intent(this, PBFGFilledFormActivity.class);
        intent.putExtra("FORM15GH_MODEL", this.f18418a);
        intent.putExtra("FORM15GH_STATUS", this.f18419b);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
