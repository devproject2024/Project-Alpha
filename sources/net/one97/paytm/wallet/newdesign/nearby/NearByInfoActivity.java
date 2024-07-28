package net.one97.paytm.wallet.newdesign.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public class NearByInfoActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nb_w_activity_passbook_info);
        setTitle(getString(R.string.top_menu_nearby));
    }

    public void attachBaseContext(Context context) {
        d.a aVar = d.f71130b;
        super.attachBaseContext(d.a.a().f71132a.a(context));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if (i2 == 301 && b.r((Context) this)) {
            startActivity(new Intent(this, NearByMainActivity.class));
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
