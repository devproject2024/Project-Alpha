package net.one97.paytm.recharge.presentation.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.c.a.a;
import net.one97.paytm.recharge.widgets.c.d;

public class AJRAutomaticPaymentFAQs extends PaytmActivity {
    public void attachBaseContext(Context context) {
        a aVar = a.f60256a;
        super.attachBaseContext(a.a(context));
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_automatic_payment_faqs);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        d dVar = d.f64967a;
        d.a(getClass().getSimpleName() + " Activity Created");
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        setTitle(R.string.pa_faq_title);
        return super.onPrepareOptionsMenu(menu);
    }
}
