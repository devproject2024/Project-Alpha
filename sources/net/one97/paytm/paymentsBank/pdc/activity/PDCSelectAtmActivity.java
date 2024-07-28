package net.one97.paytm.paymentsBank.pdc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.pdc.a.i;
import net.one97.paytm.paymentsBank.pdc.a.j;

public class PDCSelectAtmActivity extends PBBaseToolbarActivity implements View.OnClickListener, d {
    public final int e() {
        return 0;
    }

    public final int f() {
        return -1;
    }

    public void onClick(View view) {
    }

    public void onFragmentAction(int i2, Object obj) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("pdc_product_id");
        String stringExtra2 = getIntent().getStringExtra("pdc_price");
        String stringExtra3 = getIntent().getStringExtra("pdc_title");
        CustProductList custProductList = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
        if (TextUtils.isEmpty(stringExtra)) {
            j a2 = j.a();
            a2.setArguments(getIntent().getExtras());
            getSupportFragmentManager().a().b(R.id.container_framelayout, a2, "PDCSelectAtmFragment").c();
            this.f17395e.setVisibility(0);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("pdc_product_id", stringExtra);
        bundle2.putString("pdc_title", stringExtra3);
        bundle2.putString("pdc_price", stringExtra2);
        bundle2.putSerializable("CUST_PRODUCT", custProductList);
        a(bundle2, false);
    }

    public final void a(Bundle bundle, boolean z) {
        i a2 = i.a();
        bundle.putAll(bundle);
        a2.setArguments(bundle);
        if (z) {
            getSupportFragmentManager().a().b(R.id.container_framelayout, a2, "PDCSelectAddressFragment").a("PDCSelectAtmFragment").c();
        } else {
            getSupportFragmentManager().a().b(R.id.container_framelayout, a2, "PDCSelectAddressFragment").c();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101 && intent.hasExtra("IMAGE_URL")) {
            intent.getStringExtra("IMAGE_URL");
        }
    }
}
