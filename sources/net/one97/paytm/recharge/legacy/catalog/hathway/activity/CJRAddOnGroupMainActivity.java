package net.one97.paytm.recharge.legacy.catalog.hathway.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRService;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.hathway.a.d;

@Deprecated
public class CJRAddOnGroupMainActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    CJRService f62969a;

    /* renamed from: b  reason: collision with root package name */
    private String f62970b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f62971c;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(CJRRechargeUtilities.INSTANCE.getRestringValue(context));
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.main_fragment);
        setSupportActionBar((Toolbar) findViewById(R.id.my_awesome_toolbar));
        getSupportActionBar().b(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("key_plain_expiry_list")) {
                this.f62969a = (CJRService) extras.getSerializable("key_plain_expiry_list");
            }
            if (extras.containsKey("key_pack_name")) {
                this.f62970b = extras.getString("key_pack_name");
            }
            if (extras.containsKey("list_position")) {
                this.f62971c = extras.getInt("list_position");
            }
            d dVar = new d(this, getSupportFragmentManager(), this.f62969a);
            ((ImageView) findViewById(R.id.imgArrowId)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRAddOnGroupMainActivity.this.finish();
                }
            });
            ((TextView) findViewById(R.id.tv_service_type)).setText(this.f62969a.getConnectiontype() + "\nVC No. " + this.f62969a.getVCNo());
            ((TextView) findViewById(R.id.tv_tootlbar_done)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("list_position", CJRAddOnGroupMainActivity.this.f62971c);
                    intent.putExtra("key_plain_expiry_list", CJRAddOnGroupMainActivity.this.f62969a);
                    CJRAddOnGroupMainActivity.this.setResult(-1, intent);
                    CJRAddOnGroupMainActivity.this.finish();
                }
            });
            viewPager.setAdapter(dVar);
            ((TabLayout) findViewById(R.id.sliding_tabs)).setupWithViewPager(viewPager);
            if (this.f62970b.equalsIgnoreCase(getString(R.string.view_add_on))) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(1);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
