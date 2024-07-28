package net.one97.paytm.paymentsBank.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public class SavingsAccountInfoActivity extends PBBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_savings_account_info);
        setTitle(getString(R.string.paytm_payments_bank));
        ag_();
        o.a().callWalletInfoLoginActivity(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (i2 == 301 && b.r((Context) this)) {
            Intent intent2 = new Intent(this, SavingsAccountActivity.class);
            intent2.setFlags(67108864);
            startActivity(intent2);
            finish();
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
