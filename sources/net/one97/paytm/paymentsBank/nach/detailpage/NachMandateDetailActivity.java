package net.one97.paytm.paymentsBank.nach.detailpage;

import android.os.Bundle;
import androidx.fragment.app.q;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.nach.Payload;
import net.one97.paytm.paymentsBank.nach.detailpage.b.a;

public class NachMandateDetailActivity extends PBBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_nach_detail);
        Payload payload = (Payload) getIntent().getSerializableExtra("key_payload");
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.fragment_container;
        a.C0319a aVar = a.f18561a;
        k.c(payload, "payload");
        a aVar2 = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("key_payload", payload);
        aVar2.setArguments(bundle2);
        a2.b(i2, aVar2, (String) null).c();
    }
}
