package net.one97.paytm.paymentsBank.si.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.model.BeneficiaryEntity;
import net.one97.paytm.bankCommon.model.CJRAddBeneficiary;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.si.c.b;
import net.one97.paytm.paymentsBank.si.c.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecurringPaymentAddActivity extends SIBaseActivity implements d, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, String> f18803b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.si_activity_recur_add);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RecurringPaymentAddActivity.this.a(view);
            }
        });
        c cVar = new c();
        cVar.s = this;
        getSupportFragmentManager().a().b(R.id.container_one, cVar, (String) null).c();
        getSupportFragmentManager().a().b(R.id.container_two, new b(), (String) null).c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 103) {
            this.f18803b = (HashMap) obj;
            String str = this.f18803b.get("acc_no");
            String str2 = this.f18803b.get("holdername");
            String str3 = this.f18803b.get("ifsc");
            String str4 = this.f18803b.get("bankname");
            BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
            if (a.Z(str)) {
                BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
                BeneficiaryEntity.UPI upi = new BeneficiaryEntity.UPI();
                ArrayList<BeneficiaryEntity.UPIAccount> arrayList = new ArrayList<>();
                BeneficiaryEntity.UPIAccount uPIAccount = new BeneficiaryEntity.UPIAccount();
                BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
                source.upi = "ENABLED";
                source.wallet = "DISABLED";
                source.oba = "DISABLED";
                BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = new BeneficiaryEntity.UPIAccountDetail();
                uPIAccountDetail.vpa = str;
                uPIAccountDetail.accountHolderName = str2;
                uPIAccount.source = source;
                uPIAccount.accountDetail = uPIAccountDetail;
                arrayList.add(uPIAccount);
                instrumentPreferences.upi = upi;
                instrumentPreferences.upi.accounts = arrayList;
                beneficiaryEntity.instrumentPreferences = instrumentPreferences;
            } else {
                BeneficiaryEntity.InstrumentPreferences instrumentPreferences2 = new BeneficiaryEntity.InstrumentPreferences();
                BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
                ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList2 = new ArrayList<>();
                BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
                BeneficiaryEntity.Source source2 = new BeneficiaryEntity.Source();
                source2.upi = "ENABLED";
                source2.wallet = "ENABLED";
                source2.oba = "ENABLED";
                BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
                otherBankAccountDetail.accountNumber = str;
                otherBankAccountDetail.accountHolderName = str2;
                otherBankAccountDetail.ifscCode = str3;
                otherBankAccountDetail.bankName = str4;
                otherBankAccount.source = source2;
                otherBankAccount.accountDetail = otherBankAccountDetail;
                arrayList2.add(otherBankAccount);
                instrumentPreferences2.otherBank = otherBank;
                instrumentPreferences2.otherBank.accounts = arrayList2;
                beneficiaryEntity.instrumentPreferences = instrumentPreferences2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(this));
            hashMap.put("Content-Type", "application/json");
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(new JSONObject(new f().a((Object) beneficiaryEntity)));
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.si.d.a.a((Context) this, (Map<String, String>) hashMap, jSONArray.toString(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            if (com.paytm.network.b.b.a(this)) {
                a(this, getString(R.string.pb_please_wait));
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
        } else if (i2 == 105) {
            this.f18803b = (HashMap) obj;
            e();
        }
    }

    private void e() {
        Intent intent = new Intent(this, RecurringPaymentSetInfoActivity.class);
        intent.putExtra(Item.CTA_URL_TYPE_MAP, this.f18803b);
        intent.putExtra("acc_no", getIntent().getStringExtra("acc_no"));
        startActivity(intent);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRAddBeneficiary) {
            ah_();
            CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
            if (cJRAddBeneficiary.getData() != null && !TextUtils.isEmpty(cJRAddBeneficiary.getData().getBeneficiaryId())) {
                this.f18803b.put("benifId", cJRAddBeneficiary.getData().getBeneficiaryId());
                e();
                finish();
            } else if (cJRAddBeneficiary.getError() == null || TextUtils.isEmpty(cJRAddBeneficiary.getError().getErrorMsg())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
            } else {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), cJRAddBeneficiary.getError().getErrorMsg());
            }
        }
    }
}
