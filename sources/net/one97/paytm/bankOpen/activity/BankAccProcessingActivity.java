package net.one97.paytm.bankOpen.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.a.a;

public class BankAccProcessingActivity extends PBBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_acc_processing);
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = a.a((Context) this, "ISA", (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            getApplicationContext();
            new c();
            c.a(a2);
        } else {
            a(a2);
        }
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccProcessingActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CustProductStatus) {
            CustProductStatus custProductStatus = (CustProductStatus) iJRPaytmDataModel;
            if (TextUtils.isEmpty(custProductStatus.getProduct()) || !custProductStatus.getProduct().equalsIgnoreCase("ISA")) {
                ah_();
                if (!TextUtils.isEmpty(custProductStatus.getErrorMessage())) {
                    b.b((Context) this, getString(R.string.error), custProductStatus.getErrorMessage());
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(custProductStatus.getPasscode())) {
                if (custProductStatus.getPasscode().equalsIgnoreCase("Y")) {
                    net.one97.paytm.bankCommon.h.b.a((Context) this, true);
                } else {
                    net.one97.paytm.bankCommon.h.b.a((Context) this, false);
                }
            }
            if (!TextUtils.isEmpty(custProductStatus.getKYC())) {
                net.one97.paytm.bankCommon.h.b.b((Context) this, custProductStatus.getKYC());
            }
            if (!TextUtils.isEmpty(custProductStatus.getNominee())) {
                net.one97.paytm.bankCommon.h.b.d((Context) this, custProductStatus.getNominee());
            }
            if (!TextUtils.isEmpty(custProductStatus.getAadhaarRec())) {
                net.one97.paytm.bankCommon.h.b.e((Context) this, custProductStatus.getAadhaarRec());
            }
            if (!TextUtils.isEmpty(custProductStatus.getPanRec())) {
                net.one97.paytm.bankCommon.h.b.f(this, custProductStatus.getPanRec());
            }
            if (!TextUtils.isEmpty(custProductStatus.getForm60Rec())) {
                net.one97.paytm.bankCommon.h.b.g(this, custProductStatus.getForm60Rec());
            }
            ah_();
            findViewById(R.id.activity_bank_acc_processing_lyt).setVisibility(0);
            q a2 = getSupportFragmentManager().a();
            a2.a(R.id.fragment_container, (Fragment) new net.one97.paytm.bankOpen.b.a());
            a2.c();
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
    }
}
