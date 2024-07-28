package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRSavingAccountStatementDownloadResposne;
import net.one97.paytm.passbook.beans.statement.CJRPassbookStatementDownloadResponse;
import net.one97.paytm.passbook.beans.statement.CJRTollStatementDownloadResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.statementDownload.o;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.m;
import org.json.JSONException;
import org.json.JSONObject;

public class StatementDownloadActivity extends BaseActivity implements g, i.a<IJRDataModel> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RadioGroup f58611a;

    /* renamed from: b  reason: collision with root package name */
    private String f58612b;

    /* renamed from: c  reason: collision with root package name */
    private String f58613c;

    /* renamed from: d  reason: collision with root package name */
    private Dialog f58614d;

    /* renamed from: e  reason: collision with root package name */
    private String f58615e = "PassbookWalletFragment";

    /* renamed from: f  reason: collision with root package name */
    private String f58616f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f58617g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f58618h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f58619i;
    private EditText j;
    private NestedScrollView k;
    private EditText l;
    private String m;
    private CompoundButton.OnCheckedChangeListener n = new CompoundButton.OnCheckedChangeListener() {
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            StatementDownloadActivity.this.a(compoundButton, z);
        }
    };

    public /* synthetic */ void onResponse(Object obj) {
        String str;
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        n();
        if (!isFinishing()) {
            boolean z = true;
            if (iJRDataModel instanceof CJRPassbookStatementDownloadResponse) {
                CJRPassbookStatementDownloadResponse cJRPassbookStatementDownloadResponse = (CJRPassbookStatementDownloadResponse) iJRDataModel;
                if (!"ACCEPTED".equalsIgnoreCase(cJRPassbookStatementDownloadResponse.getStatus())) {
                    a(cJRPassbookStatementDownloadResponse.getStatusMessage(), false);
                    return;
                }
                String str2 = this.m;
                if (str2 == null) {
                    str2 = b.m((Context) this);
                }
                int checkedRadioButtonId = this.f58611a.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.id_passbook_rbtn_1_month) {
                    str = getString(R.string.msg_statement_sent_for_1_month);
                } else if (checkedRadioButtonId == R.id.id_passbook_rbtn_2_month) {
                    str = getString(R.string.msg_statement_sent_for_2_month);
                } else if (checkedRadioButtonId == R.id.id_passbook_rbtn_3_month) {
                    str = getString(R.string.msg_statement_sent_for_3_month);
                } else if (checkedRadioButtonId == R.id.id_passbook_rbtn_6_month) {
                    str = getString(R.string.msg_statement_sent_for_6_month);
                } else if (checkedRadioButtonId == R.id.id_passbook_rbtn_1_year) {
                    str = getString(R.string.msg_statement_sent_for_1_year);
                } else if (checkedRadioButtonId != R.id.id_passbook_rbtn_select_duration || this.f58619i.getText().length() <= 0 || this.j.getText().length() <= 0) {
                    str = "";
                } else {
                    str = getString(R.string.msg_statement_sent_for_custom_time, new Object[]{this.f58619i.getText().toString(), this.j.getText().toString()});
                }
                o oVar = new o(str, str2, new o.a() {
                    public final void onDismiss() {
                        StatementDownloadActivity.this.p();
                    }
                });
                oVar.setCancelable(false);
                try {
                    oVar.show(getSupportFragmentManager().a(), "StatementSentSuccessfullyBottomsheetDialogFragment");
                } catch (Exception unused) {
                }
            }
            if (iJRDataModel instanceof CJRTollStatementDownloadResponse) {
                String statusMessage = ((CJRTollStatementDownloadResponse) iJRDataModel).getStatusMessage();
                if (statusMessage.equalsIgnoreCase("TOLL_REQUEST_ACCEPTED")) {
                    statusMessage = getResources().getString(R.string.toll_statement_accepted_msg);
                }
                a(statusMessage, false);
            }
            if (iJRDataModel instanceof CJRSavingAccountStatementDownloadResposne) {
                CJRSavingAccountStatementDownloadResposne cJRSavingAccountStatementDownloadResposne = (CJRSavingAccountStatementDownloadResposne) iJRDataModel;
                String str3 = cJRSavingAccountStatementDownloadResposne.status;
                String str4 = cJRSavingAccountStatementDownloadResposne.message;
                if ("200".equalsIgnoreCase(str3)) {
                    a a2 = m.a(getApplicationContext());
                    int b2 = a2.b("accountStatementDownloadCount", 0, true);
                    a2.a("accountStatementDownloadTimestamp", System.currentTimeMillis(), true);
                    a2.a("accountStatementDownloadCount", b2 + 1, true);
                } else {
                    z = false;
                }
                if (str4 == null) {
                    str4 = getString(R.string.oops_something_went_wrong);
                }
                a(String.valueOf(str4), z);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_w_passbook_module_statement_duration);
        setTitle(getString(R.string.top_menu_passbook));
        if (getIntent() != null && !TextUtils.isEmpty(getIntent().getStringExtra("CallingFragment"))) {
            this.f58615e = getIntent().getStringExtra("CallingFragment");
        }
        this.f58616f = getIntent().getStringExtra("header_title");
        if (!TextUtils.isEmpty(this.f58616f)) {
            setTitle(this.f58616f);
        }
        this.f58611a = (RadioGroup) findViewById(R.id.id_passbook_dialog_radio_group);
        if (this.f58615e.equalsIgnoreCase("TransactionTollPassageHistoryFragment")) {
            this.f58611a.findViewById(R.id.id_passbook_rbtn_2_month).setVisibility(8);
            this.f58611a.findViewById(R.id.id_2_month_separator).setVisibility(8);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_3_month).setVisibility(8);
            this.f58611a.findViewById(R.id.id_3_month_separator).setVisibility(8);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_6_month).setVisibility(8);
            this.f58611a.findViewById(R.id.id_6_month_separator).setVisibility(8);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_1_year).setVisibility(8);
            this.f58611a.findViewById(R.id.id_1_year_separator).setVisibility(8);
        } else if (this.f58615e.equalsIgnoreCase("PassbookSavingAccountFragment")) {
            this.f58611a.findViewById(R.id.id_passbook_rbtn_2_month).setVisibility(8);
            this.f58611a.findViewById(R.id.id_2_month_separator).setVisibility(8);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_3_month).setVisibility(0);
            this.f58611a.findViewById(R.id.id_3_month_separator).setVisibility(0);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_6_month).setVisibility(0);
            this.f58611a.findViewById(R.id.id_6_month_separator).setVisibility(0);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_1_year).setVisibility(8);
            this.f58611a.findViewById(R.id.id_1_year_separator).setVisibility(8);
        } else {
            this.f58611a.findViewById(R.id.id_passbook_rbtn_2_month).setVisibility(8);
            this.f58611a.findViewById(R.id.id_2_month_separator).setVisibility(8);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_3_month).setVisibility(0);
            this.f58611a.findViewById(R.id.id_3_month_separator).setVisibility(0);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_6_month).setVisibility(0);
            this.f58611a.findViewById(R.id.id_6_month_separator).setVisibility(0);
            this.f58611a.findViewById(R.id.id_passbook_rbtn_1_year).setVisibility(0);
            if (d.b().a("oldPassbookStatementDownloadOptionFlag", true)) {
                this.f58611a.findViewById(R.id.id_last_financial_year_separator).setVisibility(0);
                this.f58611a.findViewById(R.id.id_last_financial_year).setVisibility(0);
            }
            this.f58611a.findViewById(R.id.id_1_year_separator).setVisibility(0);
        }
        this.f58617g = (RadioButton) findViewById(R.id.id_passbook_rbtn_select_duration);
        this.f58618h = (TextView) findViewById(R.id.editEmailIdTv);
        this.k = (NestedScrollView) findViewById(R.id.scroll_view);
        this.l = (EditText) findViewById(R.id.enterEmailIdEdt);
        findViewById(R.id.id_proceed_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (StatementDownloadActivity.this.f58611a.getCheckedRadioButtonId() < 0) {
                    StatementDownloadActivity statementDownloadActivity = StatementDownloadActivity.this;
                    com.paytm.utility.g.b(statementDownloadActivity, statementDownloadActivity.getString(R.string.no_duration_selected), StatementDownloadActivity.this.getString(R.string.select_duration_to_proceed));
                    return;
                }
                StatementDownloadActivity.this.a();
            }
        });
        findViewById(R.id.back_arrow_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!StatementDownloadActivity.this.isFinishing()) {
                    StatementDownloadActivity.this.finish();
                }
            }
        });
        this.f58619i = (EditText) findViewById(R.id.fromDateEdt);
        this.j = (EditText) findViewById(R.id.toDateEdt);
        if (c()) {
            if (v.a(b.m((Context) this))) {
                findViewById(R.id.enterEmailIdEdt).setVisibility(0);
                findViewById(R.id.emailIdContainerLl).setVisibility(8);
            } else {
                findViewById(R.id.enterEmailIdEdt).setVisibility(8);
                findViewById(R.id.emailIdContainerLl).setVisibility(0);
                ((TextView) findViewById(R.id.emailIdTv)).setText(b.m((Context) this));
            }
        }
        this.f58617g.setOnCheckedChangeListener(this.n);
        this.f58618h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StatementDownloadActivity.this.c(view);
            }
        });
        this.f58619i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StatementDownloadActivity.this.b(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StatementDownloadActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.l.setVisibility(0);
        findViewById(R.id.emailIdContainerLl).setVisibility(8);
        this.l.setText(b.m((Context) this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (z) {
            d();
        } else {
            findViewById(R.id.duration_ll).setVisibility(8);
        }
    }

    private boolean c() {
        return this.f58615e.equalsIgnoreCase("PassbookWalletFragment");
    }

    private void d() {
        Intent intent = new Intent(this, SelectDurationActivity.class);
        if (this.f58615e.equalsIgnoreCase("PassbookWalletFragment")) {
            intent.putExtra("removeDurationLimit", true);
        } else if (this.f58615e.equalsIgnoreCase("TransactionTollPassageHistoryFragment")) {
            intent.putExtra("45daysCheck", true);
        }
        startActivityForResult(intent, 5363);
    }

    private void e() {
        net.one97.paytm.passbook.mapping.a.a(this, (String) null, getString(R.string.msg_previous_year_statement_download), getString(R.string.proceed), getString(R.string.cancel), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                StatementDownloadActivity.this.d(dialogInterface, i2);
            }
        }, $$Lambda$StatementDownloadActivity$73Ayhr12vDtqoiNlRr7xCuyXqE0.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface, int i2) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.paytm.me/oltrns")));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application can handle this request. Please install a webbrowser", 1).show();
        }
        finish();
    }

    private boolean a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar instance = Calendar.getInstance();
            instance.add(1, -1);
            Date time = instance.getTime();
            if (parse.getTime() < time.getTime() || parse2.getTime() < time.getTime()) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
            this.f58611a.clearCheck();
            return false;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 5363) {
            if (i3 == -1) {
                this.f58611a.check(R.id.id_passbook_rbtn_select_duration);
                if (!b.c((Context) this)) {
                    b();
                } else if (intent != null && intent.hasExtra("from") && intent.hasExtra("to")) {
                    String stringExtra = intent.getStringExtra("from");
                    String stringExtra2 = intent.getStringExtra("to");
                    if (c() && d.b().a("oldPassbookStatementDownloadRangeFlag", true) && a(stringExtra, stringExtra2)) {
                        this.f58611a.clearCheck();
                        e();
                    } else if (stringExtra != null && stringExtra2 != null) {
                        if (c()) {
                            findViewById(R.id.duration_ll).setVisibility(0);
                            this.f58619i.setText(a(stringExtra, "dd MMM yyyy", "dd/MM/yyyy"));
                            this.j.setText(a(stringExtra2, "dd MMM yyyy", "dd/MM/yyyy"));
                            this.k.post(new Runnable() {
                                public final void run() {
                                    StatementDownloadActivity.this.q();
                                }
                            });
                            return;
                        }
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
                            b(b.b(simpleDateFormat.parse(stringExtra), simpleDateFormat.parse(stringExtra2)));
                        } catch (ParseException unused) {
                        }
                        this.f58612b = a(stringExtra, "dd MMM yyyy", "yyyy-MM-dd HH:mm:ss");
                        this.f58613c = a(stringExtra2, "dd MMM yyyy", "yyyy-MM-dd HH:mm:ss");
                        if (this.f58612b != null && this.f58613c != null) {
                            a(true);
                        }
                    }
                }
            } else if (i3 == 0) {
                this.f58611a.clearCheck();
            }
        } else if (i2 == 1) {
            a(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.k.a(130);
    }

    private void b(int i2) {
        try {
            HashMap hashMap = new HashMap();
            if (this.f58615e.equalsIgnoreCase("PassbookWalletFragment")) {
                hashMap.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                hashMap.put("new_wallet_passbook_statement_duration", i2 + " days");
                f b2 = d.b();
                getApplicationContext();
                b2.a((Map<String, Object>) hashMap);
            }
        } catch (Exception unused) {
            boolean z = b.v;
        }
    }

    private String a(String str) {
        return a(str, "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss");
    }

    private String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, getResources().getConfiguration().locale).parse(str));
        } catch (ParseException unused) {
            return null;
        }
    }

    private String b(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", getResources().getConfiguration().locale).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(str));
        } catch (ParseException unused) {
            return null;
        }
    }

    private String f() {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            date = simpleDateFormat.parse(this.f58613c);
        } catch (ParseException unused) {
            date = null;
        }
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            this.f58613c = simpleDateFormat.format(instance.getTime());
        }
        return this.f58613c;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        String str;
        net.one97.paytm.passbook.mapping.a.b bVar;
        Class<StatementDownloadActivity> cls = StatementDownloadActivity.class;
        if (!v.a(b.m((Context) this)) || c()) {
            new HashMap();
            new HashMap().put("screen_name", cls.getName());
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f58612b) && !TextUtils.isEmpty(this.f58613c)) {
                if (this.f58615e.equalsIgnoreCase("PassbookWalletFragment")) {
                    str = d.b().a("async_passbook_download");
                } else if (this.f58615e.equalsIgnoreCase("PassbookSavingAccountFragment")) {
                    str = d.b().a("savingAccountStatementDownload");
                } else {
                    str = d.b().a("async_toll_passbook_download");
                }
                if (!TextUtils.isEmpty(str)) {
                    String e2 = b.e((Context) this, str);
                    f();
                    o();
                    if (this.f58615e.equalsIgnoreCase("PassbookWalletFragment")) {
                        String str2 = e2;
                        bVar = new net.one97.paytm.passbook.mapping.a.b(str2, this, this, new CJRPassbookStatementDownloadResponse(), h(), i().toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName());
                    } else if (this.f58615e.equalsIgnoreCase("PassbookSavingAccountFragment")) {
                        String c2 = c(e2);
                        String str3 = c2;
                        bVar = new net.one97.paytm.passbook.mapping.a.b(str3, this, this, new CJRSavingAccountStatementDownloadResposne(), l(), jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName());
                    } else {
                        String str4 = e2;
                        bVar = new net.one97.paytm.passbook.mapping.a.b(str4, this, this, new CJRTollStatementDownloadResponse(), k(), j().toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, cls.getName());
                    }
                    if (b.c((Context) this)) {
                        m();
                        getApplicationContext();
                        c.a();
                        c.b(bVar);
                        return;
                    }
                    b();
                }
            }
        } else if (z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.email_id_required));
            builder.setMessage(g());
            builder.setPositiveButton(R.string.proceed, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    StatementDownloadActivity.this.b(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(R.string.cancel, $$Lambda$StatementDownloadActivity$hJpPutWE_NzjGnW_rL26WW2Rhg.INSTANCE);
            builder.show();
        }
    }

    private String g() {
        if (this.f58615e.equalsIgnoreCase("PassbookSavingAccountFragment")) {
            return getString(R.string.msg_update_email_id_pb);
        }
        return getString(R.string.msg_update_email_id);
    }

    private String c(String str) {
        long b2 = b(this.f58612b, "yyyy-MM-dd HH:mm:ss");
        long b3 = b(this.f58613c, "yyyy-MM-dd HH:mm:ss");
        if (b3 > System.currentTimeMillis()) {
            b3 = System.currentTimeMillis();
        }
        return str + "&startDate=" + b2 + "&endDate=" + b3;
    }

    private static long b(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return -1;
        }
    }

    private Map<String, String> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", com.paytm.utility.a.q(this));
        hashMap.put("Accept-Encoding", "gzip");
        return hashMap;
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("from", this.f58612b);
            jSONObject2.put("to", this.f58613c);
            if (this.l.getVisibility() == 0 && net.one97.paytm.passbook.utility.c.a((CharSequence) this.l.getText())) {
                this.m = this.l.getText().toString();
                jSONObject2.put(AppConstants.KEY_EMAIL, this.l.getText().toString());
            }
            jSONObject.put("request", jSONObject2);
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "FILTERED_USER_TXN_HISTORY");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("startIndex", 1);
            jSONObject2.put("fromDate", b(this.f58612b));
            jSONObject2.put("toDate", b(this.f58613c));
            jSONObject.put("request", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private Map<String, String> k() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", com.paytm.utility.a.q(this));
        hashMap.put("tokentype", "OAUTH");
        hashMap.put("Cache-Control", "no-cache");
        return hashMap;
    }

    private Map<String, String> l() {
        HashMap hashMap = new HashMap();
        hashMap.put("authorization", com.paytm.utility.a.q(this));
        return hashMap;
    }

    private void m() {
        try {
            if (this.f58614d == null) {
                this.f58614d = net.one97.paytm.passbook.mapping.c.f(this);
            }
            if (this.f58614d != null && !this.f58614d.isShowing()) {
                this.f58614d.show();
            }
        } catch (Exception unused) {
        }
    }

    private void n() {
        try {
            if (this.f58614d != null && this.f58614d.isShowing()) {
                this.f58614d.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public final void b() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (b.c((Context) StatementDownloadActivity.this)) {
                        StatementDownloadActivity.this.a(true);
                    } else {
                        StatementDownloadActivity.this.b();
                    }
                }
            });
            builder.show();
        }
    }

    private void o() {
        try {
            if (this.f58615e.equalsIgnoreCase("PassbookWalletFragment")) {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/net/one97/paytm/passbook/select_duration");
                long abs = Math.abs(d(this.f58613c) - d(this.f58612b));
                StringBuilder sb = new StringBuilder();
                sb.append(Math.round(((float) abs) / 8.64E7f));
                hashMap.put("wallet_passjava.lang.Stringbook_statement_duration", sb.toString());
                d.b().a((Map<String, Object>) hashMap);
            }
        } catch (Exception unused) {
        }
    }

    private static long d(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        return date.getTime();
    }

    private void a(String str, final boolean z) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (z && !StatementDownloadActivity.this.isFinishing()) {
                        StatementDownloadActivity.this.finish();
                    }
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (!isFinishing()) {
            finish();
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        n();
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

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            java.lang.String r0 = r6.f58615e
            java.lang.String r1 = "PassbookSavingAccountFragment"
            boolean r0 = r0.equalsIgnoreCase(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002f
            android.content.Context r0 = r6.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.passbook.utility.m.a(r0)
            r3 = 0
            java.lang.String r5 = "accountStatementDownloadTimestamp"
            long r3 = r0.b((java.lang.String) r5, (long) r3, (boolean) r2)
            boolean r3 = android.text.format.DateUtils.isToday(r3)
            if (r3 == 0) goto L_0x002f
            java.lang.String r3 = "accountStatementDownloadCount"
            int r0 = r0.b((java.lang.String) r3, (int) r1, (boolean) r2)
            int r0 = r0 + r2
            r3 = 10
            if (r0 <= r3) goto L_0x002f
            r0 = 1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x003c
            int r0 = net.one97.paytm.passbook.R.string.msg_download_limit_reached
            java.lang.String r0 = r6.getString(r0)
            r6.a((java.lang.String) r0, (boolean) r1)
            return
        L_0x003c:
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x0060
            android.widget.EditText r0 = r6.l
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0060
            android.widget.EditText r0 = r6.l
            android.text.Editable r0 = r0.getText()
            boolean r0 = net.one97.paytm.passbook.utility.c.a((java.lang.CharSequence) r0)
            if (r0 != 0) goto L_0x0060
            int r0 = net.one97.paytm.passbook.R.string.msg_enter_valid_email_id
            java.lang.String r0 = r6.getString(r0)
            r6.a((java.lang.String) r0, (boolean) r1)
            return
        L_0x0060:
            android.widget.RadioGroup r0 = r6.f58611a
            int r0 = r0.getCheckedRadioButtonId()
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r1.<init>(r3)
            if (r0 != 0) goto L_0x0070
            return
        L_0x0070:
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            java.util.Date r4 = r3.getTime()
            java.lang.String r4 = r1.format(r4)
            r6.f58613c = r4
            int r4 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_1_month
            r5 = 2
            if (r0 != r4) goto L_0x009a
            r0 = -1
            r3.add(r5, r0)
            java.util.Date r0 = r3.getTime()
            java.lang.String r0 = r1.format(r0)
            r6.f58612b = r0
            r0 = 30
            r6.b((int) r0)
            r6.a((boolean) r2)
            return
        L_0x009a:
            int r4 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_2_month
            if (r0 != r4) goto L_0x00b5
            r0 = -2
            r3.add(r5, r0)
            java.util.Date r0 = r3.getTime()
            java.lang.String r0 = r1.format(r0)
            r6.f58612b = r0
            r0 = 60
            r6.b((int) r0)
            r6.a((boolean) r2)
            return
        L_0x00b5:
            int r4 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_3_month
            if (r0 != r4) goto L_0x00d0
            r0 = -3
            r3.add(r5, r0)
            java.util.Date r0 = r3.getTime()
            java.lang.String r0 = r1.format(r0)
            r6.f58612b = r0
            r0 = 90
            r6.b((int) r0)
            r6.a((boolean) r2)
            return
        L_0x00d0:
            int r4 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_6_month
            if (r0 != r4) goto L_0x00eb
            r0 = -6
            r3.add(r5, r0)
            java.util.Date r0 = r3.getTime()
            java.lang.String r0 = r1.format(r0)
            r6.f58612b = r0
            r0 = 180(0xb4, float:2.52E-43)
            r6.b((int) r0)
            r6.a((boolean) r2)
            return
        L_0x00eb:
            int r4 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_1_year
            if (r0 != r4) goto L_0x0107
            r0 = -12
            r3.add(r5, r0)
            java.util.Date r0 = r3.getTime()
            java.lang.String r0 = r1.format(r0)
            r6.f58612b = r0
            r0 = 365(0x16d, float:5.11E-43)
            r6.b((int) r0)
            r6.a((boolean) r2)
            return
        L_0x0107:
            int r1 = net.one97.paytm.passbook.R.id.id_last_financial_year
            if (r0 != r1) goto L_0x010f
            r6.e()
            return
        L_0x010f:
            int r1 = net.one97.paytm.passbook.R.id.id_passbook_rbtn_select_duration
            if (r0 != r1) goto L_0x01a5
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x018a
            android.widget.EditText r0 = r6.f58619i
            android.text.Editable r0 = r0.getText()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0189
            android.widget.EditText r0 = r6.j
            android.text.Editable r0 = r0.getText()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0132
            goto L_0x0189
        L_0x0132:
            android.widget.EditText r0 = r6.f58619i
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r6.a((java.lang.String) r0)
            r6.f58612b = r0
            android.widget.EditText r0 = r6.j
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r6.a((java.lang.String) r0)
            r6.f58613c = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x017d }
            java.lang.String r1 = "dd/MM/yyyy"
            r0.<init>(r1)     // Catch:{ ParseException -> 0x017d }
            android.widget.EditText r1 = r6.f58619i     // Catch:{ ParseException -> 0x017d }
            android.text.Editable r1 = r1.getText()     // Catch:{ ParseException -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ ParseException -> 0x017d }
            java.util.Date r1 = r0.parse(r1)     // Catch:{ ParseException -> 0x017d }
            android.widget.EditText r3 = r6.j     // Catch:{ ParseException -> 0x017d }
            android.text.Editable r3 = r3.getText()     // Catch:{ ParseException -> 0x017d }
            java.lang.String r3 = r3.toString()     // Catch:{ ParseException -> 0x017d }
            java.util.Date r0 = r0.parse(r3)     // Catch:{ ParseException -> 0x017d }
            int r0 = com.paytm.utility.b.b((java.util.Date) r1, (java.util.Date) r0)     // Catch:{ ParseException -> 0x017d }
            r6.b((int) r0)     // Catch:{ ParseException -> 0x017d }
            goto L_0x017e
        L_0x017d:
        L_0x017e:
            java.lang.String r0 = r6.f58612b
            if (r0 == 0) goto L_0x01a5
            java.lang.String r0 = r6.f58613c
            if (r0 == 0) goto L_0x01a5
            r6.a((boolean) r2)
        L_0x0189:
            return
        L_0x018a:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.statementDownload.SelectDurationActivity> r1 = net.one97.paytm.passbook.statementDownload.SelectDurationActivity.class
            r0.<init>(r6, r1)
            java.lang.String r1 = r6.f58615e
            java.lang.String r3 = "PassbookWalletFragment"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x01a0
            java.lang.String r1 = "removeDurationLimit"
            r0.putExtra(r1, r2)
        L_0x01a0:
            r1 = 5363(0x14f3, float:7.515E-42)
            r6.startActivityForResult(r0, r1)
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.statementDownload.StatementDownloadActivity.a():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        startActivityForResult(d.b().f(this), 1);
    }
}
