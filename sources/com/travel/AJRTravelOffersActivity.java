package com.travel;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class AJRTravelOffersActivity extends CJRActionBarBaseActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate(Bundle bundle) {
        CJRCatalogItem cJRCatalogItem;
        super.onCreate(bundle);
        setContentView(R.layout.pre_td_activity_ajrtravel_offers);
        setTitle(getString(R.string.travel_offers_heading));
        e();
        c();
        d();
        if (getIntent() != null) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("bundle_extra_category_item");
            CJRItem cJRItem = (CJRItem) getIntent().getSerializableExtra("extra_home_data");
            Bundle bundle2 = new Bundle();
            d.a();
            Fragment b2 = d.b().b();
            if (cJRHomePageItem != null) {
                cJRCatalogItem = new CJRCatalogItem();
                cJRCatalogItem.setName(cJRHomePageItem.getName());
                cJRCatalogItem.setListId(cJRHomePageItem.getListId());
                cJRCatalogItem.setURLType(cJRHomePageItem.getURLType());
                cJRCatalogItem.setUrl(cJRHomePageItem.getURL());
            } else {
                cJRCatalogItem = null;
            }
            bundle2.putSerializable("bundle_extra_category_item", cJRCatalogItem);
            bundle2.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle2.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle2.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle2.putSerializable("extra_home_data", cJRItem);
            bundle2.putBoolean("disable-pagination", true);
            bundle2.putBoolean("is-offer", true);
            b2.setArguments(bundle2);
            q a2 = getSupportFragmentManager().a();
            a2.b(R.id.framelayout, b2, (String) null);
            a2.b();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        d();
        c();
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
