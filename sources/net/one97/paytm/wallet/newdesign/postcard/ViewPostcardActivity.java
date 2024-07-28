package net.one97.paytm.wallet.newdesign.postcard;

import android.os.Bundle;
import androidx.fragment.app.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.e;

public class ViewPostcardActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        setContentView(R.layout.activity_view_postcard);
        getSupportActionBar().f();
        q a2 = getSupportFragmentManager().a();
        e eVar = new e();
        Bundle bundle2 = new Bundle();
        if (getIntent() != null) {
            if (getIntent().hasExtra("data")) {
                bundle2.putSerializable("data", (IJRDataModel) getIntent().getSerializableExtra("data"));
                eVar.setArguments(bundle2);
            } else if (getIntent().hasExtra("event_id")) {
                bundle2.putString("event_id", getIntent().getStringExtra("event_id"));
                eVar.setArguments(bundle2);
            }
        }
        a2.a(R.id.postcard_fragment_container, eVar, eVar.getClass().getSimpleName());
        a2.b();
    }
}
