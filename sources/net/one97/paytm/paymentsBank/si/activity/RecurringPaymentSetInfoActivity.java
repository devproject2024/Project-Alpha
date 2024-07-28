package net.one97.paytm.paymentsBank.si.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import com.squareup.timessquare.CalendarPickerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.x;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.si.c.f;
import net.one97.paytm.paymentsBank.si.g.b;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.si.response.SIEndDateResponse;
import net.one97.paytm.paymentsBank.si.response.SIPrevalidateResponse;
import net.one97.paytm.paymentsBank.si.view.ChipsView;
import net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.si.view.a;
import net.one97.paytm.paymentsBank.utils.p;

public class RecurringPaymentSetInfoActivity extends SIBaseActivity implements View.OnClickListener, d, g.a, g.b<IJRPaytmDataModel>, f.a {

    /* renamed from: b  reason: collision with root package name */
    private ChipsView f18820b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f18821c;

    /* renamed from: d  reason: collision with root package name */
    private CustomAmountTextInputEditText f18822d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f18823e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f18824f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, String> f18825g;

    /* renamed from: h  reason: collision with root package name */
    private String f18826h;

    /* renamed from: i  reason: collision with root package name */
    private String f18827i;
    private double j;
    private String k;
    private String l;
    private a m;
    private int n;
    private CheckBox o;
    private ViewGroup p;
    /* access modifiers changed from: private */
    public long q;
    /* access modifiers changed from: private */
    public long r;
    private ArrayList<PBTncData> s;
    private boolean t;
    /* access modifiers changed from: private */
    public EditText u;
    private CalendarPickerView.h v = new CalendarPickerView.h() {
        public final void b(Date date) {
        }

        public final void a(Date date) {
            long unused = RecurringPaymentSetInfoActivity.this.r = date.getTime();
            RecurringPaymentSetInfoActivity.this.f18824f.setText(RecurringPaymentSetInfoActivity.a(date, "dd MMMM"));
        }
    };
    /* access modifiers changed from: private */
    public String w;
    private CalendarPickerView.h x = new CalendarPickerView.h() {
        public final void b(Date date) {
        }

        public final void a(Date date) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            long unused = RecurringPaymentSetInfoActivity.this.q = instance.getTimeInMillis();
            RecurringPaymentSetInfoActivity.this.f18823e.setText(RecurringPaymentSetInfoActivity.a(new Date(RecurringPaymentSetInfoActivity.this.q), "dd MMMM"));
            RecurringPaymentSetInfoActivity.this.f18824f.setText("");
            long unused2 = RecurringPaymentSetInfoActivity.this.r = 0;
            String unused3 = RecurringPaymentSetInfoActivity.this.w = "";
            RecurringPaymentSetInfoActivity.this.u.setText("");
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ x a(a aVar) {
        return null;
    }

    public static String a(Date date, String str) {
        try {
            return new SimpleDateFormat(str, new Locale(n.a())).format(date);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    private static String b(Date date, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, new Locale(n.a()));
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
            return simpleDateFormat.format(date);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.si_activity_recur_set_info);
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.benif_bank_icon_iv);
        this.f18821c = (EditText) findViewById(R.id.nop_et);
        this.f18822d = (CustomAmountTextInputEditText) findViewById(R.id.amount_et);
        findViewById(R.id.name_lyt);
        this.f18823e = (EditText) findViewById(R.id.start_date_input_et);
        this.f18824f = (EditText) findViewById(R.id.end_date_input_et);
        findViewById(R.id.calendar_end_icon);
        this.u = (EditText) findViewById(R.id.payment_count_et);
        this.f18823e.setOnClickListener(this);
        this.u.setOnClickListener(this);
        ((ImageView) findViewById(R.id.calendar_start_icon)).setOnClickListener(this);
        ((Button) findViewById(R.id.confirm_btn)).setOnClickListener(this);
        this.o = (CheckBox) findViewById(R.id.tncCb);
        this.p = (ViewGroup) findViewById(R.id.tncLyt);
        ((TextView) findViewById(R.id.tncTv)).setOnClickListener(this);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RecurringPaymentSetInfoActivity.this.a(view);
            }
        });
        this.f18825g = (HashMap) getIntent().getSerializableExtra(Item.CTA_URL_TYPE_MAP);
        ((TextView) findViewById(R.id.benif_name_tv)).setText(this.f18825g.get("holdername"));
        ((TextView) findViewById(R.id.benif_ifsc_tv)).setText(this.f18825g.get("ifsc"));
        ((TextView) findViewById(R.id.benif_acc_tv)).setText(b.b(this.f18825g.get("acc_no")));
        String a2 = net.one97.paytm.paymentsBank.si.g.a.a(this.f18825g.get("ifsc"));
        if (!TextUtils.isEmpty(a2)) {
            w.a().a(a2).a(R.drawable.pb_mt_dummy_beneficiary_icon).b(R.drawable.pb_bank_ic_default_bank).a((ImageView) appCompatImageView, (e) null);
        }
        a aVar = new a();
        aVar.f18939b = getString(R.string.si_month);
        aVar.f18938a = "MONTHLY";
        a aVar2 = new a();
        aVar2.f18939b = getString(R.string.si_week);
        aVar2.f18938a = "WEEKLY";
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        this.f18820b = (ChipsView) findViewById(R.id.frequency_chipview);
        this.f18820b.setResouceId(R.layout.si_chip_view_layout);
        this.f18820b.setArrayData(arrayList, "MONTHLY");
        this.f18820b.setSelectListener($$Lambda$RecurringPaymentSetInfoActivity$okXKnrf1dvsvkWNHERupkGN2DwU.INSTANCE);
        this.f18822d.setMaxDigitsBeforeDecimalPoint(6);
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.q = instance.getTimeInMillis();
        this.f18823e.setText(a(new Date(this.q), "dd MMMM"));
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 107) {
            Intent intent = new Intent(this, RecurringPaymentListActivity.class);
            intent.putExtra("acc_no", getIntent().getStringExtra("acc_no"));
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        }
    }

    private void e() {
        net.one97.paytm.paymentsBank.si.c.d a2 = net.one97.paytm.paymentsBank.si.c.d.a();
        Bundle bundle = new Bundle();
        bundle.putInt("calendar_type", 0);
        bundle.putString("firstTitle", getString(R.string.si_calendar_start_title));
        bundle.putLong("extra_selected_date", this.q);
        a2.f18879d = this.x;
        a2.setArguments(bundle);
        a2.show(getSupportFragmentManager(), "calendar_show");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.confirm_btn) {
            boolean z = false;
            if (TextUtils.isEmpty(this.f18821c.getText())) {
                this.f18821c.requestFocus();
                com.paytm.utility.b.a((Context) this, getString(R.string.si_name_error));
            } else if (this.f18821c.getText().length() < 3 || this.f18821c.getText().length() > 50) {
                this.f18821c.requestFocus();
                com.paytm.utility.b.a((Context) this, getString(R.string.si_name_length_error));
            } else if (TextUtils.isEmpty(this.f18822d.getText().toString().replace(AppConstants.COMMA, ""))) {
                this.f18822d.requestFocus();
                com.paytm.utility.b.a((Context) this, getString(R.string.si_amount_error));
            } else if (this.q == 0) {
                com.paytm.utility.b.a((Context) this, getString(R.string.si_start_date_error));
                e();
            } else if (TextUtils.isEmpty(this.w)) {
                com.paytm.utility.b.a((Context) this, getString(R.string.pb_si_no_of_payment_empty));
                j();
            } else if (this.r == 0) {
                com.paytm.utility.b.a((Context) this, getString(R.string.si_end_date_error));
            } else if (!this.o.isChecked()) {
                com.paytm.utility.b.a((Context) this, getString(R.string.si_tnc_error));
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
            if (this.s != null) {
                i();
                return;
            }
            this.t = true;
            h();
        } else if (view.getId() != R.id.end_date_input_et && view.getId() != R.id.calendar_end_icon) {
            if (view.getId() == R.id.start_date_input_et || view.getId() == R.id.calendar_start_icon) {
                e();
            } else if (view.getId() == R.id.tncTv) {
                ArrayList<PBTncData> arrayList = this.s;
                if (!com.paytm.network.b.b.a(this)) {
                    com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
                } else if (arrayList != null && arrayList.size() > 0) {
                    f a2 = f.a(arrayList);
                    a2.f18886a = this;
                    a2.show(getSupportFragmentManager(), "KycTNCFragment");
                }
            } else if (view.getId() == R.id.payment_count_et) {
                j();
            }
        }
    }

    private void f() {
        Date date = new Date(this.q);
        this.l = new SimpleDateFormat("MMM").format(date);
        this.k = new SimpleDateFormat("EEEE").format(date);
        this.n = Integer.parseInt(new SimpleDateFormat("dd").format(date));
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
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

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if (!isFinishing()) {
            ah_();
            if (iJRPaytmDataModel2 instanceof SIPrevalidateResponse) {
                SIPrevalidateResponse sIPrevalidateResponse = (SIPrevalidateResponse) iJRPaytmDataModel2;
                if (200 == sIPrevalidateResponse.getResponseCode().intValue()) {
                    Intent intent = new Intent(this, BankPasscodeActivity.class);
                    intent.putExtra("title", getString(R.string.pb_passcode_header_set_recurring_payment));
                    intent.putExtra("ppb_header_position", "center");
                    intent.putExtra("r_token", true);
                    startActivityForResult(intent, 110);
                    return;
                }
                com.paytm.utility.b.b((Context) this, getString(R.string.error), sIPrevalidateResponse.getResponseMessage());
            } else if (iJRPaytmDataModel2 instanceof SICreationResponse) {
                SICreationResponse sICreationResponse = (SICreationResponse) iJRPaytmDataModel2;
                if (200 == sICreationResponse.getResponseCode().intValue()) {
                    net.one97.paytm.paymentsBank.si.c.e a2 = net.one97.paytm.paymentsBank.si.c.e.a(this);
                    a2.f18885a = this;
                    a2.show(getSupportFragmentManager(), "success_si");
                    return;
                }
                com.paytm.utility.b.b((Context) this, getString(R.string.error), sICreationResponse.getResponseMessage());
            } else if (iJRPaytmDataModel2 instanceof PBKYCFetchTnc) {
                this.p.setVisibility(0);
                this.s = ((PBKYCFetchTnc) iJRPaytmDataModel2).getTncDataList();
                if (this.t) {
                    i();
                    this.t = false;
                }
            } else if (iJRPaytmDataModel2 instanceof PBKYCTncAccept) {
                PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel2;
                if ("success".equalsIgnoreCase(pBKYCTncAccept.getStatus())) {
                    this.m = (a) this.f18820b.getSelectedValue();
                    f();
                    this.j = Double.parseDouble(this.f18822d.getText().toString().replaceAll(AppConstants.COMMA, "").replace(getString(R.string.si_rupee), "").trim());
                    this.f18827i = getIntent().getStringExtra("acc_no");
                    HashMap hashMap = r1;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("screen_name", getClass().getSimpleName());
                    net.one97.paytm.bankCommon.g.f a3 = net.one97.paytm.paymentsBank.si.d.a.a(this, this.f18825g.get("benifId"), this.m.f18938a.toString(), this.n, "P2P", this.q, this.r, this.j, this.k, this.f18827i, this.f18825g.get("ifsc"), this.f18825g.get("holdername"), this.f18821c.getText().toString(), this.l, Integer.parseInt(this.w), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                    if (com.paytm.network.b.b.a(this)) {
                        a(this, getString(R.string.pb_please_wait));
                        new c();
                        c.a(a3);
                        return;
                    }
                    com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
                    return;
                }
                com.paytm.utility.b.b((Context) this, getString(R.string.error), TextUtils.isEmpty(pBKYCTncAccept.getMessage()) ? getString(R.string.pb_something_wrong_try_again) : pBKYCTncAccept.getMessage());
            } else {
                if (iJRPaytmDataModel2 instanceof SIEndDateResponse) {
                    SIEndDateResponse sIEndDateResponse = (SIEndDateResponse) iJRPaytmDataModel2;
                    if (sIEndDateResponse.getPayload() == null || sIEndDateResponse.getPayload().getEndDate() == 0) {
                        this.r = 0;
                        this.f18824f.setText("");
                        this.w = "";
                        return;
                    }
                    this.r = sIEndDateResponse.getPayload().getEndDate();
                    this.f18824f.setText(b(new Date(this.r), "dd MMMM"));
                    this.u.setText(this.w);
                }
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 110 && i3 == -1) {
            this.f18826h = intent.getStringExtra("passcode");
            HashMap hashMap = r1;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.si.d.a.a(this, this.f18825g.get("benifId"), this.m.f18938a.toString(), this.n, "P2P", this.q, this.r, this.j, this.k, this.f18827i, this.f18825g.get("ifsc"), this.f18825g.get("holdername"), this.f18821c.getText().toString(), this.l, Integer.parseInt(this.w), this, this, this.f18826h, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            if (com.paytm.network.b.b.a(this)) {
                a(this, getString(R.string.pb_please_wait));
                new c();
                c.a(a2);
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
            return;
        }
    }

    private void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.f b2 = net.one97.paytm.paymentsBank.si.d.a.b(this, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (b2 == null) {
            return;
        }
        if (com.paytm.utility.b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            new c();
            c.a(b2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
    }

    private void i() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.si.d.a.a(this, this.s, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (a2 == null) {
            return;
        }
        if (com.paytm.utility.b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            new c();
            c.a(a2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
    }

    public final void g() {
        this.o.setChecked(true);
    }

    private void j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        Bundle bundle = new Bundle();
        bundle.putSerializable("year_list", arrayList);
        bundle.putString("selectedYear", this.w);
        bundle.putString("title", getString(R.string.pb_si_payment_count));
        bundle.putInt("columnCount", 4);
        bundle.putInt("shape", 100);
        net.one97.paytm.paymentsBank.slfd.tds.view.c cVar = new net.one97.paytm.paymentsBank.slfd.tds.view.c();
        cVar.setArguments(bundle);
        cVar.f19372a = new d() {
            public final void onFragmentAction(int i2, Object obj) {
                RecurringPaymentSetInfoActivity.this.a(i2, obj);
            }
        };
        cVar.show(getSupportFragmentManager(), "TDS_BSDF");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        if (!obj.toString().equalsIgnoreCase(this.w)) {
            this.w = obj.toString();
            this.r = 0;
            this.f18824f.setText("");
            f();
            this.m = (net.one97.paytm.paymentsBank.si.view.a) this.f18820b.getSelectedValue();
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.si.d.a.a(this, this.q, this.m.f18938a.toString(), this.w, this.n, this.f18825g.get("ifsc"), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            if (a2 == null) {
                return;
            }
            if (com.paytm.utility.b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                new c();
                c.a(a2);
                return;
            }
            this.w = "";
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
        }
    }
}
