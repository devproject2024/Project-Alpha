package net.one97.paytm.wallet.splitbill.activity;

import android.os.Bundle;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.c.f;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class SBCreateGroupActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71970a = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_activity_create_group);
        getWindow().setSoftInputMode(20);
        if (getIntent() != null && getIntent().hasExtra("list")) {
            this.f71970a = (ArrayList) getIntent().getSerializableExtra("list");
        }
        f fVar = (f) getSupportFragmentManager().c(f.class.getSimpleName());
        if (fVar == null) {
            fVar = new f();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("list", this.f71970a);
        fVar.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.activity_sb_create_group_frame, fVar, f.class.getSimpleName()).b();
    }
}
