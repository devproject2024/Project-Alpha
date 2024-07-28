package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.b.a;

public class QuickPayDeeplinkActivity extends QuickPaymentActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public StandingInstructionList f59962a;

    /* renamed from: c  reason: collision with root package name */
    private String f59963c;

    public void onCreate(Bundle bundle) {
        CJRHomePageItem cJRHomePageItem;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_quick_pay_deeplink);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("id")) {
                this.f59963c = intent.getStringExtra("id");
            }
            if (intent.hasExtra("extra_home_data") && (cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data")) != null) {
                this.f59963c = cJRHomePageItem.getSsId();
            }
        }
        if (!TextUtils.isEmpty(this.f59963c)) {
            this.f59962a = a.a((Context) this, this.f59963c);
            if (this.f59962a != null) {
                b();
            } else {
                String a2 = d.b().a("getQuickPaymentsUrl");
                if (!TextUtils.isEmpty(a2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Authorization", d.a().b((Context) this));
                    com.paytm.network.a a3 = d.a(this, a2 + "&siId=" + this.f59963c, new b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            Payload payload;
                            if (!(iJRPaytmDataModel == null || (payload = ((QuickListResponse) iJRPaytmDataModel).getPayload()) == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0)) {
                                StandingInstructionList unused = QuickPayDeeplinkActivity.this.f59962a = payload.getStandingInstructionList().get(0);
                                if (QuickPayDeeplinkActivity.this.f59962a != null) {
                                    QuickPayDeeplinkActivity.this.b();
                                    QuickPayDeeplinkActivity quickPayDeeplinkActivity = QuickPayDeeplinkActivity.this;
                                    a.a((Context) quickPayDeeplinkActivity, quickPayDeeplinkActivity.f59962a);
                                }
                            }
                            QuickPayDeeplinkActivity.this.finish();
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            QuickPayDeeplinkActivity.this.finish();
                        }
                    }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
                    if (com.paytm.utility.a.m(this)) {
                        a3.a();
                        return;
                    } else {
                        finish();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void b() {
        SupportingData supportingData = this.f59962a.getSupportingData();
        String amount = this.f59962a.getAmount();
        String reminderDisplayName = this.f59962a.getReminderDisplayName();
        if (supportingData != null) {
            String beneficiaryAccountNumber = supportingData.getBeneficiaryAccountNumber();
            String beneficiaryUpiAddress = supportingData.getBeneficiaryUpiAddress();
            if (!TextUtils.isEmpty(beneficiaryAccountNumber)) {
                String a2 = a(true, beneficiaryAccountNumber, supportingData.getBeneficiaryName(), supportingData.getBeneficiaryIfscCode(), supportingData.getBeneficiaryBankName(), amount);
                if (!TextUtils.isEmpty(a2)) {
                    d.b().a((Context) this, a2);
                }
            } else if (!TextUtils.isEmpty(beneficiaryUpiAddress)) {
                String a3 = a(false, beneficiaryUpiAddress, supportingData.getBeneficiaryName(), (String) null, (String) null, amount);
                if (!TextUtils.isEmpty(a3)) {
                    d.b().a((Context) this, a3);
                }
            } else {
                String beneficiaryMobileNumber = supportingData.getBeneficiaryMobileNumber();
                Intent intent = new Intent();
                intent.putExtra("PHONE_NUMBER", beneficiaryMobileNumber);
                intent.putExtra("NAME", reminderDisplayName);
                if (!TextUtils.isEmpty(amount)) {
                    intent.putExtra("AMOUNT", amount);
                }
                d.a().a(intent, (Activity) this);
            }
        }
    }
}
