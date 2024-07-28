package net.one97.paytm.paymentsBank.activity;

import android.content.Intent;

public final class PBH5LoginActivity extends PBEnteringFlowPasscodeActivity {
    public final void onBackPressed() {
        Intent intent = getIntent();
        getIntent().putExtra("loginStatus", false);
        setResult(-1, intent);
        finish();
    }
}
