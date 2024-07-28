package net.one97.paytm.acceptPayment.activities;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.PaymentsConfig;
import com.paytm.network.listener.b;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.a.c;
import net.one97.paytm.acceptPayment.storefront.b;
import net.one97.paytm.common.widgets.a;

public class AcceptPaymentMerchantSettings extends BaseActivity implements View.OnClickListener, b, b.a {

    /* renamed from: a  reason: collision with root package name */
    private c f52023a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f52023a = (c) f.a(this, R.layout.accept_payment_merchant_settings);
        this.f52023a.f51971a.setTag(0);
        this.f52023a.f51971a.setOnClickListener(this);
        a(true);
        Bundle bundle2 = new Bundle();
        net.one97.paytm.acceptPayment.b.b.a();
        bundle2.putString("url", net.one97.paytm.acceptPayment.b.b.a("ap_sf_merchant_setting"));
        bundle2.putString(Item.KEY_GA_CATEGORY, "SettingsPage");
        int i2 = R.id.sf_banners;
        Class<net.one97.paytm.acceptPayment.storefront.b> cls = net.one97.paytm.acceptPayment.storefront.b.class;
        Fragment c2 = getSupportFragmentManager().c(cls.getCanonicalName());
        if (c2 != null) {
            getSupportFragmentManager().a().a(c2).c();
        }
        try {
            Fragment newInstance = cls.newInstance();
            newInstance.setArguments(bundle2);
            getSupportFragmentManager().a().a(i2, newInstance, newInstance.getClass().getCanonicalName()).c();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        PaymentsConfig.getInstance().getEventPublisher();
    }

    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        if (((Integer) view.getTag()).intValue() == 0) {
            onBackPressed();
        }
    }

    public final void a() {
        a(false);
    }

    private void a(boolean z) {
        if (z) {
            this.f52023a.f51973c.setVisibility(0);
            a.a(this.f52023a.f51972b);
            return;
        }
        a.b(this.f52023a.f51972b);
        this.f52023a.f51973c.setVisibility(8);
    }
}
