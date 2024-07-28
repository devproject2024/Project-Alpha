package net.one97.paytm.paymentsBank.activity;

import android.os.Bundle;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.a;

public class ReceiveMoneyActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private IsaDetailsModel f17413b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_receive_money);
        setTitle(getString(R.string.receive_money));
        ag_();
        if (getIntent() != null) {
            this.f17413b = (IsaDetailsModel) getIntent().getSerializableExtra("ISA_DETAILS");
        }
        a aVar = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("ISA_DETAILS", this.f17413b);
        bundle2.putBoolean("SHOW_MOTIF", false);
        aVar.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.activity_receive_money_lyt_card, aVar, (String) null).b();
    }
}
