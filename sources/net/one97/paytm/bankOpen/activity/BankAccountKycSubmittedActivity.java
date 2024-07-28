package net.one97.paytm.bankOpen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.KycSavedUserData;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class BankAccountKycSubmittedActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f16337b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f16338c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f16339d;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        getSupportActionBar().f();
        setContentView(R.layout.activity_bank_account_submitted);
        g.a();
        String a2 = d.a("mwGetAppointmentV2Url");
        if (!URLUtil.isValidUrl(a2)) {
            b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
        } else {
            String e2 = b.e((Context) this, a2);
            if (net.one97.paytm.bankCommon.h.b.B(this)) {
                str = e2 + "&isUpiCreated=true";
            } else {
                str = e2 + "&isUpiCreated=false";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", a.q(this));
            hashMap.put("Content-Type", "application/json");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(str + "&userInterest=true&leadSource=" + "App_SA", (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new KycSavedUserData(), (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, a.C0715a.GET, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            if (b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                getApplicationContext();
                new c();
                c.a(bVar);
            } else {
                ah_();
                d();
            }
        }
        net.one97.paytm.bankCommon.mapping.c.a("/bank/saving-account/nonkyc-confirmation", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) this);
        this.f16338c = (LinearLayout) findViewById(R.id.activity_bank_acc_submitted_doc_lyt);
        this.f16337b = (RoboTextView) findViewById(R.id.activity_bank_acc_submitted_doc);
        this.f16339d = (RoboTextView) findViewById(R.id.activity_bank_acc_submitted_text);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("user_id", b.n((Context) this));
        net.one97.paytm.bankCommon.mapping.c.a("bank_savings_account_non_kyc_request_submitted_account", (Map<String, Object>) hashMap3, (Context) this);
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountKycSubmittedActivity.this.b(view);
            }
        });
        findViewById(R.id.activity_bank_account_submitted_btn_nearby).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountKycSubmittedActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        net.one97.paytm.bankCommon.mapping.c.a(this, "bank_saving_account", "visit_nearby_centre_button_clicked", "", "", "/bank/saving-account/nonkyc-confirmation", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        if (f.b().getNearByMainActivityClass() != null) {
            startActivity(new Intent(this, f.b().getNearByMainActivityClass()));
            finish();
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel instanceof KycSavedUserData) {
            ah_();
            KycSavedUserData kycSavedUserData = (KycSavedUserData) iJRPaytmDataModel;
            if (kycSavedUserData.getStatusCode().intValue() == 200 && kycSavedUserData != null && kycSavedUserData.getKYCDetail() != null && kycSavedUserData.getKYCDetail().size() > 0) {
                String poINumber = kycSavedUserData.getKYCDetail().get(0).getPoINumber();
                String pOIType = kycSavedUserData.getKYCDetail().get(0).getPOIType();
                if (!TextUtils.isEmpty(poINumber) && !TextUtils.isEmpty(pOIType)) {
                    this.f16338c.setVisibility(0);
                    RoboTextView roboTextView = this.f16337b;
                    roboTextView.setText(pOIType + " (" + poINumber + ")");
                    this.f16339d.setText(R.string.bank_request_kyc_representative);
                }
            }
        }
    }
}
