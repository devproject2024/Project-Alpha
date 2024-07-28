package net.one97.paytm.paymentsBank.slfd.interestprojection;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.utils.o;

public class FixedDepositOfferingActivity extends PaytmActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_fixed_deposit_offering);
        findViewById(R.id.tv_know_more).setOnClickListener(this);
        findViewById(R.id.rl_interest_table_wrapper).setOnClickListener(this);
        findViewById(R.id.iv_back_arrow).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_earn_higher)).setText(getString(R.string.pb_earn_higher, new Object[]{a()}));
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(f.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_know_more) {
            net.one97.paytm.paymentsBank.h.a a2 = o.a();
            d.b();
            a2.openWebViewActivity(this, d.a("know_more_fd_url"), getString(R.string.paytm_payments_bank));
        } else if (view.getId() == R.id.rl_interest_table_wrapper) {
            new net.one97.paytm.paymentsBank.slfd.common.view.d().show(getSupportFragmentManager(), "itTableBottomSheet");
        } else if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        }
    }

    private String a() {
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = (SlfdMetaApiResponseModel) new com.google.gsonhtcfix.f().a(b.D(this), SlfdMetaApiResponseModel.class);
        if (slfdMetaApiResponseModel != null) {
            return slfdMetaApiResponseModel.getPeakInterestRatePerAnnum() + "%";
        }
        try {
            g.a();
            if (TextUtils.isEmpty(d.a("saving_acc_interest"))) {
                return "8%";
            }
            g.a();
            String[] split = d.a("saving_acc_interest").split("##");
            return split.length > 1 ? split[1] : "8%";
        } catch (Exception unused) {
            return "8%";
        }
    }
}
