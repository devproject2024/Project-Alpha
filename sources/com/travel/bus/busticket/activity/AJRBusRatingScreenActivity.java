package com.travel.bus.busticket.activity;

import android.os.Bundle;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class AJRBusRatingScreenActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().hasExtra("star_count") ? getIntent().getIntExtra("star_count", 0) : 0;
        String str = "";
        String stringExtra = getIntent().hasExtra("secretKey") ? getIntent().getStringExtra("secretKey") : str;
        String stringExtra2 = getIntent().hasExtra("orderID") ? getIntent().getStringExtra("orderID") : str;
        String stringExtra3 = getIntent().hasExtra("channel") ? getIntent().getStringExtra("channel") : str;
        if (getIntent().hasExtra("operator_name")) {
            str = getIntent().getStringExtra("operator_name");
        }
        boolean booleanExtra = getIntent().hasExtra("bus-from-rnr-home") ? getIntent().getBooleanExtra("bus-from-rnr-home", false) : false;
        a a2 = a.a();
        a2.setCancelable(false);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("star_count", intExtra);
        bundle2.putString("secretKey", stringExtra);
        bundle2.putString("orderID", stringExtra2);
        bundle2.putString("channel", stringExtra3);
        bundle2.putString("operator_name", str);
        bundle2.putBoolean("bus-from-rnr-home", booleanExtra);
        if (getIntent().hasExtra("extra_home_data")) {
            bundle2.putSerializable("extra_home_data", (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data"));
        }
        a2.setArguments(bundle2);
        a2.show(getSupportFragmentManager(), "ratingScreenBottomSheet");
    }
}
