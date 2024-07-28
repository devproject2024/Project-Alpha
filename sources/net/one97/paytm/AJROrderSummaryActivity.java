package net.one97.paytm;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.finance.JarvisFinanceHelper;
import net.one97.paytm.recharge.ordersummary.h.c;

public class AJROrderSummaryActivity extends AJROrderSummaryActivityBase {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(CJROrderSummary cJROrderSummary, String str, String str2, String str3) {
        if (d()) {
            JarvisFinanceHelper.getInstance().getFinanceAccessProviderListener().sendGoldEvent(getApplicationContext(), cJROrderSummary, str, str2, str3);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            c.a aVar = c.f64331a;
            if (c.a.a((Activity) this, (CJROrderSummary) iJRPaytmDataModel)) {
                finish();
                if (Build.VERSION.SDK_INT >= 21) {
                    overridePendingTransition(0, 17432577);
                    return;
                }
                return;
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.e();
        }
        super.onApiSuccess(iJRPaytmDataModel);
    }
}
