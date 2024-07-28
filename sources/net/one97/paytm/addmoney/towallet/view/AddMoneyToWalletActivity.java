package net.one97.paytm.addmoney.towallet.view;

import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.AddMoneyBaseToolbarActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.towallet.a.a;

public class AddMoneyToWalletActivity extends AddMoneyBaseToolbarActivity implements a {

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.addmoney.common.view.a f48855c;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final void a(boolean z) {
    }

    public final int a() {
        return R.layout.uam_activity_add_to_ppb;
    }

    public final int b() {
        return f48004a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f48855c = net.one97.paytm.addmoney.common.view.a.c(PaymentDestinationType.TO_WALLET.getNumVal());
        Bundle arguments = this.f48855c.getArguments();
        arguments.putBoolean("destroy_self", getIntent().getBooleanExtra("destroy_self", false));
        double doubleExtra = getIntent().getDoubleExtra("Amount", 0.0d);
        if (doubleExtra > 0.0d) {
            arguments.putString("Amount", String.valueOf(doubleExtra));
        }
        this.f48855c.setArguments(arguments);
        getSupportFragmentManager().a().b(R.id.containerLayout, this.f48855c, (String) null).c();
    }

    public void onBackPressed() {
        net.one97.paytm.addmoney.common.view.a aVar = this.f48855c;
        if (aVar == null || !aVar.isResumed()) {
            super.onBackPressed();
        } else {
            this.f48855c.r();
        }
    }
}
