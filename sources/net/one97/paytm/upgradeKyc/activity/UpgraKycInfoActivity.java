package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.paytm.utility.b;
import net.one97.paytm.upgradeKyc.R;

public class UpgraKycInfoActivity extends UpgradeKycBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(R.string.vip_customer));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (i2 == 301 && b.r((Context) this)) {
            startActivity(new Intent(this, UpgradeKycActivity.class));
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

    public final int a() {
        return R.layout.activity_upgrade_kyc_info;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }
}
