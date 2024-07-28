package net.one97.paytm.passbook.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.paytm.utility.b;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.landing.activity.PassbookLandingActivity;

public class PassbookInfoActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_w_activity_passbook_info);
        if (b.r((Context) this)) {
            a();
        } else {
            d.b().a((Activity) this);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (i2 == 301 && b.r((Context) this)) {
            a();
        }
    }

    private void a() {
        startActivity(new Intent(this, PassbookLandingActivity.class));
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
