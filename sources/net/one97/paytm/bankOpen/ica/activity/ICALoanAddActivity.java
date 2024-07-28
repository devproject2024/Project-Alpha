package net.one97.paytm.bankOpen.ica.activity;

import android.os.Bundle;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.b.g;

public final class ICALoanAddActivity extends PBBaseActivity implements d {
    public final void onFragmentAction(int i2, Object obj) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_ca_acc_open_activity);
        g gVar = new g();
        Bundle bundle2 = new Bundle();
        if (getIntent().hasExtra("loan")) {
            bundle2.putSerializable("loan", getIntent().getSerializableExtra("loan"));
            bundle2.putInt("loan_position", getIntent().getIntExtra("loan_position", -1));
        }
        gVar.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.container, gVar).c();
    }
}
