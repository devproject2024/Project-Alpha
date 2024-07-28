package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import net.one97.paytm.common.widgets.d;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRSavingAccountStatementDownloadResposne;
import net.one97.paytm.passbook.beans.EmailEditResponse;
import net.one97.paytm.passbook.beans.userinfov2.CJRUserInfoV2;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.statementDownload.f;
import net.one97.paytm.passbook.statementDownload.h;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONObject;

public class StatementDownloadActivityForPPB extends BaseActivity implements View.OnClickListener, g, i.a<IJRDataModel>, d {

    /* renamed from: a  reason: collision with root package name */
    boolean f58625a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f58626b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f58627c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f58628d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f58629e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f58630f;

    /* renamed from: g  reason: collision with root package name */
    private String f58631g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f58632h = null;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f58633i;
    private CheckBox j;
    private ImageButton k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    private View n;
    private TextView o;
    private Dialog p;
    private TextView q;
    private b r;
    /* access modifiers changed from: private */
    public String s;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        e();
        if (isFinishing()) {
            return;
        }
        if (iJRDataModel instanceof CJRSavingAccountStatementDownloadResposne) {
            CJRSavingAccountStatementDownloadResposne cJRSavingAccountStatementDownloadResposne = (CJRSavingAccountStatementDownloadResposne) iJRDataModel;
            String str = cJRSavingAccountStatementDownloadResposne.status;
            String str2 = cJRSavingAccountStatementDownloadResposne.message;
            String str3 = cJRSavingAccountStatementDownloadResposne.txn_id;
            String str4 = str2 + "\nRequest ID :-\n" + str3;
            if (str3 != null) {
                str2 = str4;
            }
            if ("200".equalsIgnoreCase(str)) {
                com.paytm.b.a.a a2 = m.a(d.b().b());
                int b2 = a2.b("accountStatementDownloadCount", 0, true);
                a2.a("accountStatementDownloadTimestamp", System.currentTimeMillis(), true);
                a2.a("accountStatementDownloadCount", b2 + 1, true);
            }
            if (str2 == null) {
                str2 = getString(R.string.pass_oops_something_went_wrong);
            }
            String valueOf = String.valueOf(str2);
            if (!isFinishing()) {
                new c(this, valueOf).show();
            }
        } else if (iJRDataModel instanceof EmailEditResponse) {
            EmailEditResponse emailEditResponse = (EmailEditResponse) iJRDataModel;
            if ("SUCCESS".equalsIgnoreCase(emailEditResponse.status)) {
                b bVar = this.r;
                if (bVar != null && bVar.isShowing()) {
                    this.r.dismiss();
                }
                this.r = new b(this, "Enter the One Time Password (OTP) sent to your mobile number", this, emailEditResponse);
                this.r.setCanceledOnTouchOutside(true);
                this.r.show();
                return;
            }
            b.b((Context) this, getString(R.string.pass_alert), emailEditResponse.message);
        }
    }

    public void onCreate(Bundle bundle) {
        q.a(this, "/bank/savings-account/statement", (String) null, (ArrayList<String>) null, "fire a screen view with open screen event");
        super.onCreate(bundle);
        setContentView(R.layout.pass_w_passbook_module_statement_option);
        ((LinearLayout) findViewById(R.id.date_layout)).setVisibility(8);
        this.k = (ImageButton) findViewById(R.id.backArrow);
        this.k.setOnClickListener(this);
        this.f58633i = (CheckBox) findViewById(R.id.emailCheckbox);
        this.j = (CheckBox) findViewById(R.id.smsCheckbox);
        this.o = (TextView) findViewById(R.id.emailIdTv);
        this.q = (TextView) findViewById(R.id.changeEmail);
        this.q.setOnClickListener(this);
        this.f58626b = (TextView) findViewById(R.id.selectTimeTv);
        this.f58626b.setOnClickListener(this);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.m = (TextView) findViewById(R.id.select_start_date);
        this.m.setText(simpleDateFormat.format(Calendar.getInstance().getTime()));
        this.f58629e = new a(Calendar.getInstance().get(5), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
        this.m.setOnClickListener(this);
        this.l = (TextView) findViewById(R.id.select_end_date);
        this.l.setText(simpleDateFormat.format(Calendar.getInstance().getTime()));
        this.f58630f = new a(Calendar.getInstance().get(5), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
        this.l.setOnClickListener(this);
        this.n = findViewById(R.id.confirm);
        this.n.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        if (!this.f58625a) {
            String b2 = b.b((Context) this, d.b().a(PaymentsGTMConstants.USER_DETAILS) + "?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            hashMap.put("verification_type", "oauth_token");
            hashMap.put("data", com.paytm.utility.a.q(this));
            hashMap.put("Authorization", b.m());
            if (b.c((Context) this)) {
                net.one97.paytm.passbook.mapping.a.a aVar = new net.one97.paytm.passbook.mapping.a.a(b2, new i.a() {
                    public final void onResponse(Object obj) {
                        StatementDownloadActivityForPPB.this.a((IJRDataModel) obj);
                    }
                }, $$Lambda$StatementDownloadActivityForPPB$E76JS71RoKkKiFYpWfqGC0NxpLM.INSTANCE, new CJRUserInfoV2(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getName());
                getApplicationContext();
                c.a();
                c.b(aVar);
            }
        }
        String m2 = b.m((Context) this);
        if (TextUtils.isEmpty(m2)) {
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        this.o.setText(m2);
        this.q.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        CJRUserInfoV2 cJRUserInfoV2 = (CJRUserInfoV2) iJRDataModel;
        if (cJRUserInfoV2 != null && cJRUserInfoV2.getUserDefaultInfo() != null && !TextUtils.isEmpty(cJRUserInfoV2.getUserDefaultInfo().getEmail())) {
            String email = cJRUserInfoV2.getUserDefaultInfo().getEmail();
            if (!TextUtils.isEmpty(email)) {
                m.a(d.b().b()).a(AppConstants.KEY_EMAIL, email, true);
                this.o.setText(email);
            }
        }
    }

    public void onCheckBoxClicked(View view) {
        int id = view.getId();
        if (id == R.id.emailCheckbox) {
            this.j.setChecked(false);
        } else if (id == R.id.smsCheckbox) {
            this.f58633i.setChecked(false);
        }
    }

    private void c() {
        a aVar;
        Class<StatementDownloadActivityForPPB> cls = StatementDownloadActivityForPPB.class;
        new HashMap().put("screen_name", cls.getName());
        JSONObject jSONObject = new JSONObject();
        String a2 = d.b().a("savingAccountStatementDownload");
        if (!TextUtils.isEmpty(a2)) {
            String e2 = b.e((Context) this, a2);
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.f58632h = simpleDateFormat.format(instance.getTime());
            int i2 = this.f58627c;
            if (i2 == 0) {
                instance.add(2, -1);
                this.f58631g = simpleDateFormat.format(instance.getTime());
            } else if (i2 == 1) {
                instance.add(2, -2);
                this.f58631g = simpleDateFormat.format(instance.getTime());
            } else if (i2 == 2) {
                instance.add(2, -3);
                this.f58631g = simpleDateFormat.format(instance.getTime());
            } else if (i2 == 3) {
                instance.set(2, 2);
                instance.set(5, 31);
                this.f58632h = simpleDateFormat.format(instance.getTime());
                instance.set(2, 3);
                instance.set(5, 1);
                instance.add(1, -1);
                this.f58631g = simpleDateFormat.format(instance.getTime());
            } else if (!(i2 != 4 || (aVar = this.f58629e) == null || this.f58630f == null)) {
                this.f58631g = simpleDateFormat.format(Long.valueOf(aVar.a()));
                this.f58632h = simpleDateFormat.format(Long.valueOf(this.f58630f.a()));
            }
            long a3 = a(this.f58631g, "yyyy-MM-dd HH:mm:ss");
            long a4 = a(this.f58632h, "yyyy-MM-dd HH:mm:ss");
            if (a4 > System.currentTimeMillis()) {
                a4 = System.currentTimeMillis();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58632h);
            q.a(this, "custom_date_selected", this.f58631g, arrayList, "/bank/savings-account/statement");
            String str = e2 + "&startDate=" + a3 + "&endDate=" + a4;
            if (!this.f58633i.isChecked() || !TextUtils.isEmpty(b.m((Context) this))) {
                if (this.f58633i.isChecked()) {
                    q.a(this, "account_statement_confirm_clicked", "get on email", (ArrayList<String>) null, "/bank/savings-account/statement");
                    str = str + "&mode=EMAIL";
                } else if (this.j.isChecked()) {
                    q.a(this, "account_statement_confirm_clicked", "get on sms", (ArrayList<String>) null, "/bank/savings-account/statement");
                    str = str + "&mode=SMS";
                }
                if (getIntent().getStringExtra("accountType") != null) {
                    str = str + "&accountType=" + getIntent().getStringExtra("accountType");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("authorization", com.paytm.utility.a.q(this));
                net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(str, this, this, new CJRSavingAccountStatementDownloadResposne(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName());
                if (b.c((Context) this)) {
                    d();
                    getApplicationContext();
                    c.a();
                    c.b(bVar);
                    return;
                }
                a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        StatementDownloadActivityForPPB.this.b(dialogInterface, i2);
                    }
                });
                return;
            }
            this.f58625a = false;
            a(getString(R.string.pass_enter_email_to_receive_account_statement));
            this.f58625a = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        c();
    }

    private static long a(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return -1;
        }
    }

    private void a(String str) {
        f fVar = new f(str, b.m((Context) this));
        fVar.show(getSupportFragmentManager(), fVar.getTag());
        fVar.f58682a = new f.a() {
            public final void a(String str) {
                String unused = StatementDownloadActivityForPPB.this.s = str;
                if (str.equals(b.m(StatementDownloadActivityForPPB.this.getApplicationContext()))) {
                    StatementDownloadActivityForPPB statementDownloadActivityForPPB = StatementDownloadActivityForPPB.this;
                    net.one97.paytm.passbook.mapping.a.a((Context) statementDownloadActivityForPPB, statementDownloadActivityForPPB.getString(R.string.pass_alert), StatementDownloadActivityForPPB.this.getString(R.string.pass_email_is_same_as_previous));
                }
                StatementDownloadActivityForPPB.this.b(str);
            }
        };
    }

    private void a(a aVar, d.a aVar2) {
        net.one97.paytm.common.widgets.d dVar;
        if (aVar == null) {
            dVar = net.one97.paytm.common.widgets.d.a();
        } else {
            dVar = net.one97.paytm.common.widgets.d.a(aVar.f58638a, aVar.f58639b, aVar.f58640c);
        }
        dVar.show(getFragmentManager(), "DatePicker");
        dVar.f49892f = aVar2;
    }

    public static String a(long j2) {
        return new SimpleDateFormat("dd.MM.yyyy").format(Long.valueOf(j2));
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        e();
        if (isFinishing() || j.a((Context) this, networkCustomError)) {
            return;
        }
        if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
            Intent intent = new Intent();
            intent.putExtra("finish_activity", true);
            setResult(-1, intent);
            getClass().getName();
            j.a(this, networkCustomError, true, false);
            return;
        }
        getClass().getName();
        j.a((Activity) this, (Throwable) networkCustomError);
    }

    private void d() {
        try {
            if (this.p == null) {
                this.p = net.one97.paytm.passbook.mapping.c.f(this);
            }
            if (this.p != null && !this.p.isShowing()) {
                this.p.show();
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        try {
            if (this.p != null && this.p.isShowing()) {
                this.p.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        if (view == this.k) {
            onBackPressed();
        } else if (view == this.m) {
            a(this.f58629e, (d.a) new d.a() {
                public final void a(int i2, int i3, int i4) {
                    StatementDownloadActivityForPPB statementDownloadActivityForPPB = StatementDownloadActivityForPPB.this;
                    a unused = statementDownloadActivityForPPB.f58629e = new a(i2, i3, i4);
                    if (StatementDownloadActivityForPPB.this.f58629e.a() > System.currentTimeMillis()) {
                        StatementDownloadActivityForPPB statementDownloadActivityForPPB2 = StatementDownloadActivityForPPB.this;
                        net.one97.paytm.passbook.mapping.a.a((Context) statementDownloadActivityForPPB2, statementDownloadActivityForPPB2.getString(R.string.pass_error), StatementDownloadActivityForPPB.this.getString(R.string.pass_msg_curr_date));
                        return;
                    }
                    StatementDownloadActivityForPPB.this.m.setText(StatementDownloadActivityForPPB.a(StatementDownloadActivityForPPB.this.f58629e.a()));
                }
            });
        } else if (view == this.l) {
            a(this.f58630f, (d.a) new d.a() {
                public final void a(int i2, int i3, int i4) {
                    StatementDownloadActivityForPPB statementDownloadActivityForPPB = StatementDownloadActivityForPPB.this;
                    a unused = statementDownloadActivityForPPB.f58630f = new a(i2, i3, i4);
                    if (StatementDownloadActivityForPPB.this.f58630f.a() > System.currentTimeMillis()) {
                        StatementDownloadActivityForPPB statementDownloadActivityForPPB2 = StatementDownloadActivityForPPB.this;
                        net.one97.paytm.passbook.mapping.a.a((Context) statementDownloadActivityForPPB2, statementDownloadActivityForPPB2.getString(R.string.pass_error), StatementDownloadActivityForPPB.this.getString(R.string.pass_msg_curr_date));
                    } else if (StatementDownloadActivityForPPB.this.f58629e.a() > StatementDownloadActivityForPPB.this.f58630f.a()) {
                        StatementDownloadActivityForPPB statementDownloadActivityForPPB3 = StatementDownloadActivityForPPB.this;
                        net.one97.paytm.passbook.mapping.a.a((Context) statementDownloadActivityForPPB3, statementDownloadActivityForPPB3.getString(R.string.pass_error), StatementDownloadActivityForPPB.this.getString(R.string.pass_msg_endDate_greater));
                    } else {
                        StatementDownloadActivityForPPB.this.l.setText(StatementDownloadActivityForPPB.a(StatementDownloadActivityForPPB.this.f58630f.a()));
                    }
                }
            });
        } else if (view == this.f58626b) {
            q.a(this, "select_time_period_dropdown_clicked", (String) null, (ArrayList<String>) null, "/bank/savings-account/statement");
            h hVar = new h(this.f58627c);
            hVar.show(getSupportFragmentManager(), hVar.getTag());
            hVar.f58704a = new h.a() {
                public final void a(int i2) {
                    int unused = StatementDownloadActivityForPPB.this.f58627c = i2;
                    if (i2 == 0) {
                        q.a(StatementDownloadActivityForPPB.this.getApplicationContext(), "select_time_period_dropdown_clicked", "30 days", (ArrayList<String>) null, "/bank/savings-account/statement");
                        StatementDownloadActivityForPPB.this.f58626b.setText("Last 30 days");
                        ((LinearLayout) StatementDownloadActivityForPPB.this.findViewById(R.id.date_layout)).setVisibility(8);
                    } else if (i2 == 1) {
                        q.a(StatementDownloadActivityForPPB.this.getApplicationContext(), "select_time_period_dropdown_clicked", "60 days", (ArrayList<String>) null, "/bank/savings-account/statement");
                        StatementDownloadActivityForPPB.this.f58626b.setText("Last 60 days");
                        ((LinearLayout) StatementDownloadActivityForPPB.this.findViewById(R.id.date_layout)).setVisibility(8);
                    } else if (i2 == 2) {
                        q.a(StatementDownloadActivityForPPB.this.getApplicationContext(), "select_time_period_dropdown_clicked", "90 days", (ArrayList<String>) null, "/bank/savings-account/statement");
                        StatementDownloadActivityForPPB.this.f58626b.setText("Last 90 days");
                        ((LinearLayout) StatementDownloadActivityForPPB.this.findViewById(R.id.date_layout)).setVisibility(8);
                    } else if (i2 == 3) {
                        q.a(StatementDownloadActivityForPPB.this.getApplicationContext(), "select_time_period_dropdown_clicked", "Financial year", (ArrayList<String>) null, "/bank/savings-account/statement");
                        if (Calendar.getInstance().get(2) > 2) {
                            int i3 = Calendar.getInstance().get(1);
                            TextView a2 = StatementDownloadActivityForPPB.this.f58626b;
                            a2.setText("FY " + (Calendar.getInstance().get(1) - 1) + " - " + i3);
                        } else {
                            int i4 = Calendar.getInstance().get(1) - 1;
                            TextView a3 = StatementDownloadActivityForPPB.this.f58626b;
                            StringBuilder sb = new StringBuilder("FY ");
                            sb.append(i4 - 1);
                            sb.append(" - ");
                            sb.append(i4);
                            a3.setText(sb.toString());
                        }
                        ((LinearLayout) StatementDownloadActivityForPPB.this.findViewById(R.id.date_layout)).setVisibility(8);
                    } else if (i2 == 4) {
                        q.a(StatementDownloadActivityForPPB.this.getApplicationContext(), "select_time_period_dropdown_clicked", "Custom Date", (ArrayList<String>) null, "/bank/savings-account/statement");
                        StatementDownloadActivityForPPB.this.f58626b.setText("Custom Date");
                        ((LinearLayout) StatementDownloadActivityForPPB.this.findViewById(R.id.date_layout)).setVisibility(0);
                    }
                }
            };
        } else if (view == this.n) {
            boolean z = false;
            if (!(this.f58633i.isChecked() || this.j.isChecked())) {
                net.one97.paytm.passbook.mapping.a.a((Context) this, getString(R.string.pass_error), getString(R.string.pass_msg_please_select_any_option));
            } else if (this.f58627c == -1) {
                net.one97.paytm.passbook.mapping.a.a((Context) this, getString(R.string.pass_error), getString(R.string.pass_msg_please_select_the_time_period));
            } else {
                z = true;
            }
            if (z) {
                c();
            }
        } else if (view == this.q) {
            q.a(this, "change_email_clicked", (String) null, (ArrayList<String>) null, "/bank/savings-account/statement");
            a(getString(R.string.pass_change_email_id));
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        net.one97.paytm.passbook.mapping.a.b a2 = n.a(this, str, this, this);
        if (b.c((Context) this)) {
            d();
            getApplicationContext();
            c.a();
            c.b(a2);
            return;
        }
        a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                StatementDownloadActivityForPPB.this.a(dialogInterface, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        c();
    }

    public final void a() {
        Toast.makeText(this, "resend click", 0).show();
        b(this.s);
    }

    public final void b() {
        g.a(getSupportFragmentManager(), this.s);
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        public int f58638a;

        /* renamed from: b  reason: collision with root package name */
        public int f58639b;

        /* renamed from: c  reason: collision with root package name */
        public int f58640c;

        public a(int i2, int i3, int i4) {
            this.f58638a = i2;
            this.f58639b = i3;
            this.f58640c = i4;
        }

        public final long a() {
            Calendar instance = Calendar.getInstance();
            instance.set(5, this.f58638a);
            instance.set(2, this.f58639b - 1);
            instance.set(1, this.f58640c);
            return instance.getTimeInMillis();
        }
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.pass_no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.pass_network_retry_yes), onClickListener);
        builder.show();
    }
}
