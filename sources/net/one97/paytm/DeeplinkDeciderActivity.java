package net.one97.paytm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.a;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.utils.bf;

public class DeeplinkDeciderActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_deeplink_decider);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        boolean z = false;
        if (intent.getBooleanExtra("is_beneficiary_Deeplink", false)) {
            if (a.p(this) && j.b((Context) this) == 1 && !TextUtils.isEmpty(j.c(this))) {
                z = true;
            }
            if (z) {
                bf.a((Activity) this);
            } else {
                startActivity(new Intent(this, UpgradeKycActivity.class));
            }
            finish();
            return;
        }
        finish();
    }
}
