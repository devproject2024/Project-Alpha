package net.one97.paytm.wallet.newdesign.acceptmoney;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import net.one97.paytm.CJRActionBarBaseActivity;
import net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity;
import net.one97.paytm.auth.b.a;
import net.one97.paytm.j.c;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;

public class InfoActivity extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f70463a;

    /* renamed from: b  reason: collision with root package name */
    private String f70464b;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.w_activity_paysend_info);
        this.f70463a = getIntent().getBundleExtra("resultant activity_bundle");
        this.f70464b = getIntent().getStringExtra("resultant_activity");
        if (!TextUtils.isEmpty(this.f70464b) && this.f70464b.equalsIgnoreCase("upi")) {
            setTitle(getString(R.string.upi));
        } else if (TextUtils.isEmpty(this.f70464b) || !this.f70464b.equalsIgnoreCase(DeepLinkConstant.WS_ORDERS)) {
            setTitle(getString(R.string.accept_payment));
        } else {
            setTitle(getString(R.string.event_my_orders));
        }
        o();
        p();
        a.a(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (i2 == 301 && com.paytm.utility.a.p(this)) {
            if (!TextUtils.isEmpty(this.f70464b) && this.f70464b.equalsIgnoreCase("upi")) {
                if (ag.a(getApplicationContext()).b("is_upi_user", false, true)) {
                    UpiLandingPageActivity.a((Context) this);
                } else if (UpiUtils.isInActiveProfileExist(this)) {
                    startActivity(UpiUtils.getUpiLandingPageActivityIntent(this));
                } else {
                    Intent intent2 = getIntent();
                    intent2.setClass(this, UpiSelectBankActivity.class);
                    startActivity(intent2);
                }
                finish();
            } else if (TextUtils.isEmpty(this.f70464b) || !this.f70464b.equalsIgnoreCase(DeepLinkConstant.WS_ORDERS)) {
                Intent intent3 = new Intent(this, AcceptPaymentInitActivity.class);
                if (!(getIntent() == null || getIntent().getExtras() == null)) {
                    String stringExtra = getIntent().getStringExtra("openTab");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        intent3.putExtra("openTab", stringExtra);
                    }
                }
                Bundle bundle = this.f70463a;
                if (bundle != null) {
                    intent3.putExtra("extra_home_data", bundle);
                }
                intent3.setFlags(67108864);
                startActivity(intent3);
                finish();
            } else {
                c.a();
                net.one97.paytm.payments.d.a.a((Activity) this, c.ar());
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
