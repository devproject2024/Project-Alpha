package net.one97.paytm.bankOpen.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBWebViewActivity;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.model.BankAccOpen;
import net.one97.paytm.bankCommon.model.FinancialServiceConsentResponse;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.model.SweepOutConsentResponse;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.a.a;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends b implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    protected Context f16401b;

    /* renamed from: c  reason: collision with root package name */
    protected RadioButton f16402c;

    /* renamed from: d  reason: collision with root package name */
    protected RadioButton f16403d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f16404e;

    /* renamed from: f  reason: collision with root package name */
    protected CheckBox f16405f;

    /* renamed from: g  reason: collision with root package name */
    protected CheckBox f16406g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<PBTncData> f16407h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f16408i;
    protected TextView j;
    protected TextView k;
    protected PBTncData l;
    protected PBTncData m;
    protected View n;
    private boolean o;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f16401b = context;
    }

    /* access modifiers changed from: protected */
    public int d() {
        return R.layout.fragment_payment_bank_set_nominee;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d(), (ViewGroup) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c.a("/bank/saving-account/add-pb_nominee", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        this.f16405f = (CheckBox) getView().findViewById(R.id.paytments_bank_set_nominee_checkbox_section_one);
        this.f16406g = (CheckBox) getView().findViewById(R.id.paytments_bank_set_nominee_checkbox_section_two);
        this.f16402c = (RadioButton) getView().findViewById(R.id.payment_bank_set_nominee_rbtn_add_nominee);
        this.f16403d = (RadioButton) getView().findViewById(R.id.payment_bank_set_nominee_rbtn_donot_add_nominee);
        this.f16404e = (TextView) getView().findViewById(R.id.set_nominee_tv_select_one_option);
        getView().findViewById(R.id.payment_bank_set_nominee_rl_add_nominee).setOnClickListener(this);
        getView().findViewById(R.id.payment_bank_set_nominee_rl_donot_add_nominee).setOnClickListener(this);
        getView().findViewById(R.id.set_nominee_img_close).setOnClickListener(this);
        this.n = getView().findViewById(R.id.paytments_bank_set_nominee_btn_proceed);
        this.n.setOnClickListener(this);
        getView().findViewById(R.id.paytments_bank_intro_btn_tnc).setOnClickListener(this);
        this.f16402c.setOnClickListener(this);
        this.f16403d.setOnClickListener(this);
        this.f16405f.setChecked(false);
        this.f16406g.setChecked(false);
        this.f16405f.setOnCheckedChangeListener(this);
        this.f16406g.setOnCheckedChangeListener(this);
        this.j = (TextView) getView().findViewById(R.id.know_more_tv_section_one);
        this.j.setOnClickListener(this);
        this.k = (TextView) getView().findViewById(R.id.know_more_tv_section_two);
        this.k.setOnClickListener(this);
        e();
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (com.paytm.utility.b.c(this.f16401b)) {
            p();
            o();
            return;
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void f() {
        this.f16403d.setChecked(false);
        this.f16402c.setChecked(true);
        this.f16404e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.f16402c.setChecked(false);
        this.f16403d.setChecked(true);
        this.f16404e.setVisibility(8);
    }

    protected static int h() {
        return R.string.msg_please_select_one_option;
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (!this.f16402c.isChecked() && !this.f16403d.isChecked()) {
            this.f16404e.setText(R.string.msg_please_select_one_option);
            this.f16404e.setVisibility(0);
        } else if (this.f16405f.getVisibility() == 0 && this.f16406g.getVisibility() == 0) {
            if (this.f16405f.getVisibility() != 0 || this.f16405f.isChecked()) {
                ArrayList<PBTncData> arrayList = this.f16407h;
                if (arrayList != null && !arrayList.contains(this.m)) {
                    this.f16407h.add(this.m);
                }
                if (this.f16406g.getVisibility() != 0 || this.f16406g.isChecked()) {
                    ArrayList<PBTncData> arrayList2 = this.f16407h;
                    if (arrayList2 != null && !arrayList2.contains(this.l)) {
                        this.f16407h.add(this.l);
                    }
                    if (getActivity() instanceof PaymentsBankBaseActivity) {
                        ((PaymentsBankBaseActivity) getActivity()).f16348b = true;
                    }
                    this.o = false;
                    c.a("bank_saving_account_tnc_clicked", (Map<String, Object>) new HashMap(), (Context) getActivity());
                    if (this.f16405f.isChecked()) {
                        c.a(getActivity(), "bank_saving_account", "consent_checked", "", "", "/bank/saving-account/add-pb_nominee", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    } else {
                        c.a(getActivity(), "bank_saving_account", "consent_unchecked", "", "", "/bank/saving-account/add-pb_nominee", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    }
                    this.f16408i = true;
                    ArrayList<PBTncData> arrayList3 = this.f16407h;
                    if (arrayList3 != null) {
                        a(arrayList3);
                    } else {
                        n();
                    }
                } else {
                    this.f16404e.setText(R.string.pb_kyc_consent_not_checked);
                    this.f16404e.setVisibility(0);
                }
            } else {
                this.f16404e.setText(R.string.pb_kyc_consent_not_checked);
                this.f16404e.setVisibility(0);
            }
        } else if (com.paytm.utility.b.c(this.f16401b)) {
            p();
            o();
        } else {
            a();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.payment_bank_set_nominee_rbtn_add_nominee || id == R.id.payment_bank_set_nominee_rl_add_nominee) {
            f();
        } else if (id == R.id.payment_bank_set_nominee_rbtn_donot_add_nominee || id == R.id.payment_bank_set_nominee_rl_donot_add_nominee) {
            g();
        } else if (id == R.id.paytments_bank_intro_btn_tnc) {
            this.f16408i = false;
            this.o = true;
            if (this.f16407h != null) {
                q();
                return;
            }
            a(getActivity(), getString(R.string.pb_please_wait));
            n();
        } else if (id == R.id.paytments_bank_set_nominee_btn_proceed) {
            i();
        } else if (id == R.id.set_nominee_img_close) {
            j();
        } else if (id == R.id.know_more_tv_section_one) {
            d.b();
            PBWebViewActivity.a(getActivity(), d.a("nomineeConsent1KnowMore"), getString(R.string.pb_know_more));
        } else if (id == R.id.know_more_tv_section_two) {
            d.b();
            PBWebViewActivity.a(getActivity(), d.a("nomineeConsent2KnowMore"), getString(R.string.pb_know_more));
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return this.f16405f.isChecked();
    }

    /* access modifiers changed from: protected */
    public final void l() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = a.a(this.f16401b, false, (NomineeModel) null, k(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            if (com.paytm.utility.b.c(this.f16401b)) {
                a(this.f16401b, this.f16401b.getString(R.string.pb_please_wait));
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            a(a2);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
        net.one97.paytm.bankOpen.d.b.a(getActivity(), (e) getActivity());
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        W_();
        if (isResumed()) {
            if (iJRPaytmDataModel instanceof BankAccOpen) {
                BankAccOpen bankAccOpen = (BankAccOpen) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(bankAccOpen.getErrorMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), bankAccOpen.getErrorMessage());
                } else if (!TextUtils.isEmpty(bankAccOpen.getMessage()) && bankAccOpen.getMessage().equalsIgnoreCase("PRODUCT_INITIATED")) {
                    net.one97.paytm.bankCommon.h.b.k(getActivity());
                    net.one97.paytm.bankCommon.h.b.d((Context) getActivity(), "L");
                    if (getActivity() != null && (getActivity() instanceof e)) {
                        m();
                    }
                }
                super.onResponse(iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof PBKYCFetchTnc) {
                PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) iJRPaytmDataModel;
                if (pBKYCFetchTnc.getStatus() == null || !pBKYCFetchTnc.getStatus().equalsIgnoreCase("error")) {
                    if (pBKYCFetchTnc.getStatus() != null && pBKYCFetchTnc.getStatus().equalsIgnoreCase("success")) {
                        if (pBKYCFetchTnc.getTncDataList() != null) {
                            this.f16407h = pBKYCFetchTnc.getTncDataList();
                            if (this.o) {
                                W_();
                                q();
                            }
                            if (this.f16408i) {
                                this.n.performClick();
                                return;
                            }
                            return;
                        }
                        W_();
                    }
                } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                    W_();
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), pBKYCFetchTnc.getMessage());
                }
            } else if (iJRPaytmDataModel instanceof PBKYCTncAccept) {
                W_();
                PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) iJRPaytmDataModel;
                if (pBKYCTncAccept.getStatus() == null || !pBKYCTncAccept.getStatus().equalsIgnoreCase("error")) {
                    if (pBKYCTncAccept.getStatus() != null && pBKYCTncAccept.getStatus().equalsIgnoreCase("success") && pBKYCTncAccept.getResponseCode().equals("2004")) {
                        if (this.f16403d.isChecked()) {
                            l();
                        } else if (getActivity() != null && (getActivity() instanceof e)) {
                            ((e) getActivity()).a(2);
                        }
                    }
                } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), pBKYCTncAccept.getMessage());
                    ArrayList<PBTncData> arrayList = this.f16407h;
                    if (arrayList != null) {
                        arrayList.remove(this.l);
                        this.f16407h.remove(this.m);
                    }
                }
            } else if (iJRPaytmDataModel instanceof FinancialServiceConsentResponse) {
                FinancialServiceConsentResponse financialServiceConsentResponse = (FinancialServiceConsentResponse) iJRPaytmDataModel;
                if (financialServiceConsentResponse.getStatus() == null || !financialServiceConsentResponse.getStatus().equalsIgnoreCase("error")) {
                    if (financialServiceConsentResponse.getStatus() != null && financialServiceConsentResponse.getStatus().equalsIgnoreCase("success") && financialServiceConsentResponse.getTncDataList() != null) {
                        ArrayList<PBTncData> tncDataList = financialServiceConsentResponse.getTncDataList();
                        if (tncDataList.size() > 0) {
                            this.l = tncDataList.get(0);
                            String description = this.l.getDescription();
                            if (TextUtils.isEmpty(description)) {
                                this.f16406g.setVisibility(8);
                                this.k.setVisibility(8);
                                return;
                            }
                            this.f16406g.setVisibility(0);
                            this.f16406g.setText(description);
                            d.b();
                            if (!TextUtils.isEmpty(d.a("nomineeConsent2KnowMore"))) {
                                this.k.setVisibility(0);
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(financialServiceConsentResponse.getMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), financialServiceConsentResponse.getMessage());
                }
            } else if (iJRPaytmDataModel instanceof SweepOutConsentResponse) {
                SweepOutConsentResponse sweepOutConsentResponse = (SweepOutConsentResponse) iJRPaytmDataModel;
                if (sweepOutConsentResponse.getStatus() == null || !sweepOutConsentResponse.getStatus().equalsIgnoreCase("error")) {
                    if (sweepOutConsentResponse.getStatus() != null && sweepOutConsentResponse.getStatus().equalsIgnoreCase("success") && sweepOutConsentResponse.getTncDataList() != null) {
                        ArrayList<PBTncData> tncDataList2 = sweepOutConsentResponse.getTncDataList();
                        if (tncDataList2.size() > 0) {
                            this.m = tncDataList2.get(0);
                            String description2 = this.m.getDescription();
                            if (TextUtils.isEmpty(description2)) {
                                this.f16405f.setVisibility(8);
                                this.j.setVisibility(8);
                                return;
                            }
                            this.f16405f.setVisibility(0);
                            this.f16405f.setText(description2);
                            d.b();
                            if (!TextUtils.isEmpty(d.a("nomineeConsent1KnowMore"))) {
                                this.j.setVisibility(0);
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(sweepOutConsentResponse.getMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), sweepOutConsentResponse.getMessage());
                }
            }
        }
    }

    private void n() {
        d.b();
        String a2 = d.a("bank_tnc");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(this.f16401b, a2);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(this.f16401b);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            if (com.paytm.utility.b.c(this.f16401b)) {
                a(this.f16401b, getString(R.string.pb_please_wait));
                this.f16401b.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(e2, this, this, new PBKYCFetchTnc(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
                return;
            }
            a((net.one97.paytm.bankCommon.g.f) new net.one97.paytm.bankCommon.g.a(e2, this, this, new PBKYCFetchTnc(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
        }
    }

    private void o() {
        d.b();
        String a2 = d.a("swipeConsentTnc");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(this.f16401b, a2);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(this.f16401b);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            if (com.paytm.utility.b.c(this.f16401b)) {
                a(this.f16401b, getString(R.string.pb_please_wait));
                this.f16401b.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(e2, this, this, new SweepOutConsentResponse(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
                return;
            }
            a((net.one97.paytm.bankCommon.g.f) new net.one97.paytm.bankCommon.g.a(e2, this, this, new SweepOutConsentResponse(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
        }
    }

    private void p() {
        d.b();
        String a2 = d.a("financialConsentTnc");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(this.f16401b, a2);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(this.f16401b);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            if (com.paytm.utility.b.c(this.f16401b)) {
                a(this.f16401b, getString(R.string.pb_please_wait));
                this.f16401b.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(e2, this, this, new FinancialServiceConsentResponse(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
                return;
            }
            a((net.one97.paytm.bankCommon.g.f) new net.one97.paytm.bankCommon.g.a(e2, this, this, new FinancialServiceConsentResponse(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
        }
    }

    private void a(ArrayList<PBTncData> arrayList) {
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("kyc_tnc_user_url");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(this.f16401b, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", "clickthrough");
                this.f16401b.getSystemService(ContactColumn.PHONE_NUMBER);
                jSONObject.put("deviceId", com.paytm.utility.b.e(this.f16401b));
                if (arrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<PBTncData> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        PBTncData next = it2.next();
                        if (next != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", next.getCode());
                            jSONObject2.put("version", next.getVersion());
                            if (next.getCode().equals(this.m.getCode()) || next.getCode().equals(this.l.getCode())) {
                                jSONObject2.put("accept", 1);
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("tnCList", jSONArray);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            String jSONObject3 = jSONObject.toString();
            Map<String, String> e4 = net.one97.paytm.bankCommon.mapping.d.e(this.f16401b);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            if (com.paytm.utility.b.c(this.f16401b)) {
                a(this.f16401b, getString(R.string.pb_please_wait));
                getActivity().getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, e4, jSONObject3, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap));
                return;
            }
            a((net.one97.paytm.bankCommon.g.f) new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, e4, jSONObject3, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap));
        }
    }

    private void q() {
        ArrayList<PBTncData> arrayList = this.f16407h;
        if (arrayList != null && arrayList.size() > 0) {
            net.one97.paytm.bankCommon.e.a.a(this.f16407h).show(getActivity().getSupportFragmentManager(), "KycTNCFragment");
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        TextView textView = this.f16404e;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isResumed()) {
            W_();
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.utils.f.a((Context) getActivity(), networkCustomError, i2);
            }
        }
    }
}
