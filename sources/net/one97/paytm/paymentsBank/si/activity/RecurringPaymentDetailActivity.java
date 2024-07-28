package net.one97.paytm.paymentsBank.si.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.si.a.c;
import net.one97.paytm.paymentsBank.si.g.a;
import net.one97.paytm.paymentsBank.si.g.b;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.si.response.SIActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SITransactionListResponse;
import net.one97.paytm.paymentsBank.utils.p;

public class RecurringPaymentDetailActivity extends SIBaseActivity implements View.OnClickListener, d, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private TextView f18804b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18805c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f18806d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18807e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18808f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18809g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18810h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18811i;
    private TextView j;
    private TextView k;
    private RecyclerView l;
    private AppCompatImageView m;
    private ImageView n;
    private AllSIResponse.StandingInstructions o;
    private boolean p;
    private SITransactionListResponse q;
    private c r;
    private TextView s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.si_activity_recurring_detail);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RecurringPaymentDetailActivity.this.a(view);
            }
        });
        this.f18805c = (TextView) findViewById(R.id.recurNameTv);
        this.f18804b = (TextView) findViewById(R.id.rupeesTv);
        this.f18807e = (TextView) findViewById(R.id.frequencyTv);
        ((ViewGroup) findViewById(R.id.benifBtnLyt)).setOnClickListener(this);
        this.f18806d = (ViewGroup) findViewById(R.id.benifOpenLyt);
        this.f18808f = (TextView) findViewById(R.id.benifNameTv);
        this.f18809g = (TextView) findViewById(R.id.benifAccountTv);
        this.f18810h = (TextView) findViewById(R.id.benifIfscTv);
        this.f18811i = (TextView) findViewById(R.id.paymentTitleTv);
        this.j = (TextView) findViewById(R.id.paymentSubtitleTv);
        this.k = (TextView) findViewById(R.id.resumeBtn);
        findViewById(R.id.paymentHistoryTitleTv);
        this.l = (RecyclerView) findViewById(R.id.paymentHistoryRv);
        this.m = (AppCompatImageView) findViewById(R.id.benifDropDownIV);
        this.n = (ImageView) findViewById(R.id.benifIconIv);
        this.s = (TextView) findViewById(R.id.noItemTv);
        this.k.setOnClickListener(this);
        this.f18806d.setVisibility(8);
        this.o = (AllSIResponse.StandingInstructions) getIntent().getSerializableExtra("extra_data");
        this.f18808f.setText(this.o.getBeneficiaryName());
        this.f18810h.setText(this.o.getIfscCode());
        this.f18809g.setText(b.b(this.o.getDestinationAccount()));
        if ("ACTIVE".equalsIgnoreCase(this.o.getStatus())) {
            this.k.setVisibility(8);
        } else if ("PERMANENT_DEACTIVATED".equalsIgnoreCase(this.o.getStatus()) || "CLOSED".equalsIgnoreCase(this.o.getStatus())) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.o.getEndDate())) {
            TextView textView = this.j;
            textView.setText(getString(R.string.si_recur_end_on) + " " + b(this.o.getEndDate()));
        }
        if (!TextUtils.isEmpty(this.o.getStartDate()) && a(this.o.getStartDate())) {
            TextView textView2 = this.f18811i;
            textView2.setText(getString(R.string.si_first_payment_on) + ": " + b(this.o.getStartDate()));
        } else if (!TextUtils.isEmpty(this.o.getNextExecutionDate())) {
            TextView textView3 = this.f18811i;
            textView3.setText(getString(R.string.si_next_payment_on) + ": " + b(this.o.getNextExecutionDate()));
        }
        ImageView imageView = this.n;
        String ifscCode = this.o.getIfscCode();
        if (!TextUtils.isEmpty(ifscCode)) {
            w a2 = w.a();
            getApplicationContext();
            a2.a(a.a(ifscCode)).a(R.drawable.pb_mt_dummy_beneficiary_icon).b(R.drawable.pb_bank_ic_default_bank).a(imageView, (e) null);
        }
        this.f18804b.setText(net.one97.paytm.bankCommon.mapping.a.c(this.o.getAmount()));
        this.f18805c.setText(this.o.getReminderDisplayName());
        this.f18807e.setText(this.o.getFrequency().toLowerCase());
        this.l.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.r = new c(this, new ArrayList());
        this.l.setAdapter(this.r);
        c((String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    private static boolean a(String str) {
        try {
            if (new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(str).getTime() - new Date().getTime() > 0) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
        }
    }

    private static String b(String str) {
        try {
            return a("yyyy-MM-dd", "dd MMM ''yy", str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
            return simpleDateFormat2.format(simpleDateFormat.parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.resumeBtn) {
            Intent intent = new Intent(this, BankPasscodeActivity.class);
            intent.putExtra("title", getString(R.string.pb_passcode_header_resume_recurring_payment));
            intent.putExtra("ppb_header_position", "center");
            intent.putExtra("r_token", true);
            startActivityForResult(intent, 110);
        } else if (view.getId() != R.id.benifBtnLyt) {
        } else {
            if (this.f18806d.getVisibility() == 0) {
                this.f18806d.setVisibility(8);
                this.m.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.si_benif_lyt_drop_down));
                return;
            }
            this.f18806d.setVisibility(0);
            this.m.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.si_benif_lyt_drop_up));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 110 && i3 == -1) {
            String stringExtra = intent.getStringExtra("passcode");
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            StringBuilder sb = new StringBuilder();
            sb.append(this.o.getId());
            f a2 = net.one97.paytm.paymentsBank.si.d.a.a((Context) this, stringExtra, sb.toString(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            if (com.paytm.utility.b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
        }
    }

    public void onBackPressed() {
        if (this.p) {
            setResult(-1);
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            ah_();
            if (!isFinishing()) {
                ah_();
                if (i2 == -1) {
                    com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
                } else if (i2 == 401 || i2 == 410) {
                    net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
                } else {
                    p.a(iJRPaytmDataModel, networkCustomError, this);
                }
            }
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof SIActivateResponse) {
            SIActivateResponse sIActivateResponse = (SIActivateResponse) iJRPaytmDataModel;
            if (sIActivateResponse.getResponseCode().intValue() == 200) {
                this.k.setVisibility(8);
                this.p = true;
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.error), TextUtils.isEmpty(sIActivateResponse.getResponseMessage()) ? getString(R.string.pb_something_wrong_try_again) : sIActivateResponse.getResponseMessage());
        } else if (iJRPaytmDataModel instanceof SITransactionListResponse) {
            this.q = (SITransactionListResponse) iJRPaytmDataModel;
            if (this.q.getTransactions() != null && this.q.getTransactions().size() > 0) {
                c cVar = this.r;
                ArrayList<SITransactionListResponse.Transaction> transactions = this.q.getTransactions();
                if (transactions != null && transactions.size() > 0) {
                    if (cVar.f18796a == null) {
                        cVar.f18796a = new ArrayList<>();
                    }
                    cVar.f18796a.addAll(transactions);
                    cVar.notifyDataSetChanged();
                }
                this.s.setVisibility(8);
                this.l.setVisibility(0);
            } else if (this.r.getItemCount() == 0) {
                this.s.setVisibility(0);
                this.l.setVisibility(8);
            }
        }
    }

    private void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append(this.o.getId());
        f b2 = net.one97.paytm.paymentsBank.si.d.a.b(this, sb.toString(), str, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        a(this, getString(R.string.pb_please_wait));
        new net.one97.paytm.bankCommon.g.c();
        net.one97.paytm.bankCommon.g.c.a(b2);
    }

    public void onFragmentAction(int i2, Object obj) {
        SITransactionListResponse sITransactionListResponse;
        if (i2 == 123 && (sITransactionListResponse = this.q) != null && sITransactionListResponse.getTransactions() != null && this.q.getTransactions().size() > 0 && !this.q.getIsLastPage().booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.q.getTransactions().get(this.q.getTransactions().size() - 1).getMiddlewareId());
            c(sb.toString());
        }
    }
}
