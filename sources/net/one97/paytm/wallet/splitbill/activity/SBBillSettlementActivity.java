package net.one97.paytm.wallet.splitbill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.e;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupInfoBaseResponse;

public class SBBillSettlementActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private TabLayout f71965a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f71966b;

    /* renamed from: c  reason: collision with root package name */
    private e f71967c;

    /* renamed from: d  reason: collision with root package name */
    private SBGroupInfoBaseResponse f71968d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_bill_settlement_activity);
        if (getIntent() != null && getIntent().hasExtra("sb_response_get_group_info")) {
            this.f71968d = (SBGroupInfoBaseResponse) getIntent().getSerializableExtra("sb_response_get_group_info");
        }
        this.f71965a = (TabLayout) findViewById(R.id.tl_card_tabs);
        this.f71966b = (ViewPager) findViewById(R.id.vp_card);
        this.f71967c = new e(this, getSupportFragmentManager(), this.f71968d);
        this.f71966b.setAdapter(this.f71967c);
        this.f71965a.setupWithViewPager(this.f71966b);
        ((ImageView) findViewById(R.id.split_back_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBBillSettlementActivity.this.finish();
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }
}
