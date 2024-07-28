package net.one97.paytm.wallet.splitbill.activity;

import android.os.Bundle;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.c.j;

public class SBNewBillActivity extends AppCompatLockActivity {
    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("SplitBill");
        setContentView(R.layout.sb_landing_page_activity);
        j jVar = (j) getSupportFragmentManager().c(j.class.getSimpleName());
        if (jVar == null) {
            jVar = new j();
        }
        getSupportFragmentManager().a().b(R.id.activity_sb_landing_frame, jVar, j.class.getSimpleName()).b();
    }
}
